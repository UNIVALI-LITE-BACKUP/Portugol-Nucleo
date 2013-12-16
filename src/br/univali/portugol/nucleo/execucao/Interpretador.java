package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.execucao.util.ConversorTipos;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.*;
import br.univali.portugol.nucleo.execucao.erros.*;
import br.univali.portugol.nucleo.execucao.es.*;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.execucao.operacoes.aritmeticas.*;
import br.univali.portugol.nucleo.execucao.operacoes.bitwise.*;
import br.univali.portugol.nucleo.execucao.operacoes.logicas.*;
import br.univali.portugol.nucleo.simbolos.*;
import java.util.*;

public class Interpretador implements VisitanteASA
{
    private Programa programa;
    private boolean referencia = false;
    private ArvoreSintaticaAbstrata asa;
    private String ultimaReferenciaAcessada;
    
    private final Stack<String> chamadasFuncao = new Stack<>();
    private NoChamadaFuncao candidataRecursividade;
    
    protected Memoria memoria = new Memoria();    
    protected Map<String, Biblioteca> bibliotecas = new TreeMap<>();
    
    private final OperacaoDivisao operacaoDivisao = new OperacaoDivisao();
    private final OperacaoLogicaIgualdade operacaoLogicaIgualdade = new OperacaoLogicaIgualdade();
    private final OperacaoLogicaMaior operacaoLogicaMaior = new OperacaoLogicaMaior();
    private final OperacaoLogicaMaiorIgual operacaoLogicaMaiorIgual = new OperacaoLogicaMaiorIgual();
    private final OperacaoLogicaMenor operacaoLogicaMenor = new OperacaoLogicaMenor();
    private final OperacaoLogicaMenorIgual operacaoLogicaMenorIgual = new OperacaoLogicaMenorIgual();
    private final OperacaoModulo operacaoModulo = new OperacaoModulo();
    private final OperacaoMultiplicacao operacaoMultiplicacao = new OperacaoMultiplicacao();
    private final OperacaoSoma operacaoSoma = new OperacaoSoma();
    private final OperacaoSubtracao operacaoSubtracao = new OperacaoSubtracao();
    private final OperacaoBitwiseLeftShift operacaoBitwiseLeftShift = new OperacaoBitwiseLeftShift();
    private final OperacaoBitwiseRightShift operacaoBitwiseRightShift = new OperacaoBitwiseRightShift();
    private final OperacaoBitwiseE operacaoBitwiseE = new OperacaoBitwiseE();
    private final OperacaoBitwiseOu operacaoBitwiseOu = new OperacaoBitwiseOu();
    private final OperacaoBitwiseXOR operacaoBitwiseXOR = new OperacaoBitwiseXOR();
    
    private Object valorPassadoParametro;
    
    public void executar(Programa programa, String[] parametros) throws ErroExecucao, InterruptedException
    {
        try
        {
            try
            {
                this.programa = programa;
                this.asa = programa.getArvoreSintaticaAbstrata();            

                asa.aceitar(this);

                try 
                {
                    Funcao funcaoInicial = (Funcao) memoria.getSimbolo(programa.getFuncaoInicial());
                    
                    chamadasFuncao.push(funcaoInicial.getNome());
                    memoria.empilharFuncao();
                    
                    try 
                    {
                        if (funcaoInicialValida(funcaoInicial))
                        {
                            if (funcaoInicial.getParametros().size() == 1)
                            {
                                List<Object> listaParametros = converterVetorEmLista(parametros);
                                memoria.adicionarSimbolo(new Vetor(funcaoInicial.getParametros().get(0).getNome(), TipoDado.CADEIA, funcaoInicial.getParametros().get(0), listaParametros.size(), listaParametros));
                            }

                            interpretarListaBlocos(funcaoInicial.getBlocos());
                        }
                        else
                        {
                            throw new ErroFuncaoInicialInvalida(programa.getFuncaoInicial());
                        }
                    } 
                    finally 
                    {
                        memoria.desempilharFuncao();
                        chamadasFuncao.pop();
                    }
                }
                catch (ExcecaoSimboloNaoDeclarado n)
                {
                    throw new ErroFuncaoInicialNaoDeclarada(programa.getFuncaoInicial());
                }
                finally
                {
                    if (!bibliotecas.isEmpty())
                    {
                        for (Biblioteca biblioteca : bibliotecas.values())
                        {
                            GerenciadorBibliotecas.getInstance().desregistrarBiblioteca(biblioteca, programa);
                        }
                    }
                }
            }
            catch (ExcecaoVisitaASA e)
            {
                if (e.getCause() instanceof InterruptedException)
                {
                    throw (InterruptedException) e.getCause();
                }

                throw (ErroExecucao) e.getCause();
            }
            catch (EmptyStackException excecao)
            {
                System.out.println("Corrigir este problema de pilha");

                excecao.printStackTrace(System.err);

            }
            catch (StackOverflowError soe) 
            {
                throw new ErroEstouroPilha(candidataRecursividade);
            }      
        }
        catch (RuntimeException excecao)
        {
            throw new ErroExecucaoNaoTratado(excecao);
        }
    }

