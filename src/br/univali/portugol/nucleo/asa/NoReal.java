package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoReal extends NoExpressao
{
	private double valor;
	private TrechoCodigoFonte trechoCodigoFonte;
	
	public NoReal(double valor)
	{
		this.valor = valor;
	}
	
	public double getValor()
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
}
