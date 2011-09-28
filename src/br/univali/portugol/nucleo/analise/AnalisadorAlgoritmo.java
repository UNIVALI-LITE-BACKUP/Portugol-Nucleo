package br.univali.portugol.nucleo.analise;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrata;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class AnalisadorAlgoritmo
{
    private ArvoreSintaticaAbstrata arvoreSintaticaAbstrata;
    
    public AnalisadorAlgoritmo()
    {
        
    }

    public ArvoreSintaticaAbstrata getArvoreSintaticaAbstrata() 
    {
        return arvoreSintaticaAbstrata;
    }
    
    public ResultadoAnalise analisar(String codigo)
    {
        ObservadorAnaliseAlgoritmo observadorAnaliseAlgoritmo = new ObservadorAnaliseAlgoritmo();
        AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico();
        AnalisadorSemantico analisadorSemantico = new AnalisadorSemantico();
                
        analisadorSintatico.adicionarObservador(observadorAnaliseAlgoritmo);
        analisadorSemantico.adicionarObservador(observadorAnaliseAlgoritmo);
        
        ArvoreSintaticaAbstrata asa = analisadorSintatico.analisar(codigo);
        arvoreSintaticaAbstrata = asa;
        analisadorSemantico.analisar(asa);
        
        return observadorAnaliseAlgoritmo.getResultadoAnalise();
    }
}