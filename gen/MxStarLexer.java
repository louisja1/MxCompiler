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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, Null=34, BoolConst=35, StringConst=36, Number=37, 
		Bool=38, Int=39, String=40, Void=41, If=42, For=43, While=44, Break=45, 
		Continue=46, Return=47, New=48, Class=49, This=50, Identifier=51, WhiteSpace=52, 
		BlockComment=53, LineComment=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"Null", "BoolConst", "StringConst", "Number", "Bool", "Int", "String", 
		"Void", "If", "For", "While", "Break", "Continue", "Return", "New", "Class", 
		"This", "Identifier", "WhiteSpace", "BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'{'", "'}'", "';'", "'['", "']'", "'.'", "'++'", 
		"'--'", "'+'", "'-'", "'~'", "'!'", "'<<'", "'>>'", "'*'", "'/'", "'%'", 
		"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'&'", "'^'", "'|'", "'&&'", 
		"'||'", "'='", "'else'", "'null'", null, null, null, "'bool'", "'int'", 
		"'string'", "'void'", "'if'", "'for'", "'while'", "'break'", "'continue'", 
		"'return'", "'new'", "'class'", "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "Null", "BoolConst", 
		"StringConst", "Number", "Bool", "Int", "String", "Void", "If", "For", 
		"While", "Break", "Continue", "Return", "New", "Class", "This", "Identifier", 
		"WhiteSpace", "BlockComment", "LineComment"
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
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\5$\u00cd\n$\3%\3%\3%\3%\7%\u00d3\n%\f%\16%\u00d6\13%"+
		"\3%\3%\3&\6&\u00db\n&\r&\16&\u00dc\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)"+
		"\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-"+
		"\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\64\3\64\7\64\u0128\n\64\f\64\16\64\u012b\13\64\3"+
		"\65\6\65\u012e\n\65\r\65\16\65\u012f\3\65\3\65\3\66\3\66\3\66\3\66\7\66"+
		"\u0138\n\66\f\66\16\66\u013b\13\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\7\67\u0146\n\67\f\67\16\67\u0149\13\67\3\67\3\67\4\u00d4\u0139"+
		"\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8\3\2\b\b\2$$^^ddppttvv\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7s\3\2\2\2\tu\3"+
		"\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21}\3\2\2\2\23\177\3\2\2\2\25"+
		"\u0081\3\2\2\2\27\u0084\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008b"+
		"\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0092\3\2\2\2%\u0095\3\2\2\2"+
		"\'\u0097\3\2\2\2)\u0099\3\2\2\2+\u009b\3\2\2\2-\u009e\3\2\2\2/\u00a1\3"+
		"\2\2\2\61\u00a3\3\2\2\2\63\u00a6\3\2\2\2\65\u00a8\3\2\2\2\67\u00ab\3\2"+
		"\2\29\u00ad\3\2\2\2;\u00af\3\2\2\2=\u00b1\3\2\2\2?\u00b4\3\2\2\2A\u00b7"+
		"\3\2\2\2C\u00b9\3\2\2\2E\u00be\3\2\2\2G\u00cc\3\2\2\2I\u00ce\3\2\2\2K"+
		"\u00da\3\2\2\2M\u00de\3\2\2\2O\u00e3\3\2\2\2Q\u00e7\3\2\2\2S\u00ee\3\2"+
		"\2\2U\u00f3\3\2\2\2W\u00f6\3\2\2\2Y\u00fa\3\2\2\2[\u0100\3\2\2\2]\u0106"+
		"\3\2\2\2_\u010f\3\2\2\2a\u0116\3\2\2\2c\u011a\3\2\2\2e\u0120\3\2\2\2g"+
		"\u0125\3\2\2\2i\u012d\3\2\2\2k\u0133\3\2\2\2m\u0141\3\2\2\2op\7*\2\2p"+
		"\4\3\2\2\2qr\7.\2\2r\6\3\2\2\2st\7+\2\2t\b\3\2\2\2uv\7}\2\2v\n\3\2\2\2"+
		"wx\7\177\2\2x\f\3\2\2\2yz\7=\2\2z\16\3\2\2\2{|\7]\2\2|\20\3\2\2\2}~\7"+
		"_\2\2~\22\3\2\2\2\177\u0080\7\60\2\2\u0080\24\3\2\2\2\u0081\u0082\7-\2"+
		"\2\u0082\u0083\7-\2\2\u0083\26\3\2\2\2\u0084\u0085\7/\2\2\u0085\u0086"+
		"\7/\2\2\u0086\30\3\2\2\2\u0087\u0088\7-\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7/\2\2\u008a\34\3\2\2\2\u008b\u008c\7\u0080\2\2\u008c\36\3\2\2\2\u008d"+
		"\u008e\7#\2\2\u008e \3\2\2\2\u008f\u0090\7>\2\2\u0090\u0091\7>\2\2\u0091"+
		"\"\3\2\2\2\u0092\u0093\7@\2\2\u0093\u0094\7@\2\2\u0094$\3\2\2\2\u0095"+
		"\u0096\7,\2\2\u0096&\3\2\2\2\u0097\u0098\7\61\2\2\u0098(\3\2\2\2\u0099"+
		"\u009a\7\'\2\2\u009a*\3\2\2\2\u009b\u009c\7?\2\2\u009c\u009d\7?\2\2\u009d"+
		",\3\2\2\2\u009e\u009f\7#\2\2\u009f\u00a0\7?\2\2\u00a0.\3\2\2\2\u00a1\u00a2"+
		"\7>\2\2\u00a2\60\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4\u00a5\7?\2\2\u00a5\62"+
		"\3\2\2\2\u00a6\u00a7\7@\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9"+
		"\u00aa\7?\2\2\u00aa\66\3\2\2\2\u00ab\u00ac\7(\2\2\u00ac8\3\2\2\2\u00ad"+
		"\u00ae\7`\2\2\u00ae:\3\2\2\2\u00af\u00b0\7~\2\2\u00b0<\3\2\2\2\u00b1\u00b2"+
		"\7(\2\2\u00b2\u00b3\7(\2\2\u00b3>\3\2\2\2\u00b4\u00b5\7~\2\2\u00b5\u00b6"+
		"\7~\2\2\u00b6@\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8B\3\2\2\2\u00b9\u00ba\7"+
		"g\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7g\2\2\u00bdD"+
		"\3\2\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7n\2\2\u00c2F\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7t\2\2\u00c5"+
		"\u00c6\7w\2\2\u00c6\u00cd\7g\2\2\u00c7\u00c8\7h\2\2\u00c8\u00c9\7c\2\2"+
		"\u00c9\u00ca\7n\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cd\7g\2\2\u00cc\u00c3"+
		"\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cdH\3\2\2\2\u00ce\u00d4\7$\2\2\u00cf\u00d0"+
		"\7^\2\2\u00d0\u00d3\t\2\2\2\u00d1\u00d3\13\2\2\2\u00d2\u00cf\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7$\2\2\u00d8"+
		"J\3\2\2\2\u00d9\u00db\t\3\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2"+
		"\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00ddL\3\2\2\2\u00de\u00df\7"+
		"d\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7n\2\2\u00e2N"+
		"\3\2\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"P\3\2\2\2\u00e7\u00e8\7u\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7t\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7i\2\2\u00edR\3\2\2\2\u00ee"+
		"\u00ef\7x\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7f\2\2"+
		"\u00f2T\3\2\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7h\2\2\u00f5V\3\2\2\2\u00f6"+
		"\u00f7\7h\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7t\2\2\u00f9X\3\2\2\2\u00fa"+
		"\u00fb\7y\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7n\2\2"+
		"\u00fe\u00ff\7g\2\2\u00ffZ\3\2\2\2\u0100\u0101\7d\2\2\u0101\u0102\7t\2"+
		"\2\u0102\u0103\7g\2\2\u0103\u0104\7c\2\2\u0104\u0105\7m\2\2\u0105\\\3"+
		"\2\2\2\u0106\u0107\7e\2\2\u0107\u0108\7q\2\2\u0108\u0109\7p\2\2\u0109"+
		"\u010a\7v\2\2\u010a\u010b\7k\2\2\u010b\u010c\7p\2\2\u010c\u010d\7w\2\2"+
		"\u010d\u010e\7g\2\2\u010e^\3\2\2\2\u010f\u0110\7t\2\2\u0110\u0111\7g\2"+
		"\2\u0111\u0112\7v\2\2\u0112\u0113\7w\2\2\u0113\u0114\7t\2\2\u0114\u0115"+
		"\7p\2\2\u0115`\3\2\2\2\u0116\u0117\7p\2\2\u0117\u0118\7g\2\2\u0118\u0119"+
		"\7y\2\2\u0119b\3\2\2\2\u011a\u011b\7e\2\2\u011b\u011c\7n\2\2\u011c\u011d"+
		"\7c\2\2\u011d\u011e\7u\2\2\u011e\u011f\7u\2\2\u011fd\3\2\2\2\u0120\u0121"+
		"\7v\2\2\u0121\u0122\7j\2\2\u0122\u0123\7k\2\2\u0123\u0124\7u\2\2\u0124"+
		"f\3\2\2\2\u0125\u0129\t\4\2\2\u0126\u0128\t\5\2\2\u0127\u0126\3\2\2\2"+
		"\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012ah\3"+
		"\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\t\6\2\2\u012d\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0132\b\65\2\2\u0132j\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135"+
		"\7,\2\2\u0135\u0139\3\2\2\2\u0136\u0138\13\2\2\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013b\3\2\2\2\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\61\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0140\b\66\2\2\u0140l\3\2\2\2\u0141\u0142\7\61\2"+
		"\2\u0142\u0143\7\61\2\2\u0143\u0147\3\2\2\2\u0144\u0146\n\7\2\2\u0145"+
		"\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\b\67\2\2\u014b"+
		"n\3\2\2\2\13\2\u00cc\u00d2\u00d4\u00dc\u0129\u012f\u0139\u0147\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}