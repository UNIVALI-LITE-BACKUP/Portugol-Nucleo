package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

/**
 * @author Elieser
 * @param <A> Tipo do operando esquerdo
 * @param <B> tipo do operando direito
 */
public abstract class OperacaoAritmetica<A extends Number, B extends Number> 
                                                extends Operacao<A, B, Number>
{
    @Override
    public abstract Number executar(A operandoEsquerdo, B operandoDireito);
}
