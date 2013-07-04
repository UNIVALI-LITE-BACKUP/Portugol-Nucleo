package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
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
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.NoRetorne;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.execucao.InterpretadorImpl;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.util.ArrayList;
import java.util.List;

public class DepuradorImpl extends InterpretadorImpl implements Depurador, InterfaceDepurador
{
    List<NoBloco> visitar;
    List<DepuradorListener> listeners = new ArrayList<DepuradorListener>();

    public void disparaDestacarLinha(int linha)
    {
        for(DepuradorListener l : listeners){
            l.linhaAtual(linha);
        }
    }
    
    public void disparaDepuracaoInicializada()
    {
        for(DepuradorListener l : listeners){
            l.depuracaoInicializada(this);
        }
    }
    
    @Override
    public void addListener(DepuradorListener listener){
        if (!listeners.contains(listener)){
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
    public void removeListener(DepuradorListener listener){
        listeners.remove(listener);
    }

    public DepuradorImpl(List<NoBloco> nosParada)
    {
        visitar = nosParada;
    }

    @Override
    public Object visitar(NoCadeia no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getExpressao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
    public Object visitar(NoDeclaracaoMatriz no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonteNome().getLinha());
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
    public Object visitar(NoDeclaracaoVariavel no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonteNome().getLinha());
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
    public Object visitar(NoDeclaracaoVetor no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonteNome().getLinha());
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
    public Object visitar(NoEnquanto no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getCondicao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getExpressao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getCondicao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getCondicao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            //disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
            /*synchronized (this)
             {
             try
             {
             wait();
             }
             catch (InterruptedException ex)
             {
             throw new RuntimeException(ex);
             }
             }*/
        }
        return super.visitar(no);
    }

    @Override
    public Object visitar(NoReferenciaVetor no) throws ExcecaoVisitaASA
    {
        disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getExpressao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getCondicao().getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonteNome().getLinha());
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

    public synchronized void proximo()
    {
        notifyAll();
    }

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
    public Object visitar(NoOperacaoLogicaE no) throws ExcecaoVisitaASA
    {
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
        if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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
       if (visitar.contains(no))
        {
            disparaDestacarLinha(no.getTrechoCodigoFonte().getLinha());
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

}
