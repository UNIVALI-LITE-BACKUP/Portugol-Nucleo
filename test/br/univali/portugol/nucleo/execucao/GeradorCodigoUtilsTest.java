package br.univali.portugol.nucleo.execucao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class GeradorCodigoUtilsTest
{
    @Test
    public void testStringComAspasDuplas()
    {
        String string = "\"string com \"aspas\" duplas\"";
        String expResult = "\\\"string com \\\"aspas\\\" duplas\\\"";
        String result = GeradorCodigoUtils.preservaCaracteresEspeciais(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStringComQuebraDeLinha()
    {
        String string = "string com quebra de linha\n";
        String expResult = "string com quebra de linha\\n";
        String result = GeradorCodigoUtils.preservaCaracteresEspeciais(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStringLimpa()
    {
        String string = "string sem aspas ou quebra de linha";
        String expResult = new String(string);
        String result = GeradorCodigoUtils.preservaCaracteresEspeciais(string);
        assertEquals(expResult, result);
    }
    
}
