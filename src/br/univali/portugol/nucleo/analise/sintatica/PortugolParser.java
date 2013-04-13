// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2013-04-13 06:08:10


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PR_PROGRAMA", "PR_REAL", "PR_VAZIO", "PR_LOGICO", "PR_CADEIA", "PR_INTEIRO", "PR_CARACTER", "PR_ESCOLHA", "PR_CASO", "PR_CONTRARIO", "PR_CONST", "PR_FUNCAO", "PR_RETORNE", "PR_PARA", "PR_PARE", "PR_FACA", "PR_ENQUANTO", "PR_SE", "PR_SENAO", "PR_INCLUA", "PR_BIBLIOTECA", "GAMBIARRA", "PR_FALSO", "PR_VERDADEIRO", "OPERADOR_NAO", "LOGICO", "ID", "ID_BIBLIOTECA", "INTEIRO", "REAL", "SEQ_ESC", "CADEIA", "CARACTER", "ESPACO", "DIGIT_HEX", "ESC_UNICODE", "ESC_OCTAL", "COMENTARIO", "'{'", "'}'", "'-->'", "','", "'['", "']'", "'='", "'('", "')'", "'&'", "';'", "':'", "'+='", "'-='", "'/='", "'*='", "'%='", "'e'", "'ou'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'"
    };
    public static final int EOF=-1;
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
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
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
    public static final int PR_INCLUA=23;
    public static final int PR_BIBLIOTECA=24;
    public static final int GAMBIARRA=25;
    public static final int PR_FALSO=26;
    public static final int PR_VERDADEIRO=27;
    public static final int OPERADOR_NAO=28;
    public static final int LOGICO=29;
    public static final int ID=30;
    public static final int ID_BIBLIOTECA=31;
    public static final int INTEIRO=32;
    public static final int REAL=33;
    public static final int SEQ_ESC=34;
    public static final int CADEIA=35;
    public static final int CARACTER=36;
    public static final int ESPACO=37;
    public static final int DIGIT_HEX=38;
    public static final int ESC_UNICODE=39;
    public static final int ESC_OCTAL=40;
    public static final int COMENTARIO=41;

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
    			NoOperacao operacao = FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);			
    			operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
    			
    			return operacao;
    		}
    		
    		else return operandoEsquerdo;
    	}



    // $ANTLR start "parse"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:202:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;

        ArvoreSintaticaAbstrata prog = null;


        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:202:43: (prog= programa )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:204:2: prog= programa
            {
            pushFollow(FOLLOW_programa_in_parse903);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:211:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;


        	pilhaContexto.push("programa");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:214:2: ( PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:216:2: PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            match(input,PR_PROGRAMA,FOLLOW_PR_PROGRAMA_in_programa925); if (state.failed) return asa;
            match(input,42,FOLLOW_42_in_programa928); if (state.failed) return asa;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              		 		asa = new ArvoreSintaticaAbstrataPrograma();
              				asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
              				((ArvoreSintaticaAbstrataPrograma) asa).setListaInclusoesBibliotecas(new ArrayList<NoInclusaoBiblioteca>());
              			}
              		 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:4: ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PR_INCLUA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:4: inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa]
            	    {
            	    pushFollow(FOLLOW_inclusaoBiblioteca_in_programa943);
            	    inclusaoBiblioteca((ArvoreSintaticaAbstrataPrograma ) asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PR_REAL||(LA2_0>=PR_LOGICO && LA2_0<=PR_CARACTER)||LA2_0==PR_CONST) ) {
                    alt2=1;
                }
                else if ( (LA2_0==PR_FUNCAO) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_programa951);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_programa956);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_programa962); if (state.failed) return asa;

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


    // $ANTLR start "inclusaoBiblioteca"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:1: inclusaoBiblioteca[ArvoreSintaticaAbstrataPrograma asa] : incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? ;
    public final void inclusaoBiblioteca(ArvoreSintaticaAbstrataPrograma asa) throws RecognitionException {
        Token incl=null;
        Token nome=null;
        Token alias=null;


        	pilhaContexto.push("inclusaoBiblioteca");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:240:2: (incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:2: incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )?
            {
            incl=(Token)match(input,PR_INCLUA,FOLLOW_PR_INCLUA_in_inclusaoBiblioteca985); if (state.failed) return ;
            match(input,PR_BIBLIOTECA,FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca987); if (state.failed) return ;
            nome=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca993); if (state.failed) return ;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:43: ( '-->' alias= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:44: '-->' alias= ID
                    {
                    match(input,44,FOLLOW_44_in_inclusaoBiblioteca996); if (state.failed) return ;
                    alias=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca1003); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			NoInclusaoBiblioteca noInclusaoBiblioteca = new NoInclusaoBiblioteca();

              			noInclusaoBiblioteca.setNome(nome.getText());
              			noInclusaoBiblioteca.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(nome));
              			
              			if (alias != null)
              			{
              				noInclusaoBiblioteca.setAlias(alias.getText());
              				noInclusaoBiblioteca.setTrechoCodigoFonteAlias(criarTrechoCodigoFonte(alias));
              			}
              			
              			int linha = incl.getLine();
              			int coluna = incl.getCharPositionInLine();
              			int tamanho = coluna;
              			
              			if (alias != null)
              			{
              				tamanho = tamanho - alias.getCharPositionInLine() + alias.getText().length();
              			}
              			
              			else tamanho = tamanho - nome.getCharPositionInLine() + nome.getText().length();
              			
              			noInclusaoBiblioteca.setTrechoCodigoFonte(new TrechoCodigoFonte(linha, coluna, tamanho));
              			
              			asa.getListaInclusoesBibliotecas().add(noInclusaoBiblioteca);
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
    // $ANTLR end "inclusaoBiblioteca"


    // $ANTLR start "declaracoesGlobais"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:278:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesGlobais");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:281:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:283:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais1034);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:306:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesLocais");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:309:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:311:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais1062);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:329:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;

        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado = null;

        NoDeclaracao vDeclaracao = null;



        	pilhaContexto.push("listaDeclaracoes");
        	listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:333:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:334:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:334:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:335:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {
              tokenConst = null; 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:337:2: (tokenConst= PR_CONST )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PR_CONST) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:337:3: tokenConst= PR_CONST
                    {
                    tokenConst=(Token)match(input,PR_CONST,FOLLOW_PR_CONST_in_listaDeclaracoes1099); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }

            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1107);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:339:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:339:4: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1118);
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

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:350:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==45) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:350:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,45,FOLLOW_45_in_listaDeclaracoes1140); if (state.failed) return listaDeclaracoes;
            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1146);
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
            	    break loop5;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:368:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:371:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao1185); if (state.failed) return declaracao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==46) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,46,FOLLOW_46_in_declaracao1192); if (state.failed) return declaracao;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:17: (ind1= expressao )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=OPERADOR_NAO && LA6_0<=REAL)||(LA6_0>=CADEIA && LA6_0<=CARACTER)||LA6_0==42||LA6_0==49||LA6_0==68) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao1199);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }

                    match(input,47,FOLLOW_47_in_declaracao1203); if (state.failed) return declaracao;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==46) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,46,FOLLOW_46_in_declaracao1210); if (state.failed) return declaracao;
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:52: (ind2= expressao )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( ((LA7_0>=OPERADOR_NAO && LA7_0<=REAL)||(LA7_0>=CADEIA && LA7_0<=CARACTER)||LA7_0==42||LA7_0==49||LA7_0==68) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao1217);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }

                            match(input,47,FOLLOW_47_in_declaracao1221); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:80: ( '=' inicializacao= expressao )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==48) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:81: '=' inicializacao= expressao
                    {
                    match(input,48,FOLLOW_48_in_declaracao1228); if (state.failed) return declaracao;
                    pushFollow(FOLLOW_expressao_in_declaracao1234);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token tokenTipoDado=null;


        	pilhaContexto.push("declaracaoTipoDado");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:409:2: ( (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
            int alt11=5;
            switch ( input.LA(1) ) {
            case PR_INTEIRO:
                {
                alt11=1;
                }
                break;
            case PR_REAL:
                {
                alt11=2;
                }
                break;
            case PR_CARACTER:
                {
                alt11=3;
                }
                break;
            case PR_CADEIA:
                {
                alt11=4;
                }
                break;
            case PR_LOGICO:
                {
                alt11=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return informacaoTipoDado;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:3: tokenTipoDado= PR_INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,PR_INTEIRO,FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1269); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:32: tokenTipoDado= PR_REAL
                    {
                    tokenTipoDado=(Token)match(input,PR_REAL,FOLLOW_PR_REAL_in_declaracaoTipoDado1277); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:58: tokenTipoDado= PR_CARACTER
                    {
                    tokenTipoDado=(Token)match(input,PR_CARACTER,FOLLOW_PR_CARACTER_in_declaracaoTipoDado1285); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:88: tokenTipoDado= PR_CADEIA
                    {
                    tokenTipoDado=(Token)match(input,PR_CADEIA,FOLLOW_PR_CADEIA_in_declaracaoTipoDado1293); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:116: tokenTipoDado= PR_LOGICO
                    {
                    tokenTipoDado=(Token)match(input,PR_LOGICO,FOLLOW_PR_LOGICO_in_declaracaoTipoDado1301); if (state.failed) return informacaoTipoDado;

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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:427:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token PR_VAZIO2=null;


        	pilhaContexto.push("declaracaoTipoDadoVazio");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:430:2: ( PR_VAZIO )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:432:2: PR_VAZIO
            {
            PR_VAZIO2=(Token)match(input,PR_VAZIO,FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1328); if (state.failed) return informacaoTipoDado;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:449:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;

        Token tk1=null;
        Token tk2=null;


        	pilhaContexto.push("quantificador");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:452:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==46) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,46,FOLLOW_46_in_quantificador1360); if (state.failed) return quantificador;
                    match(input,47,FOLLOW_47_in_quantificador1362); if (state.failed) return quantificador;
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:17: (tk2= '[' ']' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==46) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,46,FOLLOW_46_in_quantificador1369); if (state.failed) return quantificador;
                            match(input,47,FOLLOW_47_in_quantificador1371); if (state.failed) return quantificador;

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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:472:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        InformacaoTipoDado informacao = null;



        	pilhaContexto.push("tipoRetornoFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:475:2: ( (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==PR_REAL||(LA14_0>=PR_LOGICO && LA14_0<=PR_CARACTER)) ) {
                alt14=1;
            }
            else if ( (LA14_0==PR_VAZIO) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1407);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1415);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:497:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;

        List<NoDeclaracaoParametro> vListaParametros = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("declaracaoFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:500:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:502:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,PR_FUNCAO,FOLLOW_PR_FUNCAO_in_declaracaoFuncao1442); if (state.failed) return ;
            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1452);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1461);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;
            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1468); if (state.failed) return ;
            match(input,49,FOLLOW_49_in_declaracaoFuncao1470); if (state.failed) return ;
            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1476);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;
            match(input,50,FOLLOW_50_in_declaracaoFuncao1478); if (state.failed) return ;
            match(input,42,FOLLOW_42_in_declaracaoFuncao1498); if (state.failed) return ;
            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1506);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;
            match(input,43,FOLLOW_43_in_declaracaoFuncao1516); if (state.failed) return ;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:533:1: listaParametrosFuncao returns [List<NoDeclaracaoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoDeclaracaoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoDeclaracaoParametro> listaParametros = null;

        NoDeclaracaoParametro vDeclaracaoParametro = null;



        	pilhaContexto.push("listaParametrosFuncao");
        	listaParametros = new ArrayList<NoDeclaracaoParametro>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:537:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PR_REAL||(LA16_0>=PR_LOGICO && LA16_0<=PR_CARACTER)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1571);
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

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:548:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:548:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,45,FOLLOW_45_in_listaParametrosFuncao1599); if (state.failed) return listaParametros;
                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1605);
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
                    	    break loop15;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:564:1: declaracaoParametro returns [NoDeclaracaoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoDeclaracaoParametro declaracaoParametro() throws RecognitionException {
        NoDeclaracaoParametro parametro = null;

        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;



        	pilhaContexto.push("declaracaoParametro");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:567:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1652);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:42: (tkr= '&' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==51) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:43: tkr= '&'
                    {
                    tkr=(Token)match(input,51,FOLLOW_51_in_declaracaoParametro1659); if (state.failed) return parametro;

                    }
                    break;

            }

            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1663); if (state.failed) return parametro;
            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1669);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:600:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("blocos");
        	blocos = new ArrayList<NoBloco>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:604:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:605:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:605:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PR_ESCOLHA||(LA18_0>=PR_RETORNE && LA18_0<=PR_SE)||(LA18_0>=OPERADOR_NAO && LA18_0<=REAL)||(LA18_0>=CADEIA && LA18_0<=CARACTER)||LA18_0==42||LA18_0==49||LA18_0==68) ) {
                    alt18=1;
                }
                else if ( (LA18_0==PR_REAL||(LA18_0>=PR_LOGICO && LA18_0<=PR_CARACTER)||LA18_0==PR_CONST) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:606:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1701);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;
            	    if ( state.backtracking==0 ) {
            	       blocos.add(vBloco); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:606:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1707);
            	    declaracoesLocais(blocos);

            	    state._fsp--;
            	    if (state.failed) return blocos;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:615:1: bloco returns [NoBloco bloco] : (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) ;
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:618:2: ( (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:619:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:619:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
            int alt19=8;
            switch ( input.LA(1) ) {
            case OPERADOR_NAO:
            case LOGICO:
            case ID:
            case ID_BIBLIOTECA:
            case INTEIRO:
            case REAL:
            case CADEIA:
            case CARACTER:
            case 42:
            case 49:
            case 68:
                {
                alt19=1;
                }
                break;
            case PR_PARA:
                {
                alt19=2;
                }
                break;
            case PR_PARE:
                {
                alt19=3;
                }
                break;
            case PR_RETORNE:
                {
                alt19=4;
                }
                break;
            case PR_SE:
                {
                alt19=5;
                }
                break;
            case PR_ENQUANTO:
                {
                alt19=6;
                }
                break;
            case PR_FACA:
                {
                alt19=7;
                }
                break;
            case PR_ESCOLHA:
                {
                alt19=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return bloco;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:620:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1741);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vExpressao; 	
                    }

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:621:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1756);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPara; 	 	
                    }

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:622:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1774);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPare; 	 	
                    }

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:623:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1791);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vRetorne; 	 	
                    }

                    }
                    break;
                case 5 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:624:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1807);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vSe; 		
                    }

                    }
                    break;
                case 6 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:625:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1824);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEnquanto;		
                    }

                    }
                    break;
                case 7 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:626:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1838);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vFacaEnquanto; 	
                    }

                    }
                    break;
                case 8 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:627:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1852);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:636:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;

        NoBloco inicializacao = null;

        NoExpressao condicao = null;

        NoExpressao incremento = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("para");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:639:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
            match(input,PR_PARA,FOLLOW_PR_PARA_in_para1884); if (state.failed) return para;
            match(input,49,FOLLOW_49_in_para1886); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:14: (inicializacao= inicializacaoPara )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==PR_REAL||(LA20_0>=PR_LOGICO && LA20_0<=PR_CARACTER)||LA20_0==PR_CONST||(LA20_0>=OPERADOR_NAO && LA20_0<=REAL)||(LA20_0>=CADEIA && LA20_0<=CARACTER)||LA20_0==42||LA20_0==49||LA20_0==68) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:15: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1893);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_para1897); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:55: (condicao= expressao )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=OPERADOR_NAO && LA21_0<=REAL)||(LA21_0>=CADEIA && LA21_0<=CARACTER)||LA21_0==42||LA21_0==49||LA21_0==68) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:56: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1904);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_para1908); if (state.failed) return para;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:83: (incremento= expressao )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=OPERADOR_NAO && LA22_0<=REAL)||(LA22_0>=CADEIA && LA22_0<=CARACTER)||LA22_0==42||LA22_0==49||LA22_0==68) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:84: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1915);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,50,FOLLOW_50_in_para1919); if (state.failed) return para;
            pushFollow(FOLLOW_listaBlocos_in_para1925);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:659:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;

        NoExpressao vExpressao = null;

        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("inicializacaoPara");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:662:2: ( (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=OPERADOR_NAO && LA23_0<=REAL)||(LA23_0>=CADEIA && LA23_0<=CARACTER)||LA23_0==42||LA23_0==49||LA23_0==68) ) {
                alt23=1;
            }
            else if ( (LA23_0==PR_REAL||(LA23_0>=PR_LOGICO && LA23_0<=PR_CARACTER)||LA23_0==PR_CONST) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return bloco;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1956);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1964);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:680:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vListaBlocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("listaBlocos");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:683:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:684:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:684:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,42,FOLLOW_42_in_listaBlocos1997); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_listaBlocos2003);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    if ( state.backtracking==0 ) {
                       listaBlocos = vListaBlocos; 
                    }
                    match(input,43,FOLLOW_43_in_listaBlocos2007); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:689:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos2023);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:705:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;


        	pilhaContexto.push("pare");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:708:2: ( PR_PARE )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:710:2: PR_PARE
            {
            match(input,PR_PARE,FOLLOW_PR_PARE_in_pare2051); if (state.failed) return pare;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:725:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;

        NoExpressao vExpressaoEscolha = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("escolha");
        	List<NoCaso> casos =  new ArrayList<NoCaso>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:729:2: ( PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:731:2: PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}'
            {
            match(input,PR_ESCOLHA,FOLLOW_PR_ESCOLHA_in_escolha2078); if (state.failed) return escolha;
            match(input,49,FOLLOW_49_in_escolha2080); if (state.failed) return escolha;
            pushFollow(FOLLOW_expressao_in_escolha2086);
            vExpressaoEscolha=expressao();

            state._fsp--;
            if (state.failed) return escolha;
            match(input,50,FOLLOW_50_in_escolha2088); if (state.failed) return escolha;
            match(input,42,FOLLOW_42_in_escolha2091); if (state.failed) return escolha;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:734:3: ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PR_CASO) ) {
                    int LA25_1 = input.LA(2);

                    if ( ((LA25_1>=OPERADOR_NAO && LA25_1<=REAL)||(LA25_1>=CADEIA && LA25_1<=CARACTER)||LA25_1==42||LA25_1==49||LA25_1==68) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:734:4: PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso
            	    {
            	    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2100); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_expressao_in_escolha2106);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return escolha;
            	    match(input,53,FOLLOW_53_in_escolha2108); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_blocosCaso_in_escolha2114);
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
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return escolha;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:746:4: ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PR_CASO) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:746:5: PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso
                    {
                    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2129); if (state.failed) return escolha;
                    match(input,PR_CONTRARIO,FOLLOW_PR_CONTRARIO_in_escolha2131); if (state.failed) return escolha;
                    match(input,53,FOLLOW_53_in_escolha2133); if (state.failed) return escolha;
                    pushFollow(FOLLOW_blocosCaso_in_escolha2139);
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

            match(input,43,FOLLOW_43_in_escolha2153); if (state.failed) return escolha;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:774:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("blocosCaso");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:777:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:12: ( '{' vBlocos= blocos '}' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:13: '{' vBlocos= blocos '}'
                    {
                    match(input,42,FOLLOW_42_in_blocosCaso2189); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_blocosCaso2195);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    match(input,43,FOLLOW_43_in_blocosCaso2197); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:41: (vBlocos= blocos )
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:41: (vBlocos= blocos )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso2207);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:790:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;



        	pilhaContexto.push("enquanto");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:793:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:795:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_enquanto2236); if (state.failed) return enquanto;
            match(input,49,FOLLOW_49_in_enquanto2238); if (state.failed) return enquanto;
            pushFollow(FOLLOW_expressao_in_enquanto2244);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;
            match(input,50,FOLLOW_50_in_enquanto2246); if (state.failed) return enquanto;
            pushFollow(FOLLOW_listaBlocos_in_enquanto2252);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:810:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;

        List<NoBloco> vListaBlocos = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("facaEnquanto");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:813:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:815:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,PR_FACA,FOLLOW_PR_FACA_in_facaEnquanto2278); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2284);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_facaEnquanto2286); if (state.failed) return facaEnquanto;
            match(input,49,FOLLOW_49_in_facaEnquanto2288); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_expressao_in_facaEnquanto2294);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,50,FOLLOW_50_in_facaEnquanto2296); if (state.failed) return facaEnquanto;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:831:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;

        List<NoBloco> listaBlocosSenao = null;



        	pilhaContexto.push("se");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:834:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:836:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,PR_SE,FOLLOW_PR_SE_in_se2324); if (state.failed) return se;
            match(input,49,FOLLOW_49_in_se2326); if (state.failed) return se;
            pushFollow(FOLLOW_expressao_in_se2332);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;
            match(input,50,FOLLOW_50_in_se2334); if (state.failed) return se;
            pushFollow(FOLLOW_listaBlocos_in_se2340);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:836:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PR_SENAO) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:836:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,PR_SENAO,FOLLOW_PR_SENAO_in_se2343); if (state.failed) return se;
                    pushFollow(FOLLOW_listaBlocos_in_se2349);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:852:1: retorne returns [NoRetorne retorne] : PR_RETORNE vExpressao= expressao ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("retorne");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:855:2: ( PR_RETORNE vExpressao= expressao )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:857:2: PR_RETORNE vExpressao= expressao
            {
            match(input,PR_RETORNE,FOLLOW_PR_RETORNE_in_retorne2378); if (state.failed) return retorne;
            pushFollow(FOLLOW_expressao_in_retorne2384);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return retorne;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:871:1: pilha returns [Stack<Object> pilha] : ;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:871:35: ()
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:872:1: 
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:878:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        Stack<Object> vPilha = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:881:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:883:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2428);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;
            pushFollow(FOLLOW_pilha_in_expressao2434);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {
               vPilha.push(operandoEsquerdo); 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:884:2: ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==48||(LA30_0>=54 && LA30_0<=58)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' )
            	    int alt29=6;
            	    switch ( input.LA(1) ) {
            	    case 48:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case 55:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt29=4;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt29=5;
            	        }
            	        break;
            	    case 58:
            	        {
            	        alt29=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:4: operador= '='
            	            {
            	            operador=(Token)match(input,48,FOLLOW_48_in_expressao2448); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:21: operador= '+='
            	            {
            	            operador=(Token)match(input,54,FOLLOW_54_in_expressao2456); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:39: operador= '-='
            	            {
            	            operador=(Token)match(input,55,FOLLOW_55_in_expressao2464); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:57: operador= '/='
            	            {
            	            operador=(Token)match(input,56,FOLLOW_56_in_expressao2472); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:75: operador= '*='
            	            {
            	            operador=(Token)match(input,57,FOLLOW_57_in_expressao2480); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:93: operador= '%='
            	            {
            	            operador=(Token)match(input,58,FOLLOW_58_in_expressao2488); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao2_in_expressao2500);
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
            	    break loop30;
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
              				
              				operandoDireito = FabricaNoOperacao.novoNo(operador.getText().substring(0, 1), operandoEsquerdo, operandoDireito);				   
              				NoOperacao operacao = FabricaNoOperacao.novoNo("=", operandoEsquerdo, operandoDireito);			
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:923:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao2");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:926:2: (operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:928:2: operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao22539);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:929:2: ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=59 && LA32_0<=60)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:930:3: (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		
            	      			if (gerarArvore)
            	      			{
            	      				if (operandoDireito != null)
            	      				{
            	      					NoOperacao operacao = FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);
            	      					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	      				 	operandoEsquerdo = operacao; 
            	      				 }
            	      			 }
            	      		
            	    }
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:943:3: (operador= 'e' | operador= 'ou' )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==59) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==60) ) {
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
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:943:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,59,FOLLOW_59_in_expressao22568); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:943:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,60,FOLLOW_60_in_expressao22576); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao3_in_expressao22588);
            	    operandoDireito=expressao3();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:960:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao3");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:963:2: (operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:965:2: operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32622);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:966:2: ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=61 && LA34_0<=62)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:967:3: (operador= '==' | operador= '!=' ) operandoDireito= expressao4
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (gerarArvore)
            	      			{
            	      		
            	      				if (operandoDireito != null)
            	      				{
            	      					NoOperacao operacao = FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);
            	      					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	      				 	operandoEsquerdo = operacao; 
            	      				 }
            	      			 }
            	      		
            	    }
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:980:3: (operador= '==' | operador= '!=' )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==61) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==62) ) {
            	        alt33=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:980:4: operador= '=='
            	            {
            	            operador=(Token)match(input,61,FOLLOW_61_in_expressao32643); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:980:22: operador= '!='
            	            {
            	            operador=(Token)match(input,62,FOLLOW_62_in_expressao32651); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao4_in_expressao32664);
            	    operandoDireito=expressao4();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:997:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao4");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1000:2: (operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:2: operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            {
            pushFollow(FOLLOW_expressao5_in_expressao42698);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:32: ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=63 && LA36_0<=66)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' )
                    int alt35=4;
                    switch ( input.LA(1) ) {
                    case 63:
                        {
                        alt35=1;
                        }
                        break;
                    case 64:
                        {
                        alt35=2;
                        }
                        break;
                    case 65:
                        {
                        alt35=3;
                        }
                        break;
                    case 66:
                        {
                        alt35=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return expressao;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }

                    switch (alt35) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:34: operador= '>='
                            {
                            operador=(Token)match(input,63,FOLLOW_63_in_expressao42706); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:52: operador= '<='
                            {
                            operador=(Token)match(input,64,FOLLOW_64_in_expressao42714); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:70: operador= '<'
                            {
                            operador=(Token)match(input,65,FOLLOW_65_in_expressao42722); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:87: operador= '>'
                            {
                            operador=(Token)match(input,66,FOLLOW_66_in_expressao42730); if (state.failed) return expressao;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expressao5_in_expressao42737);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1016:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao5");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1021:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao52769);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1022:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            loop37:
            do {
                int alt37=3;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1023:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1023:3: (operador= '+' operandoDireito= expressao6 )
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1025:4: operador= '+' operandoDireito= expressao6
            	    {
            	    if ( state.backtracking==0 ) {

            	      				if (gerarArvore)
            	      				{
            	      					if (operandoDireito != null)
            	      					{
            	      						NoOperacao operacao =  FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);
            	      						operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	      					 	operandoEsquerdo = operacao; 
            	      					 }
            	      				 }
            	      			
            	    }
            	    operador=(Token)match(input,67,FOLLOW_67_in_expressao52800); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52806);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1042:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    {
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1042:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1044:5: ( '-' )=>operador= '-' operandoDireito= expressao6
            	    {
            	    if ( state.backtracking==0 ) {

            	      				if (gerarArvore)
            	      				{
            	      					if (operandoDireito != null)
            	      					{
            	      						NoOperacao operacao = FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);
            	      						operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	      					 	operandoEsquerdo = operacao; 
            	      					 }
            	      				 }
            	      			
            	    }
            	    operador=(Token)match(input,68,FOLLOW_68_in_expressao52864); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52870);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1077:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao6");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1080:2: (operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1082:2: operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao62919);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1083:2: ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=69 && LA39_0<=71)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1084:3: (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (gerarArvore)
            	      			{
            	      				if (operandoDireito != null)
            	      				{
            	      					NoOperacao operacao = FabricaNoOperacao.novoNo(operador.getText(), operandoEsquerdo, operandoDireito);
            	      					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
            	      				 	operandoEsquerdo = operacao; 
            	      				 }
            	      			 }
            	      		
            	    }
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1097:3: (operador= '*' | operador= '/' | operador= '%' )
            	    int alt38=3;
            	    switch ( input.LA(1) ) {
            	    case 69:
            	        {
            	        alt38=1;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt38=2;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt38=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt38) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1097:4: operador= '*'
            	            {
            	            operador=(Token)match(input,69,FOLLOW_69_in_expressao62942); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1097:21: operador= '/'
            	            {
            	            operador=(Token)match(input,70,FOLLOW_70_in_expressao62950); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1097:38: operador= '%'
            	            {
            	            operador=(Token)match(input,71,FOLLOW_71_in_expressao62958); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao7_in_expressao62971);
            	    operandoDireito=expressao7();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1114:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;

        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao7");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1117:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:12: (listaTokenMenos+= '-' )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==68) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,68,FOLLOW_68_in_expressao73013); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:40: (listaTokenNao+= OPERADOR_NAO )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==OPERADOR_NAO) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:41: listaTokenNao+= OPERADOR_NAO
                    	    {
                    	    listaTokenNao=(Token)match(input,OPERADOR_NAO,FOLLOW_OPERADOR_NAO_in_expressao73024); if (state.failed) return expressao;
                    	    if (list_listaTokenNao==null) list_listaTokenNao=new ArrayList();
                    	    list_listaTokenNao.add(listaTokenNao);


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_expressao8_in_expressao73034);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1143:1: expressao8 returns [NoExpressao expressao] : (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;

        Token parentesis=null;
        Token operador=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao8");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1146:2: ( (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1148:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )?
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1148:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor )
            int alt43=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt43=1;
                }
                break;
            case ID:
            case ID_BIBLIOTECA:
                {
                alt43=2;
                }
                break;
            case LOGICO:
            case INTEIRO:
            case REAL:
            case CADEIA:
            case CARACTER:
                {
                alt43=3;
                }
                break;
            case 42:
                {
                alt43=4;
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1148:4: parentesis= '(' vExpressao= expressao ')'
                    {
                    parentesis=(Token)match(input,49,FOLLOW_49_in_expressao83068); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_expressao83074);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,50,FOLLOW_50_in_expressao83076); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1149:4: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao83086);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1150:4: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao83095);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1151:4: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao83105);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1153:3: (operador= '++' | operador= '--' )?
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==72) ) {
                alt44=1;
            }
            else if ( (LA44_0==73) ) {
                alt44=2;
            }
            switch (alt44) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1153:4: operador= '++'
                    {
                    operador=(Token)match(input,72,FOLLOW_72_in_expressao83118); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1153:22: operador= '--'
                    {
                    operador=(Token)match(input,73,FOLLOW_73_in_expressao83126); if (state.failed) return expressao;

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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1181:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;

        Token REAL5=null;
        Token LOGICO6=null;
        Token CADEIA7=null;
        Token INTEIRO8=null;
        Token CARACTER9=null;


        	pilhaContexto.push("tipoPrimitivo");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1184:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt45=5;
            switch ( input.LA(1) ) {
            case REAL:
                {
                alt45=1;
                }
                break;
            case LOGICO:
                {
                alt45=2;
                }
                break;
            case CADEIA:
                {
                alt45=3;
                }
                break;
            case INTEIRO:
                {
                alt45=4;
                }
                break;
            case CARACTER:
                {
                alt45=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1186:2: REAL
                    {
                    REAL5=(Token)match(input,REAL,FOLLOW_REAL_in_tipoPrimitivo3155); if (state.failed) return expressao;
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1198:2: LOGICO
                    {
                    LOGICO6=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_tipoPrimitivo3175); if (state.failed) return expressao;
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1210:2: CADEIA
                    {
                    CADEIA7=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_tipoPrimitivo3189); if (state.failed) return expressao;
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1223:2: INTEIRO
                    {
                    INTEIRO8=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_tipoPrimitivo3202); if (state.failed) return expressao;
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1244:2: CARACTER
                    {
                    CARACTER9=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_tipoPrimitivo3217); if (state.failed) return expressao;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1260:1: referencia returns [NoReferencia referencia] : (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;

        Token id=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("referencia");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1263:2: ( (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1265:2: (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1265:2: (id= ID | id= ID_BIBLIOTECA )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==ID) ) {
                alt46=1;
            }
            else if ( (LA46_0==ID_BIBLIOTECA) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return referencia;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1265:3: id= ID
                    {
                    id=(Token)match(input,ID,FOLLOW_ID_in_referencia3251); if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1265:13: id= ID_BIBLIOTECA
                    {
                    id=(Token)match(input,ID_BIBLIOTECA,FOLLOW_ID_BIBLIOTECA_in_referencia3259); if (state.failed) return referencia;

                    }
                    break;

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1266:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )
            int alt47=3;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1267:3: ( '(' )=>vExpressao= chamadaFuncao[$id.getText()]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia3277);
                    vExpressao=chamadaFuncao(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1268:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia3294);
                    vExpressao=referenciaVetorMatriz(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1269:5: vExpressao= referenciaId[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia3307);
                    vExpressao=referenciaId(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			referencia = (NoReferencia) vExpressao;
              			referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte(id));
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1286:1: referenciaId[String nome] returns [NoExpressao expressao] : ;
    public final NoExpressao referenciaId(String nome) throws RecognitionException {
        NoExpressao expressao = null;


        	pilhaContexto.push("referenciaId");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1289:2: ()
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1291:2: 
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1305:1: referenciaVetorMatriz[ String nome] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String nome) throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao indice1 = null;

        NoExpressao indice2 = null;



        	pilhaContexto.push("referenciaVetorMatriz");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1308:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1310:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,46,FOLLOW_46_in_referenciaVetorMatriz3368); if (state.failed) return expressao;
            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3374);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,47,FOLLOW_47_in_referenciaVetorMatriz3376); if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1310:30: ( '[' indice2= expressao ']' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==46) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1310:31: '[' indice2= expressao ']'
                    {
                    match(input,46,FOLLOW_46_in_referenciaVetorMatriz3379); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3385);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,47,FOLLOW_47_in_referenciaVetorMatriz3387); if (state.failed) return expressao;

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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1326:1: chamadaFuncao[String nome] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String nome) throws RecognitionException {
        NoExpressao expressao = null;

        List<NoExpressao> vListaParametros = null;



        	pilhaContexto.push("chamadaFuncao");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1329:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1331:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,49,FOLLOW_49_in_chamadaFuncao3419); if (state.failed) return expressao;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1331:6: (vListaParametros= listaParametros )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=OPERADOR_NAO && LA49_0<=REAL)||(LA49_0>=CADEIA && LA49_0<=CARACTER)||LA49_0==42||LA49_0==49||LA49_0==68) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1331:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3426);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            match(input,50,FOLLOW_50_in_chamadaFuncao3430); if (state.failed) return expressao;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1348:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaParametros");
        	listaParametros = new ArrayList<NoExpressao>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1352:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1353:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1353:2: (vExpressao= expressao )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1353:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3465);
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

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1362:2: ( ',' vExpressao= expressao )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==45) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1362:3: ',' vExpressao= expressao
            	    {
            	    match(input,45,FOLLOW_45_in_listaParametros3481); if (state.failed) return listaParametros;
            	    pushFollow(FOLLOW_expressao_in_listaParametros3487);
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
        return listaParametros;
    }
    // $ANTLR end "listaParametros"


    // $ANTLR start "matrizVetor"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1378:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("matrizVetor");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1381:2: ( ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==42) ) {
                int LA51_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt51=1;
                }
                else if ( (true) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3534);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3542);
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1398:1: vetor returns [NoExpressao expressao] : abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("vetor");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1401:2: (abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1403:2: abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,42,FOLLOW_42_in_vetor3575); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaExpressoes_in_vetor3581);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,43,FOLLOW_43_in_vetor3587); if (state.failed) return expressao;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1420:1: matriz returns [NoExpressao expressao] : abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<List<Object>> vListaListaExpressoes = null;



        	pilhaContexto.push("matriz");

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1423:2: (abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1425:2: abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,42,FOLLOW_42_in_matriz3620); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3628);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,43,FOLLOW_43_in_matriz3635); if (state.failed) return expressao;
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
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1445:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;

        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("listaListaExpressoes");
        	listaListaExpressoes = new ArrayList<List<Object>>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1449:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1450:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1450:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1450:4: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,42,FOLLOW_42_in_listaListaExpressoes3664); if (state.failed) return listaListaExpressoes;
            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3670);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;
            match(input,43,FOLLOW_43_in_listaListaExpressoes3672); if (state.failed) return listaListaExpressoes;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              				 listaListaExpressoes.add(vListaExpressoes); 
              			 }
              		
            }

            }

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1458:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==45) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1458:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) {
            	       vListaExpressoes = null; 
            	    }
            	    match(input,45,FOLLOW_45_in_listaListaExpressoes3687); if (state.failed) return listaListaExpressoes;
            	    match(input,42,FOLLOW_42_in_listaListaExpressoes3690); if (state.failed) return listaListaExpressoes;
            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3696);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;
            	    match(input,43,FOLLOW_43_in_listaListaExpressoes3698); if (state.failed) return listaListaExpressoes;
            	    if ( state.backtracking==0 ) {
            	       
            	      	   	if (gerarArvore)
            	      	   	{
            	      		   	listaListaExpressoes.add(vListaExpressoes); 
            	      	   	}
            	      	   
            	    }

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

            	pilhaContexto.pop();

        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"


    // $ANTLR start "listaExpressoes"
    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1474:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaExpressoes");
        	listaExpressoes = new ArrayList<Object>();

        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1478:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1479:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1479:2: ( (vExpressao= expressao )? )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1479:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) {
               vExpressao = null; 
            }
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1479:30: (vExpressao= expressao )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=OPERADOR_NAO && LA53_0<=REAL)||(LA53_0>=CADEIA && LA53_0<=CARACTER)||LA53_0==42||LA53_0==49||LA53_0==68) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1479:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3744);
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

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1486:2: ( ',' (vExpressao= expressao )? )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==45) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1486:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) {
            	       vExpressao = null; 
            	    }
            	    match(input,45,FOLLOW_45_in_listaExpressoes3758); if (state.failed) return listaExpressoes;
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1486:30: (vExpressao= expressao )?
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( ((LA54_0>=OPERADOR_NAO && LA54_0<=REAL)||(LA54_0>=CADEIA && LA54_0<=CARACTER)||LA54_0==42||LA54_0==49||LA54_0==68) ) {
            	        alt54=1;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1486:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes3765);
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
            	    break loop55;
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
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:2: ( '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:3: '{'
        {
        match(input,42,FOLLOW_42_in_synpred1_Portugol1993); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:4: ( '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:779:5: '{'
        {
        match(input,42,FOLLOW_42_in_synpred2_Portugol2184); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1044:5: ( '-' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1044:6: '-'
        {
        match(input,68,FOLLOW_68_in_synpred3_Portugol2836); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:3: ( '-' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1119:4: '-'
        {
        match(input,68,FOLLOW_68_in_synpred4_Portugol3003); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1267:3: ( '(' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1267:4: '('
        {
        match(input,49,FOLLOW_49_in_synpred5_Portugol3268); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1268:3: ( '[' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1268:4: '['
        {
        match(input,46,FOLLOW_46_in_synpred6_Portugol3285); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {   
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:3: ( '{' '{' )
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1383:4: '{' '{'
        {
        match(input,42,FOLLOW_42_in_synpred7_Portugol3524); if (state.failed) return ;
        match(input,42,FOLLOW_42_in_synpred7_Portugol3526); if (state.failed) return ;

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


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA24_eotS =
        "\24\uffff";
    static final String DFA24_eofS =
        "\24\uffff";
    static final String DFA24_minS =
        "\1\13\1\0\22\uffff";
    static final String DFA24_maxS =
        "\1\104\1\0\22\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\20\uffff\1\1";
    static final String DFA24_specialS =
        "\1\uffff\1\0\22\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\2\4\uffff\6\2\6\uffff\6\2\1\uffff\2\2\5\uffff\1\1\6\uffff"+
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
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "684:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Portugol()) ) {s = 19;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\34\uffff";
    static final String DFA27_eofS =
        "\34\uffff";
    static final String DFA27_minS =
        "\1\5\1\0\32\uffff";
    static final String DFA27_maxS =
        "\1\104\1\0\32\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\30\uffff\1\1";
    static final String DFA27_specialS =
        "\1\uffff\1\0\32\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\1\uffff\6\2\1\uffff\1\2\1\uffff\6\2\6\uffff\6\2\1\uffff"+
            "\2\2\5\uffff\1\1\1\2\5\uffff\1\2\22\uffff\1\2",
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
            return "779:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Portugol()) ) {s = 27;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\62\uffff";
    static final String DFA37_eofS =
        "\62\uffff";
    static final String DFA37_minS =
        "\1\5\31\uffff\1\0\27\uffff";
    static final String DFA37_maxS =
        "\1\104\31\uffff\1\0\27\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\3\56\uffff\1\1\1\2";
    static final String DFA37_specialS =
        "\32\uffff\1\0\27\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\1\uffff\6\1\1\uffff\11\1\5\uffff\6\1\1\uffff\2\1\5\uffff"+
            "\2\1\1\uffff\1\1\1\uffff\4\1\1\uffff\17\1\1\60\1\32",
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
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 1022:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_26 = input.LA(1);

                         
                        int index37_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Portugol()) ) {s = 49;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index37_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\14\uffff";
    static final String DFA42_eofS =
        "\14\uffff";
    static final String DFA42_minS =
        "\1\34\1\uffff\11\0\1\uffff";
    static final String DFA42_maxS =
        "\1\104\1\uffff\11\0\1\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\11\uffff\1\2";
    static final String DFA42_specialS =
        "\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\13\1\6\1\3\1\4\1\10\1\5\1\uffff\1\7\1\11\5\uffff\1\12\6\uffff"+
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
            "\1\uffff",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "1119:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_0 = input.LA(1);

                         
                        int index42_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_0==68) && (synpred4_Portugol())) {s = 1;}

                        else if ( (LA42_0==49) ) {s = 2;}

                        else if ( (LA42_0==ID) ) {s = 3;}

                        else if ( (LA42_0==ID_BIBLIOTECA) ) {s = 4;}

                        else if ( (LA42_0==REAL) ) {s = 5;}

                        else if ( (LA42_0==LOGICO) ) {s = 6;}

                        else if ( (LA42_0==CADEIA) ) {s = 7;}

                        else if ( (LA42_0==INTEIRO) ) {s = 8;}

                        else if ( (LA42_0==CARACTER) ) {s = 9;}

                        else if ( (LA42_0==42) ) {s = 10;}

                        else if ( (LA42_0==OPERADOR_NAO) ) {s = 11;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\70\uffff";
    static final String DFA47_eofS =
        "\70\uffff";
    static final String DFA47_minS =
        "\1\5\1\0\66\uffff";
    static final String DFA47_maxS =
        "\1\111\1\0\66\uffff";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\1\3\63\uffff\1\1";
    static final String DFA47_specialS =
        "\1\0\1\1\66\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\3\1\uffff\6\3\1\uffff\11\3\5\uffff\6\3\1\uffff\2\3\5\uffff"+
            "\2\3\1\uffff\1\3\1\2\2\3\1\1\1\3\1\uffff\26\3",
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
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "1266:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_0 = input.LA(1);

                         
                        int index47_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA47_0==49) ) {s = 1;}

                        else if ( (LA47_0==46) && (synpred6_Portugol())) {s = 2;}

                        else if ( (LA47_0==PR_REAL||(LA47_0>=PR_LOGICO && LA47_0<=PR_CASO)||(LA47_0>=PR_CONST && LA47_0<=PR_SENAO)||(LA47_0>=OPERADOR_NAO && LA47_0<=REAL)||(LA47_0>=CADEIA && LA47_0<=CARACTER)||(LA47_0>=42 && LA47_0<=43)||LA47_0==45||(LA47_0>=47 && LA47_0<=48)||LA47_0==50||(LA47_0>=52 && LA47_0<=73)) ) {s = 3;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_1 = input.LA(1);

                         
                        int index47_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Portugol()) ) {s = 55;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index47_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_programa_in_parse903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa925 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_programa928 = new BitSet(new long[]{0x000008000080C7A0L});
    public static final BitSet FOLLOW_inclusaoBiblioteca_in_programa943 = new BitSet(new long[]{0x000008000080C7A0L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa951 = new BitSet(new long[]{0x000008000000C7A0L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa956 = new BitSet(new long[]{0x000008000000C7A0L});
    public static final BitSet FOLLOW_43_in_programa962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INCLUA_in_inclusaoBiblioteca985 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca987 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca993 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_inclusaoBiblioteca996 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes1099 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1107 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1118 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaDeclaracoes1140 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1146 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao1185 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_46_in_declaracao1192 = new BitSet(new long[]{0x0002841BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_declaracao1199 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracao1203 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_46_in_declaracao1210 = new BitSet(new long[]{0x0002841BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_declaracao1217 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracao1221 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_declaracao1228 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_declaracao1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_quantificador1360 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_quantificador1362 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_quantificador1369 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_quantificador1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1442 = new BitSet(new long[]{0x00004000400047E0L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1452 = new BitSet(new long[]{0x0000400040000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1461 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1468 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_declaracaoFuncao1470 = new BitSet(new long[]{0x00040000000047A0L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1476 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_declaracaoFuncao1478 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_declaracaoFuncao1498 = new BitSet(new long[]{0x00020C1BF03F4FA0L,0x0000000000000010L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1506 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracaoFuncao1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1571 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaParametrosFuncao1599 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1605 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1652 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_51_in_declaracaoParametro1659 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1663 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1701 = new BitSet(new long[]{0x0002041BF03F4FA2L,0x0000000000000010L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1707 = new BitSet(new long[]{0x0002041BF03F4FA2L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_bloco1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARA_in_para1884 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_para1886 = new BitSet(new long[]{0x0012041BF00047A0L,0x0000000000000010L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1893 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_para1897 = new BitSet(new long[]{0x0012041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_para1904 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_para1908 = new BitSet(new long[]{0x0006041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_para1915 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_para1919 = new BitSet(new long[]{0x0002041BF03F0800L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaBlocos_in_para1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_listaBlocos1997 = new BitSet(new long[]{0x00020C1BF03F4FA0L,0x0000000000000010L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos2003 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaBlocos2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARE_in_pare2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha2078 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_escolha2080 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_escolha2086 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_escolha2088 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_escolha2091 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2100 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_escolha2106 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_escolha2108 = new BitSet(new long[]{0x0002041BF03F4FA0L,0x0000000000000010L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2114 = new BitSet(new long[]{0x0000080000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2129 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PR_CONTRARIO_in_escolha2131 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_escolha2133 = new BitSet(new long[]{0x0002041BF03F4FA0L,0x0000000000000010L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2139 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_escolha2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_blocosCaso2189 = new BitSet(new long[]{0x00020C1BF03F4FA0L,0x0000000000000010L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2195 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_blocosCaso2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto2236 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_enquanto2238 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_enquanto2244 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_enquanto2246 = new BitSet(new long[]{0x0002041BF03F0800L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto2278 = new BitSet(new long[]{0x0002041BF03F0800L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2284 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto2286 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_facaEnquanto2288 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2294 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_facaEnquanto2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_SE_in_se2324 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_se2326 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_se2332 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_se2334 = new BitSet(new long[]{0x0002041BF03F0800L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaBlocos_in_se2340 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PR_SENAO_in_se2343 = new BitSet(new long[]{0x0002041BF03F0800L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaBlocos_in_se2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2378 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_retorne2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2428 = new BitSet(new long[]{0x07C1000000000000L});
    public static final BitSet FOLLOW_pilha_in_expressao2434 = new BitSet(new long[]{0x07C1000000000002L});
    public static final BitSet FOLLOW_48_in_expressao2448 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_54_in_expressao2456 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_expressao2464 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_56_in_expressao2472 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_57_in_expressao2480 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_58_in_expressao2488 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao2_in_expressao2500 = new BitSet(new long[]{0x07C1000000000002L});
    public static final BitSet FOLLOW_expressao3_in_expressao22539 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_59_in_expressao22568 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_60_in_expressao22576 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao3_in_expressao22588 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_expressao4_in_expressao32622 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_expressao32643 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_62_in_expressao32651 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao4_in_expressao32664 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expressao5_in_expressao42698 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_63_in_expressao42706 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_64_in_expressao42714 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_65_in_expressao42722 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_66_in_expressao42730 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao5_in_expressao42737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao6_in_expressao52769 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_expressao52800 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao6_in_expressao52806 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_68_in_expressao52864 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao6_in_expressao52870 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao7_in_expressao62919 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000E0L});
    public static final BitSet FOLLOW_69_in_expressao62942 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_70_in_expressao62950 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_71_in_expressao62958 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao7_in_expressao62971 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000E0L});
    public static final BitSet FOLLOW_68_in_expressao73013 = new BitSet(new long[]{0x0002041BE0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao73024 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao8_in_expressao73034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_expressao83068 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_expressao83074 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_expressao83076 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_referencia_in_expressao83086 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao83095 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao83105 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_72_in_expressao83118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_expressao83126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_referencia3251 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_ID_BIBLIOTECA_in_referencia3259 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_referenciaVetorMatriz3368 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3374 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_referenciaVetorMatriz3376 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_referenciaVetorMatriz3379 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3385 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_referenciaVetorMatriz3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_chamadaFuncao3419 = new BitSet(new long[]{0x0006041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3426 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_chamadaFuncao3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3465 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaParametros3481 = new BitSet(new long[]{0x0002041BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3487 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_vetor3575 = new BitSet(new long[]{0x00022C1BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3581 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_vetor3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_matriz3620 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3628 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_matriz3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_listaListaExpressoes3664 = new BitSet(new long[]{0x00022C1BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3670 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaListaExpressoes3672 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaListaExpressoes3687 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_listaListaExpressoes3690 = new BitSet(new long[]{0x00022C1BF0000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3696 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaListaExpressoes3698 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3744 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaExpressoes3758 = new BitSet(new long[]{0x0002241BF0000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3765 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_42_in_synpred1_Portugol1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred2_Portugol2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred3_Portugol2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred4_Portugol3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred5_Portugol3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred6_Portugol3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred7_Portugol3524 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred7_Portugol3526 = new BitSet(new long[]{0x0000000000000002L});

}