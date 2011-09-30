package br.univali.portugol.nucleo.execucao;

import java.util.ArrayList;
import java.util.List;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.execucao.erros.ErroFuncaoInicialNaoDeclarada;
import br.univali.portugol.nucleo.simbolos.*;


public class Interpretador
{
    public static final String funcaoInicialPadrao = "inicio";
    private Saida saida;
    private Entrada entrada;
    private String funcaoInicial = funcaoInicialPadrao;
    private TabelaSimbolos tabelaSimbolosGlobal;
    
    public void setEntrada(Entrada entrada)
    {
        this.entrada = entrada;
    }

    public void setSaida(Saida saida)
    {
        this.saida = saida;
    }

    public Entrada getEntrada() 
    {
        return entrada;
    }

    public Saida getSaida() 
    {
        return saida;
    }

    public void setFuncaoInicial(String funcaoInicial) 
    {
        this.funcaoInicial = funcaoInicial;
    }
    
    public void interpretar(ArvoreSintaticaAbstrataPrograma arvoreSintaticaAbstrata, String[] parametros) throws ErroFuncaoInicialNaoDeclarada, InterruptedException
    {
        this.tabelaSimbolosGlobal = new TabelaSimbolos();

        interpretarListaDeclaracoesGlobais(arvoreSintaticaAbstrata.getListaDeclaracoesGlobais());
        interpretarFuncaoPrincipal(parametros);
    }

    private void interpretarListaDeclaracoesGlobais(List<NoDeclaracao> listaDeclaracoesGlobais) throws InterruptedException
    {
        if (listaDeclaracoesGlobais != null)
        {
            for (NoDeclaracao declaracao: listaDeclaracoesGlobais)
                interpretarDeclaracao(declaracao, tabelaSimbolosGlobal);
        }
    }

    private void interpretarDeclaracao(NoDeclaracao declaracao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        if (declaracao instanceof NoDeclaracaoVariavel)
            declararVariavel((NoDeclaracaoVariavel) declaracao, tabelaSimbolos);

        else

        if (declaracao instanceof NoDeclaracaoVetor)
            declararVetor((NoDeclaracaoVetor) declaracao, tabelaSimbolos);

        else

        if (declaracao instanceof NoDeclaracaoMatriz)
            declararMatriz((NoDeclaracaoMatriz) declaracao, tabelaSimbolos);

        else

        if (declaracao instanceof NoDeclaracaoFuncao)
            declararFuncao((NoDeclaracaoFuncao) declaracao, tabelaSimbolos);
    }

    private void declararVariavel(NoDeclaracaoVariavel declaracaoVariavel, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        String nome = declaracaoVariavel.getNome();
        TipoDado tipoDado = declaracaoVariavel.getTipoDado();

        Variavel variavel = new Variavel(nome, tipoDado);
        variavel.setConstante(declaracaoVariavel.constante());

        if (declaracaoVariavel.getInicializacao() != null)
        {
            Object valor = obterValorExpressao(declaracaoVariavel.getInicializacao(), tabelaSimbolos);

            if ((valor instanceof Double) && (tipoDado == TipoDado.INTEIRO))
            {
                double val = (Double) valor;
                valor = (int) val;
            }

            variavel.setValor(valor);
        }

        tabelaSimbolos.adicionar(variavel);
    }

    private void declararVetor(NoDeclaracaoVetor declaracaoVetor, TabelaSimbolos tabelaSimbolos)
    {
        String nome = declaracaoVetor.getNome();
        TipoDado tipoDado = declaracaoVetor.getTipoDado();

        int tamanho = obterTamanhoVetor(declaracaoVetor, tabelaSimbolos);
        List<Object> valores = obterValoresVetor(declaracaoVetor, tabelaSimbolos);

        Vetor vetor = null;

        if (tamanho == 0) vetor = new Vetor(nome, tipoDado, valores);
        else vetor = new Vetor(nome, tipoDado, tamanho, valores);

        vetor.setConstante(declaracaoVetor.constante());

        tabelaSimbolos.adicionar(vetor);
    }

    private void limpar() throws InterruptedException 
    {
        if (saida != null)
        {
            saida.limpar();
        }            
    }

    private int obterTamanhoVetor(NoDeclaracaoVetor declaracaoVetor, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            return (Integer) obterValorExpressao(declaracaoVetor.getTamanho(), tabelaSimbolos);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    private List<Object> obterValoresVetor(NoDeclaracaoVetor declaracaoVetor, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            return (List<Object>) obterValorExpressao(declaracaoVetor.getInicializacao(), tabelaSimbolos);
        }
        catch (Exception e)
        {
            return new ArrayList<Object>();
        }
    }

