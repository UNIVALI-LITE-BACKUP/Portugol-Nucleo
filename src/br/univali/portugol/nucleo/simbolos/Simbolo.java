package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class Simbolo
{
	private String nome;
	private TipoDado tipoDado;

	private TrechoCodigoFonte trechoCodigoFonteNome;
	private TrechoCodigoFonte trechoCodigoFonteTipoDado;
	
	private boolean constante = false;
	private boolean utilizado = false;
	private boolean inicializado = false;
	private boolean redeclarado = false;
	
	
	public Simbolo(String nome, TipoDado tipoDado)
	{
		setNome(nome);
		setTipoDado(tipoDado);
	}

	public final String getNome()
	{
		return nome;
	}	
	
	public final TipoDado getTipoDado()
	{
		return tipoDado;
	}
	
	public final boolean inicializado()
	{
		return inicializado;
	}
	
	public final boolean utilizado()
	{
		return utilizado;
	}
	
	public final boolean redeclarado()
	{
		return redeclarado;
	}

	public final boolean constante()
	{
		return constante;
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
	
    private void setNome(String nome)
	{
		this.nome = nome;
	}
	
	private void setTipoDado(TipoDado tipoDado)
	{
		this.tipoDado = tipoDado;
	}
	
	public final void setInicializado(boolean inicializado)
	{
		this.inicializado = inicializado;
	}
	
	public final void setUtilizado(boolean utilizado)
	{
		this.utilizado = utilizado;
	}
	
	public final void setRedeclarado(boolean redeclarado)
	{
		this.redeclarado = redeclarado;
	}
	
	public final void setConstante(boolean constante)
	{
		this.constante = constante;
	}
	
	public abstract Simbolo copiar(String novoNome);
}
