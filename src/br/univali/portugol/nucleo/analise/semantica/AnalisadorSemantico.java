package br.univali.portugol.nucleo.analise.semantica;

import java.util.ArrayList;
import java.util.List;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.analise.semantica.erros.*;
import br.univali.portugol.nucleo.analise.semantica.avisos.*;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.simbolos.*;


public final class AnalisadorSemantico
{
    private TabelaSimbolos tabelaSimbolosGlobal;
    private List<ObservadorAnaliseSemantica> observadores;

    public AnalisadorSemantico()
    {
        observadores = new ArrayList<ObservadorAnaliseSemantica>();
    }
    
    public void adicionarObservador(ObservadorAnaliseSemantica observadorAnaliseSemantica)
    {
        if (!observadores.contains(observadorAnaliseSemantica))
            observadores.add(observadorAnaliseSemantica);
    }
    
    public void removerObservador(ObservadorAnaliseSemantica observadorAnaliseSemantica)
    {
        observadores.remove(observadorAnaliseSemantica);
    }

    public void analisar(ArvoreSintaticaAbstrata asa)
    {
        if (asa != null)
        {
            tabelaSimbolosGlobal = new TabelaSimbolos();
            analizarListaDeclaracoesGlobais(asa.getListaDeclaracoesGlobais());
        }
    }

    private void analizarListaDeclaracoesGlobais(List<NoDeclaracao> listaDeclaracoesGlobais)
    {
        if (listaDeclaracoesGlobais != null)
        {
            for (NoDeclaracao declaracao: listaDeclaracoesGlobais)
                analizarDeclaracaoGlobal(declaracao, tabelaSimbolosGlobal);

            for (Simbolo simbolo: tabelaSimbolosGlobal)
            {
                if (simbolo instanceof Funcao)
                {
                	tabelaSimbolosGlobal.empilharEscopo();
                    analizarBlocosFuncao((Funcao) simbolo, tabelaSimbolosGlobal);
                    tabelaSimbolosGlobal.desempilharEscopo();
                }
            }
        }
    }

    private void analizarDeclaracaoGlobal(NoDeclaracao declaracao, TabelaSimbolos tabelaSimbolos)
    {
        if (declaracao instanceof NoDeclaracaoVariavel)
            analizarDeclaracaoVariavel((NoDeclaracaoVariavel) declaracao, tabelaSimbolos);
        else

        if (declaracao instanceof NoDeclaracaoFuncao)
            analizarDeclaracaoFuncao((NoDeclaracaoFuncao) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoVetor)
            analizarDeclaracaoVetor((NoDeclaracaoVetor) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoMatriz)
            analizarDeclaracaoMatriz((NoDeclaracaoMatriz) declaracao, tabelaSimbolos);
    }

    private void analizarDeclaracaoVariavel(NoDeclaracaoVariavel declaracaoVariavel, TabelaSimbolos tabelaSimbolos)
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

        tabelaSimbolos.adicionar(variavel);

        if (declaracaoVariavel.getInicializacao() != null)
        {
            NoExpressao inicializacao = declaracaoVariavel.getInicializacao();
            NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
            referencia.setTrechoCodigoFonteNome(declaracaoVariavel.getTrechoCodigoFonteNome());
            NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);

