package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.No;
import br.univali.portugol.nucleo.asa.NoBitwiseNao;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoCaso;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoContinue;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
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
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseE;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseLeftShift;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseOu;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseRightShift;
import br.univali.portugol.nucleo.asa.NoOperacaoBitwiseXOR;
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
import br.univali.portugol.nucleo.asa.NoTitulo;
import br.univali.portugol.nucleo.asa.NoVaPara;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.asa.VisitanteASA;

/**
 *
 * @author Luiz Fernando
 */
final class SetadorPontosParada implements VisitanteASA
{
    private int linha;

    public boolean adicionarPontoParada(int linha, ArvoreSintaticaAbstrataPrograma asa)
    {
        this.linha = linha;
        //this.pontoParadaSetado = false;

        try
        {
            return (boolean)asa.aceitar(this);
        }
        catch (ExcecaoVisitaASA ex)
        {
            ex.printStackTrace(System.err);
        }

        return false;
    }

    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
        for (NoDeclaracao declaracao : asap.getListaDeclaracoesGlobais())
        {
            if ((Boolean) declaracao.aceitar(this))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        NoExpressao expressao = noCaso.getExpressao();
        if (expressao != null)
        {
            if (expressao.getTrechoCodigoFonte().getLinha() == linha)
            {
                expressao.definirPontoParada();
                return true;
            }
        }
        else
        {
            if (noCaso.getTrechoCodigoFonte().getLinha() == linha)
            {
                noCaso.definirPontoParada();
                return true;
            }

        }
        if (noCaso.getBlocos() != null)
        {
            for (NoBloco filho : noCaso.getBlocos())
            {
                if((Boolean)filho.aceitar(this)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        if (chamadaFuncao.getTrechoCodigoFonteNome().getLinha() == linha)
        {
            chamadaFuncao.definirPontoParada();
            return true;
        }
        return false;
    }

    @Override
    public Object visitar(NoContinue noContinue) throws ExcecaoVisitaASA
    {
        if (noContinue.getTrechoCodigoFonte().getLinha() == linha)
        {
            noContinue.definirPontoParada();
            return true;
        }
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {
        if (declaracaoFuncao.getTrechoCodigoFonteNome().getLinha() == linha)
        {
            declaracaoFuncao.definirPontoParada();
            return true;
        }
        for (NoBloco filho : declaracaoFuncao.getBlocos())
        {
            if ((Boolean) filho.aceitar(this))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
        if (noDeclaracaoMatriz.getTrechoCodigoFonteNome().getLinha() == linha)
        {
            noDeclaracaoMatriz.definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        if (noDeclaracaoVariavel.getTrechoCodigoFonteNome().getLinha() == linha)
        {
            noDeclaracaoVariavel.definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
        if (noDeclaracaoVetor.getTrechoCodigoFonteNome().getLinha() == linha)
        {
            noDeclaracaoVetor.definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        if (noEnquanto.getCondicao().getTrechoCodigoFonte().getLinha() == linha)
        {
            noEnquanto.getCondicao().definirPontoParada();

            return true;
        }

        for (NoBloco bloco : noEnquanto.getBlocos())
        {
            if ((Boolean) bloco.aceitar(this))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        if (noEscolha.getExpressao().getTrechoCodigoFonte().getLinha() == linha)
        {
            noEscolha.getExpressao().definirPontoParada();

            return true;
        }

        for (NoCaso caso : noEscolha.getCasos())
        {
            if ((Boolean) caso.aceitar(this))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        if (noFacaEnquanto.getTrechoCodigoFonte().getLinha() == linha)
        {
            noFacaEnquanto.definirPontoParada();

            return true;
        }

        for (NoBloco no : noFacaEnquanto.getBlocos())
        {
            if ((Boolean) no.aceitar(this))
            {
                return true;
            }
        }

        if (noFacaEnquanto.getCondicao().getTrechoCodigoFonte().getLinha() == linha)
        {
            noFacaEnquanto.getCondicao().definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoNao noNao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaIgualdade noOperacaoLogicaIgualdade) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaDiferenca noOperacaoLogicaDiferenca) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao noOperacaoAtribuicao) throws ExcecaoVisitaASA
    {
        if (noOperacaoAtribuicao.getTrechoCodigoFonteOperador().getLinha() == linha)
        {
            noOperacaoAtribuicao.definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaE noOperacaoLogicaE) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaOU noOperacaoLogicaOU) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaior noOperacaoLogicaMaior) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaMaiorIgual noOperacaoLogicaMaiorIgual) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenor noOperacaoLogicaMenor) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoLogicaMenorIgual noOperacaoLogicaMenorIgual) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoSoma noOperacaoSoma) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoSubtracao noOperacaoSubtracao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoDivisao noOperacaoDivisao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao noOperacaoMultiplicacao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoModulo noOperacaoModulo) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoBitwiseLeftShift noOperacaoBitwiseLeftShift) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoBitwiseRightShift noOperacaoBitwiseRightShift) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoBitwiseE noOperacaoBitwiseE) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoBitwiseOu noOperacaoBitwiseOu) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoOperacaoBitwiseXOR noOperacaoBitwiseXOR) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoBitwiseNao noOperacaoBitwiseNao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        if (noPara.getTrechoCodigoFonte().getLinha() == linha)
        {
            noPara.definirPontoParada();

            return true;
        }

        for (NoBloco no : noPara.getBlocos())
        {
            if ((Boolean) no.aceitar(this))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        if (noPare.getTrechoCodigoFonte().getLinha() == linha)
        {
            noPare.definirPontoParada();

            return true;
        }

        return false;
    }

    @Override
    public Object visitar(NoReal noReal) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        return noRetorne.getExpressao().aceitar(this);
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        if (noSe.getCondicao().getTrechoCodigoFonte().getLinha() == linha)
        {
            noSe.getCondicao().definirPontoParada();

            return true;
        }

        for (NoBloco no : noSe.getBlocosVerdadeiros())
        {
            if ((Boolean) no.aceitar(this))
            {
                return true;
            }
        }

        for (NoBloco no : noSe.getBlocosFalsos())
        {
            if ((Boolean) no.aceitar(this))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object visitar(NoTitulo noTitulo) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoVaPara noVaPara) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoInclusaoBiblioteca noInclusaoBiblioteca) throws ExcecaoVisitaASA
    {
        return false;
    }
}
