package br.univali.portugol.nucleo.execucao.calc;

public class Comparador extends Operacao
{

     boolean executar(Integer a, Integer b)
    {
        return a.equals(b);
    }
    
    boolean executar(Integer a, Double b)
    {
        return a.equals(b.intValue());
    }
    
    boolean executar(Double a, Double b)
    {
        return a.equals(b);
    }
    
    boolean executar(Double a, Integer b)
    {
        return a.equals(b.doubleValue());
    }
        
    boolean executar(Character a, Character b)
    {
        return a.equals(b);
    }
            
    boolean executar(String a, String b)
    {
        return a.equals(b);
    }
    
    boolean executar(Boolean a, Boolean b)
    {
        return a.equals(b);
    }

    
}
