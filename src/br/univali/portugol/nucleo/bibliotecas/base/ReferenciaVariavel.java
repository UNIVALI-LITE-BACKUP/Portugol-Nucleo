package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface ReferenciaVariavel<T>
{
    public T obterValor() throws ErroExecucao;
    
    public void definirValor(T valor) throws ErroExecucao;
}
