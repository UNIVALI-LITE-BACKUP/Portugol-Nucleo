package br.univali.portugol.nucleo.analise.semantica.avisos;

import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.VisitanteASABasico;
import br.univali.portugol.nucleo.mensagens.AvisoAnalise;
import br.univali.portugol.nucleo.simbolos.Simbolo;

/**
 *
 * @author Luiz Fernando Noschang
 * @author Fillipi Pelz
 */
public final class AvisoSimboloGlobalOcultado extends AvisoAnalise
{
    private Simbolo simboloGlobal;
    private Simbolo simboloLocal;
    private NoDeclaracao declaracao;
    
    public AvisoSimboloGlobalOcultado(Simbolo simboloGlobal, Simbolo simboloLocal, NoDeclaracao declaracao)
    {
        super(declaracao.getTrechoCodigoFonteNome());
        
        this.simboloGlobal = simboloGlobal;
        this.simboloLocal = simboloLocal;
        
        this.getMensagem();
    }
    
     /**
     * {@inheritDoc }
     */
    @Override
    protected String construirMensagem()
    {        
        return new AvisoSimboloGlobalOcultado.ConstrutorMensagem().construirMensagem();
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
                return (String) declaracao.aceitar(this);
            }
            catch (ExcecaoVisitaASA e)
            {
                return e.getMessage();
            }
        }  

        @Override
        public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
        {
            return super.visitar(noDeclaracaoMatriz); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
        {
            return super.visitar(noDeclaracaoVariavel); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
        {
            return super.visitar(noDeclaracaoParametro); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
        {
            return super.visitar(noDeclaracaoVetor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
        {
            return super.visitar(declaracaoFuncao); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
