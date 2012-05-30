package br.univali.portugol.nucleo.mensagens;

/**
 * Classe base para todos os tipos de aviso gerados durante a análise de código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 */
public abstract class AvisoAnalise extends Aviso
{
    private int linha;
    private int coluna;

    /**
     * 
     * @param linha      a linha onde o aviso ocorreu.
     * @param coluna     a coluna onde o aviso ocorreu.
     * @since 1.0
     */
    public AvisoAnalise(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Obtém a linha onde o aviso ocorreu.
     * 
     * @return     a linha onde o aviso ocorreu.
     * @since 1.0
     */    
    public final int getLinha()
    {
        return linha;
    }

    /**
     * Obtém a coluna onde o aviso ocorreu.
     * 
     * @return     a coluna onde o aviso ocorreu.
     * @since 1.0
     */    
    public final int getColuna()
    {
        return coluna;
    }
}
