package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ASAPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import br.univali.portugol.nucleo.execucao.GeradorCodigoJava;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroAnalise;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * Classe utilitária para abstrair as etapas necessárias à compilação do código
 * fonte
 *
 * @author Luiz Fernando Noschang
 */
final class Compilador
{
    private static final File DIRETORIO_TEMPORARIO = new File(System.getProperty("java.io.tmpdir"));
    private static final File DIRETORIO_COMPILACAO = new File(DIRETORIO_TEMPORARIO, "portugol");

    private static final String NOME_PACOTE = "programas";
    private static final File DIRETORIO_PACOTE = new File(DIRETORIO_COMPILACAO, NOME_PACOTE);

    private static final String funcaoInicialPadrao = "inicio";
    private static final String[] funcoesEspeciais = new String[]
    {
        "limpa", "leia", "escreva"
    };

    private final LocalizadorFuncoes localizadorFuncoes = new LocalizadorFuncoes();

    /**
     * Compila o código fonte em Portugol para um programa. Realiza a análise
     * sintática e semântica para garantir que não há erros no código.
     *
     * @param codigo o código fonte em Portugol a ser compilado
     * @return o programa equivalente ao código fonte passado
     *
     * @throws ErroCompilacao
     */
    public Programa compilar(String codigo, boolean compilarParaExecucao) throws ErroCompilacao
    {
        AnalisadorAlgoritmo analisadorAlgoritmo = new AnalisadorAlgoritmo();
        ResultadoAnalise resultadoAnalise = analisadorAlgoritmo.analisar(codigo);

        if (!resultadoAnalise.contemErros())
        {
            ASAPrograma asa = (ASAPrograma) analisadorAlgoritmo.getASA();

            Programa programa;
            
            if (compilarParaExecucao)
            {
                programa = geraPrograma(asa);
                programa.setFuncoes(localizadorFuncoes.getFuncoes(asa));
                programa.setFuncaoInicial(localizadorFuncoes.getFuncaoInicial());
            }
            else
            {
                programa = new ProgramaVazio();
            }
            
            programa.setArvoreSintaticaAbstrata(asa);
            programa.setResultadoAnalise(resultadoAnalise);

            return programa;
        }
        else
        {
            throw new ErroCompilacao(resultadoAnalise);
        }
    }

    private Programa geraPrograma(ASAPrograma asa) throws ErroCompilacao
    {
        ResultadoAnalise resultadoAnalise = new ResultadoAnalise();

        long idPrograma = System.currentTimeMillis();
        
        String nomeClasse = "Programa".concat(String.valueOf(idPrograma));
        String nomeArquivoJava = nomeClasse.concat(".java");
        String nomeArquivoClass = nomeClasse.concat(".class");

        DIRETORIO_PACOTE.mkdirs();
        
        File arquivoJava = new File(DIRETORIO_PACOTE, nomeArquivoJava);
        File arquivoClass = new File(DIRETORIO_PACOTE, nomeArquivoClass);

        try (PrintWriter writerArquivoJava = new PrintWriter(new FileOutputStream(arquivoJava)))
        {
            GeradorCodigoJava gerador = new GeradorCodigoJava();
            gerador.gera(asa, writerArquivoJava, nomeClasse);
            writerArquivoJava.flush();

            return compilarJava(nomeClasse, arquivoJava, DIRETORIO_COMPILACAO);
        }
        catch (final IOException | ExcecaoVisitaASA ex)
        {
            resultadoAnalise.adicionarErro(new ErroAnalise()
            {
                @Override
                protected String construirMensagem()
                {
                    return ex.getMessage();
                }
            });

            throw new ErroCompilacao(resultadoAnalise);
        }
        finally
        {
            arquivoJava.delete();
            arquivoClass.delete();
        }
    }

    private Programa compilarJava(String nomeClasse, File arquivoJava, File diretorioCompilacao) throws ErroCompilacao
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits
                = fileManager.getJavaFileObjects(arquivoJava);

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
        ResultadoAnalise resultadoAnalise = new ResultadoAnalise();

        if (task.call())
        {
            try
            {
                URLClassLoader classLoader = new URLClassLoader(new URL[]
                {
                    diretorioCompilacao.toURI().toURL()
                });
                Class<?> loadedClass = classLoader.loadClass(NOME_PACOTE.concat(".").concat(nomeClasse));

                return (Programa) loadedClass.newInstance();
            }
            catch (ClassNotFoundException | IllegalAccessException | InstantiationException | MalformedURLException | RuntimeException ex)
            {
                resultadoAnalise.adicionarErro(new ErroAnalise()
                {
                    @Override
                    protected String construirMensagem()
                    {
                        return ex.getMessage();
                    }
                });

                throw new ErroCompilacao(resultadoAnalise);
            }
        }
        else
        {
            for (Diagnostic diagnostic : diagnostics.getDiagnostics())
            {
                final String message = diagnostic.getKind() + ":\t Line [" + diagnostic.getLineNumber() + "] \t Position [" + diagnostic.getPosition() + "]\t" + diagnostic.getMessage(Locale.ROOT) + "\n";

                if (diagnostic.getKind() == Diagnostic.Kind.ERROR)
                {
                    resultadoAnalise.adicionarErro(new ErroAnalise()
                    {
                        @Override
                        protected String construirMensagem()
                        {
                            return message;
                        }
                    });
                }
                else
                {
                    resultadoAnalise.adicionarAviso(new AvisoAnalise(new TrechoCodigoFonte(0, 0, 1))
                    {
                        @Override
                        protected String construirMensagem()
                        {
                            return message;
                        }
                    });
                }
            }

            throw new ErroCompilacao(resultadoAnalise);
        }
    }

    private final class LocalizadorFuncoes extends VisitanteASABasico
    {
        private final List<String> funcoes = new ArrayList<>();

        public List<String> getFuncoes(ASAPrograma asa)
        {
            try
            {
                asa.aceitar(this);
            }
            catch (ExcecaoVisitaASA excecaoVisitaASA)
            {
                excecaoVisitaASA.printStackTrace(System.out);
            }

            return funcoes;
        }

        public String getFuncaoInicial()
        {
            for (String funcao : funcoes)
            {
                if (funcao.equals(funcaoInicialPadrao))
                {
                    return funcaoInicialPadrao;
                }
            }

            if (!funcoes.isEmpty())
            {
                return funcoes.get(0);
            }

            return funcaoInicialPadrao;
        }

        private boolean estaNaListaNegra(String funcao)
        {
            for (String func : funcoesEspeciais)
            {
                if (funcao.equals(func))
                {
                    return true;
                }
            }

            return false;
        }

        @Override
        public Object visitar(ASAPrograma asap) throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> declaracoes = asap.getListaDeclaracoesGlobais();

            if (declaracoes != null)
            {
                for (NoDeclaracao declaracao : declaracoes)
                {
                    if (!estaNaListaNegra(declaracao.getNome()))
                    {
                        declaracao.aceitar(this);
                    }
                }
            }

            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
        {
            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
        {
            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
        {
            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
        {
            funcoes.add(declaracaoFuncao.getNome());

            return null;
        }
    }
}
