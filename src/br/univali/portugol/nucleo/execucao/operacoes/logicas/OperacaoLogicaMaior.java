package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.execucao.operacoes.Operacao;

public class OperacaoLogicaMaior extends Operacao
{
    public boolean executar(Integer a, Integer b)
    {
        return a > b;
    }

    public boolean executar(Integer a, Double b)
    {
        return a > b;
    }

    public boolean executar(Double a, Double b)
    {
        return a > b;
    }

    public boolean executar(Double a, Integer b)
    {
        return a > b;
    }

    public boolean executar(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    public boolean executar(Character a, Character b)
    {
        return a.compareTo(b) > 0;
    }
}
