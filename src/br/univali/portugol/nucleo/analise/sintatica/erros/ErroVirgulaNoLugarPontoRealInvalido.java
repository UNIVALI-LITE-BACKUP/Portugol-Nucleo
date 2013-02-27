package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

public class ErroVirgulaNoLugarPontoRealInvalido extends ErroSintatico
{

    
    public ErroVirgulaNoLugarPontoRealInvalido(int linha, int coluna)
    {
        super(linha, coluna);
    }

    
    
    @Override
    protected String construirMensagem()
    {
        return "Numeros reais devem ser separados com o caracter '.' (ponto)";
    }
    
}
