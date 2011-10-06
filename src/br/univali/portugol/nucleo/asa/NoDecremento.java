package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoDecremento extends NoExpressao
{
	private NoExpressao expressao;
	
	public NoDecremento(NoExpressao expressao)
	{
		this.expressao = expressao;
	}
	
	public NoExpressao getExpressao()
	{
		return expressao;
	}
	
	@Override
	protected TrechoCodigoFonte montarTrechoCodigoFonte()
	{
		TrechoCodigoFonte token = expressao.getReferenciaCodigo();
		
		int linha = token.getLinha();
		int coluna = token.getColuna();
		int tamanhoTexto = token.getTamanhoTexto() + 2;
		
		return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
	}

    @Override
    public void aceitar(VisitanteASA visitante) throws Exception 
    {
        visitante.visitar(this);
    }
}
