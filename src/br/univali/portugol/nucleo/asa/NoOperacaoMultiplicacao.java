package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de multiplicacao no código fonte.
     * Esta enumeração representa a operação de <code>multiplicação</code> no código fonte e é representada pelo operador "*".
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * </p>
 * @version 1.13
 */
public class NoOperacaoMultiplicacao extends NoOperacao
{

    public NoOperacaoMultiplicacao(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
