package br.univali.portugol.nucleo.analise.semantica.avisos;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;

/**
 * Aviso gerado pelo analisador semântico quando é realizada a atribuição de uma expressão do tipo
 * {@link TipoDado#REAL} à uma expressão do tipo {@link TipoDado#INTEIRO}. 
 * <p>
 * Consulte o documento <a href='../asa/doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
 * para obter mais detalhes.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 */
public final class AvisoValorExpressaoSeraArredondado extends AvisoAnalise
{
    private NoExpressao expressao;

    /**
     * 
     * @param expressao     a expressão que está sendo arredondada.
     * @since 1.0
     */
    public AvisoValorExpressaoSeraArredondado(NoExpressao expressao)
    {
        super(expressao.getTrechoCodigoFonte().getLinha(), expressao.getTrechoCodigoFonte().getColuna());

        this.expressao = expressao;
    }

    /**
     * Obtém a expressão que está sendo arredondada.
     * 
     * @return     a expressão que está sendo arredondada.
     * @since 1.0
     */
    public NoExpressao getExpressao()
    {
        return expressao;
    }

    /**
     * {@inheritDoc }
     */    
    @Override
    protected String construirMensagem()
    {
        return "O valor da expressão à direita da atribuição perderá precisão.";
    }
}