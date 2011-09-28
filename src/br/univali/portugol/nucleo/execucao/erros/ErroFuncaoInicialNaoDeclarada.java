package br.univali.portugol.nucleo.execucao.erros;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroFuncaoInicialNaoDeclarada extends ErroExecucao
{
    private String nomeFuncaoPrincipal;

    public ErroFuncaoInicialNaoDeclarada(String nome)
    {
            this.nomeFuncaoPrincipal = nome;
    }

    public String getNomeFuncaoPrincipal()
    {
        return nomeFuncaoPrincipal;
    }

    @Override
    protected String construirMensagem() 
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A função principal \"");
        construtorString.append(nomeFuncaoPrincipal);
        construtorString.append("\" não foi declarada.");

        return construtorString.toString();
    }
}