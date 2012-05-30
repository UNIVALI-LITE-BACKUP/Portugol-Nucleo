package br.univali.portugol.nucleo.asa;

/**
 * Representa uma operação de incremento no código fonte.
 * <p>
 * As operações de incremento são representadas no código fonte pelo operador "++". 
 * As operações de incremento só podem ser aplicadas a variáveis numéricas e incrementam
 * o valor da variável um uma unidade.
 * <p>
 * A operação de incremento equivale a somar o número 1 a uma variável e atribuir o resultado
 * da soma à própria variável:
 * 
 *<code><pre>
 *      funcao umaFuncaoQualquer()
 *      {
 *          inteiro var     // As operação a seguir são equivalentes:
 *
 *          var++           // Operação de incremento
 *          var = var + 1   // Operação de soma seguida de atribuição
 *      }
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class NoIncremento extends NoExpressao
{
    private NoExpressao expressao;

    /**
     * @param expressao     a expressão que será incrementada. Deverá ser uma referência de variável, vetor ou matriz.
     * @since 1.0
     */
    public NoIncremento(NoExpressao expressao)
    {
        this.expressao = expressao;
    }

    /**
     * Obtém a expressão que está sendo incrementada. A expressão retornada será uma referência de variável, vetor
     * ou matriz.
     * 
     * @return     a expressão que está sendo incrementada.
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
