/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

/**
 *
 * @author fillipi
 */
public interface ObservadorInterpretacao
{
    void variavelDeclarada(Variavel variavel);
    void vetorDeclarado(Vetor vetor);
    void matrizDeclarada(Matriz matriz);
}
