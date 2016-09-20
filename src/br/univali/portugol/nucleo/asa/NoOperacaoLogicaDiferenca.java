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

    @Override
    public Boolean evaluate(VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        Object opEsq = getOperandoEsquerdo().aceitar(visitor);
        Object opDir = getOperandoDireito().aceitar(visitor);
        
        if (opEsq.getClass().equals(opDir.getClass())) 
        {
            return !opEsq.equals(opDir);
        }
        
        // trata os casos de comparação de inteiro com real e de real com inteiro
        if (opEsq instanceof Integer && opDir instanceof Double) 
        {
            return ((Integer)opEsq).intValue() != ((Double) opDir).intValue();
        }
        else if (opEsq instanceof Double && opDir instanceof Integer)
        {
            return ((Double)opEsq).intValue() != ((Integer) opDir).intValue();
        }
        
        throw new ExcecaoVisitaASA("Erro avaliando expressão de diferença!", null, this);
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
