package br.univali.portugol.nucleo.execucao.operacoes.bitwise;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseOu;
import br.univali.portugol.nucleo.execucao.Depurador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class OperacaoBitwiseOUTest
{
    private final Depurador depurador;
    
    public OperacaoBitwiseOUTest()
    {
        depurador = new Depurador();
    }

     @Test
    public void test() throws Exception
    {
        test(new NoInteiro(0), new NoInteiro(0), 0);
        test(new NoInteiro(1), new NoInteiro(0), 1);
        test(new NoInteiro(0), new NoInteiro(1), 1);
        test(new NoInteiro(1), new NoInteiro(1), 1);
    }
    
    private void test(NoExpressao a, NoExpressao b, Integer expectedResult) throws ExcecaoVisitaASA
    {
        NoOperacaoBitwiseOu eBitwise = new NoOperacaoBitwiseOu(a, b);
        Integer result = depurador.visitar(eBitwise);
        assertEquals(expectedResult, result);
    }
   
}
