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
public class ErroTamanhoMatriz extends ErroSemantico {

    public ErroTamanhoMatriz(TrechoCodigoFonte trechoCodigoFonte)
    {
        super(trechoCodigoFonte);
    }

    @Override
    protected String construirMensagem()
    {
        return "A número de linhas ou colunas da matriz deve ser um valor inteiro constante";
    }
    
}
