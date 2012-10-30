package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.TipoDado;

/**
 * Representa uma variável alocada em memória durante a execução de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @since 1.0
 */
public final class Variavel extends Simbolo
{
    private Object valor;

    /**
     * Aloca uma variável em memória sem definir seu valor.
     * 
     * @param nome         o nome desta variável.
     * @param tipoDado     o tipo de dado armazenado por esta variável.
     * @since 1.0
     */
    public Variavel(String nome, TipoDado tipoDado)
    {
        super(nome, tipoDado);
        valor = tipoDado.getValorPadrao();
    }

    /**
     * Aloca uma variável em memória inicializando-a com um valor.
     * 
     * @param nome         o nome desta variável.
     * @param tipoDado     o tipo de dado armazenado por esta variável.
     * @param valor        o valor que será armazenado na variável.
     * @since 1.0
     */
    public Variavel(String nome, TipoDado tipoDado, Object valor)
    {
        super(nome, tipoDado);
        setValor(valor);
    }

    /**
     * Obtém o valor armazenado nesta variável.
     * 
     * @return     o valor armazenado nesta variável.
     * @since 1.0
     */
    public Object getValor()
    {
        setUtilizado(true);
        return valor;
    }

    /**
     * Armazena um valor nesta variável.
     * 
     * @param value     o valor que será armazenado nesta variável
     * @since 1.0
     */
    public void setValor(Object value)
    {
        
        if ((value instanceof Double) && (tipoDado == TipoDado.INTEIRO))
        {
            double val = (Double) value;
            value = (int) val;
        }

        
        setInicializado(true);
        this.valor = value;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Variavel copiar(String novoNome)
    {
        Variavel variavel = new Variavel(novoNome, getTipoDado());
        variavel.setInicializado(true);
        variavel.valor = valor;

        return variavel;
    }
}
