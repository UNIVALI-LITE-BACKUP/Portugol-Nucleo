package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public abstract class NoReferencia extends NoExpressao
{
    private String nome;
    private TrechoCodigoFonte trechoCodigoFonteNome;

    public NoReferencia(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteNome()
    {
        return trechoCodigoFonteNome;
    }

    public void setTrechoCodigoFonteNome(TrechoCodigoFonte trechoCodigoFonteNome)
    {
        this.trechoCodigoFonteNome = trechoCodigoFonteNome;
    }
}
