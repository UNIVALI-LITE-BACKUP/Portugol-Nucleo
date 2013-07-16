package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.awt.Color;
import javax.swing.JFrame;

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
public final class Graficos extends Biblioteca
{
    private static final int ALTURA_PADRAO = 480;
    private static final int LARGURA_PADRAO = 640;
    
    private static ErroExecucaoBiblioteca erroAmbienteGraficoNaoInicializado = new ErroExecucaoBiblioteca("O modo gráfico ainda não foi inicializado");
    
    private JFrame janela;    
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'preto'")
    public final Integer COR_PRETO = Color.BLACK.getRGB();
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'branca'")
    public final Integer COR_BRANCO = Color.WHITE.getRGB();
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'azul'")
    public final Integer COR_AZUL = Color.BLUE.getRGB();
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'vermelho'")
    public final Integer COR_VERMELHO = Color.RED.getRGB();
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'verde'")
    public final Integer COR_VERDE = Color.GREEN.getRGB();
    
    
    @DocumentacaoConstante(descricao = "constante que representa a cor 'amarelo'")
    public final Integer COR_AMARELO = Color.YELLOW.getRGB();
    

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
    public void iniciar_modo_grafico(Boolean manter_visivel) throws ErroExecucao
    {
        if (!ambienteGraficoInicializado())
        {
            janela = new JFrame("Sem título");
            janela.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
            janela.setLocationRelativeTo(null);
            janela.setResizable(false);
            janela.setBackground(Color.BLACK);
            janela.getContentPane().setBackground(Color.BLACK);
            janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            janela.setAlwaysOnTop(manter_visivel);
            janela.setVisible(true);
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
    public void encerrar_modo_grafico() throws ErroExecucao
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
    public void definir_dimensoes_janela(Integer largura, Integer altura) throws ErroExecucao
    {
        if (ambienteGraficoInicializado())
        {
            janela.setSize(largura, altura);
            janela.setLocationRelativeTo(null);
        }
        
        else throw erroAmbienteGraficoNaoInicializado;
    }
    
    @DocumentacaoFuncao
    (
        descricao = "define o texto da janela do ambiente gráfico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "titulo", descricao = "a nova título da janela")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void definir_titulo_janela(String titulo) throws ErroExecucao
    {
        if (ambienteGraficoInicializado())
        {
            janela.setTitle(titulo);
        }
        
        else throw erroAmbienteGraficoNaoInicializado;
    }
    
    @DocumentacaoFuncao
    (
        descricao = "limpa o desenho atual do ambiente e gráfico e preenche com a cor preto",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void limpar() throws ErroExecucao
    {
        limpar_cor(COR_PRETO);
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "limpa o desenho atual do ambiente e gráfico e preenche com a cor especificada",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cor", descricao = "a cor com a qual o fundo do ambiente gráfico será preenchido")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void limpar_cor(Integer cor) throws ErroExecucao
    {
        if (ambienteGraficoInicializado())
        {
            janela.getContentPane().setBackground(new Color(cor));
        }
        
        else throw erroAmbienteGraficoNaoInicializado;
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
    public Integer criar_cor(Integer vermelho, Integer verde, Integer azul) throws ErroExecucao
    {
        try
        {
            return new Color(vermelho, verde, azul).getRGB();
        }
        catch(IllegalArgumentException excecao)
        {
            String corErrada = "indefinido";
            
            if (excecao.getMessage().contains("red"))
            {
                corErrada = "vermelho";
            }
            else if (excecao.getMessage().contains("green"))
            {
                corErrada = "verde";
            }            
            else if (excecao.getMessage().contains("azul"))
            {
                corErrada = "azul";
            }
             
            throw new ErroExecucaoBiblioteca(String.format("Erro ao criar a cor, o valor tom de %s deve estar 0 e 255", corErrada));
        }
    }    
    
    
    private void encerrar()
    {
        if (ambienteGraficoInicializado())
        {
            if (janela.isVisible())
            {
                janela.setVisible(false);
                janela.dispose();
            }

            janela = null;
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

    private boolean ambienteGraficoInicializado()
    {
        return janela != null;
    }
}
