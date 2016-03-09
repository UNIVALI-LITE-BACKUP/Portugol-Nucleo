/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoBitwiseNao;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoCaso;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoContinue;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
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
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import java.util.List;

/**
 *
 * @author 4276663
 */
public class AnalisadorRetornoDeFuncao implements VisitanteASA
{
    /**
     * Analisa se na declaração de função passada existe 100% de chance entrar
     * em algum "retorne".
     *
     * @param noDeclaracaoFuncao no a ser analisado
     * @return true se entrar em algum retorne e false se não.
     * @throws br.univali.portugol.nucleo.asa.ExcecaoVisitaASA
     */
    public boolean possuiRetornoObrigatorio(NoDeclaracaoFuncao noDeclaracaoFuncao) throws ExcecaoVisitaASA
    {
        return (Boolean) visitar(noDeclaracaoFuncao.getBlocos());
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        return true;
    }

    public Object visitar(List<NoBloco> noBlocos) throws ExcecaoVisitaASA
    {
        for (NoBloco noBloco : noBlocos)
        {
            if ((Boolean) noBloco.aceitar(this) == true)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        if (noSe.getBlocosFalsos() == null)
        {
            return false;
        }
        Boolean ambosPossuemRetorno = (Boolean) visitar(noSe.getBlocosVerdadeiros()) && (Boolean) visitar(noSe.getBlocosFalsos());
        return ambosPossuemRetorno;
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        List<NoCaso> noCasos = noEscolha.getCasos();
        int tamanhoNoCasos = noCasos.size();
        for (int indice = 0; indice < tamanhoNoCasos; indice++)
        {
            NoCaso noCaso = noCasos.get(indice);
            boolean retorna;
            boolean possuiPare = false;
            //Verifica se possui pare
            List<NoBloco> noBlocos = noCaso.getBlocos();
            for (NoBloco noBloco : noBlocos)
            {
                if (noBloco instanceof NoPare)
                {
                    possuiPare = true;
                    break;
                }
            }
            //Verifica se possui retorno
            retorna = (Boolean) visitar(noCaso.getBlocos());
            if(!retorna && (possuiPare || indice == tamanhoNoCasos-1)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        return null;
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
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
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoContinue noContinue) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        return false;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
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
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
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
