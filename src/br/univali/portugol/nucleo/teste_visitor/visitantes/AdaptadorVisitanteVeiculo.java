/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.teste_visitor.visitantes;

import br.univali.portugol.nucleo.teste_visitor.ExcecaoVisitaNaoSuportada;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Automovel;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Biz;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Fusca;
import br.univali.portugol.nucleo.teste_visitor.veiculos.HarleyDavidson;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Motocicleta;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Porsche;
import br.univali.portugol.nucleo.teste_visitor.veiculos.Veiculo;

/**
 *
 * @author luiz
 */
public class AdaptadorVisitanteVeiculo extends VisitanteVeiculo
{

    @Override
    public void visitar(Veiculo veiculo) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(veiculo, this);
    }

    @Override
    public void visitar(Automovel automovel) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(automovel, this);
    }

    @Override
    public void visitar(Fusca fusca) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(fusca, this);
    }

    @Override
    public void visitar(Porsche porsche) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(porsche, this);
    }

    @Override
    public void visitar(Motocicleta motocicleta) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(motocicleta, this);
    }

    @Override
    public void visitar(Biz biz) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(biz, this);
    }

    @Override
    public void visitar(HarleyDavidson harleyDavidson) throws ExcecaoVisitaNaoSuportada
    {
        throw new ExcecaoVisitaNaoSuportada(harleyDavidson, this);
    }
}
