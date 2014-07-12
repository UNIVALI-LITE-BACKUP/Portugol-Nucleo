package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoElipse implements OperacaoGrafica
{
    private final int x;
    private final int y;
    private final int largura;
    private final int altura;
    private final boolean preencher;
    private final double rotacao;

    public DesenhoElipse(int x, int y, int largura, int altura, boolean preencher, double rotacao)
    {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.preencher = preencher;
        this.rotacao = rotacao;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        AffineTransform transformacao = graficos.getTransform();

        if (rotacao != 0.0)
        {
            graficos.rotate(rotacao, x + (largura / 2), y + (altura / 2));
        }

        if (preencher)
        {
            graficos.fillOval(x, y, largura, altura);
        }
        else
        {
            graficos.drawOval(x, y, largura, altura);
        }

        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
