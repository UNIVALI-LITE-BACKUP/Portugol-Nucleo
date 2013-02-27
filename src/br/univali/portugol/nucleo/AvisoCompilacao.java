package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.mensagens.Aviso;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import java.util.List;


public class AvisoCompilacao extends Aviso
{
    
    private ResultadoAnalise resultadoAnalise;


    public AvisoCompilacao(ResultadoAnalise resultadoAnalise)
    {
    }

    @Override
    protected String construirMensagem()
    {
        return "O programa foi compilado, mas possui avisos";
    }
    
    public List<AvisoAnalise> getAvisos(){
        return resultadoAnalise.getAvisos();
    }
    
}
