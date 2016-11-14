package br.univali.portugol.nucleo.execucao.gerador.helpers;

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

    public static void geraCodigoParaInspecao(NoDeclaracaoParametro parametro, PrintWriter saida, int nivelEscopo)
    {
        int ID = parametro.getIdParaInspecao();
        if (ID >= 0)
        {
            saida.append(Utils.geraIdentacao(nivelEscopo));
            
            saida.format("if (variaveisInspecionadas[%d] != null) {", ID)
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 1));
            
            String nomeVariavel = parametro.getNome();
//            if (parametro.getModoAcesso() == ModoAcesso.POR_REFERENCIA)
//            {
//                String nomeTipo = Utils.getNomeTipoJava(parametro.getTipoDado()).toUpperCase();
//                nomeVariavel = String.format("REFS_%s[%s]", nomeTipo, Utils.geraStringIndice(parametro));
//            }
            saida.format("variaveisInspecionadas[%d] = %s;", ID, nomeVariavel)
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo))
                    .append("}");
        }
    }
    
    public static void geraCodigoParaInspecao(NoDeclaracaoVariavel variavel, PrintWriter saida, 
                            int nivelEscopo, boolean gerandoCodigoParaAtribuicao)
    {
        int ID = variavel.getIdParaInspecao();
        if (ID >= 0)
        {
            if(gerandoCodigoParaAtribuicao || (!gerandoCodigoParaAtribuicao && variavel.temInicializacao()))
            {
                saida.append(Utils.geraIdentacao(nivelEscopo));
            
                saida.format("if (variaveisInspecionadas[%d] != null) {", ID)
                        .println();
            
                saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                
                String nomeVariavel = variavel.getNome();
                if (variavel.ehPassadaPorReferencia())
                {
                    String nomeTipo = Utils.getNomeTipoJava(variavel.getTipoDado()).toUpperCase();
                    nomeVariavel = String.format("REFS_%s[%s]", nomeTipo, Utils.geraStringIndice(variavel));
                }
                saida.format("variaveisInspecionadas[%d] = %s;", ID, nomeVariavel)
                        .println();
                
                saida.append(Utils.geraIdentacao(nivelEscopo))
                        .append("}");
            }
        }
    }
    
    public static void geraCodigoParaInspecao(NoReferenciaVetor referenciaVetor, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        
        int ID = ((NoDeclaracaoInspecionavel)referenciaVetor.getOrigemDaReferencia()).getIdParaInspecao();
        if (ID >= 0)
        {
            saida.append(Utils.geraIdentacao(nivelEscopo));
            
            saida.format("if (vetoresInspecionados[%d] != null) {", ID)
                    .println();
            
            String nomeVariavel = referenciaVetor.getNome();

            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .format("vetoresInspecionados[%d].setValor(", ID);
                    
            saida.format("%s[", nomeVariavel); 
            referenciaVetor.getIndice().aceitar(visitor); //escreve o índice de acesso ao vetor na saída (PrintWriter)
            saida.append("], ");

            referenciaVetor.getIndice().aceitar(visitor); // escreve o índice novamente na saída
            
            saida.append(");") // fecha o parenteses do setValor( );
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo))
                    .append("}"); // fechando IF
        }
    }
    
    public static void geraCodigoParaInspecao(NoDeclaracaoVetor vetor, PrintWriter saida, int nivelEscopo)
    {
        int ID = vetor.getIdParaInspecao();
        if (ID >= 0 && vetor.temInicializacao())
        {
            saida.append(Utils.geraIdentacao(nivelEscopo));
            
            saida.format("if (vetoresInspecionados[%d] != null) {", ID)
                    .println();
            
            String nomeVariavel = vetor.getNome();

            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .format("for (int i = 0; i < vetoresInspecionados[%d].tamanho; i++) {", ID)
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .format("vetoresInspecionados[%d].setValor(%s[i], i);", ID, nomeVariavel)
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .append("}")// fechando loop
                    .println(); 
            
            saida.append(Utils.geraIdentacao(nivelEscopo))
                    .append("}"); // fechando IF
        }
    }
    
    public static void geraCodigoParaInspecao(NoReferenciaMatriz referenciaMatriz, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        int ID = ((NoDeclaracaoInspecionavel)referenciaMatriz.getOrigemDaReferencia()).getIdParaInspecao();
        if (ID >= 0)
        {
            saida.append(Utils.geraIdentacao(nivelEscopo));
            
            saida.format("if (matrizesInspecionadas[%d] != null) {", ID)
                    .println();
            
            String nomeVariavel = referenciaMatriz.getNome();

            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .format("matrizesInspecionadas[%d].setValor(", ID);
                    
            saida.format("%s[", nomeVariavel); 
            referenciaMatriz.getLinha().aceitar(visitor); //escreve o índice da linha na saída (PrintWriter)
            saida.append("][");
            referenciaMatriz.getColuna().aceitar(visitor); //escreve o índice da coluna na saída (PrintWriter)
            saida.append("], ");

            referenciaMatriz.getLinha().aceitar(visitor); // escreve o índice da linha novamente na saída
            saida.append(", ");
            referenciaMatriz.getColuna().aceitar(visitor); // escreve o índice da linha novamente na saída
            
            saida.append(");") // fecha o parenteses do setValor( );
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo))
                    .append("}"); // fechando IF
        }
    }
    
    public static void geraCodigoParaInspecao(NoDeclaracaoMatriz matriz, PrintWriter saida, int nivelEscopo)
    {
        int ID = matriz.getIdParaInspecao();
        if (ID >= 0 && matriz.temInicializacao())
        {
            saida.append(Utils.geraIdentacao(nivelEscopo));
            
            saida.format("if (matrizesInspecionadas[%d] != null) {", ID)
                    .println();
            
            String nomeVariavel = matriz.getNome();

            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .format("for (int i = 0; i < matrizesInspecionadas[%d].linhas; i++) {", ID) // loop das linhas
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 2))
                    .format("for (int j = 0; j < matrizesInspecionadas[%d].colunas; j++) {", ID) // loop das colunas
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 3))
                    .format("matrizesInspecionadas[%d].setValor(%s[i][j], i, j);", ID, nomeVariavel)
                    .println();
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 2))
                    .append("}")// fechando loop interno
                    .println(); 
            
            saida.append(Utils.geraIdentacao(nivelEscopo + 1))
                    .append("}")// fechando loop externo
                    .println(); 
            
            saida.append(Utils.geraIdentacao(nivelEscopo))
                    .append("}"); // fechando IF
        }
    }
    
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
        assert(variavel.ehPassadaPorReferencia());
        return geraStringIndice(variavel.getIndiceReferencia(), variavel.getNome());
    }
    
    private static String geraStringIndice(int indice, String nome)
    {
        return String.format("INDICE_%s_%d", nome.toUpperCase(), indice);
    }
    
    private static void geraCodigoParaInspecaoDeAtribuicao(NoOperacaoAtribuicao atribuicao, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        NoExpressao operandoEsquerdo = atribuicao.getOperandoEsquerdo();
        if (operandoEsquerdo instanceof NoReferenciaVariavel)
        {
            NoReferenciaVariavel referenciaVariavel = (NoReferenciaVariavel) operandoEsquerdo;
            NoDeclaracao origem = referenciaVariavel.getOrigemDaReferencia();
            if (origem instanceof NoDeclaracaoVariavel)
            {
                Utils.geraCodigoParaInspecao((NoDeclaracaoVariavel)origem, saida, nivelEscopo, true);
            }
            else
            {
                Utils.geraCodigoParaInspecao((NoDeclaracaoParametro)origem, saida, nivelEscopo);
            }
        }
        else if (operandoEsquerdo instanceof NoReferenciaVetor)
        {
            NoReferenciaVetor referenciaVetor = (NoReferenciaVetor) operandoEsquerdo;
            Utils.geraCodigoParaInspecao(referenciaVetor, saida, visitor, nivelEscopo);
        }
        else if (operandoEsquerdo instanceof NoReferenciaMatriz)
        {
            NoReferenciaMatriz referenciaMatriz = (NoReferenciaMatriz) operandoEsquerdo;
            Utils.geraCodigoParaInspecao(referenciaMatriz, saida, visitor, nivelEscopo);
        }
    }
    
    private static void geraCodigoParaInspecaoDeBloco(NoBloco bloco, PrintWriter saida, VisitanteASA visitor, int nivelEscopo) throws ExcecaoVisitaASA
    {
        if (bloco instanceof NoDeclaracaoInspecionavel || bloco instanceof NoOperacaoAtribuicao)
        {
            if (bloco instanceof NoDeclaracaoInspecionavel)
            {
                if (bloco instanceof NoDeclaracaoVariavel)
                {
                    Utils.geraCodigoParaInspecao((NoDeclaracaoVariavel) bloco, saida, nivelEscopo, false);
                }
                else if (bloco instanceof NoDeclaracaoVetor)
                {
                    Utils.geraCodigoParaInspecao((NoDeclaracaoVetor) bloco, saida, nivelEscopo);
                }
                else if (bloco instanceof NoDeclaracaoMatriz)
                {
                    Utils.geraCodigoParaInspecao((NoDeclaracaoMatriz)bloco, saida, nivelEscopo);
                }
            }
            else
            {
                geraCodigoParaInspecaoDeAtribuicao((NoOperacaoAtribuicao) bloco, saida, visitor, nivelEscopo);
            }
            saida.println();
        }
    }
    
    public static void visitarBlocos(List<NoBloco> blocos, PrintWriter saida, 
            VisitanteASA visitor, int nivelEscopo, boolean geraCodigoParaInterrupcaoDeThread, 
                    boolean geraCodigoParaPontosDeParada, boolean geraCodigoParaInspecaoDeSimbolo) throws ExcecaoVisitaASA
    {
        for (NoBloco bloco : blocos)
        {
            if (geraCodigoParaPontosDeParada)
            {
                geraParadaPassoAPasso(bloco, saida, nivelEscopo);
            }

            saida.append(Utils.geraIdentacao(nivelEscopo));

            boolean adicionaPonEtoVirgula = blocoFinalizaComPontoEVirgula(bloco);
            Object resultado = bloco.aceitar(visitor);
            if (resultado instanceof Boolean )
            {
                adicionaPonEtoVirgula &= ((Boolean)resultado);
            }

            if (adicionaPonEtoVirgula)
            {
                saida.append(";");
            }
            saida.println();
            
            if (geraCodigoParaInspecaoDeSimbolo)
            {
                geraCodigoParaInspecaoDeBloco(bloco, saida, visitor, nivelEscopo);
            }
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

    public static void geraVerificacaoThreadInterrompida(PrintWriter saida, int nivelEscopo)
    {
        saida.append(Utils.geraIdentacao(nivelEscopo));
        saida.append("if (Thread.currentThread().isInterrupted()) {throw new InterruptedException();}");
        saida.println();
        saida.println();
    }

    private static TrechoCodigoFonte getTrechoCodigoFonte(NoBloco no)
    {
        TrechoCodigoFonte trechoCodigoFonte = no.getTrechoCodigoFonte();
        
        if (no instanceof NoSe)
        {
            trechoCodigoFonte = ((NoSe) no).getCondicao().getTrechoCodigoFonte();
        }
        else if (no instanceof NoEnquanto)
        {
            trechoCodigoFonte = ((NoEnquanto) no).getCondicao().getTrechoCodigoFonte();
        }
        else if (no instanceof NoPara)
        {
            trechoCodigoFonte = ((NoPara) no).getCondicao().getTrechoCodigoFonte();
        }
        else if (no instanceof NoFacaEnquanto)
        {
            trechoCodigoFonte = ((NoFacaEnquanto) no).getCondicao().getTrechoCodigoFonte();
        }
        else if (no instanceof NoEscolha)
        {
            trechoCodigoFonte = ((NoEscolha) no).getExpressao().getTrechoCodigoFonte();
        }
        else if (no instanceof NoDeclaracaoMatriz || no instanceof NoDeclaracaoVetor)
        {
            trechoCodigoFonte = ((NoDeclaracao) no).getTrechoCodigoFonteNome();
        }
        
        return trechoCodigoFonte;
    }
    
    public static void geraParadaPassoAPasso(NoBloco no, PrintWriter saida, int nivelEscopo)
    {
        TrechoCodigoFonte trechoCodigoFonte = getTrechoCodigoFonte(no);
        if (trechoCodigoFonte != null && trechoCodigoFonte.ehValido()) 
        {
            int linha;
            int coluna;

            linha = trechoCodigoFonte.getLinha();
            coluna = trechoCodigoFonte.getColuna();

            saida.append(Utils.geraIdentacao(nivelEscopo))
                .append(String.format("realizarParada(%d, %d);", linha, coluna))
                .println();
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
