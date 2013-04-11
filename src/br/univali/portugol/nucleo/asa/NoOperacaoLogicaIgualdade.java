package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de igualdade no código fonte.
    * <p>
    * A operação de <code>igualdade</code> serve para determinar se duas expressões são equivalentes (iguais).
    * No Portugol, a operação de <code>igualdade</code> é representada no código fonte pelo operador "==".
    * <p>
    * A operação de <code>igualdade</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
    * valor lógico: <code>verdadeiro</code> se as expressões forem iguais e <code>falso</code> se 
    * as expressões forem diferentes. Pode ser utilizada para realizar o controle de laços de repetição 
    * e desvios condicionais.
    * <p>
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * 
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoLogicaIgualdade extends NoOperacao
{

    public NoOperacaoLogicaIgualdade(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
