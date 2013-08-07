package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.execucao.Interpretador;
import java.util.List;

public interface Depurador extends Interpretador
{
    public void addListeners(List<DepuradorListener> listeners);
    public void addListener(DepuradorListener listener);
    
    public void removeListener(DepuradorListener listener);
    
}
