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
    public Variavel(String nome, TipoDado tipoDado, NoDeclaracao declaracaoOrigem)
    {
        super(nome, tipoDado, declaracaoOrigem);
    }
}
