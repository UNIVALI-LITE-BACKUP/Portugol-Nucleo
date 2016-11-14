package br.univali.portugol.nucleo.execucao.gerador.helpers;

import br.univali.portugol.nucleo.asa.*;
import br.univali.portugol.nucleo.asa.VisitanteASA;
import br.univali.portugol.nucleo.bibliotecas.base.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Elieser
 */
public class GeradorChamadaMetodo
{
    public void gera(NoChamadaFuncao no, PrintWriter saida, VisitanteASA visitor, 
            ASAPrograma asa, boolean gerandoCodigoParaInspecao, int nivelEscopo) throws ExcecaoVisitaASA
    {
        String escopoFuncao = (no.getEscopo() != null) ? (no.getEscopo() + ".") : "";
        String nomeFuncao = no.getNome();
        if (escopoFuncao.isEmpty() && "leia".equals(nomeFuncao)) //a função 'leia' tem um tratamento especial
        {
            geraCodigoParaFuncaoLeia(no, saida, visitor, asa);
            return;
        }

        List<ParametroEsperado> parametrosEsperados = getParametrosEsperados(no, asa);
        List<NoExpressao> parametrosPassados = no.getParametros();

        if (gerandoCodigoParaInspecao)
        {
            geraCodigoInicializacaoParametrosInspecionados(parametrosEsperados, 
                    parametrosPassados, saida, visitor, nivelEscopo);
        }
        
        saida.format("%s%s(", escopoFuncao, Utils.geraNomeValido(nomeFuncao));
        
        int totalParametros = parametrosPassados.size();
        for (int i = 0; i < totalParametros; i++)
        {
            ParametroEsperado parametroEsperado = (i < parametrosEsperados.size()) ? parametrosEsperados.get(i) : null;
            NoExpressao parametroPassado = parametrosPassados.get(i);
            geraParametro(parametroPassado, parametroEsperado, saida, visitor);

            if (i < totalParametros - 1)
            {
                saida.append(", ");
            }
        }
        saida.append(")");
    }
    
    private void geraCodigoInicializacaoParametrosInspecionados(List<ParametroEsperado> parametrosEsperados,
                                                                            List<NoExpressao> parametrosPassados, 
                                                                                PrintWriter saida, VisitanteASA visitor, 
                                                                                int nivelEscopo) throws ExcecaoVisitaASA
    {
        if (parametrosEsperados.size() != parametrosEsperados.size())
        {
            return;
        }
        
        for (int i = 0; i < parametrosEsperados.size(); i++)
        {
            ParametroEsperado parametroEsperado = parametrosEsperados.get(i);
            NoExpressao parametroPassado = parametrosPassados.get(i);
        
            if (parametroEsperado.idInspecao >= 0)
            {
                String nomeArrayInspecao = getNomeArrayInspecionavel(parametroEsperado.quantificador);
                saida.append(Utils.geraIdentacao(nivelEscopo));
                saida.format("if (%s[%d] != null) {", nomeArrayInspecao, parametroEsperado.idInspecao).println();
                switch (parametroEsperado.quantificador)
                {
                    case VALOR:
                        saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                        saida.format("  %s[%d] = ", nomeArrayInspecao, parametroEsperado.idInspecao);
                        parametroPassado.aceitar(visitor);
                        saida.append(";").println();
                        break;
                    case VETOR:
                        //gera um if verificando se é necessário redimencionar o vetor interno
//                        if (vetoresInspecionados[1].tamanho != vetor.length)
//                        {
//                            inspecionaVetor(1, vetor.length);
//                        }
                        saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                        saida.format("if (%s[%d].tamanho != ", nomeArrayInspecao, parametroEsperado.idInspecao);
                        parametroPassado.aceitar(visitor);
                        saida.append(".length) {").println();
                        
                        saida.append(Utils.geraIdentacao(nivelEscopo + 2));
                        saida.format("inspecionaVetor(%d, ", parametroEsperado.idInspecao);
                        parametroPassado.aceitar(visitor);
                        saida.append(".length);").println();
                        
                        saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                        saida.append("}").println(); //fecha IF verificando se é necessário redimencionar array interno
                        
                        //gera loop coletando todas as posições do vetor
                        saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                        saida.format("for(int i=0; i < %s[%d].tamanho; i++){", nomeArrayInspecao, parametroEsperado.idInspecao).println(); // loop percorrendo todo o array
                        
                            saida.append(Utils.geraIdentacao(nivelEscopo + 2));
                            saida.format("  %s[%d].setValor(", nomeArrayInspecao, parametroEsperado.idInspecao);
                            parametroPassado.aceitar(visitor);
                            saida.append("[i], i);").println(); //fecha setValor(v[i], i);
                        
                        saida.append(Utils.geraIdentacao(nivelEscopo + 1));
                        saida.append("}").println(); //fecha loop
                        
                        break;
                
                    case MATRIZ:
                        break;
                }
                    
                
                saida.append(Utils.geraIdentacao(nivelEscopo))
                        .append("}") // fecha o IF inicial
                        .println();
            }
        }
    }
    
