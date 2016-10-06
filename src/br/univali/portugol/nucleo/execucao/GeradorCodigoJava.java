package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.ErroCarregamentoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosParametros;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Elieser
 */
public class GeradorCodigoJava
{
    private static final String PACOTE_DAS_LIBS = "br.univali.portugol.nucleo.bibliotecas.";

    public void gera(ASAPrograma asa, PrintWriter saida, String nomeClasseJava) throws ExcecaoVisitaASA, IOException
    {
        new GeradorCodigo(asa, saida)
                .geraPackage("programas")
                .pulaLinha()
                .geraImportacaoPara(ErroExecucao.class)
                .geraImportacaoPara(Programa.class)
                .geraImportacaoDasBibliotecasIncluidas()
                .pulaLinha()
                .geraNomeDaClasse(nomeClasseJava)
                .geraChaveDeAberturaDaClasse()
                .pulaLinha()
                .geraAtributosParaAsBibliotecasIncluidas()
                .pulaLinha()
                .geraAtributosParaAsVariaveisGlobais()
                .pulaLinha()
                .geraConstrutor(nomeClasseJava)
                .pulaLinha()
                .geraMetodos()
                .geraChaveDeFechamentoDaClasse();
    }

    private static class GeradorCodigo extends VisitanteASABasico
    {
        private final PrintWriter saida;
        private final ASAPrograma asa;
        private int nivelEscopo = 1;

        public GeradorCodigo(ASAPrograma asa, PrintWriter saida)
        {
            this.saida = saida;
            this.asa = asa;
        }

        private void visitarBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
        {
            nivelEscopo++;
            for (NoBloco bloco : blocos)
            {
                saida.append(geraIdentacao());

                bloco.aceitar(this);

                if (blocoFinalizaComPontoEVirgula(bloco))
                {
                    saida.append(";");
                }
                saida.println();
            }
            nivelEscopo--;
        }

        private static boolean blocoFinalizaComPontoEVirgula(NoBloco bloco)
        {
            boolean ehLoop = bloco instanceof NoPara || bloco instanceof NoEnquanto || bloco instanceof NoFacaEnquanto;
            boolean ehDesvio = bloco instanceof NoSe || bloco instanceof NoEscolha;
            if (!ehLoop && !ehDesvio)
            {
                return true;
            }

            return false;
        }

        private static String geraQuantificador(Quantificador quantificador)
        {
            switch (quantificador)
            {
                case VETOR:
                    return "[]";
                case MATRIZ:
                    return "[][]";
            }
            return "";
        }

        private void geraMetodo(NoDeclaracaoFuncao noFuncao) throws ExcecaoVisitaASA
        {
            saida.println();
            saida.append(geraIdentacao());

            String nome = noFuncao.getNome();
            boolean metodoPrincipal = "inicio".equals(nome);
            if (metodoPrincipal)
            {
                nome = "executar";
                saida.append("@Override").println();
            }

            saida.append(geraIdentacao())
                    .append(metodoPrincipal ? "protected" : "private")
                    .append(" ")
                    .append(getNomeTipoJava(noFuncao.getTipoDado()))
                    .append(geraQuantificador(noFuncao.getQuantificador()))
                    .append(" ")
                    .append(geraNomeValido(nome));

            if (!metodoPrincipal)
            {
                geraStringDosParametros(noFuncao);
            }
            else
            {
                saida.append("(String[] parametros)");
            }
            saida.append(" throws ErroExecucao, InterruptedException");
            saida.println(); // pula uma linha depois da declaração da assinatura do método
            saida.append(geraIdentacao()).append("{").println(); // inicia o escopo do método

            visitarBlocos(noFuncao.getBlocos()); // gera o código dentro do método

            saida.println();
            saida.append(geraIdentacao()).append("}").println(); // finaliza o escopo do método
            saida.println(); // linha em branco depois de cada método
        }

