package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#CADEIA} no código fonte.
 *
 * @author Luiz Fernando Noschang
 * @version 1.0
 *
 * @see TipoDado
 */
public final class NoCadeia extends NoValor<String>
{
    /**
     * @param valor a cadeia representada por este nó da árvore
     * @since 1.0
     */
    public NoCadeia(String valor)
    {
        super(valor);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof NoCadeia)
        {
            return ((NoCadeia) obj).getValor().equals(getValor());
        }

        return false;
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
        return "\"" + getValor() + "\"";
    }
}
