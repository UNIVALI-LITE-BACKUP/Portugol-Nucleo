/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.analise.semantica;

import br.univali.portugol.nucleo.analise.semantica.erros.ExcecaoImpossivelDeterminarTipoDado;
import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.asa.TipoDado;

/**
 *
 * @author fillipi
 */
public interface TabelaCompatibilidadeTipos
{
    public TipoDado getRetorno(Class<? extends NoOperacao> operacao, TipoDado tipoDadoOperandoEsquerdo, TipoDado tipoDadoOperandoDireito) throws ExcecaoImpossivelDeterminarTipoDado;
}
