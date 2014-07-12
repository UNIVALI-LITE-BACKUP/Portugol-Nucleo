package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoLinha implements OperacaoGrafica
{
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final double rotacao;

    public DesenhoLinha(int x1, int y1, int x2, int y2, double rotacao)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.rotacao = rotacao;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        AffineTransform transformacao = graficos.getTransform();
        
        if (rotacao != 0.0)
        {
            graficos.rotate(rotacao, x1 + (Math.abs(x1 - x2) / 2), y1 + (Math.abs(y1 - y2) / 2));
        }
        
        graficos.drawLine(x1, y1, x2, y2);
        
        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
