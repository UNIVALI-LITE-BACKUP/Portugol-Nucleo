package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class ArvoreSintaticaAbstrataPrograma extends ArvoreSintaticaAbstrata
{
    public ArvoreSintaticaAbstrataPrograma()
    {
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}