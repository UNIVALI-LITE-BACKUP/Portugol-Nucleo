package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoDeclaracaoMatriz extends NoDeclaracao
{
    private NoExpressao numeroLinhas;
    private NoExpressao numeroColunas;

    public NoDeclaracaoMatriz(String nome, TipoDado tipoDado, NoExpressao numeroLinhas, NoExpressao numeroColunas, boolean constante)
    {
        super(nome, tipoDado, constante);
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
    }

    public NoExpressao getNumeroLinhas()
    {
        return numeroLinhas;
    }

    public NoExpressao getNumeroColunas()
    {
        return numeroColunas;
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
