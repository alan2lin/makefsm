// Generated from E:/repo/mvn/makefsm/fsmmaker/src/main/resources/parser\MakefsmParser.g4 by ANTLR 4.7.2


package com.github.alan2lin.makefsm.parser.autogen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakefsmParser extends Parser {
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
		RULE_prog = 0, RULE_fsm_type = 1, RULE_fsm_name = 2, RULE_status_list = 3,
		RULE_def_status = 4, RULE_statment = 5, RULE_start_status = 6, RULE_end_status_list = 7,
		RULE_end_status = 8, RULE_transfer = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "fsm_type", "fsm_name", "status_list", "def_status", "statment",
			"start_status", "end_status_list", "end_status", "transfer"
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
		public Fsm_typeContext fsm_type() {
			return getRuleContext(Fsm_typeContext.class,0);
		}
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MOORE || _la==MEALY) {
				{
				setState(20);
				fsm_type();
				}
			}

			setState(23);
			fsm_name();
			setState(24);
			status_list();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				statment();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START) | (1L << END) | (1L << ID))) != 0) );
			setState(30);
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

	public static class Fsm_typeContext extends ParserRuleContext {
		public TerminalNode MOORE() { return getToken(MakefsmParser.MOORE, 0); }
		public TerminalNode MEALY() { return getToken(MakefsmParser.MEALY, 0); }
		public Fsm_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fsm_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).enterFsm_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakefsmParserListener ) ((MakefsmParserListener)listener).exitFsm_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitFsm_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fsm_typeContext fsm_type() throws RecognitionException {
		Fsm_typeContext _localctx = new Fsm_typeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fsm_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
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
		public Token name;
		public Token desc;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitFsm_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fsm_nameContext fsm_name() throws RecognitionException {
		Fsm_nameContext _localctx = new Fsm_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fsm_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(FSM);
			setState(35);
			((Fsm_nameContext)_localctx).name = match(ID);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(36);
					match(DESC);
					}
				}

				setState(39);
				((Fsm_nameContext)_localctx).desc = match(STRING);
				}
			}

			setState(42);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitStatus_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Status_listContext status_list() throws RecognitionException {
		Status_listContext _localctx = new Status_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_status_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(STATUS);
			setState(45);
			match(COLON);
			setState(46);
			def_status();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(47);
				match(COMMA);
				setState(48);
				def_status();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
		public Token statusName;
		public Token output;
		public Token statusDesc;
		public TerminalNode ID() { return getToken(MakefsmParser.ID, 0); }
		public TerminalNode SLASH() { return getToken(MakefsmParser.SLASH, 0); }
		public List<TerminalNode> STRING() { return getTokens(MakefsmParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MakefsmParser.STRING, i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitDef_status(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Def_statusContext def_status() throws RecognitionException {
		Def_statusContext _localctx = new Def_statusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_def_status);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((Def_statusContext)_localctx).statusName = match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(57);
				match(SLASH);
				setState(58);
				((Def_statusContext)_localctx).output = match(STRING);
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(61);
					match(DESC);
					}
				}

				setState(64);
				((Def_statusContext)_localctx).statusDesc = match(STRING);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statment);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				start_status();
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				end_status_list();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
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

	public static class Start_statusContext extends ParserRuleContext {
		public Token starter;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitStart_status(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_statusContext start_status() throws RecognitionException {
		Start_statusContext _localctx = new Start_statusContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_start_status);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(START);
			setState(73);
			match(EQUAL);
			setState(74);
			((Start_statusContext)_localctx).starter = match(ID);
			setState(75);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitEnd_status_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_status_listContext end_status_list() throws RecognitionException {
		End_status_listContext _localctx = new End_status_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_end_status_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(END);
			setState(78);
			match(EQUAL);
			setState(79);
			end_status();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80);
				match(COMMA);
				setState(81);
				end_status();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
		public Token ender;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitEnd_status(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_statusContext end_status() throws RecognitionException {
		End_statusContext _localctx = new End_statusContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_end_status);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			((End_statusContext)_localctx).ender = match(ID);
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
		public Token src;
		public Token dest;
		public Token eventName;
		public Token output;
		public Token eventDesc;
		public TerminalNode DIRECT() { return getToken(MakefsmParser.DIRECT, 0); }
		public TerminalNode LSB() { return getToken(MakefsmParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(MakefsmParser.RSB, 0); }
		public TerminalNode SEMI() { return getToken(MakefsmParser.SEMI, 0); }
		public List<TerminalNode> ID() { return getTokens(MakefsmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MakefsmParser.ID, i);
		}
		public TerminalNode SLASH() { return getToken(MakefsmParser.SLASH, 0); }
		public List<TerminalNode> STRING() { return getTokens(MakefsmParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MakefsmParser.STRING, i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakefsmParserVisitor ) return ((MakefsmParserVisitor<? extends T>)visitor).visitTransfer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransferContext transfer() throws RecognitionException {
		TransferContext _localctx = new TransferContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_transfer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((TransferContext)_localctx).src = match(ID);
			setState(92);
			match(DIRECT);
			setState(93);
			((TransferContext)_localctx).dest = match(ID);
			setState(94);
			match(LSB);
			setState(95);
			((TransferContext)_localctx).eventName = match(ID);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(96);
				match(SLASH);
				setState(97);
				((TransferContext)_localctx).output = match(STRING);
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESC || _la==STRING) {
				{
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESC) {
					{
					setState(100);
					match(DESC);
					}
				}

				setState(103);
				((TransferContext)_localctx).eventDesc = match(STRING);
				}
			}

			setState(106);
			match(RSB);
			setState(107);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31p\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\5\2\30\n\2\3\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\64\n\5\f"+
		"\5\16\5\67\13\5\3\5\3\5\3\6\3\6\3\6\5\6>\n\6\3\6\5\6A\n\6\3\6\5\6D\n\6"+
		"\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tU\n\t"+
		"\f\t\16\tX\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"e\n\13\3\13\5\13h\n\13\3\13\5\13k\n\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6"+
		"\b\n\f\16\20\22\24\2\3\3\2\16\17\2s\2\27\3\2\2\2\4\"\3\2\2\2\6$\3\2\2"+
		"\2\b.\3\2\2\2\n:\3\2\2\2\fH\3\2\2\2\16J\3\2\2\2\20O\3\2\2\2\22[\3\2\2"+
		"\2\24]\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2"+
		"\31\32\5\6\4\2\32\34\5\b\5\2\33\35\5\f\7\2\34\33\3\2\2\2\35\36\3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\2\2\3!\3\3\2\2\2\"#\t\2\2"+
		"\2#\5\3\2\2\2$%\7\3\2\2%*\7\22\2\2&(\7\4\2\2\'&\3\2\2\2\'(\3\2\2\2()\3"+
		"\2\2\2)+\7\30\2\2*\'\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\t\2\2-\7\3\2\2\2"+
		"./\7\5\2\2/\60\7\b\2\2\60\65\5\n\6\2\61\62\7\21\2\2\62\64\5\n\6\2\63\61"+
		"\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3"+
		"\2\2\289\7\t\2\29\t\3\2\2\2:=\7\22\2\2;<\7\20\2\2<>\7\30\2\2=;\3\2\2\2"+
		"=>\3\2\2\2>C\3\2\2\2?A\7\4\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BD\7\30\2"+
		"\2C@\3\2\2\2CD\3\2\2\2D\13\3\2\2\2EI\5\16\b\2FI\5\20\t\2GI\5\24\13\2H"+
		"E\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\r\3\2\2\2JK\7\6\2\2KL\7\r\2\2LM\7\22\2"+
		"\2MN\7\t\2\2N\17\3\2\2\2OP\7\7\2\2PQ\7\r\2\2QV\5\22\n\2RS\7\21\2\2SU\5"+
		"\22\n\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ"+
		"\7\t\2\2Z\21\3\2\2\2[\\\7\22\2\2\\\23\3\2\2\2]^\7\22\2\2^_\7\n\2\2_`\7"+
		"\22\2\2`a\7\13\2\2ad\7\22\2\2bc\7\20\2\2ce\7\30\2\2db\3\2\2\2de\3\2\2"+
		"\2ej\3\2\2\2fh\7\4\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ik\7\30\2\2jg\3\2"+
		"\2\2jk\3\2\2\2kl\3\2\2\2lm\7\f\2\2mn\7\t\2\2n\25\3\2\2\2\17\27\36\'*\65"+
		"=@CHVdgj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
