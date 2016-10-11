package programas;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.Util;
import br.univali.portugol.nucleo.bibliotecas.Sons;
import br.univali.portugol.nucleo.bibliotecas.Graficos;
import br.univali.portugol.nucleo.bibliotecas.Teclado;
import br.univali.portugol.nucleo.bibliotecas.Mouse;
import br.univali.portugol.nucleo.bibliotecas.Matematica;
import br.univali.portugol.nucleo.bibliotecas.Tipos;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExemploBateria extends Programa
{

   private final Util Util = new Util();
   private final Sons Sons = new Sons();
   private final Graficos Graficos = new Graficos();
   private final Teclado Teclado = new Teclado();
   private final Mouse Mouse = new Mouse();
   private final Matematica Matematica = new Matematica();
   private final Tipos Tipos = new Tipos();


   private final int LARGURA_DA_TELA = 725;
   private final int ALTURA_DA_TELA = 300;
   private final int LARGURA_DO_BOTAO = 28;
   private final int ALTURA_DO_BOTAO = 28;
   private final int COR_DE_FUNDO_DOS_CONTROLES = 1644825;
   private final int COR_DAS_BARRAS_DE_VOLUME = 16761344;
   private final int COR_DO_TEXTO = 10526880;
   private final int COR_ESCURA_LINHA_DIVISORIA = 1118481;
   private final int COR_CLARA_LINHA_DIVISORIA = 5000268;
   private final String FONTE_DO_TEXTO = "Verdana";
   private final String PASTA_DE_IMAGENS = "./bateria/imagens/";
   private final String PASTA_DE_SONS = "./bateria/sons/";
   private int imagem_fundo = 0;
   private int imagem_botao_iniciar = 0;
   private int imagem_botao_iniciar_hover = 0;
   private int imagem_botao_parar = 0;
   private int imagem_botao_parar_hover = 0;
   private int imagem_lampada_ligada = 0;
   private int imagem_lampada_desligada = 0;
   private int imagem_botao_ligado = 0;
   private int imagem_botao_ligado_hover = 0;
   private int imagem_botao_desligado = 0;
   private int imagem_botao_desligado_hover = 0;
   private int imagem_botao_aumentar_andamento = 0;
   private int imagem_botao_aumentar_andamento_hover = 0;
   private int imagem_botao_diminuir_andamento = 0;
   private int imagem_botao_diminuir_andamento_hover = 0;
   private int imagem_botao_aumentar_volume_geral = 0;
   private int imagem_botao_aumentar_volume_geral_hover = 0;
   private int imagem_botao_diminuir_volume_geral = 0;
   private int imagem_botao_diminuir_volume_geral_hover = 0;
   private int imagem_botao_aumentar_volume_bumbo = 0;
   private int imagem_botao_diminuir_volume_bumbo = 0;
   private int imagem_botao_aumentar_volume_chimbal = 0;
   private int imagem_botao_diminuir_volume_chimbal = 0;
   private int imagem_botao_aumentar_volume_caixa = 0;
   private int imagem_botao_diminuir_volume_caixa = 0;
   private int som_bumbo = 0;
   private int som_caixa = 0;
   private int som_chimbal = 0;
   private int volume_bumbo = 100;
   private int volume_caixa = 90;
   private int volume_chimbal = 80;
   private int andamento = 100;
   private int tempo_atual = 0;
   private boolean executando = false;
   private final int NUMERO_DE_PECAS = 3;
   private final int NUMERO_DE_BATIDAS = 16;
   private boolean notas[][] = {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}};
   private int ultimo_x = -1;
   private int ultimo_y = -1;
   private boolean clicou = false;


   public ExemploBateria() throws ErroExecucao {}


   @Override
   protected void executar(String[] parametros) throws ErroExecucao, InterruptedException
   {
       List<Biblioteca> libs = new ArrayList<>();
        libs.add(Graficos);
        libs.add(Teclado);
        libs.add(Matematica);
        libs.add(Sons);
        libs.add(Mouse);

        Graficos.inicializar(this, libs);
        Teclado.inicializar(this, libs);
        Util.inicializar();
        Mouse.inicializar(this, libs);
        Tipos.inicializar();
        Sons.inicializar(this, libs);
        Matematica.inicializar();
        
        setDiretorioTrabalho(new File("../Portugol-Studio-Recursos/exemplos/musica"));
       
      inicializar();
      inicializar_batida_padrao();
      executar();
      finalizar();

   }


      private void inicializar_batida_padrao() throws ErroExecucao, InterruptedException
   {
      int BUMBO = 0;
      int CAIXA = 1;
      int CHIMBAL = 2;
      notas[BUMBO][0] = true;
      notas[BUMBO][8] = true;
      notas[BUMBO][10] = true;
      notas[CAIXA][4] = true;
      notas[CAIXA][12] = true;
      notas[CHIMBAL][0] = true;
      notas[CHIMBAL][2] = true;
      notas[CHIMBAL][4] = true;
      notas[CHIMBAL][6] = true;
      notas[CHIMBAL][8] = true;
      notas[CHIMBAL][10] = true;
      notas[CHIMBAL][12] = true;
      notas[CHIMBAL][14] = true;

   }


      private void executar() throws ErroExecucao, InterruptedException
   {
      int tempo_decorrido = 0;
      int tempo_inicial = 0;
      while(!Teclado.tecla_pressionada(Teclado.TECLA_ESC))
      {
         int tempo_semi_colcheia = 60000 / andamento / 4;
         tempo_inicial = Util.tempo_decorrido();
         desenhar();
         if(tempo_decorrido >= tempo_semi_colcheia)
         {
            if(executando)
            {
               atualizar();

            }

            tempo_decorrido = tempo_decorrido % tempo_semi_colcheia;

         }

         tratar_cliques();
         tempo_decorrido = tempo_decorrido + Util.tempo_decorrido() - tempo_inicial;

      }


   }


      private void tratar_cliques() throws ErroExecucao, InterruptedException
   {
      if(Mouse.algum_botao_pressionado())
      {
         if(ultimo_x <= 0 && ultimo_y <= 0)
         {
            ultimo_x = Mouse.posicao_x();
            ultimo_y = Mouse.posicao_y();
            escreva("Mouse pressionado em X: ", ultimo_x, "\n");
            escreva("Mouse pressionado em Y: ", ultimo_y, "\n");
            escreva("\n");

         }


      }
      else
      {
         if(ultimo_x >= 0 && ultimo_y >= 0)
         {
            int delta_x = Mouse.posicao_x() - ultimo_x;
            int delta_y = Mouse.posicao_y() - ultimo_y;
            if(delta_x >= 0 && delta_x <= LARGURA_DO_BOTAO && delta_y >= 0 && delta_y <= ALTURA_DO_BOTAO)
            {
               clicou = true;
               escreva("Clique em X: ", Mouse.posicao_x(), "\n");
               escreva("Clique em Y: ", Mouse.posicao_y(), "\n");
               escreva("\n");

            }


         }

         ultimo_x = -1;
         ultimo_y = -1;

      }


   }


      private void atualizar() throws ErroExecucao, InterruptedException
   {
      tempo_atual = (tempo_atual + 1) % NUMERO_DE_BATIDAS;
      for(int linha = 0; linha < 3; linha = linha + 1)
      {
         for(int coluna = 0; coluna < NUMERO_DE_BATIDAS; coluna = coluna + 1)
         {
            if(notas[linha][coluna] && coluna == tempo_atual)
            {
               int som = -1;
               int volume = 100;
               if(linha == 0)
               {
                  som = som_bumbo;
                  volume = volume_bumbo;

               }
               else
               {
                  if(linha == 1)
                  {
                     som = som_caixa;
                     volume = volume_caixa;

                  }
                  else
                  {
                     som = som_chimbal;
                     volume = volume_chimbal;

                  }


               }

               int reproducao = Sons.reproduzir_som(som, false);
               Sons.definir_volume_reproducao(reproducao, volume);

            }


         }


      }


   }


      private void desenhar() throws ErroExecucao, InterruptedException
   {
      int margem_superior = 100;
      int margem_esquerda = 100;
      int espaco_entre_os_grupos = 10;
      Graficos.desenhar_imagem(0, 0, imagem_fundo);
      desenhar_botoes_de_controles_gerais();
      desenhar_logotipo();
      desenhar_linha_divisoria(margem_superior - 10);
      desenhar_linha_divisoria(220);
      desenhar_descricao(230);
      desenhar_nomes_das_pecas(margem_superior);
      desenhar_botoes_das_pecas(margem_superior, margem_esquerda, espaco_entre_os_grupos);
      desenhar_lampadas(margem_superior - 27, margem_esquerda + 8, espaco_entre_os_grupos);
      desenhar_botoes_de_volume_das_pecas(600, 100);
      Graficos.renderizar();

   }


      private void desenhar_descricao(int y) throws ErroExecucao, InterruptedException
   {
      Graficos.definir_tamanho_texto(12.0);
      Graficos.definir_fonte_texto(FONTE_DO_TEXTO);
      Graficos.definir_cor(COR_DO_TEXTO);
      Graficos.definir_estilo_texto(false, true, false);
      Graficos.desenhar_texto(10, y, "Os c�rculos amarelos s�o batidas ativadas, e cinzas s�o desativadas.");
      Graficos.desenhar_texto(10, y + 20, "Clique em um c�rculo para ativ�-lo ou desativ�-lo.");
      Graficos.desenhar_texto(10, y + 40, "Pode ser feito enquanto est� tocando");

   }


      private void desenhar_logotipo() throws ErroExecucao, InterruptedException
   {
      int x = 470;
      int y = 10;
      double tamanho = 32.0;
      String texto = "Portugol-909";
      Graficos.definir_tamanho_texto(tamanho);
      Graficos.definir_cor(COR_ESCURA_LINHA_DIVISORIA);
      Graficos.desenhar_texto(x + 1, y + 1, texto);
      Graficos.definir_cor(COR_DAS_BARRAS_DE_VOLUME);
      Graficos.desenhar_texto(x, y, texto);

   }


      private boolean desenhar_botao(int x_do_botao, int y_do_botao, int botao_normal, int botao_hover) throws ErroExecucao, InterruptedException
   {
      boolean mouse_em_cima_do_botao = mouse_esta_em_cima_do_botao(x_do_botao, y_do_botao);
      if(mouse_em_cima_do_botao)
      {
         Graficos.desenhar_imagem(x_do_botao, y_do_botao, botao_hover);

      }
      else
      {
         Graficos.desenhar_imagem(x_do_botao, y_do_botao, botao_normal);

      }

      if(mouse_em_cima_do_botao && clicou)
      {
         clicou = false;
         executar_acao(botao_normal);

      }

      return false;

   }

      public static void main(String[] args) throws ErroExecucao, InterruptedException {
          new ExemploBateria().executar(args);
        
    }

      private void executar_acao(int botao_clicado) throws ErroExecucao, InterruptedException
   {
      {
            boolean ___sw_break___ = false;

      if(!___sw_break___ && botao_clicado == imagem_botao_iniciar)
      {
         iniciar();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_parar)
      {
         parar();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_diminuir_andamento)
      {
         diminuir_andamento();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_aumentar_andamento)
      {
         aumentar_andamento();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_aumentar_volume_geral)
      {
         aumentar_volume_geral();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_diminuir_volume_geral)
      {
         diminuir_volume_geral();
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_aumentar_volume_bumbo)
      {
         volume_bumbo = aumentar_volume_peca(volume_bumbo);
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_aumentar_volume_caixa)
      {
         volume_caixa = aumentar_volume_peca(volume_caixa);
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_aumentar_volume_chimbal)
      {
         volume_chimbal = aumentar_volume_peca(volume_chimbal);
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_diminuir_volume_chimbal)
      {
         volume_chimbal = diminuir_volume_peca(volume_chimbal);
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_diminuir_volume_caixa)
      {
         volume_caixa = diminuir_volume_peca(volume_caixa);
         ___sw_break___ = true;

      }

      if(!___sw_break___ && botao_clicado == imagem_botao_diminuir_volume_bumbo)
      {
         volume_bumbo = diminuir_volume_peca(volume_bumbo);
         ___sw_break___ = true;

      }

}

   }


      private int aumentar_volume_peca(int volume) throws ErroExecucao, InterruptedException
   {
      volume = volume + 10;
      if(volume > 100)
      {
         volume = 100;

      }
      
      return volume;
   }


      private int diminuir_volume_peca(int volume) throws ErroExecucao, InterruptedException
   {
      volume = volume - 10;
      if(volume < 0)
      {
         volume = 0;

      }

      return volume;
   }


      private void aumentar_volume_geral() throws ErroExecucao, InterruptedException
   {
      int volume_atual = Sons.obter_volume();
      if(volume_atual < 100)
      {
         int novo_volume = volume_atual + 10;
         Sons.definir_volume(novo_volume);
         escreva("Aumentando volume geral para ", novo_volume, "\n");

      }


   }


      private void diminuir_volume_geral() throws ErroExecucao, InterruptedException
   {
      int volume_atual = Sons.obter_volume();
      if(volume_atual >= 10)
      {
         int novo_volume = volume_atual - 10;
         Sons.definir_volume(novo_volume);
         escreva("Diminuindo volume geral para ", novo_volume, "\n");

      }


   }


      private void desenhar_botoes_de_volume_das_pecas(int x_inicial, int y_inicial) throws ErroExecucao, InterruptedException
   {
      desenha_controles_de_volume(x_inicial, y_inicial, imagem_botao_aumentar_volume_bumbo, imagem_botao_diminuir_volume_bumbo, volume_bumbo);
      y_inicial = y_inicial + ALTURA_DO_BOTAO;
      desenha_controles_de_volume(x_inicial, y_inicial, imagem_botao_aumentar_volume_caixa, imagem_botao_diminuir_volume_caixa, volume_caixa);
      y_inicial = y_inicial + ALTURA_DO_BOTAO;
      desenha_controles_de_volume(x_inicial, y_inicial, imagem_botao_aumentar_volume_chimbal, imagem_botao_diminuir_volume_chimbal, volume_chimbal);

   }


      private void desenha_controles_de_volume(int x, int y, int botao_aumentar, int botao_diminuir, int volume_atual) throws ErroExecucao, InterruptedException
   {
      int espaco_entre_botoes = 1;
      int x_do_botao = x;
      desenhar_botao(x, y, botao_diminuir, imagem_botao_diminuir_volume_geral_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes + LARGURA_DO_BOTAO;
      desenhar_barras_de_volume(x_do_botao, y, 10, volume_atual / 10, COR_CLARA_LINHA_DIVISORIA, COR_DAS_BARRAS_DE_VOLUME);
      x_do_botao = x_do_botao + 52;
      desenhar_botao(x_do_botao, y, botao_aumentar, imagem_botao_aumentar_volume_geral_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes + LARGURA_DO_BOTAO;

   }


      private void desenhar_barras_de_volume(int x, int y, int total_de_barras, int barras_preenchidas, int cor_da_borda, int cor_das_barras) throws ErroExecucao, InterruptedException
   {
      int largura_de_uma_barra = 4;
      int largura_das_barras_preenchidas = barras_preenchidas * (largura_de_uma_barra + 1);
      int altura = ALTURA_DO_BOTAO - 14;
      int largura = total_de_barras * largura_de_uma_barra + (total_de_barras + 1);
      y = y + 7;
      Graficos.definir_cor(cor_das_barras);
      Graficos.desenhar_retangulo(x, y, largura_das_barras_preenchidas, altura, false, true);
      Graficos.definir_cor(cor_da_borda);
      Graficos.desenhar_retangulo(x, y, largura, altura, false, false);
      int x_da_linha = x + largura_de_uma_barra + 1;
      for(int b = 0; b < total_de_barras - 1; b = b + 1)
      {
         Graficos.desenhar_linha(x_da_linha, y, x_da_linha, y + altura);
         x_da_linha = x_da_linha + largura_de_uma_barra + 1;

      }


   }


      private void desenhar_botoes_de_controles_gerais() throws ErroExecucao, InterruptedException
   {
      int margem = 10;
      int espaco_entre_botoes = LARGURA_DO_BOTAO + 3;
      int x_do_botao = margem;
      desenhar_botao(x_do_botao, margem, imagem_botao_iniciar, imagem_botao_iniciar_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes;
      desenhar_botao(x_do_botao, margem, imagem_botao_parar, imagem_botao_parar_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes;
      x_do_botao = x_do_botao + 30;
      desenhar_botao(x_do_botao, margem, imagem_botao_diminuir_andamento, imagem_botao_diminuir_andamento_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes;
      Graficos.definir_tamanho_texto(14.0);
      Graficos.definir_cor(COR_DAS_BARRAS_DE_VOLUME);
      Graficos.desenhar_texto(x_do_botao, margem + 6, Tipos.inteiro_para_cadeia(andamento, 10) + " BPM");
      x_do_botao = x_do_botao + 72;
      desenhar_botao(x_do_botao, margem, imagem_botao_aumentar_andamento, imagem_botao_aumentar_andamento_hover);
      x_do_botao = x_do_botao + (espaco_entre_botoes * 2);
      desenhar_botao(x_do_botao, margem, imagem_botao_diminuir_volume_geral, imagem_botao_diminuir_volume_geral_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes;
      int volume_geral = Sons.obter_volume();
      desenhar_barras_de_volume(x_do_botao, margem, 10, volume_geral / 10, COR_CLARA_LINHA_DIVISORIA, COR_DAS_BARRAS_DE_VOLUME);
      x_do_botao = x_do_botao + 52;
      desenhar_botao(x_do_botao, margem, imagem_botao_aumentar_volume_geral, imagem_botao_aumentar_volume_geral_hover);
      x_do_botao = x_do_botao + espaco_entre_botoes;

   }


      private void iniciar() throws ErroExecucao, InterruptedException
   {
      if(!executando)
      {
         tempo_atual = 0;
         executando = true;

      }


   }


      private void parar() throws ErroExecucao, InterruptedException
   {
      if(executando)
      {
         executando = false;

      }


   }


      private void aumentar_andamento() throws ErroExecucao, InterruptedException
   {
      if(andamento < 160)
      {
         andamento = andamento + 10;

      }


   }


      private void diminuir_andamento() throws ErroExecucao, InterruptedException
   {
      if(andamento > 50)
      {
         andamento = andamento - 10;

      }


   }


      private boolean mouse_esta_em_cima_do_botao(int x_do_botao, int y_do_botao) throws ErroExecucao, InterruptedException
   {
      int mouse_x = Mouse.posicao_x();
      int mouse_y = Mouse.posicao_y();
      boolean mouse_dentro_do_botao_na_horizontal = (mouse_x >= x_do_botao && mouse_x <= x_do_botao + LARGURA_DO_BOTAO);
      boolean mouse_dentro_do_botao_na_vertical = (mouse_y >= y_do_botao && mouse_y <= y_do_botao + ALTURA_DO_BOTAO);
      return mouse_dentro_do_botao_na_horizontal && mouse_dentro_do_botao_na_vertical;

   }


      private void desenhar_lampadas(int margem_superior, int margem_esquerda, int espacamento) throws ErroExecucao, InterruptedException
   {
      int x = margem_esquerda;
      for(int i = 0; i < NUMERO_DE_BATIDAS; i = i + 1)
      {
         if(i % 4 == 0 && i > 0)
         {
            x = x + espacamento;

         }

         if(i != tempo_atual)
         {
            Graficos.desenhar_imagem(x, margem_superior, imagem_lampada_desligada);

         }
         else
         {
            Graficos.desenhar_imagem(x, margem_superior, imagem_lampada_ligada);

         }

         x = x + LARGURA_DO_BOTAO;

      }


   }


      private void desenhar_nomes_das_pecas(int margem_superior) throws ErroExecucao, InterruptedException
   {
      String pecas[] = {"Bumbo", "Caixa", "Chimbal"};
      Graficos.definir_tamanho_texto(14.0);
      Graficos.definir_fonte_texto(FONTE_DO_TEXTO);
      Graficos.definir_cor(COR_DO_TEXTO);
      Graficos.definir_estilo_texto(false, true, false);
      margem_superior = margem_superior + 5;
      int margem_esquerda = 15;
      int MAX = Util.numero_elementos(pecas);
      for(int i = 0; i < MAX; i = i + 1)
      {
         Graficos.desenhar_texto(margem_esquerda, i * ALTURA_DO_BOTAO + margem_superior, pecas[i]);

      }


   }


      private void desenhar_linha_divisoria(int y) throws ErroExecucao, InterruptedException
   {
      Graficos.definir_cor(COR_ESCURA_LINHA_DIVISORIA);
      Graficos.desenhar_linha(0, y, LARGURA_DA_TELA, y);
      Graficos.definir_cor(COR_CLARA_LINHA_DIVISORIA);
      Graficos.desenhar_linha(0, y + 1, LARGURA_DA_TELA, y + 1);

   }


      private void desenhar_botoes_das_pecas(int margem_superior, int margem_esquerda, int espacamento) throws ErroExecucao, InterruptedException
   {
      int y = margem_superior;
      for(int linha = 0; linha < NUMERO_DE_PECAS; linha = linha + 1)
      {
         int x = margem_esquerda;
         for(int coluna = 0; coluna < 16; coluna = coluna + 1)
         {
            if(coluna % 4 == 0 && coluna > 0)
            {
               x = x + espacamento;

            }

            if(mouse_esta_em_cima_do_botao(x, y))
            {
               if(clicou)
               {
                  notas[linha][coluna] = !notas[linha][coluna];
                  clicou = false;

               }

               if(notas[linha][coluna])
               {
                  Graficos.desenhar_imagem(x, y, imagem_botao_ligado_hover);

               }
               else
               {
                  Graficos.desenhar_imagem(x, y, imagem_botao_desligado_hover);

               }


            }
            else
            {
               if(notas[linha][coluna])
               {
                  if(coluna == tempo_atual && executando)
                  {
                     Graficos.desenhar_imagem(x, y, imagem_botao_ligado_hover);

                  }
                  else
                  {
                     Graficos.desenhar_imagem(x, y, imagem_botao_ligado);

                  }


               }
               else
               {
                  Graficos.desenhar_imagem(x, y, imagem_botao_desligado);

               }


            }

            x = x + LARGURA_DO_BOTAO;

         }

         y = y + ALTURA_DO_BOTAO;

      }


   }


      private void inicializar() throws ErroExecucao, InterruptedException
   {
      carregar_imagens();
      carregar_sons();
      Graficos.iniciar_modo_grafico(true);
      Graficos.definir_dimensoes_janela(LARGURA_DA_TELA, ALTURA_DA_TELA);
      Graficos.definir_titulo_janela("Bateria Eletr�nica");

   }


      private void carregar_imagens() throws ErroExecucao, InterruptedException
   {
      imagem_fundo = Graficos.carregar_imagem(PASTA_DE_IMAGENS + "fundo.jpg");
      imagem_lampada_ligada = Graficos.carregar_imagem(PASTA_DE_IMAGENS + "lampada_ligada.png");
      imagem_lampada_desligada = Graficos.carregar_imagem(PASTA_DE_IMAGENS + "lampada_desligada.png");
      
      {
        Retorno_carregar_imagens_botao retorno;

        retorno = carregar_imagens_botao("play");
        imagem_botao_iniciar = retorno.imagem_normal;
        imagem_botao_iniciar_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("stop");
        imagem_botao_parar = retorno.imagem_normal;
        imagem_botao_parar_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("botao_ligado");
        imagem_botao_ligado = retorno.imagem_normal;
        imagem_botao_ligado_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("botao_desligado");
        imagem_botao_desligado = retorno.imagem_normal;
        imagem_botao_desligado_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("mais_andamento");
        imagem_botao_aumentar_andamento = retorno.imagem_normal;
        imagem_botao_aumentar_andamento_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("menos_andamento");
        imagem_botao_diminuir_andamento = retorno.imagem_normal;
        imagem_botao_diminuir_andamento_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("mais_volume");
        imagem_botao_aumentar_volume_geral = retorno.imagem_normal;
        imagem_botao_aumentar_volume_geral_hover = retorno.imagem_hover;

        retorno = carregar_imagens_botao("menos_volume");
        imagem_botao_diminuir_volume_geral = retorno.imagem_normal;
        imagem_botao_diminuir_volume_geral_hover = retorno.imagem_hover;
      }

      {
        Retorno_carregar_imagens_botao_volume retorno;
        
        retorno = carregar_imagens_botao_volume();
        imagem_botao_aumentar_volume_bumbo = retorno.imagem_aumentar;
        imagem_botao_diminuir_volume_bumbo = retorno.imagem_diminuir;
        
        retorno = carregar_imagens_botao_volume();
        imagem_botao_aumentar_volume_caixa = retorno.imagem_aumentar;
        imagem_botao_diminuir_volume_caixa = retorno.imagem_diminuir;
        
        retorno = carregar_imagens_botao_volume();
        imagem_botao_aumentar_volume_chimbal = retorno.imagem_aumentar;
        imagem_botao_diminuir_volume_chimbal = retorno.imagem_diminuir;
      }

   }

      private final class Retorno_carregar_imagens_botao
      {
          public int imagem_normal;
          public int imagem_hover;
      }

    private Retorno_carregar_imagens_botao carregar_imagens_botao(String nome_imagem) throws ErroExecucao, InterruptedException
   {
       Retorno_carregar_imagens_botao retorno = new Retorno_carregar_imagens_botao();
       
      String nome_imagem_normal = nome_imagem + ".png";
      String nome_imagem_hover = nome_imagem + "_hover.png";
      retorno.imagem_normal = Graficos.carregar_imagem(PASTA_DE_IMAGENS + nome_imagem_normal);
      retorno.imagem_hover = Graficos.carregar_imagem(PASTA_DE_IMAGENS + nome_imagem_hover);
      
      return retorno;
   }

    private final class Retorno_carregar_imagens_botao_volume
    {
        public int imagem_aumentar;
        public int imagem_diminuir;
    }

      private Retorno_carregar_imagens_botao_volume carregar_imagens_botao_volume() throws ErroExecucao, InterruptedException
   {
       Retorno_carregar_imagens_botao_volume retorno = new Retorno_carregar_imagens_botao_volume();
       
      String nome_imagem_aumentar = PASTA_DE_IMAGENS + "mais_volume.png";
      String nome_imagem_diminuir = PASTA_DE_IMAGENS + "menos_volume.png";
      retorno.imagem_aumentar = Graficos.carregar_imagem(nome_imagem_aumentar);
      retorno.imagem_diminuir = Graficos.carregar_imagem(nome_imagem_diminuir);

      return retorno;
   }


      private void carregar_sons() throws ErroExecucao, InterruptedException
   {
      som_bumbo = Sons.carregar_som(PASTA_DE_SONS + "bumbo.mp3");
      som_caixa = Sons.carregar_som(PASTA_DE_SONS + "caixa.mp3");
      som_chimbal = Sons.carregar_som(PASTA_DE_SONS + "chimbal.mp3");

   }


      private void finalizar() throws ErroExecucao, InterruptedException
   {
      liberar_imagens();
      liberar_sons();
      Graficos.encerrar_modo_grafico();

   }


      private void liberar_imagens() throws ErroExecucao, InterruptedException
   {
      Graficos.liberar_imagem(imagem_fundo);
      Graficos.liberar_imagem(imagem_botao_iniciar);
      Graficos.liberar_imagem(imagem_botao_iniciar_hover);
      Graficos.liberar_imagem(imagem_botao_parar);
      Graficos.liberar_imagem(imagem_botao_parar_hover);
      Graficos.liberar_imagem(imagem_botao_ligado);
      Graficos.liberar_imagem(imagem_botao_ligado_hover);
      Graficos.liberar_imagem(imagem_botao_desligado);
      Graficos.liberar_imagem(imagem_botao_desligado_hover);
      Graficos.liberar_imagem(imagem_lampada_ligada);
      Graficos.liberar_imagem(imagem_lampada_desligada);
      Graficos.liberar_imagem(imagem_botao_aumentar_andamento);
      Graficos.liberar_imagem(imagem_botao_aumentar_andamento_hover);
      Graficos.liberar_imagem(imagem_botao_diminuir_andamento);
      Graficos.liberar_imagem(imagem_botao_diminuir_andamento_hover);
      Graficos.liberar_imagem(imagem_botao_aumentar_volume_geral);
      Graficos.liberar_imagem(imagem_botao_aumentar_volume_geral_hover);
      Graficos.liberar_imagem(imagem_botao_diminuir_volume_geral);
      Graficos.liberar_imagem(imagem_botao_diminuir_volume_geral_hover);
      Graficos.liberar_imagem(imagem_botao_aumentar_volume_bumbo);
      Graficos.liberar_imagem(imagem_botao_diminuir_volume_bumbo);
      Graficos.liberar_imagem(imagem_botao_aumentar_volume_caixa);
      Graficos.liberar_imagem(imagem_botao_diminuir_volume_caixa);
      Graficos.liberar_imagem(imagem_botao_aumentar_volume_chimbal);
      Graficos.liberar_imagem(imagem_botao_diminuir_volume_chimbal);

   }


      private void liberar_sons() throws ErroExecucao, InterruptedException
   {
      Sons.liberar_som(som_bumbo);
      Sons.liberar_som(som_caixa);
      Sons.liberar_som(som_chimbal);

   }

}
