
package br.univali.portugol.nucleo.analise;

import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.mensagens.ErroAnalise;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ResultadoAnalise
{   
    private List<ErroAnalise> erros = null;
    private List<ErroSintatico> errosSintaticos = null;
    private List<ErroSemantico> errosSemanticos = null;
    
    private List<AvisoAnalise> avisos = null;
    
    public ResultadoAnalise()
    {
        erros = new ArrayList<ErroAnalise>();
        errosSintaticos = new ArrayList<ErroSintatico>();
        errosSemanticos = new ArrayList<ErroSemantico>();
        
        avisos = new ArrayList<AvisoAnalise>();
    }
    
    void adicionarAviso(AvisoAnalise aviso)
    {
        avisos.add(aviso);
    }
    
    void adicionarErro(ErroAnalise erro)
    {
        erros.add(erro);
        
        if (erro instanceof ErroSintatico) errosSintaticos.add((ErroSintatico) erro);
        else
        if (erro instanceof ErroSemantico) errosSemanticos.add((ErroSemantico) erro);
    }
    
    public int getNumeroTotalErros()
    {
        return erros.size();
    }
    
    public int getNumeroErrosSintaticos()
    {
        return errosSintaticos.size();
    }
    
    public int getNumeroErrosSemanticos()
    {        
        return errosSemanticos.size();
    }
    
    public int getNumeroAvisos()
    {
        return avisos.size();
    }

    public List<ErroAnalise> getErros()
    {
        return erros;
    }

    public List<AvisoAnalise> getAvisos()
    {
        return avisos;
    }

    public List<ErroSintatico> getErrosSintaticos()
    {
        return errosSintaticos;
    }

    public List<ErroSemantico> getErrosSemanticos()
    {
        return errosSemanticos;
    }
}