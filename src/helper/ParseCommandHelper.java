package helper;

import factory.graph.GraphFactory;
import graph.Graph;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

public class ParseCommandHelper {
    /**
     * 用于图应用的命令行交互
     *
     * @param filePath 含有图语法信息的语法输入
     * @throws IOException 文件读写的异常
     */
    public static void Command(String filePath) throws IOException {
        Graph graph = GraphFactory.createGraph(filePath);
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
                case "update":
                    cmd.update(args);
                case "show":
                    cmd.show(args);
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
            case "graph":
                GraphCommand graphCommand = new GraphCommand(graph);
                command(args, graphCommand);
                break;
            default:
                throw new UnsupportedOperationException("usage");
        }
    }
}
