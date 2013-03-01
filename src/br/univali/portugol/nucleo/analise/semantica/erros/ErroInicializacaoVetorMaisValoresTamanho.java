package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

public class ErroInicializacaoVetorMaisValoresTamanho extends ErroSemantico
{

    private NoDeclaracaoVetor declaracaoVetor;
    private NoExpressao inicializacao;
    
    public ErroInicializacaoVetorMaisValoresTamanho(NoDeclaracaoVetor declaracaoVetor, NoExpressao inicializacao)
    {
        super(inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
        this.inicializacao = inicializacao;
        this.declaracaoVetor = declaracaoVetor;
    }

    @Override
    protected String construirMensagem()
    {
        return "Existe mais valores na inicialização do que o tamanho suportado pelo vetor '"+declaracaoVetor.getNome()+"'";
    }
    
    
}
