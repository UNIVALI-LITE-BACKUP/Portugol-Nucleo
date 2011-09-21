/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.veiculos;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteVeiculo;

/**
 *
 * @author luiz
 */

public final class Biz extends Motocicleta
{
    @Override
    public void aceitar(VisitanteVeiculo visitanteVeiculo) throws ExcecaoVisitaNaoSuportada
    {
        visitanteVeiculo.visitar(this);
    }
}
