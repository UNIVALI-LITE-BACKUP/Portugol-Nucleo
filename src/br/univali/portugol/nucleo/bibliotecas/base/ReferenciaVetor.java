package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaVetor<T>
{
    public T obterValor(int indice) throws ErroExecucao;
    
    public void definirValor(T valor, int indice) throws ErroExecucao;
    
    public int numeroElementos();
}
