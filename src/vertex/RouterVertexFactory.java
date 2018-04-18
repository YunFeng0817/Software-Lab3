package vertex;

public class RouterVertexFactory {
    public static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Router(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
