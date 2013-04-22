package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroInclusaoBiblioteca extends ErroSemantico
{
    private Exception causa;

    public ErroInclusaoBiblioteca(int linha, int coluna, Exception causa)
    {
        super(linha, coluna);
        this.causa = causa;
    }

    @Override
    protected String construirMensagem()
    {
        return causa.getMessage();
    }
    
}
