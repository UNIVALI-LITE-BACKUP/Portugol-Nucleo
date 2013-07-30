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
public class ErroQuantidadeElementosInicializacaoVetor extends ErroSemantico {
    private final String pNome;
    private final int pTamanho;

    public ErroQuantidadeElementosInicializacaoVetor(TrechoCodigoFonte trechoCodigoFonte, String pNome, int pTamanho)
    {
        super(trechoCodigoFonte);
        this.pNome = pNome;
        this.pTamanho = pTamanho;
    }

    @Override
    protected String construirMensagem()
    {
        return String.format("A inicializaçao do vetor \"%s\" deve possuir %d elemento(s)", pNome, pTamanho);
    }
    
}
