package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Graficos;
import br.univali.portugol.nucleo.bibliotecas.Teclado;
import br.univali.portugol.nucleo.bibliotecas.Util;
import br.univali.portugol.nucleo.bibliotecas.Matematica;
import br.univali.portugol.nucleo.bibliotecas.Tipos;
import br.univali.portugol.nucleo.bibliotecas.Sons;
import br.univali.portugol.nucleo.bibliotecas.Texto;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExemploCorrida extends Programa {

    private final Graficos g = new Graficos();
    private final Teclado t = new Teclado();
    private final Util u = new Util();
    private final Matematica m = new Matematica();
    private final Tipos tp = new Tipos();
    private final Sons sm = new Sons();
    private final Texto txt = new Texto();

    private final int _X = 0;
    private final int _Y = 1;
    private final int _MODELO = 2;
    private final int _VELOCIDADE = 3;
    private final int _COMBUSTIVEL = 4;
    private final int _DANOS = 5;
    private final int _SX = 0;
    private final int _SY = 1;
    private final int _LARGURA = 2;
    private final int _ALTURA = 3;
    private final int _OBJ_LINHA_CHEGADA = 0;
    private final int _OBJ_GALAO_COMBUSTIVEL = 1;
    private final int _OBJ_PONTO_REPARO = 2;
    private final int TELA_SAIR = 0;
    private final int TELA_JOGO = 1;
    private final int TAXA_ATUALIZACAO = 60;
    private final double ATRITO = 0.035;
    private final double ACELERACAO = 0.085;
    private final double FREIO = 0.135;
    private final double VELOCIDADE_MAXIMA_JOGADOR = 12.0;
    private final double VELOCIDADE_MAXIMA_VEICULOS = 11.0;
    private final double VELOCIDADE_MINIMA_VEICULOS = 5.0;
    private final double MAXIMO_COMBUSTIVEL = 20000.0;
    private final double COMBUSTIVEL_GALAO = 5000.0;
    private final double MAXIMO_DANOS = 1000.0;
    private final double TAXA_DANOS = 25.0;
    private final double TAXA_REPARO = 200.0;
    private final int MAIOR_DISTANCIA_REPAROS = 12000;
    private final int MENOR_DISTANCIA_REPAROS = 9000;
    private final int MAIOR_DISTANCIA_GALOES = 6000;
    private final int MENOR_DISTANCIA_GALOES = 3000;
    private final int MAIOR_DISTANCIA_VEICULOS = 500;
    private final int MENOR_DISTANCIA_VEICULOS = 100;
    private final double EXTENSAO_ESTRADA = 80000.0;
    private int LARGURA_ACOSTAMENTO = 25;
    private final int LARGURA_MEDIDOR = 156;
    private final int ALTURA_MEDIDOR = 8;
    private int MODELOS_VEICULOS[][] = {{0, 0, 44, 96}, {43, 0, 44, 96}, {86, 0, 44, 96}, {129, 0, 44, 96}, {172, 0, 44, 96}, {0, 97, 44, 96}, {43, 97, 44, 96}, {86, 97, 44, 96}, {129, 97, 44, 96}, {172, 97, 44, 96}, {0, 195, 44, 96}, {43, 195, 44, 96}, {86, 195, 44, 96}, {129, 195, 44, 96}, {172, 197, 44, 94}, {0, 293, 42, 99}, {42, 293, 42, 99}, {85, 293, 42, 99}, {128, 293, 42, 99}, {172, 293, 42, 99}, {217, 0, 41, 87}, {217, 89, 41, 87}, {217, 179, 41, 87}, {217, 269, 41, 88}, {263, 0, 66, 374}, {331, 0, 67, 370}};
    private final int OBJETOS[][] = {{0, 0, 400, 28}, {402, 0, 21, 31}, {425, 1, 26, 27}};
    private double carro_jogador[] = new double[6];
    private double veiculos[][] = new double[10][6];
    private double galoes[][] = new double[4][2];
    private double pontos_reparo[][] = new double[4][2];
    private int tela_anterior = TELA_SAIR;
    private int tela_atual = TELA_JOGO;
    private int largura_tela = 0;
    private int altura_tela = 0;
    private double deslocamento_estrada = 0.0;
    private double distancia_percorrida = 0.0;
    private boolean freiando = false;
    private double inicio_freio = 0.0;
    private int tempo_inicio_fps = 0;
    private int tempo_fps = 0;
    private int frames = 0;
    private int fps = 0;
    private int tempo_inicio = 0;
    private int tempo_decorrido = 0;
    private int tempo_restante = 0;
    private int tempo_inicio_jogo = 0;
    private int tempo_total_jogo = 0;
    private int tempo_quadro = 1000 / tp.real_para_inteiro(m.maior_numero(1.0, tp.inteiro_para_real(TAXA_ATUALIZACAO)));
    private int imagem_estrada = -1;
    private int imagem_veiculos = -1;
    private int imagem_objetos = -1;
    private int musica_jogo = -1;
    private int som_trafego = -1;
    private int som_combustivel = -1;
    private int som_freio = -1;
    private int som_ligar = -1;
    private int som_alarme_combustivel = -1;
    private int som_colisao = -1;
    private int som_reparo = -1;
    private int som_largada = -1;
    private int rep_musica_jogo = -1;
    private int rep_som_trafego = -1;
    private int rep_som_freio = -1;
    private int rep_som_ligar = -1;
    private int rep_som_alarme_combustivel = -1;

    public ExemploCorrida() throws ErroExecucao {
    }

    @Override
    protected void executar(String[] parametros) throws ErroExecucao, InterruptedException {
        
        List<Biblioteca> libs = new ArrayList<>();
        libs.add(g);
        libs.add(t);
        libs.add(m);
        libs.add(sm);
        
        g.inicializar(this, libs);
        t.inicializar(this, libs);
        u.inicializar();
        m.inicializar(this, libs);
        tp.inicializar();
        sm.inicializar(this, libs);
        txt.inicializar();

        setDiretorioTrabalho(new File("../Portugol-Studio-Recursos/exemplos/jogos"));

        inicializar();
        while (tela_atual != TELA_SAIR) {
            switch (tela_atual) {
                case TELA_JOGO:
                    tela_jogo();
                    break;

            }

        }

        finalizar();
        
        g.finalizar();
        t.finalizar();
        u.finalizar();
        m.finalizar();
        tp.finalizar();
        sm.finalizar();
        txt.finalizar();
    }

    private void inicializar() throws ErroExecucao, InterruptedException {
        g.iniciar_modo_grafico(true);
        g.definir_titulo_janela("Corrida");
        carregar_sons();
        carregar_imagens();
        carregar_fontes();
        atualizar_dimensoes_janela();
        reiniciar();

    }

    private void carregar_sons() throws ErroExecucao, InterruptedException {
        String diretorio_sons = "./corrida/sons/";
        musica_jogo = sm.carregar_som(diretorio_sons + "musica_jogo.mp3");
        som_combustivel = sm.carregar_som(diretorio_sons + "som_combustivel.mp3");
        som_trafego = sm.carregar_som(diretorio_sons + "som_trafego.mp3");
        som_freio = sm.carregar_som(diretorio_sons + "som_freio.mp3");
        som_ligar = sm.carregar_som(diretorio_sons + "som_ligar.mp3");
        som_alarme_combustivel = sm.carregar_som(diretorio_sons + "som_alarme_combustivel.mp3");
        som_colisao = sm.carregar_som(diretorio_sons + "som_colisao.mp3");
        som_reparo = sm.carregar_som(diretorio_sons + "som_reparo.mp3");
        som_largada = sm.carregar_som(diretorio_sons + "som_largada.mp3");

    }

    private void atualizar_dimensoes_janela() throws ErroExecucao, InterruptedException {
        largura_tela = g.largura_imagem(imagem_estrada);
        altura_tela = 580;
        g.definir_dimensoes_janela(largura_tela, altura_tela);

    }

    private void finalizar() throws ErroExecucao, InterruptedException {
        liberar_imagens();
        liberar_sons();
        g.encerrar_modo_grafico();

    }

    private void liberar_sons() throws ErroExecucao, InterruptedException {
        sm.liberar_som(musica_jogo);
        sm.liberar_som(som_trafego);
        sm.liberar_som(som_combustivel);
        sm.liberar_som(som_freio);
        sm.liberar_som(som_ligar);
        sm.liberar_som(som_alarme_combustivel);
        sm.liberar_som(som_colisao);
        sm.liberar_som(som_reparo);
        sm.liberar_som(som_largada);

    }

    private void tela_jogo() throws ErroExecucao, InterruptedException {
        largada();
        tempo_inicio_jogo = u.tempo_decorrido() - tempo_total_jogo;
        while (tela_atual == TELA_JOGO) {
            tempo_total_jogo = u.tempo_decorrido() - tempo_inicio_jogo;
            tempo_inicio = u.tempo_decorrido() + tempo_restante;
            atualizar_jogo();
            desenhar_tela_jogo(true);
            atualizar_fps();
            tempo_decorrido = u.tempo_decorrido() - tempo_inicio;
            tempo_restante = tempo_quadro - tempo_decorrido;
            while (TAXA_ATUALIZACAO > 0 && tempo_restante > 0 && !t.tecla_pressionada(t.TECLA_ESC)) {
                tempo_decorrido = u.tempo_decorrido() - tempo_inicio;
                tempo_restante = tempo_quadro - tempo_decorrido;

            }

        }

        u.aguarde(100);

    }

    private void largada() throws ErroExecucao, InterruptedException {
        desenhar_tela_jogo(true);
        reproduzir_som(som_ligar, rep_som_ligar, false);
        u.aguarde(2000);
        reproduzir_som(musica_jogo, rep_musica_jogo, true);
        reproduzir_som(som_trafego, rep_som_trafego, true);
        contar_largada("3");
        contar_largada("2");
        contar_largada("1");
        contar_largada("Largar!!!");

    }

    private void contar_largada(String texto) throws ErroExecucao, InterruptedException {
        desenhar_tela_jogo(false);
        g.definir_tamanho_texto(60.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        int tx = (largura_tela / 2) - (g.largura_texto(texto) / 2);
        int ty = (altura_tela / 2) - (g.altura_texto(texto) / 2);
        int rx = tx - 20;
        int ry = ty - 20;
        int largura = g.largura_texto(texto) + 40;
        int altura = g.altura_texto(texto) + 40;
        g.definir_cor(0);
        g.desenhar_retangulo(rx, ry, largura, altura, false, true);
        g.definir_cor(16777215);
        g.desenhar_retangulo(rx, ry, largura, altura, false, false);
        g.desenhar_texto(tx, ty, texto);
        g.renderizar();
        sm.reproduzir_som(som_largada, false);
        u.aguarde(1000);

    }

    private void atualizar_fps() throws ErroExecucao, InterruptedException {
        frames = frames + 1;
        tempo_fps = u.tempo_decorrido() - tempo_inicio_fps;
        if (tempo_fps >= 1000) {
            fps = frames;
            tempo_inicio_fps = u.tempo_decorrido() - (tempo_fps - 1000);
            frames = 0;

        }

    }

    private void atualizar_jogo() throws ErroExecucao, InterruptedException {
        ler_entrada_usuario();
        atualizar_posicao_galoes();
        atualizar_posicao_pontos_reparo();
        atualizar_posicao_veiculos();
        atualizar_fisica_jogo();
        atualizar_estado_jogo();

    }

    private void atualizar_estado_jogo() throws ErroExecucao, InterruptedException {
        if (corrida_completada() && carro_em_movimento()) {
            freiar();

        } else if (corrida_completada() && carro_parado()) {
            trocar_tela(TELA_SAIR);

        }

    }

    private boolean corrida_completada() throws ErroExecucao, InterruptedException {
        return distancia_percorrida >= EXTENSAO_ESTRADA;

    }

    private void ler_entrada_usuario() throws ErroExecucao, InterruptedException {
        if (t.tecla_pressionada(t.TECLA_ESC)) {
            trocar_tela(TELA_SAIR);

        } else if (!corrida_completada()) {
            if (t.tecla_pressionada(t.TECLA_PAGE_UP)) {
                int modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
                modelo = (modelo + 1) % MODELOS_VEICULOS.length;
                carro_jogador[_MODELO] = tp.inteiro_para_real(modelo);
                u.aguarde(300);

            } else if (t.tecla_pressionada(t.TECLA_PAGE_DOWN)) {
                int modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
                modelo = (MODELOS_VEICULOS.length + modelo - 1) % MODELOS_VEICULOS.length;
                carro_jogador[_MODELO] = tp.inteiro_para_real(modelo);
                u.aguarde(300);

            }

            if (t.tecla_pressionada(t.TECLA_ESPACO)) {
                freiar();

            } else if (t.tecla_pressionada(t.TECLA_SETA_ACIMA)) {
                freiando = false;
                acelerar();

            }

            if (!t.tecla_pressionada(t.TECLA_ESPACO)) {
                interromper_som(rep_som_freio);

            }

            if (t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)) {
                virar_para_esquerda();

            } else if (t.tecla_pressionada(t.TECLA_SETA_DIREITA)) {
                virar_para_direita();

            }

            if (t.tecla_pressionada(t.TECLA_A)) {
                abastecer();

            }

            if (t.tecla_pressionada(t.TECLA_D)) {
                danificar(8.0, 12.0);

            } else if (t.tecla_pressionada(t.TECLA_R)) {
                reparar();

            }

            if (t.tecla_pressionada(t.TECLA_0)) {
                inicializar_carro_jogador();
                u.aguarde(200);

            }

        }

    }

    private boolean carro_em_movimento() throws ErroExecucao, InterruptedException {
        return carro_jogador[_VELOCIDADE] > 0.0;

    }

    private boolean carro_parado() throws ErroExecucao, InterruptedException {
        return carro_jogador[_VELOCIDADE] <= 0.0;

    }

    private void reparar() throws ErroExecucao, InterruptedException {
        carro_jogador[_DANOS] = m.maior_numero(0.0, carro_jogador[_DANOS] - TAXA_REPARO);

    }

    private void danificar(double velocidade1, double velocidade2) throws ErroExecucao, InterruptedException {
        double diferencial = m.valor_absoluto(velocidade1 - velocidade2);
        double dano = diferencial * TAXA_DANOS;
        carro_jogador[_DANOS] = m.menor_numero(MAXIMO_DANOS, carro_jogador[_DANOS] + dano);

    }

    private void abastecer() throws ErroExecucao, InterruptedException {
        carro_jogador[_COMBUSTIVEL] = m.menor_numero(MAXIMO_COMBUSTIVEL, carro_jogador[_COMBUSTIVEL] + COMBUSTIVEL_GALAO);

    }

    private void virar_para_direita() throws ErroExecucao, InterruptedException {
        int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
        int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        double acostamento = largura_tela - LARGURA_ACOSTAMENTO - (largura / 2.0);
        double nova_posicao = carro_jogador[_X] + (carro_jogador[_VELOCIDADE] / 3.0);
        carro_jogador[_X] = m.menor_numero(nova_posicao, acostamento);

    }

    private void virar_para_esquerda() throws ErroExecucao, InterruptedException {
        int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
        int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        double acostamento = LARGURA_ACOSTAMENTO + (largura / 2.0);
        double nova_posicao = carro_jogador[_X] - (carro_jogador[_VELOCIDADE] / 3.0);
        carro_jogador[_X] = m.maior_numero(nova_posicao, acostamento);

    }

    private void acelerar() throws ErroExecucao, InterruptedException {
        if (!acabou_combustivel()) {
            carro_jogador[_VELOCIDADE] = carro_jogador[_VELOCIDADE] + ACELERACAO;
            carro_jogador[_VELOCIDADE] = m.menor_numero(carro_jogador[_VELOCIDADE], VELOCIDADE_MAXIMA_JOGADOR + ATRITO);

        }

    }

    private void freiar() throws ErroExecucao, InterruptedException {
        if (freiando == false) {
            inicio_freio = distancia_percorrida;
            freiando = true;

        }

        if (carro_em_movimento()) {
            reproduzir_som(som_freio, rep_som_freio, false);

        }

        carro_jogador[_VELOCIDADE] = carro_jogador[_VELOCIDADE] - FREIO;
        carro_jogador[_VELOCIDADE] = m.maior_numero(0.0, carro_jogador[_VELOCIDADE]);

    }

    private void atualizar_fisica_jogo() throws ErroExecucao, InterruptedException {
        aplicar_atrito();
        gastar_combustivel();
        atualizar_posicao_estrada();
        verificar_colisoes();

    }

    private void verificar_colisoes() throws ErroExecucao, InterruptedException {
        int indice = -1;
        if (pegou_combustivel(indice)) {
            sm.reproduzir_som(som_combustivel, false);
            abastecer();
            sortear_posicao_galao(indice);

        }

        indice = -1;
        if (passou_ponto_reparo(indice)) {
            sm.reproduzir_som(som_reparo, false);
            reparar();
            sortear_posicao_ponto_reparo(indice);

        }

        verificar_colisoes_veiculos();

    }

    private void verificar_colisoes_veiculos() throws ErroExecucao, InterruptedException {
        if (!corrida_completada()) {
            int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
            double x1 = carro_jogador[_X];
            double y1 = carro_jogador[_Y];
            int largura1 = MODELOS_VEICULOS[indice_modelo][_LARGURA];
            int altura1 = MODELOS_VEICULOS[indice_modelo][_ALTURA];
            for (int i = 0; i < veiculos.length; i = i + 1) {
                int indice_modelo2 = tp.real_para_inteiro(veiculos[i][_MODELO]);
                double x2 = veiculos[i][_X];
                double y2 = veiculos[i][_Y];
                int largura2 = MODELOS_VEICULOS[indice_modelo2][_LARGURA];
                int altura2 = MODELOS_VEICULOS[indice_modelo2][_ALTURA];
                if (objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2)) {
                    boolean jogador_colidiu_veiculo = objeto_colidiu_acima(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
                    boolean veiculo_colidiu_jogador = objeto_colidiu_abaixo(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
                    double velocidade1 = carro_jogador[_VELOCIDADE];
                    double velocidade2 = veiculos[i][_VELOCIDADE];
                    sm.reproduzir_som(som_colisao, false);
                    danificar(velocidade1, velocidade2);
                    double diferenca_velocidade = m.valor_absoluto(veiculos[i][_VELOCIDADE] - carro_jogador[_VELOCIDADE]);
                    if (jogador_colidiu_veiculo) {
                        double nova_velocidade = veiculos[i][_VELOCIDADE] + (diferenca_velocidade * 2.0);
                        carro_jogador[_VELOCIDADE] = 0.0;
                        veiculos[i][_Y] = veiculos[i][_Y] - veiculos[i][_VELOCIDADE] - diferenca_velocidade;

                    } else if (veiculo_colidiu_jogador) {
                        double nova_velocidade = carro_jogador[_VELOCIDADE] + (diferenca_velocidade * 2.0);
                        carro_jogador[_VELOCIDADE] = m.menor_numero(VELOCIDADE_MAXIMA_JOGADOR, nova_velocidade);
                        veiculos[i][_Y] = veiculos[i][_Y] + veiculos[i][_VELOCIDADE] + diferenca_velocidade;

                    }

                    sm.reproduzir_som(som_colisao, false);
                    danificar(velocidade1, velocidade2);
                    atualizar_posicao_veiculos();
                    atualizar_posicao_estrada();

                }

            }

        }

    }

    private boolean pegou_combustivel(int indice) throws ErroExecucao, InterruptedException {
        int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
        double x1 = carro_jogador[_X];
        double y1 = carro_jogador[_Y];
        int largura1 = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        int altura1 = MODELOS_VEICULOS[indice_modelo][_ALTURA];
        int largura2 = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_LARGURA];
        int altura2 = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_ALTURA];
        for (int i = 0; i < galoes.length; i = i + 1) {
            double x2 = galoes[i][_X];
            double y2 = galoes[i][_Y];
            if (objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2)) {
                indice = i;
                return true;

            }

        }

        return false;

    }

    private boolean passou_ponto_reparo(int indice) throws ErroExecucao, InterruptedException {
        int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
        double x1 = carro_jogador[_X];
        double y1 = carro_jogador[_Y];
        int largura1 = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        int altura1 = MODELOS_VEICULOS[indice_modelo][_ALTURA];
        int largura2 = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_LARGURA];
        int altura2 = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_ALTURA];
        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            double x2 = pontos_reparo[i][_X];
            double y2 = pontos_reparo[i][_Y];
            if (objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2)) {
                indice = i;
                return true;

            }

        }

        return false;

    }

    private boolean objetos_colidiram(double x1, double y1, int largura1, int altura1, double x2, double y2, int largura2, int altura2) throws ErroExecucao, InterruptedException {
        double centro_x1 = x1;
        double centro_y1 = y1 + (altura1 / 2.0);
        double centro_x2 = x2;
        double centro_y2 = y2 + (altura2 / 2.0);
        double distancia_horizontal = m.valor_absoluto(centro_x1 - centro_x2);
        double distancia_vertical = m.valor_absoluto(centro_y1 - centro_y2);
        double distancia_horizontal_minima = (largura1 / 2.0) + (largura2 / 2.0);
        double distancia_vertical_minima = (altura1 / 2.0) + (altura2 / 2.0);
        boolean colidiu_horizontal = distancia_horizontal < distancia_horizontal_minima;
        boolean colidiu_vertical = distancia_vertical < distancia_vertical_minima;
        return (colidiu_horizontal && colidiu_vertical);

    }

    private boolean objeto_colidiu_esquerda(double x1, double y1, int largura1, int altura1, double x2, double y2, int largura2, int altura2) throws ErroExecucao, InterruptedException {
        boolean colidiu = objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
        return (colidiu && x1 > x2);

    }

    private boolean objeto_colidiu_direita(double x1, double y1, int largura1, int altura1, double x2, double y2, int largura2, int altura2) throws ErroExecucao, InterruptedException {
        boolean colidiu = objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
        return (colidiu && x1 < x2);

    }

    private boolean objeto_colidiu_acima(double x1, double y1, int largura1, int altura1, double x2, double y2, int largura2, int altura2) throws ErroExecucao, InterruptedException {
        boolean colidiu = objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
        return (colidiu && y1 > y2);

    }

    private boolean objeto_colidiu_abaixo(double x1, double y1, int largura1, int altura1, double x2, double y2, int largura2, int altura2) throws ErroExecucao, InterruptedException {
        boolean colidiu = objetos_colidiram(x1, y1, largura1, altura1, x2, y2, largura2, altura2);
        return (colidiu && y1 < y2);

    }

    private void gastar_combustivel() throws ErroExecucao, InterruptedException {
        carro_jogador[_COMBUSTIVEL] = m.maior_numero(0.0, carro_jogador[_COMBUSTIVEL] - carro_jogador[_VELOCIDADE]);
        if (acabou_combustivel()) {
            interromper_som(rep_som_alarme_combustivel);

        } else if (nivel_combustivel_critico()) {
            reproduzir_som(som_alarme_combustivel, rep_som_alarme_combustivel, false);

        } else {
            interromper_som(rep_som_alarme_combustivel);

        }

    }

    private void interromper_som(int reproducao_som) throws ErroExecucao, InterruptedException {
        if (reproducao_som > -1) {
            sm.interromper_som(reproducao_som);
            reproducao_som = -1;

        }

    }

    private void reproduzir_som(int som, int reproducao_som, boolean repetir) throws ErroExecucao, InterruptedException {
        if (reproducao_som == -1) {
            reproducao_som = sm.reproduzir_som(som, repetir);

        }

    }

    private boolean nivel_combustivel_critico() throws ErroExecucao, InterruptedException {
        double porcentagem = carro_jogador[_COMBUSTIVEL] / MAXIMO_COMBUSTIVEL;
        return porcentagem < 0.25;

    }

    private boolean acabou_combustivel() throws ErroExecucao, InterruptedException {
        return carro_jogador[_COMBUSTIVEL] <= 0.0;

    }

    private void atualizar_posicao_veiculos() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < veiculos.length; i = i + 1) {
            double x = veiculos[i][_X];
            double y = veiculos[i][_Y];
            int indice_modelo = tp.real_para_inteiro(veiculos[i][_MODELO]);
            int ix = tp.real_para_inteiro(x);
            int iy = tp.real_para_inteiro(y);
            int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
            int altura = MODELOS_VEICULOS[indice_modelo][_ALTURA];
            y = y - veiculos[i][_VELOCIDADE] + carro_jogador[_VELOCIDADE];
            if (objeto_saiu_tela(ix, iy, largura, altura) && y > altura_tela + 1500.0) {
                sortear_posicao_veiculo(i);

            } else {
                veiculos[i][_X] = x;
                veiculos[i][_Y] = y;

            }

        }

    }

    private void atualizar_posicao_galoes() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < galoes.length; i = i + 1) {
            double x = galoes[i][_X];
            double y = galoes[i][_Y];
            int ix = tp.real_para_inteiro(x);
            int iy = tp.real_para_inteiro(y);
            int largura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_LARGURA];
            int altura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_ALTURA];
            y = y + carro_jogador[_VELOCIDADE];
            if (objeto_saiu_tela(ix, iy, largura, altura)) {
                sortear_posicao_galao(i);

            } else {
                galoes[i][_X] = x;
                galoes[i][_Y] = y;

            }

        }

    }

    private void sortear_posicao_galao(int indice) throws ErroExecucao, InterruptedException {
        
        int largura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_LARGURA];
        int altura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_ALTURA];
        double maior_distancia = 0.0;
        for (int i = 0; i < galoes.length; i = i + 1) {
            maior_distancia = m.menor_numero(maior_distancia, galoes[i][_Y]);

        }

        double y = 0.0;
        double x = sortear_posicao_faixa(12);
        y = maior_distancia - u.sorteia(MENOR_DISTANCIA_GALOES, MAIOR_DISTANCIA_GALOES);
        y = m.menor_numero(y, -(altura * 2.0));
        galoes[indice][_X] = x;
        galoes[indice][_Y] = y;
        
    }

    private void atualizar_posicao_pontos_reparo() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            double x = pontos_reparo[i][_X];
            double y = pontos_reparo[i][_Y];
            int ix = tp.real_para_inteiro(x);
            int iy = tp.real_para_inteiro(y);
            int largura = OBJETOS[_OBJ_PONTO_REPARO][_LARGURA];
            int altura = OBJETOS[_OBJ_PONTO_REPARO][_ALTURA];
            y = y + carro_jogador[_VELOCIDADE];
            if (objeto_saiu_tela(ix, iy, largura, altura)) {
                sortear_posicao_ponto_reparo(i);

            } else {
                pontos_reparo[i][_X] = x;
                pontos_reparo[i][_Y] = y;

            }

        }

    }

    private void sortear_posicao_ponto_reparo(int indice) throws ErroExecucao, InterruptedException {
        int largura = OBJETOS[_OBJ_PONTO_REPARO][_LARGURA];
        int altura = OBJETOS[_OBJ_PONTO_REPARO][_ALTURA];
        double maior_distancia = 0.0;
        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            maior_distancia = m.menor_numero(maior_distancia, pontos_reparo[i][_Y]);

        }

        double y = 0.0;
        double x = sortear_posicao_faixa(12);
        y = maior_distancia - u.sorteia(MENOR_DISTANCIA_REPAROS, MAIOR_DISTANCIA_REPAROS);
        y = m.menor_numero(y, -(altura * 2.0));
        pontos_reparo[indice][_X] = x;
        pontos_reparo[indice][_Y] = y;

    }

    private int largura_faixa(int numero_faixas) throws ErroExecucao, InterruptedException {
        return (largura_tela - (LARGURA_ACOSTAMENTO * 2) - 26) / numero_faixas;

    }

    private double sortear_posicao_faixa(int numero_faixas) throws ErroExecucao, InterruptedException {
        int largura = largura_faixa(numero_faixas);
        int faixa = u.sorteia(0, numero_faixas - 1);
        if (faixa < numero_faixas / 2) {
            return LARGURA_ACOSTAMENTO + (faixa * largura) + (largura / 2.0);

        } else {
            return largura_tela - LARGURA_ACOSTAMENTO - ((numero_faixas - 1 - faixa) * largura) - (largura / 2.0);

        }

    }

    private void sortear_posicao_veiculo(int indice) throws ErroExecucao, InterruptedException {
        int indice_modelo = u.sorteia(0, MODELOS_VEICULOS.length - 1);
        int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        int altura = MODELOS_VEICULOS[indice_modelo][_ALTURA];
        double maior_distancia = 0.0;
        for (int i = 0; i < veiculos.length; i = i + 1) {
            maior_distancia = m.menor_numero(maior_distancia, veiculos[i][_Y]);

        }

        double y = 0.0;
        double x = sortear_posicao_faixa(4);
        y = maior_distancia - u.sorteia(MENOR_DISTANCIA_VEICULOS, MAIOR_DISTANCIA_VEICULOS);
        y = m.menor_numero(y, -(altura * 2.0));
        int velocidade_minima = tp.real_para_inteiro(VELOCIDADE_MINIMA_VEICULOS);
        int velocidade_maxima = tp.real_para_inteiro(VELOCIDADE_MAXIMA_VEICULOS);
        int velocidade = u.sorteia(velocidade_minima, velocidade_maxima);
        veiculos[indice][_VELOCIDADE] = tp.inteiro_para_real(velocidade);
        veiculos[indice][_MODELO] = tp.inteiro_para_real(indice_modelo);
        veiculos[indice][_X] = x;
        veiculos[indice][_Y] = y;

    }

    private boolean objeto_saiu_tela(int x, int y, int largura, int altura) throws ErroExecucao, InterruptedException {
        if (y > altura_tela) {
            return true;

        }

        return false;

    }

    private void aplicar_atrito() throws ErroExecucao, InterruptedException {
        carro_jogador[_VELOCIDADE] = m.maior_numero(0.0, carro_jogador[_VELOCIDADE] - ATRITO);

    }

    private void atualizar_posicao_estrada() throws ErroExecucao, InterruptedException {
        deslocamento_estrada = deslocamento_estrada + carro_jogador[_VELOCIDADE];
        if (carro_em_movimento()) {
            distancia_percorrida = distancia_percorrida + carro_jogador[_VELOCIDADE];

        }

        if (deslocamento_estrada > g.altura_imagem(imagem_estrada)) {
            deslocamento_estrada = deslocamento_estrada - g.altura_imagem(imagem_estrada);

        }

    }

    private void desenhar_tela_jogo(boolean renderizar) throws ErroExecucao, InterruptedException {
        desenhar_fundo();
        desenhar_estrada();
        desenhar_galoes();
        desenhar_pontos_reparo();
        desenhar_veiculo_jogador();
        desenhar_veiculos();
        desenhar_medidores();
        desenhar_fps();
        if (renderizar) {
            g.renderizar();

        }

    }

    private void desenhar_medidor_velocidade() throws ErroExecucao, InterruptedException {
        int velocidade_kmh = tp.real_para_inteiro(((140.0 * carro_jogador[_VELOCIDADE]) / VELOCIDADE_MAXIMA_JOGADOR));
        String texto = velocidade_kmh + " Km/h";
        int x = largura_tela - LARGURA_ACOSTAMENTO - g.largura_texto(texto) - 2;
        int y = altura_tela - 35;
        g.definir_tamanho_texto(12.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        g.desenhar_texto(x, y, texto);

    }

    private void desenhar_porcentagem_estrada() throws ErroExecucao, InterruptedException {
        int x = LARGURA_ACOSTAMENTO + 1;
        int y = altura_tela - 35;
        int largura = largura_tela - (LARGURA_ACOSTAMENTO * 2) - 2;
        double distancia = m.menor_numero(distancia_percorrida, EXTENSAO_ESTRADA);
        double km_por_pixel = 3.125E-4;
        double km = m.arredondar(distancia * km_por_pixel, 2);
        int porcentagem = tp.real_para_inteiro(m.arredondar(distancia / EXTENSAO_ESTRADA * 100, 2));
        g.definir_tamanho_texto(12.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        g.desenhar_texto(x, y, "Percorrido: " + km + " Km");
        y = y + g.altura_texto("Km") + 5;
        int largura_medidor = 8;
        int dx = x + (largura * porcentagem / 100) - largura_medidor;
        if ((largura * porcentagem / 100) <= largura_medidor) {
            dx = x;
            largura_medidor = (largura * porcentagem / 100);

        }

        if (dx + largura_medidor > x + largura) {
            dx = x + largura - largura_medidor;

        }

        g.definir_cor(64768);
        g.desenhar_retangulo(dx, y, largura_medidor, 7, false, true);
        g.definir_cor(0);
        g.desenhar_retangulo(x, y, largura_tela - (LARGURA_ACOSTAMENTO * 2) - 3, 7, false, false);
        g.definir_cor(16777215);
        g.desenhar_retangulo(x - 1, y - 1, largura_tela - (LARGURA_ACOSTAMENTO * 2) - 1, 9, false, false);

    }

    private void desenhar_fps() throws ErroExecucao, InterruptedException {
        g.definir_tamanho_texto(12.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        g.desenhar_texto(25, 40, "FPS: " + fps);

    }

    private void desenhar_galoes() throws ErroExecucao, InterruptedException {
        g.definir_cor(16711935);
        for (int i = 0; i < galoes.length; i = i + 1) {
            int x = tp.real_para_inteiro(m.arredondar(galoes[i][_X], 0));
            int y = tp.real_para_inteiro(m.arredondar(galoes[i][_Y], 0));
            int sx = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_SX];
            int sy = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_SY];
            int largura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_LARGURA];
            int altura = OBJETOS[_OBJ_GALAO_COMBUSTIVEL][_ALTURA];
            if (!objeto_saiu_tela(x, y, largura, altura)) {
                g.desenhar_porcao_imagem(x - (largura / 2), y, sx, sy, largura, altura, imagem_objetos);

            }

        }

    }

    private void desenhar_pontos_reparo() throws ErroExecucao, InterruptedException {
        g.definir_cor(255);
        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            int x = tp.real_para_inteiro(m.arredondar(pontos_reparo[i][_X], 0));
            int y = tp.real_para_inteiro(m.arredondar(pontos_reparo[i][_Y], 0));
            int sx = OBJETOS[_OBJ_PONTO_REPARO][_SX];
            int sy = OBJETOS[_OBJ_PONTO_REPARO][_SY];
            int largura = OBJETOS[_OBJ_PONTO_REPARO][_LARGURA];
            int altura = OBJETOS[_OBJ_PONTO_REPARO][_ALTURA];
            if (!objeto_saiu_tela(x, y, largura, altura)) {
                g.desenhar_porcao_imagem(x - (largura / 2), y, sx, sy, largura, altura, imagem_objetos);

            }

        }

    }

    private void desenhar_veiculos() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < veiculos.length; i = i + 1) {
            int indice_modelo = tp.real_para_inteiro(veiculos[i][_MODELO]);
            int x = tp.real_para_inteiro(m.arredondar(veiculos[i][_X], 0));
            int y = tp.real_para_inteiro(m.arredondar(veiculos[i][_Y], 0));
            int sx = MODELOS_VEICULOS[indice_modelo][_SX];
            int sy = MODELOS_VEICULOS[indice_modelo][_SY];
            int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
            int altura = MODELOS_VEICULOS[indice_modelo][_ALTURA];
            if (!objeto_saiu_tela(x, y, largura, altura)) {
                g.desenhar_porcao_imagem(x - (largura / 2), y, sx, sy, largura, altura, imagem_veiculos);

            }

        }

    }

    private void desenhar_medidores() throws ErroExecucao, InterruptedException {
        desenhar_medidor_combustivel();
        desenhar_medidor_danos();
        desenhar_medidor_velocidade();
        desenhar_tempo_jogo();
        desenhar_porcentagem_estrada();

    }

    private void desenhar_tempo_jogo() throws ErroExecucao, InterruptedException {
        String tempo = "Tempo: " + formatar_tempo(tempo_total_jogo);
        g.definir_tamanho_texto(12.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        int x = largura_tela - LARGURA_ACOSTAMENTO - g.largura_texto(tempo) - 2;
        int y = 40;
        g.desenhar_texto(x, y, tempo);

    }

    private String formatar_tempo(int tempo) throws ErroExecucao, InterruptedException {
        int segundos = (tempo / 1000) % 60;
        int minutos = (tempo / 60000);
        String min = txt.preencher_a_esquerda('0', 2, "" + minutos);
        String seg = txt.preencher_a_esquerda('0', 2, "" + segundos);
        return min + ":" + seg;

    }

    private void desenhar_medidor_danos() throws ErroExecucao, InterruptedException {
        int x = largura_tela - LARGURA_MEDIDOR - LARGURA_ACOSTAMENTO - 3;
        double valor = carro_jogador[_DANOS];
        double maximo = MAXIMO_DANOS;
        desenhar_medidor("Danos", x, valor, maximo, true);

    }

    private void desenhar_medidor_combustivel() throws ErroExecucao, InterruptedException {
        int x = LARGURA_ACOSTAMENTO + 2;
        double valor = carro_jogador[_COMBUSTIVEL];
        double maximo = MAXIMO_COMBUSTIVEL;
        desenhar_medidor("Combustivel", x, valor, maximo, false);

    }

    private void desenhar_medidor(String descricao, int x, double valor, double maximo, boolean inverter) throws ErroExecucao, InterruptedException {
        double porcentagem = valor / maximo;
        int cor_barra = 16777215;
        if (porcentagem > 0.5) {
            cor_barra = 64768;

        } else if (porcentagem > 0.25) {
            cor_barra = 16776448;

        } else if (porcentagem >= 0.0) {
            cor_barra = 16580608;

        }

        if (inverter) {
            if (porcentagem > 0.75) {
                cor_barra = 16580608;

            } else if (porcentagem > 0.65) {
                cor_barra = 16776448;

            } else if (porcentagem >= 0.0) {
                cor_barra = 64768;

            }

        }

        int y = 22;
        g.definir_tamanho_texto(12.0);
        g.definir_cor(16777215);
        g.definir_estilo_texto(false, true, false);
        g.desenhar_texto(x - 2, y - g.altura_texto(descricao) - 3, descricao);
        g.definir_cor(cor_barra);
        g.desenhar_retangulo(x, y, tp.real_para_inteiro(LARGURA_MEDIDOR * porcentagem), ALTURA_MEDIDOR, false, true);
        g.definir_cor(0);
        g.desenhar_retangulo(x, y, LARGURA_MEDIDOR, ALTURA_MEDIDOR, false, false);
        g.definir_cor(16777215);
        g.desenhar_retangulo(x - 1, y - 1, LARGURA_MEDIDOR + 2, ALTURA_MEDIDOR + 2, false, false);

    }

    private void desenhar_fundo() throws ErroExecucao, InterruptedException {
        g.definir_cor(11184810);
        g.limpar();

    }

    private void desenhar_veiculo_jogador() throws ErroExecucao, InterruptedException {
        int indice_modelo = tp.real_para_inteiro(carro_jogador[_MODELO]);
        int sx = MODELOS_VEICULOS[indice_modelo][_SX];
        int sy = MODELOS_VEICULOS[indice_modelo][_SY];
        int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        int altura = MODELOS_VEICULOS[indice_modelo][_ALTURA];
        int x = tp.real_para_inteiro(m.arredondar(carro_jogador[_X] - (largura / 2.0), 0));
        int y = tp.real_para_inteiro(m.arredondar(carro_jogador[_Y], 0));
        g.desenhar_porcao_imagem(x, y, sx, sy, largura, altura, imagem_veiculos);
        if (freiando) {
            int traseira = y + altura;
            int lateral_esquerda = x + 5;
            int lateral_direita = x + largura;
            int comprimento_freiada = tp.real_para_inteiro(distancia_percorrida - inicio_freio);
            g.definir_cor(0);
            g.desenhar_retangulo(lateral_esquerda, traseira, 10, comprimento_freiada, false, true);
            g.desenhar_retangulo(lateral_direita - 15, traseira, 10, comprimento_freiada, false, true);

        }

    }

    private void desenhar_estrada() throws ErroExecucao, InterruptedException {
        double y1 = deslocamento_estrada;
        double y2 = deslocamento_estrada + g.altura_imagem(imagem_estrada);
        double y3 = deslocamento_estrada - g.altura_imagem(imagem_estrada);
        int i_y1 = tp.real_para_inteiro(m.arredondar(y1, 0));
        int i_y2 = tp.real_para_inteiro(m.arredondar(y2, 0));
        int i_y3 = tp.real_para_inteiro(m.arredondar(y3, 0));
        g.desenhar_imagem(0, i_y1, imagem_estrada);
        g.desenhar_imagem(0, i_y2, imagem_estrada);
        g.desenhar_imagem(0, i_y3, imagem_estrada);
        desenhar_linha_chegada();

    }

    private void desenhar_linha_chegada() throws ErroExecucao, InterruptedException {
        double distancia_ate_chegada = EXTENSAO_ESTRADA - distancia_percorrida;
        if (distancia_ate_chegada <= carro_jogador[_Y]) {
            int sx = OBJETOS[_OBJ_LINHA_CHEGADA][_SX];
            int sy = OBJETOS[_OBJ_LINHA_CHEGADA][_SY];
            int largura = OBJETOS[_OBJ_LINHA_CHEGADA][_LARGURA];
            int altura = OBJETOS[_OBJ_LINHA_CHEGADA][_ALTURA];
            int x = 0;
            int y = tp.real_para_inteiro(carro_jogador[_Y] - distancia_ate_chegada - altura);
            g.desenhar_porcao_imagem(x, y, sx, sy, largura, altura, imagem_objetos);

        }

    }

    private void trocar_tela(int nova_tela) throws ErroExecucao, InterruptedException {
        if (nova_tela != tela_atual) {
            tela_atual = nova_tela;

        }

    }

    private void reiniciar() throws ErroExecucao, InterruptedException {
        inicializar_carro_jogador();
        inicializar_galoes();
        inicializar_pontos_reparo();
        inicializar_veiculos();
        distancia_percorrida = 0.0;
        tempo_inicio_fps = u.tempo_decorrido();
        tempo_total_jogo = 0;

    }

    private void inicializar_carro_jogador() throws ErroExecucao, InterruptedException {
        int indice_modelo = 8;
        int largura = MODELOS_VEICULOS[indice_modelo][_LARGURA];
        int altura = MODELOS_VEICULOS[indice_modelo][_ALTURA];
        carro_jogador[_MODELO] = tp.inteiro_para_real(indice_modelo);
        carro_jogador[_X] = sortear_posicao_faixa(4);
        carro_jogador[_Y] = (altura_tela - altura - 40.0);
        carro_jogador[_VELOCIDADE] = 0.0;
        carro_jogador[_COMBUSTIVEL] = MAXIMO_COMBUSTIVEL;
        carro_jogador[_DANOS] = 0.0;

    }

    private void inicializar_veiculos() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < veiculos.length; i = i + 1) {
            int velocidade_minima = tp.real_para_inteiro(VELOCIDADE_MINIMA_VEICULOS);
            int velocidade_maxima = tp.real_para_inteiro(VELOCIDADE_MAXIMA_VEICULOS);
            int velocidade = u.sorteia(velocidade_minima, velocidade_maxima);
            veiculos[i][_X] = 0.0;
            veiculos[i][_Y] = 1500.0;
            veiculos[i][_VELOCIDADE] = tp.inteiro_para_real(velocidade);
            veiculos[i][_MODELO] = tp.inteiro_para_real(u.sorteia(0, MODELOS_VEICULOS.length - 1));

        }

        for (int i = 0; i < veiculos.length; i = i + 1) {
            sortear_posicao_veiculo(i);

        }

    }

    private void inicializar_galoes() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < galoes.length; i = i + 1) {
            galoes[i][_X] = 0.0;
            galoes[i][_Y] = 0.0;

        }

        for (int i = 0; i < galoes.length; i = i + 1) {
            sortear_posicao_galao(i);

        }

    }

    private void inicializar_pontos_reparo() throws ErroExecucao, InterruptedException {
        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            pontos_reparo[i][_X] = 0.0;
            pontos_reparo[i][_Y] = 0.0;

        }

        for (int i = 0; i < pontos_reparo.length; i = i + 1) {
            sortear_posicao_ponto_reparo(i);

        }

    }

    private void carregar_imagens() throws ErroExecucao, InterruptedException {
        String diretorio_imagens = "./corrida/imagens/";
        imagem_estrada = g.carregar_imagem(diretorio_imagens + "estrada.jpg");
        imagem_veiculos = g.carregar_imagem(diretorio_imagens + "veiculos.png");
        imagem_objetos = g.carregar_imagem(diretorio_imagens + "objetos.png");

    }

    private void carregar_fontes() throws ErroExecucao, InterruptedException {
        g.carregar_fonte("./fontes/poetsen_one_regular.ttf");
        g.definir_fonte_texto("Poetsen One");

    }

    private void liberar_imagens() throws ErroExecucao, InterruptedException {
        g.liberar_imagem(imagem_veiculos);
        g.liberar_imagem(imagem_estrada);
        g.liberar_imagem(imagem_objetos);

    }
    
    public static void main(String[] args) throws Exception {
        new ExemploCorrida().executar(new String[]{});
    }

}
