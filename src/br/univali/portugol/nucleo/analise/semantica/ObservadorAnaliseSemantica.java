package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface ObservadorAnaliseSemantica
{
    public void tratarErroSemantico(ErroSemantico erroSemantico);

    public void tratarAviso(AvisoAnalise aviso);
}
