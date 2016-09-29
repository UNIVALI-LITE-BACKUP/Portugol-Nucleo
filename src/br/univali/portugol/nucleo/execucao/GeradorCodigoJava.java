package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoInicializavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorCodigoJava
{
    private static final String PACOTE_DAS_LIBS = "br.univali.portugol.nucleo.bibliotecas.";
    private Visitor visitor;
            
    public void gera(ASAPrograma asa, OutputStream saida, String nomeClasseJava) throws ExcecaoVisitaASA
    {
        PrintStream out = new PrintStream(saida);
        
        visitor = new Visitor();
        
        geraCodigoImportacoes(getListaImportacoes(asa), out);
        
        out.format("public class %s extends Programa \n", nomeClasseJava)
           .append("{ \n")
           .append(" \n");
        
        geraCodigoDosAtributos(asa, out);
        
        out.append(" \n")
           .append("   @override \n")
           .append("   protected void executar() throws ErroExecucao \n")
           .append("   { \n")
           .append("     \n")
           .append("   }\n")
           .print("}\n");
    }

    private void geraAtributosParaAsVariaveisGlobais(ASAPrograma asa, PrintStream out) throws ExcecaoVisitaASA
    {
        List<NoDeclaracao> variaveisGlobais = asa.getListaDeclaracoesGlobais();
        for (NoDeclaracao noDeclaracao : variaveisGlobais)
        {
            if (noDeclaracao instanceof NoDeclaracaoVariavel)
            {
                String tipo = getNomeTipoJava(noDeclaracao.getTipoDado());
                String nomeVariavel = noDeclaracao.getNome();
                
                NoDeclaracaoInicializavel noDeclaracaoVariavel = (NoDeclaracaoInicializavel) noDeclaracao;
                
                String inicializacao = "";
                if (noDeclaracaoVariavel.possuiInicializacao())
                {
                    inicializacao = String.format(" = %s", getValorInicializacao(noDeclaracaoVariavel));
                }
                String constante = (noDeclaracaoVariavel.constante()) ? "final " : "";
                out.format("private %s%s %s%s; \n", constante, tipo, nomeVariavel, inicializacao);
            }
        }
    }
    
    private String getValorInicializacao(NoDeclaracaoInicializavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        if (!noDeclaracaoVariavel.possuiInicializacao())
        {
            return "";
        }

        Object valor = noDeclaracaoVariavel.getInicializacao().aceitar(visitor);
        switch (noDeclaracaoVariavel.getTipoDado())
        {
            case CADEIA: return String.format("\"%s\"", valor); //coloca a string dentro de aspas duplas
            case CARACTER: return String.format("'%s'", valor); //coloca o caracter dentro de aspas simples
            case LOGICO: return ((Boolean)valor) ? "true" : "false";
            case VAZIO: return "void";
        }
            
        return valor.toString();
    }
    
    private void geraAtributosParaAsBibliotecasIncluidas(ASAPrograma asa, PrintStream out)
    {
        List<NoInclusaoBiblioteca> libsIncluidas = asa.getListaInclusoesBibliotecas();
        for (NoInclusaoBiblioteca biblioteca : libsIncluidas)
        {
            String tipo = biblioteca.getNome();
            String nome = tipo; // quando a biblioteca não tem alias o nome e o tipo são idênticos
            if (biblioteca.getAlias() != null)
            {
                nome = biblioteca.getAlias();
            }
            out.format("private %s %s = new %s(); \n", tipo, nome, tipo);
        }
    }
    
    private void geraCodigoDosAtributos(ASAPrograma asa, PrintStream out) throws ExcecaoVisitaASA
    {
        geraAtributosParaAsVariaveisGlobais(asa, out); 
        
        geraAtributosParaAsBibliotecasIncluidas(asa, out);
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
        
        for (NoInclusaoBiblioteca biblioteca : bibliotecasIncluidas)
        {
            importacoes.add(PACOTE_DAS_LIBS + biblioteca.getNome());
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
    
    private class Visitor extends VisitanteASABasico
    {
        @Override
        public Integer visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
        {
            return noInteiro.getValor();
        }

        @Override
        public Boolean visitar(NoLogico noLogico) throws ExcecaoVisitaASA
        {
            return noLogico.getValor();
        }
        
        @Override
        public Character visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
        {
            return noCaracter.getValor();
        }
        
        @Override
        public Double visitar(NoReal noReal) throws ExcecaoVisitaASA
        {
            return noReal.getValor();
        }
        
        @Override
        public String visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
        {
            return noCadeia.getValor();
        }
    }
}
