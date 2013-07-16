package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 */
public final class MetaDadosBiblioteca
{
    private String nome;
    private TipoBiblioteca tipo;
    private DocumentacaoBiblioteca documentacao;
    private List<MetaDadosFuncao> metaDadosFuncoes;
    private List<MetaDadosConstante> metaDadosConstantes;
    
    MetaDadosBiblioteca()
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
    
    public TipoBiblioteca getTipo()
    {
        return tipo;
    }

    void setTipo(TipoBiblioteca tipo)
    {
        this.tipo = tipo;
    }
    
    public DocumentacaoBiblioteca getDocumentacao()
    {
        return documentacao;
    }

    void setDocumentacao(DocumentacaoBiblioteca documentacao)
    {
        this.documentacao = documentacao;
    }
  
    public List<MetaDadosFuncao> getMetaDadosFuncoes()
    {
        return new ArrayList<MetaDadosFuncao>(metaDadosFuncoes);
    }

    void setMetaDadosFuncoes(List<MetaDadosFuncao> metaDadosFuncoes)
    {
        this.metaDadosFuncoes = metaDadosFuncoes;
    }

    public List<MetaDadosConstante> getMetaDadosConstantes()
    {
        return metaDadosConstantes;
    }

    void setMetaDadosConstantes(List<MetaDadosConstante> metaDadosConstantes)
    {
        this.metaDadosConstantes = metaDadosConstantes;
    }
}
