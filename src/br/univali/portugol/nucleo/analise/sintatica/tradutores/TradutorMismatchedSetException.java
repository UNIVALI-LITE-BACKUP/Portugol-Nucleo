package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MismatchedSetException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorMismatchedSetException 
{
    public ErroSintatico traduzirErroParsing(MismatchedSetException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
        
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }
    
}
