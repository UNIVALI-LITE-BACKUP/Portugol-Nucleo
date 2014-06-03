/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author fillipi
 */
public class ErroAoInicializarVetor extends ErroSemantico {

    public ErroAoInicializarVetor(TrechoCodigoFonte trechoCodigoFonte)
    {
        super(trechoCodigoFonte,"ErroSemantico.ErroAoInicializarVetor");
    }

    @Override
    protected String construirMensagem()
    {
        return "O vetor deve ser inicializado com um vetor literal";
    }
    
}
