package br.univali.portugol.nucleo.bibliotecas.graficos;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class Utils
{
    public static BufferedImage criarImagemCompativel(BufferedImage original)
    {
        GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        
        BufferedImage imagemCompativel = graphicsConfiguration.createCompatibleImage(original.getWidth(null), original.getHeight(null), original.getTransparency());
        Graphics g = imagemCompativel.getGraphics();
        
        g.drawImage(original, 0, 0, null);
        g.dispose();
        
        return imagemCompativel;
    }
}
