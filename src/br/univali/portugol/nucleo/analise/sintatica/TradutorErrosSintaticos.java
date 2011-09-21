
package br.univali.portugol.nucleo.analise.sintatica;

import java.util.Stack;
import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface TradutorErrosSintaticos
{
    public void traduzirErroSintatico(Stack<String> pilhaContexto, RecognitionException erro, String[] tokens);
}