        private boolean podeDeclararNoComoAtributo(NoDeclaracao no)
        {
            return no instanceof NoDeclaracaoVariavel
                    || no instanceof NoDeclaracaoVetor
                    || no instanceof NoDeclaracaoMatriz;
        }

        private String getNomeTipoJava(TipoDado tipoPortugol)
        {
            switch (tipoPortugol)
            {
                case INTEIRO:
                    return "int";
                case REAL:
                    return "double";
                case CADEIA:
                    return "String";
                case CARACTER:
                    return "char";
                case LOGICO:
                    return "boolean";
                case VAZIO:
                    return "void";
            }

            String mensagem = String.format("Não foi possível traduzir o tipo %s do Portugol para um tipo JAva.", tipoPortugol.getNome());
            throw new IllegalStateException(mensagem);
        }

        private void geraStringDosParametros(NoDeclaracaoFuncao noFuncao)
        {
            List<NoDeclaracaoParametro> parametros = noFuncao.getParametros();

            saida.append("("); // parenteses de início da lista de parâmetros
            int size = parametros.size();
            for (int i = 0; i < size; i++)
            {
                NoDeclaracaoParametro noParametro = parametros.get(i);

                saida.append(getNomeTipoJava(noParametro.getTipoDado()))
                        .append(" ") // espaço entre o tipo e o nome
                        .append(geraNomeValido(noParametro.getNome()))
                        .append(geraQuantificador(noParametro.getQuantificador()));

                if (i < size - 1)
                {
                    saida.append(", ");
                }
            }
            saida.append(")"); // parenteses de fim da lista de parâmetros
        }

        public GeradorCodigo geraAtributosParaAsVariaveisGlobais() throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> variaveisGlobais = asa.getListaDeclaracoesGlobais();
            boolean existemVariaveisGlobais = false;
            for (NoDeclaracao no : variaveisGlobais)
            {
                if (podeDeclararNoComoAtributo(no))
                {
                    existemVariaveisGlobais = true;
                    saida.append(geraIdentacao())
                            .append("private ")
                            .append(no.constante() ? "final " : "");

                    no.aceitar(this);

                    saida.append(";").println();
                }
            }

            if (existemVariaveisGlobais)
            {
                saida.println(); // deixa uma linha em branco depois dos atributos globais
            }

            return this;
        }

