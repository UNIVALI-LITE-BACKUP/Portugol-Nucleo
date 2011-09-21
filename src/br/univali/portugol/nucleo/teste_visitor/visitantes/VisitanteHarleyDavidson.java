/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.visitantes;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.veiculos.HarleyDavidson;

/**
 *
 * @author luiz
 */
public final class VisitanteHarleyDavidson extends AdaptadorVisitanteVeiculo
{
    @Override
    public void visitar(HarleyDavidson harleyDavidson) throws ExcecaoVisitaNaoSuportada
    {
        System.out.println("Visitando uma Harley Davidson");
    }
}
