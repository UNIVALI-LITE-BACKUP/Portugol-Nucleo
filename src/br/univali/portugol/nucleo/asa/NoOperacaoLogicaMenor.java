package br.univali.portugol.nucleo.asa;

import br.univali.portugol.nucleo.execucao.Depurador;


/**
 * Esta enumeração representa a operação <code>menor</code> no código fonte.
 * <p>
 * A operação <code>menor</code>serve para verificar se uma expressão é maior que outra.
 * No Portugol, a operação <code>menor</code> é representada no código fonte pelo operador "&lt;".
 * A operação <code>menor</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
 * valor lógico: <code>verdadeiro</code> se a expressão à esquerda do operador for menor que à expressão
 * à direita do operador, caso contrário retorna <code>falso</code>.Pode ser utilizada para realizar o 
 * controle de laços de repetição e desvios condicionais.
 * </p>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public final class NoOperacaoLogicaMenor extends NoOperacaoLogica
{
    public NoOperacaoLogicaMenor(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }

    @Override
    public Boolean evaluate(VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        Object opEsq = getOperandoEsquerdo().aceitar(visitor);
        Object opDir = getOperandoDireito().aceitar(visitor);

        if (opEsq instanceof Number && opDir instanceof Number)
        {
            return ((Number)opEsq).doubleValue() < ((Number)opDir).doubleValue();
        }
 
        throw new ExcecaoVisitaASA("Tipo inválido na operação lógica 'menor'", null, this);
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
    public boolean ehParavel(Depurador.Estado estado)
    {
         return super.ehParavel(estado) && getPai() instanceof NoPara;
    }
    
    
}
