package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public abstract class OperacaoBitwiseLeftShift extends Operacao<Integer, Integer, Integer>
{

    private final static OperacaoBitwiseLeftShift OPERACAO = new OperacaoBitwiseLeftShift()
    {
        @Override
        public Integer executar(Integer a, Integer b)
        {
            return a << b;
        }
    };
    
    public static OperacaoBitwiseLeftShift getOperacao()
    {
        return OPERACAO;
    }
        
}
