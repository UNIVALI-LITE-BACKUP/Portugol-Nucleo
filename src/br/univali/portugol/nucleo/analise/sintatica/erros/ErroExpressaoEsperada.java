/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author luiz
 */
public final class ErroExpressaoEsperada extends ErroSintatico
{
    private String contexto;
    
    public ErroExpressaoEsperada(int linha, int coluna, String contexto)
    {
        super(linha, coluna);
        this.contexto = contexto;
    }

    @Override
    protected String construirMensagem()
    {
        return "Está faltando a expressão de controle do bloco.";
    }
}
