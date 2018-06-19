// Generated from /IdeaProjects/CTL/src\CTL.g4 by ANTLR 4.7

package com.ctl.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CTLParser}.
 */
public interface CTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CTLParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(CTLParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CTLParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(CTLParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryCTL(CTLParser.UnaryCTLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryCTL(CTLParser.UnaryCTLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryCTL(CTLParser.BinaryCTLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryCTL(CTLParser.BinaryCTLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(CTLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(CTLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(CTLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(CTLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(CTLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(CTLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Biconditional}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBiconditional(CTLParser.BiconditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Biconditional}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBiconditional(CTLParser.BiconditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CTL}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCTL(CTLParser.CTLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CTL}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCTL(CTLParser.CTLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Property}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterProperty(CTLParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Property}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitProperty(CTLParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParen(CTLParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParen(CTLParser.ParenContext ctx);
}