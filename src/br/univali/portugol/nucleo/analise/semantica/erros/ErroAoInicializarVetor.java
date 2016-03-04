
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Vetor;
import java.util.Random;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noschang
 */
public class ErroAoInicializarVetor extends ErroSemantico
{
    private static final Random rnd = new Random(System.currentTimeMillis());
    private static final int minimo = -50;
    private static final int maximo = 50;
    
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
            int valor = minimo + rnd.nextInt(maximo + 1 - minimo);

            builder.append(valor);

            if (i < tamanhoMaximo - 1)
            {
                builder.append(",");
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

}
