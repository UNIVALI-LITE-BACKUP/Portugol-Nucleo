package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 *
 */

public final class ErroSimboloNaoDeclarado extends ErroSemantico
{
    private NoReferencia referencia;

    public ErroSimboloNaoDeclarado(NoReferencia referencia)
    {
        super
        (
            referencia.getTrechoCodigoFonteNome().getLinha(),
            referencia.getTrechoCodigoFonteNome().getColuna()
        );

        this.referencia = referencia;
    }

    public NoReferencia getReferencia()
    {
        return referencia;
    }

    @Override
    protected String construirMensagem()
    {
        if (referencia instanceof NoReferenciaVetor) return construirMensagemVetor();
        if (referencia instanceof NoReferenciaMatriz) return construirMensagemMatriz();
        if (referencia instanceof NoReferenciaVariavel) return construirMensagemVariavel();
        if (referencia instanceof NoChamadaFuncao) return construirMensagemFuncao();

        return null;
    }

    private String construirMensagemVetor()
    {
        StringBuilder construtorTexto = new StringBuilder();

        construtorTexto.append("O vetor \"");
        construtorTexto.append(referencia.getNome());
        construtorTexto.append("\" não foi declarado neste escopo.");

        return construtorTexto.toString();
    }

    private String construirMensagemMatriz()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A matriz \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }

    private String construirMensagemVariavel()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A variável \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }

    private String construirMensagemFuncao()
    {
        StringBuilder construtorString = new StringBuilder();

        construtorString.append("A função \"");
        construtorString.append(referencia.getNome());
        construtorString.append("\" não foi declarada neste escopo.");

        return construtorString.toString();
    }
}