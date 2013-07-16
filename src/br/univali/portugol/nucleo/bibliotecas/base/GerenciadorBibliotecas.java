package br.univali.portugol.nucleo.bibliotecas.base;

import br.univali.portugol.nucleo.asa.ModoAcesso;
import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Esta classe é responsável por carregar as bibliotecas em memória e gerenciar
 * seu ciclo de vida. É responsável também por criar os metadados das bibliotecas
 * e validar se as mesmas foram implementadas de acordo com as regras definidas
 * na classe base ({@link Biblioteca}).
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
    
    public List<String> listarBibliotecasDisponiveis()
    {
        if (bibliotecasDisponiveis == null)
        {
            bibliotecasDisponiveis = new ArrayList<String>();
            bibliotecasDisponiveis.add("Matematica");
        }
        
        return new ArrayList<String>(bibliotecasDisponiveis);
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
     * @param nome  o nome da biblioteca para a qual se deseja obter os metadados
     * @return      os metadados da biblioteca em questão
     * 
     * @throws ErroCarregamentoBiblioteca   esta exceção é jogada caso o {@link GerenciadorBibliotecas}
     *                                      não consiga carregar a biblioteca especificada
     */
    public MetaDadosBiblioteca getMetaDadosBiblioteca(String nome) throws ErroCarregamentoBiblioteca
    {
        if (!metaDadosBibliotecas.containsKey(nome))
        {
            Class classeBiblioteca = carregarBiblioteca(nome);
            MetaDadosBiblioteca metaDados = obterMetaDadosBiblioteca(nome, classeBiblioteca);
            
            metaDadosBibliotecas.put(nome, metaDados);
        }
        
        return metaDadosBibliotecas.get(nome);
    }
    
    private Class<? extends Biblioteca> carregarBiblioteca(String nome) throws ErroCarregamentoBiblioteca
    {
        if (!bibliotecasCarregadas.containsKey(nome))
        {
            try
            {
                return Class.forName("br.univali.portugol.nucleo.bibliotecas.".concat(nome)).asSubclass(Biblioteca.class);
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
    
    private MetaDadosBiblioteca obterMetaDadosBiblioteca(String nomeBiblioteca, Class<? extends Biblioteca> classeBiblioteca) throws ErroCarregamentoBiblioteca
    {
        if (declaracaoValida(classeBiblioteca))
        {
            PropriedadesBiblioteca propriedadesBiblioteca = obterAnotacaoClasse(nomeBiblioteca, classeBiblioteca, PropriedadesBiblioteca.class);
            DocumentacaoBiblioteca documentacaoBiblioteca = obterAnotacaoClasse(nomeBiblioteca, classeBiblioteca, DocumentacaoBiblioteca.class);

            MetaDadosBiblioteca metaDadosBiblioteca = new MetaDadosBiblioteca();

            metaDadosBiblioteca.setNome(nomeBiblioteca);
            metaDadosBiblioteca.setTipo(propriedadesBiblioteca.tipo());
            metaDadosBiblioteca.setDocumentacao(documentacaoBiblioteca);
            
            List<MetaDadosFuncao> metaDadosFuncoes = obterMetaDadosFuncoes(nomeBiblioteca, classeBiblioteca);
            List<MetaDadosConstante> metaDadosConstantes = obterMetaDadosConstantes(nomeBiblioteca, classeBiblioteca);
            
            if (!metaDadosFuncoes.isEmpty() || !metaDadosConstantes.isEmpty())
            {
                metaDadosBiblioteca.setMetaDadosFuncoes(metaDadosFuncoes);
                metaDadosBiblioteca.setMetaDadosConstantes(metaDadosConstantes);
            }
            
            else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, "a biblioteca não está exportando nenhuma constante ou função");

            return metaDadosBiblioteca;
        }
        
        else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, montarMensagemDeclaracaoInvalida(classeBiblioteca));
    }
    
    private List<MetaDadosFuncao> obterMetaDadosFuncoes(String nomeBiblioteca, Class<? extends Biblioteca> classeBiblioteca) throws ErroCarregamentoBiblioteca
    {
        List<MetaDadosFuncao> metaDadosFuncoes = new ArrayList<MetaDadosFuncao>();
        
        for (Method metodo : classeBiblioteca.getDeclaredMethods())
        {
            if (Modifier.isPublic(metodo.getModifiers()))
            {
                MetaDadosFuncao metaDadosFuncao = obterMetaDadosFuncao(nomeBiblioteca, metodo);
                
                if (!metaDadosFuncoes.contains(metaDadosFuncao))
                {
                    metaDadosFuncoes.add(metaDadosFuncao);
                }
                
                else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o método '%s' possui sobrecargas", metodo.getName()));
            }
        }
        
        return metaDadosFuncoes;
    }
    
    private MetaDadosFuncao obterMetaDadosFuncao(String nomeBiblioteca, Method metodo) throws ErroCarregamentoBiblioteca
    {
        if (!Modifier.isStatic(metodo.getModifiers()))
        {
            if (jogaExcecao(metodo, ErroExecucao.class))
            {
                DocumentacaoFuncao documentacaoFuncao = obterAnotacaoMetodo(nomeBiblioteca, metodo, DocumentacaoFuncao.class);

                MetaDadosFuncao metaDadosFuncao = new MetaDadosFuncao();

                metaDadosFuncao.setNome(metodo.getName());
                metaDadosFuncao.setDocumentacao(documentacaoFuncao);
                metaDadosFuncao.setTipoDado(obterTipoDadoMetodo(nomeBiblioteca, metodo));
                metaDadosFuncao.setMetaDadosParametros(obterMetaDadosParametros(nomeBiblioteca, metodo, documentacaoFuncao));

                if (eMatriz(metodo.getReturnType()))
                {
                    metaDadosFuncao.setQuantificador(Quantificador.MATRIZ);
                }
                else if (eVetor(metodo.getReturnType()))
                {
                    metaDadosFuncao.setQuantificador(Quantificador.VETOR);
                }

                else metaDadosFuncao.setQuantificador(Quantificador.VALOR);

                return metaDadosFuncao;
            }
            
            else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o método '%s' deve jogar uma exceção do tipo '%s' para ser exportado como uma função", metodo.getName(), ErroExecucao.class.getName()));
        }
        
        else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o método '%s' não pode ser estático para ser exportado como uma função", metodo.getName()));
    }
    
    private boolean jogaExcecao(Method metodo, Class<? extends Exception> classeExcecao)
    {
        for (int i = 0; i < metodo.getExceptionTypes().length; i++)
        {
            if (metodo.getExceptionTypes()[i] == classeExcecao)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private List<MetaDadosParametro> obterMetaDadosParametros(String nomeBiblioteca, Method metodo, DocumentacaoFuncao documentacaoFuncao) throws ErroCarregamentoBiblioteca
    {
        List<MetaDadosParametro> metaDadosParametros = new ArrayList<MetaDadosParametro>();
        
        Class[] tiposParametros = metodo.getParameterTypes();
        Annotation[] anotacoesParametros = documentacaoFuncao.parametros();
        
        if (tiposParametros.length == anotacoesParametros.length)
        {        
            for (int i = 0; i < tiposParametros.length; i++)
            {
                DocumentacaoParametro documentacaoParametro = (DocumentacaoParametro) anotacoesParametros[i];
                MetaDadosParametro metaDadosParametro = new MetaDadosParametro();
                
                metaDadosParametro.setNome(documentacaoParametro.nome());
                metaDadosParametro.setDocumentacaoParametro(documentacaoParametro);
                metaDadosParametro.setTipoDado(obterTipoDadoParametro(nomeBiblioteca, metodo, i, documentacaoParametro.nome(), tiposParametros[i]));

                if (tiposParametros[i] == Referencia.class)
                {
                    tiposParametros[i] = (Class) ((ParameterizedType) metodo.getGenericParameterTypes()[i]).getActualTypeArguments()[0];
                    metaDadosParametro.setModoAcesso(ModoAcesso.POR_REFERENCIA);
                }
                
                else metaDadosParametro.setModoAcesso(ModoAcesso.POR_VALOR);
                
                if (eMatriz(tiposParametros[i]))
                {
                    metaDadosParametro.setQuantificador(Quantificador.MATRIZ);
                }                
                else if (eVetor(tiposParametros[i]))
                {
                    metaDadosParametro.setQuantificador(Quantificador.VETOR);
                }
                
                else metaDadosParametro.setQuantificador(Quantificador.VALOR);                
                
                
                if (!metaDadosParametros.contains(metaDadosParametro))
                {
                    metaDadosParametros.add(metaDadosParametro);
                }
                
                else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o método '%s' está documentando diferentes parâmetros com o mesmo nome: '%s'", metodo.getName(), documentacaoParametro.nome()));
            }
        }
        
        else if (anotacoesParametros.length < tiposParametros.length)
        {
            throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("existem parâmetros da função '%s' que não foram documentados com a anotação '%s'", metodo.getName(), DocumentacaoParametro.class.getSimpleName()));
        }
        else if (anotacoesParametros.length > tiposParametros.length)
        {
            throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("a função '%s' está documentando um parâmetro inexistente: '%s'", metodo.getName(), ((DocumentacaoParametro) anotacoesParametros[anotacoesParametros.length - 1]).nome()));
        }
        
        return metaDadosParametros;
    }
    
    private List<MetaDadosConstante> obterMetaDadosConstantes(String nomeBiblioteca, Class<? extends Biblioteca> classeBiblioteca) throws ErroCarregamentoBiblioteca
    {
        List<MetaDadosConstante> metaDadosConstantes = new ArrayList<MetaDadosConstante>();
        
        for (Field atributo : classeBiblioteca.getDeclaredFields())
        {
            if (Modifier.isPublic(atributo.getModifiers()))
            {
                if (!Modifier.isStatic(atributo.getModifiers()))
                {
                    if (Modifier.isFinal(atributo.getModifiers()))
                    {
                        if (maiusculo(atributo.getName()))
                        {
                            DocumentacaoConstante documentacaoConstante = obterAnotacaoAtributo(nomeBiblioteca, atributo, DocumentacaoConstante.class);
                            MetaDadosConstante metaDadosConstante = new MetaDadosConstante();
                            
                            metaDadosConstante.setNome(atributo.getName());
                            metaDadosConstante.setDocumentacao(documentacaoConstante);
                            metaDadosConstante.setQuantificador(Quantificador.VALOR);
                            metaDadosConstante.setTipoDado(obterTipoDadoConstante(nomeBiblioteca, atributo));
                            
                            if (!metaDadosConstantes.contains(metaDadosConstante))
                            {
                                metaDadosConstantes.add(metaDadosConstante);
                            }
                        }
                        
                        else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' deve ter o nome todo em letras maiúsuclas para ser exportado como uma constante", atributo.getName()));
                    }
                    
                    else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' deve ser final para ser exportado como uma constante", atributo.getName()));
                }
                
                else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' não pode ser estático para ser exportado como uma constante", atributo.getName()));
            }
        }
        
        return metaDadosConstantes;
    }
    
    private TipoDado obterTipoDadoConstante(String nomeBiblioteca, Field atributo) throws ErroCarregamentoBiblioteca
    {
        Class classeTipo = atributo.getType();
        
        if (eMatriz(classeTipo) || eVetor(classeTipo))
        {
            throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' não pode ser um vetor nem uma matriz para ser exportado como uma constante", atributo.getName()));
        }
        
        if (classeTipo == Integer.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' dever ser do tipo '%s' ao invés do tipo primitivo '%s'", atributo.getName(), Integer.class.getName(), Integer.TYPE.getSimpleName()));
        if (classeTipo == Double.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", atributo.getName(), Double.class.getName(), Double.TYPE.getSimpleName()));
        if (classeTipo == Character.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", atributo.getName(), Character.class.getName(), Character.TYPE.getSimpleName()));
        if (classeTipo == Boolean.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", atributo.getName(), Boolean.class.getName(), Boolean.TYPE.getSimpleName()));
        if ((classeTipo == Void.class || classeTipo == Void.TYPE)) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' não pode ser do tipo primitivo '%s' nem do tipo '%s'", atributo.getName(), Void.TYPE.getName(), classeTipo.getName()));

        TipoDado tipoDado;
        
        if ((tipoDado = TipoDado.obterTipoDadoPeloTipoJava(classeTipo)) != null)
        {        
            return tipoDado;
        }
        
        throw new ErroCarregamentoBiblioteca
        (
            nomeBiblioteca, String.format("o tipo do atributo '%s' deve ser um dos tipos a seguir: '%s', '%s', '%s', '%s', ou '%s'", atributo.getName(),
        
            TipoDado.CADEIA.getTipoJava().getName(),
            TipoDado.CARACTER.getTipoJava().getName(),
            TipoDado.INTEIRO.getTipoJava().getName(),
            TipoDado.LOGICO.getTipoJava().getName(),
            TipoDado.REAL.getTipoJava().getName()
        ));
    }
    
    private boolean maiusculo(String texto)
    {
        return texto.equals(texto.toUpperCase());
    }
    
    private <T extends Annotation> T obterAnotacaoClasse(String nomeBiblioteca, Class<? extends Biblioteca> classeBiblioteca, Class<T> classeAnotacao) throws ErroCarregamentoBiblioteca
    {
        T anotacao;
        
        if ((anotacao = classeBiblioteca.getAnnotation(classeAnotacao)) != null)
        {
            return anotacao;
        }
        
        throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("a biblioteca não foi anotada com a anotação '%s'", classeAnotacao.getSimpleName()));
    }
    
    private <T extends Annotation> T obterAnotacaoAtributo(String nomeBiblioteca, Field atributo, Class<T> classeAnotacao) throws ErroCarregamentoBiblioteca
    {
        T anotacao;
        
        if ((anotacao = atributo.getAnnotation(classeAnotacao)) != null)
        {
            return anotacao;
        }
        
        throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o atributo '%s' não foi anotado com a anotação '%s'", atributo.getName(), classeAnotacao.getSimpleName()));
    }    
    
    private TipoDado obterTipoDadoMetodo(String nomeBiblioteca, Method metodo) throws ErroCarregamentoBiblioteca
    {
        Class classeTipo;
        
        if (eMatriz(metodo.getReturnType()))
        {
            classeTipo = obterTipoMatriz(metodo.getReturnType());
        }        
        else if (eVetor(metodo.getReturnType()))
        {
            classeTipo = obterTipoVetor(metodo.getReturnType());
        }
        
        else classeTipo = metodo.getReturnType();
        
        
        if (classeTipo == Integer.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o retorno do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", metodo.getName(), Integer.class.getName(), Integer.TYPE.getSimpleName()));
        if (classeTipo == Double.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o retorno do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", metodo.getName(), Double.class.getName(), Double.TYPE.getSimpleName()));
        if (classeTipo == Character.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o retorno do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", metodo.getName(), Character.class.getName(), Character.TYPE.getSimpleName()));
        if (classeTipo == Boolean.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o retorno do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", metodo.getName(), Boolean.class.getName(), Boolean.TYPE.getSimpleName()));
        if (classeTipo == Void.class) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o retorno do método '%s' deve ser do tipo primitivo '%s' ao invés do tipo '%s'", metodo.getName(), Void.TYPE.getName(), classeTipo.getName()));

        TipoDado tipoDado;
        
        if ((tipoDado = TipoDado.obterTipoDadoPeloTipoJava(classeTipo)) != null)
        {        
            return tipoDado;
        }
        
        throw new ErroCarregamentoBiblioteca
        (
            nomeBiblioteca, String.format("o retorno do método '%s' deve ser um dos tipos a seguir: '%s', '%s', '%s', '%s', '%s' ou '%s'", metodo.getName(), 
        
            TipoDado.CADEIA.getTipoJava().getName(),
            TipoDado.CARACTER.getTipoJava().getName(),
            TipoDado.INTEIRO.getTipoJava().getName(),
            TipoDado.LOGICO.getTipoJava().getName(),
            TipoDado.REAL.getTipoJava().getName(),
            TipoDado.VAZIO.getTipoJava().getName()
        ));
    }
    
    private TipoDado obterTipoDadoParametro(String nomeBiblioteca, Method metodo, int indice, String nomeParametro, Class classeTipo) throws ErroCarregamentoBiblioteca
    {
        if (classeTipo == Referencia.class)
        {
            if (eMatriz(classeTipo) || eVetor(classeTipo))
            {
                throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' não pode ser um vetor nem uma matriz de '%s'", nomeParametro, metodo.getName(), Referencia.class.getName()));
            }            
            
            if (metodo.getGenericParameterTypes()[indice] instanceof ParameterizedType)
            {
                classeTipo = (Class) ((ParameterizedType) metodo.getGenericParameterTypes()[indice]).getActualTypeArguments()[0];
            }
            
            else throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o tipo do parâmetro '%s' do método '%s' não foi especificado", nomeParametro, metodo.getName()));
        }
        
        if (eMatriz(classeTipo))
        {
            classeTipo = obterTipoMatriz(classeTipo);
        }        
        else if (eVetor(classeTipo))
        {
            classeTipo = obterTipoVetor(classeTipo);
        }
        
        if (classeTipo == Integer.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", nomeParametro, metodo.getName(), Integer.class.getName(), Integer.TYPE.getSimpleName()));
        if (classeTipo == Double.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", nomeParametro, metodo.getName(), Double.class.getName(), Double.TYPE.getSimpleName()));
        if (classeTipo == Character.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", nomeParametro, metodo.getName(), Character.class.getName(), Character.TYPE.getSimpleName()));
        if (classeTipo == Boolean.TYPE) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' deve ser do tipo '%s' ao invés do tipo primitivo '%s'", nomeParametro, metodo.getName(), Boolean.class.getName(), Boolean.TYPE.getSimpleName()));
        if ((classeTipo == Void.class || classeTipo == Void.TYPE)) throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("o parâmetro '%s' do método '%s' não pode ser do tipo primitivo '%s' nem do tipo '%s'", nomeParametro, metodo.getName(), Void.TYPE.getName(), classeTipo.getName()));

        TipoDado tipoDado;
        
        if ((tipoDado = TipoDado.obterTipoDadoPeloTipoJava(classeTipo)) != null)
        {        
            return tipoDado;
        }
        
        throw new ErroCarregamentoBiblioteca
        (
            nomeBiblioteca, String.format("o tipo do parâmetro '%s' do método '%s' deve ser um dos tipos a seguir: '%s', '%s', '%s', '%s', ou '%s'", nomeParametro, metodo.getName(),
        
            TipoDado.CADEIA.getTipoJava().getName(),
            TipoDado.CARACTER.getTipoJava().getName(),
            TipoDado.INTEIRO.getTipoJava().getName(),
            TipoDado.LOGICO.getTipoJava().getName(),
            TipoDado.REAL.getTipoJava().getName()
        ));
    }

    private boolean eVetor(Class classe)
    {
        return classe.isArray();
    }
    
    private boolean eMatriz(Class classe)
    {
        if (classe.isArray())
        {
            return classe.getComponentType().isArray();
        }
        
        return false;
    }
    
    private Class obterTipoVetor(Class classe)
    {
        return classe.getComponentType();
    }
    
    private Class obterTipoMatriz(Class classe)
    {
        return classe.getComponentType().getComponentType();
    }
    
    private <T extends Annotation> T obterAnotacaoMetodo(String nomeBiblioteca, Method metodo, Class<T> classeAnotacao) throws ErroCarregamentoBiblioteca
    {
        T anotacao;
        
        if ((anotacao = metodo.getAnnotation(classeAnotacao)) != null)
        {
            return anotacao;
        }
        
        throw new ErroCarregamentoBiblioteca(nomeBiblioteca, String.format("a função '%s' não foi anotada com a anotação '%s'", metodo.getName(), classeAnotacao.getSimpleName()));
    }    
    
    private boolean declaracaoValida(Class<? extends Biblioteca> classeBiblioteca) throws ErroCarregamentoBiblioteca
    {
        boolean publica = Modifier.isPublic(classeBiblioteca.getModifiers());
        boolean efinal = Modifier.isFinal(classeBiblioteca.getModifiers());
        boolean estatica = Modifier.isStatic(classeBiblioteca.getModifiers());
        boolean anonima = classeBiblioteca.isAnonymousClass();
        boolean sintetica = classeBiblioteca.isSynthetic();
        boolean membro = classeBiblioteca.isMemberClass();
        boolean local = classeBiblioteca.isLocalClass();
        
        return (publica && efinal && !estatica && !anonima && !sintetica && !membro && !local);
    }
    
    private String montarMensagemDeclaracaoInvalida(Class<? extends Biblioteca> classeBiblioteca)
    {
        if (!Modifier.isPublic(classeBiblioteca.getModifiers()))    return "a biblioteca deve ser pública";
        if (!Modifier.isFinal(classeBiblioteca.getModifiers()))     return "a biblioteca deve ser final";
        if (Modifier.isStatic(classeBiblioteca.getModifiers()))     return "a biblioteca não pode ser estática";
        if (classeBiblioteca.isAnonymousClass())                    return "a biblioteca não pode ser uma classe anônima";
        if (classeBiblioteca.isSynthetic())                         return "a biblioteca não pode ser uma classe sintética";
        if (classeBiblioteca.isMemberClass())                       return "a biblioteca não pode ser uma classe membro";
        if (classeBiblioteca.isLocalClass())                        return "a biblioteca não pode ser uma classe local";
        
        return null;
    }
}
