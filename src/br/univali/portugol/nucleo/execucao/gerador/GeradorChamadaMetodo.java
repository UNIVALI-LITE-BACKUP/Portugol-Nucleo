package br.univali.portugol.nucleo.execucao.gerador;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import br.univali.portugol.nucleo.bibliotecas.base.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Elieser
 */
class GeradorChamadaMetodo
{
    public void gera(NoChamadaFuncao no, PrintWriter saida, VisitanteASA visitor, ASAPrograma asa) throws ExcecaoVisitaASA
    {
        String escopoFuncao = (no.getEscopo() != null) ? (no.getEscopo() + ".") : "";
        String nomeFuncao = no.getNome();
        if (escopoFuncao.isEmpty() && "leia".equals(nomeFuncao)) //a função 'leia' tem um tratamento especial
        {
            geraCodigoParaFuncaoLeia(no, saida, visitor);
            return;
        }

        List<ParametroEsperado> parametrosEsperados = getParametrosEsperados(no, asa);

        //criaValueHoldersParaParametrosPorReferencia(metaDadosParametrosEsperados, no.getParametros());
        saida.format("%s%s(", escopoFuncao, Utils.geraNomeValido(nomeFuncao));
        List<NoExpressao> parametrosPassados = no.getParametros();

        int totalParametros = parametrosPassados.size();
        for (int i = 0; i < totalParametros; i++)
        {
            ParametroEsperado parametroEsperado = (i < parametrosEsperados.size()) ? parametrosEsperados.get(i) : null;
            NoExpressao parametroPassado = parametrosPassados.get(i);
            geraParametro(parametroPassado, parametroEsperado, saida, visitor);

            if (i < totalParametros - 1)
            {
                saida.append(", ");
            }
        }
        saida.append(")");
    }

    private void geraParametro(NoExpressao parametroRecebido, ParametroEsperado parametroEsperado, PrintWriter saida, VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        boolean precisaDeCast = false;
        boolean parametroEhOperacao = false;
        //boolean passandoPorReferencia = false;

        if (parametroEsperado != null)
        {
            TipoDado tipoEsperado = parametroEsperado.tipoDado;
            //ModoAcesso modoAcessoEsperado = metaDadosParametrosEsperados.get(i).modoAcesso;

            // verifica se é necessário fazer cast de um double para int quando o parâmetro esperado é int
            precisaDeCast = tipoEsperado == TipoDado.INTEIRO && parametroRecebido.getTipoResultante() == TipoDado.REAL;
            parametroEhOperacao = parametroRecebido instanceof NoOperacao;
            //passandoPorReferencia = modoAcessoEsperado == ModoAcesso.POR_REFERENCIA;
            if (precisaDeCast)
            {
                saida.append("(int)");
                if (parametroEhOperacao)
                {
                    saida.append("("); //coloca toda a operação que está sendo passada por parâmetro entre parênteses para que o cast seja aplicado em toda a operação
                }
            }
        }

        // verifica se é um parametro por referência
        //if (!passandoPorReferencia)
        //{
        parametroRecebido.aceitar(visitor);
        //}
        //else
        //{
        //    saida.append( "holder_")
        //            .append(((NoReferencia)parametrosPassados.get(i)).getNome());
        //}

        if (precisaDeCast && parametroEhOperacao)
        {
            saida.append(")");
        }
    }

    private class ParametroEsperado
    {
        public final TipoDado tipoDado;
        public final ModoAcesso modoAcesso;

        public ParametroEsperado(TipoDado tipoDado, ModoAcesso modoAcesso)
        {
            this.tipoDado = tipoDado;
            this.modoAcesso = modoAcesso;
        }
    }

    private List<ParametroEsperado> getParametrosEsperados(NoChamadaFuncao no, ASAPrograma asa)
    {
        List<ParametroEsperado> metaDados = new ArrayList<>();

        if (no.getEscopo() != null) // é uma função de biblioteca?
        {
            String nomeBiblioteca = Utils.getNomeBiblioteca(no.getEscopo(), asa);
            try
            {
                MetaDadosBiblioteca metadadosBiblioteca = GerenciadorBibliotecas.getInstance().obterMetaDadosBiblioteca(nomeBiblioteca);
                assert (metadadosBiblioteca != null);
                MetaDadosFuncao metaDadosFuncao = metadadosBiblioteca.obterMetaDadosFuncoes().obter(no.getNome());
                assert (metaDadosFuncao != null);
                MetaDadosParametros metaDadosParametros = metaDadosFuncao.obterMetaDadosParametros();
                int totalParametros = metaDadosParametros.quantidade();
                for (int i = 0; i < totalParametros; i++)
                {
                    TipoDado tipoDado = metaDadosParametros.obter(i).getTipoDado();
                    ModoAcesso modoAcesso = metaDadosParametros.obter(i).getModoAcesso();
                    String nome = metaDadosParametros.obter(i).getNome();
                    metaDados.add(new ParametroEsperado(tipoDado, modoAcesso));
                }
                return metaDados;
            }
            catch (ErroCarregamentoBiblioteca ex)
            {
                ex.printStackTrace();
            }
        }

        // é uma função comum
        if (no.getOrigemDaReferencia() != null)
        {
            List<NoDeclaracaoParametro> parametros = no.getOrigemDaReferencia().getParametros();
            for (NoDeclaracaoParametro parametro : parametros)
            {
                metaDados.add(new ParametroEsperado(parametro.getTipoDado(), parametro.getModoAcesso()));
            }
            return metaDados;
        }

        return Collections.EMPTY_LIST;
    }

    private void geraCodigoParaFuncaoLeia(NoChamadaFuncao no, PrintWriter saida, VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametros = no.getParametros();
        for (int i = 0; i < parametros.size(); i++)
        {
            NoReferencia noRef = (NoReferencia) parametros.get(i);

            Utils.geraNomeDaReferencia(noRef, saida, visitor); // gera nome da variável + colchetes de vetores ou matrizes incluíndo as expressões dos índices

            NoDeclaracao origem = noRef.getOrigemDaReferencia();
            TipoDado tipo = TipoDado.CADEIA;
            if (origem != null) // parece que tem um bug no leia passando 'cadeia' como parametro, a origem do 'leia' é nula
            {
                tipo = origem.getTipoDado();
            }
            String nomeFuncao = "leia" + Utils.getNomeTipoEmCamelCase(tipo);
            saida.format(" = %s()", nomeFuncao);
            if (i < parametros.size() - 1) // adiciona um ponto e vírgula depois de cada atribuição gerada, exceto para a última
            {
                saida.append(";").println();
            }
        }
    }

}
