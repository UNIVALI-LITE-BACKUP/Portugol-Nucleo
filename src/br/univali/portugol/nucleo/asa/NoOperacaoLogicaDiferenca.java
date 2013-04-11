package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de soma no código fonte.
    * <p>
    * A operação de <code>diferença</code> serve para determinar se duas expressões são diferentes.
    * No Portugol, a operação de <code>diferença</code> é representada no código fonte pelo operador "!=".
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * </p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoLogicaDiferenca extends NoOperacao
{

    public NoOperacaoLogicaDiferenca(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
