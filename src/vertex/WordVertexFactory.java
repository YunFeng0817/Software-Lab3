package vertex;

public class WordVertexFactory extends VertexFactory {
    @Override
    public Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Word(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
