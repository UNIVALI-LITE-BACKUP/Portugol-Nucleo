package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.execucao.gerador.helpers.Utils;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.execucao.gerador.helpers.*;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Elieser
 */
public class GeradorCodigoJava
{
    private static final String PACOTE_DAS_LIBS = "br.univali.portugol.nucleo.bibliotecas.";

    private final GeradorChamadaMetodo geradorChamadaMetodo = new GeradorChamadaMetodo();
    private final GeradorSwitchCase geradorSwitchCase = new GeradorSwitchCase();
    private final GeradorDeclaracaoMetodo geradorDeclaracaoMetodo = new GeradorDeclaracaoMetodo();
    private final GeradorOperacao geradorOperacao = new GeradorOperacao();
    private final GeradorAtributo geradorAtributo = new GeradorAtributo();
    private final GeradorDeclaracaoVariavel geradorDeclaracaoVariavel = new GeradorDeclaracaoVariavel();
    private final GeradorAtribuicao geradorAtribuicao = new GeradorAtribuicao();

    public void gera(ASAPrograma asa, PrintWriter saida, String nomeClasseJava) throws ExcecaoVisitaASA, IOException
    {
        gera(asa, saida, nomeClasseJava, false, false, false); // não gera código para interrupção de thread, pontos de parada e inspeção de símbolos
    }

    public void gera(ASAPrograma asa, PrintWriter saida, String nomeClasseJava, 
            boolean geraCodigoParaInterrupcaoDeThread, boolean geraCodigoParaPontosDeParada,
                    boolean geraCodigoParaInspecaoDeSimbolos) throws ExcecaoVisitaASA, IOException
    {
        PreAnalisador preAnalisador = new PreAnalisador();
        asa.aceitar(preAnalisador);

        VisitorGeracaoCodigo gerador = new VisitorGeracaoCodigo(asa, saida 
                        ,geraCodigoParaInterrupcaoDeThread
                        ,geraCodigoParaPontosDeParada
                        ,geraCodigoParaInspecaoDeSimbolos);
        
        int totalVariaveis = preAnalisador.getTotalVariaveisDeclaradas();
        int totalVetores = preAnalisador.getTotalVetoresDeclarados();
        int totalMatrizes = preAnalisador.getTotalMatrizesDeclaradas();
        
        gerador.geraPackage("programas")
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
                .geraAtributosParaAsVariaveisPassadasPorReferencia(preAnalisador.getVariaveisPassadasPorReferencia())
                .pulaLinha()
                .geraConstrutor(nomeClasseJava, totalVariaveis, totalVetores, totalMatrizes)
                .pulaLinha()
                .geraMetodos(preAnalisador.getFuncoesQuerForamInvocadas())
                .geraChaveDeFechamentoDaClasse();
    }

    private class VisitorGeracaoCodigo extends VisitanteASABasico
    {
        private final PrintWriter saida;
        private final ASAPrograma asa;
        private int nivelEscopo = 1;
        private final boolean gerandoCodigoParaInterrupcaoDeThread;
        private final boolean gerandoCodigoParaPontosDeParada;
        private final boolean gerandoCodigoParaInspecaoDeSimbolos;

        public VisitorGeracaoCodigo(ASAPrograma asa, PrintWriter saida, 
                boolean geraCodigoParaInterrupcaoDeThread, boolean geraCodigoParaPontosDeParada,
                            boolean geraCodigoParaInspecaoDeSimbolos)
        {
            this.saida = saida;
            this.asa = asa;
            this.gerandoCodigoParaInterrupcaoDeThread = geraCodigoParaInterrupcaoDeThread;
            this.gerandoCodigoParaPontosDeParada = geraCodigoParaPontosDeParada;
            this.gerandoCodigoParaInspecaoDeSimbolos = geraCodigoParaInspecaoDeSimbolos;
        }

