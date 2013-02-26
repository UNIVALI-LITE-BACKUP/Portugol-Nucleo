package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

public class ErroReferenciaInvalida extends ErroSemantico
{
    private final NoExpressao expressao;
    private final Simbolo simbolo;

    public ErroReferenciaInvalida(NoExpressao expressao, Simbolo simbolo, int linha, int coluna)
    {
        super(linha,coluna);
        this.expressao = expressao;
        this.simbolo = simbolo;
    }

    @Override
    protected String construirMensagem()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        if (simbolo instanceof Vetor)
            stringBuilder.append("O vetor está sendo utilizado como ");
        else if (simbolo instanceof Matriz)
            stringBuilder.append("A matriz está sendo utilizada como ");
        else if (simbolo instanceof Variavel)
            stringBuilder.append("A variável está sendo utilizada como ");
        
        
        if (expressao instanceof NoReferenciaVariavel)
            stringBuilder.append("uma variável");
        else if (expressao instanceof NoReferenciaMatriz)
            stringBuilder.append("uma matriz");
        else if (expressao instanceof NoReferenciaVetor)
            stringBuilder.append("um vetor");
        
        
        return stringBuilder.toString();
    }    
}
