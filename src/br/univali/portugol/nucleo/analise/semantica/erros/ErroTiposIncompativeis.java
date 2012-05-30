package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.Operacao;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 * Erro gerado pelo analisador semântico quando uma operação entre duas expressões com
 * tipos de dado incompatíveis é encontrada.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploTiposIncompativeis()
 *      {
 *           inteiro valor1 = 10
 *           logico valor2 = falso
 *           real valor3 = 2.34
 * 
 *           valor3 = valor1 + valor2       // Gera erro, pois a operação de soma não é suportada entre um inteiro e um lógico
 *           valor2 = valor3                // Gera erro, pois a operação de atribuição não é suportada entre um lógico e um real
 *           valor3 = valor1                // Não gera erro pois a operação de atribuição entre um real e um inteiro é suportada
 *      }
 * 
 * </pre></code>
 * <p>
 * Consulte o documento <a href='doc-files/compatibilidade_tipos.pdf' target='blank'>Compatibilidade de tipos do Portugol</a> 
 * para verificar os tipos de dados que podem ser utlizados com cada operação.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 */

public final class ErroTiposIncompativeis extends ErroSemantico
{
    private Operacao operacao;
    private TipoDado tipoDadoOperandoDireito;
    private TipoDado tipoDadoOperandoEsquerdo;

    /**
     * 
     * @param operacao                     a operação que estava sendo realizada entre as duas expressões.
     * @param tipoDadoOperandoEsquerdo     o tipo de dado da expressão à esquerda do operador.
     * @param tipoDadoOperandoDireito      o tipo de dado da expressão á direita do operador.
     * @since 1.0
     */
    public ErroTiposIncompativeis(NoOperacao operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito)
    {
        super
        (
            operacao.getTrechoCodigoFonte().getLinha(),
            operacao.getTrechoCodigoFonte().getColuna()
        );

        this.operacao = operacao.getOperacao();
        this.tipoDadoOperandoDireito = tipoDadoOperandoDireito;
        this.tipoDadoOperandoEsquerdo = tipoDadoOperandoEsquerdo;
    }
    
    /**
     * Obtém  a operação que estava sendo realizada entre as duas expressões.
     * 
     * @return      a operação que estava sendo realizada entre as duas expressões.
     * @since 1.0
     */
    public Operacao getOperacao()
    {
        return operacao;
    }

    /**
     * Obtém o tipo de dado da expressão à direita do operador.
     * 
     * @return     o tipo de dado da expressão à direita do operador.
     * @since 1.0
     */
    public TipoDado getTipoDadoOperandoDireito()
    {
        return tipoDadoOperandoDireito;
    }

    /**
     * Obtém o tipo de dado da expressão à esquerda do operador.
     * 
     * @return     o tipo de dado da expressão à esquerda do operador.
     * @since 1.0
     */
    public TipoDado getTipoDadoOperandoEsquerdo()
    {
        return tipoDadoOperandoEsquerdo;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        switch (operacao)
        {
            case ATRIBUICAO: return construirMensagemAtribuicao();
            case DIFERENCA: return construirMensagemDiferenca();
            case DIVISAO: return construirMensagemDivisao();
            case DIVISAO_ACUMULATIVA: return construirMensagemDivisaoAcumulativa();
            case E: return construirMensagemE();
            case IGUALDADE: return construirMensagemIgualdade();
            case MAIOR: return construirMensagemMaior();
            case MAIOR_IGUAL: return construirMensagemMaiorIgual();
            case MENOR: return construirMensagemMenor();
            case MENOR_IGUAL: return construirMensagemMenorIgual();
            case MODULO: return construirMensagemModulo();
            case MODULO_ACUMULATIVO: return construirMensagemModuloAcumulativo();
            case MULTIPLICACAO: return construirMensagemMultiplicacao();
            case MULTIPLICACAO_ACUMULATIVA: return construirMensagemMultiplicacaoAcumulativa();
            case OU: return construirMensagemOu();
            case SOMA: return construirMensagemSoma();
            case SOMA_ACUMULATIVA: return construirMensagemSomaAcumulativa();
            case SUBTRACAO: return construirMensagemSubtracao();
            case SUBTRACAO_ACUMULATIVA: return construirMensagemSubtracaoAcumulativa();
        }

        return null;
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#ATRIBUICAO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemAtribuicao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível atribuir uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\" à uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#DIFERENCA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */
    private String construirMensagemDiferenca()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#DIVISAO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */    
    private String construirMensagemDivisao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível dividir uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" por uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#DIVISAO_ACUMULATIVA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemDivisaoAcumulativa()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar uma operação de divisão acumulativa entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressao do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }
    
    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#E}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemE()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar a operação lógica E entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }
    
    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#IGUALDADE}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemIgualdade()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MAIOR}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemMaior()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MAIOR_IGUAL}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemMaiorIgual()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MENOR}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemMenor()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MENOR_IGUAL}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemMenorIgual()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível comparar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MODULO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemModulo()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível obter o módulo entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MODULO_ACUMULATIVO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemModuloAcumulativo()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar uma operação de módulo acumulativo entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MULTIPLICACAO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemMultiplicacao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível multiplicar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#MULTIPLICACAO_ACUMULATIVA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */            
    private String construirMensagemMultiplicacaoAcumulativa()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar uma operação de multiplicação acumulativa entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#OU}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemOu()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar a operação lógica OU entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#SOMA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemSoma()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível somar uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" com uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

        /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#SOMA_ACUMULATIVA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemSomaAcumulativa()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar uma operação de soma acumulativa entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#SUBTRACAO}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemSubtracao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível subtrair uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\" de uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\".");

        return construtorString.toString();
    }

    /**
     * Constrói uma mensagem de erro personalizada para a operação {@link Operacao#SUBTRACAO_ACUMULATIVA}.
     * 
     * @return     a mensagem de erro personalizada.
     * @since 1.0
     * 
     * @see NoOperacao
     */        
    private String construirMensagemSubtracaoAcumulativa()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("Tipos incompatíveis! Não é possível executar uma operação de subtração acumulativa entre uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoEsquerdo);
        construtorString.append("\" e uma expressão do tipo \"");
        construtorString.append(tipoDadoOperandoDireito);
        construtorString.append("\".");

        return construtorString.toString();
    }
}
