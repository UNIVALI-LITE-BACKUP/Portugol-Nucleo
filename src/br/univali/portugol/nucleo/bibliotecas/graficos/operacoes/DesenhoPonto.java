package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoPonto implements OperacaoGrafica
{
    private final int x;
    private final int y;

    public DesenhoPonto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        graficos.drawLine(x, y, x, y);
    }
}