    private void declararMatriz(NoDeclaracaoMatriz declaracaoMatriz, TabelaSimbolos tabelaSimbolos)
    {
        String nome = declaracaoMatriz.getNome();
        TipoDado tipoDado = declaracaoMatriz.getTipoDado();

        int numeroLinhas = obterNumeroLinhas(declaracaoMatriz, tabelaSimbolos);
        int numeroColunas = obterNumeroColunas(declaracaoMatriz, tabelaSimbolos);
        List<List<Object>> valores = obterValoresMatriz(declaracaoMatriz, tabelaSimbolos);

        Matriz matriz;

        if (numeroLinhas == 0) matriz = new Matriz(nome, tipoDado, valores);
        else matriz = new Matriz(nome, tipoDado, numeroLinhas, numeroColunas, valores);

        matriz.setConstante(declaracaoMatriz.constante());

        tabelaSimbolos.adicionar(matriz);
    }

    private int obterNumeroLinhas(NoDeclaracaoMatriz declaracaoMatriz,TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            return (Integer) obterValorExpressao(declaracaoMatriz.getNumeroLinhas(), tabelaSimbolos);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    private int obterNumeroColunas(NoDeclaracaoMatriz declaracaoMatriz, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            return (Integer) obterValorExpressao(declaracaoMatriz.getNumeroColunas(), tabelaSimbolos);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    private List<List<Object>> obterValoresMatriz(NoDeclaracaoMatriz declaracaoMatriz, TabelaSimbolos tabelaSimbolos)
    {
        try
        {
            return (List<List<Object>>) obterValorExpressao(declaracaoMatriz.getInicializacao(), tabelaSimbolos);
        }
        catch (Exception e)
        {
            return new ArrayList<List<Object>>();
        }
    }

    private void declararFuncao(NoDeclaracaoFuncao declaracaoFuncao, TabelaSimbolos tabelaSimbolos)
    {
        String nome = declaracaoFuncao.getNome();
        TipoDado tipoDados = declaracaoFuncao.getTipoDado();
        Quantificador quantificador = declaracaoFuncao.getQuantificador();

        List<NoParametro> parametros = declaracaoFuncao.getParametros();
        List<NoBloco> blocos = declaracaoFuncao.getBlocos();

        tabelaSimbolos.adicionar(new Funcao(nome, tipoDados, quantificador, parametros, blocos));
    }

    private void interpretarFuncaoPrincipal(String[] parametros) throws ErroFuncaoInicialNaoDeclarada, InterruptedException
    {
        if (tabelaSimbolosGlobal.contem(funcaoInicial))
        {
            Funcao funcaoPrincipal = (Funcao) tabelaSimbolosGlobal.obter(funcaoInicial);
            TabelaSimbolos tabelaSimbolosFuncaoPrincipal = new TabelaSimbolos();

            if (funcaoPrincipal.getParametros().size() > 0)
            {
                List<Object> listaParametros = converterVetorEmLista(parametros);
                tabelaSimbolosFuncaoPrincipal.adicionar(new Vetor(funcaoPrincipal.getParametros().get(0).getNome(), TipoDado.CADEIA, listaParametros.size(), listaParametros));
            }

            interpretarListaBlocos(funcaoPrincipal.getBlocos(), tabelaSimbolosFuncaoPrincipal);
        }

        else throw new ErroFuncaoInicialNaoDeclarada(funcaoInicial);
    }

    private List<Object> converterVetorEmLista(Object[] vetor)
    {
        List<Object> lista = new ArrayList<Object>();

        if (vetor != null)
        {
            for (int i = 0; i < vetor.length; i++)
                lista.add(vetor[i]);
        }

        return lista;
    }

    private Object interpretarListaBlocos(List<NoBloco> blocos, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        if (blocos != null)
        {
            Object valor = null;

            for (NoBloco bloco: blocos)
            {
                if ((valor = interpretarBloco(bloco, tabelaSimbolos)) != null)
                    return valor;
            }
        }

        return null;
    }

    private Object interpretarBloco(NoBloco bloco, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        if (bloco != null)
        {
            if (bloco instanceof NoPara)
                return interpretarBlocoPara((NoPara) bloco, tabelaSimbolos);

            if (bloco instanceof NoSe)
                return interpretarBlocoSe((NoSe) bloco, tabelaSimbolos);

            if (bloco instanceof NoEnquanto)
                return interpretarBlocoEnquanto((NoEnquanto) bloco, tabelaSimbolos);

            if (bloco instanceof NoRetorne)
                return obterValorExpressao(((NoRetorne) bloco).getExpressao(), tabelaSimbolos);

            if (bloco instanceof NoPare)
                return bloco;

            if (bloco instanceof NoFacaEnquanto)
                return interpretarBlocoFacaEnquanto((NoFacaEnquanto) bloco, tabelaSimbolos);

            if (bloco instanceof NoEscolha)
                return interpretarBlocoEscolha((NoEscolha) bloco, tabelaSimbolos);

            if (bloco instanceof NoDeclaracao)
                interpretarDeclaracao((NoDeclaracao) bloco, tabelaSimbolos);

            else

            if (bloco instanceof NoExpressao)
                obterValorExpressao((NoExpressao) bloco, tabelaSimbolos);
        }

        return null;
    }

    private Object interpretarBlocoPara(NoPara blocoPara, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        Object valorRetorno = null;
        tabelaSimbolos.empilharEscopo();

        interpretarBloco(blocoPara.getInicializacao(), tabelaSimbolos);
        NoExpressao condicao = blocoPara.getCondicao();

        while ((condicao != null)? (Boolean) obterValorExpressao(condicao, tabelaSimbolos) : true)
        {
            if ((valorRetorno = interpretarListaBlocos(blocoPara.getBlocos(), tabelaSimbolos)) != null)
                break;

            obterValorExpressao(blocoPara.getIncremento(), tabelaSimbolos);
        }

        tabelaSimbolos.desempilharEscopo();

        return (valorRetorno instanceof NoPare)? null : valorRetorno;
    }

    private Object interpretarBlocoEscolha(NoEscolha blocoEscolha, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        List<NoCaso> casos = blocoEscolha.getCasos();
        Object valorEscolha = obterValorExpressao(blocoEscolha.getExpressao(), tabelaSimbolos);

        int indiceValorEscolhido = procurarIndiceValorEscolhido(valorEscolha, casos, tabelaSimbolos);

        if (indiceValorEscolhido >= 0)
        {
            for (int i = indiceValorEscolhido; i < casos.size(); i++)
            {
                tabelaSimbolos.empilharEscopo();
                Object valorRetorno = interpretarListaBlocos(casos.get(i).getBlocos(), tabelaSimbolos);
                tabelaSimbolos.desempilharEscopo();

                if (valorRetorno != null) return (valorRetorno instanceof NoPare)? null : valorRetorno;
            }
        }

        return null;
    }

    private int procurarIndiceValorEscolhido(Object valorEscolha, List<NoCaso> casos, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        Object[] valoresCasos = obterValoresCasos(casos, tabelaSimbolos);

        for (int i = 0; i < valoresCasos.length; i++)
        {
            if (valoresCasos[i] == valorEscolha)
                return i;
        }

        for (int i = 0; i < valoresCasos.length; i++)
        {
            if (valoresCasos[i] == null)
                return i;
        }

        return -1;
    }

    private Object[] obterValoresCasos(List<NoCaso> casos, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        Object[] valores = new Object[casos.size()];

        for (int i = 0; i < casos.size(); i++)
            valores[i] = obterValorExpressao(casos.get(i).getExpressao(), tabelaSimbolos);

        return valores;
    }

    private Object interpretarBlocoFacaEnquanto(NoFacaEnquanto blocoFacaEnquanto, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        do
        {
            tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(blocoFacaEnquanto.getBlocos(), tabelaSimbolos);
            tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null) return (valorRetorno instanceof NoPare)? null: valorRetorno;
        }
        while ((Boolean) obterValorExpressao(blocoFacaEnquanto.getCondicao(), tabelaSimbolos));

        return null;
    }

    private Object interpretarBlocoEnquanto(NoEnquanto blocoEnquanto, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        while ((Boolean) obterValorExpressao(blocoEnquanto.getCondicao(), tabelaSimbolos))
        {
            tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(blocoEnquanto.getBlocos(), tabelaSimbolos);
            tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null) return (valorRetorno instanceof NoPare)? null : valorRetorno;
        }

        return null;
    }

