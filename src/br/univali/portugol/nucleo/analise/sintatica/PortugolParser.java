// $ANTLR 3.4 /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2013-07-08 18:05:20


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

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PortugolParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CADEIA", "CARACTER", "COMENTARIO", "DIGIT_HEX", "ESC_OCTAL", "ESC_UNICODE", "ESPACO", "GAMBIARRA", "ID", "ID_BIBLIOTECA", "INTEIRO", "LOGICO", "OPERADOR_NAO", "PR_BIBLIOTECA", "PR_CADEIA", "PR_CARACTER", "PR_CASO", "PR_CONST", "PR_CONTRARIO", "PR_ENQUANTO", "PR_ESCOLHA", "PR_FACA", "PR_FALSO", "PR_FUNCAO", "PR_INCLUA", "PR_INTEIRO", "PR_LOGICO", "PR_PARA", "PR_PARE", "PR_PROGRAMA", "PR_REAL", "PR_RETORNE", "PR_SE", "PR_SENAO", "PR_VAZIO", "PR_VERDADEIRO", "REAL", "SEQ_ESC", "'!='", "'%'", "'%='", "'&'", "'&='", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-->'", "'-='", "'/'", "'/='", "':'", "';'", "'<'", "'<<'", "'<<='", "'<='", "'='", "'=='", "'>'", "'>='", "'>>'", "'>>='", "'['", "']'", "'^'", "'^='", "'e'", "'ou'", "'{'", "'|'", "'|='", "'}'"
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
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int CADEIA=4;
    public static final int CARACTER=5;
    public static final int COMENTARIO=6;
    public static final int DIGIT_HEX=7;
    public static final int ESC_OCTAL=8;
    public static final int ESC_UNICODE=9;
    public static final int ESPACO=10;
    public static final int GAMBIARRA=11;
    public static final int ID=12;
    public static final int ID_BIBLIOTECA=13;
    public static final int INTEIRO=14;
    public static final int LOGICO=15;
    public static final int OPERADOR_NAO=16;
    public static final int PR_BIBLIOTECA=17;
    public static final int PR_CADEIA=18;
    public static final int PR_CARACTER=19;
    public static final int PR_CASO=20;
    public static final int PR_CONST=21;
    public static final int PR_CONTRARIO=22;
    public static final int PR_ENQUANTO=23;
    public static final int PR_ESCOLHA=24;
    public static final int PR_FACA=25;
    public static final int PR_FALSO=26;
    public static final int PR_FUNCAO=27;
    public static final int PR_INCLUA=28;
    public static final int PR_INTEIRO=29;
    public static final int PR_LOGICO=30;
    public static final int PR_PARA=31;
    public static final int PR_PARE=32;
    public static final int PR_PROGRAMA=33;
    public static final int PR_REAL=34;
    public static final int PR_RETORNE=35;
    public static final int PR_SE=36;
    public static final int PR_SENAO=37;
    public static final int PR_VAZIO=38;
    public static final int PR_VERDADEIRO=39;
    public static final int REAL=40;
    public static final int SEQ_ESC=41;

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
    public String getGrammarFileName() { return "/home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g"; }


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
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:202:1: parse returns [ArvoreSintaticaAbstrata asa] : prog= programa ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;


        ArvoreSintaticaAbstrata prog =null;


        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:202:43: (prog= programa )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:204:2: prog= programa
            {
            pushFollow(FOLLOW_programa_in_parse907);
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
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:211:1: programa returns [ArvoreSintaticaAbstrata asa] : PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata programa() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;



        	pilhaContexto.push("programa");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:214:2: ( PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:216:2: PR_PROGRAMA '{' ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )* ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            match(input,PR_PROGRAMA,FOLLOW_PR_PROGRAMA_in_programa929); if (state.failed) return asa;

            match(input,79,FOLLOW_79_in_programa932); if (state.failed) return asa;

            if ( state.backtracking==0 ) {
            			if (gerarArvore)
            			{
            		 		asa = new ArvoreSintaticaAbstrataPrograma();
            				asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
            				((ArvoreSintaticaAbstrataPrograma) asa).setListaInclusoesBibliotecas(new ArrayList<NoInclusaoBiblioteca>());
            			}
            		 }

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:4: ( inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PR_INCLUA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:227:4: inclusaoBiblioteca[(ArvoreSintaticaAbstrataPrograma ) asa]
            	    {
            	    pushFollow(FOLLOW_inclusaoBiblioteca_in_programa947);
            	    inclusaoBiblioteca((ArvoreSintaticaAbstrataPrograma ) asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= PR_CADEIA && LA2_0 <= PR_CARACTER)||LA2_0==PR_CONST||(LA2_0 >= PR_INTEIRO && LA2_0 <= PR_LOGICO)||LA2_0==PR_REAL) ) {
                    alt2=1;
                }
                else if ( (LA2_0==PR_FUNCAO) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_programa955);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:229:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_programa960);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,82,FOLLOW_82_in_programa966); if (state.failed) return asa;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return asa;
    }
    // $ANTLR end "programa"



    // $ANTLR start "inclusaoBiblioteca"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:237:1: inclusaoBiblioteca[ArvoreSintaticaAbstrataPrograma asa] : incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? ;
    public final void inclusaoBiblioteca(ArvoreSintaticaAbstrataPrograma asa) throws RecognitionException {
        Token incl=null;
        Token nome=null;
        Token alias=null;


        	pilhaContexto.push("inclusaoBiblioteca");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:240:2: (incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:2: incl= PR_INCLUA PR_BIBLIOTECA nome= ID ( '-->' alias= ID )?
            {
            incl=(Token)match(input,PR_INCLUA,FOLLOW_PR_INCLUA_in_inclusaoBiblioteca989); if (state.failed) return ;

            match(input,PR_BIBLIOTECA,FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca991); if (state.failed) return ;

            nome=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca997); if (state.failed) return ;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:43: ( '-->' alias= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==57) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:241:44: '-->' alias= ID
                    {
                    match(input,57,FOLLOW_57_in_inclusaoBiblioteca1000); if (state.failed) return ;

                    alias=(Token)match(input,ID,FOLLOW_ID_in_inclusaoBiblioteca1007); if (state.failed) return ;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "inclusaoBiblioteca"



    // $ANTLR start "declaracoesGlobais"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:278:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes =null;



        	pilhaContexto.push("declaracoesGlobais");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:281:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:283:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais1038);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracoesGlobais"



    // $ANTLR start "declaracoesLocais"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:306:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes =null;



        	pilhaContexto.push("declaracoesLocais");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:309:2: (vListaDeclaracoes= listaDeclaracoes )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:311:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais1066);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracoesLocais"



    // $ANTLR start "listaDeclaracoes"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:329:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;


        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado =null;

        NoDeclaracao vDeclaracao =null;



        	pilhaContexto.push("listaDeclaracoes");
        	listaDeclaracoes = new ArrayList<NoDeclaracao>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:333:2: ( ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:334:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:334:2: ( (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:335:2: (tokenConst= PR_CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {tokenConst = null; }

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:337:2: (tokenConst= PR_CONST )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PR_CONST) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:337:3: tokenConst= PR_CONST
                    {
                    tokenConst=(Token)match(input,PR_CONST,FOLLOW_PR_CONST_in_listaDeclaracoes1103); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }


            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1111);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:339:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:339:4: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1122);
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


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:350:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==54) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:350:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,54,FOLLOW_54_in_listaDeclaracoes1144); if (state.failed) return listaDeclaracoes;

            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1150);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return listaDeclaracoes;
    }
    // $ANTLR end "listaDeclaracoes"



    // $ANTLR start "declaracao"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:368:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
    public final NoDeclaracao declaracao(Token tokenConst, InformacaoTipoDado informacaoTipoDado) throws RecognitionException {
        NoDeclaracao declaracao = null;


        Token tk1=null;
        Token tk2=null;
        Token ID1=null;
        NoExpressao ind1 =null;

        NoExpressao ind2 =null;

        NoExpressao inicializacao =null;



        	pilhaContexto.push("declaracao");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:371:2: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao1189); if (state.failed) return declaracao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==73) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,73,FOLLOW_73_in_declaracao1196); if (state.failed) return declaracao;

                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:17: (ind1= expressao )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0 >= CADEIA && LA6_0 <= CARACTER)||(LA6_0 >= ID && LA6_0 <= OPERADOR_NAO)||LA6_0==REAL||LA6_0==47||LA6_0==55||LA6_0==79) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao1203);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }


                    match(input,74,FOLLOW_74_in_declaracao1207); if (state.failed) return declaracao;

                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==73) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,73,FOLLOW_73_in_declaracao1214); if (state.failed) return declaracao;

                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:52: (ind2= expressao )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( ((LA7_0 >= CADEIA && LA7_0 <= CARACTER)||(LA7_0 >= ID && LA7_0 <= OPERADOR_NAO)||LA7_0==REAL||LA7_0==47||LA7_0==55||LA7_0==79) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao1221);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }


                            match(input,74,FOLLOW_74_in_declaracao1225); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:80: ( '=' inicializacao= expressao )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==67) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:373:81: '=' inicializacao= expressao
                    {
                    match(input,67,FOLLOW_67_in_declaracao1232); if (state.failed) return declaracao;

                    pushFollow(FOLLOW_expressao_in_declaracao1238);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return declaracao;
    }
    // $ANTLR end "declaracao"



    // $ANTLR start "declaracaoTipoDado"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:406:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        Token tokenTipoDado=null;


        	pilhaContexto.push("declaracaoTipoDado");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:409:2: ( (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:2: (tokenTipoDado= PR_INTEIRO |tokenTipoDado= PR_REAL |tokenTipoDado= PR_CARACTER |tokenTipoDado= PR_CADEIA |tokenTipoDado= PR_LOGICO )
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
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:3: tokenTipoDado= PR_INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,PR_INTEIRO,FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1273); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:32: tokenTipoDado= PR_REAL
                    {
                    tokenTipoDado=(Token)match(input,PR_REAL,FOLLOW_PR_REAL_in_declaracaoTipoDado1281); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:58: tokenTipoDado= PR_CARACTER
                    {
                    tokenTipoDado=(Token)match(input,PR_CARACTER,FOLLOW_PR_CARACTER_in_declaracaoTipoDado1289); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:88: tokenTipoDado= PR_CADEIA
                    {
                    tokenTipoDado=(Token)match(input,PR_CADEIA,FOLLOW_PR_CADEIA_in_declaracaoTipoDado1297); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:411:116: tokenTipoDado= PR_LOGICO
                    {
                    tokenTipoDado=(Token)match(input,PR_LOGICO,FOLLOW_PR_LOGICO_in_declaracaoTipoDado1305); if (state.failed) return informacaoTipoDado;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDado"



    // $ANTLR start "declaracaoTipoDadoVazio"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:427:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : PR_VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        Token PR_VAZIO2=null;


        	pilhaContexto.push("declaracaoTipoDadoVazio");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:430:2: ( PR_VAZIO )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:432:2: PR_VAZIO
            {
            PR_VAZIO2=(Token)match(input,PR_VAZIO,FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1332); if (state.failed) return informacaoTipoDado;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDadoVazio"



    // $ANTLR start "quantificador"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:449:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;


        Token tk1=null;
        Token tk2=null;


        	pilhaContexto.push("quantificador");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:452:2: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==73) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,73,FOLLOW_73_in_quantificador1364); if (state.failed) return quantificador;

                    match(input,74,FOLLOW_74_in_quantificador1366); if (state.failed) return quantificador;

                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:17: (tk2= '[' ']' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==73) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:454:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,73,FOLLOW_73_in_quantificador1373); if (state.failed) return quantificador;

                            match(input,74,FOLLOW_74_in_quantificador1375); if (state.failed) return quantificador;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return quantificador;
    }
    // $ANTLR end "quantificador"



    // $ANTLR start "tipoRetornoFuncao"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:472:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;


        InformacaoTipoDado informacao =null;



        	pilhaContexto.push("tipoRetornoFuncao");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:475:2: ( (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:2: (informacao= declaracaoTipoDado |informacao= declaracaoTipoDadoVazio )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0 >= PR_CADEIA && LA14_0 <= PR_CARACTER)||(LA14_0 >= PR_INTEIRO && LA14_0 <= PR_LOGICO)||LA14_0==PR_REAL) ) {
                alt14=1;
            }
            else if ( (LA14_0==PR_VAZIO) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1411);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:477:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1419);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return informacaoTipoDado;
    }
    // $ANTLR end "tipoRetornoFuncao"



    // $ANTLR start "declaracaoFuncao"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:497:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado =null;

        Quantificador vQuantificador =null;

        List<NoDeclaracaoParametro> vListaParametros =null;

        List<NoBloco> vBlocos =null;



        	pilhaContexto.push("declaracaoFuncao");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:500:2: ( PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:502:2: PR_FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,PR_FUNCAO,FOLLOW_PR_FUNCAO_in_declaracaoFuncao1446); if (state.failed) return ;

            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1456);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1465);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;

            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1472); if (state.failed) return ;

            match(input,47,FOLLOW_47_in_declaracaoFuncao1474); if (state.failed) return ;

            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1480);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;

            match(input,48,FOLLOW_48_in_declaracaoFuncao1482); if (state.failed) return ;

            match(input,79,FOLLOW_79_in_declaracaoFuncao1502); if (state.failed) return ;

            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1510);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;

            match(input,82,FOLLOW_82_in_declaracaoFuncao1520); if (state.failed) return ;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return ;
    }
    // $ANTLR end "declaracaoFuncao"



    // $ANTLR start "listaParametrosFuncao"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:533:1: listaParametrosFuncao returns [List<NoDeclaracaoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoDeclaracaoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoDeclaracaoParametro> listaParametros = null;


        NoDeclaracaoParametro vDeclaracaoParametro =null;



        	pilhaContexto.push("listaParametrosFuncao");
        	listaParametros = new ArrayList<NoDeclaracaoParametro>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:537:2: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:538:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0 >= PR_CADEIA && LA16_0 <= PR_CARACTER)||(LA16_0 >= PR_INTEIRO && LA16_0 <= PR_LOGICO)||LA16_0==PR_REAL) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:3: (vDeclaracaoParametro= declaracaoParametro )
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:539:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1575);
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


                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:548:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==54) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:548:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,54,FOLLOW_54_in_listaParametrosFuncao1603); if (state.failed) return listaParametros;

                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1609);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametrosFuncao"



    // $ANTLR start "declaracaoParametro"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:564:1: declaracaoParametro returns [NoDeclaracaoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoDeclaracaoParametro declaracaoParametro() throws RecognitionException {
        NoDeclaracaoParametro parametro = null;


        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado =null;

        Quantificador vQuantificador =null;



        	pilhaContexto.push("declaracaoParametro");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:567:2: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1656);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:42: (tkr= '&' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==45) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:569:43: tkr= '&'
                    {
                    tkr=(Token)match(input,45,FOLLOW_45_in_declaracaoParametro1663); if (state.failed) return parametro;

                    }
                    break;

            }


            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1667); if (state.failed) return parametro;

            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1673);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return parametro;
    }
    // $ANTLR end "declaracaoParametro"



    // $ANTLR start "blocos"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:600:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;


        NoBloco vBloco =null;



        	pilhaContexto.push("blocos");
        	blocos = new ArrayList<NoBloco>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:604:2: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:605:2: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:605:2: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= CADEIA && LA18_0 <= CARACTER)||(LA18_0 >= ID && LA18_0 <= OPERADOR_NAO)||(LA18_0 >= PR_ENQUANTO && LA18_0 <= PR_FACA)||(LA18_0 >= PR_PARA && LA18_0 <= PR_PARE)||(LA18_0 >= PR_RETORNE && LA18_0 <= PR_SE)||LA18_0==REAL||LA18_0==47||LA18_0==55||LA18_0==79) ) {
                    alt18=1;
                }
                else if ( ((LA18_0 >= PR_CADEIA && LA18_0 <= PR_CARACTER)||LA18_0==PR_CONST||(LA18_0 >= PR_INTEIRO && LA18_0 <= PR_LOGICO)||LA18_0==PR_REAL) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:606:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1705);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;

            	    if ( state.backtracking==0 ) { blocos.add(vBloco); }

            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:606:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1711);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return blocos;
    }
    // $ANTLR end "blocos"



    // $ANTLR start "bloco"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:615:1: bloco returns [NoBloco bloco] : (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) ;
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



        	pilhaContexto.push("bloco");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:618:2: ( (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:619:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:619:3: (vExpressao= expressao |vPara= para |vPare= pare |vRetorne= retorne |vSe= se |vEnquanto= enquanto |vFacaEnquanto= facaEnquanto |vEscolha= escolha )
            int alt19=8;
            switch ( input.LA(1) ) {
            case CADEIA:
            case CARACTER:
            case ID:
            case ID_BIBLIOTECA:
            case INTEIRO:
            case LOGICO:
            case OPERADOR_NAO:
            case REAL:
            case 47:
            case 55:
            case 79:
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
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:620:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1745);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vExpressao; 	}

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:621:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1760);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vPara; 	 	}

                    }
                    break;
                case 3 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:622:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1778);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vPare; 	 	}

                    }
                    break;
                case 4 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:623:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1795);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vRetorne; 	 	}

                    }
                    break;
                case 5 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:624:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1811);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vSe; 		}

                    }
                    break;
                case 6 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:625:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1828);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vEnquanto;		}

                    }
                    break;
                case 7 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:626:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1842);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;

                    if ( state.backtracking==0 ) { bloco = vFacaEnquanto; 	}

                    }
                    break;
                case 8 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:627:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1856);
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

            	pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "bloco"



    // $ANTLR start "para"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:636:1: para returns [NoPara para] : PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;


        NoBloco inicializacao =null;

        NoExpressao condicao =null;

        NoExpressao incremento =null;

        List<NoBloco> vBlocos =null;



        	pilhaContexto.push("para");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:639:2: ( PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:2: PR_PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
            match(input,PR_PARA,FOLLOW_PR_PARA_in_para1888); if (state.failed) return para;

            match(input,47,FOLLOW_47_in_para1890); if (state.failed) return para;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:14: (inicializacao= inicializacaoPara )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0 >= CADEIA && LA20_0 <= CARACTER)||(LA20_0 >= ID && LA20_0 <= OPERADOR_NAO)||(LA20_0 >= PR_CADEIA && LA20_0 <= PR_CARACTER)||LA20_0==PR_CONST||(LA20_0 >= PR_INTEIRO && LA20_0 <= PR_LOGICO)||LA20_0==PR_REAL||LA20_0==REAL||LA20_0==47||LA20_0==55||LA20_0==79) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:15: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1897);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,62,FOLLOW_62_in_para1901); if (state.failed) return para;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:55: (condicao= expressao )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0 >= CADEIA && LA21_0 <= CARACTER)||(LA21_0 >= ID && LA21_0 <= OPERADOR_NAO)||LA21_0==REAL||LA21_0==47||LA21_0==55||LA21_0==79) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:56: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1908);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,62,FOLLOW_62_in_para1912); if (state.failed) return para;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:83: (incremento= expressao )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0 >= CADEIA && LA22_0 <= CARACTER)||(LA22_0 >= ID && LA22_0 <= OPERADOR_NAO)||LA22_0==REAL||LA22_0==47||LA22_0==55||LA22_0==79) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:641:84: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1919);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }


            match(input,48,FOLLOW_48_in_para1923); if (state.failed) return para;

            pushFollow(FOLLOW_listaBlocos_in_para1929);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return para;
    }
    // $ANTLR end "para"



    // $ANTLR start "inicializacaoPara"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:659:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;


        NoExpressao vExpressao =null;

        List<NoDeclaracao> vListaDeclaracoes =null;



        	pilhaContexto.push("inicializacaoPara");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:662:2: ( (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:2: (vExpressao= expressao |vListaDeclaracoes= listaDeclaracoes )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0 >= CADEIA && LA23_0 <= CARACTER)||(LA23_0 >= ID && LA23_0 <= OPERADOR_NAO)||LA23_0==REAL||LA23_0==47||LA23_0==55||LA23_0==79) ) {
                alt23=1;
            }
            else if ( ((LA23_0 >= PR_CADEIA && LA23_0 <= PR_CARACTER)||LA23_0==PR_CONST||(LA23_0 >= PR_INTEIRO && LA23_0 <= PR_LOGICO)||LA23_0==PR_REAL) ) {
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
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1960);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:664:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1968);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return bloco;
    }
    // $ANTLR end "inicializacaoPara"



    // $ANTLR start "listaBlocos"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:680:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vListaBlocos =null;

        NoBloco vBloco =null;



        	pilhaContexto.push("listaBlocos");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:683:2: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:684:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:684:2: ( ( '{' )=> '{' vListaBlocos= blocos '}' |vBloco= bloco )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==79) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred1_Portugol()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA24_0 >= CADEIA && LA24_0 <= CARACTER)||(LA24_0 >= ID && LA24_0 <= OPERADOR_NAO)||(LA24_0 >= PR_ENQUANTO && LA24_0 <= PR_FACA)||(LA24_0 >= PR_PARA && LA24_0 <= PR_PARE)||(LA24_0 >= PR_RETORNE && LA24_0 <= PR_SE)||LA24_0==REAL||LA24_0==47||LA24_0==55) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,79,FOLLOW_79_in_listaBlocos2001); if (state.failed) return listaBlocos;

                    pushFollow(FOLLOW_blocos_in_listaBlocos2007);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    if ( state.backtracking==0 ) { listaBlocos = vListaBlocos; }

                    match(input,82,FOLLOW_82_in_listaBlocos2011); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:689:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos2027);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "listaBlocos"



    // $ANTLR start "pare"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:705:1: pare returns [NoPare pare] : PR_PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;


        Token PR_PARE5=null;


        	pilhaContexto.push("pare");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:708:2: ( PR_PARE )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:710:2: PR_PARE
            {
            PR_PARE5=(Token)match(input,PR_PARE,FOLLOW_PR_PARE_in_pare2055); if (state.failed) return pare;

            if ( state.backtracking==0 ) {
            		if (gerarArvore)
            		{
            			pare = new NoPare();
            			pare.setTrechoCodigoFonte(criarTrechoCodigoFonte(PR_PARE5));
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

            	pilhaContexto.pop();

        }
        return pare;
    }
    // $ANTLR end "pare"



    // $ANTLR start "escolha"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:726:1: escolha returns [NoEscolha escolha] : PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;


        NoExpressao vExpressaoEscolha =null;

        NoExpressao vExpressao =null;

        List<NoBloco> vBlocos =null;



        	pilhaContexto.push("escolha");
        	List<NoCaso> casos =  new ArrayList<NoCaso>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:730:2: ( PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:732:2: PR_ESCOLHA '(' vExpressaoEscolha= expressao ')' '{' ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+ ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )? '}'
            {
            match(input,PR_ESCOLHA,FOLLOW_PR_ESCOLHA_in_escolha2082); if (state.failed) return escolha;

            match(input,47,FOLLOW_47_in_escolha2084); if (state.failed) return escolha;

            pushFollow(FOLLOW_expressao_in_escolha2090);
            vExpressaoEscolha=expressao();

            state._fsp--;
            if (state.failed) return escolha;

            match(input,48,FOLLOW_48_in_escolha2092); if (state.failed) return escolha;

            match(input,79,FOLLOW_79_in_escolha2095); if (state.failed) return escolha;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:735:3: ( PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PR_CASO) ) {
                    int LA25_1 = input.LA(2);

                    if ( ((LA25_1 >= CADEIA && LA25_1 <= CARACTER)||(LA25_1 >= ID && LA25_1 <= OPERADOR_NAO)||LA25_1==REAL||LA25_1==47||LA25_1==55||LA25_1==79) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:735:4: PR_CASO vExpressao= expressao ':' vBlocos= blocosCaso
            	    {
            	    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2104); if (state.failed) return escolha;

            	    pushFollow(FOLLOW_expressao_in_escolha2110);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return escolha;

            	    match(input,61,FOLLOW_61_in_escolha2112); if (state.failed) return escolha;

            	    pushFollow(FOLLOW_blocosCaso_in_escolha2118);
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


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:747:4: ( PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PR_CASO) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:747:5: PR_CASO PR_CONTRARIO ':' vBlocos= blocosCaso
                    {
                    match(input,PR_CASO,FOLLOW_PR_CASO_in_escolha2133); if (state.failed) return escolha;

                    match(input,PR_CONTRARIO,FOLLOW_PR_CONTRARIO_in_escolha2135); if (state.failed) return escolha;

                    match(input,61,FOLLOW_61_in_escolha2137); if (state.failed) return escolha;

                    pushFollow(FOLLOW_blocosCaso_in_escolha2143);
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


            match(input,82,FOLLOW_82_in_escolha2157); if (state.failed) return escolha;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return escolha;
    }
    // $ANTLR end "escolha"



    // $ANTLR start "blocosCaso"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:775:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;


        List<NoBloco> vBlocos =null;



        	pilhaContexto.push("blocosCaso");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:778:2: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==79) ) {
                int LA27_1 = input.LA(2);

                if ( (synpred2_Portugol()) ) {
                    alt27=1;
                }
                else if ( (true) ) {
                    alt27=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA27_0 >= CADEIA && LA27_0 <= CARACTER)||(LA27_0 >= ID && LA27_0 <= OPERADOR_NAO)||(LA27_0 >= PR_CADEIA && LA27_0 <= PR_CONST)||(LA27_0 >= PR_ENQUANTO && LA27_0 <= PR_FACA)||(LA27_0 >= PR_INTEIRO && LA27_0 <= PR_PARE)||(LA27_0 >= PR_REAL && LA27_0 <= PR_SE)||LA27_0==REAL||LA27_0==47||LA27_0==55||LA27_0==82) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return listaBlocos;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:12: ( '{' vBlocos= blocos '}' )
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:13: '{' vBlocos= blocos '}'
                    {
                    match(input,79,FOLLOW_79_in_blocosCaso2193); if (state.failed) return listaBlocos;

                    pushFollow(FOLLOW_blocos_in_blocosCaso2199);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;

                    match(input,82,FOLLOW_82_in_blocosCaso2201); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:41: (vBlocos= blocos )
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:41: (vBlocos= blocos )
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso2211);
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

            	pilhaContexto.pop();

        }
        return listaBlocos;
    }
    // $ANTLR end "blocosCaso"



    // $ANTLR start "enquanto"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:791:1: enquanto returns [NoEnquanto enquanto] : PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;


        NoExpressao vExpressao =null;

        List<NoBloco> vListaBlocos =null;



        	pilhaContexto.push("enquanto");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:794:2: ( PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:796:2: PR_ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_enquanto2240); if (state.failed) return enquanto;

            match(input,47,FOLLOW_47_in_enquanto2242); if (state.failed) return enquanto;

            pushFollow(FOLLOW_expressao_in_enquanto2248);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;

            match(input,48,FOLLOW_48_in_enquanto2250); if (state.failed) return enquanto;

            pushFollow(FOLLOW_listaBlocos_in_enquanto2256);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return enquanto;
    }
    // $ANTLR end "enquanto"



    // $ANTLR start "facaEnquanto"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:811:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;


        List<NoBloco> vListaBlocos =null;

        NoExpressao vExpressao =null;



        	pilhaContexto.push("facaEnquanto");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:814:2: ( PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:816:2: PR_FACA vListaBlocos= listaBlocos PR_ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,PR_FACA,FOLLOW_PR_FACA_in_facaEnquanto2282); if (state.failed) return facaEnquanto;

            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2288);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;

            match(input,PR_ENQUANTO,FOLLOW_PR_ENQUANTO_in_facaEnquanto2290); if (state.failed) return facaEnquanto;

            match(input,47,FOLLOW_47_in_facaEnquanto2292); if (state.failed) return facaEnquanto;

            pushFollow(FOLLOW_expressao_in_facaEnquanto2298);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;

            match(input,48,FOLLOW_48_in_facaEnquanto2300); if (state.failed) return facaEnquanto;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return facaEnquanto;
    }
    // $ANTLR end "facaEnquanto"



    // $ANTLR start "se"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:832:1: se returns [NoSe se] : PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;


        NoExpressao vExpressao =null;

        List<NoBloco> vListaBlocos =null;

        List<NoBloco> listaBlocosSenao =null;



        	pilhaContexto.push("se");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:835:2: ( PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:2: PR_SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( PR_SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,PR_SE,FOLLOW_PR_SE_in_se2328); if (state.failed) return se;

            match(input,47,FOLLOW_47_in_se2330); if (state.failed) return se;

            pushFollow(FOLLOW_expressao_in_se2336);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;

            match(input,48,FOLLOW_48_in_se2338); if (state.failed) return se;

            pushFollow(FOLLOW_listaBlocos_in_se2344);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:66: ( PR_SENAO listaBlocosSenao= listaBlocos )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PR_SENAO) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:837:67: PR_SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,PR_SENAO,FOLLOW_PR_SENAO_in_se2347); if (state.failed) return se;

                    pushFollow(FOLLOW_listaBlocos_in_se2353);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return se;
    }
    // $ANTLR end "se"



    // $ANTLR start "retorne"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:853:1: retorne returns [NoRetorne retorne] : PR_RETORNE vExpressao= expressao ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;


        NoExpressao vExpressao =null;



        	pilhaContexto.push("retorne");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:856:2: ( PR_RETORNE vExpressao= expressao )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:858:2: PR_RETORNE vExpressao= expressao
            {
            match(input,PR_RETORNE,FOLLOW_PR_RETORNE_in_retorne2382); if (state.failed) return retorne;

            pushFollow(FOLLOW_expressao_in_retorne2388);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return retorne;
    }
    // $ANTLR end "retorne"



    // $ANTLR start "pilha"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:872:1: pilha returns [Stack<Object> pilha] :;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;


        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:872:35: ()
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:873:1: 
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
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:879:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        Stack<Object> vPilha =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:882:2: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' ) operandoDireito= expressao2 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:884:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2432);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;

            pushFollow(FOLLOW_pilha_in_expressao2438);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;

            if ( state.backtracking==0 ) { vPilha.push(operandoEsquerdo); }

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:885:2: ( (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' ) operandoDireito= expressao2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==44||LA30_0==46||LA30_0==50||LA30_0==53||LA30_0==58||LA30_0==60||LA30_0==65||LA30_0==67||LA30_0==72||LA30_0==76||LA30_0==81) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' ) operandoDireito= expressao2
            	    {
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:3: (operador= '=' |operador= '+=' |operador= '-=' |operador= '/=' |operador= '*=' |operador= '%=' |operador= '>>=' |operador= '<<=' |operador= '|=' |operador= '&=' |operador= '^=' )
            	    int alt29=11;
            	    switch ( input.LA(1) ) {
            	    case 67:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case 58:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    case 60:
            	        {
            	        alt29=4;
            	        }
            	        break;
            	    case 50:
            	        {
            	        alt29=5;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt29=6;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt29=7;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt29=8;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt29=9;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt29=10;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt29=11;
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
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:4: operador= '='
            	            {
            	            operador=(Token)match(input,67,FOLLOW_67_in_expressao2452); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:21: operador= '+='
            	            {
            	            operador=(Token)match(input,53,FOLLOW_53_in_expressao2460); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:39: operador= '-='
            	            {
            	            operador=(Token)match(input,58,FOLLOW_58_in_expressao2468); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:57: operador= '/='
            	            {
            	            operador=(Token)match(input,60,FOLLOW_60_in_expressao2476); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:75: operador= '*='
            	            {
            	            operador=(Token)match(input,50,FOLLOW_50_in_expressao2484); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:93: operador= '%='
            	            {
            	            operador=(Token)match(input,44,FOLLOW_44_in_expressao2492); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 7 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:111: operador= '>>='
            	            {
            	            operador=(Token)match(input,72,FOLLOW_72_in_expressao2500); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 8 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:130: operador= '<<='
            	            {
            	            operador=(Token)match(input,65,FOLLOW_65_in_expressao2508); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 9 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:149: operador= '|='
            	            {
            	            operador=(Token)match(input,81,FOLLOW_81_in_expressao2516); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 10 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:167: operador= '&='
            	            {
            	            operador=(Token)match(input,46,FOLLOW_46_in_expressao2524); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 11 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:886:185: operador= '^='
            	            {
            	            operador=(Token)match(input,76,FOLLOW_76_in_expressao2532); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao2_in_expressao2545);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao"



    // $ANTLR start "expressao2"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:929:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao2_5 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao2_5 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao2");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:932:2: (operandoEsquerdo= expressao2_5 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao2_5 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:934:2: operandoEsquerdo= expressao2_5 ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao2_5 )*
            {
            pushFollow(FOLLOW_expressao2_5_in_expressao22584);
            operandoEsquerdo=expressao2_5();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:935:2: ( (operador= 'e' |operador= 'ou' ) operandoDireito= expressao2_5 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= 77 && LA32_0 <= 78)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:936:3: (operador= 'e' |operador= 'ou' ) operandoDireito= expressao2_5
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

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:949:3: (operador= 'e' |operador= 'ou' )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==77) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==78) ) {
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
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:949:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,77,FOLLOW_77_in_expressao22613); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:949:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,78,FOLLOW_78_in_expressao22621); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao2_5_in_expressao22633);
            	    operandoDireito=expressao2_5();

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao2"



    // $ANTLR start "expressao2_5"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:965:1: expressao2_5 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= '&' |operador= '|' |operador= '^' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2_5() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao2_5");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:968:2: (operandoEsquerdo= expressao3 ( (operador= '&' |operador= '|' |operador= '^' ) operandoDireito= expressao3 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:969:2: operandoEsquerdo= expressao3 ( (operador= '&' |operador= '|' |operador= '^' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao2_52666);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:970:5: ( (operador= '&' |operador= '|' |operador= '^' ) operandoDireito= expressao3 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==45||LA34_0==75||LA34_0==80) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:971:3: (operador= '&' |operador= '|' |operador= '^' ) operandoDireito= expressao3
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

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:983:3: (operador= '&' |operador= '|' |operador= '^' )
            	    int alt33=3;
            	    switch ( input.LA(1) ) {
            	    case 45:
            	        {
            	        alt33=1;
            	        }
            	        break;
            	    case 80:
            	        {
            	        alt33=2;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt33=3;
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
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:983:4: operador= '&'
            	            {
            	            operador=(Token)match(input,45,FOLLOW_45_in_expressao2_52695); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:983:21: operador= '|'
            	            {
            	            operador=(Token)match(input,80,FOLLOW_80_in_expressao2_52703); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:983:38: operador= '^'
            	            {
            	            operador=(Token)match(input,75,FOLLOW_75_in_expressao2_52711); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao3_in_expressao2_52723);
            	    operandoDireito=expressao3();

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao2_5"



    // $ANTLR start "expressao3"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:999:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao3");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1002:2: (operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1004:2: operandoEsquerdo= expressao4 ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32757);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1005:2: ( (operador= '==' |operador= '!=' ) operandoDireito= expressao4 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==42||LA36_0==68) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1006:3: (operador= '==' |operador= '!=' ) operandoDireito= expressao4
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

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:3: (operador= '==' |operador= '!=' )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==68) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==42) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:4: operador= '=='
            	            {
            	            operador=(Token)match(input,68,FOLLOW_68_in_expressao32778); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1019:22: operador= '!='
            	            {
            	            operador=(Token)match(input,42,FOLLOW_42_in_expressao32786); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao4_in_expressao32799);
            	    operandoDireito=expressao4();

            	    state._fsp--;
            	    if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao3"



    // $ANTLR start "expressao4"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1036:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao4_5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao4_5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao4");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1039:2: (operandoEsquerdo= expressao4_5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao4_5 )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:2: operandoEsquerdo= expressao4_5 ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao4_5 )?
            {
            pushFollow(FOLLOW_expressao4_5_in_expressao42833);
            operandoEsquerdo=expressao4_5();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:34: ( (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao4_5 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==63||LA38_0==66||(LA38_0 >= 69 && LA38_0 <= 70)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:35: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' ) operandoDireito= expressao4_5
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:35: (operador= '>=' |operador= '<=' |operador= '<' |operador= '>' )
                    int alt37=4;
                    switch ( input.LA(1) ) {
                    case 70:
                        {
                        alt37=1;
                        }
                        break;
                    case 66:
                        {
                        alt37=2;
                        }
                        break;
                    case 63:
                        {
                        alt37=3;
                        }
                        break;
                    case 69:
                        {
                        alt37=4;
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
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:36: operador= '>='
                            {
                            operador=(Token)match(input,70,FOLLOW_70_in_expressao42841); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:54: operador= '<='
                            {
                            operador=(Token)match(input,66,FOLLOW_66_in_expressao42849); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:72: operador= '<'
                            {
                            operador=(Token)match(input,63,FOLLOW_63_in_expressao42857); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1041:89: operador= '>'
                            {
                            operador=(Token)match(input,69,FOLLOW_69_in_expressao42865); if (state.failed) return expressao;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_expressao4_5_in_expressao42872);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao4"



    // $ANTLR start "expressao4_5"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1054:1: expressao4_5 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '<<' |operador= '>>' ) operandoDireito= expressao5 )* ;
    public final NoExpressao expressao4_5() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao4_5");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1057:2: (operandoEsquerdo= expressao5 ( (operador= '<<' |operador= '>>' ) operandoDireito= expressao5 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1057:4: operandoEsquerdo= expressao5 ( (operador= '<<' |operador= '>>' ) operandoDireito= expressao5 )*
            {
            pushFollow(FOLLOW_expressao5_in_expressao4_52901);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1058:5: ( (operador= '<<' |operador= '>>' ) operandoDireito= expressao5 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==64||LA40_0==71) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1059:3: (operador= '<<' |operador= '>>' ) operandoDireito= expressao5
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

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1071:3: (operador= '<<' |operador= '>>' )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==64) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==71) ) {
            	        alt39=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expressao;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1071:4: operador= '<<'
            	            {
            	            operador=(Token)match(input,64,FOLLOW_64_in_expressao4_52930); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1071:22: operador= '>>'
            	            {
            	            operador=(Token)match(input,71,FOLLOW_71_in_expressao4_52938); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao5_in_expressao4_52950);
            	    operandoDireito=expressao5();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop40;
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao4_5"



    // $ANTLR start "expressao5"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1087:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao5");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1090:2: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1092:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao52984);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1093:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*
            loop41:
            do {
                int alt41=3;
                alt41 = dfa41.predict(input);
                switch (alt41) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1094:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1094:3: (operador= '+' operandoDireito= expressao6 )
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1096:4: operador= '+' operandoDireito= expressao6
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

            	    operador=(Token)match(input,51,FOLLOW_51_in_expressao53015); if (state.failed) return expressao;

            	    pushFollow(FOLLOW_expressao6_in_expressao53021);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1113:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    {
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1113:3: ( ( '-' )=>operador= '-' operandoDireito= expressao6 )
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1115:5: ( '-' )=>operador= '-' operandoDireito= expressao6
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

            	    operador=(Token)match(input,55,FOLLOW_55_in_expressao53079); if (state.failed) return expressao;

            	    pushFollow(FOLLOW_expressao6_in_expressao53085);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao5"



    // $ANTLR start "expressao6"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1148:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;


        Token operador=null;
        NoExpressao operandoEsquerdo =null;

        NoExpressao operandoDireito =null;



        	pilhaContexto.push("expressao6");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1151:2: (operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1153:2: operandoEsquerdo= expressao7 ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao63134);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1154:2: ( (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==43||LA43_0==49||LA43_0==59) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1155:3: (operador= '*' |operador= '/' |operador= '%' ) operandoDireito= expressao7
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

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1168:3: (operador= '*' |operador= '/' |operador= '%' )
            	    int alt42=3;
            	    switch ( input.LA(1) ) {
            	    case 49:
            	        {
            	        alt42=1;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt42=2;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt42=3;
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
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1168:4: operador= '*'
            	            {
            	            operador=(Token)match(input,49,FOLLOW_49_in_expressao63157); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1168:21: operador= '/'
            	            {
            	            operador=(Token)match(input,59,FOLLOW_59_in_expressao63165); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1168:38: operador= '%'
            	            {
            	            operador=(Token)match(input,43,FOLLOW_43_in_expressao63173); if (state.failed) return expressao;

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_expressao7_in_expressao63186);
            	    operandoDireito=expressao7();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop43;
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao6"



    // $ANTLR start "expressao7"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1185:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;


        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        NoExpressao vExpressao =null;



        	pilhaContexto.push("expressao7");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1188:2: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8 )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* ) vExpressao= expressao8
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= OPERADOR_NAO )* )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==55) && (synpred4_Portugol())) {
                alt46=1;
            }
            else if ( (LA46_0==47) ) {
                int LA46_2 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==ID) ) {
                int LA46_3 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 3, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==ID_BIBLIOTECA) ) {
                int LA46_4 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 4, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==REAL) ) {
                int LA46_5 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 5, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==LOGICO) ) {
                int LA46_6 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 6, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==CADEIA) ) {
                int LA46_7 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==INTEIRO) ) {
                int LA46_8 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 8, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==CARACTER) ) {
                int LA46_9 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 9, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==79) ) {
                int LA46_10 = input.LA(2);

                if ( (synpred4_Portugol()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 10, input);

                    throw nvae;

                }
            }
            else if ( (LA46_0==OPERADOR_NAO) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:12: (listaTokenMenos+= '-' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==55) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,55,FOLLOW_55_in_expressao73228); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:40: (listaTokenNao+= OPERADOR_NAO )*
                    {
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:40: (listaTokenNao+= OPERADOR_NAO )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==OPERADOR_NAO) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:41: listaTokenNao+= OPERADOR_NAO
                    	    {
                    	    listaTokenNao=(Token)match(input,OPERADOR_NAO,FOLLOW_OPERADOR_NAO_in_expressao73239); if (state.failed) return expressao;
                    	    if (list_listaTokenNao==null) list_listaTokenNao=new ArrayList();
                    	    list_listaTokenNao.add(listaTokenNao);


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_expressao8_in_expressao73249);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao7"



    // $ANTLR start "expressao8"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1214:1: expressao8 returns [NoExpressao expressao] : (parentesis= '(' vExpressao= expressao ')' |vExpressao= referencia |vExpressao= tipoPrimitivo |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;


        Token parentesis=null;
        Token operador=null;
        NoExpressao vExpressao =null;



        	pilhaContexto.push("expressao8");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1217:2: ( (parentesis= '(' vExpressao= expressao ')' |vExpressao= referencia |vExpressao= tipoPrimitivo |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1219:2: (parentesis= '(' vExpressao= expressao ')' |vExpressao= referencia |vExpressao= tipoPrimitivo |vExpressao= matrizVetor ) (operador= '++' |operador= '--' )?
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1219:2: (parentesis= '(' vExpressao= expressao ')' |vExpressao= referencia |vExpressao= tipoPrimitivo |vExpressao= matrizVetor )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt47=1;
                }
                break;
            case ID:
            case ID_BIBLIOTECA:
                {
                alt47=2;
                }
                break;
            case CADEIA:
            case CARACTER:
            case INTEIRO:
            case LOGICO:
            case REAL:
                {
                alt47=3;
                }
                break;
            case 79:
                {
                alt47=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1219:4: parentesis= '(' vExpressao= expressao ')'
                    {
                    parentesis=(Token)match(input,47,FOLLOW_47_in_expressao83283); if (state.failed) return expressao;

                    pushFollow(FOLLOW_expressao_in_expressao83289);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;

                    match(input,48,FOLLOW_48_in_expressao83291); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1220:4: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao83301);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1221:4: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao83310);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1222:4: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao83320);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1224:3: (operador= '++' |operador= '--' )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==52) ) {
                alt48=1;
            }
            else if ( (LA48_0==56) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1224:4: operador= '++'
                    {
                    operador=(Token)match(input,52,FOLLOW_52_in_expressao83333); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1224:22: operador= '--'
                    {
                    operador=(Token)match(input,56,FOLLOW_56_in_expressao83341); if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "expressao8"



    // $ANTLR start "tipoPrimitivo"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1255:1: tipoPrimitivo returns [NoExpressao expressao] : ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;


        Token REAL6=null;
        Token LOGICO7=null;
        Token CADEIA8=null;
        Token INTEIRO9=null;
        Token CARACTER10=null;


        	pilhaContexto.push("tipoPrimitivo");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1258:2: ( REAL | LOGICO | CADEIA | INTEIRO | CARACTER )
            int alt49=5;
            switch ( input.LA(1) ) {
            case REAL:
                {
                alt49=1;
                }
                break;
            case LOGICO:
                {
                alt49=2;
                }
                break;
            case CADEIA:
                {
                alt49=3;
                }
                break;
            case INTEIRO:
                {
                alt49=4;
                }
                break;
            case CARACTER:
                {
                alt49=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1260:2: REAL
                    {
                    REAL6=(Token)match(input,REAL,FOLLOW_REAL_in_tipoPrimitivo3370); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) { 
                    		if (gerarArvore)
                    		{
                    			NoReal real = new NoReal(Double.parseDouble((REAL6!=null?REAL6.getText():null)));
                    			real.setTrechoCodigoFonte(criarTrechoCodigoFonte(REAL6));
                    			expressao = real;
                    		}
                    	}

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1272:2: LOGICO
                    {
                    LOGICO7=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_tipoPrimitivo3390); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		if (gerarArvore)
                    		{
                    			NoLogico logico = new NoLogico(((LOGICO7!=null?LOGICO7.getText():null).equals("verdadeiro")? true : false));
                    			logico.setTrechoCodigoFonte(criarTrechoCodigoFonte(LOGICO7));
                    			expressao = logico;
                    		}
                    	}

                    }
                    break;
                case 3 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1284:2: CADEIA
                    {
                    CADEIA8=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_tipoPrimitivo3404); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		if (gerarArvore)
                    		{
                    			String texto = (CADEIA8!=null?CADEIA8.getText():null);
                    			NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                    			cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte(CADEIA8));
                    			expressao = cadeia;
                    		}
                    	}

                    }
                    break;
                case 4 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1297:2: INTEIRO
                    {
                    INTEIRO9=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_tipoPrimitivo3417); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		try
                    		{
                    	
                    		if (gerarArvore)
                    		{
                    			NoInteiro inteiro = new NoInteiro(Integer.parseInt((INTEIRO9!=null?INTEIRO9.getText():null)));
                    			inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte(INTEIRO9));
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
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1318:2: CARACTER
                    {
                    CARACTER10=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_tipoPrimitivo3432); if (state.failed) return expressao;

                    if ( state.backtracking==0 ) {
                    		if (gerarArvore)
                    		{
                    			NoCaracter caracter = new NoCaracter((CARACTER10!=null?CARACTER10.getText():null).charAt(1));
                    			caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte(CARACTER10));
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "tipoPrimitivo"



    // $ANTLR start "referencia"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1334:1: referencia returns [NoReferencia referencia] : (id= ID |id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] |vExpressao= referenciaId[$id.getText()] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;


        Token id=null;
        NoExpressao vExpressao =null;



        	pilhaContexto.push("referencia");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1337:2: ( (id= ID |id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] |vExpressao= referenciaId[$id.getText()] ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1339:2: (id= ID |id= ID_BIBLIOTECA ) ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] |vExpressao= referenciaId[$id.getText()] )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1339:2: (id= ID |id= ID_BIBLIOTECA )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==ID) ) {
                alt50=1;
            }
            else if ( (LA50_0==ID_BIBLIOTECA) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return referencia;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1339:3: id= ID
                    {
                    id=(Token)match(input,ID,FOLLOW_ID_in_referencia3466); if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1339:13: id= ID_BIBLIOTECA
                    {
                    id=(Token)match(input,ID_BIBLIOTECA,FOLLOW_ID_BIBLIOTECA_in_referencia3474); if (state.failed) return referencia;

                    }
                    break;

            }


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1340:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] |vExpressao= referenciaId[$id.getText()] )
            int alt51=3;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1341:3: ( '(' )=>vExpressao= chamadaFuncao[$id.getText()]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia3492);
                    vExpressao=chamadaFuncao(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1342:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia3509);
                    vExpressao=referenciaVetorMatriz(id.getText());

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1343:5: vExpressao= referenciaId[$id.getText()]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia3522);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return referencia;
    }
    // $ANTLR end "referencia"



    // $ANTLR start "referenciaId"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1360:1: referenciaId[String id] returns [NoExpressao expressao] :;
    public final NoExpressao referenciaId(String id) throws RecognitionException {
        NoExpressao expressao = null;



        	pilhaContexto.push("referenciaId");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1363:2: ()
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1365:2: 
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaId"



    // $ANTLR start "referenciaVetorMatriz"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1389:1: referenciaVetorMatriz[ String id] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String id) throws RecognitionException {
        NoExpressao expressao = null;


        NoExpressao indice1 =null;

        NoExpressao indice2 =null;



        	pilhaContexto.push("referenciaVetorMatriz");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1392:2: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1394:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,73,FOLLOW_73_in_referenciaVetorMatriz3583); if (state.failed) return expressao;

            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3589);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;

            match(input,74,FOLLOW_74_in_referenciaVetorMatriz3591); if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1394:30: ( '[' indice2= expressao ']' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==73) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1394:31: '[' indice2= expressao ']'
                    {
                    match(input,73,FOLLOW_73_in_referenciaVetorMatriz3594); if (state.failed) return expressao;

                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz3600);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;

                    match(input,74,FOLLOW_74_in_referenciaVetorMatriz3602); if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "referenciaVetorMatriz"



    // $ANTLR start "chamadaFuncao"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1420:1: chamadaFuncao[String id] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String id) throws RecognitionException {
        NoExpressao expressao = null;


        List<NoExpressao> vListaParametros =null;



        	pilhaContexto.push("chamadaFuncao");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1423:2: ( '(' (vListaParametros= listaParametros )? ')' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1425:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,47,FOLLOW_47_in_chamadaFuncao3634); if (state.failed) return expressao;

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1425:6: (vListaParametros= listaParametros )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0 >= CADEIA && LA53_0 <= CARACTER)||(LA53_0 >= ID && LA53_0 <= OPERADOR_NAO)||LA53_0==REAL||LA53_0==47||LA53_0==55||LA53_0==79) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1425:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao3641);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }


            match(input,48,FOLLOW_48_in_chamadaFuncao3645); if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "chamadaFuncao"



    // $ANTLR start "listaParametros"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1453:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;


        NoExpressao vExpressao =null;



        	pilhaContexto.push("listaParametros");
        	listaParametros = new ArrayList<NoExpressao>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1457:2: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1458:2: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1458:2: (vExpressao= expressao )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1458:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3680);
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


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1467:2: ( ',' vExpressao= expressao )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==54) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1467:3: ',' vExpressao= expressao
            	    {
            	    match(input,54,FOLLOW_54_in_listaParametros3696); if (state.failed) return listaParametros;

            	    pushFollow(FOLLOW_expressao_in_listaParametros3702);
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
            	    break loop54;
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

            	pilhaContexto.pop();

        }
        return listaParametros;
    }
    // $ANTLR end "listaParametros"



    // $ANTLR start "matrizVetor"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1483:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;


        NoExpressao vExpressao =null;



        	pilhaContexto.push("matrizVetor");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1486:2: ( ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor ) )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:2: ( ( '{' '{' )=>vExpressao= matriz |vExpressao= vetor )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==79) ) {
                int LA55_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3749);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3757);
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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matrizVetor"



    // $ANTLR start "vetor"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1503:1: vetor returns [NoExpressao expressao] : abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;


        Token abre_ch=null;
        Token fecha_ch=null;
        List<Object> vListaExpressoes =null;



        	pilhaContexto.push("vetor");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1506:2: (abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1508:2: abre_ch= '{' vListaExpressoes= listaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,79,FOLLOW_79_in_vetor3791); if (state.failed) return expressao;

            pushFollow(FOLLOW_listaExpressoes_in_vetor3797);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;

            fecha_ch=(Token)match(input,82,FOLLOW_82_in_vetor3803); if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "vetor"



    // $ANTLR start "matriz"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1525:1: matriz returns [NoExpressao expressao] : abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;


        Token abre_ch=null;
        Token fecha_ch=null;
        List<List<Object>> vListaListaExpressoes =null;



        	pilhaContexto.push("matriz");

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1528:2: (abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1530:2: abre_ch= '{' vListaListaExpressoes= listaListaExpressoes fecha_ch= '}'
            {
            abre_ch=(Token)match(input,79,FOLLOW_79_in_matriz3836); if (state.failed) return expressao;

            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3844);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;

            fecha_ch=(Token)match(input,82,FOLLOW_82_in_matriz3851); if (state.failed) return expressao;

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
        	// do for sure before leaving

            	pilhaContexto.pop();

        }
        return expressao;
    }
    // $ANTLR end "matriz"



    // $ANTLR start "listaListaExpressoes"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1550:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;


        List<Object> vListaExpressoes =null;



        	pilhaContexto.push("listaListaExpressoes");
        	listaListaExpressoes = new ArrayList<List<Object>>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1554:2: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1555:2: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1555:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1555:4: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,79,FOLLOW_79_in_listaListaExpressoes3880); if (state.failed) return listaListaExpressoes;

            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3886);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;

            match(input,82,FOLLOW_82_in_listaListaExpressoes3888); if (state.failed) return listaListaExpressoes;

            if ( state.backtracking==0 ) {
            			if (gerarArvore)
            			{
            				 listaListaExpressoes.add(vListaExpressoes); 
            			 }
            		}

            }


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1563:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==54) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1563:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) { vListaExpressoes = null; }

            	    match(input,54,FOLLOW_54_in_listaListaExpressoes3903); if (state.failed) return listaListaExpressoes;

            	    match(input,79,FOLLOW_79_in_listaListaExpressoes3906); if (state.failed) return listaListaExpressoes;

            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3912);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;

            	    match(input,82,FOLLOW_82_in_listaListaExpressoes3914); if (state.failed) return listaListaExpressoes;

            	    if ( state.backtracking==0 ) { 
            	    	   	if (gerarArvore)
            	    	   	{
            	    		   	listaListaExpressoes.add(vListaExpressoes); 
            	    	   	}
            	    	   }

            	    }
            	    break;

            	default :
            	    break loop56;
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

            	pilhaContexto.pop();

        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"



    // $ANTLR start "listaExpressoes"
    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1579:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;


        NoExpressao vExpressao =null;



        	pilhaContexto.push("listaExpressoes");
        	listaExpressoes = new ArrayList<Object>();

        try {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1583:2: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1584:2: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1584:2: ( (vExpressao= expressao )? )
            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1584:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) { vExpressao = null; }

            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1584:30: (vExpressao= expressao )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0 >= CADEIA && LA57_0 <= CARACTER)||(LA57_0 >= ID && LA57_0 <= OPERADOR_NAO)||LA57_0==REAL||LA57_0==47||LA57_0==55||LA57_0==79) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1584:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3960);
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


            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1591:2: ( ',' (vExpressao= expressao )? )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==54) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1591:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) { vExpressao = null; }

            	    match(input,54,FOLLOW_54_in_listaExpressoes3974); if (state.failed) return listaExpressoes;

            	    // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1591:30: (vExpressao= expressao )?
            	    int alt58=2;
            	    int LA58_0 = input.LA(1);

            	    if ( ((LA58_0 >= CADEIA && LA58_0 <= CARACTER)||(LA58_0 >= ID && LA58_0 <= OPERADOR_NAO)||LA58_0==REAL||LA58_0==47||LA58_0==55||LA58_0==79) ) {
            	        alt58=1;
            	    }
            	    switch (alt58) {
            	        case 1 :
            	            // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1591:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes3981);
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
            	    break loop59;
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

            	pilhaContexto.pop();

        }
        return listaExpressoes;
    }
    // $ANTLR end "listaExpressoes"

    // $ANTLR start synpred1_Portugol
    public final void synpred1_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:2: ( '{' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:685:3: '{'
        {
        match(input,79,FOLLOW_79_in_synpred1_Portugol1997); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:4: ( '{' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:780:5: '{'
        {
        match(input,79,FOLLOW_79_in_synpred2_Portugol2188); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1115:5: ( '-' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1115:6: '-'
        {
        match(input,55,FOLLOW_55_in_synpred3_Portugol3051); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:3: ( '-' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1190:4: '-'
        {
        match(input,55,FOLLOW_55_in_synpred4_Portugol3218); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1341:3: ( '(' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1341:4: '('
        {
        match(input,47,FOLLOW_47_in_synpred5_Portugol3483); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1342:3: ( '[' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1342:4: '['
        {
        match(input,73,FOLLOW_73_in_synpred6_Portugol3500); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:3: ( '{' '{' )
        // /home/fillipi/workspace/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1488:4: '{' '{'
        {
        match(input,79,FOLLOW_79_in_synpred7_Portugol3739); if (state.failed) return ;

        match(input,79,FOLLOW_79_in_synpred7_Portugol3741); if (state.failed) return ;

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


    protected DFA41 dfa41 = new DFA41(this);
    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA41_eotS =
        "\74\uffff";
    static final String DFA41_eofS =
        "\74\uffff";
    static final String DFA41_minS =
        "\1\4\43\uffff\1\0\27\uffff";
    static final String DFA41_maxS =
        "\1\122\43\uffff\1\0\27\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\3\70\uffff\1\1\1\2";
    static final String DFA41_specialS =
        "\44\uffff\1\0\27\uffff}>";
    static final String[] DFA41_transitionS = {
            "\2\1\6\uffff\5\1\1\uffff\4\1\1\uffff\3\1\1\uffff\1\1\1\uffff"+
            "\4\1\1\uffff\4\1\2\uffff\1\1\1\uffff\1\1\1\uffff\5\1\1\uffff"+
            "\1\1\1\72\1\uffff\2\1\1\44\2\uffff\1\1\1\uffff\15\1\1\uffff"+
            "\11\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1093:2: ( (operador= '+' operandoDireito= expressao6 ) | ( ( '-' )=>operador= '-' operandoDireito= expressao6 ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_36 = input.LA(1);

                         
                        int index41_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Portugol()) ) {s = 59;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index41_36);

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
    static final String DFA51_eotS =
        "\102\uffff";
    static final String DFA51_eofS =
        "\102\uffff";
    static final String DFA51_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA51_maxS =
        "\1\122\1\0\100\uffff";
    static final String DFA51_acceptS =
        "\2\uffff\1\2\1\3\75\uffff\1\1";
    static final String DFA51_specialS =
        "\1\0\1\1\100\uffff}>";
    static final String[] DFA51_transitionS = {
            "\2\3\6\uffff\5\3\1\uffff\4\3\1\uffff\3\3\1\uffff\1\3\1\uffff"+
            "\4\3\1\uffff\4\3\2\uffff\1\3\1\uffff\5\3\1\1\11\3\1\uffff\17"+
            "\3\1\2\11\3",
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
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "1340:2: ( ( '(' )=>vExpressao= chamadaFuncao[$id.getText()] | ( '[' )=>vExpressao= referenciaVetorMatriz[$id.getText()] |vExpressao= referenciaId[$id.getText()] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_0 = input.LA(1);

                         
                        int index51_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA51_0==47) ) {s = 1;}

                        else if ( (LA51_0==73) && (synpred6_Portugol())) {s = 2;}

                        else if ( ((LA51_0 >= CADEIA && LA51_0 <= CARACTER)||(LA51_0 >= ID && LA51_0 <= OPERADOR_NAO)||(LA51_0 >= PR_CADEIA && LA51_0 <= PR_CONST)||(LA51_0 >= PR_ENQUANTO && LA51_0 <= PR_FACA)||LA51_0==PR_FUNCAO||(LA51_0 >= PR_INTEIRO && LA51_0 <= PR_PARE)||(LA51_0 >= PR_REAL && LA51_0 <= PR_SENAO)||LA51_0==REAL||(LA51_0 >= 42 && LA51_0 <= 46)||(LA51_0 >= 48 && LA51_0 <= 56)||(LA51_0 >= 58 && LA51_0 <= 72)||(LA51_0 >= 74 && LA51_0 <= 82)) ) {s = 3;}

                         
                        input.seek(index51_0);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_Portugol()) ) {s = 65;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_1);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

    public static final BitSet FOLLOW_programa_in_parse907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PROGRAMA_in_programa929 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_programa932 = new BitSet(new long[]{0x00000004782C0000L,0x0000000000040000L});
    public static final BitSet FOLLOW_inclusaoBiblioteca_in_programa947 = new BitSet(new long[]{0x00000004782C0000L,0x0000000000040000L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_programa955 = new BitSet(new long[]{0x00000004682C0000L,0x0000000000040000L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_programa960 = new BitSet(new long[]{0x00000004682C0000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_programa966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INCLUA_in_inclusaoBiblioteca989 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_PR_BIBLIOTECA_in_inclusaoBiblioteca991 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca997 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_inclusaoBiblioteca1000 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_inclusaoBiblioteca1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CONST_in_listaDeclaracoes1103 = new BitSet(new long[]{0x00000004600C0000L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1111 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1122 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_listaDeclaracoes1144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1150 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao1189 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000208L});
    public static final BitSet FOLLOW_73_in_declaracao1196 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008400L});
    public static final BitSet FOLLOW_expressao_in_declaracao1203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_declaracao1207 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000208L});
    public static final BitSet FOLLOW_73_in_declaracao1214 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008400L});
    public static final BitSet FOLLOW_expressao_in_declaracao1221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_declaracao1225 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_declaracao1232 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_declaracao1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_INTEIRO_in_declaracaoTipoDado1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_REAL_in_declaracaoTipoDado1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CARACTER_in_declaracaoTipoDado1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_CADEIA_in_declaracaoTipoDado1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_LOGICO_in_declaracaoTipoDado1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_VAZIO_in_declaracaoTipoDadoVazio1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_quantificador1364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_quantificador1366 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_quantificador1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_quantificador1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FUNCAO_in_declaracaoFuncao1446 = new BitSet(new long[]{0x00000044600C1000L,0x0000000000000200L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1456 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000200L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1465 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1472 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracaoFuncao1474 = new BitSet(new long[]{0x00010004600C0000L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1480 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_declaracaoFuncao1482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_declaracaoFuncao1502 = new BitSet(new long[]{0x0080811DE3ADF030L,0x0000000000048000L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_declaracaoFuncao1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1575 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_listaParametrosFuncao1603 = new BitSet(new long[]{0x00000004600C0000L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1609 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1656 = new BitSet(new long[]{0x0000200000001000L});
    public static final BitSet FOLLOW_45_in_declaracaoParametro1663 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1667 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1705 = new BitSet(new long[]{0x0080811DE3ADF032L,0x0000000000008000L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1711 = new BitSet(new long[]{0x0080811DE3ADF032L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_bloco1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARA_in_para1888 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_para1890 = new BitSet(new long[]{0x40808104602DF030L,0x0000000000008000L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1897 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_para1901 = new BitSet(new long[]{0x408081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_para1908 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_para1912 = new BitSet(new long[]{0x008181000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_para1919 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_para1923 = new BitSet(new long[]{0x008081198381F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaBlocos_in_para1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_listaBlocos2001 = new BitSet(new long[]{0x0080811DE3ADF030L,0x0000000000048000L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos2007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_listaBlocos2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_PARE_in_pare2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ESCOLHA_in_escolha2082 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_escolha2084 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_escolha2090 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_escolha2092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_escolha2095 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2104 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_escolha2110 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_escolha2112 = new BitSet(new long[]{0x0080811DE3ADF030L,0x0000000000008000L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2118 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
    public static final BitSet FOLLOW_PR_CASO_in_escolha2133 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_PR_CONTRARIO_in_escolha2135 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_escolha2137 = new BitSet(new long[]{0x0080811DE3ADF030L,0x0000000000008000L});
    public static final BitSet FOLLOW_blocosCaso_in_escolha2143 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_escolha2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_blocosCaso2193 = new BitSet(new long[]{0x0080811DE3ADF030L,0x0000000000048000L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_blocosCaso2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_enquanto2240 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_enquanto2242 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_enquanto2248 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_enquanto2250 = new BitSet(new long[]{0x008081198381F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_FACA_in_facaEnquanto2282 = new BitSet(new long[]{0x008081198381F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2288 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_PR_ENQUANTO_in_facaEnquanto2290 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_facaEnquanto2292 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2298 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_facaEnquanto2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_SE_in_se2328 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_se2330 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_se2336 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_se2338 = new BitSet(new long[]{0x008081198381F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaBlocos_in_se2344 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_PR_SENAO_in_se2347 = new BitSet(new long[]{0x008081198381F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaBlocos_in_se2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PR_RETORNE_in_retorne2382 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_retorne2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2432 = new BitSet(new long[]{0x1424500000000000L,0x000000000002110AL});
    public static final BitSet FOLLOW_pilha_in_expressao2438 = new BitSet(new long[]{0x1424500000000002L,0x000000000002110AL});
    public static final BitSet FOLLOW_67_in_expressao2452 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_53_in_expressao2460 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_58_in_expressao2468 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_60_in_expressao2476 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_50_in_expressao2484 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_44_in_expressao2492 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_72_in_expressao2500 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_65_in_expressao2508 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_81_in_expressao2516 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_46_in_expressao2524 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_76_in_expressao2532 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao2_in_expressao2545 = new BitSet(new long[]{0x1424500000000002L,0x000000000002110AL});
    public static final BitSet FOLLOW_expressao2_5_in_expressao22584 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_77_in_expressao22613 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_78_in_expressao22621 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao2_5_in_expressao22633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_expressao3_in_expressao2_52666 = new BitSet(new long[]{0x0000200000000002L,0x0000000000010800L});
    public static final BitSet FOLLOW_45_in_expressao2_52695 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_80_in_expressao2_52703 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_75_in_expressao2_52711 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao3_in_expressao2_52723 = new BitSet(new long[]{0x0000200000000002L,0x0000000000010800L});
    public static final BitSet FOLLOW_expressao4_in_expressao32757 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_expressao32778 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_42_in_expressao32786 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao4_in_expressao32799 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_expressao4_5_in_expressao42833 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000064L});
    public static final BitSet FOLLOW_70_in_expressao42841 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_66_in_expressao42849 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_63_in_expressao42857 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_69_in_expressao42865 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao4_5_in_expressao42872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao5_in_expressao4_52901 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000081L});
    public static final BitSet FOLLOW_64_in_expressao4_52930 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_71_in_expressao4_52938 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao5_in_expressao4_52950 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000081L});
    public static final BitSet FOLLOW_expressao6_in_expressao52984 = new BitSet(new long[]{0x0088000000000002L});
    public static final BitSet FOLLOW_51_in_expressao53015 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao6_in_expressao53021 = new BitSet(new long[]{0x0088000000000002L});
    public static final BitSet FOLLOW_55_in_expressao53079 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao6_in_expressao53085 = new BitSet(new long[]{0x0088000000000002L});
    public static final BitSet FOLLOW_expressao7_in_expressao63134 = new BitSet(new long[]{0x0802080000000002L});
    public static final BitSet FOLLOW_49_in_expressao63157 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_59_in_expressao63165 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_43_in_expressao63173 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao7_in_expressao63186 = new BitSet(new long[]{0x0802080000000002L});
    public static final BitSet FOLLOW_55_in_expressao73228 = new BitSet(new long[]{0x000081000000F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_OPERADOR_NAO_in_expressao73239 = new BitSet(new long[]{0x000081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao8_in_expressao73249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_expressao83283 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_expressao83289 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_expressao83291 = new BitSet(new long[]{0x0110000000000002L});
    public static final BitSet FOLLOW_referencia_in_expressao83301 = new BitSet(new long[]{0x0110000000000002L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao83310 = new BitSet(new long[]{0x0110000000000002L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao83320 = new BitSet(new long[]{0x0110000000000002L});
    public static final BitSet FOLLOW_52_in_expressao83333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_expressao83341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_tipoPrimitivo3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_tipoPrimitivo3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_tipoPrimitivo3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_tipoPrimitivo3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_tipoPrimitivo3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_referencia3466 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ID_BIBLIOTECA_in_referencia3474 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_referenciaVetorMatriz3583 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_referenciaVetorMatriz3591 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_referenciaVetorMatriz3594 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz3600 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_referenciaVetorMatriz3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_chamadaFuncao3634 = new BitSet(new long[]{0x008181000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao3641 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_chamadaFuncao3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3680 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_listaParametros3696 = new BitSet(new long[]{0x008081000001F030L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3702 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_vetor3791 = new BitSet(new long[]{0x00C081000001F030L,0x0000000000048000L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_vetor3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_matriz3836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_matriz3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_listaListaExpressoes3880 = new BitSet(new long[]{0x00C081000001F030L,0x0000000000048000L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_listaListaExpressoes3888 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_listaListaExpressoes3903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_listaListaExpressoes3906 = new BitSet(new long[]{0x00C081000001F030L,0x0000000000048000L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_listaListaExpressoes3914 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3960 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_listaExpressoes3974 = new BitSet(new long[]{0x00C081000001F032L,0x0000000000008000L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3981 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_79_in_synpred1_Portugol1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_synpred2_Portugol2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred3_Portugol3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred4_Portugol3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred5_Portugol3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_synpred6_Portugol3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_synpred7_Portugol3739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_synpred7_Portugol3741 = new BitSet(new long[]{0x0000000000000002L});

}