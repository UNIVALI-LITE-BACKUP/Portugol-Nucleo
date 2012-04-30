package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoDeclaracaoFuncao extends NoDeclaracao
{
    private List<NoBloco> blocos;
    private Quantificador quantificador;
    private List<NoDeclaracaoParametro> parametros;

    public NoDeclaracaoFuncao(String nome, TipoDado tipoDado, Quantificador quantificador)
    {
        super(nome, tipoDado, true);
        this.quantificador = quantificador;
    }

    public Quantificador getQuantificador()
    {
        return quantificador;
    }

    public List<NoBloco> getBlocos()
    {
        return blocos;
    }

    public void setBlocos(List<NoBloco> blocos)
    {
        this.blocos = blocos;
    }

    public List<NoDeclaracaoParametro> getParametros()
    {
        return parametros;
    }

    public void setParametros(List<NoDeclaracaoParametro> parametros)
    {
        this.parametros = parametros;
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
