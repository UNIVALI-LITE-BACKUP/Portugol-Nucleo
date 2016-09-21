package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMaior;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoMaiorTest
{
    private final Depurador depurador;
    
    public OperacaoMaiorTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void testExpressaoInteira() throws Exception
    {
        // a expressão de soma deve resultar em um inteiro
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), Boolean.FALSE);
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(4)), new NoInteiro(10), Boolean.FALSE);
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(6)), new NoInteiro(10), Boolean.TRUE);
    }
    
    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(11), Boolean.FALSE);
        test(new NoInteiro(10), new NoInteiro(9), Boolean.TRUE);
    }
    
    @Test
    public void testInteiroDouble() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), Boolean.FALSE);
        test(new NoInteiro(10), new NoReal(9), Boolean.TRUE);
    }
    
    @Test
    public void testDouble() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), Boolean.FALSE);
        test(new NoReal(10.0), new NoReal(9.0), Boolean.TRUE);
    }
    
    @Test
    public void testDoubleInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), Boolean.FALSE);
        test(new NoReal(10.0), new NoInteiro(9), Boolean.TRUE);
    }
 
    private void test(NoExpressao a, NoExpressao b, Boolean expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoLogicaMaior igualdade = new NoOperacaoLogicaMaior(a, b);
        Object result = depurador.visitar(igualdade);
        assertEquals(expectedResult, result);
    }
   
}
