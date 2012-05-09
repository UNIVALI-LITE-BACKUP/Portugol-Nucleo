package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */
public final class ExcecaoVisitaASA extends Exception
{
    private No no;
    private ArvoreSintaticaAbstrata arvoreSintaticaAbstrata;

    public ExcecaoVisitaASA(String mensagem, ArvoreSintaticaAbstrata arvoreSintaticaAbstrata, No no)
    {
        super(mensagem);
        this.arvoreSintaticaAbstrata = arvoreSintaticaAbstrata;
        this.no = no;
    }

    public ExcecaoVisitaASA(Throwable causa, ArvoreSintaticaAbstrata arvoreSintaticaAbstrata, No no)
    {
        super(causa);
        this.no = no;
        this.arvoreSintaticaAbstrata = arvoreSintaticaAbstrata;
    }

    public ExcecaoVisitaASA(String mensagem, Throwable causa, ArvoreSintaticaAbstrata arvoreSintaticaAbstrata, No no)
    {
        super(mensagem, causa);
        this.no = no;
        this.arvoreSintaticaAbstrata = arvoreSintaticaAbstrata;
    }

    public ArvoreSintaticaAbstrata getArvoreSintaticaAbstrata()
    {
        return arvoreSintaticaAbstrata;
    }

    public No getNo()
    {
        return no;
    }
}