    private Object interpretarBlocoSe(NoSe blocoSe, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        boolean condicao = (Boolean) obterValorExpressao(blocoSe.getCondicao(), tabelaSimbolos);

        List<NoBloco> blocos = (condicao)? blocoSe.getBlocosVerdadeiros() : blocoSe.getBlocosFalsos();

        tabelaSimbolos.empilharEscopo();
        Object valorRetorno = interpretarListaBlocos(blocos, tabelaSimbolos);
        tabelaSimbolos.desempilharEscopo();

        return valorRetorno;
    }

    private Object obterValorExpressao(NoExpressao expressao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        if (expressao instanceof NoInteiro)         return ((NoInteiro)     expressao).getValor();
        if (expressao instanceof NoReal)            return ((NoReal)        expressao).getValor();
        if (expressao instanceof NoCadeia)          return ((NoCadeia)      expressao).getValor();
        if (expressao instanceof NoCaracter)        return ((NoCaracter)    expressao).getValor();
        if (expressao instanceof NoLogico)          return ((NoLogico)      expressao).getValor();

        if (expressao instanceof NoVetor)           return obterValoresVetor        ((NoVetor)          expressao, tabelaSimbolos);
        if (expressao instanceof NoMatriz)          return obterValoresMatriz       ((NoMatriz)         expressao, tabelaSimbolos);
        if (expressao instanceof NoNao)             return obterValorNao            ((NoNao)            expressao, tabelaSimbolos);
        if (expressao instanceof NoMenosUnario)     return obterValorMenosUnario    ((NoMenosUnario)    expressao, tabelaSimbolos);
        if (expressao instanceof NoReferencia)      return obterValorReferencia     ((NoReferencia)     expressao, tabelaSimbolos);
        if (expressao instanceof NoOperacao)        return obterValorOperacao       ((NoOperacao)       expressao, tabelaSimbolos);
        if (expressao instanceof NoIncremento)      return obterValorIncremento     ((NoIncremento)     expressao, tabelaSimbolos);
        if (expressao instanceof NoDecremento)      return obterValorDecremento     ((NoDecremento)     expressao, tabelaSimbolos);

        return null;
    }

