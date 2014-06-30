package br.univali.portugol.nucleo.bibliotecas.base;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaVariavel<T>
{
    public T obterValor() throws ErroExecucaoBiblioteca;
    
    public void definirValor(T valor) throws ErroExecucaoBiblioteca;
}
