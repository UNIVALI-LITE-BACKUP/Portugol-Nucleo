package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class OperacaoDefinirFonte implements OperacaoGrafica
{
    private final Font fonte;

    public OperacaoDefinirFonte(Font fonte)
    {
        this.fonte = fonte;
    }

    @Override
    public void executar(Graphics2D graficos, Rectangle areaGraficos)
    {
        graficos.setFont(fonte);
    }
}
