package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.execucao.Entrada;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.execucao.ModoEncerramento;
import br.univali.portugol.nucleo.execucao.ObservadorExecucao;
import br.univali.portugol.nucleo.execucao.ObservadorInterpretacao;
import br.univali.portugol.nucleo.execucao.ResultadoExecucao;
import br.univali.portugol.nucleo.execucao.Saida;
import br.univali.portugol.nucleo.execucao.erros.ErroExecucaoNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.relator.erros.RelatorErros;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe provê uma fachada (Facade) para abstrair os detalhes da execução dos programas que não interessam 
 * aos utilizadores do Portugol.
 * <p>
 * Ela se encarrega de instanciar um interpretador para o código fonte e de gerenciar o ciclo de vida (inicio, fim, interrupção)
 * da Thread na qual o interpretador irá executar.
 * 
 * 
 * @author Luiz Fernando Noschang
 * @author Fillipi Domingos Pelz

 * @version 1.0
 * @see Interpretador
 * @see Thread
 */
public final class Programa
{
    private String codigo;
    private RelatorErros relatorErros;
    private Saida saida;
    private Entrada entrada;
    private String funcaoInicial = Interpretador.funcaoInicialPadrao;
    private Thread threadExecucao = null;
    private long horaInicialExecucao = 0L;
    private ResultadoExecucao resultadoExecucao = null;
    private List<ObservadorExecucao> observadores;
    private ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrataPrograma;

    public Programa()
    {
        relatorErros = new RelatorErros();
        relatorErros.inicializar("Portugol Núcleo", "1.0");
        observadores = new ArrayList<ObservadorExecucao>();
    }

    /** 
     * Permite adicionar um observador à execução do programa. Os observadores serão notificados sobre o início e
     * o término da execução, bem como erros em tempo de execução que vierem a ocorrer.
     * 
     * @param observador     o observador de execução a ser registrado.
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
     * Remove um observador de execução previamente registrado utilizando o método 
     * {@link Programa#adicionarObservadorExecucao(br.univali.portugol.nucleo.execucao.ObservadorExecucao) }.
     * Uma vez removido, o observador não será mais notificado sobre o estado da execução do programa nem dos 
     * erros em tempo de execução que vierem a ocorrer.
     * 
     * @param observador     um observador de execução previamente registrado.
     * @since 1.0
     */
    public void removerObservadorExecucao(ObservadorExecucao observador)
    {
        observadores.remove(observador);
    }

    private List<ObservadorInterpretacao> observadoresInter = new ArrayList<ObservadorInterpretacao>();
    public void addObservadorInterpretacao(ObservadorInterpretacao o) {
        observadoresInter.add(o);
    }
    
