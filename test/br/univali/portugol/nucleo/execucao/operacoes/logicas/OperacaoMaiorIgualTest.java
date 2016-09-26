package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMaior;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMaiorIgual;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoMaiorIgualTest
{
    private final Depurador depurador;
    
    public OperacaoMaiorIgualTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void testExpressaoInteira() throws Exception
    {
        // a expressão de soma deve resultar em um inteiro
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), Boolean.TRUE);
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(4)), new NoInteiro(10), Boolean.FALSE);
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(6)), new NoInteiro(10), Boolean.TRUE);
    }
    
    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(11), Boolean.FALSE);
        test(new NoInteiro(10), new NoInteiro(9), Boolean.TRUE);
        test(new NoInteiro(10), new NoInteiro(10), Boolean.TRUE);
    }
    
    @Test
    public void testInteiroDouble() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), Boolean.TRUE);
        test(new NoInteiro(10), new NoReal(9), Boolean.TRUE);
        test(new NoInteiro(10), new NoReal(11), Boolean.FALSE);
    }
    
    @Test
    public void testDouble() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), Boolean.TRUE);
        test(new NoReal(10.0), new NoReal(9.0), Boolean.TRUE);
        test(new NoReal(10.0), new NoReal(11.0), Boolean.FALSE);
    }
    
    @Test
    public void testDoubleInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), Boolean.TRUE);
        test(new NoReal(10.0), new NoInteiro(9), Boolean.TRUE);
        test(new NoReal(10.0), new NoInteiro(11), Boolean.FALSE);
    }

    private void test(NoExpressao a, NoExpressao b, Boolean expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoLogicaMaiorIgual igualdade = new NoOperacaoLogicaMaiorIgual(a, b);
        Object result = depurador.visitar(igualdade);
        assertEquals(expectedResult, result);
    }
   
}
