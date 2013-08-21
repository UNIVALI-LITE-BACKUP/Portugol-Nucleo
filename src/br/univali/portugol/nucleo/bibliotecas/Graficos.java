package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.*;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca
(
    descricao = "Esta biblioteca permite inicializar e utilizar um ambiente gráfico com " +
                "suporte ao desenho de primitivas gráficas e de imagens carregadas do " +
                "sistema de arquivos",
    
    versao = "1.0"
)
public final class Graficos extends Biblioteca implements Teclado.InstaladorTeclado, Mouse.InstaladorMouse
{
    private static final int NUMERO_MAXIMO_IMAGENS = 128;
    private static final int ALTURA_PADRAO = 480;
    private static final int LARGURA_PADRAO = 640;
    
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
    
    @DocumentacaoFuncao
    (
        descricao = "Inicia o modo gráfico e exibe uma janela com as configurações padrão (tamanho 640x480 e fundo preto). " +
                    "Se o modo gráfico já estiver iniciado, nada acontecerá",
        
        parametros = 
         {
            @DocumentacaoParametro
            (
                nome = "manter_visivel", 
                descricao = "define se a janela do ambiente gráfico deve permanecer sempre visível sobre as outras janelas (útil durante a depuração)"
            )
         },
        autores = 
        { 
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void iniciar_modo_grafico(Boolean manter_visivel) throws ErroExecucaoBiblioteca
    {
        if (!ambienteGraficoInicializado())
        {
            janela.setVisible(true);
            janela.setAlwaysOnTop(manter_visivel);
            janela.requestFocusInWindow();
        }
    }
    
    @DocumentacaoFuncao
    (
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
    
    @DocumentacaoFuncao
    (
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
    public void definir_dimensoes_janela(Integer largura, Integer altura) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            janela.definirDimensoes(largura, altura);
            janela.setLocationRelativeTo(null);
        }
        
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
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
    public void definir_titulo_janela(String titulo) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            janela.setTitle(titulo);
        }
        
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }

    
    @DocumentacaoFuncao
    (
        descricao = "limpa o desenho atual do ambiente e gráfico e preenche o fundo com a cor especificada",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cor", descricao = "a cor com a qual o fundo do ambiente gráfico será preenchido")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void limpar(Integer cor) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            SuperficieDesenho superficieDesenho = janela.superficieDesenho;
            Graphics2D buffer = superficieDesenho.getGraphics2D();
            
            buffer.setColor(new Color(cor));
            buffer.fillRect(0, 0, superficieDesenho.getWidth(), superficieDesenho.getHeight());
        }
        
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
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
        catch(IllegalArgumentException excecao)
        {
            String corErrada = "indefinido";
            
            if (excecao.getMessage().contains("Red"))
            {
                corErrada = "vermelho";
            }
            else if (excecao.getMessage().contains("Green"))
            {
                corErrada = "verde";
            }            
            else if (excecao.getMessage().contains("Blue"))
            {
                corErrada = "azul";
            }
             
            throw new ErroExecucaoBiblioteca(String.format("Erro ao criar a cor, o valor do tom de %s deve estar entre 0 e 255", corErrada));
        }
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
              "Quando uma função de desenho da biblioteca é chamada, o desenho não é realizado imediatamente na tela, "
            + "mas sim, em uma área reservada da memória. Isto é feito com o objetivo de aumentar o desempenho do "
            + "programa e minimizar outros problemas. Esta técnica é chamada de <b>Back Buffer</b> ou <b>Double Buffer</b>.<br><br>"
            
            + "A função renderizar, faz com que os desenhos existentes no <b>Back Buffer</b> sejam desenhados na tela.<br><br>"
            
            + "Esta função deve ser chamada sempre após todas as outras funções de desenho, para garantir que todos os"
            + "desenhos sejam exibidos",
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        },
        referencia = "http://en.wikipedia.org/wiki/Multiple_buffering#Double_buffering_in_computer_graphics"
    )
    public void renderizar() throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            BufferStrategy strategy = janela.superficieDesenho.estrategiaBuffer;
            // Render single frame
            do {
                // The following loop ensures that the contents of the drawing buffer
                // are consistent in case the underlying surface was recreated
                do {
                    // Get a new graphics context every time through the loop
                    // to make sure the strategy is validated
                    Graphics2D graphics = (Graphics2D) strategy.getDrawGraphics();
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    // Render to graphics
                    for (OperacaoDesenho op : operacoesDesenho)
                    {
                        op.desenhar(graphics);
                    }
                    
                    // Dispose the graphics
                    graphics.dispose();

                    // Repeat the rendering if the drawing buffer contents 
                    // were restored
                } while (strategy.contentsRestored());

                // Display the buffer
                strategy.show();

                // Repeat the rendering if the drawing buffer was lost
            } while (strategy.contentsLost());
            
            operacoesDesenho.clear();
            
            
        }
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
            
              "Desenha um retângulo com a <param>cor</param> e dimensões especificadas, na posição definida pelos "
            + "parâmetros <param>x</param> e <param>y</param>.<br><br>"
            
            + "O retângulo é posicionado na tela a partir do seu canto superior esquerdo",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do retângulo no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do retângulo no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "largura", descricao = "a largura do retângulo em pixels"),
            @DocumentacaoParametro(nome = "altura", descricao = "a altura do retângulo em pixels"),
            @DocumentacaoParametro(nome = "cor", descricao = "a cor do retângulo"),
            @DocumentacaoParametro
            (
                nome = "preencher", 
                descricao = 
            
                      "define se o retângulo será preenchido com a <param>cor</param> especificada. "
                    + "Se o valor for <tipo>verdadeiro</tipo>, o retângulo será preenchido. Se o valor for "
                    + "<tipo>falso</tipo>, somente o contorno do retângulo será desenhado"
            )
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_retangulo(final Integer x, final Integer y, final Integer largura, final Integer altura, final Integer cor, final Boolean preencher) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho() {

                @Override
                public void desenhar(Graphics2D g2d)
                {
                    g2d.setColor(new Color(cor));

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
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
            
              "Desenha um círculo com a <param>cor</param> e dimensões especificadas, na posição definida pelos "
            + "parâmetros <param>x</param> e <param>y</param>.<br><br>"
            
            + "O círculo é posicionado na tela a partir do seu centro",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do círculo no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do círculo no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "raio", descricao = "o raio do círculo em pixels"),
            @DocumentacaoParametro(nome = "cor", descricao = "a cor do círculo"),
            @DocumentacaoParametro
            (
                nome = "preencher", 
                descricao = 
            
                      "define se o círculo será preenchido com a <param>cor</param> especificada. "
                    + "Se o valor for <tipo>verdadeiro</tipo>, o círculo será preenchido. Se o valor for "
                    + "<tipo>falso</tipo>, somente o contorno do círculo será desenhado"
            )
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_circulo(final Integer x, final Integer y, final Integer raio, final Integer cor, final Boolean preencher) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            operacoesDesenho.add(new OperacaoDesenho() {

                @Override
                public void desenhar(Graphics2D g2d)
                {
                    g2d.setColor(new Color(cor));

                    if (preencher)
                    {
                        g2d.fillOval(x, y, raio, raio);
                    }
                    else
                    {
                        g2d.drawOval(x, y, raio, raio);
                    }
                }
            });
        }
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
            
              "Desenha um ponto com a <param>cor</param> especificada, na posição definida pelos "
            + "parâmetros <param>x</param> e <param>y</param>."
            
            + "O ponto desenhado ocupa um único pixel na tela",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x", descricao = "a coordenada (distância) do ponto no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y", descricao = "a coordenada (distância) do ponto no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "cor", descricao = "a cor do ponto")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_ponto(final Integer x, final Integer y, final Integer cor) throws ErroExecucaoBiblioteca
    {
        if (ambienteGraficoInicializado())
        {
            
            operacoesDesenho.add(new OperacaoDesenho() {

                @Override
                public void desenhar(Graphics2D g2d)
                {
                    g2d.setColor(new Color(cor));
                    g2d.drawLine(x, y, x, y);
                }
            });
        }
        else throw new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
            
              "Desenha uma linha com a <param>cor</param> especificada, de um ponto 'A' (definido pelos parâmetros "
            + "<param>x1</param> e <param>y1</param>) até um ponto 'B' (definido pelos parâmetros "
            + "<param>x2</param> e <param>y2</param>)",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x1", descricao = "a coordenada (distância) do ponto 'A' no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y1", descricao = "a coordenada (distância) do ponto 'A' no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "x2", descricao = "a coordenada (distância) do ponto 'B' no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y2", descricao = "a coordenada (distância) do ponto 'B' no eixo vertical, em relação ao topo da janela"),            
            @DocumentacaoParametro(nome = "cor", descricao = "a cor da linha")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_linha(final Integer x1, final Integer y1, final Integer x2, final Integer y2, final Integer cor) throws ErroExecucaoBiblioteca
    {
        operacoesDesenho.add(new OperacaoDesenho() {

            @Override
            public void desenhar(Graphics2D g2d)
            {   
                g2d.setColor(new Color(cor));
                g2d.drawLine(x1, y1, x2, y2);
            }
        });
    }    
    
    
    @DocumentacaoFuncao
    (
        descricao = 
              "Carrega uma imagem na memória para ser utilizada mais tarde. Os formatos de imagem suportados "
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
        File arquivo = new File(caminho);
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
    
    
    @DocumentacaoFuncao
    (
        descricao = 
              "Desenha uma imagem previamente carregada, na posição especificada pelos "
            + "parâmetros <param>x</param> e <param>y</param>",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) da imagem no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) da imagem no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da imagem a ser desenhada")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_imagem(final Integer x, final Integer y, Integer endereco) throws ErroExecucaoBiblioteca
    {
        final Image imagem = obterImagem(endereco);
        operacoesDesenho.add(new OperacaoDesenho() {

            @Override
            public void desenhar(Graphics2D g2d)
            {
                g2d.drawImage(imagem, x, y, null);
            }
        });
    }
    
    @DocumentacaoFuncao
    (
        descricao = 
              "Desenha uma porção de uma imagem previamente carregada, na posição especificada pelos "
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
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
                , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_porcao_imagem(final Integer x, final Integer y, final Integer xi, final Integer yi, final Integer largura, final Integer altura, Integer endereco) throws ErroExecucaoBiblioteca
    {
        final Image imagem = obterImagem(endereco);
        operacoesDesenho.add(new OperacaoDesenho() {

            @Override
            public void desenhar(Graphics2D g2d)
            {
                g2d.drawImage(imagem, x, y, x + largura, y + altura, xi, yi, xi + largura, yi + altura, null);
            }
        });        
        
    }    
    
    @DocumentacaoFuncao
    (
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

    @DocumentacaoFuncao
    (
        descricao = 
              
              "Desenha um texto (<tipo>cadeia</tipo>) na posição especificada pelos "
            + "parâmetros <param>x</param> e <param>y</param>",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "x", descricao = "a posição (distância) do texto no eixo horizontal, em relação ao lado esquerdo da janela"),
            @DocumentacaoParametro(nome = "y", descricao = "a posição (distância) do ponto no eixo vertical, em relação ao topo da janela"),
            @DocumentacaoParametro(nome = "texto", descricao = "o texto (<tipo>cadeia</tipo>) a ser desenhado"),
            @DocumentacaoParametro(nome = "tamanho", descricao = "o tamanho da fonte utilizada para desenhar o texto"),
            @DocumentacaoParametro(nome = "cor_fonte", descricao = "a cor da fonte utilizada para desenhar o texto"),
            @DocumentacaoParametro(nome = "cor_fundo", descricao = "a cor de fundo do texto")
        },
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
                , @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br")
        }
    )
    public void desenhar_texto(final Integer x, final Integer y, final String texto, final Integer tamanho, final Integer cor_fonte, final Integer cor_fundo) throws ErroExecucaoBiblioteca
    {
        operacoesDesenho.add(new OperacaoDesenho() {

            @Override
            public void desenhar(Graphics2D g2d)
            {
                Font fonteAtual = g2d.getFont();

                g2d.setFont(fonteAtual.deriveFont(Font.PLAIN, tamanho));

                FontMetrics dimensoesFonte = g2d.getFontMetrics();

                int altura = dimensoesFonte.getAscent() + dimensoesFonte.getLeading();
                int largura = dimensoesFonte.stringWidth(texto);

                g2d.setColor(new Color(cor_fundo));
                g2d.fillRect(x, y, largura, altura);
                g2d.setColor(new Color(cor_fonte));
                g2d.drawString(texto, x, y + dimensoesFonte.getAscent() - dimensoesFonte.getDescent() + dimensoesFonte.getLeading() + 1);
            }
        });
        
    }
    
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
    
    private void encerrar()
    {
        if (ambienteGraficoInicializado())
        {
            janela.setVisible(false);
            janela = null;
            operacoesDesenho.clear();
            liberarImagens();
        }
    }
    
    /**
     * Fecha a janela, se estiver visível e libera os recursos alocados
     */
    @Override
    protected void finalizar()
    {
        encerrar();
    }

    @Override
    protected void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas)
    {
        janela = new Janela();
        imagens = new Image[NUMERO_MAXIMO_IMAGENS];
        operacoesDesenho = new ArrayList<>(512);
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
    public void instalarMouse(MouseAdapter observadorMouse) throws ErroExecucaoBiblioteca
    {
        janela.superficieDesenho.addMouseListener(observadorMouse);
        janela.superficieDesenho.addMouseMotionListener(observadorMouse);
    }

    @NaoExportar
    @Override
    public void definirCursor(Cursor cursor) throws ErroExecucaoBiblioteca
    {
        janela.setCursor(cursor);
    }

    private interface OperacaoDesenho 
    {
        public void desenhar(Graphics2D g2d);
    }
    
    private final class Janela extends JFrame
    {
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
            
            JPanel painelConteudo = (JPanel) getContentPane();
        
            painelConteudo.setFocusable(false);
            painelConteudo.setRequestFocusEnabled(false);
            painelConteudo.setLayout(null);
            painelConteudo.add(superficieDesenho);
            
            definirDimensoes(LARGURA_PADRAO, ALTURA_PADRAO);
            setLocationRelativeTo(null);
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
        
        public SuperficieDesenho()
        {
            setIgnoreRepaint(true);
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
            return g2d;
        }
       
    }
}
