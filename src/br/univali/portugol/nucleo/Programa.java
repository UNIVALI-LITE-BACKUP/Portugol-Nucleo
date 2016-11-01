package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.execucao.es.Entrada;
import br.univali.portugol.nucleo.execucao.es.EntradaSaidaPadrao;
import br.univali.portugol.nucleo.execucao.ModoEncerramento;
import br.univali.portugol.nucleo.execucao.ObservadorExecucao;
import br.univali.portugol.nucleo.execucao.ResultadoExecucao;
import br.univali.portugol.nucleo.execucao.TradutorErrosExecucao;
import br.univali.portugol.nucleo.execucao.erros.ErroExecucaoNaoTratado;
import br.univali.portugol.nucleo.execucao.erros.ErroValorEntradaInvalido;
import br.univali.portugol.nucleo.execucao.es.Armazenador;
import br.univali.portugol.nucleo.execucao.es.InputMediator;
import br.univali.portugol.nucleo.execucao.es.Saida;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.Variavel;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe provê uma fachada (Facade) para abstrair os detalhes da execução
 * dos programas que não interessam aos utilizadores do Portugol.
 * <p>
 * Ela se encarrega de instanciar um interpretador para o código fonte e de
 * gerenciar o ciclo de vida (inicio, fim, interrupção) da Thread na qual o
 * interpretador irá executar.
 *
 *
 * @author Luiz Fernando Noschang
 * @author Fillipi Domingos Pelz
 *
 * @version 1.0
 * @see Interpretador
 * @see Thread
 */
