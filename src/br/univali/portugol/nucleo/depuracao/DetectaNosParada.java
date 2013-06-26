/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.execucao.Interpretador;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fillipi
 */
public class DetectaNosParada extends Interpretador
{
    List<NoBloco> nosParada;

    public List<NoBloco> executar(Programa programa, String[] parametros) throws ErroExecucao
    {
        nosParada = new ArrayList<NoBloco>();
        interpretar(programa, parametros);
        return nosParada;
    }

    @Override
    protected Object interpretarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {
        for (NoBloco no : blocos){
            nosParada.add(no);
        }
        
        return super.interpretarListaBlocos(blocos);
    }
    
    
    
}
