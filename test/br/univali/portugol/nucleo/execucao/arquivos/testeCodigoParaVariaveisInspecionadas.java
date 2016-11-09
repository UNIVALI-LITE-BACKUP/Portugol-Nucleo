package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeCodigoParaVariaveisInspecionadas extends Programa
{
    
    
    public testeCodigoParaVariaveisInspecionadas() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        int x = 1;
        if (variaveisInspecionadas.containsKey(4)) 
        {
            variaveisInspecionadas.replace(4, x); 
        }
        
        x = 2;
        if (variaveisInspecionadas.containsKey(4))
        {
            variaveisInspecionadas.replace(4, x);
        }
    }
}
