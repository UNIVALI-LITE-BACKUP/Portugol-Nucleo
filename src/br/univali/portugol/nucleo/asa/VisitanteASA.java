package br.univali.portugol.nucleo.asa;

/**
 *
 * @author Fillipi Domingos Pelz
 * @author Luiz Fernando Noshchang
 * 
 */
public interface VisitanteASA {
    
    void visitar(ArvoreSintaticaAbstrataPrograma asap) throws Exception;
    void visitar(NoCadeia noCadeia) throws Exception;
    void visitar(NoCaracter noCaracter) throws Exception;
    void visitar(NoCaso noCaso) throws Exception;
    void visitar(NoChamadaFuncao chamadaFuncao) throws Exception;
    void visitar(NoDeclaracaoFuncao declaracaoFuncao) throws Exception;
    void visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws Exception;
    void visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws Exception;
    void visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws Exception;
    void visitar(NoDecremento noDecremento) throws Exception;
    void visitar(NoEnquanto noEnquanto) throws Exception;
    void visitar(NoEscolha noEscolha) throws Exception;
    void visitar(NoFacaEnquanto noFacaEnquanto) throws Exception;
    void visitar(NoIncremento noIncremento) throws Exception;
    void visitar(NoInteiro noInteiro) throws Exception;
    void visitar(NoLogico noLogico) throws Exception;
    void visitar(NoMatriz noMatriz) throws Exception;
    void visitar(NoMenosUnario noMenosUnario) throws Exception;
    void visitar(NoNao noNao) throws Exception;
    void visitar(NoOperacao noOperacao) throws Exception;
    void visitar(NoPara noPara) throws Exception;
    void visitar(NoPare noPare) throws Exception;
    void visitar(NoPercorra noPercorra) throws Exception;
    void visitar(NoReal noReal) throws Exception;
    void visitar(NoReferenciaMatriz noReferenciaMatriz) throws Exception;
    void visitar(NoReferenciaVariavel noReferenciaVariavel) throws Exception;
    void visitar(NoReferenciaVetor noReferenciaVetor) throws Exception;
    void visitar(NoRetorne noRetorne) throws Exception;
    void visitar(NoSe noSe) throws Exception;
    void visitar(NoVetor noVetor) throws Exception;
    
}
