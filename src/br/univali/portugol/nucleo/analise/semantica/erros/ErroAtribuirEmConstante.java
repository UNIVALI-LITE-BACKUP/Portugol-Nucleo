/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

/**
 *
 * @author fillipi
 */
public class ErroAtribuirEmConstante extends ErroSemantico {
    private final Simbolo pSimbolo;

    public ErroAtribuirEmConstante(TrechoCodigoFonte trechoCodigoFonte, Simbolo pSimbolo)
    {
        super(trechoCodigoFonte);
        this.pSimbolo = pSimbolo;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder sb = new StringBuilder();
        if (pSimbolo instanceof Variavel)
        {
            sb.append("\"");
            sb.append(pSimbolo.getNome());
            sb.append("\" é uma constante, e portanto, não pode ter seu valor alterado após a inicialização");
        }
        else
        {
            if (pSimbolo instanceof Vetor)
            {
                sb.append("O vetor \"");
                sb.append(pSimbolo.getNome());
                sb.append("\" é constante e, portanto, não pode ter seus valores alterados após a inicialização");
            }
            else
            {
                if (pSimbolo instanceof Matriz)
                {
                    sb.append("A matriz \"");
                    sb.append(pSimbolo.getNome());
                    sb.append("\" é constante e, portanto, não pode ter seu valor alterado após a inicialização");
                }
            }
        }
        return sb.toString();
    }
    
}
