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
        super("Erro de comunicação. O Arduíno foi desconectado do computador");
        
        LOGGER.log(Level.SEVERE, String.format("A resposta da instrução '%s' não foi recebida dentro do timeout especificado", instrucao.name()));        
    }

    public ErroComunicacao(SerialPortException erroPortaSerial)
    {
        super("Erro de comunicação. O Arduíno foi desconectado do computador ou a porta serial já está sendo utilizda por outro dispositivo");
    }
}
