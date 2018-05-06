package helper;

import edge.Edge;
import factory.edge.EdgeFactory;
import graph.Graph;
import vertex.Vertex;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class EdgeCommand extends Command {
    EdgeCommand(Graph g) {
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
            StringBuilder OptionalCommand = new StringBuilder();
            for (int i = 4; i < args.length; i++) {
                OptionalCommand.append(args[i]);
            }
            Rule = Pattern.compile("\"(.*)\"\"(.*)\"");
            matcher = Rule.matcher(OptionalCommand);
            String label1, label2;
            if (matcher.find()) {
                label1 = matcher.group(1);
                label2 = matcher.group(2);
            } else
                return;
            Rule = Pattern.compile("weighted=([Y|N])");
            matcher = Rule.matcher(OptionalCommand);
            boolean weighted = false;
            double weight = -1;
//            boolean directed = true;
            if (matcher.find()) {
                weighted = matcher.group(1).equals("Y");
            }
            // 匹配可选项 weighted
            Rule = Pattern.compile("[0-9]+/.?[0-9]*");
            matcher = Rule.matcher(OptionalCommand);
            if (matcher.find()) {
                weight = Double.parseDouble(matcher.group(1));
            }
            if (!weighted && weight != -1)
                return;   // 此处有待 lab4处理
            // 匹配可选项 weight
//            Rule = Pattern.compile("directed=([Y|N])");
//            matcher = Rule.matcher(OptionalCommand);
//            if (matcher.find()) {
//                directed = matcher.group(1).equals("Y");
//            }
//            if(directed){
//                to do something in lab4
//            }
            // 匹配可选项 directed
            List<Vertex> vertices = graph.vertices().
                    stream().
                    filter(item -> item.getLabel().equals(label1) || item.getLabel().equals(label2))
                    .collect(Collectors.toList());
            Edge newEdge = EdgeFactory.createEdge(label, type, vertices, weight);
            graph.addEdge(newEdge);
        }
    }

    @Override
    void delete(String[] args) {

    }
}
