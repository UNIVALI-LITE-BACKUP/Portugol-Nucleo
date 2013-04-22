package br.univali.portugol.nucleo.asa;

/**
 * Representa uma referência de variável no código fonte.
 * <p>
 * Uma referência de variável é utilizada para acessar o valor de uma variável.
 * Uma referência de variável é composta apenas pelo nome da variável que está sendo
 * referenciada.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploReferenciaVariavel()
 *      {
 *           inteiro var = 25
 *  
 *           escreva("Isto é uma referência de variável: ", var)
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class NoReferenciaVariavel extends NoReferencia
{
    /**
     * 
     * @param nome     o nome da variável que está sendo referenciada.
     * @since 1.0
     */
    public NoReferenciaVariavel(String escopo, String nome)
    {
        super(escopo, nome);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        int tamanhoTexto = 0;

        int linha = getTrechoCodigoFonteNome().getLinha();
        int coluna = getTrechoCodigoFonteNome().getColuna();

        tamanhoTexto = tamanhoTexto + getTrechoCodigoFonteNome().getTamanhoTexto();

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
