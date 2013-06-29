
package br.univali.portugol.nucleo.analise;

import br.univali.portugol.nucleo.mensagens.Aviso;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.Erro;
import br.univali.portugol.nucleo.mensagens.ErroAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import br.univali.portugol.nucleo.simbolos.TabelaSimbolos;
import java.util.ArrayList;
import java.util.List;

/**
 * Guarda informações sobre os erros ocorridos e os avisos gerados durante a análise 
 * de um código fonte.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see Aviso
 * @see Erro
 * @see ErroSemantico
 * @see ErroSintatico
 */
public final class ResultadoAnalise
{   
    private List<ErroAnalise> erros = null;
    private List<ErroSintatico> errosSintaticos = null;
    private List<ErroSemantico> errosSemanticos = null;
    
    private List<AvisoAnalise> avisos = null;
    
    private TabelaSimbolos tabelaSimbolos;
    
    public ResultadoAnalise()
    {
        erros = new ArrayList<ErroAnalise>();
        errosSintaticos = new ArrayList<ErroSintatico>();
        errosSemanticos = new ArrayList<ErroSemantico>();
        
        avisos = new ArrayList<AvisoAnalise>();
    }

    public TabelaSimbolos getTabelaSimbolos()
    {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(TabelaSimbolos tabelaSimbolos)
    {
        this.tabelaSimbolos = tabelaSimbolos;
    }
    
    
    
    /**
     * Permite adicionar um aviso ao resultado da análise
     * 
     * @param aviso     o aviso gerado durante a análise.
     * @since 1.0
     */
    void adicionarAviso(AvisoAnalise aviso)
    {
        avisos.add(aviso);
    }

    /**
     * Permite adicionar um erro ao resultado da análise.
     * 
     * @param erro     o erro gerado durante a análise.
     * @since 1.0
     */    
    void adicionarErro(ErroAnalise erro)
    {
        erros.add(erro);
        
        if (erro instanceof ErroSintatico) errosSintaticos.add((ErroSintatico) erro);
        else
        if (erro instanceof ErroSemantico) errosSemanticos.add((ErroSemantico) erro);
    }
    
    /**
     * Obtém o número total de erros ocorridos durante a análise do código fonte.
     * 
     * @return     o número total de erros ocorridos durante a análise do código fonte.
     * @since 1.0
     */    
    public int getNumeroTotalErros()
    {
        return erros.size();
    }
    
    /**
     * Obtém o número de erros sintáticos ocorridos durante a análise do código fonte.
     * 
     * @return     o número de erros sintáticos ocorridos durante a análise do código fonte.
     * @since 1.0
     */    
    public int getNumeroErrosSintaticos()
    {
        return errosSintaticos.size();
    }
    
    /**
     * Obtém o número de erros semânticos ocorridos durante a análise do código fonte.
     * 
     * @return     o número de erros semânticos ocorridos durante a análise do código fonte.
     * @since 1.0
     */        
    public int getNumeroErrosSemanticos()
    {        
        return errosSemanticos.size();
    }
    
    /**
     * Obtém o número de avisos gerados durante a análise do código fonte.
     * 
     * @return     o número de avisos gerados durante a análise do código fonte.
     * @since 1.0
     */        
    public int getNumeroAvisos()
    {
        return avisos.size();
    }

    
    /**
     * Obtém a lista de erros ocorridos durante a análise do código fonte.
     * 
     * @return     a lista de erros ocorridos durante a análise do código fonte.
     * @since 1.0
     */    
    public List<ErroAnalise> getErros()
    {
        return erros;
    }

    /**
     * Obtém a lista dos avisos gerados durante a análise do código fonte.
     * 
     * @return     a lista dos avisos gerados durante a análise do código fonte.
     * @since 1.0
     */
    public List<AvisoAnalise> getAvisos()
    {
        return avisos;
    }

    /**
     * Obtém a lista de erros sintáticos ocorridos durante a análise do código fonte.
     * 
     * @return     a lista de erros sintáticos ocorridos durante a análise do código fonte.
     * @since 1.0
     */        
    public List<ErroSintatico> getErrosSintaticos()
    {
        return errosSintaticos;
    }

    /**
     * Obtém a lista de erros semânticos ocorridos durante a análise do código fonte.
     * 
     * @return     a lista de erros semânticos ocorridos durante a análise do código fonte.
     * @since 1.0
     */        
    public List<ErroSemantico> getErrosSemanticos()
    {
        return errosSemanticos;
    }
}