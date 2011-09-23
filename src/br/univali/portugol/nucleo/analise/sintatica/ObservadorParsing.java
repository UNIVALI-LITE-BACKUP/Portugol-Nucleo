package br.univali.portugol.nucleo.analise.sintatica;

import java.util.Stack;
import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface ObservadorParsing
{
    public void tratarErroParsing(RecognitionException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao);
}
