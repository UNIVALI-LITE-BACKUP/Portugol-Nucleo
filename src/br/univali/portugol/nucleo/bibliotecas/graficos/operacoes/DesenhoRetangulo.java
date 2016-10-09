package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoRetangulo extends OperacaoGrafica
{
    public int x;
    public int y;
    public int largura;
    public int altura;
    public boolean preencher;
    public boolean arredondarCantos;
    public double rotacao;

    public DesenhoRetangulo(CacheOperacoesGraficas cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
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
