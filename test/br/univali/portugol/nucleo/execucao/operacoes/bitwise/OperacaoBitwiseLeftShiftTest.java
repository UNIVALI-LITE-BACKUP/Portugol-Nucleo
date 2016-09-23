package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseE;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseLeftShift;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoBitwiseLeftShiftTest
{
    private final Depurador depurador;
    
    public OperacaoBitwiseLeftShiftTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void test() throws Exception
    {
        test(new NoInteiro(0), new NoInteiro(1), 0); // 0 << 1 = 0
        test(new NoInteiro(1), new NoInteiro(1), 2); // 1 << 1 = 2 
        test(new NoInteiro(1), new NoInteiro(2), 4); // 1 << 2 = 4
        test(new NoInteiro(1), new NoInteiro(3), 8); // 1 << 3 = 8
    }
    
    private void test(NoExpressao a, NoExpressao b, Integer expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoBitwiseLeftShift eBitwise = new NoOperacaoBitwiseLeftShift(a, b);
        Integer result = depurador.visitar(eBitwise);
        assertEquals(expectedResult, result);
    }
   
}
