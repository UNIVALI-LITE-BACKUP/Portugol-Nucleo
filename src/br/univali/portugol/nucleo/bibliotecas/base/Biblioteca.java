package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Classe base para a construção de bibliotecas do Portugol. Todas as bibliotecas
 * escritas para o Portugol deverão estender esta classe e seguir as seguintes
 * regras de implementação:
 * 
 * </p>
 * <ul>
 *      <li><p>A biblioteca deve estender a classe {@link Biblioteca}</p><br/></li>
 *      <li>
 *          <p>
 *              A classe da biblioteca deve ser <strong>pública</strong> e 
 *              <strong>final</strong>
 *          </p>
 *          <br/>
 *      </li>
 *      <li><p>A biblioteca deve exportar pelo menos uma função ou constante</p><br/></li>
 *      <li>
 *          <p>
 *              A biblioteca não pode ter sobrecarga dos métodos públicos exportados 
 *              como funções. Já os métodos privados poderão ser sobrecarregados a
 *              qualquer momento
 *          </p>
 *          <br/>
 *      </li>
 *      <li>
 *          <p>
 *              Para que um método da classe seja exportado como uma função da biblioteca, 
 *              o método deve ser <strong>público</strong>, <strong> não estático</strong>
 *              e deve estar anotado com a anotação {@link DocumentacaoFuncao}
 *          </p>
 *          <br/>
 *      </li>
 *      <li>
 *          <p>
 *              Para que um atributo da classe seja exportado como uma constante da biblioteca,
 *              o atributo deve ser <strong>público</strong>, <strong>final</strong>, ter o
 *              nome todo em letras maiúsculas e estar anotado com a anotação {@link DocumentacaoConstante}
 *          </p>
 *          <br/>
 *      </li>
 *      <li>
 *          <p>
 *              O tipo de retorno e parâmetros dos métodos, e o tipo dos atributos
 *              exportados, deverá ser compatível com os tipos de dados do Portugol, a saber:
 *              
 *              <br/>
 *              <ul>
 *                  <li>{@link Integer} --&gt; {@link TipoDado#INTEIRO}<br/></li>
 *                  <li>{@link Double} --&gt; {@link TipoDado#REAL} <br/></li>
 *                  <li>{@link Boolean} --&gt; {@link TipoDado#LOGICO}<br/></li>
 *                  <li>{@link String} --&gt; {@link TipoDado#CADEIA}<br/></li>
 *                  <li>{@link Character} --&gt; {@link TipoDado#CARACTER}<br/></li>
 *                  <li><strong>void</strong> --&gt; {@link TipoDado#VAZIO}<br/></li>
 *              </ul>
 *              <br/>
 * 
 *              Com exceção do tipo <strong>void</strong>, não poderão ser utilizados os
 *              tipos primitivos correspondentes, a saber: <strong>int</strong>,
 *              <strong>double</strong>, <strong>boolean</strong> e <strong>char</strong>.
 *              Além disso, o tipo <strong>void</strong> não pode ser utilizado nos parâmetros
 *              dos métodos</strong>
 *           </p>
 *           <br/>
 *      </li>
 * </ul>
 * 
 * @author Luiz Fernando Noschang
 */
public abstract class Biblioteca
{    
    private List<Field> variaveis;
    private List<Method> funcoes; 
    private TipoBiblioteca tipo;
    
    public Biblioteca() throws Exception
    {
        //variaveis = listarVariaveisExportadas();
        //funcoes = listarFuncoesExportadas();
    }

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
    
    /**
     * Este método será chamado automaticamente para inicializar a biblioteca no 
     * início da execução de cada {@link Programa}
     * 
     * <p>
     *      Para as bibliotecas do tipo {@link TipoBiblioteca#COMPARTILHADA}, quando houver
     *      um código de inicialização, a própria biblioteca fica responsável por garantir 
     *      que o código de inicialização seja executado apenas uma vez
     * </p>
     * 
     * @see TipoBiblioteca
     */
    protected void inicializar()
    {

    }
    
    /**
     * Este método será chamado automaticamente para finalizar a biblioteca no término 
     * da execução de cada {@link Programa}
     * 
     * <p>
     *      Para as bibliotecas do tipo {@link TipoBiblioteca#COMPARTILHADA}, quando houver
     *      um código de finalização, a biblioteca fica responsável por garantir que o código
     *      de finalização seja executado apenas uma vez
     * </p>
     *
     * @see GerenciadorBibliotecas
     * 
     */
    protected void finalizar()
    {

    }    

    public List<Field> getVariaveis()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Method> getFuncoes()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
