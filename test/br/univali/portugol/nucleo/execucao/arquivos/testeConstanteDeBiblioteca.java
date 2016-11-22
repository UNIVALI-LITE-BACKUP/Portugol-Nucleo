package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Matematica;

public class testeConstanteDeBiblioteca extends Programa
{
    private final Matematica mat_1010 = new Matematica();

    public testeConstanteDeBiblioteca() throws ErroExecucao, InterruptedException
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        double raio = 2.0;
        double area = mat_1010.PI * mat_1010.potencia(raio, 2.0);
    }
}
