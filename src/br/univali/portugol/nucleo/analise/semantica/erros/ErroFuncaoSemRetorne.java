/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author 4276663
 */
public class ErroFuncaoSemRetorne extends ErroSemantico
{
    String nomeFuncao;
    public ErroFuncaoSemRetorne(NoDeclaracaoFuncao noDeclaracaoFuncao){
        super(noDeclaracaoFuncao.getTrechoCodigoFonteNome());
        this.nomeFuncao = noDeclaracaoFuncao.getNome();
    }
    @Override
    protected String construirMensagem()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("A função \"");
        builder.append(nomeFuncao);
        builder.append("\" não possui uma instrução de retorno que seja sempre executada, tente colocar na ultima linha da função a instrução \"retorne\"");
        return builder.toString();
    }
    
}
