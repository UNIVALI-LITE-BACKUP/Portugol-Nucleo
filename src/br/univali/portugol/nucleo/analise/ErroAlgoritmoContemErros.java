package br.univali.portugol.nucleo.analise;

import br.univali.portugol.nucleo.mensagens.Erro;

/**
 *
 * @author Fillipi Domingos Pelz
 *
 */

public final class ErroAlgoritmoContemErros extends Erro
{
    public ErroAlgoritmoContemErros()
    {
        
    }

    @Override
    protected String construirMensagem()
    {
        return "O algoritmo contém erros";
    }
}
