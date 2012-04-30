package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoCadeia extends NoExpressao
{
    private String valor;
    private TrechoCodigoFonte trechoCodigoFonte;

    public NoCadeia(String valor)
    {
        this.valor = tratarCadeia(valor);
    }

    public String getValor()
    {
        return valor;
    }

    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return trechoCodigoFonte;
    }

    private String tratarCadeia(String valor)
    {
        valor = valor.replace("\\n", "\n");
        valor = valor.replace("\\\"", "\"");
        valor = valor.replace("\\t", "\t");

        return valor;
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}