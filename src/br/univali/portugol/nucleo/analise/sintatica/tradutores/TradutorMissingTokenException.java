package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.PortugolLexer;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParenteses;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiAbertoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MissingTokenException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorMissingTokenException 
{
    public ErroSintatico traduzirErroParsing(MissingTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao) 
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
        
        if (erro.getMissingType() == PortugolLexer.ID)
            return new ErroNomeSimboloEstaFaltando(linha, coluna, contextoAtual);

        else

        if (erro.getMissingType() == PortugolLexer.T__67)
            return new ErroEscopoNaoFoiAbertoCorretamente(linha, coluna, contextoAtual);

        else

        if (erro.getMissingType() == PortugolLexer.T__42)
            return new ErroAbreFechaParenteses(linha, coluna, "(");

        else

        if (erro.getMissingType() == PortugolLexer.T__43)
            return new ErroAbreFechaParenteses(linha, coluna, ")");
        
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }    
}
