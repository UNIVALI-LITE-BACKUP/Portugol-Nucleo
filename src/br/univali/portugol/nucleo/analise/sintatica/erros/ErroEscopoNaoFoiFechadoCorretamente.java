package br.univali.portugol.nucleo.analise.sintatica.erros;

import br.univali.portugol.nucleo.analise.sintatica.AnalisadorSintatico;
import br.univali.portugol.nucleo.mensagens.ErroSintatico;
import java.util.Stack;

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
    private Stack<String> pilhaContexto;

    /**
     * 
     * @param linha        a linha onde o erro ocorreu.
     * @param coluna       a coluna onde o erro ocorreu.
     * @param contexto     o contexto/escopo em que o analisador sintático se encontrava quando o erro ocorreu.
     * @since 1.0
     */    
    public ErroEscopoNaoFoiFechadoCorretamente(int linha, int coluna, Stack<String> pilhaContexto, String codigoFonte)
    {
        super(linha, coluna);
        this.pilhaContexto = pilhaContexto;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {
        String contexto = pilhaContexto.pop();
        
        StringBuilder construtorTexto = new StringBuilder();
        
        if (contexto.equals("programa"))
        {
            construtorTexto.append("O escopo do programa não foi fechado corretamente. Insira o caracter '}' para corrigir o problema");
        }
        else
        {
            construtorTexto.append("O escopo ");
            
            if (contexto.equals("declaracaoFuncao"))
            {
                construtorTexto.append(" da função ");
            }
            else
            {
                construtorTexto.append(" do bloco ");
            }
        
            construtorTexto.append("não foi fechado corretamente. Insira o caracter '}' para corrigir o problema");
        }
        
        return construtorTexto.toString();
    }
}
