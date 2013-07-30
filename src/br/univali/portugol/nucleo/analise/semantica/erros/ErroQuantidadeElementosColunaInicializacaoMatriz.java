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
public class ErroQuantidadeElementosColunaInicializacaoMatriz extends ErroSemantico {
    private final int pLin;
    private final String pNome;
    private final int pColunas;

    public ErroQuantidadeElementosColunaInicializacaoMatriz(TrechoCodigoFonte trechoCodigoFonte, int pLin, String pNome, int pColunas)
    {
        super(trechoCodigoFonte);
        this.pLin = pLin;
        this.pNome = pNome;
        this.pColunas = pColunas;
    }

    @Override
    protected String construirMensagem()
    {
        return String.format("A linha %d na inicialização da matriz \"%s\" deve possuir %d elementos", pLin, pNome, pColunas);
    }
    
}
