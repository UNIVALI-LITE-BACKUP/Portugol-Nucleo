package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.mensagens.ErroAnalise;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Elieser
 */
@RunWith(Parameterized.class)
public class GeradorCodigoTest
{
    private final AnalisadorAlgoritmo analisador = new AnalisadorAlgoritmo();
    private final GeradorCodigoJava gerador = new GeradorCodigoJava();

    private final static FilenameFilter FILTRO_PORTUGOL = new FiltroArquivoPortugol();

    private final String nomeTeste;

    public GeradorCodigoTest(String nomeTeste)
    {
        this.nomeTeste = nomeTeste;
    }

    @Parameters(name = "{0}") // usa o primeiro parâmetro do construtor como nome do teste
    public static Iterable<String[]> geraNomesTestes()
    {
        /**
         * Gera um teste unitário para cada par de arquivos .por e .java encontrados
         */
        
        String caminhoArquivos = "test/br/univali/portugol/nucleo/execucao/arquivos/";
        List<String[]> arquivos = new ArrayList<String[]>();

        String[] nomesArquivos = new File(caminhoArquivos).list(FILTRO_PORTUGOL);

        for (String nomeArquivo : nomesArquivos)
        {
            arquivos.add(new String[]
            {
                nomeArquivo.replace(".por", "")
            });
        }

        return arquivos;
    }

    @Test
    public void teste() throws Exception
    {
        // lê o arquivo portugol e o código esperado em java 
        String caminhoArquivos = "test/br/univali/portugol/nucleo/execucao/arquivos/";
        File arquivoPortugol = new File(caminhoArquivos + nomeTeste + ".por");
        File arquivoJava = new File(caminhoArquivos + nomeTeste + ".java");

        String codigoPortugol = new Scanner(arquivoPortugol).useDelimiter("\\Z").next(); //Lê todo o conteúdo do arquivo de exemplo
        String codigoJavaEsperado = new Scanner(arquivoJava).useDelimiter("\\Z").next();

        // verifica se o código portugol não tem erros antes de gerar o código java
        ResultadoAnalise resultado = analisador.analisar(codigoPortugol);
        assertNotNull(resultado);
        assertNotNull(resultado.getErros());
        List<ErroAnalise> erros = resultado.getErros();
        if (!erros.isEmpty())
        {
            for (ErroAnalise erro : erros)
            {
                System.out.println(erro);
            }
        }
        assertEquals(0, resultado.getErros().size());

        // gera o código e escreve em um ByteArrayOutputStream para os códigos sejam comparados através de duas strings
        ASAPrograma asa = (ASAPrograma) analisador.getASA();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(bos);//(System.out, true);
        gerador.gera(asa, writer, nomeTeste);
        writer.flush();
        String codigoGerado = bos.toString();

        //System.out.println(codigoGerado); // escreve o código gerado antes de remover a formatação        
        codigoGerado = codigoGerado.replaceAll("\\s+|\\\\n", ""); //remove todos os espaços e caracteres não visíveis
        codigoJavaEsperado = codigoJavaEsperado.replaceAll("\\s+|\\\\n", "");

        //System.out.println(codigoJavaEsperado);
        //System.out.println(codigoGerado);
        //System.out.println();
        assertEquals(codigoJavaEsperado, codigoGerado);
    }

    private static class FiltroArquivoPortugol implements FilenameFilter
    {
        @Override
        public boolean accept(File dir, String name)
        {
            return name.endsWith(".por");
        }
    }
}
