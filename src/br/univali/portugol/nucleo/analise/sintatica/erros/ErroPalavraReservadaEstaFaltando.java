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

public final class ErroPalavraReservadaEstaFaltando extends ErroSintatico
{
    private String palavraReservada;
    
    public ErroPalavraReservadaEstaFaltando(int linha, int coluna, String palavraReservada)
    {
        super(linha, coluna);
        this.palavraReservada = palavraReservada;
    }

    @Override
    protected String construirMensagem()
    {
        return "Está faltando a palavra reservada '" + palavraReservada + "'.";
    }
}
