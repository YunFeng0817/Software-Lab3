package factory.edge;

import edge.Edge;
import edge.WordEdge;
import vertex.Vertex;

import java.util.List;

class poetEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge wordEdge = new WordEdge(label, weight);
        wordEdge.addVertices(vertices);
        return wordEdge;
    }
}
