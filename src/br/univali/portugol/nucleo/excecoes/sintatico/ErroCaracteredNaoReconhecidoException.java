package br.univali.portugol.nucleo.excecoes.sintatico;

import java.io.File;

import br.univali.portugol.nucleo.excecoes.Erro;

public class ErroCaracteredNaoReconhecidoException extends Erro {

	String caractere;
	
	public ErroCaracteredNaoReconhecidoException(File arquivo, int linha, int coluna, String caractere) {
		super(arquivo, linha, coluna);
		this.caractere = caractere;
	}
	
	@Override
	protected String construirMensagem() {
		return "O caractere " + caractere + " é inválido neste local";
	}

}
