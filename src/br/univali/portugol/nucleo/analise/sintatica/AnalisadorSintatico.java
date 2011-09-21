
package br.univali.portugol.nucleo.analise.sintatica;

import br.univali.portugol.nucleo.analise.sintatica.erros.ErroDeclaracaoPrograma;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiAbertoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoNaoFoiFechadoCorretamente;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroAbreFechaParenteses;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroEscopoSimples;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoEsperada;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroExpressaoIncompleta;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroNomeSimboloEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroPalavraReservadaEstaFaltando;
import br.univali.portugol.nucleo.analise.sintatica.erros.ErroTipoDeDadoEstaFaltando;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
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
    private List<RecognitionException> erros;
    private List<ObservadorAnaliseSintatica> observadores;
    
    public AnalisadorSintatico()
    {
        observadores = new ArrayList<ObservadorAnaliseSintatica>();
        erros = new ArrayList<RecognitionException>();
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
    
    private void notificarErroSintatico(ErroSintatico erroSintatico, RecognitionException erro)
    {
        erros.add(erro);
        
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
    public void traduzirErroSintatico(Stack<String> pilhaContexto, RecognitionException erro, String[] tokens)
    {
        int linha = erro.line;
        int coluna = erro.charPositionInLine;

        String contextoAtual = "";
        String contextoAnterior = "";
        
        try { contextoAtual = pilhaContexto.pop(); }
        catch (Exception e){ contextoAtual = ""; }
        
        try { contextoAnterior = pilhaContexto.pop(); }
        catch (Exception e) { contextoAnterior = ""; }
        
        if (erro instanceof NoViableAltException)
        {
            if (contextoAtual.equals("declaracaoTipoDado"))
                notificarErroSintatico(new ErroTipoDeDadoEstaFaltando(erro.line, erro.charPositionInLine, codigo), erro);

            else

            if (contextoAtual.equals("expressao7"))
            {
                do { contextoAnterior = pilhaContexto.pop(); }
                while (contextoAnterior.startsWith("expressao"));
                    
                if ((contextoAnterior.equals("se") || contextoAnterior.equals("enquanto") || contextoAnterior.equals("facaEnquanto") || contextoAnterior.equals("escolha")))
                    notificarErroSintatico(new ErroExpressaoEsperada(linha, coluna, contextoAnterior), erro);
                
                
                else notificarErroSintatico(new ErroExpressaoIncompleta(erro.line, erro.charPositionInLine), erro);
            }
            
            else
                
            if (contextoAtual.equals("listaBlocos"))
            {
                notificarErroSintatico(new ErroEscopoSimples(linha, coluna), erro);
            }
            
            else notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contextoAtual), erro);
        }

        else

        if (erro instanceof MissingTokenException)
        {
            if (((MissingTokenException) erro).getMissingType() == PortugolLexer.ID)
                notificarErroSintatico(new ErroNomeSimboloEstaFaltando(erro.line, erro.charPositionInLine, contextoAtual), erro);
            
            else
                
            if (((MissingTokenException) erro).getMissingType() == PortugolLexer.T__67)
                notificarErroSintatico(new ErroEscopoNaoFoiAbertoCorretamente(linha, coluna, contextoAtual), erro);
            
            else
                
            if (((MissingTokenException) erro).getMissingType() == PortugolLexer.T__42)
                notificarErroSintatico(new ErroAbreFechaParenteses(linha, coluna, contextoAtual, "("), erro);
            
            else
                
            if (((MissingTokenException) erro).getMissingType() == PortugolLexer.T__43)
                notificarErroSintatico(new ErroAbreFechaParenteses(linha, coluna, contextoAtual, ")"), erro);
            
            else notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contextoAtual), erro);
        }

        else

        if (erro instanceof MismatchedTokenException)
        {
            if (((MismatchedTokenException) erro).expecting == PortugolLexer.ID)
                notificarErroSintatico(new ErroNomeSimboloEstaFaltando(erro.line, erro.charPositionInLine, contextoAtual), erro);

            else
            
            if (((MismatchedTokenException) erro).expecting == PortugolLexer.T__68)
                notificarErroSintatico(new ErroEscopoNaoFoiFechadoCorretamente(linha, coluna, contextoAtual), erro);
            
            else
            
            if (((MismatchedTokenException) erro).expecting == PortugolLexer.T__42)    
                notificarErroSintatico(new ErroAbreFechaParenteses(linha, coluna, contextoAtual, "("), erro);
            
            else
                
            if (((MismatchedTokenException) erro).expecting == PortugolLexer.T__43)    
                notificarErroSintatico(new ErroAbreFechaParenteses(linha, coluna, contextoAtual, ")"), erro);
            
            if (tokens[((MismatchedTokenException) erro).expecting].startsWith("PR_"))
            {
                String palavraReservada = tokens[((MismatchedTokenException) erro).expecting];
                palavraReservada = palavraReservada.replace("PR_", "").toLowerCase();
                        
                notificarErroSintatico(new ErroPalavraReservadaEstaFaltando(linha, coluna, palavraReservada), erro);
            }
               
            else notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contextoAtual), erro);
        }

        else notificarErroSintatico(new ErroSintaticoNaoTratado(erro, contextoAtual), erro);
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