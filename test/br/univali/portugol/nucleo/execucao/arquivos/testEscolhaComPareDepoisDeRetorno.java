package br.univali.portugol.nucleo.execucao.arquivos;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testEscolhaComPareDepoisDeRetorno extends Programa
{

    public testEscolhaComPareDepoisDeRetorno() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        realizarParada(5, 2);
        teste();

    }

    private int teste() throws ErroExecucao, InterruptedException
    {
        realizarParada(10, 14);
        int x = 1;
        realizarParada(11, 11);
        switch (x)
        {
            case 0:
                realizarParada(13, 4);
                return 10;

        }

        realizarParada(16, 2);
        return 0;

    }

}
