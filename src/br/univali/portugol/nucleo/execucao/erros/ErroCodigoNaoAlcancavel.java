/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.execucao.erros;

import br.univali.portugol.nucleo.mensagens.ErroAnalise;


/**
 *
 * @author fillipi
 */
public class ErroCodigoNaoAlcancavel extends ErroAnalise
{
    
    @Override
    protected String construirMensagem()
    {
        return "Existem códigos que não são alcançáveis. Verifique se existe algum código após um loop infinito ou um retorne";
    }
    
}
