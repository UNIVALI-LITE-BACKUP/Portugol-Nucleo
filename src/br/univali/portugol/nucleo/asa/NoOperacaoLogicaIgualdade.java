package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de igualdade no código fonte.
 * <p>
 * A operação de <code>igualdade</code> serve para determinar se duas expressões são equivalentes (iguais).
 * No Portugol, a operação de <code>igualdade</code> é representada no código fonte pelo operador "==".
 * </p>
 * 
 * <p>
 * A operação de <code>igualdade</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
 * valor lógico: <code>verdadeiro</code> se as expressões forem iguais e <code>falso</code> se 
 * as expressões forem diferentes. Pode ser utilizada para realizar o controle de laços de repetição 
 * e desvios condicionais.
 * </p>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public final class NoOperacaoLogicaIgualdade extends NoOperacaoLogica
{
    private Boolean evaluatedValue = null; // cache
    
    public NoOperacaoLogicaIgualdade(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }

    public boolean evaluate()
    {
        if (evaluatedValue == null)
        {
            evaluatedValue = doEvaluation(); //se a igualdade for testada mais de uma vez o valor que já foi avaliado será retornado
        }
        return evaluatedValue;
    }
    
    private Boolean doEvaluation()
    {
        NoExpressao opEsq = getOperandoEsquerdo();
        NoExpressao opDir = getOperandoDireito();
        if (opEsq.getClass().equals(opDir.getClass()))
        {   
            return opEsq.equals(opDir);
        }
        
        // trata os casos de comparação de inteiro com real e real com inteiro
        Number a = ((NoValor<Number>)opEsq).getValor();
        Number b = ((NoValor<Number>)opDir).getValor();
        return a.intValue() == b.intValue();
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }

    @Override
    public String toString()
    {
        return getOperandoEsquerdo().toString() + " == " + getOperandoDireito().toString();
    }
}