        private void visitarBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
        {
            nivelEscopo++;
            
            Utils.visitarBlocos(blocos, saida, this, nivelEscopo, 
                    gerandoCodigoParaInterrupcaoDeThread, gerandoCodigoParaPontosDeParada, gerandoCodigoParaInspecaoDeSimbolos);
            
            nivelEscopo--;
        }

        private void geraVerificacaoThreadInterrompida()
        {
            if (gerandoCodigoParaInterrupcaoDeThread)
            {
                nivelEscopo++;
                Utils.geraVerificacaoThreadInterrompida(saida, nivelEscopo);
                nivelEscopo--;
            }
        }

        public VisitorGeracaoCodigo geraAtributosParaAsVariaveisGlobais() throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> variaveisGlobais = asa.getListaDeclaracoesGlobais();
            boolean existemVariaveisGlobais = false;
            for (NoDeclaracao no : variaveisGlobais)
            {
                if (no instanceof NoDeclaracaoVariavel && ((NoDeclaracaoVariavel) no).ehPassadaPorReferencia())
                {
                    continue; // variáveis globais que são passadas como referência não são declaradas como atributo no código Java
                }
                boolean atributoGerado = geradorAtributo.gera(no, saida, this, nivelEscopo);
                existemVariaveisGlobais |= atributoGerado;
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
                geradorAtributo.gera(biblioteca, saida, nivelEscopo);
            }

            if (!libsIncluidas.isEmpty())
            {
                saida.println(); // deixa uma linha em branco depois dos atributos das bibliotecas
            }

            return this;
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

