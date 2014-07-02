package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca(
        descricao = "Esta biblioteca permite inicializar e utilizar um ambiente gráfico com "
        + "suporte ao desenho de primitivas gráficas e de imagens carregadas do "
        + "sistema de arquivos",
        versao = "1.6"
)
public final class Graficos extends Biblioteca implements Teclado.InstaladorTeclado, Mouse.InstaladorMouse
{
    private static final int NUMERO_MAXIMO_IMAGENS = 128;
    private static final int ALTURA_PADRAO = 480;
    private static final int LARGURA_PADRAO = 640;

    private Programa programa;
    private Janela janela;
    private Image[] imagens;

    private ArrayList<OperacaoDesenho> operacoesDesenho;

    @DocumentacaoConstante(descricao = "constante que representa a cor 'preto'")
    public static final Integer COR_PRETO = Color.BLACK.getRGB();

    @DocumentacaoConstante(descricao = "constante que representa a cor 'branca'")
    public static final Integer COR_BRANCO = Color.WHITE.getRGB();

    @DocumentacaoConstante(descricao = "constante que representa a cor 'azul'")
    public static final Integer COR_AZUL = Color.BLUE.getRGB();

    @DocumentacaoConstante(descricao = "constante que representa a cor 'vermelho'")
    public static final Integer COR_VERMELHO = Color.RED.getRGB();

    @DocumentacaoConstante(descricao = "constante que representa a cor 'verde'")
    public static final Integer COR_VERDE = Color.GREEN.getRGB();

    @DocumentacaoConstante(descricao = "constante que representa a cor 'amarelo'")
    public static final Integer COR_AMARELO = Color.YELLOW.getRGB();

