package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.ModoAcesso;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoCaso;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoEnquanto;
import br.univali.portugol.nucleo.asa.NoEscolha;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoFacaEnquanto;
import br.univali.portugol.nucleo.asa.NoInclusaoBiblioteca;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoMatriz;
import br.univali.portugol.nucleo.asa.NoMenosUnario;
import br.univali.portugol.nucleo.asa.NoNao;
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
import br.univali.portugol.nucleo.asa.NoPara;
import br.univali.portugol.nucleo.asa.NoPare;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.NoRetorne;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroCarregamentoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.GerenciadorBibliotecas;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosParametro;
import br.univali.portugol.nucleo.bibliotecas.base.MetaDadosParametros;
import br.univali.portugol.nucleo.execucao.InterpretadorImpl;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.ExcecaoSimboloNaoDeclarado;
import br.univali.portugol.nucleo.simbolos.Funcao;
import br.univali.portugol.nucleo.simbolos.ObservadorMemoria;
import br.univali.portugol.nucleo.simbolos.Ponteiro;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepuradorImpl extends InterpretadorImpl implements Depurador, InterfaceDepurador, ObservadorMemoria
{
    private List<NoBloco> eleitos;
    private List<DepuradorListener> listeners = new ArrayList<DepuradorListener>();
    private final boolean detalhado;
    
    
    @Override
    public synchronized void proximo()
    {
        notifyAll();
    }
    
    public void disparaDestacar(int linha)
    {
        for (DepuradorListener l : listeners)
        {
            l.highlightLinha(linha);
        }
    }
    
    public void disparaDestacar(TrechoCodigoFonte trechoCodigoFonte)
    {
        int linha = trechoCodigoFonte.getLinha();
        int coluna = trechoCodigoFonte.getColuna();
        int tamanho = trechoCodigoFonte.getTamanhoTexto();
        for (DepuradorListener l : listeners)
        {
            l.HighlightDetalhadoAtual(linha,coluna,tamanho);
        }
    }
    
    private List<Simbolo> getSimbolosAlterados(NoExpressao expressao)
    {
        final List<Simbolo> simbolosAlterados = new ArrayList<>();
        VisitanteASA visitante = new VisitanteASABasico() {
            
            
            @Override
            public Object visitar(NoOperacaoAtribuicao noOperacaoAtribuicao) throws ExcecaoVisitaASA
            {
                NoReferencia ref = (NoReferencia) noOperacaoAtribuicao.getOperandoEsquerdo();
                try
                {
                    
                    Simbolo simbolo = memoria.getSimbolo(ref.getNome());
                    simbolosAlterados.add(simbolo);
                    if (simbolo instanceof Ponteiro) {
                        while (simbolo instanceof Ponteiro){
                            simbolo = ((Ponteiro)simbolo).getSimboloApontado();
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
                    for (int i = 0; i < chamadaFuncao.getParametros().size(); i++){
                        if (obterModosAcessoEsperados.get(i) == ModoAcesso.POR_REFERENCIA){
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
                List<ModoAcesso> modosAcesso = new ArrayList<ModoAcesso>();

                if (chamadaFuncao.getEscopo() == null)
                {
                    if (chamadaFuncao.getNome().equals("leia"))
                    {
                       for (NoExpressao parametro : chamadaFuncao.getParametros())
                        {
                            modosAcesso.add(ModoAcesso.POR_REFERENCIA);
                        } 
                    } else if (chamadaFuncao.getNome().equals("escreva"))
                    {
                        for (NoExpressao parametro : chamadaFuncao.getParametros())
                        {
                            modosAcesso.add(ModoAcesso.POR_VALOR);
                        } 
                    } else {
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
    public void executar(Programa programa, String[] parametros) throws ErroExecucao
    {
        disparaDepuracaoInicializada();
        super.executar(programa, parametros);
    }

    @Override
    public void removeListener(DepuradorListener listener)
    {
        listeners.remove(listener);
    }

    public DepuradorImpl(List<NoBloco> nosParada, boolean detalhado)
    {
        eleitos = nosParada;
        this.detalhado = detalhado;
        memoria.adicionarObservador(this);
    }
    
    public DepuradorImpl(List<NoBloco> nosParada)
    {
        this(nosParada,false);
    }

    @Override
    public Object visitar(NoCadeia no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {                
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoCaracter no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else { 
                disparaDestacar(no.getTrechoCodigoFonte().getLinha()); 
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoCaso no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {                
                disparaDestacar(no.getExpressao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getExpressao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoChamadaFuncao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object value = super.visitar(no);
        
        if (no.getEscopo() != null || (no.getEscopo() == null && no.getNome().equals("leia")))
        {
            disparaSimbolosAlterados(getSimbolosAlterados(no));
        }
        
        return value;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonteNome());
            } else {
                disparaDestacar(no.getTrechoCodigoFonteNome().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object result = super.visitar(no);
        return result;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonteNome());
            } else {
                disparaDestacar(no.getTrechoCodigoFonteNome().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object result = super.visitar(no);
        return result;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonteNome());
            } else {
                disparaDestacar(no.getTrechoCodigoFonteNome().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object result = super.visitar(no);
        return result;
    }

    @Override
    public Object visitar(NoEnquanto no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoEscolha no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
             if (detalhado) {
                disparaDestacar(no.getExpressao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getExpressao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoFacaEnquanto no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoInteiro no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
               disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoLogico no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
               disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoMatriz no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoMenosUnario no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoNao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoPara no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
             if (detalhado) {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoPare no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReal no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaMatriz no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaVariavel no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaVetor no) throws ExcecaoVisitaASA
    {
        if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
        synchronized (this)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoRetorne no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoSe no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getCondicao().getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoVetor no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoDeclaracaoParametro no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonteNome());
            } else {
                disparaDestacar(no.getTrechoCodigoFonteNome().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object result = super.visitar(no);
        return result;
    }

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        final Object result = super.visitar(no);
        disparaSimbolosAlterados(getSimbolosAlterados(no));
        return result;
    }

    @Override
    public Object visitar(NoOperacaoLogicaE no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaOU no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaior no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoSoma no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoSubtracao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoDivisao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoOperacaoModulo no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoInclusaoBiblioteca no) throws ExcecaoVisitaASA
    {
        if (eleitos.contains(no))
        {
            if (detalhado) {
                disparaDestacar(no.getTrechoCodigoFonte());
            } else {
                disparaDestacar(no.getTrechoCodigoFonte().getLinha());
            }
            synchronized (this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }
        return super.visitar(no);
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
