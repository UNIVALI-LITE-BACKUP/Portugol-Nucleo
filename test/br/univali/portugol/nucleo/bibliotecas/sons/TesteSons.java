package br.univali.portugol.nucleo.bibliotecas.sons;

import br.univali.portugol.nucleo.bibliotecas.Sons;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author elieser
 * Esta classe não é um teste unitário padrão. É um teste 'auditivo'. Se o teste funcionar
 * você ouvirá sons, se não ouvir nada (e seu sistema de som estiver funcionando) então
 * o teste falhou. Você deverá ouvir um com de fundo e um som de sino tocando repetidamente.
 */
public class TesteSons
{
    public static void main(String args[]) throws Exception
    {
        final Sons sons = new Sons();
        final Integer somDeFundo = sons.carregar_som("../Portugol-Studio-Recursos/exemplos/jogos/corrida/sons/musica_jogo.mp3");
        final Integer somDoSino = sons.carregar_som("../Portugol-Studio-Recursos/exemplos/jogos/corrida/sons/som_largada.mp3");
        final Integer somDoTrafego = sons.carregar_som("../Portugol-Studio-Recursos/exemplos/jogos/corrida/sons/som_trafego.mp3");
        
        sons.reproduzir_som(somDoTrafego, true);
        sons.reproduzir_som(somDoSino, true);//testa a repetição do som
        sons.reproduzir_som(somDeFundo, true);
        
        Thread.sleep(20000);
    }
}
    

