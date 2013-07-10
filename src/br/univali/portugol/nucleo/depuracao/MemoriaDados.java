package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.simbolos.Memoria;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import java.util.Iterator;


public final class MemoriaDados implements Iterable<Simbolo>
{
    private Memoria memoria;

    public MemoriaDados(Memoria memoria)
    {
        this.memoria = memoria;
    }

    @Override
    public Iterator<Simbolo> iterator()
    {
        return memoria.getSimbolosVisiveisEscopoAtual().iterator();
    }
    
    
    
}
