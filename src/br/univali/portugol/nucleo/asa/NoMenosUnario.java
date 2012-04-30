package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoMenosUnario extends NoExpressao
{
    private NoExpressao expressao;
    private TrechoCodigoFonte tokenMenos;

    public NoMenosUnario(NoExpressao expressao)
    {
        this.expressao = expressao;
    }

    public NoExpressao getExpressao()
    {
        return expressao;
    }

    public TrechoCodigoFonte getTokenMenos()
    {
        return tokenMenos;
    }

    public void setTokenMenos(TrechoCodigoFonte tokenMenos)
    {
        this.tokenMenos = tokenMenos;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return expressao.getReferenciaCodigo();
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
