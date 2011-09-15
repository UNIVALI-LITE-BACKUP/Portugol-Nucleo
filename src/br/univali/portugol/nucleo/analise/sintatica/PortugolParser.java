// $ANTLR 3.4 /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2011-09-15 02:39:41


	package br.univali.portugol.nucleo.analise.sintatica;

	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PortugolParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CADEIA", "CARACTER", "COMENTARIO", "DIGIT_HEX", "ESC_OCTAL", "ESC_UNICODE", "ESPACO", "ID", "INTEIRO", "LOGICO", "OPERADOR_NAO", "PR_CADEIA", "PR_CARACTER", "PR_CASO", "PR_CASO_CONTRARIO", "PR_CONST", "PR_ENQUANTO", "PR_ESCOLHA", "PR_FACA", "PR_FALSO", "PR_FUNCAO", "PR_INTEIRO", "PR_LOGICO", "PR_PARA", "PR_PARE", "PR_PROGRAMA", "PR_REAL", "PR_RETORNE", "PR_SE", "PR_SENAO", "PR_VAZIO", "PR_VERDADEIRO", "REAL", "SEQ_ESC", "'!='", "'%'", "'%='", "'&'", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-='", "'/'", "'/='", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'e'", "'ou'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int CADEIA=4;
    public static final int CARACTER=5;
    public static final int COMENTARIO=6;
    public static final int DIGIT_HEX=7;
    public static final int ESC_OCTAL=8;
    public static final int ESC_UNICODE=9;
    public static final int ESPACO=10;
    public static final int ID=11;
    public static final int INTEIRO=12;
    public static final int LOGICO=13;
    public static final int OPERADOR_NAO=14;
    public static final int PR_CADEIA=15;
    public static final int PR_CARACTER=16;
    public static final int PR_CASO=17;
    public static final int PR_CASO_CONTRARIO=18;
    public static final int PR_CONST=19;
    public static final int PR_ENQUANTO=20;
    public static final int PR_ESCOLHA=21;
    public static final int PR_FACA=22;
    public static final int PR_FALSO=23;
    public static final int PR_FUNCAO=24;
    public static final int PR_INTEIRO=25;
    public static final int PR_LOGICO=26;
    public static final int PR_PARA=27;
    public static final int PR_PARE=28;
    public static final int PR_PROGRAMA=29;
    public static final int PR_REAL=30;
    public static final int PR_RETORNE=31;
    public static final int PR_SE=32;
    public static final int PR_SENAO=33;
    public static final int PR_VAZIO=34;
    public static final int PR_VERDADEIRO=35;
    public static final int REAL=36;
    public static final int SEQ_ESC=37;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PortugolParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PortugolParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return PortugolParser.tokenNames; }
    public String getGrammarFileName() { return "/home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g"; }


    	private int quantidadeErros = 0;
    	private String contexto = null;
    	private List<TradutorErrosSintaticos> tradutores  = new ArrayList<TradutorErrosSintaticos>();
    	
    	public void adicionarTradutorErros(TradutorErrosSintaticos tradutorErrosSintaticos)
    	{
    		if (!tradutores.contains(tradutorErrosSintaticos))
    			tradutores.add(tradutorErrosSintaticos);
    	}
    	
    	public void removerTradutorErros(TradutorErrosSintaticos tradutorErrosSintaticos)
    	{
    		tradutores.remove(tradutorErrosSintaticos);
    	}

    	@Override
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    	{
    		quantidadeErros = quantidadeErros + 1;
    		
    		for (TradutorErrosSintaticos tradutor: tradutores)
    			tradutor.traduzirErroSintatico(contexto, e, tokenNames);
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
    		
    		else return operandoEsquerdo;
    	}



    // $ANTLR start "parse"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:161:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;


        ArvoreSintaticaAbstrata prog =null;


        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:161:43: (prog= programa )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:163:2: prog= programa
            {
            pushFollow(FOLLOW_programa_in_parse766);
            prog=programa();

            state._fsp--;
            if (state.failed) return asa;

            if ( state.backtracking==0 ) {
            		asa = prog;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return asa;
    }
    // $ANTLR end "parse"



    // $ANTLR start "programa"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:169:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;



        	contexto = "programa";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:2: ( PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:2: PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            match(input,PR_PROGRAMA,FOLLOW_PR_PROGRAMA_in_programa787); if (state.failed) return asa;

            match(input,67,FOLLOW_67_in_programa790); if (state.failed) return asa;

            if ( state.backtracking==0 ) {
            	 		asa = new ArvoreSintaticaAbstrataPrograma();
            			asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
            		 }

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= PR_CADEIA && LA1_0 <= PR_CARACTER)||LA1_0==PR_CONST||(LA1_0 >= PR_INTEIRO && LA1_0 <= PR_LOGICO)||LA1_0==PR_REAL) ) {
                    alt1=1;
                }
                else if ( (LA1_0==PR_FUNCAO) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_programa802);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_programa807);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,68,FOLLOW_68_in_programa813); if (state.failed) return asa;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return asa;
    }
    // $ANTLR end "programa"



    // $ANTLR start "declaracoesGlobais"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:186:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes =null;



        	contexto = "declaracoesGlobais";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:189:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais835);
            vListaDeclaracoes=listaDeclaracoes();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();
            		
            		for (NoDeclaracao declaracao: vListaDeclaracoes)
            			listaDeclaracoesGlobais.add(declaracao);

            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaracoesGlobais"



    // $ANTLR start "declaracoesLocais"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:202:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes =null;



        	contexto = "declaracoesLocais";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:205:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:207:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais859);
            vListaDeclaracoes=listaDeclaracoes();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {
            		for (NoDeclaracao declaracao: vListaDeclaracoes)
            			listaBlocos.add(declaracao);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaracoesLocais"



    // $ANTLR start "listaDeclaracoes"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:216:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;


        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado =null;

        NoDeclaracao vDeclaracao =null;



        	contexto = "listaDeclaracoes";
        	listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:220:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:221:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:221:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:222:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {tokenConst = null; }

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:224:2: (tokenConst= PR_CONST )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PR_CONST) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:224:3: tokenConst= PR_CONST
                    {
                    tokenConst=(Token)match(input,PR_CONST,FOLLOW_PR_CONST_in_listaDeclaracoes893); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }


            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes901);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:226:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:226:7: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes915);
            vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            state._fsp--;
            if (state.failed) return listaDeclaracoes;

            if ( state.backtracking==0 ) { listaDeclaracoes.add(vDeclaracao); }

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==49) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,49,FOLLOW_49_in_listaDeclaracoes923); if (state.failed) return listaDeclaracoes;

            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes929);
            	    vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            	    state._fsp--;
            	    if (state.failed) return listaDeclaracoes;

            	    if ( state.backtracking==0 ) { listaDeclaracoes.add(vDeclaracao); }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaDeclaracoes;
    }
    // $ANTLR end "listaDeclaracoes"



    // $ANTLR start "declaracao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:232:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
    public final NoDeclaracao declaracao(Token tokenConst, InformacaoTipoDado informacaoTipoDado) throws RecognitionException {
        NoDeclaracao declaracao = null;


        Token tk1=null;
        Token tk2=null;
        Token ID1=null;
        NoExpressao ind1 =null;

        NoExpressao ind2 =null;

        NoExpressao inicializacao =null;



        	contexto = "declaracao";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:235:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao959); if (state.failed) return declaracao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==63) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,63,FOLLOW_63_in_declaracao966); if (state.failed) return declaracao;

                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:17: (ind1= expressao )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0 >= CADEIA && LA4_0 <= CARACTER)||(LA4_0 >= ID && LA4_0 <= OPERADOR_NAO)||LA4_0==REAL||LA4_0==42||LA4_0==50||LA4_0==67) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao973);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }


                    match(input,64,FOLLOW_64_in_declaracao977); if (state.failed) return declaracao;

                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==63) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,63,FOLLOW_63_in_declaracao984); if (state.failed) return declaracao;

                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:52: (ind2= expressao )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( ((LA5_0 >= CADEIA && LA5_0 <= CARACTER)||(LA5_0 >= ID && LA5_0 <= OPERADOR_NAO)||LA5_0==REAL||LA5_0==42||LA5_0==50||LA5_0==67) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao991);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }


                            match(input,64,FOLLOW_64_in_declaracao995); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:80: ( '=' inicializacao= expressao )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==59) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:81: '=' inicializacao= expressao
                    {
                    match(input,59,FOLLOW_59_in_declaracao1002); if (state.failed) return declaracao;

                    pushFollow(FOLLOW_expressao_in_declaracao1008);
                    inicializacao=expressao();

                    state._fsp--;
                    if (state.failed) return declaracao;

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		boolean constante = (tokenConst != null);
            		
            		if ((tk1 == null) && (tk2 == null))
            			declaracao = new NoDeclaracaoVariavel((ID1!=null?ID1.getText():null), informacaoTipoDado.getTipoDado(), constante);
            		
            		else
            		
            		if ((tk1 != null) && (tk2 == null))
            			declaracao = new NoDeclaracaoVetor((ID1!=null?ID1.getText():null), informacaoTipoDado.getTipoDado(), ind1, constante);
            		
            		else
            		
            		if ((tk1 != null) && (tk2 != null))
            			declaracao = new NoDeclaracaoMatriz((ID1!=null?ID1.getText():null), informacaoTipoDado.getTipoDado(), ind1, ind2, constante);
            	
            		declaracao.setInicializacao(inicializacao);
            		declaracao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID1));
            		declaracao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declaracao;
    }
    // $ANTLR end "declaracao"



    // $ANTLR start "declaracaoTipoDado"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:261:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        Token tokenTipoDado=null;


        	contexto = "declaracaoTipoDado";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:264:2: ( (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
            int alt9=5;
            switch ( input.LA(1) ) {
            case PR_INTEIRO:
                {
                alt9=1;
                }
                break;
            case PR_REAL:
                {
                alt9=2;
                }
                break;
            case PR_CARACTER:
                {
                alt9=3;
                }
                break;
            case PR_CADEIA:
                {
                alt9=4;
                }
                break;
            case PR_LOGICO:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return informacaoTipoDado;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:3: tokenTipoDado= PR_INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,PR_INTEIRO,FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1039); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:32: tokenTipoDado= PR_REAL
                    {
                    tokenTipoDado=(Token)match(input,PR_REAL,FOLLOW_PR_REAL_in_declaracaoTipoDado1047); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:58: tokenTipoDado= PR_CARACTER
                    {
                    tokenTipoDado=(Token)match(input,PR_CARACTER,FOLLOW_PR_CARACTER_in_declaracaoTipoDado1055); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:88: tokenTipoDado= PR_CADEIA
                    {
                    tokenTipoDado=(Token)match(input,PR_CADEIA,FOLLOW_PR_CADEIA_in_declaracaoTipoDado1063); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:266:116: tokenTipoDado= PR_LOGICO
                    {
                    tokenTipoDado=(Token)match(input,PR_LOGICO,FOLLOW_PR_LOGICO_in_declaracaoTipoDado1071); if (state.failed) return informacaoTipoDado;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		informacaoTipoDado = new InformacaoTipoDado();
            		informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
            		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDado"



    // $ANTLR start "declaracaoTipoDadoVazio"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:276:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        Token PR_VAZIO2=null;


        	contexto = "declaracaoTipoDadoVazio";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:279:2: ( PR_VAZIO )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:281:2: PR_VAZIO
            {
            PR_VAZIO2=(Token)match(input,PR_VAZIO,FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1095); if (state.failed) return informacaoTipoDado;

            if ( state.backtracking==0 ) { 
            		informacaoTipoDado = new InformacaoTipoDado();
            		informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
            		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(PR_VAZIO2));
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDadoVazio"



    // $ANTLR start "quantificador"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:292:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;


        Token tk1=null;
        Token tk2=null;


        	contexto = "quantificador";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:295:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:297:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:297:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==63) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:297:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,63,FOLLOW_63_in_quantificador1124); if (state.failed) return quantificador;

                    match(input,64,FOLLOW_64_in_quantificador1126); if (state.failed) return quantificador;

                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:297:17: (tk2= '[' ']' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==63) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:297:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,63,FOLLOW_63_in_quantificador1133); if (state.failed) return quantificador;

                            match(input,64,FOLLOW_64_in_quantificador1135); if (state.failed) return quantificador;

                            }
                            break;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		if ((tk1 == null) && (tk2 == null)) quantificador = Quantificador.VALOR;
            		else		
            		if ((tk1 != null) && (tk2 == null)) quantificador = Quantificador.VETOR;
            		else
            		if ((tk1 != null) && (tk2 != null)) quantificador = Quantificador.MATRIZ;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return quantificador;
    }
    // $ANTLR end "quantificador"



    // $ANTLR start "tipoRetornoFuncao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:309:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        InformacaoTipoDado informacao =null;



        	contexto = "tipoRetornoFuncao";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:312:2: ( (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:314:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:314:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0 >= PR_CADEIA && LA12_0 <= PR_CARACTER)||(LA12_0 >= PR_INTEIRO && LA12_0 <= PR_LOGICO)||LA12_0==PR_REAL) ) {
                alt12=1;
            }
            else if ( (LA12_0==PR_VAZIO) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:314:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1168);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:314:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1176);
                    informacao=declaracaoTipoDadoVazio();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		if (informacao != null) informacaoTipoDado = informacao;
            		
            		else
            		{
            			informacaoTipoDado = new InformacaoTipoDado();
            			informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
            		}
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "tipoRetornoFuncao"



    // $ANTLR start "declaracaoFuncao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:328:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado =null;

        Quantificador vQuantificador =null;

        List<NoParametro> vListaParametros =null;

        List<NoBloco> vBlocos =null;



        	contexto = "declaracaoFuncao";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:331:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:333:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,PR_FUNCAO,FOLLOW_PR_FUNCAO_in_declaracaoFuncao1200); if (state.failed) return ;

            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1210);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1219);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;

            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1226); if (state.failed) return ;

            match(input,42,FOLLOW_42_in_declaracaoFuncao1228); if (state.failed) return ;

            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1234);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;

            match(input,43,FOLLOW_43_in_declaracaoFuncao1236); if (state.failed) return ;

            match(input,67,FOLLOW_67_in_declaracaoFuncao1256); if (state.failed) return ;

            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1264);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;

            match(input,68,FOLLOW_68_in_declaracaoFuncao1274); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                     	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao((ID3!=null?ID3.getText():null), informacaoTipoDado.getTipoDado(), vQuantificador);
                     	declaracaoFuncao.setParametros(vListaParametros);
            	declaracaoFuncao.setBlocos(vBlocos);

            	declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID3));
            	declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());

                    	asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
                     }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaracaoFuncao"



    // $ANTLR start "listaParametrosFuncao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:358:1: listaParametrosFuncao returns [List<NoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoParametro> listaParametros = null;


        NoParametro vDeclaracaoParametro =null;



        	contexto = "listaParametrosFuncao";
        	listaParametros = new ArrayList<NoParametro>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:362:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0 >= PR_CADEIA && LA14_0 <= PR_CARACTER)||(LA14_0 >= PR_INTEIRO && LA14_0 <= PR_LOGICO)||LA14_0==PR_REAL) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:364:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:364:3: (vDeclaracaoParametro= declaracaoParametro )
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:364:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1326);
                    vDeclaracaoParametro=declaracaoParametro();

                    state._fsp--;
                    if (state.failed) return listaParametros;

                    if ( state.backtracking==0 ) { listaParametros.add(vDeclaracaoParametro); }

                    }


                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:365:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==49) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:365:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,49,FOLLOW_49_in_listaParametrosFuncao1334); if (state.failed) return listaParametros;

                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1340);
                    	    vDeclaracaoParametro=declaracaoParametro();

                    	    state._fsp--;
                    	    if (state.failed) return listaParametros;

                    	    if ( state.backtracking==0 ) { listaParametros.add(vDeclaracaoParametro); }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaParametros;
    }
    // $ANTLR end "listaParametrosFuncao"



    // $ANTLR start "declaracaoParametro"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:372:1: declaracaoParametro returns [NoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoParametro declaracaoParametro() throws RecognitionException {
        NoParametro parametro = null;


        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado =null;

        Quantificador vQuantificador =null;



        	contexto = "declaracaoParametro";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:375:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:377:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1373);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:377:42: (tkr= '&' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:377:43: tkr= '&'
                    {
                    tkr=(Token)match(input,41,FOLLOW_41_in_declaracaoParametro1380); if (state.failed) return parametro;

                    }
                    break;

            }


            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1384); if (state.failed) return parametro;

            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1390);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return parametro;

            if ( state.backtracking==0 ) {
            		NoParametro.ModoAcesso modoAcesso = null;
            		TipoDado tipoDado = null;
            		TrechoCodigoFonte trechoCodigoFonteTipoDado = null;
            		
            		if (tkr == null) modoAcesso = NoParametro.ModoAcesso.POR_VALOR;
            		else
            		if (tkr != null) modoAcesso = NoParametro.ModoAcesso.POR_REFERENCIA;
            		
            		if (informacaoTipoDado != null) 
            		{
            			tipoDado = informacaoTipoDado.getTipoDado();
            			trechoCodigoFonteTipoDado = informacaoTipoDado.getTrechoCodigoFonte();
            		}
            		
            		parametro = new NoParametro((ID4!=null?ID4.getText():null), tipoDado, vQuantificador, modoAcesso);
            		parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID4));
            		parametro.setTrechoCodigoFonteTipoDado(trechoCodigoFonteTipoDado);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return parametro;
    }
    // $ANTLR end "declaracaoParametro"



    // $ANTLR start "blocos"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:402:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;


        NoBloco vBloco =null;



        	contexto = "blocos";
        	blocos = new ArrayList<NoBloco>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:407:2: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:407:2: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= CADEIA && LA16_0 <= CARACTER)||(LA16_0 >= ID && LA16_0 <= OPERADOR_NAO)||(LA16_0 >= PR_ENQUANTO && LA16_0 <= PR_FACA)||(LA16_0 >= PR_PARA && LA16_0 <= PR_PARE)||(LA16_0 >= PR_RETORNE && LA16_0 <= PR_SE)||LA16_0==REAL||LA16_0==42||LA16_0==50||LA16_0==67) ) {
                    alt16=1;
                }
                else if ( ((LA16_0 >= PR_CADEIA && LA16_0 <= PR_CARACTER)||LA16_0==PR_CONST||(LA16_0 >= PR_INTEIRO && LA16_0 <= PR_LOGICO)||LA16_0==PR_REAL) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:408:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1419);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;

            	    if ( state.backtracking==0 ) { blocos.add(vBloco); }

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:408:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1425);
            	    declaracoesLocais(blocos);

            	    state._fsp--;
            	    if (state.failed) return blocos;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return blocos;
    }
    // $ANTLR end "blocos"



    // $ANTLR start "bloco"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:414:1: bloco returns [NoBloco bloco] : (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) ;
    public final NoBloco bloco() throws RecognitionException {
        NoBloco bloco = null;


        NoExpressao vExpressao =null;

        NoPara vPara =null;

        NoPare vPare =null;

        NoRetorne vRetorne =null;

        NoSe vSe =null;

        NoEnquanto vEnquanto =null;

        NoFacaEnquanto vFacaEnquanto =null;

        NoEscolha vEscolha =null;



        	contexto = "bloco";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:417:2: ( (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:418:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:418:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
            int alt17=8;
            switch ( input.LA(1) ) {
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
                alt17=1;
                }
                break;
            case PR_PARA:
                {
                alt17=2;
                }
                break;
            case PR_PARE:
                {
                alt17=3;
                }
                break;
            case PR_RETORNE:
                {
                alt17=4;
                }
                break;
            case PR_SE:
                {
                alt17=5;
                }
                break;
            case PR_ENQUANTO:
                {
                alt17=6;
                }
                break;
            case PR_FACA:
                {
                alt17=7;
                }
                break;
            case PR_ESCOLHA:
                {
                alt17=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return bloco;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:419:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1456);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vExpressao; 	}

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:420:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1471);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vPara; 	 	}

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:421:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1489);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vPare; 	 	}

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:422:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1506);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vRetorne; 	 	}

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:423:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1522);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vSe; 		}

                    }
                    break;
                case 6 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:424:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1539);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vEnquanto;		}

                    }
                    break;
                case 7 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:425:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1553);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vFacaEnquanto; 	}

                    }
                    break;
                case 8 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:426:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1567);
                    vEscolha=escolha();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vEscolha;	 	}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return bloco;
    }
    // $ANTLR end "bloco"



    // $ANTLR start "para"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:432:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;


        NoBloco inicializacao =null;

        NoExpressao condicao =null;

        NoExpressao incremento =null;

        List<NoBloco> vBlocos =null;



        	contexto = "para";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:435:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
            match(input,PR_PARA,FOLLOW_PR_PARA_in_para1596); if (state.failed) return para;

            match(input,42,FOLLOW_42_in_para1598); if (state.failed) return para;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:14: (inicializacao= inicializacaoPara )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= CADEIA && LA18_0 <= CARACTER)||(LA18_0 >= ID && LA18_0 <= PR_CARACTER)||LA18_0==PR_CONST||(LA18_0 >= PR_INTEIRO && LA18_0 <= PR_LOGICO)||LA18_0==PR_REAL||LA18_0==REAL||LA18_0==42||LA18_0==50||LA18_0==67) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:15: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1605);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,56,FOLLOW_56_in_para1609); if (state.failed) return para;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:55: (condicao= expressao )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0 >= CADEIA && LA19_0 <= CARACTER)||(LA19_0 >= ID && LA19_0 <= OPERADOR_NAO)||LA19_0==REAL||LA19_0==42||LA19_0==50||LA19_0==67) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:56: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1616);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,56,FOLLOW_56_in_para1620); if (state.failed) return para;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:83: (incremento= expressao )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0 >= CADEIA && LA20_0 <= CARACTER)||(LA20_0 >= ID && LA20_0 <= OPERADOR_NAO)||LA20_0==REAL||LA20_0==42||LA20_0==50||LA20_0==67) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:437:84: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1627);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,43,FOLLOW_43_in_para1631); if (state.failed) return para;

            pushFollow(FOLLOW_listaBlocos_in_para1637);
            vBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return para;

            if ( state.backtracking==0 ) {
            		para = new NoPara();
            		para.setInicializacao(inicializacao);
            		para.setCondicao(condicao);
            		para.setIncremento(incremento);		
            		para.setBlocos(vBlocos);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return para;
    }
    // $ANTLR end "para"



    // $ANTLR start "inicializacaoPara"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:450:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;


        NoExpressao vExpressao =null;

        List<NoDeclaracao> vListaDeclaracoes =null;



        	contexto = "inicializacaoPara";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:453:2: ( (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:455:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:455:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0 >= CADEIA && LA21_0 <= CARACTER)||(LA21_0 >= ID && LA21_0 <= OPERADOR_NAO)||LA21_0==REAL||LA21_0==42||LA21_0==50||LA21_0==67) ) {
                alt21=1;
            }
            else if ( ((LA21_0 >= PR_CADEIA && LA21_0 <= PR_CARACTER)||LA21_0==PR_CONST||(LA21_0 >= PR_INTEIRO && LA21_0 <= PR_LOGICO)||LA21_0==PR_REAL) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return bloco;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:455:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1666);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:455:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1674);
                    vListaDeclaracoes=listaDeclaracoes();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		if (vExpressao != null) bloco = vExpressao;
            		else
            		if (vExpressao == null) bloco = vListaDeclaracoes.get(0);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return bloco;
    }
    // $ANTLR end "inicializacaoPara"



    // $ANTLR start "listaBlocos"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:465:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vListaBlocos =null;

        NoBloco vBloco =null;



        	contexto = "listaBlocos";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:468:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:469:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:469:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==67) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred1_Portugol()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA22_0 >= CADEIA && LA22_0 <= CARACTER)||(LA22_0 >= ID && LA22_0 <= OPERADOR_NAO)||(LA22_0 >= PR_ENQUANTO && LA22_0 <= PR_FACA)||(LA22_0 >= PR_PARA && LA22_0 <= PR_PARE)||(LA22_0 >= PR_RETORNE && LA22_0 <= PR_SE)||LA22_0==REAL||LA22_0==42||LA22_0==50) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:470:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,67,FOLLOW_67_in_listaBlocos1704); if (state.failed) return listaBlocos;

                    pushFollow(FOLLOW_blocos_in_listaBlocos1710);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    if ( state.backtracking==0 ) { listaBlocos = vListaBlocos; }

                    match(input,68,FOLLOW_68_in_listaBlocos1714); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:474:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos1730);
                    vBloco=bloco();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    if ( state.backtracking==0 ) { 
                    		listaBlocos = new ArrayList<NoBloco>();
                    		listaBlocos.add(vBloco);
                    	}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaBlocos;
    }
    // $ANTLR end "listaBlocos"



    // $ANTLR start "pare"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:484:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;



        	contexto = "pare";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:487:2: ( PR_PARE )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:489:2: PR_PARE
            {
            match(input,PR_PARE,FOLLOW_PR_PARE_in_pare1755); if (state.failed) return pare;

            if ( state.backtracking==0 ) {
            		pare = new NoPare();
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return pare;
    }
    // $ANTLR end "pare"



    // $ANTLR start "escolha"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:498:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;


        NoExpressao vExpressao =null;

        List<NoCaso> vListaCasos =null;



        	contexto = "escolha";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:501:2: ( PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:503:2: PR_ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}'
            {
            match(input,PR_ESCOLHA,FOLLOW_PR_ESCOLHA_in_escolha1779); if (state.failed) return escolha;

            match(input,42,FOLLOW_42_in_escolha1781); if (state.failed) return escolha;

            pushFollow(FOLLOW_expressao_in_escolha1787);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return escolha;

            match(input,43,FOLLOW_43_in_escolha1789); if (state.failed) return escolha;

            match(input,67,FOLLOW_67_in_escolha1792); if (state.failed) return escolha;

            pushFollow(FOLLOW_listaCasos_in_escolha1801);
            vListaCasos=listaCasos();

            state._fsp--;
            if (state.failed) return escolha;

            match(input,68,FOLLOW_68_in_escolha1804); if (state.failed) return escolha;

            if ( state.backtracking==0 ) {
            		escolha = new NoEscolha(vExpressao);
            		escolha.setCasos(vListaCasos);
            	 }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return escolha;
    }
    // $ANTLR end "escolha"



    // $ANTLR start "listaCasos"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:516:1: listaCasos returns [List<NoCaso> casos] : ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )* ;
    public final List<NoCaso> listaCasos() throws RecognitionException {
        List<NoCaso> casos = null;


        NoExpressao vExpressao =null;

        List<NoBloco> vBlocos =null;



        	contexto = "listaCasos";
        	casos = new ArrayList<NoCaso>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:520:2: ( ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:521:3: ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )*
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:521:3: ( ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= PR_CASO && LA24_0 <= PR_CASO_CONTRARIO)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:522:3: ( casoContrario | PR_CASO vExpressao= expressao ) ':' vBlocos= blocosCaso
            	    {
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:522:3: ( casoContrario | PR_CASO vExpressao= expressao )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==PR_CASO_CONTRARIO) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==PR_CASO) ) {
            	        alt23=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return casos;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:522:5: casoContrario
            	            {
            	            pushFollow(FOLLOW_casoContrario_in_listaCasos1833);
            	            casoContrario();

            	            state._fsp--;
            	            if (state.failed) return casos;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:522:20: PR_CASO vExpressao= expressao
            	            {
            	            match(input,PR_CASO,FOLLOW_PR_CASO_in_listaCasos1836); if (state.failed) return casos;

            	            pushFollow(FOLLOW_expressao_in_listaCasos1842);
            	            vExpressao=expressao();

            	            state._fsp--;
            	            if (state.failed) return casos;

            	            }
            	            break;

            	    }


            	    match(input,55,FOLLOW_55_in_listaCasos1845); if (state.failed) return casos;

            	    pushFollow(FOLLOW_blocosCaso_in_listaCasos1851);
            	    vBlocos=blocosCaso();

            	    state._fsp--;
            	    if (state.failed) return casos;

            	    if ( state.backtracking==0 ) {
            	    		NoCaso caso = new NoCaso(vExpressao);
            	    		caso.setBlocos(vBlocos);
            	    		casos.add(caso);
            	    		
            	    		vExpressao = null;
            	    	}

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return casos;
    }
    // $ANTLR end "listaCasos"



    // $ANTLR start "casoContrario"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:535:1: casoContrario : PR_CASO_CONTRARIO ;
    public final void casoContrario() throws RecognitionException {

        	contexto = "casoContrario";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:538:2: ( PR_CASO_CONTRARIO )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:2: PR_CASO_CONTRARIO
            {
            match(input,PR_CASO_CONTRARIO,FOLLOW_PR_CASO_CONTRARIO_in_casoContrario1874); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "casoContrario"



    // $ANTLR start "blocosCaso"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:545:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vBlocos =null;



        	contexto = "blocosCaso";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:548:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==67) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred2_Portugol()) ) {
                    alt25=1;
                }
                else if ( (true) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA25_0 >= CADEIA && LA25_0 <= CARACTER)||(LA25_0 >= ID && LA25_0 <= PR_FACA)||(LA25_0 >= PR_INTEIRO && LA25_0 <= PR_PARE)||(LA25_0 >= PR_REAL && LA25_0 <= PR_SE)||LA25_0==REAL||LA25_0==42||LA25_0==50||LA25_0==68) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:12: ( '{' vBlocos= blocos '}' )
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:13: '{' vBlocos= blocos '}'
                    {
                    match(input,67,FOLLOW_67_in_blocosCaso1903); if (state.failed) return listaBlocos;

                    pushFollow(FOLLOW_blocos_in_blocosCaso1909);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    match(input,68,FOLLOW_68_in_blocosCaso1911); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:41: (vBlocos= blocos )
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:41: (vBlocos= blocos )
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso1921);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		listaBlocos = vBlocos;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaBlocos;
    }
    // $ANTLR end "blocosCaso"



    // $ANTLR start "enquanto"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:558:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;


        NoExpressao vExpressao =null;

        List<NoBloco> vListaBlocos =null;



        	contexto = "enquanto";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:561:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:563:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_enquanto1947); if (state.failed) return enquanto;

            match(input,42,FOLLOW_42_in_enquanto1949); if (state.failed) return enquanto;

            pushFollow(FOLLOW_expressao_in_enquanto1955);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;

            match(input,43,FOLLOW_43_in_enquanto1957); if (state.failed) return enquanto;

            pushFollow(FOLLOW_listaBlocos_in_enquanto1963);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return enquanto;

            if ( state.backtracking==0 ) {
            		enquanto = new NoEnquanto(vExpressao);
            		enquanto.setBlocos(vListaBlocos);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return enquanto;
    }
    // $ANTLR end "enquanto"



    // $ANTLR start "facaEnquanto"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:572:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;


        List<NoBloco> vListaBlocos =null;

        NoExpressao vExpressao =null;



        	contexto = "facaEnquanto";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:575:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:577:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,PR_FACA,FOLLOW_PR_FACA_in_facaEnquanto1986); if (state.failed) return facaEnquanto;

            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto1992);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;

            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_facaEnquanto1994); if (state.failed) return facaEnquanto;

            match(input,42,FOLLOW_42_in_facaEnquanto1996); if (state.failed) return facaEnquanto;

            pushFollow(FOLLOW_expressao_in_facaEnquanto2002);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;

            match(input,43,FOLLOW_43_in_facaEnquanto2004); if (state.failed) return facaEnquanto;

            if ( state.backtracking==0 ) {
            		facaEnquanto = new NoFacaEnquanto(vExpressao);
            		facaEnquanto.setBlocos(vListaBlocos);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return facaEnquanto;
    }
    // $ANTLR end "facaEnquanto"



    // $ANTLR start "se"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:587:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;


        NoExpressao vExpressao =null;

        List<NoBloco> vListaBlocos =null;

        List<NoBloco> listaBlocosSenao =null;



        	contexto = "se";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:590:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:592:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,PR_SE,FOLLOW_PR_SE_in_se2029); if (state.failed) return se;

            match(input,42,FOLLOW_42_in_se2031); if (state.failed) return se;

            pushFollow(FOLLOW_expressao_in_se2037);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;

            match(input,43,FOLLOW_43_in_se2039); if (state.failed) return se;

            pushFollow(FOLLOW_listaBlocos_in_se2045);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:592:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PR_SENAO) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:592:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,PR_SENAO,FOLLOW_PR_SENAO_in_se2048); if (state.failed) return se;

                    pushFollow(FOLLOW_listaBlocos_in_se2054);
                    listaBlocosSenao=listaBlocos();

                    state._fsp--;
                    if (state.failed) return se;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		se = new NoSe(vExpressao);
            		se.setBlocosVerdadeiros(vListaBlocos);
            		se.setBlocosFalsos(listaBlocosSenao);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return se;
    }
    // $ANTLR end "se"



    // $ANTLR start "retorne"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:602:1: retorne returns [NoRetorne retorne] : PR_RETORNE vExpressao= expressao ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;


        NoExpressao vExpressao =null;



        	contexto = "retorne";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:605:2: ( PR_RETORNE vExpressao= expressao )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:607:2: PR_RETORNE vExpressao= expressao
            {
            match(input,PR_RETORNE,FOLLOW_PR_RETORNE_in_retorne2080); if (state.failed) return retorne;

            pushFollow(FOLLOW_expressao_in_retorne2086);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return retorne;

            if ( state.backtracking==0 ) {
            		retorne = new NoRetorne(vExpressao);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retorne;
    }
    // $ANTLR end "retorne"



    // $ANTLR start "pilha"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:1: pilha returns [Stack<Object> pilha] :;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;


        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:35: ()
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:617:1: 
            {
            if ( state.backtracking==0 ) {
            	pilha = new Stack<Object>();
            }

            }

        }
        finally {
        	// do for sure before leaving
        }
        return pilha;
    }
    // $ANTLR end "pilha"



    // $ANTLR start "expressao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:622:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        Stack<Object> vPilha =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:625:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:627:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2127);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;

            pushFollow(FOLLOW_pilha_in_expressao2133);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;

            if ( state.backtracking==0 ) { vPilha.push(operandoEsquerdo); }

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:628:2: ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==40||LA28_0==45||LA28_0==48||LA28_0==52||LA28_0==54||LA28_0==59) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' ) operandoDireito= expressao2
            	    {
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' )
            	    int alt27=6;
            	    switch ( input.LA(1) ) {
            	    case 59:
            	        {
            	        alt27=1;
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt27=2;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt27=3;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt27=4;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt27=5;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt27=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt27) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:4: operador= '='
            	            {
            	            operador=(Token)match(input,59,FOLLOW_59_in_expressao2147); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:21: operador= '+='
            	            {
            	            operador=(Token)match(input,48,FOLLOW_48_in_expressao2155); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:39: operador= '-='
            	            {
            	            operador=(Token)match(input,52,FOLLOW_52_in_expressao2163); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:57: operador= '/='
            	            {
            	            operador=(Token)match(input,54,FOLLOW_54_in_expressao2171); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:75: operador= '*='
            	            {
            	            operador=(Token)match(input,45,FOLLOW_45_in_expressao2179); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:629:93: operador= '%='
            	            {
            	            operador=(Token)match(input,40,FOLLOW_40_in_expressao2187); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao2_in_expressao2199);
            	    operandoDireito=expressao2();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    if ( state.backtracking==0 ) {
            	    			vPilha.push(operador);
            	    			vPilha.push(operandoDireito);
            	    		}

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            if ( state.backtracking==0 ) {	

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao"



    // $ANTLR start "expressao2"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:658:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao2";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:661:2: (operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:663:2: operandoEsquerdo= expressao3 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao22234);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:2: ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0 >= 65 && LA30_0 <= 66)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:665:3: (operador= 'e' |operador= 'ou' ) operandoDireito= expressao3
            	    {
            	    if ( state.backtracking==0 ) { 
            	    		
            	    			if (operandoDireito != null)
            	    			{
            	    				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	    				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	    			 	operandoEsquerdo = operacao; 
            	    			 }
            	    		}

            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:675:3: (operador= 'e' |operador= 'ou' )
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==65) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==66) ) {
            	        alt29=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:675:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,65,FOLLOW_65_in_expressao22263); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:675:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,66,FOLLOW_66_in_expressao22271); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao3_in_expressao22283);
            	    operandoDireito=expressao3();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao2"



    // $ANTLR start "expressao3"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:686:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao3";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:689:2: (operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:691:2: operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32314);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:692:2: ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==38||LA32_0==60) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:693:3: (operador= '==' |operador= '!=' ) operandoDireito= expressao4
            	    {
            	    if ( state.backtracking==0 ) {
            	    		
            	    			if (operandoDireito != null)
            	    			{
            	    				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	    				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	    			 	operandoEsquerdo = operacao; 
            	    			 }
            	    		}

            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:703:3: (operador= '==' |operador= '!=' )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==60) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==38) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:703:4: operador= '=='
            	            {
            	            operador=(Token)match(input,60,FOLLOW_60_in_expressao32335); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:703:22: operador= '!='
            	            {
            	            operador=(Token)match(input,38,FOLLOW_38_in_expressao32343); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao4_in_expressao32356);
            	    operandoDireito=expressao4();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao3"



    // $ANTLR start "expressao4"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:714:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao4";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:717:2: (operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:2: operandoEsquerdo= expressao5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )?
            {
            pushFollow(FOLLOW_expressao5_in_expressao42387);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:32: ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0 >= 57 && LA34_0 <= 58)||(LA34_0 >= 61 && LA34_0 <= 62)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:33: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao5
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:33: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' )
                    int alt33=4;
                    switch ( input.LA(1) ) {
                    case 62:
                        {
                        alt33=1;
                        }
                        break;
                    case 58:
                        {
                        alt33=2;
                        }
                        break;
                    case 57:
                        {
                        alt33=3;
                        }
                        break;
                    case 61:
                        {
                        alt33=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return expressao;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;

                    }

                    switch (alt33) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:34: operador= '>='
                            {
                            operador=(Token)match(input,62,FOLLOW_62_in_expressao42395); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:52: operador= '<='
                            {
                            operador=(Token)match(input,58,FOLLOW_58_in_expressao42403); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:70: operador= '<'
                            {
                            operador=(Token)match(input,57,FOLLOW_57_in_expressao42411); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:719:87: operador= '>'
                            {
                            operador=(Token)match(input,61,FOLLOW_61_in_expressao42419); if (state.failed) return expressao;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_expressao5_in_expressao42426);
                    operandoDireito=expressao5();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao4"



    // $ANTLR start "expressao5"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:727:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao5";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:730:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:732:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao52455);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:733:2: ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
            loop35:
            do {
                int alt35=3;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==50) ) {
                    int LA35_27 = input.LA(2);

                    if ( (synpred3_Portugol()) ) {
                        alt35=2;
                    }


                }
                else if ( (LA35_0==46) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:734:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    if ( state.backtracking==0 ) {
            	    		
            	    			if (operandoDireito != null)
            	    			{
            	    				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	    				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	    			 	operandoEsquerdo = operacao; 
            	    			 }
            	    		}

            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:3: (operador= '+' operandoDireito= expressao6 )
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:4: operador= '+' operandoDireito= expressao6
            	    {
            	    operador=(Token)match(input,46,FOLLOW_46_in_expressao52479); if (state.failed) return expressao;

            	    pushFollow(FOLLOW_expressao6_in_expressao52485);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:51: ( '-' )=>operador= '-' operandoDireito= expressao6
            	    {
            	    operador=(Token)match(input,50,FOLLOW_50_in_expressao52499); if (state.failed) return expressao;

            	    pushFollow(FOLLOW_expressao6_in_expressao52505);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao5"



    // $ANTLR start "expressao6"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:756:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	contexto = "expressao6";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:759:2: (operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:761:2: operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao62542);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:762:2: ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==39||LA37_0==44||LA37_0==53) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:763:3: (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7
            	    {
            	    if ( state.backtracking==0 ) {
            	    		
            	    			if (operandoDireito != null)
            	    			{
            	    				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	    				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	    			 	operandoEsquerdo = operacao; 
            	    			 }
            	    		}

            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:774:3: (operador= '*' |operador= '/' |operador= '%' )
            	    int alt36=3;
            	    switch ( input.LA(1) ) {
            	    case 44:
            	        {
            	        alt36=1;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt36=2;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt36=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt36) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:774:4: operador= '*'
            	            {
            	            operador=(Token)match(input,44,FOLLOW_44_in_expressao62565); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:774:21: operador= '/'
            	            {
            	            operador=(Token)match(input,53,FOLLOW_53_in_expressao62573); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:774:38: operador= '%'
            	            {
            	            operador=(Token)match(input,39,FOLLOW_39_in_expressao62581); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao7_in_expressao62594);
            	    operandoDireito=expressao7();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao6"



    // $ANTLR start "expressao7"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:785:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;


        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        NoExpressao vExpressao =null;



        	contexto = "expressao7";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:788:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==50) && (synpred4_Portugol())) {
                alt40=1;
            }
            else if ( (LA40_0==42) ) {
                int LA40_2 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==REAL) ) {
                int LA40_3 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 3, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==LOGICO) ) {
                int LA40_4 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 4, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==CADEIA) ) {
                int LA40_5 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 5, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==INTEIRO) ) {
                int LA40_6 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 6, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==CARACTER) ) {
                int LA40_7 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==ID) ) {
                int LA40_8 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 8, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==67) ) {
                int LA40_9 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 9, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==OPERADOR_NAO) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:12: (listaTokenMenos+= '-' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==50) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,50,FOLLOW_50_in_expressao72633); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:40: (listaTokenNao+= OPERADOR_NAO )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==OPERADOR_NAO) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:41: listaTokenNao+= OPERADOR_NAO
                    	    {
                    	    listaTokenNao=(Token)match(input,OPERADOR_NAO,FOLLOW_OPERADOR_NAO_in_expressao72644); if (state.failed) return expressao;
                    	    if (list_listaTokenNao==null) list_listaTokenNao=new ArrayList();
                    	    list_listaTokenNao.add(listaTokenNao);


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_expressao8_in_expressao72654);
            vExpressao=expressao8();

            state._fsp--;
            if (state.failed) return expressao;

            if ( state.backtracking==0 ) {
            		if (list_listaTokenNao != null)
            		{
            			for (int i = 0; i < list_listaTokenNao.size(); i++)
            				vExpressao = new NoNao(vExpressao);
            		}
            		
            		else 
            		
            		if (list_listaTokenMenos != null) vExpressao = new NoMenosUnario(vExpressao);
            		
            		expressao = vExpressao;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao7"



    // $ANTLR start "expressao8"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:808:1: expressao8 returns [NoExpressao expressao] : ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao vExpressao =null;



        	contexto = "expressao8";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:811:2: ( ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:2: ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )?
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:2: ( '(' vExpressao= expressao ')' |vExpressao= tipoPrimitivo |vExpressao= referencia |vExpressao= matrizVetor )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt41=1;
                }
                break;
            case CADEIA:
            case CARACTER:
            case INTEIRO:
            case LOGICO:
            case REAL:
                {
                alt41=2;
                }
                break;
            case ID:
                {
                alt41=3;
                }
                break;
            case 67:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:3: '(' vExpressao= expressao ')'
                    {
                    match(input,42,FOLLOW_42_in_expressao82680); if (state.failed) return expressao;

                    pushFollow(FOLLOW_expressao_in_expressao82686);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;

                    match(input,43,FOLLOW_43_in_expressao82688); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:36: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao82696);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:65: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao82704);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:91: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao82712);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:815:3: (operador= '++' |operador= '--' )?
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==47) ) {
                alt42=1;
            }
            else if ( (LA42_0==51) ) {
                alt42=2;
            }
            switch (alt42) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:815:4: operador= '++'
                    {
                    operador=(Token)match(input,47,FOLLOW_47_in_expressao82725); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:815:22: operador= '--'
                    {
                    operador=(Token)match(input,51,FOLLOW_51_in_expressao82733); if (state.failed) return expressao;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		if (operador != null)
            		{
            			if (operador.getText().equals("++")) expressao = new NoIncremento(vExpressao);
            			else
            			if (operador.getText().equals("--")) expressao = new NoDecremento(vExpressao);
            		}
            		
            		else expressao = vExpressao;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "expressao8"



    // $ANTLR start "tipoPrimitivo"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:831:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;


        Token REAL5=null;
        Token LOGICO6=null;
        Token CADEIA7=null;
        Token INTEIRO8=null;
        Token CARACTER9=null;


        	contexto = "tipoPrimitivo";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:834:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt43=5;
            switch ( input.LA(1) ) {
            case REAL:
                {
                alt43=1;
                }
                break;
            case LOGICO:
                {
                alt43=2;
                }
                break;
            case CADEIA:
                {
                alt43=3;
                }
                break;
            case INTEIRO:
                {
                alt43=4;
                }
                break;
            case CARACTER:
                {
                alt43=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:836:2: REAL
                    {
                    REAL5=(Token)match(input,REAL,FOLLOW_REAL_in_tipoPrimitivo2759); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) { 
                    		NoReal real = new NoReal(Double.parseDouble((REAL5!=null?REAL5.getText():null)));
                    		real.setTrechoCodigoFonte(criarTrechoCodigoFonte(REAL5));
                    		expressao = real;
                    	}

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:845:2: LOGICO
                    {
                    LOGICO6=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_tipoPrimitivo2779); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		NoLogico logico = new NoLogico(((LOGICO6!=null?LOGICO6.getText():null).equals("verdadeiro")? true : false));
                    		logico.setTrechoCodigoFonte(criarTrechoCodigoFonte(LOGICO6));
                    		expressao = logico;
                    	}

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:854:2: CADEIA
                    {
                    CADEIA7=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_tipoPrimitivo2793); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		String texto = (CADEIA7!=null?CADEIA7.getText():null);
                    		NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                    		cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte(CADEIA7));
                    		expressao = cadeia;
                    	}

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:864:2: INTEIRO
                    {
                    INTEIRO8=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_tipoPrimitivo2806); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		NoInteiro inteiro = new NoInteiro(Integer.parseInt((INTEIRO8!=null?INTEIRO8.getText():null)));
                    		inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(INTEIRO8));
                    		expressao = inteiro;
                    	}

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:873:2: CARACTER
                    {
                    CARACTER9=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_tipoPrimitivo2821); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		NoCaracter caracter = new NoCaracter((CARACTER9!=null?CARACTER9.getText():null).charAt(1));
                    		caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte(CARACTER9));
                    		expressao = caracter;
                    	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "tipoPrimitivo"



    // $ANTLR start "referencia"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:883:1: referencia returns [NoReferencia referencia] : ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;


        Token ID10=null;
        NoExpressao vExpressao =null;



        	contexto = "referencia";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:2: ( ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:888:2: ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] )
            {
            ID10=(Token)match(input,ID,FOLLOW_ID_in_referencia2847); if (state.failed) return referencia;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:889:2: ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] |vExpressao= referenciaId[$ID.text] )
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred5_Portugol()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return referencia;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA44_0==63) && (synpred6_Portugol())) {
                alt44=2;
            }
            else if ( ((LA44_0 >= CADEIA && LA44_0 <= CARACTER)||(LA44_0 >= ID && LA44_0 <= PR_FACA)||(LA44_0 >= PR_FUNCAO && LA44_0 <= PR_PARE)||(LA44_0 >= PR_REAL && LA44_0 <= PR_SENAO)||LA44_0==REAL||(LA44_0 >= 38 && LA44_0 <= 40)||(LA44_0 >= 43 && LA44_0 <= 62)||(LA44_0 >= 64 && LA44_0 <= 68)) ) {
                alt44=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return referencia;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:890:3: ( '(' )=>vExpressao= chamadaFuncao[$ID.text]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia2864);
                    vExpressao=chamadaFuncao((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:891:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia2881);
                    vExpressao=referenciaVetorMatriz((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:892:5: vExpressao= referenciaId[$ID.text]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia2894);
                    vExpressao=referenciaId((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		referencia = (NoReferencia) vExpressao;
            		referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID10));
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return referencia;
    }
    // $ANTLR end "referencia"



    // $ANTLR start "referenciaId"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:903:1: referenciaId[String nome] returns [NoExpressao expressao] :;
    public final NoExpressao referenciaId(String nome) throws RecognitionException {
        NoExpressao expressao = null;



        	contexto = "referenciaId";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:906:2: ()
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:908:2: 
            {
            if ( state.backtracking==0 ) {
            		expressao = new NoReferenciaVariavel(nome);
            	}

            }

        }
        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "referenciaId"



    // $ANTLR start "referenciaVetorMatriz"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:916:1: referenciaVetorMatriz[ String nome] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String nome) throws RecognitionException {
        NoExpressao expressao = null;


        NoExpressao indice1 =null;

        NoExpressao indice2 =null;



        	contexto = "referenciaVetorMatriz";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:919:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:921:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,63,FOLLOW_63_in_referenciaVetorMatriz2949); if (state.failed) return expressao;

            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz2955);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;

            match(input,64,FOLLOW_64_in_referenciaVetorMatriz2957); if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:921:30: ( '[' indice2= expressao ']' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==63) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:921:31: '[' indice2= expressao ']'
                    {
                    match(input,63,FOLLOW_63_in_referenciaVetorMatriz2960); if (state.failed) return expressao;

                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz2966);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;

                    match(input,64,FOLLOW_64_in_referenciaVetorMatriz2968); if (state.failed) return expressao;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            	 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(nome, indice1);
            		else		
            		if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(nome, indice1, indice2);		
            	 }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "referenciaVetorMatriz"



    // $ANTLR start "chamadaFuncao"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:931:1: chamadaFuncao[String nome] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String nome) throws RecognitionException {
        NoExpressao expressao = null;


        List<NoExpressao> vListaParametros =null;



        	contexto = "chamadaFuncao";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:934:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:936:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,42,FOLLOW_42_in_chamadaFuncao2997); if (state.failed) return expressao;

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:936:6: (vListaParametros= listaParametros )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0 >= CADEIA && LA46_0 <= CARACTER)||(LA46_0 >= ID && LA46_0 <= OPERADOR_NAO)||LA46_0==REAL||LA46_0==42||LA46_0==50||LA46_0==67) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:936:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3004);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            match(input,43,FOLLOW_43_in_chamadaFuncao3008); if (state.failed) return expressao;

            if ( state.backtracking==0 ) {
            		NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(nome);
            		chamadaFuncao.setParametros(vListaParametros);
            		expressao = chamadaFuncao;
            	 }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "chamadaFuncao"



    // $ANTLR start "listaParametros"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:947:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;


        NoExpressao vExpressao =null;



        	contexto = "listaParametros";
        	listaParametros = new ArrayList<NoExpressao>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:951:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:952:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:952:2: (vExpressao= expressao )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:952:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3040);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return listaParametros;

            if ( state.backtracking==0 ) { listaParametros.add(vExpressao); }

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:953:2: ( ',' vExpressao= expressao )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==49) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:953:3: ',' vExpressao= expressao
            	    {
            	    match(input,49,FOLLOW_49_in_listaParametros3047); if (state.failed) return listaParametros;

            	    pushFollow(FOLLOW_expressao_in_listaParametros3052);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return listaParametros;

            	    if ( state.backtracking==0 ) { listaParametros.add(vExpressao); }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaParametros;
    }
    // $ANTLR end "listaParametros"



    // $ANTLR start "matrizVetor"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:958:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;


        NoExpressao vExpressao =null;



        	contexto = "matrizVetor";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:961:2: ( ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==67) ) {
                int LA48_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3089);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3097);
                    vExpressao=vetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		expressao = vExpressao;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "matrizVetor"



    // $ANTLR start "vetor"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:972:1: vetor returns [NoExpressao expressao] : '{' vListaExpressoes= listaExpressoes '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;


        List<Object> vListaExpressoes =null;



        	contexto = "vetor";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:975:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:977:2: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,67,FOLLOW_67_in_vetor3123); if (state.failed) return expressao;

            pushFollow(FOLLOW_listaExpressoes_in_vetor3129);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;

            match(input,68,FOLLOW_68_in_vetor3131); if (state.failed) return expressao;

            if ( state.backtracking==0 ) {
            		expressao = new NoVetor(vListaExpressoes);
            	 }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "vetor"



    // $ANTLR start "matriz"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:985:1: matriz returns [NoExpressao expressao] : '{' vListaListaExpressoes= listaListaExpressoes '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;


        List<List<Object>> vListaListaExpressoes =null;



        	contexto = "matriz";

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:988:2: ( '{' vListaListaExpressoes= listaListaExpressoes '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:990:2: '{' vListaListaExpressoes= listaListaExpressoes '}'
            {
            match(input,67,FOLLOW_67_in_matriz3157); if (state.failed) return expressao;

            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3165);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;

            match(input,68,FOLLOW_68_in_matriz3168); if (state.failed) return expressao;

            if ( state.backtracking==0 ) {
            	 	
            		expressao = new NoMatriz(vListaListaExpressoes);
            	 }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressao;
    }
    // $ANTLR end "matriz"



    // $ANTLR start "listaListaExpressoes"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;


        List<Object> vListaExpressoes =null;



        	contexto = "listaListaExpressoes";
        	listaListaExpressoes = new ArrayList<List<Object>>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1006:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1007:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1007:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1007:34: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,67,FOLLOW_67_in_listaListaExpressoes3224); if (state.failed) return listaListaExpressoes;

            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3230);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;

            match(input,68,FOLLOW_68_in_listaListaExpressoes3232); if (state.failed) return listaListaExpressoes;

            if ( state.backtracking==0 ) { listaListaExpressoes.add(vListaExpressoes); }

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1008:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==49) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1008:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) { vListaExpressoes = null; }

            	    match(input,49,FOLLOW_49_in_listaListaExpressoes3242); if (state.failed) return listaListaExpressoes;

            	    match(input,67,FOLLOW_67_in_listaListaExpressoes3245); if (state.failed) return listaListaExpressoes;

            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3251);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;

            	    match(input,68,FOLLOW_68_in_listaListaExpressoes3253); if (state.failed) return listaListaExpressoes;

            	    if ( state.backtracking==0 ) { listaListaExpressoes.add(vListaExpressoes); }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"



    // $ANTLR start "listaExpressoes"
    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1014:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;


        NoExpressao vExpressao =null;



        	contexto = "listaExpressoes";
        	listaExpressoes = new ArrayList<Object>();

        try {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1018:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:2: ( (vExpressao= expressao )? )
            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) { vExpressao = null; }

            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:30: (vExpressao= expressao )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0 >= CADEIA && LA50_0 <= CARACTER)||(LA50_0 >= ID && LA50_0 <= OPERADOR_NAO)||LA50_0==REAL||LA50_0==42||LA50_0==50||LA50_0==67) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3289);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return listaExpressoes;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { listaExpressoes.add(vExpressao); }

            }


            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1020:2: ( ',' (vExpressao= expressao )? )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==49) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1020:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) { vExpressao = null; }

            	    match(input,49,FOLLOW_49_in_listaExpressoes3300); if (state.failed) return listaExpressoes;

            	    // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1020:30: (vExpressao= expressao )?
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( ((LA51_0 >= CADEIA && LA51_0 <= CARACTER)||(LA51_0 >= ID && LA51_0 <= OPERADOR_NAO)||LA51_0==REAL||LA51_0==42||LA51_0==50||LA51_0==67) ) {
            	        alt51=1;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1020:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes3307);
            	            vExpressao=expressao();

            	            state._fsp--;
            	            if (state.failed) return listaExpressoes;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) { listaExpressoes.add(vExpressao); }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listaExpressoes;
    }
    // $ANTLR end "listaExpressoes"

    // $ANTLR start synpred1_Portugol
    public final void synpred1_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:470:2: ( '{' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:470:3: '{'
        {
        match(input,67,FOLLOW_67_in_synpred1_Portugol1700); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:4: ( '{' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:550:5: '{'
        {
        match(input,67,FOLLOW_67_in_synpred2_Portugol1898); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:51: ( '-' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:52: '-'
        {
        match(input,50,FOLLOW_50_in_synpred3_Portugol2491); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:3: ( '-' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:4: '-'
        {
        match(input,50,FOLLOW_50_in_synpred4_Portugol2623); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:890:3: ( '(' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:890:4: '('
        {
        match(input,42,FOLLOW_42_in_synpred5_Portugol2855); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:891:3: ( '[' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:891:4: '['
        {
        match(input,63,FOLLOW_63_in_synpred6_Portugol2872); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:3: ( '{' '{' )
        // /home/luiz/Documentos/Projetos/Portugol/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:4: '{' '{'
        {
        match(input,67,FOLLOW_67_in_synpred7_Portugol3079); if (state.failed) return ;

        match(input,67,FOLLOW_67_in_synpred7_Portugol3081); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Portugol

    // Delegated rules

    public final boolean synpred4_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Portugol() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Portugol_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_programa_in_parse766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_programa790 = new BitSet(new long[]{0x0000000047098000L,0x0000000000000010L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa802 = new BitSet(new long[]{0x0000000047098000L,0x0000000000000010L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa807 = new BitSet(new long[]{0x0000000047098000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_programa813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes893 = new BitSet(new long[]{0x0000000046018000L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes915 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_listaDeclaracoes923 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes929 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao959 = new BitSet(new long[]{0x8800000000000002L});
    public static final BitSet FOLLOW_63_in_declaracao966 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000009L});
    public static final BitSet FOLLOW_expressao_in_declaracao973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_declaracao977 = new BitSet(new long[]{0x8800000000000002L});
    public static final BitSet FOLLOW_63_in_declaracao984 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000009L});
    public static final BitSet FOLLOW_expressao_in_declaracao991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_declaracao995 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_declaracao1002 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_declaracao1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_quantificador1124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_quantificador1126 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_quantificador1133 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_quantificador1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1200 = new BitSet(new long[]{0x8000000446018800L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1210 = new BitSet(new long[]{0x8000000000000800L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1219 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1226 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_declaracaoFuncao1228 = new BitSet(new long[]{0x0000080046018000L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1234 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracaoFuncao1236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_declaracaoFuncao1256 = new BitSet(new long[]{0x00040411DE79F830L,0x0000000000000018L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_declaracaoFuncao1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1326 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_listaParametrosFuncao1334 = new BitSet(new long[]{0x0000000046018000L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1340 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1373 = new BitSet(new long[]{0x0000020000000800L});
    public static final BitSet FOLLOW_41_in_declaracaoParametro1380 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1384 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1419 = new BitSet(new long[]{0x00040411DE79F832L,0x0000000000000008L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1425 = new BitSet(new long[]{0x00040411DE79F832L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_bloco1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARA_in_para1596 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_para1598 = new BitSet(new long[]{0x010404104609F830L,0x0000000000000008L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1605 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_para1609 = new BitSet(new long[]{0x0104041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_para1616 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_para1620 = new BitSet(new long[]{0x00040C1000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_para1627 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_para1631 = new BitSet(new long[]{0x0004041198707830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaBlocos_in_para1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_listaBlocos1704 = new BitSet(new long[]{0x00040411DE79F830L,0x0000000000000018L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos1710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_listaBlocos1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARE_in_pare1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha1779 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_escolha1781 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_escolha1787 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_escolha1789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_escolha1792 = new BitSet(new long[]{0x0000000000060000L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaCasos_in_escolha1801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_escolha1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_casoContrario_in_listaCasos1833 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PR_CASO_in_listaCasos1836 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_listaCasos1842 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_listaCasos1845 = new BitSet(new long[]{0x00040411DE79F830L,0x0000000000000008L});
    public static final BitSet FOLLOW_blocosCaso_in_listaCasos1851 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_PR_CASO_CONTRARIO_in_casoContrario1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_blocosCaso1903 = new BitSet(new long[]{0x00040411DE79F830L,0x0000000000000018L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso1909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_blocosCaso1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto1947 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_enquanto1949 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_enquanto1955 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_enquanto1957 = new BitSet(new long[]{0x0004041198707830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto1986 = new BitSet(new long[]{0x0004041198707830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto1992 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto1994 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_facaEnquanto1996 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2002 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_facaEnquanto2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_SE_in_se2029 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_se2031 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_se2037 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_se2039 = new BitSet(new long[]{0x0004041198707830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaBlocos_in_se2045 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_PR_SENAO_in_se2048 = new BitSet(new long[]{0x0004041198707830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaBlocos_in_se2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2080 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_retorne2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2127 = new BitSet(new long[]{0x0851210000000000L});
    public static final BitSet FOLLOW_pilha_in_expressao2133 = new BitSet(new long[]{0x0851210000000002L});
    public static final BitSet FOLLOW_59_in_expressao2147 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_expressao2155 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_expressao2163 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_expressao2171 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expressao2179 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_40_in_expressao2187 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao2_in_expressao2199 = new BitSet(new long[]{0x0851210000000002L});
    public static final BitSet FOLLOW_expressao3_in_expressao22234 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_expressao22263 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_66_in_expressao22271 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao3_in_expressao22283 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expressao4_in_expressao32314 = new BitSet(new long[]{0x1000004000000002L});
    public static final BitSet FOLLOW_60_in_expressao32335 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_expressao32343 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao4_in_expressao32356 = new BitSet(new long[]{0x1000004000000002L});
    public static final BitSet FOLLOW_expressao5_in_expressao42387 = new BitSet(new long[]{0x6600000000000002L});
    public static final BitSet FOLLOW_62_in_expressao42395 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_expressao42403 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_expressao42411 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_expressao42419 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao5_in_expressao42426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao6_in_expressao52455 = new BitSet(new long[]{0x0004400000000002L});
    public static final BitSet FOLLOW_46_in_expressao52479 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao6_in_expressao52485 = new BitSet(new long[]{0x0004400000000002L});
    public static final BitSet FOLLOW_50_in_expressao52499 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao6_in_expressao52505 = new BitSet(new long[]{0x0004400000000002L});
    public static final BitSet FOLLOW_expressao7_in_expressao62542 = new BitSet(new long[]{0x0020108000000002L});
    public static final BitSet FOLLOW_44_in_expressao62565 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_expressao62573 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_39_in_expressao62581 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao7_in_expressao62594 = new BitSet(new long[]{0x0020108000000002L});
    public static final BitSet FOLLOW_50_in_expressao72633 = new BitSet(new long[]{0x0000041000003830L,0x0000000000000008L});
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao72644 = new BitSet(new long[]{0x0000041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao8_in_expressao72654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_expressao82680 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_expressao82686 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_expressao82688 = new BitSet(new long[]{0x0008800000000002L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao82696 = new BitSet(new long[]{0x0008800000000002L});
    public static final BitSet FOLLOW_referencia_in_expressao82704 = new BitSet(new long[]{0x0008800000000002L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao82712 = new BitSet(new long[]{0x0008800000000002L});
    public static final BitSet FOLLOW_47_in_expressao82725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_expressao82733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_referencia2847 = new BitSet(new long[]{0x8000040000000000L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_referenciaVetorMatriz2949 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz2955 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_referenciaVetorMatriz2957 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_referenciaVetorMatriz2960 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz2966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_referenciaVetorMatriz2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_chamadaFuncao2997 = new BitSet(new long[]{0x00040C1000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3004 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_chamadaFuncao3008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3040 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_listaParametros3047 = new BitSet(new long[]{0x0004041000007830L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3052 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_vetor3123 = new BitSet(new long[]{0x0006041000007830L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_vetor3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_matriz3157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_matriz3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_listaListaExpressoes3224 = new BitSet(new long[]{0x0006041000007830L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_listaListaExpressoes3232 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_listaListaExpressoes3242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_listaListaExpressoes3245 = new BitSet(new long[]{0x0006041000007830L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_listaListaExpressoes3253 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3289 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_listaExpressoes3300 = new BitSet(new long[]{0x0006041000007832L,0x0000000000000008L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3307 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_67_in_synpred1_Portugol1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred2_Portugol1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred3_Portugol2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred4_Portugol2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred5_Portugol2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred6_Portugol2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred7_Portugol3079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_synpred7_Portugol3081 = new BitSet(new long[]{0x0000000000000002L});

}