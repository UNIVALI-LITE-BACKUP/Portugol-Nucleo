package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public class ErroTipoParametroIncompativel extends ErroSemantico
{
    private TipoDado tipoDadoParametroEsperado;
    private TipoDado tipoDadoParametroPassado;

    private NoDeclaracaoParametro parametroEsperado;
    private NoExpressao parametroPassado;
    private Funcao funcao;

    public ErroTipoParametroIncompativel(TipoDado tipoDadoParametroEsperado, TipoDado tipoDadoParametroPassado, NoDeclaracaoParametro parametroEsperado, NoExpressao parametroPassado, Funcao funcao)
    {
        super
        (
            parametroPassado.getTrechoCodigoFonte().getLinha(),
            parametroPassado.getTrechoCodigoFonte().getColuna()
        );

        this.tipoDadoParametroEsperado = tipoDadoParametroEsperado;
        this.tipoDadoParametroPassado = tipoDadoParametroPassado;
        this.parametroEsperado = parametroEsperado;
        this.parametroPassado= parametroPassado;
        this.funcao = funcao;

    }

    public NoDeclaracaoParametro getParametroEsperado()
    {
        return parametroEsperado;
    }

    public NoExpressao getParametroPassado()
    {
        return parametroPassado;
    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public TipoDado getTipoDadoParametroEsperado()
    {
        return tipoDadoParametroEsperado;
    }

    public TipoDado getTipoDadoParametroPassado()
    {
        return tipoDadoParametroPassado;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! O parâmetro \"");
        construtorString.append(parametroEsperado.getNome());
        construtorString.append("\" da função \"");
        construtorString.append(funcao.getNome());
        construtorString.append("\" esperava uma expressão do tipo \"");
        construtorString.append(tipoDadoParametroEsperado);
        construtorString.append("\" mas foi passada uma expressão do tipo \"");
        construtorString.append(tipoDadoParametroPassado);
        construtorString.append("\".");

        return construtorString.toString();
    }
}
