package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.execucao.Depurador;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.execucao.es.Entrada;
import br.univali.portugol.nucleo.execucao.es.EntradaSaidaPadrao;
import br.univali.portugol.nucleo.execucao.ModoEncerramento;
import br.univali.portugol.nucleo.execucao.ObservadorExecucao;
import br.univali.portugol.nucleo.execucao.ResultadoExecucao;
import br.univali.portugol.nucleo.execucao.es.Saida;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
public final class Programa
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
    private static int contadorDeThreads = 0;
    private static final ExecutorService servicoExecucao = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 2L, TimeUnit.HOURS, new SynchronousQueue<Runnable>(), new ThreadFactory()
    {
        
        @Override
        public Thread newThread(Runnable r)
        {
            return new Thread(r, "Thread do nucleo " + (++contadorDeThreads));
        }
    });

    private Saida saida;
    private Entrada entrada;
    private String funcaoInicial;
    private File diretorioTrabalho = new File(".");

    private TarefaExecucao tarefaExecucao = null;
    private Future controleTarefaExecucao = null;

    private ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrataPrograma;
    private List<String> funcoes;
    private ResultadoAnalise resultadoAnalise;
    
    private final ArrayList<ObservadorExecucao> observadores;

    private final SetadorPontosParada setadorPontosParada = new SetadorPontosParada();

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
     *
     * @since 2.0
     */
    public void executar(String[] parametros, Depurador.Estado estado)
    {
        if (!isExecutando())
        {
            tarefaExecucao = new TarefaExecucao(parametros, estado);
            controleTarefaExecucao = servicoExecucao.submit(tarefaExecucao);
        }
    }
    
    public void continuar(Depurador.Estado estado)
    {
        if (isExecutando())
        {
            tarefaExecucao.continuar(estado);
        }
        else
        {
            throw new IllegalStateException("O programa não pode ser continuado pois não foi iniciado");
        }
    }

    /**
     *
     * @param candidatosParaPontosDeParada
     * @return retorna um conjunto com os números das linhas que puderam ser
     * marcadas
     */
    public Set<Integer> setPontosDeParada(Collection<Integer> candidatosParaPontosDeParada)
    {
        //TODO usar a coleção de linhas marcadas para notificar a VIEW sobre quais linhas realmente
        //foram marcadas, nem todas as linhas em 'candidatosParaPontosDeParada'  
        return setadorPontosParada.setaPontosDeParada(candidatosParaPontosDeParada, arvoreSintaticaAbstrataPrograma);
    }

    /**
     * Implementa uma tarefa para disparar a execução do programa com os
     * parâmetros e a estratégia selecionada. Futuramente podemos refatorar para
     * executar a partir de um pool de threads.
     */
    private final class TarefaExecucao implements Runnable
    {
        private final String[] parametros;
        private final ResultadoExecucao resultadoExecucao;
        private final Depurador.Estado estado;
        private final Depurador depurador;

        public TarefaExecucao(String[] parametros, Depurador.Estado estado)
        {
            this.parametros = parametros;
            this.resultadoExecucao = new ResultadoExecucao();
            this.estado = estado;
            this.depurador = new Depurador();
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
                depurador.setEstado(estado);

                depurador.adicionarObservadoresExecucao(observadores);
                notificarInicioExecucao();
                depurador.executar(Programa.this, parametros);
            }
            catch (ErroExecucao erroExecucao)
            {
                resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                resultadoExecucao.setErro(erroExecucao);
            }
            catch (InterruptedException excecao)
            {
                resultadoExecucao.setModoEncerramento(ModoEncerramento.INTERRUPCAO);
            }

            resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);

            notificarEncerramentoExecucao(resultadoExecucao);
        }

        public void continuar(Depurador.Estado estado)
        {
            depurador.continuar(estado);
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

    /**
     * Obtém a ASA que representa este programa.
     *
     * @return a ASA que representa este programa
     * @since 1.0
     */
    public ArvoreSintaticaAbstrataPrograma getArvoreSintaticaAbstrata()
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
    public void setArvoreSintaticaAbstrata(ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrataPrograma)
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
}
