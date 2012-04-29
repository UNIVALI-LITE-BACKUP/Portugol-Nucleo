package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noshchang
 * 
 */
public interface VisitanteASA
{
    void visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA;

    void visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA;

    void visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA;

    void visitar(NoCaso noCaso) throws ExcecaoVisitaASA;

    void visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA;

    void visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA;

    void visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA;

    void visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA;

    void visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA;

    void visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA;

    void visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA;

    void visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA;

    void visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA;

    void visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA;

    void visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA;

    void visitar(NoLogico noLogico) throws ExcecaoVisitaASA;

    void visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA;

    void visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA;

    void visitar(NoNao noNao) throws ExcecaoVisitaASA;

    void visitar(NoOperacao noOperacao) throws ExcecaoVisitaASA;

    void visitar(NoPara noPara) throws ExcecaoVisitaASA;

    void visitar(NoPare noPare) throws ExcecaoVisitaASA;

    void visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA;

    void visitar(NoReal noReal) throws ExcecaoVisitaASA;

    void visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA;

    void visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA;

    void visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA;

    void visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA;

    void visitar(NoSe noSe) throws ExcecaoVisitaASA;

    void visitar(NoVetor noVetor) throws ExcecaoVisitaASA;

    void visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA;
}
