package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoPare extends NoBloco
{
    
    @Override
    public void aceitar(VisitanteASA visitor)
    {
        visitor.visitar(this);
    }

}
