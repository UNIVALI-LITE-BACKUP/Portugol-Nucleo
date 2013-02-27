package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;


public class ErroSimboloNaoFuncao extends ErroSemantico
{

    private final NoReferencia referencia;
    
    public ErroSimboloNaoFuncao(NoReferencia referencia)
    {
        super(referencia.getTrechoCodigoFonte().getLinha(), referencia.getTrechoCodigoFonte().getColuna());
        this.referencia = referencia;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        sb.append(referencia.getNome());
        sb.append("' não é uma função");
        return sb.toString();
    }
    
}
