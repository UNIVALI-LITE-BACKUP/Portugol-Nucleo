package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ErroInicializacaoInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroReferenciaInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSemanticoNaoTratado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloRedeclarado;
import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe percorre a ASA gerada a partir do código fonte para detectar erros de semântica.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 * @see ObservadorAnaliseSemantica
 */
public final class AnalisadorSemantico implements VisitanteASA
{
    private boolean declarandoSimbolosGlobais;
    
    private TabelaSimbolos tabelaSimbolos;
    private List<ObservadorAnaliseSemantica> observadores;

    public AnalisadorSemantico()
    {
        tabelaSimbolos = new TabelaSimbolos();
        observadores = new ArrayList<ObservadorAnaliseSemantica>();
    }
    
    /** 
     * Permite adicionar um observador à análise semântica. Os observadores serão notificados sobre cada
     * erro semântico encontrado no código fonte e deverão tratá-los apropriadamente, exibindo-os em uma 
     * IDE, por exemplo.
     * 
     * @param observadorAnaliseSemantica     o observador da análise semântica a ser registrado.
     * @since 1.0
     */
    public void adicionarObservador(ObservadorAnaliseSemantica observadorAnaliseSemantica)
    {
        if (!observadores.contains(observadorAnaliseSemantica))
            observadores.add(observadorAnaliseSemantica);
    }
    
    /**
     * Remove um observador da análise previamente registrado utilizando o método 
     * {@link AnalisadorSemantico#adicionarObservador(br.univali.portugol.nucleo.analise.semantica.ObservadorAnaliseSemantica) }.
     * Uma vez removido, o observador não será mais notificado dos erros semânticos encontrados durante a análise.
     * 
     * @param observadorAnaliseSemantica     um observador de análise semântica previamente registrado.
     * @since 1.0
     */
    public void removerObservador(ObservadorAnaliseSemantica observadorAnaliseSemantica)
    {
        observadores.remove(observadorAnaliseSemantica);
    }
    
    private void notificarAviso(AvisoAnalise aviso)
    {
        for (ObservadorAnaliseSemantica observadorAnaliseSemantica: observadores)
        {
            observadorAnaliseSemantica.tratarAviso(aviso);
        }
    }
    
    private void notificarErroSemantico(ErroSemantico erroSemantico)
    {
        for (ObservadorAnaliseSemantica observadorAnaliseSemantica: observadores)
        {
            observadorAnaliseSemantica.tratarErroSemantico(erroSemantico);
        }
    }
    
    /**
     * Realiza a análise semântica de uma ASA. Este método não retorna valor e não gera exceções.
     * Para capturar os erros semânticos gerados durante a análise, deve-se registrar um ou mais
     * obsrvadores de análise utilizando o método 
     * {@link AnalisadorSemantico#adicionarObservador(br.univali.portugol.nucleo.analise.semantica.ObservadorAnaliseSemantica) }.
     * 
     * @param asa     a ASA que será percorrida em busca de erros semânticos.
     * @since 1.0
     */
    public void analisar(ArvoreSintaticaAbstrata asa)
    {
        if (asa != null)
        {
            try
            {                
                asa.aceitar(this);
            }
            catch (Exception excecao)
            {
                notificarErroSemantico(new ErroSemanticoNaoTratado(excecao));
            }
        }
    }

    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
        // Executa a primeira vez para declarar as funções na tabela de símbolos
        
        declarandoSimbolosGlobais = true;
        
        for (NoDeclaracao declaracao : asap.getListaDeclaracoesGlobais())
        {
            declaracao.aceitar(this);
        }
        
        declarandoSimbolosGlobais = false;
        
        // Executa a segunda vez para analizar os blocos das funções
        
        for (NoDeclaracao declaracao : asap.getListaDeclaracoesGlobais())
        {
            declaracao.aceitar(this);
        }        
        
