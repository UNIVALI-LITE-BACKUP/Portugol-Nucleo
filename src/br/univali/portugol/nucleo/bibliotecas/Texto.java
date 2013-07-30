package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ReferenciaVetor;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.COMPARTILHADA)
@DocumentacaoBiblioteca(descricao = "Esta biblioteca contém funções para manipulação de texto (dados do tipo :cadeia)", versao = "1.0")
public final class Texto extends Biblioteca
{
    @DocumentacaoFuncao
    (
        descricao = "Conta o número de caracteres existentes em uma :cadeia",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cadeia", descricao = "um valor qualquer do tipo :cadeia")
        },
        retorno = "o número de caracteres na :cadeia",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public Integer numero_caracteres(String cadeia) throws ErroExecucao
    {
        return cadeia.length();
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Transforma os caracteres de uma :cadeia em caracteres maiúsculos",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "um valor qualquer do tipo :cadeia")
        },
        retorno = "a :cadeia com os caracteres transformados",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String caracteres_maiusculos(String cad) throws ErroExecucao
    {
        return cad.toUpperCase();
    }    
    
    @DocumentacaoFuncao
    (
        descricao = "Transforma os caracteres de uma :cadeia em caracteres minúsculos",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "um valor qualquer do tipo :cadeia")
        },
        retorno = "a :cadeia com os caracteres transformados",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String caracteres_minusculos(String cad) throws ErroExecucao
    {
        return cad.toLowerCase();
    }

    @DocumentacaoFuncao
    (
        descricao = "Pesquisa por um determinado texto em uma :cadeia e substitui todas as ocorrências por um texto alternativo",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia que será pesquisada"),
            @DocumentacaoParametro(nome = "texto_pesquisa", descricao = "o texto que será pesquisado na :cadeia"),
            @DocumentacaoParametro(nome = "texto_substituto", descricao = "o texto pelo qual as ocorrências serão substituídas")
        },
        retorno = "a :cadeia resultante da substituição",
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public String substituir(String cad, String texto_pesquisa, String texto_substituto) throws ErroExecucao
    {
        return cad.replace(texto_pesquisa, texto_substituto);
    }

    @DocumentacaoFuncao
    (
        descricao = "Copia os caracteres de uma :cadeia para um vetor. O vetor para onde os caracteres serão copiados, deve ter exatamente o mesmo tamanho da :cadeia informada",
        parametros = 
        {
            @DocumentacaoParametro(nome = "cad", descricao = "a :cadeia que terá os caracteres copiados"),
            @DocumentacaoParametro(nome = "vetor", descricao = "o vetor que receberá os caracteres copiados")
        },
        autores = 
        {
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        }        
    )    
    public void copiar_caracteres(String cad, ReferenciaVetor<Character> vetor) throws ErroExecucao
    {
        if (cad.length() > 0)
        {
            if (vetor.numeroElementos() == cad.length())
            {

            }
            
            else throw new ErroExecucaoBiblioteca(String.format("Erro ao copiar os caracteres da cadeia. O tamanho do vetor (%d) é diferente do tamanho da cadeia (%d)", vetor.numeroElementos(), cad.length()));
        }
        
        else throw new ErroExecucaoBiblioteca("Erro ao copiar os caracteres da cadeia. A cadeia não possui caracteres");        
    }    
}
