package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public abstract class OperacaoBitwiseE extends Operacao<Integer, Integer, Integer>
{

    private final static OperacaoBitwiseE OPERACAO = new OperacaoBitwiseE()
    {
        @Override
        public Integer executar(Integer a, Integer b)
        {
            return a & b;
        }
    };
    
    public static OperacaoBitwiseE getOperacao()
    {
        return OPERACAO;
    }
        
}
