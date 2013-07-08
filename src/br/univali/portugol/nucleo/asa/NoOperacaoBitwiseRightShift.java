package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de soma no código fonte.
    * Esta enumeração representa a operação de <code>Bitwise right shift</code> no código fonte e é representada pelo operador "/".
    * <p>
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * 
 * </p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoBitwiseRightShift extends NoOperacao
{

    public NoOperacaoBitwiseRightShift(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
