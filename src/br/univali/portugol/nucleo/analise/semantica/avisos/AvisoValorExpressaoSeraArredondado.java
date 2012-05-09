package br.univali.portugol.nucleo.analise.semantica.avisos;

import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */
public final class AvisoValorExpressaoSeraArredondado extends AvisoAnalise
{
    private NoExpressao expressao;

    public AvisoValorExpressaoSeraArredondado(NoExpressao expressao)
    {
        super(expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna());

        this.expressao = expressao;
    }

    public NoExpressao getExpressao()
    {
        return expressao;
    }

    @Override
    protected String construirMensagem()
    {
        return "O valor da expressão à direita da atribuição será arredondado.";
    }
}