package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.analise.sintatica.PortugolLexer;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParentesis;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiAbertoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MissingTokenException;

/**
 * Tradutor para erros de parsing do tipo {@link MissingTokenException}.
 * 
 * TODO: adicionar nesta documentação a descrição e exemplos de quando este tipo 
 * de erro é gerado pelo ANTLR.
 * 
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 */
public final class TradutorMissingTokenException
{
    /**
     * 
     * @param erro               o erro de parsing gerado pelo ANTLR, sem nenhum tratamento.
     * @param tokens             a lista de tokens envolvidos no erro.
     * @param pilhaContexto      a pilha de contexto do analisador sintático.
     * @param mensagemPadrao     a mensagem de erro padrão para este tipo de erro.
     * @return                   o erro sintático traduzido.
     * @since 1.0
     */
    public ErroSintatico traduzirErroParsing(MissingTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();

        if (erro.getMissingType() == PortugolLexer.ID)
        {
            return new ErroNomeSimboloEstaFaltando(linha, coluna, contextoAtual);
        }
        else
        {
            if (erro.getMissingType() == PortugolLexer.T__67)
            {
                return new ErroEscopoNaoFoiAbertoCorretamente(linha, coluna, contextoAtual);
            }
            else
            {
                if (erro.getMissingType() == PortugolLexer.T__42)
                {
                    return new ErroAbreFechaParentesis(linha, coluna, "(");
                }
                else
                {
                    if (erro.getMissingType() == PortugolLexer.T__43)
                    {
                        return new ErroAbreFechaParentesis(linha, coluna, ")");
                    }
                }
            }
        }

        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }
}
