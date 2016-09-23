package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;
import java.util.HashMap;
import java.util.Map;

public abstract class OperacaoLogicaMaior<A, B> extends OperacaoLogica<A, B>
{
    private final static Map<Class, Map<Class, Operacao>> MAPA;

    public static OperacaoLogica getOperacao(Object operandoEsquerdo, Object operandoDireito)
    {
        return (OperacaoLogica) Operacao.getOperacao(operandoEsquerdo, operandoDireito, MAPA);
    }
    
    static {
        
        OperacaoLogica operacaoParaNumeros = new OperacaoLogica<Number, Number>()
        {
            @Override
            public Boolean executar(Number operandoEsquerdo, Number operandoDireito)
            {
                return operandoEsquerdo.doubleValue() > operandoDireito.doubleValue();
            }
        };
        
        OperacaoLogica operacaoParaCaracteres = new OperacaoLogica<Character, Character>()
        {
            @Override
            public Boolean executar(Character operandoEsquerdo, Character operandoDireito)
            {
                return operandoEsquerdo > operandoDireito;
            }
        };
        
        OperacaoLogica operacaoParaStrings = new OperacaoLogica<String, String>()
        {
            @Override
            public Boolean executar(String operandoEsquerdo, String operandoDireito)
            {
                return operandoEsquerdo.compareTo(operandoDireito) > 0;
            }
        };
        
        MAPA = new HashMap<>();
        
        // cria instâncias dos mapas usando o tipo do operando esquerdo como chave
        MAPA.put(Integer.class,     new HashMap<Class, Operacao>());
        MAPA.put(Double.class,      new HashMap<Class, Operacao>());
        MAPA.put(Character.class,   new HashMap<Class, Operacao>());
        MAPA.put(Boolean.class,     new HashMap<Class, Operacao>());
        MAPA.put(String.class,      new HashMap<Class, Operacao>());
        
        // faz o mapeamento das combinações de tipos do operando esquerdo e direito com a respectiva operação
        MAPA.get(Integer.class).put(Integer.class,      operacaoParaNumeros);
        MAPA.get(Integer.class).put(Double.class,       operacaoParaNumeros);
        
        MAPA.get(Double.class).put(Double.class,        operacaoParaNumeros);
        MAPA.get(Double.class).put(Integer.class,       operacaoParaNumeros);
        
        MAPA.get(Character.class).put(Character.class,  operacaoParaCaracteres);
        
        MAPA.get(String.class).put(String.class,        operacaoParaStrings);
    }
    
}
