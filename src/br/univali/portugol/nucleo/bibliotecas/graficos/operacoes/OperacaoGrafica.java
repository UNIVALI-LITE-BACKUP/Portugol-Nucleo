package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface OperacaoGrafica
{
    public void executar(Graphics2D graficos, Rectangle areaGraficos);
}
