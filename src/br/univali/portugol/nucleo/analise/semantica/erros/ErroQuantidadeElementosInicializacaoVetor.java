/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author fillipi
 */
public class ErroQuantidadeElementosInicializacaoVetor extends ErroSemantico
{
    private String nome;
    private int numeroElementosEsperados;
    private int numeroElementosDeclarados;

    public ErroQuantidadeElementosInicializacaoVetor(TrechoCodigoFonte trechoCodigoFonte, String nome, int numeroElementosEsperados, int numeroElementosDeclarados)
    {
        super(trechoCodigoFonte);
        
        this.nome = nome;
        this.numeroElementosEsperados = numeroElementosEsperados;
        this.numeroElementosDeclarados = numeroElementosDeclarados;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();

        construtorTexto.append("A inicialização do vetor \"");
        construtorTexto.append(nome);
        construtorTexto.append("\" deve possuir ");
        construtorTexto.append(numeroElementosEsperados);
        construtorTexto.append(" elemento");
        
        if (numeroElementosEsperados > 1)
        {
            construtorTexto.append("s");
        }
        
        int diferenca = 0;
        
        if (numeroElementosDeclarados > numeroElementosEsperados)
        {
            diferenca = numeroElementosDeclarados - numeroElementosEsperados;
            construtorTexto.append(", remova ");
        }
        else if (numeroElementosDeclarados < numeroElementosEsperados)
        {
            diferenca = numeroElementosEsperados - numeroElementosDeclarados;            
            construtorTexto.append(", insira mais ");
        }
        
        construtorTexto.append(diferenca);
        construtorTexto.append(" elemento");

            
        if (diferenca > 1)
        {
            construtorTexto.append("s");
        }
        
        construtorTexto.append(" para corrigir o problema");
        
        return construtorTexto.toString();
    }
    
}
