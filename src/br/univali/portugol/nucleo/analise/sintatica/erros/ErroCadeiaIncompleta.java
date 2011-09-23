package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroCadeiaIncompleta extends ErroSintatico
{
    public ErroCadeiaIncompleta(int linha, int coluna, String mensagemPadrao) 
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem() 
    {
        return "A expressão do tipo 'cadeia' não foi finalizada corretamente. Insira o caracter \" para corrigir o problema. ";
    }
}
