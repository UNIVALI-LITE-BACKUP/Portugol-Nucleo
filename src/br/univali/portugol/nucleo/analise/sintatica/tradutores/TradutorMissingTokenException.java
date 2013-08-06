package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParentesis;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiAbertoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroFaltaDoisPontos;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroPalavraReservadaEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroTokenFaltando;
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
    public ErroSintatico traduzirErroParsing(MissingTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao, String codigoFonte)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.peek();
        
        final String token = AnalisadorSintatico.getToken(tokens, erro.getMissingType());

        if (contextoAtual.equals("para"))
        {
            return traduzirErrosPara(linha, coluna, erro, tokens, pilhaContexto, codigoFonte);
        }
        else if (token.equals("ID"))
        {
            return new ErroNomeSimboloEstaFaltando(linha, coluna, contextoAtual);
        }
        else if (token.equals("{"))
        {
            return new ErroEscopoNaoFoiAbertoCorretamente(linha, coluna, contextoAtual);
        }
        else if (token.equals("("))
        {
            return new ErroAbreFechaParentesis(linha, coluna, "(");
        }
        else if (token.equals(")"))
        {
            return new ErroAbreFechaParentesis(linha, coluna, ")");
        }
        else if (token.equals(":"))
        {
            return new ErroFaltaDoisPontos(linha, coluna);
        }
        else if (AnalisadorSintatico.getTipoToken(token) == AnalisadorSintatico.TipoToken.PALAVRA_RESERVADA)
        {
            return new ErroPalavraReservadaEstaFaltando(linha, coluna, token.replace("PR_", "").toLowerCase(), contextoAtual);
        }

        return new ErroTokenFaltando(linha, coluna, token);
    }
    
    private ErroSintatico traduzirErrosPara(int linha, int coluna, MissingTokenException erro, String[] tokens, Stack<String> pilhaContexto, String codigoFonte)
    {
        String tokenEsperado = AnalisadorSintatico.getToken(tokens, erro.getMissingType());

        if (tokenEsperado.equals(")"))
        {            
            return new ErroAbreFechaParentesis(linha, coluna, ")");
        }
        else if (tokenEsperado.equals("("))
        {
            return new ErroAbreFechaParentesis(linha, coluna, "(");
        }
                
        return new ErroTokenFaltando(linha, coluna, tokenEsperado);
    }    
}
