package br.univali.portugol.nucleo.execucao;

/**
 * Esta classe enumera os possíveis modos de encerramento
 * de um programa.<br/>
 * 
 * <ul>
 *      <li>
 *          <p>
 *             NORMAL: este valor é retornado quando todos os comandos do
 *             programa foram executados corretamente do início ao fim.
 *          </p>
 *      </li><br/>
 *      <li>
 *          <p>
 *              ERRO: este valor é retornado quando ocorreu algum erro durante
 *              a execução do programa. Ex.: acesso a uma posição de vetor inexistente.
 *          </p>
 *      </li><br/>
 *      <li>
 *          <p>
 *              INTERRUPCAO: este valor é retornado quando o o programa foi
 *              interrompido manualmente pelo usuário. Ex.: o programa entrou em loop
 *              infinito e o usuário decidiu interromper a execução.
 *          </p>
 *      </li>
 * </ul>
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public enum ModoEncerramento 
{
    NORMAL, ERRO, INTERRUPCAO
}
