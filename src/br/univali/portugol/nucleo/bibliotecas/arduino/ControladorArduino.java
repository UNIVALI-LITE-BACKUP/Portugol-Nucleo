package br.univali.portugol.nucleo.bibliotecas.arduino;

import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Luiz Fernando
 */
public final class ControladorArduino
{
    private static final Logger LOGGER = Logger.getLogger(ControladorArduino.class.getName());

    private static final int VELOCIDADE_PORTA = 9600;
    private static final int TIMEOUT_COMUNICACAO = 2000;
    private static final int DELAY_INICIAL = 4000;

    public static final byte INICIALIZADOR_INSTRUCAO = 17; // ASCII Control 1
    public static final byte FINALIZADOR_INSTRUCAO = 20; // ASCII Control 4

    private static final byte INICIALIZADOR_PARAMETRO = 18; // ASCII Control 2
    private static final byte FINALIZADOR_PARAMETRO = 19; // ASCII Control 3

    private final StringBuilder bufferResposta = new StringBuilder();

    private SerialPort portaSerial;

    private boolean respostaRecebida;
    private Instrucao instrucaoEnviada;
    private ErroArduino erroArduino;

    public void inicializar() throws ErroExecucaoBiblioteca
    {
        if (!inicializado())
        {
            synchronized (ControladorArduino.this)
            {
                portaSerial = conectar();
                handShake();
            }
        }
    }

    private SerialPort conectar() throws ErroExecucaoBiblioteca
    {
        try
        {
            SerialPort porta = new SerialPort("COM8");

            porta.openPort();
            porta.setParams(VELOCIDADE_PORTA, 8, 1, 0);
            porta.setEventsMask(SerialPort.MASK_RXCHAR);

            Thread.sleep(DELAY_INICIAL);

            porta.addEventListener(new DecodificadorInstrucoes());

            return porta;
        }
        catch (SerialPortException excecao)
        {
            throw new ErroExecucaoBiblioteca(new ErroComunicacao(excecao));
        }
        catch (InterruptedException excecao)
        {
            throw new ErroExecucaoBiblioteca(excecao);
        }
    }

    public void finalizar()
    {
        if (inicializado())
        {
            try
            {
                portaSerial.closePort();
                
                synchronized (ControladorArduino.this)
                {
                    portaSerial = null;
                }
            }
            catch (SerialPortException excecao)
            {
                LOGGER.log(Level.WARNING, "Erro ao desconectar a porta serial", excecao);
            }
        }
    }

    public boolean inicializado()
    {
        synchronized (ControladorArduino.this)
        {
            if (portaSerial != null)
            {
                return portaSerial.isOpened();
            }

            return false;
        }
    }

    private void handShake() throws ErroExecucaoBiblioteca
    {
        enviarInstrucao(Instrucao.HAND_SHAKE);
    }

    public void enviarInstrucao(Instrucao instrucao, String... parametros) throws ErroExecucaoBiblioteca
    {
        respostaRecebida = false;
        instrucaoEnviada = instrucao;

        limparBufferResposta();

        try
        {
            String pacoteInstrucao = montarPacoteInstrucao(instrucao, parametros);

            portaSerial.writeString(pacoteInstrucao);
        }
        catch (SerialPortException excecao)
        {
            finalizar();
            throw new ErroExecucaoBiblioteca(new ErroComunicacao(excecao));
        }

        synchronized (ControladorArduino.this)
        {
            try
            {
                ControladorArduino.this.wait(TIMEOUT_COMUNICACAO);

                if (erroArduino != null)
                {
                    finalizar();
                    throw new ErroExecucaoBiblioteca(erroArduino);
                }
                else
                {
                    if (!respostaRecebida)
                    {
                        finalizar();
                        throw new ErroExecucaoBiblioteca(new ErroComunicacao(instrucao));
                    }
                }
            }
            catch (InterruptedException excecao)
            {
                throw new ErroExecucaoBiblioteca(excecao);
            }
        }
    }

    private String montarPacoteInstrucao(Instrucao instrucao, String... parametros)
    {
        StringBuilder dadosInstrucao = new StringBuilder();

        dadosInstrucao.append((char) INICIALIZADOR_INSTRUCAO);
        dadosInstrucao.append(instrucao.getID());

        if (parametros != null && parametros.length > 0)
        {
            for (String parametro : parametros)
            {
                dadosInstrucao.append((char) INICIALIZADOR_PARAMETRO);
                dadosInstrucao.append(parametro);
                dadosInstrucao.append((char) FINALIZADOR_PARAMETRO);
            }
        }

        dadosInstrucao.append((char) FINALIZADOR_INSTRUCAO);

        return dadosInstrucao.toString();
    }

    private final class DecodificadorInstrucoes implements SerialPortEventListener
    {
        @Override
        public void serialEvent(SerialPortEvent event)
        {
            if (inicializado() && event.isRXCHAR())
            {
                try
                {
                    String resposta = portaSerial.readString();

                    if (resposta != null)
                    {
                        bufferResposta.append(resposta);
                    }

                    if (instrucaoEnviada.respostaValida(bufferResposta))
                    {
                        dispararRespostaArduino();
                    }
                    else
                    {
                        if (ErroProtocolo.ocorreuErro(bufferResposta))
                        {
                            dispararErroProtocolo();
                        }
                    }
                }
                catch (SerialPortException excecao)
                {
                    dispararErroComunicacao(excecao);
                }
            }
        }
    }

    private void dispararRespostaArduino()
    {
        synchronized (ControladorArduino.this)
        {
            respostaRecebida = true;
            ControladorArduino.this.notifyAll();
        }
    }

    private void dispararErroProtocolo()
    {
        erroArduino = ErroProtocolo.decodificarErro(bufferResposta);

        synchronized (ControladorArduino.this)
        {
            ControladorArduino.this.notifyAll();
        }
    }

    private void dispararErroComunicacao(SerialPortException excecao)
    {
        erroArduino = new ErroComunicacao(excecao);

        synchronized (ControladorArduino.this)
        {
            ControladorArduino.this.notifyAll();
        }
    }

    private void limparBufferResposta()
    {
        bufferResposta.delete(0, bufferResposta.length());
    }
}
