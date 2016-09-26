package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

/**
 * @author Elieser
 */
public abstract class OperacaoLogica<A, B> extends Operacao<A, B, Boolean>
{
    @Override
    public abstract Boolean executar(A operandoEsquerdo, B operandoDireito);
    
}
