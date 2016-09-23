package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;
import java.util.HashMap;
import java.util.Map;

public abstract class OperacaoSoma<A, B, R> extends Operacao<A, B, R>
{
    private final static Map<Class, Map<Class, Operacao>> MAPA;

    public static OperacaoSoma getOperacao(Object operandoEsquerdo, Object operandoDireito)
    {
        return (OperacaoSoma) Operacao.getOperacao(operandoEsquerdo, operandoDireito, MAPA);
    }

    static
    {

        OperacaoSoma operacaoParaInteiros = new OperacaoSoma<Integer, Integer, Integer>()
        {
            @Override
            public Integer executar(Integer a, Integer b)
            {
                return a + b;
            }
        };
        
        OperacaoSoma operacaoNumericaGenerica = new OperacaoSoma<Number, Number, Number>()
        {
            @Override
            public Number executar(Number a, Number b)
            {
                return a.doubleValue() + b.doubleValue();
            }
        };
        
        OperacaoSoma operacaoConcatenacaoGenerica = new OperacaoSoma<Object, Object, String>()
        {
            @Override
            public String executar(Object a, Object b)
            {
                return a.toString() + b.toString();
            }
        };
        
        OperacaoSoma operacaoStringLogico = new OperacaoSoma<String, Boolean, String>()
        {
            @Override
            public String executar(String a, Boolean b)
            {
                return a + (b ? "verdadeiro" : "falso");
            }
        };
        
        OperacaoSoma operacaoLogicoString = new OperacaoSoma<Boolean, String, String>()
        {
            @Override
            public String executar(Boolean a, String b)
            {
                return (a ? "verdadeiro" : "falso") + b;
            }
        };

        MAPA = new HashMap<>();

        // cria instâncias dos mapas usando o tipo do operando esquerdo como chave
        MAPA.put(Integer.class, new HashMap<Class, Operacao>());
        MAPA.put(Double.class, new HashMap<Class, Operacao>());
        MAPA.put(Boolean.class, new HashMap<Class, Operacao>());
        MAPA.put(Character.class, new HashMap<Class, Operacao>());
        MAPA.put(String.class, new HashMap<Class, Operacao>());

        // faz o mapeamento das combinações de tipos do operando esquerdo e direito com a respectiva operação
        MAPA.get(Boolean.class).put(String.class, operacaoLogicoString);
        MAPA.get(String.class).put(Boolean.class, operacaoStringLogico);
        
        MAPA.get(Integer.class).put(Integer.class, operacaoParaInteiros);
        MAPA.get(Integer.class).put(Double.class, operacaoNumericaGenerica);
        MAPA.get(Double.class).put(Double.class, operacaoNumericaGenerica);
        MAPA.get(Double.class).put(Integer.class, operacaoNumericaGenerica);
        
        MAPA.get(Double.class).put(String.class, operacaoConcatenacaoGenerica);
        MAPA.get(String.class).put(Double.class, operacaoConcatenacaoGenerica);
        MAPA.get(Character.class).put(Character.class, operacaoConcatenacaoGenerica);
        MAPA.get(String.class).put(Character.class, operacaoConcatenacaoGenerica);
        MAPA.get(Character.class).put(String.class, operacaoConcatenacaoGenerica);
        MAPA.get(String.class).put(String.class, operacaoConcatenacaoGenerica);
        MAPA.get(Integer.class).put(String.class, operacaoConcatenacaoGenerica);
        MAPA.get(String.class).put(Integer.class, operacaoConcatenacaoGenerica);
    }
    

    
}
