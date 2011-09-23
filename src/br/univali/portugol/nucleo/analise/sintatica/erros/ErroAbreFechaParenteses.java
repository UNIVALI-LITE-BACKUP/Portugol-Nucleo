/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author luiz
 */
public final class ErroAbreFechaParenteses extends ErroSintatico
{
    private String tokenParenteses;
            
    public ErroAbreFechaParenteses(int linha, int coluna, String tokenParenteses)
    {
        super(linha, coluna);
        this.tokenParenteses = tokenParenteses;
    }
    
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("A expressão não foi ");
        
        if (tokenParenteses.equals("("))
            construtorTexto.append("iniciada");
        
        else
            
        if (tokenParenteses.equals(")"))
            construtorTexto.append("finalizada");
        
        construtorTexto.append(" corretamente. Insira o caracter '");
        construtorTexto.append(tokenParenteses);
        construtorTexto.append("' para corrigir o problema.");
        
        return construtorTexto.toString();
    }
}
