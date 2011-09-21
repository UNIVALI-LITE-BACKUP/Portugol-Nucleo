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

public abstract class VisitanteVeiculo
{
    public abstract void visitar(Veiculo veiculo) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(Automovel automovel) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(Fusca fusca) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(Porsche porsche) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(Motocicleta motocicleta) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(Biz biz) throws ExcecaoVisitaNaoSuportada;
    public abstract void visitar(HarleyDavidson harleyDavidson) throws ExcecaoVisitaNaoSuportada;
}
