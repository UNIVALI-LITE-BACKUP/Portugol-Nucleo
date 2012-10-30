/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.depuracao;

import br.univali.portugol.nucleo.asa.ArvoreSintaticaAbstrataPrograma;
import br.univali.portugol.nucleo.asa.ExcecaoVisitaASA;
import br.univali.portugol.nucleo.asa.NoBloco;
import br.univali.portugol.nucleo.asa.NoCadeia;
import br.univali.portugol.nucleo.asa.NoCaracter;
import br.univali.portugol.nucleo.asa.NoCaso;
import br.univali.portugol.nucleo.asa.NoChamadaFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoFuncao;
import br.univali.portugol.nucleo.asa.NoDeclaracaoMatriz;
import br.univali.portugol.nucleo.asa.NoDeclaracaoParametro;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVariavel;
import br.univali.portugol.nucleo.asa.NoDeclaracaoVetor;
import br.univali.portugol.nucleo.asa.NoDecremento;
import br.univali.portugol.nucleo.asa.NoEnquanto;
import br.univali.portugol.nucleo.asa.NoEscolha;
import br.univali.portugol.nucleo.asa.NoFacaEnquanto;
import br.univali.portugol.nucleo.asa.NoIncremento;
import br.univali.portugol.nucleo.asa.NoInteiro;
import br.univali.portugol.nucleo.asa.NoLogico;
import br.univali.portugol.nucleo.asa.NoMatriz;
import br.univali.portugol.nucleo.asa.NoMenosUnario;
import br.univali.portugol.nucleo.asa.NoNao;
import br.univali.portugol.nucleo.asa.NoOperacao;
import br.univali.portugol.nucleo.asa.NoPara;
import br.univali.portugol.nucleo.asa.NoPare;
import br.univali.portugol.nucleo.asa.NoPercorra;
import br.univali.portugol.nucleo.asa.NoReal;
import br.univali.portugol.nucleo.asa.NoReferenciaMatriz;
import br.univali.portugol.nucleo.asa.NoReferenciaVariavel;
import br.univali.portugol.nucleo.asa.NoReferenciaVetor;
import br.univali.portugol.nucleo.asa.NoRetorne;
import br.univali.portugol.nucleo.asa.NoSe;
import br.univali.portugol.nucleo.asa.NoVetor;
import br.univali.portugol.nucleo.asa.Operacao;
import br.univali.portugol.nucleo.asa.Quantificador;
import br.univali.portugol.nucleo.asa.TipoDado;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import br.univali.portugol.nucleo.simbolos.Funcao;
import br.univali.portugol.nucleo.simbolos.Matriz;
import br.univali.portugol.nucleo.simbolos.TabelaSimbolos;
import br.univali.portugol.nucleo.simbolos.Variavel;
import br.univali.portugol.nucleo.simbolos.Vetor;
import java.util.List;

/**
 *
 * @author fillipi
 */
public class Depurador implements VisitanteASA
{

    private TabelaSimbolos tabelaSimbolosGlobal;
    
    @Override
    public Object visitar(ArvoreSintaticaAbstrataPrograma asap) throws ExcecaoVisitaASA
    {
        tabelaSimbolosGlobal = new TabelaSimbolos();
        List<NoDeclaracao> listaDeclaracoesGlobais = asap.getListaDeclaracoesGlobais();
        for (NoDeclaracao noDeclaracao : listaDeclaracoesGlobais)
        {
            noDeclaracao.aceitar(this);
        }
        
        return null; 

    }

    @Override
    public Object visitar(NoCadeia noCadeia) throws ExcecaoVisitaASA
    {
        return noCadeia.getValor();
    }

    @Override
    public Object visitar(NoCaracter noCaracter) throws ExcecaoVisitaASA
    {
        return noCaracter.getValor();
    }

    @Override
    public Object visitar(NoCaso noCaso) throws ExcecaoVisitaASA
    {
        return noCaso.getExpressao().aceitar(this);
    }

    @Override
    public Object visitar(NoChamadaFuncao chamadaFuncao) throws ExcecaoVisitaASA
    {
       throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public Object visitar(NoDeclaracaoFuncao declaracaoFuncao) throws ExcecaoVisitaASA
    {
        
        String nome = declaracaoFuncao.getNome();
        TipoDado tipoDados = declaracaoFuncao.getTipoDado();
        Quantificador quantificador = declaracaoFuncao.getQuantificador();

        List<NoDeclaracaoParametro> parametros = declaracaoFuncao.getParametros();
        List<NoBloco> blocos = declaracaoFuncao.getBlocos();
        Funcao funcao = new Funcao(nome, tipoDados, quantificador, parametros, blocos);        
        
        return funcao;
    }

    @Override
    public Object visitar(NoDeclaracaoMatriz noDeclaracaoMatriz) throws ExcecaoVisitaASA
    {
         String nome = noDeclaracaoMatriz.getNome();
        TipoDado tipoDado = noDeclaracaoMatriz.getTipoDado();

        int numeroLinhas = (Integer) noDeclaracaoMatriz.getNumeroLinhas().aceitar(this);
        int numeroColunas = (Integer) noDeclaracaoMatriz.getNumeroColunas().aceitar(this);
        List<List<Object>> valores = (List<List<Object>>) noDeclaracaoMatriz.getInicializacao().aceitar(this);

        Matriz matriz;

        if (numeroLinhas == 0)
        {
            matriz = new Matriz(nome, tipoDado, valores);
        }
        else
        {
            matriz = new Matriz(nome, tipoDado, numeroLinhas, numeroColunas, valores);
        }

        matriz.setConstante(noDeclaracaoMatriz.constante());
        
        return matriz;
    }

    @Override
    public Object visitar(NoDeclaracaoVariavel noDeclaracaoVariavel) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVariavel.getNome();
        TipoDado tipoDado = noDeclaracaoVariavel.getTipoDado();
        
        Variavel variavel = new Variavel(nome, tipoDado);
        
        if (noDeclaracaoVariavel.getInicializacao() != null) {
            Object valor = noDeclaracaoVariavel.getInicializacao().aceitar(this);
            variavel.setValor(valor);            
        }
        
        variavel.setConstante(noDeclaracaoVariavel.constante());
        
        return variavel;
    }

