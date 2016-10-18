package br.univali.portugol.nucleo.execucao.gerador.helpers;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorSwitchCase
{
    public static final String NOME_VARIAVEL_BREAK = "___sw_break___";

    public void geraSwitchCase(NoEscolha no, PrintWriter saida, VisitanteASA visitor, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario) throws ExcecaoVisitaASA
    {
        String identacao = Utils.geraIdentacao(nivelEscopo);

        saida.append("switch(");

        no.getExpressao().aceitar(visitor);

        saida.append(")").println();
        saida.append(identacao).append("{").println();

        List<NoCaso> casos = no.getCasos();
        if (casos != null)
        {
            for (NoCaso caso : casos)
            {
                NoExpressao expressaoCaso = caso.getExpressao();
                if (expressaoCaso != null)
                {
                    saida.append(identacao).append("case ");

                    expressaoCaso.aceitar(visitor);

                    saida.append(":").println();
                }
                else
                {
                    saida.append(identacao).append("default:");
                }

                Utils.visitarBlocos(caso.getBlocos(), saida, visitor, nivelEscopo, gerandoCodigoParaTesteUnitario);

                saida.println();
            }
        }

        saida.append(identacao).append("}").println();

    }

    public void geraSeSenao(NoEscolha noEscolha, PrintWriter saida, VisitanteASA visitor, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario) throws ExcecaoVisitaASA
    {

        Utils.geraParadaPassoAPasso(noEscolha.getExpressao(), saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

        saida.append("{").println();
        
        String identacao = Utils.geraIdentacao(nivelEscopo);

        saida.append(identacao);
        saida.append("boolean ").append(NOME_VARIAVEL_BREAK).append(" = false;");
        
        saida.println();

        List<NoCaso> casos = noEscolha.getCasos();

        for (NoCaso noCaso : casos)
        {
            NoExpressao verificacaoBreak = new NoNao(new NoReferenciaVariavel(null, NOME_VARIAVEL_BREAK));
            NoExpressao comparacaoCaso;

            // case default: 
            if (noCaso.getExpressao() == null)
            {
                comparacaoCaso = new NoLogico(true);
            }
            else
            {
                // case expressao_nao_constante:
                comparacaoCaso = new NoOperacaoLogicaIgualdade(noEscolha.getExpressao(), noCaso.getExpressao());
            }

            NoExpressao condicao = new NoOperacaoLogicaE(verificacaoBreak, comparacaoCaso);

            if (noCaso.getExpressao() != null)
            {
                condicao.setTrechoCodigoFonte(noCaso.getExpressao().getTrechoCodigoFonte());
            }

            NoSe se = new NoSe(condicao);
            se.setBlocosVerdadeiros(noCaso.getBlocos());

            Utils.geraParadaPassoAPasso(se, saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

            saida.append(identacao);
            
            se.aceitar(visitor);
            
            saida.println();
        }

        saida.append("}");
    }

    public static boolean contemCasosNaoConstantes(NoEscolha noEscolha)
    {
        List<NoCaso> casos = noEscolha.getCasos();
        for (NoCaso caso : casos)
        {
            if (caso.getExpressao() != null)
            {
                if (!(caso.getExpressao() instanceof NoExpressaoLiteral))
                {
                    return true;
                }
            }
        }

        return false;
    }

}
