// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2013-04-25 14:27:02


	package br.univali.portugol.nucleo.analise.sintatica;

	import java.util.Stack;
	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PortugolParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PR_PROGRAMA", "PR_REAL", "PR_VAZIO", "PR_LOGICO", "PR_CADEIA", "PR_INTEIRO", "PR_CARACTER", "PR_ESCOLHA", "PR_CASO", "PR_CONTRARIO", "PR_CONST", "PR_FUNCAO", "PR_RETORNE", "PR_PARA", "PR_PARE", "PR_FACA", "PR_ENQUANTO", "PR_SE", "PR_SENAO", "GAMBIARRA", "PR_FALSO", "PR_VERDADEIRO", "OPERADOR_NAO", "LOGICO", "ID", "INTEIRO", "REAL", "SEQ_ESC", "CADEIA", "CARACTER", "ESPACO", "DIGIT_HEX", "ESC_UNICODE", "ESC_OCTAL", "COMENTARIO", "'{'", "'}'", "','", "'['", "']'", "'='", "'('", "')'", "'&'", "';'", "':'", "'+='", "'-='", "'/='", "'*='", "'%='", "'e'", "'ou'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'"
    };
    public static final int EOF=-1;
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
    public static final int T__69=69;
    public static final int PR_PROGRAMA=4;
    public static final int PR_REAL=5;
    public static final int PR_VAZIO=6;
    public static final int PR_LOGICO=7;
    public static final int PR_CADEIA=8;
    public static final int PR_INTEIRO=9;
    public static final int PR_CARACTER=10;
    public static final int PR_ESCOLHA=11;
    public static final int PR_CASO=12;
    public static final int PR_CONTRARIO=13;
    public static final int PR_CONST=14;
    public static final int PR_FUNCAO=15;
    public static final int PR_RETORNE=16;
    public static final int PR_PARA=17;
    public static final int PR_PARE=18;
    public static final int PR_FACA=19;
    public static final int PR_ENQUANTO=20;
    public static final int PR_SE=21;
    public static final int PR_SENAO=22;
    public static final int GAMBIARRA=23;
    public static final int PR_FALSO=24;
    public static final int PR_VERDADEIRO=25;
    public static final int OPERADOR_NAO=26;
    public static final int LOGICO=27;
    public static final int ID=28;
    public static final int INTEIRO=29;
    public static final int REAL=30;
    public static final int SEQ_ESC=31;
    public static final int CADEIA=32;
    public static final int CARACTER=33;
    public static final int ESPACO=34;
    public static final int DIGIT_HEX=35;
    public static final int ESC_UNICODE=36;
    public static final int ESC_OCTAL=37;
    public static final int COMENTARIO=38;

    // delegates
    // delegators


        public PortugolParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PortugolParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PortugolParser.tokenNames; }
    public String getGrammarFileName() { return "/home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g"; }


    	private boolean gerarArvore = true;
    	private int quantidadeErros = 0;		
    	private Stack<String> pilhaContexto = new Stack<String>();
    	private List<ObservadorParsing> observadores  = new ArrayList<ObservadorParsing>();
    	
    	public PortugolParser(CommonTokenStream a, RecognizerSharedState b)
    	{
    		super(a, b);
    	}
    	
    	public void adicionarObservadorParsing(ObservadorParsing observador)
    	{
    		if (!observadores.contains(observador))
    			observadores.add(observador);
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
    		
    		for (ObservadorParsing observador: observadores)
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
    	
    	private TrechoCodigoFonte criarTrechoCodigoFonteLista(Token abreEscopo, Token fechaEscopo)
    	{
    	      	if ((abreEscopo != null) && (fechaEscopo != null))
    	      	{
    	      		int linha = abreEscopo.getLine();
    			int coluna = abreEscopo.getCharPositionInLine();			
    			int tamanhoTexto = fechaEscopo.getTokenIndex() - abreEscopo.getTokenIndex();
    			
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:197:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;

        ArvoreSintaticaAbstrata prog = null;


        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:197:43: (prog= programa )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:199:2: prog= programa
            {
            pushFollow(FOLLOW_programa_in_parse863);
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
        }
        return asa;
    }
    // $ANTLR end "parse"


    // $ANTLR start "programa"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:206:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;


        	pilhaContexto.push("programa");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:209:2: ( PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:211:2: PR_PROGRAMA '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            match(input,PR_PROGRAMA,FOLLOW_PR_PROGRAMA_in_programa885); if (state.failed) return asa;
            match(input,39,FOLLOW_39_in_programa888); if (state.failed) return asa;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              		 		asa = new ArvoreSintaticaAbstrataPrograma();
              				asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
              			}
              		 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:221:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PR_REAL||(LA1_0>=PR_LOGICO && LA1_0<=PR_CARACTER)||LA1_0==PR_CONST) ) {
                    alt1=1;
                }
                else if ( (LA1_0==PR_FUNCAO) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:221:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_programa900);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:221:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_programa905);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,40,FOLLOW_40_in_programa911); if (state.failed) return asa;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return asa;
    }
    // $ANTLR end "programa"


    // $ANTLR start "declaracoesGlobais"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:230:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesGlobais");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:233:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:235:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais937);
            vListaDeclaracoes=listaDeclaracoes();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if (asa != null)
              			{
              				List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();
              				
              				if (listaDeclaracoesGlobais != null)
              				{
              					for (NoDeclaracao declaracao: vListaDeclaracoes)
              						listaDeclaracoesGlobais.add(declaracao);
              				}
              			}
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracoesGlobais"


    // $ANTLR start "declaracoesLocais"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:258:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesLocais");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:261:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:263:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais965);
            vListaDeclaracoes=listaDeclaracoes();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if ((listaBlocos != null) &&  (vListaDeclaracoes != null))
              			{
              				for (NoDeclaracao declaracao: vListaDeclaracoes)
              					listaBlocos.add(declaracao);
              			}
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracoesLocais"


    // $ANTLR start "listaDeclaracoes"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:281:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;

        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado = null;

        NoDeclaracao vDeclaracao = null;



        	pilhaContexto.push("listaDeclaracoes");
        	listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:285:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:286:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:286:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:287:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {
              tokenConst = null; 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:289:2: (tokenConst= PR_CONST )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PR_CONST) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:289:3: tokenConst= PR_CONST
                    {
                    tokenConst=(Token)match(input,PR_CONST,FOLLOW_PR_CONST_in_listaDeclaracoes1002); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }

            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1010);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:291:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:291:4: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1021);
            vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            if ( state.backtracking==0 ) {
               
              	     	if (gerarArvore)
              	     	{
              		     	if (vDeclaracao != null)	     	
              			     	listaDeclaracoes.add(vDeclaracao); 
              		     	
              			vDeclaracao = null;
              		}
              	     
            }

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:302:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==41) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:302:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,41,FOLLOW_41_in_listaDeclaracoes1043); if (state.failed) return listaDeclaracoes;
            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1049);
            	    vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            	    state._fsp--;
            	    if (state.failed) return listaDeclaracoes;
            	    if ( state.backtracking==0 ) {
            	       
            	      	   	if (gerarArvore)
            	      	   	{
            	      		   	if (vDeclaracao != null)
            	      			   	listaDeclaracoes.add(vDeclaracao); 	   
            	      		   	
            	      			 vDeclaracao = null;
            	      		 }
            	      	   
            	    }

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

            	pilhaContexto.pop();

        }
        return listaDeclaracoes;
    }
    // $ANTLR end "listaDeclaracoes"


    // $ANTLR start "declaracao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:320:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
    public final NoDeclaracao declaracao(Token tokenConst, InformacaoTipoDado informacaoTipoDado) throws RecognitionException {
        NoDeclaracao declaracao = null;

        Token tk1=null;
        Token tk2=null;
        Token ID1=null;
        NoExpressao ind1 = null;

        NoExpressao ind2 = null;

        NoExpressao inicializacao = null;



        	pilhaContexto.push("declaracao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:323:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao1088); if (state.failed) return declaracao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==42) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,42,FOLLOW_42_in_declaracao1095); if (state.failed) return declaracao;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:17: (ind1= expressao )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=OPERADOR_NAO && LA4_0<=REAL)||(LA4_0>=CADEIA && LA4_0<=CARACTER)||LA4_0==39||LA4_0==45||LA4_0==64) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao1102);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }

                    match(input,43,FOLLOW_43_in_declaracao1106); if (state.failed) return declaracao;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==42) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,42,FOLLOW_42_in_declaracao1113); if (state.failed) return declaracao;
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:52: (ind2= expressao )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( ((LA5_0>=OPERADOR_NAO && LA5_0<=REAL)||(LA5_0>=CADEIA && LA5_0<=CARACTER)||LA5_0==39||LA5_0==45||LA5_0==64) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao1120);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }

                            match(input,43,FOLLOW_43_in_declaracao1124); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:80: ( '=' inicializacao= expressao )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==44) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:325:81: '=' inicializacao= expressao
                    {
                    match(input,44,FOLLOW_44_in_declaracao1131); if (state.failed) return declaracao;
                    pushFollow(FOLLOW_expressao_in_declaracao1137);
                    inicializacao=expressao();

                    state._fsp--;
                    if (state.failed) return declaracao;

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			boolean constante = (tokenConst != null);
              			TipoDado tipoDado = (informacaoTipoDado != null)? informacaoTipoDado.getTipoDado() : null;
              			String nome = (ID1 != null)? (ID1!=null?ID1.getText():null) : null;
              			
              			if ((tk1 == null) && (tk2 == null))
              				declaracao = new NoDeclaracaoVariavel(nome, tipoDado, constante);
              			
              			else
              			
              			if ((tk1 != null) && (tk2 == null))
              				declaracao = new NoDeclaracaoVetor(nome, tipoDado, ind1, constante);
              			
              			else
              			
              			if ((tk1 != null) && (tk2 != null))
              				declaracao = new NoDeclaracaoMatriz(nome, tipoDado, ind1, ind2, constante);
              		
              			declaracao.setInicializacao(inicializacao);
              			declaracao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID1));
              			declaracao.setTrechoCodigoFonteTipoDado((informacaoTipoDado != null)? informacaoTipoDado.getTrechoCodigoFonte(): null);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return declaracao;
    }
    // $ANTLR end "declaracao"


    // $ANTLR start "declaracaoTipoDado"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:358:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token tokenTipoDado=null;


        	pilhaContexto.push("declaracaoTipoDado");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:361:2: ( (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:3: tokenTipoDado= PR_INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,PR_INTEIRO,FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1172); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:32: tokenTipoDado= PR_REAL
                    {
                    tokenTipoDado=(Token)match(input,PR_REAL,FOLLOW_PR_REAL_in_declaracaoTipoDado1180); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:58: tokenTipoDado= PR_CARACTER
                    {
                    tokenTipoDado=(Token)match(input,PR_CARACTER,FOLLOW_PR_CARACTER_in_declaracaoTipoDado1188); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:88: tokenTipoDado= PR_CADEIA
                    {
                    tokenTipoDado=(Token)match(input,PR_CADEIA,FOLLOW_PR_CADEIA_in_declaracaoTipoDado1196); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:363:116: tokenTipoDado= PR_LOGICO
                    {
                    tokenTipoDado=(Token)match(input,PR_LOGICO,FOLLOW_PR_LOGICO_in_declaracaoTipoDado1204); if (state.failed) return informacaoTipoDado;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			informacaoTipoDado = new InformacaoTipoDado();
              			informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
              			informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDado"


    // $ANTLR start "declaracaoTipoDadoVazio"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:379:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token PR_VAZIO2=null;


        	pilhaContexto.push("declaracaoTipoDadoVazio");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:382:2: ( PR_VAZIO )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:384:2: PR_VAZIO
            {
            PR_VAZIO2=(Token)match(input,PR_VAZIO,FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1231); if (state.failed) return informacaoTipoDado;
            if ( state.backtracking==0 ) {
               
              		if (gerarArvore)
              		{
              			informacaoTipoDado = new InformacaoTipoDado();
              			informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
              			informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(PR_VAZIO2));
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDadoVazio"


    // $ANTLR start "quantificador"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:401:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;

        Token tk1=null;
        Token tk2=null;


        	pilhaContexto.push("quantificador");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:404:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==42) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,42,FOLLOW_42_in_quantificador1263); if (state.failed) return quantificador;
                    match(input,43,FOLLOW_43_in_quantificador1265); if (state.failed) return quantificador;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:17: (tk2= '[' ']' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==42) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,42,FOLLOW_42_in_quantificador1272); if (state.failed) return quantificador;
                            match(input,43,FOLLOW_43_in_quantificador1274); if (state.failed) return quantificador;

                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if ((tk1 == null) && (tk2 == null)) quantificador = Quantificador.VALOR;
              			else		
              			if ((tk1 != null) && (tk2 == null)) quantificador = Quantificador.VETOR;
              			else
              			if ((tk1 != null) && (tk2 != null)) quantificador = Quantificador.MATRIZ;
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return quantificador;
    }
    // $ANTLR end "quantificador"


    // $ANTLR start "tipoRetornoFuncao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:424:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        InformacaoTipoDado informacao = null;



        	pilhaContexto.push("tipoRetornoFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:427:2: ( (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:429:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:429:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==PR_REAL||(LA12_0>=PR_LOGICO && LA12_0<=PR_CARACTER)) ) {
                alt12=1;
            }
            else if ( (LA12_0==PR_VAZIO) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:429:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1310);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:429:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1318);
                    informacao=declaracaoTipoDadoVazio();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if (informacao != null) informacaoTipoDado = informacao;
              			
              			else
              			{
              				informacaoTipoDado = new InformacaoTipoDado();
              				informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
              			}
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "tipoRetornoFuncao"


    // $ANTLR start "declaracaoFuncao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:449:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;

        List<NoDeclaracaoParametro> vListaParametros = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("declaracaoFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:452:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,PR_FUNCAO,FOLLOW_PR_FUNCAO_in_declaracaoFuncao1345); if (state.failed) return ;
            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1355);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1364);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;
            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1371); if (state.failed) return ;
            match(input,45,FOLLOW_45_in_declaracaoFuncao1373); if (state.failed) return ;
            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1379);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;
            match(input,46,FOLLOW_46_in_declaracaoFuncao1381); if (state.failed) return ;
            match(input,39,FOLLOW_39_in_declaracaoFuncao1401); if (state.failed) return ;
            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1409);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;
            match(input,40,FOLLOW_40_in_declaracaoFuncao1419); if (state.failed) return ;
            if ( state.backtracking==0 ) {

                       	if (gerarArvore)
                       	{
              	         	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao((ID3!=null?ID3.getText():null), informacaoTipoDado.getTipoDado(), vQuantificador);
              	         	declaracaoFuncao.setParametros(vListaParametros);
              		declaracaoFuncao.setBlocos(vBlocos);
              	
              		declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID3));
              		declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());
              	
              	        	asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
                      	}
                       
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracaoFuncao"


    // $ANTLR start "listaParametrosFuncao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:485:1: listaParametrosFuncao returns [List<NoDeclaracaoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoDeclaracaoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoDeclaracaoParametro> listaParametros = null;

        NoDeclaracaoParametro vDeclaracaoParametro = null;



        	pilhaContexto.push("listaParametrosFuncao");
        	listaParametros = new ArrayList<NoDeclaracaoParametro>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:489:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:490:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:490:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==PR_REAL||(LA14_0>=PR_LOGICO && LA14_0<=PR_CARACTER)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:491:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:491:3: (vDeclaracaoParametro= declaracaoParametro )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:491:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1474);
                    vDeclaracaoParametro=declaracaoParametro();

                    state._fsp--;
                    if (state.failed) return listaParametros;
                    if ( state.backtracking==0 ) {
                       
                      		     	if (gerarArvore)
                      		     	{
                      			     	listaParametros.add(vDeclaracaoParametro); 
                      		     	}		     
                      		     
                    }

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:500:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==41) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:500:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,41,FOLLOW_41_in_listaParametrosFuncao1502); if (state.failed) return listaParametros;
                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1508);
                    	    vDeclaracaoParametro=declaracaoParametro();

                    	    state._fsp--;
                    	    if (state.failed) return listaParametros;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		    	if (gerarArvore)
                    	      		    	{
                    	      			    	listaParametros.add(vDeclaracaoParametro); 
                    	      		    	}		    
                    	      		    
                    	    }

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

            	pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametrosFuncao"


    // $ANTLR start "declaracaoParametro"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:516:1: declaracaoParametro returns [NoDeclaracaoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoDeclaracaoParametro declaracaoParametro() throws RecognitionException {
        NoDeclaracaoParametro parametro = null;

        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;



        	pilhaContexto.push("declaracaoParametro");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:519:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:521:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1555);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:521:42: (tkr= '&' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==47) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:521:43: tkr= '&'
                    {
                    tkr=(Token)match(input,47,FOLLOW_47_in_declaracaoParametro1562); if (state.failed) return parametro;

                    }
                    break;

            }

            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1566); if (state.failed) return parametro;
            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1572);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return parametro;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			ModoAcesso modoAcesso = null;
              			TipoDado tipoDado = null;
              			TrechoCodigoFonte trechoCodigoFonteTipoDado = null;
              			
              			if (tkr == null) modoAcesso = ModoAcesso.POR_VALOR;
              			else
              			if (tkr != null) modoAcesso = ModoAcesso.POR_REFERENCIA;
              			
              			if (informacaoTipoDado != null) 
              			{
              				tipoDado = informacaoTipoDado.getTipoDado();
              				trechoCodigoFonteTipoDado = informacaoTipoDado.getTrechoCodigoFonte();
              			}
              			
              			parametro = new NoDeclaracaoParametro((ID4!=null?ID4.getText():null), tipoDado, vQuantificador, modoAcesso);
              			parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID4));
              			parametro.setTrechoCodigoFonteTipoDado(trechoCodigoFonteTipoDado);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return parametro;
    }
    // $ANTLR end "declaracaoParametro"


    // $ANTLR start "blocos"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:552:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("blocos");
        	blocos = new ArrayList<NoBloco>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:556:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:557:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:557:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==PR_ESCOLHA||(LA16_0>=PR_RETORNE && LA16_0<=PR_SE)||(LA16_0>=OPERADOR_NAO && LA16_0<=REAL)||(LA16_0>=CADEIA && LA16_0<=CARACTER)||LA16_0==39||LA16_0==45||LA16_0==64) ) {
                    alt16=1;
                }
                else if ( (LA16_0==PR_REAL||(LA16_0>=PR_LOGICO && LA16_0<=PR_CARACTER)||LA16_0==PR_CONST) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:558:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1604);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;
            	    if ( state.backtracking==0 ) {
            	       blocos.add(vBloco); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:558:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1610);
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

            	pilhaContexto.pop();

        }
        return blocos;
    }
    // $ANTLR end "blocos"


    // $ANTLR start "bloco"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:567:1: bloco returns [NoBloco bloco] : (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) ;
    public final NoBloco bloco() throws RecognitionException {
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

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:570:2: ( (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:571:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:571:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
            int alt17=8;
            switch ( input.LA(1) ) {
            case OPERADOR_NAO:
            case LOGICO:
            case ID:
            case INTEIRO:
            case REAL:
            case CADEIA:
            case CARACTER:
            case 39:
            case 45:
            case 64:
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:572:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1644);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vExpressao; 	
                    }

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:573:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1659);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPara; 	 	
                    }

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:574:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1677);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPare; 	 	
                    }

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:575:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1694);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vRetorne; 	 	
                    }

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:576:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1710);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vSe; 		
                    }

                    }
                    break;
                case 6 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:577:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1727);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEnquanto;		
                    }

                    }
                    break;
                case 7 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:578:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1741);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vFacaEnquanto; 	
                    }

                    }
                    break;
                case 8 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:579:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1755);
                    vEscolha=escolha();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEscolha;	 	
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

            	pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "bloco"


    // $ANTLR start "para"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:588:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;

        NoBloco inicializacao = null;

        NoExpressao condicao = null;

        NoExpressao incremento = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("para");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:591:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
            match(input,PR_PARA,FOLLOW_PR_PARA_in_para1787); if (state.failed) return para;
            match(input,45,FOLLOW_45_in_para1789); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:14: (inicializacao= inicializacaoPara )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==PR_REAL||(LA18_0>=PR_LOGICO && LA18_0<=PR_CARACTER)||LA18_0==PR_CONST||(LA18_0>=OPERADOR_NAO && LA18_0<=REAL)||(LA18_0>=CADEIA && LA18_0<=CARACTER)||LA18_0==39||LA18_0==45||LA18_0==64) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:15: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1796);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,48,FOLLOW_48_in_para1800); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:55: (condicao= expressao )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=OPERADOR_NAO && LA19_0<=REAL)||(LA19_0>=CADEIA && LA19_0<=CARACTER)||LA19_0==39||LA19_0==45||LA19_0==64) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:56: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1807);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,48,FOLLOW_48_in_para1811); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:83: (incremento= expressao )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=OPERADOR_NAO && LA20_0<=REAL)||(LA20_0>=CADEIA && LA20_0<=CARACTER)||LA20_0==39||LA20_0==45||LA20_0==64) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:593:84: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1818);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,46,FOLLOW_46_in_para1822); if (state.failed) return para;
            pushFollow(FOLLOW_listaBlocos_in_para1828);
            vBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return para;
            if ( state.backtracking==0 ) {

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return para;
    }
    // $ANTLR end "para"


    // $ANTLR start "inicializacaoPara"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:611:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;

        NoExpressao vExpressao = null;

        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("inicializacaoPara");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:614:2: ( (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=OPERADOR_NAO && LA21_0<=REAL)||(LA21_0>=CADEIA && LA21_0<=CARACTER)||LA21_0==39||LA21_0==45||LA21_0==64) ) {
                alt21=1;
            }
            else if ( (LA21_0==PR_REAL||(LA21_0>=PR_LOGICO && LA21_0<=PR_CARACTER)||LA21_0==PR_CONST) ) {
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1859);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:616:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1867);
                    vListaDeclaracoes=listaDeclaracoes();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if (vExpressao != null) bloco = vExpressao;
              			else
              			if (vExpressao == null) bloco = vListaDeclaracoes.get(0);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "inicializacaoPara"


    // $ANTLR start "listaBlocos"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:632:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vListaBlocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("listaBlocos");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:635:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:636:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:636:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:637:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,39,FOLLOW_39_in_listaBlocos1900); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_listaBlocos1906);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    if ( state.backtracking==0 ) {
                       listaBlocos = vListaBlocos; 
                    }
                    match(input,40,FOLLOW_40_in_listaBlocos1910); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos1926);
                    vBloco=bloco();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    if ( state.backtracking==0 ) {
                       
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "listaBlocos"


    // $ANTLR start "pare"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:657:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;


        	pilhaContexto.push("pare");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:660:2: ( PR_PARE )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:662:2: PR_PARE
            {
            match(input,PR_PARE,FOLLOW_PR_PARE_in_pare1954); if (state.failed) return pare;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			pare = new NoPare();
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return pare;
    }
    // $ANTLR end "pare"


    // $ANTLR start "escolha"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:677:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;

        NoExpressao vExpressaoEscolha = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("escolha");
        	List<NoCaso> casos =  new ArrayList<NoCaso>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:681:2: ( PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:683:2: PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}'
            {
            match(input,PR_ESCOLHA,FOLLOW_PR_ESCOLHA_in_escolha1981); if (state.failed) return escolha;
            match(input,45,FOLLOW_45_in_escolha1983); if (state.failed) return escolha;
            pushFollow(FOLLOW_expressao_in_escolha1989);
            vExpressaoEscolha=expressao();

            state._fsp--;
            if (state.failed) return escolha;
            match(input,46,FOLLOW_46_in_escolha1991); if (state.failed) return escolha;
            match(input,39,FOLLOW_39_in_escolha1994); if (state.failed) return escolha;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:686:3: ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==PR_CASO) ) {
                    int LA23_1 = input.LA(2);

                    if ( ((LA23_1>=OPERADOR_NAO && LA23_1<=REAL)||(LA23_1>=CADEIA && LA23_1<=CARACTER)||LA23_1==39||LA23_1==45||LA23_1==64) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:686:4: PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso
            	    {
            	    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2003); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_expressao_in_escolha2009);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return escolha;
            	    match(input,49,FOLLOW_49_in_escolha2011); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_blocosCaso_in_escolha2017);
            	    vBlocos=blocosCaso();

            	    state._fsp--;
            	    if (state.failed) return escolha;
            	    if ( state.backtracking==0 ) {
            	      			
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

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return escolha;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:698:4: ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==PR_CASO) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:698:5: PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso
                    {
                    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2032); if (state.failed) return escolha;
                    match(input,PR_CONTRARIO,FOLLOW_PR_CONTRARIO_in_escolha2034); if (state.failed) return escolha;
                    match(input,49,FOLLOW_49_in_escolha2036); if (state.failed) return escolha;
                    pushFollow(FOLLOW_blocosCaso_in_escolha2042);
                    vBlocos=blocosCaso();

                    state._fsp--;
                    if (state.failed) return escolha;
                    if ( state.backtracking==0 ) {
                      			
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

            }

            match(input,40,FOLLOW_40_in_escolha2056); if (state.failed) return escolha;
            if ( state.backtracking==0 ) {

              	 	if (gerarArvore)
              	 	{
              			escolha = new NoEscolha(vExpressaoEscolha);
              			escolha.setCasos(casos);
              		}
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return escolha;
    }
    // $ANTLR end "escolha"


    // $ANTLR start "blocosCaso"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:726:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("blocosCaso");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:729:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:12: ( '{' vBlocos= blocos '}' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:13: '{' vBlocos= blocos '}'
                    {
                    match(input,39,FOLLOW_39_in_blocosCaso2092); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_blocosCaso2098);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    match(input,40,FOLLOW_40_in_blocosCaso2100); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:41: (vBlocos= blocos )
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:41: (vBlocos= blocos )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso2110);
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

            	pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "blocosCaso"


    // $ANTLR start "enquanto"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:742:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;



        	pilhaContexto.push("enquanto");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:745:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:747:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_enquanto2139); if (state.failed) return enquanto;
            match(input,45,FOLLOW_45_in_enquanto2141); if (state.failed) return enquanto;
            pushFollow(FOLLOW_expressao_in_enquanto2147);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;
            match(input,46,FOLLOW_46_in_enquanto2149); if (state.failed) return enquanto;
            pushFollow(FOLLOW_listaBlocos_in_enquanto2155);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return enquanto;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			enquanto = new NoEnquanto(vExpressao);
              			enquanto.setBlocos(vListaBlocos);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return enquanto;
    }
    // $ANTLR end "enquanto"


    // $ANTLR start "facaEnquanto"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:762:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;

        List<NoBloco> vListaBlocos = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("facaEnquanto");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:765:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:767:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,PR_FACA,FOLLOW_PR_FACA_in_facaEnquanto2181); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2187);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_facaEnquanto2189); if (state.failed) return facaEnquanto;
            match(input,45,FOLLOW_45_in_facaEnquanto2191); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_expressao_in_facaEnquanto2197);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,46,FOLLOW_46_in_facaEnquanto2199); if (state.failed) return facaEnquanto;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			facaEnquanto = new NoFacaEnquanto(vExpressao);
              			facaEnquanto.setBlocos(vListaBlocos);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return facaEnquanto;
    }
    // $ANTLR end "facaEnquanto"


    // $ANTLR start "se"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:783:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;

        List<NoBloco> listaBlocosSenao = null;



        	pilhaContexto.push("se");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:786:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:788:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,PR_SE,FOLLOW_PR_SE_in_se2227); if (state.failed) return se;
            match(input,45,FOLLOW_45_in_se2229); if (state.failed) return se;
            pushFollow(FOLLOW_expressao_in_se2235);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;
            match(input,46,FOLLOW_46_in_se2237); if (state.failed) return se;
            pushFollow(FOLLOW_listaBlocos_in_se2243);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:788:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PR_SENAO) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:788:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,PR_SENAO,FOLLOW_PR_SENAO_in_se2246); if (state.failed) return se;
                    pushFollow(FOLLOW_listaBlocos_in_se2252);
                    listaBlocosSenao=listaBlocos();

                    state._fsp--;
                    if (state.failed) return se;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			se = new NoSe(vExpressao);
              			se.setBlocosVerdadeiros(vListaBlocos);
              			se.setBlocosFalsos(listaBlocosSenao);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return se;
    }
    // $ANTLR end "se"


    // $ANTLR start "retorne"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:804:1: retorne returns [NoRetorne retorne] : PR_RETORNE (vExpressao= expressao )? ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("retorne");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:807:2: ( PR_RETORNE (vExpressao= expressao )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:809:2: PR_RETORNE (vExpressao= expressao )?
            {
            match(input,PR_RETORNE,FOLLOW_PR_RETORNE_in_retorne2281); if (state.failed) return retorne;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:809:13: (vExpressao= expressao )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:809:14: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_retorne2288);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return retorne;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			retorne = new NoRetorne(vExpressao);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return retorne;
    }
    // $ANTLR end "retorne"


    // $ANTLR start "pilha"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:823:1: pilha returns [Stack<Object> pilha] : ;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:823:35: ()
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:824:1: 
            {
            if ( state.backtracking==0 ) {

              	pilha = new Stack<Object>();

            }

            }

        }
        finally {
        }
        return pilha;
    }
    // $ANTLR end "pilha"


    // $ANTLR start "expressao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:830:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        Stack<Object> vPilha = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:833:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:835:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2334);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;
            pushFollow(FOLLOW_pilha_in_expressao2340);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {
               vPilha.push(operandoEsquerdo); 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:836:2: ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==44||(LA29_0>=50 && LA29_0<=54)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' )
            	    int alt28=6;
            	    switch ( input.LA(1) ) {
            	    case 44:
            	        {
            	        alt28=1;
            	        }
            	        break;
            	    case 50:
            	        {
            	        alt28=2;
            	        }
            	        break;
            	    case 51:
            	        {
            	        alt28=3;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt28=4;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt28=5;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt28=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt28) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:4: operador= '='
            	            {
            	            operador=(Token)match(input,44,FOLLOW_44_in_expressao2354); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:21: operador= '+='
            	            {
            	            operador=(Token)match(input,50,FOLLOW_50_in_expressao2362); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:39: operador= '-='
            	            {
            	            operador=(Token)match(input,51,FOLLOW_51_in_expressao2370); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:57: operador= '/='
            	            {
            	            operador=(Token)match(input,52,FOLLOW_52_in_expressao2378); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:75: operador= '*='
            	            {
            	            operador=(Token)match(input,53,FOLLOW_53_in_expressao2386); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:93: operador= '%='
            	            {
            	            operador=(Token)match(input,54,FOLLOW_54_in_expressao2394); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao2_in_expressao2406);
            	    operandoDireito=expressao2();

            	    state._fsp--;
            	    if (state.failed) return expressao;
            	    if ( state.backtracking==0 ) {

            	      			if (gerarArvore)
            	      			{
            	      				vPilha.push(operador);
            	      				vPilha.push(operandoDireito);
            	      			}
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              	
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao"


    // $ANTLR start "expressao2"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:876:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao2");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:879:2: (operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:881:2: operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao22445);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:882:2: ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=55 && LA31_0<=56)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:883:3: (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		
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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:896:3: (operador= 'e' | operador= 'ou' )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==55) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==56) ) {
            	        alt30=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:896:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,55,FOLLOW_55_in_expressao22474); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:896:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,56,FOLLOW_56_in_expressao22482); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao3_in_expressao22494);
            	    operandoDireito=expressao3();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao2"


    // $ANTLR start "expressao3"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:913:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao3");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:916:2: (operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:918:2: operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32528);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:919:2: ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=57 && LA33_0<=58)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:920:3: (operador= '==' | operador= '!=' ) operandoDireito= expressao4
            	    {
            	    if ( state.backtracking==0 ) {

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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:933:3: (operador= '==' | operador= '!=' )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==57) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==58) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:933:4: operador= '=='
            	            {
            	            operador=(Token)match(input,57,FOLLOW_57_in_expressao32549); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:933:22: operador= '!='
            	            {
            	            operador=(Token)match(input,58,FOLLOW_58_in_expressao32557); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao4_in_expressao32570);
            	    operandoDireito=expressao4();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao3"


    // $ANTLR start "expressao4"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:950:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao4");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:953:2: (operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:2: operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            {
            pushFollow(FOLLOW_expressao5_in_expressao42604);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:32: ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=59 && LA35_0<=62)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' )
                    int alt34=4;
                    switch ( input.LA(1) ) {
                    case 59:
                        {
                        alt34=1;
                        }
                        break;
                    case 60:
                        {
                        alt34=2;
                        }
                        break;
                    case 61:
                        {
                        alt34=3;
                        }
                        break;
                    case 62:
                        {
                        alt34=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return expressao;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }

                    switch (alt34) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:34: operador= '>='
                            {
                            operador=(Token)match(input,59,FOLLOW_59_in_expressao42612); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:52: operador= '<='
                            {
                            operador=(Token)match(input,60,FOLLOW_60_in_expressao42620); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:70: operador= '<'
                            {
                            operador=(Token)match(input,61,FOLLOW_61_in_expressao42628); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:955:87: operador= '>'
                            {
                            operador=(Token)match(input,62,FOLLOW_62_in_expressao42636); if (state.failed) return expressao;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expressao5_in_expressao42643);
                    operandoDireito=expressao5();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao4"


    // $ANTLR start "expressao5"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:969:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao5");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:972:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:974:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao52675);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:975:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            loop36:
            do {
                int alt36=3;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:976:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:976:3: (operador= '+' operandoDireito= expressao6 )
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:978:4: operador= '+' operandoDireito= expressao6
            	    {
            	    if ( state.backtracking==0 ) {

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
            	    operador=(Token)match(input,63,FOLLOW_63_in_expressao52706); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52712);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:995:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:995:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:997:5: ( '-' )=>operador= '-' operandoDireito= expressao6
            	    {
            	    if ( state.backtracking==0 ) {

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
            	    operador=(Token)match(input,64,FOLLOW_64_in_expressao52770); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52776);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao5"


    // $ANTLR start "expressao6"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1030:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao6");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1033:2: (operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1035:2: operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao62825);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1036:2: ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=65 && LA38_0<=67)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1037:3: (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7
            	    {
            	    if ( state.backtracking==0 ) {

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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1050:3: (operador= '*' | operador= '/' | operador= '%' )
            	    int alt37=3;
            	    switch ( input.LA(1) ) {
            	    case 65:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt37=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1050:4: operador= '*'
            	            {
            	            operador=(Token)match(input,65,FOLLOW_65_in_expressao62848); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1050:21: operador= '/'
            	            {
            	            operador=(Token)match(input,66,FOLLOW_66_in_expressao62856); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1050:38: operador= '%'
            	            {
            	            operador=(Token)match(input,67,FOLLOW_67_in_expressao62864); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao7_in_expressao62877);
            	    operandoDireito=expressao7();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao6"


    // $ANTLR start "expressao7"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1067:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;

        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao7");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1070:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:12: (listaTokenMenos+= '-' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==64) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,64,FOLLOW_64_in_expressao72919); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:40: (listaTokenNao+= OPERADOR_NAO )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==OPERADOR_NAO) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:41: listaTokenNao+= OPERADOR_NAO
                    	    {
                    	    listaTokenNao=(Token)match(input,OPERADOR_NAO,FOLLOW_OPERADOR_NAO_in_expressao72930); if (state.failed) return expressao;
                    	    if (list_listaTokenNao==null) list_listaTokenNao=new ArrayList();
                    	    list_listaTokenNao.add(listaTokenNao);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_expressao8_in_expressao72940);
            vExpressao=expressao8();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao7"


    // $ANTLR start "expressao8"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1096:1: expressao8 returns [NoExpressao expressao] : (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;

        Token parentesis=null;
        Token operador=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao8");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1099:2: ( (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1101:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1101:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt42=1;
                }
                break;
            case ID:
                {
                alt42=2;
                }
                break;
            case LOGICO:
            case INTEIRO:
            case REAL:
            case CADEIA:
            case CARACTER:
                {
                alt42=3;
                }
                break;
            case 39:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1101:4: parentesis= '(' vExpressao= expressao ')'
                    {
                    parentesis=(Token)match(input,45,FOLLOW_45_in_expressao82974); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_expressao82980);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,46,FOLLOW_46_in_expressao82982); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1102:4: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao82992);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1103:4: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao83001);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1104:4: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao83011);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1106:3: (operador= '++' | operador= '--' )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==68) ) {
                alt43=1;
            }
            else if ( (LA43_0==69) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1106:4: operador= '++'
                    {
                    operador=(Token)match(input,68,FOLLOW_68_in_expressao83024); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1106:22: operador= '--'
                    {
                    operador=(Token)match(input,69,FOLLOW_69_in_expressao83032); if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              		
              			if (parentesis != null)
              			{
              				vExpressao.setEntreParentesis(true);
              			}
              			
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao8"


    // $ANTLR start "tipoPrimitivo"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1134:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;

        Token REAL5=null;
        Token LOGICO6=null;
        Token CADEIA7=null;
        Token INTEIRO8=null;
        Token CARACTER9=null;


        	pilhaContexto.push("tipoPrimitivo");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1137:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt44=5;
            switch ( input.LA(1) ) {
            case REAL:
                {
                alt44=1;
                }
                break;
            case LOGICO:
                {
                alt44=2;
                }
                break;
            case CADEIA:
                {
                alt44=3;
                }
                break;
            case INTEIRO:
                {
                alt44=4;
                }
                break;
            case CARACTER:
                {
                alt44=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1139:2: REAL
                    {
                    REAL5=(Token)match(input,REAL,FOLLOW_REAL_in_tipoPrimitivo3061); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {
                       
                      		if (gerarArvore)
                      		{
                      			NoReal real = new NoReal(Double.parseDouble((REAL5!=null?REAL5.getText():null)));
                      			real.setTrechoCodigoFonte(criarTrechoCodigoFonte(REAL5));
                      			expressao = real;
                      		}
                      	
                    }

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1151:2: LOGICO
                    {
                    LOGICO6=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_tipoPrimitivo3081); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			NoLogico logico = new NoLogico(((LOGICO6!=null?LOGICO6.getText():null).equals("verdadeiro")? true : false));
                      			logico.setTrechoCodigoFonte(criarTrechoCodigoFonte(LOGICO6));
                      			expressao = logico;
                      		}
                      	
                    }

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1163:2: CADEIA
                    {
                    CADEIA7=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_tipoPrimitivo3095); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			String texto = (CADEIA7!=null?CADEIA7.getText():null);
                      			NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                      			cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte(CADEIA7));
                      			expressao = cadeia;
                      		}
                      	
                    }

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1176:2: INTEIRO
                    {
                    INTEIRO8=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_tipoPrimitivo3108); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		try
                      		{
                      	
                      		if (gerarArvore)
                      		{
                      			NoInteiro inteiro = new NoInteiro(Integer.parseInt((INTEIRO8!=null?INTEIRO8.getText():null)));
                      			inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(INTEIRO8));
                      			expressao = inteiro;
                      		}
                      		}
                      		catch(NumberFormatException ex)
                      		{
                      			RecognitionException a = new RecognitionException();
                      			a.addSuppressed(new RuntimeException("Caracter inválido detectado")); 
                      		}
                      	
                    }

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1197:2: CARACTER
                    {
                    CARACTER9=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_tipoPrimitivo3123); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			NoCaracter caracter = new NoCaracter((CARACTER9!=null?CARACTER9.getText():null).charAt(1));
                      			caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte(CARACTER9));
                      			expressao = caracter;
                      		}
                      	
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

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "tipoPrimitivo"


    // $ANTLR start "referencia"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1213:1: referencia returns [NoReferencia referencia] : ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] | vExpressao= referenciaId[$ID.text] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;

        Token ID10=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("referencia");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1216:2: ( ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] | vExpressao= referenciaId[$ID.text] ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1218:2: ID ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] | vExpressao= referenciaId[$ID.text] )
            {
            ID10=(Token)match(input,ID,FOLLOW_ID_in_referencia3152); if (state.failed) return referencia;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1219:2: ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] | vExpressao= referenciaId[$ID.text] )
            int alt45=3;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1220:3: ( '(' )=>vExpressao= chamadaFuncao[$ID.text]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia3169);
                    vExpressao=chamadaFuncao((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1221:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia3186);
                    vExpressao=referenciaVetorMatriz((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1222:5: vExpressao= referenciaId[$ID.text]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia3199);
                    vExpressao=referenciaId((ID10!=null?ID10.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			referencia = (NoReferencia) vExpressao;
              			referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(ID10));
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return referencia;
    }
    // $ANTLR end "referencia"


    // $ANTLR start "referenciaId"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1239:1: referenciaId[String nome] returns [NoExpressao expressao] : ;
    public final NoExpressao referenciaId(String nome) throws RecognitionException {
        NoExpressao expressao = null;


        	pilhaContexto.push("referenciaId");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1242:2: ()
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1244:2: 
            {
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = new NoReferenciaVariavel(nome);
              		}
              	
            }

            }

        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaId"


    // $ANTLR start "referenciaVetorMatriz"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1258:1: referenciaVetorMatriz[ String nome] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String nome) throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao indice1 = null;

        NoExpressao indice2 = null;



        	pilhaContexto.push("referenciaVetorMatriz");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1261:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1263:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,42,FOLLOW_42_in_referenciaVetorMatriz3260); if (state.failed) return expressao;
            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3266);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,43,FOLLOW_43_in_referenciaVetorMatriz3268); if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1263:30: ( '[' indice2= expressao ']' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==42) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1263:31: '[' indice2= expressao ']'
                    {
                    match(input,42,FOLLOW_42_in_referenciaVetorMatriz3271); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3277);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,43,FOLLOW_43_in_referenciaVetorMatriz3279); if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              		 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(nome, indice1);
              			else		
              			if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(nome, indice1, indice2);		
              		}
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaVetorMatriz"


    // $ANTLR start "chamadaFuncao"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1279:1: chamadaFuncao[String nome] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String nome) throws RecognitionException {
        NoExpressao expressao = null;

        List<NoExpressao> vListaParametros = null;



        	pilhaContexto.push("chamadaFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1282:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1284:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,45,FOLLOW_45_in_chamadaFuncao3311); if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1284:6: (vListaParametros= listaParametros )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=OPERADOR_NAO && LA47_0<=REAL)||(LA47_0>=CADEIA && LA47_0<=CARACTER)||LA47_0==39||LA47_0==45||LA47_0==64) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1284:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3318);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            match(input,46,FOLLOW_46_in_chamadaFuncao3322); if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

               		if (gerarArvore)
               		{
              			NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(nome);
              			chamadaFuncao.setParametros(vListaParametros);
              			expressao = chamadaFuncao;
              		}
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "chamadaFuncao"


    // $ANTLR start "listaParametros"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1301:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaParametros");
        	listaParametros = new ArrayList<NoExpressao>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1305:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1306:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1306:2: (vExpressao= expressao )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1306:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3357);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return listaParametros;
            if ( state.backtracking==0 ) {

              		if (gerarArvore) 
              		{
              			listaParametros.add(vExpressao); 
              		}
              	   
            }

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1315:2: ( ',' vExpressao= expressao )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==41) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1315:3: ',' vExpressao= expressao
            	    {
            	    match(input,41,FOLLOW_41_in_listaParametros3373); if (state.failed) return listaParametros;
            	    pushFollow(FOLLOW_expressao_in_listaParametros3379);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return listaParametros;
            	    if ( state.backtracking==0 ) {
            	       
            	      			if (gerarArvore)
            	      			{
            	      				listaParametros.add(vExpressao); 
            	      			}
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametros"


    // $ANTLR start "matrizVetor"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1331:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("matrizVetor");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1334:2: ( ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==39) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3426);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3434);
                    vExpressao=vetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			expressao = vExpressao;
              		}
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matrizVetor"


    // $ANTLR start "vetor"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1351:1: vetor returns [NoExpressao expressao] : abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("vetor");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1354:2: (abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1356:2: abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,39,FOLLOW_39_in_vetor3467); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaExpressoes_in_vetor3473);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,40,FOLLOW_40_in_vetor3479); if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			NoVetor noVetor = new NoVetor(vListaExpressoes);
              			noVetor.setTrechoCodigoFonte(criarTrechoCodigoFonteLista(abre_ch, fecha_ch));
              			
              			expressao = noVetor;
              		}
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "vetor"


    // $ANTLR start "matriz"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1373:1: matriz returns [NoExpressao expressao] : abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<List<Object>> vListaListaExpressoes = null;



        	pilhaContexto.push("matriz");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1376:2: (abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1378:2: abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,39,FOLLOW_39_in_matriz3512); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3520);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,40,FOLLOW_40_in_matriz3527); if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              	 	{
              			NoMatriz noMatriz = new NoMatriz(vListaListaExpressoes);
              			noMatriz.setTrechoCodigoFonte(criarTrechoCodigoFonteLista(abre_ch, fecha_ch));
              			
              			expressao = noMatriz;
              		}
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matriz"


    // $ANTLR start "listaListaExpressoes"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1398:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;

        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("listaListaExpressoes");
        	listaListaExpressoes = new ArrayList<List<Object>>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1402:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1403:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1403:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1403:4: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,39,FOLLOW_39_in_listaListaExpressoes3556); if (state.failed) return listaListaExpressoes;
            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3562);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;
            match(input,40,FOLLOW_40_in_listaListaExpressoes3564); if (state.failed) return listaListaExpressoes;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              				 listaListaExpressoes.add(vListaExpressoes); 
              			 }
              		
            }

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1411:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==41) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1411:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) {
            	       vListaExpressoes = null; 
            	    }
            	    match(input,41,FOLLOW_41_in_listaListaExpressoes3579); if (state.failed) return listaListaExpressoes;
            	    match(input,39,FOLLOW_39_in_listaListaExpressoes3582); if (state.failed) return listaListaExpressoes;
            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3588);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;
            	    match(input,40,FOLLOW_40_in_listaListaExpressoes3590); if (state.failed) return listaListaExpressoes;
            	    if ( state.backtracking==0 ) {
            	       
            	      	   	if (gerarArvore)
            	      	   	{
            	      		   	listaListaExpressoes.add(vListaExpressoes); 
            	      	   	}
            	      	   
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"


    // $ANTLR start "listaExpressoes"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1427:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaExpressoes");
        	listaExpressoes = new ArrayList<Object>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1431:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1432:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1432:2: ( (vExpressao= expressao )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1432:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) {
               vExpressao = null; 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1432:30: (vExpressao= expressao )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=OPERADOR_NAO && LA51_0<=REAL)||(LA51_0>=CADEIA && LA51_0<=CARACTER)||LA51_0==39||LA51_0==45||LA51_0==64) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1432:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3636);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return listaExpressoes;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              	 	if (gerarArvore)
              	 	{
              		 	listaExpressoes.add(vExpressao); 
              	 	}
              	 
            }

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1439:2: ( ',' (vExpressao= expressao )? )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==41) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1439:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) {
            	       vExpressao = null; 
            	    }
            	    match(input,41,FOLLOW_41_in_listaExpressoes3650); if (state.failed) return listaExpressoes;
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1439:30: (vExpressao= expressao )?
            	    int alt52=2;
            	    int LA52_0 = input.LA(1);

            	    if ( ((LA52_0>=OPERADOR_NAO && LA52_0<=REAL)||(LA52_0>=CADEIA && LA52_0<=CARACTER)||LA52_0==39||LA52_0==45||LA52_0==64) ) {
            	        alt52=1;
            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1439:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes3657);
            	            vExpressao=expressao();

            	            state._fsp--;
            	            if (state.failed) return listaExpressoes;

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      		if (gerarArvore)
            	      		{
            	      		 	listaExpressoes.add(vExpressao); 
            	      	 	}
            	      	 
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	pilhaContexto.pop();

        }
        return listaExpressoes;
    }
    // $ANTLR end "listaExpressoes"

    // $ANTLR start synpred1_Portugol
    public final void synpred1_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:637:2: ( '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:637:3: '{'
        {
        match(input,39,FOLLOW_39_in_synpred1_Portugol1896); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:4: ( '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:5: '{'
        {
        match(input,39,FOLLOW_39_in_synpred2_Portugol2087); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:997:5: ( '-' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:997:6: '-'
        {
        match(input,64,FOLLOW_64_in_synpred3_Portugol2742); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:3: ( '-' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1072:4: '-'
        {
        match(input,64,FOLLOW_64_in_synpred4_Portugol2909); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1220:3: ( '(' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1220:4: '('
        {
        match(input,45,FOLLOW_45_in_synpred5_Portugol3160); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1221:3: ( '[' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1221:4: '['
        {
        match(input,42,FOLLOW_42_in_synpred6_Portugol3177); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:3: ( '{' '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1336:4: '{' '{'
        {
        match(input,39,FOLLOW_39_in_synpred7_Portugol3416); if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred7_Portugol3418); if (state.failed) return ;

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


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA22_eotS =
        "\23\uffff";
    static final String DFA22_eofS =
        "\23\uffff";
    static final String DFA22_minS =
        "\1\13\1\0\21\uffff";
    static final String DFA22_maxS =
        "\1\100\1\0\21\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA22_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\4\uffff\6\2\4\uffff\5\2\1\uffff\2\2\5\uffff\1\1\5\uffff"+
            "\1\2\22\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "636:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_1 = input.LA(1);

                         
                        int index22_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Portugol()) ) {s = 18;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA25_eotS =
        "\33\uffff";
    static final String DFA25_eofS =
        "\33\uffff";
    static final String DFA25_minS =
        "\1\5\1\0\31\uffff";
    static final String DFA25_maxS =
        "\1\100\1\0\31\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\27\uffff\1\1";
    static final String DFA25_specialS =
        "\1\uffff\1\0\31\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\2\1\uffff\6\2\1\uffff\1\2\1\uffff\6\2\4\uffff\5\2\1\uffff"+
            "\2\2\5\uffff\1\1\1\2\4\uffff\1\2\22\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "731:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Portugol()) ) {s = 26;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\33\uffff";
    static final String DFA27_eofS =
        "\33\uffff";
    static final String DFA27_minS =
        "\1\5\32\uffff";
    static final String DFA27_maxS =
        "\1\100\32\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\12\1\1\2\17\uffff";
    static final String DFA27_specialS =
        "\33\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\13\1\uffff\6\13\1\uffff\1\13\1\uffff\7\13\3\uffff\1\12\1"+
            "\5\1\3\1\7\1\4\1\uffff\1\6\1\10\5\uffff\1\11\1\13\4\uffff\1"+
            "\2\22\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "809:13: (vExpressao= expressao )?";
        }
    }
    static final String DFA36_eotS =
        "\61\uffff";
    static final String DFA36_eofS =
        "\61\uffff";
    static final String DFA36_minS =
        "\1\5\31\uffff\1\0\26\uffff";
    static final String DFA36_maxS =
        "\1\100\31\uffff\1\0\26\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\3\55\uffff\1\1\1\2";
    static final String DFA36_specialS =
        "\32\uffff\1\0\26\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\uffff\6\1\1\uffff\11\1\3\uffff\5\1\1\uffff\2\1\5\uffff"+
            "\3\1\1\uffff\4\1\1\uffff\17\1\1\57\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 975:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_26 = input.LA(1);

                         
                        int index36_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Portugol()) ) {s = 48;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA41_eotS =
        "\13\uffff";
    static final String DFA41_eofS =
        "\13\uffff";
    static final String DFA41_minS =
        "\1\32\1\uffff\10\0\1\uffff";
    static final String DFA41_maxS =
        "\1\100\1\uffff\10\0\1\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\1\10\uffff\1\2";
    static final String DFA41_specialS =
        "\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\12\1\5\1\3\1\7\1\4\1\uffff\1\6\1\10\5\uffff\1\11\5\uffff"+
            "\1\2\22\uffff\1\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "1072:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_0 = input.LA(1);

                         
                        int index41_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA41_0==64) && (synpred4_Portugol())) {s = 1;}

                        else if ( (LA41_0==45) ) {s = 2;}

                        else if ( (LA41_0==ID) ) {s = 3;}

                        else if ( (LA41_0==REAL) ) {s = 4;}

                        else if ( (LA41_0==LOGICO) ) {s = 5;}

                        else if ( (LA41_0==CADEIA) ) {s = 6;}

                        else if ( (LA41_0==INTEIRO) ) {s = 7;}

                        else if ( (LA41_0==CARACTER) ) {s = 8;}

                        else if ( (LA41_0==39) ) {s = 9;}

                        else if ( (LA41_0==OPERADOR_NAO) ) {s = 10;}

                         
                        input.seek(index41_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA41_9 = input.LA(1);

                         
                        int index41_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\67\uffff";
    static final String DFA45_eofS =
        "\67\uffff";
    static final String DFA45_minS =
        "\1\5\1\0\65\uffff";
    static final String DFA45_maxS =
        "\1\105\1\0\65\uffff";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\3\62\uffff\1\1";
    static final String DFA45_specialS =
        "\1\0\1\1\65\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\3\1\uffff\6\3\1\uffff\11\3\3\uffff\5\3\1\uffff\2\3\5\uffff"+
            "\3\3\1\2\2\3\1\1\1\3\1\uffff\26\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "1219:2: ( ( '(' )=>vExpressao= chamadaFuncao[$ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$ID.text] | vExpressao= referenciaId[$ID.text] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_0 = input.LA(1);

                         
                        int index45_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA45_0==45) ) {s = 1;}

                        else if ( (LA45_0==42) && (synpred6_Portugol())) {s = 2;}

                        else if ( (LA45_0==PR_REAL||(LA45_0>=PR_LOGICO && LA45_0<=PR_CASO)||(LA45_0>=PR_CONST && LA45_0<=PR_SENAO)||(LA45_0>=OPERADOR_NAO && LA45_0<=REAL)||(LA45_0>=CADEIA && LA45_0<=CARACTER)||(LA45_0>=39 && LA45_0<=41)||(LA45_0>=43 && LA45_0<=44)||LA45_0==46||(LA45_0>=48 && LA45_0<=69)) ) {s = 3;}

                         
                        input.seek(index45_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Portugol()) ) {s = 54;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_programa_in_parse863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa885 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_programa888 = new BitSet(new long[]{0x000001000000C7A0L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa900 = new BitSet(new long[]{0x000001000000C7A0L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa905 = new BitSet(new long[]{0x000001000000C7A0L});
    public static final BitSet FOLLOW_40_in_programa911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes1002 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1010 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1021 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_listaDeclaracoes1043 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1049 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao1088 = new BitSet(new long[]{0x0000140000000002L});
    public static final BitSet FOLLOW_42_in_declaracao1095 = new BitSet(new long[]{0x000028837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_declaracao1102 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracao1106 = new BitSet(new long[]{0x0000140000000002L});
    public static final BitSet FOLLOW_42_in_declaracao1113 = new BitSet(new long[]{0x000028837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_declaracao1120 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracao1124 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_declaracao1131 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_declaracao1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_quantificador1263 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_quantificador1265 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_quantificador1272 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_quantificador1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1345 = new BitSet(new long[]{0x00000400100047E0L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1355 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1364 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1371 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_declaracaoFuncao1373 = new BitSet(new long[]{0x00004000000047A0L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1379 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_declaracaoFuncao1381 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_declaracaoFuncao1401 = new BitSet(new long[]{0x000021837C3F4FA0L,0x0000000000000001L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1409 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_declaracaoFuncao1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1474 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_listaParametrosFuncao1502 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1508 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1555 = new BitSet(new long[]{0x0000800010000000L});
    public static final BitSet FOLLOW_47_in_declaracaoParametro1562 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1566 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1604 = new BitSet(new long[]{0x000020837C3F4FA2L,0x0000000000000001L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1610 = new BitSet(new long[]{0x000020837C3F4FA2L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_bloco1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARA_in_para1787 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_para1789 = new BitSet(new long[]{0x000120837C0047A0L,0x0000000000000001L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1796 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_para1800 = new BitSet(new long[]{0x000120837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_para1807 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_para1811 = new BitSet(new long[]{0x000060837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_para1818 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_para1822 = new BitSet(new long[]{0x000020837C3F0800L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaBlocos_in_para1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_listaBlocos1900 = new BitSet(new long[]{0x000021837C3F4FA0L,0x0000000000000001L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos1906 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_listaBlocos1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARE_in_pare1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha1981 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_escolha1983 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_escolha1989 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_escolha1991 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_escolha1994 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2003 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_escolha2009 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_escolha2011 = new BitSet(new long[]{0x000020837C3F4FA0L,0x0000000000000001L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2017 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2032 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PR_CONTRARIO_in_escolha2034 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_escolha2036 = new BitSet(new long[]{0x000020837C3F4FA0L,0x0000000000000001L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2042 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_escolha2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_blocosCaso2092 = new BitSet(new long[]{0x000021837C3F4FA0L,0x0000000000000001L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2098 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_blocosCaso2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto2139 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_enquanto2141 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_enquanto2147 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_enquanto2149 = new BitSet(new long[]{0x000020837C3F0800L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto2181 = new BitSet(new long[]{0x000020837C3F0800L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2187 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto2189 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_facaEnquanto2191 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2197 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_facaEnquanto2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_SE_in_se2227 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_se2229 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_se2235 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_se2237 = new BitSet(new long[]{0x000020837C3F0800L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaBlocos_in_se2243 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PR_SENAO_in_se2246 = new BitSet(new long[]{0x000020837C3F0800L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaBlocos_in_se2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2281 = new BitSet(new long[]{0x000020837C000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_retorne2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2334 = new BitSet(new long[]{0x007C100000000000L});
    public static final BitSet FOLLOW_pilha_in_expressao2340 = new BitSet(new long[]{0x007C100000000002L});
    public static final BitSet FOLLOW_44_in_expressao2354 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_50_in_expressao2362 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_51_in_expressao2370 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_52_in_expressao2378 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_53_in_expressao2386 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_54_in_expressao2394 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao2_in_expressao2406 = new BitSet(new long[]{0x007C100000000002L});
    public static final BitSet FOLLOW_expressao3_in_expressao22445 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_55_in_expressao22474 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_56_in_expressao22482 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao3_in_expressao22494 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_expressao4_in_expressao32528 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_expressao32549 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_58_in_expressao32557 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao4_in_expressao32570 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_expressao5_in_expressao42604 = new BitSet(new long[]{0x7800000000000002L});
    public static final BitSet FOLLOW_59_in_expressao42612 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_60_in_expressao42620 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61_in_expressao42628 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62_in_expressao42636 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao5_in_expressao42643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao6_in_expressao52675 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_63_in_expressao52706 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao6_in_expressao52712 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_expressao52770 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao6_in_expressao52776 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao7_in_expressao62825 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_expressao62848 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_66_in_expressao62856 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_67_in_expressao62864 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao7_in_expressao62877 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_64_in_expressao72919 = new BitSet(new long[]{0x0000208378000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao72930 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao8_in_expressao72940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_expressao82974 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_expressao82980 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_expressao82982 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_referencia_in_expressao82992 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao83001 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao83011 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_expressao83024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_expressao83032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_referencia3152 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_referenciaVetorMatriz3260 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3266 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_referenciaVetorMatriz3268 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_referenciaVetorMatriz3271 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3277 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_referenciaVetorMatriz3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_chamadaFuncao3311 = new BitSet(new long[]{0x000060837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3318 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_chamadaFuncao3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3357 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_listaParametros3373 = new BitSet(new long[]{0x000020837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3379 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_vetor3467 = new BitSet(new long[]{0x000023837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3473 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_vetor3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_matriz3512 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3520 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_matriz3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_listaListaExpressoes3556 = new BitSet(new long[]{0x000023837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3562 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_listaListaExpressoes3564 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_listaListaExpressoes3579 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_listaListaExpressoes3582 = new BitSet(new long[]{0x000023837C000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3588 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_listaListaExpressoes3590 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3636 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_listaExpressoes3650 = new BitSet(new long[]{0x000022837C000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3657 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_39_in_synpred1_Portugol1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred2_Portugol2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred3_Portugol2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred4_Portugol2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred5_Portugol3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred6_Portugol3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred7_Portugol3416 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred7_Portugol3418 = new BitSet(new long[]{0x0000000000000002L});

}