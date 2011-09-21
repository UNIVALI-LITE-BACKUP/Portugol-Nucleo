package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;

/**
 *
 * @author Luiz Fernando
 * 
 */

public final class ErroNomeSimboloEstaFaltando extends ErroSintatico
{
    private String contexto;
    
    public ErroNomeSimboloEstaFaltando(int linha, int coluna, String contexto)
    {
        super(linha, coluna);
        this.contexto = contexto;
    }
    
    @Override
    protected String construirMensagem()
    {
        if (contexto.equals("declaracaoParametro"))
            return "Está faltando o nome do parâmetro da função.";
        
        else
            return "Está faltando o nome da variável.";
    }
}
