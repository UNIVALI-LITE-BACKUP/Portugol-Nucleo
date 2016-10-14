package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testGeracaoLoopPara extends Programa
{

    public testGeracaoLoopPara() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        for (int i = 10; i >= 0; i = i - 1)
        {
            escreva(i);
        }
    }
}
