package vertex;

public class ServerVertexFactory {
    public static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Server(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
