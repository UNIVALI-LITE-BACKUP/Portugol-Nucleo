package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class GerenciadorBibliotecas
{
    private static GerenciadorBibliotecas instance = null;

    private List<String> bibliotecasDisponiveis;
    private Map<String, MetaDadosBiblioteca> metaDadosBibliotecas;
    private Map<String, Class<? extends Biblioteca>> bibliotecasCarregadas;
    
    
    public static GerenciadorBibliotecas getInstance()
    {
        if (instance == null)
        {
            instance = new GerenciadorBibliotecas();
        }
        
        return instance;
    }

    private GerenciadorBibliotecas()
    {
        metaDadosBibliotecas = new TreeMap<String, MetaDadosBiblioteca>();
        bibliotecasCarregadas = new TreeMap<String, Class<? extends Biblioteca>>();
        metaDadosBibliotecas = new TreeMap<String, MetaDadosBiblioteca>();
    }
    
    public String[] listarBibliotecasDisponiveis()
    {
        if (bibliotecasDisponiveis == null)
        {
            bibliotecasDisponiveis = new ArrayList<String>();
            bibliotecasDisponiveis.add("Matematica");
        }
        
        return (String[]) bibliotecasDisponiveis.toArray();
    }
    
    /**
     * Obtém os metadados da biblioteca especificada. Os metadados contém
     * informações importantes sobre a biblioteca, como a documentação e os 
     * metadados das funções e constantes.
     * 
     * <p>
     *      A chamada a este métodos fará com que o {@link GerenciadorBibliotecas} 
     *      tente carregar a biblioteca caso ela ainda não esteja em memória.
     * </p>
     * 
     * 
     * @param nome  o nome da bibloiteca para a qual se deseja obter os metadados
     * @return      os metadados da biblioteca em questão
     * 
     * @throws ErroCarregamentoBiblioteca   esta exceção é jogada caso o {@link GerenciadorBibliotecas}
     *                                      não consiga carregar a biblioteca especificada
     */
    public MetaDadosBiblioteca getMetaDadosBiblioteca(String nome) throws ErroCarregamentoBiblioteca
    {
        if (!metaDadosBibliotecas.containsKey(nome))
        {
            Class classBiblioteca = classe;
            MetaDadosBiblioteca metaDados = construirMetaDados();
        }
        
        return metaDadosBibliotecas.get(nome);
    }
    
    private Class carregarBiblioteca(String nome) throws ErroCarregamentoBiblioteca
    {
        if (!bibliotecasCarregadas.containsKey(nome))
        {
            try
            {
                Class classeBiblioteca = Class.forName("br.univali.portugol.nucleo.bibliotecas.".concat(nome));
                
                if (biblioteca.getNome().equals(nome))
                {
                    bibliotecasCarregadas.put(nome, biblioteca);
                }                
                else
                {
                    throw new ErroCarregamentoBiblioteca(nome, "o nome da biblioteca não corresponde ao nome do arquivo");
                }
            }
            catch (ClassNotFoundException excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, "a biblioteca não foi encontrada");
            }
            catch (ClassCastException excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, "a biblioteca não estende a classe base");
            }
            catch (Exception excecao)
            {
                throw new ErroCarregamentoBiblioteca(nome, excecao);
            }
        }
        
        return bibliotecasCarregadas.get(nome);
    }    
    
    /*
    
    public List<Field> getVariaveis()
    {
        return variaveis;
    }

    public List<Method> getFuncoes()
    {
        return funcoes;
    }
    
    public final List<Field> listarVariaveisExportadas() throws Exception
    {
        List<Field> variaveis = new ArrayList<Field>();
        
        Field[] campos = this.getClass().getDeclaredFields();        
        
        for (Field campo : campos)            
        {
            if (campo.isAnnotationPresent(MetaDadosConstante.class))
            {
                variaveis.add(campo);
            }
        }
        
        return variaveis;
    }
    
    public final List<Method> listarFuncoesExportadas() throws Exception
    {
        List<Method> funcoes = new ArrayList<Method>();
        Method[] metodos = this.getClass().getDeclaredMethods();
        
        for (Method metodo : metodos)
        {
            if (metodo.isAnnotationPresent(MetaDadosFuncao.class))
            {
                funcoes.add(metodo);
            }
        }
        
        return funcoes;
    }
    
    public final Object getValorVariavel(String nome) throws Exception
    {
        Field variavel = this.getClass().getDeclaredField(nome);        
                
        return variavel.get(this);
    }*/
}
