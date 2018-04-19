package factory.vertex;

import vertex.Computer;
import vertex.Director;
import vertex.Vertex;

class DirectorVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Director(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
