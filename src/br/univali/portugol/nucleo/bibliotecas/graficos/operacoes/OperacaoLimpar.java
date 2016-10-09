package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschhang
 */
public final class OperacaoLimpar extends OperacaoGrafica
{
    public Rectangle areaGraficos;
    
    public OperacaoLimpar(CacheOperacoesGraficas<OperacaoLimpar> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
    {
        graficos.fillRect(0, 0, areaGraficos.width, areaGraficos.height);
    }
}
