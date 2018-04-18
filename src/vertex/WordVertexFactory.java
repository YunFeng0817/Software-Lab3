package vertex;

public class WordVertexFactory extends VertexFactory {
    public static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Word(label);
        return newVertex;
    }
}
