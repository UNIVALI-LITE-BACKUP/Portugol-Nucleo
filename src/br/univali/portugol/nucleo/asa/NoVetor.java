package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoVetor extends NoExpressao
{
    private TrechoCodigoFonte token;
    private List<Object> valores;

    public NoVetor(List<Object> valores)
    {
        this.valores = valores;
    }

    public List<Object> getValores()
    {
        return valores;
    }

    public void setToken(TrechoCodigoFonte token)
    {
        this.token = token;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        return token;
    }
    
    @Override
    public void aceitar(VisitanteASA visitante) throws Exception
    {
        visitante.visitar(this);
    }
}
