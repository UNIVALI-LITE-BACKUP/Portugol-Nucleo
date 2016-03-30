/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.CompiladorTestCodes.FileHandle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 4276663
 */
public class CompiladorTest
{

    public CompiladorTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of compilar method, of class Compilador.
     */
    @Test
    public void testCompilar() throws Exception
    {
        Compilador compilador = new Compilador();
        //Códigos que deverão ser aceitos pelo teste de compilação
        List<String> codigos = abrirTestesAceitos();
        for (String codigo : codigos)
        {
            try{
                compilador.compilar(codigo);
            }catch(ErroCompilacao ex){
                System.out.println("O teste falhou, codigo fonte:\n"+codigo+"\nErro gerado:\n" +ex.construirMensagem());
                fail();
            }
        }
        
        // TODO review the generated test code and remove the default call to fail.
    }

    private List<String> abrirTestesAceitos() throws Exception
    {
        List<String> codigosFontes = new ArrayList<>();
        File[] arquivos = new File(getClass().getResource("CompiladorTestCodes/testesAceitos").toURI()).listFiles();
        for (File arquivo : arquivos)
        {
            if (arquivo.toString().matches(".+\\.por$"))
            {
                codigosFontes.add(FileHandle.open(arquivo));
            }
        }
        return codigosFontes;
    }

}