    @DocumentacaoFuncao(
            descricao = "Inicia o modo gráfico e exibe uma janela com as configurações padrão (tamanho 640x480 e fundo preto). "
            + "Se o modo gráfico já estiver iniciado, nada acontecerá",
            parametros =
            {
                @DocumentacaoParametro(
                        nome = "manter_visivel",
                        descricao = "define se a janela do ambiente gráfico deve permanecer sempre visível sobre as outras janelas (útil durante a depuração)"
                )
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void iniciar_modo_grafico(final Boolean manter_visivel) throws ErroExecucaoBiblioteca
    {
        if (!ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setVisible(true);
                        janela.setAlwaysOnTop(manter_visivel);
                        janela.requestFocusInWindow();

                        while (!janela.isVisible())
                        {

                        }
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Encerra o programa como se o usuário tivesse clicado no botão 'Fechar' da janela",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void fechar_janela() throws ErroExecucaoBiblioteca
    {
        encerrar_modo_grafico();
        programa.interromper();
    }

    @DocumentacaoFuncao(
            descricao = "Minimiza a janela do ambiente gráfico, como se o usuário tivesse clicado no botão 'Minimizar' da janela",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void minimizar_janela() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setExtendedState(JFrame.ICONIFIED);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Restaura a janela do ambiente gráfico, como se o usuário tivesse clicado no ícone do programa na barra de tarefas do Sistema Operacional",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void restaurar_janela() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setExtendedState(JFrame.NORMAL);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Oculta a borda da janela do modo gráfico, fazendo com que somente o conteúdo da janela seja exibido",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void ocultar_borda_janela() throws ErroExecucaoBiblioteca
    {
        ocultar_borda(true);
    }

    @DocumentacaoFuncao(
            descricao = "Exibe novamente a borda da janela do modo gráfico, caso ela esteja oculta",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void exibir_borda_janela() throws ErroExecucaoBiblioteca
    {
        ocultar_borda(false);
    }

    private void ocultar_borda(final boolean ocultar) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setVisible(false);
                        janela.dispose();
                        janela.setUndecorated(ocultar);
                        janela.setVisible(true);

                        // Deve ser chamado após exibir a janela, caso contrário a janela estará em estado 
                        // inválido (disposed) e a chamada gerará uma exceção
                        janela.definirDimensoes(janela.largura, janela.altura);

                        janela.setLocationRelativeTo(null);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "Encerra o modo gráfico e fecha a janela criada com a função 'iniciar_modo_grafico'",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void encerrar_modo_grafico() throws ErroExecucaoBiblioteca
    {
        encerrar();
    }

    @DocumentacaoFuncao(
            descricao = "altera as dimensões da janela do ambiente gráfico",
            parametros =
            {
                @DocumentacaoParametro(nome = "largura", descricao = "a nova largura da janela"),
                @DocumentacaoParametro(nome = "altura", descricao = "a nova altura da janela")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_dimensoes_janela(final Integer largura, final Integer altura) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.definirDimensoes(largura, altura);
                        janela.setLocationRelativeTo(null);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "define o texto da janela do ambiente gráfico",
            parametros =
            {
                @DocumentacaoParametro(nome = "titulo", descricao = "o novo título da janela")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_titulo_janela(final String titulo) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setTitle(titulo);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }

        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "limpa o desenho do ambiente e gráfico e preenche o fundo com a cor atual",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void limpar() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    SuperficieDesenho superficieDesenho = janela.superficieDesenho;

                    g2d.fillRect(0, 0, superficieDesenho.getWidth(), superficieDesenho.getHeight());
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "cria uma nova cor a partir da combinação de tons de vermelho, verde e azul",
            parametros =
            {
                @DocumentacaoParametro(nome = "vermelho", descricao = "o tom de vermelho (0 a 255)"),
                @DocumentacaoParametro(nome = "verde", descricao = "o tom de verde (0 a 255)"),
                @DocumentacaoParametro(nome = "azul", descricao = "o tom de verde (0 a 255)")
            },
            retorno = "a nova cor criada pela combinação dos tons de vermelho, verde e azul",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            },
            referencia = "http://pt.wikipedia.org/wiki/RGB"
    )
    public Integer criar_cor(Integer vermelho, Integer verde, Integer azul) throws ErroExecucaoBiblioteca
    {
        try
        {
            return new Color(vermelho, verde, azul).getRGB();
        }
        catch (IllegalArgumentException excecao)
        {
            String corErrada = "indefinido";

            if (excecao.getMessage().contains("Red"))
            {
                corErrada = "vermelho";
            }
            else
            {
                if (excecao.getMessage().contains("Green"))
                {
                    corErrada = "verde";
                }
                else
                {
                    if (excecao.getMessage().contains("Blue"))
                    {
                        corErrada = "azul";
                    }
                }
            }

            throw new ErroExecucaoBiblioteca(String.format("Erro ao criar a cor, o valor do tom de %s deve estar entre 0 e 255", corErrada));
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Quando uma função de desenho da biblioteca é chamada, o desenho não é realizado imediatamente na tela, "
            + "mas sim, em uma área reservada da memória. Isto é feito com o objetivo de aumentar o desempenho do "
            + "programa e minimizar outros problemas. Esta técnica é chamada de <b>Back Buffer</b> ou <b>Double Buffer</b>.<br><br>"
            + "A função renderizar, faz com que os desenhos existentes no <b>Back Buffer</b> sejam desenhados na tela.<br><br>"
            + "Esta função deve ser chamada sempre após todas as outras funções de desenho, para garantir que todos os"
            + "desenhos sejam exibidos",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            },
            referencia = "http://en.wikipedia.org/wiki/Multiple_buffering#Double_buffering_in_computer_graphics"
    )
    public void renderizar() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        BufferStrategy estrategia = janela.superficieDesenho.estrategiaBuffer;

                        do
                        {
                            do
                            {
                                Graphics2D graphics = janela.superficieDesenho.getGraphics2D();

                                for (OperacaoDesenho op : operacoesDesenho)
                                {
                                    try
                                    {
                                        op.desenhar(graphics);
                                    }
                                    catch (ErroExecucaoBiblioteca ex)
                                    {
                                        throw new RuntimeException(ex);
                                    }
                                }

                                graphics.dispose();
                            }
                            while (estrategia.contentsRestored());

                            estrategia.show();
                        }
                        while (estrategia.contentsLost());

                        operacoesDesenho.clear();
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }

        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha um retângulo na posição definida pelos parâmetros <param>x</param> e <param>y</param> "
            + "e com as dimensões especificadas pelos parâmetros <param>largura</param> e <param>altura</param>. <br><br>"
            + "O retângulo é desenhado na tela a partir do seu canto superior esquerdo ",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do retângulo no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do retângulo no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "largura", descricao = "a largura do retângulo em pixels"),
                @DocumentacaoParametro(nome = "altura", descricao = "a altura do retângulo em pixels"),
                @DocumentacaoParametro(
                        nome = "preencher",
                        descricao
                        = "define se o retângulo será preenchido com a cor do ambiente gráfico. "
                        + "Se o valor for <tipo>verdadeiro</tipo>, o retângulo será preenchido. Se o valor for "
                        + "<tipo>falso</tipo>, somente o contorno do retângulo será desenhado"
                )
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_retangulo(final Integer x, final Integer y, final Integer largura, final Integer altura, final Boolean preencher) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    if (preencher)
                    {
                        g2d.fillRect(x, y, largura, altura);
                    }
                    else
                    {
                        g2d.drawRect(x, y, largura, altura);
                    }
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha uma elipse na posição definida pelos parâmetros <param>x</param> e <param>y</param> "
            + "e com as dimensões especificadas pelos parâmetros <param>largura</param> e <param>altura</param>, .<br><br>"
            + "A elipse é desenhada na tela a partir do seu canto superior esquerdo",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do círculo no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do círculo no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "largura", descricao = "a largura da elipse em pixels"),
                @DocumentacaoParametro(nome = "altura", descricao = "a altura da elipse em pixels"),
                @DocumentacaoParametro(
                        nome = "preencher",
                        descricao
                        = "define se a elipse será preenchida com a cor do ambiente gráfico. "
                        + "Se o valor for <tipo>verdadeiro</tipo>, a elipse será preenchida. Se o valor for "
                        + "<tipo>falso</tipo>, somente o contorno da elipse será desenhado"
                )
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_elipse(final Integer x, final Integer y, final Integer largura, final Integer altura, final Boolean preencher) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    if (preencher)
                    {
                        g2d.fillOval(x, y, largura, largura);
                    }
                    else
                    {
                        g2d.drawOval(x, y, largura, largura);
                    }
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha um ponto na posição definida pelos parâmetros <param>x</param> e <param>y</param>.<br><br>"
            + "O ponto desenhado ocupa um único pixel na tela",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a coordenada (distância) do ponto no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a coordenada (distância) do ponto no eixo vertical, em relação ao topo da janela"),
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_ponto(final Integer x, final Integer y) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    g2d.drawLine(x, y, x, y);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha uma linha de um ponto 'A' (definido pelos parâmetros <param>x1</param> e <param>y1</param>) "
            + "até um ponto 'B' (definido pelos parâmetros <param>x2</param> e <param>y2</param>)",
            parametros =
            {
                @DocumentacaoParametro(nome = "x1", descricao = "a coordenada (distância) do ponto 'A' no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y1", descricao = "a coordenada (distância) do ponto 'A' no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "x2", descricao = "a coordenada (distância) do ponto 'B' no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y2", descricao = "a coordenada (distância) do ponto 'B' no eixo vertical, em relação ao topo da janela"),
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_linha(final Integer x1, final Integer y1, final Integer x2, final Integer y2) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    g2d.drawLine(x1, y1, x2, y2);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Carrega uma imagem na memória para ser utilizada mais tarde. Os formatos de imagem suportados "
            + "são: JPEG, PNG, BITMAP e GIF",
            parametros =
            {
                @DocumentacaoParametro(nome = "caminho", descricao = "o caminho do arquivo de imagem no computador")
            },
            retorno = "o endereço de memória no qual a imagem foi carregada",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Integer carregar_imagem(String caminho) throws ErroExecucaoBiblioteca
    {
        File arquivo = programa.resolverCaminho(new File(caminho));
        int indiceImagem = obterProximoIndiceLivre();

        if (arquivo.exists())
        {
            if (arquivo.isFile())
            {
                if (arquivo.canRead())
                {
                    if (indiceImagem >= 0)
                    {
                        try
                        {
                            imagens[indiceImagem] = ImageIO.read(arquivo);
                            indiceImagem = indiceImagem - 1;

                            return indiceImagem + 1;
                        }
                        catch (IOException excecao)
                        {
                            throw new ErroExecucaoBiblioteca(String.format("A imagem '%s' é inválida", caminho));
                        }
                    }
                    else
                    {
                        throw new ErroExecucaoBiblioteca("O número máximo de imagens que podem ser carregadas foi atingido");
                    }
                }
                else
                {
                    throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' não pode ser lido", caminho));
                }
            }
            else
            {
                throw new ErroExecucaoBiblioteca(String.format("O caminho '%s' não é um arquivo", caminho));
            }
        }
        else
        {
            throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' não existe", caminho));
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha uma imagem previamente carregada, na posição especificada pelos "
            + "parâmetros <param>x</param> e <param>y</param>",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) da imagem no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) da imagem no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da imagem a ser desenhada")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_imagem(final Integer x, final Integer y, Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            final Image imagem = obterImagem(endereco);

            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    g2d.drawImage(imagem, x, y, null);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha uma porção de uma imagem previamente carregada, na posição especificada pelos "
            + "parâmetros <param>x</param> e <param>y</param>",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) da imagem no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) da imagem no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "xi", descricao = "a posição (distância) no eixo horizontal a partir da qual a imagem começará a ser desenhada"),
                @DocumentacaoParametro(nome = "yi", descricao = "a posição (distância) no eixo vertical a partir da qual a imagem começará a ser desenhada"),
                @DocumentacaoParametro(nome = "largura", descricao = "a largura da porção da imagem a ser desenhada"),
                @DocumentacaoParametro(nome = "altura", descricao = "a altura da porção da imagem a ser desenhada"),
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da imagem a ser desenhada")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_porcao_imagem(final Integer x, final Integer y, final Integer xi, final Integer yi, final Integer largura, final Integer altura, Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            final Image imagem = obterImagem(endereco);

            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    g2d.drawImage(imagem, x, y, x + largura, y + altura, xi, yi, xi + largura, yi + altura, null);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "Libera a memória utilizada por uma imagem que tenha sido previamente carregada",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da imagem")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void liberar_imagem(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (obterImagem(endereco) != null)
        {
            imagens[endereco] = null;
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Desenha um texto (<tipo>cadeia</tipo>) na posição especificada pelos "
            + "parâmetros <param>x</param> e <param>y</param>",
            parametros =
            {
                @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do texto no eixo horizontal, em relação ao lado esquerdo da janela"),
                @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do ponto no eixo vertical, em relação ao topo da janela"),
                @DocumentacaoParametro(nome = "texto", descricao = "o texto (<tipo>cadeia</tipo>) a ser desenhado"),
                @DocumentacaoParametro(
                        nome = "preencher_fundo",
                        descricao
                        = "define se o fundo do texto deve ser preenchido. Se <tipo>verdadeiro</tipo> preenche "
                        + "o fundo do texto com a cor atual do ambiente gráfico. Se <tipo>falso</tipo> o fundo do "
                        + "texto será transparente"
                ),
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br"),
                @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
            }
    )
    public void desenhar_texto(final Integer x, final Integer y, final String texto, final Boolean preencher_fundo) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    FontMetrics dimensoesFonte = g2d.getFontMetrics();

                    int altura = dimensoesFonte.getAscent() + dimensoesFonte.getLeading();
                    int largura = dimensoesFonte.stringWidth(texto);

                    if (preencher_fundo)
                    {
                        g2d.fillRect(x, y, largura, altura);
                    }

                    Color corAtual = g2d.getColor();

                    g2d.setColor(janela.superficieDesenho.ultimaCorTexto);
                    g2d.drawString(texto, x, y + dimensoesFonte.getAscent() - dimensoesFonte.getDescent() + dimensoesFonte.getLeading() + 1);
                    g2d.setColor(corAtual);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao
            = "Define a cor atual do ambiente gráfico. Esta cor será utilizada para desenhar e preencher "
            + "as primitivas gráficas (ponto, linha, retângulo, etc.) e, como cor de fundo ao limpar "
            + "o ambiente gráfico ou desenhar um texto",
            parametros =
            {
                @DocumentacaoParametro(nome = "cor", descricao = "a nova cor do ambiente gráfico")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_cor(final Integer cor) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    janela.superficieDesenho.ultimaCorDesenho = new Color(cor);
                    g2d.setColor(janela.superficieDesenho.ultimaCorDesenho);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    @DocumentacaoFuncao(
            descricao = "Define a fonte que será utilizada para desenhar um texto no ambiente gráfico",
            parametros =
            {
                @DocumentacaoParametro(
                        nome = "nome",
                        descricao
                        = "o nome da fonte a ser utilizada (Ex.: Arial, Times New Roman, Tahoma). Se a fonte informada "
                        + "não existir no sistema operacional do computador, será utilizada a fonte padrão"
                ),
                @DocumentacaoParametro(nome = "tamanho", descricao = "o tamanho da fonte em pontos (pt)"),
                @DocumentacaoParametro(nome = "cor", descricao = "a cor da fonte"),
                @DocumentacaoParametro(nome = "italico", descricao = "define se a fonte terá o estilo itálico"),
                @DocumentacaoParametro(nome = "negrito", descricao = "define se a fonte terá o estilo negrito"),
                @DocumentacaoParametro(nome = "sublinhado", descricao = "define se a fonte terá o estilo sublinhado")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_fonte(final String nome, final Double tamanho, final Integer cor, final Boolean italico, final Boolean negrito, final Boolean sublinhado) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            final Font fonte = criarFonte(nome, tamanho, italico, negrito, sublinhado);
            janela.superficieDesenho.atualizarDimensoesFonte(fonte);

            operacoesDesenho.add(new OperacaoDesenho()
            {
                @Override
                public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca
                {
                    janela.superficieDesenho.ultimaFonte = fonte;
                    janela.superficieDesenho.ultimaCorTexto = new Color(cor);

                    g2d.setFont(fonte);
                }
            });
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    private Font criarFonte(String nome, Double tamanho, Boolean italico, Boolean negrito, Boolean sublinhado)
    {
        Font fonte = new Font(nome, 12, Font.PLAIN);

        fonte = fonte.deriveFont(tamanho.floatValue());

        if (sublinhado)
        {
            Map<TextAttribute, Integer> atributos = new HashMap<>();
            atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

            fonte = fonte.deriveFont(atributos);
        }

        if (italico)
        {
            fonte = fonte.deriveFont(fonte.getStyle() | Font.ITALIC);
        }

        if (negrito)
        {
            fonte = fonte.deriveFont(fonte.getStyle() | Font.BOLD);
        }

        return fonte;
    }

    @DocumentacaoFuncao(
            descricao = "Obtém a largura em pixels que um texto ocupa para ser desenhado na tela",
            parametros =
            {
                @DocumentacaoParametro(nome = "texto", descricao = "o texto que será mensurado")
            },
            retorno = "a largura do texto",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Integer largura_texto(String texto) throws ErroExecucaoBiblioteca
    {
        FontMetrics dimensoesFonte = janela.superficieDesenho.getDimensoesFonte();

        return dimensoesFonte.stringWidth(texto);
    }

    @DocumentacaoFuncao(
            descricao = "Obtém a altura em pixels que um texto ocupa para ser desenhado na tela",
            parametros =
            {
                @DocumentacaoParametro(nome = "texto", descricao = "o texto que será mensurado")
            },
            retorno = "a altura do texto",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Integer altura_texto(String texto) throws ErroExecucaoBiblioteca
    {
        FontMetrics dimensoesFonte = janela.superficieDesenho.getDimensoesFonte();

        return dimensoesFonte.getAscent() + dimensoesFonte.getLeading();
    }

    @DocumentacaoFuncao(
            descricao = "Obtém o nome da fonte atual",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public String nome_fonte() throws ErroExecucaoBiblioteca
    {
        Font fonte = janela.superficieDesenho.getUltimaFonte();

        return fonte.getName();
    }

    @DocumentacaoFuncao(
            descricao = "Obtém tamanho da fonte atual",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Double tamanho_fonte() throws ErroExecucaoBiblioteca
    {
        Font fonte = janela.superficieDesenho.getUltimaFonte();
        Float tamanho = fonte.getSize2D();

        return tamanho.doubleValue();
    }

    @DocumentacaoFuncao(
            descricao = "Obtém a altura de uma imagem previamente carregada no ambiente gráfico",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço da imagem para a qual se quer obter a largura")
            },
            retorno = "a largura da imagem",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Integer largura_imagem(Integer endereco) throws ErroExecucaoBiblioteca
    {
        Image imagem = obterImagem(endereco);

        if (imagem != null)
        {
            return imagem.getWidth(null);
        }

        return 0;
    }

    @DocumentacaoFuncao(
            descricao = "Obtém a altura de uma imagem previamente carregada no ambiente gráfico",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço da imagem para a qual se quer obter a altura")
            },
            retorno = "a altura da imagem",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Integer altura_imagem(Integer endereco) throws ErroExecucaoBiblioteca
    {
        Image imagem = obterImagem(endereco);

        if (imagem != null)
        {
            return imagem.getHeight(null);
        }

        return 0;
    }

    @DocumentacaoFuncao(
            descricao = "Carrega uma fonte no ambiente gráfico a partir de um arquivo de fonte presente no sistema de arquivos",
            parametros =
            {
                @DocumentacaoParametro(nome = "caminho_fonte", descricao = "o caminho do arquivo de fonte no sistema de arquivos")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void carregar_fonte(String caminho_fonte) throws ErroExecucaoBiblioteca
    {
        File arquivo = programa.resolverCaminho(new File(caminho_fonte));

        try
        {
            Font fonte = Font.createFont(Font.TRUETYPE_FONT, arquivo);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fonte);
        }
        catch (IOException | FontFormatException excecao)
        {
            throw new ErroExecucaoBiblioteca(String.format("Não foi possível carregar a fonte '%s'", arquivo.getAbsolutePath()));
        }
    }

    @DocumentacaoFuncao(
            descricao = "Altera o ícone que é exibido na janela do ambiente gráfico. Este ícone aparece ao lado do título "
            + "da janela e na barra de tarefas do sistema operacional",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço da imagem que será usada como ícone"),
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_icone_janela(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            try
            {
                final Image imagem = obterImagem(endereco);

                SwingUtilities.invokeAndWait(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        janela.setIconImage(imagem);
                    }
                });
            }
            catch (InterruptedException | InvocationTargetException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
        }
    }

    /*
     @DocumentacaoFuncao
     (
     descricao = "Define em quantos <param>graus</param> os desenhos deverão ser rotacionados.",
        
     autores = 
     {
     @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
     }
     )
     public void definir_rotacao(Integer graus)
     {
     janela.superficieDesenho.rotacao = graus;
     }
    
     private void rotacionar(Graphics2D graficos)
     {
        
     }*/
    private Image obterImagem(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (endereco >= 0 && endereco < NUMERO_MAXIMO_IMAGENS)
        {
            Image imagem = imagens[endereco];

            if (imagem != null)
            {
                return imagem;
            }
            else
            {
                throw new ErroExecucaoBiblioteca("O endereço de memória especificado não aponta para uma imagem");
            }
        }
        else
        {
            throw new ErroExecucaoBiblioteca("O endereço de memória é inválido");
        }
    }

    private void liberarImagens()
    {
        for (int indice = 0; indice < NUMERO_MAXIMO_IMAGENS; indice++)
        {
            imagens[indice] = null;
        }
    }

    private void encerrar() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            do
            {
                try
                {
                    SwingUtilities.invokeAndWait(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            janela.setVisible(false);
                        }
                    });
                }
                catch (InterruptedException excecao)
                {
                    /*
                     * Se o usuário interromper o programa fechando a janela ou de
                     * alguma outra forma, ocorrerá um interrupção. Neste caso, 
                     * simplesmente ignoramos e continuamos tentando fechar a janela.
                     */
                }
                catch (InvocationTargetException excecao)
                {
                    throw new ErroExecucaoBiblioteca(excecao);
                }
            }
            while (janela.isVisible());

            janela = null;
            operacoesDesenho.clear();
            liberarImagens();
        }
    }

    @Override
    protected void finalizar() throws ErroExecucaoBiblioteca
    {
        encerrar();
    }

    @Override
    protected void inicializar(final Programa programa, final List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable()
            {
                @Override
                public void run()
                {
                    Graficos.this.programa = programa;

                    janela = new Janela();
                    imagens = new Image[NUMERO_MAXIMO_IMAGENS];
                    operacoesDesenho = new ArrayList<>(512);
                }
            });
        }
        catch (InterruptedException | InvocationTargetException excecao)
        {
            throw new ErroExecucaoBiblioteca(excecao);
        }
    }

    private boolean ambienteGraficoInicializado()
    {
        if (janela != null)
        {
            return janela.isVisible();
        }

        return false;
    }

    private int obterProximoIndiceLivre()
    {
        for (int indice = NUMERO_MAXIMO_IMAGENS - 1; indice >= 0; indice--)
        {
            if (imagens[indice] == null)
            {
                return indice;
            }
        }

        return -1;
    }

    @NaoExportar
    @Override
    public void instalarTeclado(KeyListener observadorTeclado) throws ErroExecucaoBiblioteca
    {
        janela.addKeyListener(observadorTeclado);
    }

    @NaoExportar
    @Override
    public void instalarMouse(MouseAdapter observadorMouse, FocusListener observadorFoco) throws ErroExecucaoBiblioteca
    {
        janela.superficieDesenho.addMouseListener(observadorMouse);
        janela.superficieDesenho.addMouseMotionListener(observadorMouse);
        janela.addFocusListener(observadorFoco);
    }

    @NaoExportar
    @Override
    public void definirCursor(Cursor cursor) throws ErroExecucaoBiblioteca
    {
        janela.setCursor(cursor);
    }

    private interface OperacaoDesenho
    {
        public void desenhar(Graphics2D g2d) throws ErroExecucaoBiblioteca;
    }

    private final class Janela extends JFrame
    {
        private int largura;
        private int altura;
        private SuperficieDesenho superficieDesenho;

        public Janela() throws HeadlessException
        {
            superficieDesenho = new SuperficieDesenho();
            superficieDesenho.setFocusable(false);

            setTitle("Sem título");
            setResizable(false);
            setBackground(Color.BLACK);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setAlwaysOnTop(false);
            setIconImage(getIconePadrao());

            JPanel painelConteudo = (JPanel) getContentPane();

            painelConteudo.setFocusable(false);
            painelConteudo.setRequestFocusEnabled(false);
            painelConteudo.setLayout(null);
            painelConteudo.add(superficieDesenho);

            definirDimensoes(LARGURA_PADRAO, ALTURA_PADRAO);
            setLocationRelativeTo(null);

            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    programa.interromper();
                }
            });
        }

        private Image getIconePadrao()
        {
            Window janelaAtiva = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();

            if (janelaAtiva != null && !janelaAtiva.getIconImages().isEmpty())
            {
                return janelaAtiva.getIconImages().get(0);
            }

            return null;
        }

        @Override
        public void setVisible(boolean visivel)
        {
            super.setVisible(visivel);

            if (visivel)
            {
                Graphics2D g2d = superficieDesenho.getGraphics2D();
                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, superficieDesenho.getWidth(), superficieDesenho.getHeight());
                g2d.dispose();
                superficieDesenho.estrategiaBuffer.show();
            }
        }

