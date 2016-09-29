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

    @Test
    public void testProgramaVazio() throws ErroCompilacao
    {
        String codigoPortugol = "programa {"
                + "	funcao inicio() {"
                + "	}\n"
                + "}";

        String codigoEsperado = "import br.univali.portugol.nucleo.Programa;"
                + "public class Programa1 extends Programa"
                + "{"
                + "   @override"
                + "   protected void executar() throws ErroExecucao"
                + "   {"
                + "       System.out.println(\"testando\");"
                + "   }"
                + "}";

        AnalisadorAlgoritmo analisador = new AnalisadorAlgoritmo();
        analisador.analisar(codigoPortugol);
        ArvoreSintaticaAbstrata asa = analisador.getArvoreSintaticaAbstrata();

        // gera o código e escreve em um ByteArrayOutputStream
        GeradorCodigo gerador = new GeradorCodigo();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        gerador.gera(asa, bos);

        String codigoGerado = bos.toString().replaceAll("\\s+", ""); //remove todos os espaços e caracteres não visíveis
        codigoEsperado = codigoEsperado.replaceAll("\\s+", "");
        
        assertEquals(codigoEsperado, codigoGerado);
    }

}
