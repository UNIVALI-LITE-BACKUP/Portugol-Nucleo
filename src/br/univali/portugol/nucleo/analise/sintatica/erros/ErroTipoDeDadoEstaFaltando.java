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
    private String codigo;    
    
    public ErroTipoDeDadoEstaFaltando(int linha, int coluna, String codigo)
    {
        super(linha, coluna);
        this.codigo = codigo;
    }    
    
    @Override
    protected String construirMensagem()
    {
       return String.format("O tipo de dado da variável \"%s\" está faltando.", obterNomeDaVariavel());
    }    
    
    private String obterNomeDaVariavel()
    {
        String linha = codigo.split("\n")[getLinha() - 1].substring(getColuna());
        Pattern padrao = Pattern.compile("[a-zA-Z_][a-zA-Z_0-9]*");
        Matcher analisador = padrao.matcher(linha);
        
        if (analisador.find())
            return analisador.group();
        
        return "<indefinido>";
    }
}
