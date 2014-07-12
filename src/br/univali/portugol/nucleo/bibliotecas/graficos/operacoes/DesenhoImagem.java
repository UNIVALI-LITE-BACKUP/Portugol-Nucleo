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
public final class DesenhoImagem implements OperacaoGrafica
{
    private final int x;
    private final int y;
    private final BufferedImage imagem;
    private final int opacidade;
    private final double rotacao;

    public DesenhoImagem(int x, int y, BufferedImage imagem, int opacidade, double rotacao)
    {
        this.x = x;
        this.y = y;
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
            graficos.rotate(rotacao, x + (imagem.getWidth() / 2), y + (imagem.getHeight() / 2));
        } 
        
        if (opacidade == 255)
        {
            graficos.drawImage(imagem, x, y, null);
        }
        else
        {
            float a = (1.0f * opacidade) / 255.f;
            
            Composite original = graficos.getComposite();
            Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a);
            
            graficos.setComposite(alpha);
            graficos.drawImage(imagem, x, y, null);
            graficos.setComposite(original);
        }
        
        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
