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
    public void aceitar(VisitanteASA visitante) throws Exception
    {
        visitante.visitar(this);
    }
}