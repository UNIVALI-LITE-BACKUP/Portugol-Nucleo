package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeNegacao extends Programa
{
    private String a = "teste";
    private String b = "teste";

    public testeNegacao() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        if (!(!a.equals(b)))
        {
        }
    }
}
