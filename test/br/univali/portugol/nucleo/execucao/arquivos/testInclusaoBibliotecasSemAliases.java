package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Graficos;
import br.univali.portugol.nucleo.bibliotecas.Mouse;

public class testInclusaoBibliotecasSemAliases extends Programa
{
    private final Graficos Graficos = new Graficos();
    private final Mouse Mouse = new Mouse();

    public testInclusaoBibliotecasSemAliases() throws ErroExecucao
    {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
    }
}