        return null;
    }

    @Override
    public Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {
        if (declarandoSimbolosGlobais)
        {
            String nome = declaracaoFuncao.getNome();
            TipoDado tipoDado = declaracaoFuncao.getTipoDado();
            Quantificador quantificador = declaracaoFuncao.getQuantificador();

            Funcao funcao = new Funcao(nome, tipoDado, quantificador, declaracaoFuncao.getParametros(), declaracaoFuncao.getBlocos());
            funcao.setTrechoCodigoFonteNome(declaracaoFuncao.getTrechoCodigoFonteNome());
            funcao.setTrechoCodigoFonteTipoDado(declaracaoFuncao.getTrechoCodigoFonteTipoDado());
        
            if (tabelaSimbolos.contem(nome))
            {
                notificarErroSemantico(new ErroSimboloRedeclarado(funcao, tabelaSimbolos.obter(nome)));
                funcao.setRedeclarado(true);
            }

            tabelaSimbolos.adicionar(funcao);
        }
        else
        {    
            if (declaracaoFuncao.getBlocos() != null)
            {
                tabelaSimbolos.empilharEscopo();
                    
                for (NoBloco bloco : declaracaoFuncao.getBlocos())
                {
                    bloco.aceitar(this);
                }
                
                tabelaSimbolos.desempilharEscopo();
            }
        }
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel declaracaoVariavel) throws ExcecaoVisitaASA
    {
        if (declarandoSimbolosGlobais == analisandoEscopoGlobal())
        {
            String nome = declaracaoVariavel.getNome();
            TipoDado tipoDados = declaracaoVariavel.getTipoDado();

            Variavel variavel = new Variavel(nome, tipoDados);
            variavel.setConstante(declaracaoVariavel.constante());
            variavel.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
            variavel.setTrechoCodigoFonteTipoDado(declaracaoVariavel.getTrechoCodigoFonteTipoDado());

            if (tabelaSimbolos.contem(nome))
            {
                variavel.setRedeclarado(true);
                notificarErroSemantico(new ErroSimboloRedeclarado(variavel, tabelaSimbolos.obter(nome)));
            } /*
            else if (funcoesReservadas.contains(nome))
            {
                variavel.setRedeclarado(true);
                Funcao funcaoSistam = new Funcao(nome, tipoDados.VAZIO, Quantificador.VETOR, null, null);
                notificarErroSemantico(new ErroSimboloRedeclarado(variavel, funcaoSistam));
            }*/

            tabelaSimbolos.adicionar(variavel);
    
            if (declaracaoVariavel.getInicializacao() != null)
            {
                // Posteriormente restringir na gramática para não permitir atribuir vetor ou matriz a uma variável comum
                
                if (!(declaracaoVariavel.getInicializacao() instanceof NoVetor) && !(declaracaoVariavel.getInicializacao() instanceof NoMatriz))
                {
                    NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
                    referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);

                    operacao.aceitar(this);
                }
                else
                {
                    notificarErroSemantico(new ErroInicializacaoInvalida(declaracaoVariavel,declaracaoVariavel.getInicializacao(),declaracaoVariavel.getInicializacao().getTrechoCodigoFonte().getLinha() , declaracaoVariavel.getInicializacao().getTrechoCodigoFonte().getColuna()));
                }
            }
        }
    
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoNao noNao) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoOperacao noOperacao) throws ExcecaoVisitaASA
    {
        noOperacao.getOperandoEsquerdo().aceitar(this);
        noOperacao.getOperandoDireito().aceitar(this);
        
        return null;
    }

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReal noReal) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        Simbolo simbolo = tabelaSimbolos.obter(noReferenciaVariavel.getNome());

        if (simbolo != null)
        {
            if (!(simbolo instanceof Variavel))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(noReferenciaVariavel, simbolo));
            }
        }        
        else 
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(noReferenciaVariavel));
        }

        return null;
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private boolean analisandoEscopoGlobal()
    {
        return tabelaSimbolos.getNumeroEscopos() == 1;
    }
}
