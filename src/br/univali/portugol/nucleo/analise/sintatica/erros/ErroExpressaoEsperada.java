package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 * Erro gerado pelo analisador sintático quando uma construção espera uma expressão
 * mas esta expressão não é informada.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploErroExpressao()
 *      {
 *           se ()
 *           {
 *                escreva("A construção 'se' espera uma expressão entre o parêntesis...")
 *                escreva("...se não for informada uma expressão, o analisador sintático gerará este erro!")
 *           }
 * 
 *           enquanto ()
 *           {
 *                escreva("O mesmo se aplica à construção 'enquanto'!")
 *           }
 *      }
 * 
 * </pre></code>
 * 
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 */
public final class ErroExpressaoEsperada extends ErroSintatico
{
    /**
     * 
     * @param linha      a linha ond eo erro ocorreu.
     * @param coluna     a coluna onde o erro ocorreu.
     * @since 1.0
     */
    public ErroExpressaoEsperada(int linha, int coluna)
    {
        super(linha, coluna);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        return "Esta construção espera uma condição ou uma expressão entre parêntesis.";
    }
}
