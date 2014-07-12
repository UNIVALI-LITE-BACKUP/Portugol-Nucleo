package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class DesenhoPoligono implements OperacaoGrafica
{
    private final int[][] pontos;
    private final boolean preencher;
    private double rotacao;

    public DesenhoPoligono(int[][] pontos, boolean preencher, double rotacao)
    {
        this.pontos = pontos;
        this.preencher = preencher;
        this.rotacao = rotacao;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        Polygon poligono = new Polygon();
        
        int x, y, xCentro, yCentro;
        
        int xMaximo = Integer.MIN_VALUE;
        int xMinimo = Integer.MAX_VALUE;
        
        int yMaximo = Integer.MIN_VALUE;
        int yMinimo = Integer.MAX_VALUE;
        
        for (int[] ponto : pontos)
        {
            x = ponto[0];
            y = ponto[1];            
            
            poligono.addPoint(x, y);
            
            if (rotacao != 0.0)
            {            
                if (x > xMaximo)
                {
                    xMaximo = x;
                }

                if (x < xMinimo)
                {
                    xMinimo = x;
                }

                if (y > yMaximo)
                {
                    yMaximo = y;
                }

                if (y < yMinimo)
                {
                    yMinimo = y;
                }
            }
        }
        
        AffineTransform transformacao = graficos.getTransform();
        
        if (rotacao != 0.0)
        {
            xCentro = xMinimo + (Math.abs(xMaximo - xMinimo) / 2);
            yCentro = yMinimo + (Math.abs(yMaximo - yMinimo) / 2);
            
            graficos.rotate(rotacao, xCentro, yCentro);
        }

        if (preencher)
        {
            graficos.fill(poligono);
        }
        else
        {
            graficos.draw(poligono);
        }
        
        if (rotacao != 0.0)
        {
            graficos.setTransform(transformacao);
        }
    }
}
