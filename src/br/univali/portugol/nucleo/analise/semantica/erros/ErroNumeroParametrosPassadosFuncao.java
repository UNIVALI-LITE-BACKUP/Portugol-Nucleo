package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.analise.semantica.AnalisadorSemantico;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;

/**
 * Erro gerado pelo analisador semântico quando o número de parâmetros passado durante uma chamada de função
 * é diferente do número de parâmetros esperados.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSemantico
 */
public final class ErroNumeroParametrosPassadosFuncao extends ErroSemantico
{
    private int numeroParametrosPassados;
    private int numeroParametrosEsperados;

    private Funcao funcao;
    private NoChamadaFuncao chamadaFuncao;

    /**
     * 
     * @param numeroParametrosPassados      o número de parâmetros que foi passado na chamada da função.
     * @param numeroParametrosEsperados     o número de parãmetros que eram esperados pela função.
     * @param funcao                        a função que foi chamada.
     * @param chamadaFuncao                 o nó da ASA correspondente à chamada da função.
     */    
    public ErroNumeroParametrosPassadosFuncao(int numeroParametrosPassados, int numeroParametrosEsperados, Funcao funcao, NoChamadaFuncao chamadaFuncao)
    {
        super(chamadaFuncao.getTrechoCodigoFonteNome());

        this.numeroParametrosPassados = numeroParametrosPassados;
        this.numeroParametrosEsperados = numeroParametrosEsperados;

        this.funcao = funcao;
        this.chamadaFuncao = chamadaFuncao;
    }

    /**
     * Obtém o número de parãmetros que eram esperados pela função.
     * 
     * @return     o número de parãmetros que eram esperados pela função.
     * @since 1.0
     */
    public int getNumeroParametrosEsperados()
    {
        return numeroParametrosEsperados;
    }

    /**
     * Obtém o número de parâmetros que foi passado na chamada da função.
     * 
     * @return     o número de parâmetros que foi passado na chamada da função.
     * @since 1.0
     */
    public int getNumeroParametrosPassados()
    {
        return numeroParametrosPassados;
    }
    
    /**
     * Obtém o nó da ASA correspondente à chamada da função.
     * 
     * @return     o nó da ASA correspondente à chamada da função.
     * @since 1.0
     */
    public NoChamadaFuncao getChamadaFuncao()
    {
        return chamadaFuncao;
    }

    /**
     * Obtém a função que foi chamada.
     * 
     * @return     a função que foi chamada.
     * @since 1.0
     */
    public Funcao getFuncao()
    {
        return funcao;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorString = new StringBuilder();
        String nomeFuncao = (numeroParametrosEsperados > 0)? funcao.getNome() : (numeroParametrosEsperados == -1)? "escreva" : "leia";

        construtorString.append("A função \"");
        construtorString.append(nomeFuncao);
        construtorString.append("\"");
        
        
        if (numeroParametrosEsperados == 0)
            construtorString.append(" não espera nenhum parâmetro ");
        
        else
            
        if (numeroParametrosEsperados < 0)
            construtorString.append(" espera ao menos um parâmetro ");
        
        else
        {
        
            construtorString.append(" espera ");
            construtorString.append(numeroParametrosEsperados);

            if (numeroParametrosEsperados == 1) construtorString.append(" parâmetro ");
            else construtorString.append(" parâmetros ");
        
        }
        
        if (numeroParametrosPassados == 0)
            construtorString.append("mas não foi passado nenhum parâmetro");
        
        else
        {
            if (numeroParametrosPassados == 1) construtorString.append("mas foi passado ");
            else construtorString.append("mas foram passados ");

            if (numeroParametrosEsperados > numeroParametrosPassados)
                construtorString.append("apenas ");

            construtorString.append(numeroParametrosPassados);

            if (numeroParametrosPassados == 1) construtorString.append(" parâmetro.");
            else construtorString.append(" parâmetros.");
        }

        return construtorString.toString();
    }
}