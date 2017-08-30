package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.No;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.Quantificador;
import java.util.List;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;

/**
 * Representa uma função alocada em memória durante a execução de um programa.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 */
public final class Funcao extends Simbolo
{
    private final List<NoDeclaracaoParametro> parametros;
    
    /**
     * 
     * @param nome              o nome desta função.
     * @param tipoDado          o tipo de dado do valor de retorno desta função.
     * @param parametros        a lista de parâmetros esperados por esta função.
     * @param declaracaoOrigem  o nó de declaração que deu origem a esta função.
     * @since 1.0
     */
    public Funcao(String nome, TipoDado tipoDado, List<NoDeclaracaoParametro> parametros, NoDeclaracaoFuncao declaracaoOrigem)
    {
        super(nome, tipoDado, declaracaoOrigem);
        this.parametros = parametros;
    }

    @Override
    public boolean constante()
    {
        return true; 
    }

    /**
     * Obtém a lista de parâmetros esperados por esta função.
     * 
     * @return     a lista de parâmetros esperados por esta função.
     * @since 1.0
     */
    public List<NoDeclaracaoParametro> getParametros()
    {
        return parametros;
    }
}
