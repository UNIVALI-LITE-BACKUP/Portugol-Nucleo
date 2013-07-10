package br.univali.portugol.nucleo.depuracao;


public interface DepuradorListener
{
    public void depuracaoInicializada(InterfaceDepurador depurador);
    public void highlightLinha(int linha);
    public void HighlightDetalhadoAtual(int linha, int coluna, int tamanho);
    public void simbolos(MemoriaDados dados);
    
    
}
