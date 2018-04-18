package vertex;

public class ServerVertexFactory {
    public static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Server(label);
        return newVertex;
    }
}
