package br.univali.portugol.nucleo.asa;

import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoMatriz extends NoExpressao
{
    private List<List<Object>> valores;

    public NoMatriz(List<List<Object>> valores)
    {
            this.valores = valores;
    }

    public List<List<Object>> getValores()
    {
            return valores;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
            return null;
    }
    
    @Override
    public void aceitar(VisitanteASA visitante) throws Exception
    {
        visitante.visitar(this);
    }
}
