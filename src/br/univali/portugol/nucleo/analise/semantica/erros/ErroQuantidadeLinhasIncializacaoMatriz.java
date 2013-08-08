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
public final class ErroQuantidadeLinhasIncializacaoMatriz extends ErroSemantico
{
    private final String nome;
    private final int linhas;

    public ErroQuantidadeLinhasIncializacaoMatriz(TrechoCodigoFonte trechoCodigoFonte, String nome, int linhas)
    {
        super(trechoCodigoFonte);
        this.nome = nome;
        this.linhas = linhas;
    }

    @Override
    protected String construirMensagem()
    {
        return String.format("A inicialização da matriz \"%s\" deve possuir %d linhas", nome, linhas);
    }    
}
