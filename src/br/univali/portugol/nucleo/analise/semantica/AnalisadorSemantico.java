package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ErroLeiaNecessitaReferencia;
import br.univali.portugol.nucleo.analise.semantica.avisos.*;
import br.univali.portugol.nucleo.analise.semantica.erros.*;
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
public final class AnalisadorSemantico
{
    private TabelaSimbolos tabelaSimbolosGlobal;
    private List<ObservadorAnaliseSemantica> observadores;

    public AnalisadorSemantico()
    {
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
            tabelaSimbolosGlobal = new TabelaSimbolos();
            analisarListaDeclaracoesGlobais(asa.getListaDeclaracoesGlobais());
        }
    }

    private void analisarListaDeclaracoesGlobais(List<NoDeclaracao> listaDeclaracoesGlobais)
    {
        if (listaDeclaracoesGlobais != null)
        {
            for (NoDeclaracao declaracao: listaDeclaracoesGlobais)
                analisarDeclaracaoGlobal(declaracao, tabelaSimbolosGlobal);

            for (Simbolo simbolo: tabelaSimbolosGlobal)
            {
                if (simbolo instanceof Funcao)
                {
                	tabelaSimbolosGlobal.empilharEscopo();
                    analisarBlocosFuncao((Funcao) simbolo, tabelaSimbolosGlobal);
                    tabelaSimbolosGlobal.desempilharEscopo();
                }
            }
        }
    }

    private void analisarDeclaracaoGlobal(NoDeclaracao declaracao, TabelaSimbolos tabelaSimbolos)
    {
        if (declaracao instanceof NoDeclaracaoVariavel)
            analisarDeclaracaoVariavel((NoDeclaracaoVariavel) declaracao, tabelaSimbolos);
        else

        if (declaracao instanceof NoDeclaracaoFuncao)
            analisarDeclaracaoFuncao((NoDeclaracaoFuncao) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoVetor)
            analisarDeclaracaoVetor((NoDeclaracaoVetor) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoMatriz)
            analisarDeclaracaoMatriz((NoDeclaracaoMatriz) declaracao, tabelaSimbolos);
    }

    private static final List<String> funcoesReservadas = getLista();
        
    
    private void analisarDeclaracaoVariavel(NoDeclaracaoVariavel declaracaoVariavel, TabelaSimbolos tabelaSimbolos)
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
        } else if (funcoesReservadas.contains(nome)){
            variavel.setRedeclarado(true);
            Funcao funcaoSistam = new Funcao(nome, tipoDados.VAZIO, Quantificador.VETOR, null, null);
            notificarErroSemantico(new ErroSimboloRedeclarado(variavel, funcaoSistam));
        
        }

        tabelaSimbolos.adicionar(variavel);

        if (declaracaoVariavel.getInicializacao() != null)
        {
            if (!(declaracaoVariavel.getInicializacao() instanceof NoVetor) && !(declaracaoVariavel.getInicializacao() instanceof NoMatriz))
            {
                NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
                NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
                referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
                NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);

                try { obterTipoDadoExpressao(operacao, tabelaSimbolos); }
                catch (ErroSemantico erro) { notificarErroSemantico(erro); }
                catch (Exception e) { e.printStackTrace(System.err); }
            }
            else
            {
                notificarErroSemantico(new ErroInicializacaoInvalida(declaracaoVariavel,declaracaoVariavel.getInicializacao(),declaracaoVariavel.getInicializacao().getTrechoCodigoFonte().getLinha()
                        , declaracaoVariavel.getInicializacao().getTrechoCodigoFonte().getColuna()));
            }
        }
    }

    private void analisarDeclaracaoFuncao(NoDeclaracaoFuncao declaracaoFuncao, TabelaSimbolos tabelaSimbolos)
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

    private void analisarListaBlocos(List<NoBloco> listaBlocos, TabelaSimbolos tabelaSimbolos)
    {
        if (listaBlocos != null)
        {
            for (NoBloco bloco: listaBlocos)
            {
                try { analisarBloco(bloco, tabelaSimbolos); }
                catch (ErroSemantico erro) { notificarErroSemantico(erro); }
            }
        }
    }

    private void analisarBlocosFuncao(Funcao funcao, TabelaSimbolos tabelaSimbolosFuncao)
    {
        List<NoDeclaracaoParametro> parametros = funcao.getParametros();

        for (NoDeclaracaoParametro parametro : parametros)
        {
            String nome = parametro.getNome();
            TipoDado tipoDado = parametro.getTipoDado();
            Quantificador quantificador = parametro.getQuantificador();
            Simbolo simbolo = null;

            if (quantificador == Quantificador.VALOR)
                simbolo = new Variavel(nome, tipoDado);

            else

            if (quantificador == Quantificador.VETOR)
                simbolo = new Vetor(nome, tipoDado, 0, new ArrayList<Object>());

            else

            if (quantificador == Quantificador.MATRIZ)
                simbolo = new Matriz(nome, tipoDado, 0, 0, new ArrayList<List<Object>>());

            if (tabelaSimbolosFuncao.contem(nome))
                notificarErroSemantico(new ErroParametroRedeclarado(parametro, funcao));

            tabelaSimbolosFuncao.adicionar(simbolo);
        }

        analisarListaBlocos(funcao.getBlocos(), tabelaSimbolosFuncao);
    }

    private void analisarBloco(NoBloco bloco, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ErroReferenciaInvalida
    {
        if (bloco instanceof NoPara)
            analisarBlocoPara((NoPara) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoDeclaracao)
            analisarDeclaracao((NoDeclaracao) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoSe)
            analisarBlocoSe((NoSe) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoEnquanto)
            analisarBlocoEnquanto((NoEnquanto) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoFacaEnquanto)
            analisarBlocoFacaEnquanto((NoFacaEnquanto) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoExpressao)
            analisarExpressao((NoExpressao) bloco, tabelaSimbolos);
        
        else
            
        if (bloco instanceof NoRetorne)
            analisarNoRetorne((NoRetorne) bloco, tabelaSimbolos);
            
    }

    private void analisarNoRetorne(NoRetorne noRetorne, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ErroReferenciaInvalida
    {
        NoExpressao expressao = noRetorne.getExpressao();
        
        if (expressao instanceof NoOperacao)
        {
            try { obterTipoDadoOperacao((NoOperacao) expressao, tabelaSimbolos); }
            catch (ExcecaoImpossivelDeterminarTipoDado ex) {}
        }
        
        else analisarExpressao(expressao, tabelaSimbolos);            
    }
    
    private void analisarExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ErroReferenciaInvalida
    {
        if (expressao instanceof NoOperacao)
        {
            NoOperacao operacao = (NoOperacao) expressao;
            
            if (operacao.getOperacao() == Operacao.ATRIBUICAO)
            {
                try { obterTipoDadoOperacao((NoOperacao) expressao, tabelaSimbolos); }
                catch (ExcecaoImpossivelDeterminarTipoDado ex) {}
            }
        }

        else

        if (expressao instanceof NoIncremento)
            analisarIncremento((NoIncremento) expressao);
        
        else
        	
        if (expressao instanceof NoReferencia)
            analisarReferencia((NoReferencia) expressao, tabelaSimbolos);
    }
    
    private void analisarReferencia(NoReferencia referencia, TabelaSimbolos tabelaSimbolos)
    {    	
    	String nome = referencia.getNome();
    	
    	if (referencia instanceof NoChamadaFuncao)
        {	
    		if (!funcoesReservadas.contains(nome))
                {
	    		if (tabelaSimbolos.contem((referencia.getNome())))
		        {
	    			Simbolo simbolo = tabelaSimbolos.obter(referencia.getNome()); 
                                if (simbolo instanceof Funcao) {
                                    Funcao funcao = (Funcao) simbolo;
                                    analisarChamadaFuncao((NoChamadaFuncao) referencia, funcao, tabelaSimbolos);
                                } else {
                                    notificarErroSemantico(new ErroSimboloNaoFuncao(referencia));
                                }
                        }
	        
	    		else notificarErroSemantico(new ErroSimboloNaoDeclarado((NoReferencia) referencia));
    		}
    		else
    		{
    			analisarChamadaFuncaoEspecial((NoChamadaFuncao) referencia, tabelaSimbolos);
    		}
        }
    	
    	else
    		
    	if (referencia instanceof NoReferenciaVariavel)
    	{
    		if (!tabelaSimbolos.contem(nome))
    			notificarErroSemantico(new ErroSimboloNaoDeclarado(referencia));
    	}
    }


    private void analisarDeclaracao(NoDeclaracao declaracao, TabelaSimbolos tabelaSimbolos)
    {
        if (declaracao instanceof NoDeclaracaoVariavel)
            analisarDeclaracaoVariavel((NoDeclaracaoVariavel) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoVetor)
            analisarDeclaracaoVetor((NoDeclaracaoVetor) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoMatriz)
            analisarDeclaracaoMatriz((NoDeclaracaoMatriz) declaracao, tabelaSimbolos);
    }

    private TipoDado obterTipoDadoExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ExcecaoImpossivelDeterminarTipoDado, ErroReferenciaInvalida
    {
        if (expressao instanceof NoInteiro)     return TipoDado.INTEIRO;
        if (expressao instanceof NoReal)        return TipoDado.REAL;
        if (expressao instanceof NoCaracter)    return TipoDado.CARACTER;
        if (expressao instanceof NoCadeia)      return TipoDado.CADEIA;
        if (expressao instanceof NoLogico)      return TipoDado.LOGICO;

        if (expressao instanceof NoReferencia)  return obterTipoDadoReferencia  ((NoReferencia) expressao, tabelaSimbolos);
        if (expressao instanceof NoOperacao)    return obterTipoDadoOperacao    ((NoOperacao)   expressao, tabelaSimbolos);

        throw new ExcecaoImpossivelDeterminarTipoDado();
    }

    private void verificaErroReferencia(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ErroReferenciaInvalida
    {
        if (expressao instanceof NoReferencia)
        {
            Simbolo simbolo = obterSimbolo(((NoReferencia) expressao).getNome(), tabelaSimbolos);
            
            if (expressao instanceof NoReferenciaVariavel && !(simbolo instanceof Variavel))
            {
                throw new ErroReferenciaInvalida(expressao, simbolo,expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna());
            }
            
            if (expressao instanceof NoReferenciaVetor && !(simbolo instanceof Vetor))
            {
                throw new ErroReferenciaInvalida(expressao, simbolo,expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna());
            }
            
            if (expressao instanceof NoReferenciaMatriz && !(simbolo instanceof Matriz))
            {
                throw new ErroReferenciaInvalida(expressao, simbolo,expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna());
            }
        }
    }
    
    private TipoDado obterTipoDadoOperacao(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ExcecaoImpossivelDeterminarTipoDado, ErroReferenciaInvalida
    {
        boolean erro = false;

        NoExpressao operandoEsquerdo = operacao.getOperandoEsquerdo();
        NoExpressao operandoDireito = operacao.getOperandoDireito();

        TipoDado tipoDadoOperandoEsquerdo = TipoDado.VAZIO;
        TipoDado tipoDadoOperandoDireito = TipoDado.VAZIO;

        try { tipoDadoOperandoEsquerdo = obterTipoDadoExpressao(operandoEsquerdo, tabelaSimbolos); }
        catch (ErroTiposIncompativeis e) { notificarErroSemantico(e); erro = true; }
        catch (ExcecaoImpossivelDeterminarTipoDado e) { erro = true; }

        try { tipoDadoOperandoDireito = obterTipoDadoExpressao(operandoDireito, tabelaSimbolos); }
        catch (ErroTiposIncompativeis e) { notificarErroSemantico(e); erro = true; }
        catch (ExcecaoImpossivelDeterminarTipoDado e) { erro = true; }
        
        if (!erro)
        {
            verificaErroReferencia(operandoEsquerdo, tabelaSimbolos);
            verificaErroReferencia(operandoDireito, tabelaSimbolos);
       
            switch (operacao.getOperacao())
            {
                case ATRIBUICAO:                    return obterTipoDadoOperacaoAtribuicao                  (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case DIFERENCA:                     return obterTipoDadoOperacaoDiferenca                   (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case DIVISAO:                       return obterTipoDadoOperacaoDivisao                     (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case DIVISAO_ACUMULATIVA:           return obterTipoDadoOperacaoDivisaoAtribuitiva          (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case E:                             return obterTipoDadoOperacaoE                           (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case IGUALDADE:                     return obterTipoDadoOperacaoIgualdade                   (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MAIOR:                         return obterTipoDadoOperacaoMaior                       (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MAIOR_IGUAL:                   return obterTipoDadoOperacaoMaiorIgual                  (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MENOR:                         return obterTipoDadoOperacaoMenor                       (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MENOR_IGUAL:                   return obterTipoDadoOperacaoMenorIgual                  (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MODULO:                        return obterTipoDadoOperacaoModulo                      (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MODULO_ACUMULATIVO:            return obterTipoDadoOperacaoModuloAtribuitivo           (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MULTIPLICACAO:                 return obterTipoDadoOperacaoMultiplicacao               (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case MULTIPLICACAO_ACUMULATIVA:     return obterTipoDadoOperacaoMultiplicacaoAtribuitiva    (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case OU:                            return obterTipoDadoOperacaoOu                          (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case SOMA:                          return obterTipoDadoOperacaoSoma                        (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case SOMA_ACUMULATIVA:              return obterTipoDadoOperacaoSomaAtribuitiva             (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case SUBTRACAO:                     return obterTipoDadoOperacaoSubtracao                   (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                case SUBTRACAO_ACUMULATIVA:         return obterTipoDadoOperacaoSubtracaoAtribuitiva        (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
            }
        }

        throw new ExcecaoImpossivelDeterminarTipoDado();
    }
    
     private TipoDado obterTipoDadoOperacaoAtribuicao(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.CARACTER)
        {
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.CARACTER;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL)
            {
                notificarAviso(new AvisoValorExpressaoSeraArredondado(operacao.getOperandoDireito()));
                return TipoDado.INTEIRO;
            }
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoDiferenca(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA)
        {
            if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.CARACTER)
        {
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoDivisao(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoDivisaoAtribuitiva(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL)
            {
                notificarAviso(new AvisoValorExpressaoSeraArredondado(operacao.getOperandoDireito()));
                return TipoDado.INTEIRO;
            }
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoE(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoIgualdade(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.CARACTER)
        {
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return tipoDadoOperandoDireito.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMaior(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

                
        else
        
        if ((tipoDadoOperandoEsquerdo == TipoDado.CARACTER 
                && tipoDadoOperandoDireito == TipoDado.CARACTER)
            ||    
             (tipoDadoOperandoEsquerdo == TipoDado.CADEIA 
                && tipoDadoOperandoDireito == TipoDado.CADEIA))
        {
            return TipoDado.LOGICO;
        }
        
        
        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMaiorIgual(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }
        
                
        else
        
        if ((tipoDadoOperandoEsquerdo == TipoDado.CARACTER 
                && tipoDadoOperandoDireito == TipoDado.CARACTER)
            ||    
             (tipoDadoOperandoEsquerdo == TipoDado.CADEIA 
                && tipoDadoOperandoDireito == TipoDado.CADEIA))
        {
            return TipoDado.LOGICO;
        }
        

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMenor(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }
        
        else
        
        if ((tipoDadoOperandoEsquerdo == TipoDado.CARACTER 
                && tipoDadoOperandoDireito == TipoDado.CARACTER)
            ||    
             (tipoDadoOperandoEsquerdo == TipoDado.CADEIA 
                && tipoDadoOperandoDireito == TipoDado.CADEIA))
        {
            return TipoDado.LOGICO;
        }
        

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMenorIgual(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.LOGICO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.LOGICO;
        }
         
        else
        
        if ((tipoDadoOperandoEsquerdo == TipoDado.CARACTER 
                && tipoDadoOperandoDireito == TipoDado.CARACTER)
            ||    
             (tipoDadoOperandoEsquerdo == TipoDado.CADEIA 
                && tipoDadoOperandoDireito == TipoDado.CADEIA))
        {
            return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoModulo(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoModuloAtribuitivo(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMultiplicacao(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoMultiplicacaoAtribuitiva(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL)
            {
                notificarAviso(new AvisoValorExpressaoSeraArredondado(operacao.getOperandoDireito()));
                return TipoDado.INTEIRO;
            }
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoOu(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.LOGICO;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoSoma(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.CADEIA;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.CARACTER)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.CADEIA;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.LOGICO)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoSomaAtribuitiva(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.CADEIA)
        {
            if (tipoDadoOperandoDireito == TipoDado.CADEIA) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.CARACTER) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.CADEIA;
            if (tipoDadoOperandoDireito == TipoDado.LOGICO) return TipoDado.CADEIA;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL)
            {
                notificarAviso(new AvisoValorExpressaoSeraArredondado(operacao.getOperandoDireito()));
                return TipoDado.INTEIRO;
            }
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoSubtracao(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoOperacaoSubtracaoAtribuitiva(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ErroTiposIncompativeis
    {
        if (tipoDadoOperandoEsquerdo == TipoDado.INTEIRO)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.INTEIRO;
            if (tipoDadoOperandoDireito == TipoDado.REAL)
            {
                notificarAviso(new AvisoValorExpressaoSeraArredondado(operacao.getOperandoDireito()));
                return TipoDado.INTEIRO;
            }
        }

        else

        if (tipoDadoOperandoEsquerdo == TipoDado.REAL)
        {
            if (tipoDadoOperandoDireito == TipoDado.INTEIRO) return TipoDado.REAL;
            if (tipoDadoOperandoDireito == TipoDado.REAL) return TipoDado.REAL;
        }

        throw new ErroTiposIncompativeis(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
    }

    private TipoDado obterTipoDadoReferencia(NoReferencia referencia, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        String nome = referencia.getNome();
        Simbolo simbolo = obterSimbolo(nome, tabelaSimbolos);

        if (referencia instanceof NoChamadaFuncao)
        {
            if (funcoesReservadas.contains(nome))
                return TipoDado.VAZIO;
        }
        
        if (simbolo == null)
        {
            notificarErroSemantico(new ErroSimboloNaoDeclarado(referencia));
            throw new ExcecaoImpossivelDeterminarTipoDado();
        }

        else

        if (simbolo.redeclarado())
            throw new ExcecaoImpossivelDeterminarTipoDado();

        if (referencia instanceof NoChamadaFuncao)
            analisarChamadaFuncao((NoChamadaFuncao) referencia, (Funcao) simbolo, tabelaSimbolos);

        return simbolo.getTipoDado();
    }

    private Simbolo obterSimbolo(String nome, TabelaSimbolos tabelaSimbolos)
    {
            Simbolo simbolo = null;
            
            simbolo = (simbolo == null)? tabelaSimbolos.obter(nome) : simbolo;
            simbolo = (simbolo == null)? tabelaSimbolosGlobal.obter(nome) : simbolo;

            return simbolo;
    }

    private void analisarBlocoPara(NoPara para, TabelaSimbolos tabelaSimbolos)
    {
        tabelaSimbolos.empilharEscopo();

        try { analisarBloco(para.getInicializacao(), tabelaSimbolos);}
        catch(ErroSemantico erro) { notificarErroSemantico(erro); }

        try { analisarBloco(para.getCondicao(), tabelaSimbolos); }
        catch(ErroSemantico erro) { notificarErroSemantico(erro); }

        try { analisarBloco(para.getIncremento(), tabelaSimbolos); }
        catch(ErroSemantico erro) { notificarErroSemantico(erro); }

        analisarListaBlocos(para.getBlocos(), tabelaSimbolos);

        tabelaSimbolos.desempilharEscopo();
    }
    
    private void analisarChamadaFuncaoEspecial(NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos)
    {
    	List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
    	
        if (parametrosPassados != null)
        {        
            for (NoExpressao expressao: parametrosPassados)
            {
                    
                    if ("leia".equals(chamadaFuncao.getNome()))
                    {
                        if (!(expressao instanceof NoReferenciaVariavel 
                                || expressao instanceof NoReferenciaVetor 
                                || expressao instanceof NoReferenciaMatriz))
                            notificarErroSemantico(new ErroLeiaNecessitaReferencia(chamadaFuncao,expressao));
                    }
                
                    try
                    {
                        analisarExpressao(expressao, tabelaSimbolos);
                    }
                    catch (ErroSemantico erro) 
                    {
                         notificarErroSemantico(erro);
                    }
            }
        }
    }

    private void analisarChamadaFuncao(NoChamadaFuncao chamadaFuncao, Funcao funcao, TabelaSimbolos tabelaSimbolos)
    {
        int cont = 0;
        List<NoDeclaracaoParametro> parametrosEsperados = funcao.getParametros();
        List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
        
        if (parametrosPassados == null &&  parametrosEsperados.size() > 0){
            cont = 0;
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(0, parametrosEsperados.size(), funcao, chamadaFuncao));
        }
        
        else if (parametrosPassados != null){
            
            if (  parametrosEsperados.size() > parametrosPassados.size())
            {
                cont = chamadaFuncao.getParametros().size();
                notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
            }

            else 

            if (parametrosPassados.size() > funcao.getParametros().size())
            {
                cont = chamadaFuncao.getParametros().size();
                notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
            }
            else cont = parametrosPassados.size();
        }
        for (int i = 0; i < cont; i++)
        {
            TipoDado tipoDadoParametroEsperado = TipoDado.VAZIO;
            TipoDado tipoDadoParametroPassado = TipoDado.VAZIO;

            try { tipoDadoParametroEsperado = parametrosEsperados.get(i).getTipoDado(); }
            catch (Exception ex) {}

            try { tipoDadoParametroPassado = obterTipoDadoExpressao(parametrosPassados.get(i), tabelaSimbolos); }
            catch (Exception ex) {}

            if (tipoDadoParametroEsperado != TipoDado.VAZIO && tipoDadoParametroPassado != TipoDado.VAZIO)
            {
                if (tipoDadoParametroEsperado != tipoDadoParametroPassado){
                    if (!(tipoDadoParametroPassado == TipoDado.INTEIRO && tipoDadoParametroEsperado == TipoDado.REAL))
                        notificarErroSemantico(new ErroTipoParametroIncompativel(tipoDadoParametroEsperado, tipoDadoParametroPassado, parametrosEsperados.get(i), parametrosPassados.get(i), funcao));
                }
            }
        }
    }

    private void analisarBlocoSe(NoSe blocoSe, TabelaSimbolos tabelaSimbolos)
    {
        try 
        {
            NoExpressao condicao = blocoSe.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(blocoSe, condicao));
        }
        catch (ErroSemantico erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}

        tabelaSimbolos.empilharEscopo();
        analisarListaBlocos(blocoSe.getBlocosVerdadeiros(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();

        tabelaSimbolos.empilharEscopo();
        analisarListaBlocos(blocoSe.getBlocosFalsos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();        
    }

    private void analisarBlocoEnquanto(NoEnquanto enquanto, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            NoExpressao condicao = enquanto.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(enquanto, condicao));
        }
        catch (ErroSemantico erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}

        tabelaSimbolos.empilharEscopo();
        analisarListaBlocos(enquanto.getBlocos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();
    }

    private void analisarBlocoFacaEnquanto(NoFacaEnquanto facaEnquanto, TabelaSimbolos tabelaSimbolos)
    {
        tabelaSimbolos.empilharEscopo();
        analisarListaBlocos(facaEnquanto.getBlocos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();

        try
        {
            NoExpressao condicao = facaEnquanto.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(facaEnquanto, condicao));
        }
        catch (ErroSemantico erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}
    }

    private void analisarIncremento(NoIncremento incremento)
    {
        NoExpressao expressao = incremento.getExpressao();

        if (!(expressao instanceof NoReferenciaVariavel) && !(expressao instanceof NoReferenciaVetor) && !(expressao instanceof NoReferenciaMatriz))
            notificarErroSemantico(new ErroOperacaoComExpressaoConstante(incremento, expressao));

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

    private void analisarDeclaracaoVetor(NoDeclaracaoVetor declaracaoVetor, TabelaSimbolos tabelaSimbolos)
    {
        
        String nome = declaracaoVetor.getNome();
        TipoDado tipoDado = declaracaoVetor.getTipoDado();

        try
        {
            TipoDado tipoDadoTamanho = obterTipoDadoExpressao(declaracaoVetor.getTamanho(), tabelaSimbolos);

            if (!(tipoDadoTamanho == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoTamanho));
        }
        catch (ErroSemantico e){ notificarErroSemantico(e); }
        catch (ExcecaoImpossivelDeterminarTipoDado e2){  }
            
        Vetor vetor = new Vetor(nome, tipoDado, 0);
        
        if (tabelaSimbolos.contem(nome))
        {
            vetor.setRedeclarado(true);
            notificarErroSemantico(new ErroSimboloRedeclarado(vetor, tabelaSimbolos.obter(nome)));
        }

        tabelaSimbolos.adicionar(vetor);

        if (declaracaoVetor.getInicializacao() != null)
        {
            NoExpressao inicializacao = declaracaoVetor.getInicializacao();
            try {
                
                if (inicializacao instanceof NoReferenciaVariavel) {
                    NoReferenciaVariavel nrv = (NoReferenciaVariavel) inicializacao;
                    Simbolo simbolo = obterSimbolo(nrv.getNome(), tabelaSimbolos);
                    if (!(simbolo instanceof Vetor))
                    {
                        throw new ErroInicializacaoInvalida(simbolo,declaracaoVetor,inicializacao,inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
                    }
                } 
                else if (!(inicializacao instanceof NoVetor))
                {
                    throw new ErroInicializacaoInvalida(declaracaoVetor,inicializacao,inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
                }
            
                TipoDado tipoDadoOperandoEsquerdo = vetor.getTipoDado();
                TipoDado tipoDadoOperandoDireito = null;

                try { tipoDadoOperandoDireito = obterTipoDadoExpressao(inicializacao, tabelaSimbolos); }
                catch (ExcecaoImpossivelDeterminarTipoDado excecao) {}

                if (tipoDadoOperandoDireito != null)
                {
                    obterTipoDadoOperacaoAtribuicao(null, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                }
        
            } catch (ErroSemantico erro) {
                notificarErroSemantico(erro);
            } 
        }
    }

    private void analisarDeclaracaoMatriz(NoDeclaracaoMatriz declaracaoMatriz, TabelaSimbolos tabelaSimbolos) 
    {
        String nome = declaracaoMatriz.getNome();
        TipoDado tipoDado = declaracaoMatriz.getTipoDado();

        try
        {
            TipoDado tipoDadoLinha = obterTipoDadoExpressao(declaracaoMatriz.getNumeroLinhas(), tabelaSimbolos);

            if (!(tipoDadoLinha == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoLinha));
        }
        catch (ErroSemantico e){ notificarErroSemantico(e); }
        catch (ExcecaoImpossivelDeterminarTipoDado e2){  }
        
        try
        {
            TipoDado tipoDadoColuna = obterTipoDadoExpressao(declaracaoMatriz.getNumeroColunas(), tabelaSimbolos);

            if (!(tipoDadoColuna == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoColuna));
        }
        catch (ErroSemantico e){ notificarErroSemantico(e); }
        catch (ExcecaoImpossivelDeterminarTipoDado e2){  }
        
        Matriz matriz = new Matriz(nome, tipoDado, 0, 0);
        
        if (tabelaSimbolos.contem(nome))
        {
            matriz.setRedeclarado(true);
            notificarErroSemantico(new ErroSimboloRedeclarado(matriz, tabelaSimbolos.obter(nome)));
        }

        tabelaSimbolos.adicionar(matriz);

        if (declaracaoMatriz.getInicializacao() != null)
        {
            NoExpressao inicializacao = declaracaoMatriz.getInicializacao();
            try {
                if (inicializacao instanceof NoReferenciaVariavel){
                    NoReferenciaVariavel nrv = (NoReferenciaVariavel) inicializacao;
                    Simbolo simbolo = obterSimbolo(nrv.getNome(), tabelaSimbolos);
                    if (!(simbolo instanceof Matriz))
                    {
                        throw new ErroInicializacaoInvalida(simbolo,declaracaoMatriz,inicializacao,inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
                    }
                }
                else if (!(inicializacao instanceof NoMatriz))
                {
                    throw new ErroInicializacaoInvalida(declaracaoMatriz,inicializacao,inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
                }
                
                TipoDado tipoDadoOperandoEsquerdo = matriz.getTipoDado();
                TipoDado tipoDadoOperandoDireito = null;

                try { tipoDadoOperandoDireito = obterTipoDadoExpressao(inicializacao, tabelaSimbolos); }
                catch (ExcecaoImpossivelDeterminarTipoDado excecao) {}

                if (tipoDadoOperandoDireito != null)
                {
                    obterTipoDadoOperacaoAtribuicao(null, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                }
            } catch (ErroSemantico erro)
            {
                notificarErroSemantico(erro);
            }          
        }        
    }

    private static List<String> getLista()
    {
        List<String> funcoes = new ArrayList<String>();
        
        funcoes.add("leia");
        funcoes.add("escreva");
        
        return funcoes;
    }
}
