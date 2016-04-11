package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
public abstract class ObservadorExecucaoBasico implements ObservadorExecucao
{
    @Override
    public void execucaoIniciada(Programa programa)
    {
        
    }

    @Override
    public void execucaoEncerrada(Programa programa, ResultadoExecucao resultadoExecucao)
    {
        
    }

    @Override
    public void highlightLinha(int linha)
    {
        
    }

    @Override
    public void highlightDetalhadoAtual(int linha, int coluna, int tamanho)
    {
        
    }

    @Override
    public void simbolosAlterados(List<Simbolo> simbolos)
    {

    }

    @Override
    public void simboloDeclarado(Simbolo simbolo)
    {
        
    }

    @Override
    public void simboloRemovido(Simbolo simbolo)
    {
        
    }    
}
