package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ErroInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroInicializacaoInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroLeiaNecessitaReferencia;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroNumeroParametrosPassadosFuncao;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroParametroRedeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroReferenciaInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSemanticoNaoTratado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloRedeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroTipoParametroIncompativel;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroTiposIncompativeis;
import br.univali.portugol.nucleo.analise.semantica.erros.ExcecaoImpossivelDeterminarTipoDado;
import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.CarregadorBibliotecas;
import br.univali.portugol.nucleo.bibliotecas.base.ErroCarregamentoBiblioteca;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    
    private static final List<String> funcoesReservadas = getLista();
    
    private TabelaCompatibilidadeTipos tabelaCompatibilidadeTipos = TabelaCompatibilidadeTiposPortugol.INSTANCE;
    private ArvoreSintaticaAbstrata asa;
    private Map<String, Biblioteca> bibliotecas;
    
    private Funcao funcaoAtual;
    
    public AnalisadorSemantico()
    {
        tabelaSimbolos = new TabelaSimbolos();
        bibliotecas = new TreeMap<String, Biblioteca> ();
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
        {
            observadores.add(observadorAnaliseSemantica);
        }
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
        this.asa = asa;
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
        for (NoInclusaoBiblioteca inclusao : asap.getListaInclusoesBibliotecas())
        {
            inclusao.aceitar(this);
        }
        
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
        return TipoDado.CADEIA;
    }

    @Override
    public Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
    {
        return TipoDado.CARACTER;
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        if (chamadaFuncao.getEscopo() == null)
        {
            return analisarChamadaFuncaoPrograma(chamadaFuncao);
        }
        else
        {
            return analisarChamadaFuncaoBiblioteca(chamadaFuncao);
        }        
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
            funcaoAtual = (Funcao) tabelaSimbolos.obter(declaracaoFuncao.getNome());
            List<NoDeclaracaoParametro> parametros = declaracaoFuncao.getParametros();
            for (NoDeclaracaoParametro noDeclaracaoParametro : parametros)
            {
                noDeclaracaoParametro.aceitar(this);
            }
            analisarListaBlocos(declaracaoFuncao.getBlocos());
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
            } 
            else if (funcoesReservadas.contains(nome))
            {
                variavel.setRedeclarado(true);
                Funcao funcaoSistam = new Funcao(nome, TipoDado.VAZIO, Quantificador.VETOR, null, null);
                notificarErroSemantico(new ErroSimboloRedeclarado(variavel, funcaoSistam));
            }

            tabelaSimbolos.adicionar(variavel);
    
            if (declaracaoVariavel.getInicializacao() != null)
            {
                // Posteriormente restringir na gramática para não permitir atribuir vetor ou matriz a uma variável comum
                
                if (!(declaracaoVariavel.getInicializacao() instanceof NoVetor) && !(declaracaoVariavel.getInicializacao() instanceof NoMatriz))
                {
                    NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                    referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacaoAtribuicao(referencia, inicializacao);

                    try 
                    {
                        operacao.aceitar(this);
                    }
                    catch (ExcecaoVisitaASA excecao)
                    {
                        if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                        {
                            throw excecao;
                        }
                    }
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
        TipoDado tipoDadoCondicao = (TipoDado) noEnquanto.getCondicao().aceitar(this);
        
        if (tipoDadoCondicao != TipoDado.LOGICO) 
        {
            notificarErroSemantico(new ErroTiposIncompativeis(noEnquanto, tipoDadoCondicao));
        }
        
        analisarListaBlocos(noEnquanto.getBlocos());
        
        return null;
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        //TipoDado tipoDado = (TipoDado) noEscolha.getExpressao().aceitar(this);
        //notificarErroSemantico(new ErroTiposIncompativeis(noEscolha, tipoDado));
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        analisarListaBlocos(noFacaEnquanto.getBlocos());
        
        TipoDado tipoDadoCondicao = (TipoDado) noFacaEnquanto.getCondicao().aceitar(this);
        
        if (tipoDadoCondicao != TipoDado.LOGICO) 
        {
            notificarErroSemantico(new ErroTiposIncompativeis(noFacaEnquanto, tipoDadoCondicao));
        }
        
        return null;
    }

    @Override
    public Object visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
    {
        return TipoDado.INTEIRO;
    }

    @Override
    public Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA
    {
        return TipoDado.LOGICO;
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
    public Object visitar(NoOperacaoLogicaIgualdade noOperacao) throws ExcecaoVisitaASA
    {        
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaE noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaOU noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaior noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoSoma noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoSubtracao noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoDivisao noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao);
    }

    @Override
    public Object visitar(NoOperacaoModulo noOperacao) throws ExcecaoVisitaASA
    {
        return recuperaTipoNoOperacao(noOperacao); 
    }
    
    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        tabelaSimbolos.empilharEscopo();
         
        noPara.getInicializacao().aceitar(this);
        
        TipoDado tipoDadoCondicao = (TipoDado) noPara.getCondicao().aceitar(this);
        
        if (tipoDadoCondicao != TipoDado.LOGICO)
        {
            notificarErroSemantico(new ErroTiposIncompativeis(noPara, tipoDadoCondicao));
        }
        
        noPara.getIncremento().aceitar(this);
        
        analisarListaBlocos(noPara.getBlocos());
        
        tabelaSimbolos.desempilharEscopo();
        
        return null;
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        return null;
    }

    @Override
    public Object visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReal noReal) throws ExcecaoVisitaASA
    {
        return TipoDado.REAL;
    }

    @Override
    public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        if (noReferenciaVariavel.getEscopo() == null)
        {
            return analisarReferenciaVariavelPrograma(noReferenciaVariavel);
        }
        else
        {
            return analisarReferenciaVariavelBiblioteca(noReferenciaVariavel);
        }
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        TipoDado tipoDadoRetorno = TipoDado.VAZIO;
        
        if (noRetorne.getExpressao() != null) 
        {
             tipoDadoRetorno = (TipoDado) noRetorne.getExpressao().aceitar(this);
        }
        
        if (funcaoAtual.getTipoDado() != tipoDadoRetorno)
        {
            notificarErroSemantico(new ErroTiposIncompativeis(noRetorne, funcaoAtual.getTipoDado(), tipoDadoRetorno).incluirDetalhes(funcaoAtual.getNome()));
        }
        
        return null;
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        TipoDado tipoDadoCondicao = (TipoDado) noSe.getCondicao().aceitar(this);
        
        if (tipoDadoCondicao != TipoDado.LOGICO)
        {
            notificarErroSemantico(new ErroTiposIncompativeis(noSe, tipoDadoCondicao));
        }
        
        analisarListaBlocos(noSe.getBlocosVerdadeiros());
        analisarListaBlocos(noSe.getBlocosFalsos());
        
        return null;
    }

    @Override
    public Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA
    {
        List<NoExpressao> valores = (List) noVetor.getValores();
        
        if (valores != null && !valores.isEmpty())
        {        
            TipoDado tipoDadoVetor = (TipoDado) ((NoExpressao) valores.get(0)).aceitar(this);
            
            for (int i = 1; i < valores.size(); i++)
            {                                    
                TipoDado tipoDadoElemento = (TipoDado) ((NoExpressao) valores.get(i)).aceitar(this);

                if (tipoDadoElemento != tipoDadoVetor) 
                {
                    notificarErroSemantico(new ErroSemantico(0, 0)
                    {
                        @Override
                        protected String construirMensagem()
                        {
                            return "A inicialização do vetor possui mais de um tipo de dado";
                        }
                    });
                    return TipoDado.VAZIO;
                }
            }          
            return tipoDadoVetor;   
        }
        else
        {
            //TODO Fazer essa verificaçao no Sintatico (Portugol.g)
            notificarErroSemantico(new ErroSemantico(0, 0)
            {
                    @Override
                    protected String construirMensagem()
                    {
                        return "A inicialização do vetor não possui elementos";
                    }
            });
            
            return TipoDado.VAZIO;
        }
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoParametro.getNome();
        TipoDado tipoDado = noDeclaracaoParametro.getTipoDado();
        Quantificador quantificador = noDeclaracaoParametro.getQuantificador();
        Simbolo simbolo = null;

        if (quantificador == Quantificador.VALOR)
        {
            simbolo = new Variavel(nome, tipoDado);
        }
        
        else 
        
        if (quantificador == Quantificador.VETOR)
        {
            simbolo = new Vetor(nome, tipoDado, 0, new ArrayList<Object>());
        }
        
        else 
            
        if (quantificador == Quantificador.MATRIZ)
        {
            simbolo = new Matriz(nome, tipoDado, 0, 0, new ArrayList<List<Object>>());
        }
        
        if (tabelaSimbolos.contem(nome))
        {
            notificarErroSemantico(new ErroParametroRedeclarado(noDeclaracaoParametro, funcaoAtual));
        }
        
        tabelaSimbolos.adicionar(simbolo);
        
        return null;
    }
    
    private boolean analisandoEscopoGlobal()
    {
        return tabelaSimbolos.getNumeroEscopos() == 1;
    }
    
    private static List<String> getLista()
    {
        List<String> funcoes = new ArrayList<String>();
        
        funcoes.add("leia");
        funcoes.add("escreva");
        
        return funcoes;
    }
    
    private TipoDado recuperaTipoNoOperacao(NoOperacao noOperacao) throws ExcecaoVisitaASA
    {
        TipoDado operandoEsquerdo = null;
        TipoDado operandoDireito = null;
        
        try { operandoEsquerdo = (TipoDado) noOperacao.getOperandoEsquerdo().aceitar(this); }
        catch (ExcecaoVisitaASA excecao) 
        { 
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado)) 
            {
                throw excecao;
            }
        }
        
        try { operandoDireito = (TipoDado) noOperacao.getOperandoDireito().aceitar(this); }
        catch (ExcecaoVisitaASA excecao) 
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado)) 
            {
                throw excecao;
            }
        }
        
        if (operandoEsquerdo != null && operandoDireito != null)
        {
            try
            {
                return tabelaCompatibilidadeTipos.getRetorno(noOperacao.getClass(), operandoEsquerdo, operandoDireito);
            }
            catch (ExcecaoImpossivelDeterminarTipoDado excecao)
            {
                notificarErroSemantico(new ErroTiposIncompativeis(noOperacao, operandoEsquerdo, operandoDireito));

                throw new ExcecaoVisitaASA(excecao, asa, noOperacao);
            }
        }
        else
        {
            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noOperacao);
        }
    }
    
    private void analisarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {    
        if (blocos == null)
        {
            return;
        }
        
        tabelaSimbolos.empilharEscopo();        
        
        for (NoBloco noBloco : blocos)
        {
            try
            {
                noBloco.aceitar(this);
            }
            catch (ExcecaoVisitaASA excecao)
            {
                if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                {
                    throw excecao;
                }
            }
        }
        
        tabelaSimbolos.desempilharEscopo();        
    } 

    @Override
    public Object visitar(NoInclusaoBiblioteca noInclusaoBiblioteca) throws ExcecaoVisitaASA
    {
        String nome = noInclusaoBiblioteca.getNome();
        String alias = noInclusaoBiblioteca.getAlias();
        
        int linha = noInclusaoBiblioteca.getTrechoCodigoFonteNome().getLinha();
        int coluna = noInclusaoBiblioteca.getTrechoCodigoFonteNome().getColuna();
        
        try
        {
            Biblioteca biblioteca = CarregadorBibliotecas.carregarBiblioteca(nome);
            
            if (bibliotecas.containsKey(nome))
            {
                notificarErroSemantico(new ErroInclusaoBiblioteca(linha, coluna, new Exception(String.format("A biblioteca \"%s\" já foi incluída", nome))));
            }
            else
            {
                bibliotecas.put(nome, biblioteca);
            }

            if (alias != null)
            {
                if (bibliotecas.containsKey(alias))
                {
                    linha = noInclusaoBiblioteca.getTrechoCodigoFonteAlias().getLinha();
                    coluna = noInclusaoBiblioteca.getTrechoCodigoFonteAlias().getColuna();

                    notificarErroSemantico(new ErroInclusaoBiblioteca(linha, coluna, new Exception(String.format("O alias \"%s\" já está sendo utilizado pela biblioteca \"%s\"", alias, bibliotecas.get(alias).getNome()))));
                }
                else
                {
                    bibliotecas.put(alias, biblioteca);
                }
            }            
        }
        catch (ErroCarregamentoBiblioteca erro)
        {
            notificarErroSemantico(new ErroInclusaoBiblioteca(linha, coluna, erro));
        }
        
        return null;
    }

    private TipoDado analisarReferenciaVariavelPrograma(NoReferenciaVariavel noReferenciaVariavel)
    {
        Simbolo simbolo = tabelaSimbolos.obter(noReferenciaVariavel.getNome());

        if (simbolo != null)
        {
            if (!(simbolo instanceof Variavel))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(noReferenciaVariavel, simbolo));
            }
            
            return simbolo.getTipoDado();
        }
        else 
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(noReferenciaVariavel));
        }
        
        return TipoDado.VAZIO;
    }

    private TipoDado analisarReferenciaVariavelBiblioteca(NoReferenciaVariavel noReferenciaVariavel)
    {
        final String escopo = noReferenciaVariavel.getEscopo();
        final String nome = noReferenciaVariavel.getNome();
        
        final int linha = noReferenciaVariavel.getTrechoCodigoFonteNome().getLinha();
        final int coluna = noReferenciaVariavel.getTrechoCodigoFonteNome().getColuna();
        
        final Biblioteca biblioteca = bibliotecas.get(escopo);        
        
        if (biblioteca != null)
        {
            for (Field variavel : biblioteca.getVariaveis())
            {
                if (variavel.getName().equals(nome))
                {
                    return TipoDado.obterTipoDadoPeloTipoJava(variavel.getType());
                }
            }

            notificarErroSemantico(new ErroSemantico(linha, coluna) 
            {
                @Override
                protected String construirMensagem()
                {
                    return String.format("A variável \"%s\" não existe na biblioteca \"%s\"", nome, biblioteca.getNome());
                }
            });
        }            
        else 
        {
            notificarErroSemantico(new ErroSemantico(linha, coluna)
            {
                @Override
                protected String construirMensagem()
                {
                    return String.format("A biblioteca \"%s\" não foi incluída no programa", escopo);
                }
            });
        }
        
        return TipoDado.VAZIO;
    }

    private Object analisarChamadaFuncaoPrograma(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        String nome = chamadaFuncao.getNome();
        
        if (!funcoesReservadas.contains(nome))
        {
            if (tabelaSimbolos.contem((nome)))
            {
                Simbolo simbolo = tabelaSimbolos.obter(nome); 

                if (simbolo instanceof Funcao) 
                {
                    Funcao funcao = (Funcao) simbolo;
                    
                    analisarChamadaFuncao(chamadaFuncao, funcao);
                } 
                else 
                {
                    notificarErroSemantico(new ErroReferenciaInvalida(chamadaFuncao, simbolo));
                }
            }
            else
            {
                notificarErroSemantico(new ErroSimboloNaoDeclarado(chamadaFuncao));
            }
        }
        else
        {
            analisarChamadaFuncaoEspecial(chamadaFuncao);
        }
        
        return null;
    }
    
    private void analisarChamadaFuncaoEspecial(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
    	List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
    	
        if (parametrosPassados == null || chamadaFuncao.getParametros().isEmpty())
        {
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(0, "leia".equals(chamadaFuncao.getNome())? -2 : -1, null, chamadaFuncao));
        }
        else if (parametrosPassados != null)
        {        
            for (NoExpressao expressao: parametrosPassados)
            {
                if ("leia".equals(chamadaFuncao.getNome()))
                {
                    if (!(expressao instanceof NoReferenciaVariavel || expressao instanceof NoReferenciaVetor || expressao instanceof NoReferenciaMatriz))
                    {
                        notificarErroSemantico(new ErroLeiaNecessitaReferencia(chamadaFuncao,expressao));
                    } 
                }

                expressao.aceitar(this);
            }
        }
    }
        
    private void analisarChamadaFuncao(NoChamadaFuncao chamadaFuncao, Funcao funcao) throws ExcecaoVisitaASA
    {
        int cont = 0;
        
        List<NoDeclaracaoParametro> parametrosEsperados = funcao.getParametros();
        List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
        
        if (parametrosPassados == null &&  parametrosEsperados.size() > 0)
        {
            cont = 0;
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(0, parametrosEsperados.size(), funcao, chamadaFuncao));
        }
        
        else if (parametrosPassados != null)
        {            
            if ( parametrosEsperados.size() > parametrosPassados.size())
            {
                cont = chamadaFuncao.getParametros().size();
                notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
            }
            else if (parametrosPassados.size() > funcao.getParametros().size())
            {
                cont = chamadaFuncao.getParametros().size();
                notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
            }
            else 
            {
                cont = parametrosPassados.size();
            }
        }
        
        for (int i = 0; i < cont; i++)
        {
            TipoDado tipoDadoParametroEsperado = parametrosEsperados.get(i).getTipoDado();
            TipoDado tipoDadoParametroPassado = null;

            try { tipoDadoParametroPassado = (TipoDado) parametrosPassados.get(i).aceitar(this); }
            catch (ExcecaoVisitaASA excecao)
            { 
                if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                {
                    throw excecao;
                }
            }

            if (tipoDadoParametroPassado != null)
            {
                if (tipoDadoParametroEsperado != tipoDadoParametroPassado)
                {
                    if (!(tipoDadoParametroPassado == TipoDado.INTEIRO && tipoDadoParametroEsperado == TipoDado.REAL))
                    {
                        notificarErroSemantico(new ErroTipoParametroIncompativel(tipoDadoParametroEsperado, tipoDadoParametroPassado, parametrosEsperados.get(i), parametrosPassados.get(i), funcao));
                    }
                }
            }
        }
    }
    

    private Object analisarChamadaFuncaoBiblioteca(final NoChamadaFuncao chamadaFuncao)
    {
        final String escopo = chamadaFuncao.getEscopo();
        final String nome = chamadaFuncao.getNome();
        
        final int linha = chamadaFuncao.getTrechoCodigoFonteNome().getLinha();
        final int coluna = chamadaFuncao.getTrechoCodigoFonteNome().getColuna();
        
        final Biblioteca biblioteca = bibliotecas.get(escopo);
        
        if (biblioteca != null)
        {
            for (Method funcao : biblioteca.getFuncoes())
            {
                if (funcao.getName().equals(nome))
                {
                    final Class[] tiposParametrosEsperados = funcao.getParameterTypes();                    
                    
                    for (int i = 0; i < chamadaFuncao.getParametros().size(); i++)
                    {
                        final int indice = i;
                        
                        try
                        {
                            final TipoDado tipoParametroPassado = (TipoDado) chamadaFuncao.getParametros().get(i).aceitar(this);
                            
                            if (tipoParametroPassado.getTipoJava() != tiposParametrosEsperados[i])
                            {
                                notificarErroSemantico(new ErroSemantico(linha, coluna)
                                {
                                    @Override
                                    protected String construirMensagem()
                                    {
                                        return String.format("Tipos incompatíveis! O parâmetro \"%s\" da função \"%s\" esperava uma expressão do tipo \"%s\" mas foi passada uma expressão do tipo \"%s\".", indice+1, chamadaFuncao.getNome(), TipoDado.obterTipoDadoPeloTipoJava(tiposParametrosEsperados[indice]), tipoParametroPassado);
                                    }
                                });
                            }
                        }
                        catch (ExcecaoVisitaASA excecao)
                        {
                            excecao.printStackTrace(System.out);
                        }
                    }
                    
                    return TipoDado.obterTipoDadoPeloTipoJava(funcao.getReturnType());
                }
            }

            notificarErroSemantico(new ErroSemantico(linha, coluna) 
            {
                @Override
                protected String construirMensagem()
                {
                    return String.format("A função \"%s\" não existe na biblioteca \"%s\"", chamadaFuncao.getNome(), biblioteca.getNome());
                }
            });
        }            
        else 
        {
            notificarErroSemantico(new ErroSemantico(linha, coluna)
            {
                @Override
                protected String construirMensagem()
                {
                    return String.format("A biblioteca \"%s\" não foi incluída no programa", escopo);
                }
            });
        }
        
        return TipoDado.VAZIO;        
    }    
}
