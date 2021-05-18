// Generated from /home/alessandro/Scrivania/laboratori/lab03-automi-2021/pascal/pascal.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pascalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, PLUS=20, MINUS=21, MULT=22, DIV=23, MOD=24, AND=25, 
		OR=26, NOT=27, EQ=28, LT=29, LEQ=30, GT=31, GEQ=32, NEQ=33, ID=34, NUMBER=35, 
		STRING=36, R_COMMENT=37, C_COMMENT=38, LINE_COMMENT=39, WS=40, ErrorChar=41;
	public static final int
		RULE_start = 0, RULE_decl_list = 1, RULE_decl = 2, RULE_id_list = 3, RULE_main_code = 4, 
		RULE_code_block = 5, RULE_st_list = 6, RULE_statement = 7, RULE_assign = 8, 
		RULE_out = 9, RULE_in = 10, RULE_branch = 11, RULE_loop = 12, RULE_expr = 13, 
		RULE_guard = 14, RULE_relation = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "decl_list", "decl", "id_list", "main_code", "code_block", "st_list", 
			"statement", "assign", "out", "in", "branch", "loop", "expr", "guard", 
			"relation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "';'", "'var'", "':'", "'integer'", "','", "'begin'", 
			"'end'", "'.'", "':='", "'writeln'", "'('", "')'", "'readln'", "'if'", 
			"'then'", "'else'", "'repeat'", "'until'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'and'", "'or'", "'not'", "'='", "'<'", "'<='", "'>'", "'>='", 
			"'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "AND", "OR", "NOT", "EQ", "LT", "LEQ", "GT", "GEQ", "NEQ", 
			"ID", "NUMBER", "STRING", "R_COMMENT", "C_COMMENT", "LINE_COMMENT", "WS", 
			"ErrorChar"
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
	public String getGrammarFileName() { return "pascal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public pascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pascalParser.ID, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Main_codeContext main_code() {
			return getRuleContext(Main_codeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(pascalParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(ID);
			setState(34);
			match(T__1);
			setState(35);
			match(T__2);
			setState(36);
			decl_list();
			setState(37);
			main_code();
			setState(38);
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

	public static class Decl_listContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_list; }
	}

	public final Decl_listContext decl_list() throws RecognitionException {
		Decl_listContext _localctx = new Decl_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_list);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				decl();
				setState(42);
				decl_list();
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

	public static class DeclContext extends ParserRuleContext {
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			id_list();
			setState(47);
			match(T__3);
			setState(48);
			match(T__4);
			setState(49);
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

	public static class Id_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pascalParser.ID, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_id_list);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(ID);
				setState(53);
				match(T__5);
				setState(54);
				id_list();
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

	public static class Main_codeContext extends ParserRuleContext {
		public St_listContext st_list() {
			return getRuleContext(St_listContext.class,0);
		}
		public Main_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_code; }
	}

	public final Main_codeContext main_code() throws RecognitionException {
		Main_codeContext _localctx = new Main_codeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_main_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__6);
			setState(58);
			st_list();
			setState(59);
			match(T__7);
			setState(60);
			match(T__8);
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

	public static class Code_blockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public St_listContext st_list() {
			return getRuleContext(St_listContext.class,0);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_code_block);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__17:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				statement();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__6);
				setState(64);
				st_list();
				setState(65);
				match(T__7);
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

	public static class St_listContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public St_listContext st_list() {
			return getRuleContext(St_listContext.class,0);
		}
		public St_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_list; }
	}

	public final St_listContext st_list() throws RecognitionException {
		St_listContext _localctx = new St_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_st_list);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				statement();
				setState(70);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				statement();
				setState(73);
				match(T__1);
				setState(74);
				st_list();
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

	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public OutContext out() {
			return getRuleContext(OutContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				assign();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				branch();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				out();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				loop();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				in();
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pascalParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ID);
			setState(86);
			match(T__9);
			setState(87);
			expr(0);
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

	public static class OutContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(pascalParser.STRING, 0); }
		public OutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_out; }
	}

	public final OutContext out() throws RecognitionException {
		OutContext _localctx = new OutContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_out);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(T__10);
				setState(90);
				match(T__11);
				setState(91);
				expr(0);
				setState(92);
				match(T__12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(T__10);
				setState(95);
				match(T__11);
				setState(96);
				match(STRING);
				setState(97);
				match(T__12);
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

	public static class InContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pascalParser.ID, 0); }
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__13);
			setState(101);
			match(T__11);
			setState(102);
			match(ID);
			setState(103);
			match(T__12);
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

	public static class BranchContext extends ParserRuleContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public List<Code_blockContext> code_block() {
			return getRuleContexts(Code_blockContext.class);
		}
		public Code_blockContext code_block(int i) {
			return getRuleContext(Code_blockContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_branch);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__14);
				setState(106);
				guard(0);
				setState(107);
				match(T__15);
				setState(108);
				code_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__14);
				setState(111);
				guard(0);
				setState(112);
				match(T__15);
				setState(113);
				code_block();
				setState(114);
				match(T__16);
				setState(115);
				code_block();
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

	public static class LoopContext extends ParserRuleContext {
		public St_listContext st_list() {
			return getRuleContext(St_listContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__17);
			setState(120);
			st_list();
			setState(121);
			match(T__18);
			setState(122);
			guard(0);
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

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(pascalParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(pascalParser.ID, 0); }
		public TerminalNode MOD() { return getToken(pascalParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(pascalParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(pascalParser.MULT, 0); }
		public TerminalNode MINUS() { return getToken(pascalParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(pascalParser.PLUS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(125);
				match(T__11);
				setState(126);
				expr(0);
				setState(127);
				match(T__12);
				}
				break;
			case 3:
				{
				setState(129);
				match(NUMBER);
				}
				break;
			case 4:
				{
				setState(130);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(134);
						match(MOD);
						setState(135);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(137);
						match(DIV);
						setState(138);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(140);
						match(MULT);
						setState(141);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(143);
						match(MINUS);
						setState(144);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(146);
						match(PLUS);
						setState(147);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class GuardContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(pascalParser.NOT, 0); }
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode AND() { return getToken(pascalParser.AND, 0); }
		public TerminalNode OR() { return getToken(pascalParser.OR, 0); }
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
	}

	public final GuardContext guard() throws RecognitionException {
		return guard(0);
	}

	private GuardContext guard(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardContext _localctx = new GuardContext(_ctx, _parentState);
		GuardContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_guard, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(154);
				match(NOT);
				setState(155);
				guard(5);
				}
				break;
			case 2:
				{
				setState(156);
				match(T__11);
				setState(157);
				guard(0);
				setState(158);
				match(T__12);
				}
				break;
			case 3:
				{
				setState(160);
				relation();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new GuardContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_guard);
						setState(163);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(164);
						match(AND);
						setState(165);
						guard(5);
						}
						break;
					case 2:
						{
						_localctx = new GuardContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_guard);
						setState(166);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(167);
						match(OR);
						setState(168);
						guard(4);
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class RelationContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(pascalParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(pascalParser.LEQ, 0); }
		public TerminalNode EQ() { return getToken(pascalParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(pascalParser.NEQ, 0); }
		public TerminalNode GEQ() { return getToken(pascalParser.GEQ, 0); }
		public TerminalNode GT() { return getToken(pascalParser.GT, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_relation);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				expr(0);
				setState(175);
				match(LT);
				setState(176);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				expr(0);
				setState(179);
				match(LEQ);
				setState(180);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				expr(0);
				setState(183);
				match(EQ);
				setState(184);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				expr(0);
				setState(187);
				match(NEQ);
				setState(188);
				expr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				expr(0);
				setState(191);
				match(GEQ);
				setState(192);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				expr(0);
				setState(195);
				match(GT);
				setState(196);
				expr(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 14:
			return guard_sempred((GuardContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean guard_sempred(GuardContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7F\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3\t\5\tV\n\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13e\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\rx\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u0086\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u0097\n\17\f\17\16\17\u009a\13\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a4\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00ac\n\20\f\20\16\20\u00af\13\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00c9\n\21\3\21\2\4\34\36\22\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00d5\2\"\3\2\2\2\4.\3\2\2\2\6\60"+
		"\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\fE\3\2\2\2\16N\3\2\2\2\20U\3\2\2\2\22W"+
		"\3\2\2\2\24d\3\2\2\2\26f\3\2\2\2\30w\3\2\2\2\32y\3\2\2\2\34\u0085\3\2"+
		"\2\2\36\u00a3\3\2\2\2 \u00c8\3\2\2\2\"#\7\3\2\2#$\7$\2\2$%\7\4\2\2%&\7"+
		"\5\2\2&\'\5\4\3\2\'(\5\n\6\2()\7\2\2\3)\3\3\2\2\2*/\5\6\4\2+,\5\6\4\2"+
		",-\5\4\3\2-/\3\2\2\2.*\3\2\2\2.+\3\2\2\2/\5\3\2\2\2\60\61\5\b\5\2\61\62"+
		"\7\6\2\2\62\63\7\7\2\2\63\64\7\4\2\2\64\7\3\2\2\2\65:\7$\2\2\66\67\7$"+
		"\2\2\678\7\b\2\28:\5\b\5\29\65\3\2\2\29\66\3\2\2\2:\t\3\2\2\2;<\7\t\2"+
		"\2<=\5\16\b\2=>\7\n\2\2>?\7\13\2\2?\13\3\2\2\2@F\5\20\t\2AB\7\t\2\2BC"+
		"\5\16\b\2CD\7\n\2\2DF\3\2\2\2E@\3\2\2\2EA\3\2\2\2F\r\3\2\2\2GH\5\20\t"+
		"\2HI\7\4\2\2IO\3\2\2\2JK\5\20\t\2KL\7\4\2\2LM\5\16\b\2MO\3\2\2\2NG\3\2"+
		"\2\2NJ\3\2\2\2O\17\3\2\2\2PV\5\22\n\2QV\5\30\r\2RV\5\24\13\2SV\5\32\16"+
		"\2TV\5\26\f\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\21\3"+
		"\2\2\2WX\7$\2\2XY\7\f\2\2YZ\5\34\17\2Z\23\3\2\2\2[\\\7\r\2\2\\]\7\16\2"+
		"\2]^\5\34\17\2^_\7\17\2\2_e\3\2\2\2`a\7\r\2\2ab\7\16\2\2bc\7&\2\2ce\7"+
		"\17\2\2d[\3\2\2\2d`\3\2\2\2e\25\3\2\2\2fg\7\20\2\2gh\7\16\2\2hi\7$\2\2"+
		"ij\7\17\2\2j\27\3\2\2\2kl\7\21\2\2lm\5\36\20\2mn\7\22\2\2no\5\f\7\2ox"+
		"\3\2\2\2pq\7\21\2\2qr\5\36\20\2rs\7\22\2\2st\5\f\7\2tu\7\23\2\2uv\5\f"+
		"\7\2vx\3\2\2\2wk\3\2\2\2wp\3\2\2\2x\31\3\2\2\2yz\7\24\2\2z{\5\16\b\2{"+
		"|\7\25\2\2|}\5\36\20\2}\33\3\2\2\2~\u0086\b\17\1\2\177\u0080\7\16\2\2"+
		"\u0080\u0081\5\34\17\2\u0081\u0082\7\17\2\2\u0082\u0086\3\2\2\2\u0083"+
		"\u0086\7%\2\2\u0084\u0086\7$\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u0098\3\2\2\2\u0087\u0088\f\13"+
		"\2\2\u0088\u0089\7\32\2\2\u0089\u0097\5\34\17\f\u008a\u008b\f\n\2\2\u008b"+
		"\u008c\7\31\2\2\u008c\u0097\5\34\17\13\u008d\u008e\f\t\2\2\u008e\u008f"+
		"\7\30\2\2\u008f\u0097\5\34\17\n\u0090\u0091\f\b\2\2\u0091\u0092\7\27\2"+
		"\2\u0092\u0097\5\34\17\t\u0093\u0094\f\7\2\2\u0094\u0095\7\26\2\2\u0095"+
		"\u0097\5\34\17\b\u0096\u0087\3\2\2\2\u0096\u008a\3\2\2\2\u0096\u008d\3"+
		"\2\2\2\u0096\u0090\3\2\2\2\u0096\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\35\3\2\2\2\u009a\u0098\3\2\2"+
		"\2\u009b\u009c\b\20\1\2\u009c\u009d\7\35\2\2\u009d\u00a4\5\36\20\7\u009e"+
		"\u009f\7\16\2\2\u009f\u00a0\5\36\20\2\u00a0\u00a1\7\17\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a4\5 \21\2\u00a3\u009b\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00ad\3\2\2\2\u00a5\u00a6\f\6\2\2\u00a6\u00a7\7\33"+
		"\2\2\u00a7\u00ac\5\36\20\7\u00a8\u00a9\f\5\2\2\u00a9\u00aa\7\34\2\2\u00aa"+
		"\u00ac\5\36\20\6\u00ab\u00a5\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\37\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\5\34\17\2\u00b1\u00b2\7\37\2\2\u00b2\u00b3"+
		"\5\34\17\2\u00b3\u00c9\3\2\2\2\u00b4\u00b5\5\34\17\2\u00b5\u00b6\7 \2"+
		"\2\u00b6\u00b7\5\34\17\2\u00b7\u00c9\3\2\2\2\u00b8\u00b9\5\34\17\2\u00b9"+
		"\u00ba\7\36\2\2\u00ba\u00bb\5\34\17\2\u00bb\u00c9\3\2\2\2\u00bc\u00bd"+
		"\5\34\17\2\u00bd\u00be\7#\2\2\u00be\u00bf\5\34\17\2\u00bf\u00c9\3\2\2"+
		"\2\u00c0\u00c1\5\34\17\2\u00c1\u00c2\7\"\2\2\u00c2\u00c3\5\34\17\2\u00c3"+
		"\u00c9\3\2\2\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\7!\2\2\u00c6\u00c7\5"+
		"\34\17\2\u00c7\u00c9\3\2\2\2\u00c8\u00b0\3\2\2\2\u00c8\u00b4\3\2\2\2\u00c8"+
		"\u00b8\3\2\2\2\u00c8\u00bc\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c4\3\2"+
		"\2\2\u00c9!\3\2\2\2\20.9ENUdw\u0085\u0096\u0098\u00a3\u00ab\u00ad\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}