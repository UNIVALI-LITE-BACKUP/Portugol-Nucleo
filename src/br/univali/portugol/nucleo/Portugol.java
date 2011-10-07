
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class Portugol
{ 
    public static ResultadoAnalise analisar(String codigo)
    {
        return new AnalisadorAlgoritmo().analisar(codigo);
    }
    
    public static Programa compilar(String codigo) throws ErroCompilacao
    {
        AnalisadorAlgoritmo analisadorAlgoritmo = new AnalisadorAlgoritmo();
        ResultadoAnalise resultadoAnalise = analisadorAlgoritmo.analisar(codigo);
        
        if (resultadoAnalise.getNumeroTotalErros() == 0)
        {
            Programa programa = new Programa();
            programa.setCodigo(codigo);
            programa.setArvoreSintaticaAbstrataPrograma((ArvoreSintaticaAbstrataPrograma) analisadorAlgoritmo.getArvoreSintaticaAbstrata());

            return programa;
        }
        
        else throw new ErroCompilacao(resultadoAnalise);
    }
}