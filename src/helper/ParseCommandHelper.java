package helper;

import factory.graph.GraphFactory;
import graph.Graph;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

public class ParseCommandHelper {
    public static void main(String[] args) throws IOException {
        Graph graph = GraphFactory.createGraph("./test/graph/data/GraphPoet.txt");
        String[] params;
        while (true) {
            System.out.print("Graph>>>");
            Scanner in = new Scanner(System.in);
            if (in.hasNextLine()) {
                String input = in.nextLine();
                params = input.split(" ");
                if (input.equals("exit"))
                    System.exit(0);
                type(params, graph);
            }
        }
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
        if (args.length < 3)
            return;
        switch (args[0]) {
            case "vertex":
                VertexCommand vertexCommand = new VertexCommand(graph);
                command(args, vertexCommand);
                break;
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
