package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeParametroPorReferencia extends Programa
{
    private final int[] REFERENCIAS = new int[2];
    private final int INDICE_A = 0;
    private final int INDICE_B = 1;
    
    public testeParametroPorReferencia() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {  
        REFERENCIAS[INDICE_A] = 2;
        REFERENCIAS[INDICE_B] = 4;
        int m[][] = new int[2][2];
        
        int c = teste(INDICE_A, m) + teste(INDICE_B, m) * REFERENCIAS[INDICE_A] * REFERENCIAS[INDICE_B];
    }
    
    private int teste(int x, int matriz[][]) throws ErroExecucao, InterruptedException
    {
        REFERENCIAS[x] = REFERENCIAS[x] * 2;
        matriz[0][0] = matriz[0][0];
        return 1;
    }
}
