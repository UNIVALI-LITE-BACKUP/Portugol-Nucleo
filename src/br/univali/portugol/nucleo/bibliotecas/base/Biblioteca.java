package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.TipoDado;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
public abstract class Biblioteca
{
    private List<Field> variaveis;
    private List<Method> funcoes;    
    
    public Biblioteca() throws Exception
    {
        variaveis = listarVariaveisExportadas();
        funcoes = listarFuncoesExportadas();
        
        validarVariaveis(variaveis);
        validarFuncoes(funcoes);
        
        if (variaveis.isEmpty() && funcoes.isEmpty())
        {
            throw new Exception("A biblioteca não está exportando nenhuma função ou variável");
        }
    }

    public abstract String getNome();

    private void validarFuncoes(List<Method> funcoes) throws Exception
    {
        for (Method funcao : funcoes)
        {
            if (!tipoSuportado(funcao.getReturnType()))
            {
                throw new Exception(String.format("O tipo de retorno da função \"%s\" deve ser um dos tipos suportados: %s", funcao.getName(), listarTiposSuportados()));
            }
            
            if (Modifier.isStatic(funcao.getModifiers()))
            {
                throw new Exception(String.format("A função \"%s\" não pode ser declarada com o modificador \"static\"", funcao.getName()));
            }

            for (int i = 0; i < funcao.getParameterTypes().length; i++)
            {
                Class tipoParametro = funcao.getParameterTypes()[i];
                
                if (!tipoSuportado(tipoParametro))
                {
                    throw new Exception(String.format("O tipo do %dº parâmetro da função \"%s\" deve ser um dos tipos suportados: %s", (i + 1), funcao.getName(), listarTiposSuportados()));
                }
            }
        }
    }
    
    private void validarVariaveis(List<Field> variaveis) throws Exception
    {
        for (Field variavel : variaveis)
        {
            if (!Modifier.isFinal(variavel.getModifiers()))
            {
                throw new Exception(String.format("A variável \"%s\" deve ser declarada com o modificador final", variavel.getName()));
            }
            
            if (!tipoSuportado(variavel.getType()))
            {
                throw new Exception(String.format("O tipo da variável \"%s\" deve ser um dos tipos suportados: %s", variavel.getName(), listarTiposSuportados()));
            }
        }
    }
    
    private boolean tipoSuportado(Class classe)
    {
        for (TipoDado tipo : TipoDado.values())
        {
            if (classe == tipo.getTipoJava())
            {
                return true;
            }
        }
        
        return false;
    }
    
    private String listarTiposSuportados()
    {
        StringBuilder construtorTexto = new StringBuilder();
        TipoDado[] tiposDado = TipoDado.values();
        
        for (int i = 0; i < tiposDado.length - 1; i++)
        {
            construtorTexto.append(tiposDado[i].getTipoJava().getName());
            construtorTexto.append(", ");
        }
        
        construtorTexto.append(tiposDado[tiposDado.length - 1].getTipoJava().getName());
        
        return construtorTexto.toString();
    }
    
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
            if (campo.isAnnotationPresent(Exportar.class))
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
            if (metodo.isAnnotationPresent(Exportar.class))
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
    }
    
    public final Object chamarFuncao(String nome, Object[] parametros) throws Exception
    {
        Class[] tiposParametros = new Class[parametros.length];
        
        for (int i = 0; i < parametros.length; i++)
        {
            tiposParametros[i] = parametros[i].getClass();
        }
        
        Method funcao = this.getClass().getDeclaredMethod(nome, tiposParametros);
        
        return funcao.invoke(this, parametros);
    }
}
