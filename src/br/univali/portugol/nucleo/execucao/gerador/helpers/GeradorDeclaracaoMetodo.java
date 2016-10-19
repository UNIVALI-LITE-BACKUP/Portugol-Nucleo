package br.univali.portugol.nucleo.execucao.gerador.helpers;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorDeclaracaoMetodo
{
    public void gera(NoDeclaracaoFuncao noFuncao, PrintWriter saida, VisitanteASA visitor, int nivelEscopo, boolean gerandoCodigoParaTesteUnitario) throws ExcecaoVisitaASA
    {
        saida.println();

        String identacao = Utils.geraIdentacao(nivelEscopo);

        String nome = noFuncao.getNome();
        boolean metodoPrincipal = "inicio".equals(nome);
        if (metodoPrincipal)
        {
            nome = "executar";
            saida.append(identacao);
            saida.append("@Override").println();
        }

        saida.append(identacao)
                .append(metodoPrincipal ? "protected" : "private")
                .append(" ")
                .append(Utils.getNomeTipoJava(noFuncao.getTipoDado()))
                .append(geraQuantificador(noFuncao.getQuantificador()))
                .append(" ")
                .append(Utils.geraNomeValido(nome));

        if (!metodoPrincipal)
        {
            geraParametros(noFuncao, saida);
        }
        else
        {
            saida.append("(String[] parametros)");
        }
        saida.append(" throws ErroExecucao, InterruptedException");
        saida.println(); // pula uma linha depois da declaração da assinatura do método
        saida.append(identacao).append("{").println(); // inicia o escopo do método

        Utils.geraVerificacaoThreadInterrompida(saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

        Utils.geraParadaPassoAPasso(noFuncao, saida, nivelEscopo, gerandoCodigoParaTesteUnitario);

        Utils.visitarBlocos(noFuncao.getBlocos(), saida, visitor, nivelEscopo, gerandoCodigoParaTesteUnitario); // gera o código dentro do método

        saida.println();
        saida.append(identacao).append("}").println(); // finaliza o escopo do método
        saida.println(); // linha em branco depois de cada método
    }

    private static String geraQuantificador(Quantificador quantificador)
    {
        switch (quantificador)
        {
            case VETOR:
                return "[]";
            case MATRIZ:
                return "[][]";
        }
        return "";
    }

    private static void geraParametros(NoDeclaracaoFuncao noFuncao, PrintWriter saida)
    {
        List<NoDeclaracaoParametro> parametros = noFuncao.getParametros();

        saida.append("("); // parenteses de início da lista de parâmetros
        int size = parametros.size();
        for (int i = 0; i < size; i++)
        {
            NoDeclaracaoParametro noParametro = parametros.get(i);
            if (noParametro.getModoAcesso() == ModoAcesso.POR_VALOR) {
                geraParametroPorValor(noParametro, saida);
            }
            else{
                geraParametroPorReferencia(noParametro, saida);
            }

            if (i < size - 1)
            {
                saida.append(", ");
            }
        }
        saida.append(")"); // parenteses de fim da lista de parâmetros
    }
    
    private static void geraParametroPorReferencia(NoDeclaracaoParametro noParametro, PrintWriter saida)
    {
        // os parâmetros por referência são apenas índices para o array REFERENCIAS[]
        saida.append("int ")
            .append(noParametro.getNome());
    }
    
    private static void geraParametroPorValor(NoDeclaracaoParametro noParametro, PrintWriter saida)
    {
        saida.append(Utils.getNomeTipoJava(noParametro.getTipoDado()))
                    .append(" ") // espaço entre o tipo e o nome
                    .append(Utils.geraNomeValido(noParametro.getNome()))
                    .append(geraQuantificador(noParametro.getQuantificador()));
    }

}
