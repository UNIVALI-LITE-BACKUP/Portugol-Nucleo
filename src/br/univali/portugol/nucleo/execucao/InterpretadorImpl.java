package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.CarregadorBibliotecas;
import br.univali.portugol.nucleo.bibliotecas.base.ErroCarregamentoBiblioteca;
import br.univali.portugol.nucleo.execucao.erros.ErroExecucaoNaoTratado;
import br.univali.portugol.nucleo.execucao.erros.ErroFuncaoInicialNaoDeclarada;
import br.univali.portugol.nucleo.execucao.erros.ErroIndiceMatrizInvalido;
import br.univali.portugol.nucleo.execucao.erros.ErroIndiceVetorInvalido;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.OperacaoDivisao;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.OperacaoModulo;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.OperacaoMultiplicacao;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.OperacaoSoma;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.OperacaoSubtracao;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogicaIgualdade;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogicaMaior;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogicaMaiorIgual;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogicaMenor;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.OperacaoLogicaMenorIgual;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterpretadorImpl implements VisitanteASA, Interpretador
{
    public static final String funcaoInicialPadrao = "inicio";
    private Saida saida;
    private Entrada entrada;
    private boolean referencia = false;
    private ArvoreSintaticaAbstrata asa;
    private Random random = new Random(System.currentTimeMillis());
    private String funcaoInicial = funcaoInicialPadrao;
    private String ultimaReferenciaAcessada;
    private Memoria memoria = new Memoria();
    private Map<String, Biblioteca> bibliotecas = new TreeMap<String, Biblioteca>();
    private OperacaoDivisao operacaoDivisao = new OperacaoDivisao();
    private OperacaoLogicaIgualdade operacaoLogicaIgualdade = new OperacaoLogicaIgualdade();
    private OperacaoLogicaMaior operacaoLogicaMaior = new OperacaoLogicaMaior();
    private OperacaoLogicaMaiorIgual operacaoLogicaMaiorIgual = new OperacaoLogicaMaiorIgual();
    private OperacaoLogicaMenor operacaoLogicaMenor = new OperacaoLogicaMenor();
    private OperacaoLogicaMenorIgual operacaoLogicaMenorIgual = new OperacaoLogicaMenorIgual();
    private OperacaoModulo operacaoModulo = new OperacaoModulo();
    private OperacaoMultiplicacao operacaoMultiplicacao = new OperacaoMultiplicacao();
    private OperacaoSoma operacaoSoma = new OperacaoSoma();
    private OperacaoSubtracao operacaoSubtracao = new OperacaoSubtracao();

    @Override
    public void setEntrada(Entrada entrada)
    {
        this.entrada = entrada;
    }

    @Override
    public void setSaida(Saida saida)
    {
        this.saida = saida;
    }

    @Override
    public void executar(Programa programa, String[] parametros) throws ErroExecucao
    {

        try
        {
            asa = programa.getArvoreSintaticaAbstrata();
            asa.aceitar(this);

            try {

                Funcao funcaoPrincipal = (Funcao) memoria.getSimbolo(funcaoInicial);
                memoria.empilharFuncao();
                try {
                    if (funcaoPrincipal.getParametros().isEmpty() || (funcaoPrincipal.getParametros().size() == 1
                            && funcaoPrincipal.getParametros().get(0).getQuantificador() == Quantificador.VETOR && funcaoPrincipal.getParametros().get(0).getTipoDado() == TipoDado.CADEIA))
                    {



                        if (funcaoPrincipal.getParametros().size() == 1)
                        {
                            List<Object> listaParametros = converterVetorEmLista(parametros);
                            memoria.adicionarSimbolo(new Vetor(funcaoPrincipal.getParametros().get(0).getNome(), TipoDado.CADEIA, listaParametros.size(), listaParametros));
                        }

                        interpretarListaBlocos(funcaoPrincipal.getBlocos());
                    }
                    else
                    {
                        throw new ErroExecucao()
                        {
                            @Override
                            protected String construirMensagem()
                            {
                                return "A função principal \"" + funcaoInicial + "\" não deve possuir parâmetros ou o parâmetro deve ser um vetor do tipo CADEIA.";
                            }
                        };
                    }
                } 
                finally 
                {
                    memoria.desempilharFuncao();
                }
            }
            catch (ExcecaoSimboloNaoDeclarado n)
            {
                throw new ErroFuncaoInicialNaoDeclarada(funcaoInicial);
            }

        }
        catch (Exception e)
        {
            if (e instanceof ExcecaoVisitaASA)
            {
                throw (ErroExecucao) e.getCause();
            }
            if (e instanceof ErroExecucao)
            {
                throw (ErroExecucao) e;
            }
            throw new ErroExecucaoNaoTratado(e);
        }

    }

    private List<Object> converterVetorEmLista(Object[] vetor)
    {
        List<Object> lista = new ArrayList<Object>();

        if (vetor != null)
        {
            lista.addAll(Arrays.asList(vetor));
        }

        return lista;
    }

    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
       
        
        for (NoInclusaoBiblioteca inclusao : asap.getListaInclusoesBibliotecas())
        {
            inclusao.aceitar(this);
        }

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
        return noCaso.getExpressao() != null ? noCaso.getExpressao().aceitar(this) : null;
    }

    @Override
    public Object visitar(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        try
        {
            if (!noChamadaFuncao.getNome().contains("."))
            {
                if (noChamadaFuncao.getNome().equals("escreva"))
                {
                    escreva(noChamadaFuncao);

                }
                else
                {
                    if (noChamadaFuncao.getNome().equals("leia"))
                    {
                        leia(noChamadaFuncao);

                    }
                    else
                    {
                        if (noChamadaFuncao.getNome().equals("limpa"))
                        {
                            try
                            {
                                limpar();
                            }
                            catch (Exception ex)
                            {
                                if (ex instanceof InterruptedException)
                                {
                                    throw new RuntimeException(ex);
                                }
                                Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else
                        {
                            if (noChamadaFuncao.getNome().equals("aguarde"))
                            {
                                aguardar(noChamadaFuncao);
                            }
                            else
                            {
                                if (noChamadaFuncao.getNome().equals("tamanho_vetor"))
                                {
                                    return tamanho_vetor(noChamadaFuncao);
                                }
                                else
                                {
                                    if (noChamadaFuncao.getNome().equals("tamanho_matriz"))
                                    {
                                        return tamanho_matriz(noChamadaFuncao);
                                    }
                                    else
                                    {
                                        if (noChamadaFuncao.getNome().equals("potencia"))
                                        {
                                            return potencia(noChamadaFuncao);
                                        }
                                        else
                                        {
                                            if (noChamadaFuncao.getNome().equals("raiz_quadrada"))
                                            {
                                                return raiz(noChamadaFuncao);
                                            }
                                            else
                                            {
                                                if (noChamadaFuncao.getNome().equals("sorteia"))
                                                {
                                                    return sorteia(noChamadaFuncao);
                                                }
                                                else
                                                {                                                
                                                    Funcao funcao = (Funcao) memoria.getSimbolo(noChamadaFuncao.getNome());
                                                    
                                                    List<NoExpressao> listaParametrosPassados = noChamadaFuncao.getParametros();
                                                    List<NoDeclaracaoParametro> listaParametrosEsperados = funcao.getParametros();

                                                    List<Object> valoresParametrosPassados = new ArrayList<Object>();
                                                    if (listaParametrosPassados != null ) {
                                                        for (int i = 0; i < listaParametrosPassados.size(); i++)
                                                        {   
                                                            NoDeclaracaoParametro declaracao = listaParametrosEsperados.get(i);

                                                            referencia = declaracao.getModoAcesso() == ModoAcesso.POR_REFERENCIA;                                                        
                                                            valoresParametrosPassados.add(listaParametrosPassados.get(i).aceitar(this));
                                                            referencia = false;
                                                        }
                                                    }

                                                    memoria.empilharFuncao();
                                                    if (listaParametrosEsperados != null) {
                                                        for (int i = 0; i < listaParametrosEsperados.size(); i++)
                                                        {
                                                            NoDeclaracaoParametro declaracao = listaParametrosEsperados.get(i);
                                                            Simbolo simbolo = (Simbolo) declaracao.aceitar(this);
                                                            Object valor = valoresParametrosPassados.get(i);

                                                            if (simbolo instanceof Variavel)
                                                            {
                                                                ((Variavel) simbolo).setValor(valor);
                                                            }
                                                            else
                                                            {
                                                                if (simbolo instanceof Ponteiro)
                                                                {
                                                                    ((Ponteiro) simbolo).setSimbolo((Simbolo) valor);
                                                                }
                                                                else
                                                                {
                                                                    if (simbolo instanceof Vetor)
                                                                    {
                                                                        ((Vetor) simbolo).inicializarComValores((List<Object>) valor);
                                                                    }
                                                                    else
                                                                    {
                                                                        if (simbolo instanceof Matriz)
                                                                        {
                                                                            ((Matriz) simbolo).inicializarComValores((List<List<Object>>) valor);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    Object retorno = interpretarListaBlocos(funcao.getBlocos());
                                                    memoria.desempilharFuncao();
                                                    return retorno;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
            else
            {
                try
                {
                    String[] ref = noChamadaFuncao.getNome().split("\\.");
                    Biblioteca biblioteca = bibliotecas.get(ref[0]);

                    List<NoExpressao> param = noChamadaFuncao.getParametros();
                    Object[] parametros = new Object[param.size()];

                    for (int i = 0; i < parametros.length; i++)
                    {
                        parametros[i] = param.get(i).aceitar(this);
                    }

                    return biblioteca.chamarFuncao(ref[1], parametros);
                }
                catch (Exception excecao)
                {
                    throw new ExcecaoVisitaASA(new ErroExecucaoNaoTratado(excecao), asa, noChamadaFuncao);
                }
            }

            return null;
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noChamadaFuncao);
        }
    }

    private void limpar() throws Exception
    {
        if (saida != null)
        {
            saida.limpar();
        }
    }

    private void aguardar(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametros = noChamadaFuncao.getParametros();
        try
        {
            Thread.sleep((Integer) parametros.get(0).aceitar(this));
        }
        catch (InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }

    }

    private int tamanho_vetor(NoChamadaFuncao chamadaFuncao) throws ExcecaoSimboloNaoDeclarado
    {
        NoReferencia noReferencia = (NoReferencia) chamadaFuncao.getParametros().get(0);
        String nome = noReferencia.getNome();
        ultimaReferenciaAcessada = nome;
        Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(nome));
        Vetor vetor = (Vetor) simbolo;

        return vetor.getTamanho();
    }
    
    private int tamanho_matriz(NoChamadaFuncao chamadaFuncao) throws ExcecaoSimboloNaoDeclarado
    {
        NoReferencia noReferencia = (NoReferencia) chamadaFuncao.getParametros().get(0);
        String nome = noReferencia.getNome();
        ultimaReferenciaAcessada = nome;
        Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(nome));
        Matriz matriz = (Matriz) simbolo;
        
        return matriz.getNumeroColunas() * matriz.getNumeroLinhas();
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

        memoria.adicionarSimbolo(funcao);

        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoMatriz.getNome();
        TipoDado tipoDado = noDeclaracaoMatriz.getTipoDado();

        int numeroLinhas = (noDeclaracaoMatriz.getNumeroLinhas() == null) ? 0 : (Integer) noDeclaracaoMatriz.getNumeroLinhas().aceitar(this);
        int numeroColunas = (noDeclaracaoMatriz.getNumeroColunas() == null) ? 0 : (Integer) noDeclaracaoMatriz.getNumeroColunas().aceitar(this);

        List<List<Object>> valores = null;
        if (noDeclaracaoMatriz.getInicializacao() != null)
        {
            valores = (List<List<Object>>) noDeclaracaoMatriz.getInicializacao().aceitar(this);
        }

        Matriz matriz;

        if (numeroLinhas == 0 && valores != null)
        {
            matriz = new Matriz(nome, tipoDado, valores);
        }
        else
        {
            if (valores == null)
            {
                matriz = new Matriz(nome, tipoDado, numeroLinhas, numeroColunas);
            }
            else
            {
                matriz = new Matriz(nome, tipoDado, numeroLinhas, numeroColunas, valores);
            }
        }

        matriz.setConstante(noDeclaracaoMatriz.constante());

        memoria.adicionarSimbolo(matriz);

        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVariavel.getNome();
        TipoDado tipoDado = noDeclaracaoVariavel.getTipoDado();

        Variavel variavel = new Variavel(nome, tipoDado);

        if (noDeclaracaoVariavel.getInicializacao() != null)
        {
            Object valor = noDeclaracaoVariavel.getInicializacao().aceitar(this);
            variavel.setValor(valor);
        }

        variavel.setConstante(noDeclaracaoVariavel.constante());

        memoria.adicionarSimbolo(variavel);

        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVetor.getNome();
        TipoDado tipoDado = noDeclaracaoVetor.getTipoDado();

        int tamanho = (noDeclaracaoVetor.getTamanho() == null) ? 0 : (Integer) noDeclaracaoVetor.getTamanho().aceitar(this);
        List<Object> valores = null;
        if (noDeclaracaoVetor.getInicializacao() != null)
        {
            valores = (List<Object>) noDeclaracaoVetor.getInicializacao().aceitar(this);
        }

        Vetor vetor;

        if (tamanho == 0 && valores != null)
        {
            vetor = new Vetor(nome, tipoDado, valores);
        }
        else
        {
            if (valores == null)
            {
                vetor = new Vetor(nome, tipoDado, tamanho);
            }
            else
            {
                vetor = new Vetor(nome, tipoDado, tamanho, valores);
            }
        }

        vetor.setConstante(noDeclaracaoVetor.constante());

        memoria.adicionarSimbolo(vetor);

        return null;
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        try
        {
            while ((Boolean) noEnquanto.getCondicao().aceitar(this))
            {
                Object valorRetorno = interpretarListaBlocos(noEnquanto.getBlocos());

                if (valorRetorno != null)
                {
                    return valorRetorno;
                }
            }
        }
        catch (PareException pe)
        {
        }

        return null;
    }

    protected Object interpretarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {
        if (Thread.currentThread().isInterrupted())
        {
            throw new RuntimeException(new InterruptedException());
        }

        if (blocos == null)
        {
            return null;
        }

        memoria.empilharEscopo();
        try
        {
            for (NoBloco noBloco : blocos)
            {
                noBloco.aceitar(this);
            }
        }
        catch (RetorneException re)
        {
            return re.getValor();
        }
        finally
        {
            memoria.desempilharEscopo();
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
            try
            {
                for (int i = indiceValorEscolhido; i < casos.size(); i++)
                {
                    Object valorRetorno = interpretarListaBlocos(casos.get(i).getBlocos());

                    if (valorRetorno != null)
                    {
                        return valorRetorno;
                    }
                }
            }
            catch (PareException pe)
            {
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
        try
        {
            do
            {
                Object valorRetorno = interpretarListaBlocos(noFacaEnquanto.getBlocos());

                if (valorRetorno != null)
                {
                    return valorRetorno;
                }
            }
            while ((Boolean) noFacaEnquanto.getCondicao().aceitar(this));
        }
        catch (PareException pe)
        {
        }
        return null;
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
                    vetor.set(j, vetor.get(j));
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
        return !((Boolean) noNao.getExpressao().aceitar(this));
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
        try
        {
            vetor.setValor(indice, valor);
        }
        catch (IndexOutOfBoundsException ie)
        {
            throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, vetor.getNome()), asa, referenciaVetor);
        }
        return valor;
    }

    private Object atribuirValorMatriz(Matriz matriz, Object valor, NoReferenciaMatriz referenciaMatriz) throws ExcecaoVisitaASA
    {
        int linha = (Integer) referenciaMatriz.getLinha().aceitar(this);
        int coluna = (Integer) referenciaMatriz.getColuna().aceitar(this);
        try
        {
            matriz.setValor(linha, coluna, valor);
        }
        catch (IndexOutOfBoundsException ie)
        {
            throw new ExcecaoVisitaASA(new ErroIndiceMatrizInvalido(matriz, linha, coluna), asa, referenciaMatriz);
        }
        return valor;
    }

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        Object valorRetorno = null;

        memoria.empilharEscopo();
        
        if (noPara.getInicializacao() != null)
        {
            noPara.getInicializacao().aceitar(this);
        }
        
        NoExpressao condicao = noPara.getCondicao();
        try
        {
            while ((condicao != null) ? (Boolean) condicao.aceitar(this) : true)
            {
                if ((valorRetorno = interpretarListaBlocos(noPara.getBlocos())) != null)
                {
                    break;
                }

                noPara.getIncremento().aceitar(this);
            }
        }
        catch (PareException pe)
        {
        }
        finally
        {
            memoria.desempilharEscopo();
        }

        return valorRetorno;
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        throw new PareException();
    }

    private Object potencia(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametros = noChamadaFuncao.getParametros();
        Double base = null;
        Object b = parametros.get(0).aceitar(this);
        if (b instanceof Double)
        {
            base = (Double) b;
        }
        else
        {
            if (b instanceof Integer)
            {
                base = ((Integer) b).doubleValue();
            }
        }
        Double expoente = null;
        Object e = parametros.get(1).aceitar(this);
        if (e instanceof Double)
        {
            expoente = (Double) e;
        }
        else
        {
            if (e instanceof Integer)
            {
                expoente = ((Integer) e).doubleValue();
            }
        }
        Double potencia = Math.pow(base, expoente);
        return potencia;
    }

    private Object raiz(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametros = noChamadaFuncao.getParametros();
        Double valor = null;
        Object v = parametros.get(0).aceitar(this);

        if (v instanceof Double)
        {
            valor = (Double) v;
        }
        else
        {
            if (v instanceof Integer)
            {
                valor = ((Integer) v).doubleValue();
            }
        }

        return Math.sqrt(valor);
    }

    private Object sorteia(NoChamadaFuncao noChamadaFuncao) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametros = noChamadaFuncao.getParametros();
        Integer n = (Integer) parametros.get(0).aceitar(this);
        return random.nextInt(n);
    }

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoLogicaIgualdade.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);

        return !(Boolean) operacaoLogicaIgualdade.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao atribuicao) throws ExcecaoVisitaASA
    {
        try
        {
            NoReferencia noReferencia = (NoReferencia) atribuicao.getOperandoEsquerdo();

            String nome = noReferencia.getNome();
            Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(nome));
            Object valor = atribuicao.getOperandoDireito().aceitar(this);

            if (noReferencia instanceof NoReferenciaVariavel)
            {
                return atribuirValorVariavel((Variavel) simbolo, valor);
            }

            if (noReferencia instanceof NoReferenciaVetor)
            {
                return atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) noReferencia);
            }

            if (noReferencia instanceof NoReferenciaMatriz)
            {
                return atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) noReferencia);
            }

            return null;
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, atribuicao);
        }
    }

    @Override
    public Object visitar(NoOperacaoLogicaE noOperacao) throws ExcecaoVisitaASA
    {
        Boolean opEsq = (Boolean) noOperacao.getOperandoEsquerdo().aceitar(this);
        Boolean opDir = (Boolean) noOperacao.getOperandoDireito().aceitar(this);
        return opEsq && opDir;
    }

    @Override
    public Object visitar(NoOperacaoLogicaOU noOperacao) throws ExcecaoVisitaASA
    {
        Boolean opEsq = (Boolean) noOperacao.getOperandoEsquerdo().aceitar(this);
        Boolean opDir = (Boolean) noOperacao.getOperandoDireito().aceitar(this);
        return opEsq || opDir;
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaior noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoLogicaMaior.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoLogicaMaiorIgual.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoLogicaMenor.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoLogicaMenorIgual.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoSoma noOperacao) throws ExcecaoVisitaASA
    {
        Object valorOpEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object valorOpDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoSoma.executar(valorOpEsq, valorOpDir);
    }

    @Override
    public Object visitar(NoOperacaoSubtracao noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoSubtracao.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoDivisao noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoDivisao.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoMultiplicacao.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoOperacaoModulo noOperacao) throws ExcecaoVisitaASA
    {
        Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
        Object opDir = noOperacao.getOperandoDireito().aceitar(this);
        return operacaoModulo.executar(opEsq, opDir);
    }

    @Override
    public Object visitar(NoInclusaoBiblioteca noInclusaoBiblioteca) throws ExcecaoVisitaASA
    {
        try
        {
            String nome = noInclusaoBiblioteca.getNome();
            Biblioteca biblioteca = CarregadorBibliotecas.carregarBiblioteca(nome);

            bibliotecas.put(nome, biblioteca);

            if (noInclusaoBiblioteca.getAlias() != null)
            {
                bibliotecas.put(noInclusaoBiblioteca.getAlias(), biblioteca);
            }

            return null;
        }
        catch (ErroCarregamentoBiblioteca erro)
        {
            throw new ExcecaoVisitaASA(new ErroExecucaoNaoTratado(erro), asa, noInclusaoBiblioteca);
        }
    }

    private Object analisarReferenciaVariavelPrograma(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        try
        {
            Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(noReferenciaVariavel.getNome()));

            if (referencia)
            {
                return simbolo;
            }
            else
            {
                if (simbolo instanceof Vetor)
                {
                    return ((Vetor) simbolo).obterValores();
                }
                else
                {
                    if (simbolo instanceof Matriz)
                    {
                        return ((Matriz) simbolo).obterValores();
                    }
                }
            }

            return ((Variavel) simbolo).getValor();
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noReferenciaVariavel);
        }
    }

    private Object analisarReferenciaVariavelBiblioteca(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        try
        {
            Biblioteca biblioteca = bibliotecas.get(noReferenciaVariavel.getEscopo());

            return biblioteca.getValorVariavel(noReferenciaVariavel.getNome());
        }
        catch (Exception excecao)
        {
            throw new ExcecaoVisitaASA(new ErroExecucaoNaoTratado(excecao), asa, noReferenciaVariavel);
        }
    }

    private class PareException extends RuntimeException
    {
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
        try
        {
            int linha = (Integer) noReferenciaMatriz.getLinha().aceitar(this);
            int coluna = (Integer) noReferenciaMatriz.getColuna().aceitar(this);
            String nome = noReferenciaMatriz.getNome();
            Matriz matriz = (Matriz) extrairSimbolo(memoria.getSimbolo(nome));

            Object valor;
            try
            {
                valor = matriz.getValor(linha, coluna);
            }
            catch (IndexOutOfBoundsException ie)
            {
                throw new ExcecaoVisitaASA(new ErroIndiceMatrizInvalido(matriz, linha, coluna), asa, noReferenciaMatriz);
            }

            while (valor instanceof NoExpressao)
            {
                valor = ((NoExpressao) valor).aceitar(this);
            }

            return valor;
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noReferenciaMatriz);
        }
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
        try
        {
            Vetor vetor = (Vetor) memoria.getSimbolo(noReferenciaVetor.getNome());
            int indice = (Integer) noReferenciaVetor.getIndice().aceitar(this);

            if (indice >= vetor.getTamanho())
            {
                throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, vetor.getNome()), asa, noReferenciaVetor);
            }

            Object valor;
            try
            {
                valor = vetor.getValor(indice);
            }
            catch (ArrayIndexOutOfBoundsException aioobe)
            {
                throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, ultimaReferenciaAcessada), null, noReferenciaVetor);
            }

            while (valor instanceof NoExpressao)
            {
                valor = ((NoExpressao) valor).aceitar(this);
            }

            return valor;
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noReferenciaVetor);
        }
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        throw new RetorneException(noRetorne.getExpressao().aceitar(this));


    }

    private class RetorneException extends RuntimeException
    {
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
                    final NoExpressao expr = (NoExpressao) valoresVetor.get(i);
                    valores.add(expr != null ? expr.aceitar(this) : null);
                }
                catch (ArrayIndexOutOfBoundsException aioobe)
                {
                    throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(valores.size(), i, ultimaReferenciaAcessada), null, noVetor);
                }
            }
        }

        return valores;
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        Simbolo simbolo = null;
        switch (noDeclaracaoParametro.getModoAcesso())
        {
            case POR_REFERENCIA:
                simbolo = new Ponteiro(noDeclaracaoParametro.getNome(), null);
                break;
            case POR_VALOR:
                String nome = noDeclaracaoParametro.getNome();
                Quantificador quantificador = noDeclaracaoParametro.getQuantificador();
                TipoDado tipoDado = noDeclaracaoParametro.getTipoDado();
                switch (quantificador)
                {
                    case VALOR:
                    {
                        simbolo = new Variavel(nome, tipoDado, tipoDado.getValorPadrao());
                        break;
                    }
                    case VETOR:
                    {
                        simbolo = new Vetor(nome, tipoDado, null);
                        break;
                    }
                    case MATRIZ:
                    {
                        simbolo = new Matriz(nome, tipoDado, null);
                        break;
                    }
                }
                break;
        }
        memoria.adicionarSimbolo(simbolo);
        return simbolo;
    }

    private void escreva(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
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
                    try
                    {
                        saida.escrever((String) valor);
                    }
                    catch (Exception ex)
                    {
                        if (ex instanceof InterruptedException)
                        {
                            throw new RuntimeException(ex);
                        }
                        Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else
                {
                    if (valor instanceof Boolean)
                    {
                        try
                        {
                            saida.escrever((Boolean) valor);
                        }
                        catch (Exception ex)
                        {
                            if (ex instanceof InterruptedException)
                            {
                                throw new RuntimeException(ex);
                            }
                            Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        if (valor instanceof Character)
                        {
                            try
                            {

                                saida.escrever((Character) valor);
                            }
                            catch (Exception ex)
                            {
                                if (ex instanceof InterruptedException)
                                {
                                    throw new RuntimeException(ex);
                                }
                                Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else
                        {
                            if (valor instanceof Double)
                            {
                                try
                                {
                                    saida.escrever((Double) valor);
                                }
                                catch (Exception ex)
                                {
                                    if (ex instanceof InterruptedException)
                                    {
                                        throw new RuntimeException(ex);
                                    }
                                    Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else
                            {
                                if (valor instanceof Integer)
                                {
                                    try
                                    {
                                        saida.escrever((Integer) valor);
                                    }
                                    catch (Exception ex)
                                    {
                                        if (ex instanceof InterruptedException)
                                        {
                                            throw new RuntimeException(ex);
                                        }
                                        Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void leia(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        try
        {        
            List<NoExpressao> listaParametrosPassados = chamadaFuncao.getParametros();

            for (NoExpressao expressao : listaParametrosPassados)
            {
                if (expressao instanceof NoReferencia)
                {
                    NoReferencia noReferencia = (NoReferencia) expressao;

                    String nome = noReferencia.getNome();

                    Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(nome));
                    TipoDado tipoDado = simbolo.getTipoDado();
                    Object valor = null;

                    if (entrada != null)
                    {
                        try
                        {
                            valor = entrada.ler(tipoDado);

                            if (valor == null)
                            {
                                valor = tipoDado.getValorPadrao();
                            }
                        }
                        catch (Exception ex)
                        {
                            if (ex instanceof InterruptedException)
                            {
                                throw new RuntimeException(ex);
                            }
                            Logger.getLogger(InterpretadorImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                            atribuirValorVetor((Vetor) simbolo, valor, (NoReferenciaVetor) noReferencia);
                        }
                        else
                        {
                            if (simbolo instanceof Matriz)
                            {
                                atribuirValorMatriz((Matriz) simbolo, valor, (NoReferenciaMatriz) noReferencia);
                            }
                        }
                    }
                }
            }
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, chamadaFuncao);
        }
    }
}
