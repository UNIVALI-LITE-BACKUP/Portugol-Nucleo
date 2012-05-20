package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public abstract class NoExpressao extends NoBloco
{
    private boolean entreParentesis = false;
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

    public boolean estaEntreParentesis()
    {
        return entreParentesis;
    }

    public void setEntreParentesis(boolean entreParentesis)
    {
        this.entreParentesis = entreParentesis;
    }
    
    protected abstract TrechoCodigoFonte montarTrechoCodigoFonte();
}