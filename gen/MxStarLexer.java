// Generated from /Users/liuyuxi/Desktop/MxCompiler/src/MxStar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Null=2, BoolConst=3, StringConst=4, Number=5, Bool=6, Int=7, String=8, 
		Void=9, If=10, For=11, While=12, Break=13, Continue=14, Return=15, New=16, 
		Class=17, This=18, Identifier=19, WhiteSpace=20, BlockComment=21, LineComment=22, 
		Less=23, LessEqual=24, Greater=25, GreaterEqual=26, Equal=27, NotEqual=28, 
		Add=29, Sub=30, Mul=31, Div=32, Mod=33, AddAdd=34, SubSub=35, Assign=36, 
		LogicAnd=37, LogicOr=38, Not=39, BinaryAnd=40, BinaryOr=41, BinaryXor=42, 
		BinaryNot=43, LeftShift=44, RightShift=45, Semi=46, Comma=47, Dot=48, 
		LeftParen=49, RightParen=50, LeftBracket=51, RightBracket=52, LeftBrace=53, 
		RightBrace=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Null", "BoolConst", "StringConst", "Number", "Bool", "Int", "String", 
		"Void", "If", "For", "While", "Break", "Continue", "Return", "New", "Class", 
		"This", "Identifier", "WhiteSpace", "BlockComment", "LineComment", "Less", 
		"LessEqual", "Greater", "GreaterEqual", "Equal", "NotEqual", "Add", "Sub", 
		"Mul", "Div", "Mod", "AddAdd", "SubSub", "Assign", "LogicAnd", "LogicOr", 
		"Not", "BinaryAnd", "BinaryOr", "BinaryXor", "BinaryNot", "LeftShift", 
		"RightShift", "Semi", "Comma", "Dot", "LeftParen", "RightParen", "LeftBracket", 
		"RightBracket", "LeftBrace", "RightBrace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'else'", "'null'", null, null, null, "'bool'", "'int'", "'string'", 
		"'void'", "'if'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
		"'new'", "'class'", "'this'", null, null, null, null, "'<'", "'<='", "'>'", 
		"'>='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", 
		"'='", "'&&'", "'||'", "'!'", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", 
		"';'", "','", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Null", "BoolConst", "StringConst", "Number", "Bool", "Int", 
		"String", "Void", "If", "For", "While", "Break", "Continue", "Return", 
		"New", "Class", "This", "Identifier", "WhiteSpace", "BlockComment", "LineComment", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "Equal", "NotEqual", "Add", 
		"Sub", "Mul", "Div", "Mod", "AddAdd", "SubSub", "Assign", "LogicAnd", 
		"LogicOr", "Not", "BinaryAnd", "BinaryOr", "BinaryXor", "BinaryNot", "LeftShift", 
		"RightShift", "Semi", "Comma", "Dot", "LeftParen", "RightParen", "LeftBracket", 
		"RightBracket", "LeftBrace", "RightBrace"
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


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u014c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0083\n\4\3\5\3\5\3\5\3\5"+
		"\7\5\u0089\n\5\f\5\16\5\u008c\13\5\3\5\3\5\3\6\6\6\u0091\n\6\r\6\16\6"+
		"\u0092\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u00de"+
		"\n\24\f\24\16\24\u00e1\13\24\3\25\6\25\u00e4\n\25\r\25\16\25\u00e5\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\7\26\u00ee\n\26\f\26\16\26\u00f1\13\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00fc\n\27\f\27\16\27\u00ff"+
		"\13\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\4\u008a\u00ef\28\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8\3\2\b\b\2$$^^ddppt"+
		"tvv\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\3o\3\2\2\2\5t\3\2\2\2\7\u0082\3\2\2\2\t\u0084\3\2\2\2\13\u0090"+
		"\3\2\2\2\r\u0094\3\2\2\2\17\u0099\3\2\2\2\21\u009d\3\2\2\2\23\u00a4\3"+
		"\2\2\2\25\u00a9\3\2\2\2\27\u00ac\3\2\2\2\31\u00b0\3\2\2\2\33\u00b6\3\2"+
		"\2\2\35\u00bc\3\2\2\2\37\u00c5\3\2\2\2!\u00cc\3\2\2\2#\u00d0\3\2\2\2%"+
		"\u00d6\3\2\2\2\'\u00db\3\2\2\2)\u00e3\3\2\2\2+\u00e9\3\2\2\2-\u00f7\3"+
		"\2\2\2/\u0102\3\2\2\2\61\u0104\3\2\2\2\63\u0107\3\2\2\2\65\u0109\3\2\2"+
		"\2\67\u010c\3\2\2\29\u010f\3\2\2\2;\u0112\3\2\2\2=\u0114\3\2\2\2?\u0116"+
		"\3\2\2\2A\u0118\3\2\2\2C\u011a\3\2\2\2E\u011c\3\2\2\2G\u011f\3\2\2\2I"+
		"\u0122\3\2\2\2K\u0124\3\2\2\2M\u0127\3\2\2\2O\u012a\3\2\2\2Q\u012c\3\2"+
		"\2\2S\u012e\3\2\2\2U\u0130\3\2\2\2W\u0132\3\2\2\2Y\u0134\3\2\2\2[\u0137"+
		"\3\2\2\2]\u013a\3\2\2\2_\u013c\3\2\2\2a\u013e\3\2\2\2c\u0140\3\2\2\2e"+
		"\u0142\3\2\2\2g\u0144\3\2\2\2i\u0146\3\2\2\2k\u0148\3\2\2\2m\u014a\3\2"+
		"\2\2op\7g\2\2pq\7n\2\2qr\7u\2\2rs\7g\2\2s\4\3\2\2\2tu\7p\2\2uv\7w\2\2"+
		"vw\7n\2\2wx\7n\2\2x\6\3\2\2\2yz\7v\2\2z{\7t\2\2{|\7w\2\2|\u0083\7g\2\2"+
		"}~\7h\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080\u0081\7u\2\2\u0081\u0083"+
		"\7g\2\2\u0082y\3\2\2\2\u0082}\3\2\2\2\u0083\b\3\2\2\2\u0084\u008a\7$\2"+
		"\2\u0085\u0086\7^\2\2\u0086\u0089\t\2\2\2\u0087\u0089\13\2\2\2\u0088\u0085"+
		"\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7$"+
		"\2\2\u008e\n\3\2\2\2\u008f\u0091\t\3\2\2\u0090\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\f\3\2\2\2\u0094"+
		"\u0095\7d\2\2\u0095\u0096\7q\2\2\u0096\u0097\7q\2\2\u0097\u0098\7n\2\2"+
		"\u0098\16\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b\u009c\7"+
		"v\2\2\u009c\20\3\2\2\2\u009d\u009e\7u\2\2\u009e\u009f\7v\2\2\u009f\u00a0"+
		"\7t\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7i\2\2\u00a3"+
		"\22\3\2\2\2\u00a4\u00a5\7x\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7k\2\2\u00a7"+
		"\u00a8\7f\2\2\u00a8\24\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7h\2\2\u00ab"+
		"\26\3\2\2\2\u00ac\u00ad\7h\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\30\3\2\2\2\u00b0\u00b1\7y\2\2\u00b1\u00b2\7j\2\2\u00b2\u00b3\7k\2\2\u00b3"+
		"\u00b4\7n\2\2\u00b4\u00b5\7g\2\2\u00b5\32\3\2\2\2\u00b6\u00b7\7d\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7m\2\2"+
		"\u00bb\34\3\2\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be\7q\2\2\u00be\u00bf\7"+
		"p\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3"+
		"\7w\2\2\u00c3\u00c4\7g\2\2\u00c4\36\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7"+
		"\7g\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7p\2\2\u00cb \3\2\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\u00cf\7y\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2\7n\2\2\u00d2"+
		"\u00d3\7c\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7u\2\2\u00d5$\3\2\2\2\u00d6"+
		"\u00d7\7v\2\2\u00d7\u00d8\7j\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7u\2\2"+
		"\u00da&\3\2\2\2\u00db\u00df\t\4\2\2\u00dc\u00de\t\5\2\2\u00dd\u00dc\3"+
		"\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"(\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\t\6\2\2\u00e3\u00e2\3\2\2\2"+
		"\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e8\b\25\2\2\u00e8*\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea"+
		"\u00eb\7,\2\2\u00eb\u00ef\3\2\2\2\u00ec\u00ee\13\2\2\2\u00ed\u00ec\3\2"+
		"\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3\u00f4\7\61"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\26\2\2\u00f6,\3\2\2\2\u00f7\u00f8"+
		"\7\61\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fd\3\2\2\2\u00fa\u00fc\n\7\2\2"+
		"\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\b\27\2\2"+
		"\u0101.\3\2\2\2\u0102\u0103\7>\2\2\u0103\60\3\2\2\2\u0104\u0105\7>\2\2"+
		"\u0105\u0106\7?\2\2\u0106\62\3\2\2\2\u0107\u0108\7@\2\2\u0108\64\3\2\2"+
		"\2\u0109\u010a\7@\2\2\u010a\u010b\7?\2\2\u010b\66\3\2\2\2\u010c\u010d"+
		"\7?\2\2\u010d\u010e\7?\2\2\u010e8\3\2\2\2\u010f\u0110\7#\2\2\u0110\u0111"+
		"\7?\2\2\u0111:\3\2\2\2\u0112\u0113\7-\2\2\u0113<\3\2\2\2\u0114\u0115\7"+
		"/\2\2\u0115>\3\2\2\2\u0116\u0117\7,\2\2\u0117@\3\2\2\2\u0118\u0119\7\61"+
		"\2\2\u0119B\3\2\2\2\u011a\u011b\7\'\2\2\u011bD\3\2\2\2\u011c\u011d\7-"+
		"\2\2\u011d\u011e\7-\2\2\u011eF\3\2\2\2\u011f\u0120\7/\2\2\u0120\u0121"+
		"\7/\2\2\u0121H\3\2\2\2\u0122\u0123\7?\2\2\u0123J\3\2\2\2\u0124\u0125\7"+
		"(\2\2\u0125\u0126\7(\2\2\u0126L\3\2\2\2\u0127\u0128\7~\2\2\u0128\u0129"+
		"\7~\2\2\u0129N\3\2\2\2\u012a\u012b\7#\2\2\u012bP\3\2\2\2\u012c\u012d\7"+
		"(\2\2\u012dR\3\2\2\2\u012e\u012f\7~\2\2\u012fT\3\2\2\2\u0130\u0131\7`"+
		"\2\2\u0131V\3\2\2\2\u0132\u0133\7\u0080\2\2\u0133X\3\2\2\2\u0134\u0135"+
		"\7>\2\2\u0135\u0136\7>\2\2\u0136Z\3\2\2\2\u0137\u0138\7@\2\2\u0138\u0139"+
		"\7@\2\2\u0139\\\3\2\2\2\u013a\u013b\7=\2\2\u013b^\3\2\2\2\u013c\u013d"+
		"\7.\2\2\u013d`\3\2\2\2\u013e\u013f\7\60\2\2\u013fb\3\2\2\2\u0140\u0141"+
		"\7*\2\2\u0141d\3\2\2\2\u0142\u0143\7+\2\2\u0143f\3\2\2\2\u0144\u0145\7"+
		"]\2\2\u0145h\3\2\2\2\u0146\u0147\7_\2\2\u0147j\3\2\2\2\u0148\u0149\7}"+
		"\2\2\u0149l\3\2\2\2\u014a\u014b\7\177\2\2\u014bn\3\2\2\2\13\2\u0082\u0088"+
		"\u008a\u0092\u00df\u00e5\u00ef\u00fd\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}