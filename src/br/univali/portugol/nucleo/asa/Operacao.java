package br.univali.portugol.nucleo.asa;

/**
 * Esta enumeração contém a maioria das operações lógicas e aritméticas do Portugol.
 * <p>
 * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
 * para verificar os tipos de dados que podem ser utlizados com cada operação.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see NoOperacao
 */
public enum Operacao
{
    /**
     * Esta enumeração representa a operação de <code>igualdade</code> no código fonte.
     * <p>
     * A operação de <code>igualdade</code> serve para determinar se duas expressões são equivalentes (iguais).
     * No Portugol, a operação de <code>igualdade</code> é representada no código fonte pelo operador "==".
     * <p>
     * A operação de <code>igualdade</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
     * valor lógico: <code>verdadeiro</code> se as expressões forem iguais e <code>falso</code> se 
     * as expressões forem diferentes. Pode ser utilizada para realizar o controle de laços de repetição 
     * e desvios condicionais.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    IGUALDADE("==", "igualdade"),    
    
    /**
     * Esta enumeração representa a operação de <code>diferença</code> no código fonte.
     * <p>
     * A operação de <code>diferença</code> serve para determinar se duas expressões são diferentes.
     * No Portugol, a operação de <code>diferença</code> é representada no código fonte pelo operador "!=".
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    DIFERENCA("!=", "diferençaa"),
    
    /**
     * Esta enumeração representa a operação de <code>atribuição</code> no código fonte.
     * <p>
     * A operação de <code>atribuição</code> serve para armazenar um valor em uma variável, vetor ou matriz.
     * No Portugol, a operação de <code>atribuição</code> é representada no código fonte pelo operador "=".
     * <p>
     * A operação de <code>atribuição</code> é uma operação aritmética na qual o operando esquerdo é obrigatoriamente uma
     * referência a uma variável, um vetor ou uma matriz. O operando direito, por sua vez, pode ser qualquer 
     * tipo de expressão. Ao ser avaliada, o resultado da expressão à direita é armazenado na variável, vetor
     * ou matriz à esquerda e retornado como resultado da operação. Isto significa que, a operação de <code>atribuição</code>
     * pode ser utilizada como operando de outras operações.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * @since 1.0
     */
    ATRIBUICAO("=", "atribuição"),
    
    /**
     * Esta enumeração representa a operação lógica <code>e</code> no código fonte.
     * <p>
     * A operação <code>e</code> é uma operação lógica especial que equivale à operação booleana AND.
     * No Portugol, a operação <code>e</code> é representada no código fonte pelo operador "e".
     * O operando esquerdo e o operando direito desta operação só podem ser expressões lógicas. Ao ser 
     * avaliada, esta operação retorna um valor lógico que obedece à seguinte tabela verdade:
     * <p>
     * <div class="userTable">
     *     <table>
     *        <col width="34%"/>
     *        <col width="34%"/>
     *        <col width="32%"/>
     *        <thead>
     *            <tr>
     *                <th>Operando Esquerdo</th><th>Operando Direito</th><th>Resultado</th>
     *            </tr>
     *        </thead>
     *        <tbody>
     *            <tr class="userTable_oddRow">
     *                <td>falso</td><td>falso</td><td>falso</td>
     *            </tr>
     *            <tr class="userTable_evenRow">
     *                <td>verdadeiro</td><td>falso</td><td>falso</td>
     *            </tr>
     *            <tr class="userTable_oddRow">
     *                <td>falso</td><td>verdadeiro</td><td>falso</td>
     *            </tr>
     *            <tr class="userTable_evenRow">
     *                <td>verdadeiro</td><td>verdadeiro</td><td>verdadeiro</td>
     *            </tr>
     *         </tbody>
     *      </table>
     * </div>
     * <p>
     * A operação <code>e</code> pode ser utilizada utilizada para realizar o controle de
     * laços de repetição e desvios condicionais.
     * 
     * @since 1.0
     */
    E("e", "e"),
    
    /**
     * Esta enumeração representa a operação lógica <code>ou</code> no código fonte.
     * <p>
     * A operação <code>ou</code> é uma operação lógica especial que equivale à operação booleana OR.
     * No Portugol, a operação <code>ou</code> é representada no código fonte pelo operador "ou".
     * O operando esquerdo e o operando direito desta operação só podem ser expressões lógicas. Ao ser 
     * avaliada, esta operação retorna um valor lógico que obeddec à seguinte tabela verdade:
     * <p>
     * <div class="userTable">
     *     <table>
     *        <col width="34%"/>
     *        <col width="34%"/>
     *        <col width="32%"/>
     *        <thead>
     *            <tr>
     *                <th>Operando Esquerdo</th><th>Operando Direito</th><th>Resultado</th>
     *            </tr>
     *        </thead>
     *        <tbody>
     *            <tr class="userTable_oddRow">
     *                <td>falso</td><td>falso</td><td>falso</td>
     *            </tr>
     *            <tr class="userTable_evenRow">
     *                <td>verdadeiro</td><td>falso</td><td>verdadeiro</td>
     *            </tr>
     *            <tr class="userTable_oddRow">
     *                <td>falso</td><td>verdadeiro</td><td>verdadeiro</td>
     *            </tr>
     *            <tr class="userTable_evenRow">
     *                <td>verdadeiro</td><td>verdadeiro</td><td>verdadeiro</td>
     *            </tr>
     *         </tbody>
     *      </table>
     * </div>
     * <p>
     * A operação <code>ou</code> pode ser utilizada utilizada para realizar o controle de
     * laços de repetição e desvios condicionais.
     * 
     * @since 1.0
     */    
    OU("ou", "ou"),
    
