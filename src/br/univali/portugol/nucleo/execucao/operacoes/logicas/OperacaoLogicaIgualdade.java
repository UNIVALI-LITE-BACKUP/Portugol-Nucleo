package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoLogicaIgualdade extends Operacao
{
    public boolean executar(Integer a, Integer b)
    {
        return a.equals(b);
    }

    public boolean executar(Integer a, Double b)
    {
        return a.equals(b.intValue());
    }

    public boolean executar(Double a, Double b)
    {
        return a.equals(b);
    }

    public boolean executar(Double a, Integer b)
    {
        return a.equals(b.doubleValue());
    }

    public boolean executar(Character a, Character b)
    {
        return a.equals(b);
    }

    public boolean executar(String a, String b)
    {
        return a.equals(b);
    }

    public boolean executar(Boolean a, Boolean b)
    {
        return a.equals(b);
    }
}
