
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class Portugol
{ 
    public static ResultadoAnalise analisar(String codigo)
    {
        final AnalisadorAlgoritmo analizador = new AnalisadorAlgoritmo();
        final ResultadoAnalise resultado = analizador.analisar(codigo);
        
        if (resultado.getNumeroErrosSintaticos() <= 0)
        {
            resultado.setAsa(analizador.getArvoreSintaticaAbstrata());
        }
                    
        return resultado;
    }
    
    public static Programa compilar(String codigo) throws ErroCompilacao
    {
        Compilador compilador = new Compilador();
        Programa programa = compilador.compilar(codigo);
        
        return programa;
    }
    
    public static GerenciadorBibliotecas getGerenciadoBibliotecas()
    {
        return GerenciadorBibliotecas.getInstance();
    }
}