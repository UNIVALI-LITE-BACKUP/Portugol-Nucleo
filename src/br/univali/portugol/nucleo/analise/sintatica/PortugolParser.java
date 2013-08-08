// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g 2013-08-06 13:57:01


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PR_PROGRAMA", "PR_REAL", "PR_VAZIO", "PR_LOGICO", "PR_CADEIA", "PR_INTEIRO", "PR_CARACTER", "PR_ESCOLHA", "PR_CASO", "PR_CONTRARIO", "PR_CONST", "PR_FUNCAO", "PR_RETORNE", "PR_PARA", "PR_PARE", "PR_FACA", "PR_ENQUANTO", "PR_SE", "PR_SENAO", "PR_INCLUA", "PR_BIBLIOTECA", "GAMBIARRA", "PR_FALSO", "PR_VERDADEIRO", "OPERADOR_NAO", "LOGICO", "ID", "ID_BIBLIOTECA", "DIGIT_HEX", "INTEIRO", "REAL", "SEQ_ESC", "CADEIA", "CARACTER", "ESPACO", "ESC_UNICODE", "ESC_OCTAL", "COMENTARIO", "'{'", "'}'", "'-->'", "','", "'['", "']'", "'='", "'('", "')'", "'&'", "';'", "':'", "'+='", "'-='", "'/='", "'*='", "'%='", "'>>='", "'<<='", "'|='", "'&='", "'^='", "'e'", "'ou'", "'|'", "'^'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'++'", "'--'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int PR_BIBLIOTECA=24;
    public static final int T__63=63;
    public static final int DIGIT_HEX=32;
    public static final int LOGICO=29;
    public static final int ESC_UNICODE=39;
    public static final int PR_RETORNE=16;
    public static final int PR_VAZIO=6;
    public static final int PR_FUNCAO=15;
    public static final int ID=30;
    public static final int PR_CONTRARIO=13;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int OPERADOR_NAO=28;
    public static final int PR_ENQUANTO=20;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int ESC_OCTAL=40;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int PR_PROGRAMA=4;
    public static final int T__54=54;
    public static final int PR_REAL=5;
    public static final int T__59=59;
    public static final int COMENTARIO=41;
    public static final int CADEIA=36;
    public static final int T__50=50;
    public static final int GAMBIARRA=25;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int PR_LOGICO=7;
    public static final int T__46=46;
    public static final int T__80=80;
    public static final int CARACTER=37;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int PR_CARACTER=10;
    public static final int PR_SENAO=22;
    public static final int PR_PARE=18;
    public static final int PR_INCLUA=23;
    public static final int PR_PARA=17;
    public static final int PR_SE=21;
    public static final int SEQ_ESC=35;
    public static final int PR_VERDADEIRO=27;
    public static final int PR_FALSO=26;
    public static final int REAL=34;
    public static final int PR_ESCOLHA=11;
    public static final int T__71=71;
    public static final int PR_CONST=14;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int INTEIRO=33;
    public static final int PR_FACA=19;
    public static final int PR_CADEIA=8;
    public static final int PR_CASO=12;
    public static final int PR_INTEIRO=9;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int ESPACO=38;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int ID_BIBLIOTECA=31;
    public static final int T__77=77;

    // delegates
    // delegators


        public PortugolParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PortugolParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PortugolParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g"; }


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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:202:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;

        ArvoreSintaticaAbstrata prog = null;


        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:202:43: (prog= programa )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:204:2: prog= programa
            {
            pushFollow(FOLLOW_programa_in_parse922);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:211:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;


        	pilhaContexto.push("programa");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:214:2: ( PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:216:2: PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            match(input,PR_PROGRAMA,FOLLOW_PR_PROGRAMA_in_programa944); if (state.failed) return asa;
            match(input,42,FOLLOW_42_in_programa947); if (state.failed) return asa;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              		 		asa = new ArvoreSintaticaAbstrataPrograma();
              				asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
              				((ArvoreSintaticaAbstrataPrograma) asa).setListaInclusoesBibliotecas(new ArrayList<NoInclusaoBiblioteca>());
              			}
              		 
            }
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:227:4: ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PR_INCLUA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:227:4: inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa]
            	    {
            	    pushFollow(FOLLOW_inclusaoBiblioteca_in_programa962);
            	    inclusaoBiblioteca((ArvoreSintaticaAbstrataPrograma ) asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:229:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:229:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_programa970);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:229:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_programa975);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_programa981); if (state.failed) return asa;

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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:237:1: inclusaoBiblioteca[ArvoreSintaticaAbstrataPrograma asa] : incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? ;
    public final void inclusaoBiblioteca(ArvoreSintaticaAbstrataPrograma asa) throws RecognitionException {
        Token incl=null;
        Token nome=null;
        Token alias=null;


        	pilhaContexto.push("inclusaoBiblioteca");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:240:2: (incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:241:2: incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )?
            {
            incl=(Token)match(input,PR_INCLUA,FOLLOW_PR_INCLUA_in_inclusaoBiblioteca1004); if (state.failed) return ;
            match(input,PR_BIBLIOTECA,FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca1006); if (state.failed) return ;
            nome=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca1012); if (state.failed) return ;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:241:43: ( '-->' alias= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:241:44: '-->' alias= ID
                    {
                    match(input,44,FOLLOW_44_in_inclusaoBiblioteca1015); if (state.failed) return ;
                    alias=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca1022); if (state.failed) return ;

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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:278:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesGlobais");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:281:2: (vListaDeclaracoes= listaDeclaracoes )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:283:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais1053);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:306:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("declaracoesLocais");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:309:2: (vListaDeclaracoes= listaDeclaracoes )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:311:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais1081);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:329:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;

        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado = null;

        NoDeclaracao vDeclaracao = null;



        	pilhaContexto.push("listaDeclaracoes");
        	listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:333:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:334:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:334:1: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:335:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {
              tokenConst = null; 
            }
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:2: (tokenConst= PR_CONST )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PR_CONST) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:337:3: tokenConst= PR_CONST
                    {
                    tokenConst=(Token)match(input,PR_CONST,FOLLOW_PR_CONST_in_listaDeclaracoes1118); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }

            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1126);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:339:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:339:4: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1137);
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

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:350:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==45) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:350:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,45,FOLLOW_45_in_listaDeclaracoes1159); if (state.failed) return listaDeclaracoes;
            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1165);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:368:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
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
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:371:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao1204); if (state.failed) return declaracao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==46) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,46,FOLLOW_46_in_declaracao1211); if (state.failed) return declaracao;
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:17: (ind1= expressao )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=OPERADOR_NAO && LA6_0<=ID_BIBLIOTECA)||(LA6_0>=INTEIRO && LA6_0<=REAL)||(LA6_0>=CADEIA && LA6_0<=CARACTER)||LA6_0==42||LA6_0==49||LA6_0==77||LA6_0==81) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao1218);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }

                    match(input,47,FOLLOW_47_in_declaracao1222); if (state.failed) return declaracao;
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==46) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,46,FOLLOW_46_in_declaracao1229); if (state.failed) return declaracao;
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:52: (ind2= expressao )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( ((LA7_0>=OPERADOR_NAO && LA7_0<=ID_BIBLIOTECA)||(LA7_0>=INTEIRO && LA7_0<=REAL)||(LA7_0>=CADEIA && LA7_0<=CARACTER)||LA7_0==42||LA7_0==49||LA7_0==77||LA7_0==81) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao1236);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }

                            match(input,47,FOLLOW_47_in_declaracao1240); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:80: ( '=' inicializacao= expressao )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==48) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:373:81: '=' inicializacao= expressao
                    {
                    match(input,48,FOLLOW_48_in_declaracao1247); if (state.failed) return declaracao;
                    pushFollow(FOLLOW_expressao_in_declaracao1253);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:406:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token tokenTipoDado=null;


        	pilhaContexto.push("declaracaoTipoDado");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:409:2: ( (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO | tokenTipoDado= PR_REAL | tokenTipoDado= PR_CARACTER | tokenTipoDado= PR_CADEIA | tokenTipoDado= PR_LOGICO )
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
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:3: tokenTipoDado= PR_INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,PR_INTEIRO,FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1288); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:32: tokenTipoDado= PR_REAL
                    {
                    tokenTipoDado=(Token)match(input,PR_REAL,FOLLOW_PR_REAL_in_declaracaoTipoDado1296); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:58: tokenTipoDado= PR_CARACTER
                    {
                    tokenTipoDado=(Token)match(input,PR_CARACTER,FOLLOW_PR_CARACTER_in_declaracaoTipoDado1304); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:88: tokenTipoDado= PR_CADEIA
                    {
                    tokenTipoDado=(Token)match(input,PR_CADEIA,FOLLOW_PR_CADEIA_in_declaracaoTipoDado1312); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:411:116: tokenTipoDado= PR_LOGICO
                    {
                    tokenTipoDado=(Token)match(input,PR_LOGICO,FOLLOW_PR_LOGICO_in_declaracaoTipoDado1320); if (state.failed) return informacaoTipoDado;

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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:427:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token PR_VAZIO2=null;


        	pilhaContexto.push("declaracaoTipoDadoVazio");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:430:2: ( PR_VAZIO )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:432:2: PR_VAZIO
            {
            PR_VAZIO2=(Token)match(input,PR_VAZIO,FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1347); if (state.failed) return informacaoTipoDado;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:449:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;

        Token tk1=null;
        Token tk2=null;


        	pilhaContexto.push("quantificador");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:452:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==46) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:454:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,46,FOLLOW_46_in_quantificador1379); if (state.failed) return quantificador;
                    match(input,47,FOLLOW_47_in_quantificador1381); if (state.failed) return quantificador;
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:454:17: (tk2= '[' ']' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==46) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:454:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,46,FOLLOW_46_in_quantificador1388); if (state.failed) return quantificador;
                            match(input,47,FOLLOW_47_in_quantificador1390); if (state.failed) return quantificador;

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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:472:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        InformacaoTipoDado informacao = null;



        	pilhaContexto.push("tipoRetornoFuncao");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:475:2: ( (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:477:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:477:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
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
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:477:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1426);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:477:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1434);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:497:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;

        List<NoDeclaracaoParametro> vListaParametros = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("declaracaoFuncao");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:500:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:502:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,PR_FUNCAO,FOLLOW_PR_FUNCAO_in_declaracaoFuncao1461); if (state.failed) return ;
            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1471);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1480);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;
            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1487); if (state.failed) return ;
            match(input,49,FOLLOW_49_in_declaracaoFuncao1489); if (state.failed) return ;
            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1495);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;
            match(input,50,FOLLOW_50_in_declaracaoFuncao1497); if (state.failed) return ;
            match(input,42,FOLLOW_42_in_declaracaoFuncao1517); if (state.failed) return ;
            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1525);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;
            match(input,43,FOLLOW_43_in_declaracaoFuncao1535); if (state.failed) return ;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:533:1: listaParametrosFuncao returns [List<NoDeclaracaoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoDeclaracaoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoDeclaracaoParametro> listaParametros = null;

        NoDeclaracaoParametro vDeclaracaoParametro = null;



        	pilhaContexto.push("listaParametrosFuncao");
        	listaParametros = new ArrayList<NoDeclaracaoParametro>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:537:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PR_REAL||(LA16_0>=PR_LOGICO && LA16_0<=PR_CARACTER)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro )
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:539:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1590);
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

                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:548:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:548:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,45,FOLLOW_45_in_listaParametrosFuncao1618); if (state.failed) return listaParametros;
                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1624);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:564:1: declaracaoParametro returns [NoDeclaracaoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoDeclaracaoParametro declaracaoParametro() throws RecognitionException {
        NoDeclaracaoParametro parametro = null;

        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;



        	pilhaContexto.push("declaracaoParametro");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:567:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:569:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1671);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:569:42: (tkr= '&' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==51) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:569:43: tkr= '&'
                    {
                    tkr=(Token)match(input,51,FOLLOW_51_in_declaracaoParametro1678); if (state.failed) return parametro;

                    }
                    break;

            }

            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1682); if (state.failed) return parametro;
            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1688);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:600:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("blocos");
        	blocos = new ArrayList<NoBloco>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:604:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:605:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:605:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PR_ESCOLHA||(LA18_0>=PR_RETORNE && LA18_0<=PR_SE)||(LA18_0>=OPERADOR_NAO && LA18_0<=ID_BIBLIOTECA)||(LA18_0>=INTEIRO && LA18_0<=REAL)||(LA18_0>=CADEIA && LA18_0<=CARACTER)||LA18_0==42||LA18_0==49||LA18_0==77||LA18_0==81) ) {
                    alt18=1;
                }
                else if ( (LA18_0==PR_REAL||(LA18_0>=PR_LOGICO && LA18_0<=PR_CARACTER)||LA18_0==PR_CONST) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:606:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1720);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;
            	    if ( state.backtracking==0 ) {
            	       blocos.add(vBloco); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:606:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1726);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:615:1: bloco returns [NoBloco bloco] : (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) ;
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
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:618:2: ( (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:619:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:619:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha )
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
            case 77:
            case 81:
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
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:620:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1760);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vExpressao; 	
                    }

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:621:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1775);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPara; 	 	
                    }

                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:622:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1793);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPare; 	 	
                    }

                    }
                    break;
                case 4 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:623:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1810);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vRetorne; 	 	
                    }

                    }
                    break;
                case 5 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:624:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1826);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vSe; 		
                    }

                    }
                    break;
                case 6 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:625:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1843);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEnquanto;		
                    }

                    }
                    break;
                case 7 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:626:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1857);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vFacaEnquanto; 	
                    }

                    }
                    break;
                case 8 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:627:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1871);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:636:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? fp= ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;

        Token fp=null;
        Token PR_PARA5=null;
        NoBloco inicializacao = null;

        NoExpressao condicao = null;

        NoExpressao incremento = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("para");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:639:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? fp= ')' vBlocos= listaBlocos )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? fp= ')' vBlocos= listaBlocos
            {
            PR_PARA5=(Token)match(input,PR_PARA,FOLLOW_PR_PARA_in_para1903); if (state.failed) return para;
            match(input,49,FOLLOW_49_in_para1905); if (state.failed) return para;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:14: (inicializacao= inicializacaoPara )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==PR_REAL||(LA20_0>=PR_LOGICO && LA20_0<=PR_CARACTER)||LA20_0==PR_CONST||(LA20_0>=OPERADOR_NAO && LA20_0<=ID_BIBLIOTECA)||(LA20_0>=INTEIRO && LA20_0<=REAL)||(LA20_0>=CADEIA && LA20_0<=CARACTER)||LA20_0==42||LA20_0==49||LA20_0==77||LA20_0==81) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:15: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1912);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_para1916); if (state.failed) return para;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:55: (condicao= expressao )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=OPERADOR_NAO && LA21_0<=ID_BIBLIOTECA)||(LA21_0>=INTEIRO && LA21_0<=REAL)||(LA21_0>=CADEIA && LA21_0<=CARACTER)||LA21_0==42||LA21_0==49||LA21_0==77||LA21_0==81) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:56: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1923);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_para1927); if (state.failed) return para;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:83: (incremento= expressao )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=OPERADOR_NAO && LA22_0<=ID_BIBLIOTECA)||(LA22_0>=INTEIRO && LA22_0<=REAL)||(LA22_0>=CADEIA && LA22_0<=CARACTER)||LA22_0==42||LA22_0==49||LA22_0==77||LA22_0==81) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:641:84: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1934);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            fp=(Token)match(input,50,FOLLOW_50_in_para1942); if (state.failed) return para;
            pushFollow(FOLLOW_listaBlocos_in_para1948);
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
              			
              			int linha =  PR_PARA5.getLine();
                  			int coluna =  PR_PARA5.getCharPositionInLine();
                  			int tamanhoTexto = fp.getCharPositionInLine() - PR_PARA5.getCharPositionInLine();
              			
              			para.setTrechoCodigoFonte(new TrechoCodigoFonte(linha, coluna, tamanhoTexto));
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:665:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;

        NoExpressao vExpressao = null;

        List<NoDeclaracao> vListaDeclaracoes = null;



        	pilhaContexto.push("inicializacaoPara");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:668:2: ( (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:670:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:670:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=OPERADOR_NAO && LA23_0<=ID_BIBLIOTECA)||(LA23_0>=INTEIRO && LA23_0<=REAL)||(LA23_0>=CADEIA && LA23_0<=CARACTER)||LA23_0==42||LA23_0==49||LA23_0==77||LA23_0==81) ) {
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
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:670:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1979);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:670:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1987);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:686:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vListaBlocos = null;

        NoBloco vBloco = null;



        	pilhaContexto.push("listaBlocos");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:689:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:690:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:690:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:691:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,42,FOLLOW_42_in_listaBlocos2020); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_listaBlocos2026);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    if ( state.backtracking==0 ) {
                       listaBlocos = vListaBlocos; 
                    }
                    match(input,43,FOLLOW_43_in_listaBlocos2030); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:695:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos2046);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:711:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;

        Token PR_PARE6=null;


        	pilhaContexto.push("pare");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:714:2: ( PR_PARE )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:716:2: PR_PARE
            {
            PR_PARE6=(Token)match(input,PR_PARE,FOLLOW_PR_PARE_in_pare2074); if (state.failed) return pare;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			pare = new NoPare();
              			pare.setTrechoCodigoFonte(criarTrechoCodigoFonte(PR_PARE6));
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:732:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;

        NoExpressao vExpressaoEscolha = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("escolha");
        	List<NoCaso> casos =  new ArrayList<NoCaso>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:736:2: ( PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:738:2: PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}'
            {
            match(input,PR_ESCOLHA,FOLLOW_PR_ESCOLHA_in_escolha2101); if (state.failed) return escolha;
            match(input,49,FOLLOW_49_in_escolha2103); if (state.failed) return escolha;
            pushFollow(FOLLOW_expressao_in_escolha2109);
            vExpressaoEscolha=expressao();

            state._fsp--;
            if (state.failed) return escolha;
            match(input,50,FOLLOW_50_in_escolha2111); if (state.failed) return escolha;
            match(input,42,FOLLOW_42_in_escolha2114); if (state.failed) return escolha;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:741:3: ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PR_CASO) ) {
                    int LA25_1 = input.LA(2);

                    if ( ((LA25_1>=OPERADOR_NAO && LA25_1<=ID_BIBLIOTECA)||(LA25_1>=INTEIRO && LA25_1<=REAL)||(LA25_1>=CADEIA && LA25_1<=CARACTER)||LA25_1==42||LA25_1==49||LA25_1==77||LA25_1==81) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:741:4: PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso
            	    {
            	    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2123); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_expressao_in_escolha2129);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return escolha;
            	    match(input,53,FOLLOW_53_in_escolha2131); if (state.failed) return escolha;
            	    pushFollow(FOLLOW_blocosCaso_in_escolha2137);
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

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:753:4: ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PR_CASO) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:753:5: PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso
                    {
                    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2152); if (state.failed) return escolha;
                    match(input,PR_CONTRARIO,FOLLOW_PR_CONTRARIO_in_escolha2154); if (state.failed) return escolha;
                    match(input,53,FOLLOW_53_in_escolha2156); if (state.failed) return escolha;
                    pushFollow(FOLLOW_blocosCaso_in_escolha2162);
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

            match(input,43,FOLLOW_43_in_escolha2176); if (state.failed) return escolha;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:781:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vBlocos = null;



        	pilhaContexto.push("blocosCaso");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:784:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:12: ( '{' vBlocos= blocos '}' )
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:13: '{' vBlocos= blocos '}'
                    {
                    match(input,42,FOLLOW_42_in_blocosCaso2212); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_blocosCaso2218);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    match(input,43,FOLLOW_43_in_blocosCaso2220); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:41: (vBlocos= blocos )
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:41: (vBlocos= blocos )
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso2230);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:797:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;



        	pilhaContexto.push("enquanto");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:800:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:802:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_enquanto2259); if (state.failed) return enquanto;
            match(input,49,FOLLOW_49_in_enquanto2261); if (state.failed) return enquanto;
            pushFollow(FOLLOW_expressao_in_enquanto2267);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;
            match(input,50,FOLLOW_50_in_enquanto2269); if (state.failed) return enquanto;
            pushFollow(FOLLOW_listaBlocos_in_enquanto2275);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:817:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;

        List<NoBloco> vListaBlocos = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("facaEnquanto");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:820:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:822:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,PR_FACA,FOLLOW_PR_FACA_in_facaEnquanto2301); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2307);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_facaEnquanto2309); if (state.failed) return facaEnquanto;
            match(input,49,FOLLOW_49_in_facaEnquanto2311); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_expressao_in_facaEnquanto2317);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,50,FOLLOW_50_in_facaEnquanto2319); if (state.failed) return facaEnquanto;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:838:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;

        List<NoBloco> listaBlocosSenao = null;



        	pilhaContexto.push("se");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:841:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:843:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,PR_SE,FOLLOW_PR_SE_in_se2347); if (state.failed) return se;
            match(input,49,FOLLOW_49_in_se2349); if (state.failed) return se;
            pushFollow(FOLLOW_expressao_in_se2355);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;
            match(input,50,FOLLOW_50_in_se2357); if (state.failed) return se;
            pushFollow(FOLLOW_listaBlocos_in_se2363);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:843:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PR_SENAO) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:843:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,PR_SENAO,FOLLOW_PR_SENAO_in_se2366); if (state.failed) return se;
                    pushFollow(FOLLOW_listaBlocos_in_se2372);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:859:1: retorne returns [NoRetorne retorne] : PR_RETORNE (vExpressao= expressao )? ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;

        Token PR_RETORNE7=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("retorne");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:862:2: ( PR_RETORNE (vExpressao= expressao )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:864:2: PR_RETORNE (vExpressao= expressao )?
            {
            PR_RETORNE7=(Token)match(input,PR_RETORNE,FOLLOW_PR_RETORNE_in_retorne2401); if (state.failed) return retorne;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:864:24: (vExpressao= expressao )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:864:24: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_retorne2407);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return retorne;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			retorne = new NoRetorne(criarTrechoCodigoFonte(PR_RETORNE7),vExpressao);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:878:1: pilha returns [Stack<Object> pilha] : ;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:878:35: ()
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:879:1: 
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:885:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        Stack<Object> vPilha = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:888:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' ) operandoDireito= expressao2 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:890:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2452);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;
            pushFollow(FOLLOW_pilha_in_expressao2458);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {
               vPilha.push(operandoEsquerdo); 
            }
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:891:2: ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' ) operandoDireito= expressao2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==48||(LA31_0>=54 && LA31_0<=63)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' ) operandoDireito= expressao2
            	    {
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' | operador= '>>=' | operador= '<<=' | operador= '|=' | operador= '&=' | operador= '^=' )
            	    int alt30=11;
            	    switch ( input.LA(1) ) {
            	    case 48:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 55:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt30=5;
            	        }
            	        break;
            	    case 58:
            	        {
            	        alt30=6;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt30=7;
            	        }
            	        break;
            	    case 60:
            	        {
            	        alt30=8;
            	        }
            	        break;
            	    case 61:
            	        {
            	        alt30=9;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt30=10;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt30=11;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:4: operador= '='
            	            {
            	            operador=(Token)match(input,48,FOLLOW_48_in_expressao2472); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:21: operador= '+='
            	            {
            	            operador=(Token)match(input,54,FOLLOW_54_in_expressao2480); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:39: operador= '-='
            	            {
            	            operador=(Token)match(input,55,FOLLOW_55_in_expressao2488); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:57: operador= '/='
            	            {
            	            operador=(Token)match(input,56,FOLLOW_56_in_expressao2496); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:75: operador= '*='
            	            {
            	            operador=(Token)match(input,57,FOLLOW_57_in_expressao2504); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:93: operador= '%='
            	            {
            	            operador=(Token)match(input,58,FOLLOW_58_in_expressao2512); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 7 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:111: operador= '>>='
            	            {
            	            operador=(Token)match(input,59,FOLLOW_59_in_expressao2520); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 8 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:130: operador= '<<='
            	            {
            	            operador=(Token)match(input,60,FOLLOW_60_in_expressao2528); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 9 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:149: operador= '|='
            	            {
            	            operador=(Token)match(input,61,FOLLOW_61_in_expressao2536); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 10 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:167: operador= '&='
            	            {
            	            operador=(Token)match(input,62,FOLLOW_62_in_expressao2544); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 11 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:892:185: operador= '^='
            	            {
            	            operador=(Token)match(input,63,FOLLOW_63_in_expressao2552); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao2_in_expressao2565);
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
            	    break loop31;
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
              				
              				if (!operador.getText().equals("="))
              				{				
              					operandoDireito = FabricaNoOperacao.novoNo(operador.getText().substring(0, 1), operandoEsquerdo, operandoDireito);				   
              				}
              				
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:935:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao2_5 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao2_5 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao2");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:938:2: (operandoEsquerdo= expressao2_5 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao2_5 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:940:2: operandoEsquerdo= expressao2_5 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao2_5 )*
            {
            pushFollow(FOLLOW_expressao2_5_in_expressao22604);
            operandoEsquerdo=expressao2_5();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:941:2: ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao2_5 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=64 && LA33_0<=65)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:942:3: (operador= 'e' | operador= 'ou' ) operandoDireito= expressao2_5
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:955:3: (operador= 'e' | operador= 'ou' )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==64) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==65) ) {
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
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:955:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,64,FOLLOW_64_in_expressao22633); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:955:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,65,FOLLOW_65_in_expressao22641); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao2_5_in_expressao22653);
            	    operandoDireito=expressao2_5();

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
    // $ANTLR end "expressao2"


    // $ANTLR start "expressao2_5"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:971:1: expressao2_5 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= '&' | operador= '|' | operador= '^' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2_5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao2_5");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:974:2: (operandoEsquerdo= expressao3 ( (operador= '&' | operador= '|' | operador= '^' ) operandoDireito= expressao3 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:975:2: operandoEsquerdo= expressao3 ( (operador= '&' | operador= '|' | operador= '^' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao2_52686);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:976:5: ( (operador= '&' | operador= '|' | operador= '^' ) operandoDireito= expressao3 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==51||(LA35_0>=66 && LA35_0<=67)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:977:3: (operador= '&' | operador= '|' | operador= '^' ) operandoDireito= expressao3
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:989:3: (operador= '&' | operador= '|' | operador= '^' )
            	    int alt34=3;
            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt34=1;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt34=2;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt34=3;
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
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:989:4: operador= '&'
            	            {
            	            operador=(Token)match(input,51,FOLLOW_51_in_expressao2_52715); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:989:21: operador= '|'
            	            {
            	            operador=(Token)match(input,66,FOLLOW_66_in_expressao2_52723); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:989:38: operador= '^'
            	            {
            	            operador=(Token)match(input,67,FOLLOW_67_in_expressao2_52731); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao3_in_expressao2_52743);
            	    operandoDireito=expressao3();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "expressao2_5"


    // $ANTLR start "expressao3"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1005:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao3");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1008:2: (operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1010:2: operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32777);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1011:2: ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=68 && LA37_0<=69)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1012:3: (operador= '==' | operador= '!=' ) operandoDireito= expressao4
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1025:3: (operador= '==' | operador= '!=' )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==68) ) {
            	        alt36=1;
            	    }
            	    else if ( (LA36_0==69) ) {
            	        alt36=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1025:4: operador= '=='
            	            {
            	            operador=(Token)match(input,68,FOLLOW_68_in_expressao32798); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1025:22: operador= '!='
            	            {
            	            operador=(Token)match(input,69,FOLLOW_69_in_expressao32806); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao4_in_expressao32819);
            	    operandoDireito=expressao4();

            	    state._fsp--;
            	    if (state.failed) return expressao;

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
    // $ANTLR end "expressao3"


    // $ANTLR start "expressao4"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1042:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao4_5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao4_5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao4");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1045:2: (operandoEsquerdo= expressao4_5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao4_5 )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:2: operandoEsquerdo= expressao4_5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao4_5 )?
            {
            pushFollow(FOLLOW_expressao4_5_in_expressao42853);
            operandoEsquerdo=expressao4_5();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:34: ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao4_5 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=70 && LA39_0<=73)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:35: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao4_5
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:35: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' )
                    int alt38=4;
                    switch ( input.LA(1) ) {
                    case 70:
                        {
                        alt38=1;
                        }
                        break;
                    case 71:
                        {
                        alt38=2;
                        }
                        break;
                    case 72:
                        {
                        alt38=3;
                        }
                        break;
                    case 73:
                        {
                        alt38=4;
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
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:36: operador= '>='
                            {
                            operador=(Token)match(input,70,FOLLOW_70_in_expressao42861); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:54: operador= '<='
                            {
                            operador=(Token)match(input,71,FOLLOW_71_in_expressao42869); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:72: operador= '<'
                            {
                            operador=(Token)match(input,72,FOLLOW_72_in_expressao42877); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1047:89: operador= '>'
                            {
                            operador=(Token)match(input,73,FOLLOW_73_in_expressao42885); if (state.failed) return expressao;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expressao4_5_in_expressao42892);
                    operandoDireito=expressao4_5();

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


    // $ANTLR start "expressao4_5"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1060:1: expressao4_5 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '<<' | operador= '>>' ) operandoDireito= expressao5 )* ;
    public final NoExpressao expressao4_5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao4_5");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1063:2: (operandoEsquerdo= expressao5 ( (operador= '<<' | operador= '>>' ) operandoDireito= expressao5 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1063:4: operandoEsquerdo= expressao5 ( (operador= '<<' | operador= '>>' ) operandoDireito= expressao5 )*
            {
            pushFollow(FOLLOW_expressao5_in_expressao4_52921);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1064:5: ( (operador= '<<' | operador= '>>' ) operandoDireito= expressao5 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=74 && LA41_0<=75)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1065:3: (operador= '<<' | operador= '>>' ) operandoDireito= expressao5
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1077:3: (operador= '<<' | operador= '>>' )
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==74) ) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==75) ) {
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
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1077:4: operador= '<<'
            	            {
            	            operador=(Token)match(input,74,FOLLOW_74_in_expressao4_52950); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1077:22: operador= '>>'
            	            {
            	            operador=(Token)match(input,75,FOLLOW_75_in_expressao4_52958); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao5_in_expressao4_52970);
            	    operandoDireito=expressao5();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end "expressao4_5"


    // $ANTLR start "expressao5"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1093:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao5");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1096:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1098:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao53004);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1099:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            loop42:
            do {
                int alt42=3;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1100:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1100:3: (operador= '+' operandoDireito= expressao6 )
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1102:4: operador= '+' operandoDireito= expressao6
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
            	    operador=(Token)match(input,76,FOLLOW_76_in_expressao53035); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao53041);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1119:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    {
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1119:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1121:5: ( '-' )=>operador= '-' operandoDireito= expressao6
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
            	    operador=(Token)match(input,77,FOLLOW_77_in_expressao53099); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao53105);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1154:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;



        	pilhaContexto.push("expressao6");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1157:2: (operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1159:2: operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao63154);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1160:2: ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=78 && LA44_0<=80)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1161:3: (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7
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
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1174:3: (operador= '*' | operador= '/' | operador= '%' )
            	    int alt43=3;
            	    switch ( input.LA(1) ) {
            	    case 78:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case 79:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case 80:
            	        {
            	        alt43=3;
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
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1174:4: operador= '*'
            	            {
            	            operador=(Token)match(input,78,FOLLOW_78_in_expressao63177); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1174:21: operador= '/'
            	            {
            	            operador=(Token)match(input,79,FOLLOW_79_in_expressao63185); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1174:38: operador= '%'
            	            {
            	            operador=(Token)match(input,80,FOLLOW_80_in_expressao63193); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao7_in_expressao63206);
            	    operandoDireito=expressao7();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1191:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* | listaTokenNot+= '~' ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;

        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        Token listaTokenNot=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        List list_listaTokenNot=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao7");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1194:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* | listaTokenNot+= '~' ) vExpressao= expressao8 )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* | listaTokenNot+= '~' ) vExpressao= expressao8
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* | listaTokenNot+= '~' )
            int alt47=3;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:12: (listaTokenMenos+= '-' )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==77) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,77,FOLLOW_77_in_expressao73248); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:40: (listaTokenNao+= OPERADOR_NAO )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==OPERADOR_NAO) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:41: listaTokenNao+= OPERADOR_NAO
                    	    {
                    	    listaTokenNao=(Token)match(input,OPERADOR_NAO,FOLLOW_OPERADOR_NAO_in_expressao73259); if (state.failed) return expressao;
                    	    if (list_listaTokenNao==null) list_listaTokenNao=new ArrayList();
                    	    list_listaTokenNao.add(listaTokenNao);


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:75: listaTokenNot+= '~'
                    {
                    listaTokenNot=(Token)match(input,81,FOLLOW_81_in_expressao73269); if (state.failed) return expressao;
                    if (list_listaTokenNot==null) list_listaTokenNot=new ArrayList();
                    list_listaTokenNot.add(listaTokenNot);


                    }
                    break;

            }

            pushFollow(FOLLOW_expressao8_in_expressao73278);
            vExpressao=expressao8();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			if (list_listaTokenNot != null) vExpressao = new NoBitwiseNao(vExpressao);
              			
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1222:1: expressao8 returns [NoExpressao expressao] : (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;

        Token parentesis=null;
        Token operador=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("expressao8");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1225:2: ( (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )?
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:2: (parentesis= '(' vExpressao= expressao ')' | vExpressao= referencia | vExpressao= tipoPrimitivo | vExpressao= matrizVetor )
            int alt48=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt48=1;
                }
                break;
            case ID:
            case ID_BIBLIOTECA:
                {
                alt48=2;
                }
                break;
            case LOGICO:
            case INTEIRO:
            case REAL:
            case CADEIA:
            case CARACTER:
                {
                alt48=3;
                }
                break;
            case 42:
                {
                alt48=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1227:4: parentesis= '(' vExpressao= expressao ')'
                    {
                    parentesis=(Token)match(input,49,FOLLOW_49_in_expressao83312); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_expressao83318);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,50,FOLLOW_50_in_expressao83320); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1228:4: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao83330);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1229:4: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao83339);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1230:4: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao83349);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1232:3: (operador= '++' | operador= '--' )?
            int alt49=3;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==82) ) {
                alt49=1;
            }
            else if ( (LA49_0==83) ) {
                alt49=2;
            }
            switch (alt49) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1232:4: operador= '++'
                    {
                    operador=(Token)match(input,82,FOLLOW_82_in_expressao83362); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1232:22: operador= '--'
                    {
                    operador=(Token)match(input,83,FOLLOW_83_in_expressao83370); if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              		
                   			
              			if (operador != null)
              			{
              				NoInteiro inteiro = new NoInteiro(1);
              				inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(operador));			
              				NoOperacao operandoDireito = FabricaNoOperacao.novoNo(operador.getText().substring(0, 1), vExpressao, inteiro);				   
              				NoOperacao operacao = FabricaNoOperacao.novoNo("=", vExpressao, operandoDireito);			
              				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
              				expressao = operacao;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1263:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;

        Token REAL8=null;
        Token LOGICO9=null;
        Token CADEIA10=null;
        Token INTEIRO11=null;
        Token CARACTER12=null;


        	pilhaContexto.push("tipoPrimitivo");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1266:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt50=5;
            switch ( input.LA(1) ) {
            case REAL:
                {
                alt50=1;
                }
                break;
            case LOGICO:
                {
                alt50=2;
                }
                break;
            case CADEIA:
                {
                alt50=3;
                }
                break;
            case INTEIRO:
                {
                alt50=4;
                }
                break;
            case CARACTER:
                {
                alt50=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1268:2: REAL
                    {
                    REAL8=(Token)match(input,REAL,FOLLOW_REAL_in_tipoPrimitivo3399); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {
                       
                      		if (gerarArvore)
                      		{
                      			NoReal real = new NoReal(Double.parseDouble((REAL8!=null?REAL8.getText():null)));
                      			real.setTrechoCodigoFonte(criarTrechoCodigoFonte(REAL8));
                      			expressao = real;
                      		}
                      	
                    }

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1280:2: LOGICO
                    {
                    LOGICO9=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_tipoPrimitivo3419); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			NoLogico logico = new NoLogico(((LOGICO9!=null?LOGICO9.getText():null).equals("verdadeiro")? true : false));
                      			logico.setTrechoCodigoFonte(criarTrechoCodigoFonte(LOGICO9));
                      			expressao = logico;
                      		}
                      	
                    }

                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1292:2: CADEIA
                    {
                    CADEIA10=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_tipoPrimitivo3433); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			String texto = (CADEIA10!=null?CADEIA10.getText():null);
                      			NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                      			cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte(CADEIA10));
                      			expressao = cadeia;
                      		}
                      	
                    }

                    }
                    break;
                case 4 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1305:2: INTEIRO
                    {
                    INTEIRO11=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_tipoPrimitivo3446); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		try
                      		{
                      	
                      		if (gerarArvore)
                      		{
                      			NoInteiro inteiro = null;
                      			if ((INTEIRO11!=null?INTEIRO11.getText():null).matches("(0x|0X).+")){
                      				inteiro = new NoInteiro(Integer.valueOf((INTEIRO11!=null?INTEIRO11.getText():null).replaceAll("0x|0X", ""),16));
                      			} else if ((INTEIRO11!=null?INTEIRO11.getText():null).matches("(0b|0B).+")) {
                      				inteiro = new NoInteiro(Integer.valueOf((INTEIRO11!=null?INTEIRO11.getText():null).replaceAll("0b|0B", ""),2));
                      			} else {
                      				inteiro = new NoInteiro(Integer.parseInt((INTEIRO11!=null?INTEIRO11.getText():null)));
                      			}
                      			inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(INTEIRO11));
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
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1333:2: CARACTER
                    {
                    CARACTER12=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_tipoPrimitivo3461); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		if (gerarArvore)
                      		{
                      			NoCaracter caracter = new NoCaracter((CARACTER12!=null?CARACTER12.getText():null).charAt(1));
                      			caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte(CARACTER12));
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1349:1: referencia returns [NoReferencia referencia] : (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;

        Token id=null;
        NoExpressao vExpressao = null;



        	pilhaContexto.push("referencia");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1352:2: ( (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1354:2: (id= ID | id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1354:2: (id= ID | id= ID_BIBLIOTECA )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==ID_BIBLIOTECA) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return referencia;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1354:3: id= ID
                    {
                    id=(Token)match(input,ID,FOLLOW_ID_in_referencia3495); if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1354:13: id= ID_BIBLIOTECA
                    {
                    id=(Token)match(input,ID_BIBLIOTECA,FOLLOW_ID_BIBLIOTECA_in_referencia3503); if (state.failed) return referencia;

                    }
                    break;

            }

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1355:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )
            int alt52=3;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1356:3: ( '(' )=>vExpressao= chamadaFuncao[$id.getText()]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia3521);
                    vExpressao=chamadaFuncao(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1357:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia3538);
                    vExpressao=referenciaVetorMatriz(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1358:5: vExpressao= referenciaId[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia3551);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1375:1: referenciaId[String id] returns [NoExpressao expressao] : ;
    public final NoExpressao referenciaId(String id) throws RecognitionException {
        NoExpressao expressao = null;


        	pilhaContexto.push("referenciaId");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1378:2: ()
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1380:2: 
            {
            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			String nome = id;
              			String escopo = null;
              			
              			if (id.contains("."))
              			{
              				String[] ref = id.split("\\.");
              				escopo = ref[0];
              				nome = ref[1];
              			}
              			
              			expressao = new NoReferenciaVariavel(escopo, nome);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1404:1: referenciaVetorMatriz[ String id] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String id) throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao indice1 = null;

        NoExpressao indice2 = null;



        	pilhaContexto.push("referenciaVetorMatriz");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1407:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1409:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,46,FOLLOW_46_in_referenciaVetorMatriz3612); if (state.failed) return expressao;
            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3618);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,47,FOLLOW_47_in_referenciaVetorMatriz3620); if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1409:30: ( '[' indice2= expressao ']' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==46) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1409:31: '[' indice2= expressao ']'
                    {
                    match(input,46,FOLLOW_46_in_referenciaVetorMatriz3623); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3629);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,47,FOLLOW_47_in_referenciaVetorMatriz3631); if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		if (gerarArvore)
              		{
              			String nome = id;
              			String escopo = null;
              			
              			if (id.contains("."))
              			{
              				String[] ref = id.split("\\.");
              				escopo = ref[0];
              				nome = ref[1];
              			}
              		
              		 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(escopo, nome, indice1);
              			else		
              			if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(escopo, nome, indice1, indice2);		
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1435:1: chamadaFuncao[String id] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String id) throws RecognitionException {
        NoExpressao expressao = null;

        List<NoExpressao> vListaParametros = null;



        	pilhaContexto.push("chamadaFuncao");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1438:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1440:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,49,FOLLOW_49_in_chamadaFuncao3663); if (state.failed) return expressao;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1440:6: (vListaParametros= listaParametros )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=OPERADOR_NAO && LA54_0<=ID_BIBLIOTECA)||(LA54_0>=INTEIRO && LA54_0<=REAL)||(LA54_0>=CADEIA && LA54_0<=CARACTER)||LA54_0==42||LA54_0==49||LA54_0==77||LA54_0==81) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1440:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3670);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            match(input,50,FOLLOW_50_in_chamadaFuncao3674); if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

               		if (gerarArvore)
               		{
               		
               			String nome = id;
              			String escopo = null;
              			
              			if (id.contains("."))
              			{
              				String[] ref = id.split("\\.");
              				escopo = ref[0];
              				nome = ref[1];
              			}
              			
              			NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(escopo, nome);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1468:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaParametros");
        	listaParametros = new ArrayList<NoExpressao>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1472:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1473:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1473:2: (vExpressao= expressao )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1473:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3709);
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

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1482:2: ( ',' vExpressao= expressao )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==45) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1482:3: ',' vExpressao= expressao
            	    {
            	    match(input,45,FOLLOW_45_in_listaParametros3725); if (state.failed) return listaParametros;
            	    pushFollow(FOLLOW_expressao_in_listaParametros3731);
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
        return listaParametros;
    }
    // $ANTLR end "listaParametros"


    // $ANTLR start "matrizVetor"
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1498:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("matrizVetor");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1501:2: ( ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==42) ) {
                int LA56_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3778);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3786);
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1518:1: vetor returns [NoExpressao expressao] : abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("vetor");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1521:2: (abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1523:2: abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,42,FOLLOW_42_in_vetor3820); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaExpressoes_in_vetor3826);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,43,FOLLOW_43_in_vetor3832); if (state.failed) return expressao;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1540:1: matriz returns [NoExpressao expressao] : abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;

        Token abre_ch=null;
        Token fecha_ch=null;
        List<List<Object>> vListaListaExpressoes = null;



        	pilhaContexto.push("matriz");

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1543:2: (abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1545:2: abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,42,FOLLOW_42_in_matriz3865); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3873);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            fecha_ch=(Token)match(input,43,FOLLOW_43_in_matriz3880); if (state.failed) return expressao;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1565:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;

        List<Object> vListaExpressoes = null;



        	pilhaContexto.push("listaListaExpressoes");
        	listaListaExpressoes = new ArrayList<List<Object>>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1569:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1570:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1570:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1570:4: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,42,FOLLOW_42_in_listaListaExpressoes3909); if (state.failed) return listaListaExpressoes;
            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3915);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;
            match(input,43,FOLLOW_43_in_listaListaExpressoes3917); if (state.failed) return listaListaExpressoes;
            if ( state.backtracking==0 ) {

              			if (gerarArvore)
              			{
              				 listaListaExpressoes.add(vListaExpressoes); 
              			 }
              		
            }

            }

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1578:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==45) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1578:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) {
            	       vListaExpressoes = null; 
            	    }
            	    match(input,45,FOLLOW_45_in_listaListaExpressoes3932); if (state.failed) return listaListaExpressoes;
            	    match(input,42,FOLLOW_42_in_listaListaExpressoes3935); if (state.failed) return listaListaExpressoes;
            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3941);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;
            	    match(input,43,FOLLOW_43_in_listaListaExpressoes3943); if (state.failed) return listaListaExpressoes;
            	    if ( state.backtracking==0 ) {
            	       
            	      	   	if (gerarArvore)
            	      	   	{
            	      		   	listaListaExpressoes.add(vListaExpressoes); 
            	      	   	}
            	      	   
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
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
    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1594:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;

        NoExpressao vExpressao = null;



        	pilhaContexto.push("listaExpressoes");
        	listaExpressoes = new ArrayList<Object>();

        try {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1598:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1599:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1599:2: ( (vExpressao= expressao )? )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1599:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) {
               vExpressao = null; 
            }
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1599:30: (vExpressao= expressao )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=OPERADOR_NAO && LA58_0<=ID_BIBLIOTECA)||(LA58_0>=INTEIRO && LA58_0<=REAL)||(LA58_0>=CADEIA && LA58_0<=CARACTER)||LA58_0==42||LA58_0==49||LA58_0==77||LA58_0==81) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1599:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3989);
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

            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1606:2: ( ',' (vExpressao= expressao )? )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==45) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1606:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) {
            	       vExpressao = null; 
            	    }
            	    match(input,45,FOLLOW_45_in_listaExpressoes4003); if (state.failed) return listaExpressoes;
            	    // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1606:30: (vExpressao= expressao )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( ((LA59_0>=OPERADOR_NAO && LA59_0<=ID_BIBLIOTECA)||(LA59_0>=INTEIRO && LA59_0<=REAL)||(LA59_0>=CADEIA && LA59_0<=CARACTER)||LA59_0==42||LA59_0==49||LA59_0==77||LA59_0==81) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1606:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes4010);
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
            	    break loop60;
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
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:691:2: ( '{' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:691:3: '{'
        {
        match(input,42,FOLLOW_42_in_synpred1_Portugol2016); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:4: ( '{' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:786:5: '{'
        {
        match(input,42,FOLLOW_42_in_synpred2_Portugol2207); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1121:5: ( '-' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1121:6: '-'
        {
        match(input,77,FOLLOW_77_in_synpred3_Portugol3071); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:3: ( '-' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1196:4: '-'
        {
        match(input,77,FOLLOW_77_in_synpred4_Portugol3238); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1356:3: ( '(' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1356:4: '('
        {
        match(input,49,FOLLOW_49_in_synpred5_Portugol3512); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1357:3: ( '[' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1357:4: '['
        {
        match(input,46,FOLLOW_46_in_synpred6_Portugol3529); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {   
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:3: ( '{' '{' )
        // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1503:4: '{' '{'
        {
        match(input,42,FOLLOW_42_in_synpred7_Portugol3768); if (state.failed) return ;
        match(input,42,FOLLOW_42_in_synpred7_Portugol3770); if (state.failed) return ;

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
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA52 dfa52 = new DFA52(this);
    static final String DFA24_eotS =
        "\25\uffff";
    static final String DFA24_eofS =
        "\25\uffff";
    static final String DFA24_minS =
        "\1\13\1\0\23\uffff";
    static final String DFA24_maxS =
        "\1\121\1\0\23\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\21\uffff\1\1";
    static final String DFA24_specialS =
        "\1\uffff\1\0\23\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\2\4\uffff\6\2\6\uffff\4\2\1\uffff\2\2\1\uffff\2\2\4\uffff"+
            "\1\1\6\uffff\1\2\33\uffff\1\2\3\uffff\1\2",
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
            return "690:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )";
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
                        if ( (synpred1_Portugol()) ) {s = 20;}

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
        "\35\uffff";
    static final String DFA27_eofS =
        "\35\uffff";
    static final String DFA27_minS =
        "\1\5\1\0\33\uffff";
    static final String DFA27_maxS =
        "\1\121\1\0\33\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\31\uffff\1\1";
    static final String DFA27_specialS =
        "\1\uffff\1\0\33\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\1\uffff\6\2\1\uffff\1\2\1\uffff\6\2\6\uffff\4\2\1\uffff"+
            "\2\2\1\uffff\2\2\4\uffff\1\1\1\2\5\uffff\1\2\33\uffff\1\2\3"+
            "\uffff\1\2",
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
            return "786:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )";
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
                        if ( (synpred2_Portugol()) ) {s = 28;}

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
    static final String DFA29_eotS =
        "\35\uffff";
    static final String DFA29_eofS =
        "\35\uffff";
    static final String DFA29_minS =
        "\1\5\34\uffff";
    static final String DFA29_maxS =
        "\1\121\34\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\14\1\1\2\17\uffff";
    static final String DFA29_specialS =
        "\35\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\15\1\uffff\6\15\1\uffff\1\15\1\uffff\7\15\5\uffff\1\13\1"+
            "\6\1\3\1\4\1\uffff\1\10\1\5\1\uffff\1\7\1\11\4\uffff\1\12\1"+
            "\15\5\uffff\1\2\33\uffff\1\1\3\uffff\1\14",
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "864:24: (vExpressao= expressao )?";
        }
    }
    static final String DFA42_eotS =
        "\75\uffff";
    static final String DFA42_eofS =
        "\75\uffff";
    static final String DFA42_minS =
        "\1\5\43\uffff\1\0\30\uffff";
    static final String DFA42_maxS =
        "\1\121\43\uffff\1\0\30\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\3\71\uffff\1\1\1\2";
    static final String DFA42_specialS =
        "\44\uffff\1\0\30\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\6\1\1\uffff\11\1\5\uffff\4\1\1\uffff\2\1\1\uffff"+
            "\2\1\4\uffff\2\1\1\uffff\1\1\1\uffff\35\1\1\73\1\44\3\uffff"+
            "\1\1",
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
            return "()* loopback of 1099:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_36 = input.LA(1);

                         
                        int index42_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Portugol()) ) {s = 60;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_36);
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
        "\15\uffff";
    static final String DFA47_eofS =
        "\15\uffff";
    static final String DFA47_minS =
        "\1\34\1\uffff\11\0\2\uffff";
    static final String DFA47_maxS =
        "\1\121\1\uffff\11\0\2\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\11\uffff\1\2\1\3";
    static final String DFA47_specialS =
        "\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\13\1\6\1\3\1\4\1\uffff\1\10\1\5\1\uffff\1\7\1\11\4\uffff"+
            "\1\12\6\uffff\1\2\33\uffff\1\1\3\uffff\1\14",
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
            return "1196:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* | listaTokenNot+= '~' )";
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
                        if ( (LA47_0==77) && (synpred4_Portugol())) {s = 1;}

                        else if ( (LA47_0==49) ) {s = 2;}

                        else if ( (LA47_0==ID) ) {s = 3;}

                        else if ( (LA47_0==ID_BIBLIOTECA) ) {s = 4;}

                        else if ( (LA47_0==REAL) ) {s = 5;}

                        else if ( (LA47_0==LOGICO) ) {s = 6;}

                        else if ( (LA47_0==CADEIA) ) {s = 7;}

                        else if ( (LA47_0==INTEIRO) ) {s = 8;}

                        else if ( (LA47_0==CARACTER) ) {s = 9;}

                        else if ( (LA47_0==42) ) {s = 10;}

                        else if ( (LA47_0==OPERADOR_NAO) ) {s = 11;}

                        else if ( (LA47_0==81) ) {s = 12;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_2 = input.LA(1);

                         
                        int index47_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_3 = input.LA(1);

                         
                        int index47_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA47_4 = input.LA(1);

                         
                        int index47_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA47_5 = input.LA(1);

                         
                        int index47_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA47_6 = input.LA(1);

                         
                        int index47_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA47_7 = input.LA(1);

                         
                        int index47_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA47_8 = input.LA(1);

                         
                        int index47_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA47_9 = input.LA(1);

                         
                        int index47_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA47_10 = input.LA(1);

                         
                        int index47_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index47_10);
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
    static final String DFA52_eotS =
        "\103\uffff";
    static final String DFA52_eofS =
        "\103\uffff";
    static final String DFA52_minS =
        "\1\5\1\0\101\uffff";
    static final String DFA52_maxS =
        "\1\123\1\0\101\uffff";
    static final String DFA52_acceptS =
        "\2\uffff\1\2\1\3\76\uffff\1\1";
    static final String DFA52_specialS =
        "\1\0\1\1\101\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\3\1\uffff\6\3\1\uffff\11\3\5\uffff\4\3\1\uffff\2\3\1\uffff"+
            "\2\3\4\uffff\2\3\1\uffff\1\3\1\2\2\3\1\1\42\3",
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

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "1355:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] | vExpressao= referenciaId[$id.getText()] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_0 = input.LA(1);

                         
                        int index52_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA52_0==49) ) {s = 1;}

                        else if ( (LA52_0==46) && (synpred6_Portugol())) {s = 2;}

                        else if ( (LA52_0==PR_REAL||(LA52_0>=PR_LOGICO && LA52_0<=PR_CASO)||(LA52_0>=PR_CONST && LA52_0<=PR_SENAO)||(LA52_0>=OPERADOR_NAO && LA52_0<=ID_BIBLIOTECA)||(LA52_0>=INTEIRO && LA52_0<=REAL)||(LA52_0>=CADEIA && LA52_0<=CARACTER)||(LA52_0>=42 && LA52_0<=43)||LA52_0==45||(LA52_0>=47 && LA52_0<=48)||(LA52_0>=50 && LA52_0<=83)) ) {s = 3;}

                         
                        input.seek(index52_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Portugol()) ) {s = 66;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_programa_in_parse922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa944 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_programa947 = new BitSet(new long[]{0x000008000080C7A0L});
    public static final BitSet FOLLOW_inclusaoBiblioteca_in_programa962 = new BitSet(new long[]{0x000008000080C7A0L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa970 = new BitSet(new long[]{0x000008000000C7A0L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa975 = new BitSet(new long[]{0x000008000000C7A0L});
    public static final BitSet FOLLOW_43_in_programa981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INCLUA_in_inclusaoBiblioteca1004 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca1006 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca1012 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_inclusaoBiblioteca1015 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes1118 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1126 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1137 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaDeclaracoes1159 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1165 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao1204 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_46_in_declaracao1211 = new BitSet(new long[]{0x00028436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_declaracao1218 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracao1222 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_46_in_declaracao1229 = new BitSet(new long[]{0x00028436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_declaracao1236 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracao1240 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_declaracao1247 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_declaracao1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_quantificador1379 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_quantificador1381 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_quantificador1388 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_quantificador1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1461 = new BitSet(new long[]{0x00004000400047E0L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1471 = new BitSet(new long[]{0x0000400040000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1480 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1487 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_declaracaoFuncao1489 = new BitSet(new long[]{0x00040000000047A0L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1495 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_declaracaoFuncao1497 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_declaracaoFuncao1517 = new BitSet(new long[]{0x00020C36F03F4FA0L,0x0000000000022000L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1525 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracaoFuncao1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1590 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaParametrosFuncao1618 = new BitSet(new long[]{0x00000000000047A0L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1624 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1671 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_51_in_declaracaoParametro1678 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1682 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1720 = new BitSet(new long[]{0x00020436F03F4FA2L,0x0000000000022000L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1726 = new BitSet(new long[]{0x00020436F03F4FA2L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_bloco1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARA_in_para1903 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_para1905 = new BitSet(new long[]{0x00120436F00047A0L,0x0000000000022000L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1912 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_para1916 = new BitSet(new long[]{0x00120436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_para1923 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_para1927 = new BitSet(new long[]{0x00060436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_para1934 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_para1942 = new BitSet(new long[]{0x00020436F03F0800L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaBlocos_in_para1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_listaBlocos2020 = new BitSet(new long[]{0x00020C36F03F4FA0L,0x0000000000022000L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos2026 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaBlocos2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARE_in_pare2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha2101 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_escolha2103 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_escolha2109 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_escolha2111 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_escolha2114 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2123 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_escolha2129 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_escolha2131 = new BitSet(new long[]{0x00020436F03F4FA0L,0x0000000000022000L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2137 = new BitSet(new long[]{0x0000080000001000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2152 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PR_CONTRARIO_in_escolha2154 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_escolha2156 = new BitSet(new long[]{0x00020436F03F4FA0L,0x0000000000022000L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2162 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_escolha2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_blocosCaso2212 = new BitSet(new long[]{0x00020C36F03F4FA0L,0x0000000000022000L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2218 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_blocosCaso2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto2259 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_enquanto2261 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_enquanto2267 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_enquanto2269 = new BitSet(new long[]{0x00020436F03F0800L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto2301 = new BitSet(new long[]{0x00020436F03F0800L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2307 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto2309 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_facaEnquanto2311 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2317 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_facaEnquanto2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_SE_in_se2347 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_se2349 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_se2355 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_se2357 = new BitSet(new long[]{0x00020436F03F0800L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaBlocos_in_se2363 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PR_SENAO_in_se2366 = new BitSet(new long[]{0x00020436F03F0800L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaBlocos_in_se2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2401 = new BitSet(new long[]{0x00020436F0000002L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_retorne2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2452 = new BitSet(new long[]{0xFFC1000000000000L});
    public static final BitSet FOLLOW_pilha_in_expressao2458 = new BitSet(new long[]{0xFFC1000000000002L});
    public static final BitSet FOLLOW_48_in_expressao2472 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_54_in_expressao2480 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_55_in_expressao2488 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_56_in_expressao2496 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_57_in_expressao2504 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_58_in_expressao2512 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_59_in_expressao2520 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_60_in_expressao2528 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_61_in_expressao2536 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_62_in_expressao2544 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_63_in_expressao2552 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao2_in_expressao2565 = new BitSet(new long[]{0xFFC1000000000002L});
    public static final BitSet FOLLOW_expressao2_5_in_expressao22604 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_64_in_expressao22633 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_65_in_expressao22641 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao2_5_in_expressao22653 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expressao3_in_expressao2_52686 = new BitSet(new long[]{0x0008000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_51_in_expressao2_52715 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_66_in_expressao2_52723 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_67_in_expressao2_52731 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao3_in_expressao2_52743 = new BitSet(new long[]{0x0008000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_expressao4_in_expressao32777 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_expressao32798 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_69_in_expressao32806 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao4_in_expressao32819 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_expressao4_5_in_expressao42853 = new BitSet(new long[]{0x0000000000000002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_70_in_expressao42861 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_71_in_expressao42869 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_72_in_expressao42877 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_73_in_expressao42885 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao4_5_in_expressao42892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao5_in_expressao4_52921 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_74_in_expressao4_52950 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_75_in_expressao4_52958 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao5_in_expressao4_52970 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_expressao6_in_expressao53004 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_expressao53035 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao6_in_expressao53041 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_77_in_expressao53099 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao6_in_expressao53105 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_expressao7_in_expressao63154 = new BitSet(new long[]{0x0000000000000002L,0x000000000001C000L});
    public static final BitSet FOLLOW_78_in_expressao63177 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_79_in_expressao63185 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_80_in_expressao63193 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao7_in_expressao63206 = new BitSet(new long[]{0x0000000000000002L,0x000000000001C000L});
    public static final BitSet FOLLOW_77_in_expressao73248 = new BitSet(new long[]{0x00020436E0000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao73259 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_81_in_expressao73269 = new BitSet(new long[]{0x00020436E0000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_expressao8_in_expressao73278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_expressao83312 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_expressao83318 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_expressao83320 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_referencia_in_expressao83330 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao83339 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao83349 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_82_in_expressao83362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_expressao83370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_referencia3495 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_ID_BIBLIOTECA_in_referencia3503 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_referenciaVetorMatriz3612 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3618 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_referenciaVetorMatriz3620 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_referenciaVetorMatriz3623 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3629 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_referenciaVetorMatriz3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_chamadaFuncao3663 = new BitSet(new long[]{0x00060436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3670 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_chamadaFuncao3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3709 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaParametros3725 = new BitSet(new long[]{0x00020436F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3731 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_vetor3820 = new BitSet(new long[]{0x00022C36F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3826 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_vetor3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_matriz3865 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3873 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_matriz3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_listaListaExpressoes3909 = new BitSet(new long[]{0x00022C36F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3915 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaListaExpressoes3917 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaListaExpressoes3932 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_listaListaExpressoes3935 = new BitSet(new long[]{0x00022C36F0000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3941 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_listaListaExpressoes3943 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3989 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaExpressoes4003 = new BitSet(new long[]{0x00022436F0000002L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes4010 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_42_in_synpred1_Portugol2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred2_Portugol2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_synpred3_Portugol3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_synpred4_Portugol3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred5_Portugol3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred6_Portugol3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred7_Portugol3768 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred7_Portugol3770 = new BitSet(new long[]{0x0000000000000002L});

}