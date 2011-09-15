
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.analise.sintatica.PortugolLexer;
import br.univali.portugol.nucleo.analise.sintatica.PortugolParser;
import br.univali.portugol.nucleo.analise.ErroAlgoritmoContemErros;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

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
    
    public static Programa compilar(String codigo) throws Exception
    {
        return null;
    }
}