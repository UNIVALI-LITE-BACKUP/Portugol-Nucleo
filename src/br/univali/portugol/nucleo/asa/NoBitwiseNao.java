package br.univali.portugol.nucleo.asa;


/**
 * Representa uma operação de soma no código fonte.
    * Esta enumeração representa a operação de <code>Bitwise nao</code> no código fonte e é representada pelo operador "/".
    * <p>
    * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
    * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
    * 
 * </p>
 * @version 2.0
 */
public class NoBitwiseNao extends NoExpressao
{

    NoExpressao expressao;
    
    public NoBitwiseNao(NoExpressao expressao)
    {
        this.expressao = expressao;
    }
    
    /**
     * 
     * @return     a expressão que está sendo negada
     * @since 2.0
     */
    public NoExpressao getExpressao()
    {
        return expressao;
    }
    
    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return expressao.getTrechoCodigoFonte();
    }
}
