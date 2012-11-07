/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoCaso;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoDecremento;
import br.univali.portugol.nucleo.asa.NoEnquanto;
import br.univali.portugol.nucleo.asa.NoEscolha;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoFacaEnquanto;
import br.univali.portugol.nucleo.asa.NoIncremento;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoMatriz;
import br.univali.portugol.nucleo.asa.NoMenosUnario;
import br.univali.portugol.nucleo.asa.NoNao;
import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.asa.NoPara;
import br.univali.portugol.nucleo.asa.NoPare;
import br.univali.portugol.nucleo.asa.NoPercorra;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.NoRetorne;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.asa.Operacao;
import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import br.univali.portugol.nucleo.execucao.Entrada;
import br.univali.portugol.nucleo.execucao.Saida;
import br.univali.portugol.nucleo.execucao.erros.ErroIndiceVetorInvalido;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.Funcao;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Ponteiro;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.TabelaSimbolos;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author fillipi
 */
public class Depurador implements VisitanteASA
{
    
    public static final String funcaoInicialPadrao = "inicio";
      
    private Saida saida;
    private Entrada entrada;
    private boolean referencia = false;
    private boolean chamaFuncao = false;

    public void setEntrada(Entrada entrada)
    {
        this.entrada = entrada;
    }

    public void setSaida(Saida saida)
    {
        this.saida = saida;
    }
    
    private String funcaoInicial = funcaoInicialPadrao;
    private String ultimaReferenciaAcessada;

    private TabelaSimbolos tabelaSimbolosGlobal;
    Stack<TabelaSimbolos> tabelaSimbolosLocal = new Stack<TabelaSimbolos>();
    
    public void Depurar(Programa programa, String[] parametros) throws ErroExecucao
    {
        try {
            visitar(programa.getArvoreSintaticaAbstrata());
            
            
            if (tabelaSimbolosGlobal.contem(funcaoInicial))
            {
            
                Funcao funcaoPrincipal = (Funcao) tabelaSimbolosGlobal.obter(funcaoInicial);
                TabelaSimbolos tabelaSimbolosFuncaoPrincipal = new TabelaSimbolos();
                tabelaSimbolosLocal.push(tabelaSimbolosFuncaoPrincipal);
                if (funcaoPrincipal.getParametros().size() > 0)
                {
                    List<Object> listaParametros = converterVetorEmLista(parametros);
                    tabelaSimbolosFuncaoPrincipal.adicionar(new Vetor(funcaoPrincipal.getParametros().get(0).getNome(), TipoDado.CADEIA, listaParametros.size(), listaParametros));
                }
                interpretarListaBlocos(funcaoPrincipal.getBlocos());
                tabelaSimbolosLocal.pop();
            } else {
                throw new RuntimeException();
            }
        
        } catch (Exception e)
        {
            e.printStackTrace();
        }    
    }
    
    private Simbolo obterSimbolo(String nome)
    {
        TabelaSimbolos tabelaSimbolos = tabelaSimbolosLocal.peek();
        
        if (tabelaSimbolos.contem(nome))
        {
            return tabelaSimbolos.obter(nome);
        }

        return tabelaSimbolosGlobal.obter(nome);
    }

