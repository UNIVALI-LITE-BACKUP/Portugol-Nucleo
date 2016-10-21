package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Util;

public class testeParametroPorReferencia extends Programa
{
    private final Util u = new Util();
    
    private final int[] REFERENCIAS = new int[4];
    private final int INDICE_A = 0;
    private final int INDICE_B = 1;
    private final int INDICE_I = 2;
    private final int INDICE_TESTE = 3;
    
    public testeParametroPorReferencia() throws ErroExecucao, InterruptedException
    {
        REFERENCIAS[INDICE_I] = -1;
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {  
        REFERENCIAS[INDICE_A] = 2;
        REFERENCIAS[INDICE_B] = 4;
        int m[][] = new int[2][2];
        int v[] = new int[3];
        
        int c = teste(INDICE_A, m, v) + teste(INDICE_B, m, v) * REFERENCIAS[INDICE_A] * REFERENCIAS[INDICE_B];
        c = teste(INDICE_I, m, v);
        c = u.numero_linhas(m);
        c = u.numero_elementos(v);
    }
    
    private int teste(int x, int matriz[][], int vetor[]) throws ErroExecucao, InterruptedException
    {
        REFERENCIAS[x] = REFERENCIAS[x] * 2;
        matriz[0][0] = matriz[0][0];
        vetor[0] = vetor[0];
        REFERENCIAS[INDICE_TESTE] = -1;
        outro_teste(matriz, vetor, INDICE_TESTE);
        return 1;
    }
    
    private void outro_teste(int m[][], int v[], int ref) throws ErroExecucao, InterruptedException
    {
        m[0][0] = v[0];
        v[0] = m[0][0];
    }
}
