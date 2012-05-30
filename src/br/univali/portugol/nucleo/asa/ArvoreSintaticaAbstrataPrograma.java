package br.univali.portugol.nucleo.asa;

/**
 * Representa a ASA de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see ArvoreSintaticaAbstrata
 */
public final class ArvoreSintaticaAbstrataPrograma extends ArvoreSintaticaAbstrata
{
    public ArvoreSintaticaAbstrataPrograma()
    {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}