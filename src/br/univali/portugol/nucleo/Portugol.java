
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class Portugol
{    
    public static Programa compilar(String codigo) throws ErroCompilacao
    {
        Compilador compilador = new Compilador();
        Programa programa = compilador.compilar(codigo);
        
        return programa;
    }
    
    public static GerenciadorBibliotecas getGerenciadorBibliotecas()
    {
        return GerenciadorBibliotecas.getInstance();
    }
}