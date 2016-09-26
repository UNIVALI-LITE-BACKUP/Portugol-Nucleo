package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseRightShift;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoBitwiseRightShiftTest
{
    private final Depurador depurador;
    
    public OperacaoBitwiseRightShiftTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void test() throws Exception
    {
        test(new NoInteiro(0), new NoInteiro(1), 0); // 0 >> 1 = 0
        test(new NoInteiro(1), new NoInteiro(1), 0); // 1 >> 1 = 0 
        test(new NoInteiro(2), new NoInteiro(1), 1); // 2 >> 1 = 1
        test(new NoInteiro(4), new NoInteiro(1), 2); // 4 >> 1 = 2
        test(new NoInteiro(5), new NoInteiro(2), 1); // 4 >> 2 = 1
    }
    
    private void test(NoExpressao a, NoExpressao b, Integer expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoBitwiseRightShift eBitwise = new NoOperacaoBitwiseRightShift(a, b);
        Integer result = depurador.visitar(eBitwise);
        assertEquals(expectedResult, result);
    }
   
}
