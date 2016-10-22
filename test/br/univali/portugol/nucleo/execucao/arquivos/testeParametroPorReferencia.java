package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Util;

public class testeParametroPorReferencia extends Programa
{
    private final Util u = new Util();
    
    private final int[] REFS_INT = new int[5];
    private final double[] REFS_DOUBLE = new double[1];
    private final boolean[] REFS_BOOLEAN = new boolean[1];
    private final char[] REFS_CHAR = new char[1];
    private final String[] REFS_STRING = new String[1];
    
    private final int INDICE_A = 0;
    private final int INDICE_B = 1;
    private final int INDICE_I = 2;
    private final int INDICE_NUMERO_INTEIRO = 3;
    private final int INDICE_TESTE = 4;
    
    private final int INDICE_R = 0;
    
    private final int INDICE_LOG = 0;    
    
    private final int INDICE_CARAC = 0;

    private final int INDICE_X = 0;    
    
    public testeParametroPorReferencia() throws ErroExecucao, InterruptedException
    {
        REFS_INT[INDICE_I] = -1;
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {  
        REFS_INT[INDICE_A] = 2;
        REFS_INT[INDICE_B] = 4;
        int m[][] = new int[2][2];
        int v[] = new int[3];
        
        int c = teste(INDICE_A, m, v) + teste(INDICE_B, m, v) * REFS_INT[INDICE_A] * REFS_INT[INDICE_B];
        c = teste(INDICE_I, m, v);
        c = u.numero_linhas(m);
        c = u.numero_elementos(v);
        
        REFS_STRING[INDICE_X] = "asd";
        REFS_INT[INDICE_NUMERO_INTEIRO] = 0;
        REFS_DOUBLE[INDICE_R] = 1.0;
        REFS_CHAR[INDICE_CARAC] = 'b';
        REFS_BOOLEAN[INDICE_LOG] = false;
        teste_tipos(INDICE_X, INDICE_NUMERO_INTEIRO, INDICE_R, INDICE_CARAC, INDICE_LOG);        
    }
    
    private int teste(int x, int matriz[][], int vetor[]) throws ErroExecucao, InterruptedException
    {
        REFS_INT[x] = REFS_INT[x] * 2;
        matriz[0][0] = matriz[0][0];
        vetor[0] = vetor[0];
        REFS_INT[INDICE_TESTE] = -1;
        outro_teste(matriz, vetor, INDICE_TESTE);
        return 1;
    }
    
    private void outro_teste(int m[][], int v[], int ref) throws ErroExecucao, InterruptedException
    {
        m[0][0] = v[0];
        v[0] = m[0][0];
    }
    
    private void teste_tipos(int c, int i, int r, int car, int l) throws ErroExecucao, InterruptedException
    {
        REFS_STRING[c] = "asd";
        REFS_INT[i] = 10;
        REFS_DOUBLE[r] = 10.0;
        REFS_CHAR[car] = 'a';
        REFS_BOOLEAN[l] = true;
    }
}
