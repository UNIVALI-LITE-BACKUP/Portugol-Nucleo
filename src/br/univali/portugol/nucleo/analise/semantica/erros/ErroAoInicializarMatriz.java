package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import java.util.Random;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noschang
 * @since 03/07/2016
 */
public class ErroAoInicializarMatriz extends ErroSemantico
{
    private static final Random rnd = new Random(System.currentTimeMillis());
    private static final int minimo = -50;
    private static final int maximo = 50;

    private final int numeroLinhas;
    private final int numeroColunas;
    private final Matriz matriz;

    public ErroAoInicializarMatriz(Matriz matriz, TrechoCodigoFonte trechoCodigoFonte, int numeroLinhas, int numeroColunas)
    {
        super(trechoCodigoFonte);
        this.matriz = matriz;
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("A matriz '%s' deve ser inicializada com uma matriz literal. Exemplo: ", matriz.getNome()));

        builder.append(matriz.getTipoDado().getNome());
        builder.append(" ");
        builder.append(matriz.getNome());

        if (numeroLinhas == 0 || numeroColunas == 0)
        {
            builder.append("[][]");
        }
        else
        {
            builder.append("[");
            builder.append(numeroLinhas);
            builder.append("][");
            builder.append(numeroColunas);
            builder.append("]");
        }

        builder.append(" = {");

        int maximoLinhas = (numeroLinhas > 3 || numeroLinhas == 0) ? 3 : numeroLinhas;
        int maximoColunas = (numeroColunas > 3 || numeroColunas == 0) ? 3 : numeroColunas;

        for (int i = 0; i < maximoLinhas; i++)
        {
            builder.append("{");
            
            for (int j = 0; j < maximoColunas; j++)
            {
                int valor = minimo + rnd.nextInt(maximo + 1 - minimo);

                builder.append(valor);

                if (j < maximoColunas - 1)
                {
                    builder.append(", ");
                }
                else
                {
                    if (numeroColunas > 3)
                    {
                        builder.append(", ...");
                    }
                }
            }
            
            if (i < maximoLinhas - 1)
            {
                builder.append("}, ");
            }
            else
            {
                if (numeroLinhas > 3)
                {
                    builder.append("}, ... }");
                }
                else
                {
                    builder.append("}}");
                }
            }
        }

        return builder.toString();
    }
}
