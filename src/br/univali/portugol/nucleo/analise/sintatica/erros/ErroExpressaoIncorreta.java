/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author luiz
 */
public final class ErroExpressaoIncorreta extends ErroSintatico
{
    
    public ErroExpressaoIncorreta(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     
    
}
