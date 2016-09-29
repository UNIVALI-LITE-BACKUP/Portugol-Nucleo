package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Luiz Fernando Noschang
 */
public abstract class NoDeclaracaoInicializavel extends NoDeclaracao
{
    private NoExpressao inicializacao;

    public NoDeclaracaoInicializavel(String nome, TipoDado tipoDado, boolean constante)
    {
        super(nome, tipoDado, constante);
    }

    /**
     * Obtém a expressão utilizada para inicializar o símbolo declarado.
     *
     * @return a expressão de inicialização.
     *
     * @since 1.0
     */
    public final NoExpressao getInicializacao()
    {
        return inicializacao;
    }
    
    public boolean possuiInicializacao()
    {
        return inicializacao != null;
    }

    /**
     * Define a expressão de inicialização do símbolo.
     *
     * @param inicializacao a expressão de inicialização.
     *
     * @since 1.0
     */
    public final void setInicializacao(NoExpressao inicializacao)
    {
        this.inicializacao = inicializacao;
    }
}
