package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public abstract class OperacaoBitwiseOu extends Operacao<Integer, Integer, Integer>
{

    private final static OperacaoBitwiseOu OPERACAO = new OperacaoBitwiseOu()
    {
        @Override
        public Integer executar(Integer a, Integer b)
        {
            return a | b;
        }
    };
    
    public static OperacaoBitwiseOu getOperacao()
    {
        return OPERACAO;
    }
        
}
