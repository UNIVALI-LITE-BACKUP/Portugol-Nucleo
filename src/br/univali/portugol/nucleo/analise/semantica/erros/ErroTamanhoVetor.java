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
public class ErroTamanhoVetor extends ErroSemantico {

    public ErroTamanhoVetor(TrechoCodigoFonte trechoCodigoFonte)
    {
        super(trechoCodigoFonte);
    }

    @Override
    protected String construirMensagem()
    {
        return "O tamanho do vetor deve ser um valor inteiro constante";
    }
    
}
