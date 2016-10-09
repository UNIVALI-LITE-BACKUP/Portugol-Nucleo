package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class OperacaoDefinirFonte extends OperacaoGrafica
{
    public Font fonte;

    public OperacaoDefinirFonte(CacheOperacoesGraficas<OperacaoDefinirFonte> cache)
    {
        super(cache);
    }

    @Override
    public void executar(Graphics2D graficos)
    {
        graficos.setFont(fonte);
    }
}
