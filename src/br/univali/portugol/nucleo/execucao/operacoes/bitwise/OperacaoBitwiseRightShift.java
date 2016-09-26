package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public abstract class OperacaoBitwiseRightShift extends Operacao<Integer, Integer, Integer>
{

    private final static OperacaoBitwiseRightShift OPERACAO = new OperacaoBitwiseRightShift()
    {
        @Override
        public Integer executar(Integer a, Integer b)
        {
            return a >> b;
        }
    };
    
    public static OperacaoBitwiseRightShift getOperacao()
    {
        return OPERACAO;
    }
        
}
