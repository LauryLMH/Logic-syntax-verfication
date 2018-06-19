// Generated from /IdeaProjects/CTL/src\CTL.g4 by ANTLR 4.7

package com.ctl.grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CTLParser#parenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(CTLParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryCTL(CTLParser.UnaryCTLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryCTL}
	 * labeled alternative in {@link CTLParser#ctlExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCTL(CTLParser.BinaryCTLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(CTLParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(CTLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CTLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Biconditional}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBiconditional(CTLParser.BiconditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CTL}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCTL(CTLParser.CTLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Property}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(CTLParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link CTLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(CTLParser.ParenContext ctx);
}