package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noshchang
 * 
 */
public interface VisitanteASA
{
    Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA;

    Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA;

    Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA;

    Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA;

    Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA;

    Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA;

    Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA;

    Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA;

    Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA;

    Object visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA;

    Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA;

    Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA;

    Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA;

    Object visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA;

    Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA;

    Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA;

    Object visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA;

    Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA;

    Object visitar(NoNao noNao) throws ExcecaoVisitaASA;

    Object visitar(NoOperacao noOperacao) throws ExcecaoVisitaASA;

    Object visitar(NoPara noPara) throws ExcecaoVisitaASA;

    Object visitar(NoPare noPare) throws ExcecaoVisitaASA;

    Object visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA;

    Object visitar(NoReal noReal) throws ExcecaoVisitaASA;

    Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA;

    Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA;

    Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA;

    Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA;

    Object visitar(NoSe noSe) throws ExcecaoVisitaASA;

    Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA;

    Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA;
}
