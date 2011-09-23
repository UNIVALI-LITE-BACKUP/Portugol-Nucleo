package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.PortugolLexer;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParenteses;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiFechadoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroPalavraReservadaEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MismatchedTokenException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorMismatchedTokenException
{
    public ErroSintatico traduzirErroParsing(MismatchedTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
        
        if (erro.expecting == PortugolLexer.ID)
            return new ErroNomeSimboloEstaFaltando(linha, coluna, contextoAtual);

        else
            
        if (erro.expecting == PortugolLexer.T__68)
            return new ErroEscopoNaoFoiFechadoCorretamente(linha, coluna, contextoAtual);
            
        else
            
        if (erro.expecting == PortugolLexer.T__42)
            return new ErroAbreFechaParenteses(linha, coluna, "(");
            
        else
                
        if (erro.expecting == PortugolLexer.T__43)    
            return new ErroAbreFechaParenteses(linha, coluna, ")");
            
        if (tokens[((MismatchedTokenException) erro).expecting].startsWith("PR_"))
        {
            String palavraReservada = tokens[erro.expecting];
            palavraReservada = palavraReservada.replace("PR_", "").toLowerCase();
                        
            return new ErroPalavraReservadaEstaFaltando(linha, coluna, palavraReservada);
        }
               
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }    
}