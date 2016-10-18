package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Elieser
 */
public class Utils
{
    public static String geraNomeValido(String nomeAtual)
    {
        if (!ehUmaPalavraReservadaNoJava(nomeAtual))
        {
            return nomeAtual;
        }

        return "_" + nomeAtual;
    }

    public static String preservaCaracteresEspeciais(String string)
    {
        return string
                .replaceAll("\n", "\\\\n") // preserva \n nas string do código Portugol 
                .replaceAll("\"", "\\\\\""); // preserva aspas duplas com scape (\") nas string do código Portugol 
    }

    public static String getNomeTipoEmCamelCase(TipoDado tipo)
    {
        return tipo.getNome().substring(0, 1).toUpperCase() + tipo.getNome().substring(1);
    }

    public static void geraNomeDaReferencia(NoReferencia no, PrintWriter saida, VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        String nome = Utils.geraNomeValido(no.getNome());
        saida.append(nome);
        if (no instanceof NoReferenciaVetor)
        {
            saida.append("[");
            NoReferenciaVetor noVetor = (NoReferenciaVetor) no;
            noVetor.getIndice().aceitar(visitor);
            saida.append("]");

        }
        else if (no instanceof NoReferenciaMatriz) //NoReferenciaMatriz
        {
            saida.append("[");
            NoReferenciaMatriz noMatriz = (NoReferenciaMatriz) no;
            noMatriz.getLinha().aceitar(visitor);
            saida.append("][");
            noMatriz.getColuna().aceitar(visitor);
            saida.append("]");
        }
    }

    public static String getNomeBiblioteca(String escopo, ASAPrograma asa)
    {
        List<NoInclusaoBiblioteca> libs = asa.getListaInclusoesBibliotecas();
        for (NoInclusaoBiblioteca lib : libs)
        {
            if (lib.getAlias() != null)
            {
                if (lib.getAlias().equals(escopo))
                {
                    return lib.getNome();
                }
            }
            else if (lib.getNome().equals(escopo))
            {
                return escopo;
            }
        }

        throw new IllegalArgumentException("Não foi possível encontrar a biblioteca para o escopo " + escopo);
    }

    private static boolean ehUmaPalavraReservadaNoJava(String nome)
    {
        return (Arrays.binarySearch(PALAVRAS_RESERVADAS_JAVA, nome) >= 0);
    }

    // lista de palavras reservadas java 'roubadas' da wikipedia e ordenadasalfabéticamente para possibilitar uma busca binária
    private static final String[] PALAVRAS_RESERVADAS_JAVA =
    {
        "assert",
        "boolean",
        "break",
        "byte",
        "case",
        "catch",
        "char",
        "class",
        "const",
        "continue",
        "default",
        "do",
        "double",
        "else",
        "enum",
        "final",
        "finally",
        "float",
        "for",
        "goto",
        "if",
        "import",
        "instanceof",
        "interface",
        "int",
        "long",
        "native",
        "new",
        "package",
        "private",
        "protected",
        "public",
        "return",
        "short",
        "static",
        "strictfp",
        "super",
        "switch",
        "synchronized",
        "this",
        "throw",
        "throws",
        "transient",
        "try",
        "void",
        "volatile",
        "while",
        "false",
        "null",
        "true"
    };
}