        public GeradorCodigo geraAtributosParaAsBibliotecasIncluidas()
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
                saida.append(geraIdentacao())
                        .format("private final %s %s = new %s();", tipo, geraNomeValido(nome), tipo)
                        .println();
            }

            if (!libsIncluidas.isEmpty())
            {
                saida.println(); // deixa uma linha em branco depois dos atributos das bibliotecas
            }

            return this;
        }

        private String geraIdentacao()
        {
            return String.format("%" + (nivelEscopo * 3) + "s", " ");
        }

        public GeradorCodigo pulaLinha()
        {
            saida.println();
            return this;
        }

        public GeradorCodigo geraPackage(String stringPackage)
        {
            saida.append("package ")
                    .append(stringPackage)
                    .append(";")
                    .println();

            return this;
        }

        public GeradorCodigo geraMetodos() throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> declaracoes = asa.getListaDeclaracoesGlobais();
            for (NoDeclaracao declaracao : declaracoes)
            {
                if (declaracao instanceof NoDeclaracaoFuncao)
                {
                    geraMetodo((NoDeclaracaoFuncao) declaracao);
                }
            }
            return this;
        }

        @Override
        public Void visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
        {
            saida.append(String.valueOf(noInteiro.getValor()));
            return null;
        }

        @Override
        public Void visitar(NoLogico noLogico) throws ExcecaoVisitaASA
        {
            String valor = noLogico.getValor() ? "true" : "false";
            saida.append(valor);
            return null;
        }

        @Override
        public Void visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
        {
            String valor = "'" + noCaracter.getValor() + "'";
            saida.append(valor);
            return null;
        }

        @Override
        public Void visitar(NoReal noReal) throws ExcecaoVisitaASA
        {
            String valor = String.valueOf(noReal.getValor());
            saida.append(valor);
            return null;
        }

        @Override
        public Void visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
        {
            String valor = GeradorCodigoUtils.preservaCaracteresEspeciais(noCadeia.getValor());
            valor = '\"' + valor + '\"';
            saida.append(valor);
            return null;
        }

        private boolean operandosSaoStrings(NoExpressao a, NoExpressao b)
        {
            return a.getTipoResultante() == TipoDado.CADEIA
                    && b.getTipoResultante() == TipoDado.CADEIA;
        }

        private boolean usaOperadorPadrao(NoOperacao no, boolean operandosSaoStrings)
        {
            if (no instanceof NoOperacaoLogicaIgualdade || no instanceof NoOperacaoLogicaDiferenca)
            {
                return !operandosSaoStrings;
            }

            return true;
        }

        private void geraCodigoComParenteses(NoOperacao no) throws ExcecaoVisitaASA
        {
            if (no.estaEntreParenteses())
            {
                saida.append("(");
            }

            boolean operandosSaoStrings = operandosSaoStrings(no.getOperandoEsquerdo(), no.getOperandoDireito());
            boolean usaOperadorPadrao = usaOperadorPadrao(no, operandosSaoStrings);

            boolean precisaDeNegacao = !usaOperadorPadrao && (no instanceof NoOperacaoLogicaDiferenca);
            if (precisaDeNegacao)
            {
                saida.append("!"); // not equals
            }

            no.getOperandoEsquerdo().aceitar(this);

            if (usaOperadorPadrao)
            {
                String operador = OPERADORES.get(no.getClass());
                assert (operador != null);
                saida.format(" %s ", operador);
            }
            else
            {
                saida.append(".equals(");
            }

            no.getOperandoDireito().aceitar(this);

            if (!usaOperadorPadrao)
            {
                saida.append(")"); // fecha o parênteses do .equals()
            }

            if (no.estaEntreParenteses())
            {
                saida.append(")");
            }
        }

        @Override
        public Void visitar(NoOperacaoBitwiseLeftShift no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseRightShift no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseE no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseXOR no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseOu no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoSoma no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoDivisao no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoModulo no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoSubtracao no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoMultiplicacao no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaOU no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaE no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaDiferenca no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaIgualdade no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMaior no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMaiorIgual no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMenor no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMenorIgual no) throws ExcecaoVisitaASA
        {
            geraCodigoComParenteses(no);
            return null;
        }

        @Override
        public Void visitar(NoDeclaracaoVariavel noDeclaracao) throws ExcecaoVisitaASA
        {
            String nome = noDeclaracao.getNome();
            String tipo = getNomeTipoJava(noDeclaracao.getTipoDado());

            saida.format("%s %s", tipo, geraNomeValido(nome));

            if (noDeclaracao.possuiInicializacao())
            {
                saida.append(" = ");
                noDeclaracao.getInicializacao().aceitar(this);
            }

            return null;
        }

        @Override
        public Void visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
        {
            String nome = no.getNome();
            String tipo = getNomeTipoJava(no.getTipoDado());
            saida.format("%s %s[]", tipo, geraNomeValido(nome));

            if (no.possuiInicializacao())
            {
                saida.append(" = ");
                no.getInicializacao().aceitar(this);
            }
            else
            {
                saida.format(" = new %s[", tipo);
                if (no.getTamanho() != null)
                {
                    no.getTamanho().aceitar(this);
                }
                saida.append("]");
            }

            return null;
        }

        @Override
        public Void visitar(NoVetor noVetor) throws ExcecaoVisitaASA
        {
            saida.append("{");

            List<Object> valores = noVetor.getValores();
            int totalValores = valores.size();
            for (int i = 0; i < totalValores; i++)
            {
                saida.append(valores.get(i).toString());
                if (i < totalValores - 1)
                {
                    saida.append(", ");
                }
            }

            saida.append("}");

            return null;
        }

        @Override
        public Void visitar(NoDeclaracaoMatriz noDeclaracao) throws ExcecaoVisitaASA
        {
            String nome = noDeclaracao.getNome();
            String tipo = getNomeTipoJava(noDeclaracao.getTipoDado());
            saida.format("%s %s[][]", tipo, geraNomeValido(nome));

            saida.append(" = ");

            if (noDeclaracao.possuiInicializacao())
            {
                noDeclaracao.getInicializacao().aceitar(this);
            }
            else
            {
                saida.append(" new ")
                        .append(tipo)
                        .append("[");

                if (noDeclaracao.getNumeroLinhas() != null)
                {
                    noDeclaracao.getNumeroLinhas().aceitar(this);
                }

                saida.append("][");

                if (noDeclaracao.getNumeroColunas() != null)
                {
                    noDeclaracao.getNumeroColunas().aceitar(this);
                }

                saida.append("]");
            }

            return null;
        }

        @Override
        public Void visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
        {
            saida.append("{");

            List<List<Object>> valores = noMatriz.getValores();
            int totalLinhas = valores.size();
            int totalColunas = 0;
            for (int i = 0; i < totalLinhas; i++)
            {
                totalColunas = valores.get(i).size();
                saida.append("{");
                for (int j = 0; j < totalColunas; j++)
                {
                    saida.append(valores.get(i).get(j).toString());
                    if (j < totalColunas - 1)
                    {
                        saida.append(", ");
                    }
                }
                saida.append("}");
                if (i < totalLinhas - 1)
                {
                    saida.append(",");
                }
            }

            saida.append("}");

            return null;
        }

        @Override
        public Void visitar(NoRetorne no) throws ExcecaoVisitaASA
        {
            NoExpressao expressao = no.getExpressao();
            if (expressao != null)
            {
                saida.append("return ");
                if (no.temPai())
                {

                    if (no.getPai() instanceof NoDeclaracaoFuncao)
                    {
                        TipoDado tipoRetornoFuncao = ((NoDeclaracaoFuncao) no.getPai()).getTipoDado();
                        if (expressao.getTipoResultante() == TipoDado.REAL && tipoRetornoFuncao == TipoDado.INTEIRO)
                        {
                            saida.append("(int)");
                        }
                    }
                }
                else
                {
                    throw new IllegalStateException("retorne não tem pai!");
                }

                expressao.aceitar(this);
            }
            else
            {
                saida.append("return");
            }

            return null;
        }

        @Override
        public Void visitar(NoReferenciaVetor no) throws ExcecaoVisitaASA
        {
            saida.append(geraNomeValido(no.getNome()));

            saida.append("[");
            no.getIndice().aceitar(this);
            saida.append("]");

            return null;
        }

        @Override
        public Void visitar(NoReferenciaMatriz no) throws ExcecaoVisitaASA
        {
            saida.append(geraNomeValido(no.getNome()))
                    .append("[");

            no.getLinha().aceitar(this);

            saida.append("][");

            no.getColuna().aceitar(this);

            saida.append("]");

            return null;
        }

        @Override
        public Void visitar(NoReferenciaVariavel no) throws ExcecaoVisitaASA
        {
            String nome = geraNomeValido(no.getNome());
            if (no.getEscopo() != null)
            {
                saida.append(no.getEscopo())
                        .append(".");
            }
            saida.append(nome);

            return null;
        }

        @Override
        public Void visitar(NoEnquanto no) throws ExcecaoVisitaASA
        {
            saida.append("while(");

            no.getCondicao().aceitar(this);

            saida.append(")").println();
            saida.append(geraIdentacao()).append("{").println();

            visitarBlocos(no.getBlocos());

            saida.println();

            saida.append(geraIdentacao()).append("}").println();

            return null;
        }

        @Override
        public Void visitar(NoPara no) throws ExcecaoVisitaASA
        {
            saida.append("for(");
            if (no.getInicializacao() != null)
            {
                no.getInicializacao().aceitar(this);
            }

            saida.append("; "); // separador depois da inicialização do for 

            no.getCondicao().aceitar(this);

            saida.append("; "); // separador depois da c

            if (no.getIncremento() != null)
            {
                no.getIncremento().aceitar(this);
            }

            saida.append(")").println(); // fecha o parênteses do for
            saida.append(geraIdentacao()).append("{").println();

            visitarBlocos(no.getBlocos());

            saida.println();

            saida.append(geraIdentacao()).append("}").println();

            return null;
        }

        @Override
        public Void visitar(NoSe no) throws ExcecaoVisitaASA
        {
            saida.append("if(");

            no.getCondicao().aceitar(this);

            saida.append(")").println();

            saida.append(geraIdentacao()).append("{").println();

            List<NoBloco> blocosVerdadeiros = no.getBlocosVerdadeiros();
            if (blocosVerdadeiros != null)
            {
                visitarBlocos(blocosVerdadeiros);
                saida.println();
            }

            saida.append(geraIdentacao()).append("}").println();

            List<NoBloco> blocosFalsos = no.getBlocosFalsos();
            if (blocosFalsos != null)
            {
                saida.append(geraIdentacao()).append("else").println();
                saida.append(geraIdentacao()).append("{").println();

                visitarBlocos(blocosFalsos);

                saida.println();

                saida.append(geraIdentacao()).append("}").println();
            }

            return null;
        }

        @Override
        public Void visitar(NoEscolha no) throws ExcecaoVisitaASA
        {
            saida.append("switch(");

            no.getExpressao().aceitar(this);

            saida.append(")").println();
            saida.append(geraIdentacao()).append("{").println();

            List<NoCaso> casos = no.getCasos();
            if (casos != null)
            {
                for (NoCaso caso : casos)
                {
                    NoExpressao expressaoCaso = caso.getExpressao();
                    if (expressaoCaso != null)
                    {
                        saida.append(geraIdentacao()).append("case ");

                        expressaoCaso.aceitar(this);

                        saida.append(":").println();
                    }
                    else
                    {
                        saida.append(geraIdentacao()).append("default:");
                    }

                    visitarBlocos(caso.getBlocos());

                    saida.println();
                }
            }

            saida.append(geraIdentacao()).append("}").println();

            return null;
        }

        @Override
        public Void visitar(NoFacaEnquanto no) throws ExcecaoVisitaASA
        {
            saida.append("do").println();
            saida.append(geraIdentacao()).append("{").println();

            List<NoBloco> blocos = no.getBlocos();
            if (blocos != null)
            {
                visitarBlocos(blocos);
                saida.println();
            }

            saida.append(geraIdentacao()).append("}").println();

            saida.append(geraIdentacao()).append("while(");

            no.getCondicao().aceitar(this);

            saida.append(");").println();

            return null;
        }

        @Override
        public Void visitar(NoOperacaoAtribuicao no) throws ExcecaoVisitaASA
        {
            NoExpressao opEsquerdo = no.getOperandoEsquerdo();
            NoExpressao opDireito = no.getOperandoDireito();

            opEsquerdo.aceitar(this);

            saida.append(" = ");

            // verifica se é necessário fazer cast de um double para int
            TipoDado tipoOpEsquerdo = opEsquerdo.getTipoResultante();
            TipoDado tipoOpDireito = opDireito.getTipoResultante();
            boolean castEhNecessario = tipoOpEsquerdo == TipoDado.INTEIRO && tipoOpDireito == TipoDado.REAL;
            if (castEhNecessario)
            {
                saida.append("(int)");
            }

            boolean opDireitoEhOperacao = opDireito instanceof NoOperacao;
            if (castEhNecessario && opDireitoEhOperacao) // coloca toda a operação dentro de parênteses para que o cast seja aplicado no resultado da operação
            {
                saida.append("(");
            }

            no.getOperandoDireito().aceitar(this);

            if (castEhNecessario && opDireitoEhOperacao) // coloca toda a operação dentro de parênteses para que o cast seja aplicado no resultado da operação
            {
                saida.append(")");
            }

            return null;
        }

        @Override
        public Void visitar(NoMenosUnario no) throws ExcecaoVisitaASA
        {
            saida.append("-");
            no.getExpressao().aceitar(this);

            return null;
        }

        @Override
        public Void visitar(NoNao no) throws ExcecaoVisitaASA
        {
            saida.append("!");
            no.getExpressao().aceitar(this);

            return null;
        }

        private String getNomeBiblioteca(String escopo)
        {
            List<NoInclusaoBiblioteca> libs = asa.getListaInclusoesBibliotecas();
            for (NoInclusaoBiblioteca lib : libs)
            {
                if(lib.getAlias().equals(escopo)) 
                    return lib.getNome();
            }
            
            throw new IllegalArgumentException("Não foi possível encontrar a biblioteca para o escopo " + escopo);
        }
        
        private List<TipoDado> getTiposDosParametrosEsperados(NoChamadaFuncao no)
        {
            List<TipoDado> tipos = new ArrayList<>();

            if (no.getEscopo() != null) // é uma função de biblioteca?
            {
                String nomeBiblioteca = getNomeBiblioteca(no.getEscopo());
                try
                {
                    MetaDadosBiblioteca metadadosBiblioteca = GerenciadorBibliotecas.getInstance().obterMetaDadosBiblioteca(nomeBiblioteca);
                    assert(metadadosBiblioteca != null);
                    MetaDadosFuncao metaDadosFuncao = metadadosBiblioteca.obterMetaDadosFuncoes().obter(no.getNome());
                    assert(metaDadosFuncao != null);
                    MetaDadosParametros metaDadosParametros = metaDadosFuncao.obterMetaDadosParametros();
                    int totalParametros = metaDadosParametros.quantidade();
                    for (int i = 0; i < totalParametros; i++)
                    {
                        tipos.add(metaDadosParametros.obter(i).getTipoDado());
                    }
                    return tipos;
                }
                catch (ErroCarregamentoBiblioteca ex)
                {
                    ex.printStackTrace();
                }
            }

            // é uma função comum
            if (no.getOrigemDaReferencia() != null)
            {
                List<NoDeclaracaoParametro> parametros = no.getOrigemDaReferencia().getParametros();
                for (NoDeclaracaoParametro parametro : parametros)
                {
                    tipos.add(parametro.getTipoDado());
                }
                return tipos;
            }

            return Collections.EMPTY_LIST;
        }

        @Override
        public Void visitar(NoChamadaFuncao no) throws ExcecaoVisitaASA
        {
            String escopoFuncao = (no.getEscopo() != null) ? (no.getEscopo() + ".") : "";
            String nomeFuncao = no.getNome();
            if (escopoFuncao.isEmpty() && "leia".equals(nomeFuncao)) //a função 'leia' tem um tratamento especial
            {
                geraCodigoParaFuncaoLeia(no);
                return null;
            }

            saida.format("%s%s(", escopoFuncao, geraNomeValido(nomeFuncao));
            List<NoExpressao> parametrosPassados = no.getParametros();
            List<TipoDado> tiposEsperados = getTiposDosParametrosEsperados(no);
            int totalParametros = parametrosPassados.size();
            for (int i = 0; i < totalParametros; i++)
            {
                NoExpressao parametroPassado = parametrosPassados.get(i);
                boolean precisaDeCast = false;
                boolean parametroEhUmaOperacao = false;
                if (i < tiposEsperados.size())
                {
                    TipoDado tipoEsperado = tiposEsperados.get(i);

                    // verifica se é necessário fazer cast de um double para int quando o parâmetro esperado é int
                    precisaDeCast = tipoEsperado == TipoDado.INTEIRO && parametroPassado.getTipoResultante() == TipoDado.REAL;
                    parametroEhUmaOperacao = parametroPassado instanceof NoOperacao;
                    if (precisaDeCast)
                    {
                        saida.append("(int)");
                        if (parametroEhUmaOperacao)
                        {
                            saida.append("("); //coloca toda a operação que está sendo passada por parâmetro entre parênteses para que o cast seja aplicado em toda a operação
                        }
                    }
                }

                parametroPassado.aceitar(this);

                if (precisaDeCast && parametroEhUmaOperacao)
                {
                    saida.append(")");
                }

                if (i < totalParametros - 1)
                {
                    saida.append(", ");
                }
            }
            saida.append(")");

            return null;
        }

        private void geraNomeDaReferencia(NoReferencia no) throws ExcecaoVisitaASA
        {
            String nome = geraNomeValido(no.getNome());
            saida.append(nome);
            if (no instanceof NoReferenciaVetor)
            {
                saida.append("[");
                NoReferenciaVetor noVetor = (NoReferenciaVetor) no;
                noVetor.getIndice().aceitar(this);
                saida.append("]");

            }
            else if (no instanceof NoReferenciaMatriz) //NoReferenciaMatriz
            {
                saida.append("[");
                NoReferenciaMatriz noMatriz = (NoReferenciaMatriz) no;
                noMatriz.getLinha().aceitar(this);
                saida.append("][");
                noMatriz.getColuna().aceitar(this);
                saida.append("]");
            }
        }

        private String geraCodigoParaFuncaoLeia(NoChamadaFuncao no) throws ExcecaoVisitaASA
        {
            List<NoExpressao> parametros = no.getParametros();
            for (int i = 0; i < parametros.size(); i++)
            {
                NoReferencia noRef = (NoReferencia) parametros.get(i);

                geraNomeDaReferencia(noRef); // gera nome da variável + colchetes de vetores ou matrizes incluíndo as expressões dos índices

                NoDeclaracao origem = noRef.getOrigemDaReferencia();
                TipoDado tipo = TipoDado.CADEIA;
                if (origem != null) // parece que tem um bug no leia passando 'cadeia' como parametro, a origem do 'leia' é nula
                {
                    tipo = origem.getTipoDado();
                }
                String nomeFuncao = "leia" + GeradorCodigoUtils.getNomeTipoEmCamelCase(tipo);
                saida.format(" = %s()", nomeFuncao);
                if (i < parametros.size() - 1) // adiciona um ponto e vírgula depois de cada atribuição gerada, exceto para a última
                {
                    saida.append(";").println();
                }
            }
            return null;
        }

        @Override
        public Void visitar(NoPare noPare) throws ExcecaoVisitaASA
        {
            saida.append("break");

            return null;
        }

        @Override
        public Object visitar(NoBitwiseNao no) throws ExcecaoVisitaASA
        {
            saida.append("~");
            no.getExpressao().aceitar(this);

            return null;
        }

        @Override
        public Object visitar(NoContinue noContinue) throws ExcecaoVisitaASA
        {
            saida.append("continue");

            return null;
        }

        public GeradorCodigo geraImportacaoPara(Class classe)
        {
            saida.append("import ")
                    .append(classe.getCanonicalName())
                    .append(";")
                    .println();

            return this;
        }

        private GeradorCodigo geraImportacaoDasBibliotecasIncluidas()
        {
            for (NoInclusaoBiblioteca no : asa.getListaInclusoesBibliotecas())
            {
                saida.append("import ")
                        .append(PACOTE_DAS_LIBS)
                        .append(no.getNome())
                        .append(";")
                        .println();

            }

            return this;
        }

        private GeradorCodigo geraConstrutor(String nomeDaClasseJava)
        {
            saida.append(geraIdentacao())
                    .append("public ")
                    .append(nomeDaClasseJava)
                    .append("() throws ErroExecucao {}")
                    .println();

            return this;
        }

        private GeradorCodigo geraNomeDaClasse(String nomeClasseJava)
        {
            saida.format("public class %s extends Programa", nomeClasseJava).println();

            return this;
        }

        public GeradorCodigo geraChaveDeAberturaDaClasse()
        {
            saida.append("{").println();

            return this;
        }

        public GeradorCodigo geraChaveDeFechamentoDaClasse()
        {
            saida.append("}").println();

            return this;
        }

        /**
         * @param nomeAtual O nome atual da variável, vetor, matriz, parâmetro
         * ou função
         * @return Um nome que não conflite com as palavras reservadas do java
         */
        private static String geraNomeValido(String nomeAtual)
        {
            if (!ehUmaPalavraReservadaNoJava(nomeAtual))
            {
                return nomeAtual;
            }

            return "_" + nomeAtual;
        }
    }

    private static final Map<Class, String> OPERADORES = new HashMap<>();

    static
    {
        OPERADORES.put(NoOperacaoAtribuicao.class, "=");
        OPERADORES.put(NoOperacaoDivisao.class, "/");
        OPERADORES.put(NoOperacaoModulo.class, "%");
        OPERADORES.put(NoOperacaoMultiplicacao.class, "*");
        OPERADORES.put(NoOperacaoSoma.class, "+");
        OPERADORES.put(NoOperacaoSubtracao.class, "-");

        OPERADORES.put(NoMenosUnario.class, "-");

        OPERADORES.put(NoOperacaoLogicaDiferenca.class, "!=");
        OPERADORES.put(NoOperacaoLogicaIgualdade.class, "==");
        OPERADORES.put(NoOperacaoLogicaMaior.class, ">");
        OPERADORES.put(NoOperacaoLogicaMaiorIgual.class, ">=");
        OPERADORES.put(NoOperacaoLogicaMenor.class, "<");
        OPERADORES.put(NoOperacaoLogicaMenorIgual.class, "<=");
        OPERADORES.put(NoOperacaoLogicaOU.class, "||");
        OPERADORES.put(NoOperacaoLogicaE.class, "&&");

        OPERADORES.put(NoOperacaoBitwiseE.class, "&");
        OPERADORES.put(NoOperacaoBitwiseOu.class, "|");
        OPERADORES.put(NoOperacaoBitwiseXOR.class, "^");
        OPERADORES.put(NoOperacaoBitwiseLeftShift.class, "<<");
        OPERADORES.put(NoOperacaoBitwiseRightShift.class, ">>");
    }

    private static boolean ehUmaPalavraReservadaNoJava(String nome)
    {
        return (Arrays.binarySearch(PALAVRAS_RESERVADAS_JAVA, nome) >= 0);
    }

    // lista de palavras reservadas java 'roubadas' da wikipedia e ordenadasalfabéticamente para possibilitar uma busca binária
    private static final String[] PALAVRAS_RESERVADAS_JAVA =
    {
        "assert",
        "boolean",
        "break",
        "byte",
        "case",
        "catch",
        "char",
        "class",
        "const",
        "continue",
        "default",
        "do",
        "double",
        "else",
        "enum",
        "final",
        "finally",
        "float",
        "for",
        "goto",
        "if",
        "import",
        "instanceof",
        "interface",
        "int",
        "long",
        "native",
        "new",
        "package",
        "private",
        "protected",
        "public",
        "return",
        "short",
        "static",
        "strictfp",
        "super",
        "switch",
        "synchronized",
        "this",
        "throw",
        "throws",
        "transient",
        "try",
        "void",
        "volatile",
        "while",
        "false",
        "null",
        "true"
    };
}
