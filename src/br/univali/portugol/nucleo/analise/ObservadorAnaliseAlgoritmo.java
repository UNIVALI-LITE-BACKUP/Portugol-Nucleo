package br.univali.portugol.nucleo.analise;

import br.univali.portugol.nucleo.analise.semantica.ObservadorAnaliseSemantica;
import br.univali.portugol.nucleo.analise.sintatica.ObservadorAnaliseSintatica;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ObservadorAnaliseAlgoritmo implements ObservadorAnaliseSintatica, ObservadorAnaliseSemantica
{
    private ResultadoAnalise resultadoAnalise;

    public ObservadorAnaliseAlgoritmo()
    {
        resultadoAnalise = new ResultadoAnalise();
    }    

    @Override
    public void tratarErroSintatico(ErroSintatico erroSintatico)
    {
        resultadoAnalise.adicionarErro(erroSintatico);
    }

    @Override
    public void tratarErroSemantico(ErroSemantico erroSemantico)
    {
        resultadoAnalise.adicionarErro(erroSemantico);
    }

    public ResultadoAnalise getResultadoAnalise()
    {
        return resultadoAnalise;
    }

    @Override
    public void tratarAviso(AvisoAnalise aviso)
    {
        resultadoAnalise.adicionarAviso(aviso);
    }
}
