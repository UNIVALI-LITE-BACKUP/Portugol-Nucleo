package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoRetorne extends NoBloco
{
	private NoExpressao expressao;
	
	public NoRetorne(NoExpressao expressao)
	{
		this.expressao = expressao;
	}

	public NoExpressao getExpressao()
	{
		return expressao;
	}
}
