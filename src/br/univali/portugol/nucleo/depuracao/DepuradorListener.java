package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.simbolos.Simbolo;
import java.util.List;


public interface DepuradorListener
{
    public void depuracaoInicializada(InterfaceDepurador depurador);
    public void highlightLinha(int linha);
    public void HighlightDetalhadoAtual(int linha, int coluna, int tamanho);
    public void simbolosAlterados(List<Simbolo> simbolos);
    public void simboloDeclarado(Simbolo simbolo);
    public void simboloRemovido(Simbolo simbolo);
    
    
}
