package graph;

import edge.Edge;
import vertex.Vertex;

import java.util.*;

public class ConcreteGraph implements Graph {
    private final List<Vertex> vertices = new LinkedList<>();

    @Override
    public boolean addVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            return true;
        } else
            return false;
    }

    @Override
    public boolean removeVertex(Vertex vertex) {
        return false;
    }

    @Override
    public Set vertices() {
        return new HashSet<>(vertices);
    }

    @Override
    public Map sources(Vertex target) {
        return null;
    }

    @Override
    public Map targets(Vertex source) {
        return null;
    }

    @Override
    public boolean addEdge(Edge edge) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge edge) {
        return false;
    }

    @Override
    public Set edges() {
        return null;
    }
}