    /**
     * Esta enumeração representa a operação <code>maior</code> no código fonte.
     * <p>
     * A operação <code>maior</code> serve para verificar se uma expressão é maior que outra.
     * No Portugol, a operação <code>maior</code> é representada no código fonte pelo operador "&gt;".
     * <p>
     * A operação <code>maior</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
     * valor lógico: <code>verdadeiro</code> se a expressão à esquerda do operador for maior que à expressão
     * à direita do operador, caso contrário retorna <code>falso</code>.Pode ser utilizada para realizar o 
     * controle de laços de repetição e desvios condicionais.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */    
    MAIOR(">", "maior que"),
    

    /**
     * Esta enumeração representa a operação <code>maior-igual</code> no código fonte.
     * <p>
     * A operação <code>maior-igual</code> serve para verificar se uma expressão é maior ou igual a outra.
     * No Portugol, a operação <code>maior-igual</code> é representada no código fonte pelo operador "&gt;=".
     * <p>
     * A operação <code>maior-igual</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
     * valor lógico: <code>verdadeiro</code> se a expressão à esquerda do operador for maior ou igual à expressão
     * à direita do operador, caso contrário retorna <code>falso</code>.Pode ser utilizada para realizar o 
     * controle de laços de repetição e desvios condicionais.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */    
    MAIOR_IGUAL(">=", "maior igual"),
    
    /**
     * Esta enumeração representa a operação <code>menor</code> no código fonte.
     * <p>
     * A operação <code>menor</code>serve para verificar se uma expressão é maior que outra.
     * No Portugol, a operação <code>menor</code> é representada no código fonte pelo operador "&lt;".
     * <p>
     * A operação <code>menor</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
     * valor lógico: <code>verdadeiro</code> se a expressão à esquerda do operador for menor que à expressão
     * à direita do operador, caso contrário retorna <code>falso</code>.Pode ser utilizada para realizar o 
     * controle de laços de repetição e desvios condicionais.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */        
    MENOR("<", "menor que"),
    
    /**
     * Esta enumeração representa a operação <code>menor-igual</code> no código fonte.
     * <p>
     * A operação <code>menor-igual</code> serve para verificar se uma expressão é maior que outra.
     * No Portugol, a operação <code>menor-igual</code> é representada no código fonte pelo operador "&lt;=".
     * <p>
     * A operação <code>menor-igual</code> é uma operação lógica, e portanto, ao ser avaliada retorna um
     * valor lógico: <code>verdadeiro</code> se a expressão à esquerda do operador for menor ou igual á expressão
     * à direita do operador, caso contrário retorna <code>falso</code>.Pode ser utilizada para realizar o 
     * controle de laços de repetição e desvios condicionais.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    MENOR_IGUAL("<=", "menor igual"),
    

    /**
     * Esta enumeração representa a operação de <code>soma</code> no código fonte.
     * <p>
     * A operação de <code>soma</code> serve para unir duas expressões e é representada no código fonte pelo operador "+".
     * O resultado desta operação, depende do tipo de dado dos seus operandos.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    SOMA("+", "soma"),

    /**
     * Esta enumeração representa a operação de <code>soma-acumulativa</code> no código fonte.
     * <p>
     * A operação de <code>soma-acumulativa</code> combina as operações {@link Operacao#SOMA} e {@link Operacao#ATRIBUICAO} em
     * um única operação. Primeiro é relizada a soma entre o operando esquerdo e o operando direito, logo após, o resultado é
     * atribuído ao operando esquerdo. O operando esquerdo deverá obrigatoriamente ser uma referência de variável, vetor ou matriz.
     * <p>
     * No Portugol, a operação de <code>soma-acumulativa</code> é representada no código fonte pelo operador "+=".
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    SOMA_ACUMULATIVA("+=", "soma acumulativa"),
    
    /**
     * Esta enumeração representa a operação de <code>subtração</code> no código fonte.
     * <p>
     * A operação de <code>subtração</code> serve para obter a diferença entre duas expressões e é representada no código 
     * fonte pelo operador "-". O resultado desta operação, depende do tipo de dado dos seus operandos.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */    
    SUBTRACAO("-", "subtração"),
    
