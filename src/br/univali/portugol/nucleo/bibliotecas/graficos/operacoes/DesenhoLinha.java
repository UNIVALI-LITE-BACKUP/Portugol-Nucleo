package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoLinha extends OperacaoGrafica
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public double rotacao;

    public DesenhoLinha(CacheOperacoesGraficas<DesenhoLinha> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
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
