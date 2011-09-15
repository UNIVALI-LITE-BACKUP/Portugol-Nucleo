package br.univali.portugol.nucleo.mensagens;

import br.univali.portugol.nucleo.mensagens.Aviso;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class AvisoAnalise extends Aviso
{
    private int linha;
    private int coluna;

    public AvisoAnalise(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
    }

    public final int getLinha()
    {
        return linha;
    }

    public final int getColuna()
    {
        return coluna;
    }
}
