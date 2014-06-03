package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca
(
    descricao = "Esta biblioteca contém funções que permitem reproduzir sons dentro de um programa. No momento, " +
                "somente o formato MP3 é suportado.",
       
    versao = "1.0"
)
public final class Sons extends Biblioteca
{
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();
    
    private static final int NUMERO_MAXIMO_SONS = 128;
    
    private static final int NUMERO_MAXIMO_REPRODUCOES = 256;
    
    private Som[] sons;
    
    private ReprodutorSom[] reprodutores;

    @DocumentacaoFuncao
    (
        descricao = "Carrega um som na memória para ser reproduzido mais tarde",
            
        parametros = 
        {
            @DocumentacaoParametro(nome = "caminho_som", descricao = "o caminho para o arquivo de som no sistema de arquivos")                
        },
        
        retorno = "o endereço de memória no qual o som foi carregado",
            
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Integer carregar_som(String caminho_som) throws ErroExecucaoBiblioteca
    {
        int indice = obterProximoIndiceSomLivre();

        sons[indice] = new Som(new File(caminho_som), indice);

        return indice;
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Libera a memória utilizada por um som que tenha sido previamente carregado. Se o som estiver sendo reproduzido, " +
                    "todas as reproduções deste som serão interrompidas",
       
        parametros = 
        {
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do som")
        },
        
        autores = 
        {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }            
    )
    public void liberar_som(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (obterSom(endereco) != null)
        {
            for (int indice = NUMERO_MAXIMO_REPRODUCOES - 1; indice >= 0; indice--)
            {
                ReprodutorSom reprodutor = reprodutores[indice];
                
                if (reprodutor != null && reprodutor.getSom().getEndereco() == endereco)
                {
                    reprodutor.interromper();
                    reprodutores[indice] = null;
                }
            }
            
            sons[endereco] = null;
        }
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Reproduz um som previamente carregado na memória. O som é reproduzido de forma assíncrona, ou seja, " +
                    "o som ficará reproduzindo no fundo, enquanto o programa executa as próximas instruções normalmente. " +
                    "Um mesmo som pode ser reproduzido várias vezes e pode se sobrepor a outros sons.",
            
        parametros = 
        {
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do som a ser reproduzido"),
            @DocumentacaoParametro(nome = "repetir", descricao = "determina se o som deve ficar repetindo até ser manualmente interrompido")
        },
        
        retorno = 
                "o endereço de memória da reprodução de som. Este endereço é utilizado quando se deseja interromper " +
                "esta reprodução de som especificamente.",
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Integer reproduzir_som(Integer endereco, Boolean repetir) throws ErroExecucaoBiblioteca
    {
        Som som = obterSom(endereco);
        ReprodutorSom reprodutor = new ReprodutorMp3(som);
        int indice = obterProximoIndiceReprodutorLivre();
        TarefaReproducaoSom tarefaReproducao = new TarefaReproducaoSom(reprodutor, repetir, indice);
        
        threadPool.submit(tarefaReproducao);
        reprodutores[indice] = reprodutor;
        
        return indice;
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Interrompe uma reprodução específica de um som que está sendo executada no momento",
            
        parametros = 
        {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da reprodução que se quer interromper")
        },
        
        autores = 
        {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void interromper_som(Integer endereco) throws ErroExecucaoBiblioteca
    {
        threadPool.submit(new TarefaInterrupcaoSom(endereco));
    }

    @Override
    protected void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        sons = new Som[NUMERO_MAXIMO_SONS];
        reprodutores = new ReprodutorSom[NUMERO_MAXIMO_REPRODUCOES];
    }

    @Override
    protected void finalizar() throws ErroExecucaoBiblioteca
    {
        for (int endereco = NUMERO_MAXIMO_SONS - 1; endereco >= 0; endereco--)
        {
            Som som = sons[endereco];
            
            if (som != null)
            {
                for (int indice = NUMERO_MAXIMO_REPRODUCOES - 1; indice >= 0; indice--)
                {
                    ReprodutorSom reprodutor = reprodutores[indice];

                    if (reprodutor != null && reprodutor.getSom().getEndereco() == endereco)
                    {
                        reprodutor.interromper();
                        reprodutores[indice] = null;
                    }
                }
            
                sons[endereco] = null;
            }
        }
    }
    
    private Som obterSom(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (endereco >= 0 && endereco < NUMERO_MAXIMO_SONS)
        {
            Som som = sons[endereco];
            
            if (som != null)
            {
                return som;
            }
        }
        
        throw new ErroExecucaoBiblioteca("O endereço de memória especificado não aponta para um som");
    }
    
    private int obterProximoIndiceSomLivre() throws ErroExecucaoBiblioteca
    {
        for (int indice = NUMERO_MAXIMO_SONS - 1; indice >= 0; indice--)
        {
            if (sons[indice] == null)
            {
                return indice;
            }
        }
        
        throw new ErroExecucaoBiblioteca("O número máximo de sons que podem ser abertos ao mesmo tempo foi atingido");
    }
    
    private int obterProximoIndiceReprodutorLivre() throws ErroExecucaoBiblioteca
    {
        for (int indice = NUMERO_MAXIMO_REPRODUCOES - 1; indice >= 0; indice--)
        {
            if (reprodutores[indice] == null)
            {
                return indice;
            }
        }
        
        throw new ErroExecucaoBiblioteca("O número máximo de reproduções foi atingido");
    }
    
    private ReprodutorSom obterReprodutor(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (endereco >= 0 && endereco < NUMERO_MAXIMO_REPRODUCOES)
        {
            return reprodutores[endereco];
        }
        
        throw new ErroExecucaoBiblioteca("O endereço de memória especificado não aponta para uma reprodução de som");
    } 
    
    private final class TarefaReproducaoSom implements Runnable
    {
        private final ReprodutorSom reprodutor;
        private final boolean repetir;
        private final int indice;

        public TarefaReproducaoSom(ReprodutorSom reprodutor, boolean repetir, int indice)
        {
            this.reprodutor = reprodutor;
            this.repetir = repetir;
            this.indice = indice;
        }
        
        @Override
        public void run()
        {
            try
            {
                reprodutor.reproduzir(repetir);
                reprodutores[indice] = null;
            }
            catch (ErroExecucaoBiblioteca excecao)
            {
                throw new RuntimeException(excecao);
            }
        }
    }
    
    private void printSounds()
    {
        System.out.print("Reproduções: [ ");
        
        for (int i = 0; i < NUMERO_MAXIMO_REPRODUCOES; i++)
        {
            if (reprodutores[i] == null)
            {
                System.out.print("0");
            }
            else
            {
                System.out.print("1");
            }
            
            if (i == NUMERO_MAXIMO_REPRODUCOES - 1)
            {
                System.out.println(" ]");
            }
            else
            {
                System.out.print(", ");
            }
        }        
        
    }
    
    private final class TarefaInterrupcaoSom implements Runnable
    {
        private final int endereco;

        public TarefaInterrupcaoSom(int endereco)
        {
            this.endereco = endereco;
        }
        
        @Override
        public void run()
        {
            try
            {
                ReprodutorSom reprodutor = obterReprodutor(endereco);
                
                if (reprodutor != null)
                {
                    reprodutor.interromper();
                    reprodutores[endereco] = null;
                }
            }
            catch (ErroExecucaoBiblioteca excecao)
            {
                throw new RuntimeException(excecao);
            }
        }        
    }
    
    private final class Som
    {
        private final byte[] dados;
        private final File arquivo;
        private final int endereco;

        public Som(File arquivo, int endereco) throws ErroExecucaoBiblioteca
        {
            this.dados = carregarDados(arquivo);
            this.arquivo = arquivo;
            this.endereco = endereco;
        }

        public byte[] getDados()
        {
            return dados;
        }

        public File getArquivo()
        {
            return arquivo;
        }

        public int getEndereco()
        {
            return endereco;
        }
        
        private byte[] carregarDados(File arquivo) throws ErroExecucaoBiblioteca
        {
            try
            {
                int bytesLidos;
                int tamanhoBuffer = 1048576; // 1 MB

                byte[] buffer = new byte[tamanhoBuffer];

                FileInputStream fluxoArquivo = new FileInputStream(arquivo);
                ByteArrayOutputStream fluxoSaida = new ByteArrayOutputStream(buffer.length);

                while ((bytesLidos = fluxoArquivo.read(buffer, 0, buffer.length)) > 0)
                {
                    fluxoSaida.write(buffer, 0, bytesLidos);
                }

                fluxoSaida.flush();

                return fluxoSaida.toByteArray();
            }
            catch (IOException excecao)
            {
                throw new ErroExecucaoBiblioteca(String.format("Erro ao carregar o som '%s'", arquivo.getAbsolutePath()));
            }
        }
    }

    private interface ReprodutorSom
    {
        public Som getSom();
        
        public void reproduzir(boolean repetir) throws ErroExecucaoBiblioteca;
        
        public void interromper() throws ErroExecucaoBiblioteca;
    }
    
    private final class ReprodutorMp3 implements ReprodutorSom
    {
        private final Som som;        
        private Player reprodutor;
        private boolean interrompido;
                
        public ReprodutorMp3(Som som)
        {
            this.interrompido = false;
            this.som = som;
        }
        
        @Override
        public void reproduzir(boolean repetir) throws ErroExecucaoBiblioteca
        {
            try
            {
                do
                {
                    reprodutor = new Player(new BufferedInputStream(new ByteArrayInputStream(som.getDados())));
                    reprodutor.play();
                    reprodutor.close();
                    reprodutor = null;
                }
                while (repetir && !interrompido);
            }
            catch (JavaLayerException excecao)
            {
                throw new ErroExecucaoBiblioteca(String.format("Não foi possível reproduzir o som '%s'", som.getArquivo().getAbsolutePath()));
            }
        }
        
        @Override
        public void interromper() throws ErroExecucaoBiblioteca
        {
            interrompido = true;
            
            if (reprodutor != null)
            {
                reprodutor.close();
            }
        }

        @Override
        public Som getSom()
        {
            return som;
        }
    }
}
