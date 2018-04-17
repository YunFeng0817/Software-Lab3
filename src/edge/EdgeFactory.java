package edge;

import vertex.Vertex;

import java.util.List;

public class EdgeFactory {
    public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight) {
        switch (type) {
            case "WordNeighborhood":
                return poetEdgeFactory.createcreateEdge(label, vertices, weight);
            case "Computer":
                return null;
            case "Router":
                return null;
            case "Director":
                return null;
            default:
                throw new RuntimeException("form of the file is wrong!");
        }
    }
}
