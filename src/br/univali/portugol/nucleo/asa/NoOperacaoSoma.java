package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de soma no código fonte.
 * <p>
 * A operação de <code>soma</code> serve para unir duas expressões e é representada no código fonte pelo operador "+".
 * O resultado desta operação, depende do tipo de dado dos seus operandos.
 * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
 * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
 * <p>
 * @author Luiz Fernando Noschang
 * @version 1.13
 */
public class NoOperacaoSoma extends NoOperacao
{

    public NoOperacaoSoma(NoExpressao operandoEsquerdo, NoExpressao operandoDireito)
    {
        super(operandoEsquerdo, operandoDireito);
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