            try { obterTipoDadoExpressao(operacao, tabelaSimbolos); }
            catch (ErroSemantico erro) { notificarErroSemantico(erro); }
            catch (Exception e) {}
        }
    }

    private void analizarDeclaracaoFuncao(NoDeclaracaoFuncao declaracaoFuncao, TabelaSimbolos tabelaSimbolos)
    {
        String nome = declaracaoFuncao.getNome();
        TipoDado tipoDado = declaracaoFuncao.getTipoDado();
        Quantificador quantificador = declaracaoFuncao.getQuantificador();

        Funcao funcao = new Funcao(nome, tipoDado, quantificador, declaracaoFuncao.getParametros(), declaracaoFuncao.getBlocos());

        if (tabelaSimbolos.contem(nome))
        {
            notificarErroSemantico(new ErroSimboloRedeclarado(funcao, tabelaSimbolos.obter(nome)));
            funcao.setRedeclarado(true);
        }

        tabelaSimbolos.adicionar(funcao);
    }

    private void analizarListaBlocos(List<NoBloco> listaBlocos, TabelaSimbolos tabelaSimbolos)
    {
        if (listaBlocos != null)
        {
            for (NoBloco bloco: listaBlocos)
            {
                try { analizarBloco(bloco, tabelaSimbolos); }
                catch (ErroSemantico erro) { notificarErroSemantico(erro); }
            }
        }
    }

    private void analizarBlocosFuncao(Funcao funcao, TabelaSimbolos tabelaSimbolosFuncao)
    {
        List<NoParametro> parametros = funcao.getParametros();

        for (NoParametro parametro : parametros)
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

        analizarListaBlocos(funcao.getBlocos(), tabelaSimbolosFuncao);
    }

    private void analizarBloco(NoBloco bloco, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis
    {
        if (bloco instanceof NoPara)
            analizarBlocoPara((NoPara) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoDeclaracao)
            analizarDeclaracao((NoDeclaracao) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoSe)
            analizarBlocoSe((NoSe) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoEnquanto)
            analizarBlocoEnquanto((NoEnquanto) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoFacaEnquanto)
            analizarBlocoFacaEnquanto((NoFacaEnquanto) bloco, tabelaSimbolos);

        else

        if (bloco instanceof NoExpressao)
            analizarExpressao((NoExpressao) bloco, tabelaSimbolos);
    }

    private void analizarExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis
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
            analizarIncremento((NoIncremento) expressao);
        
        else
        	
        if (expressao instanceof NoReferencia)
        	analizarReferencia((NoReferencia) expressao, tabelaSimbolos);
    }
    
    private void analizarReferencia(NoReferencia referencia, TabelaSimbolos tabelaSimbolos)
    {    	
    	String nome = referencia.getNome();
    	
    	if (referencia instanceof NoChamadaFuncao)
        {	
    		if (!nome.equals("escreva") && !nome.equals("limpa") && !nome.equals("leia") && !nome.equals("aguarde") && !nome.equals("tamanho"))
    		{
	    		if (tabelaSimbolos.contem((referencia.getNome())))
		        {
	    			Funcao funcao = (Funcao) tabelaSimbolos.obter(referencia.getNome()); 
	    			analizarChamadaFuncao((NoChamadaFuncao) referencia, funcao, tabelaSimbolos);
		        }
	        
	    		else notificarErroSemantico(new ErroSimboloNaoDeclarado((NoReferencia) referencia));
    		}
    		else
    		{
    			analizarChamadaFuncaoEspecial((NoChamadaFuncao) referencia, tabelaSimbolos);
    		}
        }
    	
    	else
    		
    	if (referencia instanceof NoReferenciaVariavel)
    	{
    		if (!tabelaSimbolos.contem(nome))
    			notificarErroSemantico(new ErroSimboloNaoDeclarado(referencia));
    	}
    }


    private void analizarDeclaracao(NoDeclaracao declaracao, TabelaSimbolos tabelaSimbolos)
    {
        if (declaracao instanceof NoDeclaracaoVariavel)
            analizarDeclaracaoVariavel((NoDeclaracaoVariavel) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoVetor)
            analizarDeclaracaoVetor((NoDeclaracaoVetor) declaracao, tabelaSimbolos);
        
        else
            
        if (declaracao instanceof NoDeclaracaoMatriz)
            analizarDeclaracaoMatriz((NoDeclaracaoMatriz) declaracao, tabelaSimbolos);
    }

    private TipoDado obterTipoDadoExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ExcecaoImpossivelDeterminarTipoDado
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

    private TipoDado obterTipoDadoOperacao(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws ErroTiposIncompativeis, ExcecaoImpossivelDeterminarTipoDado
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
                case MODULO_ATRIBUITIVO:            return obterTipoDadoOperacaoModuloAtribuitivo           (operacao, tipoDadoOperandoEsquerdo, tipoDadoOperandoDireito);
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
            if (nome.equals("escreva") || nome.equals("leia") || nome.equals("limpa") || nome.equals("aguarde"))
                return TipoDado.VAZIO;
            
            else
                
            if (nome.equals("tamanho"))
                return TipoDado.INTEIRO;            
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
            analizarChamadaFuncao((NoChamadaFuncao) referencia, (Funcao) simbolo, tabelaSimbolos);

        return simbolo.getTipoDado();
    }

    private Simbolo obterSimbolo(String nome, TabelaSimbolos tabelaSimbolos)
    {
            Simbolo simbolo = null;
            
            simbolo = (simbolo == null)? tabelaSimbolos.obter(nome) : simbolo;
            simbolo = (simbolo == null)? tabelaSimbolosGlobal.obter(nome) : simbolo;

            return simbolo;
    }

    private void analizarBlocoPara(NoPara para, TabelaSimbolos tabelaSimbolos)
    {
        tabelaSimbolos.empilharEscopo();

        try { analizarBloco(para.getInicializacao(), tabelaSimbolos); }
        catch(ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }

        try { analizarBloco(para.getCondicao(), tabelaSimbolos); }
        catch(ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }

        try { analizarBloco(para.getIncremento(), tabelaSimbolos); }
        catch(ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }

        analizarListaBlocos(para.getBlocos(), tabelaSimbolos);

        tabelaSimbolos.desempilharEscopo();
    }
    
    private void analizarChamadaFuncaoEspecial(NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos)
    {
    	List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
    	
        if (parametrosPassados != null)
        {        
            for (NoExpressao expressao: parametrosPassados)
            {
                    try
                    {
                        analizarExpressao(expressao, tabelaSimbolos);
                    }
                    catch (ErroTiposIncompativeis erro) 
                    {
                            notificarErroSemantico(erro);
                    }
            }
        }
    }

    private void analizarChamadaFuncao(NoChamadaFuncao chamadaFuncao, Funcao funcao, TabelaSimbolos tabelaSimbolos)
    {
        int cont = 0;
        List<NoParametro> parametrosEsperados = funcao.getParametros();
        List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();

        if (parametrosPassados.size() > funcao.getParametros().size())
        {
            cont = chamadaFuncao.getParametros().size();
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
        }

        else

        if (parametrosEsperados.size() > parametrosPassados.size())
        {
            cont = chamadaFuncao.getParametros().size();
            notificarErroSemantico(new ErroNumeroParametrosPassadosFuncao(parametrosPassados.size(), parametrosEsperados.size(), funcao, chamadaFuncao));
        }

        else cont = parametrosPassados.size();

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
                if (tipoDadoParametroEsperado != tipoDadoParametroPassado)
                    notificarErroSemantico(new ErroTipoParametroIncompativel(tipoDadoParametroEsperado, tipoDadoParametroPassado, parametrosEsperados.get(i), parametrosPassados.get(i), funcao));
            }
        }
    }

    private void analizarBlocoSe(NoSe blocoSe, TabelaSimbolos tabelaSimbolos)
    {
        try 
        {
            NoExpressao condicao = blocoSe.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(blocoSe, condicao));
        }
        catch (ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}

        tabelaSimbolos.empilharEscopo();
        analizarListaBlocos(blocoSe.getBlocosVerdadeiros(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();

        tabelaSimbolos.empilharEscopo();
        analizarListaBlocos(blocoSe.getBlocosFalsos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();        
    }

    private void analizarBlocoEnquanto(NoEnquanto enquanto, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            NoExpressao condicao = enquanto.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(enquanto, condicao));
        }
        catch (ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}

        tabelaSimbolos.empilharEscopo();
        analizarListaBlocos(enquanto.getBlocos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();
    }

    private void analizarBlocoFacaEnquanto(NoFacaEnquanto facaEnquanto, TabelaSimbolos tabelaSimbolos)
    {
        tabelaSimbolos.empilharEscopo();
        analizarListaBlocos(facaEnquanto.getBlocos(), tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();

        try
        {
            NoExpressao condicao = facaEnquanto.getCondicao();
            TipoDado tipoDado = obterTipoDadoExpressao(condicao, tabelaSimbolos);
            if (tipoDado != TipoDado.LOGICO) notificarErroSemantico(new ErroExpressaoTipoLogicoEsperada(facaEnquanto, condicao));
        }
        catch (ErroTiposIncompativeis erro) { notificarErroSemantico(erro); }
        catch (ExcecaoImpossivelDeterminarTipoDado ex) {}
    }

    private void analizarIncremento(NoIncremento incremento)
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

    private void analizarDeclaracaoVetor(NoDeclaracaoVetor declaracaoVetor, TabelaSimbolos tabelaSimbolos)
    {
        
        String nome = declaracaoVetor.getNome();
        TipoDado tipoDado = declaracaoVetor.getTipoDado();

        try
        {
            TipoDado tipoDadoTamanho = obterTipoDadoExpressao(declaracaoVetor.getTamanho(), tabelaSimbolos);

            if (!(tipoDadoTamanho == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTiposIncompativeis2(0, 0, TipoDado.INTEIRO, tipoDadoTamanho));
        }
        catch (ErroTiposIncompativeis e){ notificarErroSemantico(e); }
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
            NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
            referencia.setTrechoCodigoFonteNome(declaracaoVetor.getTrechoCodigoFonteNome());
            NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);

            try { obterTipoDadoExpressao(operacao, tabelaSimbolos); }
            catch (ErroSemantico erro) { notificarErroSemantico(erro); }
            catch (Exception e) {}
        }
    }

    private void analizarDeclaracaoMatriz(NoDeclaracaoMatriz declaracaoMatriz, TabelaSimbolos tabelaSimbolos) 
    {
        String nome = declaracaoMatriz.getNome();
        TipoDado tipoDado = declaracaoMatriz.getTipoDado();

        try
        {
            TipoDado tipoDadoLinha = obterTipoDadoExpressao(declaracaoMatriz.getNumeroLinhas(), tabelaSimbolos);

            if (!(tipoDadoLinha == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTiposIncompativeis2(0, 0, TipoDado.INTEIRO, tipoDadoLinha));
        }
        catch (ErroTiposIncompativeis e){ notificarErroSemantico(e); }
        catch (ExcecaoImpossivelDeterminarTipoDado e2){  }
        
        try
        {
            TipoDado tipoDadoColuna = obterTipoDadoExpressao(declaracaoMatriz.getNumeroColunas(), tabelaSimbolos);

            if (!(tipoDadoColuna == TipoDado.INTEIRO))
                notificarErroSemantico(new ErroTiposIncompativeis2(0, 0, TipoDado.INTEIRO, tipoDadoColuna));
        }
        catch (ErroTiposIncompativeis e){ notificarErroSemantico(e); }
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
            NoReferenciaVariavel referencia = new NoReferenciaVariavel(nome);
            referencia.setTrechoCodigoFonteNome(declaracaoMatriz.getTrechoCodigoFonteNome());
            NoOperacao operacao = new NoOperacao(Operacao.ATRIBUICAO, referencia, inicializacao);

            try { obterTipoDadoExpressao(operacao, tabelaSimbolos); }
            catch (ErroSemantico erro) { notificarErroSemantico(erro); }
            catch (Exception e) {}
        }        
    }
}
