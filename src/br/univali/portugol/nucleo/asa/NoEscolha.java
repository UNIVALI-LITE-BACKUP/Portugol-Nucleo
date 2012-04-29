package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoEscolha extends NoBloco
{
    private List<NoCaso> casos;
    private NoExpressao expressao;

    public NoEscolha(NoExpressao expressao)
    {
        this.expressao = expressao;
    }

    public NoExpressao getExpressao()
    {
        return expressao;
    }

    public List<NoCaso> getCasos()
    {
        return casos;
    }

    public void setCasos(List<NoCaso> casos)
    {
        this.casos = casos;
    }

    @Override
    public void aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        visitante.visitar(this);
    }
}
