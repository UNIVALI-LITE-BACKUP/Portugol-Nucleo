package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroCadeiaIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroCaracterInvalidoReferencia;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoSimples;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoEsperada;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroTipoDeDadoEstaFaltando;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.NoViableAltException;

/**
 * Tradutor para erros de parsing do tipo {@link NoViableAltException}.
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
public final class TradutorNoViableAltException
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
    public ErroSintatico traduzirErroParsing(NoViableAltException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();

        if (contextoAtual.equals("declaracaoTipoDado"))
        {
            return new ErroTipoDeDadoEstaFaltando(linha, coluna);
        }
        else
        {
            if (contextoAtual.equals("listaBlocos"))
            {
                return new ErroEscopoSimples(linha, coluna);
            }
        }

        if (contextoAtual.equals("expressao7"))
        {
            return criarErroExpressaoIncompleta(erro, pilhaContexto, linha, coluna, mensagemPadrao);
        }

        if (contextoAtual.equals("referencia")){
            return new ErroCaracterInvalidoReferencia(linha, coluna, erro.token.getText());
        }
        
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }

    private ErroSintatico criarErroExpressaoIncompleta(NoViableAltException erro, Stack<String> pilhaContexto, int linha, int coluna, String mensagemPadrao)
    {
        String contextoAnterior = "";

        do
        {
            contextoAnterior = pilhaContexto.pop();
        }
        while (contextoAnterior.startsWith("expressao"));

        if (erro.token.getText().equals("<EOF>"))
        {
            return new ErroCadeiaIncompleta(linha, coluna, mensagemPadrao);
        }
        else
        {
            if (contextoBloco(contextoAnterior))
            {
                return new ErroExpressaoEsperada(linha, coluna);
            }
        }

        return new ErroExpressaoIncompleta(linha, coluna);
    }

    private boolean contextoBloco(String contexto)
    {
        return contexto.equals("se")
                || contexto.equals("enquanto")
                || contexto.equals("facaEnquanto")
                || contexto.equals("escolha");
    }
}