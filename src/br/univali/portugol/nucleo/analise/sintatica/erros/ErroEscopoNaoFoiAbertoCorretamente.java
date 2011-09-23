package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noscgang
 * 
 */

public final class ErroEscopoNaoFoiAbertoCorretamente extends ErroSintatico
{
    private String contexto;
    
    public ErroEscopoNaoFoiAbertoCorretamente(int linha, int coluna, String contexto)
    {
        super(linha, coluna);
        this.contexto = contexto;
    }
    
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("O escopo ");
        
        if (contexto.equals("programa"))
            construtorTexto.append(" do programa ");
        
        else
            
        if (contexto.equals("declaracaoFuncao"))
            construtorTexto.append(" da função ");
        
        else construtorTexto.append(" do bloco ");
        
        construtorTexto.append("não foi aberto corretamente. Inisira o caracter '{' para corrigir o problema.");
        
        return construtorTexto.toString();
    }
}
