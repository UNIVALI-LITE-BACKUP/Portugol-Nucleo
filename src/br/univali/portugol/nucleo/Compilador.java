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
 *
 * @author Luiz Fernando Noschang
 */
final class Compilador extends VisitanteASABasico
{
    private static final String funcaoInicialPadrao = "inicio";
    private static final String[] funcoesEspeciais = new String[] { "potencia", "raiz_quadrada", "aguarde", "limpa", "tamanho_vetor", "tamanho_matriz", "leia", "escreva", "sorteia" };
    
    private List<String> funcoes = new ArrayList<String>();
            
    public Programa compilar(String codigo) throws ErroCompilacao
    {
        AnalisadorAlgoritmo analisadorAlgoritmo = new AnalisadorAlgoritmo();
        ResultadoAnalise resultadoAnalise = analisadorAlgoritmo.analisar(codigo);

        if (resultadoAnalise.getNumeroTotalErros() > 0)
        {
            throw new ErroCompilacao(resultadoAnalise);
        }

        ArvoreSintaticaAbstrataPrograma asa = (ArvoreSintaticaAbstrataPrograma) analisadorAlgoritmo.getArvoreSintaticaAbstrata();
        
        Programa programa = new Programa();
        programa.setCodigo(codigo);
        programa.setFuncoes(listarFuncoes(asa));        
        programa.setFuncaoInicial(detectarFuncaoInicial());
        programa.setArvoreSintaticaAbstrataPrograma(asa);

        return programa;
    }

    private List<String> listarFuncoes(ArvoreSintaticaAbstrataPrograma asa)
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
    
    private String detectarFuncaoInicial()
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
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {
        funcoes.add(declaracaoFuncao.getNome());
        
        return null;
    }
}
