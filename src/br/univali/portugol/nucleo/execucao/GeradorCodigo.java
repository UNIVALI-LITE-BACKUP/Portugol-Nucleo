package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorCodigo
{
    private static long idProgramas = 0;
    
    public void gera(ArvoreSintaticaAbstrata asa, OutputStream saida)
    {
        PrintStream out = new PrintStream(saida);
        String nomeClasse = geraNomeClasse();
        
        List<String> importacoes = new ArrayList<>();
        importacoes.add(Programa.class.getCanonicalName()); // importa a classe base
                
        geraCodigoImportacoes(importacoes, out);
        
        out
            .format("public class %s extends Programa \n", nomeClasse)
            .append("{ \n")
            .append(" \n")
            .append("   @override \n")
            .append("   protected void executar() throws ErroExecucao \n")
            .append("   { \n")
            .append("       System.out.println(\"testando\"); \n")
            .append("   }\n")
            .print("}\n");

    }
    
    private void geraCodigoImportacoes(List<String> importacoes, PrintStream out)
    {
        for (String importacao : importacoes)
        {
            out.format("import %s; \n", importacao);
        }
        out.println(); // pula uma linha depois das importações
    }

    private String geraNomeClasse()
    {
        return "Programa" + String.valueOf(++idProgramas);
    }
}
