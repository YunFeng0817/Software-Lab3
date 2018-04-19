package factory.vertex;

import vertex.Vertex;
import vertex.Word;

class WordVertexFactory extends VertexFactory {
    static Vertex createVertex(String label, String[] args) {
        return new Word(label);
    }
}
