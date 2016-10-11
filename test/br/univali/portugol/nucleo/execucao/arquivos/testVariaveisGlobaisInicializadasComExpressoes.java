package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testVariaveisGlobaisInicializadasComExpressoes extends Programa
{
    private String c = "teste" + " concatenacao";
    private int i = ((10 + 2 * 4 / 1) << 1);
    private boolean l = true && true || false;
    private double r = 53.23 + 0.01;

    public testVariaveisGlobaisInicializadasComExpressoes() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
    }
}
