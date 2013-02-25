
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 * Erro gerado pelo analisador semântico quando uma expressão com tipo de dado diferente de
 * {@link TipoDado#INTEIRO} é utilizada como índice de um vetor ou matriz.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploTipoIndiceIncompativel()
 *      {
 *           inteiro vetor[5] = {1, 2, 3, 4, 5}
 * 
 *           vetor["teste"] = 20      // Gera um erro
 *           vetor[23.68] = 45        // Gera um erro
 *           vetor[falso] = 12        // Gera um erro
 *           vetor['b'] = 45          // Gera um erro
 *  
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 * @see ErroTiposIncompativeis
 */
public class ErroTipoIndiceIncompativel extends ErroSemantico 
{
    private TipoDado tipoEsperado;
    private TipoDado tipoObtido;
    
    
    /**
     * 
     * @param linha            a linha onde o erro ocorreu.
     * @param coluna           a coluna onde o erro cocorreu.
     * @param tipoObtido       o tipo de dado da expressão que foi passada como índice.
     * @since 1.0    
     */
    public ErroTipoIndiceIncompativel(int linha, int coluna, TipoDado tipoObtido) 
    {
        super(linha, coluna);
        this.tipoEsperado = TipoDado.INTEIRO;
        this.tipoObtido = tipoObtido;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem() 
    {
        return "Tipos incompatíveis. Era esperada uma expressão do tipo " + tipoEsperado + " mas foi encontrada uma expressão do tipo " + tipoObtido;
    }    
}
