package br.univali.portugol.nucleo.excecoes;

import java.util.Iterator;
import java.util.List;

public class ColecaoExcecoes extends Exception implements Iterable<Exception>{

	List<Exception> execoes;
	
	public ColecaoExcecoes(List<Exception> listaExcecoes) {
		execoes = listaExcecoes;
	}	

	@Override
	public Iterator<Exception> iterator() {
		return execoes.iterator();
	}
		
}
