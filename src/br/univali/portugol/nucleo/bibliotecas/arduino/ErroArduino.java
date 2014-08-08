package br.univali.portugol.nucleo.bibliotecas.arduino;

/**
 *
 * @author Luiz Fernando Noschang
 */
public abstract class ErroArduino extends Exception
{
    public ErroArduino(String mensagem)
    {
        super(mensagem);
    }
}
