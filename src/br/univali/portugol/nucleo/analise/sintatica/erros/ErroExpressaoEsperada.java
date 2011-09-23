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
public final class ErroExpressaoEsperada extends ErroSintatico
{
    public ErroExpressaoEsperada(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        return "Esta construção espera uma condição ou uma expressão entre parenteses.";
    }
}
