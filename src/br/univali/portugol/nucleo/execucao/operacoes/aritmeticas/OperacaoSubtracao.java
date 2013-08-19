package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoSubtracao extends Operacao
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
