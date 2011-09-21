package br.univali.portugol.nucleo.teste_visitor;

import br.univali.portugol.nucleo.teste_visitor.veiculos.Veiculo;
import br.univali.portugol.nucleo.teste_visitor.visitantes.VisitanteVeiculo;

/**
 *
 * @author luiz
 */
public class ExcecaoVisitaNaoSuportada extends Exception
{
    public ExcecaoVisitaNaoSuportada(Veiculo veiculo, VisitanteVeiculo visitante)
    {
        super(montarMensagem(veiculo, visitante));
    }
    
    private static String montarMensagem(Veiculo veiculo, VisitanteVeiculo visitante)
    {
        String classeVeiculo = veiculo.getClass().getSimpleName();
        String classeVisitante = visitante.getClass().getSimpleName();
        
        StringBuilder construtorTexto = new StringBuilder();
                
        construtorTexto.append("Não é possível visitar o veículo '");
        construtorTexto.append(classeVeiculo);
        construtorTexto.append("' utilizando o visitante '");
        construtorTexto.append(classeVisitante);
        construtorTexto.append("'.\nVerifique se a classe '");
        construtorTexto.append(classeVeiculo);
        construtorTexto.append("' sobrescreve o método 'aceitar' e se a classe '");
        construtorTexto.append(classeVisitante);
        construtorTexto.append("' sobrescrever o método 'visitar' recebendo um veículo do tipo '");
        construtorTexto.append(classeVeiculo); 
        construtorTexto.append("'.");
        
        return construtorTexto.toString();
        
    }
}
