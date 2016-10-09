package br.univali.portugol.nucleo.bibliotecas.graficos.operacoes;

import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDefinirCor;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDefinirFonte;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoElipse;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoImagem;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoLinha;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoPoligono;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoPonto;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoPorcaoImagem;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoRetangulo;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesDesenhoTexto;
import br.univali.portugol.nucleo.bibliotecas.graficos.operacoes.cache.CacheOperacoesLimpar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class PoolOperacoesGraficas
{
    private static final int QUANTIDADE_MAXIMA_OPERACOES = 128;
    private static final int QUANTIDADE_INICIAL_OPERACOES = 8;

    private final CacheOperacoesDesenhoElipse CACHE_OPERACOES_DESENHO_ELIPSE;
    private final CacheOperacoesDesenhoImagem CACHE_OPERACOES_DESENHO_IMAGEM;
    private final CacheOperacoesDesenhoLinha CACHE_OPERACOES_DESENHO_LINHA;
    private final CacheOperacoesDesenhoPoligono CACHE_OPERACOES_DESENHO_POLIGONO;
    private final CacheOperacoesDesenhoPonto CACHE_OPERACOES_DESENHO_PONTO;
    private final CacheOperacoesDesenhoPorcaoImagem CACHE_OPERACOES_DESENHO_PORCAO_IMAGEM;
    private final CacheOperacoesDesenhoRetangulo CACHE_OPERACOES_DESENHO_RETANGULO;
    private final CacheOperacoesDesenhoTexto CACHE_OPERACOES_DESENHO_TEXTO;
    private final CacheOperacoesDefinirCor CACHE_OPERACOES_DEFINIR_COR;
    private final CacheOperacoesDefinirFonte CACHE_OPERACOES_DEFINIR_FONTE;
    private final CacheOperacoesLimpar CACHE_OPERACOES_LIMPAR;

    public PoolOperacoesGraficas()
    {
        CACHE_OPERACOES_DESENHO_ELIPSE = new CacheOperacoesDesenhoElipse(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_IMAGEM = new CacheOperacoesDesenhoImagem(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_LINHA = new CacheOperacoesDesenhoLinha(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_POLIGONO = new CacheOperacoesDesenhoPoligono(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_PONTO = new CacheOperacoesDesenhoPonto(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_PORCAO_IMAGEM = new CacheOperacoesDesenhoPorcaoImagem(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_RETANGULO = new CacheOperacoesDesenhoRetangulo(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DESENHO_TEXTO = new CacheOperacoesDesenhoTexto(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DEFINIR_COR = new CacheOperacoesDefinirCor(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_DEFINIR_FONTE = new CacheOperacoesDefinirFonte(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
        CACHE_OPERACOES_LIMPAR = new CacheOperacoesLimpar(QUANTIDADE_MAXIMA_OPERACOES, QUANTIDADE_INICIAL_OPERACOES);
    }

    public DesenhoImagem obterOperacaoDesenhoImagem(int x, int y, BufferedImage imagem, int opacidade, double rotacao)
    {
        DesenhoImagem desenhoImagem = CACHE_OPERACOES_DESENHO_IMAGEM.obter();

        desenhoImagem.x = x;
        desenhoImagem.y = y;
        desenhoImagem.imagem = imagem;
        desenhoImagem.opacidade = opacidade;
        desenhoImagem.rotacao = rotacao;

        return desenhoImagem;
    }

    public OperacaoDefinirCor obterOperacaoDefinirCor(Color cor)
    {
        OperacaoDefinirCor operacaoDefinirCor = CACHE_OPERACOES_DEFINIR_COR.obter();

        operacaoDefinirCor.cor = cor;

        return operacaoDefinirCor;
    }

    public DesenhoRetangulo obterOperacaoDesenhoRetangulo(int x, int y, int largura, int altura, boolean arredondarCantos, boolean preencher, double rotacao)
    {
        DesenhoRetangulo desenhoRetangulo = CACHE_OPERACOES_DESENHO_RETANGULO.obter();

        desenhoRetangulo.x = x;
        desenhoRetangulo.y = y;
        desenhoRetangulo.largura = largura;
        desenhoRetangulo.altura = altura;
        desenhoRetangulo.arredondarCantos = arredondarCantos;
        desenhoRetangulo.preencher = preencher;
        desenhoRetangulo.rotacao = rotacao;

        return desenhoRetangulo;
    }

    public DesenhoElipse obterOperacaoDesenhoElipse(int x, int y, int largura, int altura, boolean preencher, double rotacao)
    {
        DesenhoElipse desenhoElipse = CACHE_OPERACOES_DESENHO_ELIPSE.obter();

        desenhoElipse.x = x;
        desenhoElipse.y = y;
        desenhoElipse.largura = largura;
        desenhoElipse.altura = altura;
        desenhoElipse.preencher = preencher;
        desenhoElipse.rotacao = rotacao;

        return desenhoElipse;
    }

    public DesenhoLinha obterOperacaoDesenhoLinha(int x1, int y1, int x2, int y2, double rotacao)
    {
        DesenhoLinha operacaoDesenhoLinha = CACHE_OPERACOES_DESENHO_LINHA.obter();

        operacaoDesenhoLinha.x1 = x1;
        operacaoDesenhoLinha.y1 = y1;
        operacaoDesenhoLinha.x2 = x2;
        operacaoDesenhoLinha.y2 = y2;
        operacaoDesenhoLinha.rotacao = rotacao;

        return operacaoDesenhoLinha;
    }

    public DesenhoPoligono obterOperacaoDesenhoPoligono(int[][] pontos, boolean preencher, double rotacao)
    {
        DesenhoPoligono operacaoDesenhoPoligono = CACHE_OPERACOES_DESENHO_POLIGONO.obter();

        operacaoDesenhoPoligono.pontos = pontos;
        operacaoDesenhoPoligono.preencher = preencher;
        operacaoDesenhoPoligono.rotacao = rotacao;

        return operacaoDesenhoPoligono;
    }

    public DesenhoPonto obterOperacaoDesenhoPonto(int x, int y)
    {
        DesenhoPonto operacaoDesenhoPonto = CACHE_OPERACOES_DESENHO_PONTO.obter();

        operacaoDesenhoPonto.x = x;
        operacaoDesenhoPonto.y = y;

        return operacaoDesenhoPonto;
    }

    public DesenhoPorcaoImagem obterOperacaoDesenhoPorcaoImagem(int x, int y, int xi, int yi, int largura, int altura, BufferedImage imagem, int opacidade, double rotacao)
    {
        DesenhoPorcaoImagem operacaoDesenhoPorcaoImagem = CACHE_OPERACOES_DESENHO_PORCAO_IMAGEM.obter();

        operacaoDesenhoPorcaoImagem.x = x;
        operacaoDesenhoPorcaoImagem.y = y;
        operacaoDesenhoPorcaoImagem.xi = xi;
        operacaoDesenhoPorcaoImagem.yi = yi;
        operacaoDesenhoPorcaoImagem.largura = largura;
        operacaoDesenhoPorcaoImagem.altura = altura;
        operacaoDesenhoPorcaoImagem.imagem = imagem;
        operacaoDesenhoPorcaoImagem.opacidade = opacidade;
        operacaoDesenhoPorcaoImagem.rotacao = rotacao;

        return operacaoDesenhoPorcaoImagem;
    }

    public DesenhoTexto obterOperacaoDesenhoTexto(int x, int y, String texto, double rotacao)
    {
        DesenhoTexto operacaoDesenhoTexto = CACHE_OPERACOES_DESENHO_TEXTO.obter();

        operacaoDesenhoTexto.x = x;
        operacaoDesenhoTexto.y = y;
        operacaoDesenhoTexto.texto = texto;
        operacaoDesenhoTexto.rotacao = rotacao;

        return operacaoDesenhoTexto;
    }

    public OperacaoDefinirFonte obterOperacaoDefinirFonte(Font fonte)
    {
        OperacaoDefinirFonte operacaoDefinirFonte = CACHE_OPERACOES_DEFINIR_FONTE.obter();

        operacaoDefinirFonte.fonte = fonte;

        return operacaoDefinirFonte;
    }

    public OperacaoLimpar obterOperacaoLimpar(Rectangle areaGraficos)
    {
        OperacaoLimpar operacaoLimpar = CACHE_OPERACOES_LIMPAR.obter();

        operacaoLimpar.areaGraficos = areaGraficos;

        return operacaoLimpar;
    }
}
