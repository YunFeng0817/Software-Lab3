package vertex;

abstract public class VertexFactory {
    public static Vertex createVertex(String label, String type, String[] args) {
        switch (type) {
            case "Word":
                return WordVertexFactory.createVertex(label, args);
            default:
                return null;
        }
    }
}
