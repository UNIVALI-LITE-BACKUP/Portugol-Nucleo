package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import br.univali.portugol.nucleo.mensagens.ErroExecucao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca
(
    descricao = "Esta biblioteca contém um conjunto de funções para manipular a entrada de dados através do teclado do computador", 
    versao = "1.0"
)
public final class Teclado extends Biblioteca
{
    private boolean[] buffer = new boolean[525];
    private final KeyListener observador;
    private int ultimaTecla = -1;
    private boolean temTeclaPressionada = false;
    private boolean aguardandoTecla = false;
    private List<Biblioteca> bibliotecasReservadas;

    public Teclado()
    {
        observador = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                buffer[e.getKeyCode()] = true;
                temTeclaPressionada = true;
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                buffer[e.getKeyCode()] = false;
                ultimaTecla = e.getKeyCode();
                temTeclaPressionada = false;
                
                if (aguardandoTecla)
                {
                    acordarThread();
                }
            }
        };
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Testa se uma determinada <param>tecla</param> está pressionada neste instante",
        parametros = 
        {
            @DocumentacaoParametro(nome = "tecla", descricao = "o código da tecla que será testada")
        },
        autores = 
        {
            @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br"),
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o resultado do teste. <tipo>Verdadeiro</tipo> se a <param>tecla</param> estiver pressionada no momento do teste. Caso contrário, retorna <tipo>falso</tipo>"
    )
    public Boolean tecla_pressionada(Integer tecla) throws ErroExecucao
    {
        return buffer[tecla];
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Testa se existe alguma tecla pressionada neste instante",
        autores = 
        {
            @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br"),
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o resultado do teste. <tipo>Verdadeiro</tipo> se houver uma tecla pressionada no momento do teste. Caso contrário, retorna <tipo>falso</tipo>"
    )    
    public Boolean alguma_tecla_pressionada() throws ErroExecucao
    {
        return temTeclaPressionada;
    }
    
    @DocumentacaoFuncao
    (
        descricao = "Aguarda até que uma tecla seja digitada, isto é, foi pressionada e depois solta, e captura o seu código",
        autores = 
        {
            @Autor(nome = "Fillipi Domingos Pelz", email = "fillipi@univali.br"),
            @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
        },
        retorno = "o código da tecla lida"
    )
    public Integer ler_tecla() throws ErroExecucao
    {
        synchronized (Teclado.this)
        {
            try
            {
                aguardandoTecla = true;
                wait();
                aguardandoTecla = false;
            }
            catch (InterruptedException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        
        return ultimaTecla;
    }
    
    private synchronized void acordarThread()
    {
        notifyAll();
    }
    
    @Override
    protected void inicializar(Programa programa, List<Biblioteca> bibliotecasReservadas) throws ErroExecucao
    {
        this.bibliotecasReservadas = bibliotecasReservadas;
        
        for (Biblioteca biblioteca : bibliotecasReservadas)
        {
            instalarTeclado(biblioteca);
        }
    }
    
    @Override
    protected void bibliotecaRegistrada(Biblioteca biblioteca) throws ErroExecucao
    {
        instalarTeclado(biblioteca);
    }
    
    private void instalarTeclado(Biblioteca biblioteca) throws ErroExecucao
    {
        if (biblioteca instanceof InstaladorTeclado)
        {
            ((InstaladorTeclado) biblioteca).instalarTeclado(observador);
        }
    }
    
    public interface InstaladorTeclado
    {
        public void instalarTeclado(KeyListener observadorTeclado) throws ErroExecucao;
    }
}
