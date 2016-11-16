
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class Portugol
{    
    public static final String QUEBRA_DE_LINHA = "\n";
    
    private static final Logger LOGGER = Logger.getLogger(Portugol.class.getName());
    
    private static final ExecutorService servico = Executors.newSingleThreadExecutor(); // usa uma thread só para enfileirar compilações consecutivas, isso evita ter que tratar compilações simultâneas
    
    private static Programa compilar(String codigo, boolean paraExecucao) throws ErroCompilacao
    {
        Compilador compilador = new Compilador();
        
        long start = System.currentTimeMillis();
        
        Programa programa = compilador.compilar(codigo, paraExecucao);
        
        long tempoCompilacao = System.currentTimeMillis() - start;
        
        String mensagem = String.format("compilação para %s em %d ms - tamanho código: %d", 
                (paraExecucao ? "execução": "análise"), tempoCompilacao, codigo.length());
        
        LOGGER.log(Level.INFO, mensagem);
        
        return programa;
    }
    
    public static Programa compilarParaAnalise(String codigo) throws ErroCompilacao
    {
        return compilar(codigo, false);
    }
    
    public static void compilarParaExecucao(final String codigo, final ListenerCompilacao listener)
    {
        Runnable tarefa = new Runnable()
        {
            @Override
            public void run()
            {
                listener.compilacaoParaExecucaoIniciada();
                try
                {
                    Programa programa = compilar(codigo, true);
                    listener.compilacaoParaExecucaoFinalizada(programa);
                }
                catch(ErroCompilacao erro)
                {
                    listener.errosDeCompilacaoDetectados(erro);
                }
            }
        };
        servico.submit(tarefa);
    }
    
    public static String renomearSimbolo(String programa, int linha, int coluna, String novoNome) throws ErroAoRenomearSimbolo
    {
        return new RenomeadorDeSimbolos().renomearSimbolo(programa, linha, coluna, novoNome);
    }
    
    public static NoDeclaracao obterDeclaracaoDoSimbolo(String programa, int linha, int coluna) throws ErroAoTentarObterDeclaracaoDoSimbolo
    {
        return new RenomeadorDeSimbolos().obterDeclaracaoDoSimbolo(programa, linha, coluna);
    }
    
    public static GerenciadorBibliotecas getGerenciadorBibliotecas()
    {
        return GerenciadorBibliotecas.getInstance();
    }
}