package br.univali.portugol.nucleo.analise.semantica.avisos;

import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;

public class AvisoInicializacaoVetorMaisValoresTamanho extends AvisoAnalise
{

    private NoDeclaracaoVetor declaracaoVetor;
    
    public AvisoInicializacaoVetorMaisValoresTamanho(NoDeclaracaoVetor declaracaoVetor, NoExpressao inicializacao)
    {
        super(inicializacao.getTrechoCodigoFonte().getLinha(), inicializacao.getTrechoCodigoFonte().getColuna());
        this.declaracaoVetor = declaracaoVetor;
    }

    @Override
    protected String construirMensagem()
    {
        return "Existe mais valores na inicialização do que o tamanho suportado pelo vetor '"+declaracaoVetor.getNome()+"'";
    }
    
    
}
