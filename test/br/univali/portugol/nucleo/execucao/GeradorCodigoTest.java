package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.ErroCompilacao;
import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Elieser
 */
public class GeradorCodigoTest
{
    private final AnalisadorAlgoritmo analisador = new AnalisadorAlgoritmo();
    private final GeradorCodigo gerador = new GeradorCodigo();
    
    @Test
    public void testProgramaVazio() throws ErroCompilacao
    {
        String codigoPortugol = "programa {"
                + "	funcao inicio() {"
                + "	}\n"
                + "}";

        String codigoJavaEsperado = "import br.univali.portugol.nucleo.Programa;"
                + "public class Programa1 extends Programa"
                + "{"
                + "   @override"
                + "   protected void executar() throws ErroExecucao"
                + "   {"
                + "   }"
                + "}";

        comparaCodigos(codigoPortugol, codigoJavaEsperado);
        
    }

    private void comparaCodigos(String codigoPortugol, String codigoJavaEsperado)
    {
        analisador.analisar(codigoPortugol);
        ArvoreSintaticaAbstrata asa = analisador.getArvoreSintaticaAbstrata();

        // gera o código e escreve em um ByteArrayOutputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        gerador.gera(asa, bos);

        String codigoGerado = bos.toString().replaceAll("\\s+", ""); //remove todos os espaços e caracteres não visíveis
        codigoJavaEsperado = codigoJavaEsperado.replaceAll("\\s+", "");
        
        assertEquals(codigoJavaEsperado, codigoGerado);
    }
}
