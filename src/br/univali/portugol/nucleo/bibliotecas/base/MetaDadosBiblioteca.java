package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.util.List;

/**
 * 
 * @author Luiz Fernando Noschang
 */
public final class MetaDadosBiblioteca
{
    private Class<? extends Biblioteca> classeBiblioteca;
    private List<MetaDadosFuncao> metaDadosFuncoes;
    
    MetaDadosBiblioteca(Class<? extends Biblioteca> classeBiblioteca)
    {
        this.classeBiblioteca = classeBiblioteca;
    }
    
    public DocumentacaoBiblioteca getDocumentacao()
    {
        return classeBiblioteca.getAnnotation(DocumentacaoBiblioteca.class);
    }
    
    public TipoBiblioteca getTipo()
    {
        return classeBiblioteca.getAnnotation(PropriedadesBiblioteca.class).tipo();
    }

    public List<MetaDadosFuncao> getMetaDadosFuncoes()
    {
        return metaDadosFuncoes;
    }

    void setMetaDadosFuncoes(List<MetaDadosFuncao> metaDadosFuncoes)
    {
        this.metaDadosFuncoes = metaDadosFuncoes;
    }
}
