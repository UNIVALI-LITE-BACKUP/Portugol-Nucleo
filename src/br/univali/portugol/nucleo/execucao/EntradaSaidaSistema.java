package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.asa.TipoDado;
import java.util.Scanner;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class EntradaSaidaSistema implements Entrada, Saida
{
    public EntradaSaidaSistema()
    {
        
    }
    
    @Override
    public Object ler(TipoDado tipoDado) throws Exception
    {
        Scanner in = new Scanner(System.in);
        
        switch (tipoDado)
        {
            case CADEIA : return in.next();
            case CARACTER : return in.next().charAt(0);
            case INTEIRO : return in.nextInt();
            case LOGICO : String s = in.next(); return s.equals("verdadeiro")? true : s.equals("falso")? false : null;
            case REAL : in.nextDouble();
        }
        
        return null;
    }

    @Override
    public void limpar() throws Exception
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println("");
        }
    }

    @Override
    public void escrever(String valor) throws Exception
    {
        System.out.print(valor);
    }

    @Override
    public void escrever(boolean valor) throws Exception
    {
        System.out.print(valor? "verdadeiro" : "falso");
    }

    @Override
    public void escrever(int valor) throws Exception
    {
        System.out.print(valor);
    }

    @Override
    public void escrever(double valor) throws Exception
    {
        System.out.print(valor);
    }

    @Override
    public void escrever(char valor) throws Exception
    {
        System.out.print(valor);
    }    
}
