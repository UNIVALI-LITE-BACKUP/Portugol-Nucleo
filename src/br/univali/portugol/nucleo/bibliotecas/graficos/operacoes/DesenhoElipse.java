package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoElipse;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoElipse extends OperacaoGrafica
{
    public int x;
    public int y;
    public int largura;
    public int altura;
    public boolean preencher;
    public double rotacao;

    public DesenhoElipse(CacheOperacoesDesenhoElipse cache)
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
