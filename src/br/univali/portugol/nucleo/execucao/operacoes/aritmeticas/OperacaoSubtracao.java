package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;
import java.util.HashMap;
import java.util.Map;

public abstract class OperacaoSubtracao<A extends Number, B extends Number> 
                            extends OperacaoAritmetica<A, B>
{
    private final static Map<Class, Map<Class, Operacao>> MAPA;
    
    public static OperacaoAritmetica getOperacao(Object operandoEsquerdo, Object operandoDireito)
    {
        return (OperacaoAritmetica) Operacao.getOperacao(operandoEsquerdo, operandoDireito, MAPA);
    }

    static {
        
        OperacaoSubtracao operacaoParaInteiros = new OperacaoSubtracao<Integer, Integer>()
        {
            @Override
            public Number executar(Integer a, Integer b)
            {
                return a-b;
            }
        };
        
        OperacaoSubtracao operacaoGenerica = new OperacaoSubtracao<Number, Number>()
        {
            @Override
            public Number executar(Number a, Number b)
            {
                return a.doubleValue() - b.doubleValue();
            }
        };
        
        MAPA = new HashMap<>();
        
        // cria instâncias dos mapas usando o tipo do operando esquerdo como chave
        MAPA.put(Integer.class,     new HashMap<Class, Operacao>());
        MAPA.put(Double.class,      new HashMap<Class, Operacao>());
        
        // faz o mapeamento das combinações de tipos do operando esquerdo e direito com a respectiva operação
        MAPA.get(Integer.class).put(Integer.class,      operacaoParaInteiros);
        MAPA.get(Integer.class).put(Double.class,       operacaoGenerica);
        
        MAPA.get(Double.class).put(Double.class,        operacaoGenerica);
        MAPA.get(Double.class).put(Integer.class,       operacaoGenerica);
    }
    

}
