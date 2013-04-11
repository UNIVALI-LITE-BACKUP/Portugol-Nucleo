package br.univali.portugol.nucleo.asa;


/**
* Esta enumeração representa a operação de <code>atribuição</code> no código fonte.
    * <p>
    * A operação de <code>atribuição</code> serve para armazenar um valor em uma variável, vetor ou matriz.
    * No Portugol, a operação de <code>atribuição</code> é representada no código fonte pelo operador "=".
    * A operação de <code>atribuição</code> é uma operação aritmética na qual o operando esquerdo é obrigatoriamente uma
    * referência a uma variável, um vetor ou uma matriz. O operando direito, por sua vez, pode ser qualquer 
    * tipo de expressão. Ao ser avaliada, o resultado da expressão à direita é armazenado na variável, vetor
    * ou matriz à esquerda e retornado como resultado da operação. Isto significa que, a operação de <code>atribuição</code>
    * pode ser utilizada como operando de outras operações.
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * </p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoAtribuicao extends NoOperacao
{

    public NoOperacaoAtribuicao(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
