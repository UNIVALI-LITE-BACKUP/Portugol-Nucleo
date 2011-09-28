package br.univali.portugol.nucleo.execucao.erros;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroExecucaoNaoTratado extends ErroExecucao
{
    private Exception causa;

    
    public ErroExecucaoNaoTratado(Exception causa) 
    {
        this.causa = causa;                
    }

    @Override
    protected String construirMensagem() 
    {
        StringBuilder construtorTexto = new StringBuilder();
        FluxoSaidaExcecao fluxoSaidaExcecao = new FluxoSaidaExcecao(construtorTexto);
        
        causa.printStackTrace(new PrintWriter(fluxoSaidaExcecao, true));
        
        return construtorTexto.toString();
    }
    
    private final class FluxoSaidaExcecao extends OutputStream
    {
        private StringBuilder construtorTexto;
        private StringBuilder saida;

        public FluxoSaidaExcecao(StringBuilder saida) 
        {
            construtorTexto = new StringBuilder(128);
            this.saida = saida;                    
        }
        
        @Override
        public void write(int b) throws IOException 
        {
            construtorTexto.append((char) b);
        }

        @Override
        public void flush() throws IOException 
        {
            saida.append(construtorTexto.toString());
            construtorTexto.setLength(0);            
        }
    }
}
