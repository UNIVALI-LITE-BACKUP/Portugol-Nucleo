
package br.univali.portugol.nucleo.analise.sintatica;

import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface TradutorErrosSintaticos
{
    public void traduzirErroSintatico(String contexto, RecognitionException erro, String[] tokens);
}
