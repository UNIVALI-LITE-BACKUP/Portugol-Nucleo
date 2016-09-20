package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de soma no código fonte.
 * <p>
 * A operação de <code>diferença</code> serve para determinar se duas expressões são diferentes.
 * No Portugol, a operação de <code>diferença</code> é representada no código fonte pelo operador "!=".
 * </p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public final class NoOperacaoLogicaDiferenca extends NoOperacaoLogica
{
    private Boolean evaluatedValue = null;
    
    public NoOperacaoLogicaDiferenca(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
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
            return !opEsq.equals(opDir);
        }
        
        // trata os casos de comparação de inteiro com real e real com inteiro
        Number a = ((NoValor<Number>)opEsq).getValor();
        Number b = ((NoValor<Number>)opDir).getValor();
        return a.intValue() != b.intValue();
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
