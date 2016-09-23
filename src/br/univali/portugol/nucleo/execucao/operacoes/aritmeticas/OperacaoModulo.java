package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.operacoes.OperacaoAntiga;

public class OperacaoModulo extends OperacaoAntiga
{
    
    public Integer executar(Integer operandoEsquerdo, Integer operandoDireito){
        return operandoEsquerdo % operandoDireito;
    }
    
}
