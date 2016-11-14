package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeCodigoParaVariaveisInspecionadas extends Programa
{
    
    
    public testeCodigoParaVariaveisInspecionadas() throws ErroExecucao, InterruptedException
    {
        variaveisInspecionadas = new Object[3];
        vetoresInspecionados = new Vetor[2];
        matrizesInspecionadas = new Matriz[2];
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
        
        
        int y;
        y = 10;
        if (variaveisInspecionadas[1] != null)
        {
            variaveisInspecionadas[1] = y;
        }
        
        int vetor[] = {1, 2, 3};
        
        if (vetoresInspecionados[0] != null)
        {
            for (int i = 0; i < vetoresInspecionados[0].tamanho; i++)
            {
                vetoresInspecionados[0].setValor(vetor[i], i);
            }
        }

        
        vetor[1] = 45;
        
        if (vetoresInspecionados[0] != null)
        {
            vetoresInspecionados[0].setValor(vetor[1], 1);
        }
        
        int matriz[][] = {{1, 2}, {3, 4}};
        if (matrizesInspecionadas[0] != null)
        {
            for (int i = 0; i < matrizesInspecionadas[0].linhas; i++)
            {
                for (int j = 0; j < matrizesInspecionadas[0].colunas; j++)
                {
                    matrizesInspecionadas[0].setValor(matriz[i][j], i, j);
                }
            }
        }
        
        matriz[0][1] = 100;
        if (matrizesInspecionadas[0] != null)
        {
            matrizesInspecionadas[0].setValor(matriz[0][1], 0, 1);
        }
        
        if (variaveisInspecionadas[2] != null)
        {
            variaveisInspecionadas[2] = x;
        }
        
        if (vetoresInspecionados[1] != null)
        {
            if (vetoresInspecionados[1].tamanho != vetor.length)
            {
                inspecionaVetor(1, vetor.length);
            }
            for (int i = 0; i < vetoresInspecionados[1].tamanho; i++)
            {
                vetoresInspecionados[1].setValor(vetor[i], i);
            }
        }
        
        if (matrizesInspecionadas[1] != null)
        {
            if (matrizesInspecionadas[1].linhas != matriz.length)
            {
                inspecionaMatriz(1, matriz.length, matriz[0].length);
            }
            for (int i = 0; i < matrizesInspecionadas[1].linhas; i++)
            {
                for (int j = 0; j < matrizesInspecionadas[1].colunas; j++)
                {
                    matrizesInspecionadas[1].setValor(matriz[i][j], i, j);
                }
            }
        }
        
        teste(x, vetor, matriz);
    }
    
    private void teste(int a, int v[], int m[][]) throws ErroExecucao, InterruptedException
    {
        a = a + 1;
        if (variaveisInspecionadas[2] != null)
        {
            variaveisInspecionadas[2] = a;
        }
        
        v[0] = 1;
        if (vetoresInspecionados[1] != null)
        {
            vetoresInspecionados[1].setValor(v[0], 0);
        }
        
        m[0][0] = 1;
        if (matrizesInspecionadas[1] != null)
        {
            matrizesInspecionadas[1].setValor(m[0][0], 0, 0);
        }
    }
}
