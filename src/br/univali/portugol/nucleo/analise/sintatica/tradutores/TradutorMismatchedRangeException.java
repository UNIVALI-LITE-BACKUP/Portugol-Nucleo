package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MismatchedRangeException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorMismatchedRangeException 
{
    public ErroSintatico traduzirErroParsing(MismatchedRangeException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
        
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }
    
}
