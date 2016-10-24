package br.univali.portugol.nucleo.execucao.gerador.helpers;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Elieser
 */
public class Utils
{
    
    private static long seedNomes = System.currentTimeMillis();

    public static void setSeedGeracaoNomesValidos(long seed)
    {
        seedNomes = seed;
    }
    
    public static String geraStringIndice(NoReferenciaVariavel variavel)
    {
        assert(variavel.ehPassadoPorReferencia());
        return geraStringIndice(variavel.getIndiceReferencia(), variavel.getNome());
    }
    
    public static String geraStringIndice(NoDeclaracaoVariavel variavel)
    {
        assert(variavel.ehPassadoPorReferencia());
        return geraStringIndice(variavel.getIndiceReferencia(), variavel.getNome());
    }
    
    private static String geraStringIndice(int indice, String nome)
    {
        return String.format("INDICE_%s_%d", nome.toUpperCase(), indice);
    }
    
    public static void visitarBlocos(List<NoBloco> blocos, PrintWriter saida, VisitanteASA visitor, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario) throws ExcecaoVisitaASA
    {
        for (NoBloco bloco : blocos)
        {
            geraParadaPassoAPasso(bloco, saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

            saida.append(Utils.geraIdentacao(nivelEscopo));

            bloco.aceitar(visitor);

            if (blocoFinalizaComPontoEVirgula(bloco))
            {
                saida.append(";");
            }
            saida.println();
        }
    }

    public static String getNomeTipoJava(TipoDado tipoPortugol)
    {
        switch (tipoPortugol)
        {
            case INTEIRO:
                return "int";
            case REAL:
                return "double";
            case CADEIA:
                return "String";
            case CARACTER:
                return "char";
            case LOGICO:
                return "boolean";
            case VAZIO:
                return "void";
        }

        String mensagem = String.format("Não foi possível traduzir o tipo %s do Portugol para um tipo JAva.", tipoPortugol.getNome());
        throw new IllegalStateException(mensagem);
    }

    public static void geraVerificacaoThreadInterrompida(PrintWriter saida, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario)
    {
        if (gerandoCodigoParaTesteUnitario)
        {
            return;
        }
        saida.append(Utils.geraIdentacao(nivelEscopo));
        saida.append("if (Thread.currentThread().isInterrupted()) {throw new InterruptedException();}");
        saida.println();
        saida.println();
    }

    public static void geraParadaPassoAPasso(NoBloco no, PrintWriter saida, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario)
    {
        if (gerandoCodigoParaTesteUnitario)
        {
            return;
        }

        if (no.ehParavel(Programa.Estado.STEP_OVER))
        {
            if (no instanceof NoSe || no instanceof NoEnquanto)
            {
                int linha;
                int coluna;
                TrechoCodigoFonte trechoCodigoFonte;

                if (no instanceof NoSe)
                {
                    trechoCodigoFonte = ((NoSe) no).getCondicao().getTrechoCodigoFonte();
                }
                else if (no instanceof NoEnquanto)
                {
                    trechoCodigoFonte = ((NoEnquanto) no).getCondicao().getTrechoCodigoFonte();
                }
                else
                {
                    trechoCodigoFonte = no.getTrechoCodigoFonte();
                }

                if (trechoCodigoFonte != null)
                {
                    linha = trechoCodigoFonte.getLinha();
                    coluna = trechoCodigoFonte.getColuna();

                    saida.println();
                    saida.append(Utils.geraIdentacao(nivelEscopo));

                    saida.append(String.format("realizarParada(%d, %d);", linha, coluna));

                    saida.println();
                    saida.println();
                }
            }
        }
    }

    static boolean blocoFinalizaComPontoEVirgula(NoBloco bloco)
    {
        boolean ehLoop = bloco instanceof NoPara || bloco instanceof NoEnquanto || bloco instanceof NoFacaEnquanto;
        boolean ehDesvio = bloco instanceof NoSe || bloco instanceof NoEscolha;
        if (!ehLoop && !ehDesvio)
        {
            return true;
        }

        return false;
    }

    public static String geraIdentacao(int nivelEscopo)
    {
        return String.format("%" + (nivelEscopo * 4) + "s", " ");
    }

    public static String geraNomeValido(String nomeAtual)
    {
        if (!ehUmaPalavraReservadaNoJava(nomeAtual))
        {
            return nomeAtual;
        }

        return nomeAtual + "_" + String.valueOf(seedNomes);
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
