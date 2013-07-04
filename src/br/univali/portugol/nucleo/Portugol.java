
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
        final AnalisadorAlgoritmo analizador = new AnalisadorAlgoritmo();
        final ResultadoAnalise resultado = analizador.analisar(codigo);
        //if (resultado.getNumeroTotalErros() <= 0)
            resultado.setAsa(analizador.getArvoreSintaticaAbstrata());
        return resultado;
    }
    
    public static Programa compilar(String codigo) throws ErroCompilacao
    {
        AnalisadorAlgoritmo analisadorAlgoritmo = new AnalisadorAlgoritmo();
        ResultadoAnalise resultadoAnalise = analisadorAlgoritmo.analisar(codigo);
        
        if (resultadoAnalise.getNumeroTotalErros() > 0)
            throw new ErroCompilacao(resultadoAnalise);

        Programa programa = new Programa();
        programa.setCodigo(codigo);
        final ArvoreSintaticaAbstrataPrograma asa = (ArvoreSintaticaAbstrataPrograma) analisadorAlgoritmo.getArvoreSintaticaAbstrata();
        programa.setArvoreSintaticaAbstrataPrograma(asa);

        return programa;
    }
}