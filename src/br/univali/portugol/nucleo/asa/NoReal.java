package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#REAL} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see TipoDado
 */
public final class NoReal extends NoExpressaoLiteral<Double>
{
    /**
     * 
     * @param valor     o número real representado por este nó da árvore
     * @since 1.0
     */
    public NoReal(double valor)
    {
        super(valor);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }

    @Override
    public String toString()
    {
        return Double.toString(getValor());
    }
}
