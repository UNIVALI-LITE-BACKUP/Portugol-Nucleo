package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoDivisao;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoDivisaoTest
{
    private final Depurador depurador;

    public OperacaoDivisaoTest()
    {
        depurador = new Depurador();
    }
 
    @Test(expected = ExcecaoVisitaASA.class)
    public void testDivisaoPorZeroInteiroReal() throws Exception
    {
        test(new NoInteiro(5), new NoReal(0.0), 0);
    }
    
    @Test(expected = ExcecaoVisitaASA.class)
    public void testDivisaoPorZeroInteiroInteiro() throws Exception
    {
        test(new NoInteiro(5), new NoInteiro(0), 0);
    }
    
    @Test(expected = ExcecaoVisitaASA.class)
    public void testDivisaoPorZeroInteiroExpresaoInteira() throws Exception
    {
        test(new NoInteiro(1), new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(-5)), 0);
    }
    
    @Test
    public void testExpressaoInteira() throws Exception
    {
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), 1);
        test(new NoOperacaoSoma(new NoInteiro(10), new NoInteiro(10)), new NoInteiro(2), 10);
    }

    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), 1);
        test(new NoInteiro(10), new NoInteiro(2), 5);
    }

    @Test
    public void testInteiroDouble() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), 1.0);
        test(new NoInteiro(5), new NoReal(2), 2.5);
    }

    @Test
    public void testDouble() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), 1.0);
        test(new NoReal(10.0), new NoReal(2.0), 5.0);
    }

    @Test
    public void testDoubleInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), 1.0);
        test(new NoReal(10.0), new NoInteiro(2), 5.0);
    }

    private void test(NoExpressao a, NoExpressao b, Number resultadoEsperado) throws ExcecaoVisitaASA
    {
        NoOperacaoDivisao divisao = new NoOperacaoDivisao(a, b);
        Number resultado = depurador.visitar(divisao);
        assertEquals(resultadoEsperado, resultado);
    }

}
