package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoEnquanto;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoFacaEnquanto;
import br.univali.portugol.nucleo.asa.NoPara;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 * Erro gerado pelo analisador semântico quando uma expressão do tipo {@link TipoDado#LOGICO} era
 * esperada em um comanndo, mas uma expressão de outro tipo foi encontrada.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 */

public final class ErroExpressaoTipoLogicoEsperada extends ErroSemantico
{
    private NoBloco bloco;
    private NoExpressao expressao;


    /**
     * 
     * @param bloco         o comando que esperava a expressão do tipo {@link TipoDado#LOGICO}.
     * @param expressao     a expressão encontrada no lugar da expressão do tipo {@link TipoDado#LOGICO}.
     * @since 1.0
     */
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

    /**
     * Obtém a expressão encontrada no lugar da expressão do tipo {@link TipoDado#LOGICO}.
     * 
     * @return     a expressão encontrada no lugar da expressão do tipo {@link TipoDado#LOGICO}.
     * @since 1.0
     */
    public NoExpressao getExpressao()
    {
        return expressao;
    }
    /**
     * Obtém o comando que esperava a expressão do tipo {@link TipoDado#LOGICO}.
     * 
     * @return     o comando que esperava a expressão do tipo {@link TipoDado#LOGICO}.
     * @since 1.0
     */
    public NoBloco getBloco()
    {
        return bloco;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        if (bloco instanceof NoSe) return construirMensagemBlocoSe();
        if (bloco instanceof NoEnquanto) return construirMensagemBlocoEnquanto();
        if (bloco instanceof NoFacaEnquanto) return construirMensagemFacaEnquanto();
        if (bloco instanceof NoPara) return construirMensagemPara();
        return null;
    }

    /**
     * Constrói uma mensagem de erro personalizada para o comando 'se'.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoSe
     */
    private String construirMensagemBlocoSe()
    {
        return "Tipos incompatíveis! A expressão utilizada com o desvio condicional \"se\" deve ser do tipo lógico!";
    }

   /**
     * Constrói uma mensagem de erro personalizada para o comando 'enquanto'.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoEnquanto
     */
    private String construirMensagemBlocoEnquanto()
    {
        return "Tipos incompatíveis! A expressão utilizada com o laço \"enquanto\" dever ser do tipo lógico!";
    }

    /**
     * Constrói uma mensagem de erro personalizada para o comando 'faca-enquanto'.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoFacaEnquanto
     */    
    private String construirMensagemFacaEnquanto()
    {
        return "Tipos incompatíveis! A expressão utilizada com o laço \"faca-enquanto\" deve ser do tipo lógico!";
    }
    
    private String construirMensagemPara()
    {
        return "Tipos incompatíveis! A expressão utilizada na condição do bloco \"para\" deve ser do tipo lógico!";
    }
}