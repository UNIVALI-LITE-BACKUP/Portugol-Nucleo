package br.univali.portugol.nucleo.asa;

import br.univali.portugol.nucleo.execucao.Depurador;
import br.univali.portugol.nucleo.execucao.PontoParada;

/**
 * Esta é a classe base para todos os nós da ASA.
 *
 * @author Luiz Fernando Noschang
 * @version 1.0
 *
 * @see ArvoreSintaticaAbstrata
 */
public abstract class No
{
    private NoBloco pai = null;
    private PontoParada pontoParada = null;

    /**
     * Este método serve para dar suporte ao caminhamento da ASA utilizando o
     * padrão visitor. As classes filhas, ao implementar este método deverão
     * chamar o método <code>visitar</code> do visitante e retornar o objeto
     * resultante da chamada. Exemplo:
     * <br>
     * <pre><code>
     *      public SubClasse extends No
     *      {
     *          &#64;Override
     *          public Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA
     *          {
     *              return visitante.visitar(this);
     *          }
     *      }
     * </code></pre>
     *
     * @param visitante o visitante que irá percorrer a ASA.
     * @return um objeto qualquer retornado pelo visitante durante o
     * caminhamento na ASA.
     * @throws ExcecaoVisitaASA
     * @since 1.0
     */
    public abstract Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA;

    public No()
    {
    }

    protected No(NoBloco pai)
    {
        this.pai = pai;
    }

    public void setPai(NoBloco pai)
    {
        this.pai = pai;
    }
    
    public boolean ehParavel(Depurador.Estado estado)
    {
        return temPontoDeParada() && estado == Depurador.Estado.BREAK_POINT ;
    }

    protected boolean temPai()
    {
        return pai != null;
    }

    protected NoBloco getPai()
    {
        if (!temPai())
        {
            throw new IllegalStateException("O objeto não tem um pai!");
        }
        return pai;
    }

    /**
     * 
     * @param status true se o nó será parado, false em caso contrário
     */
    public void definirPontoParada(boolean status){
        if(status){
            pontoParada = new PontoParada(this);
        }
        else{
            pontoParada = null;
        }
    }
    
    protected boolean temPontoDeParada(){
        return pontoParada != null;
    }
    
    
}
