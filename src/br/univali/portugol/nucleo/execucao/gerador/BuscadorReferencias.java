package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.asa.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Elieser
 */
class BuscadorReferencias extends VisitanteNulo
{

    private final List<NoDeclaracaoVariavel> declaracoes = new ArrayList<>();
    private int indiceReferencia = 0;

    @Override
    public Void visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
        NoDeclaracaoFuncao declaracaoFuncao = chamadaFuncao.getOrigemDaReferencia();
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
                    NoDeclaracaoVariavel origemReferencia = (NoDeclaracaoVariavel) referencia.getOrigemDaReferencia();
                    if (!declaracoes.contains(origemReferencia))
                    {
                        referencia.setIndiceReferencia(indiceReferencia);
                        origemReferencia.setIndiceReferencia(indiceReferencia);
                        declaracoes.add(origemReferencia);
                        for (NoReferencia ref : origemReferencia.getReferencias())
                        {
                            NoReferenciaVariavel origem = (NoReferenciaVariavel) ref;
                            origem.setIndiceReferencia(indiceReferencia);
                        }
                        indiceReferencia++;
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

    public Collection<NoDeclaracaoVariavel> getVariaveisPassadasPorReferencia()
    {
        return new ArrayList<>(declaracoes);
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
