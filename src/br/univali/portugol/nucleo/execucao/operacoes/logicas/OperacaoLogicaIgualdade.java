package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elieser
 */

public abstract class OperacaoLogicaIgualdade<A, B> implements OperacaoLogica<A, B>
{
    private final static Map<Class, Map<Class, OperacaoLogicaIgualdade>> MAPA;
    
    public static OperacaoLogica getOperacao(Object operandoEsquerdo, Object operandoDireito)
    {
        Class classOpEsquerdo = operandoEsquerdo.getClass();
        Class classOpDireito = operandoDireito.getClass();
        if (MAPA.containsKey(classOpEsquerdo))
        {
            OperacaoLogicaIgualdade operacao = MAPA.get(classOpEsquerdo).get(classOpDireito);
            if (operacao != null)
            {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Tipos não mapeados " + classOpEsquerdo.getName() + " e " + classOpDireito.getName());
    }
    
    static {
        
        OperacaoLogicaIgualdade<Object, Object> operacaoParaTiposIguais = new OperacaoLogicaIgualdade<Object, Object>()
        {
            @Override
            public boolean executar(Object a, Object b)
            {
                return a.equals(b);
            }
        };
        
        OperacaoLogicaIgualdade<Integer, Double> operacaoParaInteiroComReal = new OperacaoLogicaIgualdade<Integer, Double>()
        {
            @Override
            public boolean executar(Integer a, Double b)
            {
                return a.equals(b.intValue());
            }
        };
        
        OperacaoLogicaIgualdade<Double, Integer> operacaoParaRealComInteiro = new OperacaoLogicaIgualdade<Double, Integer>()
        {
            @Override
            public boolean executar(Double a, Integer b)
            {
                return a.equals(b.doubleValue());
            }
        };
        
        MAPA = new HashMap<>();
        
        // cria instâncias dos mapas usando o tipo do operando esquerdo como chave
        MAPA.put(Integer.class,     new HashMap<Class, OperacaoLogicaIgualdade>());
        MAPA.put(Double.class,      new HashMap<Class, OperacaoLogicaIgualdade>());
        MAPA.put(Character.class,   new HashMap<Class, OperacaoLogicaIgualdade>());
        MAPA.put(Boolean.class,     new HashMap<Class, OperacaoLogicaIgualdade>());
        MAPA.put(String.class,      new HashMap<Class, OperacaoLogicaIgualdade>());
        
        // faz o mapeamento das combinações de tipos do operando esquerdo e direito com a respectiva operação
        MAPA.get(Integer.class).put(Integer.class,      operacaoParaTiposIguais);
        MAPA.get(Integer.class).put(Double.class,       operacaoParaInteiroComReal);
        
        MAPA.get(Double.class).put(Double.class,        operacaoParaTiposIguais);
        MAPA.get(Double.class).put(Integer.class,       operacaoParaRealComInteiro);
        
        MAPA.get(Character.class).put(Character.class,  operacaoParaTiposIguais);
        
        MAPA.get(Boolean.class).put(Boolean.class,      operacaoParaTiposIguais);
        
        MAPA.get(String.class).put(String.class,        operacaoParaTiposIguais);
    }

}
