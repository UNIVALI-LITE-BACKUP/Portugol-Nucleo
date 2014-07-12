package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoRetangulo implements OperacaoGrafica
{
    private final int x;
    private final int y;
    private final int largura;
    private final int altura;
    private final boolean preencher;
    private final boolean arredondarCantos;
    private final double rotacao;

    public DesenhoRetangulo(int x, int y, int largura, int altura, boolean arredondarCantos, boolean preencher, double rotacao)
    {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.preencher = preencher;
        this.arredondarCantos = arredondarCantos;
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
            if (arredondarCantos)
            {
                int canto = (int) (Math.min(largura, altura) * 0.2);
                graficos.fillRoundRect(x, y, largura, altura, canto, canto);
            }
            else
            {
                graficos.fillRect(x, y, largura, altura);
            }
        }
        else
        {
            if (arredondarCantos)
            {
                int canto = (int) (Math.min(largura, altura) * 0.2);
                graficos.drawRoundRect(x, y, largura, altura, canto, canto);
            }
            else
            {
                graficos.drawRect(x, y, largura, altura);
            }
        }

        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
