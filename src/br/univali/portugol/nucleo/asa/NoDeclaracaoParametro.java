package br.univali.portugol.nucleo.asa;

/**
 * Representa os parâmetros esperados em uma função.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * @see NoDeclaracaoFuncao
 */
public final class NoDeclaracaoParametro extends NoDeclaracao
{
    private int indice;
    private ModoAcesso modoAcesso;
    private Quantificador quantificador;


    /**
     * @param nome              o nome deste parãmetro.
     * @param tipoDado          o tipo de dado deste parâmetro.
     * @param quantificador     o quantificador deste parâmetro.
     * @param modoAcesso        o modo de acesso deste parâmetro.
     * @since 1.0
     */
    public NoDeclaracaoParametro(String nome, TipoDado tipoDado, Quantificador quantificador, ModoAcesso modoAcesso)
    {
        super(nome, tipoDado, false);
        this.quantificador = quantificador;
        this.modoAcesso = modoAcesso;
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
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
