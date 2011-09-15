package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoParametro;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroParametroRedeclarado extends ErroSemantico
{
    private Funcao funcao;
    private NoParametro parametro;

    public ErroParametroRedeclarado(NoParametro parametro, Funcao funcao)
    {
        super
        (
            parametro.getTrechoCodigoFonteNome().getLinha(),
            parametro.getTrechoCodigoFonteNome().getColuna()
        );

        this.funcao = funcao;
        this.parametro = parametro;
    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public NoParametro getParametro()
    {            
        return parametro;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();

        construtorTexto.append("O parâmetro \"");
        construtorTexto.append(parametro.getNome());
        construtorTexto.append("\" já foi declarado na função \"");
        construtorTexto.append(funcao.getNome());
        construtorTexto.append("\".");

        return construtorTexto.toString();
    }
}