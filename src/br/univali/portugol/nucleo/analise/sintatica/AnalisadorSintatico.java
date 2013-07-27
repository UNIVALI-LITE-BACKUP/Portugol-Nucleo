package br.univali.portugol.nucleo.analise.sintatica;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroParsingNaoTratado;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorEarlyExitException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorFailedPredicateException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMismatchedNotSetException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMismatchedRangeException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMismatchedSetException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMismatchedTokenException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMismatchedTreeNodeException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorMissingTokenException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorNoViableAltException;
import br.univali.portugol.nucleo.analise.sintatica.tradutores.TradutorUnwantedTokenException;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.UnwantedTokenException;

/**
 * Esta classe provê uma fachada (Facade) que abstrai o processo de parsing do código fonte e a geração da ASA.
 * <p>
 * Esta classe se encarrega de instanciar e chamar os objetos do ANTLR responsáveis por realizar o parsing do
 * código fonte e gerar a ASA. Também abstrai o processo de tradução dos erros de parsing para erros sintáticos, 
 * capturando estes erros e encaminhando-os aos tradutores apropriados.
 * <p>
 * Esta abstração é feita através do método {@link AnalisadorSintatico#analisar(java.lang.String) }, o qual
 * fica disponível para os objetos que utilizarem esta fachada.
 *
 * @author Luiz Fernando Noschang
 * @since 1.0
 * 
 * @see PortugolLexer
 * @see PortugolParser
 */
public final class AnalisadorSintatico implements ObservadorParsing
{
    private List<ObservadorAnaliseSintatica> observadores;
    private TradutorEarlyExitException tradutorEarlyExitException;
    private TradutorFailedPredicateException tradutorFailedPredicateException;
    private TradutorMismatchedRangeException tradutorMismatchedRangeException;
    private TradutorMismatchedSetException tradutorMismatchedSetException;
    private TradutorMismatchedNotSetException tradutorMismatchedNotSetException;
    private TradutorMismatchedTokenException tradutorMismatchedTokenException;
    private TradutorMissingTokenException tradutorMissingTokenException;
    private TradutorUnwantedTokenException tradutorUnwantedTokenException;
    private TradutorMismatchedTreeNodeException tradutorMismatchedTreeNodeException;
    private TradutorNoViableAltException tradutorNoViableAltException;

    public AnalisadorSintatico()
    {
        observadores = new ArrayList<ObservadorAnaliseSintatica>();
        tradutorEarlyExitException = new TradutorEarlyExitException();
        tradutorFailedPredicateException = new TradutorFailedPredicateException();
        tradutorMismatchedRangeException = new TradutorMismatchedRangeException();
        tradutorMismatchedSetException = new TradutorMismatchedSetException();
        tradutorMismatchedNotSetException = new TradutorMismatchedNotSetException();
        tradutorMismatchedTokenException = new TradutorMismatchedTokenException();
        tradutorMissingTokenException = new TradutorMissingTokenException();
        tradutorUnwantedTokenException = new TradutorUnwantedTokenException();
        tradutorMismatchedTreeNodeException = new TradutorMismatchedTreeNodeException();
        tradutorNoViableAltException = new TradutorNoViableAltException();
    }