    private Object obterValorDecremento(NoDecremento decremento, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        return obterValorOperacao(new NoOperacao(Operacao.SUBTRACAO_ACUMULATIVA, decremento.getExpressao(), new NoInteiro(1)), tabelaSimbolos);
    }

    private Object obterValorIncremento(NoIncremento incremento, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        return obterValorOperacao(new NoOperacao(Operacao.SOMA_ACUMULATIVA, incremento.getExpressao(), new NoInteiro(1)), tabelaSimbolos);
    }

    private List<List<Object>> obterValoresMatriz(NoMatriz matriz, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        List<List<Object>> valores = matriz.getValores();

        if (valores != null)
        {
            int linhas = valores.size();

            for (int i = 0; i < linhas; i++)
            {
                List<Object> vetor = valores.get(i);

                int colunas = (vetor == null)? 0 : vetor.size();

                for (int j = 0; j < colunas; j++)
                    vetor.set(j, obterValorExpressao((NoExpressao)vetor.get(j), tabelaSimbolos));
            }
        }

        return valores;
    }

    private List<Object> obterValoresVetor(NoVetor vetor, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        List<Object> valores = vetor.getValores();

        if (valores != null)
        {
            for (int i = 0; i < valores.size(); i++)
                valores.set(i, obterValorExpressao((NoExpressao) valores.get(i), tabelaSimbolos));
        }

        return valores;
    }

    private Object obterValorNao(NoNao nao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        return ! (Boolean) obterValorExpressao(nao.getExpressao(), tabelaSimbolos);
    }

    private Object obterValorMenosUnario(NoMenosUnario menosUnario, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        Object valor = obterValorExpressao(menosUnario.getExpressao(), tabelaSimbolos);

        if (valor instanceof Double     ) 	return - ((Double) 	valor);
        if (valor instanceof Integer    ) 	return - ((Integer) 	valor);
        if (valor instanceof Character  ) 	return - ((Character) 	valor);

        return null;
    }

    private Object obterValorOperacao(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        switch (operacao.getOperacao())
        {
            case ATRIBUICAO: return obterValorOperacaoAtribuicao(operacao, tabelaSimbolos);
            case DIVISAO_ACUMULATIVA: return obterValorOperacaoDivisaoAtribuitiva(operacao, tabelaSimbolos);
            case SUBTRACAO_ACUMULATIVA: return obterValorOperacaoSubtracaoAtribuitiva(operacao, tabelaSimbolos);
            case SOMA_ACUMULATIVA: return obterValorOperacaoSomaAtribuitiva(operacao, tabelaSimbolos);
            case MULTIPLICACAO_ACUMULATIVA: return obterValorOperacaoMultiplicacaoAtribuitiva(operacao, tabelaSimbolos);
            case MODULO_ATRIBUITIVO: return obterValorOperacaoModuloAtribuitivo(operacao, tabelaSimbolos);
        }

        Object valorOperandoEsquerdo = obterValorExpressao(operacao.getOperandoEsquerdo(), tabelaSimbolos);
        Object valorOperandoDireito = obterValorExpressao(operacao.getOperandoDireito(), tabelaSimbolos);

        switch (operacao.getOperacao())
        {
            case DIFERENCA: return obterValorOperacaoDiferenca(valorOperandoEsquerdo, valorOperandoDireito);
            case DIVISAO: return obterValorOperacaoDivisao(valorOperandoEsquerdo, valorOperandoDireito);
            case E: return obterValorOperacaoE(valorOperandoEsquerdo, valorOperandoDireito);
            case IGUALDADE: return obterValorOperacaoIgualdade(valorOperandoEsquerdo, valorOperandoDireito);
            case MAIOR: return obterValorOperacaoMaior(valorOperandoEsquerdo, valorOperandoDireito);
            case MAIOR_IGUAL: return obterValorOperacaoMaiorIgual(valorOperandoEsquerdo, valorOperandoDireito);
            case MENOR: return obterValorOperacaoMenor(valorOperandoEsquerdo, valorOperandoDireito);
            case MENOR_IGUAL: return obterValorOperacaoMenorIgual(valorOperandoEsquerdo, valorOperandoDireito);
            case MODULO: return obterValorOperacaoModulo(valorOperandoEsquerdo, valorOperandoDireito);
            case MULTIPLICACAO: return obterValorOperacaoMultiplicacao(valorOperandoEsquerdo, valorOperandoDireito);
            case OU: return obterValorOperacaoOu(valorOperandoEsquerdo, valorOperandoDireito);
            case SOMA: return obterValorOperacaoSoma(valorOperandoEsquerdo, valorOperandoDireito);
            case SUBTRACAO: return obterValorOperacaoSubtracao(valorOperandoEsquerdo, valorOperandoDireito);
        }

        return null;
    }