    private boolean funcaoInicialValida(Funcao funcaoPrincipal)
    {        
        boolean possuiParametros = !funcaoPrincipal.getParametros().isEmpty();
        boolean possuiUmParametro = funcaoPrincipal.getParametros().size() == 1;
        boolean parametroVetor = possuiUmParametro && funcaoPrincipal.getParametros().get(0).getQuantificador() == Quantificador.VETOR;
        boolean tipoParametroCadeia = possuiUmParametro && funcaoPrincipal.getParametros().get(0).getTipoDado() == TipoDado.CADEIA;
        
        return !possuiParametros || (parametroVetor && tipoParametroCadeia);
    }

    private List<Object> converterVetorEmLista(Object[] vetor)
    {
        List<Object> lista = new ArrayList<>();

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
            if (noChamadaFuncao.getEscopo() == null)
            {
                if (noChamadaFuncao.getNome().equals("escreva"))
                {
                    escreva(noChamadaFuncao);

                }
                else if (noChamadaFuncao.getNome().equals("leia"))
                {
                        leia(noChamadaFuncao);

                } else if (noChamadaFuncao.getNome().equals("limpa"))
                {
                    try
                    {
                        limpar();
                    }
                    catch (Exception ex)
                    {
                        throw new ExcecaoVisitaASA(ex, asa, noChamadaFuncao);
                    }
                } else 
                {   
                        if (chamadasFuncao.contains(noChamadaFuncao.getNome()) && candidataRecursividade == null)
                        {
                            candidataRecursividade = noChamadaFuncao;
                        }
                        
                        
                        Funcao funcao = (Funcao) memoria.getSimbolo(noChamadaFuncao.getNome());                        

                        List<NoExpressao> listaParametrosPassados = noChamadaFuncao.getParametros();
                        List<NoDeclaracaoParametro> listaParametrosEsperados = funcao.getParametros();

                        List<Object> valoresParametrosPassados = new ArrayList<>();
                        if (listaParametrosPassados != null ) {
                            for (int i = 0; i < listaParametrosPassados.size(); i++)
                            {   
                                NoDeclaracaoParametro declaracao = listaParametrosEsperados.get(i);

                                referencia = declaracao.getModoAcesso() == ModoAcesso.POR_REFERENCIA;
                                valoresParametrosPassados.add(listaParametrosPassados.get(i).aceitar(this));
                                referencia = false;
                            }
                        }

                        chamadasFuncao.push(noChamadaFuncao.getNome());
                        memoria.empilharFuncao();
                        
                        if (listaParametrosEsperados != null) {
                            for (int i = 0; i < listaParametrosEsperados.size(); i++)
                            {
                                NoDeclaracaoParametro declaracao = listaParametrosEsperados.get(i);
                                this.valorPassadoParametro = valoresParametrosPassados.get(i);
                                
                                declaracao.aceitar(this);
                            }
                        }
                        Object retorno = interpretarListaBlocos(funcao.getBlocos());
                        
                        if (retorno != null && !(retorno instanceof TipoDado))
                        {
                            if (retorno.getClass() != funcao.getTipoDado().getTipoJava()){
                                try
                                {
                                    retorno = ConversorTipos.converter(retorno, funcao.getTipoDado().getTipoJava());
                                }
                                catch (ErroImpossivelConverterTipos ex)
                                {
                                    int linha = noChamadaFuncao.getTrechoCodigoFonteNome().getLinha();
                                    int coluna = noChamadaFuncao.getTrechoCodigoFonteNome().getColuna();
                                    
                                    ex.setLinha(linha);
                                    ex.setColuna(coluna);
                                    
                                    throw new ExcecaoVisitaASA(ex, asa, noChamadaFuncao);
                                }
                            }
                        }
                        
                        memoria.desempilharFuncao();
                        chamadasFuncao.pop();
                        
                        candidataRecursividade = null;
                        
                        return retorno;
                    } 
            }
            else
            {
                try
                {
                    Biblioteca biblioteca = bibliotecas.get(noChamadaFuncao.getEscopo());
                    MetaDadosBiblioteca metaDadosBiblioteca = GerenciadorBibliotecas.getInstance().obterMetaDadosBiblioteca(biblioteca.getNome());
                    MetaDadosFuncao metaDadosFuncao = metaDadosBiblioteca.obterMetaDadosFuncoes().obter(noChamadaFuncao.getNome());
                    MetaDadosParametros metaDadosParametros = metaDadosFuncao.obterMetaDadosParametros();                    
                    
                    List<NoExpressao> param = noChamadaFuncao.getParametros();
                    
                    if (param != null && !param.isEmpty())
                    {
                        Object[] parametros = new Object[param.size()];

                        for (int indice = 0; indice < parametros.length; indice++)
                        {
                            MetaDadosParametro metaDadosParametro = metaDadosParametros.obter(indice);
                            
                            if (metaDadosParametro.getModoAcesso() == ModoAcesso.POR_VALOR)
                            {
                                referencia = false;
                                
                                parametros[indice] = param.get(indice).aceitar(this);
                                
                                if (metaDadosParametro.getTipoDado() != TipoDado.TODOS &&  parametros[indice].getClass() != metaDadosParametro.getTipoDado().getTipoJava())
                                {
                                    parametros[indice] = ConversorTipos.converter(parametros[indice], metaDadosParametro.getTipoDado().getTipoJava());
                                }
                            }
                            else
                            {
                                referencia = true;
                                parametros[indice] = obterReferencia(param.get(indice));
                                referencia = false;
                            }
                        }
                        
                        return biblioteca.chamarFuncao(noChamadaFuncao, parametros);
                    }
                    
                    else return biblioteca.chamarFuncao(noChamadaFuncao);
                }
                catch(ErroCarregamentoBiblioteca excecao)
                {
                    int linha = noChamadaFuncao.getTrechoCodigoFonteNome().getLinha();
                    int coluna = noChamadaFuncao.getTrechoCodigoFonteNome().getColuna();
                    
                    ErroExecucaoNaoTratado erroExecucaoNaoTratado = new ErroExecucaoNaoTratado(excecao);
                    erroExecucaoNaoTratado.setLinha(linha);
                    erroExecucaoNaoTratado.setColuna(coluna);
                    
                    throw new ExcecaoVisitaASA(erroExecucaoNaoTratado, asa, noChamadaFuncao);
                }
                catch (ErroExecucao excecao)
                {
                    int linha = noChamadaFuncao.getTrechoCodigoFonteNome().getLinha();
                    int coluna = noChamadaFuncao.getTrechoCodigoFonteNome().getColuna();
                    
                    excecao.setLinha(linha);
                    excecao.setColuna(coluna);
                    
                    throw new ExcecaoVisitaASA(excecao, asa, noChamadaFuncao);
                }
                catch (InterruptedException excecao)
                {
                    throw new ExcecaoVisitaASA(excecao, asa, noChamadaFuncao);
                }
            }

            return null;
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noChamadaFuncao);
        }
    }
        
    private Object obterReferencia(NoExpressao expressao) throws ExcecaoVisitaASA
    {
        Simbolo simbolo = (Simbolo) expressao.aceitar(this);
        
        if (simbolo instanceof Variavel)
        {
            final Variavel variavel = (Variavel) simbolo;
            
            return new ReferenciaVariavel() 
            {
                @Override
                public Object obterValor() throws ErroExecucao
                {
                    return variavel.getValor();
                }

                @Override
                public void definirValor(Object valor) throws ErroExecucao
                {
                    variavel.setValor(valor);
                }
            };
        }
        else if (simbolo instanceof Vetor)
        {
            final Vetor vetor = (Vetor) simbolo;
            
            return new ReferenciaVetor()
            {

                @Override
                public int numeroElementos()
                {
                    return vetor.getTamanho();
                }
                
                @Override
                public Object obterValor(int indice) throws ErroExecucao
                {
                    return vetor.getValor(indice);
                }

                @Override
                public void definirValor(Object valor, int indice) throws ErroExecucao
                {
                    vetor.setValor(indice, valor);
                }
            };
        }
        else if (simbolo instanceof Matriz)
        {
            final Matriz matriz = (Matriz) simbolo;
            
            return new ReferenciaMatriz() {

                @Override
                public Object obterValor(int linha, int coluna) throws ErroExecucao
                {
                    return matriz.getValor(linha, coluna);
                }

                @Override
                public void definirValor(Object valor, int linha, int coluna) throws ErroExecucao
                {
                    matriz.setValor(linha, coluna, valor);
                }

                @Override
                public int numeroLinhas()
                {
                    return matriz.getNumeroLinhas();
                }

                @Override
                public int numeroColunas()
                {
                    return matriz.getNumeroColunas();
                }
            };
        }
        
        throw new ExcecaoVisitaASA("Erro ao criar referência", asa, expressao);
    }

    private void limpar() throws Exception
    {
        if (programa.getSaida() != null)
        {
            programa.getSaida().limpar();
        }
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
        Funcao funcao = new Funcao(nome, tipoDados, quantificador, parametros, declaracaoFuncao);

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
            matriz = new Matriz(nome, tipoDado, noDeclaracaoMatriz, valores);
        }
        else
        {
            if (valores == null)
            {
                matriz = new Matriz(nome, tipoDado, noDeclaracaoMatriz, numeroLinhas, numeroColunas);
            }
            else
            {
                matriz = new Matriz(nome, tipoDado, noDeclaracaoMatriz, numeroLinhas, numeroColunas, valores);
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

        Variavel variavel = new Variavel(nome, tipoDado, noDeclaracaoVariavel);

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
            
            for (int indice = 0; indice < valores.size(); indice++)
            {
                Class classeValor = valores.get(indice).getClass();
                Class classeVetor = tipoDado.getTipoJava();
                
                if (classeValor != classeVetor)
                {
                    try
                    {
                        valores.set(indice, ConversorTipos.converter(valores.get(indice), classeVetor));
                    }
                    catch (ErroImpossivelConverterTipos erro)
                    {
                        int linha = noDeclaracaoVetor.getTrechoCodigoFonteNome().getLinha();
                        int coluna = noDeclaracaoVetor.getTrechoCodigoFonteNome().getColuna();
                                    
                        erro.setLinha(linha);
                        erro.setColuna(coluna);
                        
                        throw new ExcecaoVisitaASA(erro, asa, noDeclaracaoVetor);
                    }
                }
            }
        }

        Vetor vetor;

        if (tamanho == 0 && valores != null)
        {
            vetor = new Vetor(nome, tipoDado, noDeclaracaoVetor, valores);
        }
        else
        {
            if (valores == null)
            {
                vetor = new Vetor(nome, tipoDado, noDeclaracaoVetor, tamanho);
            }
            else
            {
                vetor = new Vetor(nome, tipoDado, noDeclaracaoVetor, tamanho, valores);
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
            throw new ExcecaoVisitaASA(new InterruptedException(), asa, null);
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
                Object retorno = noBloco.aceitar(this);
                
                if (!(noBloco instanceof NoExpressao) && retorno != null)
                {
                    return retorno;
                }
            }
        }
        catch (RetorneException re)
        {
            return re.getValor();
        }
        finally
        {
            try {
                memoria.desempilharEscopo();
            } catch (EmptyStackException e) {
            
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
                    Object valor = vetor.get(j);
                    if (valor instanceof NoExpressao)
                        valor = ((NoExpressao)valor).aceitar(this);
                    vetor.set(j, valor);
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
            int linha = referenciaVetor.getTrechoCodigoFonteNome().getLinha();
            int coluna = referenciaVetor.getTrechoCodigoFonteNome().getColuna();

            ErroIndiceVetorInvalido erroIndiceVetorInvalido = new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, vetor.getNome());
            erroIndiceVetorInvalido.setLinha(linha);
            erroIndiceVetorInvalido.setColuna(coluna);
            
            throw new ExcecaoVisitaASA(erroIndiceVetorInvalido, asa, referenciaVetor);
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
            int linhaErro = referenciaMatriz.getTrechoCodigoFonteNome().getLinha();
            int colunaErro = referenciaMatriz.getTrechoCodigoFonteNome().getColuna();
            
            ErroIndiceMatrizInvalido erroIndiceMatrizInvalido = new ErroIndiceMatrizInvalido(matriz, linha, coluna);
            erroIndiceMatrizInvalido.setLinha(linhaErro);
            erroIndiceMatrizInvalido.setColuna(colunaErro);
            
            throw new ExcecaoVisitaASA(erroIndiceMatrizInvalido, asa, referenciaMatriz);
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

                if (noPara.getIncremento() != null) 
                {
                    noPara.getIncremento().aceitar(this);
                }
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

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoLogicaIgualdade.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);

            return !(Boolean) operacaoLogicaIgualdade.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
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
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoLogicaMaior.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoLogicaMaiorIgual.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoLogicaMenor.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoLogicaMenorIgual.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoSoma noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object valorOpEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object valorOpDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoSoma.executar(noOperacao, valorOpEsq, valorOpDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoSubtracao noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoSubtracao.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoDivisao noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoDivisao.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoMultiplicacao.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoModulo noOperacao) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacao.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacao.getOperandoDireito().aceitar(this);
            
            return operacaoModulo.executar(noOperacao, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacao);
        }
    }

    @Override
    public Object visitar(NoOperacaoBitwiseLeftShift noOperacaoBitwiseLeftShift) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacaoBitwiseLeftShift.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacaoBitwiseLeftShift.getOperandoDireito().aceitar(this);
            
            return operacaoBitwiseLeftShift.executar(noOperacaoBitwiseLeftShift, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacaoBitwiseLeftShift);
        }
    }

    @Override
    public Object visitar(NoOperacaoBitwiseRightShift noOperacaoBitwiseRightShift) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacaoBitwiseRightShift.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacaoBitwiseRightShift.getOperandoDireito().aceitar(this);
            
            return operacaoBitwiseRightShift.executar(noOperacaoBitwiseRightShift, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacaoBitwiseRightShift);
        }
    }

    @Override
    public Object visitar(NoOperacaoBitwiseE noOperacaoBitwiseE) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacaoBitwiseE.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacaoBitwiseE.getOperandoDireito().aceitar(this);
            
            return operacaoBitwiseE.executar(noOperacaoBitwiseE, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacaoBitwiseE);
        }
    }

    @Override
    public Object visitar(NoOperacaoBitwiseOu noOperacaoBitwiseOu) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacaoBitwiseOu.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacaoBitwiseOu.getOperandoDireito().aceitar(this);
            
            return operacaoBitwiseOu.executar(noOperacaoBitwiseOu, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacaoBitwiseOu);
        }
    }

    @Override
    public Object visitar(NoOperacaoBitwiseXOR noOperacaoBitwiseXOR) throws ExcecaoVisitaASA
    {
        try
        {
            Object opEsq = noOperacaoBitwiseXOR.getOperandoEsquerdo().aceitar(this);
            Object opDir = noOperacaoBitwiseXOR.getOperandoDireito().aceitar(this);
            
            return operacaoBitwiseXOR.executar(noOperacaoBitwiseXOR, opEsq, opDir);
        }
        catch (ErroExecucao ex)
        {
            throw new ExcecaoVisitaASA(ex, asa, noOperacaoBitwiseXOR);
        }
    }
    
    @Override
    public Object visitar(NoBitwiseNao noOperacaoBitwiseNao) throws ExcecaoVisitaASA
    {
        return ~((Integer) noOperacaoBitwiseNao.getExpressao().aceitar(this));
    }
    
    @Override
    public Object visitar(NoInclusaoBiblioteca noInclusaoBiblioteca) throws ExcecaoVisitaASA
    {
        try
        {
            String nome = noInclusaoBiblioteca.getNome();
            Biblioteca biblioteca = GerenciadorBibliotecas.getInstance().registrarBiblioteca(nome, this.programa);

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

            Object valor = ((Variavel) simbolo).getValor();
            
            if (valor != null)
            {
                return valor;
            }
            else
            {
                throw new ExcecaoVisitaASA(new ErroVariavelNaoInicializada(noReferenciaVariavel), asa, noReferenciaVariavel);
            }
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

            return biblioteca.getValorVariavel(noReferenciaVariavel);
        }
        catch (Exception excecao)
        {
            throw new ExcecaoVisitaASA(new ErroExecucaoNaoTratado(excecao), asa, noReferenciaVariavel);
        }
    }

    @Override
    public Object visitar(NoContinue noContinue) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitar(NoTitulo noTitulo) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitar(NoVaPara noVaPara) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class PareException extends RuntimeException
    {
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
            String nome = noReferenciaMatriz.getNome();
            Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(nome));
            
            if (referencia)
            {
                return simbolo;
            }
            else 
            {            
                final int linha = (Integer) noReferenciaMatriz.getLinha().aceitar(this);
                final int coluna = (Integer) noReferenciaMatriz.getColuna().aceitar(this);
                
                final Matriz matriz = (Matriz) simbolo;

                Object valor;
                try
                {
                    valor = matriz.getValor(linha, coluna);
                }
                catch (IndexOutOfBoundsException ie)
                {
                    int linhaErro = noReferenciaMatriz.getTrechoCodigoFonteNome().getLinha();
                    int colunaErro = noReferenciaMatriz.getTrechoCodigoFonteNome().getColuna();
            
                    ErroIndiceMatrizInvalido erroIndiceMatrizInvalido = new ErroIndiceMatrizInvalido(matriz, linha, coluna);
                    erroIndiceMatrizInvalido.setLinha(linhaErro);
                    erroIndiceMatrizInvalido.setColuna(colunaErro);
                    
                    throw new ExcecaoVisitaASA(erroIndiceMatrizInvalido, asa, noReferenciaMatriz);
                }

                 if (valor == null)
                 {
                    throw new ExcecaoVisitaASA(new ErroValorVetorMatrizNaoInicializado(noReferenciaMatriz, linha, coluna), asa, noReferenciaMatriz);
                }
                
                while (valor instanceof NoExpressao)
                {
                    valor = ((NoExpressao) valor).aceitar(this);
                }

                return valor;
            }
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
            Simbolo simbolo = extrairSimbolo(memoria.getSimbolo(noReferenciaVetor.getNome()));
            
            if (referencia)
            {
                return simbolo;
            }
            else
            {            
                final Vetor vetor = (Vetor) simbolo;
                final int indice = (Integer) noReferenciaVetor.getIndice().aceitar(this);

                
                Object valor;
                try
                {
                    valor = vetor.getValor(indice);
                }
                catch (IndexOutOfBoundsException aioobe)
                {
                    ErroIndiceVetorInvalido erroIndiceVetorInvalido = new ErroIndiceVetorInvalido(vetor.getTamanho(), indice, noReferenciaVetor.getNome());
                    
                    erroIndiceVetorInvalido.setLinha(noReferenciaVetor.getIndice().getTrechoCodigoFonte().getLinha());
                    erroIndiceVetorInvalido.setColuna(noReferenciaVetor.getIndice().getTrechoCodigoFonte().getColuna());
                    
                    throw new ExcecaoVisitaASA(erroIndiceVetorInvalido, null, noReferenciaVetor);
                }
                
                if (valor == null)
                {                    
                    throw new ExcecaoVisitaASA(new ErroValorVetorMatrizNaoInicializado(noReferenciaVetor, indice), asa, noReferenciaVetor);
                }
                
                while (valor instanceof NoExpressao)
                {
                    valor = ((NoExpressao) valor).aceitar(this);
                }

                return valor;
            }
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
        {
            throw new ExcecaoVisitaASA(excecaoSimboloNaoDeclarado, asa, noReferenciaVetor);
        }
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        Object retorno = TipoDado.VAZIO;
        if (noRetorne.getExpressao() != null) {
            retorno = noRetorne.getExpressao().aceitar(this);
        }
        throw new RetorneException(retorno);
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
        List<Object> valores = new ArrayList<>(noVetor.getValores().size());

        if (valoresVetor != null)
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
                    throw new ExcecaoVisitaASA(new ErroIndiceVetorInvalido(valores.size(), i, ultimaReferenciaAcessada), asa, noVetor);
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
                simbolo = new Ponteiro(noDeclaracaoParametro.getNome(), noDeclaracaoParametro, (Simbolo) valorPassadoParametro);
                break;
            case POR_VALOR:
                String nome = noDeclaracaoParametro.getNome();
                Quantificador quantificador = noDeclaracaoParametro.getQuantificador();
                TipoDado tipoDado = noDeclaracaoParametro.getTipoDado();
                switch (quantificador)
                {
                    case VALOR:
                    {
                        simbolo = new Variavel(nome, tipoDado, noDeclaracaoParametro, valorPassadoParametro);
                        break;
                    }
                    case VETOR:
                    {
                        simbolo = new Vetor(nome, tipoDado, noDeclaracaoParametro, (List<Object>) valorPassadoParametro);
                        break;
                    }
                    case MATRIZ:
                    {
                        simbolo = new Matriz(nome, tipoDado, noDeclaracaoParametro, (List<List<Object>>) valorPassadoParametro);
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
        final Saida saida = programa.getSaida();
        
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
                        throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
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
                            throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
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
                                throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
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
                                    throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
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
                                        throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
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
        final Entrada entrada = programa.getEntrada();
        
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
                            
                            InputHandler mediador = new InputHandler();
                            entrada.solicitaEntrada(tipoDado, mediador);

                            if (mediador.getValor() == null)
                            {
                                synchronized (this)
                                {
                                    wait();
                                }
                            }
                            
                            valor = mediador.getValor();
                        }
                        catch (Exception ex)
                        {
                            throw new ExcecaoVisitaASA(ex, asa, chamadaFuncao);
                        }
                        
                        if (valor == null)
                        {

                            throw new ExcecaoVisitaASA(new ErroValorEntradaInvalido(tipoDado, chamadaFuncao.getTrechoCodigoFonte().getLinha(), chamadaFuncao.getTrechoCodigoFonte().getColuna()), asa, chamadaFuncao);
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
    
    private class InputHandler implements InputMediator, Armazenador
    {
        private Object valor;
        
        @Override
        public synchronized Object getValor()
        {
            return valor;
        }

        @Override
        public void setValor(Object valor)
        {
            synchronized (Interpretador.this)
            {
                this.valor = valor;
                Interpretador.this.notifyAll();
            }
        }
    }
}
