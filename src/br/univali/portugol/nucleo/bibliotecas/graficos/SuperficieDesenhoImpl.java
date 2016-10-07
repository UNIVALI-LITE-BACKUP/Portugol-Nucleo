/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas.graficos;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoElipse;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoImagem;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoLinha;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoPonto;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoPorcaoImagem;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoRetangulo;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoTexto;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.DesenhoPoligono;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.OperacaoDefinirCor;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.OperacaoDefinirFonte;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.OperacaoLimpar;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.OperacaoGrafica;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.font.TextAttribute;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luiz Fernando
 */
final class SuperficieDesenhoImpl extends Canvas implements SuperficieDesenho
{
    private final List<OperacaoGrafica> operacoes = new ArrayList<>(512);

    private Font fonteTexto = null;
    private FontMetrics dimensoesFonte = null;

    private double rotacao = 0.0;
    private int opacidade = 255;
    private Color cor = new Color(0, 0, 0, opacidade);

    private BufferStrategy buffer;

    public SuperficieDesenhoImpl()
    {
        setIgnoreRepaint(true);
        setBackground(cor);
        setFocusable(false);
    }

    private void criarBuffer()
    {
        createBufferStrategy(2);
        buffer = getBufferStrategy();

        if (fonteTexto == null)
        {
            Graphics g = buffer.getDrawGraphics();

            fonteTexto = g.getFont();
            dimensoesFonte = getFontMetrics(fonteTexto);

            g.dispose();
        }
    }

    @Override
    public void renderizar()
    {
        do
        {
            do
            {
                Graphics2D graficos = (Graphics2D) buffer.getDrawGraphics();
                graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graficos.setColor(cor);
                graficos.setFont(fonteTexto);

                int totalOperacoes = operacoes.size();
                Rectangle bounds = getBounds();
                for (int i = 0; i < totalOperacoes; ++i)
                {
                    operacoes.get(i).executar(graficos, bounds);
                }

                graficos.dispose();
            }
            while (buffer.contentsRestored());

            buffer.show();
        }
        while (buffer.contentsLost());

        operacoes.clear();
    }

    private Color obterCorTransparente(int cor, int opacidade)
    {
        Color aux = new Color(cor);

        int a = opacidade;
        int r = aux.getRed();
        int g = aux.getGreen();
        int b = aux.getBlue();

        return new Color(r, g, b, a);
    }

    @Override
    public void redimensionar(int largura, int altura)
    {
        setBounds(0, 0, largura, altura);
        criarBuffer();
    }

    @Override
    public void limpar()
    {
        operacoes.add(new OperacaoLimpar());
    }

    @Override
    public void definirCor(int cor)
    {
        this.cor = obterCorTransparente(cor, opacidade);
        this.operacoes.add(new OperacaoDefinirCor(this.cor));
    }

    @Override
    public void definirOpacidade(int opacidade)
    {
        this.opacidade = opacidade;
        this.cor = obterCorTransparente(this.cor.getRGB(), opacidade);
        this.operacoes.add(new OperacaoDefinirCor(this.cor));
    }

    @Override
    public void desenharRetangulo(int x, int y, int largura, int altura, boolean arredondarCantos, boolean preencher)
    {
        operacoes.add(new DesenhoRetangulo(x, y, largura, altura, arredondarCantos, preencher, rotacao));
    }

    @Override
    public void desenharElipse(int x, int y, int largura, int altura, boolean preencher)
    {
        operacoes.add(new DesenhoElipse(x, y, largura, altura, preencher, rotacao));
    }

    @Override
    public void desenharLinha(int x1, int y1, int x2, int y2)
    {
        operacoes.add(new DesenhoLinha(x1, y1, x2, y2, rotacao));
    }

    @Override
    public void desenharTexto(String texto, int x, int y)
    {
        operacoes.add(new DesenhoTexto(x, y, texto, rotacao));
    }

    @Override
    public void definirFonteTexto(String nome)
    {
        int underline = (Integer) fonteTexto.getAttributes().get(TextAttribute.UNDERLINE);
        Font fonte = new Font(nome, Font.PLAIN, 12);

        fonte = fonte.deriveFont(fonteTexto.getStyle(), fonteTexto.getSize2D());

        Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) fonte.getAttributes();
        atributos.put(TextAttribute.UNDERLINE, underline);

        fonte = fonte.deriveFont(atributos);

        fonteTexto = fonte;
        dimensoesFonte = getFontMetrics(fonte);
        operacoes.add(new OperacaoDefinirFonte(fonte));
    }

    @Override
    public void definirEstiloTexto(boolean italico, boolean negrito, boolean sublinhado)
    {
        int estilo = Font.PLAIN;

        if (italico)
        {
            estilo = estilo | Font.ITALIC;
        }

        if (negrito)
        {
            estilo = estilo | Font.BOLD;
        }

        Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) fonteTexto.getAttributes();

        if (sublinhado)
        {
            atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        }
        else
        {
            atributos.put(TextAttribute.UNDERLINE, -1);
        }

        fonteTexto = fonteTexto.deriveFont(atributos);
        fonteTexto = fonteTexto.deriveFont(estilo);

        dimensoesFonte = getFontMetrics(fonteTexto);
        operacoes.add(new OperacaoDefinirFonte(fonteTexto));
    }

    @Override
    public void definirTamanhoTexto(double tamanho)
    {
        fonteTexto = fonteTexto.deriveFont((float) tamanho);

        dimensoesFonte = getFontMetrics(fonteTexto);
        operacoes.add(new OperacaoDefinirFonte(fonteTexto));
    }

    @Override
    public void desenharImagem(int x, int y, BufferedImage imagem)
    {
        operacoes.add(new DesenhoImagem(x, y, imagem, opacidade, rotacao));
    }

    @Override
    public void desenharPorcaoImagem(int x, int y, int xi, int yi, int largura, int altura, BufferedImage imagem)
    {
        // evita adicionar operações de pintura que estão fora das dimensões do canvas
        if (y + altura > 0 && y < getHeight() && x < getWidth() && x + largura > 0)
        {
            operacoes.add(new DesenhoPorcaoImagem(x, y, xi, yi, largura, altura, imagem, opacidade, rotacao));
        }
    }

    @Override
    public int alturaTexto(String texto)
    {
        return dimensoesFonte.getAscent() + dimensoesFonte.getLeading();
    }

    @Override
    public int larguraTexto(String texto)
    {
        return dimensoesFonte.stringWidth(texto);
    }

    public String nomeFonte()
    {
        return fonteTexto.getName();
    }

    @Override
    public void definirRotacao(int graus)
    {
        rotacao = Math.toRadians(graus % 360);
    }

    @Override
    public void desenharPonto(int x, int y)
    {
        operacoes.add(new DesenhoPonto(x, y));
    }

    @Override
    public BufferedImage renderizarImagem(int largura, int altura)
    {
        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graficos = (Graphics2D) imagem.getGraphics();
        
        graficos.setColor(cor);
        graficos.setFont(fonteTexto);
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Rectangle areaGraficos = new Rectangle(0, 0, largura, altura);

        for (OperacaoGrafica operacao : operacoes)
        {
            operacao.executar(graficos, areaGraficos);
        }

        operacoes.clear();
        
        return imagem;
    }

    @Override
    public void desenharPoligono(int[][] pontos, boolean preencher)
    {
        operacoes.add(new DesenhoPoligono(pontos, preencher, rotacao));
    }

    @Override
    public void instalarMouse(MouseAdapter observadorMouse)
    {
        addMouseListener(observadorMouse);
        addMouseMotionListener(observadorMouse);
    }
}
