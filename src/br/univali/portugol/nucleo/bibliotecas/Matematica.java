package br.univali.portugol.nucleo.bibliotecas;

import static br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca.*;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.math.BigDecimal;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca( tipo = COMPARTILHADA )
@DocumentacaoBiblioteca
(       
    descricao = "Esta biblioteca contém uma série das funções matemáticas mais comuns",
    versao = "1.0"
)
public final class Matematica extends Biblioteca
{
    public Matematica()
    {

    }

    @DocumentacaoConstante
    (            
        descricao = "Constante matemática que representa a relação entre o perímetro de uma circunferência e seu diâmetro, em outras palavras: perimetro/diâmetro",
        referencia = "http://pt.wikipedia.org/wiki/Pi"
    )
    public static final Double PI = Math.PI;
    
    @DocumentacaoFuncao
    (
        descricao = "Realiza uma exponenciação através da multiplicação da base por ela mesma tantas vezes quanto indicar o expoente",            
        parametros = 
        {
            @DocumentacaoParametro(nome = "base", descricao = "o número que será multiplicado"),
            @DocumentacaoParametro(nome = "expoente", descricao = "o número de vezes que a base será multiplicada")
        },        
        retorno = "A exponenciação da base pelo expoente",        
        referencia = "http://pt.wikipedia.org/wiki/Exponencia%C3%A7%C3%A3o",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )    
    public Double potencia(Double base, Double expoente) throws ErroExecucaoBiblioteca
    {
        return Math.pow(base, expoente);
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Realiza a radiciação (extrai a raíz) de um número por um determinado índice",        
        parametros = 
        {
            @DocumentacaoParametro(nome = "radicando", descricao = "o número do qual será extraída a raíz"),            
            @DocumentacaoParametro(nome = "indice", descricao = "indica o grau da radiciação. Quando o indice é 2 a raíz é quadrada, quando o indice é 3 a raíz é cúbica, e assim por diante")
        },        
        retorno = "a raíz do número informado",
        referencia = "http://pt.wikipedia.org/wiki/Radicia%C3%A7%C3%A3o",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Double raiz(Double radicando, Double indice) throws ErroExecucaoBiblioteca
    {
        return Math.pow(radicando, 1.0 / indice);
    }
    
    @DocumentacaoFuncao
    (
        descricao =             
            "Arredonda um número <tipo>real</tipo> para o número de casas decimais informado. " +
            "Quando o último dígito for maior ou igual a 5, o número será arredondado para cima, " +
            "quando o último dígito for menor que 5, o número será arredondado para baixo",
        
        parametros = 
        {
            @DocumentacaoParametro(nome = "numero", descricao = "o número que será arredondado"),
            @DocumentacaoParametro(nome = "casas", descricao = "o número de casas decimais após o arredondamento")
        },        
        retorno = "o número arredondado",
        referencia = "http://pt.wikipedia.org/wiki/Arredondamento",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }
    )
    public Double arredondar(Double numero, Integer casas) throws ErroExecucaoBiblioteca
    {
        BigDecimal decimal = new BigDecimal(numero);
        decimal = decimal.setScale(casas, BigDecimal.ROUND_HALF_UP);

        return decimal.doubleValue();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Calcula o seno do <param>ângulo</param> informado",
        parametros = 
        {
            @DocumentacaoParametro(nome = "angulo", descricao = "o ângulo para o qual será calculado o seno")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o seno do <param>ângulo</param> informado",
        referencia = "http://pt.wikipedia.org/wiki/Seno"            
    )
    public Double seno(Double angulo) throws ErroExecucaoBiblioteca
    {
        return Math.sin(angulo);
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Calcula o cosseno do <param>ângulo</param> informado",
        parametros = 
        {
            @DocumentacaoParametro(nome = "angulo", descricao = "o ângulo para o qual será calculado o cosseno")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o cosseno do <param>ângulo</param> informado",
        referencia = "http://pt.wikipedia.org/wiki/Cosseno"            
    )
    public Double cosseno(Double angulo) throws ErroExecucaoBiblioteca
    {
        return Math.cos(angulo);
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Calcula a tangente do <param>ângulo</param> informado",
        parametros = 
        {
            @DocumentacaoParametro(nome = "angulo", descricao = "o ângulo para o qual será calculada a tangente")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "a tagente do <param>ângulo</param> informado",
        referencia = "http://pt.wikipedia.org/wiki/Tangente"            
    )
    public Double tangente(Double angulo) throws ErroExecucaoBiblioteca
    {
        return Math.tan(angulo);
    }   
    
    @DocumentacaoFuncao
    (
        descricao = "Calcula o valor absoluto do <param>número</param> informado",
        parametros = 
        {
            @DocumentacaoParametro(nome = "numero", descricao = "o número para o qual será calculado o valor absoluto")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o valor absoluto do <param>número</param> informado",
        referencia = "http://pt.wikipedia.org/wiki/Fun%C3%A7%C3%A3o_modular"            
    )
    public Double valor_absoluto(Double numero) throws ErroExecucaoBiblioteca
    {
        return Math.abs(numero);
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Identifica o maior número entre os números informados",
        parametros = 
        {
            @DocumentacaoParametro(nome = "numeroA", descricao = "um número qualquer"),
            @DocumentacaoParametro(nome = "numeroB", descricao = "um número qualquer")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o maior número"
    )    
    public Double maior_numero(Double numeroA, Double numeroB) throws ErroExecucaoBiblioteca
    {
        return Math.max(numeroA, numeroB);
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Identifica o menor número entre os números informados",
        parametros = 
        {
            @DocumentacaoParametro(nome = "numeroA", descricao = "um número qualquer"),
            @DocumentacaoParametro(nome = "numeroB", descricao = "um número qualquer")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o menor número"
    )      
    public Double menor_numero(Double numeroA, Double numeroB) throws ErroExecucaoBiblioteca
    {
        return Math.min(numeroA, numeroB);
    }
}