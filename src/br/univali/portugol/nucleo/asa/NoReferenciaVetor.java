package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */
public final class NoReferenciaVetor extends NoReferencia
{
    private NoExpressao noIndice;

    public NoReferenciaVetor(String nome, NoExpressao indice)
    {
        super(nome);
        this.noIndice = indice;
    }

    public NoExpressao getIndice()
    {
        return noIndice;
    }

    @Override
    protected TrechoCodigoFonte montarTrechoCodigoFonte()
    {
        int tamanhoTexto = 0;

        int linha = getTrechoCodigoFonteNome().getLinha();
        int coluna = getTrechoCodigoFonteNome().getColuna();

        tamanhoTexto = tamanhoTexto + getTrechoCodigoFonteNome().getTamanhoTexto() + 2 + noIndice.getReferenciaCodigo().getTamanhoTexto();

        return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
    }

    @Override
    public void aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
    {
        visitante.visitar(this);
    }
}
