package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoChamadaFuncao extends NoReferencia
{
	private List<NoExpressao> parametros;	
	
	public NoChamadaFuncao(String nome)
	{
		super(nome);
	}
	
	public List<NoExpressao> getParametros()
	{
		return parametros;
	}
	
	public void setParametros(List<NoExpressao> parametros)
	{
		this.parametros = parametros;
	}	
	
	@Override
	protected TrechoCodigoFonte montarTrechoCodigoFonte()
	{
		int tamanhoTexto = 0;
		
		int linha = getTrechoCodigoFonteNome().getLinha();
		int coluna = getTrechoCodigoFonteNome().getColuna();
		
		tamanhoTexto = tamanhoTexto + getTrechoCodigoFonteNome().getTamanhoTexto() + 2;
		
		if (parametros != null)
		{
			for (NoExpressao parametro: parametros)
				tamanhoTexto = tamanhoTexto + parametro.getReferenciaCodigo().getTamanhoTexto();
		}
		
		return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
	}
}