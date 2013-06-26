package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 * Erro gerado pelo analisador semântico ao encontrar uma referência a um símbolo que não foi declarado ou não
 * está acessível no escopo atual. Por símbolo entende-se, uma variável, vetor, matriz ou função.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploSimboloNaoDeclarado()
 *      {
 *           inteiro num1
 * 
 *           num1 = num1 + 5        // Não gera erro, pois a variável 'num1' foi declarada neste escopo
 *           num2 = num2 - 4        // Gera erro pois a variável 'num2' não foi declarada neste escopo
 *          
 *           enquanto (verdadeiro)
 *           { 
 *                inteiro num3
 *                num3 = num3 * 4   // Não gera erro, pois a variável 'num3' foi declarada neste escopo
 *           }
 * 
 *           num3 = num3 * 4        // Gera erro, pois a variável 'num3' só existe no escopo do laço 'enquanto'
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 * @see NoDeclaracao
 */

public final class ErroSimboloNaoDeclarado extends ErroSemantico
{
    private NoReferencia referencia;

    /**
     * @param referencia     a referência ao símbolo inexistente.
     */
    public ErroSimboloNaoDeclarado(NoReferencia referencia)
    {
        super(referencia.getTrechoCodigoFonteNome());

        this.referencia = referencia;
    }

    /**
     * Obtém a referência ao símbolo inexistente.
     * 
     * @return     a referência ao símbolo inexistente.
     * @since 1.0
     */
    public NoReferencia getReferencia()
    {
        return referencia;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        if (referencia instanceof NoReferenciaVetor) return construirMensagemVetor();
        if (referencia instanceof NoReferenciaMatriz) return construirMensagemMatriz();
        if (referencia instanceof NoReferenciaVariavel) return construirMensagemVariavel();
        if (referencia instanceof NoChamadaFuncao) return construirMensagemFuncao();

        return null;
    }

    /**
     * Constrói uma mensagem de erro personalizada para uma declaração de vetor.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoDeclaracaoVetor
     */    
    private String construirMensagemVetor()
    {
        StringBuilder construtorTexto = new StringBuilder();

        construtorTexto.append("O vetor \"");
        construtorTexto.append(referencia.getNome());
        construtorTexto.append("\" não foi declarado neste escopo.");

        return construtorTexto.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para uma declaração de matriz.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoDeclaracaoMatriz
     */        
    private String construirMensagemMatriz()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A matriz \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para uma declaração de variável.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoDeclaracaoVariavel
     */        
    private String construirMensagemVariavel()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A variável \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para uma declaração de função.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoDeclaracaoFuncao
     */        
    private String construirMensagemFuncao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A função \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }
}