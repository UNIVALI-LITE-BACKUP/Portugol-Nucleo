package br.univali.portugol.nucleo.bibliotecas.base;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaMatriz<T>
{
    public T obterValor(int linha, int coluna) throws ErroExecucaoBiblioteca;
    
    public void definirValor(T valor, int linha, int coluna) throws ErroExecucaoBiblioteca;
    
    public int numeroLinhas();
    
    public int numeroColunas();
}
