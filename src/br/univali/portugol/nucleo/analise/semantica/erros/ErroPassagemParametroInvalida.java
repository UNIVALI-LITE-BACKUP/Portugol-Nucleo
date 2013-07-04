package br.univali.portugol.nucleo.analise.semantica.erros;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.NoExpressao;
import br.univali.portugol.nucleo.asa.TrechoCodigoFonte;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import br.univali.portugol.nucleo.mensagens.ErroSemantico;
import br.univali.portugol.nucleo.simbolos.Funcao;

/**
 *
 * @author Luiz Fernando Noschang
 */
public final class ErroPassagemParametroInvalida extends ErroSemantico
{
    private NoExpressao valor;
    private NoDeclaracaoParametro parametro;
    private Funcao funcao;

    public ErroPassagemParametroInvalida(NoExpressao valor, NoDeclaracaoParametro parametro, Funcao funcao)
    {
        super(valor.getTrechoCodigoFonte());
        
        this.valor = valor;
        this.parametro = parametro;
        this.funcao = funcao;
    }

    public NoExpressao getValor()
    {
        return valor;
    }

    public NoDeclaracaoParametro getParametro()
    {
        return parametro;
    }

    public Funcao getFuncao()
    {
        return funcao;
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
        construtorTexto.append(parametro.getNome());
        construtorTexto.append("\" da função \"");
        construtorTexto.append(funcao.getNome());
        construtorTexto.append("\", pois este parâmetro é passado por referência");
            
        return construtorTexto.toString();
    }
    
    private class ConstrutorMensagem extends VisitanteASABasico
    {
        public ConstrutorMensagem()
        {
            
        }        
        
        public String construirMensagem()
        {
            try
            {
                return (String) valor.aceitar(this);
            }
            catch (ExcecaoVisitaASA e)
            {
                return e.getMessage();
            }
        }

        @Override
        public Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
        {
            StringBuilder construtorTexto = new StringBuilder();
            
            construtorTexto.append("O parâmetro \"");
            construtorTexto.append(parametro.getNome());
            construtorTexto.append("\" da função \"");
            construtorTexto.append(funcao.getNome());
            construtorTexto.append("\" ");
            
            return construtorTexto.toString();
        }
    }
}
