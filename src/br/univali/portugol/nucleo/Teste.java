/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.portugol.nucleo;

import java.io.File;

import br.univali.portugol.nucleo.excecoes.ExcecaoArquivoContemErros;
import br.univali.portugol.nucleo.excecoes.ListaMensagens;
import br.univali.portugol.nucleo.excecoes.Mensagem;

/**
 *
 * @author Luiz Fernando
 */
public class Teste
{
    public static void main(String[] args) throws ExcecaoArquivoContemErros
    {
       AnalizadorSemantico as = new AnalizadorSemantico(new File("examples/tiposVariaveis.por"));
       
       ListaMensagens listaMensagens = as.analizar();
       
       for (Mensagem mensagem : listaMensagens) {
    	   System.out.println(mensagem);    	   
       }

       
    }
}
