package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoLogico extends NoExpressao
{
    private boolean valor;
    private TrechoCodigoFonte trechoCodigoFonte;	
	
    public NoLogico(boolean valor)
    {
            this.valor = valor;
    }
	
    public boolean getValor()
    {
            return valor;
    }

    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;
    }
	
    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
            return trechoCodigoFonte;
    }

    @Override
    public void aceitar(VisitanteASA visitante) throws Exception
    {
        visitante.visitar(this);
    }
}
