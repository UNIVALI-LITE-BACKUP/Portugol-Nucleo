package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

public class ErroAtribuicaoInvalida extends ErroSemantico
{
    private final NoExpressao inicializacao;
    private final NoDeclaracao declaracao;
    private Simbolo simbolo;

    public ErroAtribuicaoInvalida(NoDeclaracao declaracao, NoExpressao inicializacao, int linha, int coluna)
    {
        super(linha, coluna);
        this.declaracao = declaracao;
        this.inicializacao = inicializacao;
    }

    public ErroAtribuicaoInvalida(Simbolo simbolo, NoDeclaracao declaracao, NoExpressao inicializacao, int linha, int coluna)
    {
        this(declaracao,inicializacao,linha, coluna);
        this.simbolo = simbolo;
    }
    
    @Override
    protected String construirMensagem()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Não é possível atribuir ");
        
        if (inicializacao instanceof NoVetor)
            builder.append("um vetor ");
        else if (inicializacao instanceof NoMatriz)
            builder.append("uma matriz ");
        else if (inicializacao instanceof NoReferenciaVariavel){
            if (simbolo != null){
                if (simbolo instanceof Variavel)
                    builder.append("o valor de uma variável ");
                else if (simbolo instanceof Vetor)
                    builder.append("uma referência de um vetor ");
                else if (simbolo instanceof Matriz)
                    builder.append("uma referência de uma matriz ");
            }
        } else {
            builder.append("um valor ");
        }
        
        builder.append("à ");
        
        if (declaracao instanceof NoDeclaracaoVariavel)
            builder.append("uma variável");
        else if (declaracao instanceof NoDeclaracaoVetor)
            builder.append("um vetor");
        else if (declaracao instanceof NoDeclaracaoMatriz)
            builder.append("uma matriz");
        
        return builder.toString();
    }
    
}
