package ctl;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.List;
import java.io.*;
import java.util.ArrayList;

class State {
    private List<State> nextStateList;
    private List<String> propertyList;
    private List<Integer> labelList;
    private Node node;

    public State(int name) {
        nextStateList = new ArrayList<>();
        propertyList = new ArrayList<>();
        labelList = new ArrayList<>();
    }

    public void clearLabel() {
        labelList = new ArrayList<>();
        labelList.add(0);
    }

    public void setNode(Node n) { node = n; }

    public Node getNode() { return node; }

    public boolean addProperty(String property) {
        return propertyList.add(property);
    }

    public boolean addNextState(State nextState) {
        return nextStateList.add(nextState);
    }

    public boolean addLabel(int label) {
        return labelList.add(label);
    }

    public boolean verifyProperty(String property) {
        return propertyList.contains(property);
    }

    public boolean verifyNextState(State nextState) {
        return nextStateList.contains(nextState);
    }

    public boolean verifyLabel(int label) {
        return labelList.contains(label);
    }

    public boolean verifyNextStateLabel(int label) {
        for (int i = 0; i < nextStateList.size(); i++) {
            if (nextStateList.get(i).verifyLabel(label)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyAllNextStateLabel(int label) {
        if (nextStateList.size() == 0) {
            return false;
        }
        for (int i = 0; i < nextStateList.size(); i++) {
            if (!nextStateList.get(i).verifyLabel(label)) {
                return false;
            }
        }
        return true;
    }
}

class StateMachine {
    private List<State> stateList;
    private static Graph graph;

    public StateMachine(int size) {
        stateList = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            State state = new State(i);
            if (i > 0) {
                Node node = graph.addNode("" + i);
                state.setNode(node);
            }
            stateList.add(state);
            stateList.get(i).addLabel(0);
        }
    }

    public void clearNodeColor() {
        for (int i = 1; i < stateList.size(); ++i) {
            Node node = stateList.get(i).getNode();
            node.addAttribute("ui.class", "");
        }
    }

    public void clearLabel() {
        for (int i = 1; i < stateList.size(); ++i) {
            stateList.get(i).clearLabel();
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public boolean addProperty(int stateId, String propertyName) {
        System.err.println("stateId = " + stateId + " propertyName = " + propertyName);
        return stateList.get(stateId).addProperty(propertyName);
    }

    public boolean addNextState(int stateId, int idNextState) {
        if(idNextState == 0)
            return false;
        try {
            System.err.println("stateId = " + stateId + " nextState = " + idNextState);
            graph.addEdge("" + stateId + "-" + idNextState, "" + stateId, "" + idNextState, true);
            return stateList.get(stateId).addNextState(stateList.get(idNextState));
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean propertyLabel(int idLabel, String property) {
        for (int i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyProperty(property)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    public boolean not(int idlabel, int label) {
        for (int i = 1; i < stateList.size(); i++) {
            if (!stateList.get(i).verifyLabel(label)) {
                stateList.get(i).addLabel(idlabel);
            }
        }
        return true;
    }

    public boolean and(int idLabel, int label1, int label2) {
        for (int i = 1; i < stateList.size(); i++) {
            //p && q
            if (stateList.get(i).verifyLabel(label1) && stateList.get(i).verifyLabel(label2)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    public boolean or(int idLabel, int label1, int label2) {
        for (int i = 1; i < stateList.size(); i++) {
            //p || q
            if (stateList.get(i).verifyLabel(label1) || stateList.get(i).verifyLabel(label2)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    public boolean implication(int idLabel, int label1, int label2) {
        for (int i = 1; i < stateList.size(); i++) {
            //q->p = !q||p
            if (!stateList.get(i).verifyLabel(label1) || stateList.get(i).verifyLabel(label2)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    public boolean equivalence(int idLabel, int label1, int label2) {
        int i;
        for (i = 1; i < stateList.size(); i++) {
            // q=p --> q^p || !q^!p
            if (
                    (stateList.get(i).verifyLabel(label1) && stateList.get(i).verifyLabel(label2))
                            ||
                            ((!stateList.get(i).verifyLabel(label1)) && (!stateList.get(i).verifyLabel(label2)))
                    ) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    public boolean ex(int idLabel, int label) {
        for (int i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyNextStateLabel(label)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        return true;
    }

    private boolean euSecondStap(int idLabel, int label1) {
        boolean modified = false;
        for (int i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyLabel(label1)
                    && stateList.get(i).verifyNextStateLabel(idLabel)
                    && (!stateList.get(i).verifyLabel(idLabel))) {
                stateList.get(i).addLabel(idLabel);
                modified = true;
            }
        }
        return modified;
    }

    public boolean eu(int idLabel, int label1, int label2) {
        for (int i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyLabel(label2)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        while (euSecondStap(idLabel, label1)) ;
        return true;
    }

    private boolean afSecondStap(int idLabel) {
        int i;
        boolean modified = false;
        for (i = 1; i < stateList.size(); i++) {
            if (
                    stateList.get(i).verifyAllNextStateLabel(idLabel) &&
                            (!stateList.get(i).verifyLabel(idLabel))) {
                stateList.get(i).addLabel(idLabel);
                modified = true;
            }
        }
        return modified;
    }

    public boolean af(int idLabel, int label1) {
        for (int i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyLabel(label1)) {
                stateList.get(i).addLabel(idLabel);
            }
        }
        while (afSecondStap(idLabel)) ;
        return true;
    }

    public List<Integer> getStatesWithLabel(int label) {
        int i;
        List<Integer> list = new ArrayList<>();
        for (i = 1; i < stateList.size(); i++) {
            if (stateList.get(i).verifyLabel(label)) {
                list.add(i);
            }
        }
        return list;
    }

    public static StateMachine build(BufferedReader reader) throws IOException {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph = new SingleGraph("FSM");
        graph.setStrict(false);
        graph.setAutoCreate( true );
        graph.addAttribute("ui.stylesheet", "node {\n" +
                "\tshape: box;\n" +
                "\tsize: 50px, 50px;\n" +
                "\tfill-mode: plain;   /* Default.          */\n" +
                "\tfill-color: white;    /* Default is black. */\n" +
                "\tstroke-mode: plain; /* Default is none.  */\n" +
                "\tstroke-color: blue; /* Default is black. */\n" +
                "\ttext-alignment: center;\n" +
                "\ttext-size: 14;\n" +
                "\ttext-color: #222;\n" +
                "\ttext-background-mode: plain;\n" +
                "\ttext-background-mode: rounded-box;\n" +
                "\t}" +
                "\tnode.red { fill-color: red; }\n" +
                "\tgraph { padding: 90px; fill-color: #EEE; }");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        //graph.addAttribute("ui.stylesheet", "edge {text-alignment: along;}");
        try {
            int totLines = Integer.parseInt(reader.readLine());
            StateMachine stateMachine = new StateMachine(totLines);

            for (int i = 1; i <= totLines; i++) {
                Node node = stateMachine.stateList.get(i).getNode();
                String line = reader.readLine();
                String[] words = line.split(" ");
                if (i != Integer.parseInt(words[0])) {
                    System.out.println(i);
                    return null;
                }

                int propVectorPointer = Integer.parseInt(words[1]) + 2;
                int maxVectorPointer = Integer.parseInt(words[propVectorPointer]) + propVectorPointer + 1;
                String property = i + ": {";
                for (int j = 2; j < propVectorPointer; j++) {
                    stateMachine.addProperty(i, words[j]);
                    property += words[j];
                    if (j < propVectorPointer - 1)
                        property += ", ";
                }
                property += "}";
                node.addAttribute("ui.label", property);
                for (int j = propVectorPointer + 1; j < maxVectorPointer; j++) {
                    if (!stateMachine.addNextState(i, Integer.parseInt(words[j])))
                        return null;
                }
            }
            return stateMachine;
        } catch (NumberFormatException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
}