package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Matematica;

public class testeConstanteDeBiblioteca extends Programa
{
    private final Matematica mat = new Matematica();

    public testeConstanteDeBiblioteca() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        double raio = 2.0;
        double area = mat.PI * mat.potencia(raio, 2.0);
    }
}
