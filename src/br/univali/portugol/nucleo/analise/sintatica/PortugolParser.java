// $ANTLR 3.4 D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g 2012-04-29 17:54:45
package br.univali.portugol.nucleo.analise.sintatica;

import br.univali.portugol.nucleo.asa.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings(
{
    "all", "warnings", "unchecked"
})
public class PortugolParser extends Parser
{
    public static final String[] tokenNames = new String[]
    {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CADEIA", "CARACTER", "COMENTARIO", "DIGIT_HEX", "ESC_OCTAL", "ESC_UNICODE", "ESPACO", "ID", "INTEIRO", "LOGICO", "OPERADOR_NAO", "PR_CADEIA", "PR_CARACTER", "PR_CASO", "PR_CASO_CONTRARIO", "PR_CONST", "PR_ENQUANTO", "PR_ESCOLHA", "PR_FACA", "PR_FALSO", "PR_FUNCAO", "PR_INTEIRO", "PR_LOGICO", "PR_PARA", "PR_PARE", "PR_PROGRAMA", "PR_REAL", "PR_RETORNE", "PR_SE", "PR_SENAO", "PR_VAZIO", "PR_VERDADEIRO", "REAL", "SEQ_ESC", "'!='", "'%'", "'%='", "'&'", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-='", "'/'", "'/='", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'e'", "'ou'", "'{'", "'}'"
    };
    public static final int EOF = -1;
    public static final int T__38 = 38;
    public static final int T__39 = 39;
    public static final int T__40 = 40;
    public static final int T__41 = 41;
    public static final int T__42 = 42;
    public static final int T__43 = 43;
    public static final int T__44 = 44;
    public static final int T__45 = 45;
    public static final int T__46 = 46;
    public static final int T__47 = 47;
    public static final int T__48 = 48;
    public static final int T__49 = 49;
    public static final int T__50 = 50;
    public static final int T__51 = 51;
    public static final int T__52 = 52;
    public static final int T__53 = 53;
    public static final int T__54 = 54;
    public static final int T__55 = 55;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int T__59 = 59;
    public static final int T__60 = 60;
    public static final int T__61 = 61;
    public static final int T__62 = 62;
    public static final int T__63 = 63;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__68 = 68;
    public static final int CADEIA = 4;
    public static final int CARACTER = 5;
    public static final int COMENTARIO = 6;
    public static final int DIGIT_HEX = 7;
    public static final int ESC_OCTAL = 8;
    public static final int ESC_UNICODE = 9;
    public static final int ESPACO = 10;
    public static final int ID = 11;
    public static final int INTEIRO = 12;
    public static final int LOGICO = 13;
    public static final int OPERADOR_NAO = 14;
    public static final int PR_CADEIA = 15;
    public static final int PR_CARACTER = 16;
    public static final int PR_CASO = 17;
    public static final int PR_CASO_CONTRARIO = 18;
    public static final int PR_CONST = 19;
    public static final int PR_ENQUANTO = 20;
    public static final int PR_ESCOLHA = 21;
    public static final int PR_FACA = 22;
    public static final int PR_FALSO = 23;
    public static final int PR_FUNCAO = 24;
    public static final int PR_INTEIRO = 25;
    public static final int PR_LOGICO = 26;
    public static final int PR_PARA = 27;
    public static final int PR_PARE = 28;
    public static final int PR_PROGRAMA = 29;
    public static final int PR_REAL = 30;
    public static final int PR_RETORNE = 31;
    public static final int PR_SE = 32;
    public static final int PR_SENAO = 33;
    public static final int PR_VAZIO = 34;
    public static final int PR_VERDADEIRO = 35;
    public static final int REAL = 36;
    public static final int SEQ_ESC = 37;

    // delegates
    public Parser[] getDelegates()
    {
        return new Parser[]
                {
                };
    }

    // delegators
    public PortugolParser(TokenStream input)
    {
        this(input, new RecognizerSharedState());
    }

    public PortugolParser(TokenStream input, RecognizerSharedState state)
    {
        super(input, state);
    }

    public String[] getTokenNames()
    {
        return PortugolParser.tokenNames;
    }

    public String getGrammarFileName()
    {
        return "D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g";
    }
    private boolean gerarArvore = true;
    private int quantidadeErros = 0;
    private Stack<String> pilhaContexto = new Stack<String>();
    private List<ObservadorParsing> observadores = new ArrayList<ObservadorParsing>();

    public void adicionarObservadorParsing(ObservadorParsing observador)
    {
        if (!observadores.contains(observador))
        {
            observadores.add(observador);
        }
    }

    public void removerObservadorParsing(ObservadorParsing observador)
    {
        observadores.remove(observador);
    }

    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        gerarArvore = false;
        quantidadeErros = quantidadeErros + 1;
        String mensagemPadrao = getErrorHeader(e) + " - " + getErrorMessage(e, tokenNames);

