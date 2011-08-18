package br.univali.portugol.nucleo.excecoes.sintatico;

import java.io.File;

import br.univali.portugol.nucleo.excecoes.Erro;

public class ErroFalhaEmReconhecerCaracter extends Erro {

	String esperado;
	String encontrado;
	
	public ErroFalhaEmReconhecerCaracter( File arquivo, int linha, int coluna, String esperado, String encontrado) {
		super(arquivo, linha, coluna);
		this.esperado = esperado;
		this.encontrado = encontrado;
	}
	
	@Override
	protected String construirMensagem() 
	{
		StringBuilder construtorMensagem = new StringBuilder();
		
		return "Era esperado "+ this.esperado + " e foi encontrado "+ encontrado;
	}

}
