package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import java.lang.reflect.Method;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class FuncaoBiblioteca
{
    private Method funcao;
    private String nome;
    private String descricao;
    private String referencia;
    private TipoDado tipoDado;
    private Quantificador quantificador;
    
    FuncaoBiblioteca()
    {
    }

    public Method getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Method funcao)
    {
        this.funcao = funcao;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getReferencia()
    {
        return referencia;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public TipoDado getTipoDado()
    {
        return tipoDado;
    }

    public void setTipoDado(TipoDado tipoDado)
    {
        this.tipoDado = tipoDado;
    }

    public Quantificador getQuantificador()
    {
        return quantificador;
    }

    void setQuantificador(Quantificador quantificador)
    {
        this.quantificador = quantificador;
    }
}
