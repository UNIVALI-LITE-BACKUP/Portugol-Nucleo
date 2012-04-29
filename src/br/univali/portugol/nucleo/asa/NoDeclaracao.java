package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public abstract class NoDeclaracao extends NoBloco
{
    private String nome;
    private boolean constante;
    private TipoDado tipoDado;
    private NoExpressao inicializacao;
    private TrechoCodigoFonte trechoCodigoFonteNome;
    private TrechoCodigoFonte trechoCodigoFonteTipoDado;

    public NoDeclaracao(String nome, TipoDado tipoDado, boolean constante)
    {
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.constante = constante;
    }

    public String getNome()
    {
        return nome;
    }

    public boolean constante()
    {
        return constante;
    }

    public TipoDado getTipoDado()
    {
        return tipoDado;
    }

    public NoExpressao getInicializacao()
    {
        return inicializacao;
    }

    public void setInicializacao(NoExpressao inicializacao)
    {
        this.inicializacao = inicializacao;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteNome()
    {
        return trechoCodigoFonteNome;
    }

    public void setTrechoCodigoFonteNome(TrechoCodigoFonte trechoCodigoFonteNome)
    {
        this.trechoCodigoFonteNome = trechoCodigoFonteNome;
    }

    public void setTrechoCodigoFonteTipoDado(TrechoCodigoFonte trechoCodigoFonteTipoDado)
    {
        this.trechoCodigoFonteTipoDado = trechoCodigoFonteTipoDado;
    }

    public TrechoCodigoFonte getTrechoCodigoFonteTipoDado()
    {
        return trechoCodigoFonteTipoDado;
    }
}
