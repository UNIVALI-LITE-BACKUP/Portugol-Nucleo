package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.*;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.execucao.erros.ErroObservadorDepuracao;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepuradorImpl extends Interpretador implements Depurador, InterfaceDepurador, ObservadorMemoria
{
    private final boolean detalhado;
    private final List<DepuradorListener> listeners = new ArrayList<>();

    private Programa programa;
    private List<NoBloco> eleitos;

    @Override
    public synchronized void proximo()
    {
        notifyAll();
    }

    public void disparaDestacar(int linha)
    {
        if (linha >= 0)
        {
            for (DepuradorListener l : listeners)
            {
                l.highlightLinha(linha);
            }
        }
    }

    public void disparaDestacar(TrechoCodigoFonte trechoCodigoFonte)
    {
        if (trechoCodigoFonte != null)
        {
            int linha = trechoCodigoFonte.getLinha();
            int coluna = trechoCodigoFonte.getColuna();
            int tamanho = trechoCodigoFonte.getTamanhoTexto();
            for (DepuradorListener l : listeners)
            {
                l.HighlightDetalhadoAtual(linha, coluna, tamanho);
            }
        }
    }

    private List<Simbolo> getSimbolosAlterados(NoExpressao expressao)
    {
        final List<Simbolo> simbolosAlterados = new ArrayList<>();
        VisitanteASA visitante = new VisitanteASABasico()
        {

            @Override
            public Object visitar(NoOperacaoAtribuicao noOperacaoAtribuicao) throws ExcecaoVisitaASA
            {
                NoReferencia ref = (NoReferencia) noOperacaoAtribuicao.getOperandoEsquerdo();
                try
                {

                    Simbolo simbolo = memoria.getSimbolo(ref.getNome());
                    simbolosAlterados.add(simbolo);
                    if (simbolo instanceof Ponteiro)
                    {
                        while (simbolo instanceof Ponteiro)
                        {
                            simbolo = ((Ponteiro) simbolo).getSimboloApontado();
                        }
                        simbolosAlterados.add(simbolo);
                    }

                }
                catch (ExcecaoSimboloNaoDeclarado ex)
                {
                    Logger.getLogger(DepuradorImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }

            @Override
            public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
            {
                List<ModoAcesso> obterModosAcessoEsperados = obterModosAcessoEsperados(chamadaFuncao);

                if (chamadaFuncao.getParametros() != null)
                {
                    for (int i = 0; i < chamadaFuncao.getParametros().size(); i++)
                    {
                        if (obterModosAcessoEsperados.get(i) == ModoAcesso.POR_REFERENCIA)
                        {
                            NoReferencia ref = (NoReferencia) chamadaFuncao.getParametros().get(i);
                            try
                            {
                                Simbolo simbolo = memoria.getSimbolo(ref.getNome());
                                simbolosAlterados.add(simbolo);
                            }
                            catch (ExcecaoSimboloNaoDeclarado ex)
                            {
                                Logger.getLogger(DepuradorImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }

                return null;
            }

            private List<ModoAcesso> obterModosAcessoEsperados(NoChamadaFuncao chamadaFuncao)
            {
                List<ModoAcesso> modosAcesso = new ArrayList<>();

                if (chamadaFuncao.getEscopo() == null)
                {
                    if (chamadaFuncao.getNome().equals("leia"))
                    {
                        for (NoExpressao parametro : chamadaFuncao.getParametros())
                        {
                            modosAcesso.add(ModoAcesso.POR_REFERENCIA);
                        }
                    }
                    else
                    {
                        if (chamadaFuncao.getNome().equals("escreva"))
                        {
                            for (NoExpressao parametro : chamadaFuncao.getParametros())
                            {
                                modosAcesso.add(ModoAcesso.POR_VALOR);
                            }
                        }
                        else
                        {
                            try
                            {
                                Funcao funcao = (Funcao) memoria.getSimbolo(chamadaFuncao.getNome());

                                for (NoDeclaracaoParametro parametro : funcao.getParametros())
                                {
                                    //nao olhar mesmo que seja por referencia.
                                    //pois esta sendo feito na atribuicao, quando o simbolo e ponteiro.
                                    //PS: meu teclado nao tem acento.
                                    modosAcesso.add(ModoAcesso.POR_VALOR);
                                }
                            }
                            catch (ExcecaoSimboloNaoDeclarado ex)
                            {
                                // Não faz nada aqui
                            }
                        }
                    }
                }
                else
                {
                    try
                    {
                        Biblioteca biblioteca = bibliotecas.get(chamadaFuncao.getEscopo());
                        MetaDadosBiblioteca metaDadosBiblioteca = GerenciadorBibliotecas.getInstance().obterMetaDadosBiblioteca(biblioteca.getNome());
                        MetaDadosFuncao metaDadosFuncao = metaDadosBiblioteca.obterMetaDadosFuncoes().obter(chamadaFuncao.getNome());
                        MetaDadosParametros metaDadosParametros = metaDadosFuncao.obterMetaDadosParametros();

                        for (MetaDadosParametro metaDadosParametro : metaDadosParametros)
                        {
                            modosAcesso.add(metaDadosParametro.getModoAcesso());
                        }
                    }
                    catch (ErroCarregamentoBiblioteca ex)
                    {
                        Logger.getLogger(DepuradorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                return modosAcesso;
            }

        };
        try
        {
            expressao.aceitar(visitante);
        }
        catch (ExcecaoVisitaASA ex)
        {
            Logger.getLogger(DepuradorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return simbolosAlterados;
    }

    public void disparaSimbolosAlterados(List<Simbolo> simbolos)
    {
        for (DepuradorListener l : listeners)
        {
            l.simbolosAlterados(simbolos);
        }
    }

    public void disparaDepuracaoInicializada()
    {
        for (DepuradorListener l : listeners)
        {
            l.depuracaoInicializada(this);
        }
    }

    @Override
    public void addListeners(List<DepuradorListener> listeners)
    {
        this.listeners.addAll(listeners);
    }

    @Override
    public void addListener(DepuradorListener listener)
    {
        if (!listeners.contains(listener))
        {
            listeners.add(listener);
        }
    }

    @Override
    public void executar(Programa programa, String[] parametros) throws ErroExecucao, InterruptedException
    {
        if (!listeners.isEmpty())
        {
            this.programa = programa;

            disparaDepuracaoInicializada();
            destacarFuncaoInicial();
            super.executar(programa, parametros);
            destacarFuncaoInicial();
        }
        else
        {
            throw new ErroObservadorDepuracao();
        }
    }

    private boolean funcaoInicial(No no)
    {
        if (no instanceof NoDeclaracaoFuncao)
        {
            return ((NoDeclaracaoFuncao) no).getNome().equals(this.programa.getFuncaoInicial());
        }

        return false;
    }

    private void destacarFuncaoInicial() throws InterruptedException
    {
        NoDeclaracao funcaoInicial = obterFuncaoInicial(programa);

        if (funcaoInicial != null)
        {
            try
            {
                realizarParada(funcaoInicial, funcaoInicial.getTrechoCodigoFonteNome());
            }
            catch (ExcecaoVisitaASA excecao)
            {
                if (excecao.getCause() instanceof InterruptedException)
                {
                    throw (InterruptedException) excecao.getCause();
                }
            }
        }
    }

    private NoDeclaracao obterFuncaoInicial(Programa programa)
    {
        for (NoDeclaracao declaracao : programa.getArvoreSintaticaAbstrata().getListaDeclaracoesGlobais())
        {
            if (declaracao instanceof NoDeclaracaoFuncao && declaracao.getNome().equals(programa.getFuncaoInicial()))
            {
                return declaracao;
            }
        }

        return null;
    }

    @Override
    public void removeListener(DepuradorListener listener)
    {
        listeners.remove(listener);
    }

    public DepuradorImpl(List<NoBloco> nosParada, boolean detalhado)
    {
        this.eleitos = nosParada;
        this.detalhado = detalhado;
        this.memoria.adicionarObservador(DepuradorImpl.this);
    }

    public DepuradorImpl(List<NoBloco> nosParada)
    {
        this(nosParada, false);
    }

    @Override
    public Object visitar(NoCadeia no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoCaracter no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoCaso no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getExpressao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoChamadaFuncao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());

        final Object value = super.visitar(no);

        if (no.getEscopo() != null || (no.getEscopo() == null && no.getNome().equals("leia")))
        {
            disparaSimbolosAlterados(getSimbolosAlterados(no));
        }

        if (no.getEscopo() == null && !no.getNome().equals("leia") && !no.getNome().equals("escreva") && !no.getNome().equals("limpa"))
        {
            realizarParada(no, no.getTrechoCodigoFonte());
        }

        return value;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonteNome());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonteNome());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonteNome());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoEnquanto no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getCondicao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoEscolha no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getExpressao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoFacaEnquanto no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getCondicao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoInteiro no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoLogico no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoMatriz no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoMenosUnario no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoNao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoPara no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getCondicao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoPare no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReal no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaMatriz no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaVariavel no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaVetor no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoRetorne no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoSe no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getCondicao().getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoVetor no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoDeclaracaoParametro no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonteNome());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        final Object result = super.visitar(no);

        disparaSimbolosAlterados(getSimbolosAlterados(no));

        return result;
    }

    @Override
    public Object visitar(NoOperacaoLogicaE no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaOU no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaior no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoSoma no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoSubtracao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoDivisao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoModulo no) throws ExcecaoVisitaASA
    {
        realizarParada(no, no.getTrechoCodigoFonte());
        return super.visitar(no);
    }

    private void realizarParada(NoBloco no, TrechoCodigoFonte trechoCodigoFonte) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no) || funcaoInicial(no))
        {
            if (detalhado)
            {
                disparaDestacar(trechoCodigoFonte);
            }
            else
            {
                disparaDestacar((trechoCodigoFonte != null) ? trechoCodigoFonte.getLinha() : -1);
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new ExcecaoVisitaASA(ex, this.programa.getArvoreSintaticaAbstrata(), no);
                }
            }
        }
    }

    @Override
    public void simboloAdicionado(Simbolo simbolo)
    {
        for (DepuradorListener l : listeners)
        {
            l.simboloDeclarado(simbolo);
        }
    }

    @Override
    public void simboloRemovido(Simbolo simbolo)
    {
        for (DepuradorListener l : listeners)
        {
            l.simboloRemovido(simbolo);
        }
    }
}
