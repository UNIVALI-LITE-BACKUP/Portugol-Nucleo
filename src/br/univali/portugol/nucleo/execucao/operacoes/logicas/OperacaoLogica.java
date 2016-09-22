package br.univali.portugol.nucleo.execucao.operacoes.logicas;

/**
 * @author Elieser
 */
public interface OperacaoLogica<A, B>
{
    boolean executar(A operandoEsquerdo, B operandoDireito);
}
