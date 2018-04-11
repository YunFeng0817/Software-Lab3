package edge;

import vertex.*;

import java.util.LinkedList;
import java.util.List;

abstract public class Edge {
    final List<Vertex> vertices = new LinkedList<>();
    private final String label;
    double weight;

    Edge(String label, double weight) {
        this.label = label;
        this.weight = weight;
    }

    abstract public boolean addVertices(List<Vertex> vertices);

    boolean containVertex(Vertex v) {
        return vertices.contains(v);
    }
}
