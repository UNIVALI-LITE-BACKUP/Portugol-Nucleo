package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.execucao.gerador.helpers.Utils;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.execucao.gerador.helpers.*;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Elieser
 */
public class GeradorCodigoJava
{
    private static final String PACOTE_DAS_LIBS = "br.univali.portugol.nucleo.bibliotecas.";

    private final GeradorChamadaMetodo geradorChamadaMetodo = new GeradorChamadaMetodo();
    private final GeradorSwitchCase geradorSwitchCase = new GeradorSwitchCase();

    public void gera(ASAPrograma asa, PrintWriter saida, String nomeClasseJava) throws ExcecaoVisitaASA, IOException
    {
        gera(asa, saida, nomeClasseJava, false);
    }

    public void gera(ASAPrograma asa, PrintWriter saida, String nomeClasseJava, boolean gerandoCodigoParaTesteUnitario) throws ExcecaoVisitaASA, IOException
    {
        new VisitorGeracaoCodigo(asa, saida, gerandoCodigoParaTesteUnitario)
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

    private class VisitorGeracaoCodigo extends VisitanteASABasico
    {
        private final PrintWriter saida;
        private final ASAPrograma asa;
        private int nivelEscopo = 1;
        private final boolean gerandoCodigoParaTesteUnitario; // O código gerado para rodar os testes unitários não inclui alguns detalhes relacionados com execução passo a passo e verificação de thread interrompida durante a execução do programa.

        public VisitorGeracaoCodigo(ASAPrograma asa, PrintWriter saida, boolean geraCodigoParaTesteUnitario)
        {
            this.saida = saida;
            this.asa = asa;
            this.gerandoCodigoParaTesteUnitario = geraCodigoParaTesteUnitario;
        }

        private void visitarBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
        {
            nivelEscopo++;
            Utils.visitarBlocos(blocos, saida, this, nivelEscopo, gerandoCodigoParaTesteUnitario);
            nivelEscopo--;
        }

        private void geraVerificacaoThreadInterrompida()
        {
            if (gerandoCodigoParaTesteUnitario)
            {
                return;
            }
            nivelEscopo++;
            saida.append(geraIdentacao());
            saida.append("if (Thread.currentThread().isInterrupted()) {throw new InterruptedException();}");
            nivelEscopo--;
            pulaLinha();
            pulaLinha();
        }

        private void geraMetodo(NoDeclaracaoFuncao noFuncao) throws ExcecaoVisitaASA
        {

            saida.println();

            String nome = noFuncao.getNome();
            boolean metodoPrincipal = "inicio".equals(nome);
            if (metodoPrincipal)
            {
                nome = "executar";
                saida.append(geraIdentacao());
                saida.append("@Override").println();
            }

            saida.append(geraIdentacao())
                    .append(metodoPrincipal ? "protected" : "private")
                    .append(" ")
                    .append(getNomeTipoJava(noFuncao.getTipoDado()))
                    .append(geraQuantificador(noFuncao.getQuantificador()))
                    .append(" ")
                    .append(Utils.geraNomeValido(nome));

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

            geraVerificacaoThreadInterrompida();
            Utils.geraParadaPassoAPasso(noFuncao, saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

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
                        .append(Utils.geraNomeValido(noParametro.getNome()))
                        .append(geraQuantificador(noParametro.getQuantificador()));

                if (i < size - 1)
                {
                    saida.append(", ");
                }
            }
            saida.append(")"); // parenteses de fim da lista de parâmetros
        }

        public VisitorGeracaoCodigo geraAtributosParaAsVariaveisGlobais() throws ExcecaoVisitaASA
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

        public VisitorGeracaoCodigo geraAtributosParaAsBibliotecasIncluidas()
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
                        .format("private final %s %s = new %s();", tipo, Utils.geraNomeValido(nome), tipo)
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
            return Utils.geraIdentacao(nivelEscopo);
        }

        public VisitorGeracaoCodigo pulaLinha()
        {
            saida.println();
            return this;
        }

        public VisitorGeracaoCodigo geraPackage(String stringPackage)
        {
            saida.append("package ")
                    .append(stringPackage)
                    .append(";")
                    .println();

            return this;
        }

        public VisitorGeracaoCodigo geraMetodos() throws ExcecaoVisitaASA
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
            String valor = Utils.preservaCaracteresEspeciais(noCadeia.getValor());
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
            String nomeTipo = getNomeTipoJava(noDeclaracao.getTipoDado());

            saida.format("%s %s", nomeTipo, Utils.geraNomeValido(nome));

            if (noDeclaracao.possuiInicializacao())
            {
                saida.append(" = ");

                // verifica se é necessário fazer cast de um double para int quando o parâmetro esperado é int
                boolean precisaDeCast = noDeclaracao.getTipoDado() == TipoDado.INTEIRO && noDeclaracao.getInicializacao().getTipoResultante() == TipoDado.REAL;

                if (precisaDeCast)
                {
                    saida.append("(int) (");
                }

                noDeclaracao.getInicializacao().aceitar(this);

                if (precisaDeCast)
                {
                    saida.append(")");
                }
            }

            return null;
        }

