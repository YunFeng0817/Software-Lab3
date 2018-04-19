package factory.vertex;

import vertex.Movie;
import vertex.Vertex;

class MovieVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Movie(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
