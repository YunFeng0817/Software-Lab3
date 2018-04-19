package factory.vertex;

import vertex.Vertex;

abstract public class VertexFactory {
    public static Vertex createVertex(String label, String type, String[] args) {
        switch (type) {
            case "Word":
                return WordVertexFactory.createVertex(label, args);
            case "Computer":
                return ComputerVertexFactory.createVertex(label, args);
            case "Router":
                return RouterVertexFactory.createVertex(label, args);
            case "Server":
                return ServerVertexFactory.createVertex(label, args);
            case "Person":
                return personVertexFactory.createVertex(label, args);
            default:
                return null;
        }
    }
}
