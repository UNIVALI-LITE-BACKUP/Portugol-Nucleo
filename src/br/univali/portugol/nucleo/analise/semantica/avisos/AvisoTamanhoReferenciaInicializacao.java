package br.univali.portugol.nucleo.analise.semantica.avisos;

import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.simbolos.Simbolo;

public class AvisoTamanhoReferenciaInicializacao extends AvisoAnalise
{
    private NoDeclaracaoVetor noDeclaracaoVetor;
    private Simbolo simbolo;
    
    public AvisoTamanhoReferenciaInicializacao(Simbolo simbolo, NoDeclaracaoVetor declaracaoVetor, NoExpressao inicializacao)
    {
        
        super(inicializacao.getTrechoCodigoFonte());
        this.simbolo = simbolo;
        this.noDeclaracaoVetor = declaracaoVetor;
    }

    @Override
    protected String construirMensagem()
    {
        return "O tamanho do vetor '"+noDeclaracaoVetor.getNome()+"' foi indicado com a variável '"+simbolo.getNome()+
                "' é possível que a inicialização seja maior que o tamanho do vetor";
    }
    
}