    /**
     * 
     * @param codigo     o código fonte no qual será realizado o parsing e a análise.
     * @return     a ASA resultante do parsing do código fonte.
     * @since 1.0
     */
    public ArvoreSintaticaAbstrata analisar(String codigo)
    {
        try
        {
            ANTLRStringStream antlrStringStream = new ANTLRStringStream(codigo);
            PortugolLexer portugolLexer = new PortugolLexer(antlrStringStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(portugolLexer);
            PortugolParser portugolParser = new PortugolParser(commonTokenStream);

            portugolParser.adicionarObservadorParsing(this);
            ArvoreSintaticaAbstrata asa = portugolParser.parse();
            
            return asa;
        }
        catch (RecognitionException excecao)
        {
            excecao.printStackTrace();
            return null;
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void tratarErroParsing(RecognitionException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        notificarErroSintatico(traduzirErroParsing(erro, tokens, pilhaContexto, mensagemPadrao));
    }

    /**
     * Encaminha o erro de parsing do ANTLR para o tradutor apropriado.
     * 
     * @param erro               o erro de parsing gerado pelo ANTLR, sem nenhum tratamento.
     * @param tokens             a lista de tokens envolvidos no erro.
     * @param pilhaContexto      a pilha de contexto do analisador sintático.
     * @param mensagemPadrao     a mensagem de erro padrão para este tipo de erro.
     * @return                   o erro sintático traduzido.
     * @since 1.0
     */
    public ErroSintatico traduzirErroParsing(RecognitionException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        if (erro instanceof EarlyExitException)
        {
            return tradutorEarlyExitException.traduzirErroParsing((EarlyExitException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
        else
        
        if (erro instanceof FailedPredicateException)
        {
            return tradutorFailedPredicateException.traduzirErroParsing((FailedPredicateException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
            
        else
            
        if (erro instanceof MismatchedRangeException)
        {
            return tradutorMismatchedRangeException.traduzirErroParsing((MismatchedRangeException) erro, tokens, pilhaContexto, mensagemPadrao);        
        }
        
        else
            
        if (erro instanceof MismatchedNotSetException)
        {
            return tradutorMismatchedNotSetException.traduzirErroParsing((MismatchedNotSetException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
        
        else

        if (erro instanceof MissingTokenException)
        {
            return tradutorMissingTokenException.traduzirErroParsing((MissingTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
                        
        else

        if (erro instanceof UnwantedTokenException)
        {
            return tradutorUnwantedTokenException.traduzirErroParsing((UnwantedTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
                            
        else
                    
        if (erro instanceof MismatchedTreeNodeException)
        {
            return tradutorMismatchedTreeNodeException.traduzirErroParsing((MismatchedTreeNodeException) erro, tokens, pilhaContexto, mensagemPadrao);
        }

        else

        if (erro instanceof NoViableAltException)
        {
            return tradutorNoViableAltException.traduzirErroParsing((NoViableAltException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
        
        else
        
        if (erro instanceof MismatchedTokenException)
        {
            return tradutorMismatchedTokenException.traduzirErroParsing((MismatchedTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
        
        else
        
        if (erro instanceof MismatchedSetException)
        {
            return tradutorMismatchedSetException.traduzirErroParsing((MismatchedSetException) erro, tokens, pilhaContexto, mensagemPadrao);
        }
        
        else
        {
            return new ErroParsingNaoTratado(erro, mensagemPadrao, pilhaContexto.pop());
        }
    }

    /** 
     * Permite adicionar um observador à análise sintática. Os observadores serão notificados sobre cada
     * erro sintático encontrado no código fonte e deverão tratá-los apropriadamente, exibindo-os em uma 
     * IDE, por exemplo.
     * 
     * @param observadorAnaliseSintatica     o observador da análise sintática a ser registrado.
     * @since 1.0
     */
    public void adicionarObservador(ObservadorAnaliseSintatica observadorAnaliseSintatica)
    {
        if (!observadores.contains(observadorAnaliseSintatica))
        {
            observadores.add(observadorAnaliseSintatica);
        }
    }

    /**
     * Remove um observador da análise previamente registrado utilizando o método 
     * {@link AnalisadorSintatico#adicionarObservador(br.univali.portugol.nucleo.analise.sintatica.ObservadorAnaliseSintatica) }.
     * Uma vez removido, o observador não será mais notificado dos erros sintáticos encontrados durante a análise.
     * 
     * @param observadorAnaliseSintatica     um observador de análise sintática previamente registrado.
     * @since 1.0
     */
    public void removerObservador(ObservadorAnaliseSintatica observadorAnaliseSintatica)
    {
        observadores.remove(observadorAnaliseSintatica);
    }

    /**
     * Notifica todos os observadores registrados a respeito de um erro sintático ocorrido durante a análise.
     * 
     * @param erroSintatico     o erro sintático ocorrido.
     * @since 1.0
     */
    private void notificarErroSintatico(ErroSintatico erroSintatico)
    {
        for (ObservadorAnaliseSintatica observador : observadores)
        {
            observador.tratarErroSintatico(erroSintatico);
        }
    }
}