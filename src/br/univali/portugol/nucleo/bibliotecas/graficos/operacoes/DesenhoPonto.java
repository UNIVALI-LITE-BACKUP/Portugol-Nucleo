package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesGraficas;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoPonto extends OperacaoGrafica
{
    public int x;
    public int y;

    public DesenhoPonto(CacheOperacoesGraficas<DesenhoPonto> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
    {
        graficos.drawLine(x, y, x, y);
    }
}
