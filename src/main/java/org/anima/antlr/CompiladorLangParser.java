// Generated from C:/Users/Raphael/IdeaProjects/A3-TCC/src/main/java/org/anima/antlr/CompiladorLangParser.g4 by ANTLR 4.13.2
package org.anima.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CompiladorLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_INICIO=1, KW_FIM=2, KW_DECLARE=3, KW_INTEIRO=4, KW_REAL=5, KW_TEXTO=6, 
		KW_SE=7, KW_ENTAO=8, KW_SENAO=9, KW_ENQUANTO=10, KW_PARA=11, KW_FACA=12, 
		KW_LEIA=13, KW_ESCREVA=14, KW_E=15, KW_OU=16, KW_NAO=17, OP_SOMA=18, OP_SUBTRACAO=19, 
		OP_MULTIPLICACAO=20, OP_DIVISAO=21, OP_ATRIBUICAO=22, OP_IGUAL=23, OP_DIFERENTE=24, 
		OP_MENOR=25, OP_MAIOR=26, OP_MENOR_IGUAL=27, OP_MAIOR_IGUAL=28, ABRE_PARENTESES=29, 
		FECHA_PARENTESES=30, ABRE_CHAVES=31, FECHA_CHAVES=32, PONTO_VIRGULA=33, 
		VIRGULA=34, NUMERO_REAL=35, NUMERO_INTEIRO=36, TEXTO_LITERAL=37, IDENTIFICADOR=38, 
		WS=39, COMENTARIO_LINHA=40;
	public static final int
		RULE_programa = 0, RULE_listaComandos = 1, RULE_comando = 2, RULE_declaracao = 3, 
		RULE_tipo = 4, RULE_atribuicao = 5, RULE_estruturaCondicional = 6, RULE_estruturaRepeticao = 7, 
		RULE_loopEnquanto = 8, RULE_loopPara = 9, RULE_inicializacaoLoop = 10, 
		RULE_incrementoLoop = 11, RULE_declaracaoLoop = 12, RULE_atribuicaoLoop = 13, 
		RULE_comandoLeitura = 14, RULE_comandoEscrita = 15, RULE_expressao = 16, 
		RULE_expressaoE = 17, RULE_expressaoRelacional = 18, RULE_expressaoAditiva = 19, 
		RULE_expressaoMultiplicativa = 20, RULE_expressaoUnaria = 21, RULE_expressaoPrimaria = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaComandos", "comando", "declaracao", "tipo", "atribuicao", 
			"estruturaCondicional", "estruturaRepeticao", "loopEnquanto", "loopPara", 
			"inicializacaoLoop", "incrementoLoop", "declaracaoLoop", "atribuicaoLoop", 
			"comandoLeitura", "comandoEscrita", "expressao", "expressaoE", "expressaoRelacional", 
			"expressaoAditiva", "expressaoMultiplicativa", "expressaoUnaria", "expressaoPrimaria"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'inicio'", "'fim'", "'declare'", "'inteiro'", "'real'", "'texto'", 
			"'se'", "'entao'", "'senao'", "'enquanto'", "'para'", "'faca'", "'leia'", 
			"'escreva'", "'e'", "'ou'", "'nao'", "'+'", "'-'", "'*'", "'/'", "'='", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'('", "')'", "'{'", "'}'", 
			"';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_INICIO", "KW_FIM", "KW_DECLARE", "KW_INTEIRO", "KW_REAL", "KW_TEXTO", 
			"KW_SE", "KW_ENTAO", "KW_SENAO", "KW_ENQUANTO", "KW_PARA", "KW_FACA", 
			"KW_LEIA", "KW_ESCREVA", "KW_E", "KW_OU", "KW_NAO", "OP_SOMA", "OP_SUBTRACAO", 
			"OP_MULTIPLICACAO", "OP_DIVISAO", "OP_ATRIBUICAO", "OP_IGUAL", "OP_DIFERENTE", 
			"OP_MENOR", "OP_MAIOR", "OP_MENOR_IGUAL", "OP_MAIOR_IGUAL", "ABRE_PARENTESES", 
			"FECHA_PARENTESES", "ABRE_CHAVES", "FECHA_CHAVES", "PONTO_VIRGULA", "VIRGULA", 
			"NUMERO_REAL", "NUMERO_INTEIRO", "TEXTO_LITERAL", "IDENTIFICADOR", "WS", 
			"COMENTARIO_LINHA"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "CompiladorLangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CompiladorLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode KW_INICIO() { return getToken(CompiladorLangParser.KW_INICIO, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode KW_FIM() { return getToken(CompiladorLangParser.KW_FIM, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(KW_INICIO);
			setState(47);
			listaComandos();
			setState(48);
			match(KW_FIM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitListaComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitListaComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274877934728L) != 0)) {
				{
				{
				setState(50);
				comando();
				}
				}
				setState(55);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public EstruturaCondicionalContext estruturaCondicional() {
			return getRuleContext(EstruturaCondicionalContext.class,0);
		}
		public EstruturaRepeticaoContext estruturaRepeticao() {
			return getRuleContext(EstruturaRepeticaoContext.class,0);
		}
		public ComandoLeituraContext comandoLeitura() {
			return getRuleContext(ComandoLeituraContext.class,0);
		}
		public ComandoEscritaContext comandoEscrita() {
			return getRuleContext(ComandoEscritaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitComando(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitComando(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				declaracao();
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				atribuicao();
				}
				break;
			case KW_SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				estruturaCondicional();
				}
				break;
			case KW_ENQUANTO:
			case KW_PARA:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				estruturaRepeticao();
				}
				break;
			case KW_LEIA:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				comandoLeitura();
				}
				break;
			case KW_ESCREVA:
				enterOuterAlt(_localctx, 6);
				{
				setState(61);
				comandoEscrita();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode KW_DECLARE() { return getToken(CompiladorLangParser.KW_DECLARE, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public TerminalNode OP_ATRIBUICAO() { return getToken(CompiladorLangParser.OP_ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(KW_DECLARE);
			setState(65);
			tipo();
			setState(66);
			match(IDENTIFICADOR);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ATRIBUICAO) {
				{
				setState(67);
				match(OP_ATRIBUICAO);
				setState(68);
				expressao();
				}
			}

			setState(71);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode KW_INTEIRO() { return getToken(CompiladorLangParser.KW_INTEIRO, 0); }
		public TerminalNode KW_REAL() { return getToken(CompiladorLangParser.KW_REAL, 0); }
		public TerminalNode KW_TEXTO() { return getToken(CompiladorLangParser.KW_TEXTO, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode OP_ATRIBUICAO() { return getToken(CompiladorLangParser.OP_ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(IDENTIFICADOR);
			setState(76);
			match(OP_ATRIBUICAO);
			setState(77);
			expressao();
			setState(78);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EstruturaCondicionalContext extends ParserRuleContext {
		public TerminalNode KW_SE() { return getToken(CompiladorLangParser.KW_SE, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public TerminalNode KW_ENTAO() { return getToken(CompiladorLangParser.KW_ENTAO, 0); }
		public List<TerminalNode> ABRE_CHAVES() { return getTokens(CompiladorLangParser.ABRE_CHAVES); }
		public TerminalNode ABRE_CHAVES(int i) {
			return getToken(CompiladorLangParser.ABRE_CHAVES, i);
		}
		public List<ListaComandosContext> listaComandos() {
			return getRuleContexts(ListaComandosContext.class);
		}
		public ListaComandosContext listaComandos(int i) {
			return getRuleContext(ListaComandosContext.class,i);
		}
		public List<TerminalNode> FECHA_CHAVES() { return getTokens(CompiladorLangParser.FECHA_CHAVES); }
		public TerminalNode FECHA_CHAVES(int i) {
			return getToken(CompiladorLangParser.FECHA_CHAVES, i);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public TerminalNode KW_SENAO() { return getToken(CompiladorLangParser.KW_SENAO, 0); }
		public EstruturaCondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estruturaCondicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterEstruturaCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitEstruturaCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitEstruturaCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstruturaCondicionalContext estruturaCondicional() throws RecognitionException {
		EstruturaCondicionalContext _localctx = new EstruturaCondicionalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_estruturaCondicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(KW_SE);
			setState(81);
			match(ABRE_PARENTESES);
			setState(82);
			expressao();
			setState(83);
			match(FECHA_PARENTESES);
			setState(84);
			match(KW_ENTAO);
			setState(85);
			match(ABRE_CHAVES);
			setState(86);
			listaComandos();
			setState(87);
			match(FECHA_CHAVES);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SENAO) {
				{
				setState(88);
				match(KW_SENAO);
				setState(89);
				match(ABRE_CHAVES);
				setState(90);
				listaComandos();
				setState(91);
				match(FECHA_CHAVES);
				}
			}

			setState(95);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EstruturaRepeticaoContext extends ParserRuleContext {
		public LoopEnquantoContext loopEnquanto() {
			return getRuleContext(LoopEnquantoContext.class,0);
		}
		public LoopParaContext loopPara() {
			return getRuleContext(LoopParaContext.class,0);
		}
		public EstruturaRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estruturaRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterEstruturaRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitEstruturaRepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitEstruturaRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstruturaRepeticaoContext estruturaRepeticao() throws RecognitionException {
		EstruturaRepeticaoContext _localctx = new EstruturaRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_estruturaRepeticao);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ENQUANTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				loopEnquanto();
				}
				break;
			case KW_PARA:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				loopPara();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopEnquantoContext extends ParserRuleContext {
		public TerminalNode KW_ENQUANTO() { return getToken(CompiladorLangParser.KW_ENQUANTO, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public TerminalNode KW_FACA() { return getToken(CompiladorLangParser.KW_FACA, 0); }
		public TerminalNode ABRE_CHAVES() { return getToken(CompiladorLangParser.ABRE_CHAVES, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode FECHA_CHAVES() { return getToken(CompiladorLangParser.FECHA_CHAVES, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public LoopEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterLoopEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitLoopEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitLoopEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopEnquantoContext loopEnquanto() throws RecognitionException {
		LoopEnquantoContext _localctx = new LoopEnquantoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loopEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(KW_ENQUANTO);
			setState(102);
			match(ABRE_PARENTESES);
			setState(103);
			expressao();
			setState(104);
			match(FECHA_PARENTESES);
			setState(105);
			match(KW_FACA);
			setState(106);
			match(ABRE_CHAVES);
			setState(107);
			listaComandos();
			setState(108);
			match(FECHA_CHAVES);
			setState(109);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopParaContext extends ParserRuleContext {
		public TerminalNode KW_PARA() { return getToken(CompiladorLangParser.KW_PARA, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public InicializacaoLoopContext inicializacaoLoop() {
			return getRuleContext(InicializacaoLoopContext.class,0);
		}
		public List<TerminalNode> PONTO_VIRGULA() { return getTokens(CompiladorLangParser.PONTO_VIRGULA); }
		public TerminalNode PONTO_VIRGULA(int i) {
			return getToken(CompiladorLangParser.PONTO_VIRGULA, i);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public IncrementoLoopContext incrementoLoop() {
			return getRuleContext(IncrementoLoopContext.class,0);
		}
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public TerminalNode KW_FACA() { return getToken(CompiladorLangParser.KW_FACA, 0); }
		public TerminalNode ABRE_CHAVES() { return getToken(CompiladorLangParser.ABRE_CHAVES, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode FECHA_CHAVES() { return getToken(CompiladorLangParser.FECHA_CHAVES, 0); }
		public LoopParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterLoopPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitLoopPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitLoopPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopParaContext loopPara() throws RecognitionException {
		LoopParaContext _localctx = new LoopParaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loopPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(KW_PARA);
			setState(112);
			match(ABRE_PARENTESES);
			setState(113);
			inicializacaoLoop();
			setState(114);
			match(PONTO_VIRGULA);
			setState(115);
			expressao();
			setState(116);
			match(PONTO_VIRGULA);
			setState(117);
			incrementoLoop();
			setState(118);
			match(FECHA_PARENTESES);
			setState(119);
			match(KW_FACA);
			setState(120);
			match(ABRE_CHAVES);
			setState(121);
			listaComandos();
			setState(122);
			match(FECHA_CHAVES);
			setState(123);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InicializacaoLoopContext extends ParserRuleContext {
		public DeclaracaoLoopContext declaracaoLoop() {
			return getRuleContext(DeclaracaoLoopContext.class,0);
		}
		public AtribuicaoLoopContext atribuicaoLoop() {
			return getRuleContext(AtribuicaoLoopContext.class,0);
		}
		public InicializacaoLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacaoLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterInicializacaoLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitInicializacaoLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitInicializacaoLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializacaoLoopContext inicializacaoLoop() throws RecognitionException {
		InicializacaoLoopContext _localctx = new InicializacaoLoopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inicializacaoLoop);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				declaracaoLoop();
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				atribuicaoLoop();
				}
				break;
			case PONTO_VIRGULA:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoLoopContext extends ParserRuleContext {
		public AtribuicaoLoopContext atribuicaoLoop() {
			return getRuleContext(AtribuicaoLoopContext.class,0);
		}
		public IncrementoLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementoLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterIncrementoLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitIncrementoLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitIncrementoLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementoLoopContext incrementoLoop() throws RecognitionException {
		IncrementoLoopContext _localctx = new IncrementoLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_incrementoLoop);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				atribuicaoLoop();
				}
				break;
			case FECHA_PARENTESES:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoLoopContext extends ParserRuleContext {
		public TerminalNode KW_DECLARE() { return getToken(CompiladorLangParser.KW_DECLARE, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode OP_ATRIBUICAO() { return getToken(CompiladorLangParser.OP_ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DeclaracaoLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterDeclaracaoLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitDeclaracaoLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitDeclaracaoLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoLoopContext declaracaoLoop() throws RecognitionException {
		DeclaracaoLoopContext _localctx = new DeclaracaoLoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracaoLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(KW_DECLARE);
			setState(135);
			tipo();
			setState(136);
			match(IDENTIFICADOR);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ATRIBUICAO) {
				{
				setState(137);
				match(OP_ATRIBUICAO);
				setState(138);
				expressao();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoLoopContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode OP_ATRIBUICAO() { return getToken(CompiladorLangParser.OP_ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicaoLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterAtribuicaoLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitAtribuicaoLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitAtribuicaoLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoLoopContext atribuicaoLoop() throws RecognitionException {
		AtribuicaoLoopContext _localctx = new AtribuicaoLoopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atribuicaoLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IDENTIFICADOR);
			setState(142);
			match(OP_ATRIBUICAO);
			setState(143);
			expressao();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoLeituraContext extends ParserRuleContext {
		public TerminalNode KW_LEIA() { return getToken(CompiladorLangParser.KW_LEIA, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public ComandoLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterComandoLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitComandoLeitura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitComandoLeitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoLeituraContext comandoLeitura() throws RecognitionException {
		ComandoLeituraContext _localctx = new ComandoLeituraContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(KW_LEIA);
			setState(146);
			match(ABRE_PARENTESES);
			setState(147);
			match(IDENTIFICADOR);
			setState(148);
			match(FECHA_PARENTESES);
			setState(149);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoEscritaContext extends ParserRuleContext {
		public TerminalNode KW_ESCREVA() { return getToken(CompiladorLangParser.KW_ESCREVA, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(CompiladorLangParser.PONTO_VIRGULA, 0); }
		public ComandoEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterComandoEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitComandoEscrita(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitComandoEscrita(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoEscritaContext comandoEscrita() throws RecognitionException {
		ComandoEscritaContext _localctx = new ComandoEscritaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(KW_ESCREVA);
			setState(152);
			match(ABRE_PARENTESES);
			setState(153);
			expressao();
			setState(154);
			match(FECHA_PARENTESES);
			setState(155);
			match(PONTO_VIRGULA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public List<ExpressaoEContext> expressaoE() {
			return getRuleContexts(ExpressaoEContext.class);
		}
		public ExpressaoEContext expressaoE(int i) {
			return getRuleContext(ExpressaoEContext.class,i);
		}
		public List<TerminalNode> KW_OU() { return getTokens(CompiladorLangParser.KW_OU); }
		public TerminalNode KW_OU(int i) {
			return getToken(CompiladorLangParser.KW_OU, i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			expressaoE();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_OU) {
				{
				{
				setState(158);
				match(KW_OU);
				setState(159);
				expressaoE();
				}
				}
				setState(164);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoEContext extends ParserRuleContext {
		public List<ExpressaoRelacionalContext> expressaoRelacional() {
			return getRuleContexts(ExpressaoRelacionalContext.class);
		}
		public ExpressaoRelacionalContext expressaoRelacional(int i) {
			return getRuleContext(ExpressaoRelacionalContext.class,i);
		}
		public List<TerminalNode> KW_E() { return getTokens(CompiladorLangParser.KW_E); }
		public TerminalNode KW_E(int i) {
			return getToken(CompiladorLangParser.KW_E, i);
		}
		public ExpressaoEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoEContext expressaoE() throws RecognitionException {
		ExpressaoEContext _localctx = new ExpressaoEContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressaoE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			expressaoRelacional();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_E) {
				{
				{
				setState(166);
				match(KW_E);
				setState(167);
				expressaoRelacional();
				}
				}
				setState(172);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAditivaContext> expressaoAditiva() {
			return getRuleContexts(ExpressaoAditivaContext.class);
		}
		public ExpressaoAditivaContext expressaoAditiva(int i) {
			return getRuleContext(ExpressaoAditivaContext.class,i);
		}
		public TerminalNode OP_IGUAL() { return getToken(CompiladorLangParser.OP_IGUAL, 0); }
		public TerminalNode OP_DIFERENTE() { return getToken(CompiladorLangParser.OP_DIFERENTE, 0); }
		public TerminalNode OP_MENOR() { return getToken(CompiladorLangParser.OP_MENOR, 0); }
		public TerminalNode OP_MAIOR() { return getToken(CompiladorLangParser.OP_MAIOR, 0); }
		public TerminalNode OP_MENOR_IGUAL() { return getToken(CompiladorLangParser.OP_MENOR_IGUAL, 0); }
		public TerminalNode OP_MAIOR_IGUAL() { return getToken(CompiladorLangParser.OP_MAIOR_IGUAL, 0); }
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoRelacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressaoRelacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			expressaoAditiva();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) {
				{
				setState(174);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				expressaoAditiva();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoAditivaContext extends ParserRuleContext {
		public List<ExpressaoMultiplicativaContext> expressaoMultiplicativa() {
			return getRuleContexts(ExpressaoMultiplicativaContext.class);
		}
		public ExpressaoMultiplicativaContext expressaoMultiplicativa(int i) {
			return getRuleContext(ExpressaoMultiplicativaContext.class,i);
		}
		public List<TerminalNode> OP_SOMA() { return getTokens(CompiladorLangParser.OP_SOMA); }
		public TerminalNode OP_SOMA(int i) {
			return getToken(CompiladorLangParser.OP_SOMA, i);
		}
		public List<TerminalNode> OP_SUBTRACAO() { return getTokens(CompiladorLangParser.OP_SUBTRACAO); }
		public TerminalNode OP_SUBTRACAO(int i) {
			return getToken(CompiladorLangParser.OP_SUBTRACAO, i);
		}
		public ExpressaoAditivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAditiva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoAditiva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoAditivaContext expressaoAditiva() throws RecognitionException {
		ExpressaoAditivaContext _localctx = new ExpressaoAditivaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressaoAditiva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			expressaoMultiplicativa();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SOMA || _la==OP_SUBTRACAO) {
				{
				{
				setState(179);
				_la = _input.LA(1);
				if ( !(_la==OP_SOMA || _la==OP_SUBTRACAO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(180);
				expressaoMultiplicativa();
				}
				}
				setState(185);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoMultiplicativaContext extends ParserRuleContext {
		public List<ExpressaoUnariaContext> expressaoUnaria() {
			return getRuleContexts(ExpressaoUnariaContext.class);
		}
		public ExpressaoUnariaContext expressaoUnaria(int i) {
			return getRuleContext(ExpressaoUnariaContext.class,i);
		}
		public List<TerminalNode> OP_MULTIPLICACAO() { return getTokens(CompiladorLangParser.OP_MULTIPLICACAO); }
		public TerminalNode OP_MULTIPLICACAO(int i) {
			return getToken(CompiladorLangParser.OP_MULTIPLICACAO, i);
		}
		public List<TerminalNode> OP_DIVISAO() { return getTokens(CompiladorLangParser.OP_DIVISAO); }
		public TerminalNode OP_DIVISAO(int i) {
			return getToken(CompiladorLangParser.OP_DIVISAO, i);
		}
		public ExpressaoMultiplicativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoMultiplicativa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoMultiplicativaContext expressaoMultiplicativa() throws RecognitionException {
		ExpressaoMultiplicativaContext _localctx = new ExpressaoMultiplicativaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressaoMultiplicativa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			expressaoUnaria();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULTIPLICACAO || _la==OP_DIVISAO) {
				{
				{
				setState(187);
				_la = _input.LA(1);
				if ( !(_la==OP_MULTIPLICACAO || _la==OP_DIVISAO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				expressaoUnaria();
				}
				}
				setState(193);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoUnariaContext extends ParserRuleContext {
		public TerminalNode KW_NAO() { return getToken(CompiladorLangParser.KW_NAO, 0); }
		public ExpressaoUnariaContext expressaoUnaria() {
			return getRuleContext(ExpressaoUnariaContext.class,0);
		}
		public TerminalNode OP_SUBTRACAO() { return getToken(CompiladorLangParser.OP_SUBTRACAO, 0); }
		public ExpressaoPrimariaContext expressaoPrimaria() {
			return getRuleContext(ExpressaoPrimariaContext.class,0);
		}
		public ExpressaoUnariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoUnaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoUnaria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoUnariaContext expressaoUnaria() throws RecognitionException {
		ExpressaoUnariaContext _localctx = new ExpressaoUnariaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressaoUnaria);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_NAO:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(KW_NAO);
				setState(195);
				expressaoUnaria();
				}
				break;
			case OP_SUBTRACAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(OP_SUBTRACAO);
				setState(197);
				expressaoUnaria();
				}
				break;
			case ABRE_PARENTESES:
			case NUMERO_REAL:
			case NUMERO_INTEIRO:
			case TEXTO_LITERAL:
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				expressaoPrimaria();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoPrimariaContext extends ParserRuleContext {
		public TerminalNode NUMERO_INTEIRO() { return getToken(CompiladorLangParser.NUMERO_INTEIRO, 0); }
		public TerminalNode NUMERO_REAL() { return getToken(CompiladorLangParser.NUMERO_REAL, 0); }
		public TerminalNode TEXTO_LITERAL() { return getToken(CompiladorLangParser.TEXTO_LITERAL, 0); }
		public TerminalNode IDENTIFICADOR() { return getToken(CompiladorLangParser.IDENTIFICADOR, 0); }
		public TerminalNode ABRE_PARENTESES() { return getToken(CompiladorLangParser.ABRE_PARENTESES, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PARENTESES() { return getToken(CompiladorLangParser.FECHA_PARENTESES, 0); }
		public ExpressaoPrimariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoPrimaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).enterExpressaoPrimaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompiladorLangParserListener ) ((CompiladorLangParserListener)listener).exitExpressaoPrimaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompiladorLangParserVisitor ) return ((CompiladorLangParserVisitor<? extends T>)visitor).visitExpressaoPrimaria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoPrimariaContext expressaoPrimaria() throws RecognitionException {
		ExpressaoPrimariaContext _localctx = new ExpressaoPrimariaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressaoPrimaria);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO_INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(NUMERO_INTEIRO);
				}
				break;
			case NUMERO_REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(NUMERO_REAL);
				}
				break;
			case TEXTO_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(TEXTO_LITERAL);
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(IDENTIFICADOR);
				}
				break;
			case ABRE_PARENTESES:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(ABRE_PARENTESES);
				setState(206);
				expressao();
				setState(207);
				match(FECHA_PARENTESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\u0004\u0001(\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003F\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006^\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0003\u0007d\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0085\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u008c"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00a1\b\u0010\n\u0010\f\u0010\u00a4\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00a9\b\u0011\n\u0011\f\u0011\u00ac\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b1\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00b6\b\u0013\n\u0013\f\u0013\u00b9"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00be\b\u0014"+
		"\n\u0014\f\u0014\u00c1\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00c8\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u00d2\b\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000"+
		"\u0004\u0001\u0000\u0004\u0006\u0001\u0000\u0017\u001c\u0001\u0000\u0012"+
		"\u0013\u0001\u0000\u0014\u0015\u00d4\u0000.\u0001\u0000\u0000\u0000\u0002"+
		"5\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006@\u0001"+
		"\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000\u0000"+
		"\fP\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010e\u0001"+
		"\u0000\u0000\u0000\u0012o\u0001\u0000\u0000\u0000\u0014\u0080\u0001\u0000"+
		"\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018\u0086\u0001\u0000"+
		"\u0000\u0000\u001a\u008d\u0001\u0000\u0000\u0000\u001c\u0091\u0001\u0000"+
		"\u0000\u0000\u001e\u0097\u0001\u0000\u0000\u0000 \u009d\u0001\u0000\u0000"+
		"\u0000\"\u00a5\u0001\u0000\u0000\u0000$\u00ad\u0001\u0000\u0000\u0000"+
		"&\u00b2\u0001\u0000\u0000\u0000(\u00ba\u0001\u0000\u0000\u0000*\u00c7"+
		"\u0001\u0000\u0000\u0000,\u00d1\u0001\u0000\u0000\u0000./\u0005\u0001"+
		"\u0000\u0000/0\u0003\u0002\u0001\u000001\u0005\u0002\u0000\u00001\u0001"+
		"\u0001\u0000\u0000\u000024\u0003\u0004\u0002\u000032\u0001\u0000\u0000"+
		"\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u00006\u0003\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u0000"+
		"8?\u0003\u0006\u0003\u00009?\u0003\n\u0005\u0000:?\u0003\f\u0006\u0000"+
		";?\u0003\u000e\u0007\u0000<?\u0003\u001c\u000e\u0000=?\u0003\u001e\u000f"+
		"\u0000>8\u0001\u0000\u0000\u0000>9\u0001\u0000\u0000\u0000>:\u0001\u0000"+
		"\u0000\u0000>;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001"+
		"\u0000\u0000\u0000?\u0005\u0001\u0000\u0000\u0000@A\u0005\u0003\u0000"+
		"\u0000AB\u0003\b\u0004\u0000BE\u0005&\u0000\u0000CD\u0005\u0016\u0000"+
		"\u0000DF\u0003 \u0010\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GH\u0005!\u0000\u0000H\u0007\u0001\u0000"+
		"\u0000\u0000IJ\u0007\u0000\u0000\u0000J\t\u0001\u0000\u0000\u0000KL\u0005"+
		"&\u0000\u0000LM\u0005\u0016\u0000\u0000MN\u0003 \u0010\u0000NO\u0005!"+
		"\u0000\u0000O\u000b\u0001\u0000\u0000\u0000PQ\u0005\u0007\u0000\u0000"+
		"QR\u0005\u001d\u0000\u0000RS\u0003 \u0010\u0000ST\u0005\u001e\u0000\u0000"+
		"TU\u0005\b\u0000\u0000UV\u0005\u001f\u0000\u0000VW\u0003\u0002\u0001\u0000"+
		"W]\u0005 \u0000\u0000XY\u0005\t\u0000\u0000YZ\u0005\u001f\u0000\u0000"+
		"Z[\u0003\u0002\u0001\u0000[\\\u0005 \u0000\u0000\\^\u0001\u0000\u0000"+
		"\u0000]X\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0005!\u0000\u0000`\r\u0001\u0000\u0000\u0000ad\u0003\u0010"+
		"\b\u0000bd\u0003\u0012\t\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000"+
		"\u0000\u0000d\u000f\u0001\u0000\u0000\u0000ef\u0005\n\u0000\u0000fg\u0005"+
		"\u001d\u0000\u0000gh\u0003 \u0010\u0000hi\u0005\u001e\u0000\u0000ij\u0005"+
		"\f\u0000\u0000jk\u0005\u001f\u0000\u0000kl\u0003\u0002\u0001\u0000lm\u0005"+
		" \u0000\u0000mn\u0005!\u0000\u0000n\u0011\u0001\u0000\u0000\u0000op\u0005"+
		"\u000b\u0000\u0000pq\u0005\u001d\u0000\u0000qr\u0003\u0014\n\u0000rs\u0005"+
		"!\u0000\u0000st\u0003 \u0010\u0000tu\u0005!\u0000\u0000uv\u0003\u0016"+
		"\u000b\u0000vw\u0005\u001e\u0000\u0000wx\u0005\f\u0000\u0000xy\u0005\u001f"+
		"\u0000\u0000yz\u0003\u0002\u0001\u0000z{\u0005 \u0000\u0000{|\u0005!\u0000"+
		"\u0000|\u0013\u0001\u0000\u0000\u0000}\u0081\u0003\u0018\f\u0000~\u0081"+
		"\u0003\u001a\r\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080}\u0001"+
		"\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0085\u0003\u001a"+
		"\r\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0017\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u0003\u0000\u0000\u0087\u0088\u0003\b\u0004\u0000"+
		"\u0088\u008b\u0005&\u0000\u0000\u0089\u008a\u0005\u0016\u0000\u0000\u008a"+
		"\u008c\u0003 \u0010\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005&\u0000\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f\u0090\u0003"+
		" \u0010\u0000\u0090\u001b\u0001\u0000\u0000\u0000\u0091\u0092\u0005\r"+
		"\u0000\u0000\u0092\u0093\u0005\u001d\u0000\u0000\u0093\u0094\u0005&\u0000"+
		"\u0000\u0094\u0095\u0005\u001e\u0000\u0000\u0095\u0096\u0005!\u0000\u0000"+
		"\u0096\u001d\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u000e\u0000\u0000"+
		"\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u009a\u0003 \u0010\u0000\u009a"+
		"\u009b\u0005\u001e\u0000\u0000\u009b\u009c\u0005!\u0000\u0000\u009c\u001f"+
		"\u0001\u0000\u0000\u0000\u009d\u00a2\u0003\"\u0011\u0000\u009e\u009f\u0005"+
		"\u0010\u0000\u0000\u009f\u00a1\u0003\"\u0011\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3!\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00aa\u0003$\u0012\u0000"+
		"\u00a6\u00a7\u0005\u000f\u0000\u0000\u00a7\u00a9\u0003$\u0012\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"#\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0"+
		"\u0003&\u0013\u0000\u00ae\u00af\u0007\u0001\u0000\u0000\u00af\u00b1\u0003"+
		"&\u0013\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1%\u0001\u0000\u0000\u0000\u00b2\u00b7\u0003(\u0014\u0000"+
		"\u00b3\u00b4\u0007\u0002\u0000\u0000\u00b4\u00b6\u0003(\u0014\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\'\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bf"+
		"\u0003*\u0015\u0000\u00bb\u00bc\u0007\u0003\u0000\u0000\u00bc\u00be\u0003"+
		"*\u0015\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0)\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005\u0011\u0000\u0000\u00c3\u00c8\u0003*\u0015\u0000"+
		"\u00c4\u00c5\u0005\u0013\u0000\u0000\u00c5\u00c8\u0003*\u0015\u0000\u00c6"+
		"\u00c8\u0003,\u0016\u0000\u00c7\u00c2\u0001\u0000\u0000\u0000\u00c7\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8+\u0001"+
		"\u0000\u0000\u0000\u00c9\u00d2\u0005$\u0000\u0000\u00ca\u00d2\u0005#\u0000"+
		"\u0000\u00cb\u00d2\u0005%\u0000\u0000\u00cc\u00d2\u0005&\u0000\u0000\u00cd"+
		"\u00ce\u0005\u001d\u0000\u0000\u00ce\u00cf\u0003 \u0010\u0000\u00cf\u00d0"+
		"\u0005\u001e\u0000\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00c9"+
		"\u0001\u0000\u0000\u0000\u00d1\u00ca\u0001\u0000\u0000\u0000\u00d1\u00cb"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cc\u0001\u0000\u0000\u0000\u00d1\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d2-\u0001\u0000\u0000\u0000\u000f5>E]c\u0080"+
		"\u0084\u008b\u00a2\u00aa\u00b0\u00b7\u00bf\u00c7\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}