    /**
     * Executa este programa com os parâmetros especificados. Se o programa já estiver
     * executando não faz nada.
     * 
     * @param parametros     lista de parâmetros que serão passados ao programa no
     *                       momento da execução.
     * @since 1.0
     */
    public void executar(final String[] parametros)
    {
        if (!isExecutando())
        {
            threadExecucao = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Interpretador interpretador = new Interpretador();
                        interpretador.setEntrada(entrada);
                        interpretador.setSaida(saida);
                        
                        notificarInicioExecucao();
                        
                        resultadoExecucao = new ResultadoExecucao();
                        horaInicialExecucao = System.currentTimeMillis();
                        
                        resultadoExecucao.setRetorno(interpretador.interpretar(Programa.this, parametros));
                        
                        threadExecucao = null;
                        resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);
                        
                        notificarEncerramentoExecucao(resultadoExecucao);
                        
                    }
                    catch (ErroExecucao erroExecucao)
                    {                  
                        if ( erroExecucao instanceof ErroExecucaoNaoTratado 
                                && ((ErroExecucaoNaoTratado)erroExecucao).getCausa().getCause() != null 
                                && ((ErroExecucaoNaoTratado)erroExecucao).getCausa().getCause() instanceof InterruptedException)
                        {                           
                            notificarEncerramentoExecucao(resultadoExecucao);
                          
                        } else { 
                            if (resultadoExecucao == null)
                            {
                                resultadoExecucao = new ResultadoExecucao();
                            }

                            resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                            resultadoExecucao.setErro(erroExecucao);
                            notificarEncerramentoExecucao(resultadoExecucao);
                        }
                    }
                    catch (Exception erro)
                    {
                        if (resultadoExecucao == null)
                        {
                            resultadoExecucao = new ResultadoExecucao();
                        }
                       
                        resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                        resultadoExecucao.setErro(new ErroExecucaoNaoTratado(erro));
                        
                        relatorErros.relatarErro(erro, codigo);                  
                        notificarEncerramentoExecucao(resultadoExecucao);
                    }
                }
            });

            try {
                threadExecucao.start();            
            } catch (RuntimeException ie){
                if (ie.getCause() instanceof InterruptedException)
                {
                    notificarEncerramentoExecucao(resultadoExecucao);
                }
            }
        }
    }

    /*
    public void depurar() throws Exception
    {
    
    }
     */
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
            /*
             * Se estiver no meio de um escreva, esibe uma exception no console do netbeans.
             * A exception é referente ao JTextArea do console.
             * 
             * Parece ser um bug da JVM. No entanto, este bug não parece impedir
             * a interrupção da thread e nem causa outros efeitos colaterais (será?)
             * 
             */
            resultadoExecucao.setModoEncerramento(ModoEncerramento.INTERRUPCAO);
            resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);
            
            threadExecucao.interrupt();
            threadExecucao = null;
        }
    }

    /**
     * Obtém a ASA que representa este programa.
     * 
     * @return     a ASA que representa este programa
     * @since 1.0
     */
    public ArvoreSintaticaAbstrataPrograma getArvoreSintaticaAbstrata()
    {
        return arvoreSintaticaAbstrataPrograma;
    }

    /**
     * Define a ASA que representa este programa.
     * 
     * @param arvoreSintaticaAbstrataPrograma     a ASA que representa este programa.
     * @since 1.0
     */
    public void setArvoreSintaticaAbstrataPrograma(ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrataPrograma)
    {
        this.arvoreSintaticaAbstrataPrograma = arvoreSintaticaAbstrataPrograma;
    }

    /**
     * Define o nome da função que deverá ser chamada para dar início à execução do programa.
     * Caso não tenho sido declarada uma função com este nome no código fonte, será
     * gerado um erro em tempo de execução.
     * 
     * @param funcaoInicial     o nome da função que será o ponto de partida do programa.
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
     * @return     o nome da função que está atualmente definida como ponto de partida.
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
     * @return     a interface para entrada de dados que está atualmente registrada.
     * @since 1.0
     */
    public Entrada getEntrada()
    {
        return entrada;
    }

    /**
     * Obtém a interface para saída de dados que está atualmente registrada
     * para este programa.
     * 
     * @return     a interface para saída de dados que está atualmente registrada.
     * @since 1.0
     */
    public Saida getSaida()
    {
        return saida;
    }

    /**
     * Define a interface para entrada de dados deste programa.
     * 
     * @param entrada     a interface para entrada de dados a ser registrada para este programa.
     * @since 1.0
     */
    public void setEntrada(Entrada entrada)
    {
        this.entrada = entrada;
    }

    /**
     * Define a interface para saída de dados deste programa.
     * 
     * @param saida     a interface para saída de dados a ser registrada para este programa.
     * @since 1.0
     */
    public void setSaida(Saida saida)
    {
        this.saida = saida;
    }

    /**
     * Define o código fonte deste programa.
     * 
     * @param codigo     o código fonte que gerou este programa ao ser compilado.
     * @since 1.0
     */
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * Obtém o código fonte que gerou este programa ao ser compilado.
     * 
     * @return     o código fonte que gerou este programa ao ser compilado.
     * @since 1.0
     */
    public String getCodigo()
    {
        return codigo;
    }

    /**
     * Verifica se este programa está em execução.
     * 
     * @return     <code>true</code> se o programa estiver executando, caso contrário 
     *             retorna <code>false</code>.
     * @since 1.0
     */
    public boolean isExecutando()
    {
        return threadExecucao != null;
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
     * @param resultadoExecucao     objeto contendo informações sobre o motivo do encerramento
     *                              do programa e eventos ocorridos durante a execução.
     * @since 1.0
     */
    private void notificarEncerramentoExecucao(ResultadoExecucao resultadoExecucao)
    {
        threadExecucao = null;

        for (ObservadorExecucao observador : observadores)
        {
            observador.execucaoEncerrada(this, resultadoExecucao);
        }
    }
}