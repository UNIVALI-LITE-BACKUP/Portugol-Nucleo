/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author fillipi
 */
public class ErroCaracterInvalido extends ErroSintatico
{

    String caracter;
    
    public ErroCaracterInvalido(int linha, int coluna, String caracter)
    {
        super(linha, coluna);
        this.caracter = caracter;
    }

    
    
    @Override
    protected String construirMensagem()
    {
        return "O caracter "+caracter+" é inválido.";
    }
    
}