public abstract class Programa
{
    /*
     * Optei por criar manualmente o pool de threads ao invés de usar um método da classe Executors.
     * 
     * O pool criado aqui é idêntico ao criado pelo método newCachedThreadPool(), exceto pela propriedade
     * keepAliveTime. Esta propriedade define quanto tempo a thread pode ficar inativa (sem ter uma tarefa submetida)
     * antes de ser desalocada da memória.
     *
     * Na implementação da classe Executors, o keepAliveTime padrão é de 60 segundos, um tempo consideravelmente pequeno.
     * Ao analisar a execução com o JVisualVM, foi possível perceber que com frequência, as threads que estavam aguardando
     * tarefas no pool eram desalocadas e novas threads tinham que ser criadas.
     *    
     * Nesta implementação, o tempo foi aumentado (exageradamente) para 2 horas.
     */
    private static final ExecutorService POOL_DE_THREADS = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 2L, TimeUnit.HOURS, new SynchronousQueue<Runnable>(), new NamedThreadFactory("Portugol Núcleo (Thread de programa #%d", Thread.MAX_PRIORITY));

    private Saida saida;
    private Entrada entrada;
    private String funcaoInicial;
    private File diretorioTrabalho = new File(".");
    private File arquivoOrigem = null;

    private TarefaExecucao tarefaExecucao = null;
    private Future controleTarefaExecucao = null;

    private ASAPrograma arvoreSintaticaAbstrataPrograma;
    private List<String> funcoes;
    private ResultadoAnalise resultadoAnalise;

    private final ArrayList<ObservadorExecucao> observadores;

    private Set<Integer> linhasComPontoDeParada = new HashSet<>();

    private volatile boolean lendo = false;
    private volatile boolean leituraIgnorada = false;

    private final Object LOCK = new Object();
    
    private int ultimaLinha = 0;
    private int ultimaColuna = 0;

    public static enum Estado
    {
        BREAK_POINT, //usuário clicou no botão que executa o programa até atingir um ponto de parada, caso exista algum
        STEP_INTO, //não utilizado no momento
        STEP_OVER, //executa passo a passo, para em todos os nós que são paráveis (nem todos são)
        PARADO//esperando o usuário iniciar a execução
    }

    private Estado estado = Estado.PARADO;

    public Programa()
    {
        EntradaSaidaPadrao es = new EntradaSaidaPadrao();

        entrada = es;
        saida = es;
        funcoes = new ArrayList<>();
        observadores = new ArrayList<>();
    }

    /**
     * Permite adicionar um observador à execução do programa. Os observadores
     * serão notificados sobre o início e o término da execução, bem como erros
     * em tempo de execução que vierem a ocorrer.
     *
     * @param observador o observador de execução a ser registrado.
     * @since 1.0
     */
    public void adicionarObservadorExecucao(ObservadorExecucao observador)
    {
        if (!observadores.contains(observador))
        {
            observadores.add(observador);
        }
    }

    /**
     * Remove um observador de execução previamente registrado utilizando o
     * método 
     * {@link Programa#adicionarObservadorExecucao(br.univali.portugol.nucleo.execucao.ObservadorExecucao) }.
     * Uma vez removido, o observador não será mais notificado sobre o estado da
     * execução do programa nem dos erros em tempo de execução que vierem a
     * ocorrer.
     *
     * @param observador um observador de execução previamente registrado.
     * @since 1.0
     */
    public void removerObservadorExecucao(ObservadorExecucao observador)
    {
        observadores.remove(observador);
    }

    /**
     * Depura este programa com os parâmetros especificados. Se o programa já
     * estiver executando/depurando não faz nada.
     *
     * @param parametros lista de parâmetros que serão passados ao programa no
     * momento da execução.
     * @param estado
     *
     * @since 2.0
     */
    public void executar(String[] parametros, Programa.Estado estado)
    {
        if (!isExecutando())
        {
            this.estado = estado;
            tarefaExecucao = new TarefaExecucao(parametros);
            controleTarefaExecucao = POOL_DE_THREADS.submit(tarefaExecucao);
        }
    }

    public void continuar(Programa.Estado estado)
    {
        synchronized (LOCK)
        {
            if (isExecutando())
            {
                tarefaExecucao.continuar(estado);
                if (this.isLendo())
                {
                    setLeituraIgnorada(true);
                }
                this.estado = estado;
                LOCK.notifyAll();
            }
            else
            {
                throw new IllegalStateException("O programa não pode ser continuado pois não foi iniciado");
            }
        }
    }

    public void ativaPontosDeParada(Set<Integer> linhasComPontosDeParadaAtivados)
    {
        linhasComPontoDeParada.clear();
        linhasComPontoDeParada.addAll(linhasComPontosDeParadaAtivados);
    }

    protected abstract void executar(String[] parametros) throws ErroExecucao, InterruptedException;

    /**
     * Implementa uma tarefa para disparar a execução do programa com os
     * parâmetros e a estratégia selecionada. Futuramente podemos refatorar para
     * executar a partir de um pool de threads.
     */
    private final class TarefaExecucao implements Runnable
    {
        private final String[] parametros;
        private final ResultadoExecucao resultadoExecucao;
        //private final Programa.Estado estado;

        public TarefaExecucao(String[] parametros)
        {
            this.parametros = parametros;
            this.resultadoExecucao = new ResultadoExecucao();
            //this.estado = estado;
        }

        public ResultadoExecucao getResultadoExecucao()
        {
            return resultadoExecucao;
        }

        @Override
        public void run()
        {
            long horaInicialExecucao = System.currentTimeMillis();

            try
            {
                notificarInicioExecucao();
                inicializaBibliotecasIncluidas();
                executar(parametros);
            }
            catch (ErroExecucao erroExecucao)
            {
                erroExecucao.setLinha(ultimaLinha);
                erroExecucao.setColuna(ultimaColuna);
                
                resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                resultadoExecucao.setErro(erroExecucao);
            }
            catch (InterruptedException excecao)
            {
                resultadoExecucao.setModoEncerramento(ModoEncerramento.INTERRUPCAO);
            }
            catch (Exception excecao)
            {
                TradutorErrosExecucao tradutorErros = new TradutorErrosExecucao();

                if (excecao.getCause() instanceof InterruptedException)
                {
                    resultadoExecucao.setModoEncerramento(ModoEncerramento.INTERRUPCAO);
                }
                else
                {
                    resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                    resultadoExecucao.setErro(tradutorErros.traduzir(excecao));
                }
            }
            finally
            {
                try
                {
                    finalizaBibliotecasIncluidas();
                }
                catch (InterruptedException | ErroExecucaoBiblioteca ex)
                {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, "Não era pra acontecer", ex);
                }
            }

            resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);

            notificarEncerramentoExecucao(resultadoExecucao);
        }

        public void continuar(Programa.Estado estado)
        {
            synchronized (LOCK)
            {
                if (isLendo())
                {
                    setLeituraIgnorada(true);
                }

                Programa.this.estado = estado;
                LOCK.notifyAll();
            }
        }
    }

    /**
     * Interrompe a execução deste programa. Não tem nenhum efeito se o programa
     * não estiver executando.
     *
     * @since 1.0
     */
    public void interromper()
    {
        if (isExecutando())
        {
            controleTarefaExecucao.cancel(true);
            Variavel.limpaCache();
        }
    }
    
    private boolean podeParar(int linha)
    {
        // pode parar quando está no modo STEP_OVER ou quando está no modo BREAK_POINT e tem um ponto de parada ativo na linha em execução
        
        if (estado == Estado.STEP_OVER)
        {
            return true;
        }
        
        return estado == Estado.BREAK_POINT && linhasComPontoDeParada.contains(linha);
    }
    
    protected void realizarParada(int linha, int coluna) throws ErroExecucao, InterruptedException
    {
        ultimaLinha = linha;
        ultimaColuna = coluna;
        
        if (podeParar(linha))
        {
            disparaDestacar(linha);
            synchronized (LOCK)
            {
                LOCK.wait();
            }
//            else if ( this.estado == Estado.STEP_INTO)
//            {
//                disparaDestacar(trechoCodigoFonte);
//            }
//            else
//            {
//                disparaDestacar((trechoCodigoFonte != null) ? trechoCodigoFonte.getLinha() : -1);
//            }
        }
    }
    
    private  void disparaDestacar(int linha)
    {
        if (linha >= 0)
        {
            for (ObservadorExecucao observador : observadores)
            {
                observador.highlightLinha(linha);
            }
        }
    }
    
    /**
     * Obtém a lista de funções declaradas atualmente no programa
     *
     * @return a lista de funções
     */
    public List<String> getFuncoes()
    {
        return funcoes;
    }

    /**
     * Define a lista de funções declaradas atualmente no programa
     *
     * @param funcoes a lista de funções
     */
    public void setFuncoes(List<String> funcoes)
    {
        this.funcoes = funcoes;
    }

    public File getArquivoOrigem()
    {
        return arquivoOrigem;
    }

    public void setArquivoOrigem(File arquivoOrigem)
    {
        this.arquivoOrigem = arquivoOrigem;
    }

    /**
     * Obtém a ASA que representa este programa.
     *
     * @return a ASA que representa este programa
     * @since 1.0
     */
    public ASAPrograma getArvoreSintaticaAbstrata()
    {
        return arvoreSintaticaAbstrataPrograma;
    }

    /**
     * Define a ASA que representa este programa.
     *
     * @param arvoreSintaticaAbstrataPrograma a ASA que representa este
     * programa.
     * @since 1.0
     */
    public void setArvoreSintaticaAbstrata(ASAPrograma arvoreSintaticaAbstrataPrograma)
    {
        this.arvoreSintaticaAbstrataPrograma = arvoreSintaticaAbstrataPrograma;
    }

    /**
     * Define o nome da função que deverá ser chamada para dar início à execução
     * do programa. Caso não tenho sido declarada uma função com este nome no
     * código fonte, será gerado um erro em tempo de execução.
     *
     * @param funcaoInicial o nome da função que será o ponto de partida do
     * programa.
     * @since 1.0
     */
    public void setFuncaoInicial(String funcaoInicial)
    {
        this.funcaoInicial = funcaoInicial;
    }

    /**
     * Obtém o nome da função que está atualmente definida como ponto de partida
     * para este programa.
     *
     * @return o nome da função que está atualmente definida como ponto de
     * partida.
     * @since 1.0
     */
    public String getFuncaoInicial()
    {
        return funcaoInicial;
    }

    /**
     * Obtém a interface para entrada de dados que está atualmente registrada
     * para este programa.
     *
     * @return a interface para entrada de dados que está atualmente registrada.
     * @since 1.0
     */
    public Entrada getEntrada()
    {
        return entrada;
    }

    /**
     * Obtém a interface para saída de dados que está atualmente registrada para
     * este programa.
     *
     * @return a interface para saída de dados que está atualmente registrada.
     * @since 1.0
     */
    public Saida getSaida()
    {
        return saida;
    }

    /**
     * Define a interface para entrada de dados deste programa.
     *
     * @param entrada a interface para entrada de dados a ser registrada para
     * este programa.
     * @since 1.0
     */
    public void setEntrada(Entrada entrada)
    {
        this.entrada = entrada;
    }

    /**
     * Define a interface para saída de dados deste programa.
     *
     * @param saida a interface para saída de dados a ser registrada para este
     * programa.
     * @since 1.0
     */
    public void setSaida(Saida saida)
    {
        this.saida = saida;
    }

    public void setResultadoAnalise(ResultadoAnalise resultadoAnalise)
    {
        this.resultadoAnalise = resultadoAnalise;
    }

    public ResultadoAnalise getResultadoAnalise()
    {
        return resultadoAnalise;
    }

    /**
     * Verifica se este programa está em execução.
     *
     * @return     <code>true</code> se o programa estiver executando, caso
     * contrário retorna <code>false</code>.
     * @since 1.0
     */
    public boolean isExecutando()
    {
        return (tarefaExecucao != null && controleTarefaExecucao != null && !controleTarefaExecucao.isDone());
    }

    /**
     * Notifica todos os observadores registrados sobre o início da execução
     * deste programa.
     */
    private void notificarInicioExecucao()
    {
        for (ObservadorExecucao observador : observadores)
        {
            observador.execucaoIniciada(this);
        }
    }

    /**
     * Notifica todos os observadores registrados sobre o término da execução
     * deste programa.
     *
     * @param resultadoExecucao objeto contendo informações sobre o motivo do
     * encerramento do programa e eventos ocorridos durante a execução.
     * @since 1.0
     */
    private void notificarEncerramentoExecucao(ResultadoExecucao resultadoExecucao)
    {
        tarefaExecucao = null;
        controleTarefaExecucao = null;

        for (ObservadorExecucao observador : observadores)
        {
            observador.execucaoEncerrada(this, resultadoExecucao);
        }
    }

    public void setDiretorioTrabalho(File diretorioTrabalho)
    {
        if (diretorioTrabalho.isDirectory() && diretorioTrabalho.exists())
        {
            this.diretorioTrabalho = diretorioTrabalho;
        }
        else
        {
            throw new IllegalArgumentException(String.format("Diretório de trabalho inválido. O caminho '%s' não existe ou não representa um diretório", diretorioTrabalho.getAbsolutePath()));
        }
    }

    public File resolverCaminho(File caminho)
    {
        if (!caminho.isAbsolute())
        {
            return new File(diretorioTrabalho, caminho.getPath());
        }

        return caminho;
    }

    private String obterCaminhoCompleto(File arquivo)
    {
        try
        {
            return arquivo.getCanonicalPath();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arquivo.getAbsolutePath();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Programa)
        {
            return ((Programa) obj) == this;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return System.identityHashCode(this);
    }

    protected void limpa() throws ErroExecucao
    {
        try
        {
            saida.limpar();
        }
        catch (Exception e)
        {
            throw new ErroExecucao()
            {
                @Override
                protected String construirMensagem()
                {
                    return "Erro de execução limpando a saída!";
                }
            };
        }
    }

    protected void escreva(Object... listaParametrosPassados) throws ErroExecucao
    {
        if (saida == null)
        {
            throw new IllegalStateException("A saída do Programa está nula!");
        }

        for (Object valor : listaParametrosPassados)
        {

            if (valor instanceof String)
            {
                if (valor.equals("${show developers}"))
                {
                    valor = "\n\nDesenvolvedores:\n\nFillipi Domingos Pelz\nLuiz Fernando Noschang\n\n";
                }

                try
                {
                    saida.escrever((String) valor);
                }
                catch (Exception ex)
                {
                    throw new ErroExecucaoNaoTratado(ex);
                }
            }
            else if (valor instanceof Boolean)
            {
                try
                {
                    saida.escrever((Boolean) valor);
                }
                catch (Exception ex)
                {
                    throw new ErroExecucaoNaoTratado(ex);
                }
            }
            else if (valor instanceof Character)
            {
                try
                {

                    saida.escrever((Character) valor);
                }
                catch (Exception ex)
                {
                    throw new ErroExecucaoNaoTratado(ex);
                }
            }
            else if (valor instanceof Double)
            {
                try
                {
                    saida.escrever((Double) valor);
                }
                catch (Exception ex)
                {
                    throw new ErroExecucaoNaoTratado(ex);
                }
            }
            else if (valor instanceof Integer)
            {
                try
                {
                    saida.escrever((Integer) valor);
                }
                catch (Exception ex)
                {
                    throw new ErroExecucaoNaoTratado(ex);
                }
            }
        }
    }

    private void setLendo(boolean lendo)
    {
        synchronized (LOCK)
        {
            this.lendo = lendo;
        }
    }

    private boolean isLendo()
    {
        synchronized (LOCK)
        {
            return lendo;
        }
    }

    private void setLeituraIgnorada(boolean leituraIgnorada)
    {
        synchronized (LOCK)
        {
            this.leituraIgnorada = leituraIgnorada;
        }
    }

    private boolean isLeituraIgnorada()
    {
        synchronized (LOCK)
        {
            return leituraIgnorada;
        }
    }

    protected double leiaReal() throws ErroExecucao
    {
        return (Double) leia(TipoDado.REAL);
    }

    protected int leiaInteiro() throws ErroExecucao
    {
        return (Integer) leia(TipoDado.INTEIRO);
    }

    protected boolean leiaLogico() throws ErroExecucao
    {
        return (Boolean) leia(TipoDado.LOGICO);
    }

    protected char leiaCaracter() throws ErroExecucao
    {
        return (Character) leia(TipoDado.CARACTER);
    }

    protected String leiaCadeia() throws ErroExecucao
    {
        return (String) leia(TipoDado.CADEIA);
    }

    private Object leia(TipoDado tipoDado) throws ErroExecucao
    {
        assert (entrada != null);

        setLendo(true);

        try
        {
            InputHandler mediador = new InputHandler();
            entrada.solicitaEntrada(tipoDado, mediador);

            // Se for verdadeiro, significa que a entrada é assíncrona,
            // então devemos esperar a leitura da entrada. Caso contrário,
            // a entrada é síncrona, podemos seguir em frente e pegar o valor 
            if (mediador.getValor() == null && !mediador.isCancelado())
            {
                synchronized (LOCK)
                {
                    LOCK.wait();
                }
            }

            if (!mediador.isCancelado())
            {
                if (!isLeituraIgnorada())
                {
                    return mediador.getValor();
                }
                else
                {
                    throw new ErroValorEntradaInvalido(tipoDado, 0, 0);
                }
            }
            else
            {
                throw new ErroValorEntradaInvalido(tipoDado, 0, 0);
            }
        }
        catch (Exception ex)
        {
            throw new ErroExecucaoNaoTratado(ex);
        }
        finally
        {
            setLendo(false);
        }

    }

    private class InputHandler implements InputMediator, Armazenador
    {
        private Object valor;
        private boolean cancelado = false;

        @Override
        public Object getValor()
        {
            synchronized (LOCK)
            {
                return valor;
            }
        }

        @Override
        public void setValor(Object valor)
        {
            synchronized (LOCK)
            {
                this.valor = valor;
                LOCK.notifyAll();
            }
        }

        @Override
        public void cancelarLeitura()
        {
            synchronized (LOCK)
            {
                this.cancelado = true;
                LOCK.notifyAll();
            }
        }

        public boolean isCancelado()
        {
            synchronized (LOCK)
            {
                return cancelado;
            }
        }
    }

    private List<Biblioteca> obterBibliotecasIncluidas() throws ErroExecucaoBiblioteca, InterruptedException
    {
        try
        {
            Field atributos[] = this.getClass().getDeclaredFields();
            List<Biblioteca> bibliotecas = new ArrayList<>();

            for (Field atributo : atributos)
            {
                boolean acessoPermitido = atributo.isAccessible();
                if (!acessoPermitido)
                {
                    atributo.setAccessible(true);
                }
                if (atributo.get(this) instanceof Biblioteca)
                {
                    bibliotecas.add((Biblioteca) atributo.get(this));
                }
                atributo.setAccessible(acessoPermitido);
            }

            return bibliotecas;
        }
        catch (IllegalAccessException | IllegalArgumentException | SecurityException ex)
        {
            throw new ErroExecucaoBiblioteca(ex);
        }
    }

    protected void inicializaBibliotecasIncluidas() throws ErroExecucaoBiblioteca, InterruptedException
    {
        List<Biblioteca> bibliotecasReservadas = obterBibliotecasIncluidas();

        for (Biblioteca biblioteca : bibliotecasReservadas)
        {
            biblioteca.inicializar(this, bibliotecasReservadas);
        }
    }

    protected void finalizaBibliotecasIncluidas() throws ErroExecucaoBiblioteca, InterruptedException
    {
        List<Biblioteca> bibliotecasReservadas = obterBibliotecasIncluidas();

        for (Biblioteca biblioteca : bibliotecasReservadas)
        {
            biblioteca.finalizar();
        }
    }
}
