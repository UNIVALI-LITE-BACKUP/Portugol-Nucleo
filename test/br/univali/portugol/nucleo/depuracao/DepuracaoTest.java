package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.ErroCompilacao;
import br.univali.portugol.nucleo.Portugol;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz Fernando
 */
public class DepuracaoTest
{
    @Test
    public void testPontoDeParadaSimples() throws Exception
    {
        String codigo = carregarCodigo("tabuada.por");
        Programa programa = Portugol.compilar(codigo);
        
        assertTrue("linha 3 falhou",programa.adicionarPontoParada(3));
        assertTrue("linha 5 falhou",programa.adicionarPontoParada(5));
        assertTrue(programa.adicionarPontoParada(7));
        assertTrue(programa.adicionarPontoParada(8));
        assertTrue(programa.adicionarPontoParada(10));
        assertTrue(programa.adicionarPontoParada(12));
        assertTrue("linha 14 falhou", programa.adicionarPontoParada(14));
        assertTrue(programa.adicionarPontoParada(15));
        
        assertFalse(programa.adicionarPontoParada(1));
        assertFalse(programa.adicionarPontoParada(2));
        assertFalse(programa.adicionarPontoParada(4));        
        assertFalse(programa.adicionarPontoParada(6));
        assertFalse(programa.adicionarPontoParada(9));
        assertFalse(programa.adicionarPontoParada(11));        
        assertFalse(programa.adicionarPontoParada(13));
        assertFalse(programa.adicionarPontoParada(16));
        assertFalse(programa.adicionarPontoParada(17));
        assertFalse(programa.adicionarPontoParada(18));
        //programa.depurar(null, false);
        
        //assertFalse(true);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    private String carregarCodigo(String nome)
    {
        nome = "br/univali/portugol/nucleo/depuracao/" + nome;
        String line;
        StringBuilder  sb = new StringBuilder("");
        
        try (InputStreamReader isr = new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(nome)); BufferedReader br = new BufferedReader(isr))
        {            
            while ((line = br.readLine()) != null)
            {
                sb.append(line);
                sb.append("\n");
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace(System.err);
        }
        
        return sb.toString();
    }
}
