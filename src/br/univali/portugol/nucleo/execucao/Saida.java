package br.univali.portugol.nucleo.execucao;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public interface Saida
{
    public void limpar() throws Exception;    
    public void escrever(String valor) throws Exception;
    public void escrever(boolean valor) throws Exception;
    public void escrever(int valor) throws Exception;
    public void escrever(double valor) throws Exception;
    public void escrever(char valor) throws Exception;
}
