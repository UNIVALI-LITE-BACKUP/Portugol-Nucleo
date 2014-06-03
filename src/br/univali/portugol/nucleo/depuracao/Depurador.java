package br.univali.portugol.nucleo.depuracao;

import java.util.List;

public interface Depurador
{
    void addListeners(List<DepuradorListener> listeners);
    void addListener(DepuradorListener listener);
    
    public void removeListener(DepuradorListener listener);    
}
