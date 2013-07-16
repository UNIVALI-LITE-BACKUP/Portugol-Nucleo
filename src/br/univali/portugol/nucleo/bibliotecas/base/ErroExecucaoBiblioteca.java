package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroExecucaoBiblioteca extends ErroExecucao
{
    private String mensagem;

    public ErroExecucaoBiblioteca(String mensagem)
    {
        this.mensagem = mensagem;
    }    
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected String construirMensagem() 
    {
        return mensagem;
    }
}
