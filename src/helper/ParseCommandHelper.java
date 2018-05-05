package helper;

import graph.Graph;
import graph.GraphPoet;

import java.util.regex.*;

public class ParseCommandHelper {
    public static void main(String[] args) {
        Graph graph = new GraphPoet("");
        type(args, graph);
    }

    private static void command(String[] args, Command cmd) {
        Pattern commandRule = Pattern.compile("--(.*)");
        Matcher matcher = commandRule.matcher(args[1]);
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

    private static void type(String[] args, Graph graph) {
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
