/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.asa.TipoDado;

/**
 *
 * @author fillipi
 */
public interface DepuradorListener
{
    
    void linhaAtual(int linha);
    
    void simboloDeclarado(String nome, TipoDado tipoDado);
    
    void valorSimboloAlterado(String nome, Object valor);
    
    void novaTabelaSimbolos();
    
}
