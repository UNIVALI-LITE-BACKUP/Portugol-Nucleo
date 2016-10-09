package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Luiz Fernando Noschang
 * @param <T> Uma operação gráfica otimizada
 */
public final class CacheOperacoesGraficas<T extends OperacaoGrafica>
{
    private final OperacaoGrafica[] OPERACOES;
    private final Class<T> CLASSE_OPERACAO;

    private final int QUANTIDADE_MAXIMA;
    private final int QUANTIDADE_ALOCACAO;

    private int indiceObtencao = 0;
    private int indiceDevolucao = 0;

    public CacheOperacoesGraficas(Class<T> classeOperacao, int quantidadeMaxima, int quantidadeAlocacao)
    {
        if (quantidadeAlocacao > quantidadeMaxima)
        {
            throw new IllegalStateException("A quantidade de alocação de operações não pode ser maior que a quantidade maxima");
        }

        QUANTIDADE_MAXIMA = quantidadeMaxima;
        QUANTIDADE_ALOCACAO = quantidadeAlocacao;

        CLASSE_OPERACAO = classeOperacao;
        OPERACOES = new OperacaoGrafica[quantidadeMaxima];

        alocarOperacoes();
    }

    private void alocarOperacoes()
    {
        try
        {
            int indice = indiceObtencao;
            int posicoesVerificadas = 0;
            int operacoesAlocadas = 0;

            do
            {
                if (OPERACOES[indice] == null)
                {
                    Constructor<T> construtor = CLASSE_OPERACAO.getConstructor(CacheOperacoesGraficas.class);
                    OPERACOES[indice] = construtor.newInstance(this);
                    operacoesAlocadas++;
                }

                posicoesVerificadas++;
                indice = (indice + 1) % QUANTIDADE_MAXIMA;
                indiceDevolucao = indice;
            }
            while (operacoesAlocadas < QUANTIDADE_ALOCACAO && posicoesVerificadas < QUANTIDADE_MAXIMA);

        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException | InstantiationException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public T obter()
    {
        if (OPERACOES[indiceObtencao] == null)
        {
            alocarOperacoes();
        }

        T operacao = (T) OPERACOES[indiceObtencao];

        OPERACOES[indiceObtencao] = null;
        indiceObtencao = (indiceObtencao + 1) % QUANTIDADE_MAXIMA;

        return operacao;
    }

    public void devolver(T operacao)
    {
        int posicoesVerificadas = 0;

        do
        {
            if (OPERACOES[indiceDevolucao] == null)
            {
                OPERACOES[indiceDevolucao] = operacao;
                indiceDevolucao = (indiceDevolucao + 1) % QUANTIDADE_MAXIMA;

                return;
            }

            posicoesVerificadas++;
            indiceDevolucao = (indiceDevolucao + 1) % QUANTIDADE_MAXIMA;
        }
        while (posicoesVerificadas < QUANTIDADE_MAXIMA);
    }
}
