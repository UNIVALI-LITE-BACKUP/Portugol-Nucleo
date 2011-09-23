/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author luiz
 */
public class ErroTiposIncompativeis2 extends ErroSemantico 
{
    private TipoDado tipoEsperado;
    private TipoDado tipoObtido;
    
    public ErroTiposIncompativeis2(int linha, int coluna, TipoDado tipoEsperado, TipoDado tipoObtido) 
    {
        super(linha, coluna);
        this.tipoEsperado = tipoEsperado;
        this.tipoObtido = tipoObtido;
    }

    @Override
    protected String construirMensagem() 
    {
        return "Tipos incompatíveis. Era esperada uma expressão do tipo " + tipoEsperado + " mas foi encontrada uma expressão do tipo " + tipoObtido;
    }    
}
