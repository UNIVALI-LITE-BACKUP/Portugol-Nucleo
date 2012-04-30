package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroOperandoEsquerdoAtribuicaoConstante extends ErroSemantico
{
    private NoOperacao atribuicao;

    public ErroOperandoEsquerdoAtribuicaoConstante(NoOperacao atribuicao)
    {
        super
        (
            atribuicao.getOperandoEsquerdo().getTrechoCodigoFonte().getLinha(),
            atribuicao.getOperandoEsquerdo().getTrechoCodigoFonte().getColuna()
        );

        this.atribuicao = atribuicao;
    }

    public NoOperacao getAtribuicao()
    {
        return atribuicao;
    }

    @Override
    protected String construirMensagem()
    {
        return "O operando esquerdo da atribuição não pode ser uma expressão constante.";
    }
}