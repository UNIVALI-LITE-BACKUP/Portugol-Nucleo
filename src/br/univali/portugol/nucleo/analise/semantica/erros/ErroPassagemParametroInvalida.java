package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroPassagemParametroInvalida extends ErroSemantico
{
    private NoExpressao valor;
    private String nomeParametro;
    private String nomeFuncao;

    public ErroPassagemParametroInvalida(NoExpressao valor, String nomeParametro, String nomeFuncao)
    {
        super(valor.getTrechoCodigoFonte());
        
        this.valor = valor;
        this.nomeParametro = nomeParametro;
        this.nomeFuncao = nomeFuncao;
    }

    public NoExpressao getValor()
    {
        return valor;
    }

    public String getNomeParametro()
    {
        return nomeParametro;
    }

    public String getNomeFuncao()
    {
        return nomeFuncao;
    }
    
     /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {        
        //return new ErroPassagemParametroInvalida.ConstrutorMensagem().construirMensagem();
        
        StringBuilder construtorTexto = new StringBuilder();
            
        construtorTexto.append("Não é possível passar uma expressão constante para o parâmetro \"");
        construtorTexto.append(nomeParametro);
        construtorTexto.append("\" da função \"");
        construtorTexto.append(nomeFuncao);
        construtorTexto.append("\", pois este parâmetro espera uma referência");
            
        return construtorTexto.toString();
    }
}
