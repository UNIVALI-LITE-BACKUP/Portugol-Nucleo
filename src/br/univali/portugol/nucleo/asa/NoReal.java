package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#REAL} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see TipoDado
 */
public final class NoReal extends NoExpressao
{
    private double valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    /**
     * 
     * @param valor     o número real representado por este nó da árvore
     * @since 1.0
     */
    public NoReal(double valor)
    {
        this.valor = valor;
    }

    /**
     * 
     * @return     o número real representado por este nó da árvore
     * @since 1.0
     */
    public double getValor()
    {
        return valor;
    }

    /**
     * 
     * @param trechoCodigoFonte     o trecho do código fonte no qual o número real se encontra
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
