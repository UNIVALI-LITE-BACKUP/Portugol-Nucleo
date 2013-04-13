package br.univali.portugol.nucleo.bibliotecas.base;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class CarregadorBibliotecas
{
    private static final Map<String, Biblioteca> bibliotecasCarregadas = new HashMap<String, Biblioteca>();
    
    public static Biblioteca carregarBiblioteca(String nome) throws ErroCarregamentoBiblioteca
    {
        if (!bibliotecasCarregadas.containsKey(nome))
        {
            try
            {
                Class classeBiblioteca = Class.forName("br.univali.portugol.nucleo.bibliotecas.".concat(nome));
                Biblioteca biblioteca = (Biblioteca) classeBiblioteca.newInstance();
                
                bibliotecasCarregadas.put(nome, biblioteca);
            }
            catch (ClassNotFoundException excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, "a biblioteca não foi encontrada");
            }
            catch (ClassCastException excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, "a biblioteca não  estende a classe base");
            }
            catch (Exception excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, excecao);
            }
        }
        
        return bibliotecasCarregadas.get(nome);
    }
}
