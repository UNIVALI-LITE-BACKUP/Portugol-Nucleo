package br.univali.portugol.nucleo.analise.sintatica;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public interface ObservadorAnaliseSintatica
{
    public void tratarErroSintatico(ErroSintatico erroSintatico);
}
