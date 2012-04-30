package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class ArvoreSintaticaAbstrata
{	
    private List<NoDeclaracao> listaDeclaracoesGlobais;

    public ArvoreSintaticaAbstrata()
    {		
    }	

    public List<NoDeclaracao> getListaDeclaracoesGlobais()
    {
            return listaDeclaracoesGlobais;
    }

    public void setListaDeclaracoesGlobais(List<NoDeclaracao> listaDeclaracoesGlobais)
    {
            this.listaDeclaracoesGlobais = listaDeclaracoesGlobais;
    }
        
    public abstract Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA;
}