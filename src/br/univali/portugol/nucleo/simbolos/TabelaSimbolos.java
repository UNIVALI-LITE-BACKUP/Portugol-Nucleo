package br.univali.portugol.nucleo.simbolos;

import br.univali.portugol.nucleo.asa.NoReferencia;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Armazena todos os símbolos alocados em memória durante a execução dos programas.
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 */
public final class TabelaSimbolos implements Iterable<Simbolo>
{
    private Stack<Map<String, Simbolo>> escopos;

    public TabelaSimbolos()
    {
        escopos = new Stack<Map<String, Simbolo>>();
        empilharEscopo();
    }

    /**
     * Inicializa um novo escopo dentro desta tabela de símbolos.
     * 
     * @since 1.0
     */
    public void empilharEscopo()
    {
        escopos.push(new HashMap<String, Simbolo>());
    }
    
    /**
     * Remove o escopo mais recente desta tabela de símbolos.
     * 
     * @since 1.0
     */
    public void desempilharEscopo()
    {
        escopos.pop();
    }

    /**
     * Adiciona um símbolo no escopo atual.
     * 
     * @param simbolo     o símbolo a ser adicionado no escopo.
     * @since 1.0
     */
    public void adicionar(Simbolo simbolo)
    {
        escopos.peek().put(simbolo.getNome(), simbolo);
    }

    /**
     * Obtém o símbolo representado pelo nome esecificado. O símbolo é procurado em cada um dos escopos do
     * programa, iniciando pelo escopo mais recente.
     * 
     * @param nome     o nome do símbolo que está sendo procurado.
     * @return         o símbolo com o nome específicado, ou null caso não seja encontrado.
     * @since 1.0
     */
    public Simbolo obter(String nome)
    {
        Simbolo simbolo = null;

        for (int i = escopos.size() - 1; i >= 0; i--)
        {
            if ((simbolo = escopos.elementAt(i).get(nome)) != null)
            {
                return simbolo;
            }
        }

        return null;
    }

    /**
     * Verifica se existe um símbolo com o nome especificado, nesta tabela de símbolos.
     * 
     * @param nome     o nome do símbolo que está sendo procurado.
     * @return         <code>true</code> se o símbolo for encontrado, caso contrário retorna <code>false</code>.
     * @since 1.0
     */
    public boolean contem(String nome)
    {
        for (Map<String, Simbolo> escopo : escopos)
        {
            if (escopo.containsKey(nome))
            {
                return true;
            }
        }

        return false;
    }

    public int getNumeroEscopos()
    {
        return escopos.size();
    }
    
    /**
     * {@inheritDoc }
     */
    @Override    
    public Iterator<Simbolo> iterator()
    {
        return escopos.peek().values().iterator();
    }

}