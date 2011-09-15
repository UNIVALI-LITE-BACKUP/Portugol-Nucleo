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
    public AnalisadorAlgoritmo()
    {
        
    }
    
    public ResultadoAnalise analisar(String codigo)
    {
        ObservadorAnaliseAlgoritmo observadorAnaliseAlgoritmo = new ObservadorAnaliseAlgoritmo();
        AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico();
        AnalisadorSemantico analisadorSemantico = new AnalisadorSemantico();
                
        analisadorSintatico.adicionarObservador(observadorAnaliseAlgoritmo);
        analisadorSemantico.adicionarObservador(observadorAnaliseAlgoritmo);
        
        ArvoreSintaticaAbstrata asa = analisadorSintatico.analisar(codigo);
        analisadorSemantico.analisar(asa);
        
        return observadorAnaliseAlgoritmo.getResultadoAnalise();
    }    
}