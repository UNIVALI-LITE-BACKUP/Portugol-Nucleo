package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 *
 * Erro gerado pelo analisador sintático quando um parêntesis não foi aberto
 * ou fechado corretamente.
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *      funcao exemploErroAbreFechaParentesis()
 *      {
 *           inteiro valor
 * 
 *           valor = 2 * 5 + 3)     // Gera um erro, pois o parêntesis não foi aberto no início da expressão
 *           valor = 2 * (5 + 3     // Gera um erro, pois o parêntesis não foi fechado no final da expressão
 *      }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noschang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 */
public final class ErroAbreFechaParentesis extends ErroSintatico
{
    private String tokenParenteses;
            
    /**
     * 
     * @param linha                a linha onde o erro ocorreu.  
     * @param coluna               a coluna onde o erro ocorreu.
     * @param tokenParenteses      token utilizado para identificar a natureza do erro. 
     *                             Se o token for igual a "(", faltou abrir o parêntesis, se o token for ")" 
     *                             faltou fechar o parêntesis.
     * @since 1.0
     */
    public ErroAbreFechaParentesis(int linha, int coluna, String tokenParenteses)
    {
        super(linha, coluna);
        this.tokenParenteses = tokenParenteses;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("A expressão não foi ");
        
        if (tokenParenteses.equals("("))
            construtorTexto.append("iniciada");
        
        else
            
        if (tokenParenteses.equals(")"))
            construtorTexto.append("finalizada");
        
        construtorTexto.append(" corretamente. Insira o caracter '");
        construtorTexto.append(tokenParenteses);
        construtorTexto.append("' para corrigir o problema.");
        
        return construtorTexto.toString();
    }
}
