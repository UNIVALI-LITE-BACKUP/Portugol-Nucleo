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

    public boolean evaluate(VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        if (evaluatedValue == null)
        {
            evaluatedValue = doEvaluation(visitor); //se a igualdade for testada mais de uma vez o valor que já foi avaliado será retornado
        }
        return evaluatedValue;
    }
    
    private Boolean doEvaluation(VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        
        Object opEsq = getOperandoEsquerdo().aceitar(visitor);
        Object opDir = getOperandoDireito().aceitar(visitor);
        
        Class esqClass = opEsq.getClass();
        Class dirClass = opDir.getClass();
        
        if (esqClass.equals(dirClass)) 
        {
            return opEsq.equals(opDir);
        }
        
        // trata os casos de comparação de inteiro com real e de real com inteiro
        if (opEsq instanceof Integer && opDir instanceof Double) 
        {
            return ((Integer)opEsq).intValue() == ((Double) opDir).intValue();
        }
        else if (opEsq instanceof Double && opDir instanceof Integer)
        {
            return ((Double)opEsq).intValue() == ((Integer) opDir).intValue();
        }
        
        throw new ExcecaoVisitaASA("Erro avaliando expressão de igualdade!", null, this);
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
