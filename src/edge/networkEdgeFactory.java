package edge;

import vertex.Vertex;

import java.util.List;

class networkEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge networkEdge = new NetworkConnection(label, weight);
        networkEdge.addVertices(vertices);
        return networkEdge;
    }
}
