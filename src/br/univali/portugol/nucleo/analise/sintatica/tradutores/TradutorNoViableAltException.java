package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroCadeiaIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoSimples;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoEsperada;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroTipoDeDadoEstaFaltando;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.NoViableAltException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class TradutorNoViableAltException 
{
    public ErroSintatico traduzirErroParsing(NoViableAltException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao) 
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.pop();
        
        if (contextoAtual.equals("declaracaoTipoDado"))
            return new ErroTipoDeDadoEstaFaltando(linha, coluna);

        else

        if (contextoAtual.equals("listaBlocos"))
            return new ErroEscopoSimples(linha, coluna);
            
        if (contextoAtual.equals("expressao7"))
            return criarErroExpressaoIncompleta(erro, pilhaContexto, linha, coluna, mensagemPadrao);
        
        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }
    
    private ErroSintatico criarErroExpressaoIncompleta(NoViableAltException erro, Stack<String> pilhaContexto, int linha, int coluna, String mensagemPadrao)
    {
        String contextoAnterior = "";

        do { contextoAnterior = pilhaContexto.pop(); }
        while (contextoAnterior.startsWith("expressao"));
        
        if (erro.token.getText().equals("<EOF>"))
        {
            return new ErroCadeiaIncompleta(linha, coluna, mensagemPadrao);
        }
        
        else

        if (contextoBloco(contextoAnterior))
        {
            return new ErroExpressaoEsperada(linha, coluna);
        }
        
        return new ErroExpressaoIncompleta(linha, coluna);
    }

    private boolean contextoBloco(String contexto)
    {
        return 
            contexto.equals("se") || 
            contexto.equals("enquanto") || 
            contexto.equals("facaEnquanto") || 
            contexto.equals("escolha");
    }
}