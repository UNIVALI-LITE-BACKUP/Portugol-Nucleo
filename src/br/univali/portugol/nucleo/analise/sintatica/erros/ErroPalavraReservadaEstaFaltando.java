package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 * Erro gerado pelo analisador sintático quando uma palavra reservada está faltando.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      programa
 *      {
 *           inteiro exemploPalavraReservada()
 *           {
 *                escreva("Esta declaração de função vai gerar um erro, pois falta a palavra reservada 'funcao' no início da declaração")
 *           }
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 */
public final class ErroPalavraReservadaEstaFaltando extends ErroSintatico
{
    private String palavraReservada;

    /**
     * 
     * @param linha                a linha onde o erro ocorreu.
     * @param coluna               a coluna onde o erro ocorreu.
     * @param palavraReservada     a palavra reservada que está faltando.
     */
    public ErroPalavraReservadaEstaFaltando(int linha, int coluna, String palavraReservada)
    {
        super(linha, coluna);
        this.palavraReservada = palavraReservada;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        return "Está faltando a palavra reservada '" + palavraReservada + "'.";
    }
}
