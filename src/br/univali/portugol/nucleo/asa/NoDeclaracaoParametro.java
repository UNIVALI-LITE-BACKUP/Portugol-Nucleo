package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoDeclaracaoParametro extends NoDeclaracao
{
    private int indice;
    private String nome;
    private TipoDado tipoDado;
    private ModoAcesso modoAcesso;
    private Quantificador quantificador;
    private TrechoCodigoFonte trechoCodigoFonteNome;
    private TrechoCodigoFonte trechoCodigoFonteTipoDado;

    public NoDeclaracaoParametro(String nome, TipoDado tipoDado, Quantificador quantificador, ModoAcesso modoAcesso)
    {
        super(nome, tipoDado, true);
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.quantificador = quantificador;
        this.modoAcesso = modoAcesso;
    }

    public int getIndice()
    {
        return indice;
    }

    @Override
    public String getNome()
    {
        return nome;
    }

    @Override
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

    @Override
    public TrechoCodigoFonte getTrechoCodigoFonteNome()
    {
        return trechoCodigoFonteNome;
    }

    @Override
    public void setTrechoCodigoFonteNome(TrechoCodigoFonte trechoCodigoFonteNome)
    {
        this.trechoCodigoFonteNome = trechoCodigoFonteNome;
    }

    @Override
    public TrechoCodigoFonte getTrechoCodigoFonteTipoDado()
    {
        return trechoCodigoFonteTipoDado;
    }

    @Override
    public void setTrechoCodigoFonteTipoDado(TrechoCodigoFonte trechoCodigoFonteTipoDado)
    {
        this.trechoCodigoFonteTipoDado = trechoCodigoFonteTipoDado;
    }

    @Override
    public void aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        visitante.visitar(this);
    }
}
