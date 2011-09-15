package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public class NoParametro
{	
    public enum ModoAcesso { POR_VALOR, POR_REFERENCIA };

    private int indice;
    private String nome;
    private TipoDado tipoDado;
    private ModoAcesso modoAcesso;
    private Quantificador quantificador;

    private TrechoCodigoFonte trechoCodigoFonteNome;
    private TrechoCodigoFonte trechoCodigoFonteTipoDado;

    public NoParametro(String nome, TipoDado tipoDado, Quantificador quantificador, ModoAcesso modoAcesso)
    {
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.quantificador = quantificador;
        this.modoAcesso = modoAcesso;
    }

    public int getIndice()
    {
        return indice;
    }
	
    public String getNome()
    {
        return nome;
    }

    public TipoDado getTipoDado()
    {
        return tipoDado;
    }

    public Quantificador getQuantificador()
    {
        return quantificador;
    }

    public ModoAcesso getModoAcesso()
    {
        return modoAcesso;
    }

    public void setIndice(int indice)
    {
        this.indice = indice;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteNome()
    {
        return trechoCodigoFonteNome;
    }

    public void setTrechoCodigoFonteNome(TrechoCodigoFonte trechoCodigoFonteNome)
    {
        this.trechoCodigoFonteNome = trechoCodigoFonteNome;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteTipoDado()
    {
        return trechoCodigoFonteTipoDado;
    }

    public void setTrechoCodigoFonteTipoDado(TrechoCodigoFonte trechoCodigoFonteTipoDado)
    {
        this.trechoCodigoFonteTipoDado = trechoCodigoFonteTipoDado;
    }
}