        for (ObservadorParsing observador : observadores)
        {
            Stack<String> copiaPilha = new Stack<String>();
            copiaPilha.addAll(pilhaContexto);

            observador.tratarErroParsing(e, tokenNames, copiaPilha, mensagemPadrao);
        }
    }

    private class InformacaoTipoDado
    {
        private TipoDado tipoDado;
        private TrechoCodigoFonte trechoCodigoFonte;

        public InformacaoTipoDado()
        {
        }

        public TipoDado getTipoDado()
        {
            return tipoDado;
        }

        public TrechoCodigoFonte getTrechoCodigoFonte()
        {
            return trechoCodigoFonte;
        }

        public void setTipoDado(TipoDado tipoDado)
        {
            this.tipoDado = tipoDado;
        }

        public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
        {
            this.trechoCodigoFonte = trechoCodigoFonte;
        }
    }

    private TrechoCodigoFonte criarTrechoCodigoFonte(Token tokenAntlr)
    {
        if (tokenAntlr != null)
        {
            int linha = tokenAntlr.getLine();
            int coluna = tokenAntlr.getCharPositionInLine();
            int tamanhoTexto = tokenAntlr.getText().length();

            return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
        }

        return null;
    }

    private NoExpressao selecionarExpressao(NoExpressao operandoEsquerdo, NoExpressao operandoDireito, Token operador)
    {
        if (operandoDireito != null)
        {
            NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));

            return operacao;
        }
        else
        {
            return operandoEsquerdo;
        }
    }

    // $ANTLR start "parse"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:171:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException
    {
        ArvoreSintaticaAbstrata asa = null;


        ArvoreSintaticaAbstrata prog = null;


        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:171:43: (prog= programa )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:173:2: prog= programa
            {
                pushFollow(FOLLOW_programa_in_parse766);
                prog = programa();

                state._fsp--;
                if (state.failed)
                {
                    return asa;
                }

                if (state.backtracking == 0)
                {
                    asa = prog;
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving
        }
        return asa;
    }
    // $ANTLR end "parse"

    // $ANTLR start "programa"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:180:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException
    {
        ArvoreSintaticaAbstrata asa = null;



        pilhaContexto.push("programa");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:183:2: ( PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:185:2: PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
                match(input, PR_PROGRAMA, FOLLOW_PR_PROGRAMA_in_programa788);
                if (state.failed)
                {
                    return asa;
                }

                match(input, 67, FOLLOW_67_in_programa791);
                if (state.failed)
                {
                    return asa;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        asa = new ArvoreSintaticaAbstrataPrograma();
                        asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
                    }
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:195:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
                loop1:
                do
                {
                    int alt1 = 3;
                    int LA1_0 = input.LA(1);

                    if (((LA1_0 >= PR_CADEIA && LA1_0 <= PR_CARACTER) || LA1_0 == PR_CONST || (LA1_0 >= PR_INTEIRO && LA1_0 <= PR_LOGICO) || LA1_0 == PR_REAL))
                    {
                        alt1 = 1;
                    }
                    else if ((LA1_0 == PR_FUNCAO))
                    {
                        alt1 = 2;
                    }


                    switch (alt1)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:195:4: declaracoesGlobais[asa]
                        {
                            pushFollow(FOLLOW_declaracoesGlobais_in_programa803);
                            declaracoesGlobais(asa);

                            state._fsp--;
                            if (state.failed)
                            {
                                return asa;
                            }

                        }
                        break;
                        case 2:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:195:30: declaracaoFuncao[asa]
                        {
                            pushFollow(FOLLOW_declaracaoFuncao_in_programa808);
                            declaracaoFuncao(asa);

                            state._fsp--;
                            if (state.failed)
                            {
                                return asa;
                            }

                        }
                        break;

                        default:
                            break loop1;
                    }
                }
                while (true);


                match(input, 68, FOLLOW_68_in_programa814);
                if (state.failed)
                {
                    return asa;
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return asa;
    }
    // $ANTLR end "programa"

    // $ANTLR start "declaracoesGlobais"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:204:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException
    {
        List<NoDeclaracao> vListaDeclaracoes = null;



        pilhaContexto.push("declaracoesGlobais");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:207:2: (vListaDeclaracoes= listaDeclaracoes )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:209:2: vListaDeclaracoes= listaDeclaracoes
            {
                pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais840);
                vListaDeclaracoes = listaDeclaracoes();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if (asa != null)
                        {
                            List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();

                            if (listaDeclaracoesGlobais != null)
                            {
                                for (NoDeclaracao declaracao : vListaDeclaracoes)
                                {
                                    listaDeclaracoesGlobais.add(declaracao);
                                }
                            }
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return;
    }
    // $ANTLR end "declaracoesGlobais"

    // $ANTLR start "declaracoesLocais"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:232:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException
    {
        List<NoDeclaracao> vListaDeclaracoes = null;



        pilhaContexto.push("declaracoesLocais");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:235:2: (vListaDeclaracoes= listaDeclaracoes )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:237:2: vListaDeclaracoes= listaDeclaracoes
            {
                pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais868);
                vListaDeclaracoes = listaDeclaracoes();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if ((listaBlocos != null) && (vListaDeclaracoes != null))
                        {
                            for (NoDeclaracao declaracao : vListaDeclaracoes)
                            {
                                listaBlocos.add(declaracao);
                            }
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return;
    }
    // $ANTLR end "declaracoesLocais"

    // $ANTLR start "listaDeclaracoes"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:255:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException
    {
        List<NoDeclaracao> listaDeclaracoes = null;


        Token tokenConst = null;
        InformacaoTipoDado informacaoTipoDado = null;

        NoDeclaracao vDeclaracao = null;



        pilhaContexto.push("listaDeclaracoes");
        listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:259:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:260:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:260:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:261:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
                {
                    if (state.backtracking == 0)
                    {
                        tokenConst = null;
                    }

                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:263:2: (tokenConst= PR_CONST )?
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);

                    if ((LA2_0 == PR_CONST))
                    {
                        alt2 = 1;
                    }
                    switch (alt2)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:263:3: tokenConst= PR_CONST
                        {
                            tokenConst = (Token) match(input, PR_CONST, FOLLOW_PR_CONST_in_listaDeclaracoes905);
                            if (state.failed)
                            {
                                return listaDeclaracoes;
                            }

                        }
                        break;

                    }


                    pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes913);
                    informacaoTipoDado = declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed)
                    {
                        return listaDeclaracoes;
                    }
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:265:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:265:4: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
                    {
                        pushFollow(FOLLOW_declaracao_in_listaDeclaracoes924);
                        vDeclaracao = declaracao(tokenConst, informacaoTipoDado);

                        state._fsp--;
                        if (state.failed)
                        {
                            return listaDeclaracoes;
                        }

                        if (state.backtracking == 0)
                        {
                            if (gerarArvore)
                            {
                                if (vDeclaracao != null)
                                {
                                    listaDeclaracoes.add(vDeclaracao);
                                }

                                vDeclaracao = null;
                            }
                        }

                    }


                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:276:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
                    loop3:
                    do
                    {
                        int alt3 = 2;
                        int LA3_0 = input.LA(1);

                        if ((LA3_0 == 49))
                        {
                            alt3 = 1;
                        }


                        switch (alt3)
                        {
                            case 1:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:276:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
                            {
                                match(input, 49, FOLLOW_49_in_listaDeclaracoes946);
                                if (state.failed)
                                {
                                    return listaDeclaracoes;
                                }

                                pushFollow(FOLLOW_declaracao_in_listaDeclaracoes952);
                                vDeclaracao = declaracao(tokenConst, informacaoTipoDado);

                                state._fsp--;
                                if (state.failed)
                                {
                                    return listaDeclaracoes;
                                }

                                if (state.backtracking == 0)
                                {
                                    if (gerarArvore)
                                    {
                                        if (vDeclaracao != null)
                                        {
                                            listaDeclaracoes.add(vDeclaracao);
                                        }

                                        vDeclaracao = null;
                                    }
                                }

                            }
                            break;

                            default:
                                break loop3;
                        }
                    }
                    while (true);


                }


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaDeclaracoes;
    }
    // $ANTLR end "listaDeclaracoes"

    // $ANTLR start "declaracao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:294:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
    public final NoDeclaracao declaracao(Token tokenConst, InformacaoTipoDado informacaoTipoDado) throws RecognitionException
    {
        NoDeclaracao declaracao = null;


        Token tk1 = null;
        Token tk2 = null;
        Token ID1 = null;
        NoExpressao ind1 = null;

        NoExpressao ind2 = null;

        NoExpressao inicializacao = null;



        pilhaContexto.push("declaracao");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:297:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
                {
                    ID1 = (Token) match(input, ID, FOLLOW_ID_in_declaracao991);
                    if (state.failed)
                    {
                        return declaracao;
                    }

                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
                    int alt7 = 2;
                    int LA7_0 = input.LA(1);

                    if ((LA7_0 == 63))
                    {
                        alt7 = 1;
                    }
                    switch (alt7)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                        {
                            tk1 = (Token) match(input, 63, FOLLOW_63_in_declaracao998);
                            if (state.failed)
                            {
                                return declaracao;
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:17: (ind1= expressao )?
                            int alt4 = 2;
                            int LA4_0 = input.LA(1);

                            if (((LA4_0 >= CADEIA && LA4_0 <= CARACTER) || (LA4_0 >= ID && LA4_0 <= OPERADOR_NAO) || LA4_0 == REAL || LA4_0 == 42 || LA4_0 == 50 || LA4_0 == 67))
                            {
                                alt4 = 1;
                            }
                            switch (alt4)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:18: ind1= expressao
                                {
                                    pushFollow(FOLLOW_expressao_in_declaracao1005);
                                    ind1 = expressao();

                                    state._fsp--;
                                    if (state.failed)
                                    {
                                        return declaracao;
                                    }

                                }
                                break;

                            }


                            match(input, 64, FOLLOW_64_in_declaracao1009);
                            if (state.failed)
                            {
                                return declaracao;
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:41: (tk2= '[' (ind2= expressao )? ']' )?
                            int alt6 = 2;
                            int LA6_0 = input.LA(1);

                            if ((LA6_0 == 63))
                            {
                                alt6 = 1;
                            }
                            switch (alt6)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:42: tk2= '[' (ind2= expressao )? ']'
                                {
                                    tk2 = (Token) match(input, 63, FOLLOW_63_in_declaracao1016);
                                    if (state.failed)
                                    {
                                        return declaracao;
                                    }

                                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:52: (ind2= expressao )?
                                    int alt5 = 2;
                                    int LA5_0 = input.LA(1);

                                    if (((LA5_0 >= CADEIA && LA5_0 <= CARACTER) || (LA5_0 >= ID && LA5_0 <= OPERADOR_NAO) || LA5_0 == REAL || LA5_0 == 42 || LA5_0 == 50 || LA5_0 == 67))
                                    {
                                        alt5 = 1;
                                    }
                                    switch (alt5)
                                    {
                                        case 1:
                                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:53: ind2= expressao
                                        {
                                            pushFollow(FOLLOW_expressao_in_declaracao1023);
                                            ind2 = expressao();

                                            state._fsp--;
                                            if (state.failed)
                                            {
                                                return declaracao;
                                            }

                                        }
                                        break;

                                    }


                                    match(input, 64, FOLLOW_64_in_declaracao1027);
                                    if (state.failed)
                                    {
                                        return declaracao;
                                    }

                                }
                                break;

                            }


                        }
                        break;

                    }


                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:80: ( '=' inicializacao= expressao )?
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);

                    if ((LA8_0 == 59))
                    {
                        alt8 = 1;
                    }
                    switch (alt8)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:299:81: '=' inicializacao= expressao
                        {
                            match(input, 59, FOLLOW_59_in_declaracao1034);
                            if (state.failed)
                            {
                                return declaracao;
                            }

                            pushFollow(FOLLOW_expressao_in_declaracao1040);
                            inicializacao = expressao();

                            state._fsp--;
                            if (state.failed)
                            {
                                return declaracao;
                            }

                        }
                        break;

                    }


                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        boolean constante = (tokenConst != null);
                        TipoDado tipoDado = (informacaoTipoDado != null) ? informacaoTipoDado.getTipoDado() : null;
                        String nome = (ID1 != null) ? (ID1 != null ? ID1.getText() : null) : null;

                        if ((tk1 == null) && (tk2 == null))
                        {
                            declaracao = new NoDeclaracaoVariavel(nome, tipoDado, constante);
                        }
                        else if ((tk1 != null) && (tk2 == null))
                        {
                            declaracao = new NoDeclaracaoVetor(nome, tipoDado, ind1, constante);
                        }
                        else if ((tk1 != null) && (tk2 != null))
                        {
                            declaracao = new NoDeclaracaoMatriz(nome, tipoDado, ind1, ind2, constante);
                        }

                        declaracao.setInicializacao(inicializacao);
                        declaracao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID1));
                        declaracao.setTrechoCodigoFonteTipoDado((informacaoTipoDado != null) ? informacaoTipoDado.getTrechoCodigoFonte() : null);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return declaracao;
    }
    // $ANTLR end "declaracao"

    // $ANTLR start "declaracaoTipoDado"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:332:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException
    {
        InformacaoTipoDado informacaoTipoDado = null;


        Token tokenTipoDado = null;


        pilhaContexto.push("declaracaoTipoDado");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:335:2: ( (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
                int alt9 = 5;
                switch (input.LA(1))
                {
                    case PR_INTEIRO:
                    {
                        alt9 = 1;
                    }
                    break;
                    case PR_REAL:
                    {
                        alt9 = 2;
                    }
                    break;
                    case PR_CARACTER:
                    {
                        alt9 = 3;
                    }
                    break;
                    case PR_CADEIA:
                    {
                        alt9 = 4;
                    }
                    break;
                    case PR_LOGICO:
                    {
                        alt9 = 5;
                    }
                    break;
                    default:
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return informacaoTipoDado;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 9, 0, input);

                        throw nvae;

                }

                switch (alt9)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:3: tokenTipoDado= PR_INTEIRO
                    {
                        tokenTipoDado = (Token) match(input, PR_INTEIRO, FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1075);
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:32: tokenTipoDado= PR_REAL
                    {
                        tokenTipoDado = (Token) match(input, PR_REAL, FOLLOW_PR_REAL_in_declaracaoTipoDado1083);
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;
                    case 3:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:58: tokenTipoDado= PR_CARACTER
                    {
                        tokenTipoDado = (Token) match(input, PR_CARACTER, FOLLOW_PR_CARACTER_in_declaracaoTipoDado1091);
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;
                    case 4:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:88: tokenTipoDado= PR_CADEIA
                    {
                        tokenTipoDado = (Token) match(input, PR_CADEIA, FOLLOW_PR_CADEIA_in_declaracaoTipoDado1099);
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;
                    case 5:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:116: tokenTipoDado= PR_LOGICO
                    {
                        tokenTipoDado = (Token) match(input, PR_LOGICO, FOLLOW_PR_LOGICO_in_declaracaoTipoDado1107);
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        informacaoTipoDado = new InformacaoTipoDado();
                        informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
                        informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDado"

    // $ANTLR start "declaracaoTipoDadoVazio"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:353:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException
    {
        InformacaoTipoDado informacaoTipoDado = null;


        Token PR_VAZIO2 = null;


        pilhaContexto.push("declaracaoTipoDadoVazio");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:356:2: ( PR_VAZIO )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:358:2: PR_VAZIO
            {
                PR_VAZIO2 = (Token) match(input, PR_VAZIO, FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1134);
                if (state.failed)
                {
                    return informacaoTipoDado;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        informacaoTipoDado = new InformacaoTipoDado();
                        informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
                        informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(PR_VAZIO2));
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDadoVazio"

    // $ANTLR start "quantificador"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:375:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException
    {
        Quantificador quantificador = null;


        Token tk1 = null;
        Token tk2 = null;


        pilhaContexto.push("quantificador");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:378:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:380:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:380:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
                int alt11 = 2;
                int LA11_0 = input.LA(1);

                if ((LA11_0 == 63))
                {
                    alt11 = 1;
                }
                switch (alt11)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:380:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                        tk1 = (Token) match(input, 63, FOLLOW_63_in_quantificador1166);
                        if (state.failed)
                        {
                            return quantificador;
                        }

                        match(input, 64, FOLLOW_64_in_quantificador1168);
                        if (state.failed)
                        {
                            return quantificador;
                        }

                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:380:17: (tk2= '[' ']' )?
                        int alt10 = 2;
                        int LA10_0 = input.LA(1);

                        if ((LA10_0 == 63))
                        {
                            alt10 = 1;
                        }
                        switch (alt10)
                        {
                            case 1:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:380:18: tk2= '[' ']'
                            {
                                tk2 = (Token) match(input, 63, FOLLOW_63_in_quantificador1175);
                                if (state.failed)
                                {
                                    return quantificador;
                                }

                                match(input, 64, FOLLOW_64_in_quantificador1177);
                                if (state.failed)
                                {
                                    return quantificador;
                                }

                            }
                            break;

                        }


                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if ((tk1 == null) && (tk2 == null))
                        {
                            quantificador = Quantificador.VALOR;
                        }
                        else if ((tk1 != null) && (tk2 == null))
                        {
                            quantificador = Quantificador.VETOR;
                        }
                        else if ((tk1 != null) && (tk2 != null))
                        {
                            quantificador = Quantificador.MATRIZ;
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return quantificador;
    }
    // $ANTLR end "quantificador"

    // $ANTLR start "tipoRetornoFuncao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:398:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException
    {
        InformacaoTipoDado informacaoTipoDado = null;


        InformacaoTipoDado informacao = null;



        pilhaContexto.push("tipoRetornoFuncao");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:401:2: ( (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:403:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:403:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
                int alt12 = 3;
                int LA12_0 = input.LA(1);

                if (((LA12_0 >= PR_CADEIA && LA12_0 <= PR_CARACTER) || (LA12_0 >= PR_INTEIRO && LA12_0 <= PR_LOGICO) || LA12_0 == PR_REAL))
                {
                    alt12 = 1;
                }
                else if ((LA12_0 == PR_VAZIO))
                {
                    alt12 = 2;
                }
                switch (alt12)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:403:3: informacao= declaracaoTipoDado
                    {
                        pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1213);
                        informacao = declaracaoTipoDado();

                        state._fsp--;
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:403:37: informacao= declaracaoTipoDadoVazio
                    {
                        pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1221);
                        informacao = declaracaoTipoDadoVazio();

                        state._fsp--;
                        if (state.failed)
                        {
                            return informacaoTipoDado;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if (informacao != null)
                        {
                            informacaoTipoDado = informacao;
                        }
                        else
                        {
                            informacaoTipoDado = new InformacaoTipoDado();
                            informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "tipoRetornoFuncao"

    // $ANTLR start "declaracaoFuncao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:423:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException
    {
        Token ID3 = null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;

        List<NoDeclaracaoParametro> vListaParametros = null;

        List<NoBloco> vBlocos = null;



        pilhaContexto.push("declaracaoFuncao");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:426:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:428:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
                match(input, PR_FUNCAO, FOLLOW_PR_FUNCAO_in_declaracaoFuncao1248);
                if (state.failed)
                {
                    return;
                }

                pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1258);
                informacaoTipoDado = tipoRetornoFuncao();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1267);
                vQuantificador = quantificador();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                ID3 = (Token) match(input, ID, FOLLOW_ID_in_declaracaoFuncao1274);
                if (state.failed)
                {
                    return;
                }

                match(input, 42, FOLLOW_42_in_declaracaoFuncao1276);
                if (state.failed)
                {
                    return;
                }

                pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1282);
                vListaParametros = listaParametrosFuncao();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                match(input, 43, FOLLOW_43_in_declaracaoFuncao1284);
                if (state.failed)
                {
                    return;
                }

                match(input, 67, FOLLOW_67_in_declaracaoFuncao1304);
                if (state.failed)
                {
                    return;
                }

                pushFollow(FOLLOW_blocos_in_declaracaoFuncao1312);
                vBlocos = blocos();

                state._fsp--;
                if (state.failed)
                {
                    return;
                }

                match(input, 68, FOLLOW_68_in_declaracaoFuncao1322);
                if (state.failed)
                {
                    return;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao((ID3 != null ? ID3.getText() : null), informacaoTipoDado.getTipoDado(), vQuantificador);
                        declaracaoFuncao.setParametros(vListaParametros);
                        declaracaoFuncao.setBlocos(vBlocos);

                        declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID3));
                        declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());

                        asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return;
    }
    // $ANTLR end "declaracaoFuncao"

    // $ANTLR start "listaParametrosFuncao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:459:1: listaParametrosFuncao returns [List<NoDeclaracaoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoDeclaracaoParametro> listaParametrosFuncao() throws RecognitionException
    {
        List<NoDeclaracaoParametro> listaParametros = null;


        NoDeclaracaoParametro vDeclaracaoParametro = null;



        pilhaContexto.push("listaParametrosFuncao");
        listaParametros = new ArrayList<NoDeclaracaoParametro>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:463:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:464:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:464:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
                int alt14 = 2;
                int LA14_0 = input.LA(1);

                if (((LA14_0 >= PR_CADEIA && LA14_0 <= PR_CARACTER) || (LA14_0 >= PR_INTEIRO && LA14_0 <= PR_LOGICO) || LA14_0 == PR_REAL))
                {
                    alt14 = 1;
                }
                switch (alt14)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:465:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:465:3: (vDeclaracaoParametro= declaracaoParametro )
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:465:8: vDeclaracaoParametro= declaracaoParametro
                        {
                            pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1377);
                            vDeclaracaoParametro = declaracaoParametro();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaParametros;
                            }

                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    listaParametros.add(vDeclaracaoParametro);
                                }
                            }

                        }


                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:474:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                        loop13:
                        do
                        {
                            int alt13 = 2;
                            int LA13_0 = input.LA(1);

                            if ((LA13_0 == 49))
                            {
                                alt13 = 1;
                            }


                            switch (alt13)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:474:4: ',' vDeclaracaoParametro= declaracaoParametro
                                {
                                    match(input, 49, FOLLOW_49_in_listaParametrosFuncao1405);
                                    if (state.failed)
                                    {
                                        return listaParametros;
                                    }

                                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1411);
                                    vDeclaracaoParametro = declaracaoParametro();

                                    state._fsp--;
                                    if (state.failed)
                                    {
                                        return listaParametros;
                                    }

                                    if (state.backtracking == 0)
                                    {
                                        if (gerarArvore)
                                        {
                                            listaParametros.add(vDeclaracaoParametro);
                                        }
                                    }

                                }
                                break;

                                default:
                                    break loop13;
                            }
                        }
                        while (true);


                    }
                    break;

                }


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametrosFuncao"

    // $ANTLR start "declaracaoParametro"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:490:1: declaracaoParametro returns [NoDeclaracaoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoDeclaracaoParametro declaracaoParametro() throws RecognitionException
    {
        NoDeclaracaoParametro parametro = null;


        Token tkr = null;
        Token ID4 = null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;



        pilhaContexto.push("declaracaoParametro");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:493:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:495:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
                pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1458);
                informacaoTipoDado = declaracaoTipoDado();

                state._fsp--;
                if (state.failed)
                {
                    return parametro;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:495:42: (tkr= '&' )?
                int alt15 = 2;
                int LA15_0 = input.LA(1);

                if ((LA15_0 == 41))
                {
                    alt15 = 1;
                }
                switch (alt15)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:495:43: tkr= '&'
                    {
                        tkr = (Token) match(input, 41, FOLLOW_41_in_declaracaoParametro1465);
                        if (state.failed)
                        {
                            return parametro;
                        }

                    }
                    break;

                }


                ID4 = (Token) match(input, ID, FOLLOW_ID_in_declaracaoParametro1469);
                if (state.failed)
                {
                    return parametro;
                }

                pushFollow(FOLLOW_quantificador_in_declaracaoParametro1475);
                vQuantificador = quantificador();

                state._fsp--;
                if (state.failed)
                {
                    return parametro;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        ModoAcesso modoAcesso = null;
                        TipoDado tipoDado = null;
                        TrechoCodigoFonte trechoCodigoFonteTipoDado = null;

                        if (tkr == null)
                        {
                            modoAcesso = ModoAcesso.POR_VALOR;
                        }
                        else if (tkr != null)
                        {
                            modoAcesso = ModoAcesso.POR_REFERENCIA;
                        }

                        if (informacaoTipoDado != null)
                        {
                            tipoDado = informacaoTipoDado.getTipoDado();
                            trechoCodigoFonteTipoDado = informacaoTipoDado.getTrechoCodigoFonte();
                        }

                        parametro = new NoDeclaracaoParametro((ID4 != null ? ID4.getText() : null), tipoDado, vQuantificador, modoAcesso);
                        parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID4));
                        parametro.setTrechoCodigoFonteTipoDado(trechoCodigoFonteTipoDado);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return parametro;
    }
    // $ANTLR end "declaracaoParametro"

    // $ANTLR start "blocos"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:526:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException
    {
        List<NoBloco> blocos = null;


        NoBloco vBloco = null;



        pilhaContexto.push("blocos");
        blocos = new ArrayList<NoBloco>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:530:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:531:2: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:531:2: (vBloco= bloco | declaracoesLocais[blocos] )*
                loop16:
                do
                {
                    int alt16 = 3;
                    int LA16_0 = input.LA(1);

                    if (((LA16_0 >= CADEIA && LA16_0 <= CARACTER) || (LA16_0 >= ID && LA16_0 <= OPERADOR_NAO) || (LA16_0 >= PR_ENQUANTO && LA16_0 <= PR_FACA) || (LA16_0 >= PR_PARA && LA16_0 <= PR_PARE) || (LA16_0 >= PR_RETORNE && LA16_0 <= PR_SE) || LA16_0 == REAL || LA16_0 == 42 || LA16_0 == 50 || LA16_0 == 67))
                    {
                        alt16 = 1;
                    }
                    else if (((LA16_0 >= PR_CADEIA && LA16_0 <= PR_CARACTER) || LA16_0 == PR_CONST || (LA16_0 >= PR_INTEIRO && LA16_0 <= PR_LOGICO) || LA16_0 == PR_REAL))
                    {
                        alt16 = 2;
                    }


                    switch (alt16)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:532:2: vBloco= bloco
                        {
                            pushFollow(FOLLOW_bloco_in_blocos1507);
                            vBloco = bloco();

                            state._fsp--;
                            if (state.failed)
                            {
                                return blocos;
                            }

                            if (state.backtracking == 0)
                            {
                                blocos.add(vBloco);
                            }

                        }
                        break;
                        case 2:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:532:43: declaracoesLocais[blocos]
                        {
                            pushFollow(FOLLOW_declaracoesLocais_in_blocos1513);
                            declaracoesLocais(blocos);

                            state._fsp--;
                            if (state.failed)
                            {
                                return blocos;
                            }

                        }
                        break;

                        default:
                            break loop16;
                    }
                }
                while (true);


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return blocos;
    }
    // $ANTLR end "blocos"

    // $ANTLR start "bloco"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:541:1: bloco returns [NoBloco bloco] : (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) ;
    public final NoBloco bloco() throws RecognitionException
    {
        NoBloco bloco = null;


        NoExpressao vExpressao = null;

        NoPara vPara = null;

        NoPare vPare = null;

        NoRetorne vRetorne = null;

        NoSe vSe = null;

        NoEnquanto vEnquanto = null;

        NoFacaEnquanto vFacaEnquanto = null;

        NoEscolha vEscolha = null;



        pilhaContexto.push("bloco");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:544:2: ( (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:545:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:545:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
                int alt17 = 8;
                switch (input.LA(1))
                {
                    case CADEIA:
                    case CARACTER:
                    case ID:
                    case INTEIRO:
                    case LOGICO:
                    case OPERADOR_NAO:
                    case REAL:
                    case 42:
                    case 50:
                    case 67:
                    {
                        alt17 = 1;
                    }
                    break;
                    case PR_PARA:
                    {
                        alt17 = 2;
                    }
                    break;
                    case PR_PARE:
                    {
                        alt17 = 3;
                    }
                    break;
                    case PR_RETORNE:
                    {
                        alt17 = 4;
                    }
                    break;
                    case PR_SE:
                    {
                        alt17 = 5;
                    }
                    break;
                    case PR_ENQUANTO:
                    {
                        alt17 = 6;
                    }
                    break;
                    case PR_FACA:
                    {
                        alt17 = 7;
                    }
                    break;
                    case PR_ESCOLHA:
                    {
                        alt17 = 8;
                    }
                    break;
                    default:
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return bloco;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 17, 0, input);

                        throw nvae;

                }

                switch (alt17)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:546:3: vExpressao= expressao
                    {
                        pushFollow(FOLLOW_expressao_in_bloco1547);
                        vExpressao = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vExpressao;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:547:3: vPara= para
                    {
                        pushFollow(FOLLOW_para_in_bloco1562);
                        vPara = para();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vPara;
                        }

                    }
                    break;
                    case 3:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:548:3: vPare= pare
                    {
                        pushFollow(FOLLOW_pare_in_bloco1580);
                        vPare = pare();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vPare;
                        }

                    }
                    break;
                    case 4:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:549:3: vRetorne= retorne
                    {
                        pushFollow(FOLLOW_retorne_in_bloco1597);
                        vRetorne = retorne();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vRetorne;
                        }

                    }
                    break;
                    case 5:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:550:3: vSe= se
                    {
                        pushFollow(FOLLOW_se_in_bloco1613);
                        vSe = se();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vSe;
                        }

                    }
                    break;
                    case 6:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:551:3: vEnquanto= enquanto
                    {
                        pushFollow(FOLLOW_enquanto_in_bloco1630);
                        vEnquanto = enquanto();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vEnquanto;
                        }

                    }
                    break;
                    case 7:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:552:3: vFacaEnquanto= facaEnquanto
                    {
                        pushFollow(FOLLOW_facaEnquanto_in_bloco1644);
                        vFacaEnquanto = facaEnquanto();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vFacaEnquanto;
                        }

                    }
                    break;
                    case 8:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:553:3: vEscolha= escolha
                    {
                        pushFollow(FOLLOW_escolha_in_bloco1658);
                        vEscolha = escolha();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                        if (state.backtracking == 0)
                        {
                            bloco = vEscolha;
                        }

                    }
                    break;

                }


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "bloco"

    // $ANTLR start "para"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:562:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException
    {
        NoPara para = null;


        NoBloco inicializacao = null;

        NoExpressao condicao = null;

        NoExpressao incremento = null;

        List<NoBloco> vBlocos = null;



        pilhaContexto.push("para");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:565:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
                match(input, PR_PARA, FOLLOW_PR_PARA_in_para1690);
                if (state.failed)
                {
                    return para;
                }

                match(input, 42, FOLLOW_42_in_para1692);
                if (state.failed)
                {
                    return para;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:14: (inicializacao= inicializacaoPara )?
                int alt18 = 2;
                int LA18_0 = input.LA(1);

                if (((LA18_0 >= CADEIA && LA18_0 <= CARACTER) || (LA18_0 >= ID && LA18_0 <= PR_CARACTER) || LA18_0 == PR_CONST || (LA18_0 >= PR_INTEIRO && LA18_0 <= PR_LOGICO) || LA18_0 == PR_REAL || LA18_0 == REAL || LA18_0 == 42 || LA18_0 == 50 || LA18_0 == 67))
                {
                    alt18 = 1;
                }
                switch (alt18)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:15: inicializacao= inicializacaoPara
                    {
                        pushFollow(FOLLOW_inicializacaoPara_in_para1699);
                        inicializacao = inicializacaoPara();

                        state._fsp--;
                        if (state.failed)
                        {
                            return para;
                        }

                    }
                    break;

                }


                match(input, 56, FOLLOW_56_in_para1703);
                if (state.failed)
                {
                    return para;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:55: (condicao= expressao )?
                int alt19 = 2;
                int LA19_0 = input.LA(1);

                if (((LA19_0 >= CADEIA && LA19_0 <= CARACTER) || (LA19_0 >= ID && LA19_0 <= OPERADOR_NAO) || LA19_0 == REAL || LA19_0 == 42 || LA19_0 == 50 || LA19_0 == 67))
                {
                    alt19 = 1;
                }
                switch (alt19)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:56: condicao= expressao
                    {
                        pushFollow(FOLLOW_expressao_in_para1710);
                        condicao = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return para;
                        }

                    }
                    break;

                }


                match(input, 56, FOLLOW_56_in_para1714);
                if (state.failed)
                {
                    return para;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:83: (incremento= expressao )?
                int alt20 = 2;
                int LA20_0 = input.LA(1);

                if (((LA20_0 >= CADEIA && LA20_0 <= CARACTER) || (LA20_0 >= ID && LA20_0 <= OPERADOR_NAO) || LA20_0 == REAL || LA20_0 == 42 || LA20_0 == 50 || LA20_0 == 67))
                {
                    alt20 = 1;
                }
                switch (alt20)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:84: incremento= expressao
                    {
                        pushFollow(FOLLOW_expressao_in_para1721);
                        incremento = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return para;
                        }

                    }
                    break;

                }


                match(input, 43, FOLLOW_43_in_para1725);
                if (state.failed)
                {
                    return para;
                }

                pushFollow(FOLLOW_listaBlocos_in_para1731);
                vBlocos = listaBlocos();

                state._fsp--;
                if (state.failed)
                {
                    return para;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        para = new NoPara();
                        para.setInicializacao(inicializacao);
                        para.setCondicao(condicao);
                        para.setIncremento(incremento);
                        para.setBlocos(vBlocos);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return para;
    }
    // $ANTLR end "para"

    // $ANTLR start "inicializacaoPara"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:585:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException
    {
        NoBloco bloco = null;


        NoExpressao vExpressao = null;

        List<NoDeclaracao> vListaDeclaracoes = null;



        pilhaContexto.push("inicializacaoPara");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:588:2: ( (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:590:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:590:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
                int alt21 = 2;
                int LA21_0 = input.LA(1);

                if (((LA21_0 >= CADEIA && LA21_0 <= CARACTER) || (LA21_0 >= ID && LA21_0 <= OPERADOR_NAO) || LA21_0 == REAL || LA21_0 == 42 || LA21_0 == 50 || LA21_0 == 67))
                {
                    alt21 = 1;
                }
                else if (((LA21_0 >= PR_CADEIA && LA21_0 <= PR_CARACTER) || LA21_0 == PR_CONST || (LA21_0 >= PR_INTEIRO && LA21_0 <= PR_LOGICO) || LA21_0 == PR_REAL))
                {
                    alt21 = 2;
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return bloco;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                    throw nvae;

                }
                switch (alt21)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:590:3: vExpressao= expressao
                    {
                        pushFollow(FOLLOW_expressao_in_inicializacaoPara1762);
                        vExpressao = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:590:28: vListaDeclaracoes= listaDeclaracoes
                    {
                        pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1770);
                        vListaDeclaracoes = listaDeclaracoes();

                        state._fsp--;
                        if (state.failed)
                        {
                            return bloco;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if (vExpressao != null)
                        {
                            bloco = vExpressao;
                        }
                        else if (vExpressao == null)
                        {
                            bloco = vListaDeclaracoes.get(0);
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "inicializacaoPara"

    // $ANTLR start "listaBlocos"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:606:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException
    {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vListaBlocos = null;

        NoBloco vBloco = null;



        pilhaContexto.push("listaBlocos");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:609:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:610:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:610:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
                int alt22 = 2;
                int LA22_0 = input.LA(1);

                if ((LA22_0 == 67))
                {
                    int LA22_1 = input.LA(2);

                    if ((synpred1_Portugol()))
                    {
                        alt22 = 1;
                    }
                    else if ((true))
                    {
                        alt22 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return listaBlocos;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 22, 1, input);

                        throw nvae;

                    }
                }
                else if (((LA22_0 >= CADEIA && LA22_0 <= CARACTER) || (LA22_0 >= ID && LA22_0 <= OPERADOR_NAO) || (LA22_0 >= PR_ENQUANTO && LA22_0 <= PR_FACA) || (LA22_0 >= PR_PARA && LA22_0 <= PR_PARE) || (LA22_0 >= PR_RETORNE && LA22_0 <= PR_SE) || LA22_0 == REAL || LA22_0 == 42 || LA22_0 == 50))
                {
                    alt22 = 2;
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return listaBlocos;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                    throw nvae;

                }
                switch (alt22)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:611:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                        match(input, 67, FOLLOW_67_in_listaBlocos1803);
                        if (state.failed)
                        {
                            return listaBlocos;
                        }

                        pushFollow(FOLLOW_blocos_in_listaBlocos1809);
                        vListaBlocos = blocos();

                        state._fsp--;
                        if (state.failed)
                        {
                            return listaBlocos;
                        }

                        if (state.backtracking == 0)
                        {
                            listaBlocos = vListaBlocos;
                        }

                        match(input, 68, FOLLOW_68_in_listaBlocos1813);
                        if (state.failed)
                        {
                            return listaBlocos;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:615:2: vBloco= bloco
                    {
                        pushFollow(FOLLOW_bloco_in_listaBlocos1829);
                        vBloco = bloco();

                        state._fsp--;
                        if (state.failed)
                        {
                            return listaBlocos;
                        }

                        if (state.backtracking == 0)
                        {
                            if (gerarArvore)
                            {
                                listaBlocos = new ArrayList<NoBloco>();
                                listaBlocos.add(vBloco);
                            }
                        }

                    }
                    break;

                }


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "listaBlocos"

    // $ANTLR start "pare"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:631:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException
    {
        NoPare pare = null;



        pilhaContexto.push("pare");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:634:2: ( PR_PARE )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:636:2: PR_PARE
            {
                match(input, PR_PARE, FOLLOW_PR_PARE_in_pare1857);
                if (state.failed)
                {
                    return pare;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        pare = new NoPare();
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return pare;
    }
    // $ANTLR end "pare"

    // $ANTLR start "escolha"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:651:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' ;
    public final NoEscolha escolha() throws RecognitionException
    {
        NoEscolha escolha = null;


        NoExpressao vExpressao = null;

        List<NoCaso> vListaCasos = null;



        pilhaContexto.push("escolha");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:654:2: ( PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:656:2: PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}'
            {
                match(input, PR_ESCOLHA, FOLLOW_PR_ESCOLHA_in_escolha1884);
                if (state.failed)
                {
                    return escolha;
                }

                match(input, 42, FOLLOW_42_in_escolha1886);
                if (state.failed)
                {
                    return escolha;
                }

                pushFollow(FOLLOW_expressao_in_escolha1892);
                vExpressao = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return escolha;
                }

                match(input, 43, FOLLOW_43_in_escolha1894);
                if (state.failed)
                {
                    return escolha;
                }

                match(input, 67, FOLLOW_67_in_escolha1897);
                if (state.failed)
                {
                    return escolha;
                }

                pushFollow(FOLLOW_listaCasos_in_escolha1906);
                vListaCasos = listaCasos();

                state._fsp--;
                if (state.failed)
                {
                    return escolha;
                }

                match(input, 68, FOLLOW_68_in_escolha1909);
                if (state.failed)
                {
                    return escolha;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        escolha = new NoEscolha(vExpressao);
                        escolha.setCasos(vListaCasos);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return escolha;
    }
    // $ANTLR end "escolha"

    // $ANTLR start "listaCasos"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:675:1: listaCasos returns [List<NoCaso> casos] : ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )* ;
    public final List<NoCaso> listaCasos() throws RecognitionException
    {
        List<NoCaso> casos = null;


        NoExpressao vExpressao = null;

        List<NoBloco> vBlocos = null;



        pilhaContexto.push("listaCasos");
        casos = new ArrayList<NoCaso>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:679:2: ( ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:680:3: ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )*
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:680:3: ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )*
                loop24:
                do
                {
                    int alt24 = 2;
                    int LA24_0 = input.LA(1);

                    if (((LA24_0 >= PR_CASO && LA24_0 <= PR_CASO_CONTRARIO)))
                    {
                        alt24 = 1;
                    }


                    switch (alt24)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:681:3: ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso
                        {
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:681:3: ( casoContrario | PR_CASO vExpressao= expressao )
                            int alt23 = 2;
                            int LA23_0 = input.LA(1);

                            if ((LA23_0 == PR_CASO_CONTRARIO))
                            {
                                alt23 = 1;
                            }
                            else if ((LA23_0 == PR_CASO))
                            {
                                alt23 = 2;
                            }
                            else
                            {
                                if (state.backtracking > 0)
                                {
                                    state.failed = true;
                                    return casos;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 23, 0, input);

                                throw nvae;

                            }
                            switch (alt23)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:681:5: casoContrario
                                {
                                    pushFollow(FOLLOW_casoContrario_in_listaCasos1941);
                                    casoContrario();

                                    state._fsp--;
                                    if (state.failed)
                                    {
                                        return casos;
                                    }

                                }
                                break;
                                case 2:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:681:20: PR_CASO vExpressao= expressao
                                {
                                    match(input, PR_CASO, FOLLOW_PR_CASO_in_listaCasos1944);
                                    if (state.failed)
                                    {
                                        return casos;
                                    }

                                    pushFollow(FOLLOW_expressao_in_listaCasos1950);
                                    vExpressao = expressao();

                                    state._fsp--;
                                    if (state.failed)
                                    {
                                        return casos;
                                    }

                                }
                                break;

                            }


                            match(input, 55, FOLLOW_55_in_listaCasos1953);
                            if (state.failed)
                            {
                                return casos;
                            }

                            pushFollow(FOLLOW_blocosCaso_in_listaCasos1959);
                            vBlocos = blocosCaso();

                            state._fsp--;
                            if (state.failed)
                            {
                                return casos;
                            }

                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    NoCaso caso = new NoCaso(vExpressao);
                                    caso.setBlocos(vBlocos);
                                    casos.add(caso);

                                    vExpressao = null;
                                }
                            }

                        }
                        break;

                        default:
                            break loop24;
                    }
                }
                while (true);


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return casos;
    }
    // $ANTLR end "listaCasos"

    // $ANTLR start "casoContrario"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:700:1: casoContrario : PR_CASO_CONTRARIO ;
    public final void casoContrario() throws RecognitionException
    {

        pilhaContexto.push("casoContrario");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:703:2: ( PR_CASO_CONTRARIO )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:704:2: PR_CASO_CONTRARIO
            {
                match(input, PR_CASO_CONTRARIO, FOLLOW_PR_CASO_CONTRARIO_in_casoContrario1985);
                if (state.failed)
                {
                    return;
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return;
    }
    // $ANTLR end "casoContrario"

    // $ANTLR start "blocosCaso"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:712:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException
    {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vBlocos = null;



        pilhaContexto.push("blocosCaso");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:715:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
                int alt25 = 2;
                int LA25_0 = input.LA(1);

                if ((LA25_0 == 67))
                {
                    int LA25_1 = input.LA(2);

                    if ((synpred2_Portugol()))
                    {
                        alt25 = 1;
                    }
                    else if ((true))
                    {
                        alt25 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return listaBlocos;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 25, 1, input);

                        throw nvae;

                    }
                }
                else if (((LA25_0 >= CADEIA && LA25_0 <= CARACTER) || (LA25_0 >= ID && LA25_0 <= PR_FACA) || (LA25_0 >= PR_INTEIRO && LA25_0 <= PR_PARE) || (LA25_0 >= PR_REAL && LA25_0 <= PR_SE) || LA25_0 == REAL || LA25_0 == 42 || LA25_0 == 50 || LA25_0 == 68))
                {
                    alt25 = 2;
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return listaBlocos;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                    throw nvae;

                }
                switch (alt25)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:12: ( '{' vBlocos= blocos '}' )
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:13: '{' vBlocos= blocos '}'
                        {
                            match(input, 67, FOLLOW_67_in_blocosCaso2016);
                            if (state.failed)
                            {
                                return listaBlocos;
                            }

                            pushFollow(FOLLOW_blocos_in_blocosCaso2022);
                            vBlocos = blocos();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaBlocos;
                            }

                            match(input, 68, FOLLOW_68_in_blocosCaso2024);
                            if (state.failed)
                            {
                                return listaBlocos;
                            }

                        }


                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:41: (vBlocos= blocos )
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:41: (vBlocos= blocos )
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:42: vBlocos= blocos
                        {
                            pushFollow(FOLLOW_blocos_in_blocosCaso2034);
                            vBlocos = blocos();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaBlocos;
                            }

                        }


                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    listaBlocos = vBlocos;
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "blocosCaso"

    // $ANTLR start "enquanto"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:728:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException
    {
        NoEnquanto enquanto = null;


        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;



        pilhaContexto.push("enquanto");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:731:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:733:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
                match(input, PR_ENQUANTO, FOLLOW_PR_ENQUANTO_in_enquanto2063);
                if (state.failed)
                {
                    return enquanto;
                }

                match(input, 42, FOLLOW_42_in_enquanto2065);
                if (state.failed)
                {
                    return enquanto;
                }

                pushFollow(FOLLOW_expressao_in_enquanto2071);
                vExpressao = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return enquanto;
                }

                match(input, 43, FOLLOW_43_in_enquanto2073);
                if (state.failed)
                {
                    return enquanto;
                }

                pushFollow(FOLLOW_listaBlocos_in_enquanto2079);
                vListaBlocos = listaBlocos();

                state._fsp--;
                if (state.failed)
                {
                    return enquanto;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        enquanto = new NoEnquanto(vExpressao);
                        enquanto.setBlocos(vListaBlocos);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return enquanto;
    }
    // $ANTLR end "enquanto"

    // $ANTLR start "facaEnquanto"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:748:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException
    {
        NoFacaEnquanto facaEnquanto = null;


        List<NoBloco> vListaBlocos = null;

        NoExpressao vExpressao = null;



        pilhaContexto.push("facaEnquanto");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:751:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:753:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
                match(input, PR_FACA, FOLLOW_PR_FACA_in_facaEnquanto2105);
                if (state.failed)
                {
                    return facaEnquanto;
                }

                pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2111);
                vListaBlocos = listaBlocos();

                state._fsp--;
                if (state.failed)
                {
                    return facaEnquanto;
                }

                match(input, PR_ENQUANTO, FOLLOW_PR_ENQUANTO_in_facaEnquanto2113);
                if (state.failed)
                {
                    return facaEnquanto;
                }

                match(input, 42, FOLLOW_42_in_facaEnquanto2115);
                if (state.failed)
                {
                    return facaEnquanto;
                }

                pushFollow(FOLLOW_expressao_in_facaEnquanto2121);
                vExpressao = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return facaEnquanto;
                }

                match(input, 43, FOLLOW_43_in_facaEnquanto2123);
                if (state.failed)
                {
                    return facaEnquanto;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        facaEnquanto = new NoFacaEnquanto(vExpressao);
                        facaEnquanto.setBlocos(vListaBlocos);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return facaEnquanto;
    }
    // $ANTLR end "facaEnquanto"

    // $ANTLR start "se"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:769:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException
    {
        NoSe se = null;


        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;

        List<NoBloco> listaBlocosSenao = null;



        pilhaContexto.push("se");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:772:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:774:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
                match(input, PR_SE, FOLLOW_PR_SE_in_se2151);
                if (state.failed)
                {
                    return se;
                }

                match(input, 42, FOLLOW_42_in_se2153);
                if (state.failed)
                {
                    return se;
                }

                pushFollow(FOLLOW_expressao_in_se2159);
                vExpressao = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return se;
                }

                match(input, 43, FOLLOW_43_in_se2161);
                if (state.failed)
                {
                    return se;
                }

                pushFollow(FOLLOW_listaBlocos_in_se2167);
                vListaBlocos = listaBlocos();

                state._fsp--;
                if (state.failed)
                {
                    return se;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:774:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
                int alt26 = 2;
                int LA26_0 = input.LA(1);

                if ((LA26_0 == PR_SENAO))
                {
                    alt26 = 1;
                }
                switch (alt26)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:774:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                        match(input, PR_SENAO, FOLLOW_PR_SENAO_in_se2170);
                        if (state.failed)
                        {
                            return se;
                        }

                        pushFollow(FOLLOW_listaBlocos_in_se2176);
                        listaBlocosSenao = listaBlocos();

                        state._fsp--;
                        if (state.failed)
                        {
                            return se;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        se = new NoSe(vExpressao);
                        se.setBlocosVerdadeiros(vListaBlocos);
                        se.setBlocosFalsos(listaBlocosSenao);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return se;
    }
    // $ANTLR end "se"

    // $ANTLR start "retorne"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:790:1: retorne returns [NoRetorne retorne] : PR_RETORNE vExpressao= expressao ;
    public final NoRetorne retorne() throws RecognitionException
    {
        NoRetorne retorne = null;


        NoExpressao vExpressao = null;



        pilhaContexto.push("retorne");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:793:2: ( PR_RETORNE vExpressao= expressao )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:795:2: PR_RETORNE vExpressao= expressao
            {
                match(input, PR_RETORNE, FOLLOW_PR_RETORNE_in_retorne2205);
                if (state.failed)
                {
                    return retorne;
                }

                pushFollow(FOLLOW_expressao_in_retorne2211);
                vExpressao = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return retorne;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        retorne = new NoRetorne(vExpressao);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return retorne;
    }
    // $ANTLR end "retorne"

    // $ANTLR start "pilha"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:809:1: pilha returns [Stack<Object> pilha] :;
    public final Stack<Object> pilha() throws RecognitionException
    {
        Stack<Object> pilha = null;


        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:809:35: ()
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:810:1: 
            {
                if (state.backtracking == 0)
                {
                    pilha = new Stack<Object>();
                }

            }

        }
        finally
        {
            // do for sure before leaving
        }
        return pilha;
    }
    // $ANTLR end "pilha"

    // $ANTLR start "expressao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:816:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        Stack<Object> vPilha = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:819:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:821:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )*
            {
                pushFollow(FOLLOW_expressao2_in_expressao2255);
                operandoEsquerdo = expressao2();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                pushFollow(FOLLOW_pilha_in_expressao2261);
                vPilha = pilha();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                if (state.backtracking == 0)
                {
                    vPilha.push(operandoEsquerdo);
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:822:2: ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )*
                loop28:
                do
                {
                    int alt28 = 2;
                    int LA28_0 = input.LA(1);

                    if ((LA28_0 == 40 || LA28_0 == 45 || LA28_0 == 48 || LA28_0 == 52 || LA28_0 == 54 || LA28_0 == 59))
                    {
                        alt28 = 1;
                    }


                    switch (alt28)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2
                        {
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' )
                            int alt27 = 6;
                            switch (input.LA(1))
                            {
                                case 59:
                                {
                                    alt27 = 1;
                                }
                                break;
                                case 48:
                                {
                                    alt27 = 2;
                                }
                                break;
                                case 52:
                                {
                                    alt27 = 3;
                                }
                                break;
                                case 54:
                                {
                                    alt27 = 4;
                                }
                                break;
                                case 45:
                                {
                                    alt27 = 5;
                                }
                                break;
                                case 40:
                                {
                                    alt27 = 6;
                                }
                                break;
                                default:
                                    if (state.backtracking > 0)
                                    {
                                        state.failed = true;
                                        return expressao;
                                    }
                                    NoViableAltException nvae =
                                            new NoViableAltException("", 27, 0, input);

                                    throw nvae;

                            }

                            switch (alt27)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:4: operador= '='
                                {
                                    operador = (Token) match(input, 59, FOLLOW_59_in_expressao2275);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 2:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:21: operador= '+='
                                {
                                    operador = (Token) match(input, 48, FOLLOW_48_in_expressao2283);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 3:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:39: operador= '-='
                                {
                                    operador = (Token) match(input, 52, FOLLOW_52_in_expressao2291);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 4:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:57: operador= '/='
                                {
                                    operador = (Token) match(input, 54, FOLLOW_54_in_expressao2299);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 5:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:75: operador= '*='
                                {
                                    operador = (Token) match(input, 45, FOLLOW_45_in_expressao2307);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 6:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:823:93: operador= '%='
                                {
                                    operador = (Token) match(input, 40, FOLLOW_40_in_expressao2315);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;

                            }


                            pushFollow(FOLLOW_expressao2_in_expressao2327);
                            operandoDireito = expressao2();

                            state._fsp--;
                            if (state.failed)
                            {
                                return expressao;
                            }

                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    vPilha.push(operador);
                                    vPilha.push(operandoDireito);
                                }
                            }

                        }
                        break;

                        default:
                            break loop28;
                    }
                }
                while (true);


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        while (vPilha.size() > 1)
                        {
                            operandoDireito = (NoExpressao) vPilha.pop();
                            operador = ((Token) vPilha.pop());
                            operandoEsquerdo = (NoExpressao) vPilha.pop();

                            Operacao tipoOperacao = Operacao.obterOperacaoPeloOperador(operador.getText());

                            NoOperacao operacao = new NoOperacao(tipoOperacao, operandoEsquerdo, operandoDireito);
                            operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));

                            vPilha.push(operacao);
                        }

                        expressao = (NoExpressao) vPilha.pop();
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao"

    // $ANTLR start "expressao2"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:861:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao2");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:864:2: (operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:866:2: operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )*
            {
                pushFollow(FOLLOW_expressao3_in_expressao22366);
                operandoEsquerdo = expressao3();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:867:2: ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )*
                loop30:
                do
                {
                    int alt30 = 2;
                    int LA30_0 = input.LA(1);

                    if (((LA30_0 >= 65 && LA30_0 <= 66)))
                    {
                        alt30 = 1;
                    }


                    switch (alt30)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:868:3: (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3
                        {
                            if (state.backtracking == 0)
                            {

                                if (gerarArvore)
                                {
                                    if (operandoDireito != null)
                                    {
                                        NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
                                        operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
                                        operandoEsquerdo = operacao;
                                    }
                                }
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:881:3: (operador= 'e' |operador= 'ou' )
                            int alt29 = 2;
                            int LA29_0 = input.LA(1);

                            if ((LA29_0 == 65))
                            {
                                alt29 = 1;
                            }
                            else if ((LA29_0 == 66))
                            {
                                alt29 = 2;
                            }
                            else
                            {
                                if (state.backtracking > 0)
                                {
                                    state.failed = true;
                                    return expressao;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 29, 0, input);

                                throw nvae;

                            }
                            switch (alt29)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:881:4: operador= 'e'
                                {
                                    operador = (Token) match(input, 65, FOLLOW_65_in_expressao22395);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 2:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:881:21: operador= 'ou'
                                {
                                    operador = (Token) match(input, 66, FOLLOW_66_in_expressao22403);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;

                            }


                            pushFollow(FOLLOW_expressao3_in_expressao22415);
                            operandoDireito = expressao3();

                            state._fsp--;
                            if (state.failed)
                            {
                                return expressao;
                            }

                        }
                        break;

                        default:
                            break loop30;
                    }
                }
                while (true);


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao2"

    // $ANTLR start "expressao3"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:898:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao3");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:901:2: (operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:903:2: operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
            {
                pushFollow(FOLLOW_expressao4_in_expressao32449);
                operandoEsquerdo = expressao4();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:904:2: ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
                loop32:
                do
                {
                    int alt32 = 2;
                    int LA32_0 = input.LA(1);

                    if ((LA32_0 == 38 || LA32_0 == 60))
                    {
                        alt32 = 1;
                    }


                    switch (alt32)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:905:3: (operador= '==' |operador= '!=' ) operandoDireito= expressao4
                        {
                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {

                                    if (operandoDireito != null)
                                    {
                                        NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
                                        operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
                                        operandoEsquerdo = operacao;
                                    }
                                }
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:918:3: (operador= '==' |operador= '!=' )
                            int alt31 = 2;
                            int LA31_0 = input.LA(1);

                            if ((LA31_0 == 60))
                            {
                                alt31 = 1;
                            }
                            else if ((LA31_0 == 38))
                            {
                                alt31 = 2;
                            }
                            else
                            {
                                if (state.backtracking > 0)
                                {
                                    state.failed = true;
                                    return expressao;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 31, 0, input);

                                throw nvae;

                            }
                            switch (alt31)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:918:4: operador= '=='
                                {
                                    operador = (Token) match(input, 60, FOLLOW_60_in_expressao32470);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 2:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:918:22: operador= '!='
                                {
                                    operador = (Token) match(input, 38, FOLLOW_38_in_expressao32478);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;

                            }


                            pushFollow(FOLLOW_expressao4_in_expressao32491);
                            operandoDireito = expressao4();

                            state._fsp--;
                            if (state.failed)
                            {
                                return expressao;
                            }

                        }
                        break;

                        default:
                            break loop32;
                    }
                }
                while (true);


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao3"

    // $ANTLR start "expressao4"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:935:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )? ;
    public final NoExpressao expressao4() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao4");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:938:2: (operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:2: operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )?
            {
                pushFollow(FOLLOW_expressao5_in_expressao42525);
                operandoEsquerdo = expressao5();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:32: ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )?
                int alt34 = 2;
                int LA34_0 = input.LA(1);

                if (((LA34_0 >= 57 && LA34_0 <= 58) || (LA34_0 >= 61 && LA34_0 <= 62)))
                {
                    alt34 = 1;
                }
                switch (alt34)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:33: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:33: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' )
                        int alt33 = 4;
                        switch (input.LA(1))
                        {
                            case 62:
                            {
                                alt33 = 1;
                            }
                            break;
                            case 58:
                            {
                                alt33 = 2;
                            }
                            break;
                            case 57:
                            {
                                alt33 = 3;
                            }
                            break;
                            case 61:
                            {
                                alt33 = 4;
                            }
                            break;
                            default:
                                if (state.backtracking > 0)
                                {
                                    state.failed = true;
                                    return expressao;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 33, 0, input);

                                throw nvae;

                        }

                        switch (alt33)
                        {
                            case 1:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:34: operador= '>='
                            {
                                operador = (Token) match(input, 62, FOLLOW_62_in_expressao42533);
                                if (state.failed)
                                {
                                    return expressao;
                                }

                            }
                            break;
                            case 2:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:52: operador= '<='
                            {
                                operador = (Token) match(input, 58, FOLLOW_58_in_expressao42541);
                                if (state.failed)
                                {
                                    return expressao;
                                }

                            }
                            break;
                            case 3:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:70: operador= '<'
                            {
                                operador = (Token) match(input, 57, FOLLOW_57_in_expressao42549);
                                if (state.failed)
                                {
                                    return expressao;
                                }

                            }
                            break;
                            case 4:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:87: operador= '>'
                            {
                                operador = (Token) match(input, 61, FOLLOW_61_in_expressao42557);
                                if (state.failed)
                                {
                                    return expressao;
                                }

                            }
                            break;

                        }


                        pushFollow(FOLLOW_expressao5_in_expressao42564);
                        operandoDireito = expressao5();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao4"

    // $ANTLR start "expressao5"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:954:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* ;
    public final NoExpressao expressao5() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao5");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:957:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:959:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
            {
                pushFollow(FOLLOW_expressao6_in_expressao52596);
                operandoEsquerdo = expressao6();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:960:2: ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
                loop35:
                do
                {
                    int alt35 = 3;
                    int LA35_0 = input.LA(1);

                    if ((LA35_0 == 50))
                    {
                        int LA35_27 = input.LA(2);

                        if ((synpred3_Portugol()))
                        {
                            alt35 = 2;
                        }


                    }
                    else if ((LA35_0 == 46))
                    {
                        alt35 = 1;
                    }


                    switch (alt35)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:961:3: (operador= '+' operandoDireito= expressao6 )
                        {
                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    if (operandoDireito != null)
                                    {
                                        NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
                                        operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
                                        operandoEsquerdo = operacao;
                                    }
                                }
                            }
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:3: (operador= '+' operandoDireito= expressao6 )
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:4: operador= '+' operandoDireito= expressao6
                            {
                                operador = (Token) match(input, 46, FOLLOW_46_in_expressao52620);
                                if (state.failed)
                                {
                                    return expressao;
                                }

                                pushFollow(FOLLOW_expressao6_in_expressao52626);
                                operandoDireito = expressao6();

                                state._fsp--;
                                if (state.failed)
                                {
                                    return expressao;
                                }

                            }


                        }
                        break;
                        case 2:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:51: ( '-' )=>operador= '-' operandoDireito= expressao6
                        {
                            operador = (Token) match(input, 50, FOLLOW_50_in_expressao52640);
                            if (state.failed)
                            {
                                return expressao;
                            }

                            pushFollow(FOLLOW_expressao6_in_expressao52646);
                            operandoDireito = expressao6();

                            state._fsp--;
                            if (state.failed)
                            {
                                return expressao;
                            }

                        }
                        break;

                        default:
                            break loop35;
                    }
                }
                while (true);


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao5"

    // $ANTLR start "expressao6"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:991:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        pilhaContexto.push("expressao6");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:994:2: (operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:996:2: operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
            {
                pushFollow(FOLLOW_expressao7_in_expressao62686);
                operandoEsquerdo = expressao7();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:997:2: ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
                loop37:
                do
                {
                    int alt37 = 2;
                    int LA37_0 = input.LA(1);

                    if ((LA37_0 == 39 || LA37_0 == 44 || LA37_0 == 53))
                    {
                        alt37 = 1;
                    }


                    switch (alt37)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:998:3: (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7
                        {
                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    if (operandoDireito != null)
                                    {
                                        NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
                                        operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
                                        operandoEsquerdo = operacao;
                                    }
                                }
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1011:3: (operador= '*' |operador= '/' |operador= '%' )
                            int alt36 = 3;
                            switch (input.LA(1))
                            {
                                case 44:
                                {
                                    alt36 = 1;
                                }
                                break;
                                case 53:
                                {
                                    alt36 = 2;
                                }
                                break;
                                case 39:
                                {
                                    alt36 = 3;
                                }
                                break;
                                default:
                                    if (state.backtracking > 0)
                                    {
                                        state.failed = true;
                                        return expressao;
                                    }
                                    NoViableAltException nvae =
                                            new NoViableAltException("", 36, 0, input);

                                    throw nvae;

                            }

                            switch (alt36)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1011:4: operador= '*'
                                {
                                    operador = (Token) match(input, 44, FOLLOW_44_in_expressao62709);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 2:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1011:21: operador= '/'
                                {
                                    operador = (Token) match(input, 53, FOLLOW_53_in_expressao62717);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;
                                case 3:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1011:38: operador= '%'
                                {
                                    operador = (Token) match(input, 39, FOLLOW_39_in_expressao62725);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }

                                }
                                break;

                            }


                            pushFollow(FOLLOW_expressao7_in_expressao62738);
                            operandoDireito = expressao7();

                            state._fsp--;
                            if (state.failed)
                            {
                                return expressao;
                            }

                        }
                        break;

                        default:
                            break loop37;
                    }
                }
                while (true);


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao6"

    // $ANTLR start "expressao7"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1028:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token listaTokenMenos = null;
        Token listaTokenNao = null;
        List list_listaTokenMenos = null;
        List list_listaTokenNao = null;
        NoExpressao vExpressao = null;



        pilhaContexto.push("expressao7");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1031:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )
                int alt40 = 2;
                int LA40_0 = input.LA(1);

                if ((LA40_0 == 50) && (synpred4_Portugol()))
                {
                    alt40 = 1;
                }
                else if ((LA40_0 == 42))
                {
                    int LA40_2 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 2, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == REAL))
                {
                    int LA40_3 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 3, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == LOGICO))
                {
                    int LA40_4 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 4, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == CADEIA))
                {
                    int LA40_5 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 5, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == INTEIRO))
                {
                    int LA40_6 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 6, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == CARACTER))
                {
                    int LA40_7 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 7, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == ID))
                {
                    int LA40_8 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 8, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == 67))
                {
                    int LA40_9 = input.LA(2);

                    if ((synpred4_Portugol()))
                    {
                        alt40 = 1;
                    }
                    else if ((true))
                    {
                        alt40 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 40, 9, input);

                        throw nvae;

                    }
                }
                else if ((LA40_0 == OPERADOR_NAO))
                {
                    alt40 = 2;
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return expressao;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                    throw nvae;

                }
                switch (alt40)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:12: (listaTokenMenos+= '-' )?
                        int alt38 = 2;
                        int LA38_0 = input.LA(1);

                        if ((LA38_0 == 50))
                        {
                            alt38 = 1;
                        }
                        switch (alt38)
                        {
                            case 1:
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:13: listaTokenMenos+= '-'
                            {
                                listaTokenMenos = (Token) match(input, 50, FOLLOW_50_in_expressao72780);
                                if (state.failed)
                                {
                                    return expressao;
                                }
                                if (list_listaTokenMenos == null)
                                {
                                    list_listaTokenMenos = new ArrayList();
                                }
                                list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                        }


                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:40: (listaTokenNao+= OPERADOR_NAO )*
                        loop39:
                        do
                        {
                            int alt39 = 2;
                            int LA39_0 = input.LA(1);

                            if ((LA39_0 == OPERADOR_NAO))
                            {
                                alt39 = 1;
                            }


                            switch (alt39)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:41: listaTokenNao+= OPERADOR_NAO
                                {
                                    listaTokenNao = (Token) match(input, OPERADOR_NAO, FOLLOW_OPERADOR_NAO_in_expressao72791);
                                    if (state.failed)
                                    {
                                        return expressao;
                                    }
                                    if (list_listaTokenNao == null)
                                    {
                                        list_listaTokenNao = new ArrayList();
                                    }
                                    list_listaTokenNao.add(listaTokenNao);


                                }
                                break;

                                default:
                                    break loop39;
                            }
                        }
                        while (true);


                    }
                    break;

                }


                pushFollow(FOLLOW_expressao8_in_expressao72801);
                vExpressao = expressao8();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if (list_listaTokenNao != null)
                        {
                            for (int i = 0; i < list_listaTokenNao.size(); i++)
                            {
                                vExpressao = new NoNao(vExpressao);
                            }
                        }
                        else if (list_listaTokenMenos != null)
                        {
                            vExpressao = new NoMenosUnario(vExpressao);
                        }

                        expressao = vExpressao;
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao7"

    // $ANTLR start "expressao8"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1057:1: expressao8 returns [NoExpressao expressao] : ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token operador = null;
        NoExpressao vExpressao = null;



        pilhaContexto.push("expressao8");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1060:2: ( ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:2: ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )?
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:2: ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor )
                int alt41 = 4;
                switch (input.LA(1))
                {
                    case 42:
                    {
                        alt41 = 1;
                    }
                    break;
                    case CADEIA:
                    case CARACTER:
                    case INTEIRO:
                    case LOGICO:
                    case REAL:
                    {
                        alt41 = 2;
                    }
                    break;
                    case ID:
                    {
                        alt41 = 3;
                    }
                    break;
                    case 67:
                    {
                        alt41 = 4;
                    }
                    break;
                    default:
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 41, 0, input);

                        throw nvae;

                }

                switch (alt41)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:3: '(' vExpressao= expressao ')'
                    {
                        match(input, 42, FOLLOW_42_in_expressao82830);
                        if (state.failed)
                        {
                            return expressao;
                        }

                        pushFollow(FOLLOW_expressao_in_expressao82836);
                        vExpressao = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                        match(input, 43, FOLLOW_43_in_expressao82838);
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:36: vExpressao= tipoPrimitivo
                    {
                        pushFollow(FOLLOW_tipoPrimitivo_in_expressao82846);
                        vExpressao = tipoPrimitivo();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;
                    case 3:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:65: vExpressao= referencia
                    {
                        pushFollow(FOLLOW_referencia_in_expressao82854);
                        vExpressao = referencia();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;
                    case 4:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1062:91: vExpressao= matrizVetor
                    {
                        pushFollow(FOLLOW_matrizVetor_in_expressao82862);
                        vExpressao = matrizVetor();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1064:3: (operador= '++' |operador= '--' )?
                int alt42 = 3;
                int LA42_0 = input.LA(1);

                if ((LA42_0 == 47))
                {
                    alt42 = 1;
                }
                else if ((LA42_0 == 51))
                {
                    alt42 = 2;
                }
                switch (alt42)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1064:4: operador= '++'
                    {
                        operador = (Token) match(input, 47, FOLLOW_47_in_expressao82875);
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1064:22: operador= '--'
                    {
                        operador = (Token) match(input, 51, FOLLOW_51_in_expressao82883);
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if (operador != null)
                        {
                            if (operador.getText().equals("++"))
                            {
                                expressao = new NoIncremento(vExpressao);
                            }
                            else if (operador.getText().equals("--"))
                            {
                                expressao = new NoDecremento(vExpressao);
                            }
                        }
                        else
                        {
                            expressao = vExpressao;
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao8"

    // $ANTLR start "tipoPrimitivo"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1086:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException
    {
        NoExpressao expressao = null;


        Token REAL5 = null;
        Token LOGICO6 = null;
        Token CADEIA7 = null;
        Token INTEIRO8 = null;
        Token CARACTER9 = null;


        pilhaContexto.push("tipoPrimitivo");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1089:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt43 = 5;
            switch (input.LA(1))
            {
                case REAL:
                {
                    alt43 = 1;
                }
                break;
                case LOGICO:
                {
                    alt43 = 2;
                }
                break;
                case CADEIA:
                {
                    alt43 = 3;
                }
                break;
                case INTEIRO:
                {
                    alt43 = 4;
                }
                break;
                case CARACTER:
                {
                    alt43 = 5;
                }
                break;
                default:
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return expressao;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                    throw nvae;

            }

            switch (alt43)
            {
                case 1:
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1091:2: REAL
                {
                    REAL5 = (Token) match(input, REAL, FOLLOW_REAL_in_tipoPrimitivo2912);
                    if (state.failed)
                    {
                        return expressao;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            NoReal real = new NoReal(Double.parseDouble((REAL5 != null ? REAL5.getText() : null)));
                            real.setTrechoCodigoFonte(criarTrechoCodigoFonte(REAL5));
                            expressao = real;
                        }
                    }

                }
                break;
                case 2:
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1103:2: LOGICO
                {
                    LOGICO6 = (Token) match(input, LOGICO, FOLLOW_LOGICO_in_tipoPrimitivo2932);
                    if (state.failed)
                    {
                        return expressao;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            NoLogico logico = new NoLogico(((LOGICO6 != null ? LOGICO6.getText() : null).equals("verdadeiro") ? true : false));
                            logico.setTrechoCodigoFonte(criarTrechoCodigoFonte(LOGICO6));
                            expressao = logico;
                        }
                    }

                }
                break;
                case 3:
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1115:2: CADEIA
                {
                    CADEIA7 = (Token) match(input, CADEIA, FOLLOW_CADEIA_in_tipoPrimitivo2946);
                    if (state.failed)
                    {
                        return expressao;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            String texto = (CADEIA7 != null ? CADEIA7.getText() : null);
                            NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                            cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte(CADEIA7));
                            expressao = cadeia;
                        }
                    }

                }
                break;
                case 4:
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1128:2: INTEIRO
                {
                    INTEIRO8 = (Token) match(input, INTEIRO, FOLLOW_INTEIRO_in_tipoPrimitivo2959);
                    if (state.failed)
                    {
                        return expressao;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            NoInteiro inteiro = new NoInteiro(Integer.parseInt((INTEIRO8 != null ? INTEIRO8.getText() : null)));
                            inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(INTEIRO8));
                            expressao = inteiro;
                        }
                    }

                }
                break;
                case 5:
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1140:2: CARACTER
                {
                    CARACTER9 = (Token) match(input, CARACTER, FOLLOW_CARACTER_in_tipoPrimitivo2974);
                    if (state.failed)
                    {
                        return expressao;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            NoCaracter caracter = new NoCaracter((CARACTER9 != null ? CARACTER9.getText() : null).charAt(1));
                            caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte(CARACTER9));
                            expressao = caracter;
                        }
                    }

                }
                break;

            }
        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "tipoPrimitivo"

    // $ANTLR start "referencia"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1156:1: referencia returns [NoReferencia referencia] : ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] ) ;
    public final NoReferencia referencia() throws RecognitionException
    {
        NoReferencia referencia = null;


        Token ID10 = null;
        NoExpressao vExpressao = null;



        pilhaContexto.push("referencia");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1159:2: ( ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1161:2: ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] )
            {
                ID10 = (Token) match(input, ID, FOLLOW_ID_in_referencia3003);
                if (state.failed)
                {
                    return referencia;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1162:2: ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] )
                int alt44 = 3;
                int LA44_0 = input.LA(1);

                if ((LA44_0 == 42))
                {
                    int LA44_1 = input.LA(2);

                    if ((synpred5_Portugol()))
                    {
                        alt44 = 1;
                    }
                    else if ((true))
                    {
                        alt44 = 3;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return referencia;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 44, 1, input);

                        throw nvae;

                    }
                }
                else if ((LA44_0 == 63) && (synpred6_Portugol()))
                {
                    alt44 = 2;
                }
                else if (((LA44_0 >= CADEIA && LA44_0 <= CARACTER) || (LA44_0 >= ID && LA44_0 <= PR_FACA) || (LA44_0 >= PR_FUNCAO && LA44_0 <= PR_PARE) || (LA44_0 >= PR_REAL && LA44_0 <= PR_SENAO) || LA44_0 == REAL || (LA44_0 >= 38 && LA44_0 <= 40) || (LA44_0 >= 43 && LA44_0 <= 62) || (LA44_0 >= 64 && LA44_0 <= 68)))
                {
                    alt44 = 3;
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return referencia;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                    throw nvae;

                }
                switch (alt44)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1163:3: ( '(' )=>vExpressao= chamadaFuncao[$ID.text]
                    {
                        pushFollow(FOLLOW_chamadaFuncao_in_referencia3020);
                        vExpressao = chamadaFuncao((ID10 != null ? ID10.getText() : null));

                        state._fsp--;
                        if (state.failed)
                        {
                            return referencia;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1164:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text]
                    {
                        pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia3037);
                        vExpressao = referenciaVetorMatriz((ID10 != null ? ID10.getText() : null));

                        state._fsp--;
                        if (state.failed)
                        {
                            return referencia;
                        }

                    }
                    break;
                    case 3:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1165:5: vExpressao= referenciaId[$ID.text]
                    {
                        pushFollow(FOLLOW_referenciaId_in_referencia3050);
                        vExpressao = referenciaId((ID10 != null ? ID10.getText() : null));

                        state._fsp--;
                        if (state.failed)
                        {
                            return referencia;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        referencia = (NoReferencia) vExpressao;
                        referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID10));
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return referencia;
    }
    // $ANTLR end "referencia"

    // $ANTLR start "referenciaId"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1182:1: referenciaId[String nome] returns [NoExpressao expressao] :;
    public final NoExpressao referenciaId(String nome) throws RecognitionException
    {
        NoExpressao expressao = null;



        pilhaContexto.push("referenciaId");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1185:2: ()
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1187:2: 
            {
                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = new NoReferenciaVariavel(nome);
                    }
                }

            }

        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaId"

    // $ANTLR start "referenciaVetorMatriz"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1201:1: referenciaVetorMatriz[ String nome] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String nome) throws RecognitionException
    {
        NoExpressao expressao = null;


        NoExpressao indice1 = null;

        NoExpressao indice2 = null;



        pilhaContexto.push("referenciaVetorMatriz");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1204:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1206:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
                match(input, 63, FOLLOW_63_in_referenciaVetorMatriz3111);
                if (state.failed)
                {
                    return expressao;
                }

                pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3117);
                indice1 = expressao();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                match(input, 64, FOLLOW_64_in_referenciaVetorMatriz3119);
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1206:30: ( '[' indice2= expressao ']' )?
                int alt45 = 2;
                int LA45_0 = input.LA(1);

                if ((LA45_0 == 63))
                {
                    alt45 = 1;
                }
                switch (alt45)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1206:31: '[' indice2= expressao ']'
                    {
                        match(input, 63, FOLLOW_63_in_referenciaVetorMatriz3122);
                        if (state.failed)
                        {
                            return expressao;
                        }

                        pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3128);
                        indice2 = expressao();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                        match(input, 64, FOLLOW_64_in_referenciaVetorMatriz3130);
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        if ((indice1 != null) && (indice2 == null))
                        {
                            expressao = new NoReferenciaVetor(nome, indice1);
                        }
                        else if ((indice1 != null) && (indice2 != null))
                        {
                            expressao = new NoReferenciaMatriz(nome, indice1, indice2);
                        }
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaVetorMatriz"

    // $ANTLR start "chamadaFuncao"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1222:1: chamadaFuncao[String nome] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String nome) throws RecognitionException
    {
        NoExpressao expressao = null;


        List<NoExpressao> vListaParametros = null;



        pilhaContexto.push("chamadaFuncao");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1225:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:2: '(' (vListaParametros= listaParametros )? ')'
            {
                match(input, 42, FOLLOW_42_in_chamadaFuncao3162);
                if (state.failed)
                {
                    return expressao;
                }

                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:6: (vListaParametros= listaParametros )?
                int alt46 = 2;
                int LA46_0 = input.LA(1);

                if (((LA46_0 >= CADEIA && LA46_0 <= CARACTER) || (LA46_0 >= ID && LA46_0 <= OPERADOR_NAO) || LA46_0 == REAL || LA46_0 == 42 || LA46_0 == 50 || LA46_0 == 67))
                {
                    alt46 = 1;
                }
                switch (alt46)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:7: vListaParametros= listaParametros
                    {
                        pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3169);
                        vListaParametros = listaParametros();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                match(input, 43, FOLLOW_43_in_chamadaFuncao3173);
                if (state.failed)
                {
                    return expressao;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(nome);
                        chamadaFuncao.setParametros(vListaParametros);
                        expressao = chamadaFuncao;
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "chamadaFuncao"

    // $ANTLR start "listaParametros"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1244:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException
    {
        List<NoExpressao> listaParametros = null;


        NoExpressao vExpressao = null;



        pilhaContexto.push("listaParametros");
        listaParametros = new ArrayList<NoExpressao>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1248:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1249:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1249:2: (vExpressao= expressao )
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1249:6: vExpressao= expressao
                {
                    pushFollow(FOLLOW_expressao_in_listaParametros3208);
                    vExpressao = expressao();

                    state._fsp--;
                    if (state.failed)
                    {
                        return listaParametros;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            listaParametros.add(vExpressao);
                        }
                    }

                }


                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1258:2: ( ',' vExpressao= expressao )*
                loop47:
                do
                {
                    int alt47 = 2;
                    int LA47_0 = input.LA(1);

                    if ((LA47_0 == 49))
                    {
                        alt47 = 1;
                    }


                    switch (alt47)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1258:3: ',' vExpressao= expressao
                        {
                            match(input, 49, FOLLOW_49_in_listaParametros3224);
                            if (state.failed)
                            {
                                return listaParametros;
                            }

                            pushFollow(FOLLOW_expressao_in_listaParametros3230);
                            vExpressao = expressao();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaParametros;
                            }

                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    listaParametros.add(vExpressao);
                                }
                            }

                        }
                        break;

                        default:
                            break loop47;
                    }
                }
                while (true);


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametros"

    // $ANTLR start "matrizVetor"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1274:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException
    {
        NoExpressao expressao = null;


        NoExpressao vExpressao = null;



        pilhaContexto.push("matrizVetor");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1277:2: ( ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
                int alt48 = 2;
                int LA48_0 = input.LA(1);

                if ((LA48_0 == 67))
                {
                    int LA48_1 = input.LA(2);

                    if ((synpred7_Portugol()))
                    {
                        alt48 = 1;
                    }
                    else if ((true))
                    {
                        alt48 = 2;
                    }
                    else
                    {
                        if (state.backtracking > 0)
                        {
                            state.failed = true;
                            return expressao;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 48, 1, input);

                        throw nvae;

                    }
                }
                else
                {
                    if (state.backtracking > 0)
                    {
                        state.failed = true;
                        return expressao;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                    throw nvae;

                }
                switch (alt48)
                {
                    case 1:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:3: ( '{' '{' )=>vExpressao= matriz
                    {
                        pushFollow(FOLLOW_matriz_in_matrizVetor3277);
                        vExpressao = matriz();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;
                    case 2:
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:37: vExpressao= vetor
                    {
                        pushFollow(FOLLOW_vetor_in_matrizVetor3285);
                        vExpressao = vetor();

                        state._fsp--;
                        if (state.failed)
                        {
                            return expressao;
                        }

                    }
                    break;

                }


                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = vExpressao;
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matrizVetor"

    // $ANTLR start "vetor"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1294:1: vetor returns [NoExpressao expressao] : '{' vListaExpressoes= listaExpressoes '}' ;
    public final NoExpressao vetor() throws RecognitionException
    {
        NoExpressao expressao = null;


        List<Object> vListaExpressoes = null;



        pilhaContexto.push("vetor");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1297:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1299:2: '{' vListaExpressoes= listaExpressoes '}'
            {
                match(input, 67, FOLLOW_67_in_vetor3314);
                if (state.failed)
                {
                    return expressao;
                }

                pushFollow(FOLLOW_listaExpressoes_in_vetor3320);
                vListaExpressoes = listaExpressoes();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                match(input, 68, FOLLOW_68_in_vetor3322);
                if (state.failed)
                {
                    return expressao;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = new NoVetor(vListaExpressoes);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "vetor"

    // $ANTLR start "matriz"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1313:1: matriz returns [NoExpressao expressao] : '{' vListaListaExpressoes= listaListaExpressoes '}' ;
    public final NoExpressao matriz() throws RecognitionException
    {
        NoExpressao expressao = null;


        List<List<Object>> vListaListaExpressoes = null;



        pilhaContexto.push("matriz");

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1316:2: ( '{' vListaListaExpressoes= listaListaExpressoes '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1318:2: '{' vListaListaExpressoes= listaListaExpressoes '}'
            {
                match(input, 67, FOLLOW_67_in_matriz3351);
                if (state.failed)
                {
                    return expressao;
                }

                pushFollow(FOLLOW_listaListaExpressoes_in_matriz3359);
                vListaListaExpressoes = listaListaExpressoes();

                state._fsp--;
                if (state.failed)
                {
                    return expressao;
                }

                match(input, 68, FOLLOW_68_in_matriz3362);
                if (state.failed)
                {
                    return expressao;
                }

                if (state.backtracking == 0)
                {
                    if (gerarArvore)
                    {
                        expressao = new NoMatriz(vListaListaExpressoes);
                    }
                }

            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matriz"

    // $ANTLR start "listaListaExpressoes"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1335:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException
    {
        List<List<Object>> listaListaExpressoes = null;


        List<Object> vListaExpressoes = null;



        pilhaContexto.push("listaListaExpressoes");
        listaListaExpressoes = new ArrayList<List<Object>>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1339:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1340:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1340:2: ( '{' vListaExpressoes= listaExpressoes '}' )
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1340:4: '{' vListaExpressoes= listaExpressoes '}'
                {
                    match(input, 67, FOLLOW_67_in_listaListaExpressoes3391);
                    if (state.failed)
                    {
                        return listaListaExpressoes;
                    }

                    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3397);
                    vListaExpressoes = listaExpressoes();

                    state._fsp--;
                    if (state.failed)
                    {
                        return listaListaExpressoes;
                    }

                    match(input, 68, FOLLOW_68_in_listaListaExpressoes3399);
                    if (state.failed)
                    {
                        return listaListaExpressoes;
                    }

                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            listaListaExpressoes.add(vListaExpressoes);
                        }
                    }

                }


                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1348:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
                loop49:
                do
                {
                    int alt49 = 2;
                    int LA49_0 = input.LA(1);

                    if ((LA49_0 == 49))
                    {
                        alt49 = 1;
                    }


                    switch (alt49)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1348:4: ',' '{' vListaExpressoes= listaExpressoes '}'
                        {
                            if (state.backtracking == 0)
                            {
                                vListaExpressoes = null;
                            }

                            match(input, 49, FOLLOW_49_in_listaListaExpressoes3414);
                            if (state.failed)
                            {
                                return listaListaExpressoes;
                            }

                            match(input, 67, FOLLOW_67_in_listaListaExpressoes3417);
                            if (state.failed)
                            {
                                return listaListaExpressoes;
                            }

                            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3423);
                            vListaExpressoes = listaExpressoes();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaListaExpressoes;
                            }

                            match(input, 68, FOLLOW_68_in_listaListaExpressoes3425);
                            if (state.failed)
                            {
                                return listaListaExpressoes;
                            }

                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    listaListaExpressoes.add(vListaExpressoes);
                                }
                            }

                        }
                        break;

                        default:
                            break loop49;
                    }
                }
                while (true);


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"

    // $ANTLR start "listaExpressoes"
    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1364:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException
    {
        List<Object> listaExpressoes = null;


        NoExpressao vExpressao = null;



        pilhaContexto.push("listaExpressoes");
        listaExpressoes = new ArrayList<Object>();

        try
        {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1368:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1369:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1369:2: ( (vExpressao= expressao )? )
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1369:3: (vExpressao= expressao )?
                {
                    if (state.backtracking == 0)
                    {
                        vExpressao = null;
                    }

                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1369:30: (vExpressao= expressao )?
                    int alt50 = 2;
                    int LA50_0 = input.LA(1);

                    if (((LA50_0 >= CADEIA && LA50_0 <= CARACTER) || (LA50_0 >= ID && LA50_0 <= OPERADOR_NAO) || LA50_0 == REAL || LA50_0 == 42 || LA50_0 == 50 || LA50_0 == 67))
                    {
                        alt50 = 1;
                    }
                    switch (alt50)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1369:31: vExpressao= expressao
                        {
                            pushFollow(FOLLOW_expressao_in_listaExpressoes3471);
                            vExpressao = expressao();

                            state._fsp--;
                            if (state.failed)
                            {
                                return listaExpressoes;
                            }

                        }
                        break;

                    }


                    if (state.backtracking == 0)
                    {
                        if (gerarArvore)
                        {
                            listaExpressoes.add(vExpressao);
                        }
                    }

                }


                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1376:2: ( ',' (vExpressao= expressao )? )*
                loop52:
                do
                {
                    int alt52 = 2;
                    int LA52_0 = input.LA(1);

                    if ((LA52_0 == 49))
                    {
                        alt52 = 1;
                    }


                    switch (alt52)
                    {
                        case 1:
                        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1376:3: ',' (vExpressao= expressao )?
                        {
                            if (state.backtracking == 0)
                            {
                                vExpressao = null;
                            }

                            match(input, 49, FOLLOW_49_in_listaExpressoes3485);
                            if (state.failed)
                            {
                                return listaExpressoes;
                            }

                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1376:30: (vExpressao= expressao )?
                            int alt51 = 2;
                            int LA51_0 = input.LA(1);

                            if (((LA51_0 >= CADEIA && LA51_0 <= CARACTER) || (LA51_0 >= ID && LA51_0 <= OPERADOR_NAO) || LA51_0 == REAL || LA51_0 == 42 || LA51_0 == 50 || LA51_0 == 67))
                            {
                                alt51 = 1;
                            }
                            switch (alt51)
                            {
                                case 1:
                                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1376:31: vExpressao= expressao
                                {
                                    pushFollow(FOLLOW_expressao_in_listaExpressoes3492);
                                    vExpressao = expressao();

                                    state._fsp--;
                                    if (state.failed)
                                    {
                                        return listaExpressoes;
                                    }

                                }
                                break;

                            }


                            if (state.backtracking == 0)
                            {
                                if (gerarArvore)
                                {
                                    listaExpressoes.add(vExpressao);
                                }
                            }

                        }
                        break;

                        default:
                            break loop52;
                    }
                }
                while (true);


            }

        }
        catch (RecognitionException re)
        {
            reportError(re);
            recover(input, re);
        }
        finally
        {
            // do for sure before leaving

            pilhaContexto.pop();

        }
        return listaExpressoes;
    }
    // $ANTLR end "listaExpressoes"

    // $ANTLR start synpred1_Portugol
    public final void synpred1_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:611:2: ( '{' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:611:3: '{'
        {
            match(input, 67, FOLLOW_67_in_synpred1_Portugol1799);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:4: ( '{' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:717:5: '{'
        {
            match(input, 67, FOLLOW_67_in_synpred2_Portugol2011);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:51: ( '-' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:52: '-'
        {
            match(input, 50, FOLLOW_50_in_synpred3_Portugol2632);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:3: ( '-' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1033:4: '-'
        {
            match(input, 50, FOLLOW_50_in_synpred4_Portugol2770);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1163:3: ( '(' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1163:4: '('
        {
            match(input, 42, FOLLOW_42_in_synpred5_Portugol3011);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1164:3: ( '[' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1164:4: '['
        {
            match(input, 63, FOLLOW_63_in_synpred6_Portugol3028);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException
    {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:3: ( '{' '{' )
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1279:4: '{' '{'
        {
            match(input, 67, FOLLOW_67_in_synpred7_Portugol3267);
            if (state.failed)
            {
                return;
            }

            match(input, 67, FOLLOW_67_in_synpred7_Portugol3269);
            if (state.failed)
            {
                return;
            }

        }

    }
    // $ANTLR end synpred7_Portugol

    // Delegated rules
    public final boolean synpred4_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred4_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred2_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred2_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred6_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred6_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred1_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred1_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred5_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred5_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred7_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred7_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred3_Portugol()
    {
        state.backtracking++;
        int start = input.mark();
        try
        {
            synpred3_Portugol_fragment(); // can never throw exception
        }
        catch (RecognitionException re)
        {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }
    public static final BitSet FOLLOW_programa_in_parse766 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa788 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_67_in_programa791 = new BitSet(new long[]
            {
                0x0000000047098000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa803 = new BitSet(new long[]
            {
                0x0000000047098000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa808 = new BitSet(new long[]
            {
                0x0000000047098000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_programa814 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais840 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais868 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes905 = new BitSet(new long[]
            {
                0x0000000046018000L
            });
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes913 = new BitSet(new long[]
            {
                0x0000000000000800L
            });
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes924 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_49_in_listaDeclaracoes946 = new BitSet(new long[]
            {
                0x0000000000000800L
            });
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes952 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_ID_in_declaracao991 = new BitSet(new long[]
            {
                0x8800000000000002L
            });
    public static final BitSet FOLLOW_63_in_declaracao998 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000009L
            });
    public static final BitSet FOLLOW_expressao_in_declaracao1005 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_declaracao1009 = new BitSet(new long[]
            {
                0x8800000000000002L
            });
    public static final BitSet FOLLOW_63_in_declaracao1016 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000009L
            });
    public static final BitSet FOLLOW_expressao_in_declaracao1023 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_declaracao1027 = new BitSet(new long[]
            {
                0x0800000000000002L
            });
    public static final BitSet FOLLOW_59_in_declaracao1034 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_declaracao1040 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1075 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1083 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1091 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1099 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1107 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1134 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_63_in_quantificador1166 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_quantificador1168 = new BitSet(new long[]
            {
                0x8000000000000002L
            });
    public static final BitSet FOLLOW_63_in_quantificador1175 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_quantificador1177 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1213 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1221 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1248 = new BitSet(new long[]
            {
                0x8000000446018800L
            });
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1258 = new BitSet(new long[]
            {
                0x8000000000000800L
            });
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1267 = new BitSet(new long[]
            {
                0x0000000000000800L
            });
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1274 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_declaracaoFuncao1276 = new BitSet(new long[]
            {
                0x0000080046018000L
            });
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1282 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_declaracaoFuncao1284 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_67_in_declaracaoFuncao1304 = new BitSet(new long[]
            {
                0x00040411DE79F830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1312 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_declaracaoFuncao1322 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1377 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_49_in_listaParametrosFuncao1405 = new BitSet(new long[]
            {
                0x0000000046018000L
            });
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1411 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1458 = new BitSet(new long[]
            {
                0x0000020000000800L
            });
    public static final BitSet FOLLOW_41_in_declaracaoParametro1465 = new BitSet(new long[]
            {
                0x0000000000000800L
            });
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1469 = new BitSet(new long[]
            {
                0x8000000000000000L
            });
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1475 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_bloco_in_blocos1507 = new BitSet(new long[]
            {
                0x00040411DE79F832L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1513 = new BitSet(new long[]
            {
                0x00040411DE79F832L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_bloco1547 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_para_in_bloco1562 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_pare_in_bloco1580 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_retorne_in_bloco1597 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_se_in_bloco1613 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_enquanto_in_bloco1630 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1644 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_escolha_in_bloco1658 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_PARA_in_para1690 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_para1692 = new BitSet(new long[]
            {
                0x010404104609F830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_inicializacaoPara_in_para1699 = new BitSet(new long[]
            {
                0x0100000000000000L
            });
    public static final BitSet FOLLOW_56_in_para1703 = new BitSet(new long[]
            {
                0x0104041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_para1710 = new BitSet(new long[]
            {
                0x0100000000000000L
            });
    public static final BitSet FOLLOW_56_in_para1714 = new BitSet(new long[]
            {
                0x00040C1000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_para1721 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_para1725 = new BitSet(new long[]
            {
                0x0004041198707830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaBlocos_in_para1731 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1762 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1770 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_listaBlocos1803 = new BitSet(new long[]
            {
                0x00040411DE79F830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_blocos_in_listaBlocos1809 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_listaBlocos1813 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_bloco_in_listaBlocos1829 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_PARE_in_pare1857 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha1884 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_escolha1886 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_escolha1892 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_escolha1894 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_67_in_escolha1897 = new BitSet(new long[]
            {
                0x0000000000060000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_listaCasos_in_escolha1906 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_escolha1909 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_casoContrario_in_listaCasos1941 = new BitSet(new long[]
            {
                0x0080000000000000L
            });
    public static final BitSet FOLLOW_PR_CASO_in_listaCasos1944 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_listaCasos1950 = new BitSet(new long[]
            {
                0x0080000000000000L
            });
    public static final BitSet FOLLOW_55_in_listaCasos1953 = new BitSet(new long[]
            {
                0x00040411DE79F830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_blocosCaso_in_listaCasos1959 = new BitSet(new long[]
            {
                0x0000000000060002L
            });
    public static final BitSet FOLLOW_PR_CASO_CONTRARIO_in_casoContrario1985 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_blocosCaso2016 = new BitSet(new long[]
            {
                0x00040411DE79F830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_blocos_in_blocosCaso2022 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_blocosCaso2024 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_blocos_in_blocosCaso2034 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto2063 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_enquanto2065 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_enquanto2071 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_enquanto2073 = new BitSet(new long[]
            {
                0x0004041198707830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2079 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto2105 = new BitSet(new long[]
            {
                0x0004041198707830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2111 = new BitSet(new long[]
            {
                0x0000000000100000L
            });
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto2113 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_facaEnquanto2115 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2121 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_facaEnquanto2123 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_SE_in_se2151 = new BitSet(new long[]
            {
                0x0000040000000000L
            });
    public static final BitSet FOLLOW_42_in_se2153 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_se2159 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_se2161 = new BitSet(new long[]
            {
                0x0004041198707830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaBlocos_in_se2167 = new BitSet(new long[]
            {
                0x0000000200000002L
            });
    public static final BitSet FOLLOW_PR_SENAO_in_se2170 = new BitSet(new long[]
            {
                0x0004041198707830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaBlocos_in_se2176 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2205 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_retorne2211 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_expressao2_in_expressao2255 = new BitSet(new long[]
            {
                0x0851210000000000L
            });
    public static final BitSet FOLLOW_pilha_in_expressao2261 = new BitSet(new long[]
            {
                0x0851210000000002L
            });
    public static final BitSet FOLLOW_59_in_expressao2275 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_48_in_expressao2283 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_52_in_expressao2291 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_54_in_expressao2299 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_45_in_expressao2307 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_40_in_expressao2315 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao2_in_expressao2327 = new BitSet(new long[]
            {
                0x0851210000000002L
            });
    public static final BitSet FOLLOW_expressao3_in_expressao22366 = new BitSet(new long[]
            {
                0x0000000000000002L, 0x0000000000000006L
            });
    public static final BitSet FOLLOW_65_in_expressao22395 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_66_in_expressao22403 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao3_in_expressao22415 = new BitSet(new long[]
            {
                0x0000000000000002L, 0x0000000000000006L
            });
    public static final BitSet FOLLOW_expressao4_in_expressao32449 = new BitSet(new long[]
            {
                0x1000004000000002L
            });
    public static final BitSet FOLLOW_60_in_expressao32470 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_38_in_expressao32478 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao4_in_expressao32491 = new BitSet(new long[]
            {
                0x1000004000000002L
            });
    public static final BitSet FOLLOW_expressao5_in_expressao42525 = new BitSet(new long[]
            {
                0x6600000000000002L
            });
    public static final BitSet FOLLOW_62_in_expressao42533 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_58_in_expressao42541 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_57_in_expressao42549 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_61_in_expressao42557 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao5_in_expressao42564 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_expressao6_in_expressao52596 = new BitSet(new long[]
            {
                0x0004400000000002L
            });
    public static final BitSet FOLLOW_46_in_expressao52620 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao6_in_expressao52626 = new BitSet(new long[]
            {
                0x0004400000000002L
            });
    public static final BitSet FOLLOW_50_in_expressao52640 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao6_in_expressao52646 = new BitSet(new long[]
            {
                0x0004400000000002L
            });
    public static final BitSet FOLLOW_expressao7_in_expressao62686 = new BitSet(new long[]
            {
                0x0020108000000002L
            });
    public static final BitSet FOLLOW_44_in_expressao62709 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_53_in_expressao62717 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_39_in_expressao62725 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao7_in_expressao62738 = new BitSet(new long[]
            {
                0x0020108000000002L
            });
    public static final BitSet FOLLOW_50_in_expressao72780 = new BitSet(new long[]
            {
                0x0000041000003830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao72791 = new BitSet(new long[]
            {
                0x0000041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao8_in_expressao72801 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_42_in_expressao82830 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_expressao82836 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_expressao82838 = new BitSet(new long[]
            {
                0x0008800000000002L
            });
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao82846 = new BitSet(new long[]
            {
                0x0008800000000002L
            });
    public static final BitSet FOLLOW_referencia_in_expressao82854 = new BitSet(new long[]
            {
                0x0008800000000002L
            });
    public static final BitSet FOLLOW_matrizVetor_in_expressao82862 = new BitSet(new long[]
            {
                0x0008800000000002L
            });
    public static final BitSet FOLLOW_47_in_expressao82875 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_51_in_expressao82883 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo2912 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo2932 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo2946 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo2959 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo2974 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_ID_in_referencia3003 = new BitSet(new long[]
            {
                0x8000040000000000L
            });
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia3020 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia3037 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_referenciaId_in_referencia3050 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_63_in_referenciaVetorMatriz3111 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3117 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_referenciaVetorMatriz3119 = new BitSet(new long[]
            {
                0x8000000000000002L
            });
    public static final BitSet FOLLOW_63_in_referenciaVetorMatriz3122 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3128 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000001L
            });
    public static final BitSet FOLLOW_64_in_referenciaVetorMatriz3130 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_42_in_chamadaFuncao3162 = new BitSet(new long[]
            {
                0x00040C1000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3169 = new BitSet(new long[]
            {
                0x0000080000000000L
            });
    public static final BitSet FOLLOW_43_in_chamadaFuncao3173 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_expressao_in_listaParametros3208 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_49_in_listaParametros3224 = new BitSet(new long[]
            {
                0x0004041000007830L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_listaParametros3230 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_matriz_in_matrizVetor3277 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_vetor_in_matrizVetor3285 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_vetor3314 = new BitSet(new long[]
            {
                0x0006041000007830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3320 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_vetor3322 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_matriz3351 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3359 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_matriz3362 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_listaListaExpressoes3391 = new BitSet(new long[]
            {
                0x0006041000007830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3397 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_listaListaExpressoes3399 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_49_in_listaListaExpressoes3414 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_67_in_listaListaExpressoes3417 = new BitSet(new long[]
            {
                0x0006041000007830L, 0x0000000000000018L
            });
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3423 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000010L
            });
    public static final BitSet FOLLOW_68_in_listaListaExpressoes3425 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3471 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_49_in_listaExpressoes3485 = new BitSet(new long[]
            {
                0x0006041000007832L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3492 = new BitSet(new long[]
            {
                0x0002000000000002L
            });
    public static final BitSet FOLLOW_67_in_synpred1_Portugol1799 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_synpred2_Portugol2011 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_50_in_synpred3_Portugol2632 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_50_in_synpred4_Portugol2770 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_42_in_synpred5_Portugol3011 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_63_in_synpred6_Portugol3028 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
    public static final BitSet FOLLOW_67_in_synpred7_Portugol3267 = new BitSet(new long[]
            {
                0x0000000000000000L, 0x0000000000000008L
            });
    public static final BitSet FOLLOW_67_in_synpred7_Portugol3269 = new BitSet(new long[]
            {
                0x0000000000000002L
            });
}