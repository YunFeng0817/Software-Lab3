package helper;

import edge.Edge;
import factory.edge.EdgeFactory;
import graph.Graph;
import vertex.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class HyperEdgeCommand extends Command {
    HyperEdgeCommand(Graph g) {
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
        String type;
        matcher = Rule.matcher(args[3]);
        if (matcher.find()) {
            type = matcher.group(1);
            StringBuilder OptionalCommand = new StringBuilder("");
            for (int i = 4; i < args.length; i++) {
                OptionalCommand.append(args[i]);
            }
            String[] edgesLabels = OptionalCommand.toString().split("\"");
            List<String> edgesList = new ArrayList<>(Arrays.asList(edgesLabels));
            edgesList.removeIf(item -> item.equals(""));
            List<Vertex> vertices = graph.vertices()
                    .stream()
                    .filter(item -> edgesList.contains(item.getLabel()))
                    .collect(Collectors.toList());
            Edge HyperEdge = EdgeFactory.createEdge(label, type, vertices, -1);
            if(graph.addEdge(HyperEdge))
                System.out.println("Add hyper edge successfully");
            else
                System.err.println("Add fail!");
        }
    }

    @Override
    void delete(String[] args) {
        throw new UnsupportedOperationException();
    }
}