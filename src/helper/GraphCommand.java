package helper;

import graph.Graph;
import vertex.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GraphCommand extends Command {
    GraphCommand(Graph g) {
        super(g);
    }

    @Override
    void add(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void delete(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void update(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void show(String[] args) {
        Matcher matcher;
        StringBuilder OptionalCommand = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            OptionalCommand.append(args[i]);
        }
        List<Pattern> Rules = new ArrayList<>();
        Rules.add(Pattern.compile("degreeCentrality"));
        Rules.add(Pattern.compile("radius"));
        Rules.add(Pattern.compile("diameter"));
        Rules.add(Pattern.compile("visible"));
        Rules.add(Pattern.compile("distance=\"(.*)\"\"(.*)\""));
        matcher = Rules.get(0).matcher(OptionalCommand);
        if (matcher.find()) {
            System.out.println("The degreeCentrality of the graph : " + GraphMetrics.degreeCentrality(graph));
        }
        matcher = Rules.get(1).matcher(OptionalCommand);
        if (matcher.find()) {
            System.out.println("The radius of the graph : " + GraphMetrics.radius(graph));
        }
        matcher = Rules.get(2).matcher(OptionalCommand);
        if (matcher.find()) {
            System.out.println("The diameter of the graph : " + GraphMetrics.diameter(graph));
        }
        matcher = Rules.get(3).matcher(OptionalCommand);
        if (matcher.find()) {
            GraphVisualizationHelper.visualize(graph);
        }
        Matcher newMatcher = Rules.get(4).matcher(OptionalCommand);
        if (matcher.find()) {
            Vertex start, end;
            start = graph.vertices().stream().filter(item -> item.getLabel().equals(newMatcher.group(1))).findFirst().orElse(null);
            end = graph.vertices().stream().filter(item -> item.getLabel().equals(newMatcher.group(2))).findFirst().orElse(null);
            if (start == null || end == null) {
                System.err.println("The input vertex is not in the graph ");
                return;
            }
            System.out.println("The distance between the two vertices : " + GraphMetrics.distance(graph, start, end));
        }
    }
}
