package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeCodigoParaVariaveisInspecionadas extends Programa
{
    
    
    public testeCodigoParaVariaveisInspecionadas() throws ErroExecucao, InterruptedException
    {
        variaveisInspecionadas = new Object[1];
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        int x = 1;
        if (variaveisInspecionadas[0] != null) 
        {
            variaveisInspecionadas[0] = x; 
        }
        
        x = 2;
        if (variaveisInspecionadas[0] != null) 
        {
            variaveisInspecionadas[0] = x; 
        }
    }
}
