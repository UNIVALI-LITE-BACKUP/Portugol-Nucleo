package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.bibliotecas.base.ErroCarregamentoBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroInclusaoBiblioteca extends ErroSemantico
{
    private ErroCarregamentoBiblioteca erroCarregamentoBiblioteca;

    public ErroInclusaoBiblioteca(int linha, int coluna, ErroCarregamentoBiblioteca erroCarregamentoBiblioteca)
    {
        super(linha, coluna);
    }
    
    @Override
    protected String construirMensagem()
    {
        return erroCarregamentoBiblioteca.getMessage();
    }
    
}
