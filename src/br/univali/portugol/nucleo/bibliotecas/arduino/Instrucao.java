package br.univali.portugol.nucleo.bibliotecas.arduino;

/**
 *
 * @author Luiz Fernando Noschang
 */
public enum Instrucao
{
    HAND_SHAKE, DEFINIR_MODO_PINO, DEFINIR_ESTADO_PINO, DEFINIR_INTENSIDADE_PINO;//, LER_ESTADO_PINO, LER_INTENSIDADE_PINO;
    
    public String getID()
    {
        return Integer.toString(this.ordinal() + 1);
    }
    
    public static String getNome(int instrucao)
    {
        return values()[instrucao - 1].name();
    }
    
    public boolean respostaValida(StringBuilder resposta)
    {
        return resposta.toString().equals("OK " + getID());
    }
}
