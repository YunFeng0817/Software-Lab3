package graph;

import java.util.*;

public class ConcreteGraph<L, E> implements Graph {
    private final List<L> vertices = new LinkedList<>();

    @Override
    public boolean addVertex(Object vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add((L) vertex);
            return true;
        } else
            return false;
    }

    @Override
    public boolean removeVertex(Object vertex) {
        return false;
    }

    @Override
    public Set vertices() {
        return new HashSet<>(vertices);
    }

    @Override
    public Map sources(Object target) {
        return null;
    }

    @Override
    public Map targets(Object source) {
        return null;
    }

    @Override
    public boolean addEdge(Object edge) {
        return false;
    }

    @Override
    public boolean removeEdge(Object edge) {
        return false;
    }

    @Override
    public Set edges() {
        return null;
    }
}
