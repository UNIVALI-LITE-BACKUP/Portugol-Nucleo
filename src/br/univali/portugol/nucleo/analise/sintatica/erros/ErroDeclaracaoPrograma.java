
package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * @author Luiz Fernando Noschang
 * 
 */

public final class ErroDeclaracaoPrograma extends ErroSintatico
{
    private String textoToken_PR_PROGRAMA;
    
    public ErroDeclaracaoPrograma(int linha, int coluna, String textoToken_PR_PROGRAMA)
    {
        super(linha, coluna);
        this.textoToken_PR_PROGRAMA = textoToken_PR_PROGRAMA;
    }    
    
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("Todo algoritmo deve iniciar com a declaração de um programa.");
        construtorTexto.append("No entanto, a declaração de programa não está presente no seu algoritmo ou ela contém erros.\n");
        construtorTexto.append("Verifique se você não esqueceu de digitar a palavra reservada \"");
        construtorTexto.append(textoToken_PR_PROGRAMA);
        construtorTexto.append("\" ou os delimitadores de escopo \"{\" \"}\".\n\n");
        construtorTexto.append("Uma declaração de programa correta deve utilizar a seguinte sintaxe:\n\n");
        construtorTexto.append(textoToken_PR_PROGRAMA);
        construtorTexto.append("\n{\n\n\n}");
                
        return construtorTexto.toString();
    }
}
