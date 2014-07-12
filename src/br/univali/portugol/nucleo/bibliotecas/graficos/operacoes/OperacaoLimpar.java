package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschhang
 */
public final class OperacaoLimpar implements OperacaoGrafica
{
    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        graficos.fillRect(0, 0, areaGraficos.width, areaGraficos.height);
    }
}
