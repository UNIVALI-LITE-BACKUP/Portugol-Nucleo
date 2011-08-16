/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.excecoes;

import java.io.File;

/**
 *
 * @author fillipi
 */
public class ErroNomeIncompativel extends Erro{

    
    
    public ErroNomeIncompativel(File arquivo, int linha, int coluna) {
        super(arquivo, linha, coluna);
    }

    @Override
    protected String construirMensagem() {
        return "Problema na nomeclatura da declaração, uma declaração deve iniciar com lestras";
    }
    
    
    
}
