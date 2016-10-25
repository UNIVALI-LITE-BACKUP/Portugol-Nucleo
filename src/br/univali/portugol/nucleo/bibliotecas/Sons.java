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
import br.univali.portugol.nucleo.bibliotecas.sons.SonsUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca(
        descricao = "Esta biblioteca contém funções que permitem reproduzir sons dentro de um programa. No momento, "
        + "somente o formato MP3 é suportado.",
        versao = "1.0"
)
public final class Sons extends Biblioteca
{
    private static final Logger LOGGER = Logger.getLogger(Sons.class.getName());

    private final AtomicInteger indiceDosSons = new AtomicInteger(0);
    private final AtomicInteger indiceDasReproducoes = new AtomicInteger(0);

    private final Map<Integer, Som> sons = new HashMap<>();
    private final Map<Integer, Reproducao> reproducoes = Collections.synchronizedMap(new HashMap<Integer, Reproducao>());

    private final AudioFormat formatoDeAudio = criaFormatoDeAudioPadrao();

    private int volumeGeral = 100;

    private Programa programa;

    @DocumentacaoFuncao(
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
    public int carregar_som(String caminho_som) throws ErroExecucaoBiblioteca, InterruptedException
    {
        File caminho = resolveCaminho(caminho_som);
        int indice = indiceDosSons.incrementAndGet();
        sons.put(indice, new Som(caminho, indice));
        return indice;
    }

    private File resolveCaminho(String caminho)
    {
        if (programa != null)
        {
            return programa.resolverCaminho(new File(caminho));
        }
        return new File(new File("."), caminho); //isto é útil para poder testar a lib Sons sem inicializá-la com um programa.
    }

    @DocumentacaoFuncao(
            descricao = "Libera a memória utilizada por um som que tenha sido previamente carregado. Se o som estiver sendo reproduzido, "
            + "todas as reproduções deste som serão interrompidas",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do som")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void liberar_som(int endereco) throws ErroExecucaoBiblioteca, InterruptedException
    {
        if (sons.containsKey(endereco))
        {
            sons.remove(endereco);
        }
    }

    @DocumentacaoFuncao(
            descricao = "Reproduz um som previamente carregado na memória. O som é reproduzido de forma assíncrona, ou seja, "
            + "o som ficará reproduzindo no fundo, enquanto o programa executa as próximas instruções normalmente. "
            + "Um mesmo som pode ser reproduzido várias vezes e pode se sobrepor a outros sons.",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória do som a ser reproduzido"),
                @DocumentacaoParametro(nome = "repetir", descricao = "determina se o som deve ficar repetindo até ser manualmente interrompido")
            },
            retorno
            = "o endereço de memória da reprodução de som. Este endereço é utilizado quando se deseja interromper "
            + "esta reprodução de som especificamente.",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public int reproduzir_som(int endereco, boolean repetir) throws ErroExecucaoBiblioteca, InterruptedException
    {
        if (sons.containsKey(endereco))
        {
            try
            {
                Som som = sons.get(endereco);
                int enderecoDaReproducao = indiceDasReproducoes.incrementAndGet();
                Reproducao reproducao = new Reproducao(som, formatoDeAudio, enderecoDaReproducao);
                reproducao.setVolumeGeral(volumeGeral / 100f);
                reproducoes.put(enderecoDaReproducao, reproducao);
                reproducao.inicia(repetir);
                return enderecoDaReproducao;
            }
            catch (Exception e)
            {
                throw new ErroExecucaoBiblioteca(e);
            }
        }
        throw new ErroExecucaoBiblioteca("Endereço de som inválido!");
    }

    @DocumentacaoFuncao(
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
    public void interromper_som(int endereco) throws ErroExecucaoBiblioteca, InterruptedException
    {
        synchronized (reproducoes)
        {
            if (reproducoes.containsKey(endereco))
            {
                Reproducao reproducao = reproducoes.get(endereco);
                reproducao.interrompe();
                reproducoes.remove(endereco);
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Define um novo volume para um som que já está sendo executado",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "o endereço de memória da reprodução que se quer alterar o volume"),
                @DocumentacaoParametro(nome = "volume", descricao = "o novo volume entre 0 e 100")
            },
            autores =
            {
                @Autor(nome = "Elieser A. de Jesus", email = "elieser@univali.br")
            }
    )
    public void definir_volume_reproducao(int endereco, int volume) throws ErroExecucaoBiblioteca, InterruptedException
    {
        synchronized (reproducoes)
        {
            if (reproducoes.containsKey(endereco))
            {
                reproducoes.get(endereco).setVolume(volume / 100f);
            }
            else
            {
                LOGGER.log(Level.WARNING, "Índice de reprodução não encontrado!");
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Define o volume geral",
            parametros =
            {
                @DocumentacaoParametro(nome = "volume", descricao = "O novo volume geral (entre 0 e 100)")
            },
            autores =
            {
                @Autor(nome = "Elieser A. de Jesus", email = "elieser@univali.br")
            }
    )
    public void definir_volume(int volume) throws ErroExecucaoBiblioteca, InterruptedException
    {
        synchronized (reproducoes)
        {
            volumeGeral = volume;
            for (Reproducao reproducao : reproducoes.values())
            {
                reproducao.setVolumeGeral(volume / 100f);
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Retorna o volume geral",
            retorno = "Um valor do tipo inteiro entre 0 e 100 representando o volume geral atual.",
            autores =
            {
                @Autor(nome = "Elieser A. de Jesus", email = "elieser@univali.br")
            }
    )
    public int obter_volume() throws ErroExecucaoBiblioteca, InterruptedException
    {
        return volumeGeral;
    }

    @DocumentacaoFuncao(
            descricao = "Retornar o volume de uma reprodução de som",
            parametros =
            {
                @DocumentacaoParametro(nome = "endereco", descricao = "O endereço de memória da reprodução que se quer obter o volume")
            },
            retorno = "Um valor do tipo inteiro entre 0 e 100 representando o volume atual da reprodução. Caso a reprodução não exista ou já tenha sido finalizada o valor -1 será retornado",
            autores =
            {
                @Autor(nome = "Elieser A. de Jesus", email = "elieser@univali.br")
            }
    )
    public int obter_volume_reproducao(int endereco) throws ErroExecucaoBiblioteca, InterruptedException
    {
        synchronized (reproducoes)
        {
            if (reproducoes.containsKey(endereco))
            {
                Reproducao reproducao = reproducoes.get(endereco);
                return (int) (reproducao.getVolume() * 100);
            }
        }
        return -1;
    }

    @Override
    public void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca, InterruptedException
    {
        this.programa = programa;
    }

    @Override
    public void finalizar() throws ErroExecucaoBiblioteca, InterruptedException
    {
        synchronized (reproducoes)
        {
            for (Reproducao reproducao : reproducoes.values())
            {
                reproducao.interrompe();
            }
            reproducoes.clear();
        }
        sons.clear();
    }

    private class ListenerDeInterrupcaoDeAudio implements LineListener
    {
        private final int endereco;

        public ListenerDeInterrupcaoDeAudio(int endereco)
        {
            this.endereco = endereco;
        }

        @Override
        public void update(LineEvent evento)
        {
            if (evento.getType() == LineEvent.Type.STOP)
            {
                try
                {
                    interromper_som(endereco);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
                catch (ErroExecucaoBiblioteca excecao)
                {
                    LOGGER.log(Level.SEVERE, null, excecao);
                }

            }
        }

    }

    private class Reproducao
    {
        private Clip reprodutor;
        private final int endereco; //endereco da reprodução, não do som. O objeto Som tem outro endereço.
        private float volume = 1.0f;
        private float volumeGeral = 1.0f;
        private FloatControl controleDeVolume = null;

        public Reproducao(Som som, AudioFormat formatoDeAudio, int endereco) throws IOException, UnsupportedAudioFileException
        {
            this.endereco = endereco;
            try
            {
                reprodutor = AudioSystem.getClip();
                reprodutor.open(criaStream(som, formatoDeAudio));
                reprodutor.addLineListener(new ListenerDeInterrupcaoDeAudio(endereco));

                if (reprodutor.isControlSupported(FloatControl.Type.MASTER_GAIN))
                {
                    controleDeVolume = (FloatControl) reprodutor.getControl(FloatControl.Type.MASTER_GAIN);
                }
            }
            catch (LineUnavailableException excecao)
            {
                LOGGER.log(Level.WARNING, "Não foi possível criar ou abrir uma linha de execução de áudio!", excecao);
                reprodutor = null;
            }
        }

        /**
         * @param volume da reprodução Entre 0.0 e 1.0
         */
        void setVolume(float volume)
        {
            if (reprodutor == null || controleDeVolume == null)
            {
                return;
            }

            this.volume = limitaValorDoVolume(volume);

            float valorLinear = this.volume * this.volumeGeral;
            float volumeExponencial = SonsUtils.linearParaExponencial(valorLinear); //É possível converter o valor linear para decibéis diretamente, entretanto converter os valores lineares para exponenciais faz com que as alterações de volume se adequem melhor à audição humana. Mais detalhes em http://www.dr-lex.be/info-stuff/volumecontrols.html
            float valorEmDecibeis = SonsUtils.linearParaDecibel(volumeExponencial);
            if (valorEmDecibeis < controleDeVolume.getMinimum())
            {
                valorEmDecibeis = controleDeVolume.getMinimum();
            }
            else
            {
                if (valorEmDecibeis > controleDeVolume.getMaximum())
                {
                    valorEmDecibeis = controleDeVolume.getMaximum();
                }
            }
            controleDeVolume.setValue(valorEmDecibeis);
            //LOGGER.log(Level.INFO, "Valor linear {0}", valorLinear);
            //LOGGER.log(Level.INFO, "Valor em decibéis {0}", valorEmDecibeis);
            //LOGGER.log(Level.INFO, "Volume setado para {0}", controleDeVolume.getValue());
        }

        void setVolumeGeral(float volumeGeral) //esse 'workaround' no volume geral foi usado porque o Java não permite manipular o volume geral
        {
            this.volumeGeral = volumeGeral;
            setVolume(this.volume); //atualiza o volume
        }

        public float getVolume()
        {
            return volume;
        }

        public int getEndereco()
        {
            return endereco;
        }

        public void inicia(boolean repetir)
        {
            if (reprodutor == null)
            {
                return;
            }

            if (!repetir)
            {
                reprodutor.start();
            }
            else
            {
                reprodutor.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }

        public void interrompe()
        {
            if (reprodutor == null)
            {
                return;
            }

            reprodutor.stop();
            reprodutor.close();
        }
    }

    private static float limitaValorDoVolume(float volume)
    {
        if (volume < 0)
        {
            return 0;
        }
        else
        {
            if (volume > 1)
            {
                return 1;
            }
        }
        return volume;
    }

    private static AudioInputStream criaStream(Som som, AudioFormat formatoDoAudio)
            throws UnsupportedAudioFileException, IOException
    {

        AudioInputStream fluxoCodificado = AudioSystem.getAudioInputStream(som.getArquivo());
        AudioFormat formatoCodificado = fluxoCodificado.getFormat();

        boolean precisaConverterTaxaDeAmostragem = formatoCodificado.getSampleRate() != formatoDoAudio.getSampleRate();
        boolean precisaConververCanais = formatoCodificado.getChannels() != formatoDoAudio.getChannels();

        //converte para PCM, mas mantendo a taxa de amostragem original e o número de canais originais
        AudioFormat formatoDeConversao = criaNovoFormatoDeAudio(formatoDoAudio, formatoCodificado.getSampleRate(), formatoCodificado.getChannels());
        AudioInputStream fluxoDecodificado = AudioSystem.getAudioInputStream(formatoDeConversao, fluxoCodificado);

        if (precisaConverterTaxaDeAmostragem)
        {
            // converte de PCM para PCM mas alterando a taxa de amostragem e mantendo a mesma quantidade de canais do áudio original
            formatoDeConversao = criaNovoFormatoDeAudio(formatoDoAudio, formatoDoAudio.getSampleRate(), formatoCodificado.getChannels());
            fluxoDecodificado = AudioSystem.getAudioInputStream(formatoDeConversao, fluxoDecodificado);
        }

        if (precisaConververCanais) //o áudio original era mono e precisar ser convertido para stereo
        {
            // converte o fluxo para a quantidade final de canais
            formatoDeConversao = criaNovoFormatoDeAudio(formatoDoAudio, formatoDoAudio.getSampleRate(), formatoDoAudio.getChannels());
            fluxoDecodificado = AudioSystem.getAudioInputStream(formatoDeConversao, fluxoDecodificado);
        }
        return fluxoDecodificado;
    }

    private static AudioFormat criaNovoFormatoDeAudio(AudioFormat formatoBase, float novaTaxaDeAmostragem, int canais)
    {
        return new AudioFormat(
                formatoBase.getEncoding(),
                novaTaxaDeAmostragem,
                formatoBase.getSampleSizeInBits(),
                canais,
                canais * formatoBase.getSampleSizeInBits() / 8,
                formatoBase.getFrameRate(),
                formatoBase.isBigEndian()
        );
    }

    private final class Som
    {
        private final File arquivo;
        private final int endereco;

        public Som(File arquivo, int endereco) throws ErroExecucaoBiblioteca, InterruptedException
        {
            this.arquivo = arquivo;
            this.endereco = endereco;
        }

        public File getArquivo()
        {
            return arquivo;
        }

        public int getEndereco()
        {
            return endereco;
        }

    }

    private static AudioFormat criaFormatoDeAudioPadrao()
    {
        float taxaDeAmostragem = 44100; //44100 amostras por segundo (44.1 KHz)
        int canais = 2;//estéreo
        int quantidadeDeBitsPorAmostra = 16; //áudio de 16 bits
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                taxaDeAmostragem,
                quantidadeDeBitsPorAmostra,
                canais,
                canais * quantidadeDeBitsPorAmostra / 8, //frame size
                taxaDeAmostragem, //frame rate
                false); //big endian?
    }

}
