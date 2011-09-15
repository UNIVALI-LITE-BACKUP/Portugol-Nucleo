package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Fillipi Domingos Pelz
 * 
 */

public final class ErroNomeIncompativel extends ErroSintatico
{
    public ErroNomeIncompativel(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        return "Problema na nomeclatura da declaração, uma declaração deve iniciar com letras";
    }
}