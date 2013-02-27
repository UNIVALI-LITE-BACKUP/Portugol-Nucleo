package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

public class ErroCaracterInsperadoInvalido extends ErroSintatico
{
    private final String caracter;

    
    
    public ErroCaracterInsperadoInvalido(int linha, int coluna, String caracter)
    {
        super(linha, coluna);
        this.caracter = caracter;
    }

    
    
    @Override
    protected String construirMensagem()
    {
        return "O caracter '"+ caracter + "' está sendo utilizado de forma inesperada";
    }
    
}
