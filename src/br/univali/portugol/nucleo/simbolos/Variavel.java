package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.TipoDado;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Representa uma variável alocada em memória durante a execução de um programa.
 *
 * @author Luiz Fernando Noschang
 * @since 1.0
 */
public final class Variavel extends Simbolo
{
    private static final Map<Integer, Variavel> CACHE = new HashMap<>();
    
    private Object valor;

    public static Variavel getVariavel(String nome, TipoDado tipoDado, NoDeclaracao declaracaoOrigem)
    {
        Integer hash = geraHash(nome, tipoDado, declaracaoOrigem);
        if (!CACHE.containsKey(hash)) {
            CACHE.put(hash, new Variavel(nome, tipoDado, declaracaoOrigem));
        }
        return CACHE.get(hash);
    }
    
    public static void limpaCache()
    {
        CACHE.clear();
    }
    
    /**
     * Aloca uma variável em memória sem definir seu valor.
     *
     * @param nome o nome desta variável.
     *
     * @param tipoDado o tipo de dado armazenado por esta variável.
     *
     * @param declaracaoOrigem o nó de declaração que originou a variável
     *
     * @since 1.0
     */
    private Variavel(String nome, TipoDado tipoDado, NoDeclaracao declaracaoOrigem)
    {
        super(nome, tipoDado, declaracaoOrigem);
    }

    /**
     * Obtém o valor armazenado nesta variável.
     *
     * @return o valor armazenado nesta variável.
     *
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
     * @param valor o valor que será armazenado nesta variável
     *
     * @since 1.0
     */
    public void setValor(Object valor)
    {
        if ((valor instanceof Double) && (tipoDado == TipoDado.INTEIRO))
        {
            double val = (Double) valor;
            valor = (int) val;
        }

        else if ((valor instanceof Integer) && (tipoDado == TipoDado.REAL))
        {
            valor = ((Integer) valor).doubleValue();
        }

        setInicializado(true);
        this.valor = valor;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Variavel copiar(String novoNome)
    {
        Variavel variavel = new Variavel(novoNome, getTipoDado(), getOrigemDoSimbolo());
        variavel.setInicializado(true);
        variavel.valor = valor;

        return variavel;
    }
    
    private static Integer geraHash(String nome, TipoDado tipo, NoDeclaracao declaracao)
    {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(nome);
        hash = 23 * hash + Objects.hashCode(tipo);
        hash = 23 * hash + Objects.hashCode(declaracao);
        return hash;
    }
}
