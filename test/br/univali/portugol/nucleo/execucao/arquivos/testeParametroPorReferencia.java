package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;

public class testeParametroPorReferencia extends Programa
{

    public testeParametroPorReferencia() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        int a = 10;
        ValueHolder<Integer> holder_a = new ValueHolder(a);
        teste(holder_a);
        a = holder_a.getValue();
    }
    
    private void teste(ValueHolder x) throws ErroExecucao, InterruptedException
    {
        x.setValue(11);
    }
}
