package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesGraficas;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class OperacaoDefinirFonte extends OperacaoGrafica
{
    private Font fonte;

    public OperacaoDefinirFonte(CacheOperacoesGraficas<OperacaoDefinirFonte> cache)
    {
        super(cache);
    }
    
    void setParametros(Font fonte)
    {
        this.fonte = fonte;
    }

    @Override
    public void desenhar(Graphics2D graficos)
    {
        graficos.setFont(fonte);
    }
}
