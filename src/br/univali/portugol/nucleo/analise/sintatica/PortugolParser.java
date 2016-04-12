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
			setState(113); match(ID);
			setState(116);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(114); match(37);
				setState(115); match(ID);
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
			setState(118); listaDeclaracoes();
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
			setState(120); listaDeclaracoes();
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
				setState(122); match(PR_CONST);
				}
			}

			setState(125); declaracaoTipoDado();
			{
			setState(126); declaracao();
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(127); match(24);
				setState(128); declaracao();
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
				setState(135); match(28);
				setState(137);
				_la = _input.LA(1);
				if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
					{
					setState(136); expressao();
					}
				}

				setState(139); match(34);
				setState(145);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(140); match(28);
					setState(142);
					_la = _input.LA(1);
					if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
						{
						setState(141); expressao();
						}
					}

					setState(144); match(34);
					}
				}

				}
			}

			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(149); expressao();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER))) != 0)) ) {
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
			setState(154); match(PR_VAZIO);
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
			setState(162);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(156); match(28);
				setState(157); match(34);
				setState(160);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(158); match(28);
					setState(159); match(34);
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
			setState(166);
			switch (_input.LA(1)) {
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
				{
				setState(164); declaracaoTipoDado();
				}
				break;
			case PR_VAZIO:
				{
				setState(165); declaracaoTipoDadoVazio();
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
			setState(168); match(PR_FUNCAO);
			setState(169); tipoRetornoFuncao();
			setState(170); quantificador();
			setState(171); match(ID);
			setState(172); match(21);
			setState(173); listaParametrosFuncao();
			setState(174); match(40);
			setState(175); match(9);
			setState(176); blocos();
			setState(177); match(14);
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
			setState(187);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PR_REAL) | (1L << PR_LOGICO) | (1L << PR_CADEIA) | (1L << PR_INTEIRO) | (1L << PR_CARACTER))) != 0)) {
				{
				{
				setState(179); declaracaoParametro();
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(180); match(24);
					setState(181); declaracaoParametro();
					}
					}
					setState(186);
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
			setState(189); declaracaoTipoDado();
			setState(191);
			_la = _input.LA(1);
			if (_la==20) {
				{
				setState(190); match(20);
				}
			}

			setState(193); match(ID);
			setState(194); quantificador();
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
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (PR_REAL - 9)) | (1L << (PR_LOGICO - 9)) | (1L << (PR_CADEIA - 9)) | (1L << (PR_INTEIRO - 9)) | (1L << (PR_CARACTER - 9)) | (1L << (PR_ESCOLHA - 9)) | (1L << (PR_CONST - 9)) | (1L << (PR_RETORNE - 9)) | (1L << (PR_PARA - 9)) | (1L << (PR_PARE - 9)) | (1L << (PR_FACA - 9)) | (1L << (PR_ENQUANTO - 9)) | (1L << (PR_SE - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(198);
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
					setState(196); bloco();
					}
					break;
				case PR_REAL:
				case PR_LOGICO:
				case PR_CADEIA:
				case PR_INTEIRO:
				case PR_CARACTER:
				case PR_CONST:
					{
					setState(197); declaracoesLocais();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(202);
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
			setState(211);
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
				setState(203); expressao();
				}
				break;
			case PR_PARA:
				{
				setState(204); para();
				}
				break;
			case PR_PARE:
				{
				setState(205); pare();
				}
				break;
			case PR_RETORNE:
				{
				setState(206); retorne();
				}
				break;
			case PR_SE:
				{
				setState(207); se();
				}
				break;
			case PR_ENQUANTO:
				{
				setState(208); enquanto();
				}
				break;
			case PR_FACA:
				{
				setState(209); facaEnquanto();
				}
				break;
			case PR_ESCOLHA:
				{
				setState(210); escolha();
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
			setState(213); match(PR_PARA);
			setState(214); match(21);
			setState(216);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (PR_REAL - 9)) | (1L << (PR_LOGICO - 9)) | (1L << (PR_CADEIA - 9)) | (1L << (PR_INTEIRO - 9)) | (1L << (PR_CARACTER - 9)) | (1L << (PR_CONST - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(215); inicializacaoPara();
				}
			}

			setState(218); match(8);
			setState(220);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(219); expressao();
				}
			}

			setState(222); match(8);
			setState(224);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(223); expressao();
				}
			}

			setState(226); match(40);
			setState(227); listaBlocos();
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
			setState(231);
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
				setState(229); expressao();
				}
				break;
			case PR_REAL:
			case PR_LOGICO:
			case PR_CADEIA:
			case PR_INTEIRO:
			case PR_CARACTER:
			case PR_CONST:
				{
				setState(230); listaDeclaracoes();
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
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(233); match(9);
				setState(234); blocos();
				setState(235); match(14);
				}
				break;

			case 2:
				{
				setState(237); bloco();
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
			setState(240); match(PR_PARE);
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
			setState(242); match(PR_ESCOLHA);
			setState(243); match(21);
			setState(244); expressao();
			setState(245); match(40);
			setState(246); match(9);
			setState(252); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(247); match(PR_CASO);
					setState(248); expressao();
					setState(249); match(26);
					setState(250); blocosCaso();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(254); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(260);
			_la = _input.LA(1);
			if (_la==PR_CASO) {
				{
				setState(256); match(PR_CASO);
				setState(257); match(PR_CONTRARIO);
				setState(258); match(26);
				setState(259); blocosCaso();
				}
			}

			setState(262); match(14);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PortugolVisitor ) return ((PortugolVisitor<? extends T>)visitor).visitBlocosCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocosCasoContext blocosCaso() throws RecognitionException {
		BlocosCasoContext _localctx = new BlocosCasoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_blocosCaso);
		try {
			setState(269);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(264); match(9);
				setState(265); blocos();
				setState(266); match(14);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(268); blocos();
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
			setState(271); match(PR_ENQUANTO);
			setState(272); match(21);
			setState(273); expressao();
			setState(274); match(40);
			setState(275); listaBlocos();
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
			setState(277); match(PR_FACA);
			setState(278); listaBlocos();
			setState(279); match(PR_ENQUANTO);
			setState(280); match(21);
			setState(281); expressao();
			setState(282); match(40);
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
			setState(284); match(PR_SE);
			setState(285); match(21);
			setState(286); expressao();
			setState(287); match(40);
			setState(288); listaBlocos();
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(289); match(PR_SENAO);
				setState(290); listaBlocos();
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
			setState(293); match(PR_RETORNE);
			setState(295);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(294); expressao();
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
			setState(299); expressao2();
			setState(300); pilha();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 7) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 18) | (1L << 23) | (1L << 25))) != 0)) {
				{
				{
				setState(301);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 7) | (1L << 12) | (1L << 13) | (1L << 16) | (1L << 18) | (1L << 23) | (1L << 25))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(302); expressao2();
				}
				}
				setState(307);
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
			setState(308); expressao2_5();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19 || _la==39) {
				{
				{
				setState(309);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==39) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(310); expressao2_5();
				}
				}
				setState(315);
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
			setState(316); expressao3();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==33) {
				{
				{
				setState(317);
				_la = _input.LA(1);
				if ( !(_la==6 || _la==33) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(318); expressao3();
				}
				}
				setState(323);
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
			setState(324); expressao3_5();
			setState(327);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 27) | (1L << 32) | (1L << 36))) != 0)) {
				{
				setState(325);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 27) | (1L << 32) | (1L << 36))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(326); expressao3_5();
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
			setState(329); expressao4_5();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 20) | (1L << 31))) != 0)) {
				{
				{
				setState(330);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 20) | (1L << 31))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(331); expressao4_5();
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

	public static class Expressao4_5Context extends ParserRuleContext {
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
			setState(337); expressao5();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10 || _la==11) {
				{
				{
				setState(338);
				_la = _input.LA(1);
				if ( !(_la==10 || _la==11) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(339); expressao5();
				}
				}
				setState(344);
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
			setState(345); expressao6();
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(350);
					switch (_input.LA(1)) {
					case 41:
						{
						{
						setState(346); match(41);
						setState(347); expressao6();
						}
						}
						break;
					case 42:
						{
						{
						setState(348); match(42);
						setState(349); expressao6();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
			setState(355); expressao7();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 22) | (1L << 38))) != 0)) {
				{
				{
				setState(356);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 22) | (1L << 38))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(357); expressao7();
				}
				}
				setState(362);
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
			setState(373);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(364);
				_la = _input.LA(1);
				if (_la==42) {
					{
					setState(363); ((Expressao7Context)_localctx).s42 = match(42);
					((Expressao7Context)_localctx).listaTokenMenos.add(((Expressao7Context)_localctx).s42);
					}
				}

				}
				break;

			case 2:
				{
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPERADOR_NAO) {
					{
					{
					setState(366); ((Expressao7Context)_localctx).OPERADOR_NAO = match(OPERADOR_NAO);
					((Expressao7Context)_localctx).listaTokenNao.add(((Expressao7Context)_localctx).OPERADOR_NAO);
					}
					}
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 3:
				{
				setState(372); ((Expressao7Context)_localctx).s35 = match(35);
				((Expressao7Context)_localctx).listaTokenNot.add(((Expressao7Context)_localctx).s35);
				}
				break;
			}
			setState(375); expressao8();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			switch (_input.LA(1)) {
			case 21:
				{
				setState(377); match(21);
				setState(378); expressao();
				setState(379); match(40);
				}
				break;
			case ID:
			case ID_BIBLIOTECA:
				{
				setState(381); referencia();
				}
				break;
			case LOGICO:
			case INTEIRO:
			case REAL:
			case CADEIA:
			case CARACTER:
				{
				setState(382); tipoPrimitivo();
				}
				break;
			case 9:
				{
				setState(383); matrizVetor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(387);
			_la = _input.LA(1);
			if (_la==29 || _la==30) {
				{
				setState(386);
				_la = _input.LA(1);
				if ( !(_la==29 || _la==30) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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
			setState(389);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==ID_BIBLIOTECA) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(395);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(392); chamadaFuncao();
				}
				break;

			case 2:
				{
				setState(393); referenciaVetorMatriz();
				}
				break;

			case 3:
				{
				setState(394); referenciaId();
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
			setState(399); match(28);
			setState(400); expressao();
			setState(401); match(34);
			setState(406);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(402); match(28);
				setState(403); expressao();
				setState(404); match(34);
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
			setState(408); match(21);
			setState(410);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(409); listaParametros();
				}
			}

			setState(412); match(40);
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
			setState(414); expressao();
			}
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(415); match(24);
				setState(416); expressao();
				}
				}
				setState(421);
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
			setState(424);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(422); matriz();
				}
				break;

			case 2:
				{
				setState(423); vetor();
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
			setState(426); match(9);
			setState(427); listaExpressoes();
			setState(428); match(14);
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
			setState(430); match(9);
			setState(431); listaListaExpressoes();
			setState(432); match(14);
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
			setState(438);
			_la = _input.LA(1);
			if (_la==9) {
				{
				setState(434); match(9);
				setState(435); listaExpressoes();
				setState(436); match(14);
				}
			}

			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(440); match(24);
				setState(441); match(9);
				setState(442); listaExpressoes();
				setState(443); match(14);
				}
				}
				setState(449);
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
			setState(451);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (21 - 9)) | (1L << (35 - 9)) | (1L << (42 - 9)) | (1L << (OPERADOR_NAO - 9)) | (1L << (LOGICO - 9)) | (1L << (ID - 9)) | (1L << (ID_BIBLIOTECA - 9)) | (1L << (INTEIRO - 9)) | (1L << (REAL - 9)) | (1L << (CADEIA - 9)) | (1L << (CARACTER - 9)))) != 0)) {
				{
				setState(450); expressao();
				}
			}

			}
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(453); match(24);
				{
				setState(454); expressao();
				}
				}
				}
				setState(459);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3L\u01cf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3w\n\3\3"+
		"\4\3\4\3\5\3\5\3\6\5\6~\n\6\3\6\3\6\3\6\3\6\7\6\u0084\n\6\f\6\16\6\u0087"+
		"\13\6\3\7\3\7\3\7\5\7\u008c\n\7\3\7\3\7\3\7\5\7\u0091\n\7\3\7\5\7\u0094"+
		"\n\7\5\7\u0096\n\7\3\7\5\7\u0099\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5"+
		"\n\u00a3\n\n\5\n\u00a5\n\n\3\13\3\13\5\13\u00a9\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00b9\n\r\f\r\16\r\u00bc\13"+
		"\r\5\r\u00be\n\r\3\16\3\16\5\16\u00c2\n\16\3\16\3\16\3\16\3\17\3\17\7"+
		"\17\u00c9\n\17\f\17\16\17\u00cc\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00d6\n\20\3\21\3\21\3\21\5\21\u00db\n\21\3\21\3\21\5\21"+
		"\u00df\n\21\3\21\3\21\5\21\u00e3\n\21\3\21\3\21\3\21\3\22\3\22\5\22\u00ea"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00f1\n\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\6\25\u00ff\n\25\r\25\16\25\u0100\3"+
		"\25\3\25\3\25\3\25\5\25\u0107\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0110\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0126\n\31\3\32\3\32"+
		"\5\32\u012a\n\32\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u0132\n\34\f\34\16"+
		"\34\u0135\13\34\3\35\3\35\3\35\7\35\u013a\n\35\f\35\16\35\u013d\13\35"+
		"\3\36\3\36\3\36\7\36\u0142\n\36\f\36\16\36\u0145\13\36\3\37\3\37\3\37"+
		"\5\37\u014a\n\37\3 \3 \3 \7 \u014f\n \f \16 \u0152\13 \3!\3!\3!\7!\u0157"+
		"\n!\f!\16!\u015a\13!\3\"\3\"\3\"\3\"\3\"\7\"\u0161\n\"\f\"\16\"\u0164"+
		"\13\"\3#\3#\3#\7#\u0169\n#\f#\16#\u016c\13#\3$\5$\u016f\n$\3$\7$\u0172"+
		"\n$\f$\16$\u0175\13$\3$\5$\u0178\n$\3$\3$\3%\3%\3%\3%\3%\3%\3%\5%\u0183"+
		"\n%\3%\5%\u0186\n%\3&\3&\3\'\3\'\3\'\3\'\5\'\u018e\n\'\3(\3(\3)\3)\3)"+
		"\3)\3)\3)\3)\5)\u0199\n)\3*\3*\5*\u019d\n*\3*\3*\3+\3+\3+\7+\u01a4\n+"+
		"\f+\16+\u01a7\13+\3,\3,\5,\u01ab\n,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\5/\u01b9\n/\3/\3/\3/\3/\3/\7/\u01c0\n/\f/\16/\u01c3\13/\3\60\5\60\u01c6"+
		"\n\60\3\60\3\60\7\60\u01ca\n\60\f\60\16\60\u01cd\13\60\3\60\2\61\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^\2\r\4\2..\60\63\t\2\4\7\t\t\16\17\22\22\24\24\31\31\33\33\4\2\25"+
		"\25))\4\2\b\b##\6\2\23\23\35\35\"\"&&\5\2\21\21\26\26!!\3\2\f\r\5\2\3"+
		"\3\30\30((\3\2\37 \4\2DDGJ\3\2EF\u01df\2`\3\2\2\2\4q\3\2\2\2\6x\3\2\2"+
		"\2\bz\3\2\2\2\n}\3\2\2\2\f\u0088\3\2\2\2\16\u009a\3\2\2\2\20\u009c\3\2"+
		"\2\2\22\u00a4\3\2\2\2\24\u00a8\3\2\2\2\26\u00aa\3\2\2\2\30\u00bd\3\2\2"+
		"\2\32\u00bf\3\2\2\2\34\u00ca\3\2\2\2\36\u00d5\3\2\2\2 \u00d7\3\2\2\2\""+
		"\u00e9\3\2\2\2$\u00f0\3\2\2\2&\u00f2\3\2\2\2(\u00f4\3\2\2\2*\u010f\3\2"+
		"\2\2,\u0111\3\2\2\2.\u0117\3\2\2\2\60\u011e\3\2\2\2\62\u0127\3\2\2\2\64"+
		"\u012b\3\2\2\2\66\u012d\3\2\2\28\u0136\3\2\2\2:\u013e\3\2\2\2<\u0146\3"+
		"\2\2\2>\u014b\3\2\2\2@\u0153\3\2\2\2B\u015b\3\2\2\2D\u0165\3\2\2\2F\u0177"+
		"\3\2\2\2H\u0182\3\2\2\2J\u0187\3\2\2\2L\u0189\3\2\2\2N\u018f\3\2\2\2P"+
		"\u0191\3\2\2\2R\u019a\3\2\2\2T\u01a0\3\2\2\2V\u01aa\3\2\2\2X\u01ac\3\2"+
		"\2\2Z\u01b0\3\2\2\2\\\u01b8\3\2\2\2^\u01c5\3\2\2\2`a\7-\2\2ae\7\13\2\2"+
		"bd\5\4\3\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fl\3\2\2\2ge\3\2\2\2"+
		"hk\5\6\4\2ik\5\26\f\2jh\3\2\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2mo\3\2\2\2nl\3\2\2\2op\7\20\2\2p\3\3\2\2\2qr\7@\2\2rs\7A\2\2sv\7E\2"+
		"\2tu\7\'\2\2uw\7E\2\2vt\3\2\2\2vw\3\2\2\2w\5\3\2\2\2xy\5\n\6\2y\7\3\2"+
		"\2\2z{\5\n\6\2{\t\3\2\2\2|~\7\67\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2"+
		"\177\u0080\5\16\b\2\u0080\u0085\5\f\7\2\u0081\u0082\7\32\2\2\u0082\u0084"+
		"\5\f\7\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\13\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0095\7E\2\2"+
		"\u0089\u008b\7\36\2\2\u008a\u008c\5\66\34\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0093\7$\2\2\u008e\u0090\7\36"+
		"\2\2\u008f\u0091\5\66\34\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0094\7$\2\2\u0093\u008e\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0099\5\66\34\2\u0098\u0097\3\2\2\2\u0098\u0099\3"+
		"\2\2\2\u0099\r\3\2\2\2\u009a\u009b\t\2\2\2\u009b\17\3\2\2\2\u009c\u009d"+
		"\7/\2\2\u009d\21\3\2\2\2\u009e\u009f\7\36\2\2\u009f\u00a2\7$\2\2\u00a0"+
		"\u00a1\7\36\2\2\u00a1\u00a3\7$\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\23\3\2\2\2\u00a6\u00a9\5\16\b\2\u00a7\u00a9\5\20\t\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\25\3\2\2\2\u00aa\u00ab"+
		"\78\2\2\u00ab\u00ac\5\24\13\2\u00ac\u00ad\5\22\n\2\u00ad\u00ae\7E\2\2"+
		"\u00ae\u00af\7\27\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7*\2\2\u00b1\u00b2"+
		"\7\13\2\2\u00b2\u00b3\5\34\17\2\u00b3\u00b4\7\20\2\2\u00b4\27\3\2\2\2"+
		"\u00b5\u00ba\5\32\16\2\u00b6\u00b7\7\32\2\2\u00b7\u00b9\5\32\16\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00c1\5\16\b\2\u00c0\u00c2\7\26"+
		"\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\7E\2\2\u00c4\u00c5\5\22\n\2\u00c5\33\3\2\2\2\u00c6\u00c9\5\36\20"+
		"\2\u00c7\u00c9\5\b\5\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\35\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00d6\5\66\34\2\u00ce\u00d6\5 \21\2\u00cf\u00d6\5"+
		"&\24\2\u00d0\u00d6\5\62\32\2\u00d1\u00d6\5\60\31\2\u00d2\u00d6\5,\27\2"+
		"\u00d3\u00d6\5.\30\2\u00d4\u00d6\5(\25\2\u00d5\u00cd\3\2\2\2\u00d5\u00ce"+
		"\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5"+
		"\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\37\3\2\2"+
		"\2\u00d7\u00d8\7:\2\2\u00d8\u00da\7\27\2\2\u00d9\u00db\5\"\22\2\u00da"+
		"\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\7\n"+
		"\2\2\u00dd\u00df\5\66\34\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e2\7\n\2\2\u00e1\u00e3\5\66\34\2\u00e2\u00e1\3"+
		"\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7*\2\2\u00e5"+
		"\u00e6\5$\23\2\u00e6!\3\2\2\2\u00e7\u00ea\5\66\34\2\u00e8\u00ea\5\n\6"+
		"\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea#\3\2\2\2\u00eb\u00ec"+
		"\7\13\2\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee\7\20\2\2\u00ee\u00f1\3\2\2"+
		"\2\u00ef\u00f1\5\36\20\2\u00f0\u00eb\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"%\3\2\2\2\u00f2\u00f3\7;\2\2\u00f3\'\3\2\2\2\u00f4\u00f5\7\64\2\2\u00f5"+
		"\u00f6\7\27\2\2\u00f6\u00f7\5\66\34\2\u00f7\u00f8\7*\2\2\u00f8\u00fe\7"+
		"\13\2\2\u00f9\u00fa\7\65\2\2\u00fa\u00fb\5\66\34\2\u00fb\u00fc\7\34\2"+
		"\2\u00fc\u00fd\5*\26\2\u00fd\u00ff\3\2\2\2\u00fe\u00f9\3\2\2\2\u00ff\u0100"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0106\3\2\2\2\u0102"+
		"\u0103\7\65\2\2\u0103\u0104\7\66\2\2\u0104\u0105\7\34\2\2\u0105\u0107"+
		"\5*\26\2\u0106\u0102\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\7\20\2\2\u0109)\3\2\2\2\u010a\u010b\7\13\2\2\u010b\u010c\5\34\17"+
		"\2\u010c\u010d\7\20\2\2\u010d\u0110\3\2\2\2\u010e\u0110\5\34\17\2\u010f"+
		"\u010a\3\2\2\2\u010f\u010e\3\2\2\2\u0110+\3\2\2\2\u0111\u0112\7=\2\2\u0112"+
		"\u0113\7\27\2\2\u0113\u0114\5\66\34\2\u0114\u0115\7*\2\2\u0115\u0116\5"+
		"$\23\2\u0116-\3\2\2\2\u0117\u0118\7<\2\2\u0118\u0119\5$\23\2\u0119\u011a"+
		"\7=\2\2\u011a\u011b\7\27\2\2\u011b\u011c\5\66\34\2\u011c\u011d\7*\2\2"+
		"\u011d/\3\2\2\2\u011e\u011f\7>\2\2\u011f\u0120\7\27\2\2\u0120\u0121\5"+
		"\66\34\2\u0121\u0122\7*\2\2\u0122\u0125\5$\23\2\u0123\u0124\7?\2\2\u0124"+
		"\u0126\5$\23\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\61\3\2\2"+
		"\2\u0127\u0129\79\2\2\u0128\u012a\5\66\34\2\u0129\u0128\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\63\3\2\2\2\u012b\u012c\3\2\2\2\u012c\65\3\2\2\2\u012d"+
		"\u012e\58\35\2\u012e\u0133\5\64\33\2\u012f\u0130\t\3\2\2\u0130\u0132\5"+
		"8\35\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\67\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u013b\5:\36"+
		"\2\u0137\u0138\t\4\2\2\u0138\u013a\5:\36\2\u0139\u0137\3\2\2\2\u013a\u013d"+
		"\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c9\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e\u0143\5<\37\2\u013f\u0140\t\5\2\2\u0140\u0142\5<"+
		"\37\2\u0141\u013f\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144;\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0149\5> \2\u0147"+
		"\u0148\t\6\2\2\u0148\u014a\5> \2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2"+
		"\2\u014a=\3\2\2\2\u014b\u0150\5@!\2\u014c\u014d\t\7\2\2\u014d\u014f\5"+
		"@!\2\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151?\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0158\5B\"\2\u0154"+
		"\u0155\t\b\2\2\u0155\u0157\5B\"\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159A\3\2\2\2\u015a\u0158"+
		"\3\2\2\2\u015b\u0162\5D#\2\u015c\u015d\7+\2\2\u015d\u0161\5D#\2\u015e"+
		"\u015f\7,\2\2\u015f\u0161\5D#\2\u0160\u015c\3\2\2\2\u0160\u015e\3\2\2"+
		"\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163C"+
		"\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u016a\5F$\2\u0166\u0167\t\t\2\2\u0167"+
		"\u0169\5F$\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2"+
		"\2\u016a\u016b\3\2\2\2\u016bE\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016f"+
		"\7,\2\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0178\3\2\2\2\u0170"+
		"\u0172\7C\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0173\u0174\3\2\2\2\u0174\u0178\3\2\2\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0178\7%\2\2\u0177\u016e\3\2\2\2\u0177\u0173\3\2\2\2\u0177\u0176\3\2"+
		"\2\2\u0178\u0179\3\2\2\2\u0179\u017a\5H%\2\u017aG\3\2\2\2\u017b\u017c"+
		"\7\27\2\2\u017c\u017d\5\66\34\2\u017d\u017e\7*\2\2\u017e\u0183\3\2\2\2"+
		"\u017f\u0183\5L\'\2\u0180\u0183\5J&\2\u0181\u0183\5V,\2\u0182\u017b\3"+
		"\2\2\2\u0182\u017f\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0185\3\2\2\2\u0184\u0186\t\n\2\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186I\3\2\2\2\u0187\u0188\t\13\2\2\u0188K\3\2\2\2\u0189\u018d\t"+
		"\f\2\2\u018a\u018e\5R*\2\u018b\u018e\5P)\2\u018c\u018e\5N(\2\u018d\u018a"+
		"\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018c\3\2\2\2\u018eM\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190O\3\2\2\2\u0191\u0192\7\36\2\2\u0192\u0193\5\66\34"+
		"\2\u0193\u0198\7$\2\2\u0194\u0195\7\36\2\2\u0195\u0196\5\66\34\2\u0196"+
		"\u0197\7$\2\2\u0197\u0199\3\2\2\2\u0198\u0194\3\2\2\2\u0198\u0199\3\2"+
		"\2\2\u0199Q\3\2\2\2\u019a\u019c\7\27\2\2\u019b\u019d\5T+\2\u019c\u019b"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7*\2\2\u019f"+
		"S\3\2\2\2\u01a0\u01a5\5\66\34\2\u01a1\u01a2\7\32\2\2\u01a2\u01a4\5\66"+
		"\34\2\u01a3\u01a1\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6U\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\5Z.\2\u01a9"+
		"\u01ab\5X-\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01abW\3\2\2\2\u01ac"+
		"\u01ad\7\13\2\2\u01ad\u01ae\5^\60\2\u01ae\u01af\7\20\2\2\u01afY\3\2\2"+
		"\2\u01b0\u01b1\7\13\2\2\u01b1\u01b2\5\\/\2\u01b2\u01b3\7\20\2\2\u01b3"+
		"[\3\2\2\2\u01b4\u01b5\7\13\2\2\u01b5\u01b6\5^\60\2\u01b6\u01b7\7\20\2"+
		"\2\u01b7\u01b9\3\2\2\2\u01b8\u01b4\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01c1"+
		"\3\2\2\2\u01ba\u01bb\7\32\2\2\u01bb\u01bc\7\13\2\2\u01bc\u01bd\5^\60\2"+
		"\u01bd\u01be\7\20\2\2\u01be\u01c0\3\2\2\2\u01bf\u01ba\3\2\2\2\u01c0\u01c3"+
		"\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2]\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c4\u01c6\5\66\34\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3"+
		"\2\2\2\u01c6\u01cb\3\2\2\2\u01c7\u01c8\7\32\2\2\u01c8\u01ca\5\66\34\2"+
		"\u01c9\u01c7\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc_\3\2\2\2\u01cd\u01cb\3\2\2\2\67ejlv}\u0085\u008b\u0090"+
		"\u0093\u0095\u0098\u00a2\u00a4\u00a8\u00ba\u00bd\u00c1\u00c8\u00ca\u00d5"+
		"\u00da\u00de\u00e2\u00e9\u00f0\u0100\u0106\u010f\u0125\u0129\u0133\u013b"+
		"\u0143\u0149\u0150\u0158\u0160\u0162\u016a\u016e\u0173\u0177\u0182\u0185"+
		"\u018d\u0198\u019c\u01a5\u01aa\u01b8\u01c1\u01c5\u01cb";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}