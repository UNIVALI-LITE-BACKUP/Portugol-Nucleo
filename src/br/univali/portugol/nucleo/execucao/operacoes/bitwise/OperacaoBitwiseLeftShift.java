package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.OperacaoAntiga;

public class OperacaoBitwiseLeftShift extends OperacaoAntiga
{

    public Integer executar(Integer a, Integer b)
    {
        return a << b;
    }
        
}
