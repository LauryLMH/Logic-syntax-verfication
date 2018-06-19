// Generated from /IdeaProjects/CTL/src\CTL.g4 by ANTLR 4.7

package com.ctl.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, AND=3, OR=4, BICONDITIONAL=5, IMPLIES=6, NOT=7, CTLOpUnary=8, 
		CTLOpBinary=9, PropertyID=10, ID=11, PAREN_OPEN=12, PAREN_CLOSE=13;
	public static final int
		RULE_parenExpr = 0, RULE_ctlExpr = 1, RULE_expr = 2;
	public static final String[] ruleNames = {
		"parenExpr", "ctlExpr", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'&'", "'|'", "'<->'", "'->'", "'!'", null, null, null, 
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "WS", "AND", "OR", "BICONDITIONAL", "IMPLIES", "NOT", "CTLOpUnary", 
		"CTLOpBinary", "PropertyID", "ID", "PAREN_OPEN", "PAREN_CLOSE"
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
	public String getGrammarFileName() { return "CTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParenExprContext extends ParserRuleContext {
		public TerminalNode PAREN_OPEN() { return getToken(CTLParser.PAREN_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(CTLParser.PAREN_CLOSE, 0); }
		public ParenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExprContext parenExpr() throws RecognitionException {
		ParenExprContext _localctx = new ParenExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parenExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(PAREN_OPEN);
			setState(7);
			expr(0);
			setState(8);
			match(PAREN_CLOSE);
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

	public static class CtlExprContext extends ParserRuleContext {
		public CtlExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlExpr; }
	 
		public CtlExprContext() { }
		public void copyFrom(CtlExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryCTLContext extends CtlExprContext {
		public TerminalNode CTLOpBinary() { return getToken(CTLParser.CTLOpBinary, 0); }
		public TerminalNode PAREN_OPEN() { return getToken(CTLParser.PAREN_OPEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(CTLParser.PAREN_CLOSE, 0); }
		public BinaryCTLContext(CtlExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterBinaryCTL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitBinaryCTL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitBinaryCTL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryCTLContext extends CtlExprContext {
		public TerminalNode CTLOpUnary() { return getToken(CTLParser.CTLOpUnary, 0); }
		public ParenExprContext parenExpr() {
			return getRuleContext(ParenExprContext.class,0);
		}
		public UnaryCTLContext(CtlExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterUnaryCTL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitUnaryCTL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitUnaryCTL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtlExprContext ctlExpr() throws RecognitionException {
		CtlExprContext _localctx = new CtlExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ctlExpr);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CTLOpUnary:
				_localctx = new UnaryCTLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				match(CTLOpUnary);
				setState(11);
				parenExpr();
				}
				break;
			case CTLOpBinary:
				_localctx = new BinaryCTLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				match(CTLOpBinary);
				setState(13);
				match(PAREN_OPEN);
				setState(14);
				expr(0);
				setState(15);
				match(T__0);
				setState(16);
				expr(0);
				setState(17);
				match(PAREN_CLOSE);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CTLParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(CTLParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IMPLIES() { return getToken(CTLParser.IMPLIES, 0); }
		public ImpliesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(CTLParser.AND, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BiconditionalContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BICONDITIONAL() { return getToken(CTLParser.BICONDITIONAL, 0); }
		public BiconditionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterBiconditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitBiconditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitBiconditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CTLContext extends ExprContext {
		public CtlExprContext ctlExpr() {
			return getRuleContext(CtlExprContext.class,0);
		}
		public CTLContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterCTL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitCTL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitCTL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PropertyContext extends ExprContext {
		public TerminalNode PropertyID() { return getToken(CTLParser.PropertyID, 0); }
		public PropertyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExprContext {
		public ParenExprContext parenExpr() {
			return getRuleContext(ParenExprContext.class,0);
		}
		public ParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CTLListener ) ((CTLListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CTLVisitor ) return ((CTLVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAREN_OPEN:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(22);
				parenExpr();
				}
				break;
			case CTLOpUnary:
			case CTLOpBinary:
				{
				_localctx = new CTLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				ctlExpr();
				}
				break;
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(NOT);
				setState(25);
				expr(6);
				}
				break;
			case PropertyID:
				{
				_localctx = new PropertyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(PropertyID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(29);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(30);
						match(AND);
						setState(31);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(32);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(33);
						match(OR);
						setState(34);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new BiconditionalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(35);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(36);
						match(BICONDITIONAL);
						setState(37);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ImpliesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(38);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(39);
						match(IMPLIES);
						setState(40);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\26"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\36\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\2\3\6\5\2\4\6\2\2\2\65"+
		"\2\b\3\2\2\2\4\25\3\2\2\2\6\35\3\2\2\2\b\t\7\16\2\2\t\n\5\6\4\2\n\13\7"+
		"\17\2\2\13\3\3\2\2\2\f\r\7\n\2\2\r\26\5\2\2\2\16\17\7\13\2\2\17\20\7\16"+
		"\2\2\20\21\5\6\4\2\21\22\7\3\2\2\22\23\5\6\4\2\23\24\7\17\2\2\24\26\3"+
		"\2\2\2\25\f\3\2\2\2\25\16\3\2\2\2\26\5\3\2\2\2\27\30\b\4\1\2\30\36\5\2"+
		"\2\2\31\36\5\4\3\2\32\33\7\t\2\2\33\36\5\6\4\b\34\36\7\f\2\2\35\27\3\2"+
		"\2\2\35\31\3\2\2\2\35\32\3\2\2\2\35\34\3\2\2\2\36-\3\2\2\2\37 \f\7\2\2"+
		" !\7\5\2\2!,\5\6\4\b\"#\f\6\2\2#$\7\6\2\2$,\5\6\4\7%&\f\5\2\2&\'\7\7\2"+
		"\2\',\5\6\4\6()\f\4\2\2)*\7\b\2\2*,\5\6\4\4+\37\3\2\2\2+\"\3\2\2\2+%\3"+
		"\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\7\3\2\2\2/-\3\2\2\2\6"+
		"\25\35+-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}