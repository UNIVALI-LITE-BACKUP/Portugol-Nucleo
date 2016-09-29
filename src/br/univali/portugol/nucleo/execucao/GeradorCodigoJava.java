package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
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
        
        out.append("package programas;\n");
        
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
                    Object valor = noDeclaracaoVariavel.getInicializacao().aceitar(visitor);
                    inicializacao = String.format(" = %s", valor);
                }
                String constante = (noDeclaracaoVariavel.constante()) ? "final " : "";
                out.format("private %s%s %s%s; \n", constante, tipo, nomeVariavel, inicializacao);
            }
        }
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
        public String visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
        {
            return String.valueOf(noInteiro.getValor());
        }

        private String geraCodigoComParenteses(String valor, NoExpressao no)
        {
            if (no.estaEntreParenteses())
            {
                return "(" + valor + ")";
            }
            return valor;
        }
        
        @Override
        public String visitar(NoLogico noLogico) throws ExcecaoVisitaASA
        {
            String valor = noLogico.getValor() ? "true" : "false";
            return geraCodigoComParenteses(valor, noLogico);
        }
        
        @Override
        public String visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
        {
            String valor = "'" + noCaracter.getValor() + "'";
            return geraCodigoComParenteses(valor, noCaracter);
        }
        
        @Override
        public String visitar(NoReal noReal) throws ExcecaoVisitaASA
        {
            String valor = String.valueOf(noReal.getValor());
            return geraCodigoComParenteses(valor, noReal);
        }
        
        @Override
        public String visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
        {
            String valor = "\"" + noCadeia.getValor() + "\"";
            return geraCodigoComParenteses(valor, noCadeia);
        }

        @Override
        public String visitar(NoOperacaoBitwiseLeftShift leftShift) throws ExcecaoVisitaASA
        {
            Object a = leftShift.getOperandoEsquerdo().aceitar(this);
            Object b = leftShift.getOperandoDireito().aceitar(this);
            String valor = a + " << " + b;
            return geraCodigoComParenteses(valor, leftShift);
        }
        
        @Override
        public String visitar(NoOperacaoBitwiseRightShift rightShift) throws ExcecaoVisitaASA
        {
            Object a = rightShift.getOperandoEsquerdo().aceitar(this);
            Object b = rightShift.getOperandoDireito().aceitar(this);
            String valor = a + " >> " + b;
            return geraCodigoComParenteses(valor, rightShift);
        }
        
        @Override
        public String visitar(NoOperacaoBitwiseE no) throws ExcecaoVisitaASA
        {
            Object a = no.getOperandoEsquerdo().aceitar(this);
            Object b = no.getOperandoDireito().aceitar(this);
            String valor = a + " & " + b;
            return geraCodigoComParenteses(valor, no);
        }
        
        @Override
        public String visitar(NoOperacaoBitwiseXOR no) throws ExcecaoVisitaASA
        {
            Object a = no.getOperandoEsquerdo().aceitar(this);
            Object b = no.getOperandoDireito().aceitar(this);
            String valor = a + " ^ " + b;
            return geraCodigoComParenteses(valor, no);
        }
        
        @Override
        public String visitar(NoOperacaoBitwiseOu no) throws ExcecaoVisitaASA
        {
            Object a = no.getOperandoEsquerdo().aceitar(this);
            Object b = no.getOperandoDireito().aceitar(this);
            String valor = a + " | " + b;
            return geraCodigoComParenteses(valor, no);
        }
        
        @Override
        public String visitar(NoOperacaoSoma soma) throws ExcecaoVisitaASA
        {
            Object a = soma.getOperandoEsquerdo().aceitar(this);
            Object b = soma.getOperandoDireito().aceitar(this);
            String valor = a + " + " + b;
            return geraCodigoComParenteses(valor, soma);
        }
        
        @Override
        public String visitar(NoOperacaoDivisao divisao) throws ExcecaoVisitaASA
        {
            Object a = divisao.getOperandoEsquerdo().aceitar(this);
            Object b = divisao.getOperandoDireito().aceitar(this);
            String valor = a  + " / " + b;
            return geraCodigoComParenteses(valor, divisao);
        }
        
        @Override
        public String visitar(NoOperacaoSubtracao subtracao) throws ExcecaoVisitaASA
        {
            Object a = subtracao.getOperandoEsquerdo().aceitar(this);
            Object b = subtracao.getOperandoDireito().aceitar(this);
            String valor = a  + " - " + b;
            return geraCodigoComParenteses(valor, subtracao);
        }
        
        @Override
        public String visitar(NoOperacaoMultiplicacao multiplicacao) throws ExcecaoVisitaASA
        {
            Object a = multiplicacao.getOperandoEsquerdo().aceitar(this);
            Object b = multiplicacao.getOperandoDireito().aceitar(this);
            String valor = a  + " * " + b;
            return geraCodigoComParenteses(valor, multiplicacao);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaOU noOuLogico) throws ExcecaoVisitaASA
        {
            Object a = noOuLogico.getOperandoEsquerdo().aceitar(this);
            Object b = noOuLogico.getOperandoDireito().aceitar(this);
            String valor = a  + " || " + b;
            return geraCodigoComParenteses(valor, noOuLogico);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaE noELogico) throws ExcecaoVisitaASA
        {
            Object a = noELogico.getOperandoEsquerdo().aceitar(this);
            Object b = noELogico.getOperandoDireito().aceitar(this);
            String valor = a  + " && " + b;
            return geraCodigoComParenteses(valor, noELogico);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaDiferenca noDiferenca) throws ExcecaoVisitaASA
        {
            Object a = noDiferenca.getOperandoEsquerdo().aceitar(this);
            Object b = noDiferenca.getOperandoDireito().aceitar(this);
            String valor = a  + " != " + b;
            return geraCodigoComParenteses(valor, noDiferenca);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaIgualdade noIgualdade) throws ExcecaoVisitaASA
        {
            Object a = noIgualdade.getOperandoEsquerdo().aceitar(this);
            Object b = noIgualdade.getOperandoDireito().aceitar(this);
            
            String valor;
            if (a instanceof String && b instanceof String)
            {
                valor = a  + ".equals(" + b + ")";
            }
            else
            {
                valor = a  + " == " + b;
            }
            return geraCodigoComParenteses(valor, noIgualdade);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaMaior noMaior) throws ExcecaoVisitaASA
        {
            Object a = noMaior.getOperandoEsquerdo().aceitar(this);
            Object b = noMaior.getOperandoDireito().aceitar(this);
            
            String valor = a  + " > " + b;
            return geraCodigoComParenteses(valor, noMaior);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaMaiorIgual noMaiorIgual) throws ExcecaoVisitaASA
        {
            Object a = noMaiorIgual.getOperandoEsquerdo().aceitar(this);
            Object b = noMaiorIgual.getOperandoDireito().aceitar(this);
            
            String valor = a  + " >= " + b;
            return geraCodigoComParenteses(valor, noMaiorIgual);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaMenor noMenor) throws ExcecaoVisitaASA
        {
            Object a = noMenor.getOperandoEsquerdo().aceitar(this);
            Object b = noMenor.getOperandoDireito().aceitar(this);
            
            String valor = a  + " < " + b;
            return geraCodigoComParenteses(valor, noMenor);
        }
        
        @Override
        public String visitar(NoOperacaoLogicaMenorIgual noMenorIgual) throws ExcecaoVisitaASA
        {
            Object a = noMenorIgual.getOperandoEsquerdo().aceitar(this);
            Object b = noMenorIgual.getOperandoDireito().aceitar(this);
            
            String valor = a  + " <= " + b;
            return geraCodigoComParenteses(valor, noMenorIgual);
        }
        
    }
}
