package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoModulo extends Operacao
{
    
    public Integer executar(Integer operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo % operandoDireito;
    }
    
}
