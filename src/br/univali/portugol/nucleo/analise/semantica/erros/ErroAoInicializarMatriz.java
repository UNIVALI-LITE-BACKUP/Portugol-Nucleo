package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
    private static final DecimalFormat format = buildFormat();
    private static final String[] cadeias = new String[]
    {
        "barco", "estrela", "maçã", "pato", "cachorro", "gato", "leão", "azul", "vermelho", "branco", "preto", "amarelo", "banana", "árvore", "laranja", "criança", "saúde", "luz", "paz", "verde", "marrom", "rosa", "tio", "tia", "pai", "mãe", "professor", "aluno"
    };

    private static final int minimoInteiro = -50;
    private static final int maximoInteiro = 50;

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
                builder.append(obterProximoValor(matriz));

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

    private String obterProximoValor(Matriz matriz)
    {
        TipoDado tipoDado = matriz.getTipoDado();

        switch (tipoDado)
        {
            case INTEIRO:
                return Integer.toString(minimoInteiro + rnd.nextInt(maximoInteiro + 1 - minimoInteiro));
            case CARACTER:
                return "'" + ((char) (65 + rnd.nextInt(26))) + "'";
            case REAL:
                return format.format(rnd.nextFloat() * rnd.nextInt(101));
            case CADEIA:
                return "\"" + cadeias[rnd.nextInt(cadeias.length)] + "\"";
            case LOGICO:
            {
                int valor = rnd.nextInt(2);

                if (valor == 0)
                {
                    return "falso";
                }
                else
                {
                    return "verdadeiro";
                }
            }
        }

        return "?";
    }

    private static DecimalFormat buildFormat()
    {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');

        return new DecimalFormat("0.00", symbols);
    }
}
