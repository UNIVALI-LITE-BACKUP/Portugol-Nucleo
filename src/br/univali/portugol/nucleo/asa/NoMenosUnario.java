package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoMenosUnario extends NoExpressao
{
    private NoExpressao expressao;
    private TrechoCodigoFonte trechoCodigoFonteMenos;

    public NoMenosUnario(NoExpressao expressao)
    {
        this.expressao = expressao;
    }

    public NoExpressao getExpressao()
    {
        return expressao;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteMenos()
    {
        return trechoCodigoFonteMenos;
    }

    public void setTrechoCodigoFonteMenos(TrechoCodigoFonte trechoCodigoFonteMenos)
    {
        this.trechoCodigoFonteMenos = trechoCodigoFonteMenos;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return expressao.getTrechoCodigoFonte();
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
