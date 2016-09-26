package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

public abstract class OperacaoModulo extends OperacaoAritmetica<Integer, Integer>
{
    @Override
    public abstract Integer executar(Integer operandoEsquerdo, Integer operandoDireito);
    
    private final static OperacaoModulo OPERACAO = new OperacaoModulo()
    {
        @Override
        public Integer executar(Integer operandoEsquerdo, Integer operandoDireito)
        {
            return operandoEsquerdo % operandoDireito;
        }
    };
    
    public static OperacaoModulo getOperacao()
    {
        return OPERACAO;
    }

}
