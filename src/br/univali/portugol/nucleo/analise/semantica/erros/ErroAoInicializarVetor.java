package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Vetor;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noschang
 */
public class ErroAoInicializarVetor extends ErroSemantico
{
    private static final Random rnd = new Random(System.currentTimeMillis());
    private static final DecimalFormat format = buildFormat();
    private static final String[] cadeias = new String[]
    {
        "barco", "estrela", "maçã", "pato", "cachorro", "gato", "leão", "azul", "vermelho", "branco", "preto", "amarelo", "banana", "árvore", "laranja", "criança", "saúde", "luz", "paz", "verde", "marrom", "rosa", "tio", "tia", "pai", "mãe", "professor", "aluno"
    };

    private static final int minimoInteiro = -50;
    private static final int maximoInteiro = 50;

    private final int tamanhoVetor;
    private final Vetor vetor;

    public ErroAoInicializarVetor(Vetor vetor, TrechoCodigoFonte trechoCodigoFonte, int tamanhoVetor)
    {
        super(trechoCodigoFonte, "ErroSemantico.ErroAoInicializarVetor");
        this.vetor = vetor;
        this.tamanhoVetor = tamanhoVetor;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("O vetor '%s' deve ser inicializado com um vetor literal. Exemplo: ", vetor.getNome()));

        builder.append(vetor.getTipoDado().getNome());
        builder.append(" ");
        builder.append(vetor.getNome());

        if (tamanhoVetor == 0)
        {
            builder.append("[]");
        }
        else
        {
            builder.append("[");
            builder.append(tamanhoVetor);
            builder.append("]");
        }

        builder.append(" = {");

        int tamanhoMaximo = (tamanhoVetor > 4 || tamanhoVetor == 0) ? 4 : tamanhoVetor;

        for (int i = 0; i < tamanhoMaximo; i++)
        {
            builder.append(obterProximoValor(vetor));

            if (i < tamanhoMaximo - 1)
            {
                builder.append(", ");
            }
        }

        if (tamanhoVetor > 4)
        {
            builder.append(", ... }");
        }
        else
        {
            builder.append("}");
        }

        return builder.toString();
    }

    private String obterProximoValor(Vetor vetor)
    {
        TipoDado tipoDado = vetor.getTipoDado();

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
