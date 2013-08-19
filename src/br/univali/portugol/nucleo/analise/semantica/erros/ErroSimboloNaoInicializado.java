/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

/**
 *
 * @author fillipi
 */
public class ErroSimboloNaoInicializado extends ErroSemantico
{
    private final Simbolo simbolo;
    private final NoReferencia noReferencia;

    public ErroSimboloNaoInicializado(NoReferencia noReferencia, Simbolo simbolo)
    {
        super(noReferencia.getTrechoCodigoFonteNome());
        this.noReferencia = noReferencia;
        this.simbolo = simbolo;        
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        if (simbolo instanceof Variavel)
        {
            construtorTexto.append("A variável \"");
            construtorTexto.append(simbolo.getNome());
            construtorTexto.append("\" não foi inicializada");
        }
        else if (simbolo instanceof Vetor)
        {
            construtorTexto.append("O vetor \"");
            construtorTexto.append(simbolo.getNome());
            construtorTexto.append("\" não foi inicializado");
        }
        else if (simbolo instanceof Matriz)
        {
            construtorTexto.append("A matriz \"");
            construtorTexto.append(simbolo.getNome());
            construtorTexto.append("\" não foi inicializada");
        }
        
        return construtorTexto.toString();                
    }
    
}
