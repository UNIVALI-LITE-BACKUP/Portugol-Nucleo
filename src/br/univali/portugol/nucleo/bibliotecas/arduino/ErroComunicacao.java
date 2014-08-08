package br.univali.portugol.nucleo.bibliotecas.arduino;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroComunicacao extends ErroArduino
{
    private static final Logger LOGGER = Logger.getLogger(ErroComunicacao.class.getName());
    
    public ErroComunicacao(Instrucao instrucao)
    {
        super(obterMensagemInstrucao(instrucao));
        
        LOGGER.log(Level.SEVERE, String.format("A resposta da instrução '%s' não foi recebida dentro do timeout especificado", instrucao.name()));        
    }

    public ErroComunicacao(SerialPortException erroPortaSerial)
    {
        super("Erro de comunicação. O Arduino não está conectado ao computador ou a porta serial já está sendo utilizda por outro dispositivo");
    }
    
    private static String obterMensagemInstrucao(Instrucao instrucao)
    {
        if (instrucao == Instrucao.HAND_SHAKE)
        {
            return "Erro de comunicação. O dispositivo conectado na porta serial não é um Arduino ou é um Arduino que não contém o firmware do Portugol";
        }
        
        return "Erro de comunicação. O Arduino não está conectado ao computador";
    }
}
