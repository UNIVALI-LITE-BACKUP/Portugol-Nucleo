package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoEnquanto;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoFacaEnquanto;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroExpressaoTipoLogicoEsperada extends ErroSemantico
{
    private NoBloco bloco;
    private NoExpressao expressao;


    public ErroExpressaoTipoLogicoEsperada(NoBloco bloco, NoExpressao expressao)
    {
        super
        (
            expressao.getTrechoCodigoFonte().getLinha(),
            expressao.getTrechoCodigoFonte().getColuna()
        );

        this.bloco = bloco;
        this.expressao = expressao;
    }

    public NoExpressao getExpressao()
    {
        return expressao;
    }

    public NoBloco getBloco()
    {
        return bloco;
    }

    @Override
    protected String construirMensagem()
    {
        if (bloco instanceof NoSe) return construirMensagemBlocoSe();
        if (bloco instanceof NoEnquanto) return construirMensagemBlocoEnquanto();
        if (bloco instanceof NoFacaEnquanto) return construirMensagemFacaEnquanto();

        return null;
    }

    private String construirMensagemBlocoSe()
    {
        return "Tipos incompatíveis! A expressão utilizada com o desvio condicional \"se\" deve ser do tipo lógico!";
    }

    private String construirMensagemBlocoEnquanto()
    {
        return "Tipos incompatíveis! A expressão utilizada com o laço \"enquanto\" dever ser do tipo lógico!";
    }

    private String construirMensagemFacaEnquanto()
    {
        return "Tipos incompatíveis! A expressão utilizada com o laço \"faca-enquanto\" deve ser do tipo lógico!";
    }
}