    /**
     * Esta enumeração representa a operação de <code>subtracao-acumulativa</code> no código fonte.
     * <p>
     * A operação de <code>subtracao-acumulativa</code> combina as operações {@link Operacao#SUBTRACAO} e {@link Operacao#ATRIBUICAO} em
     * um única operação. Primeiro é relizada a subtração entre o operando esquerdo e o operando direito, logo após, o resultado é
     * atribuído ao operando esquerdo. O operando esquerdo deverá obrigatoriamente ser uma referência de variável, vetor ou matriz.
     * <p>
     * No Portugol, a operação de <code>subtracao-acumulativa</code> é representada no código fonte pelo operador "-=".
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */    
    SUBTRACAO_ACUMULATIVA("-=", "subtração acumulativa"),
    
    /**
     * Esta enumeração representa a operação de <code>divisão</code> no código fonte e é representada pelo operador "/".
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */    
    DIVISAO("/", "divisão"),
    
    /**
     * Esta enumeração representa a operação de <code>divisao-acumulativa</code> no código fonte.
     * <p>
     * A operação de <code>divisao-acumulativa</code> combina as operações {@link Operacao#DIVISAO} e {@link Operacao#ATRIBUICAO} em
     * um única operação. Primeiro é relizada a divisão entre o operando esquerdo e o operando direito, logo após, o resultado é
     * atribuído ao operando esquerdo. O operando esquerdo deverá obrigatoriamente ser uma referência de variável, vetor ou matriz.
     * <p>
     * No Portugol, a operação de <code>divisao-acumulativa</code> é representada no código fonte pelo operador "/=".
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    DIVISAO_ACUMULATIVA("/=", "divisão acumulativa"),
    
    /**
     * Esta enumeração representa a operação de <code>multiplicação</code> no código fonte e é representada pelo operador "*".
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    MULTIPLICACAO("*", "multiplicação"),
    
    /**
     * Esta enumeração representa a operação de <code>mutiplicacao-acumulativa</code> no código fonte.
     * <p>
     * A operação de <code>multiplicacao-acumulativa</code> combina as operações {@link Operacao#MULTIPLICACAO} e {@link Operacao#ATRIBUICAO} em
     * um única operação. Primeiro é relizada a multiplicação entre o operando esquerdo e o operando direito, logo após, o resultado é
     * atribuído ao operando esquerdo. O operando esquerdo deverá obrigatoriamente ser uma referência de variável, vetor ou matriz.
     * <p>
     * No Portugol, a operação de <code>multiplicacao-acumulativa</code> é representada no código fonte pelo operador "*=".
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */        
    MULTIPLICACAO_ACUMULATIVA("*=", "multiplicação acumulativa"),
    
    /**
     * Esta enumeração representa a operação de <code>modulo</code> no código fonte.
     * <p>
     * A operação de <code>modulo</code> serve para obter o resto da divisão entre duas expressões e é representada no código 
     * fonte pelo operador "%". O resultado desta operação, depende do tipo de dado dos seus operandos.
     * <p>
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    MODULO("%", "módulo"),
    
    /**
     * Esta enumeração representa a operação de <code>modulo-acumulativo</code> no código fonte.
     * <p>
     * A operação de <code>modulo-acumulativo</code> combina as operações {@link Operacao#MODULO} e {@link Operacao#ATRIBUICAO} em
     * um única operação. Primeiro é relizada a operação de módulo entre o operando esquerdo e o operando direito, logo após, o 
     * resultado é atribuído ao operando esquerdo. O operando esquerdo deverá obrigatoriamente ser uma referência de variável, vetor 
     * ou matriz.
     * <p>
     * No Portugol, a operação de <code>modulo-acumulativo</code> é representada no código fonte pelo operador "%=".
     * Consulte o documento <a href='doc-files/compatibilidade_tipos.xls' target='blank'>Compatibilidade de tipos do Portugol</a> 
     * para verificar os tipos de dados que podem ser utlizados com esta operação e o resultado para cada tipo de dado.
     * 
     * @since 1.0
     */
    MODULO_ACUMULATIVO("%=", "módulo acumulativo"),
    
    /** 
     * Esta enumeração é utilizada pelo analisador semântico e pelo interpretador do Portugol apenas para indicar uma operação 
     * entre tipos incompatíveis, e portanto, não representa nenhuma operação no código fonte.
     * 
     * @since 1.0
     */    
    OPERACAO_INVALIDA(null, "Operação Inválida");
    
    private String operador;
    private String descricao;

    /**
     * 
     * @param operador      o operador que representa esta operação no código fonte.
     * @param descricao     a descrição desta operação.
     * @since 1.0
     */    
    private Operacao(String operador, String descricao)
    {
        this.operador = operador;
        this.descricao = descricao;
    }

    /**
     * Obtém uma operação a partir do operador associado á operação.
     * 
     * @param operator     o operador que representa esta operação no código fonte.
     * @return             a operação correspondente ao operador.
     * @since 1.0
     */
    public static Operacao obterOperacaoPeloOperador(String operator)
    {
        Operacao[] operacoes = values();

        for (Operacao operacao : operacoes)
        {
            if (operacao.operador.equals(operator))
            {
                return operacao;
            }
        }

        return Operacao.OPERACAO_INVALIDA;
    }

    @Override
    public String toString()
    {
        return descricao;
    }
}