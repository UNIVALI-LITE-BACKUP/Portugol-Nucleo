package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.ErroCompilacao;
import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import java.io.ByteArrayOutputStream;
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
    public void testInclusaoBibliotecasComAliases() throws ErroCompilacao
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inclua biblioteca Graficos --> g                        \n"
                + "	inclua biblioteca Mouse --> m                           \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Graficos;      \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Mouse;         \n"                
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private Graficos g = new Graficos();                      \n"
                + "   private Mouse m = new Mouse();                            \n"
                + "                                                             \n"
                + "   @override                                                 \n"
                + "   protected void executar() throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testInclusaoBibliotecasSemAliases() throws ErroCompilacao
    {
        String codigoPortugol = "programa {                                     \n"
                + "	inclua biblioteca Graficos                              \n"
                + "	inclua biblioteca Mouse                                 \n"
                + "	funcao inicio() {                                       \n"
                + "	}                                                       \n"
                + "}";

        String codigoJavaEsperado = ""
                + "import br.univali.portugol.nucleo.Programa;                  \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Graficos;      \n"
                + "import br.univali.portugol.nucleo.bibliotecas.Mouse;         \n"                
                + "                                                             \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private Graficos Graficos = new Graficos();               \n"
                + "   private Mouse Mouse = new Mouse();                        \n"
                + "                                                             \n"
                + "   @override                                                 \n"
                + "   protected void executar() throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testDeclaracaoVariaveisGlobaisComoAtributosDoPrograma() throws ErroCompilacao
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

        String codigoJavaEsperado = "import br.univali.portugol.nucleo.Programa; \n"
                + "public class ProgramaTeste extends Programa                  \n"
                + "{                                                            \n"
                + "   private int a;                                            \n"
                + "   private int b;                                            \n"
                + "   private  String c;                                        \n"                
                + "   private  boolean d;                                       \n"                
                + "   private  char e1;                                         \n"
                + "   private  double f;                                        \n"                
                + "                                                             \n"
                + "   @override                                                 \n"
                + "   protected void executar() throws ErroExecucao             \n"
                + "   {                                                         \n"
                + "   }                                                         \n"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }
    
    @Test
    public void testProgramaVazio() throws ErroCompilacao
    {
        String codigoPortugol = "programa {"
                + "	funcao inicio() {"
                + "	}\n"
                + "}";

        String codigoJavaEsperado = "import br.univali.portugol.nucleo.Programa;"
                + "public class ProgramaTeste extends Programa"
                + "{"
                + "   @override"
                + "   protected void executar() throws ErroExecucao"
                + "   {"
                + "   }"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
    }

    private void comparaCodigos(String codigoPortugol, String codigoJavaEsperado) throws ErroCompilacao
    {
        analisador.analisar(codigoPortugol);
        ASAPrograma asa = (ASAPrograma) analisador.getASA();

        // gera o código e escreve em um ByteArrayOutputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        gerador.gera(asa, bos, "ProgramaTeste");

        String codigoGerado = bos.toString().replaceAll("\\s+", ""); //remove todos os espaços e caracteres não visíveis
        codigoJavaEsperado = codigoJavaEsperado.replaceAll("\\s+", "");
        
        System.out.println(codigoJavaEsperado);
        System.out.println(codigoGerado);
        System.out.println();
        
        assertEquals("Os códigos não são iguais!", codigoJavaEsperado, codigoGerado);
    }
}
