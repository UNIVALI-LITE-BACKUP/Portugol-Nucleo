package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public abstract class NoExpressao extends NoBloco
{
    private TrechoCodigoFonte referenciaCodigo = null;

    public NoExpressao()
    {
    }

    public final TrechoCodigoFonte getReferenciaCodigo()
    {
        if (referenciaCodigo == null)
        {
            referenciaCodigo = montarTrechoCodigoFonte();
        }

        return referenciaCodigo;
    }

    protected abstract TrechoCodigoFonte montarTrechoCodigoFonte();
}