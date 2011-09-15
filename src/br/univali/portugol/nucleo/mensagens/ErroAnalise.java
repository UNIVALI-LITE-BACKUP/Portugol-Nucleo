package br.univali.portugol.nucleo.mensagens;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public abstract class ErroAnalise extends Erro
{
    private int linha;
    private int coluna;

    public ErroAnalise(int linha, int coluna)
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
