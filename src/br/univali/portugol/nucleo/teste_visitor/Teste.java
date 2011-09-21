/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor;

import br.univali.portugol.nucleo.teste_visitor.veiculos.Veiculo;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Biz;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Fusca;
import br.univali.portugol.nucleo.teste_visitor.veiculos.HarleyDavidson;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Porsche;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteBiz;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteFusca;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteHarleyDavidson;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitantePorsche;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteVeiculo;

/**
 *
 * @author luiz
 */
public final class Teste
{
    public static void main(String[] args) throws ExcecaoVisitaNaoSuportada
    {
        Veiculo veiculo = new HarleyDavidson();
        VisitanteVeiculo visitante = new VisitanteHarleyDavidson();
        
        veiculo.aceitar(visitante);
    }
}