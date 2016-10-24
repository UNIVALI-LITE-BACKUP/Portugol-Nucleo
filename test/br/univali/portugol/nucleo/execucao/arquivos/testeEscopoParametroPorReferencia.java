package br.univali.portugol.nucleo.execucao.arquivos;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Util;

public class testeEscopoParametroPorReferencia extends Programa
{
    private final Util u = new Util();
    
      
    
    public testeEscopoParametroPorReferencia() throws ErroExecucao, InterruptedException
    {
        
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
    {  
        
    }
    
    private void teste(int a)  throws ErroExecucao, InterruptedException                               
    {                                                      
        
        teste_escopo(a);
    }

    private void teste_escopo(int a)  throws ErroExecucao, InterruptedException
    {
        teste(a);
    }
}