     private List<Object> converterVetorEmLista(Object[] vetor)
    {
        List<Object> lista = new ArrayList<Object>();

        if (vetor != null)
        {
            for (int i = 0; i < vetor.length; i++)
            {
                lista.add(vetor[i]);
            }
        }

        return lista;
    }
    
    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
        tabelaSimbolosGlobal = new TabelaSimbolos();
        tabelaSimbolosLocal.push(tabelaSimbolosGlobal);
        List<NoDeclaracao> listaDeclaracoesGlobais = asap.getListaDeclaracoesGlobais();
        for (NoDeclaracao noDeclaracao : listaDeclaracoesGlobais)
        {
            noDeclaracao.aceitar(this);
        }        
        return null; 
    }

    @Override
    public Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
    {
        return noCadeia.getValor();
    }

    @Override
    public Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
    {
        return noCaracter.getValor();
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        return noCaso.getExpressao().aceitar(this);
    }

    @Override
    public Object visitar(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        if (noChamadaFuncao.getNome().equals("escreva"))
        {
            try {
                escreva(noChamadaFuncao);
            } catch (Exception e) {

            }
        }
        else if (noChamadaFuncao.getNome().equals("leia"))
        {
            try {
                leia(noChamadaFuncao);
            }
            catch (Exception e ) {}

        } else {

            Funcao funcao = (Funcao) obterSimbolo(noChamadaFuncao.getNome());

            tabelaSimbolosLocal.push(new TabelaSimbolos());

            List<NoExpressao> listaParametrosPassados = noChamadaFuncao.getParametros();
            List<NoDeclaracaoParametro> listaParametrosEsperados = funcao.getParametros();

            for (int i = 0; i < listaParametrosEsperados.size(); i++)
            {
                Simbolo simbolo = (Simbolo) listaParametrosEsperados.get(i).aceitar(this);
                
                this.chamaFuncao = true;
                if (simbolo instanceof Variavel) {
                    Object valor = listaParametrosPassados.get(i).aceitar(this);
                    ((Variavel)simbolo).setValor(valor);
                } else if (simbolo instanceof Ponteiro) {
                    referencia = true;
                    Object valor = listaParametrosPassados.get(i).aceitar(this);
                    referencia = false;
                    ((Ponteiro)simbolo).setSimbolo((Simbolo)valor);
                } else if (simbolo instanceof Vetor){
                    List<Object> valores = (List<Object>) listaParametrosPassados.get(i).aceitar(this);
                    ((Vetor)simbolo).inicializarComValores(valores);
                } else if (simbolo instanceof Matriz) {
                    List<List<Object>> valores = (List<List<Object>>) listaParametrosPassados.get(i).aceitar(this);
                    ((Matriz)simbolo).inicializarComValores(valores);
                }
                this.chamaFuncao = false;
            }
            Object retorno = interpretarListaBlocos(funcao.getBlocos());

            tabelaSimbolosLocal.pop();
            return retorno;
        } 
        return null;
    }
    
     private Simbolo extrairSimbolo(Simbolo simbolo)
    {
        while (simbolo instanceof Ponteiro)
        {
            simbolo = ((Ponteiro) simbolo).getSimboloApontado();
        }        
        return simbolo;
    }
     
    @Override
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {        
        String nome = declaracaoFuncao.getNome();
        TipoDado tipoDados = declaracaoFuncao.getTipoDado();
        Quantificador quantificador = declaracaoFuncao.getQuantificador();

        List<NoDeclaracaoParametro> parametros = declaracaoFuncao.getParametros();
        List<NoBloco> blocos = declaracaoFuncao.getBlocos();
        Funcao funcao = new Funcao(nome, tipoDados, quantificador, parametros, blocos);        
        
        tabelaSimbolosLocal.peek().adicionar(funcao);
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
         String nome = noDeclaracaoMatriz.getNome();
        TipoDado tipoDado = noDeclaracaoMatriz.getTipoDado();

        int numeroLinhas = (Integer) noDeclaracaoMatriz.getNumeroLinhas().aceitar(this);
        int numeroColunas = (Integer) noDeclaracaoMatriz.getNumeroColunas().aceitar(this);
        List<List<Object>> valores = (List<List<Object>>) noDeclaracaoMatriz.getInicializacao().aceitar(this);

        Matriz matriz;

        if (numeroLinhas == 0)
        {
            matriz = new Matriz(nome, tipoDado, valores);
        }
        else
        {
            matriz = new Matriz(nome, tipoDado, numeroLinhas, numeroColunas, valores);
        }

        matriz.setConstante(noDeclaracaoMatriz.constante());
        
        tabelaSimbolosLocal.peek().adicionar(matriz);
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVariavel.getNome();
        TipoDado tipoDado = noDeclaracaoVariavel.getTipoDado();
        
        Variavel variavel = new Variavel(nome, tipoDado);
        
        if (noDeclaracaoVariavel.getInicializacao() != null) {
            Object valor = noDeclaracaoVariavel.getInicializacao().aceitar(this);
            variavel.setValor(valor);            
        }
        
        variavel.setConstante(noDeclaracaoVariavel.constante());
        
        tabelaSimbolosLocal.peek().adicionar(variavel);
        
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVetor.getNome();
        TipoDado tipoDado = noDeclaracaoVetor.getTipoDado();

        int tamanho = (Integer) noDeclaracaoVetor.getTamanho().aceitar(this);
        List<Object> valores = (List<Object>) noDeclaracaoVetor.getInicializacao().aceitar(this);

        Vetor vetor = null;

        if (tamanho == 0)
        {
            vetor = new Vetor(nome, tipoDado, valores);
        }
        else
        {
            vetor = new Vetor(nome, tipoDado, tamanho, valores);
        }

        vetor.setConstante(noDeclaracaoVetor.constante());

        tabelaSimbolosLocal.peek().adicionar(vetor);
        
        return null;
    }

    @Override
    public Object visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA
    {
        return new NoOperacao(Operacao.SUBTRACAO_ACUMULATIVA, noDecremento.getExpressao(), new NoInteiro(1)).aceitar(this);
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        try {
            while ((Boolean) noEnquanto.getCondicao().aceitar(this))
            {
                Object valorRetorno = interpretarListaBlocos(noEnquanto.getBlocos());

                if (valorRetorno != null)
                {
                    return valorRetorno;
                }
            }
        } catch (PareException pe) {
        
        }

        return null;
    }
    
    private Object interpretarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {
        if (blocos == null)
        {
            return null;
        }
        
        tabelaSimbolosLocal.peek().empilharEscopo();
        try {
            for (NoBloco noBloco : blocos)
            {
                noBloco.aceitar(this);
            }
        } catch (RetorneException re) {
            return re.getValor();
        } finally {
            tabelaSimbolosLocal.peek().desempilharEscopo();
        }
        return null;
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        List<NoCaso> casos = noEscolha.getCasos();
        Object valorEscolha = noEscolha.getExpressao().aceitar(this);

        int indiceValorEscolhido = procurarIndiceValorEscolhido(valorEscolha, casos);

        if (indiceValorEscolhido >= 0)
        {
            try {
                for (int i = indiceValorEscolhido; i < casos.size(); i++)
                {
                    Object valorRetorno = interpretarListaBlocos(casos.get(i).getBlocos());

                    if (valorRetorno != null)
                    {
                        return valorRetorno;
                    }
                }
            } catch (PareException pe) {
            
            }
        }

        return null;
    }
    
    private int procurarIndiceValorEscolhido(Object valorEscolha, List<NoCaso> casos) throws ExcecaoVisitaASA
    {
        for (NoCaso caso : casos)
        {          
            if (caso.aceitar(this) == valorEscolha)
            {
                return casos.indexOf(caso);
            }

            if (caso.aceitar(this) == null)
            {
                return casos.indexOf(caso);
            }            
        }

        return -1;
    }
        

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        try {
            do
            {
                Object valorRetorno = interpretarListaBlocos(noFacaEnquanto.getBlocos());

                if (valorRetorno != null)
                {
                    return valorRetorno;
                }
            }
            while ((Boolean) noFacaEnquanto.getCondicao().aceitar(this));
        } catch (PareException pe) {
        
        }
        return null;
    }

    @Override
    public Object visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA
    {
        return new NoOperacao(Operacao.SOMA_ACUMULATIVA, noIncremento.getExpressao(), new NoInteiro(1)).aceitar(this);
    }

    @Override
    public Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
    {
        return noInteiro.getValor();
    }

    @Override
    public Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA
    {
        return noLogico.getValor();
    }

    @Override
    public Object visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
    {
        
        List<List<Object>> valores = noMatriz.getValores();

        if (valores != null)
        {
            int linhas = valores.size();

            for (int i = 0; i < linhas; i++)
            {
                List<Object> vetor = valores.get(i);

                int colunas = (vetor == null) ? 0 : vetor.size();

                for (int j = 0; j < colunas; j++)
                {
                    vetor.set(j, ((NoExpressao) vetor.get(j)).aceitar(this));
                }
            }
        }

        return valores;
    }

    @Override
    public Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA
    {
         Object valor = noMenosUnario.getExpressao().aceitar(this);

        if (valor instanceof Double)
        {
            return -((Double) valor);
        }
        if (valor instanceof Integer)
        {
            return -((Integer) valor);
        }
        if (valor instanceof Character)
        {
            return -((Character) valor);
        }

        return null;
    }

    @Override
    public Object visitar(NoNao noNao) throws ExcecaoVisitaASA
    {
        return !((Boolean)noNao.getExpressao().aceitar(this));
    }

    @Override
    public Object visitar(NoOperacao noOperacao) throws ExcecaoVisitaASA
    {
        switch (noOperacao.getOperacao())
        {
            case ATRIBUICAO:
                return obterValorOperacaoAtribuicao(noOperacao);
            case DIVISAO_ACUMULATIVA:
                return obterValorOperacaoDivisaoAtribuitiva(noOperacao);
            case SUBTRACAO_ACUMULATIVA:
                return obterValorOperacaoSubtracaoAtribuitiva(noOperacao);
            case SOMA_ACUMULATIVA:
                return obterValorOperacaoSomaAtribuitiva(noOperacao);
            case MULTIPLICACAO_ACUMULATIVA:
                return obterValorOperacaoMultiplicacaoAtribuitiva(noOperacao);
            case MODULO_ACUMULATIVO:
                return obterValorOperacaoModuloAtribuitivo(noOperacao);
        }
        
        Object valorOperandoEsquerdo = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object valorOperandoDireito = noOperacao.getOperandoDireito().aceitar(this);
        
        switch (noOperacao.getOperacao())
        {
            case DIFERENCA:
                return obterValorOperacaoDiferenca(valorOperandoEsquerdo, valorOperandoDireito);
            case DIVISAO:
                return obterValorOperacaoDivisao(valorOperandoEsquerdo, valorOperandoDireito);
            case E:
                return obterValorOperacaoE(valorOperandoEsquerdo, valorOperandoDireito);
            case IGUALDADE:
                return obterValorOperacaoIgualdade(valorOperandoEsquerdo, valorOperandoDireito);
            case MAIOR:
                return obterValorOperacaoMaior(valorOperandoEsquerdo, valorOperandoDireito);
            case MAIOR_IGUAL:
                return obterValorOperacaoMaiorIgual(valorOperandoEsquerdo, valorOperandoDireito);
            case MENOR:
                return obterValorOperacaoMenor(valorOperandoEsquerdo, valorOperandoDireito);
            case MENOR_IGUAL:
                return obterValorOperacaoMenorIgual(valorOperandoEsquerdo, valorOperandoDireito);
            case MODULO:
                return obterValorOperacaoModulo(valorOperandoEsquerdo, valorOperandoDireito);
            case MULTIPLICACAO:
                return obterValorOperacaoMultiplicacao(valorOperandoEsquerdo, valorOperandoDireito);
            case OU:
                return obterValorOperacaoOu(valorOperandoEsquerdo, valorOperandoDireito);
            case SOMA:
                return obterValorOperacaoSoma(valorOperandoEsquerdo, valorOperandoDireito);
            case SUBTRACAO:
                return obterValorOperacaoSubtracao(valorOperandoEsquerdo, valorOperandoDireito);
        }

        return null;
    }
    
     private Object obterValorOperacaoAtribuicao(NoOperacao atribuicao) throws ExcecaoVisitaASA
    {
        NoReferencia referencia = (NoReferencia) atribuicao.getOperandoEsquerdo();

        String nome = referencia.getNome();
        Simbolo simbolo = extrairSimbolo(obterSimbolo(nome));
        Object valor = atribuicao.getOperandoDireito().aceitar(this);//, null);

        if ((valor instanceof Double) && (simbolo.getTipoDado() == TipoDado.INTEIRO))
        {
            double val = (Double) valor;
            valor = (int) val;
        }

        if (referencia instanceof NoReferenciaVariavel)
        {
            return atribuirValorVariavel((Variavel) simbolo, valor);
        }

        if (referencia instanceof NoReferenciaVetor)
        {
            return atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) referencia);
        }

        if (referencia instanceof NoReferenciaMatriz)
        {
            return atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) referencia);
        }

        return null;
    }

    private Object obterValorOperacaoDiferenca(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        return !(Boolean) obterValorOperacaoIgualdade(valorOperandoEsquerdo, valorOperandoDireito);
    }

    private Object obterValorOperacaoDivisao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo / (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo / (Double) valorOperandoDireito;
            }
        }
        else
        {
            if (valorOperandoEsquerdo instanceof Double)
            {
                double valorEsquerdo = (Double) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Integer)
                {
                    return valorEsquerdo / (Integer) valorOperandoDireito;
                }
                if (valorOperandoDireito instanceof Double)
                {
                    return valorEsquerdo / (Double) valorOperandoDireito;
                }
            }
        }

        return null;
    }

    private Object obterValorOperacaoDivisaoAtribuitiva(NoOperacao operacao ) throws ExcecaoVisitaASA
    {
        NoOperacao divisao = new NoOperacao(Operacao.DIVISAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), divisao);

        return obterValorOperacaoAtribuicao(atribuicao);
    }

    private Object obterValorOperacaoE(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        return (Boolean) valorOperandoEsquerdo && (Boolean) valorOperandoDireito;
    }

    private Object obterValorOperacaoIgualdade(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof String)
        {
            String valorEsquerdo = (String) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof String)
            {
                return valorEsquerdo.equals((String) valorOperandoDireito);
            }
        }
        else
        {
            if (valorOperandoEsquerdo instanceof Character)
            {
                char valorEsquerdo = (Character) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Character)
                {
                    return valorEsquerdo == (Character) valorOperandoDireito;
                }
            }
            else
            {
                if (valorOperandoEsquerdo instanceof Integer)
                {
                    int valorEsquerdo = (Integer) valorOperandoEsquerdo;

                    if (valorOperandoDireito instanceof Integer)
                    {
                        return valorEsquerdo == (Integer) valorOperandoDireito;
                    }
                    if (valorOperandoDireito instanceof Double)
                    {
                        return valorEsquerdo == (Double) valorOperandoDireito;
                    }
                }
                else
                {
                    if (valorOperandoEsquerdo instanceof Double)
                    {
                        double valorEsquerdo = (Double) valorOperandoEsquerdo;

                        if (valorOperandoDireito instanceof Integer)
                        {
                            return valorEsquerdo == (Integer) valorOperandoDireito;
                        }
                        if (valorOperandoDireito instanceof Double)
                        {
                            return valorEsquerdo == (Double) valorOperandoDireito;
                        }
                    }
                    else
                    {
                        if (valorOperandoEsquerdo instanceof Boolean)
                        {
                            boolean valorEsquerdo = (Boolean) valorOperandoEsquerdo;

                            if (valorOperandoDireito instanceof Boolean)
                            {
                                return valorEsquerdo == ((Boolean) valorOperandoDireito);
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private Object obterValorOperacaoMaior(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo > (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo > (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo > (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo > (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof String) { 
            String valorEsquerdo = (String) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof  String) {
                String valorDireito = (String) valorOperandoDireito;
                return valorEsquerdo.compareTo(valorDireito) > 0;
            }
        }
        else if (valorOperandoEsquerdo instanceof Character) {
            Character valorEsquero = (Character) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof Character) {
                Character valorDireito = (Character) valorOperandoDireito;
                return valorEsquero.compareTo(valorDireito) > 0;
            }
        }
        
        return null;
    }

    private Object obterValorOperacaoMaiorIgual(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo >= (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo >= (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo >= (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo >= (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof String) { 
            String valorEsquerdo = (String) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof  String) {
                String valorDireito = (String) valorOperandoDireito;
                return valorEsquerdo.compareTo(valorDireito) >= 0;
            }
        }
        else if (valorOperandoEsquerdo instanceof Character) {
            Character valorEsquero = (Character) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof Character) {
                Character valorDireito = (Character) valorOperandoDireito;
                return valorEsquero.compareTo(valorDireito) >= 0;
            }
        }

        return null;
    }

    private Object obterValorOperacaoMenor(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo < (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo < (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo < (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo < (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof String) { 
            String valorEsquerdo = (String) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof  String) {
                String valorDireito = (String) valorOperandoDireito;
                return valorEsquerdo.compareTo(valorDireito) < 0;
            }
        }
        else if (valorOperandoEsquerdo instanceof Character) {
            Character valorEsquero = (Character) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof Character) {
                Character valorDireito = (Character) valorOperandoDireito;
                return valorEsquero.compareTo(valorDireito) < 0;
            }
        }
        return null;
    }

    private Object obterValorOperacaoMenorIgual(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo <= (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo <= (Double) valorOperandoDireito;
            }
        }
        else if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo <= (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo <= (Double) valorOperandoDireito;
            }
        }        
        else if (valorOperandoEsquerdo instanceof String) { 
            String valorEsquerdo = (String) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof  String) {
                String valorDireito = (String) valorOperandoDireito;
                return valorEsquerdo.compareTo(valorDireito) <= 0;
            }
        }
        else if (valorOperandoEsquerdo instanceof Character) {
            Character valorEsquero = (Character) valorOperandoEsquerdo;
            if (valorOperandoDireito instanceof Character) {
                Character valorDireito = (Character) valorOperandoDireito;
                return valorEsquero.compareTo(valorDireito) <= 0;
            }
        }
        return null;
    }

    private Object obterValorOperacaoModulo(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return (valorEsquerdo) % ((Integer) valorOperandoDireito);
            }
        }

        return null;
    }

    private Object obterValorOperacaoModuloAtribuitivo(NoOperacao operacao) throws ExcecaoVisitaASA
    {
        NoOperacao modulo = new NoOperacao(Operacao.MODULO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), modulo);

        return obterValorOperacaoAtribuicao(atribuicao);
    }

    private Object obterValorOperacaoMultiplicacao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo * (Integer) valorOperandoDireito;
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo * (Double) valorOperandoDireito;
            }
        }
        else
        {
            if (valorOperandoEsquerdo instanceof Double)
            {
                double valorEsquerdo = (Double) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Integer)
                {
                    return valorEsquerdo * (Integer) valorOperandoDireito;
                }
                if (valorOperandoDireito instanceof Double)
                {
                    return valorEsquerdo * (Double) valorOperandoDireito;
                }
            }
        }

        return null;
    }

    private Object obterValorOperacaoMultiplicacaoAtribuitiva(NoOperacao operacao) throws ExcecaoVisitaASA
    {
        NoOperacao multiplicacao = new NoOperacao(Operacao.MULTIPLICACAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), multiplicacao);

        return obterValorOperacaoAtribuicao(atribuicao);
    }

    private Object obterValorOperacaoOu(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        return (Boolean) valorOperandoEsquerdo || (Boolean) valorOperandoDireito;
    }

    private Object obterValorOperacaoSoma(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof String)
        {
            String valorEsquerdo = (String) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof String)
            {
                return valorEsquerdo + ((String) valorOperandoDireito);
            }
            if (valorOperandoDireito instanceof Character)
            {
                return valorEsquerdo + ((Character) valorOperandoDireito);
            }
            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo + ((Integer) valorOperandoDireito);
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo + ((Double) valorOperandoDireito);
            }
            if (valorOperandoDireito instanceof Boolean)
            {
                return valorEsquerdo + (String) (((Boolean) valorOperandoDireito) ? "verdadeiro" : "falso");
            }
        }
        else
        {
            if (valorOperandoEsquerdo instanceof Character)
            {
                char valorEsquerdo = (Character) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof String)
                {
                    return valorEsquerdo + ((String) valorOperandoDireito);
                }
                if (valorOperandoDireito instanceof Character)
                {
                    return valorEsquerdo + (((Character) valorOperandoDireito).toString());
                }
            }
            else
            {
                if (valorOperandoEsquerdo instanceof Integer)
                {
                    int valorEsquerdo = (Integer) valorOperandoEsquerdo;

                    if (valorOperandoDireito instanceof String)
                    {
                        return valorEsquerdo + ((String) valorOperandoDireito);
                    }
                    if (valorOperandoDireito instanceof Integer)
                    {
                        return valorEsquerdo + ((Integer) valorOperandoDireito);
                    }
                    if (valorOperandoDireito instanceof Double)
                    {
                        return valorEsquerdo + ((Double) valorOperandoDireito);
                    }
                }
                else
                {
                    if (valorOperandoEsquerdo instanceof Double)
                    {
                        double valorEsquerdo = (Double) valorOperandoEsquerdo;

                        if (valorOperandoDireito instanceof String)
                        {
                            return valorEsquerdo + ((String) valorOperandoDireito);
                        }
                        if (valorOperandoDireito instanceof Integer)
                        {
                            return valorEsquerdo + ((Integer) valorOperandoDireito);
                        }
                        if (valorOperandoDireito instanceof Double)
                        {
                            return valorEsquerdo + ((Double) valorOperandoDireito);
                        }
                    }
                    else
                    {
                        if (valorOperandoEsquerdo instanceof Boolean)
                        {
                            boolean valorEsquerdo = (Boolean) valorOperandoEsquerdo;

                            if (valorOperandoDireito instanceof String)
                            {
                                return (String) ((valorEsquerdo) ? "verdadeiro" : "falso") + (String) valorOperandoDireito;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    private Object obterValorOperacaoSomaAtribuitiva(NoOperacao operacao) throws ExcecaoVisitaASA
    {
        NoOperacao soma = new NoOperacao(Operacao.SOMA, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), soma);

        return obterValorOperacaoAtribuicao(atribuicao);
    }

    private Object obterValorOperacaoSubtracao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)
            {
                return valorEsquerdo - ((Integer) valorOperandoDireito);
            }
            if (valorOperandoDireito instanceof Double)
            {
                return valorEsquerdo - ((Double) valorOperandoDireito);
            }
        }
        else
        {
            if (valorOperandoEsquerdo instanceof Double)
            {
                double leftValue = (Double) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Integer)
                {
                    return leftValue - ((Integer) valorOperandoDireito);
                }
                if (valorOperandoDireito instanceof Double)
                {
                    return leftValue - ((Double) valorOperandoDireito);
                }
            }
        }

        return null;
    }

    private Object obterValorOperacaoSubtracaoAtribuitiva(NoOperacao operacao ) throws ExcecaoVisitaASA
    {
        NoOperacao subtracao = new NoOperacao(Operacao.SUBTRACAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), subtracao);

        return obterValorOperacaoAtribuicao(atribuicao);
    }
    
    private Object atribuirValorVariavel(Variavel variavel, Object valor)
    {
        Variavel variable = (Variavel) variavel;
        variable.setValor(valor);

        return valor;
    }

    private Object atribuirValorVetor(Vetor vetor, Object valor, NoReferenciaVetor referenciaVetor) throws ExcecaoVisitaASA
    {
        int indice = (Integer) referenciaVetor.getIndice().aceitar(this);
        vetor.setValor(indice, valor);

        return valor;
    }

    private Object atribuirValorMatriz(Matriz matriz, Object valor, NoReferenciaMatriz referenciaMatriz) throws ExcecaoVisitaASA
    {
        int linha = (Integer) referenciaMatriz.getLinha().aceitar(this);
        int coluna = (Integer) referenciaMatriz.getColuna().aceitar(this);
        matriz.setValor(linha, coluna, valor);

        return valor;
    }
    

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
         Object valorRetorno = null;
         
        tabelaSimbolosLocal.peek().empilharEscopo();
        noPara.getInicializacao().aceitar(this);
        NoExpressao condicao = noPara.getCondicao();
        try {
            while ((condicao != null) ? (Boolean) condicao.aceitar(this) : true)
            {
                if ((valorRetorno = interpretarListaBlocos(noPara.getBlocos())) != null)
                {
                    break;
                }

                noPara.getIncremento().aceitar(this);
            }
        } catch (PareException pe) {
            
        } finally {
            tabelaSimbolosLocal.peek().desempilharEscopo();
        }
        
        return valorRetorno;
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        throw new PareException();
    }
    
    private class PareException extends RuntimeException {
        
    }   

    @Override
    public Object visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReal noReal) throws ExcecaoVisitaASA
    {
        return noReal.getValor();
    }

    @Override
    public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
    {
        int linha = (Integer) noReferenciaMatriz.getLinha().aceitar(this);
        int coluna = (Integer) noReferenciaMatriz.getColuna().aceitar(this);
        String nome = noReferenciaMatriz.getNome();
        Matriz matriz = (Matriz) extrairSimbolo(obterSimbolo(nome));
        
        return matriz.getValor(linha, coluna);
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        Simbolo simbolo = obterSimbolo(noReferenciaVariavel.getNome());
        if (referencia) 
        {
            return  simbolo;
        } else {
            if (chamaFuncao) {
                if (simbolo instanceof Vetor) {
                    return ((Vetor)simbolo).obterValores();
                } else if (simbolo instanceof Matriz) {
                    return ((Matriz)simbolo).obterValores();
                }
            }
            
            return ((Variavel)simbolo).getValor();
        }
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        Vetor vetor = (Vetor) obterSimbolo(noReferenciaVetor.getNome());
        int indice = (Integer) noReferenciaVetor.getIndice().aceitar(this);

        try
        {
            return vetor.getValor(indice);
        }
        catch (ArrayIndexOutOfBoundsException aioobe)
        {
            throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, vetor.getNome()),null,noReferenciaVetor);
        }
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        throw new RetorneException(noRetorne.getExpressao().aceitar(this));
    }
    
    private class RetorneException extends RuntimeException {
        private Object valor;

        public RetorneException(Object valor)
        {
            this.valor = valor;
        }

        public Object getValor()
        {
            return valor;
        }
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        boolean condicao = (Boolean) noSe.getCondicao().aceitar(this);

        List<NoBloco> blocos = (condicao) ? noSe.getBlocosVerdadeiros() : noSe.getBlocosFalsos();
        
        Object valorRetorno = interpretarListaBlocos(blocos);

        return valorRetorno;
    }

    @Override
    public Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA
    {
        List<Object> valoresVetor = noVetor.getValores();
        List<Object> valores = new ArrayList<Object>(noVetor.getValores().size());

        if (valores != null)
        {
            for (int i = 0; i < valoresVetor.size(); i++)
            {
                try
                {
                    valores.add(((NoExpressao) valoresVetor.get(i)).aceitar(this));
                }
                catch (ArrayIndexOutOfBoundsException aioobe)
                {
                    throw new ExcecaoVisitaASA( new ErroIndiceVetorInvalido(valores.size(), i, ultimaReferenciaAcessada), null, noVetor);
                }
            }
        }

        return valores;
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        Simbolo simbolo = null;
        switch (noDeclaracaoParametro.getModoAcesso()) {                        
            case POR_REFERENCIA:
                simbolo = new Ponteiro(noDeclaracaoParametro.getNome(), null);
                break;
            case POR_VALOR:                           
                String nome = noDeclaracaoParametro.getNome();
                Quantificador quantificador = noDeclaracaoParametro.getQuantificador();
                TipoDado tipoDado = noDeclaracaoParametro.getTipoDado();
                switch (quantificador) {
                    case VALOR:
                    {
                        simbolo = new Variavel(nome, tipoDado, tipoDado.getValorPadrao());
                        break;
                    }
                    case VETOR:
                    {
                        simbolo = new Vetor(nome, tipoDado, (List<Object>) tipoDado.getValorPadrao());
                        break;
                    }
                    case MATRIZ:
                    {
                        simbolo = new Matriz(nome, tipoDado, (List<List<Object>>) tipoDado.getValorPadrao());                        
                        break;
                    }
                }
                break;    
        }
        tabelaSimbolosLocal.peek().adicionar(simbolo);
        return simbolo;
    }
    
    
    
    
    private void escreva(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA, Exception
    {
        List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();

        for (NoExpressao expressao : listaParametrosPassados)
        {
            if (saida != null)
            {
                Object valor = expressao.aceitar(this);
                if (valor instanceof String)
                {
                    if (valor.equals("${show developers}"))
                    {
                        valor = "\n\nDesenvolvedores:\n\nFillipi Domingos Pelz\nLuiz Fernando Noschang\n\n";
                    }
                    
                    saida.escrever((String) valor);
                }
                else
                {
                    if (valor instanceof Boolean)
                    {
                        saida.escrever((Boolean) valor);
                    }
                    else
                    {
                        if (valor instanceof Character)
                        {
                            saida.escrever((Character) valor);
                        }
                        else
                        {
                            if (valor instanceof Double)
                            {
                                saida.escrever((Double) valor);
                            }
                            else
                            {
                                if (valor instanceof Integer)
                                {
                                    saida.escrever((Integer) valor);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void leia(NoChamadaFuncao chamadaFuncao) throws Exception
    {
        List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();

        for (NoExpressao expressao : listaParametrosPassados)
        {
            if (expressao instanceof NoReferencia)
            {
                NoReferencia referencia = (NoReferencia) expressao;

                String nome = referencia.getNome();

                Simbolo simbolo = extrairSimbolo(obterSimbolo(nome));
                TipoDado tipoDado = simbolo.getTipoDado();
                Object valor = null;

                if (entrada != null)
                {
                    valor = entrada.ler(tipoDado);

                    if (valor == null)
                    {
                        valor = tipoDado.getValorPadrao();
                    }
                }

                if (simbolo instanceof Variavel)
                {
                    atribuirValorVariavel((Variavel) simbolo, valor);
                }
                else
                {
                    if (simbolo instanceof Vetor)
                    {
                        atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) referencia);
                    }
                    else
                    {
                        if (simbolo instanceof Matriz)
                        {
                            atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) referencia);
                        }
                    }
                }
            }
        }
    }
    
    
    
}
