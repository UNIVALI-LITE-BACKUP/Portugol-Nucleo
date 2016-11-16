package br.univali.portugol.nucleo;

/**
 *
 * @author Elieser
 */
public interface ListenerCompilacao
{
    void compilacaoParaExecucaoIniciada();
    
    void compilacaoParaExecucaoFinalizada(Programa programaCompilado);
    
    void errosDeCompilacaoDetectados(ErroCompilacao erro);
}
