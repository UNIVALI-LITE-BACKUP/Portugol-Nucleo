package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface ObservadorExecucao 
{
    /**
     * Este método é chamado antes do início da execução do programa, 
     * notificando os observadores de que a execução está prestes a 
     * ser iniciada.
     * 
     * @param programa o programa que está sendo executado.
     */
    
    public void execucaoIniciada(Programa programa);
    
    /**
     * Este método é chamado após o término da execução do programa,
     * notificando os observadores de que a execução terminou.
     * 
     * @param programa o programa que foi executado
     * 
     * @param resultadoExecucao contém informações referentes à execução 
     * do programa como, por exemplo, o tempo total da execução.
     * 
     */
    
    public void execucaoEncerrada(Programa programa, ResultadoExecucao resultadoExecucao);
}
