package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.TipoDado;
import java.lang.reflect.Field;

/**
 *
 * @author Luiz Fernando
 */
public final class ConstanteBiblioteca
{
    private Object valor;
    private String nome;
    private String descricao;
    private String referencia;
    private TipoDado tipoDado;

    ConstanteBiblioteca()
    {
    }

    public Object getValor()
    {
        return valor;
    }

    void setValor(Object valor)
    {
        this.valor = valor;
    }
    
    public String getNome()
    {
        return nome;
    }

    void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getReferencia()
    {
        return referencia;
    }

    void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public TipoDado getTipoDado()
    {
        return tipoDado;
    }

    void setTipoDado(TipoDado tipoDado)
    {
        this.tipoDado = tipoDado;
    }
}
