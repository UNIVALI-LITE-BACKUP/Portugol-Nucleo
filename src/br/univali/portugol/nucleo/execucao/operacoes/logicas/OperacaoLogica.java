package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import java.util.Map;

/**
 * @author Elieser
 */
public abstract class OperacaoLogica<A, B>
{
    public abstract boolean executar(A operandoEsquerdo, B operandoDireito);
    
    protected static OperacaoLogica getOperacao(Object operandoEsquerdo, Object operandoDireito, Map<Class, Map<Class, OperacaoLogica>> mapa)
    {
        Class classOpEsquerdo = operandoEsquerdo.getClass();
        Class classOpDireito = operandoDireito.getClass();
        if (mapa.containsKey(classOpEsquerdo))
        {
            OperacaoLogica operacao = mapa.get(classOpEsquerdo).get(classOpDireito);
            if (operacao != null)
            {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Tipos não mapeados " + classOpEsquerdo.getName() + " e " + classOpDireito.getName());
    }
}
