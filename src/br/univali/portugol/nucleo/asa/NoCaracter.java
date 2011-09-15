package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoCaracter extends NoExpressao
{
	private char valor;
	private TrechoCodigoFonte trechoCodigoFonte;
	
	public NoCaracter(char valor)
	{
		setValor(valor);
	}
	
	public char getValor()
	{
		return valor;
	}
	
	private void setValor(char valor)
	{
		this.valor = valor;
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