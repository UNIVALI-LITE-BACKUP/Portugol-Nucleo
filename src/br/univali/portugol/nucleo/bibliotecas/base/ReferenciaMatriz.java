package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaMatriz<T>
{
    public T obterValor(int linha, int coluna) throws ErroExecucao;
    
    public void definirValor(T valor, int linha, int coluna) throws ErroExecucao;
    
    public int numeroLinhas();
    
    public int numeroColunas();
}
