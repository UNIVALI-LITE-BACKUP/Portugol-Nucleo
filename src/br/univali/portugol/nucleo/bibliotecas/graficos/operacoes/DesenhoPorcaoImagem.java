package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoPorcaoImagem implements OperacaoGrafica
{
    private final int x;
    private final int y;
    private final int xi;
    private final int yi;
    private final int largura;
    private final int altura;
    private final BufferedImage imagem;
    private final int opacidade;
    private final double rotacao;

    public DesenhoPorcaoImagem(int x, int y, int xi, int yi, int largura, int altura, BufferedImage imagem, int opacidade, double rotacao)
    {
        this.x = x;
        this.y = y;
        this.xi = xi;
        this.yi = yi;
        this.largura = largura;
        this.altura = altura;
        this.imagem = imagem;
        this.opacidade = opacidade;
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

        if (opacidade == 255)
        {
            graficos.drawImage(imagem, x, y, x + largura, y + altura, xi, yi, xi + largura, yi + altura, null);
        }
        else
        {
            float a = (1.0f * opacidade) / 255.f;

            Composite original = graficos.getComposite();
            Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a);

            graficos.setComposite(alpha);
            graficos.drawImage(imagem, x, y, x + largura, y + altura, xi, yi, xi + largura, yi + altura, null);
            graficos.setComposite(original);
        }

        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
