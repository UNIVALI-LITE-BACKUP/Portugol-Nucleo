package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;

/**
 * Erro gerado pelo analisador sintático quando um escopo não foi fechado corretamente
 * pela omissão do token "}".
 * <p>
 * Exemplo:
 * <code><pre>
 * 
 *     funcao exemploEscopo()
 *     {
 *          enquanto (verdadeiro)
 *          {
 *               // Gera um erro
 *          
 *     }
 * 
 * </pre></code>
 * 
 * @author Luiz Fernando Noscgang
 * @version 1.0
 * 
 * @see AnalisadorSintatico
 * @see ErroEscopoNaoFoiAbertoCorretamente
 */
public final class ErroEscopoNaoFoiFechadoCorretamente extends ErroSintatico
{
    private String contexto;

    /**
     * 
     * @param linha        a linha onde o erro ocorreu.
     * @param coluna       a coluna onde o erro ocorreu.
     * @param contexto     o contexto/escopo em que o analisador sintático se encontrava quando o erro ocorreu.
     * @since 1.0
     */    
    public ErroEscopoNaoFoiFechadoCorretamente(int linha, int coluna, String contexto)
    {
        super(linha, coluna);
        this.contexto = contexto;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        StringBuilder construtorTexto = new StringBuilder();
        
        construtorTexto.append("O escopo ");
        
        if (contexto.equals("programa"))
            construtorTexto.append(" do programa ");
        
        else
            
        if (contexto.equals("declaracaoFuncao"))
            construtorTexto.append(" da função ");
        
        else construtorTexto.append(" do bloco ");
        
        construtorTexto.append("não foi fechado corretamente. Insira o caracter '}' para corrigir o problema.");
        
        return construtorTexto.toString();
    }
}
