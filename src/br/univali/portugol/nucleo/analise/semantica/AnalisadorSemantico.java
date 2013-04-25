package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.avisos.AvisoTamanhoReferenciaInicializacao;
import br.univali.portugol.nucleo.analise.semantica.avisos.AvisoInicializacaoVetorMaisValoresTamanho;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Funcao funcaoAtual;

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
                    funcaoAtual = (Funcao) simbolo;
                    analisarBlocosFuncao((Funcao) simbolo, tabelaSimbolosGlobal);
                    tabelaSimbolosGlobal.desempilharEscopo();
                }
            }
        }
    }

    private void analisarBlocoEscolha(NoEscolha escolha, TabelaSimbolos tabelaSimbolos)
    {
        TipoDado tipoDadoEscolha = TipoDado.VAZIO;
        try
        {
            NoExpressao expressao = escolha.getExpressao();            
            try
            {            
                if (((tipoDadoEscolha = obterTipoDadoExpressao(expressao, tabelaSimbolos)) != TipoDado.INTEIRO)
                        && ((tipoDadoEscolha = obterTipoDadoExpressao(expressao, tabelaSimbolos)) != TipoDado.CARACTER))
                    throw new ErroTipoEscolha(escolha, tipoDadoEscolha);
            }
            catch (ExcecaoImpossivelDeterminarTipoDado ex) { }
        }
        catch (ErroSemantico erroSemantico)
        {
            notificarErroSemantico(erroSemantico);
        }
        
        List<NoCaso> casos = escolha.getCasos();
        
        for (NoCaso caso : casos)
        {
            NoExpressao expressao = caso.getExpressao();
            TipoDado tipoDado = TipoDado.VAZIO;
            
            if (expressao != null)
            {
                try
                {            
                    if ((tipoDado = obterTipoDadoExpressao(expressao, tabelaSimbolos)) != tipoDadoEscolha)
                        throw new ErroTiposIncompativeis(expressao.getTrechoCodigoFonte().getLinha(),
                                expressao.getTrechoCodigoFonte().getColuna(),caso, tipoDadoEscolha, tipoDado);
                }
                catch (ExcecaoImpossivelDeterminarTipoDado ex) { }
                catch (ErroSemantico ex) 
                {
                    notificarErroSemantico(ex);
                }
            }
            
            if (caso.getBlocos() != null)
            {
                tabelaSimbolos.empilharEscopo();
                
                for (NoBloco bloco : caso.getBlocos())
                {
                    analisarBloco(bloco, tabelaSimbolos);
                }
                
                tabelaSimbolos.desempilharEscopo();
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

                analisarBloco(operacao, tabelaSimbolos);
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
                analisarBloco(bloco, tabelaSimbolos);
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
    
   /* 
    private TipoDado getRetornoFuncao(Funcao funcao)
    {
        if (funcao.getBlocos() != null)
        {
            
        }
    }*/

    private void analisarBloco(NoBloco bloco, TabelaSimbolos tabelaSimbolos)
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
        
        else
            
        if (bloco instanceof NoEscolha)
            analisarBlocoEscolha((NoEscolha) bloco, tabelaSimbolos);
            
    }

    private void analisarNoRetorne(NoRetorne noRetorne, TabelaSimbolos tabelaSimbolos)
    {
        TipoDado tipoRetornado = null;
        int linha = 0;
        int coluna = 0;
        
        if (noRetorne.getExpressao() != null)
        {
            TrechoCodigoFonte trecho = noRetorne.getExpressao().getTrechoCodigoFonte();
            linha = trecho.getLinha();
            coluna = trecho.getColuna();
            
            try { tipoRetornado = obterTipoDadoExpressao(noRetorne.getExpressao(), tabelaSimbolos); }
            catch (ExcecaoImpossivelDeterminarTipoDado ex) { }
        }
        else
        {
            tipoRetornado = TipoDado.VAZIO;
        }

        if (tipoRetornado != funcaoAtual.getTipoDado())
        {
            final TipoDado tipo = tipoRetornado;
            final TipoDado tipoFuncao = funcaoAtual.getTipoDado();
            final String nomeFuncao = funcaoAtual.getNome();
            
            notificarErroSemantico(new ErroSemantico(linha, coluna)
            {
                @Override
                protected String construirMensagem()
                {
                    return String.format("Tipos incompatíveis! O retorno da função \"%s\" é do tipo \"%s\", mas foi retornada uma expressão do tipo \"%s\"", nomeFuncao, tipoFuncao, tipo);
                }
            });
        }
    }
    
    private void analisarExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos)
    {/*
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
        {
            try { analisarIncremento((NoIncremento) expressao, tabelaSimbolos); }
            catch (ExcecaoImpossivelDeterminarTipoDado ex) { ex.printStackTrace(System.out); }
        }
        else
        	
        if (expressao instanceof NoReferencia)
            analisarReferencia((NoReferencia) expressao, tabelaSimbolos);*/
        try
        {
            obterTipoDadoExpressao(expressao, tabelaSimbolos);
        }
        catch (ExcecaoImpossivelDeterminarTipoDado ex)
        {
            
        }
    }
    
    private void analisarReferencia(NoReferencia referencia, TabelaSimbolos tabelaSimbolos)
    {    	
    	
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

    private TipoDado obterTipoDadoExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        if (expressao instanceof NoInteiro)     return TipoDado.INTEIRO;
        if (expressao instanceof NoReal)        return TipoDado.REAL;
        if (expressao instanceof NoCaracter)    return TipoDado.CARACTER;
        if (expressao instanceof NoCadeia)      return TipoDado.CADEIA;
        if (expressao instanceof NoLogico)      return TipoDado.LOGICO;

        if (expressao instanceof NoReferencia)  return obterTipoDadoReferencia  ((NoReferencia) expressao, tabelaSimbolos);
        if (expressao instanceof NoOperacao)    return obterTipoDadoOperacao    ((NoOperacao)   expressao, tabelaSimbolos);

        if (expressao instanceof NoVetor)       return obterTipoDadoVetor(((NoVetor) expressao), tabelaSimbolos);
        if (expressao instanceof NoMatriz)      return obterTipoDadoMatriz(((NoMatriz) expressao),tabelaSimbolos);
        if (expressao instanceof NoMenosUnario) return obterTipoDadoExpressao(((NoMenosUnario)expressao).getExpressao(), tabelaSimbolos);
        
        if (expressao instanceof NoIncremento) return obterTipoDadoIncremento((NoIncremento) expressao, tabelaSimbolos);
        
        notificarErroSemantico(new ErroSemantico(expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna())
        {
            @Override
            protected String construirMensagem()
            {
                return "Não foi possível identificar a expressão";
            }
        });
        throw new ExcecaoImpossivelDeterminarTipoDado();
    }

    private void verificaErroReferencia(NoExpressao expressao, TabelaSimbolos tabelaSimbolos)
    {
        if (expressao instanceof NoReferencia)
        {
            Simbolo simbolo = obterSimbolo(((NoReferencia) expressao).getNome(), tabelaSimbolos);
            
            if (expressao instanceof NoReferenciaVariavel && !(simbolo instanceof Variavel))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(expressao, simbolo));
            }
            
            if (expressao instanceof NoReferenciaVetor && !(simbolo instanceof Vetor))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(expressao, simbolo));
            }
            
            if (expressao instanceof NoReferenciaMatriz && !(simbolo instanceof Matriz))
            {
                notificarErroSemantico(new ErroReferenciaInvalida(expressao, simbolo));
            }
        }
    }
    
    private TipoDado obterTipoDadoOperacao(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        NoExpressao operandoEsquerdo = operacao.getOperandoEsquerdo();
        NoExpressao operandoDireito = operacao.getOperandoDireito();

        TipoDado tipoDadoOperandoEsquerdo = null;
        TipoDado tipoDadoOperandoDireito = null;

        try { tipoDadoOperandoEsquerdo = obterTipoDadoExpressao(operandoEsquerdo, tabelaSimbolos); }
        catch (ExcecaoImpossivelDeterminarTipoDado e) {  }

        try { tipoDadoOperandoDireito = obterTipoDadoExpressao(operandoDireito, tabelaSimbolos); }
        catch (ExcecaoImpossivelDeterminarTipoDado e) {  }
        
        if (tipoDadoOperandoEsquerdo != null && tipoDadoOperandoDireito != null)
        {
            verificaErroReferencia(operandoEsquerdo, tabelaSimbolos);
            verificaErroReferencia(operandoDireito, tabelaSimbolos);
       
            try
            {
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
            catch (ErroTiposIncompativeis e)
            {
                notificarErroSemantico(e);
                
                throw new ExcecaoImpossivelDeterminarTipoDado();
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
           	
    	if (!(referencia instanceof NoChamadaFuncao))
        {    	
            Simbolo simbolo = tabelaSimbolos.obter(nome);
            
            if (simbolo != null)
            {
                verificaErroReferencia(referencia, tabelaSimbolos);
                
                return simbolo.getTipoDado();
            }
            else
            {
                notificarErroSemantico(new ErroSimboloNaoDeclarado(referencia));
                
                throw new ExcecaoImpossivelDeterminarTipoDado();
            }
        }
        else
        {	
            if (!funcoesReservadas.contains(nome))
            {
                if (tabelaSimbolos.contem((nome)))
                {
                    Simbolo simbolo = tabelaSimbolos.obter(nome);

                    if (simbolo instanceof Funcao) 
                    {
                        analisarChamadaFuncao((NoChamadaFuncao) referencia, (Funcao) simbolo, tabelaSimbolos);
                    }
                    else 
                    {
                        notificarErroSemantico(new ErroReferenciaInvalida(referencia, simbolo));
                    }
                    
                    return simbolo.getTipoDado();
                }
                else 
                {
                    notificarErroSemantico(new ErroSimboloNaoDeclarado((NoReferencia) referencia));
                    
                    throw new ExcecaoImpossivelDeterminarTipoDado();
                }
            }
            else
            {
                analisarChamadaFuncaoEspecial((NoChamadaFuncao) referencia, tabelaSimbolos);
                return TipoDado.VAZIO;
            }
        } 
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

        analisarBloco(para.getInicializacao(), tabelaSimbolos);
                
        try
        {
            if (obterTipoDadoExpressao(para.getCondicao(), tabelaSimbolos) != TipoDado.LOGICO)
            {
                notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(para, para.getCondicao()));
            }        
        }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {  }

        analisarBloco(para.getIncremento(), tabelaSimbolos);

        analisarListaBlocos(para.getBlocos(), tabelaSimbolos);

        tabelaSimbolos.desempilharEscopo();
    }
    
    private void analisarChamadaFuncaoEspecial(NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos)
    {
    	List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
    	
        if (parametrosPassados == null || parametrosPassados.isEmpty())
        {
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(0, chamadaFuncao.getNome().equals("leia")? -2 : -1, null, chamadaFuncao));
        }
        else
        {        
            for (NoExpressao expressao: parametrosPassados)
            {
                analisarExpressao(expressao, tabelaSimbolos);

                if (chamadaFuncao.getNome().equals("leia"))
                {
                    if (!(expressao instanceof NoReferencia) || (expressao instanceof NoChamadaFuncao))
                    {
                        notificarErroSemantico(new ErroLeiaNecessitaReferencia(chamadaFuncao,expressao));
                    } 
                }                
            }
        }
    }

    private void analisarChamadaFuncao(NoChamadaFuncao chamadaFuncao, Funcao funcao, TabelaSimbolos tabelaSimbolos)
    {
        int cont = 0;
        List<NoDeclaracaoParametro> parametrosEsperados = funcao.getParametros();
        List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
        
        if ((parametrosPassados == null || parametrosPassados.isEmpty()) && parametrosEsperados.size() > 0)
        {
            cont = 0;
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(0, parametrosEsperados.size(), funcao, chamadaFuncao));
        }
        
        else if ((parametrosPassados != null && !parametrosPassados.isEmpty()))
        {            
            if (  parametrosEsperados.size() > parametrosPassados.size())
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

            try { tipoDadoParametroPassado = obterTipoDadoExpressao(parametrosPassados.get(i), tabelaSimbolos); }
            catch (ExcecaoImpossivelDeterminarTipoDado ex) { }

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

    private void analisarBlocoSe(NoSe blocoSe, TabelaSimbolos tabelaSimbolos)
    {
        try 
        {
            NoExpressao condicao = blocoSe.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) throw new ErroExpressaoTipoLogicoEsperada(blocoSe, condicao);
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
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}
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
            if (declaracaoVetor.getTamanho() != null)
            {
                TipoDado tipoDadoTamanho = obterTipoDadoExpressao(declaracaoVetor.getTamanho(), tabelaSimbolos);

                if (!(tipoDadoTamanho == TipoDado.INTEIRO))
                    notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoTamanho));
            }
        }
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
                
                if (!(inicializacao instanceof NoVetor))
                {
                    throw new ErroInicializacaoInvalida(declaracaoVetor,inicializacao,inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
                } else {
                    NoVetor valores = (NoVetor) inicializacao;
                    if (declaracaoVetor.getTamanho() instanceof NoInteiro){
                        if (valores.getValores().size() > ((NoInteiro)declaracaoVetor.getTamanho()).getValor()){
                            notificarAviso(new AvisoInicializacaoVetorMaisValoresTamanho(declaracaoVetor,inicializacao));
                        }
                    } else if (declaracaoVetor.getTamanho() instanceof NoReferenciaVariavel){
                        NoReferenciaVariavel nrv = (NoReferenciaVariavel) declaracaoVetor.getTamanho();
                        Simbolo simbolo = obterSimbolo(nrv.getNome(), tabelaSimbolos);
                        notificarAviso(new AvisoTamanhoReferenciaInicializacao(simbolo,declaracaoVetor,inicializacao));
                    }
                    TipoDado tipoDadoOperandoEsquerdo = vetor.getTipoDado();
                    TipoDado tipoDadoOperandoDireito = null;

                    try { tipoDadoOperandoDireito = obterTipoDadoExpressao(inicializacao, tabelaSimbolos); }
                    catch (ExcecaoImpossivelDeterminarTipoDado excecao) {}

                    NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
                    referencia.setTrechoCodigoFonteNome(declaracaoVetor.getTrechoCodigoFonteNome());
                    NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);
                    
                    if (tipoDadoOperandoDireito != null)
                    {
                        obterTipoDadoOperacaoAtribuicao(operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
                    }                   
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
            final NoExpressao numeroLinhas = declaracaoMatriz.getNumeroLinhas();
            if (numeroLinhas != null) {
                TipoDado tipoDadoLinha = obterTipoDadoExpressao(numeroLinhas, tabelaSimbolos);

                if (!(tipoDadoLinha == TipoDado.INTEIRO))
                    notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoLinha));
            }
        }
        catch (ExcecaoImpossivelDeterminarTipoDado e2){  }
        
        try
        {
            final NoExpressao numeroColunas = declaracaoMatriz.getNumeroColunas();
            if (numeroColunas != null){
                TipoDado tipoDadoColuna = obterTipoDadoExpressao(numeroColunas, tabelaSimbolos);

                if (!(tipoDadoColuna == TipoDado.INTEIRO))
                    notificarErroSemantico(new ErroTipoIndiceIncompativel(0, 0, tipoDadoColuna));
            }
        }
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

    private TipoDado obterTipoDadoIncremento(NoIncremento noIncremento, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        TipoDado tipo = null;
        NoExpressao expressao = noIncremento.getExpressao();
        
        if (!(expressao instanceof NoReferencia))
        {
           notificarErroSemantico(new ErroOperacaoComExpressaoConstante(noIncremento, expressao));
        }
        
        try { tipo = obterTipoDadoExpressao(noIncremento.getExpressao(), tabelaSimbolos); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) { }
        
        final TipoDado fTipo = tipo;    
        
        if (tipo != null)
        {        
            if (tipo != TipoDado.INTEIRO && tipo != TipoDado.REAL)
            {
                notificarErroSemantico(new ErroSemantico(noIncremento.getTrechoCodigoFonte().getLinha(), noIncremento.getTrechoCodigoFonte().getColuna()) 
                {
                    @Override
                    protected String construirMensagem()
                    {
                        return String.format("Tipos incompatíveis. O incremento espera uma expressão do tipo \"%s\" ou \"%s\", mas foi encontrada uma expressão do tipo \"%s\".", TipoDado.INTEIRO, TipoDado.REAL, fTipo); 
                    }
                });
            }

            return tipo;
        }
        else
        {
            throw new ExcecaoImpossivelDeterminarTipoDado();
        }
    }

    private TipoDado obterTipoDadoMatriz(NoMatriz noMatriz, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        List<TipoDado> tipos = new ArrayList<TipoDado>();
    
        List<List<Object>> valores = noMatriz.getValores();
        
        
        if (valores != null && !valores.isEmpty()){
            
            for (List<Object> valList : valores)
            {
                for (Object elemento : valList)
                {
                    if (elemento != null)
                    {
                        TipoDado tipo = obterTipoDadoExpressao((NoExpressao) elemento, tabelaSimbolos);

                        if (tipo != TipoDado.VAZIO)
                            tipos.add(tipo);
                    }
                }
            }
            
            if (!tipos.isEmpty())
            {
                TipoDado tipoVetor = tipos.get(0);
                
                for (int i = 1; i < tipos.size(); i++)
                {
                    if (tipoVetor != tipos.get(i))
                    {
                        notificarErroSemantico(new ErroSemantico(0, 0)
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                return "A inicialização da matriz possui mais de um tipo de dado";
                            }
                        });
                        
                        throw new ExcecaoImpossivelDeterminarTipoDado();
                    }
                }
                
                return tipoVetor;                
            }
            
            else throw new ExcecaoImpossivelDeterminarTipoDado();
        
            
        } else {
            
            notificarErroSemantico(new ErroSemantico(0, 0)
            {
                    @Override
                    protected String construirMensagem()
                    {
                        return "A inicialização da matriz não possui elementos";
                    }
            });
            
            throw new ExcecaoImpossivelDeterminarTipoDado();        
        }
    }
    private TipoDado obterTipoDadoVetor(NoVetor noVetor, TabelaSimbolos tabelaSimbolos) throws ExcecaoImpossivelDeterminarTipoDado
    {
        List<Object> valores = noVetor.getValores();
        List<TipoDado> tipos = new ArrayList<TipoDado>();
        
        if (valores != null && !valores.isEmpty())
        {        
            for (Object elemento : valores)
            {
                 if (elemento != null)
                 {
                    TipoDado tipo = obterTipoDadoExpressao((NoExpressao) elemento, tabelaSimbolos);

                    if (tipo != TipoDado.VAZIO)
                        tipos.add(tipo);
                 } 
            }
            
            if (!tipos.isEmpty())
            {
                TipoDado tipoVetor = tipos.get(0);
                
                for (int i = 1; i < tipos.size(); i++)
                {
                    if (tipoVetor != tipos.get(i))
                    {
                        notificarErroSemantico(new ErroSemantico(0, 0)
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                return "A inicialização do vetor possui mais de um tipo de dado";
                            }
                        });
                        
                        throw new ExcecaoImpossivelDeterminarTipoDado();
                    }
                }
                
                return tipoVetor;                
            }
            
            else throw new ExcecaoImpossivelDeterminarTipoDado();
        }
        
        else
        {
            notificarErroSemantico(new ErroSemantico(0, 0)
            {
                    @Override
                    protected String construirMensagem()
                    {
                        return "A inicialização do vetor não possui elementos";
                    }
            });
            
            throw new ExcecaoImpossivelDeterminarTipoDado();
        }
    }
}
