/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author fillipi
 */
public class ErroParaSemExpressaoComparacao extends ErroSemantico {

    public ErroParaSemExpressaoComparacao()
    {
    }

    @Override
    protected String construirMensagem()
    {
        return "É obrigatório a utilização de uma expressão de condição no comando para";
    }
    
}
