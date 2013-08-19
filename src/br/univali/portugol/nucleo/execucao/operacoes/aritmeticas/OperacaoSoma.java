package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoSoma extends Operacao
{
        
    public String executar(String operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(Integer operandoEsquerdo, String operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(String operandoEsquerdo, String operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(Character operandoEsquerdo, String operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(String operandoEsquerdo, Character operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(Character operandoEsquerdo, Character operandoDireito){
        return operandoEsquerdo + operandoDireito.toString();
    }
   
    public String executar(String operandoEsquerdo, Boolean operandoDireito){
        return operandoEsquerdo + (operandoDireito ? "verdadeiro" : "falso");
    }
    
    public String executar(Boolean operandoEsquerdo, String operandoDireito){
        return (operandoEsquerdo ? "verdadeiro" : "falso" ) + operandoDireito;
    }
    
    public String executar(String operandoEsquerdo, Double operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public String executar(Double operandoEsquerdo, String operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
           
    public Integer executar(Integer operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public Double executar(Integer operandoEsquerdo, Double operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Double operandoDireito){
        return operandoEsquerdo + operandoDireito;
    }
    
}
