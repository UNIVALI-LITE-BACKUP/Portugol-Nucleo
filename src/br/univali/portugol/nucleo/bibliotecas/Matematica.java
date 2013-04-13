package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.Exportar;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class Matematica extends Biblioteca
{
    public Matematica() throws Exception
    {
        
    }
    
    @Exportar
    public final Double PI = Math.PI;
    
    @Exportar
    public Double potencia(Double base, Double expoente)
    {
        return Math.pow(base, expoente); 
    }
    
    public Double raiz(Double valor)
    {
        return Math.sqrt(valor);
    }
    
}
