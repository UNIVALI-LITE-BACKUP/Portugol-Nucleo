package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.util.regex.Pattern;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.COMPARTILHADA)
@DocumentacaoBiblioteca(descricao = "Esta biblioteca contém funções que permitem converter os tipos de dado do Portugol entre si", versao = "1.0")
public final class Tipos extends Biblioteca
{
    private static Pattern padraoInteiro = Pattern.compile("^-?\\d+$");
    private static Pattern padraoReal = Pattern.compile("^-?\\d+\\.\\d+$");
    private static Pattern padraoLogico = Pattern.compile("^verdadeiro|falso$");
    
    @DocumentacaoFuncao
    (
        descricao = "Verifica se a :cadeia passada por parâmetro representa um valor do tipo :inteiro",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia a ser verificada")
        },
        retorno = ":verdadeiro se a :cadeia representar um valor do tipo :inteiro, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean cadeia_e_inteiro(String cad) throws ErroExecucao
    {
        return padraoInteiro.matcher(cad).find();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Verifica se a :cadeia passada por parâmetro representa um valor do tipo :real",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia a ser verificada")
        },
        retorno = ":verdadeiro se a :cadeia representar um valor do tipo :real, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean cadeia_e_real(String cad) throws ErroExecucao
    {
        return padraoReal.matcher(cad).find();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Verifica se a :cadeia passada por parâmetro representa um valor do tipo :logico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia a ser verificada")
        },
        retorno = ":verdadeiro se a cadeia representar um valor do tipo :logico, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean cadeia_e_logico(String cad) throws ErroExecucao
    {
        return padraoLogico.matcher(cad).find();
    }

    @DocumentacaoFuncao
    (
        descricao = "Verifica se a :cadeia passada por parâmetro representa um valor do tipo :caracter",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia a ser verificada")
        },
        retorno = ":verdadeiro se a :cadeia representar um valor do tipo :caracter, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean cadeia_e_caracter(String cad) throws ErroExecucao
    {        
        return cad.length() == 1;
    }

    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :cadeia em um valor do tipo :caracter",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :caracter",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Character cadeia_para_caracter(String valor) throws ErroExecucao
    {        
        if (valor.length() == 1)
        {
            return valor.charAt(0);
        }
        
        throw new ErroExecucaoBiblioteca(String.format("o valor '%s' não é um caracter válido", valor));
    }

    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :cadeia em um valor do tipo :inteiro",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :inteiro",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Integer cadeia_para_inteiro(String valor) throws ErroExecucao
    {        
        try
        {
            return Integer.parseInt(valor);
        }
        catch (NumberFormatException ex)
        {
            throw new ErroExecucaoBiblioteca(String.format("o valor '%s' não é um número inteiro válido", valor));
        }
    }

    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :cadeia em um valor do tipo :real",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :real",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Double cadeia_para_real(String valor) throws ErroExecucao
    {        
        try
        {
            return Double.parseDouble(valor);
        }
        catch (NumberFormatException ex)
        {
            throw new ErroExecucaoBiblioteca(String.format("o valor '%s' não é um número real válido", valor));
        }
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :cadeia em um valor do tipo :logico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :logico",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean cadeia_para_logico(String valor) throws ErroExecucao
    {        
        if (valor.equals("verdadeiro"))
        {
            return true;
        }
        else if (valor.equals("falso"))
        {
            return false;
        }        
        
        throw new ErroExecucaoBiblioteca(String.format("o valor '%s' não é um valor lógico válido", valor));
    }

    @DocumentacaoFuncao
    (
        descricao = "Verifica se o :inteiro passado por parâmetro representa um valor do tipo :caracter",
        parametros = 
        {
            @DocumentacaoParametro(nome = "int", descricao = "o :inteiro a a ser verificado")
        },
        retorno = ":verdadeiro se o :inteiro representar um valor do tipo :caracter, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean inteiro_e_caracter(Integer _int) throws ErroExecucao
    {        
        return (_int >= 0 && _int <= 9);
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :inteiro em um valor do tipo :cadeia",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :cadeia",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String inteiro_para_cadeia(Integer valor) throws ErroExecucao
    {        
        return valor.toString();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :inteiro em um valor do tipo :caracter",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :caracter",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Character inteiro_para_caracter(Integer valor) throws ErroExecucao
    {        
        if (valor >= 0 && valor <= 9)
        {
            return valor.toString().charAt(0);
        }
        
        throw new ErroExecucaoBiblioteca(String.format("o valor '%d' não é um caracter válido", valor));
    }

    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :inteiro em um valor do tipo :logico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = ":falso se o valor for menor ou igual a 0, :verdadeiro se o valor for maior ou igual a 1",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean inteiro_para_logico(Integer valor) throws ErroExecucao
    {        
        if (valor <= 0)            
        {
            return false;
        }
        
        return true;
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :inteiro em um valor do tipo :real",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :real",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Double inteiro_para_real(Integer valor) throws ErroExecucao
    {        
        return valor.doubleValue();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Verifica se o :caracter passado por parâmetro representa um valor do tipo :inteiro",
        parametros = 
        {
            @DocumentacaoParametro(nome = "car", descricao = "o :caracter a ser verificado")
        },
        retorno = ":verdadeiro se o :caracter representar um valor do tipo :inteiro, caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean caracter_e_inteiro(Character car) throws ErroExecucao
    {        
        return cadeia_e_inteiro(new String(new char[]{ car }));
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Verifica se o :caracter passado por parâmetro representa um valor do tipo :logico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "car", descricao = "o :caracter a ser verificado")
        },
        retorno = ":verdadeiro se o :caracter for um dos seguintes valores: 'S', 's', 'N' ou 'n'. Caso contrário, retorna :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean caracter_e_logico(Character car) throws ErroExecucao
    {        
        return (car.equals('S') || car.equals('s') || car.equals('N') || car.equals('n'));
    }
    
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :caracter em um valor do tipo :cadeia",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :cadeia",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String caracter_para_cadeia(Character valor) throws ErroExecucao
    {        
        return new String(new char[]{ valor });
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :caracter em um valor do tipo :inteiro",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :caracter",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Integer caracter_para_inteiro(Character valor) throws ErroExecucao
    {
        return cadeia_para_inteiro(caracter_para_cadeia(valor));
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :caracter em um valor do tipo :logico",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = ":verdadeiro se o :caracter for um dos seguintes valores: 'S', 's'; :falso se o :caracter for um dos seguintes valores: 'N', 'n'",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Boolean caracter_para_logico(Character valor) throws ErroExecucao
    {
        if (valor.equals('S') || valor.equals('s'))
        {
            return true;
        }
        else if (valor.equals('N') || valor.equals('n'))
        {
            return false;
        }
        
        throw new ErroExecucaoBiblioteca(String.format("o valor '%s' não é um valor lógico válido", valor));
    }    

    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :logico em um valor do tipo :cadeia",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :cadeia",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String logico_para_cadeia(Boolean valor) throws ErroExecucao
    {
        return (valor)? "verdadeiro" : "falso";
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :logico em um valor do tipo :inteiro",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "1 se o valor passado por parâmetro for :verdadeiro, 0 se o valor passado por parâmetro for :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Integer logico_para_inteiro(Boolean valor) throws ErroExecucao
    {
        return (valor)? 1 : 0;
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :logico em um valor do tipo :caracter",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "'S' se o valor passado por parâmetro for :verdadeiro, 'N' se o valor passado por parâmetro for :falso",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Character logico_para_caracter(Boolean valor) throws ErroExecucao
    {
        return (valor)? 'S' : 'N';
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :real em um valor do tipo :cadeia",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :cadeia",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String real_para_cadeia(Double valor) throws ErroExecucao
    {        
        return valor.toString();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Converte um valor do tipo :real em um valor do tipo :inteiro. Se o valor :real tiver uma porção fracionária (Ex.: 9.56), o valor será truncado (Ex.: 9)",
        parametros = 
        {
            @DocumentacaoParametro(nome = "valor", descricao = "o valor a ser convertido")
        },
        retorno = "um valor do tipo :inteiro",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Integer real_para_inteiro(Double valor) throws ErroExecucao
    {        
        return valor.intValue();
    }
}
