package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.avisos.AvisoSimboloGlobalOcultado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroInicializacaoInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroLeiaNecessitaReferencia;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroNumeroParametrosPassadosFuncao;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroOperacaoComExpressaoConstante;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroParametroRedeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroPassagemParametroInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroReferenciaInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSemanticoNaoTratado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoInicializado;
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
 * 
 * @version 2.0
 * 
 * @see AnalisadorSintatico
 * @see ObservadorAnaliseSemantica
 */
public final class AnalisadorSemantico implements VisitanteASA
{
    private boolean declarandoSimbolosGlobais;
    
    private Memoria memoria;
    private List<ObservadorAnaliseSemantica> observadores;
    
    private static final List<String> funcoesReservadas = getLista();
    
    private TabelaCompatibilidadeTipos tabelaCompatibilidadeTipos = TabelaCompatibilidadeTiposPortugol.INSTANCE;
    private ArvoreSintaticaAbstrata asa;
    private Map<String, Biblioteca> bibliotecas;
    
    private Funcao funcaoAtual;
    private TipoDado tipoDadoEscolha;
    private boolean declarandoVetor;
    private boolean declarandoMatriz;
    
    public AnalisadorSemantico()
    {
        memoria = new Memoria();
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
        if (noCaso.getExpressao() != null) {
            TipoDado tipoDado = (TipoDado) noCaso.getExpressao().aceitar(this);

            if ((tipoDadoEscolha == TipoDado.INTEIRO) || (tipoDadoEscolha == TipoDado.CARACTER)){
               if (tipoDado != tipoDadoEscolha){
                   notificarErroSemantico(new ErroTiposIncompativeis(noCaso, tipoDado, tipoDadoEscolha));
               } 
            } else {
                if ((tipoDado != TipoDado.INTEIRO) && (tipoDado != TipoDado.CARACTER)){
                    notificarErroSemantico(new ErroTiposIncompativeis(noCaso, tipoDado, TipoDado.INTEIRO, TipoDado.CARACTER));
                }
            }
        }
        
        analisarListaBlocos(noCaso.getBlocos());
        
        return null;
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
        
            try
            {
                Simbolo simbolo = memoria.getSimbolo(nome);
                notificarErroSemantico(new ErroSimboloRedeclarado(funcao, simbolo));
                
                funcao.setRedeclarado(true);
            }
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                 memoria.adicionarSimbolo(funcao);
            }
        }
        else
        {   
            try
            {
                funcaoAtual = (Funcao) memoria.getSimbolo(declaracaoFuncao.getNome());
                memoria.empilharFuncao();
                List<NoDeclaracaoParametro> parametros = declaracaoFuncao.getParametros();
                for (NoDeclaracaoParametro noDeclaracaoParametro : parametros)
                {
                    noDeclaracaoParametro.aceitar(this);
                }
                analisarListaBlocos(declaracaoFuncao.getBlocos());
            }
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, declaracaoFuncao);
            }
            finally
            {
                memoria.desempilharFuncao();
            }
        }
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
        if (declarandoSimbolosGlobais == memoria.isEscopoGlobal())
        {
            String nome = noDeclaracaoMatriz.getNome();
            TipoDado tipoDados = noDeclaracaoMatriz.getTipoDado();
            Integer linhas = null;
            Integer colunas = null;
            
            if ((noDeclaracaoMatriz.getNumeroLinhas() != null && !(noDeclaracaoMatriz.getNumeroLinhas()instanceof NoInteiro))
                    && (noDeclaracaoMatriz.getNumeroColunas()) != null && !(noDeclaracaoMatriz.getNumeroColunas()instanceof NoInteiro)){
                                
                    notificarErroSemantico(new ErroSemantico(noDeclaracaoMatriz.getNumeroLinhas().getTrechoCodigoFonte()) {

                    @Override
                    protected String construirMensagem()
                    {
                        return "A número de linhas ou colunas da matriz deve ser um valor inteiro constante";
                    }
                });
            } else {
                if (noDeclaracaoMatriz.getNumeroLinhas()!= null)
                    linhas = ((NoInteiro)noDeclaracaoMatriz.getNumeroLinhas()).getValor();
                if (noDeclaracaoMatriz.getNumeroColunas() != null)
                    colunas = ((NoInteiro)noDeclaracaoMatriz.getNumeroColunas()).getValor();
            }
                  
            Matriz matriz = new Matriz(nome, tipoDados,1,1);
            matriz.setTrechoCodigoFonteNome(noDeclaracaoMatriz.getTrechoCodigoFonteNome());
            matriz.setTrechoCodigoFonteTipoDado(noDeclaracaoMatriz.getTrechoCodigoFonteTipoDado());

            try
            {
                Simbolo simboloExistente = memoria.getSimbolo(nome);
                
                if 
                (
                    (memoria.isGlobal(simboloExistente) && memoria.isGlobal(matriz)) ||
                    (memoria.isLocal(simboloExistente) && memoria.isLocal(matriz))
                )
                {
                    matriz.setRedeclarado(true);
                    notificarErroSemantico(new ErroSimboloRedeclarado(matriz, simboloExistente));
                }
                else
                {
                    Simbolo simboloGlobal = memoria.isGlobal(simboloExistente)? simboloExistente : matriz;
                    Simbolo simboloLocal = memoria.isGlobal(simboloExistente)? matriz : simboloExistente;
                    
                    notificarAviso(new AvisoSimboloGlobalOcultado(simboloGlobal, simboloLocal, noDeclaracaoMatriz));
                }
            } 
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                if (funcoesReservadas.contains(nome))
                {
                    matriz.setRedeclarado(true);
                    Funcao funcaoSistam = new Funcao(nome, TipoDado.VAZIO, Quantificador.VETOR, null, null);
                    notificarErroSemantico(new ErroSimboloRedeclarado(matriz, funcaoSistam));
                }
                else
                {
                    memoria.adicionarSimbolo(matriz);
                }
            }
            
            if (noDeclaracaoMatriz.constante() && noDeclaracaoMatriz.getInicializacao() == null)
            {
                NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                referencia.setTrechoCodigoFonteNome(noDeclaracaoMatriz.getTrechoCodigoFonteNome());
                    
                notificarErroSemantico(new ErroSimboloNaoInicializado(referencia, matriz));
            }
            
            if (noDeclaracaoMatriz.getInicializacao() != null)
            {                
                if (noDeclaracaoMatriz.getInicializacao() instanceof NoMatriz)
                {
                    NoExpressao inicializacao = noDeclaracaoMatriz.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                    referencia.setTrechoCodigoFonteNome(noDeclaracaoMatriz.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacaoAtribuicao(referencia, inicializacao);
                           
                    if (linhas != null){
                        if (linhas != ((NoMatriz)inicializacao).getValores().size())
                        {
                            final int pLinhas = linhas;
                            final String pNome = nome;
                            
                            notificarErroSemantico(new ErroSemantico(noDeclaracaoMatriz.getInicializacao().getTrechoCodigoFonte())
                            {
                                @Override
                                protected String construirMensagem()
                                {
                                    return String.format("A inicialização da matriz \"%s\" deve possuir %d linhas", pNome, pLinhas);
                                }
                            });
                        }
                    }
                    
                     if (colunas != null)
                     {
                        for (int lin = 0; lin < ((NoMatriz)inicializacao).getValores().size(); lin++)
                        {
                            if (colunas != ((NoMatriz)inicializacao).getValores().get(lin).size())
                            {
                                final int pColunas = colunas;
                                final String pNome = nome;
                                final int pLin = lin;

                                notificarErroSemantico(new ErroSemantico(noDeclaracaoMatriz.getInicializacao().getTrechoCodigoFonte())
                                {
                                    @Override
                                    protected String construirMensagem()
                                    {
                                        return String.format("A linha %d na inicialização da matriz \"%s\" deve possuir %d elementos", pLin, pNome, pColunas);
                                    }
                                });
                            }
                        }
                     }
                    
                    try 
                    {
                        this.declarandoMatriz = true;
                        operacao.aceitar(this);
                        this.declarandoMatriz = false;
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
                    notificarErroSemantico(new ErroInicializacaoInvalida(noDeclaracaoMatriz));
                }
            }
            
            matriz.setConstante(noDeclaracaoMatriz.constante());
        }
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel declaracaoVariavel) throws ExcecaoVisitaASA
    {        
        if (declarandoSimbolosGlobais == memoria.isEscopoGlobal())
        {
            String nome = declaracaoVariavel.getNome();
            TipoDado tipoDados = declaracaoVariavel.getTipoDado();

            Variavel variavel = new Variavel(nome, tipoDados);
            variavel.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
            variavel.setTrechoCodigoFonteTipoDado(declaracaoVariavel.getTrechoCodigoFonteTipoDado());

            try
            {
                Simbolo simboloExistente = memoria.getSimbolo(nome);
                
                if 
                (
                    (memoria.isGlobal(simboloExistente) && memoria.isGlobal(variavel)) ||
                    (memoria.isLocal(simboloExistente) && memoria.isLocal(variavel))
                )
                {
                    variavel.setRedeclarado(true);
                    notificarErroSemantico(new ErroSimboloRedeclarado(variavel, simboloExistente));
                }
                else 
                {
                   Simbolo simboloGlobal = memoria.isGlobal(simboloExistente)? simboloExistente : variavel;
                   Simbolo simboloLocal = memoria.isGlobal(simboloExistente)? variavel : simboloExistente;

                   notificarAviso(new AvisoSimboloGlobalOcultado(simboloGlobal, simboloLocal, declaracaoVariavel));
                }
            } 
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                if (funcoesReservadas.contains(nome))
                {
                    variavel.setRedeclarado(true);
                    Funcao funcaoSistam = new Funcao(nome, TipoDado.VAZIO, Quantificador.VETOR, null, null);
                    notificarErroSemantico(new ErroSimboloRedeclarado(variavel, funcaoSistam));
                }
                else
                {
                    memoria.adicionarSimbolo(variavel);
                }
            }            
            
            if (declaracaoVariavel.constante() && declaracaoVariavel.getInicializacao() == null)
            {
                NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                    
                notificarErroSemantico(new ErroSimboloNaoInicializado(referencia, variavel));
            }
            
            if (declaracaoVariavel.getInicializacao() != null)
            {
                // Posteriormente restringir na gramática para não permitir atribuir vetor ou matriz a uma variável comum
                
                if (!(declaracaoVariavel.getInicializacao() instanceof NoVetor) && !(declaracaoVariavel.getInicializacao() instanceof NoMatriz))
                {
                    NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                    referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacaoAtribuicao(referencia, inicializacao);
                    
                    memoria.empilharEscopo();
                    memoria.adicionarSimbolo(variavel);
                    
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
                    
                    memoria.desempilharEscopo();                
                }
                else
                {
                    notificarErroSemantico(new ErroInicializacaoInvalida(declaracaoVariavel));
                }
            }
            
            variavel.setConstante(declaracaoVariavel.constante());
            
        }
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {     
        if (declarandoSimbolosGlobais == memoria.isEscopoGlobal())
        {
            String nome = noDeclaracaoVetor.getNome();
            TipoDado tipoDados = noDeclaracaoVetor.getTipoDado();
            Integer tamanho = null;
            
            if (noDeclaracaoVetor.getTamanho() != null && !(noDeclaracaoVetor.getTamanho() instanceof NoInteiro)){
                                
                notificarErroSemantico(new ErroSemantico() {

                    @Override
                    protected String construirMensagem()
                    {
                        return "O tamanho do vetor deve ser um valor inteiro constante";
                    }
                });
            } else {
                if (noDeclaracaoVetor.getTamanho() != null)
                    tamanho = ((NoInteiro)noDeclaracaoVetor.getTamanho()).getValor();
            }
                  
            Vetor vetor = new Vetor(nome, tipoDados,1);
            vetor.setTrechoCodigoFonteNome(noDeclaracaoVetor.getTrechoCodigoFonteNome());
            vetor.setTrechoCodigoFonteTipoDado(noDeclaracaoVetor.getTrechoCodigoFonteTipoDado());

            try
            {
                 Simbolo simboloExistente = memoria.getSimbolo(nome);
                
                 if 
                (
                    (memoria.isGlobal(simboloExistente) && memoria.isGlobal(vetor)) ||
                    (memoria.isLocal(simboloExistente) && memoria.isLocal(vetor))
                )
                {
                    vetor.setRedeclarado(true);
                    notificarErroSemantico(new ErroSimboloRedeclarado(vetor, simboloExistente));
                }
                else
                {
                    Simbolo simboloGlobal = memoria.isGlobal(simboloExistente)? simboloExistente : vetor;
                    Simbolo simboloLocal = memoria.isGlobal(simboloExistente)? vetor : simboloExistente;

                    notificarAviso(new AvisoSimboloGlobalOcultado(simboloGlobal, simboloLocal, noDeclaracaoVetor));
                }
            } 
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                if (funcoesReservadas.contains(nome))
                {
                    vetor.setRedeclarado(true);
                    Funcao funcaoSistam = new Funcao(nome, TipoDado.VAZIO, Quantificador.VETOR, null, null);
                    notificarErroSemantico(new ErroSimboloRedeclarado(vetor, funcaoSistam));
                }
                else
                {
                     memoria.adicionarSimbolo(vetor);
                }
            }
            
            if (noDeclaracaoVetor.constante() && noDeclaracaoVetor.getInicializacao() == null)
            {
                NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                referencia.setTrechoCodigoFonteNome(noDeclaracaoVetor.getTrechoCodigoFonteNome());
                    
                notificarErroSemantico(new ErroSimboloNaoInicializado(referencia, vetor));
            }

            
            if (noDeclaracaoVetor.getInicializacao() != null)
            {
            
                if (noDeclaracaoVetor.getInicializacao() instanceof NoVetor)
                {
                    NoExpressao inicializacao = noDeclaracaoVetor.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(null, nome);
                    referencia.setTrechoCodigoFonteNome(noDeclaracaoVetor.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacaoAtribuicao(referencia, inicializacao);
                    
                    if (tamanho != null){
                        if (tamanho != ((NoVetor)inicializacao).getValores().size()){
                            final int pTamanho = tamanho;
                            final String pNome = nome;
                            
                            notificarErroSemantico(new ErroSemantico(noDeclaracaoVetor.getInicializacao().getTrechoCodigoFonte())
                            {
                                @Override
                                protected String construirMensagem()
                                {
                                    return String.format("A inicializaçao do vetor \"%s\" deve possuir %d elemento(s)", pNome, pTamanho);
                                }
                            });
                        }
                    }
                   
                    try 
                    {
                        this.declarandoVetor = true;
                        operacao.aceitar(this);
                        this.declarandoVetor = false;
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
                    notificarErroSemantico(new ErroInicializacaoInvalida(noDeclaracaoVetor));
                }
            }
            
            vetor.setConstante(noDeclaracaoVetor.constante());
        }
        
        return null;
        
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
        tipoDadoEscolha = (TipoDado) noEscolha.getExpressao().aceitar(this);
        
        if ((tipoDadoEscolha != TipoDado.INTEIRO) && (tipoDadoEscolha != TipoDado.CARACTER)){
            notificarErroSemantico(new ErroTiposIncompativeis(noEscolha, tipoDadoEscolha,TipoDado.INTEIRO,TipoDado.CARACTER));
        }
        List<NoCaso> casos = noEscolha.getCasos();
        for (NoCaso noCaso : casos)
        {
            noCaso.aceitar(this);
        }
        return null;
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
        List<List<Object>> valores = noMatriz.getValores();
        
        if (valores != null && !valores.isEmpty()){
            
            try
            {
                TipoDado tipoMatriz = (TipoDado) ((NoExpressao) valores.get(0).get(0)).aceitar(this);
                for (List<Object> valList : valores)
                {
                    for (int i = 0; i < valList.size(); i++)
                    {
                        TipoDado tipoDadoElemento = (TipoDado) ((NoExpressao) valList.get(i)).aceitar(this);

                        if (tipoMatriz != tipoDadoElemento)
                        {
                            notificarErroSemantico(new ErroSemantico(noMatriz.getTrechoCodigoFonte())
                            {
                                @Override
                                protected String construirMensagem()
                                {
                                    return "A inicialização da matriz possui mais de um tipo de dado";
                                }
                            });                        
                            
                            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noMatriz);
                        }
                    }
                }
                return tipoMatriz;    
            }
            catch (Exception excecao)
            {
                //excecao.printStackTrace(System.out);
                throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noMatriz);
            }
            
        } else {
            
            notificarErroSemantico(new ErroSemantico(noMatriz.getTrechoCodigoFonte())
            {
                    @Override
                    protected String construirMensagem()
                    {
                        return "A inicialização da matriz não possui elementos";
                    }
            });

            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noMatriz);
        }
    }

    @Override
    public Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA
    {
        TipoDado tipo = (TipoDado) noMenosUnario.getExpressao().aceitar(this);
        if (!tipo.equals(TipoDado.INTEIRO) && !tipo.equals(TipoDado.REAL)){
            notificarErroSemantico(new ErroTiposIncompativeis(noMenosUnario, tipo, TipoDado.INTEIRO, TipoDado.REAL));
            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noMenosUnario);
        }
        
        return tipo;
    }

    @Override
    public Object visitar(NoNao noNao) throws ExcecaoVisitaASA
    {
        TipoDado tipo = (TipoDado) noNao.getExpressao().aceitar(this);
        if (tipo != TipoDado.LOGICO){
            notificarErroSemantico(new ErroTiposIncompativeis(noNao, tipo, TipoDado.LOGICO));
            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noNao);
        }        
        return tipo;
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
        TipoDado tipoDadoRetorno;
        
        TipoDado operandoEsquerdo = null;
        TipoDado operandoDireito = null;
        
        Simbolo simbolo = null;
        boolean inicializadoAnterior = false;
        if (!(noOperacao.getOperandoEsquerdo() instanceof NoReferencia)){
            notificarErroSemantico(new ErroOperacaoComExpressaoConstante(noOperacao, noOperacao.getOperandoEsquerdo()));
        }  else {
            try
            {
                simbolo = memoria.getSimbolo(((NoReferencia)noOperacao.getOperandoEsquerdo()).getNome());

                inicializadoAnterior = simbolo.inicializado();
                simbolo.setInicializado(true);            
                if (simbolo instanceof Variavel){
                    
                    if (simbolo.constante())
                    {
                        final Simbolo pSimbolo = simbolo;
                        
                        notificarErroSemantico(new ErroSemantico(noOperacao.getOperandoDireito().getTrechoCodigoFonte())
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                StringBuilder sb = new StringBuilder();
                                
                                if (pSimbolo instanceof Variavel)
                                {
                                    sb.append("A variável \"");
                                    sb.append(pSimbolo.getNome());
                                    sb.append("\" é constante e portante não pode ter seu valor alterado após a inicialização");
                                }
                                else if (pSimbolo instanceof Vetor)
                                {
                                    sb.append("O vetor \"");
                                    sb.append(pSimbolo.getNome());
                                    sb.append("\" é constante e portante não pode ter seus valores alterados após a inicialização");
                                }
                                else if (pSimbolo instanceof Matriz)
                                {
                                    sb.append("A matriz \"");
                                    sb.append(pSimbolo.getNome());
                                    sb.append("\" é constante e portante não pode ter seu valor alterado após a inicialização");
                                }
                                
                                return sb.toString();
                            }
                        });
                    }
                    
                    if ((noOperacao.getOperandoDireito() instanceof NoMatriz) || 
                            (noOperacao.getOperandoDireito() instanceof NoVetor))
                        notificarErroSemantico(new ErroSemantico(noOperacao.getOperandoDireito().getTrechoCodigoFonte()) {

                        @Override
                        protected String construirMensagem()
                        {
                            return "não é possível atribuir uma matriz ou um vetor a uma variável";
                        }
                    });
                } else if (simbolo instanceof Vetor) {
                    if (!(noOperacao.getOperandoDireito() instanceof NoVetor)){
                        notificarErroSemantico(new ErroSemantico(noOperacao.getOperandoDireito().getTrechoCodigoFonte()) {

                            @Override
                            protected String construirMensagem()
                            {
                                return "um vetor deve ser inicializado com um vetor literal";
                            }
                        });
                    }
                } else if (simbolo instanceof Matriz) {
                    if (!(noOperacao.getOperandoDireito() instanceof NoMatriz)){
                        notificarErroSemantico(new ErroSemantico(noOperacao.getOperandoDireito().getTrechoCodigoFonte())
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                return "uma matriz deve ser inicializada com uma matriz literal";
                            }
                        });
                    }
                }
            }
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                // Não faz nada
            }
        }
        
        try { operandoEsquerdo = (TipoDado) noOperacao.getOperandoEsquerdo().aceitar(this); }
        catch (ExcecaoVisitaASA excecao) 
        { 
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado)) 
            {
                throw excecao;
            }
        }
        
        if (simbolo != null) {
            simbolo.setInicializado(inicializadoAnterior);
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
                 tipoDadoRetorno = tabelaCompatibilidadeTipos.getRetorno(noOperacao.getClass(), operandoEsquerdo, operandoDireito);
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
        
        
        if (simbolo != null) {
            simbolo.setInicializado(true);
        }
        
        return tipoDadoRetorno;
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
        memoria.empilharEscopo();
         
        try
        {
            if (noPara.getInicializacao() != null)
            {
                noPara.getInicializacao().aceitar(this);
            }
        }
        catch (ExcecaoVisitaASA excecao)
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                throw excecao;
        }
        
        try
        {        
            TipoDado tipoDadoCondicao = (TipoDado) noPara.getCondicao().aceitar(this);

            if (tipoDadoCondicao != TipoDado.LOGICO)
            {
                notificarErroSemantico(new ErroTiposIncompativeis(noPara, tipoDadoCondicao));
            }
        }
        catch (ExcecaoVisitaASA excecao)
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                throw excecao;
        }
        
        try
        {
            noPara.getIncremento().aceitar(this);
        }
        catch (ExcecaoVisitaASA excecao)
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
                throw excecao;
        }
        
        analisarListaBlocos(noPara.getBlocos());
        
        memoria.desempilharEscopo();
        
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
        try 
        { 
            TipoDado tipoLinha = (TipoDado) noReferenciaMatriz.getLinha().aceitar(this); 
            TipoDado tipoColuna = (TipoDado) noReferenciaMatriz.getColuna().aceitar(this); 
            
            
            if (tipoLinha != TipoDado.INTEIRO && tipoColuna != TipoDado.INTEIRO)
            {
                notificarErroSemantico(new ErroTiposIncompativeis(noReferenciaMatriz, tipoLinha, TipoDado.INTEIRO, tipoColuna, TipoDado.INTEIRO));
            }
        }
        catch (ExcecaoVisitaASA excecao) 
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
            {
                throw excecao;
            }
        }        
        
        try
        {
            Simbolo simbolo = memoria.getSimbolo(noReferenciaMatriz.getNome());
         
            if (!(simbolo instanceof Matriz))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(noReferenciaMatriz, simbolo));
            }
            
            return simbolo.getTipoDado();
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado) 
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(noReferenciaMatriz));
        }
        
        throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noReferenciaMatriz);
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        if (noReferenciaVariavel.getEscopo() == null)
        {
            try
            {
                return analisarReferenciaVariavelPrograma(noReferenciaVariavel);
            }
            catch (ExcecaoImpossivelDeterminarTipoDado ex)
            {
                throw new ExcecaoVisitaASA(ex, asa, noReferenciaVariavel);
            }
        }
        else
        {
            return analisarReferenciaVariavelBiblioteca(noReferenciaVariavel);
        }
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        try 
        { 
            TipoDado tipoIndice = (TipoDado) noReferenciaVetor.getIndice().aceitar(this); 
            
            if (tipoIndice != TipoDado.INTEIRO)
            {
                notificarErroSemantico(new ErroTiposIncompativeis(noReferenciaVetor, tipoIndice, TipoDado.INTEIRO));
            }
        }
        catch (ExcecaoVisitaASA excecao) 
        {
            if (!(excecao.getCause() instanceof ExcecaoImpossivelDeterminarTipoDado))
            {
                throw excecao;
            }
        }        
        
        try
        {
            Simbolo simbolo = memoria.getSimbolo(noReferenciaVetor.getNome());
                    
            if (!(simbolo instanceof Vetor))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(noReferenciaVetor, simbolo));
            }
            
            return simbolo.getTipoDado();
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(noReferenciaVetor));
        }
        
        throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noReferenciaVetor);
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
            notificarErroSemantico(new ErroTiposIncompativeis(noRetorne, new String[] { funcaoAtual.getNome() }, funcaoAtual.getTipoDado(), tipoDadoRetorno));
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
            try
            {                
                TipoDado tipoDadoVetor = (TipoDado) ((NoExpressao) valores.get(0)).aceitar(this);

                for (int i = 1; i < valores.size(); i++)
                {                                    
                    TipoDado tipoDadoElemento = (TipoDado) ((NoExpressao) valores.get(i)).aceitar(this);

                    if (tipoDadoElemento != tipoDadoVetor) 
                    {
                        notificarErroSemantico(new ErroSemantico(noVetor.getTrechoCodigoFonte())
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                return "A inicialização do vetor possui mais de um tipo de dado";
                            }
                        });
                        
                        throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noVetor);
                    }
                }      
                return tipoDadoVetor;   
            }
            catch (Exception excecao)
            {
                //excecao.printStackTrace(System.out);
                throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noVetor);
            }
        }
        else
        {
            //TODO Fazer essa verificaçao no Sintatico (Portugol.g)
            notificarErroSemantico(new ErroSemantico(noVetor.getTrechoCodigoFonte())
            {
                    @Override
                    protected String construirMensagem()
                    {
                        return "A inicialização do vetor não possui elementos";
                    }
            });
            
            throw new ExcecaoVisitaASA(new ExcecaoImpossivelDeterminarTipoDado(), asa, noVetor);
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
        
        try
        {            
            memoria.getSimbolo(nome);
            simbolo.setRedeclarado(true);
            notificarErroSemantico(new ErroParametroRedeclarado(noDeclaracaoParametro, funcaoAtual));
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            simbolo.setInicializado(true);
            memoria.adicionarSimbolo(simbolo);
        }
        
        return null;
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
        
        memoria.empilharEscopo();        
        
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
        
        memoria.desempilharEscopo();        
    } 

    @Override
    public Object visitar(NoInclusaoBiblioteca noInclusaoBiblioteca) throws ExcecaoVisitaASA
    {
        String nome = noInclusaoBiblioteca.getNome();
        String alias = noInclusaoBiblioteca.getAlias();
        
        
        try
        {
            Biblioteca biblioteca = CarregadorBibliotecas.carregarBiblioteca(nome);
            
            if (bibliotecas.containsKey(nome))
            {
                notificarErroSemantico(new ErroInclusaoBiblioteca(noInclusaoBiblioteca.getTrechoCodigoFonteNome(), new Exception(String.format("A biblioteca \"%s\" já foi incluída", nome))));
            }
            else
            {
                bibliotecas.put(nome, biblioteca);
            }

            if (alias != null)
            {
                if (bibliotecas.containsKey(alias))
                {
                    notificarErroSemantico(new ErroInclusaoBiblioteca(noInclusaoBiblioteca.getTrechoCodigoFonteAlias(), new Exception(String.format("O alias \"%s\" já está sendo utilizado pela biblioteca \"%s\"", alias, bibliotecas.get(alias).getNome()))));
                }
                else
                {
                    bibliotecas.put(alias, biblioteca);
                }
            }            
        }
        catch (ErroCarregamentoBiblioteca erro)
        {
            notificarErroSemantico(new ErroInclusaoBiblioteca(noInclusaoBiblioteca.getTrechoCodigoFonteNome(), erro));
        }
        
        return null;
    }

    private TipoDado analisarReferenciaVariavelPrograma(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoImpossivelDeterminarTipoDado
    {
        try
        {
            Simbolo simbolo = memoria.getSimbolo(noReferenciaVariavel.getNome());
            
            if (!simbolo.inicializado()){
                notificarErroSemantico(new ErroSimboloNaoInicializado(noReferenciaVariavel,simbolo));
            }      
            
            if (!(simbolo instanceof Variavel) && !declarandoVetor && !declarandoMatriz)
            {
                notificarErroSemantico(new ErroReferenciaInvalida(noReferenciaVariavel, simbolo));
            }
            
            return simbolo.getTipoDado();
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(noReferenciaVariavel));
        }
        
        throw new ExcecaoImpossivelDeterminarTipoDado();
    }

    private TipoDado analisarReferenciaVariavelBiblioteca(NoReferenciaVariavel noReferenciaVariavel)
    {
        final String escopo = noReferenciaVariavel.getEscopo();
        final String nome = noReferenciaVariavel.getNome();
        
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

            notificarErroSemantico(new ErroSemantico(noReferenciaVariavel.getTrechoCodigoFonteNome()) 
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
            notificarErroSemantico(new ErroSemantico(noReferenciaVariavel.getTrechoCodigoFonteNome())
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
            try
            {
                Simbolo simbolo = memoria.getSimbolo(nome); 

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
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
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
                    
                    if (expressao instanceof NoReferenciaVariavel) {
                        String nome = ((NoReferenciaVariavel) expressao).getNome();
                        
                        try
                        {
                            Simbolo variavel = memoria.getSimbolo(nome);
                            variavel.setInicializado(true);
                        }
                        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
                        {
                            // Não faz nada
                        }
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
            if (i < parametrosEsperados.size())
            {
                boolean erroPassagem = false;

                NoDeclaracaoParametro parametroEsperado = parametrosEsperados.get(i);
                NoExpressao parametroPassado = parametrosPassados.get(i);

                if (parametroEsperado.getModoAcesso() == ModoAcesso.POR_REFERENCIA)
                {
                    if (!(parametroPassado instanceof NoReferenciaVariavel))
                    {
                        notificarErroSemantico(new ErroPassagemParametroInvalida(parametroPassado, parametroEsperado, funcao));
                        erroPassagem = true;
                    }
                    else
                    {
                        try
                        {
                            Simbolo simbolo = memoria.getSimbolo(((NoReferenciaVariavel) parametroPassado).getNome());

                            if (simbolo.constante())
                            {
                                notificarErroSemantico(new ErroPassagemParametroInvalida(parametroPassado, parametroEsperado, funcao));
                                erroPassagem = true;
                            }
                        }
                        catch(ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
                        {
                            excecaoSimboloNaoDeclarado.printStackTrace(System.out);
                        }
                    }
                }

                if (!erroPassagem)
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
        }
    }
    

    private Object analisarChamadaFuncaoBiblioteca(final NoChamadaFuncao chamadaFuncao)
    {
        final String escopo = chamadaFuncao.getEscopo();
        final String nome = chamadaFuncao.getNome();
        
        
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
                                notificarErroSemantico(new ErroSemantico(chamadaFuncao.getTrechoCodigoFonteNome())
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

            notificarErroSemantico(new ErroSemantico(chamadaFuncao.getTrechoCodigoFonteNome()) 
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
            notificarErroSemantico(new ErroSemantico(chamadaFuncao.getTrechoCodigoFonteNome())
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
