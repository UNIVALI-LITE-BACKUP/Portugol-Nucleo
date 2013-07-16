package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class MetaDadosFuncao
{
    private String nome;
    private TipoDado tipoDado;
    private Quantificador quantificador;
    private DocumentacaoFuncao documentacao;
    private List<MetaDadosParametro> metaDadosParametros;    

    MetaDadosFuncao()
    {
        
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
    
    public DocumentacaoFuncao getDocumentacao()
    {
        return documentacao;
    }

    void setDocumentacao(DocumentacaoFuncao documentacao)
    {
        this.documentacao = documentacao;
    }    

    public List<MetaDadosParametro> getMetaDadosParametros()
    {
        return new ArrayList<MetaDadosParametro>(metaDadosParametros);
    }

    void setMetaDadosParametros(List<MetaDadosParametro> metaDadosParametros)
    {
        this.metaDadosParametros = metaDadosParametros;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof MetaDadosFuncao)
        {
            return ((MetaDadosFuncao) obj).nome.equals(this.nome);
        }
        
        return false;
    }

    @Override
    public int hashCode()
    {
        return 89 * 7 + (this.nome != null ? this.nome.hashCode() : 0);
    }
}
