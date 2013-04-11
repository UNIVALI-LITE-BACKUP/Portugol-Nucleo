/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ExcecaoImpossivelDeterminarTipoDado;
import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.asa.NoOperacaoAtribuicao;
import br.univali.portugol.nucleo.asa.NoOperacaoDivisao;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaDiferenca;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaE;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaIgualdade;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMaior;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMaiorIgual;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMenor;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaMenorIgual;
import br.univali.portugol.nucleo.asa.NoOperacaoLogicaOU;
import br.univali.portugol.nucleo.asa.NoOperacaoModulo;
import br.univali.portugol.nucleo.asa.NoOperacaoMultiplicacao;
import br.univali.portugol.nucleo.asa.NoOperacaoSoma;
import br.univali.portugol.nucleo.asa.NoOperacaoSubtracao;
import br.univali.portugol.nucleo.asa.TipoDado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fillipi
 */
public final class TabelaCompatibilidadeTiposPortugol implements TabelaCompatibilidadeTipos
{
    private Map<Class<? extends NoOperacao>, TipoDado[][]> tabelas;

    public static final TabelaCompatibilidadeTiposPortugol INSTANCE = new TabelaCompatibilidadeTiposPortugol();
    
    private TabelaCompatibilidadeTiposPortugol()
    {
        tabelas = new HashMap<Class<? extends NoOperacao>, TipoDado[][]>();
        
        tabelas.put(NoOperacaoAtribuicao.class, criarTabelaCompatibilidadeAtribuicao());
        tabelas.put(NoOperacaoDivisao.class, criarTabelaCompatibilidadeDivisaoMultiplicacaoSubtracao());
        tabelas.put(NoOperacaoLogicaDiferenca.class, criarTabelaCompatibilidadeDiferencaIgualdade());
        tabelas.put(NoOperacaoLogicaE.class, criarTabelaCompatibilidadeEOu());
        tabelas.put(NoOperacaoLogicaIgualdade.class, criarTabelaCompatibilidadeDiferencaIgualdade());
        tabelas.put(NoOperacaoLogicaMaior.class, criarTabelaCompatibilidadeMaiorMaiorIgualMenorMenorIgual());
        tabelas.put(NoOperacaoLogicaMaiorIgual.class, criarTabelaCompatibilidadeMaiorMaiorIgualMenorMenorIgual());
        tabelas.put(NoOperacaoLogicaMenor.class, criarTabelaCompatibilidadeMaiorMaiorIgualMenorMenorIgual());
        tabelas.put(NoOperacaoLogicaMenorIgual.class, criarTabelaCompatibilidadeMaiorMaiorIgualMenorMenorIgual());
        tabelas.put(NoOperacaoLogicaOU.class, criarTabelaCompatibilidadeEOu());
        tabelas.put(NoOperacaoModulo.class, criarTabelaCompatibilidadeModulo());
        tabelas.put(NoOperacaoMultiplicacao.class, criarTabelaCompatibilidadeDivisaoMultiplicacaoSubtracao());        
        tabelas.put(NoOperacaoSoma.class, criarTabelaCompatibilidadeSoma());
        tabelas.put(NoOperacaoSubtracao.class, criarTabelaCompatibilidadeDivisaoMultiplicacaoSubtracao());
        
    }

    @Override
    public TipoDado getRetorno(Class<? extends NoOperacao> operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ExcecaoImpossivelDeterminarTipoDado
    {
        TipoDado[][] tabelaCompatibilidade = tabelas.get(operacao);
        TipoDado tipoEsperado = tabelaCompatibilidade[tipoDadoOperandoEsquerdo.ordinal()][tipoDadoOperandoDireito.ordinal()];
        if (tipoEsperado == null)
            throw new ExcecaoImpossivelDeterminarTipoDado();
        return tipoEsperado;
    }

    private TipoDado[][] criarTabelaCompatibilidadeAtribuicao()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = TipoDado.CARACTER;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }

    private TipoDado[][] criarTabelaCompatibilidadeDivisaoMultiplicacaoSubtracao()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }

    private TipoDado[][] criarTabelaCompatibilidadeDiferencaIgualdade()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }

    private TipoDado[][] criarTabelaCompatibilidadeEOu()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }

    private TipoDado[][] criarTabelaCompatibilidadeMaiorMaiorIgualMenorMenorIgual()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }

    private TipoDado[][] criarTabelaCompatibilidadeModulo()
    {
         int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }
    
    private TipoDado[][] criarTabelaCompatibilidadeSoma()
    {
        int tamanho = TipoDado.values().length;
        TipoDado[][] tabela = new TipoDado[tamanho][tamanho];
        
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.CARACTER.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.LOGICO.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CADEIA.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.CARACTER.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.CARACTER.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.INTEIRO;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.INTEIRO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
                 
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.LOGICO.ordinal()] = TipoDado.LOGICO;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.LOGICO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.REAL.ordinal()][TipoDado.CADEIA.ordinal()] = TipoDado.CADEIA;
        tabela[TipoDado.REAL.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.INTEIRO.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.REAL.ordinal()][TipoDado.REAL.ordinal()] = TipoDado.REAL;
        tabela[TipoDado.REAL.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CADEIA.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.CARACTER.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.INTEIRO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.LOGICO.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.REAL.ordinal()] = null;
        tabela[TipoDado.VAZIO.ordinal()][TipoDado.VAZIO.ordinal()] = null;
        
        return tabela;
    }
}
