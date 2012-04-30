package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoVetor extends NoExpressao
{
    private TrechoCodigoFonte trechoCodigoFonte;
    private List<Object> valores;

    public NoVetor(List<Object> valores)
    {
        this.valores = valores;
    }

    public List<Object> getValores()
    {
        return valores;
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

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
