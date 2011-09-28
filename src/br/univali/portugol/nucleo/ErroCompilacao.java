package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.mensagens.Erro;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroCompilacao extends Erro
{
    private ResultadoAnalise resultadoAnalise;

    public ErroCompilacao(ResultadoAnalise resultadoAnalise) 
    {
        this.resultadoAnalise = resultadoAnalise;
    }
    
    @Override
    protected String construirMensagem() 
    {
        return "Não foi possível compilar o programa, o código contém erros.";
    }

    public ResultadoAnalise getResultadoAnalise() 
    {
        return resultadoAnalise;
    }
}
