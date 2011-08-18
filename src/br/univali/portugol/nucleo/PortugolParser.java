// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g 2011-08-17 18:23:15


	package br.univali.portugol.nucleo;

	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;
  import br.univali.portugol.nucleo.excecoes.ColecaoExcecoes;
  import java.util.List;
  import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PortugolParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMA", "BIBLIOTECA", "USE", "REAL", "VAZIO", "LOGICO", "CADEIA", "INTEIRO", "CARACTER", "ESCOLHA", "CASO", "CONTRARIO", "CONST", "PERCORRA", "FUNCAO", "RETORNE", "PARA", "PARE", "FACA", "ENQUANTO", "SE", "SENAO", "FALSO", "VERDADEIRO", "LETRA", "DIGITO", "UNDERLINE", "CONST_LOGICO", "CONST_INTEIRO", "EXPOENTE", "CONST_REAL", "SEQUENCIA_ESCAPE", "CONST_CADEIA", "CONST_CARACTER", "ID", "APELIDO", "COMENTARIO_SIMPLES", "COMENTARIO_MULTILINHA", "ESPACO", "DIGITO_HEXA", "ESCAPE_UNICODE", "ESCAPE_OCTAL", "'{'", "'}'", "','", "'['", "']'", "'='", "'('", "')'", "'&'", "';'", "':'", "'+='", "'-='", "'/='", "'*='", "'%='", "'e'", "'ou'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'nao'", "'++'", "'--'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int CONST_LOGICO=31;
    public static final int T__64=64;
    public static final int CASO=14;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int DIGITO=29;
    public static final int LOGICO=9;
    public static final int FACA=22;
    public static final int CONST=16;
    public static final int BIBLIOTECA=5;
    public static final int VAZIO=8;
    public static final int DIGITO_HEXA=43;
    public static final int PERCORRA=17;
    public static final int ID=38;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int VERDADEIRO=27;
    public static final int PARE=21;
    public static final int PARA=20;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int APELIDO=39;
    public static final int T__58=58;
    public static final int ESCAPE_OCTAL=45;
    public static final int T__51=51;
    public static final int CONST_INTEIRO=32;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int CONST_CADEIA=36;
    public static final int CONTRARIO=15;
    public static final int CADEIA=10;
    public static final int T__50=50;
    public static final int CONST_REAL=34;
    public static final int COMENTARIO_MULTILINHA=41;
    public static final int T__46=46;
    public static final int CARACTER=12;
    public static final int T__47=47;
    public static final int CONST_CARACTER=37;
    public static final int COMENTARIO_SIMPLES=40;
    public static final int T__48=48;
    public static final int ESCOLHA=13;
    public static final int T__49=49;
    public static final int FUNCAO=18;
    public static final int RETORNE=19;
    public static final int ESCAPE_UNICODE=44;
    public static final int UNDERLINE=30;
    public static final int ENQUANTO=23;
    public static final int REAL=7;
    public static final int SE=24;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int SENAO=25;
    public static final int T__70=70;
    public static final int INTEIRO=11;
    public static final int EXPOENTE=33;
    public static final int PROGRAMA=4;
    public static final int SEQUENCIA_ESCAPE=35;
    public static final int USE=6;
    public static final int FALSO=26;
    public static final int T__76=76;
    public static final int LETRA=28;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int ESPACO=42;
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
    public String getGrammarFileName() { return "/home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g"; }


      @Override
      public void reportError(RecognitionException e) {
           excecoes.add(e);
      }

    	private class InformacaoTipoDado
    	{
    		private TipoDado tipoDado;
    		private br.univali.portugol.nucleo.asa.Token token;
    		
    		public InformacaoTipoDado()
    		{

    		}

    		public TipoDado getTipoDado()
    		{
    			return tipoDado;
    		}

    		public br.univali.portugol.nucleo.asa.Token getToken()
    		{
    			return token;
    		}
    		
    		public void setTipoDado(TipoDado tipoDado)
    		{
    			this.tipoDado = tipoDado;
    		}
    		
    		public void setToken(br.univali.portugol.nucleo.asa.Token token)
    		{
    			this.token = token;
    		}

    	}
    	
    	private String obterNomeBiblioteca(String nome)
    	{
    		return nome.substring(1, nome.length() - 1);
    	}
    	
    	private String obterApelidoBiblioteca(String nome, String apelido)
    	{
    		if (apelido == null) apelido = nome;
    			
    		return apelido;
    	}
    	
    	
    	private String obterApelido(String apelido)
    	{
    		if (apelido != null)
    		{
    			return apelido.substring(0, apelido.length() - 1);
    		}
    		
    		return null;
    	}


    	private br.univali.portugol.nucleo.asa.Token criarToken(Token tokenAntlr)
    	{
    		if (tokenAntlr != null)
    		{
    			int linha = tokenAntlr.getLine();
    			int coluna = tokenAntlr.getCharPositionInLine();
    			int tamanhoTexto = tokenAntlr.getText().length();
    			
    			return new br.univali.portugol.nucleo.asa.Token(linha, coluna, tamanhoTexto);
    		}
    		
    		return null;
    	}
    	
    	private NoExpressao selecionarExpressao(NoExpressao operandoEsquerdo, NoExpressao operandoDireito, Token operador)
    	{
    		if (operandoDireito != null) 
    		{
    			NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);			
    			operacao.setTokenOperador(criarToken(operador));
    			
    			return operacao;
    		}
    		
    		else return operandoEsquerdo;
    	}
    	
    	private List<Exception> excecoes;
    	
    	public ArvoreSintaticaAbstrata gerarArvore() throws ColecaoExcecoes{
    	 excecoes = new ArrayList<Exception>();
    	 ArvoreSintaticaAbstrata ast = null;
    	 try {
    	   ast = parse();
    	 } catch (RecognitionException re){
    	   excecoes.add(re);  
    	 }
    	 if (excecoes.isEmpty())
    	   return ast;
    	 else
    	   throw new ColecaoExcecoes(excecoes);
    	}



    // $ANTLR start "parse"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:237:1: parse returns [ArvoreSintaticaAbstrata asa] : (programa= PROGRAMA | biblioteca= BIBLIOTECA ) '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' ;
    public final ArvoreSintaticaAbstrata parse() throws RecognitionException {
        ArvoreSintaticaAbstrata asa = null;

        Token programa=null;
        Token biblioteca=null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:237:43: ( (programa= PROGRAMA | biblioteca= BIBLIOTECA ) '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:241:3: (programa= PROGRAMA | biblioteca= BIBLIOTECA ) '{' ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )* '}'
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:241:3: (programa= PROGRAMA | biblioteca= BIBLIOTECA )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PROGRAMA) ) {
                alt1=1;
            }
            else if ( (LA1_0==BIBLIOTECA) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return asa;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:241:5: programa= PROGRAMA
                    {
                    programa=(Token)match(input,PROGRAMA,FOLLOW_PROGRAMA_in_parse961); if (state.failed) return asa;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:241:27: biblioteca= BIBLIOTECA
                    {
                    biblioteca=(Token)match(input,BIBLIOTECA,FOLLOW_BIBLIOTECA_in_parse969); if (state.failed) return asa;

                    }
                    break;

            }

            match(input,46,FOLLOW_46_in_parse973); if (state.failed) return asa;
            if ( state.backtracking==0 ) {

              	 		if (programa != null)  asa = new ArvoreSintaticaAbstrataPrograma((programa!=null?programa.getText():null));
              		 	else	 	
              		 	if (biblioteca != null) asa = new ArvoreSintaticaAbstrataBiblioteca();
              	 			 	
              //			asa.setListaInclusaoBibliotecas(vListaInclusaoBibliotecas);
              			asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());		
              		 
            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:252:3: ( declaracoesGlobais[asa] | declaracaoFuncao[asa] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==REAL||(LA2_0>=LOGICO && LA2_0<=CARACTER)||LA2_0==CONST) ) {
                    alt2=1;
                }
                else if ( (LA2_0==FUNCAO) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:252:4: declaracoesGlobais[asa]
            	    {
            	    pushFollow(FOLLOW_declaracoesGlobais_in_parse985);
            	    declaracoesGlobais(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:252:30: declaracaoFuncao[asa]
            	    {
            	    pushFollow(FOLLOW_declaracaoFuncao_in_parse990);
            	    declaracaoFuncao(asa);

            	    state._fsp--;
            	    if (state.failed) return asa;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,47,FOLLOW_47_in_parse996); if (state.failed) return asa;

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


    // $ANTLR start "declaracoesGlobais"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:283:1: declaracoesGlobais[ArvoreSintaticaAbstrata asa] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesGlobais(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:283:49: (vListaDeclaracoes= listaDeclaracoes )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:285:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesGlobais1015);
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
        }
        return ;
    }
    // $ANTLR end "declaracoesGlobais"


    // $ANTLR start "declaracoesLocais"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:295:1: declaracoesLocais[List<NoBloco> listaBlocos] : vListaDeclaracoes= listaDeclaracoes ;
    public final void declaracoesLocais(List<NoBloco> listaBlocos) throws RecognitionException {
        List<NoDeclaracao> vListaDeclaracoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:295:46: (vListaDeclaracoes= listaDeclaracoes )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:297:2: vListaDeclaracoes= listaDeclaracoes
            {
            pushFollow(FOLLOW_listaDeclaracoes_in_declaracoesLocais1034);
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
        }
        return ;
    }
    // $ANTLR end "declaracoesLocais"


    // $ANTLR start "listaDeclaracoes"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:306:1: listaDeclaracoes returns [List<NoDeclaracao> listaDeclaracoes] : ( (tokenConst= CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) ;
    public final List<NoDeclaracao> listaDeclaracoes() throws RecognitionException {
        List<NoDeclaracao> listaDeclaracoes = null;

        Token tokenConst=null;
        InformacaoTipoDado informacaoTipoDado = null;

        NoDeclaracao vDeclaracao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:306:62: ( ( (tokenConst= CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:307:1: ( (tokenConst= CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            {
            if ( state.backtracking==0 ) {

              	listaDeclaracoes = new ArrayList<NoDeclaracao>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:310:1: ( (tokenConst= CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:311:2: (tokenConst= CONST )? informacaoTipoDado= declaracaoTipoDado (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] ) ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            {
            if ( state.backtracking==0 ) {
              tokenConst = null; 
            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:313:2: (tokenConst= CONST )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==CONST) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:313:3: tokenConst= CONST
                    {
                    tokenConst=(Token)match(input,CONST,FOLLOW_CONST_in_listaDeclaracoes1065); if (state.failed) return listaDeclaracoes;

                    }
                    break;

            }

            pushFollow(FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1073);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:315:2: (vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:315:7: vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            {
            pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1087);
            vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            state._fsp--;
            if (state.failed) return listaDeclaracoes;
            if ( state.backtracking==0 ) {
               listaDeclaracoes.add(vDeclaracao); 
            }

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:316:2: ( ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==48) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:316:3: ',' vDeclaracao= declaracao[tokenConst, informacaoTipoDado]
            	    {
            	    match(input,48,FOLLOW_48_in_listaDeclaracoes1095); if (state.failed) return listaDeclaracoes;
            	    pushFollow(FOLLOW_declaracao_in_listaDeclaracoes1101);
            	    vDeclaracao=declaracao(tokenConst, informacaoTipoDado);

            	    state._fsp--;
            	    if (state.failed) return listaDeclaracoes;
            	    if ( state.backtracking==0 ) {
            	       listaDeclaracoes.add(vDeclaracao); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
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
        }
        return listaDeclaracoes;
    }
    // $ANTLR end "listaDeclaracoes"


    // $ANTLR start "declaracao"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:321:1: declaracao[Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns [NoDeclaracao declaracao] : ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) ;
    public final NoDeclaracao declaracao(Token tokenConst, InformacaoTipoDado informacaoTipoDado) throws RecognitionException {
        NoDeclaracao declaracao = null;

        Token tk1=null;
        Token tk2=null;
        Token ID1=null;
        NoExpressao ind1 = null;

        NoExpressao ind2 = null;

        NoExpressao inicializacao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:321:103: ( ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:2: ( ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:3: ID (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )? ( '=' inicializacao= expressao )?
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_declaracao1127); if (state.failed) return declaracao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:6: (tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==49) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:7: tk1= '[' (ind1= expressao )? ']' (tk2= '[' (ind2= expressao )? ']' )?
                    {
                    tk1=(Token)match(input,49,FOLLOW_49_in_declaracao1134); if (state.failed) return declaracao;
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:17: (ind1= expressao )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=CONST_LOGICO && LA5_0<=CONST_INTEIRO)||LA5_0==CONST_REAL||(LA5_0>=CONST_CADEIA && LA5_0<=APELIDO)||LA5_0==46||LA5_0==52||LA5_0==71||LA5_0==75) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:18: ind1= expressao
                            {
                            pushFollow(FOLLOW_expressao_in_declaracao1141);
                            ind1=expressao();

                            state._fsp--;
                            if (state.failed) return declaracao;

                            }
                            break;

                    }

                    match(input,50,FOLLOW_50_in_declaracao1145); if (state.failed) return declaracao;
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:41: (tk2= '[' (ind2= expressao )? ']' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==49) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:42: tk2= '[' (ind2= expressao )? ']'
                            {
                            tk2=(Token)match(input,49,FOLLOW_49_in_declaracao1152); if (state.failed) return declaracao;
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:52: (ind2= expressao )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( ((LA6_0>=CONST_LOGICO && LA6_0<=CONST_INTEIRO)||LA6_0==CONST_REAL||(LA6_0>=CONST_CADEIA && LA6_0<=APELIDO)||LA6_0==46||LA6_0==52||LA6_0==71||LA6_0==75) ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:53: ind2= expressao
                                    {
                                    pushFollow(FOLLOW_expressao_in_declaracao1159);
                                    ind2=expressao();

                                    state._fsp--;
                                    if (state.failed) return declaracao;

                                    }
                                    break;

                            }

                            match(input,50,FOLLOW_50_in_declaracao1163); if (state.failed) return declaracao;

                            }
                            break;

                    }


                    }
                    break;

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:80: ( '=' inicializacao= expressao )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==51) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:323:81: '=' inicializacao= expressao
                    {
                    match(input,51,FOLLOW_51_in_declaracao1170); if (state.failed) return declaracao;
                    pushFollow(FOLLOW_expressao_in_declaracao1176);
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
              		declaracao.setTokenNome(criarToken(ID1));
              		declaracao.setTokenTipoDado(informacaoTipoDado.getToken());
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return declaracao;
    }
    // $ANTLR end "declaracao"


    // $ANTLR start "declaracaoTipoDado"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:347:1: declaracaoTipoDado returns [InformacaoTipoDado informacaoTipoDado] : (tokenTipoDado= INTEIRO | tokenTipoDado= REAL | tokenTipoDado= CARACTER | tokenTipoDado= CADEIA | tokenTipoDado= LOGICO ) ;
    public final InformacaoTipoDado declaracaoTipoDado() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token tokenTipoDado=null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:347:66: ( (tokenTipoDado= INTEIRO | tokenTipoDado= REAL | tokenTipoDado= CARACTER | tokenTipoDado= CADEIA | tokenTipoDado= LOGICO ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:2: (tokenTipoDado= INTEIRO | tokenTipoDado= REAL | tokenTipoDado= CARACTER | tokenTipoDado= CADEIA | tokenTipoDado= LOGICO )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:2: (tokenTipoDado= INTEIRO | tokenTipoDado= REAL | tokenTipoDado= CARACTER | tokenTipoDado= CADEIA | tokenTipoDado= LOGICO )
            int alt10=5;
            switch ( input.LA(1) ) {
            case INTEIRO:
                {
                alt10=1;
                }
                break;
            case REAL:
                {
                alt10=2;
                }
                break;
            case CARACTER:
                {
                alt10=3;
                }
                break;
            case CADEIA:
                {
                alt10=4;
                }
                break;
            case LOGICO:
                {
                alt10=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return informacaoTipoDado;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:3: tokenTipoDado= INTEIRO
                    {
                    tokenTipoDado=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_declaracaoTipoDado1202); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:29: tokenTipoDado= REAL
                    {
                    tokenTipoDado=(Token)match(input,REAL,FOLLOW_REAL_in_declaracaoTipoDado1210); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 3 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:52: tokenTipoDado= CARACTER
                    {
                    tokenTipoDado=(Token)match(input,CARACTER,FOLLOW_CARACTER_in_declaracaoTipoDado1218); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 4 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:79: tokenTipoDado= CADEIA
                    {
                    tokenTipoDado=(Token)match(input,CADEIA,FOLLOW_CADEIA_in_declaracaoTipoDado1226); if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 5 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:349:104: tokenTipoDado= LOGICO
                    {
                    tokenTipoDado=(Token)match(input,LOGICO,FOLLOW_LOGICO_in_declaracaoTipoDado1234); if (state.failed) return informacaoTipoDado;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		informacaoTipoDado = new InformacaoTipoDado();
              		informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
              		informacaoTipoDado.setToken(criarToken(tokenTipoDado));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDado"


    // $ANTLR start "declaracaoTipoDadoVazio"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:357:1: declaracaoTipoDadoVazio returns [InformacaoTipoDado informacaoTipoDado] : VAZIO ;
    public final InformacaoTipoDado declaracaoTipoDadoVazio() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        Token VAZIO2=null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:357:71: ( VAZIO )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:359:2: VAZIO
            {
            VAZIO2=(Token)match(input,VAZIO,FOLLOW_VAZIO_in_declaracaoTipoDadoVazio1251); if (state.failed) return informacaoTipoDado;
            if ( state.backtracking==0 ) {
               
              		informacaoTipoDado = new InformacaoTipoDado();
              		informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
              		informacaoTipoDado.setToken(criarToken(VAZIO2));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "declaracaoTipoDadoVazio"


    // $ANTLR start "quantificador"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:369:1: quantificador returns [Quantificador quantificador] : (tk1= '[' ']' (tk2= '[' ']' )? )? ;
    public final Quantificador quantificador() throws RecognitionException {
        Quantificador quantificador = null;

        Token tk1=null;
        Token tk2=null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:369:51: ( (tk1= '[' ']' (tk2= '[' ']' )? )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:371:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:371:2: (tk1= '[' ']' (tk2= '[' ']' )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==49) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:371:3: tk1= '[' ']' (tk2= '[' ']' )?
                    {
                    tk1=(Token)match(input,49,FOLLOW_49_in_quantificador1274); if (state.failed) return quantificador;
                    match(input,50,FOLLOW_50_in_quantificador1276); if (state.failed) return quantificador;
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:371:17: (tk2= '[' ']' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==49) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:371:18: tk2= '[' ']'
                            {
                            tk2=(Token)match(input,49,FOLLOW_49_in_quantificador1283); if (state.failed) return quantificador;
                            match(input,50,FOLLOW_50_in_quantificador1285); if (state.failed) return quantificador;

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
        }
        return quantificador;
    }
    // $ANTLR end "quantificador"


    // $ANTLR start "tipoRetornoFuncao"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:382:1: tipoRetornoFuncao returns [InformacaoTipoDado informacaoTipoDado] : (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? ;
    public final InformacaoTipoDado tipoRetornoFuncao() throws RecognitionException {
        InformacaoTipoDado informacaoTipoDado = null;

        InformacaoTipoDado informacao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:382:65: ( (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:384:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:384:2: (informacao= declaracaoTipoDado | informacao= declaracaoTipoDadoVazio )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==REAL||(LA13_0>=LOGICO && LA13_0<=CARACTER)) ) {
                alt13=1;
            }
            else if ( (LA13_0==VAZIO) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:384:3: informacao= declaracaoTipoDado
                    {
                    pushFollow(FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1312);
                    informacao=declaracaoTipoDado();

                    state._fsp--;
                    if (state.failed) return informacaoTipoDado;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:384:37: informacao= declaracaoTipoDadoVazio
                    {
                    pushFollow(FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1320);
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
        }
        return informacaoTipoDado;
    }
    // $ANTLR end "tipoRetornoFuncao"


    // $ANTLR start "declaracaoFuncao"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:397:1: declaracaoFuncao[ArvoreSintaticaAbstrata asa] : FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' ;
    public final void declaracaoFuncao(ArvoreSintaticaAbstrata asa) throws RecognitionException {
        Token ID3=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;

        List<NoParametro> vListaParametros = null;

        List<NoBloco> vBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:397:47: ( FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:399:2: FUNCAO informacaoTipoDado= tipoRetornoFuncao vQuantificador= quantificador ID '(' vListaParametros= listaParametrosFuncao ')' '{' vBlocos= blocos '}'
            {
            match(input,FUNCAO,FOLLOW_FUNCAO_in_declaracaoFuncao1338); if (state.failed) return ;
            pushFollow(FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1348);
            informacaoTipoDado=tipoRetornoFuncao();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_quantificador_in_declaracaoFuncao1357);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return ;
            ID3=(Token)match(input,ID,FOLLOW_ID_in_declaracaoFuncao1364); if (state.failed) return ;
            match(input,52,FOLLOW_52_in_declaracaoFuncao1366); if (state.failed) return ;
            pushFollow(FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1372);
            vListaParametros=listaParametrosFuncao();

            state._fsp--;
            if (state.failed) return ;
            match(input,53,FOLLOW_53_in_declaracaoFuncao1374); if (state.failed) return ;
            match(input,46,FOLLOW_46_in_declaracaoFuncao1394); if (state.failed) return ;
            pushFollow(FOLLOW_blocos_in_declaracaoFuncao1402);
            vBlocos=blocos();

            state._fsp--;
            if (state.failed) return ;
            match(input,47,FOLLOW_47_in_declaracaoFuncao1412); if (state.failed) return ;
            if ( state.backtracking==0 ) {

                       	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao((ID3!=null?ID3.getText():null), informacaoTipoDado.getTipoDado(), vQuantificador);
              		declaracaoFuncao.setParametros(vListaParametros);
              		declaracaoFuncao.setBlocos(vBlocos);

              		declaracaoFuncao.setTokenNome(criarToken(ID3));
              		declaracaoFuncao.setTokenTipoDado(informacaoTipoDado.getToken());

                      	asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
                       
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declaracaoFuncao"


    // $ANTLR start "listaParametrosFuncao"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:423:1: listaParametrosFuncao returns [List<NoParametro> listaParametros] : ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? ;
    public final List<NoParametro> listaParametrosFuncao() throws RecognitionException {
        List<NoParametro> listaParametros = null;

        NoParametro vDeclaracaoParametro = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:423:65: ( ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:424:1: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            {
            if ( state.backtracking==0 ) {

              	listaParametros = new ArrayList<NoParametro>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:427:2: ( (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==REAL||(LA15_0>=LOGICO && LA15_0<=CARACTER)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:428:3: (vDeclaracaoParametro= declaracaoParametro ) ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:428:3: (vDeclaracaoParametro= declaracaoParametro )
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:428:8: vDeclaracaoParametro= declaracaoParametro
                    {
                    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1460);
                    vDeclaracaoParametro=declaracaoParametro();

                    state._fsp--;
                    if (state.failed) return listaParametros;
                    if ( state.backtracking==0 ) {
                       listaParametros.add(vDeclaracaoParametro); 
                    }

                    }

                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:429:3: ( ',' vDeclaracaoParametro= declaracaoParametro )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==48) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:429:4: ',' vDeclaracaoParametro= declaracaoParametro
                    	    {
                    	    match(input,48,FOLLOW_48_in_listaParametrosFuncao1468); if (state.failed) return listaParametros;
                    	    pushFollow(FOLLOW_declaracaoParametro_in_listaParametrosFuncao1474);
                    	    vDeclaracaoParametro=declaracaoParametro();

                    	    state._fsp--;
                    	    if (state.failed) return listaParametros;
                    	    if ( state.backtracking==0 ) {
                    	       listaParametros.add(vDeclaracaoParametro); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
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
        }
        return listaParametros;
    }
    // $ANTLR end "listaParametrosFuncao"


    // $ANTLR start "declaracaoParametro"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:433:1: declaracaoParametro returns [NoParametro parametro] : informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador ;
    public final NoParametro declaracaoParametro() throws RecognitionException {
        NoParametro parametro = null;

        Token tkr=null;
        Token ID4=null;
        InformacaoTipoDado informacaoTipoDado = null;

        Quantificador vQuantificador = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:433:51: (informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:435:2: informacaoTipoDado= declaracaoTipoDado (tkr= '&' )? ID vQuantificador= quantificador
            {
            pushFollow(FOLLOW_declaracaoTipoDado_in_declaracaoParametro1499);
            informacaoTipoDado=declaracaoTipoDado();

            state._fsp--;
            if (state.failed) return parametro;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:435:42: (tkr= '&' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==54) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:435:43: tkr= '&'
                    {
                    tkr=(Token)match(input,54,FOLLOW_54_in_declaracaoParametro1506); if (state.failed) return parametro;

                    }
                    break;

            }

            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaracaoParametro1510); if (state.failed) return parametro;
            pushFollow(FOLLOW_quantificador_in_declaracaoParametro1516);
            vQuantificador=quantificador();

            state._fsp--;
            if (state.failed) return parametro;
            if ( state.backtracking==0 ) {

              		NoParametro.ModoAcesso modoAcesso = null;
              		
              		if (tkr == null) modoAcesso = NoParametro.ModoAcesso.POR_VALOR;
              		else
              		if (tkr != null) modoAcesso = NoParametro.ModoAcesso.POR_REFERENCIA;
              		
              		
              		parametro = new NoParametro((ID4!=null?ID4.getText():null), informacaoTipoDado.getTipoDado(), vQuantificador, modoAcesso);
              		parametro.setTokenNome(criarToken(ID4));
              		parametro.setTokenTipoDado(informacaoTipoDado.getToken());
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return parametro;
    }
    // $ANTLR end "declaracaoParametro"


    // $ANTLR start "blocos"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:451:1: blocos returns [List<NoBloco> blocos] : (vBloco= bloco | declaracoesLocais[blocos] )* ;
    public final List<NoBloco> blocos() throws RecognitionException {
        List<NoBloco> blocos = null;

        NoBloco vBloco = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:451:37: ( (vBloco= bloco | declaracoesLocais[blocos] )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:452:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            {
            if ( state.backtracking==0 ) {

              	blocos = new ArrayList<NoBloco>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:455:1: (vBloco= bloco | declaracoesLocais[blocos] )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==ESCOLHA||LA17_0==PERCORRA||(LA17_0>=RETORNE && LA17_0<=SE)||(LA17_0>=CONST_LOGICO && LA17_0<=CONST_INTEIRO)||LA17_0==CONST_REAL||(LA17_0>=CONST_CADEIA && LA17_0<=APELIDO)||LA17_0==46||LA17_0==52||LA17_0==71||LA17_0==75) ) {
                    alt17=1;
                }
                else if ( (LA17_0==REAL||(LA17_0>=LOGICO && LA17_0<=CARACTER)||LA17_0==CONST) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:456:2: vBloco= bloco
            	    {
            	    pushFollow(FOLLOW_bloco_in_blocos1540);
            	    vBloco=bloco();

            	    state._fsp--;
            	    if (state.failed) return blocos;
            	    if ( state.backtracking==0 ) {
            	       blocos.add(vBloco); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:456:43: declaracoesLocais[blocos]
            	    {
            	    pushFollow(FOLLOW_declaracoesLocais_in_blocos1546);
            	    declaracoesLocais(blocos);

            	    state._fsp--;
            	    if (state.failed) return blocos;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return blocos;
    }
    // $ANTLR end "blocos"


    // $ANTLR start "bloco"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:460:1: bloco returns [NoBloco bloco] : (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha | vPercorra= percorra ) ;
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

        NoPercorra vPercorra = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:460:29: ( (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha | vPercorra= percorra ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:461:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha | vPercorra= percorra )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:461:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha | vPercorra= percorra )
            int alt18=9;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:462:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_bloco1570);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vExpressao; 	 
                    }

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:463:3: vPara= para
                    {
                    pushFollow(FOLLOW_para_in_bloco1584);
                    vPara=para();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPara; 	 
                    }

                    }
                    break;
                case 3 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:464:3: vPare= pare
                    {
                    pushFollow(FOLLOW_pare_in_bloco1601);
                    vPare=pare();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPare; 	 
                    }

                    }
                    break;
                case 4 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:465:3: vRetorne= retorne
                    {
                    pushFollow(FOLLOW_retorne_in_bloco1617);
                    vRetorne=retorne();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vRetorne; 	 
                    }

                    }
                    break;
                case 5 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:466:3: vSe= se
                    {
                    pushFollow(FOLLOW_se_in_bloco1632);
                    vSe=se();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vSe; 		 
                    }

                    }
                    break;
                case 6 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:467:3: vEnquanto= enquanto
                    {
                    pushFollow(FOLLOW_enquanto_in_bloco1648);
                    vEnquanto=enquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEnquanto;	 
                    }

                    }
                    break;
                case 7 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:468:3: vFacaEnquanto= facaEnquanto
                    {
                    pushFollow(FOLLOW_facaEnquanto_in_bloco1662);
                    vFacaEnquanto=facaEnquanto();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vFacaEnquanto; 
                    }

                    }
                    break;
                case 8 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:469:3: vEscolha= escolha
                    {
                    pushFollow(FOLLOW_escolha_in_bloco1676);
                    vEscolha=escolha();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vEscolha;	 
                    }

                    }
                    break;
                case 9 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:470:3: vPercorra= percorra
                    {
                    pushFollow(FOLLOW_percorra_in_bloco1691);
                    vPercorra=percorra();

                    state._fsp--;
                    if (state.failed) return bloco;
                    if ( state.backtracking==0 ) {
                       bloco = vPercorra; 	 
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
        }
        return bloco;
    }
    // $ANTLR end "bloco"


    // $ANTLR start "percorra"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:474:1: percorra returns [NoPercorra percorra] : PERCORRA '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoPercorra percorra() throws RecognitionException {
        NoPercorra percorra = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:474:38: ( PERCORRA '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:476:2: PERCORRA '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,PERCORRA,FOLLOW_PERCORRA_in_percorra1711); if (state.failed) return percorra;
            match(input,52,FOLLOW_52_in_percorra1713); if (state.failed) return percorra;
            pushFollow(FOLLOW_expressao_in_percorra1719);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return percorra;
            match(input,53,FOLLOW_53_in_percorra1721); if (state.failed) return percorra;
            pushFollow(FOLLOW_listaBlocos_in_percorra1728);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return percorra;
            if ( state.backtracking==0 ) {

              		percorra = new NoPercorra(vExpressao);
              		percorra.setBlocos(vListaBlocos);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return percorra;
    }
    // $ANTLR end "percorra"


    // $ANTLR start "para"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:485:1: para returns [NoPara para] : PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos ;
    public final NoPara para() throws RecognitionException {
        NoPara para = null;

        NoBloco inicializacao = null;

        NoExpressao condicao = null;

        NoExpressao incremento = null;

        List<NoBloco> vBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:485:26: ( PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:2: PARA '(' (inicializacao= inicializacaoPara )? ';' (condicao= expressao )? ';' (incremento= expressao )? ')' vBlocos= listaBlocos
            {
            match(input,PARA,FOLLOW_PARA_in_para1746); if (state.failed) return para;
            match(input,52,FOLLOW_52_in_para1748); if (state.failed) return para;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:11: (inicializacao= inicializacaoPara )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==REAL||(LA19_0>=LOGICO && LA19_0<=CARACTER)||LA19_0==CONST||(LA19_0>=CONST_LOGICO && LA19_0<=CONST_INTEIRO)||LA19_0==CONST_REAL||(LA19_0>=CONST_CADEIA && LA19_0<=APELIDO)||LA19_0==46||LA19_0==52||LA19_0==71||LA19_0==75) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:12: inicializacao= inicializacaoPara
                    {
                    pushFollow(FOLLOW_inicializacaoPara_in_para1755);
                    inicializacao=inicializacaoPara();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_para1759); if (state.failed) return para;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:52: (condicao= expressao )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=CONST_LOGICO && LA20_0<=CONST_INTEIRO)||LA20_0==CONST_REAL||(LA20_0>=CONST_CADEIA && LA20_0<=APELIDO)||LA20_0==46||LA20_0==52||LA20_0==71||LA20_0==75) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:53: condicao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1766);
                    condicao=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_para1770); if (state.failed) return para;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:80: (incremento= expressao )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=CONST_LOGICO && LA21_0<=CONST_INTEIRO)||LA21_0==CONST_REAL||(LA21_0>=CONST_CADEIA && LA21_0<=APELIDO)||LA21_0==46||LA21_0==52||LA21_0==71||LA21_0==75) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:487:81: incremento= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_para1777);
                    incremento=expressao();

                    state._fsp--;
                    if (state.failed) return para;

                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_para1781); if (state.failed) return para;
            pushFollow(FOLLOW_listaBlocos_in_para1787);
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
        }
        return para;
    }
    // $ANTLR end "para"


    // $ANTLR start "inicializacaoPara"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:497:1: inicializacaoPara returns [NoBloco bloco] : (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) ;
    public final NoBloco inicializacaoPara() throws RecognitionException {
        NoBloco bloco = null;

        NoExpressao vExpressao = null;

        List<NoDeclaracao> vListaDeclaracoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:497:41: ( (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:499:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:499:2: (vExpressao= expressao | vListaDeclaracoes= listaDeclaracoes )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=CONST_LOGICO && LA22_0<=CONST_INTEIRO)||LA22_0==CONST_REAL||(LA22_0>=CONST_CADEIA && LA22_0<=APELIDO)||LA22_0==46||LA22_0==52||LA22_0==71||LA22_0==75) ) {
                alt22=1;
            }
            else if ( (LA22_0==REAL||(LA22_0>=LOGICO && LA22_0<=CARACTER)||LA22_0==CONST) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return bloco;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:499:3: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_inicializacaoPara1808);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return bloco;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:499:28: vListaDeclaracoes= listaDeclaracoes
                    {
                    pushFollow(FOLLOW_listaDeclaracoes_in_inicializacaoPara1816);
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
        }
        return bloco;
    }
    // $ANTLR end "inicializacaoPara"


    // $ANTLR start "listaBlocos"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:508:1: listaBlocos returns [List<NoBloco> listaBlocos] : ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) ;
    public final List<NoBloco> listaBlocos() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vListaBlocos = null;

        NoBloco vBloco = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:508:47: ( ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:509:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:509:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:510:2: ( '{' )=> '{' vListaBlocos= blocos '}'
                    {
                    match(input,46,FOLLOW_46_in_listaBlocos1840); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_listaBlocos1846);
                    vListaBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    if ( state.backtracking==0 ) {
                       listaBlocos = vListaBlocos; 
                    }
                    match(input,47,FOLLOW_47_in_listaBlocos1850); if (state.failed) return listaBlocos;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:514:2: vBloco= bloco
                    {
                    pushFollow(FOLLOW_bloco_in_listaBlocos1866);
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
        }
        return listaBlocos;
    }
    // $ANTLR end "listaBlocos"


    // $ANTLR start "pare"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:523:1: pare returns [NoPare pare] : PARE ;
    public final NoPare pare() throws RecognitionException {
        NoPare pare = null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:523:26: ( PARE )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:525:2: PARE
            {
            match(input,PARE,FOLLOW_PARE_in_pare1885); if (state.failed) return pare;
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
        }
        return pare;
    }
    // $ANTLR end "pare"


    // $ANTLR start "escolha"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:532:1: escolha returns [NoEscolha escolha] : ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' ;
    public final NoEscolha escolha() throws RecognitionException {
        NoEscolha escolha = null;

        NoExpressao vExpressao = null;

        List<NoCaso> vListaCasos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:532:35: ( ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:534:2: ESCOLHA '(' vExpressao= expressao ')' '{' vListaCasos= listaCasos '}'
            {
            match(input,ESCOLHA,FOLLOW_ESCOLHA_in_escolha1902); if (state.failed) return escolha;
            match(input,52,FOLLOW_52_in_escolha1904); if (state.failed) return escolha;
            pushFollow(FOLLOW_expressao_in_escolha1910);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return escolha;
            match(input,53,FOLLOW_53_in_escolha1912); if (state.failed) return escolha;
            match(input,46,FOLLOW_46_in_escolha1915); if (state.failed) return escolha;
            pushFollow(FOLLOW_listaCasos_in_escolha1924);
            vListaCasos=listaCasos();

            state._fsp--;
            if (state.failed) return escolha;
            match(input,47,FOLLOW_47_in_escolha1927); if (state.failed) return escolha;
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
        }
        return escolha;
    }
    // $ANTLR end "escolha"


    // $ANTLR start "listaCasos"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:545:1: listaCasos returns [List<NoCaso> casos] : ( CASO ( CONTRARIO | vExpressao= expressao ) ':' vBlocos= blocosCaso )* ;
    public final List<NoCaso> listaCasos() throws RecognitionException {
        List<NoCaso> casos = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:545:39: ( ( CASO ( CONTRARIO | vExpressao= expressao ) ':' vBlocos= blocosCaso )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:546:1: ( CASO ( CONTRARIO | vExpressao= expressao ) ':' vBlocos= blocosCaso )*
            {
            if ( state.backtracking==0 ) {

              	casos = new ArrayList<NoCaso>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:549:1: ( CASO ( CONTRARIO | vExpressao= expressao ) ':' vBlocos= blocosCaso )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==CASO) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:550:2: CASO ( CONTRARIO | vExpressao= expressao ) ':' vBlocos= blocosCaso
            	    {
            	    match(input,CASO,FOLLOW_CASO_in_listaCasos1948); if (state.failed) return casos;
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:550:7: ( CONTRARIO | vExpressao= expressao )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==CONTRARIO) ) {
            	        alt24=1;
            	    }
            	    else if ( ((LA24_0>=CONST_LOGICO && LA24_0<=CONST_INTEIRO)||LA24_0==CONST_REAL||(LA24_0>=CONST_CADEIA && LA24_0<=APELIDO)||LA24_0==46||LA24_0==52||LA24_0==71||LA24_0==75) ) {
            	        alt24=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return casos;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:550:8: CONTRARIO
            	            {
            	            match(input,CONTRARIO,FOLLOW_CONTRARIO_in_listaCasos1951); if (state.failed) return casos;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:550:20: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaCasos1959);
            	            vExpressao=expressao();

            	            state._fsp--;
            	            if (state.failed) return casos;

            	            }
            	            break;

            	    }

            	    match(input,56,FOLLOW_56_in_listaCasos1962); if (state.failed) return casos;
            	    pushFollow(FOLLOW_blocosCaso_in_listaCasos1968);
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
            	    break loop25;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return casos;
    }
    // $ANTLR end "listaCasos"


    // $ANTLR start "blocosCaso"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:561:1: blocosCaso returns [List<NoBloco> listaBlocos] : ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) ;
    public final List<NoBloco> blocosCaso() throws RecognitionException {
        List<NoBloco> listaBlocos = null;

        List<NoBloco> vBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:561:46: ( ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:4: ( '{' )=> ( '{' vBlocos= blocos '}' )
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:12: ( '{' vBlocos= blocos '}' )
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:13: '{' vBlocos= blocos '}'
                    {
                    match(input,46,FOLLOW_46_in_blocosCaso1995); if (state.failed) return listaBlocos;
                    pushFollow(FOLLOW_blocos_in_blocosCaso2001);
                    vBlocos=blocos();

                    state._fsp--;
                    if (state.failed) return listaBlocos;
                    match(input,47,FOLLOW_47_in_blocosCaso2003); if (state.failed) return listaBlocos;

                    }


                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:41: (vBlocos= blocos )
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:41: (vBlocos= blocos )
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:42: vBlocos= blocos
                    {
                    pushFollow(FOLLOW_blocos_in_blocosCaso2013);
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
        }
        return listaBlocos;
    }
    // $ANTLR end "blocosCaso"


    // $ANTLR start "enquanto"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:569:1: enquanto returns [NoEnquanto enquanto] : ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ;
    public final NoEnquanto enquanto() throws RecognitionException {
        NoEnquanto enquanto = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:569:38: ( ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:571:2: ENQUANTO '(' vExpressao= expressao ')' vListaBlocos= listaBlocos
            {
            match(input,ENQUANTO,FOLLOW_ENQUANTO_in_enquanto2032); if (state.failed) return enquanto;
            match(input,52,FOLLOW_52_in_enquanto2034); if (state.failed) return enquanto;
            pushFollow(FOLLOW_expressao_in_enquanto2040);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return enquanto;
            match(input,53,FOLLOW_53_in_enquanto2042); if (state.failed) return enquanto;
            pushFollow(FOLLOW_listaBlocos_in_enquanto2048);
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
        }
        return enquanto;
    }
    // $ANTLR end "enquanto"


    // $ANTLR start "facaEnquanto"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:579:1: facaEnquanto returns [NoFacaEnquanto facaEnquanto] : FACA vListaBlocos= listaBlocos ENQUANTO '(' vExpressao= expressao ')' ;
    public final NoFacaEnquanto facaEnquanto() throws RecognitionException {
        NoFacaEnquanto facaEnquanto = null;

        List<NoBloco> vListaBlocos = null;

        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:579:50: ( FACA vListaBlocos= listaBlocos ENQUANTO '(' vExpressao= expressao ')' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:581:2: FACA vListaBlocos= listaBlocos ENQUANTO '(' vExpressao= expressao ')'
            {
            match(input,FACA,FOLLOW_FACA_in_facaEnquanto2065); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_listaBlocos_in_facaEnquanto2071);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,ENQUANTO,FOLLOW_ENQUANTO_in_facaEnquanto2073); if (state.failed) return facaEnquanto;
            match(input,52,FOLLOW_52_in_facaEnquanto2075); if (state.failed) return facaEnquanto;
            pushFollow(FOLLOW_expressao_in_facaEnquanto2081);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return facaEnquanto;
            match(input,53,FOLLOW_53_in_facaEnquanto2083); if (state.failed) return facaEnquanto;
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
        }
        return facaEnquanto;
    }
    // $ANTLR end "facaEnquanto"


    // $ANTLR start "se"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:589:1: se returns [NoSe se] : SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( SENAO listaBlocosSenao= listaBlocos )? ;
    public final NoSe se() throws RecognitionException {
        NoSe se = null;

        NoExpressao vExpressao = null;

        List<NoBloco> vListaBlocos = null;

        List<NoBloco> listaBlocosSenao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:589:20: ( SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( SENAO listaBlocosSenao= listaBlocos )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:591:2: SE '(' vExpressao= expressao ')' vListaBlocos= listaBlocos ( SENAO listaBlocosSenao= listaBlocos )?
            {
            match(input,SE,FOLLOW_SE_in_se2101); if (state.failed) return se;
            match(input,52,FOLLOW_52_in_se2103); if (state.failed) return se;
            pushFollow(FOLLOW_expressao_in_se2109);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return se;
            match(input,53,FOLLOW_53_in_se2111); if (state.failed) return se;
            pushFollow(FOLLOW_listaBlocos_in_se2117);
            vListaBlocos=listaBlocos();

            state._fsp--;
            if (state.failed) return se;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:591:63: ( SENAO listaBlocosSenao= listaBlocos )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==SENAO) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:591:64: SENAO listaBlocosSenao= listaBlocos
                    {
                    match(input,SENAO,FOLLOW_SENAO_in_se2120); if (state.failed) return se;
                    pushFollow(FOLLOW_listaBlocos_in_se2126);
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
        }
        return se;
    }
    // $ANTLR end "se"


    // $ANTLR start "retorne"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:601:1: retorne returns [NoRetorne retorne] : RETORNE vExpressao= expressao ;
    public final NoRetorne retorne() throws RecognitionException {
        NoRetorne retorne = null;

        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:601:35: ( RETORNE vExpressao= expressao )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:603:2: RETORNE vExpressao= expressao
            {
            match(input,RETORNE,FOLLOW_RETORNE_in_retorne2147); if (state.failed) return retorne;
            pushFollow(FOLLOW_expressao_in_retorne2153);
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
        }
        return retorne;
    }
    // $ANTLR end "retorne"


    // $ANTLR start "pilha"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:609:1: pilha returns [Stack<Object> pilha] : ;
    public final Stack<Object> pilha() throws RecognitionException {
        Stack<Object> pilha = null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:609:35: ()
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:610:1: 
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
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:615:1: expressao returns [NoExpressao expressao] : operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* ;
    public final NoExpressao expressao() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        Stack<Object> vPilha = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:615:41: (operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:617:2: operandoEsquerdo= expressao2 vPilha= pilha ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            {
            pushFollow(FOLLOW_expressao2_in_expressao2186);
            operandoEsquerdo=expressao2();

            state._fsp--;
            if (state.failed) return expressao;
            pushFollow(FOLLOW_pilha_in_expressao2192);
            vPilha=pilha();

            state._fsp--;
            if (state.failed) return expressao;
            if ( state.backtracking==0 ) {
               vPilha.push(operandoEsquerdo); 
            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:618:2: ( (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==51||(LA29_0>=57 && LA29_0<=61)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' ) operandoDireito= expressao2
            	    {
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:3: (operador= '=' | operador= '+=' | operador= '-=' | operador= '/=' | operador= '*=' | operador= '%=' )
            	    int alt28=6;
            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt28=1;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt28=2;
            	        }
            	        break;
            	    case 58:
            	        {
            	        alt28=3;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt28=4;
            	        }
            	        break;
            	    case 60:
            	        {
            	        alt28=5;
            	        }
            	        break;
            	    case 61:
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
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:4: operador= '='
            	            {
            	            operador=(Token)match(input,51,FOLLOW_51_in_expressao2206); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:21: operador= '+='
            	            {
            	            operador=(Token)match(input,57,FOLLOW_57_in_expressao2214); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:39: operador= '-='
            	            {
            	            operador=(Token)match(input,58,FOLLOW_58_in_expressao2222); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 4 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:57: operador= '/='
            	            {
            	            operador=(Token)match(input,59,FOLLOW_59_in_expressao2230); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 5 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:75: operador= '*='
            	            {
            	            operador=(Token)match(input,60,FOLLOW_60_in_expressao2238); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 6 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:619:93: operador= '%='
            	            {
            	            operador=(Token)match(input,61,FOLLOW_61_in_expressao2246); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao2_in_expressao2258);
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
            	    break loop29;
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
              			operacao.setTokenOperador(criarToken(operador));
              			
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
        }
        return expressao;
    }
    // $ANTLR end "expressao"


    // $ANTLR start "expressao2"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:648:1: expressao2 returns [NoExpressao expressao] : operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* ;
    public final NoExpressao expressao2() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:648:42: (operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:650:2: operandoEsquerdo= expressao3 ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            {
            pushFollow(FOLLOW_expressao3_in_expressao22288);
            operandoEsquerdo=expressao3();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:651:2: ( (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=62 && LA31_0<=63)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:652:3: (operador= 'e' | operador= 'ou' ) operandoDireito= expressao3
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		
            	      			if (operandoDireito != null)
            	      			{
            	      				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	      				operacao.setTokenOperador(criarToken(operador));
            	      			 	operandoEsquerdo = operacao; 
            	      			 }
            	      		
            	    }
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:662:3: (operador= 'e' | operador= 'ou' )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==62) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==63) ) {
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
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:662:4: operador= 'e'
            	            {
            	            operador=(Token)match(input,62,FOLLOW_62_in_expressao22317); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:662:21: operador= 'ou'
            	            {
            	            operador=(Token)match(input,63,FOLLOW_63_in_expressao22325); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao3_in_expressao22337);
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

              		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expressao;
    }
    // $ANTLR end "expressao2"


    // $ANTLR start "expressao3"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:673:1: expressao3 returns [NoExpressao expressao] : operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* ;
    public final NoExpressao expressao3() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:673:42: (operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:675:2: operandoEsquerdo= expressao4 ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            {
            pushFollow(FOLLOW_expressao4_in_expressao32363);
            operandoEsquerdo=expressao4();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:676:2: ( (operador= '==' | operador= '!=' ) operandoDireito= expressao4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=64 && LA33_0<=65)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:677:3: (operador= '==' | operador= '!=' ) operandoDireito= expressao4
            	    {
            	    if ( state.backtracking==0 ) {

            	      		
            	      			if (operandoDireito != null)
            	      			{
            	      				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	      				operacao.setTokenOperador(criarToken(operador));
            	      			 	operandoEsquerdo = operacao; 
            	      			 }
            	      		
            	    }
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:687:3: (operador= '==' | operador= '!=' )
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
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:687:4: operador= '=='
            	            {
            	            operador=(Token)match(input,64,FOLLOW_64_in_expressao32384); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:687:22: operador= '!='
            	            {
            	            operador=(Token)match(input,65,FOLLOW_65_in_expressao32392); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao4_in_expressao32405);
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

              		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expressao;
    }
    // $ANTLR end "expressao3"


    // $ANTLR start "expressao4"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:698:1: expressao4 returns [NoExpressao expressao] : operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? ;
    public final NoExpressao expressao4() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:698:42: (operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:2: operandoEsquerdo= expressao5 ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            {
            pushFollow(FOLLOW_expressao5_in_expressao42431);
            operandoEsquerdo=expressao5();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:32: ( (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=66 && LA35_0<=69)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' ) operandoDireito= expressao5
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:33: (operador= '>=' | operador= '<=' | operador= '<' | operador= '>' )
                    int alt34=4;
                    switch ( input.LA(1) ) {
                    case 66:
                        {
                        alt34=1;
                        }
                        break;
                    case 67:
                        {
                        alt34=2;
                        }
                        break;
                    case 68:
                        {
                        alt34=3;
                        }
                        break;
                    case 69:
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
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:34: operador= '>='
                            {
                            operador=(Token)match(input,66,FOLLOW_66_in_expressao42439); if (state.failed) return expressao;

                            }
                            break;
                        case 2 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:52: operador= '<='
                            {
                            operador=(Token)match(input,67,FOLLOW_67_in_expressao42447); if (state.failed) return expressao;

                            }
                            break;
                        case 3 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:70: operador= '<'
                            {
                            operador=(Token)match(input,68,FOLLOW_68_in_expressao42455); if (state.failed) return expressao;

                            }
                            break;
                        case 4 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:700:87: operador= '>'
                            {
                            operador=(Token)match(input,69,FOLLOW_69_in_expressao42463); if (state.failed) return expressao;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expressao5_in_expressao42470);
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
        }
        return expressao;
    }
    // $ANTLR end "expressao4"


    // $ANTLR start "expressao5"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:708:1: expressao5 returns [NoExpressao expressao] : operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* ;
    public final NoExpressao expressao5() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:708:42: (operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:710:2: operandoEsquerdo= expressao6 ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
            {
            pushFollow(FOLLOW_expressao6_in_expressao52494);
            operandoEsquerdo=expressao6();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:711:2: ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*
            loop36:
            do {
                int alt36=3;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:712:3: (operador= '+' operandoDireito= expressao6 )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		
            	      			if (operandoDireito != null)
            	      			{
            	      				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	      				operacao.setTokenOperador(criarToken(operador));
            	      			 	operandoEsquerdo = operacao; 
            	      			 }
            	      		
            	    }
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:723:3: (operador= '+' operandoDireito= expressao6 )
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:723:4: operador= '+' operandoDireito= expressao6
            	    {
            	    operador=(Token)match(input,70,FOLLOW_70_in_expressao52518); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52524);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:723:51: ( '-' )=>operador= '-' operandoDireito= expressao6
            	    {
            	    operador=(Token)match(input,71,FOLLOW_71_in_expressao52538); if (state.failed) return expressao;
            	    pushFollow(FOLLOW_expressao6_in_expressao52544);
            	    operandoDireito=expressao6();

            	    state._fsp--;
            	    if (state.failed) return expressao;

            	    }
            	    break;

            	default :
            	    break loop36;
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
        }
        return expressao;
    }
    // $ANTLR end "expressao5"


    // $ANTLR start "expressao6"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:733:1: expressao6 returns [NoExpressao expressao] : operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* ;
    public final NoExpressao expressao6() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao operandoEsquerdo = null;

        NoExpressao operandoDireito = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:733:42: (operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:735:2: operandoEsquerdo= expressao7 ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            {
            pushFollow(FOLLOW_expressao7_in_expressao62575);
            operandoEsquerdo=expressao7();

            state._fsp--;
            if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:736:2: ( (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=72 && LA38_0<=74)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:737:3: (operador= '*' | operador= '/' | operador= '%' ) operandoDireito= expressao7
            	    {
            	    if ( state.backtracking==0 ) {

            	      		
            	      			if (operandoDireito != null)
            	      			{
            	      				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
            	      				operacao.setTokenOperador(criarToken(operador));
            	      			 	operandoEsquerdo = operacao; 
            	      			 }
            	      		
            	    }
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:748:3: (operador= '*' | operador= '/' | operador= '%' )
            	    int alt37=3;
            	    switch ( input.LA(1) ) {
            	    case 72:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case 74:
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
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:748:4: operador= '*'
            	            {
            	            operador=(Token)match(input,72,FOLLOW_72_in_expressao62598); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 2 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:748:21: operador= '/'
            	            {
            	            operador=(Token)match(input,73,FOLLOW_73_in_expressao62606); if (state.failed) return expressao;

            	            }
            	            break;
            	        case 3 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:748:38: operador= '%'
            	            {
            	            operador=(Token)match(input,74,FOLLOW_74_in_expressao62614); if (state.failed) return expressao;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expressao7_in_expressao62627);
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

              		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expressao;
    }
    // $ANTLR end "expressao6"


    // $ANTLR start "expressao7"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:759:1: expressao7 returns [NoExpressao expressao] : ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= 'nao' )* ) vExpressao= expressao8 ;
    public final NoExpressao expressao7() throws RecognitionException {
        NoExpressao expressao = null;

        Token listaTokenMenos=null;
        Token listaTokenNao=null;
        List list_listaTokenMenos=null;
        List list_listaTokenNao=null;
        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:759:42: ( ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= 'nao' )* ) vExpressao= expressao8 )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= 'nao' )* ) vExpressao= expressao8
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= 'nao' )* )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:3: ( '-' )=> (listaTokenMenos+= '-' )?
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:12: (listaTokenMenos+= '-' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==71) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:13: listaTokenMenos+= '-'
                            {
                            listaTokenMenos=(Token)match(input,71,FOLLOW_71_in_expressao72661); if (state.failed) return expressao;
                            if (list_listaTokenMenos==null) list_listaTokenMenos=new ArrayList();
                            list_listaTokenMenos.add(listaTokenMenos);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:40: (listaTokenNao+= 'nao' )*
                    {
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:40: (listaTokenNao+= 'nao' )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==75) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:41: listaTokenNao+= 'nao'
                    	    {
                    	    listaTokenNao=(Token)match(input,75,FOLLOW_75_in_expressao72672); if (state.failed) return expressao;
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

            pushFollow(FOLLOW_expressao8_in_expressao72682);
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
        }
        return expressao;
    }
    // $ANTLR end "expressao7"


    // $ANTLR start "expressao8"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:779:1: expressao8 returns [NoExpressao expressao] : ( '(' vExpressao= expressao ')' | vExpressao= tipoPrimitivo | vExpressao= referencia | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? ;
    public final NoExpressao expressao8() throws RecognitionException {
        NoExpressao expressao = null;

        Token operador=null;
        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:779:42: ( ( '(' vExpressao= expressao ')' | vExpressao= tipoPrimitivo | vExpressao= referencia | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:2: ( '(' vExpressao= expressao ')' | vExpressao= tipoPrimitivo | vExpressao= referencia | vExpressao= matrizVetor ) (operador= '++' | operador= '--' )?
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:2: ( '(' vExpressao= expressao ')' | vExpressao= tipoPrimitivo | vExpressao= referencia | vExpressao= matrizVetor )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt42=1;
                }
                break;
            case CONST_LOGICO:
            case CONST_INTEIRO:
            case CONST_REAL:
            case CONST_CADEIA:
            case CONST_CARACTER:
                {
                alt42=2;
                }
                break;
            case ID:
            case APELIDO:
                {
                alt42=3;
                }
                break;
            case 46:
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
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:3: '(' vExpressao= expressao ')'
                    {
                    match(input,52,FOLLOW_52_in_expressao82703); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_expressao82709);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,53,FOLLOW_53_in_expressao82711); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:36: vExpressao= tipoPrimitivo
                    {
                    pushFollow(FOLLOW_tipoPrimitivo_in_expressao82719);
                    vExpressao=tipoPrimitivo();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 3 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:65: vExpressao= referencia
                    {
                    pushFollow(FOLLOW_referencia_in_expressao82727);
                    vExpressao=referencia();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 4 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:781:91: vExpressao= matrizVetor
                    {
                    pushFollow(FOLLOW_matrizVetor_in_expressao82735);
                    vExpressao=matrizVetor();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:783:3: (operador= '++' | operador= '--' )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==76) ) {
                alt43=1;
            }
            else if ( (LA43_0==77) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:783:4: operador= '++'
                    {
                    operador=(Token)match(input,76,FOLLOW_76_in_expressao82748); if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:783:22: operador= '--'
                    {
                    operador=(Token)match(input,77,FOLLOW_77_in_expressao82756); if (state.failed) return expressao;

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
        }
        return expressao;
    }
    // $ANTLR end "expressao8"


    // $ANTLR start "tipoPrimitivo"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:797:1: tipoPrimitivo returns [NoExpressao expressao] : ( CONST_REAL | CONST_LOGICO | CONST_CADEIA | CONST_INTEIRO | CONST_CARACTER );
    public final NoExpressao tipoPrimitivo() throws RecognitionException {
        NoExpressao expressao = null;

        Token CONST_REAL5=null;
        Token CONST_LOGICO6=null;
        Token CONST_CADEIA7=null;
        Token CONST_INTEIRO8=null;
        Token CONST_CARACTER9=null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:797:45: ( CONST_REAL | CONST_LOGICO | CONST_CADEIA | CONST_INTEIRO | CONST_CARACTER )
            int alt44=5;
            switch ( input.LA(1) ) {
            case CONST_REAL:
                {
                alt44=1;
                }
                break;
            case CONST_LOGICO:
                {
                alt44=2;
                }
                break;
            case CONST_CADEIA:
                {
                alt44=3;
                }
                break;
            case CONST_INTEIRO:
                {
                alt44=4;
                }
                break;
            case CONST_CARACTER:
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
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:799:2: CONST_REAL
                    {
                    CONST_REAL5=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_tipoPrimitivo2775); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {
                       
                      		NoReal real = new NoReal(Double.parseDouble((CONST_REAL5!=null?CONST_REAL5.getText():null)));
                      		real.setToken(criarToken(CONST_REAL5));
                      		expressao = real;
                      	
                    }

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:808:2: CONST_LOGICO
                    {
                    CONST_LOGICO6=(Token)match(input,CONST_LOGICO,FOLLOW_CONST_LOGICO_in_tipoPrimitivo2795); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		NoLogico logico = new NoLogico(((CONST_LOGICO6!=null?CONST_LOGICO6.getText():null).equals("verdadeiro")? true : false));
                      		logico.setToken(criarToken(CONST_LOGICO6));
                      		expressao = logico;
                      	
                    }

                    }
                    break;
                case 3 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:817:2: CONST_CADEIA
                    {
                    CONST_CADEIA7=(Token)match(input,CONST_CADEIA,FOLLOW_CONST_CADEIA_in_tipoPrimitivo2809); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		String texto = (CONST_CADEIA7!=null?CONST_CADEIA7.getText():null);
                      		NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
                      		cadeia.setToken(criarToken(CONST_CADEIA7));
                      		expressao = cadeia;
                      	
                    }

                    }
                    break;
                case 4 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:827:2: CONST_INTEIRO
                    {
                    CONST_INTEIRO8=(Token)match(input,CONST_INTEIRO,FOLLOW_CONST_INTEIRO_in_tipoPrimitivo2822); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		NoInteiro inteiro = new NoInteiro(Integer.parseInt((CONST_INTEIRO8!=null?CONST_INTEIRO8.getText():null)));
                      		inteiro.setToken(criarToken(CONST_INTEIRO8));
                      		expressao = inteiro;
                      	
                    }

                    }
                    break;
                case 5 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:836:2: CONST_CARACTER
                    {
                    CONST_CARACTER9=(Token)match(input,CONST_CARACTER,FOLLOW_CONST_CARACTER_in_tipoPrimitivo2837); if (state.failed) return expressao;
                    if ( state.backtracking==0 ) {

                      		NoCaracter caracter = new NoCaracter((CONST_CARACTER9!=null?CONST_CARACTER9.getText():null).charAt(1));
                      		caracter.setToken(criarToken(CONST_CARACTER9));
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
        }
        return expressao;
    }
    // $ANTLR end "tipoPrimitivo"


    // $ANTLR start "referencia"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:844:1: referencia returns [NoReferencia referencia] : ( APELIDO )? ID ( ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text] | vExpressao= referenciaId[$APELIDO.text, $ID.text] ) ;
    public final NoReferencia referencia() throws RecognitionException {
        NoReferencia referencia = null;

        Token APELIDO10=null;
        Token ID11=null;
        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:844:44: ( ( APELIDO )? ID ( ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text] | vExpressao= referenciaId[$APELIDO.text, $ID.text] ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:846:2: ( APELIDO )? ID ( ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text] | vExpressao= referenciaId[$APELIDO.text, $ID.text] )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:846:2: ( APELIDO )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==APELIDO) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:846:2: APELIDO
                    {
                    APELIDO10=(Token)match(input,APELIDO,FOLLOW_APELIDO_in_referencia2856); if (state.failed) return referencia;

                    }
                    break;

            }

            ID11=(Token)match(input,ID,FOLLOW_ID_in_referencia2859); if (state.failed) return referencia;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:847:2: ( ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text] | vExpressao= referenciaId[$APELIDO.text, $ID.text] )
            int alt46=3;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:848:3: ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text]
                    {
                    pushFollow(FOLLOW_chamadaFuncao_in_referencia2876);
                    vExpressao=chamadaFuncao((APELIDO10!=null?APELIDO10.getText():null), (ID11!=null?ID11.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:849:3: ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text]
                    {
                    pushFollow(FOLLOW_referenciaVetorMatriz_in_referencia2893);
                    vExpressao=referenciaVetorMatriz((APELIDO10!=null?APELIDO10.getText():null), (ID11!=null?ID11.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;
                case 3 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:850:5: vExpressao= referenciaId[$APELIDO.text, $ID.text]
                    {
                    pushFollow(FOLLOW_referenciaId_in_referencia2906);
                    vExpressao=referenciaId((APELIDO10!=null?APELIDO10.getText():null), (ID11!=null?ID11.getText():null));

                    state._fsp--;
                    if (state.failed) return referencia;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		referencia = (NoReferencia) vExpressao;
              		referencia.setTokenNome(criarToken(ID11));
              		referencia.setTokenApelido(criarToken(APELIDO10));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return referencia;
    }
    // $ANTLR end "referencia"


    // $ANTLR start "referenciaId"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:859:1: referenciaId[String apelido, String nome] returns [NoExpressao expressao] : ;
    public final NoExpressao referenciaId(String apelido, String nome) throws RecognitionException {
        NoExpressao expressao = null;

        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:859:74: ()
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:861:2: 
            {
            if ( state.backtracking==0 ) {

              		expressao = new NoReferenciaVariavel(obterApelido(apelido), nome);
              	
            }

            }

        }
        finally {
        }
        return expressao;
    }
    // $ANTLR end "referenciaId"


    // $ANTLR start "referenciaVetorMatriz"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:867:1: referenciaVetorMatriz[String apelido, String nome] returns [NoExpressao expressao] : '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? ;
    public final NoExpressao referenciaVetorMatriz(String apelido, String nome) throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao indice1 = null;

        NoExpressao indice2 = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:867:83: ( '[' indice1= expressao ']' ( '[' indice2= expressao ']' )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:869:2: '[' indice1= expressao ']' ( '[' indice2= expressao ']' )?
            {
            match(input,49,FOLLOW_49_in_referenciaVetorMatriz2946); if (state.failed) return expressao;
            pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz2952);
            indice1=expressao();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,50,FOLLOW_50_in_referenciaVetorMatriz2954); if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:869:30: ( '[' indice2= expressao ']' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==49) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:869:31: '[' indice2= expressao ']'
                    {
                    match(input,49,FOLLOW_49_in_referenciaVetorMatriz2957); if (state.failed) return expressao;
                    pushFollow(FOLLOW_expressao_in_referenciaVetorMatriz2963);
                    indice2=expressao();

                    state._fsp--;
                    if (state.failed) return expressao;
                    match(input,50,FOLLOW_50_in_referenciaVetorMatriz2965); if (state.failed) return expressao;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(obterApelido(apelido), nome, indice1);
              		else		
              		if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(obterApelido(apelido), nome, indice1, indice2);		
              	 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expressao;
    }
    // $ANTLR end "referenciaVetorMatriz"


    // $ANTLR start "chamadaFuncao"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:877:1: chamadaFuncao[String apelido, String nome] returns [NoExpressao expressao] : '(' (vListaParametros= listaParametros )? ')' ;
    public final NoExpressao chamadaFuncao(String apelido, String nome) throws RecognitionException {
        NoExpressao expressao = null;

        List<NoExpressao> vListaParametros = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:877:75: ( '(' (vListaParametros= listaParametros )? ')' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:879:2: '(' (vListaParametros= listaParametros )? ')'
            {
            match(input,52,FOLLOW_52_in_chamadaFuncao2987); if (state.failed) return expressao;
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:879:6: (vListaParametros= listaParametros )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=CONST_LOGICO && LA48_0<=CONST_INTEIRO)||LA48_0==CONST_REAL||(LA48_0>=CONST_CADEIA && LA48_0<=APELIDO)||LA48_0==46||LA48_0==52||LA48_0==71||LA48_0==75) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:879:7: vListaParametros= listaParametros
                    {
                    pushFollow(FOLLOW_listaParametros_in_chamadaFuncao2994);
                    vListaParametros=listaParametros();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_chamadaFuncao2998); if (state.failed) return expressao;
            if ( state.backtracking==0 ) {

              		NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(obterApelido(apelido), nome);
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
        }
        return expressao;
    }
    // $ANTLR end "chamadaFuncao"


    // $ANTLR start "listaParametros"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:888:1: listaParametros returns [List<NoExpressao> listaParametros] : (vExpressao= expressao ) ( ',' vExpressao= expressao )* ;
    public final List<NoExpressao> listaParametros() throws RecognitionException {
        List<NoExpressao> listaParametros = null;

        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:888:59: ( (vExpressao= expressao ) ( ',' vExpressao= expressao )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:889:1: (vExpressao= expressao ) ( ',' vExpressao= expressao )*
            {
            if ( state.backtracking==0 ) {

              	listaParametros = new ArrayList<NoExpressao>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:892:2: (vExpressao= expressao )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:892:6: vExpressao= expressao
            {
            pushFollow(FOLLOW_expressao_in_listaParametros3025);
            vExpressao=expressao();

            state._fsp--;
            if (state.failed) return listaParametros;
            if ( state.backtracking==0 ) {
               listaParametros.add(vExpressao); 
            }

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:893:2: ( ',' vExpressao= expressao )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==48) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:893:3: ',' vExpressao= expressao
            	    {
            	    match(input,48,FOLLOW_48_in_listaParametros3032); if (state.failed) return listaParametros;
            	    pushFollow(FOLLOW_expressao_in_listaParametros3037);
            	    vExpressao=expressao();

            	    state._fsp--;
            	    if (state.failed) return listaParametros;
            	    if ( state.backtracking==0 ) {
            	       listaParametros.add(vExpressao); 
            	    }

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
        }
        return listaParametros;
    }
    // $ANTLR end "listaParametros"


    // $ANTLR start "matrizVetor"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:896:1: matrizVetor returns [NoExpressao expressao] : ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) ;
    public final NoExpressao matrizVetor() throws RecognitionException {
        NoExpressao expressao = null;

        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:896:43: ( ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor ) )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:2: ( ( '{' '{' )=>vExpressao= matriz | vExpressao= vetor )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==46) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred7_Portugol()) ) {
                    alt50=1;
                }
                else if ( (true) ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expressao;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expressao;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:3: ( '{' '{' )=>vExpressao= matriz
                    {
                    pushFollow(FOLLOW_matriz_in_matrizVetor3067);
                    vExpressao=matriz();

                    state._fsp--;
                    if (state.failed) return expressao;

                    }
                    break;
                case 2 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:37: vExpressao= vetor
                    {
                    pushFollow(FOLLOW_vetor_in_matrizVetor3075);
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
        }
        return expressao;
    }
    // $ANTLR end "matrizVetor"


    // $ANTLR start "vetor"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:905:1: vetor returns [NoExpressao expressao] : '{' vListaExpressoes= listaExpressoes '}' ;
    public final NoExpressao vetor() throws RecognitionException {
        NoExpressao expressao = null;

        List<Object> vListaExpressoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:905:37: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:907:2: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,46,FOLLOW_46_in_vetor3094); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaExpressoes_in_vetor3100);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,47,FOLLOW_47_in_vetor3102); if (state.failed) return expressao;
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
        }
        return expressao;
    }
    // $ANTLR end "vetor"


    // $ANTLR start "matriz"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:913:1: matriz returns [NoExpressao expressao] : '{' vListaListaExpressoes= listaListaExpressoes '}' ;
    public final NoExpressao matriz() throws RecognitionException {
        NoExpressao expressao = null;

        List<List<Object>> vListaListaExpressoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:913:38: ( '{' vListaListaExpressoes= listaListaExpressoes '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:915:2: '{' vListaListaExpressoes= listaListaExpressoes '}'
            {
            match(input,46,FOLLOW_46_in_matriz3121); if (state.failed) return expressao;
            pushFollow(FOLLOW_listaListaExpressoes_in_matriz3129);
            vListaListaExpressoes=listaListaExpressoes();

            state._fsp--;
            if (state.failed) return expressao;
            match(input,47,FOLLOW_47_in_matriz3132); if (state.failed) return expressao;
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
        }
        return expressao;
    }
    // $ANTLR end "matriz"


    // $ANTLR start "listaListaExpressoes"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:924:1: listaListaExpressoes returns [List<List<Object>> listaListaExpressoes] : ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* ;
    public final List<List<Object>> listaListaExpressoes() throws RecognitionException {
        List<List<Object>> listaListaExpressoes = null;

        List<Object> vListaExpressoes = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:924:70: ( ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:925:1: ( '{' vListaExpressoes= listaExpressoes '}' ) ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            {
            if ( state.backtracking==0 ) {

              	listaListaExpressoes = new ArrayList<List<Object>>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:928:2: ( '{' vListaExpressoes= listaExpressoes '}' )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:928:27: '{' vListaExpressoes= listaExpressoes '}'
            {
            match(input,46,FOLLOW_46_in_listaListaExpressoes3175); if (state.failed) return listaListaExpressoes;
            pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3181);
            vListaExpressoes=listaExpressoes();

            state._fsp--;
            if (state.failed) return listaListaExpressoes;
            match(input,47,FOLLOW_47_in_listaListaExpressoes3183); if (state.failed) return listaListaExpressoes;
            if ( state.backtracking==0 ) {
               listaListaExpressoes.add(vListaExpressoes); 
            }

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:929:2: ( ',' '{' vListaExpressoes= listaExpressoes '}' )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==48) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:929:4: ',' '{' vListaExpressoes= listaExpressoes '}'
            	    {
            	    if ( state.backtracking==0 ) {
            	       vListaExpressoes = null; 
            	    }
            	    match(input,48,FOLLOW_48_in_listaListaExpressoes3193); if (state.failed) return listaListaExpressoes;
            	    match(input,46,FOLLOW_46_in_listaListaExpressoes3195); if (state.failed) return listaListaExpressoes;
            	    pushFollow(FOLLOW_listaExpressoes_in_listaListaExpressoes3201);
            	    vListaExpressoes=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return listaListaExpressoes;
            	    match(input,47,FOLLOW_47_in_listaListaExpressoes3203); if (state.failed) return listaListaExpressoes;
            	    if ( state.backtracking==0 ) {
            	       listaListaExpressoes.add(vListaExpressoes); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return listaListaExpressoes;
    }
    // $ANTLR end "listaListaExpressoes"


    // $ANTLR start "listaExpressoes"
    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:933:1: listaExpressoes returns [List<Object> listaExpressoes] : ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* ;
    public final List<Object> listaExpressoes() throws RecognitionException {
        List<Object> listaExpressoes = null;

        NoExpressao vExpressao = null;


        try {
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:933:54: ( ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )* )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:934:1: ( (vExpressao= expressao )? ) ( ',' (vExpressao= expressao )? )*
            {
            if ( state.backtracking==0 ) {

              	listaExpressoes = new ArrayList<Object>();

            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:937:2: ( (vExpressao= expressao )? )
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:937:3: (vExpressao= expressao )?
            {
            if ( state.backtracking==0 ) {
               vExpressao = null; 
            }
            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:937:30: (vExpressao= expressao )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=CONST_LOGICO && LA52_0<=CONST_INTEIRO)||LA52_0==CONST_REAL||(LA52_0>=CONST_CADEIA && LA52_0<=APELIDO)||LA52_0==46||LA52_0==52||LA52_0==71||LA52_0==75) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:937:31: vExpressao= expressao
                    {
                    pushFollow(FOLLOW_expressao_in_listaExpressoes3234);
                    vExpressao=expressao();

                    state._fsp--;
                    if (state.failed) return listaExpressoes;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               listaExpressoes.add(vExpressao); 
            }

            }

            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:938:2: ( ',' (vExpressao= expressao )? )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==48) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:938:3: ',' (vExpressao= expressao )?
            	    {
            	    if ( state.backtracking==0 ) {
            	       vExpressao = null; 
            	    }
            	    match(input,48,FOLLOW_48_in_listaExpressoes3245); if (state.failed) return listaExpressoes;
            	    // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:938:30: (vExpressao= expressao )?
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( ((LA53_0>=CONST_LOGICO && LA53_0<=CONST_INTEIRO)||LA53_0==CONST_REAL||(LA53_0>=CONST_CADEIA && LA53_0<=APELIDO)||LA53_0==46||LA53_0==52||LA53_0==71||LA53_0==75) ) {
            	        alt53=1;
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:938:31: vExpressao= expressao
            	            {
            	            pushFollow(FOLLOW_expressao_in_listaExpressoes3252);
            	            vExpressao=expressao();

            	            state._fsp--;
            	            if (state.failed) return listaExpressoes;

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	       listaExpressoes.add(vExpressao); 
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
        }
        return listaExpressoes;
    }
    // $ANTLR end "listaExpressoes"

    // $ANTLR start synpred1_Portugol
    public final void synpred1_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:510:2: ( '{' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:510:3: '{'
        {
        match(input,46,FOLLOW_46_in_synpred1_Portugol1836); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Portugol

    // $ANTLR start synpred2_Portugol
    public final void synpred2_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:4: ( '{' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:563:5: '{'
        {
        match(input,46,FOLLOW_46_in_synpred2_Portugol1990); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Portugol

    // $ANTLR start synpred3_Portugol
    public final void synpred3_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:723:51: ( '-' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:723:52: '-'
        {
        match(input,71,FOLLOW_71_in_synpred3_Portugol2530); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Portugol

    // $ANTLR start synpred4_Portugol
    public final void synpred4_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:3: ( '-' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:761:4: '-'
        {
        match(input,71,FOLLOW_71_in_synpred4_Portugol2651); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Portugol

    // $ANTLR start synpred5_Portugol
    public final void synpred5_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:848:3: ( '(' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:848:4: '('
        {
        match(input,52,FOLLOW_52_in_synpred5_Portugol2867); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Portugol

    // $ANTLR start synpred6_Portugol
    public final void synpred6_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:849:3: ( '[' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:849:4: '['
        {
        match(input,49,FOLLOW_49_in_synpred6_Portugol2884); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Portugol

    // $ANTLR start synpred7_Portugol
    public final void synpred7_Portugol_fragment() throws RecognitionException {   
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:3: ( '{' '{' )
        // /home/fillipi/Documentos/Projetos/Portugol-Nucleo/gramatica/Portugol.g:898:4: '{' '{'
        {
        match(input,46,FOLLOW_46_in_synpred7_Portugol3057); if (state.failed) return ;
        match(input,46,FOLLOW_46_in_synpred7_Portugol3059); if (state.failed) return ;

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


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA18_eotS =
        "\12\uffff";
    static final String DFA18_eofS =
        "\12\uffff";
    static final String DFA18_minS =
        "\1\15\11\uffff";
    static final String DFA18_maxS =
        "\1\113\11\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA18_specialS =
        "\12\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\10\3\uffff\1\11\1\uffff\1\4\1\2\1\3\1\7\1\6\1\5\6\uffff\2"+
            "\1\1\uffff\1\1\1\uffff\4\1\6\uffff\1\1\5\uffff\1\1\22\uffff"+
            "\1\1\3\uffff\1\1",
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

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "461:1: (vExpressao= expressao | vPara= para | vPare= pare | vRetorne= retorne | vSe= se | vEnquanto= enquanto | vFacaEnquanto= facaEnquanto | vEscolha= escolha | vPercorra= percorra )";
        }
    }
    static final String DFA23_eotS =
        "\25\uffff";
    static final String DFA23_eofS =
        "\25\uffff";
    static final String DFA23_minS =
        "\1\15\1\0\23\uffff";
    static final String DFA23_maxS =
        "\1\113\1\0\23\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\21\uffff\1\1";
    static final String DFA23_specialS =
        "\1\uffff\1\0\23\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\2\3\uffff\1\2\1\uffff\6\2\6\uffff\2\2\1\uffff\1\2\1\uffff"+
            "\4\2\6\uffff\1\1\5\uffff\1\2\22\uffff\1\2\3\uffff\1\2",
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

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "509:1: ( ( '{' )=> '{' vListaBlocos= blocos '}' | vBloco= bloco )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Portugol()) ) {s = 20;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA26_eotS =
        "\35\uffff";
    static final String DFA26_eofS =
        "\35\uffff";
    static final String DFA26_minS =
        "\1\7\1\0\33\uffff";
    static final String DFA26_maxS =
        "\1\113\1\0\33\uffff";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\31\uffff\1\1";
    static final String DFA26_specialS =
        "\1\uffff\1\0\33\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\1\uffff\6\2\1\uffff\2\2\1\uffff\6\2\6\uffff\2\2\1\uffff"+
            "\1\2\1\uffff\4\2\6\uffff\1\1\1\2\4\uffff\1\2\22\uffff\1\2\3"+
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

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "563:2: ( ( '{' )=> ( '{' vBlocos= blocos '}' ) | (vBlocos= blocos ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Portugol()) ) {s = 28;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\63\uffff";
    static final String DFA36_eofS =
        "\63\uffff";
    static final String DFA36_minS =
        "\1\7\31\uffff\1\0\30\uffff";
    static final String DFA36_maxS =
        "\1\113\31\uffff\1\0\30\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\3\57\uffff\1\1\1\2";
    static final String DFA36_specialS =
        "\32\uffff\1\0\30\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\uffff\6\1\1\uffff\12\1\5\uffff\2\1\1\uffff\1\1\1\uffff"+
            "\4\1\6\uffff\3\1\1\uffff\4\1\1\uffff\17\1\1\61\1\32\3\uffff"+
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
            return "()* loopback of 711:2: ( (operador= '+' operandoDireito= expressao6 ) | ( '-' )=>operador= '-' operandoDireito= expressao6 )*";
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
                        if ( (synpred3_Portugol()) ) {s = 50;}

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
        "\14\uffff";
    static final String DFA41_eofS =
        "\14\uffff";
    static final String DFA41_minS =
        "\1\37\1\uffff\11\0\1\uffff";
    static final String DFA41_maxS =
        "\1\113\1\uffff\11\0\1\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\1\11\uffff\1\2";
    static final String DFA41_specialS =
        "\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\4\1\6\1\uffff\1\3\1\uffff\1\5\1\7\1\11\1\10\6\uffff\1\12"+
            "\5\uffff\1\2\22\uffff\1\1\3\uffff\1\13",
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
            return "761:2: ( ( '-' )=> (listaTokenMenos+= '-' )? | (listaTokenNao+= 'nao' )* )";
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
                        if ( (LA41_0==71) && (synpred4_Portugol())) {s = 1;}

                        else if ( (LA41_0==52) ) {s = 2;}

                        else if ( (LA41_0==CONST_REAL) ) {s = 3;}

                        else if ( (LA41_0==CONST_LOGICO) ) {s = 4;}

                        else if ( (LA41_0==CONST_CADEIA) ) {s = 5;}

                        else if ( (LA41_0==CONST_INTEIRO) ) {s = 6;}

                        else if ( (LA41_0==CONST_CARACTER) ) {s = 7;}

                        else if ( (LA41_0==APELIDO) ) {s = 8;}

                        else if ( (LA41_0==ID) ) {s = 9;}

                        else if ( (LA41_0==46) ) {s = 10;}

                        else if ( (LA41_0==75) ) {s = 11;}

                         
                        input.seek(index41_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA41_9 = input.LA(1);

                         
                        int index41_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA41_10 = input.LA(1);

                         
                        int index41_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Portugol()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index41_10);
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
    static final String DFA46_eotS =
        "\71\uffff";
    static final String DFA46_eofS =
        "\71\uffff";
    static final String DFA46_minS =
        "\1\7\1\0\67\uffff";
    static final String DFA46_maxS =
        "\1\115\1\0\67\uffff";
    static final String DFA46_acceptS =
        "\2\uffff\1\2\1\3\64\uffff\1\1";
    static final String DFA46_specialS =
        "\1\0\1\1\67\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\3\1\uffff\6\3\1\uffff\12\3\5\uffff\2\3\1\uffff\1\3\1\uffff"+
            "\4\3\6\uffff\3\3\1\2\2\3\1\1\1\3\1\uffff\27\3",
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
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "847:2: ( ( '(' )=>vExpressao= chamadaFuncao[$APELIDO.text, $ID.text] | ( '[' )=>vExpressao= referenciaVetorMatriz[$APELIDO.text, $ID.text] | vExpressao= referenciaId[$APELIDO.text, $ID.text] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_0 = input.LA(1);

                         
                        int index46_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_0==52) ) {s = 1;}

                        else if ( (LA46_0==49) && (synpred6_Portugol())) {s = 2;}

                        else if ( (LA46_0==REAL||(LA46_0>=LOGICO && LA46_0<=CASO)||(LA46_0>=CONST && LA46_0<=SENAO)||(LA46_0>=CONST_LOGICO && LA46_0<=CONST_INTEIRO)||LA46_0==CONST_REAL||(LA46_0>=CONST_CADEIA && LA46_0<=APELIDO)||(LA46_0>=46 && LA46_0<=48)||(LA46_0>=50 && LA46_0<=51)||LA46_0==53||(LA46_0>=55 && LA46_0<=77)) ) {s = 3;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Portugol()) ) {s = 56;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_PROGRAMA_in_parse961 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_BIBLIOTECA_in_parse969 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse973 = new BitSet(new long[]{0x0000800000051E80L});
    public static final BitSet FOLLOW_declaracoesGlobais_in_parse985 = new BitSet(new long[]{0x0000800000051E80L});
    public static final BitSet FOLLOW_declaracaoFuncao_in_parse990 = new BitSet(new long[]{0x0000800000051E80L});
    public static final BitSet FOLLOW_47_in_parse996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesGlobais1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_declaracoesLocais1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_listaDeclaracoes1065 = new BitSet(new long[]{0x0000000000011E80L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_listaDeclaracoes1073 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1087 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_listaDeclaracoes1095 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_declaracao_in_listaDeclaracoes1101 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ID_in_declaracao1127 = new BitSet(new long[]{0x000A000000000002L});
    public static final BitSet FOLLOW_49_in_declaracao1134 = new BitSet(new long[]{0x001440F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_declaracao1141 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_declaracao1145 = new BitSet(new long[]{0x000A000000000002L});
    public static final BitSet FOLLOW_49_in_declaracao1152 = new BitSet(new long[]{0x001440F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_declaracao1159 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_declaracao1163 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_declaracao1170 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_declaracao1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEIRO_in_declaracaoTipoDado1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_declaracaoTipoDado1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTER_in_declaracaoTipoDado1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CADEIA_in_declaracaoTipoDado1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICO_in_declaracaoTipoDado1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAZIO_in_declaracaoTipoDadoVazio1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_quantificador1274 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_quantificador1276 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_quantificador1283 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_quantificador1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_tipoRetornoFuncao1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDadoVazio_in_tipoRetornoFuncao1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCAO_in_declaracaoFuncao1338 = new BitSet(new long[]{0x0002004000011F80L});
    public static final BitSet FOLLOW_tipoRetornoFuncao_in_declaracaoFuncao1348 = new BitSet(new long[]{0x0002004000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoFuncao1357 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoFuncao1364 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_declaracaoFuncao1366 = new BitSet(new long[]{0x0020000000011E80L});
    public static final BitSet FOLLOW_listaParametrosFuncao_in_declaracaoFuncao1372 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_declaracaoFuncao1374 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_declaracaoFuncao1394 = new BitSet(new long[]{0x0010C0F581FB3E80L,0x0000000000000880L});
    public static final BitSet FOLLOW_blocos_in_declaracaoFuncao1402 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaracaoFuncao1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1460 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_listaParametrosFuncao1468 = new BitSet(new long[]{0x0000000000011E80L});
    public static final BitSet FOLLOW_declaracaoParametro_in_listaParametrosFuncao1474 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_declaracaoTipoDado_in_declaracaoParametro1499 = new BitSet(new long[]{0x0040004000000000L});
    public static final BitSet FOLLOW_54_in_declaracaoParametro1506 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_declaracaoParametro1510 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_quantificador_in_declaracaoParametro1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_blocos1540 = new BitSet(new long[]{0x001040F581FB3E82L,0x0000000000000880L});
    public static final BitSet FOLLOW_declaracoesLocais_in_blocos1546 = new BitSet(new long[]{0x001040F581FB3E82L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_bloco1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_para_in_bloco1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pare_in_bloco1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorne_in_bloco1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_se_in_bloco1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enquanto_in_bloco1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facaEnquanto_in_bloco1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escolha_in_bloco1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_percorra_in_bloco1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCORRA_in_percorra1711 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_percorra1713 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_percorra1719 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_percorra1721 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_percorra1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARA_in_para1746 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_para1748 = new BitSet(new long[]{0x009040F580011E80L,0x0000000000000880L});
    public static final BitSet FOLLOW_inicializacaoPara_in_para1755 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_para1759 = new BitSet(new long[]{0x009040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_para1766 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_para1770 = new BitSet(new long[]{0x003040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_para1777 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_para1781 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_para1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_inicializacaoPara1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaDeclaracoes_in_inicializacaoPara1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_listaBlocos1840 = new BitSet(new long[]{0x0010C0F581FB3E80L,0x0000000000000880L});
    public static final BitSet FOLLOW_blocos_in_listaBlocos1846 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_listaBlocos1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_listaBlocos1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARE_in_pare1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCOLHA_in_escolha1902 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_escolha1904 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_escolha1910 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_escolha1912 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_escolha1915 = new BitSet(new long[]{0x0000800000004000L});
    public static final BitSet FOLLOW_listaCasos_in_escolha1924 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_escolha1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASO_in_listaCasos1948 = new BitSet(new long[]{0x001040F580008000L,0x0000000000000880L});
    public static final BitSet FOLLOW_CONTRARIO_in_listaCasos1951 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_expressao_in_listaCasos1959 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_listaCasos1962 = new BitSet(new long[]{0x001040F581FB3E80L,0x0000000000000880L});
    public static final BitSet FOLLOW_blocosCaso_in_listaCasos1968 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_46_in_blocosCaso1995 = new BitSet(new long[]{0x0010C0F581FB3E80L,0x0000000000000880L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2001 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_blocosCaso2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blocos_in_blocosCaso2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENQUANTO_in_enquanto2032 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_enquanto2034 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_enquanto2040 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_enquanto2042 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_enquanto2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACA_in_facaEnquanto2065 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_facaEnquanto2071 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ENQUANTO_in_facaEnquanto2073 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_facaEnquanto2075 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_facaEnquanto2081 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_facaEnquanto2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SE_in_se2101 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_se2103 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_se2109 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_se2111 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_se2117 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_SENAO_in_se2120 = new BitSet(new long[]{0x001040F581FA2000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaBlocos_in_se2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETORNE_in_retorne2147 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_retorne2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao2_in_expressao2186 = new BitSet(new long[]{0x3E08000000000000L});
    public static final BitSet FOLLOW_pilha_in_expressao2192 = new BitSet(new long[]{0x3E08000000000002L});
    public static final BitSet FOLLOW_51_in_expressao2206 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_57_in_expressao2214 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_58_in_expressao2222 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_59_in_expressao2230 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_60_in_expressao2238 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_61_in_expressao2246 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao2_in_expressao2258 = new BitSet(new long[]{0x3E08000000000002L});
    public static final BitSet FOLLOW_expressao3_in_expressao22288 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_expressao22317 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_63_in_expressao22325 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao3_in_expressao22337 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_expressao4_in_expressao32363 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_64_in_expressao32384 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_65_in_expressao32392 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao4_in_expressao32405 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expressao5_in_expressao42431 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_66_in_expressao42439 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_67_in_expressao42447 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_68_in_expressao42455 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_69_in_expressao42463 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao5_in_expressao42470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao6_in_expressao52494 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_70_in_expressao52518 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao6_in_expressao52524 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_71_in_expressao52538 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao6_in_expressao52544 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_expressao7_in_expressao62575 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000700L});
    public static final BitSet FOLLOW_72_in_expressao62598 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_73_in_expressao62606 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_74_in_expressao62614 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao7_in_expressao62627 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000700L});
    public static final BitSet FOLLOW_71_in_expressao72661 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_75_in_expressao72672 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao8_in_expressao72682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_expressao82703 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_expressao82709 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_expressao82711 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_tipoPrimitivo_in_expressao82719 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_referencia_in_expressao82727 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_matrizVetor_in_expressao82735 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_expressao82748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_expressao82756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_tipoPrimitivo2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_LOGICO_in_tipoPrimitivo2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_CADEIA_in_tipoPrimitivo2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INTEIRO_in_tipoPrimitivo2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_CARACTER_in_tipoPrimitivo2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_APELIDO_in_referencia2856 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_referencia2859 = new BitSet(new long[]{0x0012000000000000L});
    public static final BitSet FOLLOW_chamadaFuncao_in_referencia2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaVetorMatriz_in_referencia2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referenciaId_in_referencia2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_referenciaVetorMatriz2946 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz2952 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_referenciaVetorMatriz2954 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_referenciaVetorMatriz2957 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_referenciaVetorMatriz2963 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_referenciaVetorMatriz2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_chamadaFuncao2987 = new BitSet(new long[]{0x003040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaParametros_in_chamadaFuncao2994 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_chamadaFuncao2998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3025 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_listaParametros3032 = new BitSet(new long[]{0x001040F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_listaParametros3037 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_matriz_in_matrizVetor3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetor_in_matrizVetor3075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_vetor3094 = new BitSet(new long[]{0x0011C0F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaExpressoes_in_vetor3100 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_vetor3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_matriz3121 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_listaListaExpressoes_in_matriz3129 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_matriz3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_listaListaExpressoes3175 = new BitSet(new long[]{0x0011C0F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3181 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_listaListaExpressoes3183 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_listaListaExpressoes3193 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_listaListaExpressoes3195 = new BitSet(new long[]{0x0011C0F580000000L,0x0000000000000880L});
    public static final BitSet FOLLOW_listaExpressoes_in_listaListaExpressoes3201 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_listaListaExpressoes3203 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3234 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_listaExpressoes3245 = new BitSet(new long[]{0x001140F580000002L,0x0000000000000880L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes3252 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_46_in_synpred1_Portugol1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred2_Portugol1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred3_Portugol2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred4_Portugol2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred5_Portugol2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred6_Portugol2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred7_Portugol3057 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_synpred7_Portugol3059 = new BitSet(new long[]{0x0000000000000002L});

}