    private Object obterValorOperacaoAtribuicao(NoOperacao atribuicao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoReferencia referencia = (NoReferencia) atribuicao.getOperandoEsquerdo();

        String nome = referencia.getNome();
        Simbolo simbolo = extrairSimbolo(obterSimbolo(nome, tabelaSimbolos));
        Object valor = obterValorExpressao(atribuicao.getOperandoDireito(), tabelaSimbolos);

        if ((valor instanceof Double) && (simbolo.getTipoDado() == TipoDado.INTEIRO))
        {
            double val = (Double) valor;
            valor = (int) val;
        }

        if (referencia instanceof NoReferenciaVariavel)
            return atribuirValorVariavel((Variavel) simbolo, valor);

        if (referencia instanceof NoReferenciaVetor)
            return atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) referencia, tabelaSimbolos);

        if (referencia instanceof NoReferenciaMatriz)
            return atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) referencia, tabelaSimbolos);

        return null;
    }

    private Object obterValorOperacaoDiferenca(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        return ! (Boolean) obterValorOperacaoIgualdade(valorOperandoEsquerdo, valorOperandoDireito);
    }

    private Object obterValorOperacaoDivisao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo / (Integer)    valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo / (Double)     valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo / (Integer)    valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo / (Double)     valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoDivisaoAtribuitiva(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoOperacao divisao = new NoOperacao(Operacao.DIVISAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), divisao);

        return obterValorOperacaoAtribuicao(atribuicao, tabelaSimbolos);
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

           if (valorOperandoDireito instanceof String) return valorEsquerdo.equals((String) valorOperandoDireito);
        }

        else

        if (valorOperandoEsquerdo instanceof Character)
        {
            char valorEsquerdo = (Character) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Character)  return valorEsquerdo == (Character) valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo == (Integer)   valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo == (Double)    valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo == (Integer)   valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo == (Double)    valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Boolean)
        {
            boolean valorEsquerdo = (Boolean) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Boolean) return valorEsquerdo == ((Boolean) valorOperandoDireito);
        }

        return false;
    }

    private Object obterValorOperacaoMaior(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
                int valorEsquerdo = (Integer) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Integer) return valorEsquerdo > (Integer) valorOperandoDireito;
                if (valorOperandoDireito instanceof Double) return valorEsquerdo > (Double) valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
                double valorEsquerdo = (Double) valorOperandoEsquerdo;

                if (valorOperandoDireito instanceof Integer) return valorEsquerdo > (Integer) valorOperandoDireito;
                if (valorOperandoDireito instanceof Double) return valorEsquerdo > (Double) valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoMaiorIgual(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo >= (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof  Double) return valorEsquerdo >= (Double) valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo >= (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof Double) return valorEsquerdo >= (Double) valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoMenor(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo < (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof Double) return valorEsquerdo < (Double) valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo < (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof Double) return valorEsquerdo < (Double) valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoMenorIgual(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo <= (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof Double) return valorEsquerdo <= (Double) valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return valorEsquerdo <= (Integer) valorOperandoDireito;
            if (valorOperandoDireito instanceof Double) return valorEsquerdo <= (Double) valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoModulo(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer) return (valorEsquerdo) % ((Integer) valorOperandoDireito);
        }

        return null;
    }

    private Object obterValorOperacaoModuloAtribuitivo(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoOperacao modulo = new NoOperacao(Operacao.MODULO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), modulo);

        return obterValorOperacaoAtribuicao(atribuicao, tabelaSimbolos);
    }

    private Object obterValorOperacaoMultiplicacao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo * (Integer)    valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo * (Double)     valorOperandoDireito;
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo * (Integer)    valorOperandoDireito;
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo * (Double)     valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoMultiplicacaoAtribuitiva(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoOperacao multiplicacao = new NoOperacao(Operacao.MULTIPLICACAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), multiplicacao);

        return obterValorOperacaoAtribuicao(atribuicao, tabelaSimbolos);
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

            if (valorOperandoDireito instanceof String)     return valorEsquerdo + ((String)            valorOperandoDireito);
            if (valorOperandoDireito instanceof Character)  return valorEsquerdo + ((Character)         valorOperandoDireito);
            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo + ((Integer)           valorOperandoDireito);
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo + ((Double)            valorOperandoDireito);
            if (valorOperandoDireito instanceof Boolean)    return valorEsquerdo + (String) (((Boolean) valorOperandoDireito)? "verdadeiro" : "falso");
        }

        else

        if (valorOperandoEsquerdo instanceof Character)
        {
            char valorEsquerdo = (Character) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof String)     return valorEsquerdo + ((String)    valorOperandoDireito);
            if (valorOperandoDireito instanceof Character)  return valorEsquerdo + (((Character) valorOperandoDireito).toString());
        }

        else

        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof String)     return valorEsquerdo + ((String)    valorOperandoDireito);
            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo + ((Integer)   valorOperandoDireito);
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo + ((Double)    valorOperandoDireito);
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double valorEsquerdo = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof String)     return valorEsquerdo + ((String)    valorOperandoDireito);
            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo + ((Integer)   valorOperandoDireito);
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo + ((Double)    valorOperandoDireito);
        }

        else

        if (valorOperandoEsquerdo instanceof Boolean)
        {
            boolean valorEsquerdo = (Boolean) valorOperandoEsquerdo;
            
            if (valorOperandoDireito instanceof String) return (String) ((valorEsquerdo) ? "verdadeiro" : "falso") + (String) valorOperandoDireito;
        }

        return null;
    }

    private Object obterValorOperacaoSomaAtribuitiva(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoOperacao soma = new NoOperacao(Operacao.SOMA, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), soma);

        return obterValorOperacaoAtribuicao(atribuicao, tabelaSimbolos);
    }

    private Object obterValorOperacaoSubtracao(Object valorOperandoEsquerdo, Object valorOperandoDireito)
    {
        if (valorOperandoEsquerdo instanceof Integer)
        {
            int valorEsquerdo = (Integer) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return valorEsquerdo - ((Integer)   valorOperandoDireito);
            if (valorOperandoDireito instanceof Double)     return valorEsquerdo - ((Double)    valorOperandoDireito);
        }

        else

        if (valorOperandoEsquerdo instanceof Double)
        {
            double leftValue = (Double) valorOperandoEsquerdo;

            if (valorOperandoDireito instanceof Integer)    return leftValue - ((Integer)   valorOperandoDireito);
            if (valorOperandoDireito instanceof Double)     return leftValue - ((Double)    valorOperandoDireito);
        }

        return null;
    }

    private Object obterValorOperacaoSubtracaoAtribuitiva(NoOperacao operacao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
        NoOperacao subtracao = new NoOperacao(Operacao.SUBTRACAO, operacao.getOperandoEsquerdo(), operacao.getOperandoDireito());
        NoOperacao atribuicao = new NoOperacao(Operacao.ATRIBUICAO, operacao.getOperandoEsquerdo(), subtracao);

        return obterValorOperacaoAtribuicao(atribuicao, tabelaSimbolos);
    }

    private Object atribuirValorVariavel(Variavel variavel, Object valor)
    {
            Variavel variable = (Variavel) variavel;
            variable.setValor(valor);

            return valor;
    }

    private Object atribuirValorVetor(Vetor vetor, Object valor, NoReferenciaVetor referenciaVetor, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            int indice = (Integer) obterValorExpressao(referenciaVetor.getIndice(), tabelaSimbolos);
            vetor.setValor(indice, valor);

            return valor;
    }

    private Object atribuirValorMatriz(Matriz matriz, Object valor, NoReferenciaMatriz referenciaMatriz, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            int linha = (Integer) obterValorExpressao(referenciaMatriz.getLinha(), tabelaSimbolos);
            int coluna = (Integer) obterValorExpressao(referenciaMatriz.getColuna(), tabelaSimbolos);
            matriz.setValor(linha, coluna, valor);

            return valor;
    }
    
    private Object obterValorReferencia(NoReferencia referencia, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            String nome = referencia.getNome();
            Simbolo simbolo = extrairSimbolo(obterSimbolo(nome, tabelaSimbolos));

            if (referencia instanceof NoReferenciaVariavel)
                    return obterValorVariavel((Variavel) simbolo);

            if (referencia instanceof NoReferenciaVetor)
                    return obterValorVetor((Vetor) simbolo, (NoReferenciaVetor) referencia, tabelaSimbolos);

            if (referencia instanceof NoReferenciaMatriz)
                    return obterValorMatriz((Matriz) simbolo, (NoReferenciaMatriz) referencia, tabelaSimbolos);

            if (referencia instanceof NoChamadaFuncao)
            {
                    if (referencia.getNome().equals("escreva"))
                            escreva((NoChamadaFuncao) referencia, tabelaSimbolos);

                    else

                    if (referencia.getNome().equals("leia"))
                            leia((NoChamadaFuncao) referencia, tabelaSimbolos);

                    else

                    if (referencia.getNome().equals("limpar"))
                    {
                        limpar();
                    }
                    
                    else
                        
                    if (referencia.getNome().equals("aguarde"))
                    {
                        aguardar((NoChamadaFuncao) referencia, tabelaSimbolos);
                    }
                    else

                    if (simbolo instanceof Funcao)
                            return obterValorFuncao((Funcao) simbolo, (NoChamadaFuncao) referencia, tabelaSimbolos);
                    /*
                    else

                    if (simbolo instanceof FuncaoCompilada)
                            return obterValorFuncaoCompilada((FuncaoCompilada) simbolo, (NoChamadaFuncao) referencia, tabelaSimbolos);
                    */
            }

            return null;
    }                     
                     
    /*
    private Object obterValorFuncaoCompilada(FuncaoCompilada funcao, NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos)
    {
            List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();
            List<NoParametro> listaParametrosEsperados = funcao.getParametros();

            for (int i = 0; i < listaParametrosEsperados.size(); i++)
            {
                    NoExpressao parametroPassado = listaParametrosPassados.get(i);
                    NoParametro parametroEsperado = listaParametrosEsperados.get(i);

                    switch (parametroEsperado.getModoAcesso())
                    {
                            case POR_VALOR: passarParametroFuncaoCompiladaPorValor(); break;
                            case POR_REFERENCIA: passarParametroFuncaoCompiladaPorReferencia(); break;
                    }
            }

            return funcao.executar(null);
    }

    private void passarParametroFuncaoCompiladaPorValor()
    {

    }

    private void passarParametroFuncaoCompiladaPorReferencia()
    {

    }
    */

    private void escreva(NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();

            for (NoExpressao expressao: listaParametrosPassados)
            {
                if (saida != null)
                {
                    Object valor = obterValorExpressao(expressao, tabelaSimbolos);
                    if (valor instanceof String) saida.escrever((String) valor);
                    else
                    if (valor instanceof Boolean) saida.escrever((Boolean) valor);
                    else
                    if (valor instanceof Character) saida.escrever((Character) valor);
                    else
                    if (valor instanceof Double) saida.escrever((Double) valor);
                    else
                    if (valor instanceof Integer) saida.escrever((Integer) valor);
                }
            }
    }

    private void leia(NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();

            for (NoExpressao expressao: listaParametrosPassados)
            {
                    if (expressao instanceof NoReferencia)
                    {
                        NoReferencia referencia = (NoReferencia) expressao;

                        String nome = referencia.getNome();

                        Simbolo simbolo = extrairSimbolo(obterSimbolo(nome, tabelaSimbolos));
                        TipoDado tipoDado = simbolo.getTipoDado();
                        Object valor = null;

                        if (entrada != null)
                        {
                            valor = entrada.ler(tipoDado);
                            
                            if (valor ==  null)
                                valor = tipoDado.getValorPadrao();
                        }

                        if (simbolo instanceof Variavel) atribuirValorVariavel((Variavel) simbolo, valor);
                        else
                        if (simbolo instanceof Vetor) atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) referencia, tabelaSimbolos);
                        else
                        if (simbolo instanceof Matriz) atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) referencia, tabelaSimbolos);
                    }
            }
    }

    
    private Object obterValorVariavel(Variavel variavel)
    {
            return variavel.getValor();
    }

    private Object obterValorVetor(Vetor vetor, NoReferenciaVetor referenciaVetor, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            int indice = (Integer) obterValorExpressao(referenciaVetor.getIndice(), tabelaSimbolos);

            return vetor.getValor(indice);
    }

    private Object obterValorMatriz(Matriz matriz, NoReferenciaMatriz referenciaMatriz, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            int linha = (Integer) obterValorExpressao(referenciaMatriz.getLinha(), tabelaSimbolos);
            int coluna = (Integer) obterValorExpressao(referenciaMatriz.getColuna(), tabelaSimbolos);

            return matriz.getValor(linha, coluna);
    }

    private Object obterValorFuncao(Funcao funcao, NoChamadaFuncao chamadaFuncao, TabelaSimbolos tabelaSimbolos) throws InterruptedException
    {
            TabelaSimbolos tabelaSimbolosFuncao = new TabelaSimbolos();

            List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();
            List<NoParametro> listaParametrosEsperados = funcao.getParametros();

            for (int i = 0; i < listaParametrosEsperados.size(); i++)
            {
                    NoExpressao parametroPassado = listaParametrosPassados.get(i);
                    NoParametro parametroEsperado = listaParametrosEsperados.get(i);

                    switch (parametroEsperado.getModoAcesso())
                    {
                            case POR_VALOR: passarParametroFuncaoPorValor(parametroPassado, parametroEsperado, tabelaSimbolos, tabelaSimbolosFuncao); break;
                            case POR_REFERENCIA: passarParametroFuncaoPorReferencia(parametroPassado, parametroEsperado, tabelaSimbolos, tabelaSimbolosFuncao); break;
                    }
            }

            return interpretarListaBlocos(funcao.getBlocos(), tabelaSimbolosFuncao);
    }
    
    @SuppressWarnings("unchecked")
    private void passarParametroFuncaoPorValor(NoExpressao parametroPassado, NoParametro parametroEsperado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao) throws InterruptedException
    {
        String nome = parametroEsperado.getNome();

        if (parametroPassado instanceof NoReferenciaVariavel)
        {
            NoReferenciaVariavel referencia = (NoReferenciaVariavel) parametroPassado;
            Simbolo simbolo = extrairSimbolo(obterSimbolo(referencia.getNome(), tabelaSimbolos));
            tabelaSimbolosFuncao.adicionar(simbolo.copiar(nome));
        }

        else
        {
            Quantificador quantificador = parametroEsperado.getQuantificador();
            TipoDado tipoDado = parametroEsperado.getTipoDado();
            Object valor = obterValorExpressao(parametroPassado, tabelaSimbolos);

            if (quantificador == Quantificador.VALOR)
                tabelaSimbolosFuncao.adicionar(new Variavel(nome, tipoDado, valor));

            else

            if (quantificador == Quantificador.VETOR)
                tabelaSimbolosFuncao.adicionar(new Vetor(nome, tipoDado, (List<Object>) valor));

            else

            if (quantificador == Quantificador.MATRIZ)
                tabelaSimbolos.adicionar(new Matriz(nome, tipoDado, (List<List<Object>>) valor));
        }
    }

    /*
    @SuppressWarnings("unchecked")
    private void passarParametroFuncaoPorValor(NoExpressao parametroPassado, NoParametro parametroEsperado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao)
    {
        Quantificador quantificador = parametroEsperado.getQuantificador();

        if (quantificador == Quantificador.VALOR)
            passarValorPorValor(parametroEsperado, parametroPassado, tabelaSimbolos, tabelaSimbolosFuncao);

        else

        if (quantificador == Quantificador.VETOR)
            passarVetorPorValor(parametroEsperado, parametroPassado, tabelaSimbolos, tabelaSimbolosFuncao);

        else

        if (quantificador == Quantificador.MATRIZ)
            passarMatrizPorValor(parametroEsperado, parametroPassado, tabelaSimbolos, tabelaSimbolosFuncao);
    }

    private void passarMatrizPorValor(NoParametro parametroEsperado, NoExpressao parametroPassado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao)
    {

    }

    private void passarVetorPorValor(NoParametro parametroEsperado, NoExpressao parametroPassado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao)
    {
        String nome = parametroEsperado.getNome();

        if (parametroPassado instanceof NoReferenciaVariavel)
        {
            NoReferenciaVariavel referencia = (NoReferenciaVariavel) parametroPassado;
            Simbolo vetor = extrairSimbolo(obterSimbolo(referencia.getApelido(), referencia.getNome(), tabelaSimbolos));
            tabelaSimbolosFuncao.adicionar(vetor.copiar(nome));
        }

        TipoDado tipoDado = parametroEsperado.getTipoDado();
        Object valor = obterValorExpressao(parametroPassado, tabelaSimbolos);

        switch (parametroEsperado.getQuantificador())
                {
                        case VALOR:  tabelaSimbolosFuncao.adicionar(new Variavel(nome, tipoDado, valor)); break;
                        case VETOR:  tabelaSimbolosFuncao.adicionar(new Vetor(nome, tipoDado, (List<Object>) valor)); break;
                        case MATRIZ: tabelaSimbolosFuncao.adicionar(new Matriz(nome, tipoDado, (List<List<Object>>) valor)); break;
                }
         
    }

    private void passarValorPorValor(NoParametro parametroEsperado, NoExpressao parametroPassado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao)
    {
        String nome = parametroEsperado.getNome();
        TipoDado tipoDado = parametroEsperado.getTipoDado();

        Variavel variavel = new Variavel(nome, tipoDado);
        variavel.setValor(obterValorExpressao(parametroPassado, tabelaSimbolos));
        tabelaSimbolosFuncao.adicionar(variavel);
    }
    */

    private void passarParametroFuncaoPorReferencia(NoExpressao parametroPassado, NoParametro parametroEsperado, TabelaSimbolos tabelaSimbolos, TabelaSimbolos tabelaSimbolosFuncao)
    {
            NoReferencia referencia = (NoReferencia) parametroPassado;
            String nome = referencia.getNome();
            Simbolo simbolo = obterSimbolo(nome, tabelaSimbolos);

            tabelaSimbolosFuncao.adicionar(new Ponteiro(parametroEsperado.getNome(), simbolo));
    }


    private Simbolo extrairSimbolo(Simbolo simbolo)
    {
            while (simbolo instanceof Ponteiro)
                    simbolo = ((Ponteiro) simbolo).getSimboloApontado();

            return simbolo;
    }

    private Simbolo obterSimbolo(String nome, TabelaSimbolos tabelaSimbolos)
    {
        if (tabelaSimbolos.contem(nome))
            return tabelaSimbolos.obter(nome);

        return tabelaSimbolosGlobal.obter(nome);
    }

    private void aguardar(NoChamadaFuncao noChamadaFuncao, TabelaSimbolos tabelaSimbolos) throws InterruptedException 
    {
        List<NoExpressao> parametros = noChamadaFuncao.getParametros();
        Thread.sleep((Integer) obterValorExpressao(parametros.get(0), tabelaSimbolos));
    }
}
