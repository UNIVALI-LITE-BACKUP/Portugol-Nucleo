package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.execucao.Interpretador;

public interface Depurador extends Interpretador
{
    public void addListener(DepuradorListener listener);
    
    public void removeListener(DepuradorListener listener);
    
}
