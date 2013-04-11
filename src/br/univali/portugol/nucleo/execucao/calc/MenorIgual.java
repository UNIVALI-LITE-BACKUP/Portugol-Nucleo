package br.univali.portugol.nucleo.execucao.calc;

public class MenorIgual extends Operacao
{
    
     boolean executar(Integer a, Integer b)
    {
        return a <= b;
    }
    
    boolean executar(Integer a, Double b)
    {
        return a <= b;
    }
    
    boolean executar(Double a, Double b)
    {
        return a <= b;
    }
    
    boolean executar(Double a, Integer b)
    {
        return a <= b;
    }  
    
}
