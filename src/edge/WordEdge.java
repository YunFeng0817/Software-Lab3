package edge;

import vertex.Vertex;

import java.util.*;

public class WordEdge extends Edge {
    WordEdge(String label, double weight) {
        super(label, weight);
    }

    @Override
    public boolean addVertices(List<Vertex> vertices) {
        if (vertices.size() == 2) {
            this.vertices.addAll(new LinkedList<>(vertices));
            return true;
        }
        return false;
    }

    @Override
    public Set<Vertex> sourceVertices() {
        if (vertices.size() == 2) {
            return new HashSet<>(Collections.singleton(vertices.get(0)));
        } else
            return null;
    }

    @Override
    public Set<Vertex> targetVertices() {
        if (vertices.size() == 2) {
            return new HashSet<>(Collections.singleton(vertices.get(1)));
        } else
            return null;
    }
}
