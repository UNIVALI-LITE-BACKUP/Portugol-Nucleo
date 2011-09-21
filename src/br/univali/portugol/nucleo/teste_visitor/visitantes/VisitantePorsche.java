/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.visitantes;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Porsche;

/**
 *
 * @author luiz
 */
public final class VisitantePorsche extends AdaptadorVisitanteVeiculo
{

    @Override
    public void visitar(Porsche porsche) throws ExcecaoVisitaNaoSuportada
    {
        System.out.println("Visitando um Porsche");
    }
}
