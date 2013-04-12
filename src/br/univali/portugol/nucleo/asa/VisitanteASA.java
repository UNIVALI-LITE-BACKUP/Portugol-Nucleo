package br.univali.portugol.nucleo.asa;

/**
 * Esta interface serve como base para a implementação de um objeto caminhador da ASA
 * utilizando o padrão visitor.
 * 
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noshchang
 * 
 * @version 1.0
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

    Object visitar(NoOperacaoLogicaIgualdade noOperacaoLogicaIgualdade) throws ExcecaoVisitaASA;

    Object visitar(NoOperacaoLogicaDiferenca noOperacaoLogicaDiferenca) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoAtribuicao noOperacaoAtribuicao) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaE noOperacaoLogicaE) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaOU noOperacaoLogicaOU) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaMaior noOperacaoLogicaMaior) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaMaiorIgual noOperacaoLogicaMaiorIgual) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaMenor noOperacaoLogicaMenor) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoLogicaMenorIgual noOperacaoLogicaMenorIgual) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoSoma noOperacaoSoma) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoSubtracao noOperacaoSubtracao) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoDivisao noOperacaoDivisao) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoMultiplicacao noOperacaoMultiplicacao) throws ExcecaoVisitaASA;
    
    Object visitar(NoOperacaoModulo noOperacaoModulo) throws ExcecaoVisitaASA;
    
    Object visitar(NoPara noPara) throws ExcecaoVisitaASA;

    Object visitar(NoPare noPare) throws ExcecaoVisitaASA;

    /**
     * @param noPercorra           nó da ASA.
     * @return                     um objeto qualquer. 
     * @throws ExcecaoVisitaASA
     * @deprecated                 a classe NoPercora será removida nas versões futuras.
     */
    @Deprecated
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
