package br.univali.portugol.nucleo.bibliotecas.graficos;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class CacheImagens
{
    private static final int NUMERO_MAXIMO_IMAGENS = 128;

    private final BufferedImage[] imagens = new BufferedImage[NUMERO_MAXIMO_IMAGENS];
    private final Programa programa;

    private CacheImagens(Programa programa)
    {
        this.programa = programa;
    }

    public static CacheImagens criar(Programa programa)
    {
        return new CacheImagens(programa);
    }

    private int obterProximoIndiceLivre() throws ErroExecucaoBiblioteca
    {
        for (int indice = NUMERO_MAXIMO_IMAGENS - 1; indice >= 0; indice--)
        {
            if (imagens[indice] == null)
            {
                return indice;
            }
        }

        throw new ErroExecucaoBiblioteca("O número máximo de imagens que podem ser carregadas foi atingido");
    }

    public BufferedImage obterImagem(int endereco) throws ErroExecucaoBiblioteca
    {
        if (endereco >= 0 && endereco < NUMERO_MAXIMO_IMAGENS)
        {
            BufferedImage imagem = imagens[endereco];

            if (imagem != null)
            {
                return imagem;
            }
        }

        throw new ErroExecucaoBiblioteca("O endereço de memória especificado não aponta para uma imagem");
    }

    public void liberar()
    {
        for (int indice = 0; indice < NUMERO_MAXIMO_IMAGENS; indice++)
        {
            imagens[indice] = null;
        }
    }

    public void liberarImagem(int endereco) 
    {
        if (endereco >=0 && endereco < NUMERO_MAXIMO_IMAGENS)
        {
            imagens[endereco] = null;
        }
    }

    public int adicionarImagem(BufferedImage imagem) throws ErroExecucaoBiblioteca
    {
        int indiceImagem = obterProximoIndiceLivre();

        imagens[indiceImagem] = imagem;

        return indiceImagem;
    }
}
