package br.univali.portugol.nucleo.execucao.erros;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ExcecaoFuncaoPrincipalNaoDeclarada extends Exception
{
    private String nomeFuncaoPrincipal;

    public ExcecaoFuncaoPrincipalNaoDeclarada(String nome)
    {
            super(construirMensagem(nome));
            this.nomeFuncaoPrincipal = nome;
    }

    public String getNomeFuncaoPrincipal()
    {
        return nomeFuncaoPrincipal;
    }
	

    private static String construirMensagem(String nomeFuncaoPrincipal)
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A função principal \"");
        construtorString.append(nomeFuncaoPrincipal);
        construtorString.append("\" não foi declarada.");

        return construtorString.toString();
    }
}