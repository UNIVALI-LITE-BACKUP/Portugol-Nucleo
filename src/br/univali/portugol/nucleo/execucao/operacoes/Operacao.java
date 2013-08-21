package br.univali.portugol.nucleo.execucao.operacoes;

import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.execucao.erros.ErroDivisaoPorZero;
import br.univali.portugol.nucleo.execucao.erros.ErroExecucaoNaoTratado;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Operacao
{
    public Object executar(NoOperacao noOperacao, Object a, Object b) throws ErroExecucao
    {
        int linha = noOperacao.getTrechoCodigoFonte().getLinha();
        int coluna = noOperacao.getTrechoCodigoFonte().getColuna();
        
        try
        {
            Class ca = a.getClass();
            Class cb = b.getClass();

            Method metodo = this.getClass().getDeclaredMethod("executar", ca, cb);
            return metodo.invoke(this, a, b);
        }
        catch (InvocationTargetException ex)
        {            
            if (ex.getCause() instanceof ArithmeticException)
            {
                if (ex.getCause().getMessage().contains("/ by zero"))
                {
                    throw traduzirErro(new ErroDivisaoPorZero(), linha, coluna);
                }
            }
            
            throw traduzirErro((Exception) ex.getCause(), linha, coluna);
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException ex)
        {   
            throw traduzirErro(ex, linha, coluna);
        }
    }
    
    private ErroExecucao traduzirErro(Exception erro, int linha, int coluna)
    {
        ErroExecucao erroExecucao;
        
        if (erro instanceof ErroExecucao)
        {
            erroExecucao = (ErroExecucao) erro;
        }
        else
        {
            erroExecucao = new ErroExecucaoNaoTratado(erro);
        }
        
        erroExecucao.setLinha(linha);
        erroExecucao.setColuna(coluna);
        
        return erroExecucao;
    }
}
