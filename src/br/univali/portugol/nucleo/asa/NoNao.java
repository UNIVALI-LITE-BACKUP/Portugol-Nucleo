package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoNao extends NoExpressao
{
	private NoExpressao expressao;
	
	public NoNao(NoExpressao expressao)
	{
		this.expressao = expressao;
	}
	
	public NoExpressao getExpressao()
	{
		return expressao;
	}
	
	@Override
	protected TrechoCodigoFonte montarTrechoCodigoFonte()
	{
		return null;
	}
}
