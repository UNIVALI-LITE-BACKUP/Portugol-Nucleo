// Generated from Portugol.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		PR_PROGRAMA=32, PR_REAL=33, PR_VAZIO=34, PR_LOGICO=35, PR_CADEIA=36, PR_INTEIRO=37, 
		PR_CARACTER=38, PR_ESCOLHA=39, PR_CASO=40, PR_CONTRARIO=41, PR_CONST=42, 
		PR_FUNCAO=43, PR_RETORNE=44, PR_PARA=45, PR_PARE=46, PR_FACA=47, PR_ENQUANTO=48, 
		PR_SE=49, PR_SENAO=50, PR_INCLUA=51, PR_BIBLIOTECA=52, GAMBIARRA=53, OPERADOR_NAO=54, 
		LOGICO=55, ID=56, ID_BIBLIOTECA=57, INTEIRO=58, REAL=59, CADEIA=60, CARACTER=61, 
		ESPACO=62, ATRIBUICOES=63, COMENTARIO=64;
	public static final int
		RULE_programa = 0, RULE_inclusaoBiblioteca = 1, RULE_declaracoesGlobais = 2, 
		RULE_declaracoesLocais = 3, RULE_listaDeclaracoes = 4, RULE_declaracao = 5, 
		RULE_declaracaoTipoDado = 6, RULE_declaracaoTipoDadoVazio = 7, RULE_quantificador = 8, 
		RULE_tipoRetornoFuncao = 9, RULE_declaracaoFuncao = 10, RULE_listaParametrosFuncao = 11, 
		RULE_declaracaoParametro = 12, RULE_blocos = 13, RULE_bloco = 14, RULE_para = 15, 
		RULE_inicializacaoPara = 16, RULE_listaBlocos = 17, RULE_pare = 18, RULE_escolha = 19, 
		RULE_blocosCaso = 20, RULE_enquanto = 21, RULE_facaEnquanto = 22, RULE_se = 23, 
		RULE_retorne = 24, RULE_expressao = 25, RULE_tipoPrimitivo = 26, RULE_referencia = 27, 
		RULE_referenciaVetorMatriz = 28, RULE_chamadaFuncao = 29, RULE_listaParametros = 30, 
		RULE_matrizVetor = 31, RULE_vetor = 32, RULE_matriz = 33, RULE_listaListaExpressoes = 34, 
		RULE_listaExpressoes = 35;
	public static final String[] ruleNames = {
		"programa", "inclusaoBiblioteca", "declaracoesGlobais", "declaracoesLocais", 
		"listaDeclaracoes", "declaracao", "declaracaoTipoDado", "declaracaoTipoDadoVazio", 
		"quantificador", "tipoRetornoFuncao", "declaracaoFuncao", "listaParametrosFuncao", 
		"declaracaoParametro", "blocos", "bloco", "para", "inicializacaoPara", 
		"listaBlocos", "pare", "escolha", "blocosCaso", "enquanto", "facaEnquanto", 
		"se", "retorne", "expressao", "tipoPrimitivo", "referencia", "referenciaVetorMatriz", 
		"chamadaFuncao", "listaParametros", "matrizVetor", "vetor", "matriz", 
		"listaListaExpressoes", "listaExpressoes"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'-->'", "','", "'['", "']'", "'('", "')'", "'&'", 
		"';'", "':'", "'++'", "'--'", "'-'", "'~'", "'*'", "'/'", "'%'", "'+'", 
		"'<<'", "'>>'", "'|'", "'^'", "'>='", "'<='", "'<'", "'>'", "'=='", "'!='", 
		"'e'", "'ou'", "'programa'", "'real'", "'vazio'", "'logico'", "'cadeia'", 
		"'inteiro'", "'caracter'", "'escolha'", "'caso'", "'contrario'", "'const'", 
		"'funcao'", "'retorne'", "'para'", "'pare'", "'faca'", "'enquanto'", "'se'", 
		"'senao'", "'inclua'", "'biblioteca'", null, "'nao'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "PR_PROGRAMA", "PR_REAL", 
		"PR_VAZIO", "PR_LOGICO", "PR_CADEIA", "PR_INTEIRO", "PR_CARACTER", "PR_ESCOLHA", 
		"PR_CASO", "PR_CONTRARIO", "PR_CONST", "PR_FUNCAO", "PR_RETORNE", "PR_PARA", 
		"PR_PARE", "PR_FACA", "PR_ENQUANTO", "PR_SE", "PR_SENAO", "PR_INCLUA", 
		"PR_BIBLIOTECA", "GAMBIARRA", "OPERADOR_NAO", "LOGICO", "ID", "ID_BIBLIOTECA", 
		"INTEIRO", "REAL", "CADEIA", "CARACTER", "ESPACO", "ATRIBUICOES", "COMENTARIO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PortugolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PR_PROGRAMA() { return getToken(PortugolParser.PR_PROGRAMA, 0); }
		public List<InclusaoBibliotecaContext> inclusaoBiblioteca() {
			return getRuleContexts(InclusaoBibliotecaContext.class);
		}
		public InclusaoBibliotecaContext inclusaoBiblioteca(int i) {
			return getRuleContext(InclusaoBibliotecaContext.class,i);
		}
		public List<DeclaracoesGlobaisContext> declaracoesGlobais() {
			return getRuleContexts(DeclaracoesGlobaisContext.class);
		}
		public DeclaracoesGlobaisContext declaracoesGlobais(int i) {
			return getRuleContext(DeclaracoesGlobaisContext.class,i);
		}
		public List<DeclaracaoFuncaoContext> declaracaoFuncao() {
			return getRuleContexts(DeclaracaoFuncaoContext.class);
		}
		public DeclaracaoFuncaoContext declaracaoFuncao(int i) {
			return getRuleContext(DeclaracaoFuncaoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(PR_PROGRAMA);
			setState(73);
			match(T__0);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PR_INCLUA) {
				{
				{
				setState(74);
				inclusaoBiblioteca();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER) | (1L << PR_CONST) | (1L << PR_FUNCAO))) != 0)) {
				{
				setState(82);
				switch (_input.LA(1)) {
				case PR_REAL:
				case PR_LOGICO:
				case PR_CADEIA:
				case PR_INTEIRO:
				case PR_CARACTER:
				case PR_CONST:
					{
					setState(80);
					declaracoesGlobais();
					}
					break;
				case PR_FUNCAO:
					{
					setState(81);
					declaracaoFuncao();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__1);
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
		public TerminalNode PR_INCLUA() { return getToken(PortugolParser.PR_INCLUA, 0); }
		public TerminalNode PR_BIBLIOTECA() { return getToken(PortugolParser.PR_BIBLIOTECA, 0); }
		public List<TerminalNode> ID() { return getTokens(PortugolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PortugolParser.ID, i);
		}
		public InclusaoBibliotecaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusaoBiblioteca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterInclusaoBiblioteca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitInclusaoBiblioteca(this);
		}
	}

	public final InclusaoBibliotecaContext inclusaoBiblioteca() throws RecognitionException {
		InclusaoBibliotecaContext _localctx = new InclusaoBibliotecaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inclusaoBiblioteca);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(PR_INCLUA);
			setState(90);
			match(PR_BIBLIOTECA);
			setState(91);
			match(ID);
			setState(94);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(92);
				match(T__2);
				setState(93);
				match(ID);
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
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public DeclaracoesGlobaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoesGlobais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracoesGlobais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracoesGlobais(this);
		}
	}

	public final DeclaracoesGlobaisContext declaracoesGlobais() throws RecognitionException {
		DeclaracoesGlobaisContext _localctx = new DeclaracoesGlobaisContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoesGlobais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			listaDeclaracoes();
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
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public DeclaracoesLocaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoesLocais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracoesLocais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracoesLocais(this);
		}
	}

	public final DeclaracoesLocaisContext declaracoesLocais() throws RecognitionException {
		DeclaracoesLocaisContext _localctx = new DeclaracoesLocaisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracoesLocais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			listaDeclaracoes();
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
		public DeclaracaoTipoDadoContext declaracaoTipoDado() {
			return getRuleContext(DeclaracaoTipoDadoContext.class,0);
		}
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public TerminalNode PR_CONST() { return getToken(PortugolParser.PR_CONST, 0); }
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaDeclaracoes(this);
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
			setState(101);
			_la = _input.LA(1);
			if (_la==PR_CONST) {
				{
				setState(100);
				match(PR_CONST);
				}
			}

			setState(103);
			declaracaoTipoDado();
			{
			setState(104);
			declaracao();
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(105);
				match(T__3);
				setState(106);
				declaracao();
				}
				}
				setState(111);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracao(this);
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
			setState(112);
			match(ID);
			setState(125);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(113);
				match(T__4);
				setState(115);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
					{
					setState(114);
					expressao(0);
					}
				}

				setState(117);
				match(T__5);
				setState(123);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(118);
					match(T__4);
					setState(120);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
						{
						setState(119);
						expressao(0);
						}
					}

					setState(122);
					match(T__5);
					}
				}

				}
			}

			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(127);
				expressao(0);
				}
				break;
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
		public TerminalNode PR_INTEIRO() { return getToken(PortugolParser.PR_INTEIRO, 0); }
		public TerminalNode PR_REAL() { return getToken(PortugolParser.PR_REAL, 0); }
		public TerminalNode PR_CARACTER() { return getToken(PortugolParser.PR_CARACTER, 0); }
		public TerminalNode PR_CADEIA() { return getToken(PortugolParser.PR_CADEIA, 0); }
		public TerminalNode PR_LOGICO() { return getToken(PortugolParser.PR_LOGICO, 0); }
		public DeclaracaoTipoDadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoTipoDado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracaoTipoDado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracaoTipoDado(this);
		}
	}

	public final DeclaracaoTipoDadoContext declaracaoTipoDado() throws RecognitionException {
		DeclaracaoTipoDadoContext _localctx = new DeclaracaoTipoDadoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracaoTipoDado);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracaoTipoDadoVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracaoTipoDadoVazio(this);
		}
	}

	public final DeclaracaoTipoDadoVazioContext declaracaoTipoDadoVazio() throws RecognitionException {
		DeclaracaoTipoDadoVazioContext _localctx = new DeclaracaoTipoDadoVazioContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracaoTipoDadoVazio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(PR_VAZIO);
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
		public QuantificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterQuantificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitQuantificador(this);
		}
	}

	public final QuantificadorContext quantificador() throws RecognitionException {
		QuantificadorContext _localctx = new QuantificadorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_quantificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(134);
				match(T__4);
				setState(135);
				match(T__5);
				setState(138);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(136);
					match(T__4);
					setState(137);
					match(T__5);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterTipoRetornoFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitTipoRetornoFuncao(this);
		}
	}

	public final TipoRetornoFuncaoContext tipoRetornoFuncao() throws RecognitionException {
		TipoRetornoFuncaoContext _localctx = new TipoRetornoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipoRetornoFuncao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			switch (_input.LA(1)) {
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
				{
				setState(142);
				declaracaoTipoDado();
				}
				break;
			case PR_VAZIO:
				{
				setState(143);
				declaracaoTipoDadoVazio();
				}
				break;
			case T__4:
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
		public TerminalNode PR_FUNCAO() { return getToken(PortugolParser.PR_FUNCAO, 0); }
		public TipoRetornoFuncaoContext tipoRetornoFuncao() {
			return getRuleContext(TipoRetornoFuncaoContext.class,0);
		}
		public QuantificadorContext quantificador() {
			return getRuleContext(QuantificadorContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ListaParametrosFuncaoContext listaParametrosFuncao() {
			return getRuleContext(ListaParametrosFuncaoContext.class,0);
		}
		public BlocosContext blocos() {
			return getRuleContext(BlocosContext.class,0);
		}
		public DeclaracaoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracaoFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracaoFuncao(this);
		}
	}

	public final DeclaracaoFuncaoContext declaracaoFuncao() throws RecognitionException {
		DeclaracaoFuncaoContext _localctx = new DeclaracaoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaracaoFuncao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(PR_FUNCAO);
			setState(147);
			tipoRetornoFuncao();
			setState(148);
			quantificador();
			setState(149);
			match(ID);
			setState(150);
			match(T__6);
			setState(151);
			listaParametrosFuncao();
			setState(152);
			match(T__7);
			setState(153);
			match(T__0);
			setState(154);
			blocos();
			setState(155);
			match(T__1);
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
		public List<DeclaracaoParametroContext> declaracaoParametro() {
			return getRuleContexts(DeclaracaoParametroContext.class);
		}
		public DeclaracaoParametroContext declaracaoParametro(int i) {
			return getRuleContext(DeclaracaoParametroContext.class,i);
		}
		public ListaParametrosFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametrosFuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaParametrosFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaParametrosFuncao(this);
		}
	}

	public final ListaParametrosFuncaoContext listaParametrosFuncao() throws RecognitionException {
		ListaParametrosFuncaoContext _localctx = new ListaParametrosFuncaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaParametrosFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER))) != 0)) {
				{
				{
				setState(157);
				declaracaoParametro();
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(158);
					match(T__3);
					setState(159);
					declaracaoParametro();
					}
					}
					setState(164);
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
		public DeclaracaoTipoDadoContext declaracaoTipoDado() {
			return getRuleContext(DeclaracaoTipoDadoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public QuantificadorContext quantificador() {
			return getRuleContext(QuantificadorContext.class,0);
		}
		public DeclaracaoParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoParametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclaracaoParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclaracaoParametro(this);
		}
	}

	public final DeclaracaoParametroContext declaracaoParametro() throws RecognitionException {
		DeclaracaoParametroContext _localctx = new DeclaracaoParametroContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracaoParametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			declaracaoTipoDado();
			setState(169);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(168);
				match(T__8);
				}
			}

			setState(171);
			match(ID);
			setState(172);
			quantificador();
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
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterBlocos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitBlocos(this);
		}
	}

	public final BlocosContext blocos() throws RecognitionException {
		BlocosContext _localctx = new BlocosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blocos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER) | (1L << PR_ESCOLHA) | (1L << PR_CONST) | (1L << PR_RETORNE) | (1L << PR_PARA) | (1L << PR_PARE) | (1L << PR_FACA) | (1L << PR_ENQUANTO) | (1L << PR_SE) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(176);
				switch (_input.LA(1)) {
				case T__0:
				case T__6:
				case T__13:
				case T__14:
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
					setState(174);
					bloco();
					}
					break;
				case PR_REAL:
				case PR_LOGICO:
				case PR_CADEIA:
				case PR_INTEIRO:
				case PR_CARACTER:
				case PR_CONST:
					{
					setState(175);
					declaracoesLocais();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(180);
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
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public PareContext pare() {
			return getRuleContext(PareContext.class,0);
		}
		public RetorneContext retorne() {
			return getRuleContext(RetorneContext.class,0);
		}
		public SeContext se() {
			return getRuleContext(SeContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public FacaEnquantoContext facaEnquanto() {
			return getRuleContext(FacaEnquantoContext.class,0);
		}
		public EscolhaContext escolha() {
			return getRuleContext(EscolhaContext.class,0);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bloco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__13:
			case T__14:
			case OPERADOR_NAO:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(181);
				expressao(0);
				}
				break;
			case PR_PARA:
				{
				setState(182);
				para();
				}
				break;
			case PR_PARE:
				{
				setState(183);
				pare();
				}
				break;
			case PR_RETORNE:
				{
				setState(184);
				retorne();
				}
				break;
			case PR_SE:
				{
				setState(185);
				se();
				}
				break;
			case PR_ENQUANTO:
				{
				setState(186);
				enquanto();
				}
				break;
			case PR_FACA:
				{
				setState(187);
				facaEnquanto();
				}
				break;
			case PR_ESCOLHA:
				{
				setState(188);
				escolha();
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
		public TerminalNode PR_PARA() { return getToken(PortugolParser.PR_PARA, 0); }
		public ListaBlocosContext listaBlocos() {
			return getRuleContext(ListaBlocosContext.class,0);
		}
		public InicializacaoParaContext inicializacaoPara() {
			return getRuleContext(InicializacaoParaContext.class,0);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitPara(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(PR_PARA);
			setState(192);
			match(T__6);
			setState(194);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER) | (1L << PR_CONST) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(193);
				inicializacaoPara();
				}
			}

			setState(196);
			match(T__9);
			setState(198);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(197);
				expressao(0);
				}
			}

			setState(200);
			match(T__9);
			setState(202);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(201);
				expressao(0);
				}
			}

			setState(204);
			match(T__7);
			setState(205);
			listaBlocos();
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
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public InicializacaoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacaoPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterInicializacaoPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitInicializacaoPara(this);
		}
	}

	public final InicializacaoParaContext inicializacaoPara() throws RecognitionException {
		InicializacaoParaContext _localctx = new InicializacaoParaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_inicializacaoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__13:
			case T__14:
			case OPERADOR_NAO:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(207);
				expressao(0);
				}
				break;
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
			case PR_CONST:
				{
				setState(208);
				listaDeclaracoes();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaBlocos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaBlocos(this);
		}
	}

	public final ListaBlocosContext listaBlocos() throws RecognitionException {
		ListaBlocosContext _localctx = new ListaBlocosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listaBlocos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(211);
				match(T__0);
				setState(212);
				blocos();
				setState(213);
				match(T__1);
				}
				break;
			case 2:
				{
				setState(215);
				bloco();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterPare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitPare(this);
		}
	}

	public final PareContext pare() throws RecognitionException {
		PareContext _localctx = new PareContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(PR_PARE);
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
		public TerminalNode PR_ESCOLHA() { return getToken(PortugolParser.PR_ESCOLHA, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> PR_CASO() { return getTokens(PortugolParser.PR_CASO); }
		public TerminalNode PR_CASO(int i) {
			return getToken(PortugolParser.PR_CASO, i);
		}
		public List<BlocosCasoContext> blocosCaso() {
			return getRuleContexts(BlocosCasoContext.class);
		}
		public BlocosCasoContext blocosCaso(int i) {
			return getRuleContext(BlocosCasoContext.class,i);
		}
		public TerminalNode PR_CONTRARIO() { return getToken(PortugolParser.PR_CONTRARIO, 0); }
		public EscolhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escolha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterEscolha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitEscolha(this);
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
			setState(220);
			match(PR_ESCOLHA);
			setState(221);
			match(T__6);
			setState(222);
			expressao(0);
			setState(223);
			match(T__7);
			setState(224);
			match(T__0);
			setState(230); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(225);
					match(PR_CASO);
					setState(226);
					expressao(0);
					setState(227);
					match(T__10);
					setState(228);
					blocosCaso();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(232); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(238);
			_la = _input.LA(1);
			if (_la==PR_CASO) {
				{
				setState(234);
				match(PR_CASO);
				setState(235);
				match(PR_CONTRARIO);
				setState(236);
				match(T__10);
				setState(237);
				blocosCaso();
				}
			}

			setState(240);
			match(T__1);
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
		public BlocosContext blocos() {
			return getRuleContext(BlocosContext.class,0);
		}
		public BlocosCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocosCaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterBlocosCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitBlocosCaso(this);
		}
	}

	public final BlocosCasoContext blocosCaso() throws RecognitionException {
		BlocosCasoContext _localctx = new BlocosCasoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_blocosCaso);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(242);
				match(T__0);
				setState(243);
				blocos();
				setState(244);
				match(T__1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(246);
				blocos();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitEnquanto(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_enquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(PR_ENQUANTO);
			setState(250);
			match(T__6);
			setState(251);
			expressao(0);
			setState(252);
			match(T__7);
			setState(253);
			listaBlocos();
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
		public TerminalNode PR_FACA() { return getToken(PortugolParser.PR_FACA, 0); }
		public ListaBlocosContext listaBlocos() {
			return getRuleContext(ListaBlocosContext.class,0);
		}
		public TerminalNode PR_ENQUANTO() { return getToken(PortugolParser.PR_ENQUANTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public FacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facaEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterFacaEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitFacaEnquanto(this);
		}
	}

	public final FacaEnquantoContext facaEnquanto() throws RecognitionException {
		FacaEnquantoContext _localctx = new FacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_facaEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(PR_FACA);
			setState(256);
			listaBlocos();
			setState(257);
			match(PR_ENQUANTO);
			setState(258);
			match(T__6);
			setState(259);
			expressao(0);
			setState(260);
			match(T__7);
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
		public TerminalNode PR_SE() { return getToken(PortugolParser.PR_SE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<ListaBlocosContext> listaBlocos() {
			return getRuleContexts(ListaBlocosContext.class);
		}
		public ListaBlocosContext listaBlocos(int i) {
			return getRuleContext(ListaBlocosContext.class,i);
		}
		public TerminalNode PR_SENAO() { return getToken(PortugolParser.PR_SENAO, 0); }
		public SeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_se; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitSe(this);
		}
	}

	public final SeContext se() throws RecognitionException {
		SeContext _localctx = new SeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_se);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(PR_SE);
			setState(263);
			match(T__6);
			setState(264);
			expressao(0);
			setState(265);
			match(T__7);
			setState(266);
			listaBlocos();
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(267);
				match(PR_SENAO);
				setState(268);
				listaBlocos();
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
		public TerminalNode PR_RETORNE() { return getToken(PortugolParser.PR_RETORNE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public RetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterRetorne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitRetorne(this);
		}
	}

	public final RetorneContext retorne() throws RecognitionException {
		RetorneContext _localctx = new RetorneContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_retorne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(PR_RETORNE);
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(272);
				expressao(0);
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

	public static class ExpressaoContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ReferenciaContext referencia() {
			return getRuleContext(ReferenciaContext.class,0);
		}
		public TipoPrimitivoContext tipoPrimitivo() {
			return getRuleContext(TipoPrimitivoContext.class,0);
		}
		public MatrizVetorContext matrizVetor() {
			return getRuleContext(MatrizVetorContext.class,0);
		}
		public List<TerminalNode> OPERADOR_NAO() { return getTokens(PortugolParser.OPERADOR_NAO); }
		public TerminalNode OPERADOR_NAO(int i) {
			return getToken(PortugolParser.OPERADOR_NAO, i);
		}
		public TerminalNode ATRIBUICOES() { return getToken(PortugolParser.ATRIBUICOES, 0); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expressao, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case LOGICO:
			case ID:
			case ID_BIBLIOTECA:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(283);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(276);
					match(T__6);
					setState(277);
					expressao(0);
					setState(278);
					match(T__7);
					}
					break;
				case ID:
				case ID_BIBLIOTECA:
					{
					setState(280);
					referencia();
					}
					break;
				case LOGICO:
				case INTEIRO:
				case REAL:
				case CADEIA:
				case CARACTER:
					{
					setState(281);
					tipoPrimitivo();
					}
					break;
				case T__0:
					{
					setState(282);
					matrizVetor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(285);
					_la = _input.LA(1);
					if ( !(_la==T__11 || _la==T__12) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				}
				break;
			case T__13:
			case T__14:
			case OPERADOR_NAO:
				{
				setState(295);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(288);
					match(T__13);
					}
					break;
				case OPERADOR_NAO:
					{
					setState(290); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(289);
							match(OPERADOR_NAO);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(292); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case T__14:
					{
					setState(294);
					match(T__14);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(297);
				expressao(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(324);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(300);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(301);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(302);
						expressao(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(303);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(304);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__18) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(305);
						expressao(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(306);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(308);
						expressao(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(309);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(310);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__21) | (1L << T__22))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(311);
						expressao(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(312);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(313);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(314);
						expressao(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(315);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(316);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(317);
						expressao(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(318);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(319);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(320);
						expressao(3);
						}
						break;
					case 8:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(321);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(322);
						match(ATRIBUICOES);
						setState(323);
						expressao(2);
						}
						break;
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TipoPrimitivoContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(PortugolParser.REAL, 0); }
		public TerminalNode LOGICO() { return getToken(PortugolParser.LOGICO, 0); }
		public TerminalNode CADEIA() { return getToken(PortugolParser.CADEIA, 0); }
		public TerminalNode INTEIRO() { return getToken(PortugolParser.INTEIRO, 0); }
		public TerminalNode CARACTER() { return getToken(PortugolParser.CARACTER, 0); }
		public TipoPrimitivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoPrimitivo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterTipoPrimitivo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitTipoPrimitivo(this);
		}
	}

	public final TipoPrimitivoContext tipoPrimitivo() throws RecognitionException {
		TipoPrimitivoContext _localctx = new TipoPrimitivoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tipoPrimitivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOGICO) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ReferenciaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode ID_BIBLIOTECA() { return getToken(PortugolParser.ID_BIBLIOTECA, 0); }
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public ReferenciaVetorMatrizContext referenciaVetorMatriz() {
			return getRuleContext(ReferenciaVetorMatrizContext.class,0);
		}
		public ReferenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterReferencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitReferencia(this);
		}
	}

	public final ReferenciaContext referencia() throws RecognitionException {
		ReferenciaContext _localctx = new ReferenciaContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_referencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==ID_BIBLIOTECA) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(334);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(332);
				chamadaFuncao();
				}
				break;
			case T__4:
				{
				setState(333);
				referenciaVetorMatriz();
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

	public static class ReferenciaVetorMatrizContext extends ParserRuleContext {
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterReferenciaVetorMatriz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitReferenciaVetorMatriz(this);
		}
	}

	public final ReferenciaVetorMatrizContext referenciaVetorMatriz() throws RecognitionException {
		ReferenciaVetorMatrizContext _localctx = new ReferenciaVetorMatrizContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_referenciaVetorMatriz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(T__4);
			setState(337);
			expressao(0);
			setState(338);
			match(T__5);
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(339);
				match(T__4);
				setState(340);
				expressao(0);
				setState(341);
				match(T__5);
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

	public static class ChamadaFuncaoContext extends ParserRuleContext {
		public ListaParametrosContext listaParametros() {
			return getRuleContext(ListaParametrosContext.class,0);
		}
		public ChamadaFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterChamadaFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitChamadaFuncao(this);
		}
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_chamadaFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__6);
			setState(347);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(346);
				listaParametros();
				}
			}

			setState(349);
			match(T__7);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaParametros(this);
		}
	}

	public final ListaParametrosContext listaParametros() throws RecognitionException {
		ListaParametrosContext _localctx = new ListaParametrosContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_listaParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(351);
			expressao(0);
			}
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(352);
				match(T__3);
				setState(353);
				expressao(0);
				}
				}
				setState(358);
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
		public MatrizContext matriz() {
			return getRuleContext(MatrizContext.class,0);
		}
		public VetorContext vetor() {
			return getRuleContext(VetorContext.class,0);
		}
		public MatrizVetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrizVetor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterMatrizVetor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitMatrizVetor(this);
		}
	}

	public final MatrizVetorContext matrizVetor() throws RecognitionException {
		MatrizVetorContext _localctx = new MatrizVetorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_matrizVetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(359);
				matriz();
				}
				break;
			case 2:
				{
				setState(360);
				vetor();
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
		public ListaExpressoesContext listaExpressoes() {
			return getRuleContext(ListaExpressoesContext.class,0);
		}
		public VetorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vetor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterVetor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitVetor(this);
		}
	}

	public final VetorContext vetor() throws RecognitionException {
		VetorContext _localctx = new VetorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_vetor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(T__0);
			setState(364);
			listaExpressoes();
			setState(365);
			match(T__1);
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
		public ListaListaExpressoesContext listaListaExpressoes() {
			return getRuleContext(ListaListaExpressoesContext.class,0);
		}
		public MatrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matriz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterMatriz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitMatriz(this);
		}
	}

	public final MatrizContext matriz() throws RecognitionException {
		MatrizContext _localctx = new MatrizContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_matriz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__0);
			setState(368);
			listaListaExpressoes();
			setState(369);
			match(T__1);
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
		public List<ListaExpressoesContext> listaExpressoes() {
			return getRuleContexts(ListaExpressoesContext.class);
		}
		public ListaExpressoesContext listaExpressoes(int i) {
			return getRuleContext(ListaExpressoesContext.class,i);
		}
		public ListaListaExpressoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaListaExpressoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaListaExpressoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaListaExpressoes(this);
		}
	}

	public final ListaListaExpressoesContext listaListaExpressoes() throws RecognitionException {
		ListaListaExpressoesContext _localctx = new ListaListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_listaListaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(371);
				match(T__0);
				setState(372);
				listaExpressoes();
				setState(373);
				match(T__1);
				}
			}

			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(377);
				match(T__3);
				setState(378);
				match(T__0);
				setState(379);
				listaExpressoes();
				setState(380);
				match(T__1);
				}
				}
				setState(386);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterListaExpressoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitListaExpressoes(this);
		}
	}

	public final ListaExpressoesContext listaExpressoes() throws RecognitionException {
		ListaExpressoesContext _localctx = new ListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_listaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(388);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__13) | (1L << T__14) | (1L << OPERADOR_NAO) | (1L << LOGICO) | (1L << ID) | (1L << ID_BIBLIOTECA) | (1L << INTEIRO) | (1L << REAL) | (1L << CADEIA) | (1L << CARACTER))) != 0)) {
				{
				setState(387);
				expressao(0);
				}
			}

			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(390);
				match(T__3);
				{
				setState(391);
				expressao(0);
				}
				}
				}
				setState(396);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u0190\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2"+
		"\3\2\7\2U\n\2\f\2\16\2X\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3a\n\3\3\4"+
		"\3\4\3\5\3\5\3\6\5\6h\n\6\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\7"+
		"\3\7\3\7\5\7v\n\7\3\7\3\7\3\7\5\7{\n\7\3\7\5\7~\n\7\5\7\u0080\n\7\3\7"+
		"\5\7\u0083\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u008d\n\n\5\n\u008f"+
		"\n\n\3\13\3\13\5\13\u0093\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\7\r\u00a3\n\r\f\r\16\r\u00a6\13\r\5\r\u00a8\n\r\3\16"+
		"\3\16\5\16\u00ac\n\16\3\16\3\16\3\16\3\17\3\17\7\17\u00b3\n\17\f\17\16"+
		"\17\u00b6\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c0\n\20"+
		"\3\21\3\21\3\21\5\21\u00c5\n\21\3\21\3\21\5\21\u00c9\n\21\3\21\3\21\5"+
		"\21\u00cd\n\21\3\21\3\21\3\21\3\22\3\22\5\22\u00d4\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00db\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\6\25\u00e9\n\25\r\25\16\25\u00ea\3\25\3\25\3\25\3\25\5"+
		"\25\u00f1\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00fa\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0110\n\31\3\32\3\32\5\32\u0114\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u011e\n\33\3\33\5\33\u0121"+
		"\n\33\3\33\3\33\6\33\u0125\n\33\r\33\16\33\u0126\3\33\5\33\u012a\n\33"+
		"\3\33\5\33\u012d\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u0147\n\33\f\33\16\33\u014a\13\33\3\34\3\34\3\35\3\35\3\35\5\35"+
		"\u0151\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u015a\n\36\3\37\3"+
		"\37\5\37\u015e\n\37\3\37\3\37\3 \3 \3 \7 \u0165\n \f \16 \u0168\13 \3"+
		"!\3!\5!\u016c\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\5$\u017a\n$\3"+
		"$\3$\3$\3$\3$\7$\u0181\n$\f$\16$\u0184\13$\3%\5%\u0187\n%\3%\3%\7%\u018b"+
		"\n%\f%\16%\u018e\13%\3%\2\3\64&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFH\2\r\4\2##%(\3\2\16\17\3\2\22\24\4\2\20"+
		"\20\25\25\3\2\26\27\4\2\13\13\30\31\3\2\32\35\3\2\36\37\3\2 !\4\299<?"+
		"\3\2:;\u01a9\2J\3\2\2\2\4[\3\2\2\2\6b\3\2\2\2\bd\3\2\2\2\ng\3\2\2\2\f"+
		"r\3\2\2\2\16\u0084\3\2\2\2\20\u0086\3\2\2\2\22\u008e\3\2\2\2\24\u0092"+
		"\3\2\2\2\26\u0094\3\2\2\2\30\u00a7\3\2\2\2\32\u00a9\3\2\2\2\34\u00b4\3"+
		"\2\2\2\36\u00bf\3\2\2\2 \u00c1\3\2\2\2\"\u00d3\3\2\2\2$\u00da\3\2\2\2"+
		"&\u00dc\3\2\2\2(\u00de\3\2\2\2*\u00f9\3\2\2\2,\u00fb\3\2\2\2.\u0101\3"+
		"\2\2\2\60\u0108\3\2\2\2\62\u0111\3\2\2\2\64\u012c\3\2\2\2\66\u014b\3\2"+
		"\2\28\u014d\3\2\2\2:\u0152\3\2\2\2<\u015b\3\2\2\2>\u0161\3\2\2\2@\u016b"+
		"\3\2\2\2B\u016d\3\2\2\2D\u0171\3\2\2\2F\u0179\3\2\2\2H\u0186\3\2\2\2J"+
		"K\7\"\2\2KO\7\3\2\2LN\5\4\3\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2"+
		"PV\3\2\2\2QO\3\2\2\2RU\5\6\4\2SU\5\26\f\2TR\3\2\2\2TS\3\2\2\2UX\3\2\2"+
		"\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\4\2\2Z\3\3\2\2\2[\\\7\65"+
		"\2\2\\]\7\66\2\2]`\7:\2\2^_\7\5\2\2_a\7:\2\2`^\3\2\2\2`a\3\2\2\2a\5\3"+
		"\2\2\2bc\5\n\6\2c\7\3\2\2\2de\5\n\6\2e\t\3\2\2\2fh\7,\2\2gf\3\2\2\2gh"+
		"\3\2\2\2hi\3\2\2\2ij\5\16\b\2jo\5\f\7\2kl\7\6\2\2ln\5\f\7\2mk\3\2\2\2"+
		"nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\13\3\2\2\2qo\3\2\2\2r\177\7:\2\2su\7\7"+
		"\2\2tv\5\64\33\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2w}\7\b\2\2xz\7\7\2\2y{\5"+
		"\64\33\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\7\b\2\2}x\3\2\2\2}~\3\2\2\2~"+
		"\u0080\3\2\2\2\177s\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081"+
		"\u0083\5\64\33\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\r\3\2\2"+
		"\2\u0084\u0085\t\2\2\2\u0085\17\3\2\2\2\u0086\u0087\7$\2\2\u0087\21\3"+
		"\2\2\2\u0088\u0089\7\7\2\2\u0089\u008c\7\b\2\2\u008a\u008b\7\7\2\2\u008b"+
		"\u008d\7\b\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u0088\3\2\2\2\u008e\u008f\3\2\2\2\u008f\23\3\2\2\2\u0090\u0093"+
		"\5\16\b\2\u0091\u0093\5\20\t\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\25\3\2\2\2\u0094\u0095\7-\2\2\u0095\u0096\5"+
		"\24\13\2\u0096\u0097\5\22\n\2\u0097\u0098\7:\2\2\u0098\u0099\7\t\2\2\u0099"+
		"\u009a\5\30\r\2\u009a\u009b\7\n\2\2\u009b\u009c\7\3\2\2\u009c\u009d\5"+
		"\34\17\2\u009d\u009e\7\4\2\2\u009e\27\3\2\2\2\u009f\u00a4\5\32\16\2\u00a0"+
		"\u00a1\7\6\2\2\u00a1\u00a3\5\32\16\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3"+
		"\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\31\3\2\2"+
		"\2\u00a9\u00ab\5\16\b\2\u00aa\u00ac\7\13\2\2\u00ab\u00aa\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7:\2\2\u00ae\u00af\5\22"+
		"\n\2\u00af\33\3\2\2\2\u00b0\u00b3\5\36\20\2\u00b1\u00b3\5\b\5\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\35\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00c0"+
		"\5\64\33\2\u00b8\u00c0\5 \21\2\u00b9\u00c0\5&\24\2\u00ba\u00c0\5\62\32"+
		"\2\u00bb\u00c0\5\60\31\2\u00bc\u00c0\5,\27\2\u00bd\u00c0\5.\30\2\u00be"+
		"\u00c0\5(\25\2\u00bf\u00b7\3\2\2\2\u00bf\u00b8\3\2\2\2\u00bf\u00b9\3\2"+
		"\2\2\u00bf\u00ba\3\2\2\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\37\3\2\2\2\u00c1\u00c2\7/\2\2"+
		"\u00c2\u00c4\7\t\2\2\u00c3\u00c5\5\"\22\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\7\f\2\2\u00c7\u00c9\5\64\33\2"+
		"\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc"+
		"\7\f\2\2\u00cb\u00cd\5\64\33\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\5$\23\2\u00d0!\3"+
		"\2\2\2\u00d1\u00d4\5\64\33\2\u00d2\u00d4\5\n\6\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d2\3\2\2\2\u00d4#\3\2\2\2\u00d5\u00d6\7\3\2\2\u00d6\u00d7\5\34\17"+
		"\2\u00d7\u00d8\7\4\2\2\u00d8\u00db\3\2\2\2\u00d9\u00db\5\36\20\2\u00da"+
		"\u00d5\3\2\2\2\u00da\u00d9\3\2\2\2\u00db%\3\2\2\2\u00dc\u00dd\7\60\2\2"+
		"\u00dd\'\3\2\2\2\u00de\u00df\7)\2\2\u00df\u00e0\7\t\2\2\u00e0\u00e1\5"+
		"\64\33\2\u00e1\u00e2\7\n\2\2\u00e2\u00e8\7\3\2\2\u00e3\u00e4\7*\2\2\u00e4"+
		"\u00e5\5\64\33\2\u00e5\u00e6\7\r\2\2\u00e6\u00e7\5*\26\2\u00e7\u00e9\3"+
		"\2\2\2\u00e8\u00e3\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00f0\3\2\2\2\u00ec\u00ed\7*\2\2\u00ed\u00ee\7+\2"+
		"\2\u00ee\u00ef\7\r\2\2\u00ef\u00f1\5*\26\2\u00f0\u00ec\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7\4\2\2\u00f3)\3\2\2\2\u00f4"+
		"\u00f5\7\3\2\2\u00f5\u00f6\5\34\17\2\u00f6\u00f7\7\4\2\2\u00f7\u00fa\3"+
		"\2\2\2\u00f8\u00fa\5\34\17\2\u00f9\u00f4\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"+\3\2\2\2\u00fb\u00fc\7\62\2\2\u00fc\u00fd\7\t\2\2\u00fd\u00fe\5\64\33"+
		"\2\u00fe\u00ff\7\n\2\2\u00ff\u0100\5$\23\2\u0100-\3\2\2\2\u0101\u0102"+
		"\7\61\2\2\u0102\u0103\5$\23\2\u0103\u0104\7\62\2\2\u0104\u0105\7\t\2\2"+
		"\u0105\u0106\5\64\33\2\u0106\u0107\7\n\2\2\u0107/\3\2\2\2\u0108\u0109"+
		"\7\63\2\2\u0109\u010a\7\t\2\2\u010a\u010b\5\64\33\2\u010b\u010c\7\n\2"+
		"\2\u010c\u010f\5$\23\2\u010d\u010e\7\64\2\2\u010e\u0110\5$\23\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\61\3\2\2\2\u0111\u0113\7.\2\2"+
		"\u0112\u0114\5\64\33\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\63"+
		"\3\2\2\2\u0115\u011d\b\33\1\2\u0116\u0117\7\t\2\2\u0117\u0118\5\64\33"+
		"\2\u0118\u0119\7\n\2\2\u0119\u011e\3\2\2\2\u011a\u011e\58\35\2\u011b\u011e"+
		"\5\66\34\2\u011c\u011e\5@!\2\u011d\u0116\3\2\2\2\u011d\u011a\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u0121\t\3"+
		"\2\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u012d\3\2\2\2\u0122"+
		"\u012a\7\20\2\2\u0123\u0125\78\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u012a\7\21\2\2\u0129\u0122\3\2\2\2\u0129\u0124\3\2\2\2\u0129\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\5\64\33\13\u012c\u0115\3\2\2\2"+
		"\u012c\u0129\3\2\2\2\u012d\u0148\3\2\2\2\u012e\u012f\f\n\2\2\u012f\u0130"+
		"\t\4\2\2\u0130\u0147\5\64\33\13\u0131\u0132\f\t\2\2\u0132\u0133\t\5\2"+
		"\2\u0133\u0147\5\64\33\n\u0134\u0135\f\b\2\2\u0135\u0136\t\6\2\2\u0136"+
		"\u0147\5\64\33\t\u0137\u0138\f\7\2\2\u0138\u0139\t\7\2\2\u0139\u0147\5"+
		"\64\33\b\u013a\u013b\f\6\2\2\u013b\u013c\t\b\2\2\u013c\u0147\5\64\33\7"+
		"\u013d\u013e\f\5\2\2\u013e\u013f\t\t\2\2\u013f\u0147\5\64\33\6\u0140\u0141"+
		"\f\4\2\2\u0141\u0142\t\n\2\2\u0142\u0147\5\64\33\5\u0143\u0144\f\3\2\2"+
		"\u0144\u0145\7A\2\2\u0145\u0147\5\64\33\4\u0146\u012e\3\2\2\2\u0146\u0131"+
		"\3\2\2\2\u0146\u0134\3\2\2\2\u0146\u0137\3\2\2\2\u0146\u013a\3\2\2\2\u0146"+
		"\u013d\3\2\2\2\u0146\u0140\3\2\2\2\u0146\u0143\3\2\2\2\u0147\u014a\3\2"+
		"\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\65\3\2\2\2\u014a\u0148"+
		"\3\2\2\2\u014b\u014c\t\13\2\2\u014c\67\3\2\2\2\u014d\u0150\t\f\2\2\u014e"+
		"\u0151\5<\37\2\u014f\u0151\5:\36\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2"+
		"\2\2\u01519\3\2\2\2\u0152\u0153\7\7\2\2\u0153\u0154\5\64\33\2\u0154\u0159"+
		"\7\b\2\2\u0155\u0156\7\7\2\2\u0156\u0157\5\64\33\2\u0157\u0158\7\b\2\2"+
		"\u0158\u015a\3\2\2\2\u0159\u0155\3\2\2\2\u0159\u015a\3\2\2\2\u015a;\3"+
		"\2\2\2\u015b\u015d\7\t\2\2\u015c\u015e\5> \2\u015d\u015c\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\7\n\2\2\u0160=\3\2\2\2"+
		"\u0161\u0166\5\64\33\2\u0162\u0163\7\6\2\2\u0163\u0165\5\64\33\2\u0164"+
		"\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167?\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016c\5D#\2\u016a\u016c"+
		"\5B\"\2\u016b\u0169\3\2\2\2\u016b\u016a\3\2\2\2\u016cA\3\2\2\2\u016d\u016e"+
		"\7\3\2\2\u016e\u016f\5H%\2\u016f\u0170\7\4\2\2\u0170C\3\2\2\2\u0171\u0172"+
		"\7\3\2\2\u0172\u0173\5F$\2\u0173\u0174\7\4\2\2\u0174E\3\2\2\2\u0175\u0176"+
		"\7\3\2\2\u0176\u0177\5H%\2\u0177\u0178\7\4\2\2\u0178\u017a\3\2\2\2\u0179"+
		"\u0175\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0182\3\2\2\2\u017b\u017c\7\6"+
		"\2\2\u017c\u017d\7\3\2\2\u017d\u017e\5H%\2\u017e\u017f\7\4\2\2\u017f\u0181"+
		"\3\2\2\2\u0180\u017b\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183G\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0187\5\64\33"+
		"\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018c\3\2\2\2\u0188\u0189"+
		"\7\6\2\2\u0189\u018b\5\64\33\2\u018a\u0188\3\2\2\2\u018b\u018e\3\2\2\2"+
		"\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018dI\3\2\2\2\u018e\u018c\3"+
		"\2\2\2\60OTV`gouz}\177\u0082\u008c\u008e\u0092\u00a4\u00a7\u00ab\u00b2"+
		"\u00b4\u00bf\u00c4\u00c8\u00cc\u00d3\u00da\u00ea\u00f0\u00f9\u010f\u0113"+
		"\u011d\u0120\u0126\u0129\u012c\u0146\u0148\u0150\u0159\u015d\u0166\u016b"+
		"\u0179\u0182\u0186\u018c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}