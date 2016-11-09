/*
Este é um teste de integração que percorre todos os exemplos do PS e para cada exemplo:
1 - Gerado o código Java para o exemplo
2 - Escreve o código gerado em um arquivo
3 - Envia o código java gerado para o javac e verifica se existem erros sintáticos no código java gerado
 */
package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.execucao.gerador.GeradorCodigoJava;
import br.univali.portugol.nucleo.ErroCompilacao;
import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elieser
 */
public class IntegracaoGeradorCodigoJavacTest
{
    @Test 
    public void testaErrosSintaticosNoCodigoGerado() throws FileNotFoundException, ErroCompilacao, ExcecaoVisitaASA, IOException
    {
        File dirExemplos = new File("../Portugol-Studio-Recursos/exemplos");
        File[] dirs = dirExemplos.listFiles();
        for (File dir : dirs)
        {
            geraCodigo(dir);
        }
        //geraCodigo(new File("../Portugol-Studio-Recursos/exemplos/jogos/corrida.por"));
        //geraCodigo(new File("../Portugol-Studio-Recursos/exemplos/musica/bateria.por"));
    }
    
    public List<String> check(String file) {
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromStrings(Arrays.asList(file));

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

        List<String> messages = new ArrayList<String>();
        Formatter formatter = new Formatter();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            messages.add(diagnostic.getKind() + ":\t Line [" + diagnostic.getLineNumber() + "] \t Position [" + diagnostic.getPosition() + "]\t" + diagnostic.getMessage(Locale.ROOT) + "\n");
        }

        return messages;
    }
    
    private void geraCodigo(File exemplo) throws FileNotFoundException, ErroCompilacao, ExcecaoVisitaASA, IOException
    {
        System.out.println(exemplo);
        if (exemplo.isDirectory()) {
            File files[] = exemplo.listFiles();
            for (File file : files)
            {
                geraCodigo(file);
            }
        }
        else
        {
            List<String> ignore = new ArrayList<>();
            ignore.add("varios.por");
            ignore.add("logico.por");
            ignore.add("lagarta.por");
            
            if (ignore.contains(exemplo.getName()))
                return;
                
            if (exemplo.getName().endsWith(".por"))
            {
                String codigoPortugol = new Scanner(exemplo).useDelimiter("\\Z").next(); //Lê todo o conteúdo do arquivo de exemplo
                AnalisadorAlgoritmo aa = new AnalisadorAlgoritmo();
                aa.analisar(codigoPortugol);
                GeradorCodigoJava gerador = new GeradorCodigoJava();
                String nomeExemplo = exemplo.getName().replace(".por", "");
                String nomeClasse = "Exemplo" + (nomeExemplo.substring(0, 1).toUpperCase() + nomeExemplo.substring(1));
                String arquivoJava = "../" + nomeClasse + ".java";
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(arquivoJava)));
                try
                {
                    gerador.gera((ASAPrograma) aa.getASA(), writer, nomeClasse, true, true, true);
                }
                finally
                {
                    writer.close();
                }
                
                List<String> erros = check(arquivoJava);
                if (!erros.isEmpty())
                {
                    System.out.println("Erros encontrados em " + arquivoJava);
                    for (String erro : erros)
                    {
                        System.out.println("\t" + erro);
                    }
                }
                Assert.assertEquals(0, erros.size());
            }
        }
    }
}
