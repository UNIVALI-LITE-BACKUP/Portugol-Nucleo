package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import java.util.Map;

/**
 * @author Elieser
 */
public abstract class OperacaoAritmetica<A, B>
{
    public abstract Number executar(A operandoEsquerdo, B operandoDireito);
    
    protected static OperacaoAritmetica getOperacao(Object operandoEsquerdo, Object operandoDireito, Map<Class, Map<Class, OperacaoAritmetica>> mapa)
    {
        Class classOpEsquerdo = operandoEsquerdo.getClass();
        Class classOpDireito = operandoDireito.getClass();
        if (mapa.containsKey(classOpEsquerdo))
        {
            OperacaoAritmetica operacao = mapa.get(classOpEsquerdo).get(classOpDireito);
            if (operacao != null)
            {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Tipos não mapeados " + classOpEsquerdo.getName() + " e " + classOpDireito.getName());
    }
}
