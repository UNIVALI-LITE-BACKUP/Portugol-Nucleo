package br.univali.portugol.nucleo.asa;

/**
 * Representa os parâmetros esperados em uma função.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see NoDeclaracaoFuncao
 */
public final class NoDeclaracaoParametro extends No
{
    private String nome;
    private TipoDado tipoDado;
    private int indice;
    private ModoAcesso modoAcesso;
    private Quantificador quantificador;
    private TrechoCodigoFonte trechoCodigoFonteNome;
    private TrechoCodigoFonte trechoCodigoFonteTipoDado;

    /**
     * @param nome              o nome deste parãmetro.
     * @param tipoDado          o tipo de dado deste parâmetro.
     * @param quantificador     o quantificador deste parâmetro.
     * @param modoAcesso        o modo de acesso deste parâmetro.
     * @since 1.0
     */
    public NoDeclaracaoParametro(String nome, TipoDado tipoDado, Quantificador quantificador, ModoAcesso modoAcesso)
    {
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.quantificador = quantificador;
        this.modoAcesso = modoAcesso;
    }

    /**
     * Obtém o nome do símbolo que está sendo declarado. O nome definido na declaração do símbolo será
     * o mesmo nome utilizado para acessá-lo em outros locais do código fonte.
     * 
     * @return     o nome do símbolo sendo declarado.
     * @since 1.13
     */    
    public String getNome()
    {
        return nome;
    }

    /**
     * Obtém o tipo de dado do símbolo que está sendo declarado. 
     * 
     * @return     o tipo de dado
     * @since 1.13
     */
    public TipoDado getTipoDado()
    {
        return tipoDado;
    }
    

    /**
     * Obtém o índice do parâmetro na declaração da função iniciando em 0. Isto significa que, para uma função que espera 4 parâmetros, 
     * o primeiro terá índice 0, o segundo terá índice 1, o terceiro terá índice 2 e assim por diante.
     * 
     * @return     o índice do parâmetro.
     * @since 1.0
     */    
    public int getIndice()
    {
        return indice;
    }

    /**
     * 
     * Obtém o quantificador deste parâmetro.
     * 
     * @return     o quantificador deste parâmetro.
     * @since 1.0
     */
    public Quantificador getQuantificador()
    {
        return quantificador;
    }

    /**
     * Obtém o modo de acesso deste parâmetro.
     * 
     * @return o modo de acesso deste parâmetro.
     * @since 1.0
     */
    public ModoAcesso getModoAcesso()
    {
        return modoAcesso;
    }

    /**
     * Define o índice deste parâmetro na declaração da função.
     * 
     * @param indice     o índice do parâmetro.
     * @since 1.0
     */    
    public void setIndice(int indice)
    {
        this.indice = indice;
    }
    
        /**
     * Obtém o trecho do código fonte no qual o nome do símbolo se encontra.
     * 
     * @return     o trecho do código fonte
     * @since 1.0
     */
    public TrechoCodigoFonte getTrechoCodigoFonteNome()
    {
        return trechoCodigoFonteNome;
    }

    /**
     * Define o trecho do código fonte no qual o nome do símbolo se encontra.
     * 
     * @param trechoCodigoFonteNome     Define o trecho do código fonte no qual o nome do símbolo se encontra.
     * @since 1.0
     */
    public void setTrechoCodigoFonteNome(TrechoCodigoFonte trechoCodigoFonteNome)
    {
        this.trechoCodigoFonteNome = trechoCodigoFonteNome;
    }

    /**
     * Define o trecho do código fonte no qual o tipo de dado do símbolo se encontra.
     * 
     * @param trechoCodigoFonteTipoDado    Define o trecho do código fonte no qual o tipo de dado do símbolo se encontra.
     * @since 1.0
     */
    public void setTrechoCodigoFonteTipoDado(TrechoCodigoFonte trechoCodigoFonteTipoDado)
    {
        this.trechoCodigoFonteTipoDado = trechoCodigoFonteTipoDado;
    }

    /**
     * Obtém o trecho do código fonte no qual o tipo de dado do símbolo se encontra.
     * 
     * @return     Obtém o trecho do código fonte no qual o tipo de dado do símbolo se encontra.
     */
    public TrechoCodigoFonte getTrechoCodigoFonteTipoDado()
    {
        return trechoCodigoFonteTipoDado;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
