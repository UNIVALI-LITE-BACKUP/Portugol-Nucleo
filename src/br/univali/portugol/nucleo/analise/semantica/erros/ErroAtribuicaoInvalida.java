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
public class ErroAtribuicaoInvalida extends ErroSemantico
{

    public ErroAtribuicaoInvalida(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        throw new UnsupportedOperationException("ErroAtribuicaoInvalida");
    }
    
}
