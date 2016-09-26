package br.univali.portugol.nucleo.execucao.operacoes.aritmeticas;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoModulo;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoModuloTest
{
    private final Depurador depurador;

    public OperacaoModuloTest()
    {
        depurador = new Depurador();
    }

    @Test(expected = ExcecaoVisitaASA.class)
    public void testDivisaoPorZeroInteiroInteiro() throws Exception
    {
        test(new NoInteiro(5), new NoInteiro(0), 0);
    }
    
    @Test(expected = ExcecaoVisitaASA.class)
    public void testDivisaoPorZeroInteiroReal() throws Exception
    {
        test(new NoInteiro(1), new NoReal(0.0), 0);
    }
    
    @Test
    public void testExpressaoInteira() throws Exception
    {
        test(new NoOperacaoSoma(new NoInteiro(5), new NoInteiro(5)), new NoInteiro(10), 0);  // 10 % 10
        test(new NoOperacaoSoma(new NoInteiro(10), new NoInteiro(10)), new NoInteiro(2), 0);// 20 % 2
        test(new NoInteiro(10), new NoInteiro(9), 1);// 10 % 9
        test(new NoInteiro(11), new NoInteiro(7), 4);// 11 % 7
    }

    @Test
    public void testInteiros() throws Exception
    {
        test(new NoInteiro(10), new NoInteiro(10), 0);
        test(new NoInteiro(10), new NoInteiro(9), 1);
    }

    private void test(NoExpressao a, NoExpressao b, Integer resultadoEsperado) throws ExcecaoVisitaASA
    {
        NoOperacaoModulo modulo = new NoOperacaoModulo(a, b);
        Integer resultado = depurador.visitar(modulo);
        assertEquals(resultadoEsperado, resultado);
    }

}
