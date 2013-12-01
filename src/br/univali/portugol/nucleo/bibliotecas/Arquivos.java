package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca
(
    descricao = "Esta biblioteca permite ler e escrever arquivos locais ou em um servidor remoto",
    versao = "1.0"
)
public final class Arquivos extends Biblioteca
{
    private static enum ModoAcesso { LEITURA, ESCRITA }
    
    private static final int NUMERO_MAXIMO_ARQUIVOS = 10;
    
    private Arquivo[] arquivos;
    
    @DocumentacaoConstante(descricao = "indica à biblioteca que o arquivo deve ser aberto apenas para leitura")
    public static final Integer MODO_LEITURA = ModoAcesso.LEITURA.ordinal();
    
    @DocumentacaoConstante(descricao = "indica à biblioteca que o arquivo deve ser aberto apenas para escrita")
    public static final Integer MODO_ESCRITA = ModoAcesso.ESCRITA.ordinal();
    
    @DocumentacaoFuncao
    (
        descricao = "Abre um arquivo para leitura ou escrita. No modo leitura, caso o arquivo informado não exista, será gerado " +
                    "um erro. No modo escrita, caso o arquivo informado não exista, ele tentará ser criado, se a criação do arquivo " +
                    "falhar, então será gerado um erro.<br><br>" +
            
                    "<b>IMPORTANTE:</b> ao abrir o arquivo no modo de escrita, o conteúdo do arquivo é apagado para que o novo conteúdo " +
                    "seja escrito. Caso seja necessário manter o conteúdo atual do arquivo, deve-se armazená-lo em uma variável e depois " +
                    "escrevê-lo novamente no arquivo.",            
            
        parametros = 
        {
            @DocumentacaoParametro(nome = "caminho_arquivo", descricao = "o nome do arquivo que se quer abrir"),
                
            @DocumentacaoParametro(nome = "modo_acesso", descricao = "determina se o arquivo será aberto para leitura ou para escrita")
        },
        
        retorno = "o endereço de memória onde o arquivo foi carregado",
        
        autores =
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Integer abrir_arquivo(String caminho_arquivo, Integer modo_acesso) throws ErroExecucaoBiblioteca
    {
        File arquivo = new File(caminho_arquivo);
        
        if (!arquivoAberto(arquivo))
        {
            if (modo_acesso >= 0 && modo_acesso <= ModoAcesso.values().length)
            {
                int indice = obterProximoIndiceLivre();
            
                arquivos[indice] = new Arquivo(arquivo);
                arquivos[indice].abrir(ModoAcesso.values()[modo_acesso]);
                
                return indice;
            }
            
            throw new ErroExecucaoBiblioteca(String.format("Modo de acesso inválido: %d", modo_acesso));
        }
                
        throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' já está aberto", arquivo.getAbsolutePath()));
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Fecha um arquivo aberto anteriormente", 
            
        parametros = 
        {
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do arquivo")
        },
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void fechar_arquivo(Integer endereco) throws ErroExecucaoBiblioteca
    {
        Arquivo arquivo = obterArquivo(endereco);
        arquivo.fechar();
        
        arquivos[endereco] = null;
    }
    
        @DocumentacaoFuncao
    (
        descricao = "Verifica se o arquivo chegou ao fim, isto é, se todas as linhas já foram lidas. Esta função só é executada se o arquivo " +
                    "estiver aberto em modo de leitura. Se o arquivo estiver em modo de escrita, será gerado um erro.",

        parametros = 
        {
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do arquivo")
        },
        
        retorno = "<tipo>verdadeiro</tipo> se o arquivo tiver chegado ao fim. Caso contrário retorna <tipo>falso</tipo>",
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Boolean fim_arquivo(Integer endereco) throws ErroExecucaoBiblioteca
    {
        return obterArquivo(endereco).fim();
    }
    
    
    @DocumentacaoFuncao
    (
        descricao = "Lê a próxima linha do arquivo. Esta função só é executada se o arquivo estiver aberto em modo de "+
                    "leitura. Se o arquivo estiver em modo de escrita, será gerado um erro.",

        parametros = 
        {
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do arquivo")
        },
        
        retorno = "<tipo>verdadeiro</tipo> se o arquivo tiver chegado ao fim. Caso cotrário retorna <tipo>falso</tipo>",
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public String ler_linha(Integer endereco) throws ErroExecucaoBiblioteca
    {
        return obterArquivo(endereco).ler();
    }
    
    @DocumentacaoFuncao
    (
       descricao = "Escreve uma linha no arquivo. Esta função só é executada se o arquivo estiver aberto em modo de " +
                    "escrita. Se o arquivo estiver em modo de leitura, será gerado um erro.",

        parametros = 
        {
            @DocumentacaoParametro(nome = "linha", descricao = "a linha a ser escrita no arquivo"),
            @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do arquivo")
        },
        
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public void escrever_linha(String linha, Integer endereco) throws ErroExecucaoBiblioteca
    {
        obterArquivo(endereco).escrever(linha);
    }
    
    @Override
    protected void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        arquivos = new Arquivo[NUMERO_MAXIMO_ARQUIVOS];
    }    

    @Override
    protected void finalizar() throws ErroExecucaoBiblioteca
    {
        for (int indice = NUMERO_MAXIMO_ARQUIVOS - 1; indice >= 0; indice--)
        {
            if (arquivos[indice] != null)
            {
                arquivos[indice].fechar();
                arquivos[indice] = null;
            }
        }
    }
    
    private Arquivo obterArquivo(Integer endereco) throws ErroExecucaoBiblioteca
    {
        if (endereco >= 0 && endereco < NUMERO_MAXIMO_ARQUIVOS)
        {
            Arquivo arquivo = arquivos[endereco];
            
            if (arquivo != null)
            {
                return arquivo;
            }
        }
        
        throw new ErroExecucaoBiblioteca("O endereço de memória especificado não aponta para um arquivo");
    }
    
    private boolean arquivoAberto(File arq)
    {
        String caminho = arq.getAbsolutePath();
        
        for (int indice = NUMERO_MAXIMO_ARQUIVOS - 1; indice >= 0; indice--)
        {
            Arquivo arquivo = arquivos[indice];
            
            if (arquivo != null && arquivo.getCaminho().equals(caminho))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private int obterProximoIndiceLivre() throws ErroExecucaoBiblioteca
    {
        for (int indice = NUMERO_MAXIMO_ARQUIVOS - 1; indice >= 0; indice--)
        {
            if (arquivos[indice] == null)
            {
                return indice;
            }
        }
        
        throw new ErroExecucaoBiblioteca("O número máximo de arquivos que podem ser abertos ao mesmo tempo foi atingido");
    }
            
    private final class Arquivo
    {
        private static final String charset = "ISO-8859-1";
        private final File arquivo;
        
        private ModoAcesso modoAcesso;
        private boolean fim = false;
        
        private BufferedReader leitor;
        private BufferedWriter escritor;
        
        public Arquivo(File arquivo)
        {
            this.arquivo = arquivo;
        }
        
        public void abrir(ModoAcesso modoAcesso) throws ErroExecucaoBiblioteca
        {
            this.modoAcesso = modoAcesso;
            
            if (modoAcesso == ModoAcesso.LEITURA)
            {
                abrirParaLeitura();
            }
            else if (modoAcesso == ModoAcesso.ESCRITA)
            {
                abrirParaEscrita();
            }
        }
        
        private void abrirParaLeitura() throws ErroExecucaoBiblioteca
        {
            try
            {
                leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), charset));
            }
            catch (FileNotFoundException | UnsupportedEncodingException excecao)
            {
                throw new ErroExecucaoBiblioteca(String.format("Não foi possível abrir o arquivo '%s' para leitura", arquivo.getAbsolutePath()));
            }
        }
        
        private void abrirParaEscrita() throws ErroExecucaoBiblioteca
        {
            try
            {
                escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), charset));
            }
            catch (IOException excecao)
            {
                throw new ErroExecucaoBiblioteca(String.format("Não foi possível abrir o arquivo '%s' para escrita", arquivo.getAbsolutePath()));
            }
        }

        public String ler() throws ErroExecucaoBiblioteca
        {
            if (modoAcesso == ModoAcesso.LEITURA)
            {
                try
                {
                    String linha = leitor.readLine();

                    if (linha == null)
                    {
                        linha = "";
                        fim = true;
                    }

                    return linha;
                }
                catch (IOException excecao)
                {
                    throw new ErroExecucaoBiblioteca(String.format("Não foi possível ler a próxima linha do arquivo '%s'", arquivo.getAbsolutePath()));
                }
            }
            else
            {            
                throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' está aberto em modo de escrita", arquivo.getAbsolutePath()));
            }
        }

        public void escrever(String linha) throws ErroExecucaoBiblioteca
        {
            if (modoAcesso == ModoAcesso.ESCRITA)
            {
                try
                {
                    escritor.write(linha.replace("\n", "").replace("\r", ""));
                    escritor.write("\n");
                    escritor.flush();
                }
                catch (IOException excecao)
                {
                    throw new ErroExecucaoBiblioteca(String.format("Não foi possível escrever no arquivo '%s'", arquivo.getAbsolutePath()));
                }
            }
            else
            {
                throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' está aberto em modo de leitura", arquivo.getAbsolutePath()));
            }
        }

        public boolean fim() throws ErroExecucaoBiblioteca
        {
            if (modoAcesso == ModoAcesso.LEITURA)
            {
                return fim;
            }
            else
            {
                throw new ErroExecucaoBiblioteca(String.format("O arquivo '%s' está aberto em modo de escrita", arquivo.getAbsolutePath()));
            }
        }

        public void fechar() throws ErroExecucaoBiblioteca
        {
            try
            {
                if (modoAcesso == ModoAcesso.ESCRITA)
                {
                    escritor.flush();
                    escritor.close();
                }
                else if (modoAcesso == ModoAcesso.LEITURA)
                {
                    leitor.close();
                }
            }
            catch (IOException | NullPointerException excecao)
            {
                
            }
        }
        
        public String getCaminho()
        {
            return arquivo.getAbsolutePath();
        }
    }
}
