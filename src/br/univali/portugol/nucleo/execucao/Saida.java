package br.univali.portugol.nucleo.execucao;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public interface Saida
{
    public void limpar(ObservadorSaida observadorSaida);    
    public void escrever(String valor, ObservadorSaida observadorSaida);
    public void escrever(boolean valor, ObservadorSaida observadorSaida);
    public void escrever(int valor, ObservadorSaida observadorSaida);
    public void escrever(double valor, ObservadorSaida observadorSaida);
    public void escrever(char valor, ObservadorSaida observadorSaida);
}
