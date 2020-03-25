// Generated from E:/repo/mvn/makefsm/fsmmaker/src/main/resources/parser\MakefsmLexer.g4 by ANTLR 4.7.2

package  com.alan2lin.makefsm.parser.autogen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakefsmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FSM=1, DESC=2, STATUS=3, START=4, END=5, COLON=6, SEMI=7, DIRECT=8, LSB=9, 
		RSB=10, EQUAL=11, MOORE=12, MEALY=13, SLASH=14, COMMA=15, ID=16, INT=17, 
		LINE_COMMENT=18, BLOCK_COMMENT=19, SHELL_COMMENT=20, WS=21, STRING=22, 
		CHAR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FSM", "DESC", "STATUS", "START", "END", "COLON", "SEMI", "DIRECT", "LSB", 
			"RSB", "EQUAL", "MOORE", "MEALY", "SLASH", "COMMA", "ID", "INT", "LINE_COMMENT", 
			"BLOCK_COMMENT", "SHELL_COMMENT", "WS", "STRING", "CHAR", "HEX_DIGIT", 
			"ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC"
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


	public MakefsmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MakefsmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00d0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\7"+
		"\21s\n\21\f\21\16\21v\13\21\3\22\6\22y\n\22\r\22\16\22z\3\23\3\23\3\23"+
		"\3\23\7\23\u0081\n\23\f\23\16\23\u0084\13\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\7\24\u008c\n\24\f\24\16\24\u008f\13\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\7\25\u0098\n\25\f\25\16\25\u009b\13\25\3\25\3\25\3\26\6\26"+
		"\u00a0\n\26\r\26\16\26\u00a1\3\26\3\26\3\27\3\27\3\27\7\27\u00a9\n\27"+
		"\f\27\16\27\u00ac\13\27\3\27\3\27\3\30\3\30\3\30\5\30\u00b3\n\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u00bd\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u00c8\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\u008d\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65"+
		"\2\67\2\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\16\17\""+
		"\"\4\2$$^^\4\2))^^\5\2\62;CHch\n\2$$))^^ddhhppttvv\2\u00d8\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\39\3\2\2\2"+
		"\5=\3\2\2\2\7B\3\2\2\2\tI\3\2\2\2\13O\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21"+
		"W\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33f\3\2\2\2"+
		"\35l\3\2\2\2\37n\3\2\2\2!p\3\2\2\2#x\3\2\2\2%|\3\2\2\2\'\u0087\3\2\2\2"+
		")\u0095\3\2\2\2+\u009f\3\2\2\2-\u00a5\3\2\2\2/\u00af\3\2\2\2\61\u00b6"+
		"\3\2\2\2\63\u00bc\3\2\2\2\65\u00c7\3\2\2\2\67\u00c9\3\2\2\29:\7H\2\2:"+
		";\7U\2\2;<\7O\2\2<\4\3\2\2\2=>\7F\2\2>?\7G\2\2?@\7U\2\2@A\7E\2\2A\6\3"+
		"\2\2\2BC\7U\2\2CD\7V\2\2DE\7C\2\2EF\7V\2\2FG\7W\2\2GH\7U\2\2H\b\3\2\2"+
		"\2IJ\7U\2\2JK\7V\2\2KL\7C\2\2LM\7T\2\2MN\7V\2\2N\n\3\2\2\2OP\7G\2\2PQ"+
		"\7P\2\2QR\7F\2\2R\f\3\2\2\2ST\7<\2\2T\16\3\2\2\2UV\7=\2\2V\20\3\2\2\2"+
		"WX\7/\2\2XY\7@\2\2Y\22\3\2\2\2Z[\7]\2\2[\24\3\2\2\2\\]\7_\2\2]\26\3\2"+
		"\2\2^_\7?\2\2_\30\3\2\2\2`a\7O\2\2ab\7Q\2\2bc\7Q\2\2cd\7T\2\2de\7G\2\2"+
		"e\32\3\2\2\2fg\7O\2\2gh\7G\2\2hi\7C\2\2ij\7N\2\2jk\7[\2\2k\34\3\2\2\2"+
		"lm\7\61\2\2m\36\3\2\2\2no\7.\2\2o \3\2\2\2pt\t\2\2\2qs\t\3\2\2rq\3\2\2"+
		"\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\"\3\2\2\2vt\3\2\2\2wy\4\62;\2xw\3\2"+
		"\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{$\3\2\2\2|}\7\61\2\2}~\7\61\2\2~\u0082"+
		"\3\2\2\2\177\u0081\n\4\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0086\b\23\2\2\u0086&\3\2\2\2\u0087\u0088\7\61\2\2\u0088\u0089"+
		"\7,\2\2\u0089\u008d\3\2\2\2\u008a\u008c\13\2\2\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7,\2\2\u0091\u0092\7\61\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\b\24\2\2\u0094(\3\2\2\2\u0095\u0099\7%\2\2"+
		"\u0096\u0098\n\4\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\b\25\2\2\u009d*\3\2\2\2\u009e\u00a0\t\5\2\2\u009f\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\b\26\2\2\u00a4,\3\2\2\2\u00a5\u00aa\7$\2\2\u00a6"+
		"\u00a9\5\63\32\2\u00a7\u00a9\n\6\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3"+
		"\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae.\3\2\2\2\u00af"+
		"\u00b2\7)\2\2\u00b0\u00b3\5\63\32\2\u00b1\u00b3\n\7\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7)\2\2\u00b5"+
		"\60\3\2\2\2\u00b6\u00b7\t\b\2\2\u00b7\62\3\2\2\2\u00b8\u00b9\7^\2\2\u00b9"+
		"\u00bd\t\t\2\2\u00ba\u00bd\5\67\34\2\u00bb\u00bd\5\65\33\2\u00bc\u00b8"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\64\3\2\2\2\u00be"+
		"\u00bf\7^\2\2\u00bf\u00c0\4\62\65\2\u00c0\u00c1\4\629\2\u00c1\u00c8\4"+
		"\629\2\u00c2\u00c3\7^\2\2\u00c3\u00c4\4\629\2\u00c4\u00c8\4\629\2\u00c5"+
		"\u00c6\7^\2\2\u00c6\u00c8\4\629\2\u00c7\u00be\3\2\2\2\u00c7\u00c2\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c8\66\3\2\2\2\u00c9\u00ca\7^\2\2\u00ca\u00cb"+
		"\7w\2\2\u00cb\u00cc\5\61\31\2\u00cc\u00cd\5\61\31\2\u00cd\u00ce\5\61\31"+
		"\2\u00ce\u00cf\5\61\31\2\u00cf8\3\2\2\2\16\2tz\u0082\u008d\u0099\u00a1"+
		"\u00a8\u00aa\u00b2\u00bc\u00c7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}