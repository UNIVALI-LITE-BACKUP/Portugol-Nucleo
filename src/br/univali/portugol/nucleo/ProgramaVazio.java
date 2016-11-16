package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
final class ProgramaVazio extends Programa
{
    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {
        throw new ErroExecucao()
        {
            @Override
            protected String construirMensagem()
            {
                return "Este programa não é executável";
            }
        };
    }
}
