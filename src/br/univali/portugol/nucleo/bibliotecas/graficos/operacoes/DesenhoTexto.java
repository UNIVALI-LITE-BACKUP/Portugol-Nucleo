package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoTexto extends OperacaoGrafica
{
    public int x;
    public int y;
    public String texto;
    public double rotacao;

    public DesenhoTexto(CacheOperacoesGraficas<DesenhoTexto> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
    {
        FontMetrics dimensoesFonte = graficos.getFontMetrics();

        int largura = dimensoesFonte.stringWidth(texto);
        int altura = dimensoesFonte.getAscent() - dimensoesFonte.getDescent() + dimensoesFonte.getLeading() + 1;

        AffineTransform transformacao = graficos.getTransform();

        if (rotacao != 0.0)
        {
            graficos.rotate(rotacao, x + (largura / 2), y + (altura / 2));
        }

        graficos.drawString(texto, x, y + altura);

        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
