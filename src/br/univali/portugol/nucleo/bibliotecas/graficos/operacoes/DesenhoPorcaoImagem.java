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
public final class DesenhoPorcaoImagem extends OperacaoGrafica
{
    public int x;
    public int y;
    public int xi;
    public int yi;
    public int largura;
    public int altura;
    public BufferedImage imagem;
    public int opacidade;
    public double rotacao;

    public DesenhoPorcaoImagem(CacheOperacoesGraficas<DesenhoPorcaoImagem> cache)
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
