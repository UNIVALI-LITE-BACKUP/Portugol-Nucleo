package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

public final class ErroInicializacaoInvalida extends ErroSemantico
{
    private final NoExpressao inicializacao;
    private final NoDeclaracao declaracao;
    private Simbolo simbolo;

    public ErroInicializacaoInvalida(NoDeclaracao declaracao)
    {
       
        super(declaracao.getInicializacao().getTrechoCodigoFonte());
        this.declaracao = declaracao;
        this.inicializacao = declaracao.getInicializacao();
    }

    public ErroInicializacaoInvalida(Simbolo simbolo, NoDeclaracao declaracao)
    {
        this(declaracao);
        this.simbolo = simbolo;
    }
    
    @Override
    protected String construirMensagem()
    {
        StringBuilder builder = new StringBuilder();
        String direito = null;
        builder.append("Não é possível inicializar ");
        
        if (declaracao instanceof NoDeclaracaoVariavel)
        {
            direito = "a variável '%s' ";
        }
        else if (declaracao instanceof NoDeclaracaoVetor)
        {
            direito = "o vetor '%s' ";
        }
        else if (declaracao instanceof NoDeclaracaoMatriz)
        {
            direito = "a matriz '%s' ";
        }
        
        builder.append(String.format(direito, declaracao.getNome()));
        
        String esquerdo = null;
        
        if (inicializacao instanceof NoVetor)
        {
            builder.append("com um vetor");
        }
        else if (inicializacao instanceof NoMatriz)
        {
            builder.append("com uma matriz");
        }
        else if (inicializacao instanceof NoReferenciaVariavel){
            if (simbolo != null){
                if (simbolo instanceof Variavel)
                {
                    esquerdo = "com o valor da variável '%s'";
                }
                else if (simbolo instanceof Vetor)
                {
                    esquerdo = "com os valores do vetor '%s'";
                }
                else if (simbolo instanceof Matriz)
                {
                    esquerdo ="os valores da matriz '%s'";
                }
                builder.append(String.format(esquerdo,simbolo.getNome()));
            }
        } else {
            builder.append("com um valor ou uma expressão");
        }
        
        return builder.toString();
    }
    
}
