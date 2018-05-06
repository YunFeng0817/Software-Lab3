package helper;

import edge.Edge;
import factory.vertex.VertexFactory;
import graph.Graph;
import vertex.Vertex;

import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

class VertexCommand extends Command {
    VertexCommand(Graph g) {
        super(g);
    }

    @Override
    void add(String[] args) {
        Pattern Rule = Pattern.compile("\"(.*)\"");
        Matcher matcher = Rule.matcher(args[2]);
        String label;
        if (matcher.find())
            label = matcher.group(1);
        else
            return;
        matcher = Rule.matcher(args[3]);
        String type;
        if (matcher.find()) {
            type = matcher.group(1);
            Vertex newVertex = VertexFactory.createVertex(label, type, null);
            if (graph.addVertex(newVertex))
                System.out.println("Add vertex successfully!");
            else
                System.err.println("Add fail!");
        }
    }

    @Override
    void delete(String[] args) {
        Pattern Rule = Pattern.compile("\"(.*)\"");
        Matcher matcher = Rule.matcher(args[2]);
        String regex;
        if (matcher.find()) {
            regex = matcher.group(1);
            Pattern InputRule = Pattern.compile(regex);
            List<Vertex> vertices = graph.vertices().stream().filter(item -> InputRule.matcher(item.getLabel()).find()).collect(Collectors.toList());
            if (vertices.size() != 0) {
                System.out.println(vertices.size() + " vertices are found:");
                vertices.forEach(item -> System.out.println(item.getLabel()));
                // 请用户确认是否删除这些内容
                if (Command.confirm()) {
                    vertices.forEach(item -> graph.removeVertex(item));
                    System.out.println("Delete them successfully");
                }
            } else {
                System.out.println("Not found the specific vertex");
            }
        }
    }

    @Override
    void update(String[] args) {
        Pattern Rule = Pattern.compile("\"(.*)\"");
        Matcher matcher = Rule.matcher(args[2]);
        String label;
        Vertex vertex;
        if (matcher.find()) {
            label = matcher.group(1);
            vertex = graph.vertices().stream().filter(item -> item.getLabel().equals(label)).findFirst().orElse(null);
            if (vertex == null)
                return;
        } else
            return;
        StringBuilder OptionalCommand = new StringBuilder();
        for (int i = 4; i < args.length; i++) {
            OptionalCommand.append(args[i]);
        }
        Rule = Pattern.compile("label=(.*)");
        matcher = Rule.matcher(OptionalCommand);
        String newLabel;
        if (matcher.find()) {
            newLabel = matcher.group(1);
            vertex.setLabel(newLabel);
            System.out.println("Update label successfully");
        }
        Rule = Pattern.compile("argument=(.*)");
        matcher = Rule.matcher(OptionalCommand);
        String argument;
        String[] arguments;
        if (matcher.find()) {
            argument = matcher.group(1);
            arguments = argument.split(",");
            vertex.fillVertexInfo(arguments);
            System.out.println("The argument of the vertex update successfully");
        }
    }
}
