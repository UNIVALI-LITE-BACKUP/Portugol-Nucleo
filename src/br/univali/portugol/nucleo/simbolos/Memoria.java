package br.univali.portugol.nucleo.simbolos;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;
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
    private List<ObservadorMemoria> observadores;    

    public Memoria()
    {
        escopoGlobal = new TabelaSimbolos();
        escoposLocais = new Stack<TabelaSimbolos>();
        observadores = new ArrayList<>();
    }
    
    public void adicionarObservador(ObservadorMemoria observador)
    {
        if (!observadores.contains(observador))
        {
            observadores.add(observador);
        }
    }
    
    public void removerObservador(ObservadorMemoria observador)
    {
        observadores.remove(observador);
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
        
        notificarSimboloAdicionado(simbolo);
    }
    
    public void empilharFuncao()
    {
        escoposLocais.push(new TabelaSimbolos());
    }
    
    public void desempilharFuncao() throws EmptyStackException
    {
        TabelaSimbolos simbolosFuncao = escoposLocais.pop();
        for (Map<String, Simbolo> simbolos : simbolosFuncao ){
            for (Simbolo simbolo : simbolos.values()) {
                notificarSimboloRemovido(simbolo);
            }
        }
    }
    
    public void empilharEscopo() throws EmptyStackException
    {
        if (!escoposLocais.isEmpty())
        {
            escoposLocais.peek().empilharEscopo();
        } else {
            escopoGlobal.empilharEscopo();
        }     
    }
    
    public void desempilharEscopo() throws EmptyStackException
    {
        if (!escoposLocais.isEmpty())
        {
             Map<String, Simbolo> escopo = escoposLocais.peek().desempilharEscopo();
             
             for (Simbolo simbolo : escopo.values())
             {
                 notificarSimboloRemovido(simbolo);
             }
             
        } else {
            escopoGlobal.empilharEscopo();
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
    
    private void notificarSimboloAdicionado(Simbolo simbolo)
    {
        for (ObservadorMemoria observador : observadores)
        {
            observador.simboloAdicionado(simbolo);
        }
    }
    
    private void notificarSimboloRemovido(Simbolo simbolo)
    {
        for (ObservadorMemoria observador : observadores)
        {
            observador.simboloRemovido(simbolo);
        }
    }
}
