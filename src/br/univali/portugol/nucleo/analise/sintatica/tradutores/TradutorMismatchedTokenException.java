package br.univali.portugol.nucleo.analise.sintatica.tradutores;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParentesis;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiFechadoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressoesForaEscopoPrograma;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroFaltaDoisPontos;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroPalavraReservadaEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;
import org.antlr.runtime.MismatchedTokenException;

/**
 * Tradutor para erros de parsing do tipo {@link MismatchedTokenException}.
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
public final class TradutorMismatchedTokenException
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
    public ErroSintatico traduzirErroParsing(MismatchedTokenException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao, String codigoFonte)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;
        String contextoAtual = pilhaContexto.peek();
        
        String tokenEsperado = AnalisadorSintatico.getToken(tokens, erro.expecting);
        String tokenEncontrado = AnalisadorSintatico.getToken(tokens, erro.getUnexpectedType());
        
        if (contextoAtual.equals("para"))
        {
            return traduzirErrosPara(linha, coluna, erro, tokens, pilhaContexto, codigoFonte);
        }
        else if (tokenEsperado.equals("ID"))
        {
            return new ErroNomeSimboloEstaFaltando(linha, coluna, contextoAtual);
        }
        else if (tokenEsperado.equals("}"))
        {  
            return new ErroEscopoNaoFoiFechadoCorretamente(linha, coluna, pilhaContexto, codigoFonte);
        }
        else if (tokenEsperado.equals("("))
        {
            return new ErroAbreFechaParentesis(linha, coluna, "(");
        }
        else if (tokenEsperado.equals(")"))
        {
            return new ErroAbreFechaParentesis(linha, coluna, ")");
        }
        else if (tokenEsperado.equals(":"))
        {
            return new ErroFaltaDoisPontos(linha, coluna);
        }
        else if (AnalisadorSintatico.getTipoToken(tokenEsperado) == AnalisadorSintatico.TipoToken.PALAVRA_RESERVADA)
        {
            if (tokenEsperado.equals("PR_PROGRAMA"))
            {
                if (codigoFonte.indexOf("programa") >= 0)
                {
                    String expressoes = codigoFonte.substring(0, codigoFonte.indexOf("programa"));
                
                    return new ErroExpressoesForaEscopoPrograma(expressoes, 0, codigoFonte, ErroExpressoesForaEscopoPrograma.Local.ANTES);
                }
                else if (codigoFonte.indexOf("{") >= 0)
                {
                    final String expressoes = codigoFonte.substring(0, codigoFonte.indexOf("{"));
                    
                    return new ErroSintatico(linha, coluna)
                    {
                        @Override
                        protected String construirMensagem()
                        {
                            return String.format("A estrutura do algoritmo está incorreta. Para corrigir o problema, remova o seguinte trecho de código '%s', que está antes do caracter '{' e, inclua a palavra reservada 'programa' ", expressoes);
                        }
                    };
                }                
            }
            
            return new ErroPalavraReservadaEstaFaltando(linha, coluna, tokenEsperado.replace("PR_", "").toLowerCase(), contextoAtual);
        }

        return new ErroParsingNaoTratado(erro, mensagemPadrao, contextoAtual);
    }
    
    private ErroSintatico traduzirErrosPara(int linha, int coluna, MismatchedTokenException erro, String[] tokens, Stack<String> pilhaContexto, String codigoFonte)
    {
        String tokenEsperado = AnalisadorSintatico.getToken(tokens, erro.expecting);
        String tokenEncontrado = AnalisadorSintatico.getToken(tokens, erro.getUnexpectedType());
        
        if (tokenEsperado.equals(")"))
        {
            return new ErroAbreFechaParentesis(linha, coluna, ")");
        }
        else if (tokenEsperado.equals("("))
        {
            return new ErroAbreFechaParentesis(linha, coluna, "(");
        }
        else if (tokenEsperado.equals(";") && !tokenEncontrado.equals(")"))
        {
            return new ErroAbreFechaParentesis(linha, coluna, ")");
        }
        else
        
        return new ErroSintatico(linha, coluna)
        {
            @Override
            protected String construirMensagem()
            {
                return "O comando 'para' necessita ao menos de uma condição de parada. Utilize a seguinte construção para corrigir o problema: 'para( ; <condicao> ; ){ <comandos> }'";
            }
        };
    }
}
