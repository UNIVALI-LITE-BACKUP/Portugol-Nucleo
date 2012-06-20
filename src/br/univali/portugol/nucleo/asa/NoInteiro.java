package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#INTEIRO} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see TipoDado
 */
public final class NoInteiro extends NoExpressao
{
    private int valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    /**
     * 
     * @param valor     o número inteiro representado por este nó da árvore
     * @since 1.0
     */    
    public NoInteiro(int valor)
    {
        this.valor = valor;
    }
    
    /**
     * @return     o número inteiro representado por este nó da árvore
     * @since 1.0
     */
    public int getValor()
    {
        return valor;
    }

    /**
     * @param trechoCodigoFonte     o trecho do código fonte no qual o númeor inteiro se encontra
     * @since 1.0
     */
    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;NoInteiro a;
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
