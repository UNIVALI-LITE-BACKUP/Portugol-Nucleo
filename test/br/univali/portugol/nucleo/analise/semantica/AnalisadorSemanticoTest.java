package br.univali.portugol.nucleo.analise.semantica;


import br.univali.portugol.nucleo.Portugol;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroTipoIndiceIncompativel;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroTiposIncompativeis;
import br.univali.portugol.nucleo.asa.TipoDado;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnalisadorSemanticoTest
{
    
    public AnalisadorSemanticoTest()
    {
        
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }

    @Test
    public void testTipoIncompativelExpressaoSOMAInteiroLogico() {
        ResultadoAnalise resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  inteiro a"
                                            + "  logico b"
                                            + "  a + b"
                                            + " }"
                                            + "}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
    }
    
    @Test
    public void testVariavelNaoDeclaradaEmExpressaoSoma() {
        ResultadoAnalise resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  inteiro a"
                                            + "  inteiro b"
                                            + "  a = a + c"
                                            + " }"
                                            + "}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ ErroSimboloNaoDeclarado.class.getName(),ErroSimboloNaoDeclarado.class, resultado.getErros().get(0).getClass());
    }
    
    @Test
    public void testTiposIncompativeisEscolhaCaso() {
        
        /*
         * Verifica se a expressao passada no escolha e inteiro ou caracter 
         */
        ResultadoAnalise resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  cadeia a"
                                            + "  escolha (a) {"
                                            + "     caso 1:"
                                            + "         pare"
                                            + "     caso 'a':"
                                            + "         pare"
                                            + "  }"
                                            + " }"
                                            + "}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Tipos incompativeis na expressao do escolha "+ ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! O comando \"escolha\" espera uma expressão do tipo \""+ TipoDado.INTEIRO+"\" ou \""+TipoDado.CARACTER+"\" mas foi passada uma expressão do tipo \""+TipoDado.CADEIA+"\".",
                resultado.getErros().get(0).getMensagem());
        
        
        /*
         * Verifica se a expressao passada no primeiro caso e igual ao do escolha 
         */
        resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  caracter a"
                                            + "  escolha (a) {"
                                            + "     caso 1:"
                                            + "         pare"
                                            + "     caso 'a':"
                                            + "         pare"
                                            + "  }"
                                            + " }"
                                            + "}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Tipos incompativeis na expressao do caso "+ ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! A expressão esperada para esse caso deveria ser do tipo \""+ TipoDado.CARACTER+"\" mas foi passada uma expressão do tipo \""+TipoDado.INTEIRO+"\".",
                resultado.getErros().get(0).getMensagem());
        
        /*
         * Verifica se ambas expressoes nao inteiro nem caracter
         */
        resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  logico a"
                                            + "  escolha (a) {"
                                            + "     caso 2.0:"
                                            + "         pare"
                                            + "     caso 'a':"
                                            + "         pare"
                                            + "  }"
                                            + " }"
                                            + "}");
        assertEquals("Era esperados dois erros semanticos",2, resultado.getErros().size());
        assertEquals("Tipos incompativeis na expressao do caso "+ ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! O comando \"escolha\" espera uma expressão do tipo \""+ TipoDado.INTEIRO+"\" ou \""+TipoDado.CARACTER+"\" mas foi passada uma expressão do tipo \""+TipoDado.LOGICO+"\".",
                resultado.getErros().get(0).getMensagem());
        assertEquals("Tipos incompatíveis! A expressão esperada para esse caso deveria ser do tipo \""+ TipoDado.INTEIRO+"\" ou \""+TipoDado.CARACTER+"\" mas foi passada uma expressão do tipo \""+TipoDado.REAL+"\".",
                resultado.getErros().get(1).getMensagem());
        
        
        /*
         * codigo correto
         */
        resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  inteiro a"
                                            + "  escolha (a) {"
                                            + "     caso 2:"
                                            + "         pare"
                                            + "     caso 1:"
                                            + "         pare"
                                            + "     caso contrario:"
                                            + "         pare"
                                            + "  }"
                                            + " }"
                                            + "}");
        assertEquals("Nao era esperado um erro semantico",0, resultado.getErros().size());
        
    }
}