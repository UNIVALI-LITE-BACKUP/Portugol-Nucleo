package br.univali.portugol.nucleo.execucao;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class ThreadSaida extends Thread implements ObservadorSaida
{
    private Saida saida;
    
    private Object valor = null;    
    private boolean limpar = false;
    private boolean aguardando = true;
    
    public ThreadSaida(Saida saida)
    {
        this.saida = saida;
    }

    public void setEscrever(Object valor) 
    {
        this.limpar = false;
        this.valor = valor;
    }

    public void setLimpar() 
    {
        this.limpar = true;
        this.valor = null;
    }

    @Override
    public void run() 
    {
        if (valor != null) escreva(valor);
        else
        if (limpar) saida.limpar(this);
        else 
            aguardando = false;

        while (aguardando)
        {
            try 
            {
                /**
                 * A thread fica dormindo no processador aguardando um
                 * valor ser escrito na saída
                 */
                
                Thread.sleep(60000); 
            }
            catch (InterruptedException e) 
            {
                
            }
        }
        
    }
	
    @Override
    public void notificaValorEscrito()
    {
        interromperThread();
    }

    @Override
    public void notificarSaidaLimpa() 
    {
        interromperThread();
    }
    
    private void interromperThread()
    {
        synchronized (this) 
        {
            aguardando = false;
            
            /**
             * O notify() faz com que a thread do interpretador que está aguardando a entrada
             * continue a execução.
             * 
             * O interrupt() faz com que a thread da entrada gere uma execao do tipo InterruptedException
             * encerrando a thread mesmo que ela esteja dormindo no processador. Desta forma o método run()
             * é finalizado e o interpretador pode seguir adiante.
             * 
             */
            
            notify(); 
            this.interrupt();
        }
    }

    private void escreva(Object valor)
    {
        if (valor instanceof String) saida.escrever((String) valor, this);
        else
        if (valor instanceof Boolean) saida.escrever((Boolean) valor, this);
        else
        if (valor instanceof Character) saida.escrever((Character) valor, this);
        else
        if (valor instanceof Double) saida.escrever((Double) valor, this);
        else
        if (valor instanceof Integer) saida.escrever((Integer) valor, this);
    }
}
