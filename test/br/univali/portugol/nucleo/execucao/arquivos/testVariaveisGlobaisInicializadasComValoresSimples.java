package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testVariaveisGlobaisInicializadasComValoresSimples extends Programa
{
    private int i = 10;
    private String c = "teste";
    private boolean l = true;
    private char ch = 'a';
    private double r = 53.23;

    public testVariaveisGlobaisInicializadasComValoresSimples() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
    }
}
