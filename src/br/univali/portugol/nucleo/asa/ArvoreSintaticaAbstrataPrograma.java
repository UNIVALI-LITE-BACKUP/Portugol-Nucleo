package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * Representa a ASA de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see ArvoreSintaticaAbstrata
 */
public final class ArvoreSintaticaAbstrataPrograma extends ArvoreSintaticaAbstrata
{
    private List<NoInclusaoBiblioteca> listaInclusoesBibliotecas;
    
    public ArvoreSintaticaAbstrataPrograma()
    {
        
    }

    public List<NoInclusaoBiblioteca> getListaInclusoesBibliotecas()
    {
        return listaInclusoesBibliotecas;
    }

    public void setListaInclusoesBibliotecas(List<NoInclusaoBiblioteca> listaInclusoesBibliotecas)
    {
        this.listaInclusoesBibliotecas = listaInclusoesBibliotecas;
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