package br.univali.portugol.nucleo;

import br.univali.portugol.nucleo.analise.AnalisadorAlgoritmo;
import br.univali.portugol.nucleo.analise.ResultadoAnalise;
import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para abstrair as etapas necessárias à compilação do código fonte
 *
 * @author Luiz Fernando Noschang
 */
final class Compilador
{
    private static final String funcaoInicialPadrao = "inicio";
    private static final String[] funcoesEspeciais = new String[] { "limpa", "leia", "escreva" };
    
    private final LocalizadorFuncoes localizadorFuncoes = new LocalizadorFuncoes();
    
    /**
     * Compila o código fonte em Portugol para um programa. Realiza a análise sintática
     * e semântica para garantir que não há erros no código.
     * 
     * @param codigo  o código fonte em Portugol a ser compilado
     * @return  o programa equivalente ao código fonte passado
     * 
     * @throws ErroCompilacao 
     */
    public Programa compilar(String codigo) throws ErroCompilacao
    {
        AnalisadorAlgoritmo analisadorAlgoritmo = new AnalisadorAlgoritmo();
        ResultadoAnalise resultadoAnalise = analisadorAlgoritmo.analisar(codigo);

        if (!resultadoAnalise.contemErros())
        {
            ArvoreSintaticaAbstrataPrograma asa = (ArvoreSintaticaAbstrataPrograma) analisadorAlgoritmo.getArvoreSintaticaAbstrata();
        
            Programa programa = geraPrograma();
            programa.setFuncoes(localizadorFuncoes.getFuncoes(asa));
            programa.setFuncaoInicial(localizadorFuncoes.getFuncaoInicial());
            programa.setArvoreSintaticaAbstrata(asa);
            programa.setResultadoAnalise(resultadoAnalise);

        return programa;
        }
        else
        {
            throw new ErroCompilacao(resultadoAnalise);
        }
    }
    
    private Programa geraPrograma()
    {
        // 1 - gera o código
        // 2 - manda o código gerado para o javac
        // 3 - instancia a classe que vai extender 'Programa'
        // 4 - retorna o programa gerado
        
        return null; //TODO invoca o javac para compilar o programa
    }
            
    private final class LocalizadorFuncoes extends VisitanteASABasico
    {
        private final List<String> funcoes = new ArrayList<>();
        
        public List<String> getFuncoes(ArvoreSintaticaAbstrataPrograma asa)
        {
            try
            {
                asa.aceitar(this);
            }
            catch (ExcecaoVisitaASA excecaoVisitaASA)
            {
                excecaoVisitaASA.printStackTrace(System.out);
            }

            return funcoes;               
        }

        public String getFuncaoInicial()
        {
            for (String funcao : funcoes)
            {
                if (funcao.equals(funcaoInicialPadrao))
                {
                    return funcaoInicialPadrao;
                }
            }

            if (!funcoes.isEmpty())
            {
                return funcoes.get(0);
            }

            return funcaoInicialPadrao;
        }

        private boolean estaNaListaNegra(String funcao)
        {
            for (String func : funcoesEspeciais)
            {
                if (funcao.equals(func))
                {
                    return true;
                }
            }

            return false;
        }
        
        @Override
        public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
        {
            List<NoDeclaracao> declaracoes = asap.getListaDeclaracoesGlobais();

            if (declaracoes != null)
            {
                for (NoDeclaracao declaracao : declaracoes)
                {
                    if (!estaNaListaNegra(declaracao.getNome()))
                    {                    
                        declaracao.aceitar(this);                
                    }
                }
            }

            return null;
        }
        
        @Override
        public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
        {
            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
        {
            return null;
        }

        @Override
        public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
        {
            return null;
        }        

        @Override
        public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
        {
            funcoes.add(declaracaoFuncao.getNome());

            return null;
        }
    }
}
