package edge;

import vertex.Vertex;

import java.util.List;

public class forwardEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge forwardConnection = new CommentConnection(label, weight);
        if (vertices.get(0).equals(vertices.get(1))) {
            throw new UnsupportedOperationException("One comment connection edge can't be a loop");
        }
        forwardConnection.addVertices(vertices);
        return forwardConnection;
    }
}
