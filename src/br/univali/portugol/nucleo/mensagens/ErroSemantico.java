package br.univali.portugol.nucleo.mensagens;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class ErroSemantico extends ErroAnalise
{
    public ErroSemantico(int linha, int coluna)
    {
        super(linha, coluna);
    }
}
