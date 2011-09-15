package br.univali.portugol.nucleo.execucao;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public interface Saida
{
	public void limpar();
    
	public void escrever(String valor);
    public void escrever(boolean valor);
    public void escrever(int valor);
    public void escrever(double valor);
    public void escrever(char valor);
}
