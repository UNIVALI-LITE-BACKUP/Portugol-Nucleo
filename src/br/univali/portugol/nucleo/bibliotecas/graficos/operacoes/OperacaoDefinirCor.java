package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class OperacaoDefinirCor implements OperacaoGrafica
{
    private final Color cor;

    public OperacaoDefinirCor(Color cor)
    {
        this.cor = cor;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        graficos.setColor(cor);
    }
}
