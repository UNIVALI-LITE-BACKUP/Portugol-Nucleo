package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class TrechoCodigoFonte
{
	private int linha;
	private int coluna;
	private int tamanhoTexto;
	
	public TrechoCodigoFonte(int linha, int coluna, int tamanhoTexto)
	{
		this.linha = linha;
		this.coluna = coluna;
		this.tamanhoTexto = tamanhoTexto;
	}

	public int getColuna()
	{
		return coluna;
	}

	public int getLinha()
	{
		return linha;
	}

	public int getTamanhoTexto()
	{
		return tamanhoTexto;
	}
}