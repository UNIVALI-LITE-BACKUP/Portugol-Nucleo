package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class OperacaoDefinirCor extends OperacaoGrafica
{
    public Color cor;

    public OperacaoDefinirCor(CacheOperacoesGraficas<OperacaoDefinirCor> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
    {
        graficos.setColor(cor);
    }
}