        public VisitorGeracaoCodigo geraMetodos(Set<NoDeclaracaoFuncao> funcoesQueForamInvocadas) throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> declaracoes = asa.getListaDeclaracoesGlobais();
            for (NoDeclaracao declaracao : declaracoes)
            {
                if (declaracao instanceof NoDeclaracaoFuncao)
                {
                    NoDeclaracaoFuncao declaracaoFuncao = (NoDeclaracaoFuncao)declaracao;
                    if (declaracaoFuncao.getNome().equals("inicio") || funcoesQueForamInvocadas.contains(declaracaoFuncao)) //só gera código para funções que foram invocadas
                    {
                        geradorDeclaracaoMetodo.gera(declaracaoFuncao,  saida, this, nivelEscopo, 
                                gerandoCodigoParaInterrupcaoDeThread, gerandoCodigoParaPontosDeParada, gerandoCodigoParaInspecaoDeSimbolos);
                    }
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

        @Override
        public Void visitar(NoOperacaoBitwiseLeftShift no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseRightShift no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseE no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseXOR no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoBitwiseOu no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoSoma no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoDivisao no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoModulo no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoSubtracao no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoMultiplicacao no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaOU no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaE no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaDiferenca no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaIgualdade no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMaior no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMaiorIgual no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMenor no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Void visitar(NoOperacaoLogicaMenorIgual no) throws ExcecaoVisitaASA
        {
            geradorOperacao.gera(no, saida, this);
            return null;
        }

        @Override
        public Boolean visitar(NoDeclaracaoVariavel noDeclaracao) throws ExcecaoVisitaASA
        {
            return geradorDeclaracaoVariavel.gera(noDeclaracao, saida, this, nivelEscopo);
        }

        @Override
        public Void visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
        {
            geradorDeclaracaoVariavel.gera(no, saida, this, nivelEscopo);
            return null;
        }

        @Override
        public Void visitar(NoVetor noVetor) throws ExcecaoVisitaASA
        {
            geradorDeclaracaoVariavel.gera(noVetor, saida, this, nivelEscopo);
            return null;
        }

        @Override
        public Void visitar(NoDeclaracaoMatriz noDeclaracao) throws ExcecaoVisitaASA
        {
            geradorDeclaracaoVariavel.gera(noDeclaracao, saida, this, nivelEscopo);
            return null;
        }

        @Override
        public Void visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
        {
            geradorDeclaracaoVariavel.gera(noMatriz, saida, this, nivelEscopo);
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

            NoDeclaracao declaracao = no.getOrigemDaReferencia();
            boolean ehParametroPorReferencia = declaracao instanceof NoDeclaracaoParametro && (((NoDeclaracaoParametro) declaracao).getModoAcesso() == ModoAcesso.POR_REFERENCIA);
            if (ehParametroPorReferencia || no.ehPassadoPorReferencia())
            {
                String stringIndice = ehParametroPorReferencia ? no.getNome() : Utils.geraStringIndice(no);
                String nomeTipo = Utils.getNomeTipoJava(declaracao.getTipoDado()).toUpperCase();
                saida.format("REFS_%s[%s]", nomeTipo, stringIndice);
            }
            else
            {
                saida.append(nome);
            }

            return null;
        }

        @Override
        public Void visitar(NoEnquanto no) throws ExcecaoVisitaASA
        {

            saida.append("while(");

            no.getCondicao().aceitar(this);

            saida.append(")").println();

            String identacao = Utils.geraIdentacao(nivelEscopo);

            saida.append(identacao).append("{").println();

            geraVerificacaoThreadInterrompida();

            visitarBlocos(no.getBlocos());

            saida.println();

            saida.append(identacao).append("}").println();

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

            String identacao = Utils.geraIdentacao(nivelEscopo);

            saida.append(identacao).append("{").println();

            geraVerificacaoThreadInterrompida();

            visitarBlocos(no.getBlocos());

            saida.println();

            saida.append(identacao).append("}").println();

            return null;
        }

        @Override
        public Void visitar(NoSe no) throws ExcecaoVisitaASA
        {
            saida.append("if(");

            no.getCondicao().aceitar(this);

            saida.append(")").println();

            String identacao = Utils.geraIdentacao(nivelEscopo);

            saida.append(identacao).append("{").println();

            List<NoBloco> blocosVerdadeiros = no.getBlocosVerdadeiros();
            if (blocosVerdadeiros != null)
            {
                visitarBlocos(blocosVerdadeiros);
                saida.println();
            }

            saida.append(identacao).append("}").println();

            List<NoBloco> blocosFalsos = no.getBlocosFalsos();
            if (blocosFalsos != null)
            {
                saida.append(identacao).append("else").println();
                saida.append(identacao).append("{").println();

                visitarBlocos(blocosFalsos);

                saida.println();

                saida.append(identacao).append("}").println();
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
                geradorSwitchCase.geraSwitchCase(no, saida, this, nivelEscopo, 
                        gerandoCodigoParaInterrupcaoDeThread, gerandoCodigoParaPontosDeParada, gerandoCodigoParaInspecaoDeSimbolos);
            }
            else
            {
                geradorSwitchCase.geraSeSenao(no, saida, this, nivelEscopo, 
                        gerandoCodigoParaInterrupcaoDeThread, gerandoCodigoParaPontosDeParada);
            }

            return null;
        }

        @Override
        public Void visitar(NoFacaEnquanto no) throws ExcecaoVisitaASA
        {
            String identacao = Utils.geraIdentacao(nivelEscopo);

            saida.append("do").println();
            saida.append(identacao).append("{").println();

            geraVerificacaoThreadInterrompida();

            List<NoBloco> blocos = no.getBlocos();
            if (blocos != null)
            {
                visitarBlocos(blocos);
                saida.println();
            }

            saida.append(identacao).append("}").println();

            saida.append(identacao).append("while(");

            no.getCondicao().aceitar(this);

            saida.append(");").println();

            return null;
        }

        @Override
        public Void visitar(NoOperacaoAtribuicao no) throws ExcecaoVisitaASA
        {
            geradorAtribuicao.gera(no, saida, this, nivelEscopo);
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

        private void inicializaVariaveisGlobaisQueSaoPassadasPorReferencia() throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> declaracoes = asa.getListaDeclaracoesGlobais();
            for (NoDeclaracao declaracao : declaracoes)
            {
                if (declaracao instanceof NoDeclaracaoVariavel)
                {
                    NoDeclaracaoVariavel variavel = (NoDeclaracaoVariavel) declaracao;
                    if (variavel.ehPassadaPorReferencia() && variavel.temInicializacao())
                    {
                        String nomeTipo = Utils.getNomeTipoJava(variavel.getTipoDado());
                        saida.append(Utils.geraIdentacao(nivelEscopo));
                        saida.format("REFS_%s[%s] = ", nomeTipo.toUpperCase(), Utils.geraStringIndice(variavel));
                        variavel.getInicializacao().aceitar(this);
                        saida.append(";").println(); // o ponto e vírgula depois da inicialização
                    }
                }
            }
        }

        private VisitorGeracaoCodigo geraConstrutor(String nomeDaClasseJava, 
                int variaveisDeclaradas, int vetoresDeclarados, int matrizesDeclaradas) throws ExcecaoVisitaASA
        {
            String identacao = Utils.geraIdentacao(nivelEscopo);
            saida.append(identacao)
                    .append("public ")
                    .append(nomeDaClasseJava)
                    .append("() throws ErroExecucao, InterruptedException {")
                    .println();

            nivelEscopo++;
            
            if (gerandoCodigoParaInspecaoDeSimbolos)
            {
                String identacaoInterna = Utils.geraIdentacao(nivelEscopo);
                saida.append(identacaoInterna)
                        .format("variaveisInspecionadas = new Object[%d];", variaveisDeclaradas)
                        .println();
                
                saida.append(identacaoInterna)
                        .format("vetoresInspecionados = new Vetor[%d];", vetoresDeclarados)
                        .println();
                
                saida.append(identacaoInterna)
                        .format("matrizesInspecionadas = new Matriz[%d];", matrizesDeclaradas)
                        .println();
            }
            
            inicializaVariaveisGlobaisQueSaoPassadasPorReferencia();
            
            nivelEscopo--;

            saida.append(identacao)
                    .append("}").println();

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

        public VisitorGeracaoCodigo geraAtributosParaAsVariaveisPassadasPorReferencia(Map<TipoDado, List<NoDeclaracaoVariavel>> variaveis)
        {
            if (variaveis.isEmpty())
            {
                return this;
            }

            String identacao = Utils.geraIdentacao(nivelEscopo);

            //declara os arrays (separados por tipo) que armazenam todas as referências
            //gera os arrays nessa sequência de tipos
            TipoDado tipos[] =
            {
                TipoDado.INTEIRO, TipoDado.REAL, TipoDado.LOGICO, TipoDado.CARACTER, TipoDado.CADEIA
            };

            for (TipoDado tipo : tipos)
            {
                if (variaveis.containsKey(tipo))
                {
                    String nomeTipo = Utils.getNomeTipoJava(tipo);
                    int numeroVariaveis = variaveis.get(tipo).size();
                    saida.append(identacao)
                            .format("private final %s[] REFS_%s = new %s[%d];",
                                    nomeTipo, nomeTipo.toUpperCase(), nomeTipo, numeroVariaveis)
                            .println();
                }
            }

            saida.println(); // pula uma linha antes de declarar as variáveis de cada tipo

            for (TipoDado tipo : tipos)
            {
                if (variaveis.containsKey(tipo))
                {
                    for (NoDeclaracaoVariavel variavel : variaveis.get(tipo))
                    {
                        saida.append(identacao)
                                .append("private final int ")
                                .append(Utils.geraStringIndice(variavel))
                                .append(" = ")
                                .append(String.valueOf(variavel.getIndiceReferencia()))
                                .append(";")
                                .println();
                    }
                    
                    saida.println(); //separa as declarações para cada tipo
                }
            }

            return this;
        }

    }

}
