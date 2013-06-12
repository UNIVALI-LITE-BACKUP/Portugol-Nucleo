/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Simbolo;

/**
 *
 * @author fillipi
 */
public class ErroSimboloNaoInicializado extends ErroSemantico
{
    private final Simbolo simbolo;
    private final NoReferencia noReferenciaVariavel;

    public ErroSimboloNaoInicializado(NoReferencia noReferenciaVariavel, Simbolo simbolo)
    {
        super(noReferenciaVariavel.getTrechoCodigoFonteNome().getLinha(),
                noReferenciaVariavel.getTrechoCodigoFonteNome().getColuna());
        this.noReferenciaVariavel = noReferenciaVariavel;
        this.simbolo = simbolo;
        
    }

    @Override
    protected String construirMensagem()
    {
        return "\""+ simbolo.getNome() + "\" não foi inicializado";
    }
    
}
