package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * Representa a ASA de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see ASA
 */
public final class ASAPrograma extends ASA
{
    private List<NoInclusaoBiblioteca> listaInclusoesBibliotecas;
    
    public ASAPrograma()
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