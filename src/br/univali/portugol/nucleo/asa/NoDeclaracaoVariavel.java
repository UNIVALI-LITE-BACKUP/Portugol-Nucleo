package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoDeclaracaoVariavel extends NoDeclaracao
{
    public NoDeclaracaoVariavel(String nome, TipoDado tipoDado, boolean constante)
    {
        super(nome, tipoDado, constante);
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}