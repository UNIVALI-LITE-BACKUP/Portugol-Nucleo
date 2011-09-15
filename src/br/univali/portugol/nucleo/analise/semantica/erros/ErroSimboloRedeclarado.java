package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroSimboloRedeclarado extends ErroSemantico
{
    private Simbolo simboloExistente;
    private Simbolo simboloRedeclarado;

    public ErroSimboloRedeclarado(Simbolo simboloRedeclarado, Simbolo simboloExistente)
    {
        super
        (
            simboloRedeclarado.getTrechoCodigoFonteNome().getLinha(),
            simboloRedeclarado.getTrechoCodigoFonteNome().getColuna()
        );

        this.simboloRedeclarado = simboloRedeclarado;
        this.simboloExistente = simboloExistente;
    }

    public Simbolo getSimboloRedeclarado()
    {
        return simboloRedeclarado;
    }

    public Simbolo getSimboloExistente()
    {
        return simboloExistente;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("O símbolo \"");
        construtorString.append(simboloRedeclarado.getNome());
        construtorString.append("\" já foi declarado como ");

        if (simboloRedeclarado instanceof Vetor) construtorString.append("um vetor");
        else
        if (simboloRedeclarado instanceof Matriz) construtorString.append("uma matriz");
        else
        if (simboloRedeclarado instanceof Variavel) construtorString.append("uma variável");
        else
        if (simboloRedeclarado instanceof Funcao) construtorString.append("uma função");

        construtorString.append(" na linha: ");
        construtorString.append(simboloExistente.getTrechoCodigoFonteNome().getLinha());
        construtorString.append(", coluna: ");
        construtorString.append(simboloExistente.getTrechoCodigoFonteNome().getColuna());
        construtorString.append(".");

        return construtorString.toString();
    }
}
