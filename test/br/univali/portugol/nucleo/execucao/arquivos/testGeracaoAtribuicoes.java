package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testGeracaoAtribuicoes extends Programa
{
    private boolean notas[][] =
    {
        {
            true, false
        },
        {
            false, false
        },
        {
            true, false
        }
    };

    public testGeracaoAtribuicoes() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        int x = (10 / 2);
        int a[] =
        {
            1, 2, 3
        };
        int u[] = new int[3];
        int v[][] = new int[2][2];
        int b[][] =
        {
            {
                1, 2, 3
            }, 
            {
                4, 5, 6
            }
        };
        int c = a[0];
        int d = b[0][1];
        int f = x;
        b[0][0] = 1;
        u[1] = 1;
    }
}
