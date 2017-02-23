package br.univali.portugol.nucleo.bibliotecas.graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ImagemGenerica extends Imagem
{
    private final BufferedImage imagem;
    
    public ImagemGenerica(BufferedImage imagem)
    {
        this.imagem = Utils.criarImagemCompativel(imagem);
    }

    @Override
    public BufferedImage getImagem()
    {
        return imagem;
    }
}
