
package br.univali.portugol.nucleo.analise.sintatica;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroDeclaracaoPrograma;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroTipoDeDadoNaoInformado;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class AnalisadorSintatico implements TradutorErrosSintaticos
{
    private String codigo;
    private PortugolLexer portugolLexer;
    private PortugolParser portugolParser;            
    private List<ObservadorAnaliseSintatica> observadores;
    
    public AnalisadorSintatico()
    {
        observadores = new ArrayList<ObservadorAnaliseSintatica>();
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
    
    public void notificarErroSintatico(ErroSintatico erroSintatico)
    {
        for (ObservadorAnaliseSintatica observador: observadores)
            observador.tratarErroSintatico(erroSintatico);
    }

    public ArvoreSintaticaAbstrata analisar(String codigo)
    {
        try
        {
            this.codigo = codigo;
            ANTLRStringStream antlrStringStream = new ANTLRStringStream(codigo);
            portugolLexer = new PortugolLexer(antlrStringStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(portugolLexer);
            portugolParser = new PortugolParser(commonTokenStream);
            
            portugolParser.adicionarTradutorErros(this);
            return portugolParser.parse();
            
        }
        catch(RecognitionException excecao)
        {
            System.out.println("O algoritmo contém erros");
            return null;
        }
    }
    
    @Override
    public void traduzirErroSintatico(String contexto, RecognitionException erro, String[] tokens)
    {
        if (contexto != null)
        {
            if (erro instanceof NoViableAltException)
            {
                if (contexto.equals("declaracaoTipoDado"))
                    notificarErroSintatico(new ErroTipoDeDadoNaoInformado(erro.line, erro.charPositionInLine, codigo));
            }
            
            else
            
            if (contexto.equals("programa")) traduzirErrosDeclaracaoPrograma(erro, tokens);
            
            else
            
            notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contexto));
        }
        
        else notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contexto));
    }

    
    private void traduzirErrosDeclaracaoPrograma(RecognitionException erro, String[] tokens)
    {
        String textoToken_PR_PROGRAMA = "programa";
        notificarErroSintatico(new ErroDeclaracaoPrograma(erro.line, erro.charPositionInLine, textoToken_PR_PROGRAMA));        
    }
    
    private class ErroSintaticoNaoTratado extends ErroSintatico
    {
        private String contexto;
        private RecognitionException erro;
        
        public ErroSintaticoNaoTratado(RecognitionException erro, String contexto)
        {
            super(erro.line, erro.charPositionInLine);
            this.erro = erro;
            this.contexto = contexto;
        }
        
        @Override
        protected String construirMensagem()
        {
            String msg = "";
            
            if (contexto != null)
                msg = msg + "Contexto " + contexto + " -> ";
            
            return msg + portugolParser.getErrorHeader(erro) + " - " + portugolParser.getErrorMessage(erro, portugolParser.getTokenNames()) + " Tipo: " + erro.getClass().getSimpleName();
        }                
    }
}