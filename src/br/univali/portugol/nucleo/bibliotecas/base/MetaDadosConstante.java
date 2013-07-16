package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class MetaDadosConstante
{
    private Object valor;
    private String nome;
    private TipoDado tipoDado;
    private Quantificador quantificador;
    private DocumentacaoConstante documentacao;

    MetaDadosConstante()
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

    public TipoDado getTipoDado()
    {
        return tipoDado;
    }

    void setTipoDado(TipoDado tipoDado)
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

    public DocumentacaoConstante getDocumentacao()
    {
        return documentacao;
    }

    void setDocumentacao(DocumentacaoConstante documentacao)
    {
        this.documentacao = documentacao;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof MetaDadosConstante)
        {
            return ((MetaDadosConstante) obj).nome.equals(this.nome);
        }
        
        return false;
    }

    @Override
    public int hashCode()
    {
        return 83 * 7 + (this.nome != null ? this.nome.hashCode() : 0);
    }    
}
