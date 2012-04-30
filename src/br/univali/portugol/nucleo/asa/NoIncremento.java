package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoIncremento extends NoExpressao
{
    private NoExpressao expressao;

    public NoIncremento(NoExpressao expressao)
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
        TrechoCodigoFonte trechoCodigoFonte = expressao.getTrechoCodigoFonte();

        int linha = trechoCodigoFonte.getLinha();
        int coluna = trechoCodigoFonte.getColuna();
        int tamanhoTexto = trechoCodigoFonte.getTamanhoTexto() + 2;

        return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
    }

    @Override
    public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        return visitante.visitar(this);
    }
}
