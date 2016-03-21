package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.mensagens.Erro;

/**
 *
 * @author Luiz Fernando Noschang
 * @since 03/20/2016
 */
public final class ErroAoTentarObterDeclaracaoDoSimbolo extends Erro
{
    private final String mensagem;
    
    public ErroAoTentarObterDeclaracaoDoSimbolo(String mensagem)
    {
        this.mensagem = mensagem;
    }
    
    @Override
    protected String construirMensagem()
    {
        return mensagem;
    }
}
