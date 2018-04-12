package edge;

import vertex.Vertex;

import java.util.List;
import java.util.Set;

public class UndirectedEdge extends Edge {
    UndirectedEdge(String label, double weight) {
        super(label, weight);
    }

    @Override
    public boolean addVertices(List<Vertex> vertices) {
        if (vertices.size() == 2) {
            if (super.vertices.size() == 0) {
                super.vertices.addAll(vertices);
                return true;
            }
            return false;
        } else {
            throw new RuntimeException("the directed edge must be two vertices");
        }
    }

    @Override
    Set<Vertex> sourceVertices() {
        return super.vertices();
    }

    @Override
    Set<Vertex> targetVertices() {
        return super.vertices();
    }
}
