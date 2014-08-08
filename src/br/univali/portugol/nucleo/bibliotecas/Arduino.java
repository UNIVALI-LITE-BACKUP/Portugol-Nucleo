package br.univali.portugol.nucleo.bibliotecas;

import br.univali.portugol.nucleo.Programa;
import br.univali.portugol.nucleo.bibliotecas.arduino.ControladorArduino;
import br.univali.portugol.nucleo.bibliotecas.arduino.Instrucao;
import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoConstante;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import java.util.List;

/**
 *
 * @author Luiz Fernando Noschang
 */
@PropriedadesBiblioteca(tipo = TipoBiblioteca.RESERVADA)
@DocumentacaoBiblioteca(descricao = "Biblioteca que permite controlar o Arduino a partir do Portugol (versão de testes)", versao = "0.1")
public final class Arduino extends Biblioteca
{
    @DocumentacaoConstante(descricao = "esta constante define que o pino será colocado em modo de entrada, ou seja, o valor do pino poderá ser lido pelo Arduino")
    public static final Integer MODO_ENTRADA = 0;

    @DocumentacaoConstante(descricao = "esta constante define que o pino será colocado em modo de saída, ou seja, o valor do pino poderá ser escrito pelo Arduino")
    public static final Integer MODO_SAIDA = 1;

    @DocumentacaoConstante(descricao = "esta constante define que o pino deverá ser ligado")
    public static final Integer ESTADO_LIGADO = 2;

    @DocumentacaoConstante(descricao = "esta constante define que o pino deverá ser desligado")
    public static final Integer ESTADO_DESLIGADO = 3;

    private ControladorArduino controladorArduino;
    private Programa programa;

    @Override
    protected void inicializar(final Programa programa, final List<Biblioteca> bibliotecasReservadas) throws ErroExecucaoBiblioteca
    {
        this.programa = programa;
        this.controladorArduino = new ControladorArduino();
    }

    @Override
    protected void finalizar() throws ErroExecucaoBiblioteca
    {
        controladorArduino.finalizar();
    }

    @DocumentacaoFuncao(
            descricao = "Esta função estabelece uma conexão entre o Portugol e deve ser chamada antes "
            + "de qualquer outra função da biblioteca. Se isto não for feito, o Portugol não poderá controlar o Arduino e um "
            + "erro de execução será lançado ao tentar chamar qualquer uma das outras funções",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void conectar_arduino() throws ErroExecucaoBiblioteca
    {
        this.controladorArduino.inicializar();
    }

    @DocumentacaoFuncao(
            descricao = "Esta função desconecta o Portugol do Arduino e deve ser chamada sempre que o programa não for "
            + "mais utilizar o Arduino. <br><br>Note que, após desconectar do Arduino, o Portugol não poderá mais controlá-lo e será "
            + "lançado um erro de execução caso qualquer uma das funções da biblioteca seja chamada.<br><br>Para voltar a utilizar "
            + "o Arduino, a função conectar_arduino() deverá ser chamada novamente",
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void desconectar_arduino() throws ErroExecucaoBiblioteca
    {
        controladorArduino.finalizar();
    }

    @DocumentacaoFuncao(
            descricao = "Define o modo de operação de um pino. Existem dois modos de operação: entrada e saída. "
            + "No modo de entrada, o valor do pino poderá ser lido pelo Arduino, mas não poderá ser escrito. No modo de saída, "
            + "o valor do pino poderá ser escrito pelo Arduino, mas não poderá ser lido",
            parametros =
            {
                @DocumentacaoParametro(nome = "pino", descricao = "o número pino que terá seu modo alterado"),
                @DocumentacaoParametro(nome = "modo", descricao = "o novo modo de operação do pino")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_modo_pino(Integer pino, Integer modo) throws ErroExecucaoBiblioteca
    {
        if (arduinoConectado())
        {
            if (modo.equals(MODO_ENTRADA) || modo.equals(MODO_SAIDA))
            {
                controladorArduino.enviarInstrucao(Instrucao.DEFINIR_MODO_PINO, Integer.toString(pino), Integer.toString(modo));
            }
            else
            {
                throw new ErroExecucaoBiblioteca("O modo informado é inválido! Deve ser informado um dos seguintes modos: [MODO_ENTRADA, MODO_SAIDA]");
            }
        }
    }

    @DocumentacaoFuncao(
            descricao = "Define o estado de um pino. Esta função só funciona para pinos do tipo digital. Os pinos digitais "
            + "podem assumir dois estados: ligado ou desligado.<br><br>Quando um pino digital está ligado, significa que toda "
            + "a tensão existente na fonte de alimentação do Arduino está passando pelo pino. Quando o pino está desligado, "
            + "significa que nenhuma tensão está passando pelo pino",
            parametros =
            {
                @DocumentacaoParametro(nome = "pino", descricao = "o número pino que será ligado ou desligado"),
                @DocumentacaoParametro(nome = "estado", descricao = "o novo estado do pino")
            },
            autores =
            {
                @Autor(nome = "Luiz Fernando Noschang", email = "noschang@univali.br")
            }
    )
    public void definir_estado_pino(Integer pino, Integer estado) throws ErroExecucaoBiblioteca
    {
        if (arduinoConectado())
        {
            if (estado.equals(ESTADO_LIGADO) || estado.equals(ESTADO_DESLIGADO))
            {
                controladorArduino.enviarInstrucao(Instrucao.DEFINIR_ESTADO_PINO, Integer.toString(pino), Integer.toString(estado));
            }
            else
            {
                throw new ErroExecucaoBiblioteca("O estado informado é inválido! Deve ser informado um dos seguintes estados: [ESTADO_LIGADO, ESTADO_DESLIGADO]");
            }
        }
    }

    private boolean arduinoConectado() throws ErroExecucaoBiblioteca
    {
        if (!controladorArduino.inicializado())
        {
            throw new ErroExecucaoBiblioteca("O Portugol ainda não foi conectado ao Arduino");
        }

        return true;
    }
}
