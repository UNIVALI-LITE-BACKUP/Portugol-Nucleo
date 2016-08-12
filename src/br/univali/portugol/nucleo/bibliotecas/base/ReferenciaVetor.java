package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.simbolos.Vetor;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaVetor<T>
{
    public T obterValor(int indice) throws ErroExecucaoBiblioteca;
    
    public void definirValor(T valor, int indice) throws ErroExecucaoBiblioteca;
    
    public int numeroElementos();
    
    public Vetor getVetor();
}
