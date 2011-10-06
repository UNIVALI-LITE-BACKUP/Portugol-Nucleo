package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoFacaEnquanto extends NoBloco
{
	private List<NoBloco> blocos;
	private NoExpressao condicao;
	
	public NoFacaEnquanto(NoExpressao condicao)
	{
		this.condicao = condicao;
	}
	
	public List<NoBloco> getBlocos()
	{
		return blocos;
	}
	
	public void setBlocos(List<NoBloco> blocos)
	{
		this.blocos = blocos;
	}
	
	public NoExpressao getCondicao()
	{
		return condicao;
	}
        
    @Override
    public void aceitar(VisitanteASA visitor) 
    {
        visitor.visitar(this);
    }
}
