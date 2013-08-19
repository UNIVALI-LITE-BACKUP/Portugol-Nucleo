package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 * 
 * @author Fillipi Pelz
 */
public interface Interpretador
{
    public void setEntrada(Entrada entrada);

    public void setSaida(Saida saida);
    
    public void executar(Programa programa, String[] parametros) throws ErroExecucao;
    
}
