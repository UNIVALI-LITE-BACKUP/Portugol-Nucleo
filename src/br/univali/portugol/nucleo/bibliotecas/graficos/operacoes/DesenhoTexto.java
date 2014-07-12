package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoTexto implements OperacaoGrafica
{
    private final int x;
    private final int y;
    private final String texto;
    private final double rotacao;

    public DesenhoTexto(int x, int y, String texto, double rotacao)
    {
        this.x = x;
        this.y = y;
        this.texto = texto;
        this.rotacao = rotacao;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
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
