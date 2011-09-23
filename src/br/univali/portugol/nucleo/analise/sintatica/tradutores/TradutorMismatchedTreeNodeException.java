package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MismatchedTreeNodeException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorMismatchedTreeNodeException 
{
    public ErroSintatico traduzirErroParsing(MismatchedTreeNodeException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao) 
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
                
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }    
}
