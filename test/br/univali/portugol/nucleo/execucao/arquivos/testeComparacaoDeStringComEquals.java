package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeComparacaoDeStringComEquals extends Programa
{
    private String umaFrase = "a";
    private String outraFrase = "a";
    private int a = 0;
    private int b = 0;

    public testeComparacaoDeStringComEquals() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        if (umaFrase.equals(outraFrase))
        {
            escreva("teste");
        }
        if (!umaFrase.equals(outraFrase))
        {
            escreva("teste");
        }
        if (a == b)
        {
            escreva("teste");
        }
        if (a == b / 2)
        {
            escreva("teste");
        }
        if (a == 10 / 2 * 2)
        {
            escreva("teste");
        }
    }
}
