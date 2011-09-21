package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroExpressaoIncompleta extends ErroSintatico
{

    public ErroExpressaoIncompleta(int linha, int coluna)
    {
        super(linha, coluna);
    }

    @Override
    protected String construirMensagem()
    {
        return "A expressão está incompleta. Verifique se ambos os operandos direito e esquerdo estão presentes.";
    }    
}
