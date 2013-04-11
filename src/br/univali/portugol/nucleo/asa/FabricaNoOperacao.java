package br.univali.portugol.nucleo.asa;


public final class FabricaNoOperacao
{
    public static NoOperacao novoNo(String operador, NoExpressao operandoEsquerdo, NoExpressao operandoDireito){
        if ("==".equals(operador))
            return new NoOperacaoLogicaIgualdade(operandoEsquerdo, operandoDireito);
        else
        if ("!=".equals(operador))
            return new NoOperacaoLogicaDiferenca(operandoEsquerdo, operandoDireito);
        else
        if ("=".equals(operador))
            return new NoOperacaoAtribuicao(operandoEsquerdo, operandoDireito);
        else
        if ("e".equals(operador))
            return new NoOperacaoLogicaE(operandoEsquerdo, operandoDireito);
        else
        if ("ou".equals(operador))
            return new NoOperacaoLogicaOU(operandoEsquerdo, operandoDireito);
        else
        if (">".equals(operador))
            return new NoOperacaoLogicaMaior(operandoEsquerdo, operandoDireito);
        else
        if (">=".equals(operador))
            return new NoOperacaoLogicaMaiorIgual(operandoEsquerdo, operandoDireito);
        else
        if ("<".equals(operador))
            return new NoOperacaoLogicaMenor(operandoEsquerdo, operandoDireito);
        else
        if ("<=".equals(operador))
            return new NoOperacaoLogicaMenorIgual(operandoEsquerdo, operandoDireito);
        else
        if ("+".equals(operador))
            return new NoOperacaoSoma(operandoEsquerdo, operandoDireito);
        else
        if ("-".equals(operador))
            return new NoOperacaoSubtracao(operandoEsquerdo, operandoDireito);
        else
        if ("/".equals(operador))
            return new NoOperacaoDivisao(operandoEsquerdo, operandoDireito);
        else
        if ("*".equals(operador))
            return new NoOperacaoMultiplicacao(operandoEsquerdo, operandoDireito);
        else
        if ("%".equals(operador))
            return new NoOperacaoModulo(operandoEsquerdo, operandoDireito);
        
        return null;
    }
}
