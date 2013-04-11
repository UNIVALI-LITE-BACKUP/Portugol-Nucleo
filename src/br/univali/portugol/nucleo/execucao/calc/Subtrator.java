package br.univali.portugol.nucleo.execucao.calc;

public class Subtrator extends Operacao
{
    
     public Integer executar(Integer operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo - operandoDireito;
    }
    
    public Double executar(Integer operandoEsquerdo, Double operandoDireito){
        return operandoEsquerdo - operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo - operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Double operandoDireito){
        return operandoEsquerdo - operandoDireito;
    }
    
}
