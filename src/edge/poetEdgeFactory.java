package edge;

import vertex.Vertex;

import java.util.List;

public class poetEdgeFactory {
    static Edge createcreateEdge(String label, List<Vertex> vertices, double weight) {
        Edge wordEdge = new WordEdge(label, weight);
        wordEdge.addVertices(vertices);
        return wordEdge;
    }
}
