package br.univali.portugol.nucleo.simbolos;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Luiz Fernando Noschang
 * @author Fillipi Pelz
 */
public class Memoria
{
    private TabelaSimbolos escopoGlobal;
    private Stack<TabelaSimbolos> escoposLocais;

    public Memoria()
    {
        escopoGlobal = new TabelaSimbolos();
        escoposLocais = new Stack<TabelaSimbolos>();
    }
    
    public Simbolo getSimbolo(String nome) throws ExcecaoSimboloNaoDeclarado
    {        
        if (!escoposLocais.isEmpty())
        {
            try
            {
                return escoposLocais.peek().obter(nome);
            }
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)
            {
                // Procura no escopo global
            }
        }
        
        return escopoGlobal.obter(nome);
    }
    
    public void adicionarSimbolo(Simbolo simbolo)
    {
        if (!escoposLocais.isEmpty())
        {
            escoposLocais.peek().adicionar(simbolo);
        }        
        else
        {
            escopoGlobal.adicionar(simbolo);
        }
    }
    
    public void empilharFuncao()
    {
        escoposLocais.push(new TabelaSimbolos());
    }
    
    public void desempilharFuncao() throws EmptyStackException
    {
        escoposLocais.pop();
    }
    
    public void empilharEscopo() throws EmptyStackException
    {
        if (!escoposLocais.isEmpty())
        {
            escoposLocais.peek().empilharEscopo();
        }        
    }
    
    public void desempilharEscopo() throws EmptyStackException
    {
        if (!escoposLocais.isEmpty())
        {
            escoposLocais.peek().desempilharEscopo();
        }
    }
    
    public boolean isEscopoGlobal()
    {
        return escoposLocais.isEmpty();
    }
    
    public boolean isGlobal(Simbolo simbolo)
    {
        try
        {
            Simbolo simboloExistente = escopoGlobal.obter(simbolo.getNome());
            
            return (simboloExistente == simbolo);
        }
        catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)        
        {
            return false;
        }
    }
    
    public boolean isLocal(Simbolo simbolo)
    {
        if (!escoposLocais.isEmpty())
        {
            try
            {
                Simbolo simboloExistente = escoposLocais.peek().obter(simbolo.getNome());

                return (simboloExistente == simbolo);
            }
            catch (ExcecaoSimboloNaoDeclarado excecaoSimboloNaoDeclarado)        
            {
                
            }
        }
        
        return false;
    }
}
