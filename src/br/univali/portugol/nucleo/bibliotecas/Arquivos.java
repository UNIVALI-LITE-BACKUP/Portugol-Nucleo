package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ReferenciaVariavel;
import br.univali.portugol.nucleo.bibliotecas.base.ReferenciaVetor;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca(
        descricao = "Esta biblioteca permite ler e escrever arquivos",
        versao = "1.3"
)
public final class Arquivos extends Biblioteca
{
    private static enum ModoAcesso
    {
        LEITURA, ESCRITA
    }

    private static final int NUMERO_MAXIMO_ARQUIVOS = 10;

    private Programa programa;
    private Arquivo[] arquivos;
    private DialogoSelecaoArquivo dialogoSelecao;
    private FiltroExtensao filtroTodosArquivos;

    @DocumentacaoConstante(descricao = "indica à biblioteca que o arquivo deve ser aberto apenas para leitura")
    public static final Integer MODO_LEITURA = ModoAcesso.LEITURA.ordinal();

    @DocumentacaoConstante(descricao = "indica à biblioteca que o arquivo deve ser aberto apenas para escrita")
    public static final Integer MODO_ESCRITA = ModoAcesso.ESCRITA.ordinal();

    @DocumentacaoFuncao(
            descricao = "Abre um arquivo para leitura ou escrita. No modo leitura, caso o arquivo informado não exista, será gerado "
            + "um erro. No modo escrita, caso o arquivo informado não exista, ele tentará ser criado, se a criação do arquivo "
            + "falhar, então será gerado um erro.<br><br>"
            + "<b>IMPORTANTE:</b> ao abrir o arquivo no modo de escrita, o conteúdo do arquivo é apagado para que o novo conteúdo "
            + "seja escrito. Caso seja necessário manter o conteúdo atual do arquivo, deve-se armazená-lo em uma variável e depois "
            + "escrevê-lo novamente no arquivo.",
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
        File arquivo = programa.resolverCaminho(new File(caminho_arquivo));

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

    @DocumentacaoFuncao(
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

    @DocumentacaoFuncao(
            descricao = "Verifica se o arquivo chegou ao fim, isto é, se todas as linhas já foram lidas. Esta função só é executada se o arquivo "
            + "estiver aberto em modo de leitura. Se o arquivo estiver em modo de escrita, será gerado um erro.",
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

    @DocumentacaoFuncao(
            descricao = "Lê a próxima linha do arquivo. Esta função só é executada se o arquivo estiver aberto em modo de "
            + "leitura. Se o arquivo estiver em modo de escrita, será gerado um erro.",
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

    @DocumentacaoFuncao(
            descricao = "Escreve uma linha no arquivo. Esta função só é executada se o arquivo estiver aberto em modo de "
            + "escrita. Se o arquivo estiver em modo de leitura, será gerado um erro.",
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

    @DocumentacaoFuncao(
            descricao = "Verifica se um determinado arquivo existe no sistema de arquivos",
            parametros =
            {
                @DocumentacaoParametro(nome = "caminho_arquivo", descricao = "o caminho do arquivo que se quer verificar")
            },
            retorno = "<tipo>verdadeiro</tipo> se o arquivo existir",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Boolean arquivo_existe(String caminho_arquivo) throws ErroExecucaoBiblioteca
    {
        File arquivo = programa.resolverCaminho(new File(caminho_arquivo));

        return arquivo.isFile() && arquivo.exists();
    }

    @DocumentacaoFuncao(
            descricao = "Remove um arquivo do sistema de arquivos",
            parametros =
            {
                @DocumentacaoParametro(nome = "caminho_arquivo", descricao = "o caminho do arquivo que ser quer apagar")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void apagar_arquivo(String caminho_arquivo) throws ErroExecucaoBiblioteca
    {
        File arquivo = programa.resolverCaminho(new File(caminho_arquivo));

        try
        {
            if (arquivo.isFile())
            {
                Files.delete(arquivo.toPath());
            }
            else
            {
                throw new ErroExecucaoBiblioteca(String.format("Não foi possível apagar o arquivo '%s'", arquivo.getAbsolutePath()));
            }
        }
        catch (IOException excecao)
        {
            throw new ErroExecucaoBiblioteca(String.format("Não foi possível apagar o arquivo '%s'", arquivo.getAbsolutePath()));
        }
    }

    @Override
    protected void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        this.programa = programa;
        this.arquivos = new Arquivo[NUMERO_MAXIMO_ARQUIVOS];
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

    @DocumentacaoFuncao(descricao = "Abre um janela que permite ao usuário navegar nos diretórios do computador e selecionar um arquivo",
            parametros =
            {
                @DocumentacaoParametro(nome = "formatos_suportados",
                        descricao = "Define os formatos de arquivos que poderão ser selecionados. Um formato de "
                        + "arquivo é formado por uma descrição e uma lista de extensões válidas. A descrição deve "
                        + "estar separada da lista de extensões pelo caracter '|' e cada extensão deverá estar "
                        + "separada da outra pelo caracter ','. Ex.: 'Arquivos de texto|txt', 'Arquivos de imagem|png,jpg,jpeg,bmp'"
                ),
                @DocumentacaoParametro(nome = "aceitar_todos_arquivos",
                        descricao = "Quando verdadeiro, inclui automaticamente um formato que permite selecionar "
                        + "qualquer arquivo. Este formato também será incluído se nenhum outro formato for informado "
                        + "no parâmetro 'formatos_suportados'"
                ),
                @DocumentacaoParametro(nome = "arquivo_selecionado",
                        descricao = "A variável que receberá o caminho do arquivo selecionado pelo usuário"
                )
            },
            retorno = "verdadeiro se o usuário selecionou um arquivo. Falso se o usuário cancelou a seleção do arquivo",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public Boolean selecionar_arquivo(final ReferenciaVetor<String> formatos_suportados, final Boolean aceitar_todos_arquivos, final ReferenciaVariavel<String> arquivo_selecionado) throws ErroExecucaoBiblioteca
    {
        synchronized (Arquivos.this)
        {
            final ResultadoSelecao resultadoSelecao = new ResultadoSelecao();

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        JFileChooser dialogo = obterDialogoSelecao();
                        List<FileFilter> filtros = criarFiltros(formatos_suportados);

                        for (FileFilter filtro : dialogo.getChoosableFileFilters())
                        {
                            dialogo.removeChoosableFileFilter(filtro);
                        }

                        for (FileFilter filtro : filtros)
                        {
                            dialogo.addChoosableFileFilter(filtro);
                        }

                        if (aceitar_todos_arquivos || formatos_suportados.numeroElementos() == 0)
                        {
                            dialogo.addChoosableFileFilter(obterFiltroTodosArquivos());
                        }

                        Window janelaPai = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
                        
                        if (dialogo.showDialog(janelaPai, null) == JFileChooser.APPROVE_OPTION)
                        {
                            arquivo_selecionado.definirValor(obterCaminhoArquivo(dialogo.getSelectedFile()));
                            resultadoSelecao.setArquivoSelecionado(true);
                        }
                        
                        synchronized(Arquivos.this)
                        {
                            Arquivos.this.notifyAll();
                        }
                    }
                    catch (ErroExecucaoBiblioteca excecao)
                    {
                        throw new RuntimeException(excecao);
                    }
                }
            });

            try
            {
                wait();
            }
            catch (InterruptedException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }

            return resultadoSelecao.isArquivoSelecionado();
        }
    }

    private String obterCaminhoArquivo(File arquivo)
    {
        try
        {
            return arquivo.getCanonicalPath();
        }
        catch (IOException excecao)
        {
            return arquivo.getAbsolutePath();
        }
    }

    private List<FileFilter> criarFiltros(ReferenciaVetor<String> formatos) throws ErroExecucaoBiblioteca
    {
        List<FileFilter> filtros = new ArrayList<>();

        for (int i = 0; i < formatos.numeroElementos(); i++)
        {
            String formato = formatos.obterValor(i);

            try
            {
                String[] partes = formato.split("\\|");

                filtros.add(new FiltroExtensao(partes[0], partes[1]));
            }
            catch (Exception excecao)
            {
                throw new ErroExecucaoBiblioteca(String.format("O formato de arquivo '%s' é inválido", formato));
            }
        }

        return filtros;
    }

    private final class ResultadoSelecao
    {
        private boolean arquivoSelecionado = false;

        public void setArquivoSelecionado(boolean arquivoSelecionado)
        {
            this.arquivoSelecionado = arquivoSelecionado;
        }

        public boolean isArquivoSelecionado()
        {
            return arquivoSelecionado;
        }
    }

    private final class FiltroExtensao extends FileFilter
    {
        private final String descricao;
        private final List<String> extensoes;

        public FiltroExtensao(String descricao, String extensoes)
        {
            this.extensoes = obterExtensoes(extensoes);
            this.descricao = obterDescricao(descricao);
        }

        public String getExtensaoPrincipal()
        {
            return extensoes.get(0);
        }

        private List<String> obterExtensoes(String extensoes)
        {
            List<String> ext = new ArrayList<>();

            String[] exts = extensoes.split(",");

            for (String e : exts)
            {
                ext.add(e.trim().toLowerCase());
            }

            return ext;
        }

        private String obterDescricao(String descricao)
        {
            String desc = descricao;

            desc = desc.concat(" (");

            for (int i = 0; i < extensoes.size(); i++)
            {
                desc = desc.concat("*." + extensoes.get(i));

                if (i < extensoes.size() - 1)
                {
                    desc = desc.concat(", ");
                }
            }

            desc = desc.concat(")");

            return desc;
        }

        @Override
        public boolean accept(File arquivo)
        {
            if (arquivo.isFile())
            {
                for (String extensao : extensoes)
                {
                    if (arquivo.getName().toLowerCase().endsWith("." + extensao) || extensao.equals("*"))
                    {
                        return true;
                    }
                }

                return false;
            }

            return true;
        }

        @Override
        public String getDescription()
        {
            return descricao;
        }
    }

    private final class DialogoSelecaoArquivo extends JFileChooser
    {
        @Override
        public File getSelectedFile()
        {
            File arquivo = super.getSelectedFile();

            if (arquivo != null)
            {
                String extensao = ((FiltroExtensao) getFileFilter()).getExtensaoPrincipal();

                if (!extensao.equals("*"))
                {
                    if (!arquivo.getName().toLowerCase().endsWith("." + extensao))
                    {
                        arquivo = new File(arquivo.getPath().concat("." + extensao));
                    }
                }
            }

            return arquivo;
        }
    }

    private FiltroExtensao obterFiltroTodosArquivos()
    {
        if (filtroTodosArquivos == null)
        {
            filtroTodosArquivos = new FiltroExtensao("Todos os arquivos", "*");
        }

        return filtroTodosArquivos;
    }

    private DialogoSelecaoArquivo obterDialogoSelecao()
    {
        if (dialogoSelecao == null)
        {
            dialogoSelecao = new DialogoSelecaoArquivo();
            dialogoSelecao.setMultiSelectionEnabled(false);
            dialogoSelecao.setApproveButtonText("Selecionar");
            dialogoSelecao.setDialogTitle("Selecionar arquivo");
            dialogoSelecao.setAcceptAllFileFilterUsed(false);
        }

        return dialogoSelecao;
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
            else
            {
                if (modoAcesso == ModoAcesso.ESCRITA)
                {
                    abrirParaEscrita();
                }
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
                if (arquivo.getParentFile() != null)
                {
                    arquivo.getParentFile().mkdirs();
                }

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
                    escritor.newLine();
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
                else
                {
                    if (modoAcesso == ModoAcesso.LEITURA)
                    {
                        leitor.close();
                    }
                }
            }
            catch (IOException | NullPointerException excecao)
            {

            }
        }

        private String getCaminho()
        {
            return arquivo.getAbsolutePath();
        }
    }
}
