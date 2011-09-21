/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.visitantes;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Biz;

/**
 *
 * @author luiz
 */
public final class VisitanteBiz extends AdaptadorVisitanteVeiculo
{
    @Override
    public void visitar(Biz biz) throws ExcecaoVisitaNaoSuportada
    {
        System.out.println("Visitando uma Biz");
    }
}
