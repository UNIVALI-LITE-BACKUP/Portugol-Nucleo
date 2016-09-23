package br.univali.portugol.nucleo.execucao.operacoes;

import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogica;
import java.util.Map;

/**
 * @author Elieser
 * @param <A> Tipo do operando esquerdo
 * @param <B> Tipo do operando direito
 * @param <R> Tipo de retorno da operação
 */
public abstract class Operacao<A, B, R>
{
    public abstract R executar(A operandoEsquerdo, B operandoDireito);
    
    protected static Operacao getOperacao(Object operandoEsquerdo, Object operandoDireito, Map<Class, Map<Class, Operacao>> mapa)
    {
        Class classOpEsquerdo = operandoEsquerdo.getClass();
        Class classOpDireito = operandoDireito.getClass();
        if (mapa.containsKey(classOpEsquerdo))
        {
            Operacao operacao = mapa.get(classOpEsquerdo).get(classOpDireito);
            if (operacao != null)
            {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Tipos não mapeados " + classOpEsquerdo.getName() + " e " + classOpDireito.getName());
    }
}