    private String getNomeArrayInspecionavel(Quantificador quantificador)
    {
        switch(quantificador)
        {
            case VALOR: return "variaveisInspecionadas";
            case VETOR: return "vetoresInspecionados";
            case MATRIZ: return "matrizesInspecionadas";
        }
        return "variaveisInspecionadas";
    }

    private void geraParametro(NoExpressao parametroRecebido, ParametroEsperado parametroEsperado, PrintWriter saida, VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        boolean precisaDeCast = false;
        boolean parametroEhOperacao = false;
        boolean passandoPorReferencia = false;

        if (parametroEsperado != null)
        {
            TipoDado tipoEsperado = parametroEsperado.tipoDado;
            ModoAcesso modoAcessoEsperado = parametroEsperado.modoAcesso;

            // verifica se é necessário fazer cast de um double para int quando o parâmetro esperado é int
            precisaDeCast = tipoEsperado == TipoDado.INTEIRO && parametroRecebido.getTipoResultante() == TipoDado.REAL;
            parametroEhOperacao = parametroRecebido instanceof NoOperacao;
            passandoPorReferencia = modoAcessoEsperado == ModoAcesso.POR_REFERENCIA;
            if (precisaDeCast)
            {
                saida.append("(int)");
                if (parametroEhOperacao)
                {
                    saida.append("("); //coloca toda a operação que está sendo passada por parâmetro entre parênteses para que o cast seja aplicado em toda a operação
                }
            }
        }

        // verifica se é um parametro por referência
        if (!passandoPorReferencia)
        {
            parametroRecebido.aceitar(visitor);
        }
        else
        {
            NoReferenciaVariavel referencia = ((NoReferenciaVariavel)parametroRecebido);
            if (referencia.getOrigemDaReferencia() instanceof NoDeclaracaoVariavel)
            {
                saida.append(Utils.geraStringIndice(referencia));
            }
            else // origem é um NoDeclaracaoParametro
            {
                saida.append(referencia.getNome());
            }
        }

        if (precisaDeCast && parametroEhOperacao)
        {
            saida.append(")");
        }
    }

    private class ParametroEsperado
    {
        public final TipoDado tipoDado;
        public final ModoAcesso modoAcesso;
        public final String nome;
        public final int idInspecao;
        public final Quantificador quantificador;

        public ParametroEsperado(TipoDado tipoDado, ModoAcesso modoAcesso, String nome, Quantificador quantificador)
        {
            this(tipoDado, modoAcesso, nome, quantificador, -1);
        }
        
        public ParametroEsperado(TipoDado tipoDado, ModoAcesso modoAcesso, String nome, Quantificador quantificador, int idInspecao)
        {
            this.tipoDado = tipoDado;
            this.modoAcesso = modoAcesso;
            this.nome = nome;
            this.idInspecao = idInspecao;
            this.quantificador = quantificador;
        }
    }

