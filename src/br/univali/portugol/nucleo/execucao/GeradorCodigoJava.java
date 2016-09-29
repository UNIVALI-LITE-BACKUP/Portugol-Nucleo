package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.TipoDado;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorCodigoJava
{
    public void gera(ASAPrograma asa, OutputStream saida, String nomeClasseJava)
    {
        PrintStream out = new PrintStream(saida);
        
        geraCodigoImportacoes(getListaImportacoes(asa), out);
        
        out.format("public class %s extends Programa \n", nomeClasseJava)
           .append("{ \n")
           .append(" \n");
        
        geraCodigoDasVariaveisGlobais(asa, out);
        
        out.append(" \n")
           .append("   @override \n")
           .append("   protected void executar() throws ErroExecucao \n")
           .append("   { \n")
           .append("     \n")
           .append("   }\n")
           .print("}\n");
    }

    private void geraCodigoDasVariaveisGlobais(ASAPrograma asa, PrintStream out)
    {
        List<NoDeclaracao> variaveisGlobais = asa.getListaDeclaracoesGlobais();
        for (NoDeclaracao declaracao : variaveisGlobais)
        {
            if (declaracao instanceof NoDeclaracaoVariavel)
            {
                String tipo = getNomeTipoJava(declaracao.getTipoDado());
                String nomeVariavel = declaracao.getNome();
                out.format("private %s %s;", tipo, nomeVariavel);
            }
        }
    }
    
    private String getNomeTipoJava(TipoDado tipoPortugol)
    {
        switch (tipoPortugol)
        {
            case INTEIRO: return "int";
            case REAL: return "double";
            case CADEIA: return "String";
            case CARACTER: return "char";
            case LOGICO: return "boolean";
            case VAZIO: return "void";
        }
        
        String mensagem = String.format("Não foi possível traduzir o tipo %s do Portugol para um tipo JAva.", tipoPortugol.getNome());
        throw new IllegalStateException(mensagem);
    }
    
    private List<String> getListaImportacoes(ASAPrograma asa)
    {
        List<String> importacoes = new ArrayList<>();
        
        // importação para a classe base do programa
        importacoes.add(Programa.class.getCanonicalName()); 
        
        // importação para as bibliotecas do PS
        List<NoInclusaoBiblioteca> bibliotecasIncluidas = asa.getListaInclusoesBibliotecas();
        String pacoteDasLibs = "br.univali.portugol.nucleo.bibliotecas.";
        for (NoInclusaoBiblioteca biblioteca : bibliotecasIncluidas)
        {
            importacoes.add(pacoteDasLibs + biblioteca.getNome());
        }
        
        return importacoes;
    }
    
    private void geraCodigoImportacoes(List<String> importacoes, PrintStream out)
    {
        for (String importacao : importacoes)
        {
            out.format("import %s; \n", importacao);
        }
        out.println(); // pula uma linha depois das importações
    }
}
