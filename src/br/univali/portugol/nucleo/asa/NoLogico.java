package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#LOGICO} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see TipoDado
 */
public final class NoLogico extends NoExpressao
{
    private boolean valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    /**
     * @param valor     o valor lógico representado por este nó da árvore
     * @since 1.0
     */    
    public NoLogico(boolean valor)
    {
        this.valor = valor;
    }

    /**
     * @return     o valor lógico representado por este nó da árvore
     * @since 1.0
     */
    public boolean getValor()
    {
        return valor;
    }

    /**
     * 
     * @param trechoCodigoFonte     o trecho do código fonte no qual o valor lógico se encontra
     * @since 1.0
     */
    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return trechoCodigoFonte;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
