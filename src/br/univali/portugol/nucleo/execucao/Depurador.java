package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.bibliotecas.base.*;
import br.univali.portugol.nucleo.execucao.erros.ErroObservadorDepuracao;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.simbolos.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Depurador extends Interpretador implements ObservadorMemoria
{
    public static enum Estado
    {
        BREAK_POINT, //usuário clicou no botão que executa o programa até atingir um ponto de parada, caso exista algum
        STEP_INTO, //não utilizado no momento
        STEP_OVER, //executa passo a passo, para em todos os nós que são paráveis (nem todos são)
        PARADO//esperando o usuário iniciar a execução
    }
    
    private final List<ObservadorExecucao> observadores = new ArrayList<>();

    private Programa programa;
    private Estado estado = Estado.PARADO;


    
    
    public Estado getEstado()
    {
        return estado;
    }

    public void setEstado(Estado estado)
    {
        this.estado = estado;
    }

    public synchronized void continuar(Depurador.Estado estado)
    {
        if (this.isLendo())
        {
            setLeituraIgnorada(true);
        }
        
        this.estado = estado;
        notifyAll();
    }

    public void disparaDestacar(int linha)
    {
        if (linha >= 0)
        {
            for (ObservadorExecucao observador : observadores)
            {
                observador.highlightLinha(linha);
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
            
            for (ObservadorExecucao observador : observadores)
            {
                observador.highlightDetalhadoAtual(linha, coluna, tamanho);
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
                    Logger.getLogger(Depurador.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(Depurador.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(Depurador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Depurador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return simbolosAlterados;
    }

    public void disparaSimbolosAlterados(List<Simbolo> simbolos)
    {
        for (ObservadorExecucao l : observadores)
        {
            l.simbolosAlterados(simbolos);
        }
    }

    /**
     * Permite adicionar um observador à execução do programa. Os observadores
     * serão notificados sobre o início e o término da execução, bem como erros
     * em tempo de execução que vierem a ocorrer.
     *
     * @param observadores os observadores de execução a serem registrados.
     * @since 1.0
     */
    public void adicionarObservadoresExecucao(List<ObservadorExecucao> observadores)
    {
        this.observadores.addAll(observadores);
    }

    /**
     * Remove um observador de execução previamente registrado utilizando o
     * método 
     * {@link Programa#adicionarObservadorExecucao(br.univali.portugol.nucleo.execucao.ObservadorExecucao) }.
     * Uma vez removido, o observador não será mais notificado sobre o estado da
     * execução do programa nem dos erros em tempo de execução que vierem a
     * ocorrer.
     *
     * @param observadores os observadores de execução previamente registrados.
     * @since 1.0
     */
    public void removerObservadoresExecucao(List<ObservadorExecucao> observadores)
    {
        this.observadores.removeAll(observadores);
    }    
    
    @Override
    public void executar(Programa programa, String[] parametros) throws ErroExecucao, InterruptedException
    {
        if (!observadores.isEmpty())
        {
            this.programa = programa;

            if (estado != Estado.BREAK_POINT)
            {
                destacarFuncaoInicial();
            }
            super.executar(programa, parametros);

            if (estado != Estado.BREAK_POINT)
            {
                destacarFuncaoInicial();
            }

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

    public Depurador()
    {
        this.memoria.adicionarObservador(Depurador.this);
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
        if(no.getExpressao() != null){
            realizarParada(no, no.getExpressao().getTrechoCodigoFonte());
        }
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
        if (trechoCodigoFonte == null) 
        {
            return;
        }
        
        if (no.ehParavel(this.estado) || funcaoInicial(no))
        {
            if ( this.estado == Estado.STEP_INTO){
            
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
        for (ObservadorExecucao l : observadores)
        {
            l.simboloDeclarado(simbolo);
        }
    }

    @Override
    public void simboloRemovido(Simbolo simbolo)
    {
        for (ObservadorExecucao l : observadores)
        {
            l.simboloRemovido(simbolo);
        }
    }
}
