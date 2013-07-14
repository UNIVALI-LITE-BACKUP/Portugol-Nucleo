/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas.base;

public class Teste
{
    public static void main(String[] args) throws Exception
    {
        Class classeBiblioteca = Class.forName("br.univali.portugol.nucleo.bibliotecas.Matematica");
        MetaDadosBiblioteca md = new MetaDadosBiblioteca(classeBiblioteca);
        
        System.out.println(md.getTipo());
    }
}
