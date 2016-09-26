package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Elieser
 */
public class OperacaoSomaTest
{
    private final Depurador depurador;

    public OperacaoSomaTest()
    {
        depurador = new Depurador();
    }
    
    @Test
    public void testStringInteiro() throws Exception
    {
        test(new NoCadeia("Portugol"), new NoInteiro(10), "Portugol10");
    }
    
    @Test 
    public void testStringString() throws Exception
    {
        test(new NoCadeia("Port"), new NoCadeia("ugol"), "Portugol");
        test(new NoCadeia(""), new NoCadeia(""), "");
    }
    
    @Test
    public void testInteiroString() throws Exception
    {
        test(new NoInteiro(10), new NoCadeia("Portugol"), "10Portugol");
    }
    
    @Test
    public void testCharacterString() throws Exception
    {
        test(new NoCaracter('_'), new NoCadeia("Portugol"), "_Portugol");
    }
    
    @Test
    public void testStringCharacter() throws Exception
    {
        test(new NoCadeia("Portugol"), new NoCaracter('_'), "Portugol_");
    }
    
    @Test
    public void testCharacterCharacter() throws Exception
    {
        test(new NoCaracter(':'), new NoCaracter(')'), ":)");
    }
    
    @Test
    public void testStringLogico() throws Exception
    {
        test(new NoCadeia("Teste-"), new NoLogico(true), "Teste-verdadeiro");
        test(new NoCadeia("Teste-"), new NoLogico(false), "Teste-falso");
    }
    
    @Test
    public void testLogicoString() throws Exception
    {
        test(new NoLogico(true), new NoCadeia("-Teste"), "verdadeiro-Teste");
        test(new NoLogico(false), new NoCadeia("-Teste"), "falso-Teste");
    }
    
    @Test
    public void testStringReal() throws Exception
    {
        test(new NoCadeia("Teste "), new NoReal(10.0), "Teste 10.0");
        test(new NoCadeia("Teste "), new NoReal(0.0), "Teste 0.0");
    }
    
    @Test
    public void testRealString() throws Exception
    {
        test(new NoReal(10.0), new NoCadeia(" Teste"), "10.0 Teste");
        test(new NoReal(0.0), new NoCadeia(" Teste"), "0.0 Teste");
    }
    
    @Test
    public void testInteiroInteiro() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), 20);
        test(new NoInteiro(10), new NoInteiro(-10), 0);
        test(new NoInteiro(-10), new NoInteiro(-10), -20);
    }    
    
    @Test
    public void testInteiroReal() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), 20.0);
        test(new NoInteiro(10), new NoReal(-10.0), 0.0);
        test(new NoInteiro(-10), new NoReal(-10.0), -20.0);
    }    
    
    @Test
    public void testRealInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), 20.0);
        test(new NoReal(10.0), new NoInteiro(-10), 0.0);
    }    
    
    @Test
    public void testRealReal() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), 20.0);
        test(new NoReal(10.0), new NoReal(-10), 0.0);
    }    

    private void test(NoExpressao a, NoExpressao b, Object resultadoEsperado) throws ExcecaoVisitaASA
    {
        NoOperacaoSoma soma = new NoOperacaoSoma(a, b);
        Object resultado = depurador.visitar(soma);
        assertEquals(resultadoEsperado, resultado);
    }

}
