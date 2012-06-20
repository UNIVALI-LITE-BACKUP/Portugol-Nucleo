package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#CARACTER} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see TipoDado
 */
public final class NoCaracter extends NoExpressao
{
    private char valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    /**
     * 
     * @param valor     o caracter representado por este nó da árvore
     * @since 1.0
     */
    public NoCaracter(char valor)
    {
        this.valor = valor;
    }

    /**
     * 
     * @return     o caracter representado por este nó da árvore
     * @since 1.0
     */
    public char getValor()
    {
        return valor;
    }

    /**
     * 
     * @param trechoCodigoFonte     o trecho do código fonte no qual o caracter se encontra
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