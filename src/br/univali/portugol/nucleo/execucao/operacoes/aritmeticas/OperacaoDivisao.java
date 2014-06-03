package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.execucao.erros.ErroDivisaoPorZero;
import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoDivisao extends Operacao
{
    public Integer executar(Integer operandoEsquerdo, Integer operandoDireito)
    {
        return operandoEsquerdo / operandoDireito;
    }
    
    public Double executar(Integer operandoEsquerdo, Double operandoDireito) throws ErroDivisaoPorZero
    {
        verificarDivisaoZero(operandoDireito);
        
        return operandoEsquerdo / operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Integer operandoDireito) throws ErroDivisaoPorZero
    {
        verificarDivisaoZero(operandoDireito);
        
        return operandoEsquerdo / operandoDireito;
    }
    
    public Double executar(Double operandoEsquerdo, Double operandoDireito) throws ErroDivisaoPorZero
    {
        verificarDivisaoZero(operandoDireito);
        
        return operandoEsquerdo / operandoDireito;
    }
    
    private void verificarDivisaoZero(Object operandoDireito) throws ErroDivisaoPorZero
    {
        if (operandoDireito.equals(0) || operandoDireito.equals(0.0))
        {
            throw new ErroDivisaoPorZero();
        }
    }    
}
