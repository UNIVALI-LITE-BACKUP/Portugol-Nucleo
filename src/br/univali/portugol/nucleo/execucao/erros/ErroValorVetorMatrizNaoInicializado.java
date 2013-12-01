package br.univali.portugol.nucleo.execucao.erros;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoReferencia;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroValorVetorMatrizNaoInicializado extends ErroExecucao
{
    private final NoReferencia referencia;
    private int linha;
    private int coluna;
    private int indice;
    
    public ErroValorVetorMatrizNaoInicializado(NoReferenciaVetor referenciaVetor, int indice)
    {
        this.referencia = referenciaVetor;
        this.indice = indice;
        this.setLinha(referencia.getTrechoCodigoFonteNome().getLinha());
        this.setColuna(referencia.getTrechoCodigoFonteNome().getColuna());        
    }

    public ErroValorVetorMatrizNaoInicializado(NoReferenciaMatriz referenciaMatriz, int linha, int coluna)
    {
        this.referencia = referenciaMatriz;
        this.linha = linha;
        this.coluna = coluna;
        this.setLinha(referencia.getTrechoCodigoFonteNome().getLinha());
        this.setColuna(referencia.getTrechoCodigoFonteNome().getColuna());
    }

    /**
     * {@inheritDoc }
     * 
     * @return  o texto da mensagem
     */
    @Override
    protected String construirMensagem()
    {        
        return new ConstrutorMensagem().construirMensagem();
    }
    
    private final class ConstrutorMensagem extends VisitanteASABasico
    {
        public ConstrutorMensagem()
        {
            
        }        
        
        public String construirMensagem()
        {
            try
            {
                return (String) referencia.aceitar(this);
            }
            catch (ExcecaoVisitaASA e)
            {
                return e.getMessage();
            }
        } 

        @Override
        public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
        {
            return String.format("O elemento do vetor '%s', na posição [%d] não foi inicializado", noReferenciaVetor.getNome(),indice);
        }

        @Override
        public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
        {
            return String.format("O elemento da matriz '%s', na linha [%d] e coluna [%d] não foi inicializado", noReferenciaMatriz.getNome(), linha, coluna);
        }
    }
}
