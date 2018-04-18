package edge;

import vertex.Vertex;

import java.util.List;

public class EdgeFactory {
    public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight) {
        switch (type) {
            case "WordNeighborhood":
                return poetEdgeFactory.createEdge(label, vertices, weight);
            case "NetworkConnection":
                return networkEdgeFactory.createEdge(label, vertices, weight);
            default:
                throw new RuntimeException("form of the file is wrong!");
        }
    }
}
