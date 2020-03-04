// Generated from E:/repo/mvn/makefsm/src/main/resources/parser\MakefsmParser.g4 by ANTLR 4.7.2

package  makefsm.parser.autogen;

import makefsm.parser.FSMParser;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakefsmParser extends FSMParser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FSM=1, DESC=2, STATUS=3, START=4, END=5, COLON=6, SEMI=7, DIRECT=8, LSB=9, 
		RSB=10, EQUAL=11, MOORE=12, MEALY=13, SLASH=14, COMMA=15, ID=16, INT=17, 
		LINE_COMMENT=18, BLOCK_COMMENT=19, SHELL_COMMENT=20, WS=21, STRING=22, 
		CHAR=23;
	public static final int
		RULE_prog = 0, RULE_statment = 1, RULE_fsm_name = 2, RULE_status_list = 3, 
		RULE_def_status = 4, RULE_start_status = 5, RULE_end_status_list = 6, 
		RULE_end_status = 7, RULE_transfer = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "statment", "fsm_name", "status_list", "def_status", "start_status", 
			"end_status_list", "end_status", "transfer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'FSM'", "'DESC'", "'STATUS'", "'START'", "'END'", "':'", "';'", 
			"'->'", "'['", "']'", "'='", "'MOORE'", "'MEALY'", "'/'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FSM", "DESC", "STATUS", "START", "END", "COLON", "SEMI", "DIRECT", 
			"LSB", "RSB", "EQUAL", "MOORE", "MEALY", "SLASH", "COMMA", "ID", "INT", 
			"LINE_COMMENT", "BLOCK_COMMENT", "SHELL_COMMENT", "WS", "STRING", "CHAR"
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
	public String getGrammarFileName() { return "MakefsmParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	 
	public MakefsmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Fsm_nameContext fsm_name() {
			return getRuleContext(Fsm_nameContext.class,0);
		}
		public Status_listContext status_list() {
			return getRuleContext(Status_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MakefsmParser.EOF, 0); }
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public TerminalNode MOORE() { return getToken(MakefsmParser.MOORE, 0); }
		public TerminalNode MEALY() { return getToken(MakefsmParser.MEALY, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MOORE || _la==MEALY) {
				{
				setState(18);
				_la = _input.LA(1);
				if ( !(_la==MOORE || _la==MEALY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(21);
			fsm_name();
			setState(22);
			status_list();
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				statment();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START) | (1L << END) | (1L << ID))) != 0) );
			setState(28);
			match(EOF);
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

	public static class StatmentContext extends ParserRuleContext {
		public Start_statusContext start_status() {
			return getRuleContext(Start_statusContext.class,0);
		}
		public End_status_listContext end_status_list() {
			return getRuleContext(End_status_listContext.class,0);
		}
		public TransferContext transfer() {
			return getRuleContext(TransferContext.class,0);
		}
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitStatment(this);
		}
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statment);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				start_status();
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				end_status_list();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				transfer();
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

	public static class Fsm_nameContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode FSM() { return getToken(MakefsmParser.FSM, 0); }
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(MakefsmParser.ID, 0); }
		public TerminalNode STRING() { return getToken(MakefsmParser.STRING, 0); }
		public TerminalNode DESC() { return getToken(MakefsmParser.DESC, 0); }
		public Fsm_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fsm_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterFsm_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitFsm_name(this);
		}
	}

	public final Fsm_nameContext fsm_name() throws RecognitionException {
		Fsm_nameContext _localctx = new Fsm_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fsm_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(FSM);
			setState(36);
			((Fsm_nameContext)_localctx).a = match(ID);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(37);
					match(DESC);
					}
				}

				setState(40);
				((Fsm_nameContext)_localctx).b = match(STRING);
				}
			}

			setState(43);
			match(SEMI);
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

	public static class Status_listContext extends ParserRuleContext {
		public TerminalNode STATUS() { return getToken(MakefsmParser.STATUS, 0); }
		public TerminalNode COLON() { return getToken(MakefsmParser.COLON, 0); }
		public List<Def_statusContext> def_status() {
			return getRuleContexts(Def_statusContext.class);
		}
		public Def_statusContext def_status(int i) {
			return getRuleContext(Def_statusContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MakefsmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MakefsmParser.COMMA, i);
		}
		public Status_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_status_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterStatus_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitStatus_list(this);
		}
	}

	public final Status_listContext status_list() throws RecognitionException {
		Status_listContext _localctx = new Status_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_status_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(STATUS);
			setState(46);
			match(COLON);
			setState(47);
			def_status();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(48);
				match(COMMA);
				setState(49);
				def_status();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(SEMI);
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

	public static class Def_statusContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode ID() { return getToken(MakefsmParser.ID, 0); }
		public TerminalNode STRING() { return getToken(MakefsmParser.STRING, 0); }
		public TerminalNode DESC() { return getToken(MakefsmParser.DESC, 0); }
		public Def_statusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_status; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterDef_status(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitDef_status(this);
		}
	}

	public final Def_statusContext def_status() throws RecognitionException {
		Def_statusContext _localctx = new Def_statusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_def_status);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((Def_statusContext)_localctx).a = match(ID);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(58);
					match(DESC);
					}
				}

				setState(61);
				((Def_statusContext)_localctx).b = match(STRING);
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

	public static class Start_statusContext extends ParserRuleContext {
		public Token a;
		public TerminalNode START() { return getToken(MakefsmParser.START, 0); }
		public TerminalNode EQUAL() { return getToken(MakefsmParser.EQUAL, 0); }
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(MakefsmParser.ID, 0); }
		public Start_statusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_status; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterStart_status(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitStart_status(this);
		}
	}

	public final Start_statusContext start_status() throws RecognitionException {
		Start_statusContext _localctx = new Start_statusContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_start_status);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(START);
			setState(65);
			match(EQUAL);
			setState(66);
			((Start_statusContext)_localctx).a = match(ID);
			setState(67);
			match(SEMI);
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

	public static class End_status_listContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(MakefsmParser.END, 0); }
		public TerminalNode EQUAL() { return getToken(MakefsmParser.EQUAL, 0); }
		public List<End_statusContext> end_status() {
			return getRuleContexts(End_statusContext.class);
		}
		public End_statusContext end_status(int i) {
			return getRuleContext(End_statusContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MakefsmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MakefsmParser.COMMA, i);
		}
		public End_status_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_status_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterEnd_status_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitEnd_status_list(this);
		}
	}

	public final End_status_listContext end_status_list() throws RecognitionException {
		End_status_listContext _localctx = new End_status_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_end_status_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(END);
			setState(70);
			match(EQUAL);
			setState(71);
			end_status();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(72);
				match(COMMA);
				setState(73);
				end_status();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			match(SEMI);
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

	public static class End_statusContext extends ParserRuleContext {
		public Token a;
		public TerminalNode ID() { return getToken(MakefsmParser.ID, 0); }
		public End_statusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_status; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterEnd_status(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitEnd_status(this);
		}
	}

	public final End_statusContext end_status() throws RecognitionException {
		End_statusContext _localctx = new End_statusContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_end_status);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			((End_statusContext)_localctx).a = match(ID);
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

	public static class TransferContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public Token c;
		public Token e;
		public TerminalNode DIRECT() { return getToken(MakefsmParser.DIRECT, 0); }
		public TerminalNode LSB() { return getToken(MakefsmParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(MakefsmParser.RSB, 0); }
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public List<TerminalNode> ID() { return getTokens(MakefsmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MakefsmParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(MakefsmParser.STRING, 0); }
		public TerminalNode DESC() { return getToken(MakefsmParser.DESC, 0); }
		public TransferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transfer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterTransfer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitTransfer(this);
		}
	}

	public final TransferContext transfer() throws RecognitionException {
		TransferContext _localctx = new TransferContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transfer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((TransferContext)_localctx).a = match(ID);
			setState(84);
			match(DIRECT);
			setState(85);
			((TransferContext)_localctx).b = match(ID);
			setState(86);
			match(LSB);
			setState(87);
			((TransferContext)_localctx).c = match(ID);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(88);
					match(DESC);
					}
				}

				setState(91);
				((TransferContext)_localctx).e = match(STRING);
				}
			}

			setState(94);
			match(RSB);
			setState(95);
			match(SEMI);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2\26"+
		"\n\2\3\2\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\3\3\3\3\3\3\5\3$\n\3\3"+
		"\4\3\4\3\4\5\4)\n\4\3\4\5\4,\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\65\n"+
		"\5\f\5\16\58\13\5\3\5\3\5\3\6\3\6\5\6>\n\6\3\6\5\6A\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\7\bM\n\b\f\b\16\bP\13\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\\\n\n\3\n\5\n_\n\n\3\n\3\n\3\n\3\n\2\2\13\2\4"+
		"\6\b\n\f\16\20\22\2\3\3\2\16\17\2f\2\25\3\2\2\2\4#\3\2\2\2\6%\3\2\2\2"+
		"\b/\3\2\2\2\n;\3\2\2\2\fB\3\2\2\2\16G\3\2\2\2\20S\3\2\2\2\22U\3\2\2\2"+
		"\24\26\t\2\2\2\25\24\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2\27\30\5\6\4\2"+
		"\30\32\5\b\5\2\31\33\5\4\3\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2"+
		"\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7\2\2\3\37\3\3\2\2\2 $\5\f\7\2!$\5"+
		"\16\b\2\"$\5\22\n\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\3\2"+
		"\2&+\7\22\2\2\')\7\4\2\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*,\7\30\2\2+(\3"+
		"\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\t\2\2.\7\3\2\2\2/\60\7\5\2\2\60\61\7\b"+
		"\2\2\61\66\5\n\6\2\62\63\7\21\2\2\63\65\5\n\6\2\64\62\3\2\2\2\658\3\2"+
		"\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\t\2\2:\t"+
		"\3\2\2\2;@\7\22\2\2<>\7\4\2\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?A\7\30\2\2"+
		"@=\3\2\2\2@A\3\2\2\2A\13\3\2\2\2BC\7\6\2\2CD\7\r\2\2DE\7\22\2\2EF\7\t"+
		"\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\r\2\2IN\5\20\t\2JK\7\21\2\2KM\5\20\t\2L"+
		"J\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\t\2\2"+
		"R\17\3\2\2\2ST\7\22\2\2T\21\3\2\2\2UV\7\22\2\2VW\7\n\2\2WX\7\22\2\2XY"+
		"\7\13\2\2Y^\7\22\2\2Z\\\7\4\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]_\7\30"+
		"\2\2^[\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\f\2\2ab\7\t\2\2b\23\3\2\2\2\r\25"+
		"\34#(+\66=@N[^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}