package br.univali.portugol.nucleo.execucao.calc;

public class Maior extends Operacao
{
    
     boolean executar(Integer a, Integer b)
    {
        return a > b;
    }
    
    boolean executar(Integer a, Double b)
    {
        return a > b;
    }
    
    boolean executar(Double a, Double b)
    {
        return a > b;
    }
    
    boolean executar(Double a, Integer b)
    {
        return a > b;
    }  
    
       boolean executar(String a, String b){
        return a.compareTo(b) > 0;
    }
    
    boolean executar(Character a, Character b){
        return a.compareTo(b) > 0;
    }
    
}
