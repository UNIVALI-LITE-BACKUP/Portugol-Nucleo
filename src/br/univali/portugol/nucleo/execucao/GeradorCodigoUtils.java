package br.univali.portugol.nucleo.execucao;

/**
 * @author Elieser
 */
public class GeradorCodigoUtils
{
    public static String preservaCaracteresEspeciais(String string)
    {
        return string
                .replaceAll("\n", "\\\\n")   // preserva \n nas string do código Portugol 
                .replaceAll("\"", "\\\\\""); // preserva aspas duplas com scape (\") nas string do código Portugol 
    }
}
