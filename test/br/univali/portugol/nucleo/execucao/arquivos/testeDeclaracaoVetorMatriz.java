package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeDeclaracaoVetorMatriz extends Programa
{
    private final int TAM = 5;
    private String frases[] = new String[TAM];

    public testeDeclaracaoVetorMatriz() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        int vetor[] = {teste()};
        boolean matriz[][] = new boolean[2][2];
        char letras[][] = new char[TAM][TAM];
    }
    
    private int teste() throws ErroExecucao, InterruptedException
    {
        return 1;
    }
}
