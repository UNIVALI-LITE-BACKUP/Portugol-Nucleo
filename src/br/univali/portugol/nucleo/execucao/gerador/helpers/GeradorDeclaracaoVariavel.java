package br.univali.portugol.nucleo.execucao.gerador.helpers;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoExpressaoLiteral;
import br.univali.portugol.nucleo.asa.NoMatriz;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorDeclaracaoVariavel
{

    public void gera(NoMatriz matriz, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        saida.append("{");

        List<List<Object>> valores = matriz.getValores();
        int totalLinhas = valores.size();
        int totalColunas = 0;
        for (int i = 0; i < totalLinhas; i++)
        {
            totalColunas = valores.get(i).size();
            saida.append("{");
            for (int j = 0; j < totalColunas; j++)
            {
                saida.append(valores.get(i).get(j).toString());
                if (j < totalColunas - 1)
                {
                    saida.append(", ");
                }
            }
            saida.append("}");
            if (i < totalLinhas - 1)
            {
                saida.append(",");
            }
        }

        saida.append("}");
    }

    public void gera(NoVetor vetor, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        saida.append("{");

        List<Object> valores = vetor.getValores();
        int totalValores = valores.size();
        for (int i = 0; i < totalValores; i++)
        {
            if (valores.get(i) instanceof NoExpressaoLiteral)
            {
                saida.append(valores.get(i).toString());
            }
            else
            {
                ((NoExpressao) valores.get(i)).aceitar(visitor);
            }

            if (i < totalValores - 1)
            {
                saida.append(", ");
            }
        }

        saida.append("}");
    }

    public void gera(NoDeclaracaoVetor vetor, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        String nome = vetor.getNome();
        String tipo = Utils.getNomeTipoJava(vetor.getTipoDado());
        saida.format("%s %s[]", tipo, Utils.geraNomeValido(nome));

        if (vetor.possuiInicializacao())
        {
            saida.append(" = ");
            vetor.getInicializacao().aceitar(visitor);
        }
        else
        {
            saida.format(" = new %s[", tipo);
            if (vetor.getTamanho() != null)
            {
                vetor.getTamanho().aceitar(visitor);
            }
            saida.append("]");
        }

    }

    public void gera(NoDeclaracaoMatriz matriz, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        String nome = matriz.getNome();
        String tipo = Utils.getNomeTipoJava(matriz.getTipoDado());
        saida.format("%s %s[][]", tipo, Utils.geraNomeValido(nome));

        saida.append(" = ");

        if (matriz.possuiInicializacao())
        {
            matriz.getInicializacao().aceitar(visitor);
        }
        else
        {
            saida.append(" new ")
                    .append(tipo)
                    .append("[");

            if (matriz.getNumeroLinhas() != null)
            {
                matriz.getNumeroLinhas().aceitar(visitor);
            }

            saida.append("][");

            if (matriz.getNumeroColunas() != null)
            {
                matriz.getNumeroColunas().aceitar(visitor);
            }

            saida.append("]");
        }

    }

    public void gera(NoDeclaracaoVariavel variavel, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        String nome = variavel.getNome();
        String nomeTipo = Utils.getNomeTipoJava(variavel.getTipoDado());

        saida.format("%s %s", nomeTipo, Utils.geraNomeValido(nome));

        if (variavel.possuiInicializacao())
        {
            saida.append(" = ");

            // verifica se é necessário fazer cast de um double para int quando o parâmetro esperado é int
            boolean precisaDeCast = variavel.getTipoDado() == TipoDado.INTEIRO && variavel.getInicializacao().getTipoResultante() == TipoDado.REAL;

            if (precisaDeCast)
            {
                saida.append("(int) (");
            }

            variavel.getInicializacao().aceitar(visitor);

            if (precisaDeCast)
            {
                saida.append(")");
            }
        }

    }

}
