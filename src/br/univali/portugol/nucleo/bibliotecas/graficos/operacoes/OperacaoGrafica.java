package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesGraficas;
import java.awt.Graphics2D;

/**
 *
 * @author Luiz Fernando
 */
public abstract class OperacaoGrafica
{
    private final CacheOperacoesGraficas cache;

    public OperacaoGrafica(CacheOperacoesGraficas cache)
    {
        this.cache = cache;
    }
    
    public final void liberar()
    {
        cache.devolver(this);
    }
    
    public abstract void executar(Graphics2D graficos);
}