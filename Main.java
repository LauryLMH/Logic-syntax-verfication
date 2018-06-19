package ctl;
import com.ctl.grammar.CTLLexer;
import com.ctl.grammar.CTLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.graphstream.graph.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Parse state machine.
        StateMachine machine = StateMachine.build(reader);
        if (machine == null) {
            System.out.println("Invalid state machine.");
            return;
        }

        Graph graph = machine.getGraph();
        graph.display();

        // Read expression.
        String CTLExpression = reader.readLine();
        System.out.println("Parsing is done.");
        // Reading is done.
        System.err.println(CTLExpression);

        ArrayList<String> formulas = getFormulates(CTLExpression);
        for (String f : formulas) {
            reader.readLine();
            System.out.println("---> " + f);
            dealSubformula(machine, graph, f);
        }
        reader.close();
    }

    static void dealSubformula(StateMachine machine, Graph graph, String CTLExpression) {
        machine.clearNodeColor();
        machine.clearLabel();
        ParseTreeWalker walker = new ParseTreeWalker();

        CTLParser parser = new CTLParser(
                new CommonTokenStream(new CTLLexer(CharStreams.fromString(CTLExpression)))
        );
        parser.removeErrorListeners();
        parser.setBuildParseTree(true);
        ParseTree expressionTree;
        try {
            expressionTree = parser.expr();
//            System.out.println(expressionTree.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        NormalizedCTLEmitter converter = new NormalizedCTLEmitter();
        walker.walk(converter, expressionTree);

//        System.out.println("Converted: " + converter.getCTL(expressionTree));

        parser = new CTLParser(
                new CommonTokenStream(new CTLLexer(CharStreams.fromString(converter.getCTL(expressionTree)))));
        parser.setBuildParseTree(true);
        ParseTree convertedTree = parser.expr();
        EvaluatorEmitter evaluator = new EvaluatorEmitter(machine);
        walker.walk(evaluator, convertedTree);

        List<Integer> answer = machine.getStatesWithLabel(evaluator.getLabel(convertedTree));
        if (answer.isEmpty()) {
            System.out.println("The expression is false for all states");
        } else {
            System.out.println("The expression is valid in the following states:");
            Iterator<Integer> it = answer.iterator();
            String id = it.next().toString();
            graph.getNode(id).addAttribute("ui.class", "red");
            System.out.print(id);
            while (it.hasNext()) {
                id = it.next().toString();
                System.out.print(" " + id);
                graph.getNode(id).addAttribute("ui.class", "red");
            }
            System.out.println();
        }
    }

    static ArrayList<String> getFormulates(String CTLExpression) {
        ParseTreeWalker walker = new ParseTreeWalker();

        CTLParser parser = new CTLParser(
                new CommonTokenStream(new CTLLexer(CharStreams.fromString(CTLExpression)))
        );
        parser.removeErrorListeners();
        parser.setBuildParseTree(true);
        ParseTree expressionTree;
        try {
            expressionTree = parser.expr();
            System.out.println(expressionTree.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        SubCTLEmitter converter = new SubCTLEmitter();
        walker.walk(converter, expressionTree);
        return converter.getFormulas();
    }
}
