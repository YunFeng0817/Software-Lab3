package helper;

import graph.Graph;

import java.util.regex.*;

public class ParseCommandHelper {
    public static void main(String[] args) {
        Graph graph;

    }

    static void command(String[] args, Command cmd) {
        Pattern commandRule = Pattern.compile("\"--(.*)\"");
        Matcher matcher = commandRule.matcher(args[2]);
        String command;
        if (matcher.find()) {
            command = matcher.group(1);
            switch (command) {
                case "add":
                    cmd.add(args);
                    break;
                case "delete":
                    cmd.delete(args);
                    break;
                default:
            }
        }
    }

    static void type(String[] args, Graph graph) {
        switch (args[0]) {
            case "vertex":
                VertexCommand vertexCommand = new VertexCommand(graph);
                command(args, vertexCommand);
            case "edge":
                EdgeCommand edgeCommand = new EdgeCommand(graph);
                command(args, edgeCommand);
                break;
            case "hyperedge":
                HyperEdgeCommand hyperEdgeCommand = new HyperEdgeCommand(graph);
                command(args, hyperEdgeCommand);
                break;
            default:
                throw new UnsupportedOperationException("usage");
        }
    }
}
