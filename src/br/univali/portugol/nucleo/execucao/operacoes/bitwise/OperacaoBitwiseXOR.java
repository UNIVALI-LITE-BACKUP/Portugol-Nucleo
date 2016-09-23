package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public abstract class OperacaoBitwiseXOR extends Operacao<Integer, Integer, Integer>
{

    private final static OperacaoBitwiseXOR OPERACAO = new OperacaoBitwiseXOR()
    {
        @Override
        public Integer executar(Integer a, Integer b)
        {
            return a ^ b;
        }
    };
    
    public static OperacaoBitwiseXOR getOperacao()
    {
        return OPERACAO;
    }
        
}
