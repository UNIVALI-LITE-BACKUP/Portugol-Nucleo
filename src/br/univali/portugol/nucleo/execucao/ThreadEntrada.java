package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.asa.TipoDado;

public final class ThreadEntrada extends Thread implements ObservadorEntrada 
{
    private Object valor;
    private Entrada entrada;
    private TipoDado tipoDado;

    public ThreadEntrada(Entrada entrada, TipoDado tipoDado) 
    {
        this.tipoDado = tipoDado;
        this.entrada = entrada;
    }

    public void run() 
    {
        entrada.ler(tipoDado, this);

        while (valor == null) 
        {
            try 
            {
                /**
                 * A thread fica dormindo no processador aguardando um
                 * valor ser retornado da entrada
                 */
                
                Thread.sleep(60000); 
            }
            catch (InterruptedException e) 
            {
                
            }
        }
    }
	
    @Override
    public void notificaValorLido(Object valor)
    {
        synchronized (this) 
        {
            this.valor = valor;
            
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

    public Object getValor() 
    {
        return valor;
    }
}
