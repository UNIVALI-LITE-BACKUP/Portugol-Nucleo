
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
 *
 * @author Luiz Fernando Noschang
 * 
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
    
    public ArvoreSintaticaAbstrata analisar(String codigo)
    {
        try
        {
            ANTLRStringStream antlrStringStream = new ANTLRStringStream(codigo);
            PortugolLexer portugolLexer = new PortugolLexer(antlrStringStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(portugolLexer);
            PortugolParser portugolParser = new PortugolParser(commonTokenStream);
            
            portugolParser.adicionarObservadorParsing(this);
            return portugolParser.parse();            
        }
        catch(RecognitionException excecao)
        {
            excecao.printStackTrace();
            return null;
        }
    }

    @Override
    public void tratarErroParsing(RecognitionException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {
        notificarErroSintatico(traduzirErroParsing(erro, tokens, pilhaContexto, mensagemPadrao));
    }
    
    public ErroSintatico traduzirErroParsing(RecognitionException erro, String[] tokens, Stack<String> pilhaContexto, String mensagemPadrao)
    {            
        if (erro instanceof EarlyExitException) return tradutorEarlyExitException.traduzirErroParsing((EarlyExitException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof FailedPredicateException) return tradutorFailedPredicateException.traduzirErroParsing((FailedPredicateException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof MismatchedRangeException) return tradutorMismatchedRangeException.traduzirErroParsing((MismatchedRangeException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof MismatchedNotSetException) return tradutorMismatchedNotSetException.traduzirErroParsing((MismatchedNotSetException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof MissingTokenException) return tradutorMissingTokenException.traduzirErroParsing((MissingTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof UnwantedTokenException) return tradutorUnwantedTokenException.traduzirErroParsing((UnwantedTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof MismatchedTreeNodeException) return tradutorMismatchedTreeNodeException.traduzirErroParsing((MismatchedTreeNodeException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof NoViableAltException) return tradutorNoViableAltException.traduzirErroParsing((NoViableAltException) erro, tokens, pilhaContexto, mensagemPadrao);
        else 
        if (erro instanceof MismatchedTokenException) return tradutorMismatchedTokenException.traduzirErroParsing((MismatchedTokenException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        if (erro instanceof MismatchedSetException) return tradutorMismatchedSetException.traduzirErroParsing((MismatchedSetException) erro, tokens, pilhaContexto, mensagemPadrao);
        else
        return new ErroParsingNaoTratado(erro, mensagemPadrao, pilhaContexto.pop());
    }
    
    public void adicionarObservador(ObservadorAnaliseSintatica observadorAnaliseSintatica)
    {
        if (!observadores.contains(observadorAnaliseSintatica))
            observadores.add(observadorAnaliseSintatica);
    }
    
    public void removerObservador(ObservadorAnaliseSintatica observadorAnaliseSintatica)
    {
        observadores.remove(observadorAnaliseSintatica);
    }
    
    private void notificarErroSintatico(ErroSintatico erroSintatico)
    {
        for (ObservadorAnaliseSintatica observador: observadores)
            observador.tratarErroSintatico(erroSintatico);
    }
}