/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.visitantes;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Fusca;

/**
 *
 * @author luiz
 */
public final class VisitanteFusca extends AdaptadorVisitanteVeiculo
{
    @Override
    public void visitar(Fusca fusca) throws ExcecaoVisitaNaoSuportada
    {
        System.out.println("Visitando um Fusca");
    }
}
