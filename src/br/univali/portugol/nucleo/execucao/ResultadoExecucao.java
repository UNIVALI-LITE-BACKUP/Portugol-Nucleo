package br.univali.portugol.nucleo.execucao;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 * Esta classe contém informações referentes à 
 * execução do programa.
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class ResultadoExecucao 
{
    private Long tempoExecucao = 0L;
    private ModoEncerramento modoEncerramento = ModoEncerramento.NORMAL;
    private ErroExecucao erro;

    /**
     * @return Retorna em milissegundos o tempo total em que o 
     * programa permaneceu rodando (em execução).
     */
    
    public Long getTempoExecucao()
    {
        return tempoExecucao;
    }

    public void setTempoExecucao(Long tempoExecucao)
    {
        this.tempoExecucao = tempoExecucao;
    }

    /**
     * 
     * @return um valor indicando o modo como a execução foi encerrada.
     * @see ModoEncerramento
     */
    
    public ModoEncerramento getModoEncerramento()
    {
        return modoEncerramento;
    }

    public void setModoEncerramento(ModoEncerramento modoEncerramento) 
    {
        this.modoEncerramento = modoEncerramento;
    }

    /**
     * 
     * @return um erro de execução caso tenha ocorrido, caso contrário retorna null.
     * <p>
     *      Para verificar se ocorreu um erro de execução deve-se
     *      utilizar o método {@link #getModoEncerramento() }.
     * </p>
     * 
     */
    
    public ErroExecucao getErro() 
    {
        return erro;
    }

    public void setErro(ErroExecucao erro) 
    {
        this.erro = erro;
    }
}
