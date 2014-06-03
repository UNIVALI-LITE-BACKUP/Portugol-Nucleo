package br.univali.portugol.nucleo.asa;

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
    /**
     * Este método serve para dar suporte ao caminhamento da ASA utilizando o padrão visitor.
     * As classes filhas, ao implementar este método deverão chamar o método <code>visitar</code> do visitante
     * e retornar o objeto resultante da chamada. Exemplo:
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
     * @param visitante             o visitante que irá percorrer a ASA.
     * @return                      um objeto qualquer retornado pelo visitante durante o caminhamento na ASA.
     * @throws ExcecaoVisitaASA
     * @since 1.0
     */
    public abstract Object aceitar(VisitanteASA visitante) throws ExcecaoVisitaASA;
}
