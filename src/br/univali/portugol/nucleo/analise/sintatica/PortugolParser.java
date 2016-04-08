// Generated from C:\Users\4276663\Desktop\Git\Portugol-Nucleo\src\br\u005Cunivali\portugol\nucleo\analise\sintatica\Portugol.g4 by ANTLR 4.1
package br.univali.portugol.nucleo.analise.sintatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PortugolParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__41=1, T__40=2, T__39=3, T__38=4, T__37=5, T__36=6, T__35=7, T__34=8, 
		T__33=9, T__32=10, T__31=11, T__30=12, T__29=13, T__28=14, T__27=15, T__26=16, 
		T__25=17, T__24=18, T__23=19, T__22=20, T__21=21, T__20=22, T__19=23, 
		T__18=24, T__17=25, T__16=26, T__15=27, T__14=28, T__13=29, T__12=30, 
		T__11=31, T__10=32, T__9=33, T__8=34, T__7=35, T__6=36, T__5=37, T__4=38, 
		T__3=39, T__2=40, T__1=41, T__0=42, PR_PROGRAMA=43, PR_REAL=44, PR_VAZIO=45, 
		PR_LOGICO=46, PR_CADEIA=47, PR_INTEIRO=48, PR_CARACTER=49, PR_ESCOLHA=50, 
		PR_CASO=51, PR_CONTRARIO=52, PR_CONST=53, PR_FUNCAO=54, PR_RETORNE=55, 
		PR_PARA=56, PR_PARE=57, PR_FACA=58, PR_ENQUANTO=59, PR_SE=60, PR_SENAO=61, 
		PR_INCLUA=62, PR_BIBLIOTECA=63, GAMBIARRA=64, OPERADOR_NAO=65, LOGICO=66, 
		ID=67, ID_BIBLIOTECA=68, INTEIRO=69, REAL=70, CADEIA=71, CARACTER=72, 
		ESPACO=73, COMENTARIO=74;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'*='", "'+='", "'&='", "'%='", "'!='", "'>>='", "';'", 
		"'{'", "'>>'", "'<<'", "'^='", "'='", "'}'", "'^'", "'<<='", "'<='", "'|='", 
		"'ou'", "'&'", "'('", "'*'", "'-='", "','", "'/='", "':'", "'>='", "'['", 
		"'--'", "'++'", "'|'", "'<'", "'=='", "']'", "'~'", "'>'", "'-->'", "'%'", 
		"'e'", "')'", "'+'", "'-'", "'programa'", "'real'", "'vazio'", "'logico'", 
		"'cadeia'", "'inteiro'", "'caracter'", "'escolha'", "'caso'", "'contrario'", 
		"'const'", "'funcao'", "'retorne'", "'para'", "'pare'", "'faca'", "'enquanto'", 
		"'se'", "'senao'", "'inclua'", "'biblioteca'", "GAMBIARRA", "'nao'", "LOGICO", 
		"ID", "ID_BIBLIOTECA", "INTEIRO", "REAL", "CADEIA", "CARACTER", "ESPACO", 
		"COMENTARIO"
	};
	public static final int
		RULE_programa = 0, RULE_inclusaoBiblioteca = 1, RULE_declaracoesGlobais = 2, 
		RULE_declaracoesLocais = 3, RULE_listaDeclaracoes = 4, RULE_declaracao = 5, 
		RULE_declaracaoTipoDado = 6, RULE_declaracaoTipoDadoVazio = 7, RULE_quantificador = 8, 
		RULE_tipoRetornoFuncao = 9, RULE_declaracaoFuncao = 10, RULE_listaParametrosFuncao = 11, 
		RULE_declaracaoParametro = 12, RULE_blocos = 13, RULE_bloco = 14, RULE_para = 15, 
		RULE_inicializacaoPara = 16, RULE_listaBlocos = 17, RULE_pare = 18, RULE_escolha = 19, 
		RULE_blocosCaso = 20, RULE_enquanto = 21, RULE_facaEnquanto = 22, RULE_se = 23, 
		RULE_retorne = 24, RULE_pilha = 25, RULE_expressao = 26, RULE_expressao2 = 27, 
		RULE_expressao2_5 = 28, RULE_expressao3 = 29, RULE_expressao3_5 = 30, 
		RULE_expressao4_5 = 31, RULE_expressao5 = 32, RULE_expressao6 = 33, RULE_expressao7 = 34, 
		RULE_expressao8 = 35, RULE_tipoPrimitivo = 36, RULE_referencia = 37, RULE_referenciaId = 38, 
		RULE_referenciaVetorMatriz = 39, RULE_chamadaFuncao = 40, RULE_listaParametros = 41, 
		RULE_matrizVetor = 42, RULE_vetor = 43, RULE_matriz = 44, RULE_listaListaExpressoes = 45, 
		RULE_listaExpressoes = 46;
	public static final String[] ruleNames = {
		"programa", "inclusaoBiblioteca", "declaracoesGlobais", "declaracoesLocais", 
		"listaDeclaracoes", "declaracao", "declaracaoTipoDado", "declaracaoTipoDadoVazio", 
		"quantificador", "tipoRetornoFuncao", "declaracaoFuncao", "listaParametrosFuncao", 
		"declaracaoParametro", "blocos", "bloco", "para", "inicializacaoPara", 
		"listaBlocos", "pare", "escolha", "blocosCaso", "enquanto", "facaEnquanto", 
		"se", "retorne", "pilha", "expressao", "expressao2", "expressao2_5", "expressao3", 
		"expressao3_5", "expressao4_5", "expressao5", "expressao6", "expressao7", 
		"expressao8", "tipoPrimitivo", "referencia", "referenciaId", "referenciaVetorMatriz", 
		"chamadaFuncao", "listaParametros", "matrizVetor", "vetor", "matriz", 
		"listaListaExpressoes", "listaExpressoes"
	};

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public PortugolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracaoFuncaoContext declaracaoFuncao(int i) {
			return getRuleContext(DeclaracaoFuncaoContext.class,i);
		}
		public DeclaracoesGlobaisContext declaracoesGlobais(int i) {
			return getRuleContext(DeclaracoesGlobaisContext.class,i);
		}
		public List<DeclaracaoFuncaoContext> declaracaoFuncao() {
			return getRuleContexts(DeclaracaoFuncaoContext.class);
		}
		public List<DeclaracoesGlobaisContext> declaracoesGlobais() {
			return getRuleContexts(DeclaracoesGlobaisContext.class);
		}
		public List<InclusaoBibliotecaContext> inclusaoBiblioteca() {
			return getRuleContexts(InclusaoBibliotecaContext.class);
		}
		public TerminalNode PR_PROGRAMA() { return getToken(PortugolParser.PR_PROGRAMA, 0); }
		public InclusaoBibliotecaContext inclusaoBiblioteca(int i) {
			return getRuleContext(InclusaoBibliotecaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(PR_PROGRAMA);
			setState(95); match(9);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PR_INCLUA) {
				{
				{
				setState(96); inclusaoBiblioteca();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER) | (1L << PR_CONST) | (1L << PR_FUNCAO))) != 0)) {
				{
				setState(104);
				switch (_input.LA(1)) {
				case PR_REAL:
				case PR_LOGICO:
				case PR_CADEIA:
				case PR_INTEIRO:
				case PR_CARACTER:
				case PR_CONST:
					{
					setState(102); declaracoesGlobais();
					}
					break;
				case PR_FUNCAO:
					{
					setState(103); declaracaoFuncao();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InclusaoBibliotecaContext extends ParserRuleContext {
		public Token nome;
		public Token alias;
		public List<TerminalNode> ID() { return getTokens(PortugolParser.ID); }
		public TerminalNode PR_BIBLIOTECA() { return getToken(PortugolParser.PR_BIBLIOTECA, 0); }
		public TerminalNode PR_INCLUA() { return getToken(PortugolParser.PR_INCLUA, 0); }
		public TerminalNode ID(int i) {
			return getToken(PortugolParser.ID, i);
		}
		public InclusaoBibliotecaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusaoBiblioteca; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitInclusaoBiblioteca(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusaoBibliotecaContext inclusaoBiblioteca() throws RecognitionException {
		InclusaoBibliotecaContext _localctx = new InclusaoBibliotecaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inclusaoBiblioteca);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(PR_INCLUA);
			setState(112); match(PR_BIBLIOTECA);
			setState(113); ((InclusaoBibliotecaContext)_localctx).nome = match(ID);
			setState(116);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(114); match(37);
				setState(115); ((InclusaoBibliotecaContext)_localctx).alias = match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesGlobaisContext extends ParserRuleContext {
		public ListaDeclaracoesContext vListaDeclaracoes;
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public DeclaracoesGlobaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoesGlobais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracoesGlobais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesGlobaisContext declaracoesGlobais() throws RecognitionException {
		DeclaracoesGlobaisContext _localctx = new DeclaracoesGlobaisContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoesGlobais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); ((DeclaracoesGlobaisContext)_localctx).vListaDeclaracoes = listaDeclaracoes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesLocaisContext extends ParserRuleContext {
		public ListaDeclaracoesContext vListaDeclaracoes;
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public DeclaracoesLocaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoesLocais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracoesLocais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesLocaisContext declaracoesLocais() throws RecognitionException {
		DeclaracoesLocaisContext _localctx = new DeclaracoesLocaisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracoesLocais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); ((DeclaracoesLocaisContext)_localctx).vListaDeclaracoes = listaDeclaracoes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public Token tokenConst;
		public DeclaracaoTipoDadoContext informacaoTipoDado;
		public DeclaracaoContext vDeclaracao;
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracaoTipoDadoContext declaracaoTipoDado() {
			return getRuleContext(DeclaracaoTipoDadoContext.class,0);
		}
		public TerminalNode PR_CONST() { return getToken(PortugolParser.PR_CONST, 0); }
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listaDeclaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(123);
			_la = _input.LA(1);
			if (_la==PR_CONST) {
				{
				setState(122); ((ListaDeclaracoesContext)_localctx).tokenConst = match(PR_CONST);
				}
			}

			setState(125); ((ListaDeclaracoesContext)_localctx).informacaoTipoDado = declaracaoTipoDado();
			{
			setState(126); ((ListaDeclaracoesContext)_localctx).vDeclaracao = declaracao();
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(127); match(24);
				setState(128); ((ListaDeclaracoesContext)_localctx).vDeclaracao = declaracao();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public Token tk1;
		public ExpressaoContext ind1;
		public Token tk2;
		public ExpressaoContext ind2;
		public ExpressaoContext inicializacao;
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(134); match(ID);
			setState(147);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(135); ((DeclaracaoContext)_localctx).tk1 = match(28);
				setState(137);
				_la = _input.LA(1);
				if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
					{
					setState(136); ((DeclaracaoContext)_localctx).ind1 = expressao();
					}
				}

				setState(139); match(34);
				setState(145);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(140); ((DeclaracaoContext)_localctx).tk2 = match(28);
					setState(142);
					_la = _input.LA(1);
					if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
						{
						setState(141); ((DeclaracaoContext)_localctx).ind2 = expressao();
						}
					}

					setState(144); match(34);
					}
				}

				}
			}

			setState(151);
			_la = _input.LA(1);
			if (_la==13) {
				{
				setState(149); match(13);
				setState(150); ((DeclaracaoContext)_localctx).inicializacao = expressao();
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoTipoDadoContext extends ParserRuleContext {
		public Token tokenTipoDado;
		public TerminalNode PR_REAL() { return getToken(PortugolParser.PR_REAL, 0); }
		public TerminalNode PR_INTEIRO() { return getToken(PortugolParser.PR_INTEIRO, 0); }
		public TerminalNode PR_LOGICO() { return getToken(PortugolParser.PR_LOGICO, 0); }
		public TerminalNode PR_CARACTER() { return getToken(PortugolParser.PR_CARACTER, 0); }
		public TerminalNode PR_CADEIA() { return getToken(PortugolParser.PR_CADEIA, 0); }
		public DeclaracaoTipoDadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoTipoDado; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracaoTipoDado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoTipoDadoContext declaracaoTipoDado() throws RecognitionException {
		DeclaracaoTipoDadoContext _localctx = new DeclaracaoTipoDadoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracaoTipoDado);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			switch (_input.LA(1)) {
			case PR_INTEIRO:
				{
				setState(153); ((DeclaracaoTipoDadoContext)_localctx).tokenTipoDado = match(PR_INTEIRO);
				}
				break;
			case PR_REAL:
				{
				setState(154); ((DeclaracaoTipoDadoContext)_localctx).tokenTipoDado = match(PR_REAL);
				}
				break;
			case PR_CARACTER:
				{
				setState(155); ((DeclaracaoTipoDadoContext)_localctx).tokenTipoDado = match(PR_CARACTER);
				}
				break;
			case PR_CADEIA:
				{
				setState(156); ((DeclaracaoTipoDadoContext)_localctx).tokenTipoDado = match(PR_CADEIA);
				}
				break;
			case PR_LOGICO:
				{
				setState(157); ((DeclaracaoTipoDadoContext)_localctx).tokenTipoDado = match(PR_LOGICO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoTipoDadoVazioContext extends ParserRuleContext {
		public TerminalNode PR_VAZIO() { return getToken(PortugolParser.PR_VAZIO, 0); }
		public DeclaracaoTipoDadoVazioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoTipoDadoVazio; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracaoTipoDadoVazio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoTipoDadoVazioContext declaracaoTipoDadoVazio() throws RecognitionException {
		DeclaracaoTipoDadoVazioContext _localctx = new DeclaracaoTipoDadoVazioContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracaoTipoDadoVazio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(PR_VAZIO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantificadorContext extends ParserRuleContext {
		public Token tk1;
		public Token tk2;
		public QuantificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantificador; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitQuantificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantificadorContext quantificador() throws RecognitionException {
		QuantificadorContext _localctx = new QuantificadorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_quantificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(162); ((QuantificadorContext)_localctx).tk1 = match(28);
				setState(163); match(34);
				setState(166);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(164); ((QuantificadorContext)_localctx).tk2 = match(28);
					setState(165); match(34);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoRetornoFuncaoContext extends ParserRuleContext {
		public DeclaracaoTipoDadoContext informacao;
		public DeclaracaoTipoDadoContext declaracaoTipoDado() {
			return getRuleContext(DeclaracaoTipoDadoContext.class,0);
		}
		public DeclaracaoTipoDadoVazioContext declaracaoTipoDadoVazio() {
			return getRuleContext(DeclaracaoTipoDadoVazioContext.class,0);
		}
		public TipoRetornoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoRetornoFuncao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitTipoRetornoFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoRetornoFuncaoContext tipoRetornoFuncao() throws RecognitionException {
		TipoRetornoFuncaoContext _localctx = new TipoRetornoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipoRetornoFuncao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			switch (_input.LA(1)) {
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
				{
				setState(170); ((TipoRetornoFuncaoContext)_localctx).informacao = declaracaoTipoDado();
				}
				break;
			case PR_VAZIO:
				{
				setState(171); ((TipoRetornoFuncaoContext)_localctx).informacao = declaracaoTipoDadoVazio();
				}
				break;
			case 28:
			case ID:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoFuncaoContext extends ParserRuleContext {
		public TipoRetornoFuncaoContext informacaoTipoDado;
		public QuantificadorContext vQuantificador;
		public ListaParametrosFuncaoContext vListaParametros;
		public BlocosContext vBlocos;
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public QuantificadorContext quantificador() {
			return getRuleContext(QuantificadorContext.class,0);
		}
		public ListaParametrosFuncaoContext listaParametrosFuncao() {
			return getRuleContext(ListaParametrosFuncaoContext.class,0);
		}
		public BlocosContext blocos() {
			return getRuleContext(BlocosContext.class,0);
		}
		public TerminalNode PR_FUNCAO() { return getToken(PortugolParser.PR_FUNCAO, 0); }
		public TipoRetornoFuncaoContext tipoRetornoFuncao() {
			return getRuleContext(TipoRetornoFuncaoContext.class,0);
		}
		public DeclaracaoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFuncao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracaoFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoFuncaoContext declaracaoFuncao() throws RecognitionException {
		DeclaracaoFuncaoContext _localctx = new DeclaracaoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaracaoFuncao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(PR_FUNCAO);
			setState(175); ((DeclaracaoFuncaoContext)_localctx).informacaoTipoDado = tipoRetornoFuncao();
			setState(176); ((DeclaracaoFuncaoContext)_localctx).vQuantificador = quantificador();
			setState(177); match(ID);
			setState(178); match(21);
			setState(179); ((DeclaracaoFuncaoContext)_localctx).vListaParametros = listaParametrosFuncao();
			setState(180); match(40);
			setState(181); match(9);
			setState(182); ((DeclaracaoFuncaoContext)_localctx).vBlocos = blocos();
			setState(183); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaParametrosFuncaoContext extends ParserRuleContext {
		public DeclaracaoParametroContext vDeclaracaoParametro;
		public DeclaracaoParametroContext declaracaoParametro(int i) {
			return getRuleContext(DeclaracaoParametroContext.class,i);
		}
		public List<DeclaracaoParametroContext> declaracaoParametro() {
			return getRuleContexts(DeclaracaoParametroContext.class);
		}
		public ListaParametrosFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametrosFuncao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaParametrosFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaParametrosFuncaoContext listaParametrosFuncao() throws RecognitionException {
		ListaParametrosFuncaoContext _localctx = new ListaParametrosFuncaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaParametrosFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER))) != 0)) {
				{
				{
				setState(185); ((ListaParametrosFuncaoContext)_localctx).vDeclaracaoParametro = declaracaoParametro();
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(186); match(24);
					setState(187); ((ListaParametrosFuncaoContext)_localctx).vDeclaracaoParametro = declaracaoParametro();
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoParametroContext extends ParserRuleContext {
		public DeclaracaoTipoDadoContext informacaoTipoDado;
		public Token tkr;
		public QuantificadorContext vQuantificador;
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public QuantificadorContext quantificador() {
			return getRuleContext(QuantificadorContext.class,0);
		}
		public DeclaracaoTipoDadoContext declaracaoTipoDado() {
			return getRuleContext(DeclaracaoTipoDadoContext.class,0);
		}
		public DeclaracaoParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoParametro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitDeclaracaoParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoParametroContext declaracaoParametro() throws RecognitionException {
		DeclaracaoParametroContext _localctx = new DeclaracaoParametroContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracaoParametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); ((DeclaracaoParametroContext)_localctx).informacaoTipoDado = declaracaoTipoDado();
			setState(197);
			_la = _input.LA(1);
			if (_la==20) {
				{
				setState(196); ((DeclaracaoParametroContext)_localctx).tkr = match(20);
				}
			}

			setState(199); match(ID);
			setState(200); ((DeclaracaoParametroContext)_localctx).vQuantificador = quantificador();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocosContext extends ParserRuleContext {
		public BlocoContext vBloco;
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public List<DeclaracoesLocaisContext> declaracoesLocais() {
			return getRuleContexts(DeclaracoesLocaisContext.class);
		}
		public DeclaracoesLocaisContext declaracoesLocais(int i) {
			return getRuleContext(DeclaracoesLocaisContext.class,i);
		}
		public BlocosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitBlocos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocosContext blocos() throws RecognitionException {
		BlocosContext _localctx = new BlocosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blocos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (PR_REAL - 9)) | (1L << (PR_LOGICO - 9)) | (1L << (PR_CADEIA - 9)) | (1L << (PR_INTEIRO - 9)) | (1L << (PR_CARACTER - 9)) | (1L << (PR_ESCOLHA - 9)) | (1L << (PR_CONST - 9)) | (1L << (PR_RETORNE - 9)) | (1L << (PR_PARA - 9)) | (1L << (PR_PARE - 9)) | (1L << (PR_FACA - 9)) | (1L << (PR_ENQUANTO - 9)) | (1L << (PR_SE - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(204);
				switch (_input.LA(1)) {
				case 9:
				case 21:
				case 35:
				case 42:
				case PR_ESCOLHA:
				case PR_RETORNE:
				case PR_PARA:
				case PR_PARE:
				case PR_FACA:
				case PR_ENQUANTO:
				case PR_SE:
				case OPERADOR_NAO:
				case LOGICO:
				case ID:
				case ID_BIBLIOTECA:
				case INTEIRO:
				case REAL:
				case CADEIA:
				case CARACTER:
					{
					setState(202); ((BlocosContext)_localctx).vBloco = bloco();
					}
					break;
				case PR_REAL:
				case PR_LOGICO:
				case PR_CADEIA:
				case PR_INTEIRO:
				case PR_CARACTER:
				case PR_CONST:
					{
					setState(203); declaracoesLocais();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public ParaContext vPara;
		public PareContext vPare;
		public RetorneContext vRetorne;
		public SeContext vSe;
		public EnquantoContext vEnquanto;
		public FacaEnquantoContext vFacaEnquanto;
		public EscolhaContext vEscolha;
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public PareContext pare() {
			return getRuleContext(PareContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public FacaEnquantoContext facaEnquanto() {
			return getRuleContext(FacaEnquantoContext.class,0);
		}
		public SeContext se() {
			return getRuleContext(SeContext.class,0);
		}
		public EscolhaContext escolha() {
			return getRuleContext(EscolhaContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public RetorneContext retorne() {
			return getRuleContext(RetorneContext.class,0);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bloco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			switch (_input.LA(1)) {
			case 9:
			case 21:
			case 35:
			case 42:
			case OPERADOR_NAO:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(209); ((BlocoContext)_localctx).vExpressao = expressao();
				}
				break;
			case PR_PARA:
				{
				setState(210); ((BlocoContext)_localctx).vPara = para();
				}
				break;
			case PR_PARE:
				{
				setState(211); ((BlocoContext)_localctx).vPare = pare();
				}
				break;
			case PR_RETORNE:
				{
				setState(212); ((BlocoContext)_localctx).vRetorne = retorne();
				}
				break;
			case PR_SE:
				{
				setState(213); ((BlocoContext)_localctx).vSe = se();
				}
				break;
			case PR_ENQUANTO:
				{
				setState(214); ((BlocoContext)_localctx).vEnquanto = enquanto();
				}
				break;
			case PR_FACA:
				{
				setState(215); ((BlocoContext)_localctx).vFacaEnquanto = facaEnquanto();
				}
				break;
			case PR_ESCOLHA:
				{
				setState(216); ((BlocoContext)_localctx).vEscolha = escolha();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParaContext extends ParserRuleContext {
		public InicializacaoParaContext inicializacao;
		public ExpressaoContext condicao;
		public ExpressaoContext incremento;
		public Token fp;
		public ListaBlocosContext vBlocos;
		public InicializacaoParaContext inicializacaoPara() {
			return getRuleContext(InicializacaoParaContext.class,0);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public TerminalNode PR_PARA() { return getToken(PortugolParser.PR_PARA, 0); }
		public ListaBlocosContext listaBlocos() {
			return getRuleContext(ListaBlocosContext.class,0);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(PR_PARA);
			setState(220); match(21);
			setState(222);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (PR_REAL - 9)) | (1L << (PR_LOGICO - 9)) | (1L << (PR_CADEIA - 9)) | (1L << (PR_INTEIRO - 9)) | (1L << (PR_CARACTER - 9)) | (1L << (PR_CONST - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(221); ((ParaContext)_localctx).inicializacao = inicializacaoPara();
				}
			}

			setState(224); match(8);
			setState(226);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(225); ((ParaContext)_localctx).condicao = expressao();
				}
			}

			setState(228); match(8);
			setState(230);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(229); ((ParaContext)_localctx).incremento = expressao();
				}
			}

			setState(232); ((ParaContext)_localctx).fp = match(40);
			setState(233); ((ParaContext)_localctx).vBlocos = listaBlocos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InicializacaoParaContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public ListaDeclaracoesContext vListaDeclaracoes;
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public InicializacaoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacaoPara; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitInicializacaoPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializacaoParaContext inicializacaoPara() throws RecognitionException {
		InicializacaoParaContext _localctx = new InicializacaoParaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_inicializacaoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			switch (_input.LA(1)) {
			case 9:
			case 21:
			case 35:
			case 42:
			case OPERADOR_NAO:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(235); ((InicializacaoParaContext)_localctx).vExpressao = expressao();
				}
				break;
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
			case PR_CONST:
				{
				setState(236); ((InicializacaoParaContext)_localctx).vListaDeclaracoes = listaDeclaracoes();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaBlocosContext extends ParserRuleContext {
		public BlocosContext vListaBlocos;
		public BlocoContext vBloco;
		public BlocosContext blocos() {
			return getRuleContext(BlocosContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ListaBlocosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaBlocos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaBlocos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaBlocosContext listaBlocos() throws RecognitionException {
		ListaBlocosContext _localctx = new ListaBlocosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listaBlocos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(239); match(9);
				setState(240); ((ListaBlocosContext)_localctx).vListaBlocos = blocos();
				setState(241); match(14);
				}
				break;

			case 2:
				{
				setState(243); ((ListaBlocosContext)_localctx).vBloco = bloco();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PareContext extends ParserRuleContext {
		public TerminalNode PR_PARE() { return getToken(PortugolParser.PR_PARE, 0); }
		public PareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitPare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PareContext pare() throws RecognitionException {
		PareContext _localctx = new PareContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(PR_PARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscolhaContext extends ParserRuleContext {
		public ExpressaoContext vExpressaoEscolha;
		public ExpressaoContext vExpressao;
		public BlocosCasoContext vBlocos;
		public List<BlocosCasoContext> blocosCaso() {
			return getRuleContexts(BlocosCasoContext.class);
		}
		public TerminalNode PR_CASO(int i) {
			return getToken(PortugolParser.PR_CASO, i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public BlocosCasoContext blocosCaso(int i) {
			return getRuleContext(BlocosCasoContext.class,i);
		}
		public List<TerminalNode> PR_CASO() { return getTokens(PortugolParser.PR_CASO); }
		public TerminalNode PR_CONTRARIO() { return getToken(PortugolParser.PR_CONTRARIO, 0); }
		public TerminalNode PR_ESCOLHA() { return getToken(PortugolParser.PR_ESCOLHA, 0); }
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public EscolhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escolha; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitEscolha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscolhaContext escolha() throws RecognitionException {
		EscolhaContext _localctx = new EscolhaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_escolha);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248); match(PR_ESCOLHA);
			setState(249); match(21);
			setState(250); ((EscolhaContext)_localctx).vExpressaoEscolha = expressao();
			setState(251); match(40);
			setState(252); match(9);
			setState(258); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(253); match(PR_CASO);
					setState(254); ((EscolhaContext)_localctx).vExpressao = expressao();
					setState(255); match(26);
					setState(256); ((EscolhaContext)_localctx).vBlocos = blocosCaso();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(266);
			_la = _input.LA(1);
			if (_la==PR_CASO) {
				{
				setState(262); match(PR_CASO);
				setState(263); match(PR_CONTRARIO);
				setState(264); match(26);
				setState(265); ((EscolhaContext)_localctx).vBlocos = blocosCaso();
				}
			}

			setState(268); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocosCasoContext extends ParserRuleContext {
		public BlocosContext vBlocos;
		public BlocosContext blocos() {
			return getRuleContext(BlocosContext.class,0);
		}
		public BlocosCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocosCaso; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitBlocosCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocosCasoContext blocosCaso() throws RecognitionException {
		BlocosCasoContext _localctx = new BlocosCasoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_blocosCaso);
		try {
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(270); match(9);
				setState(271); ((BlocosCasoContext)_localctx).vBlocos = blocos();
				setState(272); match(14);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(274); ((BlocosCasoContext)_localctx).vBlocos = blocos();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnquantoContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public ListaBlocosContext vListaBlocos;
		public TerminalNode PR_ENQUANTO() { return getToken(PortugolParser.PR_ENQUANTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ListaBlocosContext listaBlocos() {
			return getRuleContext(ListaBlocosContext.class,0);
		}
		public EnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquanto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_enquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(PR_ENQUANTO);
			setState(278); match(21);
			setState(279); ((EnquantoContext)_localctx).vExpressao = expressao();
			setState(280); match(40);
			setState(281); ((EnquantoContext)_localctx).vListaBlocos = listaBlocos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FacaEnquantoContext extends ParserRuleContext {
		public ListaBlocosContext vListaBlocos;
		public ExpressaoContext vExpressao;
		public TerminalNode PR_ENQUANTO() { return getToken(PortugolParser.PR_ENQUANTO, 0); }
		public TerminalNode PR_FACA() { return getToken(PortugolParser.PR_FACA, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ListaBlocosContext listaBlocos() {
			return getRuleContext(ListaBlocosContext.class,0);
		}
		public FacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facaEnquanto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitFacaEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FacaEnquantoContext facaEnquanto() throws RecognitionException {
		FacaEnquantoContext _localctx = new FacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_facaEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(PR_FACA);
			setState(284); ((FacaEnquantoContext)_localctx).vListaBlocos = listaBlocos();
			setState(285); match(PR_ENQUANTO);
			setState(286); match(21);
			setState(287); ((FacaEnquantoContext)_localctx).vExpressao = expressao();
			setState(288); match(40);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public ListaBlocosContext vListaBlocos;
		public ListaBlocosContext listaBlocosSenao;
		public TerminalNode PR_SE() { return getToken(PortugolParser.PR_SE, 0); }
		public ListaBlocosContext listaBlocos(int i) {
			return getRuleContext(ListaBlocosContext.class,i);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PR_SENAO() { return getToken(PortugolParser.PR_SENAO, 0); }
		public List<ListaBlocosContext> listaBlocos() {
			return getRuleContexts(ListaBlocosContext.class);
		}
		public SeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_se; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeContext se() throws RecognitionException {
		SeContext _localctx = new SeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_se);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(PR_SE);
			setState(291); match(21);
			setState(292); ((SeContext)_localctx).vExpressao = expressao();
			setState(293); match(40);
			setState(294); ((SeContext)_localctx).vListaBlocos = listaBlocos();
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(295); match(PR_SENAO);
				setState(296); ((SeContext)_localctx).listaBlocosSenao = listaBlocos();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetorneContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PR_RETORNE() { return getToken(PortugolParser.PR_RETORNE, 0); }
		public RetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorne; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitRetorne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetorneContext retorne() throws RecognitionException {
		RetorneContext _localctx = new RetorneContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_retorne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); match(PR_RETORNE);
			setState(301);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(300); ((RetorneContext)_localctx).vExpressao = expressao();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PilhaContext extends ParserRuleContext {
		public PilhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pilha; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitPilha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PilhaContext pilha() throws RecognitionException {
		PilhaContext _localctx = new PilhaContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pilha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public Expressao2Context operandoEsquerdo;
		public PilhaContext vPilha;
		public Token operador;
		public Expressao2Context operandoDireito;
		public List<Expressao2Context> expressao2() {
			return getRuleContexts(Expressao2Context.class);
		}
		public PilhaContext pilha() {
			return getRuleContext(PilhaContext.class,0);
		}
		public Expressao2Context expressao2(int i) {
			return getRuleContext(Expressao2Context.class,i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); ((ExpressaoContext)_localctx).operandoEsquerdo = expressao2();
			setState(306); ((ExpressaoContext)_localctx).vPilha = pilha();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 7) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 18) | (1L << 23) | (1L << 25))) != 0)) {
				{
				{
				setState(318);
				switch (_input.LA(1)) {
				case 13:
					{
					setState(307); ((ExpressaoContext)_localctx).operador = match(13);
					}
					break;
				case 3:
					{
					setState(308); ((ExpressaoContext)_localctx).operador = match(3);
					}
					break;
				case 23:
					{
					setState(309); ((ExpressaoContext)_localctx).operador = match(23);
					}
					break;
				case 25:
					{
					setState(310); ((ExpressaoContext)_localctx).operador = match(25);
					}
					break;
				case 2:
					{
					setState(311); ((ExpressaoContext)_localctx).operador = match(2);
					}
					break;
				case 5:
					{
					setState(312); ((ExpressaoContext)_localctx).operador = match(5);
					}
					break;
				case 7:
					{
					setState(313); ((ExpressaoContext)_localctx).operador = match(7);
					}
					break;
				case 16:
					{
					setState(314); ((ExpressaoContext)_localctx).operador = match(16);
					}
					break;
				case 18:
					{
					setState(315); ((ExpressaoContext)_localctx).operador = match(18);
					}
					break;
				case 4:
					{
					setState(316); ((ExpressaoContext)_localctx).operador = match(4);
					}
					break;
				case 12:
					{
					setState(317); ((ExpressaoContext)_localctx).operador = match(12);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(320); ((ExpressaoContext)_localctx).operandoDireito = expressao2();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao2Context extends ParserRuleContext {
		public Expressao2_5Context operandoEsquerdo;
		public Token operador;
		public Expressao2_5Context operandoDireito;
		public List<Expressao2_5Context> expressao2_5() {
			return getRuleContexts(Expressao2_5Context.class);
		}
		public Expressao2_5Context expressao2_5(int i) {
			return getRuleContext(Expressao2_5Context.class,i);
		}
		public Expressao2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao2Context expressao2() throws RecognitionException {
		Expressao2Context _localctx = new Expressao2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressao2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); ((Expressao2Context)_localctx).operandoEsquerdo = expressao2_5();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19 || _la==39) {
				{
				{
				setState(329);
				switch (_input.LA(1)) {
				case 39:
					{
					setState(327); ((Expressao2Context)_localctx).operador = match(39);
					}
					break;
				case 19:
					{
					setState(328); ((Expressao2Context)_localctx).operador = match(19);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(331); ((Expressao2Context)_localctx).operandoDireito = expressao2_5();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao2_5Context extends ParserRuleContext {
		public Expressao3Context operandoEsquerdo;
		public Token operador;
		public Expressao3Context operandoDireito;
		public List<Expressao3Context> expressao3() {
			return getRuleContexts(Expressao3Context.class);
		}
		public Expressao3Context expressao3(int i) {
			return getRuleContext(Expressao3Context.class,i);
		}
		public Expressao2_5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao2_5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao2_5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao2_5Context expressao2_5() throws RecognitionException {
		Expressao2_5Context _localctx = new Expressao2_5Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressao2_5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); ((Expressao2_5Context)_localctx).operandoEsquerdo = expressao3();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==33) {
				{
				{
				setState(340);
				switch (_input.LA(1)) {
				case 33:
					{
					setState(338); ((Expressao2_5Context)_localctx).operador = match(33);
					}
					break;
				case 6:
					{
					setState(339); ((Expressao2_5Context)_localctx).operador = match(6);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(342); ((Expressao2_5Context)_localctx).operandoDireito = expressao3();
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao3Context extends ParserRuleContext {
		public Expressao3_5Context operandoEsquerdo;
		public Token operador;
		public Expressao3_5Context operandoDireito;
		public List<Expressao3_5Context> expressao3_5() {
			return getRuleContexts(Expressao3_5Context.class);
		}
		public Expressao3_5Context expressao3_5(int i) {
			return getRuleContext(Expressao3_5Context.class,i);
		}
		public Expressao3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao3Context expressao3() throws RecognitionException {
		Expressao3Context _localctx = new Expressao3Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressao3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); ((Expressao3Context)_localctx).operandoEsquerdo = expressao3_5();
			setState(356);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 27) | (1L << 32) | (1L << 36))) != 0)) {
				{
				setState(353);
				switch (_input.LA(1)) {
				case 27:
					{
					setState(349); ((Expressao3Context)_localctx).operador = match(27);
					}
					break;
				case 17:
					{
					setState(350); ((Expressao3Context)_localctx).operador = match(17);
					}
					break;
				case 32:
					{
					setState(351); ((Expressao3Context)_localctx).operador = match(32);
					}
					break;
				case 36:
					{
					setState(352); ((Expressao3Context)_localctx).operador = match(36);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(355); ((Expressao3Context)_localctx).operandoDireito = expressao3_5();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao3_5Context extends ParserRuleContext {
		public Expressao4_5Context operandoEsquerdo;
		public Token operador;
		public Expressao4_5Context operandoDireito;
		public Expressao4_5Context expressao4_5(int i) {
			return getRuleContext(Expressao4_5Context.class,i);
		}
		public List<Expressao4_5Context> expressao4_5() {
			return getRuleContexts(Expressao4_5Context.class);
		}
		public Expressao3_5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao3_5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao3_5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao3_5Context expressao3_5() throws RecognitionException {
		Expressao3_5Context _localctx = new Expressao3_5Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressao3_5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358); ((Expressao3_5Context)_localctx).operandoEsquerdo = expressao4_5();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 20) | (1L << 31))) != 0)) {
				{
				{
				setState(362);
				switch (_input.LA(1)) {
				case 20:
					{
					setState(359); ((Expressao3_5Context)_localctx).operador = match(20);
					}
					break;
				case 31:
					{
					setState(360); ((Expressao3_5Context)_localctx).operador = match(31);
					}
					break;
				case 15:
					{
					setState(361); ((Expressao3_5Context)_localctx).operador = match(15);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(364); ((Expressao3_5Context)_localctx).operandoDireito = expressao4_5();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao4_5Context extends ParserRuleContext {
		public Expressao5Context operandoEsquerdo;
		public Token operador;
		public Expressao5Context operandoDireito;
		public Expressao5Context expressao5(int i) {
			return getRuleContext(Expressao5Context.class,i);
		}
		public List<Expressao5Context> expressao5() {
			return getRuleContexts(Expressao5Context.class);
		}
		public Expressao4_5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao4_5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao4_5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao4_5Context expressao4_5() throws RecognitionException {
		Expressao4_5Context _localctx = new Expressao4_5Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressao4_5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); ((Expressao4_5Context)_localctx).operandoEsquerdo = expressao5();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10 || _la==11) {
				{
				{
				setState(373);
				switch (_input.LA(1)) {
				case 11:
					{
					setState(371); ((Expressao4_5Context)_localctx).operador = match(11);
					}
					break;
				case 10:
					{
					setState(372); ((Expressao4_5Context)_localctx).operador = match(10);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(375); ((Expressao4_5Context)_localctx).operandoDireito = expressao5();
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao5Context extends ParserRuleContext {
		public Expressao6Context operandoEsquerdo;
		public Token operador;
		public Expressao6Context operandoDireito;
		public Expressao6Context expressao6(int i) {
			return getRuleContext(Expressao6Context.class,i);
		}
		public List<Expressao6Context> expressao6() {
			return getRuleContexts(Expressao6Context.class);
		}
		public Expressao5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao5Context expressao5() throws RecognitionException {
		Expressao5Context _localctx = new Expressao5Context(_ctx, getState());
		enterRule(_localctx, 64, RULE_expressao5);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(381); ((Expressao5Context)_localctx).operandoEsquerdo = expressao6();
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(386);
					switch (_input.LA(1)) {
					case 41:
						{
						{
						setState(382); ((Expressao5Context)_localctx).operador = match(41);
						setState(383); ((Expressao5Context)_localctx).operandoDireito = expressao6();
						}
						}
						break;
					case 42:
						{
						{
						setState(384); ((Expressao5Context)_localctx).operador = match(42);
						setState(385); ((Expressao5Context)_localctx).operandoDireito = expressao6();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao6Context extends ParserRuleContext {
		public Expressao7Context operandoEsquerdo;
		public Token operador;
		public Expressao7Context operandoDireito;
		public Expressao7Context expressao7(int i) {
			return getRuleContext(Expressao7Context.class,i);
		}
		public List<Expressao7Context> expressao7() {
			return getRuleContexts(Expressao7Context.class);
		}
		public Expressao6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao6; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao6Context expressao6() throws RecognitionException {
		Expressao6Context _localctx = new Expressao6Context(_ctx, getState());
		enterRule(_localctx, 66, RULE_expressao6);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); ((Expressao6Context)_localctx).operandoEsquerdo = expressao7();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 22) | (1L << 38))) != 0)) {
				{
				{
				setState(395);
				switch (_input.LA(1)) {
				case 22:
					{
					setState(392); ((Expressao6Context)_localctx).operador = match(22);
					}
					break;
				case 1:
					{
					setState(393); ((Expressao6Context)_localctx).operador = match(1);
					}
					break;
				case 38:
					{
					setState(394); ((Expressao6Context)_localctx).operador = match(38);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(397); ((Expressao6Context)_localctx).operandoDireito = expressao7();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao7Context extends ParserRuleContext {
		public Token s42;
		public List<Token> listaTokenMenos = new ArrayList<Token>();
		public Token OPERADOR_NAO;
		public List<Token> listaTokenNao = new ArrayList<Token>();
		public Token s35;
		public List<Token> listaTokenNot = new ArrayList<Token>();
		public Expressao8Context vExpressao;
		public TerminalNode OPERADOR_NAO() { return getToken(PortugolParser.OPERADOR_NAO, 0); }
		public Expressao8Context expressao8() {
			return getRuleContext(Expressao8Context.class,0);
		}
		public Expressao7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao7; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao7(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao7Context expressao7() throws RecognitionException {
		Expressao7Context _localctx = new Expressao7Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_expressao7);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(404);
				_la = _input.LA(1);
				if (_la==42) {
					{
					setState(403); ((Expressao7Context)_localctx).s42 = match(42);
					((Expressao7Context)_localctx).listaTokenMenos.add(((Expressao7Context)_localctx).s42);
					}
				}

				}
				break;

			case 2:
				{
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPERADOR_NAO) {
					{
					{
					setState(406); ((Expressao7Context)_localctx).OPERADOR_NAO = match(OPERADOR_NAO);
					((Expressao7Context)_localctx).listaTokenNao.add(((Expressao7Context)_localctx).OPERADOR_NAO);
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 3:
				{
				setState(412); ((Expressao7Context)_localctx).s35 = match(35);
				((Expressao7Context)_localctx).listaTokenNot.add(((Expressao7Context)_localctx).s35);
				}
				break;
			}
			setState(415); ((Expressao7Context)_localctx).vExpressao = expressao8();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao8Context extends ParserRuleContext {
		public Token ab;
		public ExpressaoContext vExpressao;
		public Token fp;
		public Token operador;
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TipoPrimitivoContext tipoPrimitivo() {
			return getRuleContext(TipoPrimitivoContext.class,0);
		}
		public ReferenciaContext referencia() {
			return getRuleContext(ReferenciaContext.class,0);
		}
		public MatrizVetorContext matrizVetor() {
			return getRuleContext(MatrizVetorContext.class,0);
		}
		public Expressao8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao8; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitExpressao8(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao8Context expressao8() throws RecognitionException {
		Expressao8Context _localctx = new Expressao8Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_expressao8);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			switch (_input.LA(1)) {
			case 21:
				{
				setState(417); ((Expressao8Context)_localctx).ab = match(21);
				setState(418); ((Expressao8Context)_localctx).vExpressao = expressao();
				setState(419); ((Expressao8Context)_localctx).fp = match(40);
				}
				break;
			case ID:
			case ID_BIBLIOTECA:
				{
				setState(421); ((Expressao8Context)_localctx).vExpressao = referencia();
				}
				break;
			case LOGICO:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(422); ((Expressao8Context)_localctx).vExpressao = tipoPrimitivo();
				}
				break;
			case 9:
				{
				setState(423); ((Expressao8Context)_localctx).vExpressao = matrizVetor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(428);
			switch (_input.LA(1)) {
			case 30:
				{
				setState(426); ((Expressao8Context)_localctx).operador = match(30);
				}
				break;
			case 29:
				{
				setState(427); ((Expressao8Context)_localctx).operador = match(29);
				}
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
			case 31:
			case 32:
			case 33:
			case 34:
			case 35:
			case 36:
			case 38:
			case 39:
			case 40:
			case 41:
			case 42:
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
			case PR_ESCOLHA:
			case PR_CASO:
			case PR_CONST:
			case PR_FUNCAO:
			case PR_RETORNE:
			case PR_PARA:
			case PR_PARE:
			case PR_FACA:
			case PR_ENQUANTO:
			case PR_SE:
			case PR_SENAO:
			case OPERADOR_NAO:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoPrimitivoContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(PortugolParser.REAL, 0); }
		public TerminalNode CARACTER() { return getToken(PortugolParser.CARACTER, 0); }
		public TerminalNode INTEIRO() { return getToken(PortugolParser.INTEIRO, 0); }
		public TerminalNode LOGICO() { return getToken(PortugolParser.LOGICO, 0); }
		public TerminalNode CADEIA() { return getToken(PortugolParser.CADEIA, 0); }
		public TipoPrimitivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoPrimitivo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitTipoPrimitivo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoPrimitivoContext tipoPrimitivo() throws RecognitionException {
		TipoPrimitivoContext _localctx = new TipoPrimitivoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tipoPrimitivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LOGICO - 66)) | (1L << (INTEIRO - 66)) | (1L << (REAL - 66)) | (1L << (CADEIA - 66)) | (1L << (CARACTER - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenciaContext extends ParserRuleContext {
		public Token id;
		public ChamadaFuncaoContext vExpressao;
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ReferenciaVetorMatrizContext referenciaVetorMatriz() {
			return getRuleContext(ReferenciaVetorMatrizContext.class,0);
		}
		public TerminalNode ID_BIBLIOTECA() { return getToken(PortugolParser.ID_BIBLIOTECA, 0); }
		public ReferenciaIdContext referenciaId() {
			return getRuleContext(ReferenciaIdContext.class,0);
		}
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public ReferenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencia; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitReferencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenciaContext referencia() throws RecognitionException {
		ReferenciaContext _localctx = new ReferenciaContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_referencia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(432); ((ReferenciaContext)_localctx).id = match(ID);
				}
				break;
			case ID_BIBLIOTECA:
				{
				setState(433); ((ReferenciaContext)_localctx).id = match(ID_BIBLIOTECA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(436); ((ReferenciaContext)_localctx).vExpressao = chamadaFuncao();
				}
				break;

			case 2:
				{
				setState(437); ((ReferenciaContext)_localctx).vExpressao = referenciaVetorMatriz();
				}
				break;

			case 3:
				{
				setState(438); ((ReferenciaContext)_localctx).vExpressao = referenciaId();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenciaIdContext extends ParserRuleContext {
		public ReferenciaIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenciaId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitReferenciaId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenciaIdContext referenciaId() throws RecognitionException {
		ReferenciaIdContext _localctx = new ReferenciaIdContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_referenciaId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenciaVetorMatrizContext extends ParserRuleContext {
		public ExpressaoContext indice1;
		public ExpressaoContext indice2;
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ReferenciaVetorMatrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenciaVetorMatriz; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitReferenciaVetorMatriz(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenciaVetorMatrizContext referenciaVetorMatriz() throws RecognitionException {
		ReferenciaVetorMatrizContext _localctx = new ReferenciaVetorMatrizContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_referenciaVetorMatriz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443); match(28);
			setState(444); ((ReferenciaVetorMatrizContext)_localctx).indice1 = expressao();
			setState(445); match(34);
			setState(450);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(446); match(28);
				setState(447); ((ReferenciaVetorMatrizContext)_localctx).indice2 = expressao();
				setState(448); match(34);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChamadaFuncaoContext extends ParserRuleContext {
		public ListaParametrosContext vListaParametros;
		public ListaParametrosContext listaParametros() {
			return getRuleContext(ListaParametrosContext.class,0);
		}
		public ChamadaFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFuncao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitChamadaFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_chamadaFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452); match(21);
			setState(454);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(453); ((ChamadaFuncaoContext)_localctx).vListaParametros = listaParametros();
				}
			}

			setState(456); match(40);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaParametrosContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ListaParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametros; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaParametrosContext listaParametros() throws RecognitionException {
		ListaParametrosContext _localctx = new ListaParametrosContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_listaParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(458); ((ListaParametrosContext)_localctx).vExpressao = expressao();
			}
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(459); match(24);
				setState(460); ((ListaParametrosContext)_localctx).vExpressao = expressao();
				}
				}
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatrizVetorContext extends ParserRuleContext {
		public MatrizContext vExpressao;
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public MatrizContext matriz() {
			return getRuleContext(MatrizContext.class,0);
		}
		public MatrizVetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrizVetor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitMatrizVetor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrizVetorContext matrizVetor() throws RecognitionException {
		MatrizVetorContext _localctx = new MatrizVetorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_matrizVetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(466); ((MatrizVetorContext)_localctx).vExpressao = matriz();
				}
				break;

			case 2:
				{
				setState(467); ((MatrizVetorContext)_localctx).vExpressao = vetor();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VetorContext extends ParserRuleContext {
		public Token abre_ch;
		public ListaExpressoesContext vListaExpressoes;
		public Token fecha_ch;
		public ListaExpressoesContext listaExpressoes() {
			return getRuleContext(ListaExpressoesContext.class,0);
		}
		public VetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vetor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitVetor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VetorContext vetor() throws RecognitionException {
		VetorContext _localctx = new VetorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_vetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470); ((VetorContext)_localctx).abre_ch = match(9);
			setState(471); ((VetorContext)_localctx).vListaExpressoes = listaExpressoes();
			setState(472); ((VetorContext)_localctx).fecha_ch = match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatrizContext extends ParserRuleContext {
		public Token abre_ch;
		public ListaListaExpressoesContext vListaListaExpressoes;
		public Token fecha_ch;
		public ListaListaExpressoesContext listaListaExpressoes() {
			return getRuleContext(ListaListaExpressoesContext.class,0);
		}
		public MatrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matriz; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitMatriz(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrizContext matriz() throws RecognitionException {
		MatrizContext _localctx = new MatrizContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_matriz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); ((MatrizContext)_localctx).abre_ch = match(9);
			setState(475); ((MatrizContext)_localctx).vListaListaExpressoes = listaListaExpressoes();
			setState(476); ((MatrizContext)_localctx).fecha_ch = match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaListaExpressoesContext extends ParserRuleContext {
		public ListaExpressoesContext vListaExpressoes;
		public ListaExpressoesContext listaExpressoes(int i) {
			return getRuleContext(ListaExpressoesContext.class,i);
		}
		public List<ListaExpressoesContext> listaExpressoes() {
			return getRuleContexts(ListaExpressoesContext.class);
		}
		public ListaListaExpressoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaListaExpressoes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaListaExpressoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaListaExpressoesContext listaListaExpressoes() throws RecognitionException {
		ListaListaExpressoesContext _localctx = new ListaListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_listaListaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			_la = _input.LA(1);
			if (_la==9) {
				{
				setState(478); match(9);
				setState(479); ((ListaListaExpressoesContext)_localctx).vListaExpressoes = listaExpressoes();
				setState(480); match(14);
				}
			}

			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(484); match(24);
				setState(485); match(9);
				setState(486); ((ListaListaExpressoesContext)_localctx).vListaExpressoes = listaExpressoes();
				setState(487); match(14);
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaExpressoesContext extends ParserRuleContext {
		public ExpressaoContext vExpressao;
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ListaExpressoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaExpressoes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitListaExpressoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaExpressoesContext listaExpressoes() throws RecognitionException {
		ListaExpressoesContext _localctx = new ListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_listaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(495);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(494); ((ListaExpressoesContext)_localctx).vExpressao = expressao();
				}
			}

			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(497); match(24);
				{
				setState(498); ((ListaExpressoesContext)_localctx).vExpressao = expressao();
				}
				}
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3L\u01fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3w\n\3\3"+
		"\4\3\4\3\5\3\5\3\6\5\6~\n\6\3\6\3\6\3\6\3\6\7\6\u0084\n\6\f\6\16\6\u0087"+
		"\13\6\3\7\3\7\3\7\5\7\u008c\n\7\3\7\3\7\3\7\5\7\u0091\n\7\3\7\5\7\u0094"+
		"\n\7\5\7\u0096\n\7\3\7\3\7\5\7\u009a\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00a1"+
		"\n\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u00a9\n\n\5\n\u00ab\n\n\3\13\3\13\5\13"+
		"\u00af\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7"+
		"\r\u00bf\n\r\f\r\16\r\u00c2\13\r\5\r\u00c4\n\r\3\16\3\16\5\16\u00c8\n"+
		"\16\3\16\3\16\3\16\3\17\3\17\7\17\u00cf\n\17\f\17\16\17\u00d2\13\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00dc\n\20\3\21\3\21\3\21"+
		"\5\21\u00e1\n\21\3\21\3\21\5\21\u00e5\n\21\3\21\3\21\5\21\u00e9\n\21\3"+
		"\21\3\21\3\21\3\22\3\22\5\22\u00f0\n\22\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00f7\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\6\25\u0105\n\25\r\25\16\25\u0106\3\25\3\25\3\25\3\25\5\25\u010d\n\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u0116\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u012c\n\31\3\32\3\32\5\32\u0130\n\32\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0141"+
		"\n\34\3\34\7\34\u0144\n\34\f\34\16\34\u0147\13\34\3\35\3\35\3\35\5\35"+
		"\u014c\n\35\3\35\7\35\u014f\n\35\f\35\16\35\u0152\13\35\3\36\3\36\3\36"+
		"\5\36\u0157\n\36\3\36\7\36\u015a\n\36\f\36\16\36\u015d\13\36\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u0164\n\37\3\37\5\37\u0167\n\37\3 \3 \3 \3 \5 \u016d"+
		"\n \3 \7 \u0170\n \f \16 \u0173\13 \3!\3!\3!\5!\u0178\n!\3!\7!\u017b\n"+
		"!\f!\16!\u017e\13!\3\"\3\"\3\"\3\"\3\"\7\"\u0185\n\"\f\"\16\"\u0188\13"+
		"\"\3#\3#\3#\3#\5#\u018e\n#\3#\7#\u0191\n#\f#\16#\u0194\13#\3$\5$\u0197"+
		"\n$\3$\7$\u019a\n$\f$\16$\u019d\13$\3$\5$\u01a0\n$\3$\3$\3%\3%\3%\3%\3"+
		"%\3%\3%\5%\u01ab\n%\3%\3%\5%\u01af\n%\3&\3&\3\'\3\'\5\'\u01b5\n\'\3\'"+
		"\3\'\3\'\5\'\u01ba\n\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\5)\u01c5\n)\3*\3*\5"+
		"*\u01c9\n*\3*\3*\3+\3+\3+\7+\u01d0\n+\f+\16+\u01d3\13+\3,\3,\5,\u01d7"+
		"\n,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\5/\u01e5\n/\3/\3/\3/\3/\3/\7/"+
		"\u01ec\n/\f/\16/\u01ef\13/\3\60\5\60\u01f2\n\60\3\60\3\60\7\60\u01f6\n"+
		"\60\f\60\16\60\u01f9\13\60\3\60\2\61\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\3\4\2DDGJ\u0225\2`"+
		"\3\2\2\2\4q\3\2\2\2\6x\3\2\2\2\bz\3\2\2\2\n}\3\2\2\2\f\u0088\3\2\2\2\16"+
		"\u00a0\3\2\2\2\20\u00a2\3\2\2\2\22\u00aa\3\2\2\2\24\u00ae\3\2\2\2\26\u00b0"+
		"\3\2\2\2\30\u00c3\3\2\2\2\32\u00c5\3\2\2\2\34\u00d0\3\2\2\2\36\u00db\3"+
		"\2\2\2 \u00dd\3\2\2\2\"\u00ef\3\2\2\2$\u00f6\3\2\2\2&\u00f8\3\2\2\2(\u00fa"+
		"\3\2\2\2*\u0115\3\2\2\2,\u0117\3\2\2\2.\u011d\3\2\2\2\60\u0124\3\2\2\2"+
		"\62\u012d\3\2\2\2\64\u0131\3\2\2\2\66\u0133\3\2\2\28\u0148\3\2\2\2:\u0153"+
		"\3\2\2\2<\u015e\3\2\2\2>\u0168\3\2\2\2@\u0174\3\2\2\2B\u017f\3\2\2\2D"+
		"\u0189\3\2\2\2F\u019f\3\2\2\2H\u01aa\3\2\2\2J\u01b0\3\2\2\2L\u01b4\3\2"+
		"\2\2N\u01bb\3\2\2\2P\u01bd\3\2\2\2R\u01c6\3\2\2\2T\u01cc\3\2\2\2V\u01d6"+
		"\3\2\2\2X\u01d8\3\2\2\2Z\u01dc\3\2\2\2\\\u01e4\3\2\2\2^\u01f1\3\2\2\2"+
		"`a\7-\2\2ae\7\13\2\2bd\5\4\3\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"fl\3\2\2\2ge\3\2\2\2hk\5\6\4\2ik\5\26\f\2jh\3\2\2\2ji\3\2\2\2kn\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\20\2\2p\3\3\2\2\2qr\7@"+
		"\2\2rs\7A\2\2sv\7E\2\2tu\7\'\2\2uw\7E\2\2vt\3\2\2\2vw\3\2\2\2w\5\3\2\2"+
		"\2xy\5\n\6\2y\7\3\2\2\2z{\5\n\6\2{\t\3\2\2\2|~\7\67\2\2}|\3\2\2\2}~\3"+
		"\2\2\2~\177\3\2\2\2\177\u0080\5\16\b\2\u0080\u0085\5\f\7\2\u0081\u0082"+
		"\7\32\2\2\u0082\u0084\5\f\7\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\13\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0095\7E\2\2\u0089\u008b\7\36\2\2\u008a\u008c\5\66\34\2"+
		"\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0093"+
		"\7$\2\2\u008e\u0090\7\36\2\2\u008f\u0091\5\66\34\2\u0090\u008f\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\7$\2\2\u0093\u008e"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0089\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0098\7\17\2\2\u0098\u009a\5"+
		"\66\34\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\r\3\2\2\2\u009b"+
		"\u00a1\7\62\2\2\u009c\u00a1\7.\2\2\u009d\u00a1\7\63\2\2\u009e\u00a1\7"+
		"\61\2\2\u009f\u00a1\7\60\2\2\u00a0\u009b\3\2\2\2\u00a0\u009c\3\2\2\2\u00a0"+
		"\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\17\3\2\2"+
		"\2\u00a2\u00a3\7/\2\2\u00a3\21\3\2\2\2\u00a4\u00a5\7\36\2\2\u00a5\u00a8"+
		"\7$\2\2\u00a6\u00a7\7\36\2\2\u00a7\u00a9\7$\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\23\3\2\2\2\u00ac\u00af\5\16\b\2\u00ad\u00af\5\20\t\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\25\3\2\2"+
		"\2\u00b0\u00b1\78\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\5\22\n\2\u00b3"+
		"\u00b4\7E\2\2\u00b4\u00b5\7\27\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7"+
		"*\2\2\u00b7\u00b8\7\13\2\2\u00b8\u00b9\5\34\17\2\u00b9\u00ba\7\20\2\2"+
		"\u00ba\27\3\2\2\2\u00bb\u00c0\5\32\16\2\u00bc\u00bd\7\32\2\2\u00bd\u00bf"+
		"\5\32\16\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00bb"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\31\3\2\2\2\u00c5\u00c7\5\16\b\2\u00c6"+
		"\u00c8\7\26\2\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00ca\7E\2\2\u00ca\u00cb\5\22\n\2\u00cb\33\3\2\2\2\u00cc"+
		"\u00cf\5\36\20\2\u00cd\u00cf\5\b\5\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\35\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00dc\5\66\34\2\u00d4\u00dc\5 \21"+
		"\2\u00d5\u00dc\5&\24\2\u00d6\u00dc\5\62\32\2\u00d7\u00dc\5\60\31\2\u00d8"+
		"\u00dc\5,\27\2\u00d9\u00dc\5.\30\2\u00da\u00dc\5(\25\2\u00db\u00d3\3\2"+
		"\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2"+
		"\2\2\u00dc\37\3\2\2\2\u00dd\u00de\7:\2\2\u00de\u00e0\7\27\2\2\u00df\u00e1"+
		"\5\"\22\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2"+
		"\u00e2\u00e4\7\n\2\2\u00e3\u00e5\5\66\34\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\7\n\2\2\u00e7\u00e9\5\66\34\2"+
		"\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb"+
		"\7*\2\2\u00eb\u00ec\5$\23\2\u00ec!\3\2\2\2\u00ed\u00f0\5\66\34\2\u00ee"+
		"\u00f0\5\n\6\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0#\3\2\2\2"+
		"\u00f1\u00f2\7\13\2\2\u00f2\u00f3\5\34\17\2\u00f3\u00f4\7\20\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f7\5\36\20\2\u00f6\u00f1\3\2\2\2\u00f6\u00f5\3"+
		"\2\2\2\u00f7%\3\2\2\2\u00f8\u00f9\7;\2\2\u00f9\'\3\2\2\2\u00fa\u00fb\7"+
		"\64\2\2\u00fb\u00fc\7\27\2\2\u00fc\u00fd\5\66\34\2\u00fd\u00fe\7*\2\2"+
		"\u00fe\u0104\7\13\2\2\u00ff\u0100\7\65\2\2\u0100\u0101\5\66\34\2\u0101"+
		"\u0102\7\34\2\2\u0102\u0103\5*\26\2\u0103\u0105\3\2\2\2\u0104\u00ff\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010c\3\2\2\2\u0108\u0109\7\65\2\2\u0109\u010a\7\66\2\2\u010a\u010b\7"+
		"\34\2\2\u010b\u010d\5*\26\2\u010c\u0108\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\7\20\2\2\u010f)\3\2\2\2\u0110\u0111\7\13\2"+
		"\2\u0111\u0112\5\34\17\2\u0112\u0113\7\20\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0116\5\34\17\2\u0115\u0110\3\2\2\2\u0115\u0114\3\2\2\2\u0116+\3\2\2"+
		"\2\u0117\u0118\7=\2\2\u0118\u0119\7\27\2\2\u0119\u011a\5\66\34\2\u011a"+
		"\u011b\7*\2\2\u011b\u011c\5$\23\2\u011c-\3\2\2\2\u011d\u011e\7<\2\2\u011e"+
		"\u011f\5$\23\2\u011f\u0120\7=\2\2\u0120\u0121\7\27\2\2\u0121\u0122\5\66"+
		"\34\2\u0122\u0123\7*\2\2\u0123/\3\2\2\2\u0124\u0125\7>\2\2\u0125\u0126"+
		"\7\27\2\2\u0126\u0127\5\66\34\2\u0127\u0128\7*\2\2\u0128\u012b\5$\23\2"+
		"\u0129\u012a\7?\2\2\u012a\u012c\5$\23\2\u012b\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\61\3\2\2\2\u012d\u012f\79\2\2\u012e\u0130\5\66\34\2\u012f"+
		"\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\63\3\2\2\2\u0131\u0132\3\2\2"+
		"\2\u0132\65\3\2\2\2\u0133\u0134\58\35\2\u0134\u0145\5\64\33\2\u0135\u0141"+
		"\7\17\2\2\u0136\u0141\7\5\2\2\u0137\u0141\7\31\2\2\u0138\u0141\7\33\2"+
		"\2\u0139\u0141\7\4\2\2\u013a\u0141\7\7\2\2\u013b\u0141\7\t\2\2\u013c\u0141"+
		"\7\22\2\2\u013d\u0141\7\24\2\2\u013e\u0141\7\6\2\2\u013f\u0141\7\16\2"+
		"\2\u0140\u0135\3\2\2\2\u0140\u0136\3\2\2\2\u0140\u0137\3\2\2\2\u0140\u0138"+
		"\3\2\2\2\u0140\u0139\3\2\2\2\u0140\u013a\3\2\2\2\u0140\u013b\3\2\2\2\u0140"+
		"\u013c\3\2\2\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0144\58\35\2\u0143\u0140\3\2\2\2\u0144"+
		"\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\67\3\2\2"+
		"\2\u0147\u0145\3\2\2\2\u0148\u0150\5:\36\2\u0149\u014c\7)\2\2\u014a\u014c"+
		"\7\25\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2"+
		"\u014d\u014f\5:\36\2\u014e\u014b\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u01519\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u015b\5<\37\2\u0154\u0157\7#\2\2\u0155\u0157\7\b\2\2\u0156\u0154\3\2"+
		"\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\5<\37\2\u0159"+
		"\u0156\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c;\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0166\5> \2\u015f\u0164"+
		"\7\35\2\2\u0160\u0164\7\23\2\2\u0161\u0164\7\"\2\2\u0162\u0164\7&\2\2"+
		"\u0163\u015f\3\2\2\2\u0163\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0162"+
		"\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\5> \2\u0166\u0163\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167=\3\2\2\2\u0168\u0171\5@!\2\u0169\u016d\7\26\2\2\u016a"+
		"\u016d\7!\2\2\u016b\u016d\7\21\2\2\u016c\u0169\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\5@!\2\u016f\u016c"+
		"\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"?\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u017c\5B\"\2\u0175\u0178\7\r\2\2\u0176"+
		"\u0178\7\f\2\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017b\5B\"\2\u017a\u0177\3\2\2\2\u017b\u017e\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017dA\3\2\2\2\u017e\u017c\3\2\2\2"+
		"\u017f\u0186\5D#\2\u0180\u0181\7+\2\2\u0181\u0185\5D#\2\u0182\u0183\7"+
		",\2\2\u0183\u0185\5D#\2\u0184\u0180\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187C\3\2\2\2"+
		"\u0188\u0186\3\2\2\2\u0189\u0192\5F$\2\u018a\u018e\7\30\2\2\u018b\u018e"+
		"\7\3\2\2\u018c\u018e\7(\2\2\u018d\u018a\3\2\2\2\u018d\u018b\3\2\2\2\u018d"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\5F$\2\u0190\u018d\3\2\2"+
		"\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193E"+
		"\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0197\7,\2\2\u0196\u0195\3\2\2\2\u0196"+
		"\u0197\3\2\2\2\u0197\u01a0\3\2\2\2\u0198\u019a\7C\2\2\u0199\u0198\3\2"+
		"\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u01a0\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a0\7%\2\2\u019f\u0196\3\2"+
		"\2\2\u019f\u019b\3\2\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a2\5H%\2\u01a2G\3\2\2\2\u01a3\u01a4\7\27\2\2\u01a4\u01a5\5\66\34\2"+
		"\u01a5\u01a6\7*\2\2\u01a6\u01ab\3\2\2\2\u01a7\u01ab\5L\'\2\u01a8\u01ab"+
		"\5J&\2\u01a9\u01ab\5V,\2\u01aa\u01a3\3\2\2\2\u01aa\u01a7\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01af\7 "+
		"\2\2\u01ad\u01af\7\37\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01ad\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01afI\3\2\2\2\u01b0\u01b1\t\2\2\2\u01b1K\3\2\2\2\u01b2"+
		"\u01b5\7E\2\2\u01b3\u01b5\7F\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b3\3\2\2"+
		"\2\u01b5\u01b9\3\2\2\2\u01b6\u01ba\5R*\2\u01b7\u01ba\5P)\2\u01b8\u01ba"+
		"\5N(\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba"+
		"M\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bcO\3\2\2\2\u01bd\u01be\7\36\2\2\u01be"+
		"\u01bf\5\66\34\2\u01bf\u01c4\7$\2\2\u01c0\u01c1\7\36\2\2\u01c1\u01c2\5"+
		"\66\34\2\u01c2\u01c3\7$\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c0\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5Q\3\2\2\2\u01c6\u01c8\7\27\2\2\u01c7\u01c9\5T+\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\7*"+
		"\2\2\u01cbS\3\2\2\2\u01cc\u01d1\5\66\34\2\u01cd\u01ce\7\32\2\2\u01ce\u01d0"+
		"\5\66\34\2\u01cf\u01cd\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2"+
		"\u01d1\u01d2\3\2\2\2\u01d2U\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d7\5"+
		"Z.\2\u01d5\u01d7\5X-\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7W"+
		"\3\2\2\2\u01d8\u01d9\7\13\2\2\u01d9\u01da\5^\60\2\u01da\u01db\7\20\2\2"+
		"\u01dbY\3\2\2\2\u01dc\u01dd\7\13\2\2\u01dd\u01de\5\\/\2\u01de\u01df\7"+
		"\20\2\2\u01df[\3\2\2\2\u01e0\u01e1\7\13\2\2\u01e1\u01e2\5^\60\2\u01e2"+
		"\u01e3\7\20\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e0\3\2\2\2\u01e4\u01e5\3"+
		"\2\2\2\u01e5\u01ed\3\2\2\2\u01e6\u01e7\7\32\2\2\u01e7\u01e8\7\13\2\2\u01e8"+
		"\u01e9\5^\60\2\u01e9\u01ea\7\20\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e6\3"+
		"\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"]\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f2\5\66\34\2\u01f1\u01f0\3\2\2"+
		"\2\u01f1\u01f2\3\2\2\2\u01f2\u01f7\3\2\2\2\u01f3\u01f4\7\32\2\2\u01f4"+
		"\u01f6\5\66\34\2\u01f5\u01f3\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3"+
		"\2\2\2\u01f7\u01f8\3\2\2\2\u01f8_\3\2\2\2\u01f9\u01f7\3\2\2\2@ejlv}\u0085"+
		"\u008b\u0090\u0093\u0095\u0099\u00a0\u00a8\u00aa\u00ae\u00c0\u00c3\u00c7"+
		"\u00ce\u00d0\u00db\u00e0\u00e4\u00e8\u00ef\u00f6\u0106\u010c\u0115\u012b"+
		"\u012f\u0140\u0145\u014b\u0150\u0156\u015b\u0163\u0166\u016c\u0171\u0177"+
		"\u017c\u0184\u0186\u018d\u0192\u0196\u019b\u019f\u01aa\u01ae\u01b4\u01b9"+
		"\u01c4\u01c8\u01d1\u01d6\u01e4\u01ed\u01f1\u01f7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}