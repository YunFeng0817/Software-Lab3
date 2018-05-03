package application;

import edge.Edge;
import factory.edge.EdgeFactory;
import factory.graph.GraphFactory;
import factory.vertex.VertexFactory;
import graph.*;
import helper.GraphVisualizationHelper;
import vertex.Vertex;

import java.io.IOException;
import java.util.*;

class GraphPoetApp {
    private Graph graphPoet;

    GraphPoetApp(String filePath) throws IOException {
        graphPoet = GraphFactory.createGraph(filePath);
//        GraphVisualizationHelper.visualize(graphPoet);
        Vertex newVertex1 = VertexFactory.createVertex("newVertex1", "Word", null);
        Vertex newVertex2 = VertexFactory.createVertex("newVertex2", "Word", null);
        graphPoet.addVertex(newVertex1);
        Vertex specificVertex = graphPoet.vertices().stream().filter(item -> item.getLabel().equals("to")).findFirst().orElse(null);
        graphPoet.removeVertex(specificVertex);
        if (newVertex1 != null)
            newVertex1.setLabel("changeLabel");
        Edge newEdge = EdgeFactory.createEdge("newEdge", "WordNeighborhood", new ArrayList<>(Arrays.asList(newVertex1, newVertex2)), 1);
        graphPoet.addEdge(newEdge);
        Edge specificEdge = graphPoet.edges().stream().filter(item -> item.getLabel().equals("2")).findFirst().orElse(null);
        graphPoet.removeEdge(specificEdge);
        specificEdge = graphPoet.edges().stream().filter(item -> item.getLabel().equals("3")).findFirst().orElse(null);
        specificEdge.setLabel("Name");
        newEdge.setLabel("changeLabel");
        newEdge.setWeight(2);
        GraphVisualizationHelper.visualize(graphPoet);
    }

    /**
     * Generate a poem.
     *
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    String poem(String input) {
        List<String> inputWords;
        String[] test = input.split(" ");
        inputWords = new LinkedList<>(Arrays.asList(test));
        ListIterator<String> iterator = inputWords.listIterator();
        if (!iterator.hasNext()) {
            return " ";
        }
        String previous = iterator.next();
        String next;
        StringBuilder result;
        while (iterator.hasNext()) {
            next = iterator.next();
            result = new StringBuilder(getBridge(previous, next));
            if (!result.toString().equals("")) {
                iterator.previous();
                iterator.add(result.toString());
                iterator.next();
            }
            previous = next;
        }
        result = new StringBuilder();
        for (String words : inputWords) {
            result.append(words).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * this function is to search the bridge word according to the given two words in the graph
     *
     * @param source : the source vertex of the edge, 'source' is followed by 'target'
     * @param target : the target vertex of the edge
     * @return if the bridge is existed,return the bridge word, "" is returned otherwise
     */
    private String getBridge(String source, String target) {
        source = source.toLowerCase();
        target = target.toLowerCase();
        String finalSource = source;
        Vertex sourceVertex = graphPoet.vertices().stream().filter(item -> item.getLabel().equals(finalSource)).findFirst().orElse(null);
        String finalTarget = target;
        Vertex targetVertex = graphPoet.vertices().stream().filter(item -> item.getLabel().equals(finalTarget)).findFirst().orElse(null);
        if (sourceVertex == null || targetVertex == null) {
            return "";
        }
        Map<Vertex, List<Double>> bridges = new HashMap<>();
        Map<Vertex, List<Double>> middleTargets;
        Map<Vertex, List<Double>> finalTargets;
        middleTargets = graphPoet.targets(sourceVertex);
        for (Map.Entry<Vertex, List<Double>> entry : middleTargets.entrySet()) {
            finalTargets = graphPoet.targets(entry.getKey());
            if (finalTargets.keySet().contains(targetVertex)) {
                bridges.put(entry.getKey(), new ArrayList<>(Collections.singletonList(entry.getValue().get(0) + finalTargets.get(targetVertex).get(0))));
            }
        }
        // use to sort the bridges by weight
        List<Map.Entry<Vertex, List<Double>>> sortedBridges = new ArrayList<>(bridges.entrySet());
        // use sort and lambda expression
        sortedBridges.sort((Map.Entry<Vertex, List<Double>> o1, Map.Entry<Vertex, List<Double>> o2) -> o2.getValue().get(0).compareTo(o1.getValue().get(0)));
        if (!sortedBridges.isEmpty())
            return sortedBridges.get(0).getKey().getLabel();
        return "";
    }
}
