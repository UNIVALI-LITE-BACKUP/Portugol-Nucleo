package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoOperacaoSubtracao;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoSubtracaoTest
{
    private final Depurador depurador;

    public OperacaoSubtracaoTest()
    {
        depurador = new Depurador();
    }

    @Test
    public void testExpressaoInteira() throws Exception
    {
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), 0);
        test(new NoOperacaoSoma(new NoInteiro(10), new NoInteiro(10)), new NoInteiro(2), 18);
    }

    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), 0);
        test(new NoInteiro(10), new NoInteiro(2), 8);
    }

    @Test
    public void testInteiroDouble() throws Exception
    {
        test(new NoInteiro(10), new NoReal(10.0), 0.0);
        test(new NoInteiro(5), new NoReal(2), 3.0);
    }

    @Test
    public void testDouble() throws Exception
    {
        test(new NoReal(10.0), new NoReal(10.0), 0.0);
        test(new NoReal(10.0), new NoReal(2.0), 8.0);
    }

    @Test
    public void testDoubleInteiro() throws Exception
    {
        test(new NoReal(10.0), new NoInteiro(10), 0.0);
        test(new NoReal(10.0), new NoInteiro(2), 8.0);
    }

    private void test(NoExpressao a, NoExpressao b, Number resultadoEsperado) throws ExcecaoVisitaASA
    {
        NoOperacaoSubtracao subtracao = new NoOperacaoSubtracao(a, b);
        Number resultado = depurador.visitar(subtracao);
        assertEquals(resultadoEsperado, resultado);
    }

}
