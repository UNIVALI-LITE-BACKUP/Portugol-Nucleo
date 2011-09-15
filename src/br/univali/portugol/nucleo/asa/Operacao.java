package br.univali.portugol.nucleo.asa;

public enum Operacao
{	
    IGUALDADE ("==", "igualdade"),
    DIFERENCA ("!=", "diferençaa"),
    ATRIBUICAO ("=", "atribuição"),
    E ("e", "e"),
    OU ("ou", "ou"),
    MAIOR (">",	"maior que"),
    MAIOR_IGUAL (">=", "maior igual"),
    MENOR ("<",	"menor que"),
    MENOR_IGUAL ("<=", "menor igual"),
    SOMA ("+", "soma"),
    SOMA_ACUMULATIVA ("+=", "soma acumulativa"),
    SUBTRACAO ("-",	"subtração"),
    SUBTRACAO_ACUMULATIVA ("-=",	"subtração acumulativa"),
    DIVISAO ("/", "divisão"),
    DIVISAO_ACUMULATIVA ("/=", "divisão acumulativa"),
    MULTIPLICACAO ("*", "multiplicação"),
    MULTIPLICACAO_ACUMULATIVA ("*=", "multiplicação acumulativa"),
    MODULO ("%", "módulo"),
    MODULO_ATRIBUITIVO ("%=", "módulo acumulativo"),
    OPERACAO_INVALIDA (null, "Operação Inválida");
	
	
    private String operador;
    private String descricao;

    private Operacao(String operador, String descricao)
    {
        this.operador = operador;
        this.descricao = descricao;
    }

    public static Operacao obterOperacaoPeloOperador(String operator)
    {
        Operacao[] operacoes = values();

        for (Operacao operacao: operacoes)
            if (operacao.operador.equals(operator))
                return operacao;

        return Operacao.OPERACAO_INVALIDA;
    }

    @Override
    public String toString()
    {
        return descricao;
    }
}