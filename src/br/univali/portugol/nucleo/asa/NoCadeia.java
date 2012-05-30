package br.univali.portugol.nucleo.asa;

/**
 * Representa um valor do tipo {@link TipoDado#CADEIA} no código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see TipoDado
 */
public final class NoCadeia extends NoExpressao
{
    private String valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    /**
     * @param valor     a cadeia representada por este nó da árvore
     * @since 1.0
     */    
    public NoCadeia(String valor)
    {
        this.valor = tratarCadeia(valor);
    }

    /**
     * @return     a cadeia representada por este nó da árvore
     * @since 1.0
     */
    public String getValor()
    {
        return valor;
    }

    /**
     * @param trechoCodigoFonte     o trecho do código fonte no qual a cadeia se encontra
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
     * Varre uma cadeia procurando por "sequências de escape" e substituindo por seus
     * valores equivalentes.
     * <p>
     * As sequências de escape representam caracteres ou valores especiais que não podem
     * ser escritos diretamente no código-fonte, pois são interpretados de forma diferente
     * pelo parser do Portugol.
     * 
     * @param      valor a cadeia em seu formato original, como foi declarada no código fonte.
     * @return     uma nova versão da cadeia com as sequências de escape já substituídas.
     * 
     * @since 1.0
     */
    private String tratarCadeia(String valor)
    {
        valor = valor.replace("\\n", "\r\n");
        valor = valor.replace("\\\"", "\"");
        valor = valor.replace("\\t", "\t");

        return valor;
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