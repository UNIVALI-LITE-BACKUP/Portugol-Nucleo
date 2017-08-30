package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.TipoDado;

/**
 * Representa uma matriz alocada em memória durante a execução de um programa.
 *
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class Matriz extends Simbolo
{
    private int numeroLinhas;
    private int numeroColunas;
    private Object[][] valores;
    public static final Integer TAMANHO_MAXIMO = 16777216;


    /**
     * Aloca uma matriz em memória sem definir seu tamanho nem seus valores.
     *
     * @param nome o nome desta matriz.
     *
     * @param tipoDado o tipo de dado armazenado por esta matriz.
     *
     * @param declaracaoOrigem a declaração que originou esta matriz.
     *
     * @since 1.0
     */
    public Matriz(String nome, TipoDado tipoDado, NoDeclaracao declaracaoOrigem)
    {
        super(nome, tipoDado, declaracaoOrigem);
    }

    /**
     * Aloca uma matriz em memória definindo suas dimensões, mas sem definir
     * seus valores.
     *
     * @param nome o nome desta matriz.
     *
     * @param tipoDado o tipo de dado armazenado por esta matriz.
     *
     * @param declaracaoOrigem a declaração que originou esta matriz.
     *
     * @param numeroLinhas o número de linhas que esta matriz terá.
     *
     * @param numeroColunas o número de colunas que esta matriz terá.
     *
     * @since 1.0
     */
    public Matriz(String nome, TipoDado tipoDado, NoDeclaracao declaracaoOrigem, int numeroLinhas, int numeroColunas)
    {
        super(nome, tipoDado, declaracaoOrigem);
        inicializarComDimensoes(numeroLinhas, numeroColunas);
    }

    /**
     * Obtém o número de linhas desta matriz.
     *
     * @return o número de linhas desta matriz.
     *
     * @since 1.0
     */
    public int getNumeroLinhas()
    {
        return numeroLinhas;
    }

    /**
     * Obtém o número de colunas desta matriz.
     *
     * @return o número de colunas desta matriz.
     *
     * @since 1.0
     */
    public int getNumeroColunas()
    {
        return numeroColunas;
    }

    private void inicializarComDimensoes(int numeroLinhas, int numeroColunas)
    {
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
        valores = new Object[numeroLinhas][numeroColunas];

        for (int i = 0; i < numeroLinhas; i++)
        {
            for (int j = 0; j < numeroColunas; j++)
            {
                valores[i][j] = null;
            }
        }
    }    
}
