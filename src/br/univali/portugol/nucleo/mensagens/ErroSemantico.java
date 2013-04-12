package br.univali.portugol.nucleo.mensagens;

/**
 * Classe base para todos os tipos de erros semânticos ocorridos durante a análise
 * de código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public abstract class ErroSemantico extends ErroAnalise
{
    public ErroSemantico()
    {
        
    }
    
    /**
     * 
     * @param linha      a linha onde o erro ocorreu.
     * @param coluna     a coluna onde o erro ocorreu.
     */
    public ErroSemantico(int linha, int coluna)
    {
        super(linha, coluna);
    }
}
