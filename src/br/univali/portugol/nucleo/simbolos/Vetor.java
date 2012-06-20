package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.TipoDado;
import java.util.List;

/**
 * Representa um vator alocado em memória durante a execução de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class Vetor extends Simbolo
{
    private int tamanho;
    private Object[] valores;

    /**
     * Aloca um vetor em memória sem definir seu tamanho nem seus valores.
     * 
     * @param nome         o nome deste vetor.
     * @param tipoDado     o tipo de dado armazenado por este vetor.
     * @since 1.0
     */
    private Vetor(String nome, TipoDado tipoDado)
    {
        super(nome, tipoDado);
        setInicializado(true);
    }
    
    
    /**
     * Aloca um vetor em memória definindo seu tamanho, mas sem definir seus valores.
     * 
     * @param nome              o nome deste vetor.
     * @param tipoDado          o tipo de dado armazenado por este vetor.
     * @param tamanho           o tamamho que este vetor terá.
     * @since 1.0
     */
    public Vetor(String nome, TipoDado tipoDado, int tamanho)
    {
        super(nome, tipoDado);
        inicializarComTamanho(tamanho);
        setInicializado(true);
    }

    /**
     * Aloca um vetor em memória definindo seu tamanho e seus valores.
     * 
     * @param nome              o nome deste vetor.
     * @param tipoDado          o tipo de dado armazenado por este vetor.
     * @param tamanho           o tamamho que este vetor terá.
     * @param valores           os valores que serão armazenados neste vetor.
     * @since 1.0
     */    
    public Vetor(String nome, TipoDado tipoDado, int tamanho, List<Object> valores)
    {
        super(nome, tipoDado);
        inicializarComTamanhoValores(tamanho, valores);
        setInicializado(true);
    }

    /**
     * Aloca um vetor em memória definindo seus valores, mas sem definir seu tamanho.
     * O tamanho do vetor será detectado automaticamente a partir da lista de valores.
     * 
     * @param nome              o nome deste vetor.
     * @param tipoDado          o tipo de dado armazenado por este vetor.
     * @param valores           os valores que serão armazenados neste vetor.
     * @since 1.0
     */        
    public Vetor(String nome, TipoDado tipoDado, List<Object> valores)
    {
        super(nome, tipoDado);
        inicializarComValores(valores);
        setInicializado(true);
    }
    
    /**
     * Obtém o tamanho deste vetor.
     * 
     * @return     o tamanho deste vetor.
     * @since 1.0
     */
    public int getTamanho()
    {
        return tamanho;
    }

    /**
     * Recupera um valor armazenado neste vetor no índice esecificado.
     * 
     * @param indice     o índice deste vetor no qual o valor se encontra.
     * @return           o valor armazenado neste vetor no índice especificado.
     * @since 1.0
     */
    public Object getValor(int indice)
    {
        setUtilizado(true);
        return valores[indice];
    }

    /**
     * Armazena um valor neste vetor no índice esecificado.
     * 
     * @param indice     o índice deste vetor no qual o valor será armazenado.
     * @param valor      o valor que será armazenado neste vetor no índice especificado.
     * @since 1.0
     */
    public void setValor(int indice, Object valor)
    {
        this.valores[indice] = valor;
    }

    private void inicializarComTamanho(int tamanho)
    {
        Object valorPadrao = getTipoDado().getValorPadrao();

        this.tamanho = tamanho;
        valores = new Object[tamanho];

        for (int i = 0; i < tamanho; i++)
        {
            valores[i] = valorPadrao;
        }
    }

    private void inicializarComTamanhoValores(int tamanho, List<Object> valores)
    {
        Object valorPadrao = getTipoDado().getValorPadrao();

        this.tamanho = tamanho;
        this.valores = new Object[tamanho];

        for (int i = 0; i < tamanho; i++)
        {
            try
            {
                this.valores[i] = obterValor(valores.get(i));
            }
            catch (Exception e)
            {
                this.valores[i] = valorPadrao;
            }
        }
    }

    private void inicializarComValores(List<Object> valores)
    {
        inicializarComTamanhoValores(valores.size(), valores);
    }

    private Object obterValor(Object valor)
    {
        return (valor == null) ? getTipoDado().getValorPadrao() : valor;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public Vetor copiar(String novoNome)
    {
        Vetor vetor = new Vetor(novoNome, getTipoDado());
        vetor.tamanho = tamanho;
        vetor.valores = valores.clone();

        return vetor;
    }
}
