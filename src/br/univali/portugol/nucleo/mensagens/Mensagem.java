
package br.univali.portugol.nucleo.mensagens;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public abstract class Mensagem extends Exception
{
    private String mensagem = null;

    public Mensagem()
    {

    }

    @Override
    public final String toString()
    {
        return getMensagem();
    }

    @Override
    public final String getMessage()
    {
        return getMensagem();
    }

    public final String getMensagem()
    {
        if (mensagem == null)
            mensagem = construirMensagem();

        return mensagem;
    }
    
    protected abstract String construirMensagem();
}