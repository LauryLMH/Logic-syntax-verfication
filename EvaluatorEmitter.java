package ctl;

import com.ctl.grammar.CTLBaseListener;
import com.ctl.grammar.CTLParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class EvaluatorEmitter extends CTLBaseListener {
    private ParseTreeProperty<Integer> label;
    private int nextLabel;
    StateMachine stateMachine;

    public EvaluatorEmitter(StateMachine m) {
        this.nextLabel = 1;
        this.label = new ParseTreeProperty<>();
        this.stateMachine = m;
    }

    Integer getLabel(ParseTree ctx) {
        return label.get(ctx);
    }

    void setLabel(ParseTree ctx) {
        label.put(ctx, nextLabel);
//        System.out.println("==================");
//        System.out.println(ctx.getText());
//        System.out.println("==================");
        ++ nextLabel;
    }

    void setTrueLabel(ParseTree ctx) {
        label.put(ctx, 0);
    }

    void cloneChildLabel(ParseTree ctx, ParseTree child) {
        label.put(ctx, getLabel(child));
    }

    @Override
    public void exitProperty(CTLParser.PropertyContext ctx) {
        if (ctx.getText().compareTo("true") == 0)
            setTrueLabel(ctx);
        else
            setLabel(ctx);
        stateMachine.propertyLabel(getLabel(ctx), ctx.getText());
    }

    @Override
    public void exitParen(CTLParser.ParenContext ctx) {
        cloneChildLabel(ctx, ctx.parenExpr());
    }

    @Override
    public void exitParenExpr(CTLParser.ParenExprContext ctx) {
        cloneChildLabel(ctx, ctx.expr());
    }

    @Override
    public void exitOr(CTLParser.OrContext ctx) {
        setLabel(ctx);
        Integer leftLabel = getLabel(ctx.expr(0));
        Integer rightLabel = getLabel(ctx.expr(1));

        stateMachine.or(getLabel(ctx), leftLabel, rightLabel);
    }

    @Override
    public void exitNot(CTLParser.NotContext ctx) {
        setLabel(ctx);
        Integer childLabel = getLabel(ctx.expr());
        stateMachine.not(getLabel(ctx), childLabel);
    }

    @Override
    public void exitCTL(CTLParser.CTLContext ctx) {
        cloneChildLabel(ctx, ctx.ctlExpr());
    }

    @Override
    public void exitUnaryCTL(CTLParser.UnaryCTLContext ctx) {
        setLabel(ctx);
        Integer childLabel = getLabel(ctx.parenExpr());

        if (ctx.CTLOpUnary().getText().charAt(0) == 'A')
            stateMachine.af(getLabel(ctx), childLabel);
        else
            stateMachine.ex(getLabel(ctx), childLabel);
    }

    @Override
    public void exitBinaryCTL(CTLParser.BinaryCTLContext ctx) {
        setLabel(ctx);
        Integer leftLabel = getLabel(ctx.expr(0));
        Integer rightLabel = getLabel(ctx.expr(1));
        stateMachine.eu(getLabel(ctx), leftLabel, rightLabel);
    }
}
