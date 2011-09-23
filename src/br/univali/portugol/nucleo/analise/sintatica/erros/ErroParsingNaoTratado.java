package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroParsingNaoTratado extends ErroSintatico
{
    private String contexto;
    private String mensagemPadrao;
    private RecognitionException erro;
    
    public ErroParsingNaoTratado(RecognitionException erro, String mensagemPadrao, String contexto) 
    {
        super(erro.line, erro.charPositionInLine);
        this.erro = erro;
        this.contexto = contexto;
        this.mensagemPadrao = mensagemPadrao;
    }

    @Override
    protected String construirMensagem() 
    {
        return this.mensagemPadrao + " - Contexto: " + contexto + " - Classe: " + erro.getClass().getSimpleName();
    }    
}
