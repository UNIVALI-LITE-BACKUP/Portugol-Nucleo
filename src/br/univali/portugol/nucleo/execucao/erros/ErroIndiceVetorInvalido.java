package br.univali.portugol.nucleo.execucao.erros;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroIndiceVetorInvalido extends ErroExecucao
{           
    private int tamanhoVetor;
    private int indiceAcessado;
    private String nomeVetor;
    
    public ErroIndiceVetorInvalido(int tamanhoVetor, int indiceAcessado, String nomeVetor) 
    {
        this.tamanhoVetor = tamanhoVetor;
        this.indiceAcessado = indiceAcessado;
        this.nomeVetor = nomeVetor;                
    }

    @Override
    protected String construirMensagem() 
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("O índice [");
        construtorTexto.append(indiceAcessado);
        construtorTexto.append("] é inválido para o vetor \"");
        construtorTexto.append(nomeVetor);
        construtorTexto.append("\". O vetor ");
        
        if (tamanhoVetor == 0)
            construtorTexto.append("não possui elementos.");
        
        else
        {
            construtorTexto.append("possui ");
            construtorTexto.append(tamanhoVetor);
            
            if (tamanhoVetor == 1)
            construtorTexto.append(" elemento.");
        
            else construtorTexto.append(" elementos.");
        }
        
        return construtorTexto.toString();
    }
}
