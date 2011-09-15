package br.univali.portugol.nucleo.mensagens;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class ErroSintatico extends ErroAnalise
{
    public ErroSintatico(int linha, int coluna)
    {
        super(linha, coluna);
    }
}
