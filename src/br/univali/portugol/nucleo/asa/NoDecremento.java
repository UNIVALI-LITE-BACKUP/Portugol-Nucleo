package br.univali.portugol.nucleo.asa;

/**
 * Representa uma operação de decremento no código fonte.
 * <p>
 * As operações de decremento são representadas no código fonte pelo operador "--". 
 * As operações de decremento só podem ser aplicadas a variáveis numéricas e decrementam
 * o valor da variável um uma unidade.
 * <p>
 * A operação de decremento equivale a subtrair o número 1 de uma variável e atribuir o resultado
 * da subtração à própria variável:
 * 
 *<code><pre>
 *      funcao umaFuncaoQualquer()
 *      {
 *          inteiro var     // As operação a seguir são equivalentes:
 *
 *          var--           // Operação de decremento
 *          var = var - 1   // Operação de subtração seguida de atribuição
 *      }
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class NoDecremento extends NoExpressao
{
    private NoExpressao expressao;

    /**
     * @param expressao     a expressão que será decrementada. Deverá ser uma referência de variável, vetor ou matriz.
     * @since 1.0
     */
    public NoDecremento(NoExpressao expressao)
    {
        this.expressao = expressao;
    }

    /**
     * Obtém a expressão que está sendo decrementada. A expressão retornada será uma referência de variável, vetor
     * ou matriz.
     * 
     * @return     a expressão que esta sendo decrementada.
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
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        TrechoCodigoFonte trechoCodigoFonte = expressao.getTrechoCodigoFonte();

        int linha = trechoCodigoFonte.getLinha();
        int coluna = trechoCodigoFonte.getColuna();
        int tamanhoTexto = trechoCodigoFonte.getTamanhoTexto() + 2;

        return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
