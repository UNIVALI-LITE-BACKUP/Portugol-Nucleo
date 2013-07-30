/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author fillipi
 */
public class ErroQuantidadeLinhasIncializacaoMatriz extends ErroSemantico {
    private final String pNome;
    private final int pLinhas;

    public ErroQuantidadeLinhasIncializacaoMatriz(TrechoCodigoFonte trechoCodigoFonte, String pNome, int pLinhas)
    {
        super(trechoCodigoFonte);
        this.pNome = pNome;
        this.pLinhas = pLinhas;
    }

    @Override
    protected String construirMensagem()
    {
        return String.format("A inicialização da matriz \"%s\" deve possuir %d linhas", pNome, pLinhas);
    }
    
}
