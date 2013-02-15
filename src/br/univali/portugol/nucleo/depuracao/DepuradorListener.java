/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.asa.TipoDado;

/**
 *
 * @author fillipipelz
 */
public interface DepuradorListener
{
    public void linhaAtual(int linha);
    public void simboloDeclarado(String nome, TipoDado tipoDado);
    public void valorSimboloAlterado(String nome, Object valor);
    public void novaTabelaSimbolos();
    
}
