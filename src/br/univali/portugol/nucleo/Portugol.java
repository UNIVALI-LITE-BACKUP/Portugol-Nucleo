
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class Portugol
{    
    public static final String QUEBRA_DE_LINHA = "\n";
    
    private static Programa compilar(String codigo, boolean paraExecucao) throws ErroCompilacao
    {
        Compilador compilador = new Compilador();
        Programa programa = compilador.compilar(codigo, paraExecucao);
        
        return programa;
    }
    
    public static Programa compilarParaAnalise(String codigo) throws ErroCompilacao
    {
        return compilar(codigo, false);
    }
    
    public static Programa compilarParaExecucao(String codigo) throws ErroCompilacao
    {
        return compilar(codigo, true);
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