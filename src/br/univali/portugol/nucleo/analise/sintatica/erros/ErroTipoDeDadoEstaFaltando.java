package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroTipoDeDadoEstaFaltando extends ErroSintatico
{
    public ErroTipoDeDadoEstaFaltando(int linha, int coluna)
    {
        super(linha, coluna);
    }    
    
    @Override
    protected String construirMensagem()
    {
       return "Você esqueceu de informar o tipo de dado da variável.";
    }
}
