package br.univali.portugol.nucleo.execucao.calc;

public class Modulador extends Operacao
{
    
    public Integer executar(Integer operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo % operandoDireito;
    }
    
}