        public void definirDimensoes(int largura, int altura)
        {
            this.largura = largura;
            this.altura = altura;

            JPanel painelConteudo = (JPanel) getContentPane();

            painelConteudo.setPreferredSize(new Dimension(largura, altura));
            superficieDesenho.setBounds(0, 0, largura, altura);

            pack();

            superficieDesenho.criarBuffer();
            Graphics2D g2d = superficieDesenho.getGraphics2D();
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, largura, altura);
            g2d.dispose();
        }
    }

    private final class SuperficieDesenho extends Canvas
    {
        public BufferStrategy estrategiaBuffer;
        public Color ultimaCorDesenho = Color.BLACK;
        public Color ultimaCorTexto = Color.BLACK;
        private Font ultimaFonte = null;
        private FontMetrics dimensoesFonte;

        public SuperficieDesenho()
        {
            setIgnoreRepaint(true);
        }

        public FontMetrics getDimensoesFonte()
        {
            if (dimensoesFonte == null)
            {
                atualizarDimensoesFonte(getGraphics2D().getFont());
            }

            return dimensoesFonte;
        }

        public void atualizarDimensoesFonte(Font novaFonte)
        {
            Graphics2D g2d = getGraphics2D();
            Font fonteAtual = g2d.getFont();

            g2d.setFont(novaFonte);
            dimensoesFonte = g2d.getFontMetrics();
            g2d.setFont(fonteAtual);
        }

        public Font getUltimaFonte()
        {
            if (ultimaFonte == null)
            {
                ultimaFonte = getFont();
            }

            return ultimaFonte;
        }

        public void setUltimaFonte(Font ultimaFonte)
        {
            this.ultimaFonte = ultimaFonte;
        }

        public void criarBuffer()
        {
            createBufferStrategy(2);
            estrategiaBuffer = getBufferStrategy();
        }

        public Graphics2D getGraphics2D()
        {
            Graphics2D g2d = (Graphics2D) estrategiaBuffer.getDrawGraphics();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(ultimaCorDesenho);
            g2d.setFont(getUltimaFonte());

            return g2d;
        }
    }
}
