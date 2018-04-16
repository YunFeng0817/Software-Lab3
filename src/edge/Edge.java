package edge;

import vertex.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

abstract public class Edge {
    protected final List<Vertex> vertices = new LinkedList<>();
    private final String label;
    private double weight = 0;

    Edge(String label, double weight) {
        this.label = label;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    abstract public boolean addVertices(List<Vertex> vertices);

    boolean containVertex(Vertex v) {
        return vertices.contains(v);
    }

    public Set<Vertex> vertices() {
        return new HashSet<>(vertices);
    }

    abstract public Set<Vertex> sourceVertices();

    abstract public Set<Vertex> targetVertices();

    public double setWeight(double weight) {
        double oldWeight = this.weight;
        this.weight = weight;
        return oldWeight;
    }
}
