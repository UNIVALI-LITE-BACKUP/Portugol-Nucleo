package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class GeradorCodigoTest
{
    private final AnalisadorAlgoritmo analisador = new AnalisadorAlgoritmo();
    private final GeradorCodigoJava gerador = new GeradorCodigoJava();

    
    @Test
    public void testeComparacaoDeStringComEquals() throws Exception
    {
        String portugol = "programa                                             \n"
                + "{                                                            \n"
                + "     cadeia umaFrase, outraFrase                             \n"
                + "     inteiro a, b                                            \n"                
                + "                                                             \n"
                + "	funcao inicio()                                         \n"
                + "	{                                                       \n"
                + "         se (umaFrase == outraFrase)                         \n"
                + "		escreva(\"teste\")                              \n"
                + "         se (a == outraFrase)                                \n"
                + "		escreva(\"teste\")                              \n"                
                + "         se (a == b)                                         \n"
                + "		escreva(\"teste\")                              \n"                
                + "         se (a == b/2)                                       \n"
                + "		escreva(\"teste\")                              \n"                                
                + "         se (a == 10/2 * 2)                                  \n"
                + "		escreva(\"teste\")                              \n"                                                
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private String umaFrase;                                  \n"
                + "   private String outraFrase;                                \n"
                + "   private Integer a;                                        \n"
                + "   private Integer b;                                        \n"                
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         if (umaFrase.equals(outraFrase)) {                  \n"
                + "		escreva(\"teste\");                             \n"
                + "         }                                                   \n"
                + "         if (a == outraFrase) {                              \n"
                + "		escreva(\"teste\");                             \n"                
                + "         }                                                   \n"                
                + "         if (a == b) {                                       \n"
                + "		escreva(\"teste\");                             \n"                
                + "         }                                                   \n"                
                + "         if (a == b/2) {                                     \n"
                + "		escreva(\"teste\");                             \n"                                
                + "         }                                                   \n"                
                + "         if (a == 10/2 * 2) {                                \n"
                + "		escreva(\"teste\");                             \n"                                                                
                + "         }                                                   \n"                
                + "   }                                                         \n"
                + "}";

        comparaCodigos(portugol, codigoJavaEsperado);
    }

    
    @Test
    public void testePalavrasReservadasDoJava() throws Exception
    {
        // Testa se as palavras reservadas do Java são substituídas corretamente pelo gerador de código.
        String portugol = ""
                + "programa                                                         \n"
                + "{                                                                \n"
                + "     inteiro continue                                            \n"
                + "     cadeia break                                                \n"
                + "     inteiro if                                                  \n"
                + "     cadeia else                                                 \n"
                + "     inteiro while                                               \n"
                + "     cadeia do[3]                                                \n"
                + "     inteiro return[2][2]                                        \n"
                + "     cadeia for                                                  \n"
                + "     inteiro import                                              \n"
                + "     cadeia package                                              \n"
                + "     inteiro assert                                              \n"
                + "     inteiro int                                                 \n"
                + "     cadeia boolean                                              \n"
                + "     cadeia double                                               \n"
                + "     cadeia float                                                \n"
                + "     cadeia short                                                \n"
                + "     cadeia char                                                 \n"
                + "                                                                 \n"
                + "     funcao inicio()                                             \n"
                + "     {                                                           \n"
                + "     }                                                           \n"
                + "     funcao float(inteiro int, logico boolean[])                                             \n"
                + "     {                                                           \n"
                + "     }                                                           \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                               \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;        \n"
                + "import br.univali.portugol.nucleo.Programa;                      \n"
                + "                                                                 \n"
                + "public class ProgramaTeste extends Programa                      \n"
                + "{                                                                \n"
                + "     private Integer _continue;                                       \n"
                + "     private String _break;                                       \n"
                + "     private Integer _if;                                             \n"
                + "     private String _else;                                        \n"
                + "     private Integer _while;                                          \n"
                + "     private String _do[] = new String[3];                          \n"
                + "     private Integer _return[][] = new Integer[2][2];                         \n"
                + "     private String _for;                                         \n"
                + "     private Integer _import;                                         \n"
                + "     private String _package;                                     \n"
                + "     private Integer _assert;                                         \n"
                + "     private Integer _int;                                            \n"
                + "     private String _boolean;                                     \n"
                + "     private String _double;                                      \n"
                + "     private String _float;                                       \n"
                + "     private String _short;                                       \n"
                + "     private String _char;                                        \n"
                + "                                                                 \n"
                + "                                                                 \n"
                + "   public ProgramaTeste() throws ErroExecucao {}                 \n"                
                + "                                                                 \n"                
                + "   @Override                                                     \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                             \n"
                + "   }                                                             \n"
                + "   private void _float(Integer _int, Boolean _boolean[]) throws ErroExecucao, InterruptedException             \n"
                + "   {                                                             \n"
                + "   }                                                             \n"
                + "}";

        comparaCodigos(portugol, codigoJavaEsperado);

    }

    @Test
    public void testeDeclaracaoVetorMatriz() throws Exception
    {
        String portugol = "programa                                             \n"
                + "{                                                      \n"
                + "       const inteiro TAM = 5                           \n"
                + "	cadeia frases[TAM]                              \n"
                + "                                                       \n"
                + "	funcao inicio()                                 \n"
                + "	{                                               \n"
                + "		inteiro vetor[3]                        \n"
                + "		logico matriz[2][2]                     \n"
                + "		caracter letras[TAM][TAM]               \n"
                + "	}                                               \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "     private final Integer TAM = 5;                              \n"
                + "     private String frases[] = new String[TAM];              \n"
                + "                                                             \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "		Integer vetor[] = new Integer[3];                       \n"
                + "		Boolean matriz[][] = new Boolean[2][2];         \n"
                + "		Character letras[][] = new Character[TAM][TAM];           \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(portugol, codigoJavaEsperado);
    }

    @Test
    public void testeConstanteDeBiblioteca() throws Exception
    {
        String portugol = "programa                                                       \n"
                + "{                                                              \n"
                + "	inclua biblioteca Matematica --> mat                    \n"
                + "                                                               \n"
                + "	funcao inicio()                                         \n"
                + "	{                                                       \n"
                + "		real raio = 2.0                                 \n"
                + "		real area = mat.PI * mat.potencia(raio, 2.0)    \n"
                + "	}                                                       \n"
                + "}";
        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Matematica;    \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private final Matematica mat = new Matematica();          \n"
                + "                                                             \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "      Double raio = 2.0;                                     \n"
                + "      Double area = mat.PI * mat.potencia(raio, 2.0);         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(portugol, codigoJavaEsperado);
    }

    @Test
    public void testLeia() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro opcao                                       \n"
                + "         leia(opcao)                                         \n"
                + "         logico teste                                        \n"
                + "         leia(teste)                                         \n"
                + "         cadeia testeCadeia = \"inicializada\"               \n"
                + "         leia(testeCadeia)                                   \n"
                + "         inteiro a, b, c                                     \n"
                + "         leia(a, b, c)                                       \n"
                + "         inteiro vetor[3]                                    \n"
                + "         leia(vetor[0])                                      \n"
                + "         inteiro matriz[3][2]                                \n"
                + "         leia(matriz[0][1])                                  \n"
                + "         leia(matriz[(0+1)%3][1/5+6*2])                                  \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         Integer opcao;                                          \n"
                + "         opcao = leiaInteiro();                              \n"
                + "         Boolean teste;                                      \n"
                + "         teste = leiaLogico();                               \n"
                + "         String testeCadeia = \"inicializada\";              \n"
                + "         testeCadeia = leiaCadeia();                         \n"
                + "         Integer a;                                              \n"
                + "         Integer b;                                              \n"
                + "         Integer c;                                              \n"
                + "         a = leiaInteiro();                                  \n"
                + "         b = leiaInteiro();                                  \n"
                + "         c = leiaInteiro();                                  \n"
                + "         Integer vetor[] = new Integer[3];                           \n"
                + "         vetor[0] = leiaInteiro();                           \n"
                + "         Integer matriz[][] = new Integer[3][2];                     \n"
                + "         matriz[0][1] = leiaInteiro();                       \n"
                + "         matriz[(0+1)%3][1/5+6*2] = leiaInteiro();           \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
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
                + "		 	escreva (\"Tchau!\n\")                    \n"
                + "		 	pare                                    \n"
                + "		 caso contrario:                                \n"
                + "		 	escreva (\"Opção Inválida!\n\")          \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         Integer opcao = 1;                                      \n"
                + "         switch (opcao)                                      \n"
                + "         {                                                   \n"
                + "		case 1:                                         \n"
                + "                 escreva (\"caso 1\");                        \n"
                + "		 	break;                                  \n"
                + "		 case 2:                                        \n"
                + "                 escreva (\"caso 2\");                        \n"
                + "		 	break;                                  \n"
                + "		 case 3:                                        \n"
                + "		 	escreva (\"Tchau!\n\");                    \n"
                + "		 	break;                                  \n"
                + "		 default:                                       \n"
                + "		 	escreva (\"Opção Inválida!\n\");          \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         Integer x = 1;                                          \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         Integer x = 1;                                          \n"
                + "         do{                                                 \n"
                + "             teste(x);                                        \n"
                + "         }                                                   \n"
                + "         while(x < 10);                                      \n"
                + "   }                                                         \n"
                + "   private void teste(Integer a) throws ErroExecucao, InterruptedException                                \n"
                + "   {                                                         \n"
                + "         escreva(testeRetorno(a));                           \n"
                + "   }                                                         \n"
                + "   private Boolean testeRetorno(Integer a) throws ErroExecucao, InterruptedException {                     \n"
                + "         return a % 2 == 0;                                  \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }

    @Test
    public void testGeracaoLoopPara() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "	funcao inicio() {                                       \n"
                + "             para(inteiro i=10; i >= 0; i--) {               \n"
                + "                 escreva(i)                                  \n"
                + "             }                                               \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "             for(Integer i=10; i >= 0; i=i-1) {                    \n"
                + "                 escreva(i);                                 \n"
                + "             }                                               \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "         Integer x = 1;                                          \n"
                + "         while(x < 10) {                                     \n"
                + "             x = x + 1;                                      \n"
                + "             for(Integer i=0; i < 10; i=i+1) {                     \n"
                + "                 escreva(i);                                 \n"
                + "             }                                               \n"
                + "         }                                                   \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }

    @Test
    public void testGeracaoAtribuicoes() throws Exception
    {
        String codigoPortugol = "programa {                                     \n"
                + "         logico notas[][]   = {                              \n"
                + " /* bumbo   */{verdadeiro, falso},                           \n"
                + " /* caixa   */{falso, falso},                                \n"
                + " /* chimbal */{verdadeiro, falso}                            \n"
                + "         }                                                   \n"
                + "	funcao inicio() {                                       \n"
                + "         inteiro x = (10 / 2)                                \n"
                + "         inteiro a[] = {1, 2, 3}                             \n"
                + "         inteiro u[3]                                        \n"
                + "         inteiro x[2][2]                                     \n"
                + "         inteiro b[][] = {{1, 2, 3}, {4,5,6}}                \n"
                + "         inteiro c = a[0]                                    \n"
                + "         inteiro d = b[0][1]                                 \n"
                + "         inteiro f = x                                       \n"
                + "         b[0][0] = 1                                         \n"
                + "         u[1] = 1                                            \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "package programas;                                           \n"
                + "import br.univali.portugol.nucleo.mensagens.ErroExecucao;    \n"
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private Boolean notas[][] = {                             \n"
                + "             {true, false},                                  \n"
                + "             {false, false},                                 \n"
                + "             {true, false}                                   \n"
                + "         };                                                  \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "      Integer x = (10/2);                                        \n"
                + "      Integer a[] = {1, 2, 3};                                   \n"
                + "      Integer u[] = new Integer[3];                                  \n"
                + "      Integer x[][] = new Integer[2][2];                             \n"
                + "      Integer b[][] = {{1, 2, 3}, {4,5,6}};                      \n"
                + "      Integer c = a[0];                                          \n"
                + "      Integer d = b[0][1];                                       \n"
                + "      Integer f = x;                                             \n"
                + "      b[0][0] = 1;                                           \n"
                + "      u[1] = 1;                                              \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private Integer retornaInteiro() throws ErroExecucao, InterruptedException                               \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private Integer[] retornaArray() throws ErroExecucao, InterruptedException                              \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private Integer[][] retornaMatriz() throws ErroExecucao, InterruptedException                           \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void teste(Integer x[], Double c[][]) throws ErroExecucao, InterruptedException                 \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void testando(Integer x, Double y) throws ErroExecucao, InterruptedException                    \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void testando() throws ErroExecucao, InterruptedException                                   \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "   private void maisUma() throws ErroExecucao, InterruptedException                                    \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "   private final Integer i =  10;                                \n"
                + "   private final String c = \"teste\";                       \n"
                + "                                                             \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "   private Integer i = ((10 + 2 * 4/1) << 1);                    \n"
                + "   private Boolean l = true && true || false;                \n"
                + "   private Double r = 53.23 + 0.01;                           \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "   private Integer i =  10;                                      \n"
                + "   private  String c = \"teste\";                            \n"
                + "   private  Boolean l = true;                                \n"
                + "   private  Character c = 'a';                                    \n"
                + "   private  Double r = 53.23;                                \n"
                + "                                                             \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "   private Integer a;                                            \n"
                + "   private Integer b;                                            \n"
                + "   private  String c;                                        \n"
                + "   private  Boolean d;                                       \n"
                + "   private  Character e1;                                         \n"
                + "   private  Double f;                                        \n"
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override                                                 \n"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
                + "                                                             \n"
                + "   public ProgramaTeste() throws ErroExecucao {}    \n"                
                + "                                                             \n"                
                + "   @Override"
                + "   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException    \n"
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
        PrintWriter writer = new PrintWriter(bos);//(System.out, true);
        gerador.gera(asa, writer, "ProgramaTeste");
        writer.flush();
        String codigoGerado = bos.toString();
        System.out.println(codigoGerado); // escreve o código gerado antes de remover a formatação        

        codigoGerado = codigoGerado.replaceAll("\\s+|\\\\n", ""); //remove todos os espaços e caracteres não visíveis
        codigoJavaEsperado = codigoJavaEsperado.replaceAll("\\s+|\\\\n", "");

        System.out.println(codigoJavaEsperado);
        System.out.println(codigoGerado);
        System.out.println();

        assertEquals("Os códigos não são iguais!", codigoJavaEsperado, codigoGerado);
    }
}