    private List<ParametroEsperado> getParametrosEsperados(NoChamadaFuncao no, ASAPrograma asa)
    {
        List<ParametroEsperado> metaDados = new ArrayList<>();

        if (no.getEscopo() != null) // é uma função de biblioteca?
        {
            String nomeBiblioteca = Utils.getNomeBiblioteca(no.getEscopo(), asa);
            try
            {
                GerenciadorBibliotecas gerenciador = GerenciadorBibliotecas.getInstance();
                MetaDadosBiblioteca metadadosBiblioteca = gerenciador.obterMetaDadosBiblioteca(nomeBiblioteca);
                assert (metadadosBiblioteca != null);
                MetaDadosFuncao metaDadosFuncao = metadadosBiblioteca.obterMetaDadosFuncoes().obter(no.getNome());
                assert (metaDadosFuncao != null);
                MetaDadosParametros metaDadosParametros = metaDadosFuncao.obterMetaDadosParametros();
                int totalParametros = metaDadosParametros.quantidade();
                for (int i = 0; i < totalParametros; i++)
                {
                    TipoDado tipoDado = metaDadosParametros.obter(i).getTipoDado();
                    ModoAcesso modoAcesso = metaDadosParametros.obter(i).getModoAcesso();
                    String nome = metaDadosParametros.obter(i).getNome();
                    Quantificador quantificador = metaDadosParametros.obter(i).getQuantificador();
                    metaDados.add(new ParametroEsperado(tipoDado, modoAcesso, nome, quantificador));
                }
                return metaDados;
            }
            catch (ErroCarregamentoBiblioteca ex)
            {
                ex.printStackTrace();
            }
        }

        // é uma função comum e é possível obter a declaração da função?
        if (no.getOrigemDaReferencia() != null)
        {
            List<NoDeclaracaoParametro> parametros = no.getOrigemDaReferencia().getParametros();
            for (NoDeclaracaoParametro parametro : parametros)
            {
                TipoDado tipo = parametro.getTipoDado();
                ModoAcesso modoAcesso = parametro.getModoAcesso();
                String nome = parametro.getNome();
                int idInspecao = parametro.getIdParaInspecao();
                Quantificador quantificador = parametro.getQuantificador();
                metaDados.add(new ParametroEsperado(tipo, modoAcesso, nome, quantificador, idInspecao));
            }
            return metaDados;
        }

        return Collections.EMPTY_LIST;
    }

    private void visitaParametroPassado(NoReferencia parametroPassado, VisitanteASA visitor) throws ExcecaoVisitaASA
    {
        if (parametroPassado instanceof NoReferenciaVariavel)
        {
            visitor.visitar((NoReferenciaVariavel) parametroPassado);
        }
        else if (parametroPassado instanceof NoReferenciaVetor)
        {
            visitor.visitar((NoReferenciaVetor) parametroPassado);
        }
        else if (parametroPassado instanceof NoReferenciaMatriz)
        {
            visitor.visitar((NoReferenciaMatriz) parametroPassado);
        }
    }
    
    private void geraCodigoParaFuncaoLeia(NoChamadaFuncao no, PrintWriter saida, VisitanteASA visitor, ASAPrograma asa) throws ExcecaoVisitaASA
    {
        List<NoExpressao> parametrosPassados = no.getParametros();

        for (int i = 0; i < parametrosPassados.size(); i++)
        {
            NoReferencia parametroPassado = (NoReferencia) parametrosPassados.get(i);
            
            visitaParametroPassado(parametroPassado, visitor);
            
            NoDeclaracao origem = parametroPassado.getOrigemDaReferencia();
            TipoDado tipo = TipoDado.CADEIA;
            if (origem != null) // parece que tem um bug no leia passando 'cadeia' como parametro, a origem do 'leia' é nula
            {
                tipo = origem.getTipoDado();
            }
            String nomeFuncao = "leia" + Utils.getNomeTipoEmCamelCase(tipo);
            saida.format(" = %s()", nomeFuncao);
            if (i < parametrosPassados.size() - 1) // adiciona um ponto e vírgula depois de cada atribuição gerada, exceto para a última
            {
                saida.append(";").println();
            }
        }
    }
}
