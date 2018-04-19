package factory.edge;

import edge.Edge;
import edge.NetworkConnection;
import vertex.Vertex;

import java.util.List;

class networkEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge networkEdge = new NetworkConnection(label, weight);
        if (vertices.get(0).equals(vertices.get(1))) {
            throw new UnsupportedOperationException("One networkConnection edge can't be a loop");
        }
        if (vertices.get(0).getClass().getName().equals(vertices.get(1).getClass().getName())) {
            throw new UnsupportedOperationException("One networkConnection edge can't have the same type vertices");
        }
        networkEdge.addVertices(vertices);
        return networkEdge;
    }
}
