package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.ErroCompilacao;
import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class GeradorCodigoTest
{
    private final AnalisadorAlgoritmo analisador = new AnalisadorAlgoritmo();
    private final GeradorCodigoJava gerador = new GeradorCodigoJava();
    
//    @Test
//    public void testaExemplos() throws FileNotFoundException, ErroCompilacao, ExcecaoVisitaASA, IOException
//    {
//        File dirExemplos = new File("../Portugol-Studio-Recursos/exemplos");
//        File[] dirs = dirExemplos.listFiles();
//        for (File dir : dirs)
//        {
//            geraCodigoParaExemplo(dir);
//        }
//    }
    
    private void geraCodigoParaExemplo(File exemplo) throws FileNotFoundException, ErroCompilacao, ExcecaoVisitaASA, IOException
    {
        if (exemplo.isDirectory()) {
            File files[] = exemplo.listFiles();
            for (File file : files)
            {
                geraCodigoParaExemplo(file);
            }
        }
        else
        {
            if (exemplo.getName().endsWith(".por"))
            {
                System.out.println("TESTANDO " + exemplo.getName());
                String codigoPortugol = new Scanner(exemplo).useDelimiter("\\Z").next();
                AnalisadorAlgoritmo aa = new AnalisadorAlgoritmo();
                aa.analisar(codigoPortugol);
                GeradorCodigoJava gerador = new GeradorCodigoJava();
                String nomeClasse = exemplo.getName().replace(".por", "");
                String arquivoJava = "../" + nomeClasse + ".java";
                OutputStream os = new BufferedOutputStream(new FileOutputStream(arquivoJava));
                gerador.gera((ASAPrograma) aa.getASA(), os, nomeClasse);
                os.close();
            }
        }
    }

    @Test
    public void testNoEscolha() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro opcao = 1                                   \n"
                + "         escolha (opcao)                                     \n"
                + "         {                                                   \n" 
                + "		caso 1:                                         \n" 
                + "                 escreva (\"caso 1\")                        \n" 
                + "		 	pare                                    \n" 
                + "		 caso 2:                                        \n" 
                + "                 escreva (\"caso 2\")                        \n" 
                + "		 	pare                                    \n" 
                + "		 caso 3:                                        \n" 
                + "		 	escreva (\"Tchau!\")                    \n" 
                + "		 	pare                                    \n" 
                + "		 caso contrario:                                \n" 
                + "		 	escreva (\"Opção Inválida !\")          \n" 
                + "         }                                                   \n"                
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "         int opcao = 1;                                      \n"                
                + "         switch (opcao)                                      \n"
                + "         {                                                   \n" 
                + "		case 1:                                         \n" 
                + "                 escreva (\"caso 1\");                        \n" 
                + "		 	break;                                  \n" 
                + "		 case 2:                                        \n" 
                + "                 escreva (\"caso 2\");                        \n" 
                + "		 	break;                                  \n" 
                + "		 case 3:                                        \n" 
                + "		 	escreva (\"Tchau!\");                    \n" 
                + "		 	break;                                  \n" 
                + "		 default:                                       \n" 
                + "		 	escreva (\"Opção Inválida !\");          \n" 
                + "         }                                                   \n"                
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoSeSenao() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro x = 1                                       \n"
                + "         se (x > 0) {                                        \n"                
                + "             se (verdadeiro) {                               \n"
                + "             }                                               \n"
                + "             senao {                                         \n"                
                + "                 se (x <= 0) {                               \n"
                + "                 }                                           \n"                
                + "             }                                               \n"                
                + "         }                                                   \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "         int x = 1;                                          \n"
                + "         if (x > 0) {                                        \n"                
                + "             if (true) {                                     \n"
                + "             }                                               \n"
                + "             else {                                          \n"                
                + "                 if (x <= 0) {                               \n"
                + "                 }                                           \n"                
                + "             }                                               \n"                
                + "         }                                                   \n"
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoChamaFuncoes() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro x = 1                                       \n"
                + "         faca{                                               \n"
                + "             teste(x)                                        \n"                                
                + "         }                                                   \n"
                + "         enquanto(x < 10)                                    \n"                
                + "	}                                                       \n"
                + "	funcao teste(inteiro a) {                               \n"
                + "           escreva(testeRetorno(a))                          \n"
                + "     }                                                       \n"
                + "	funcao logico testeRetorno(inteiro a) {                 \n"
                + "          retorne a % 2 == 0                                 \n"
                + "     }                                                       \n"                
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "         int x = 1;                                          \n"
                + "         do{                                                 \n"
                + "             teste(x);                                        \n"                                
                + "         }                                                   \n"
                + "         while(x < 10);                                      \n"                                
                + "   }                                                         \n"
                + "   private void teste(int a)                                 \n"
                + "   {                                                         \n"
                + "         escreva(testeRetorno(a));                           \n"
                + "   }                                                         \n"
                + "   private boolean testeRetorno(int a) {                     \n"
                + "         return a % 2 == 0;                                  \n"
                + "   }                                                         \n"                                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoCorpoDeMetodo() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro x = 1                                       \n"
                + "         enquanto(x < 10) {                                  \n"
                + "             x++                                             \n"                
                + "             para(inteiro i=0; i < 10; i++) {                \n"
                + "                 escreva(i)                                  \n"                                
                + "             }                                               \n"                
                + "         }                                                   \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "         int x = 1;                                          \n"
                + "         while(x < 10) {                                     \n"
                + "             x = x + 1;                                      \n"                
                + "             for(int i=0; i < 10; i=i+1) {                     \n"
                + "                 escreva(i);                                 \n"                                
                + "             }                                               \n"                
                + "         }                                                   \n"                                
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoAtribuicaoDentroDeFuncao() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro x = (10 / 2)                                \n"
                + "         inteiro a[] = {1, 2, 3}                             \n"
                + "         inteiro u[3]                                        \n"                
                + "         inteiro x[2][2]                                        \n"                                
                + "         inteiro b[][] = {{1, 2, 3}, {4,5,6}}                \n"                
                + "         inteiro c = a[0]                                    \n"
                + "         inteiro d = b[0][1]                                 \n"                
                + "         inteiro f = x                                       \n"                                
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "      int x = (10/2);                                        \n"
                + "      int a[] = {1, 2, 3};                                   \n"                
                + "      int u[3];                                              \n"                
                + "      int x[2][2];                                           \n"                
                + "      int b[][] = {{1, 2, 3}, {4,5,6}};                      \n"
                + "      int c = a[0];                                          \n"                
                + "      int d = b[0][1];                                       \n"                
                + "      int f = x;                                             \n"                                
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoFuncaoRetornandoArrays() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "	funcao inteiro retornaInteiro() {                       \n"
                + "	}                                                       \n"                
                + "	funcao inteiro[] retornaArray() {                       \n"
                + "	}                                                       \n"                
                + "	funcao inteiro[][] retornaMatriz() {                    \n"
                + "	}                                                       \n"                                
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private int retornaInteiro()                               \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "   private int[] retornaArray()                              \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "   private int[][] retornaMatriz()                           \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoFuncaoComParametrosQueSaoArrays() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "	funcao teste(inteiro x[], real c[][]) {                 \n"
                + "	}                                                       \n"                
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void teste(int x[], double c[][])                 \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoFuncaoComParametros() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "	funcao testando(inteiro x, real y) {                    \n"
                + "	}                                                       \n"                
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void testando(int x, double y)                    \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testGeracaoFuncoesSimples() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "	funcao testando() {                                     \n"
                + "	}                                                       \n"                
                + "	funcao maisUma() {                                      \n"
                + "	}                                                       \n"                                
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void testando()                                   \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "   private void maisUma()                                     \n"
                + "   {                                                         \n"
                + "   }                                                         \n"                
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testInclusaoBibliotecasComESemAliases() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inclua biblioteca Graficos --> g                        \n"
                + "	inclua biblioteca Mouse                                 \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Graficos;      \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Mouse;         \n"                
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private final Graficos g = new Graficos();                      \n"
                + "   private final Mouse Mouse = new Mouse();                        \n"
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testInclusaoBibliotecasComAliases() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inclua biblioteca Graficos --> g                        \n"
                + "	inclua biblioteca Mouse --> m                           \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Graficos;      \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Mouse;         \n"                
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private final Graficos g = new Graficos();                \n"
                + "   private final Mouse m = new Mouse();                      \n"
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testInclusaoBibliotecasSemAliases() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inclua biblioteca Graficos                              \n"
                + "	inclua biblioteca Mouse                                 \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Graficos;      \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Mouse;         \n"                
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private final Graficos Graficos = new Graficos();         \n"
                + "   private final Mouse Mouse = new Mouse();                  \n"
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testDeclaracaoConstantes() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	const inteiro i = 10                                    \n"
                + "	const cadeia c = \"teste\"                              \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = "package programas;                         \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private final int i =  10;                                \n"
                + "   private final String c = \"teste\";                       \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testVariaveisGlobaisInicializadasComExpressoes() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	cadeia c = \"teste\" + \" concatenacao\"                \n"
                + "	inteiro i = ((10 + 2 * 4/1) << 1)                       \n"
                + "     logico l = verdadeiro e verdadeiro ou falso            \n"
                + "     real r = 53.23 + 0.01                                   \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = "package programas;                         \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private String c = \"teste\" + \" concatenacao\";         \n"
                + "   private int i = ((10 + 2 * 4/1) << 1);                    \n"
                + "   private boolean l = true && true || false;                \n"
                + "   private double r = 53.23 + 0.01;                           \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testVariaveisGlobaisInicializadasComValoresSimples() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inteiro i = 10                                          \n"
                + "	cadeia c = \"teste\"                                    \n"
                + "     logico l = verdadeiro                                   \n"
                + "     caracter c = 'a'                                        \n"
                + "     real r = 53.23                                          \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = "package programas;                         \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private int i =  10;                                      \n"
                + "   private  String c = \"teste\";                            \n"                
                + "   private  boolean l = true;                                \n"                
                + "   private  char c = 'a';                                    \n"
                + "   private  double r = 53.23;                                \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testDeclaracaoVariaveisGlobaisComoAtributosDoPrograma() throws Exception
    {
        String codigoPortugol = "programa {         \n"
                + "	inteiro a, b                \n"
                + "	cadeia c                    \n"
                + "     logico d                    \n"
                + "     caracter e1                 \n"
                + "     real f                      \n"
                + "	funcao inicio() {           \n"
                + "	}\n                         \n"
                + "}";

        String codigoJavaEsperado = "package programas;                         \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private int a;                                            \n"
                + "   private int b;                                            \n"
                + "   private  String c;                                        \n"                
                + "   private  boolean d;                                       \n"                
                + "   private  char e1;                                         \n"
                + "   private  double f;                                        \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testProgramaVazio() throws Exception
    {
        String codigoPortugol = "programa {"
                + "	funcao inicio() {"
                + "	}\n"
                + "}";

        String codigoJavaEsperado = "package programas;"  
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;"

                + "public class ProgramaTeste extends Programa"
                + "{"
                + "   @Override"
                + "   protected void executar(String[] parametros) throws ErroExecucao"
                + "   {"
                + "   }"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }

    private void comparaCodigos(String codigoPortugol, String codigoJavaEsperado) throws Exception
    {
        analisador.analisar(codigoPortugol);
        ASAPrograma asa = (ASAPrograma) analisador.getASA();

        // gera o código e escreve em um ByteArrayOutputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        gerador.gera(asa, bos, "ProgramaTeste");

        String codigoGerado = bos.toString();
        System.out.println(codigoGerado); // escreve o código gerado antes de remover a formatação        

        codigoGerado = codigoGerado.replaceAll("\\s+", ""); //remove todos os espaços e caracteres não visíveis
        codigoJavaEsperado = codigoJavaEsperado.replaceAll("\\s+", "");
        
        System.out.println(codigoJavaEsperado);
        System.out.println(codigoGerado);
        System.out.println();
        
        assertEquals("Os códigos não são iguais!", codigoJavaEsperado, codigoGerado);
    }
}
