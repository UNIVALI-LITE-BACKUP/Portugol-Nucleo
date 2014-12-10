package br.univali.portugol.nucleo.depuracao;

import java.util.List;

public interface Depurador
{

    static enum Estado
    {
        BREAK_POINT, STEP_INTO, STEP_OVER, INIT
    }

    public Estado getEstado();
    
    public void setEstado(Estado novoEstado);
    
    void addListeners(List<DepuradorListener> listeners);

    void addListener(DepuradorListener listener);

    public void removeListener(DepuradorListener listener);
}