    @Override
    public Object visitar(NoDeclaracaoVetor noDeclaracaoVetor) throws ExcecaoVisitaASA
    {
        String nome = noDeclaracaoVetor.getNome();
        TipoDado tipoDado = noDeclaracaoVetor.getTipoDado();

        int tamanho = (Integer) noDeclaracaoVetor.getTamanho().aceitar(this);
        List<Object> valores = (List<Object>) noDeclaracaoVetor.getInicializacao().aceitar(this);

        Vetor vetor = null;

        if (tamanho == 0)
        {
            vetor = new Vetor(nome, tipoDado, valores);
        }
        else
        {
            vetor = new Vetor(nome, tipoDado, tamanho, valores);
        }

        vetor.setConstante(noDeclaracaoVetor.constante());

        return vetor;
    }

    @Override
    public Object visitar(NoDecremento noDecremento) throws ExcecaoVisitaASA
    {
        return new NoOperacao(Operacao.SUBTRACAO_ACUMULATIVA, noDecremento.getExpressao(), new NoInteiro(1)).aceitar(this);
    }

    @Override
    public Object visitar(NoEnquanto noEnquanto) throws ExcecaoVisitaASA
    {
        while ((Boolean) noEnquanto.getCondicao().aceitar(this))
        {
            //tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(noEnquanto.getBlocos());
            //tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null)
            {
                return (valorRetorno instanceof NoPare) ? null : valorRetorno;
            }
        }

        return null;
    }
    
    private Object interpretarListaBlocos(List<NoBloco> blocos) throws ExcecaoVisitaASA
    {
        for (NoBloco noBloco : blocos)
        {
            Object valor = noBloco.aceitar(this);
            if (valor != null)
            {
                return valor;
            }
        }
        return null;
    }

    @Override
    public Object visitar(NoEscolha noEscolha) throws ExcecaoVisitaASA
    {
        List<NoCaso> casos = noEscolha.getCasos();
        Object valorEscolha = noEscolha.getExpressao().aceitar(this);

        int indiceValorEscolhido = procurarIndiceValorEscolhido(valorEscolha, casos);

        if (indiceValorEscolhido >= 0)
        {
            for (int i = indiceValorEscolhido; i < casos.size(); i++)
            {
                //tabelaSimbolos.empilharEscopo();
                Object valorRetorno = interpretarListaBlocos(casos.get(i).getBlocos());
                //tabelaSimbolos.desempilharEscopo();

                if (valorRetorno != null)
                {
                    return (valorRetorno instanceof NoPare) ? null : valorRetorno;
                }
            }
        }

        return null;
    }
    
    private int procurarIndiceValorEscolhido(Object valorEscolha, List<NoCaso> casos) throws ExcecaoVisitaASA
    {
        for (NoCaso caso : casos)
        {          
            if (caso.aceitar(this) == valorEscolha)
            {
                return casos.indexOf(caso);
            }



            if (caso.aceitar(this) == null)
            {
                return casos.indexOf(caso);
            }            
        }

        return -1;
    }
        

    @Override
    public Object visitar(NoFacaEnquanto noFacaEnquanto) throws ExcecaoVisitaASA
    {
        do
        {
            //tabelaSimbolos.empilharEscopo();
            Object valorRetorno = interpretarListaBlocos(noFacaEnquanto.getBlocos());
            //tabelaSimbolos.desempilharEscopo();

            if (valorRetorno != null)
            {
                return (valorRetorno instanceof NoPare) ? null : valorRetorno;
            }
        }
        while ((Boolean) noFacaEnquanto.getCondicao().aceitar(this));

        return null;
    }

    @Override
    public Object visitar(NoIncremento noIncremento) throws ExcecaoVisitaASA
    {
        return new NoOperacao(Operacao.SOMA_ACUMULATIVA, noIncremento.getExpressao(), new NoInteiro(1)).aceitar(this);
    }

    @Override
    public Object visitar(NoInteiro noInteiro) throws ExcecaoVisitaASA
    {
        return noInteiro.getValor();
    }

    @Override
    public Object visitar(NoLogico noLogico) throws ExcecaoVisitaASA
    {
        return noLogico.getValor();
    }

    @Override
    public Object visitar(NoMatriz noMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoMenosUnario noMenosUnario) throws ExcecaoVisitaASA
    {
         Object valor = noMenosUnario.getExpressao().aceitar(this);

        if (valor instanceof Double)
        {
            return -((Double) valor);
        }
        if (valor instanceof Integer)
        {
            return -((Integer) valor);
        }
        if (valor instanceof Character)
        {
            return -((Character) valor);
        }

        return null;
    }

    @Override
    public Object visitar(NoNao noNao) throws ExcecaoVisitaASA
    {
        return !((Boolean)noNao.getExpressao().aceitar(this));
    }

    @Override
    public Object visitar(NoOperacao noOperacao) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoPara noPara) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoPare noPare) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoPercorra noPercorra) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReal noReal) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaMatriz noReferenciaMatriz) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaVariavel noReferenciaVariavel) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoReferenciaVetor noReferenciaVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoRetorne noRetorne) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoSe noSe) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoVetor noVetor) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitar(NoDeclaracaoParametro noDeclaracaoParametro) throws ExcecaoVisitaASA
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
