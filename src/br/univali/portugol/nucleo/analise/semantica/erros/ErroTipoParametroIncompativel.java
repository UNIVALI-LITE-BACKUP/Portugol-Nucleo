package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;

/**
 * Erro gerado pelo analisador semântico quando é realizada uma chamada de função passando
 * um parâmetro com um tipo de dado diferento do esperado pela função.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      programa
 *      {
 *           funcao exemploTipoParametroIncompativel()
 *           {
 *                 /*
 *                  * Esta chamada de função gera erro, pois o segundo parâmetro da função espera um valor do tipo
 *                  * inteiro, no entanto, está sendo passado uma expressão do tipo cadeia.
 *                  *&#47;
 *  
 *                 inteiro valor = soma(5, "Oooooppppsss!")
 * 
 *                 escreva(valor)
 *           }
 * 
 *           funcao inteiro soma(nteiro a, inteiro b)
 *           {
 *                retorne a + b
 *           }
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @since 1.0
 * 
 * @see AnalisadorSemantico
 */

public class ErroTipoParametroIncompativel extends ErroSemantico
{
    private TipoDado tipoDadoParametroEsperado;
    private TipoDado tipoDadoParametroPassado;

    private NoDeclaracaoParametro parametroEsperado;
    private NoExpressao parametroPassado;
    private Funcao funcao;

    /**
     * 
     * @param tipoDadoParametroEsperado     o tipo de dado esperado pelo parâmetro da função.
     * @param tipoDadoParametroPassado      o tipo de dado da expressão que foi passada por parâmetro.
     * @param parametroEsperado             o nó da ASA correspondente à declaração do parâmetro da função.
     * @param parametroPassado              a expressão que foi passada por parâmetro.
     * @param funcao                        a função que foi chamada.
     */
    public ErroTipoParametroIncompativel(TipoDado tipoDadoParametroEsperado, TipoDado tipoDadoParametroPassado, NoDeclaracaoParametro parametroEsperado, NoExpressao parametroPassado, Funcao funcao)
    {
        super(parametroPassado.getTrechoCodigoFonte());
        this.tipoDadoParametroEsperado = tipoDadoParametroEsperado;
        this.tipoDadoParametroPassado = tipoDadoParametroPassado;
        this.parametroEsperado = parametroEsperado;
        this.parametroPassado= parametroPassado;
        this.funcao = funcao;

    }

    /**
     * Obtém      o nó da ASA correspondente à declaração do parâmetro da função.
     * 
     * @return     o nó da ASA correspondente à declaração do parâmetro da função.
     * @since 1.0
     */
    public NoDeclaracaoParametro getParametroEsperado()
    {
        return parametroEsperado;
    }

    /**
     * Obtém a expressão que foi passada por parâmetro.
     * 
     * @return     a expressão que foi passada por parâmetro.
     * @since 1.0
     */
    public NoExpressao getParametroPassado()
    {
        return parametroPassado;
    }
    
    /**
     * Obtém a função que foi chamada.
     * 
     * @return     a função que foi chamada.
     * @since 1.0
     */
    public Funcao getFuncao()
    {
        return funcao;
    }

    /**
     * Obtém o tipo de dado esperado pelo parâmetro da função.
     * 
     * @return     o tipo de dado esperado pelo parâmetro da função.
     * @since 1.0
     */
    public TipoDado getTipoDadoParametroEsperado()
    {
        return tipoDadoParametroEsperado;
    }

    /**
     * Obtém o tipo de dado da expressão que foi passada por parâmetro.
     * 
     * @return     o tipo de dado da expressão que foi passada por parâmetro.
     * @since 1.0
     */
    public TipoDado getTipoDadoParametroPassado()
    {
        return tipoDadoParametroPassado;
    }

    /**
     * {@inheritDoc }
     */
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
