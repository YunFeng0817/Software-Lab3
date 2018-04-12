package edge;

import vertex.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

abstract public class Edge {
    protected final List<Vertex> vertices = new LinkedList<>();
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

    Set<Vertex> vertices() {
        return new HashSet<>(vertices);
    }

    abstract Set<Vertex> sourceVertices();

    abstract Set<Vertex> targetVertices();
}
