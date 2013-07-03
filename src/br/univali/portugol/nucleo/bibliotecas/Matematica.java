package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.ExportarFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.ExportarVariavel;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Parametro;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class Matematica extends Biblioteca
{
    public Matematica() throws Exception
    {
        super();
    }

    @Override
    public String getNome()
    {
        return "Matematica";
    }
    
    @ExportarVariavel
    (
        descricao = "Constante matemática que representa a relação entre o perímetro de uma circunferência e seu diâmetro, em outras palavras: perimetro/diâmetro",
        referencia = "http://pt.wikipedia.org/wiki/Pi"
    )
    public final Double PI = Math.PI;
    
    @ExportarFuncao
    (
        descricao = "Realiza uma exponenciação através da multiplicação da base por ela mesma tantas vezes quanto indicar o expoente",            
        parametros = 
        {
            @Parametro(nome = "base", descricao = "o número que será multiplicado"),
            @Parametro(nome = "expoente", descricao = "o número de vezes que a base será multiplicada")
        },        
        retorno = "A exponenciação da base pelo expoente",        
        referencia = "http://pt.wikipedia.org/wiki/Exponencia%C3%A7%C3%A3o"
    )    
    public Double potencia(Double base, Double expoente)
    {
        return Math.pow(base, expoente);
    }
    
    @ExportarFuncao
    (
        descricao = "Realiza a radiciação (extrai a raíz) de um número por um determinado índice",        
        parametros = 
        {
            @Parametro(nome = "radicando", descricao = "o número do qual será extraída a raíz"),            
            @Parametro(nome = "indice", descricao = "indica o grau da radiciação. Quando o indice é 2 a raíz é quadrada, quando o indice é 3 a raíz é cúbica, e assim por diante")
        },        
        retorno = "a raíz do número informado",        
        referencia = ""
    )
    public Double raiz(Double radicando, Double indice)
    {
        return Math.pow(radicando, 1.0 / indice);
    }
}
