package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noshchang
 * 
 */
public interface VisitanteASA {
    
    void visitar(ArvoreSintaticaAbstrataPrograma asap);
    void visitar(NoCadeia noCadeia);
    void visitar(NoCaracter noCaracter);
    void visitar(NoCaso noCaso);
    void visitar(NoChamadaFuncao chamadaFuncao);
    void visitar(NoDeclaracaoFuncao declaracaoFuncao);
    void visitar(NoDeclaracaoMatriz noDeclaracaoMatriz);
    void visitar(NoDeclaracaoVariavel noDeclaracaoVariavel);
    void visitar(NoDeclaracaoVetor noDeclaracaoVetor);
    void visitar(NoDecremento noDecremento);
    void visitar(NoEnquanto noEnquanto);
    void visitar(NoEscolha noEscolha);
    void visitar(NoFacaEnquanto noFacaEnquanto);
    void visitar(NoIncremento noIncremento);
    void visitar(NoInteiro noInteiro);
    void visitar(NoLogico noLogico);
    void visitar(NoMatriz noMatriz);
    void visitar(NoMenosUnario noMenosUnario);
    void visitar(NoNao noNao);
    void visitar(NoOperacao noOperacao);
    void visitar(NoPara noPara);
    void visitar(NoPare noPare);
    void visitar(NoPercorra noPercorra);
    void visitar(NoReal noReal);
    void visitar(NoReferenciaMatriz noReferenciaMatriz);
    void visitar(NoReferenciaVariavel noReferenciaVariavel);
    void visitar(NoReferenciaVetor noReferenciaVetor);
    void visitar(NoRetorne noRetorne);
    void visitar(NoSe noSe);
    void visitar(NoVetor noVetor);
    
}
