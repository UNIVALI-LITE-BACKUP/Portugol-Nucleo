/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas;

/**
 *
 * @author Luiz Fernando
 */
public class TestDecimal
{
    public static void main(String[] args)
    {
        int decimalPlaces = 5;
        int factor = 1;
        
        for (int i = 1; i <= decimalPlaces; i++)
            factor *= 10;
        
        double num = 3.123456789123;
        
        double res = Math.round(num * factor) / factor;
        
        System.out.println("Res: " + res);
    }
}
