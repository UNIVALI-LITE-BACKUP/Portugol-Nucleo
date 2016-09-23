package br.univali.portugol.nucleo.execucao.operacoes.logicas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaDiferenca;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoDiferencaTest
{
    private final Depurador depurador;
    
    public OperacaoDiferencaTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void testExpressaoInteira() throws Exception
    {
        // a expressão de soma deve resultar em um inteiro
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), Boolean.FALSE);
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(4)), new NoInteiro(10), Boolean.TRUE);
    }
    
    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), Boolean.FALSE);
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

    @Test
    public void testCharacter() throws Exception
    {
        test(new NoCaracter('a'), new NoCaracter('a'), Boolean.FALSE);
        test(new NoCaracter('a'), new NoCaracter('b'), Boolean.TRUE);
    }

    @Test
    public void testString() throws Exception
    {
        test(new NoCadeia("test"), new NoCadeia("test"), Boolean.FALSE);
        test(new NoCadeia("test"), new NoCadeia("t"), Boolean.TRUE);
    }

    @Test
    public void testBoolean() throws Exception
    {
        test(new NoLogico(true), new NoLogico(true), Boolean.FALSE);
        test(new NoLogico(true), new NoLogico(false), Boolean.TRUE);
    }
    
    private void test(NoExpressao a, NoExpressao b, Boolean expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoLogicaDiferenca igualdade = new NoOperacaoLogicaDiferenca(a, b);
        Object result = depurador.visitar(igualdade);
        assertEquals(expectedResult, result);
    }
   
}
