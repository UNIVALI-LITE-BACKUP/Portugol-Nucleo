package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ErroExpressaoTipoLogicoEsperada;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroInicializacaoInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroParametroRedeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroReferenciaInvalida;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSemanticoNaoTratado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloNaoDeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroSimboloRedeclarado;
import br.univali.portugol.nucleo.analise.semantica.erros.ErroTiposIncompativeis;
import br.univali.portugol.nucleo.analise.semantica.erros.ExcecaoImpossivelDeterminarTipoDado;
import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.execucao.Interpretador;
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
    
    private static final List<String> funcoesReservadas = getLista();
    
    private TabelaCompatibilidadeTipos compatibilidadeTipos = TabelaCompatibilidadeTiposPortugol.INSTANCE;
    private ArvoreSintaticaAbstrata asa;
    
    private Funcao funcaoAtual;
    
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
                Funcao funcaoSistam = new Funcao(nome, tipoDados.VAZIO, Quantificador.VETOR, null, null);
                notificarErroSemantico(new ErroSimboloRedeclarado(variavel, funcaoSistam));
            }

            tabelaSimbolos.adicionar(variavel);
    
            if (declaracaoVariavel.getInicializacao() != null)
            {
                // Posteriormente restringir na gramática para não permitir atribuir vetor ou matriz a uma variável comum
                
                if (!(declaracaoVariavel.getInicializacao() instanceof NoVetor) && !(declaracaoVariavel.getInicializacao() instanceof NoMatriz))
                {
                    NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
                    referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacaoAtribuicao(referencia, inicializacao);

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
        TipoDado tipoCondicao = (TipoDado) noEnquanto.getCondicao().aceitar(this);
        if (tipoCondicao != TipoDado.LOGICO) {
            notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(noEnquanto, noEnquanto.getCondicao()));
        }
        
        analisarListaBlocos(noEnquanto.getBlocos());
        
        return null;
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
            notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(noPara, noPara.getCondicao()));
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
        TipoDado tipoDadoRetorno = TipoDado.VAZIO;
        if (noRetorne.getExpressao() != null) 
             tipoDadoRetorno = (TipoDado) noRetorne.getExpressao().aceitar(this);
        
        if (funcaoAtual.getTipoDado() != tipoDadoRetorno){
            notificarErroSemantico(new ErroSemantico(0, 0) {

                @Override
                protected String construirMensagem()
                {
                   return "Tipo incompativel no retorno da funcao";
                }

            });
        }
        
        return null;
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        TipoDado condicao = (TipoDado) noSe.getCondicao().aceitar(this);
        
        if (condicao != TipoDado.LOGICO)
            notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(noSe, noSe.getCondicao()));
        
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
                                    
                TipoDado tipo = (TipoDado) ((NoExpressao) valores.get(i)).aceitar(this);

                if (tipo != tipoDadoVetor) {
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
            simbolo = new Variavel(nome, tipoDado);

        else

        if (quantificador == Quantificador.VETOR)
            simbolo = new Vetor(nome, tipoDado, 0, new ArrayList<Object>());

        else

        if (quantificador == Quantificador.MATRIZ)
            simbolo = new Matriz(nome, tipoDado, 0, 0, new ArrayList<List<Object>>());

        if (tabelaSimbolos.contem(nome))
            notificarErroSemantico(new ErroParametroRedeclarado(noDeclaracaoParametro, funcaoAtual));

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
    
    private TipoDado recuperaTipoNoOperacao(NoOperacao noOperacao) throws ExcecaoVisitaASA{
        TipoDado opEsq = (TipoDado) noOperacao.getOperandoEsquerdo().aceitar(this);
        TipoDado opDir = (TipoDado) noOperacao.getOperandoDireito().aceitar(this);
        TipoDado tipo = TipoDado.VAZIO;
        try
        {
            tipo = compatibilidadeTipos.getRetorno(noOperacao.getClass(), opEsq, opDir);
        }
        catch (ExcecaoImpossivelDeterminarTipoDado ex)
        {
            if (opEsq == TipoDado.VAZIO && opDir == TipoDado.VAZIO ) {
                throw new ExcecaoVisitaASA(ex, asa, noOperacao);
            }
            notificarErroSemantico(new ErroTiposIncompativeis(noOperacao, opEsq, opDir));
        }
        return tipo;
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
            noBloco.aceitar(this);
        }
        tabelaSimbolos.desempilharEscopo();        
    } 
}
