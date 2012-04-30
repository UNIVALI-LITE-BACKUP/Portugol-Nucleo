package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public abstract class NoExpressao extends NoBloco
{
    private TrechoCodigoFonte trechoCodigoFonte = null;

    public NoExpressao()
    {
    }

    public final TrechoCodigoFonte getTrechoCodigoFonte()
    {
        if (trechoCodigoFonte == null)
        {
            trechoCodigoFonte = montarTrechoCodigoFonte();
        }

        return trechoCodigoFonte;
    }

    protected abstract TrechoCodigoFonte montarTrechoCodigoFonte();
}