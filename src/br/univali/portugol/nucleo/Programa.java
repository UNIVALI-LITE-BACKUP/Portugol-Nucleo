
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.execucao.Entrada;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.execucao.ModoEncerramento;
import br.univali.portugol.nucleo.execucao.ObservadorExecucao;
import br.univali.portugol.nucleo.execucao.ResultadoExecucao;
import br.univali.portugol.nucleo.execucao.Saida;
import br.univali.portugol.nucleo.execucao.erros.ErroExecucaoNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.relator.erros.RelatorErros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 * @author Fillipi Domingos Pelz
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
        relatorErros =  new RelatorErros();
        relatorErros.inicializar("Portugol Núcleo", "1.0");
        observadores = new ArrayList<ObservadorExecucao>();
    }
    
    public void adicionarObservadorExecucao(ObservadorExecucao observador)
    {
        if (!observadores.contains(observador))
            observadores.add(observador);
    }
    
    public void removerObservadorExecucao(ObservadorExecucao observador)
    {
        observadores.remove(observador);
    }
    
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
                        interpretador.setFuncaoInicial(funcaoInicial);

                        notificarInicioExecucao();

                        resultadoExecucao = new ResultadoExecucao();
                        horaInicialExecucao = System.currentTimeMillis();
                        
                        interpretador.interpretar(arvoreSintaticaAbstrataPrograma, parametros);

                        threadExecucao = null;
                        resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);
                        notificarEncerramentoExecucao(resultadoExecucao);
                    }
                    catch (InterruptedException excecaoThreadInterrompida)
                    {
                        
                    }
                    catch (ErroExecucao erroExecucao)
                    {
                        resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                        resultadoExecucao.setErro(erroExecucao);
                        notificarEncerramentoExecucao(resultadoExecucao);
                    }
                    catch (Exception erro)
                    {   
                        resultadoExecucao.setModoEncerramento(ModoEncerramento.ERRO);
                        resultadoExecucao.setErro(new ErroExecucaoNaoTratado(erro));
                        relatorErros.relatarErro(erro, codigo);
                        notificarEncerramentoExecucao(resultadoExecucao);
                    }
                }
            });
            
            threadExecucao.start();
        }
    }
    
    /*
    public void depurar() throws Exception
    {
        
    }
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
            
            threadExecucao.interrupt();
            threadExecucao = null;

            resultadoExecucao.setModoEncerramento(ModoEncerramento.INTERRUPCAO);
            resultadoExecucao.setTempoExecucao(System.currentTimeMillis() - horaInicialExecucao);

            new Thread(new Runnable() 
            {
                @Override
                public void run() 
                {
                    try { Thread.sleep(500); }
                    catch (Exception ex) {}

                    notificarEncerramentoExecucao(resultadoExecucao);

                    resultadoExecucao = null;
                }
            }).start();
        } 
    }
    
    public ArvoreSintaticaAbstrataPrograma getArvoreSintaticaAbstrata()
    {
        return arvoreSintaticaAbstrataPrograma;
    }

    public void setArvoreSintaticaAbstrataPrograma(ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrataPrograma) 
    {
        this.arvoreSintaticaAbstrataPrograma = arvoreSintaticaAbstrataPrograma;
    }
    
    public void setFuncaoInicial(String funcaoInicial)
    {
        this.funcaoInicial = funcaoInicial;
    }
    
    public String getFuncaoInicial()
    {
        return funcaoInicial;
    }

    public Entrada getEntrada() 
    {
        return entrada;
    }

    public Saida getSaida() 
    {
        return saida;
    }

    public void setEntrada(Entrada entrada) 
    {
        this.entrada = entrada;
    }

    public void setSaida(Saida saida) 
    {
        this.saida = saida;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getCodigo() 
    {
        return codigo;
    }
    
    public boolean isExecutando()
    {
        return threadExecucao != null;
    }
    
    private void notificarInicioExecucao()
    {
        for (ObservadorExecucao observador: observadores)
            observador.execucaoIniciada(this);
    }
    
    private void notificarEncerramentoExecucao(ResultadoExecucao resultadoExecucao)
    {
        threadExecucao = null;
        
        for (ObservadorExecucao observador: observadores)
            observador.execucaoEncerrada(this, resultadoExecucao);
    }    
}