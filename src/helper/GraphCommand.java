package helper;

import graph.Graph;

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
        for (int i = 4; i < args.length; i++) {
            OptionalCommand.append(args[i]);
        }
        List<Pattern> Rules = new ArrayList<>();
        Rules.add(Pattern.compile("degreeCentrality"));
        Rules.add(Pattern.compile("radius"));
        Rules.add(Pattern.compile("diameter"));
        Rules.add(Pattern.compile("visiable"));
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
    }
}
