/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

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
import br.univali.portugol.nucleo.execucao.erros.ErroIndiceVetorInvalido;
import br.univali.portugol.nucleo.simbolos.Funcao;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Ponteiro;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.TabelaSimbolos;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fillipi
 */
public class Depurador implements VisitanteASA
{
    
    
    private String ultimaReferenciaAcessada;

    private TabelaSimbolos tabelaSimbolosGlobal;
    
    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
        tabelaSimbolosGlobal = new TabelaSimbolos();
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
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        Funcao funcao = null;// chamadaFuncao.getNome();
        
        TabelaSimbolos tabelaSimbolosFuncao = new TabelaSimbolos();

        List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();
        List<NoDeclaracaoParametro> listaParametrosEsperados = funcao.getParametros();

        for (int i = 0; i < listaParametrosEsperados.size(); i++)
        {
            NoExpressao parametroPassado = listaParametrosPassados.get(i);
            NoDeclaracaoParametro parametroEsperado = listaParametrosEsperados.get(i);

            switch (parametroEsperado.getModoAcesso())
            {
                case POR_VALOR:
                    passarParametroFuncaoPorValor(parametroPassado, parametroEsperado, tabelaSimbolosFuncao);
                    break;
                case POR_REFERENCIA:
                    passarParametroFuncaoPorReferencia(parametroPassado, parametroEsperado, tabelaSimbolosFuncao);
                    break;
            }
        }

        return interpretarListaBlocos(funcao.getBlocos());
    }

     private void passarParametroFuncaoPorReferencia(NoExpressao parametroPassado, NoDeclaracaoParametro parametroEsperado, TabelaSimbolos tabelaSimbolosFuncao)
    {
        NoReferencia referencia = (NoReferencia) parametroPassado;
        String nome = referencia.getNome();
        Simbolo simbolo =null;// obterSimbolo(nome, tabelaSimbolos);

        tabelaSimbolosFuncao.adicionar(new Ponteiro(parametroEsperado.getNome(), simbolo));
    }
    
     @SuppressWarnings("unchecked")
    private void passarParametroFuncaoPorValor(NoExpressao parametroPassado, NoDeclaracaoParametro parametroEsperado, TabelaSimbolos tabelaSimbolosFuncao) throws ExcecaoVisitaASA
    {
        String nome = parametroEsperado.getNome();

        if (parametroPassado instanceof NoReferenciaVariavel)
        {
            NoReferenciaVariavel referencia = (NoReferenciaVariavel) parametroPassado;
            Simbolo simbolo = null;//extrairSimbolo(obterSimbolo(referencia.getNome(), tabelaSimbolos));
            tabelaSimbolosFuncao.adicionar(simbolo.copiar(nome));
        }
        else
        {
            Quantificador quantificador = parametroEsperado.getQuantificador();
            TipoDado tipoDado = parametroEsperado.getTipoDado();
            Object valor = parametroPassado.aceitar(this);

            if (quantificador == Quantificador.VALOR)
            {
                tabelaSimbolosFuncao.adicionar(new Variavel(nome, tipoDado, valor));
            }
            else
            {
                if (quantificador == Quantificador.VETOR)
                {
                    tabelaSimbolosFuncao.adicionar(new Vetor(nome, tipoDado, (List<Object>) valor));
                }
                else
                {
                    if (quantificador == Quantificador.MATRIZ)
                    {
                        //tabelaSimbolos.adicionar(new Matriz(nome, tipoDado, (List<List<Object>>) valor));
  
                    }
                }
            }
        }
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
        
        return funcao;
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
        
        return matriz;
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
        
        return variavel;
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

        return vetor;
    }

    @Override
    public Object visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA
    {
        return new NoOperacao(Operacao.SUBTRACAO_ACUMULATIVA, noDecremento.getExpressao(), new NoInteiro(1)).aceitar(this);
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        while ((Boolean) noEnquanto.getCondicao().aceitar(this))
        {
            //tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(noEnquanto.getBlocos());
            //tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null)
            {
                return (valorRetorno instanceof NoPare) ? null : valorRetorno;
            }
        }

        return null;
    }
    
    private Object interpretarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {
        for (NoBloco noBloco : blocos)
        {
            Object valor = noBloco.aceitar(this);
            if (valor != null)
            {
                return valor;
            }
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
            for (int i = indiceValorEscolhido; i < casos.size(); i++)
            {
                //tabelaSimbolos.empilharEscopo();
                Object valorRetorno = interpretarListaBlocos(casos.get(i).getBlocos());
                //tabelaSimbolos.desempilharEscopo();

                if (valorRetorno != null)
                {
                    return (valorRetorno instanceof NoPare) ? null : valorRetorno;
                }
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
        do
        {
            //tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(noFacaEnquanto.getBlocos());
            //tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null)
            {
                return (valorRetorno instanceof NoPare) ? null : valorRetorno;
            }
        }
        while ((Boolean) noFacaEnquanto.getCondicao().aceitar(this));

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
        Simbolo simbolo = null;//extrairSimbolo(obterSimbolo(nome, null));
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
         
        //tabelaSimbolos.empilharEscopo();
        noPara.getInicializacao().aceitar(this);
        NoExpressao condicao = noPara.getCondicao();

        while ((condicao != null) ? (Boolean) condicao.aceitar(this) : true)
        {
            if ((valorRetorno = interpretarListaBlocos(noPara.getBlocos())) != null)
            {
                break;
            }

            noPara.getIncremento().aceitar(this);
        }

        //tabelaSimbolos.desempilharEscopo();

        return (valorRetorno instanceof NoPare) ? null : valorRetorno;
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        return noPare;
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

        Matriz matriz = null;// = extrairSimbolo(obterSimbolo(nome, tabelaSimbolos));
        
        return matriz.getValor(linha, coluna);
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        Variavel variavel = null; //noReferenciaVariavel.getNome();
        return variavel.getValor();
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        
        Vetor vetor = null; //noReferenciaVetor.getNome()));
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
        return noRetorne.getExpressao().aceitar(this);
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        boolean condicao = (Boolean) noSe.getCondicao().aceitar(this);

        List<NoBloco> blocos = (condicao) ? noSe.getBlocosVerdadeiros() : noSe.getBlocosFalsos();

        //tabelaSimbolos.empilharEscopo();
        Object valorRetorno = interpretarListaBlocos(blocos);//, tabelaSimbolos);
        //tabelaSimbolos.desempilharEscopo();

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
                    valores.add(((NoExpressao) valoresVetor.get(i)).aceitar(this));//, tabelaSimbolos));
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
