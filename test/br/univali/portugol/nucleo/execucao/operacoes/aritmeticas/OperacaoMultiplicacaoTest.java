package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoMultiplicacao;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoMultiplicacaoTest
{
    private final Depurador depurador;

    public OperacaoMultiplicacaoTest()
    {
        depurador = new Depurador();
    }

    @Test
    public void testExpressaoInteira() throws Exception
    {
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), 100);
        test(new NoOperacaoSoma(new NoInteiro(10), new NoInteiro(10)), new NoInteiro(2), 40);
        test(new NoOperacaoSoma(new NoInteiro(10), new NoInteiro(10)), new NoInteiro(0), 0);
    }

    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), 100);
        test(new NoInteiro(10), new NoInteiro(2), 20);
    }

    @Test
    public void testInteiroDouble() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), 100.0);
        test(new NoInteiro(5), new NoReal(2), 10.0);
    }

    @Test
    public void testDouble() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), 100.0);
        test(new NoReal(10.0), new NoReal(2.0), 20.0);
    }

    @Test
    public void testDoubleInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), 100.0);
        test(new NoReal(10.0), new NoInteiro(2), 20.0);
    }

    private void test(NoExpressao a, NoExpressao b, Number resultadoEsperado) throws ExcecaoVisitaASA
    {
        NoOperacaoMultiplicacao multiplicacao = new NoOperacaoMultiplicacao(a, b);
        Number resultado = depurador.visitar(multiplicacao);
        assertEquals(resultadoEsperado, resultado);
    }

}
