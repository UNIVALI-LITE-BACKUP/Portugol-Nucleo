package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeCodigoParaVariaveisInspecionadas extends Programa
{
    
    
    public testeCodigoParaVariaveisInspecionadas() throws ErroExecucao, InterruptedException
    {
        variaveisInspecionadas = new Object[2];
        vetoresInspecionados = new Vetor[1];
        matrizesInspecionadas = new Matriz[1];
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
    }
}
