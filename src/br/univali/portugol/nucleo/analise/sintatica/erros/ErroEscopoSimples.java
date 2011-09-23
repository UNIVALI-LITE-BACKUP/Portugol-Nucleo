package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroEscopoSimples extends ErroSintatico
{
    public ErroEscopoSimples(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        return "Esta construção espera um comando. Insira um comando ou inicie um novo escopo utilizando os caracteres '{' e '}'.";
    }
}
