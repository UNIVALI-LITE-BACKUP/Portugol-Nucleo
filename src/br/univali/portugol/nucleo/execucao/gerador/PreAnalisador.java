package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.asa.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Elieser
 */
class PreAnalisador extends VisitanteNulo
{

    private final Map<TipoDado, List<NoDeclaracaoVariavel>> declaracoes = new HashMap<>();
    private final Set<NoDeclaracaoFuncao> funcoesInvocadas = new HashSet<>(); // guarda apenas as funções que foram invocadas, as funções que não são invocadas não serão geradas no código Java

    @Override
    public Void visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        NoDeclaracaoFuncao declaracaoFuncao = chamadaFuncao.getOrigemDaReferencia();
        if (!funcoesInvocadas.contains(declaracaoFuncao))
        {
            funcoesInvocadas.add(declaracaoFuncao);
        }
        
        List<NoExpressao> parametrosPassados = chamadaFuncao.getParametros();
        List<NoDeclaracaoParametro> parametrosEsperados = Collections.EMPTY_LIST;
        if (declaracaoFuncao != null)
        {
            parametrosEsperados = declaracaoFuncao.getParametros();
        }

        for (int i = 0; i < parametrosPassados.size(); i++)
        {
            NoExpressao parametroPassado = parametrosPassados.get(i);
            NoDeclaracaoParametro parametroEsperado = (i < parametrosEsperados.size()) ? parametrosEsperados.get(i) : null;
            if (parametroPassado instanceof NoReferenciaVariavel)
            {
                if (parametroEsperado != null && parametroEsperado.getModoAcesso() == ModoAcesso.POR_REFERENCIA && chamadaFuncao.getEscopo() == null)
                {
                    NoReferenciaVariavel referencia = (NoReferenciaVariavel) parametroPassado;
                    if (referencia.getOrigemDaReferencia() instanceof NoDeclaracaoVariavel)
                    {
                        NoDeclaracaoVariavel origemReferencia = (NoDeclaracaoVariavel)referencia.getOrigemDaReferencia();
                    
                        TipoDado tipoOrigem = origemReferencia.getTipoDado();
                        if (!declaracoes.containsKey(tipoOrigem)) // verifica se é necessário criar uma lista para guardar as variáveis do tipo do nó de origem
                        {
                            declaracoes.put(tipoOrigem, new ArrayList<NoDeclaracaoVariavel>());
                        }
                    
                        List<NoDeclaracaoVariavel> variaveis = declaracoes.get(tipoOrigem);
                        if (!variaveis.contains(origemReferencia))
                        {
                            int indice = variaveis.size();
                            referencia.setIndiceReferencia(indice);
                            origemReferencia.setIndiceReferencia(indice);
                            variaveis.add(origemReferencia);
                            for (NoReferencia ref : origemReferencia.getReferencias())
                            {
                                NoReferenciaVariavel origem = (NoReferenciaVariavel) ref;
                                origem.setIndiceReferencia(indice);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel no) throws ExcecaoVisitaASA
    {
        if (no.getInicializacao() != null)
        {
            no.getInicializacao().aceitar(this);
        }
        return null;
    }

    @Override
    public Object visitar(NoOperacaoAtribuicao no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    @Override
    public Object visitar(NoOperacaoSoma no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    @Override
    public Object visitar(NoOperacaoSubtracao no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    @Override
    public Object visitar(NoOperacaoModulo no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    @Override
    public Object visitar(NoOperacaoMultiplicacao no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    @Override
    public Object visitar(NoOperacaoDivisao no) throws ExcecaoVisitaASA
    {
        no.getOperandoEsquerdo().aceitar(this);
        no.getOperandoDireito().aceitar(this);
        return null;
    }

    public Map<TipoDado, List<NoDeclaracaoVariavel>> getVariaveisPassadasPorReferencia()
    {
        return declaracoes;
    }

    public Set<NoDeclaracaoFuncao> getFuncoesQuerForamInvocadas()
    {
        return funcoesInvocadas;
    }
    
    @Override
    public Object visitar(ASAPrograma asa) throws ExcecaoVisitaASA
    {
        for (NoDeclaracao declaracao : asa.getListaDeclaracoesGlobais())
        {
            declaracao.aceitar(this);
        }
        return null;
    }

    @Override
    public Object visitar(NoDeclaracaoFuncao no) throws ExcecaoVisitaASA
    {
        for (NoBloco bloco : no.getBlocos())
        {
            bloco.aceitar(this);
        }
        return null;
    }


}
