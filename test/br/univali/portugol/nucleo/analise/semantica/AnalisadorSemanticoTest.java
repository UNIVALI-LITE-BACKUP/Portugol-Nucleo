package br.univali.portugol.nucleo.analise.semantica;


import br.univali.portugol.nucleo.Portugol;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoInicializado;
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
    public void testReferenciaVetor()
    {
        ResultadoAnalise resultado = Portugol.analisar(
                                            "programa"
                                            +"{"
                                            +" funcao inicio(){"
                                            +"   inteiro a[] = {1, 2, 3}"
                                            +"   escreva(a[\"1\"])       "
                                            +" }"
                                            +"}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! O índice do vetor deve ser uma expressão do tipo \""+ TipoDado.INTEIRO+"\" mas foi passada uma expressão do tipo \""+TipoDado.CADEIA+"\".",
                resultado.getErros().get(0).getMensagem());
    }
    
    @Test
    public void testMenosUnario(){
        ResultadoAnalise resultado = Portugol.analisar(
                                            "programa"
                                            +"{"
                                            +" funcao inicio(){"
                                            +"   cadeia a = \"teste\""
                                            +"   escreva(-a)        "
                                            +" }"
                                            +"}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! A operação \"menos unário\" espera uma expressão do tipo \""+ TipoDado.INTEIRO+"\" ou \""+TipoDado.REAL+"\" mas foi passada uma expressão do tipo \""+TipoDado.CADEIA+"\".",
                resultado.getErros().get(0).getMensagem());
    }
    
    @Test
    public void testNoNao(){
        ResultadoAnalise resultado = Portugol.analisar(
                                            "programa"
                                            +"{"
                                            +" funcao inicio(){"
                                            +"   cadeia a = \"teste\""
                                            +"   se (nao a){"
                                            +"     escreva(\"nao a\")"
                                            +"   }        "
                                            +" }"
                                            +"}");
        assertEquals("Era esperado um erro semantico",1, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ErroTiposIncompativeis.class.getName(),ErroTiposIncompativeis.class, resultado.getErros().get(0).getClass());
        assertEquals("Tipos incompatíveis! A operação de negação espera uma expressão do tipo \""+ TipoDado.LOGICO+"\" mas foi passada uma expressão do tipo \""+TipoDado.CADEIA+"\".",
                resultado.getErros().get(0).getMensagem());
    }
    
    @Test
    public void testVariavelNaoInicializada(){
        ResultadoAnalise resultado = Portugol.analisar(
                                                "programa"
                                                +"{"
                                                +" funcao inicio(){"
                                                +"   inteiro a, b"
                                                +"   escreva(a)"
                                                +"   b = a + 2"
                                                +"   a = a + b"
                                                +"   escreva(b)"
                                                +"   a = 1"
                                                +"   escreva(a)"
                                                +" }"
                                                +"}");
        
        assertEquals("Era esperado tres erros semanticos",3, resultado.getErros().size());
        assertEquals("Era esperado uma instancia de "+ ErroSimboloNaoInicializado.class.getName(),ErroSimboloNaoInicializado.class, 
                resultado.getErros().get(0).getClass());

    }

    @Test
    public void testTipoIncompativelExpressaoSOMAInteiroLogico() {
        ResultadoAnalise resultado = Portugol.analisar(
                                              "programa {"
                                            + " funcao inicio() {"
                                            + "  inteiro a = 1"
                                            + "  logico b = verdadeiro"
                                            + "  b = a + b"
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
                                            + "  inteiro a = 0, b = 1"
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
                                            + "  cadeia a = \"a\""
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
                                            + "  caracter a = 'a'"
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
                                            + "  logico a = verdadeiro"
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
                                            + "  inteiro a = 1"
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