package helper;

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
            if (graph.addVertex(newVertex)) {
                System.out.println("Add vertex successfully!");
            }
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
                    graph.vertices().removeIf(item -> InputRule.matcher(item.getLabel()).find());
                }
            }
        }
    }
}
