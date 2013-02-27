package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroCaracterInsperadoInvalido;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.UnwantedTokenException;

/**
 * Tradutor para erros de parsing do tipo {@link UnwantedTokenException}.
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
public final class TradutorUnwantedTokenException
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
    public ErroSintatico traduzirErroParsing(UnwantedTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        
        
       return new ErroCaracterInsperadoInvalido(linha, coluna, erro.getUnexpectedToken().getText());
    }
}
