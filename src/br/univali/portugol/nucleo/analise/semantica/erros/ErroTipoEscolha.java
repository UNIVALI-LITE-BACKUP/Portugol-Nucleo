package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoEscolha;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

public class ErroTipoEscolha extends ErroSemantico
{
    private final TipoDado tipoEncontrado;

    public ErroTipoEscolha(NoEscolha escolha, TipoDado tipoEncontrado)
    {
        super(escolha.getExpressao().getTrechoCodigoFonte().getLinha(), escolha.getExpressao().getTrechoCodigoFonte().getColuna());
        this.tipoEncontrado = tipoEncontrado;
    }

    @Override
    protected String construirMensagem()
    { 
        return "Tipos incompatíveis! O bloco \"escolha\" espera uma expressão do \"inteiro\" ou \"caracter\" e  mas foi passada uma expressão do tipo \""+tipoEncontrado+"\".";
    }
    
}
