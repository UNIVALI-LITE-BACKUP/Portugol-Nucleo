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
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.Simbolo;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;

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
        this.declaracao = declaracao;
        
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

        private StringBuilder appendGenericMessage(StringBuilder builder){
            builder.append(declaracao.getNome())
                    .append("\" está ocultando ");
            
            if (simboloGlobal instanceof Variavel){
                builder.append("uma variável ");
            } else if (simboloGlobal instanceof Vetor){
                builder.append("um vetor ");
            } else if (simboloGlobal instanceof Matriz) {
                builder.append("uma matriz");
            }
            builder.append("do escopo global.");
            
            return builder;
        }
        
        @Override
        public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
        {
            StringBuilder builder = new StringBuilder("A matriz \"");            
            return appendGenericMessage(builder).toString();
        }

        @Override
        public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
        {
            StringBuilder builder = new StringBuilder("A variável \"");            
            return appendGenericMessage(builder).toString();
        }

        @Override
        public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
        {
            return super.visitar(noDeclaracaoParametro); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
        {
            StringBuilder builder = new StringBuilder("O vetor \"");            
            return appendGenericMessage(builder).toString();
        }

        @Override
        public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
        {
            return super.visitar(declaracaoFuncao); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
