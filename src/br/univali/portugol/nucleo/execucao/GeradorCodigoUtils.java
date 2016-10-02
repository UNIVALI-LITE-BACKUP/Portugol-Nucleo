package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.asa.TipoDado;

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
    
    public static String getNomeTipoEmCamelCase(TipoDado tipo)
    {
        return tipo.getNome().substring(0, 1).toUpperCase() + tipo.getNome().substring(1);
    }
}