        @Override
        public Void visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
        {
            String nome = no.getNome();
            String tipo = getNomeTipoJava(no.getTipoDado());
            saida.format("%s %s[]", tipo, Utils.geraNomeValido(nome));

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
                if (valores.get(i) instanceof NoExpressaoLiteral)
                {
                    saida.append(valores.get(i).toString());
                }
                else
                {
                    ((NoExpressao) valores.get(i)).aceitar(this);
                }

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
            saida.format("%s %s[][]", tipo, Utils.geraNomeValido(nome));

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
            saida.append(Utils.geraNomeValido(no.getNome()));

            saida.append("[");
            no.getIndice().aceitar(this);
            saida.append("]");

            return null;
        }

        @Override
        public Void visitar(NoReferenciaMatriz no) throws ExcecaoVisitaASA
        {
            saida.append(Utils.geraNomeValido(no.getNome()))
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
            String nome = Utils.geraNomeValido(no.getNome());
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

            geraVerificacaoThreadInterrompida();

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

            geraVerificacaoThreadInterrompida();

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

        private boolean simularBreakCaso = false;

        @Override
        public Void visitar(NoEscolha no) throws ExcecaoVisitaASA
        {
            boolean contemCasosNaoConstantes = GeradorSwitchCase.contemCasosNaoConstantes(no);
            simularBreakCaso = contemCasosNaoConstantes;
            
            if (!contemCasosNaoConstantes)
            {
                geradorSwitchCase.geraSwitchCase(no, saida, this, asa, nivelEscopo, gerandoCodigoParaTesteUnitario);
            }
            else
            {
                geradorSwitchCase.geraSeSenao(no, saida, this, nivelEscopo, gerandoCodigoParaTesteUnitario);
            }

            return null;
        }

        @Override
        public Void visitar(NoFacaEnquanto no) throws ExcecaoVisitaASA
        {
            saida.append("do").println();
            saida.append(geraIdentacao()).append("{").println();

            geraVerificacaoThreadInterrompida();

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

//        private void criaValueHoldersParaParametrosPorReferencia(List<MetaPametro> metaDadosDosParametros, 
//                                        List<NoExpressao> parametrosPassados)
//        {
//            assert(metaDadosDosParametros.size() == parametrosPassados.size());
//            
//            for (int i = 0; i < metaDadosDosParametros.size(); i++ )
//            {
//                if (metaDadosDosParametros.get(i).modoAcesso == ModoAcesso.POR_REFERENCIA)
//                {
//                    String nomeParametroPassado = ((NoReferencia)parametrosPassados.get(i)).getNome();
//                    String nomeHolder = "holder_" + nomeParametroPassado;
//                    saida.append("ValueHolder ")
//                            .append(nomeHolder)
//                            .append(" = new ValueHolder(")
//                            .append(nomeParametroPassado)
//                            .append(");").println();
//                }
//            }
//        }
        @Override
        public Void visitar(NoChamadaFuncao no) throws ExcecaoVisitaASA
        {
            geradorChamadaMetodo.gera(no, saida, this, asa);
            return null;
        }

        @Override
        public Void visitar(NoPare noPare) throws ExcecaoVisitaASA
        {
            if (simularBreakCaso)
            {
                saida.append(GeradorSwitchCase.NOME_VARIAVEL_BREAK)
                        .append(" = true");
            }
            else
            {
                saida.append("break");
            }

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

        public VisitorGeracaoCodigo geraImportacaoPara(Class classe)
        {
            saida.append("import ")
                    .append(classe.getCanonicalName())
                    .append(";")
                    .println();

            return this;
        }

        private VisitorGeracaoCodigo geraImportacaoDasBibliotecasIncluidas()
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

        private VisitorGeracaoCodigo geraConstrutor(String nomeDaClasseJava)
        {
            saida.append(geraIdentacao())
                    .append("public ")
                    .append(nomeDaClasseJava)
                    .append("() throws ErroExecucao, InterruptedException {");

            saida.append("}").println();

            return this;
        }

        private VisitorGeracaoCodigo geraNomeDaClasse(String nomeClasseJava)
        {
            saida.format("public class %s extends Programa", nomeClasseJava).println();

            return this;
        }

        public VisitorGeracaoCodigo geraChaveDeAberturaDaClasse()
        {
            saida.append("{").println();

            return this;
        }

        public VisitorGeracaoCodigo geraChaveDeFechamentoDaClasse()
        {
            saida.append("}").println();

            return this;
        }

        /**
         * @param nomeAtual O nome atual da variável, vetor, matriz, parâmetro
         * ou função
         * @return Um nome que não conflite com as palavras reservadas do java
         */
        
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

}
