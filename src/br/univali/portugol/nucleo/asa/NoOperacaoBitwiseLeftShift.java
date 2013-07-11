package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de Bitwise Left Shift no código fonte.
    * Esta enumeração representa a operação de <code>Bitwise Left Shift</code> no código fonte e é representada pelo operador "&lt;&lt;".
    * <p>
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * 
 * </p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoBitwiseLeftShift extends NoOperacao
{

    public NoOperacaoBitwiseLeftShift(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
