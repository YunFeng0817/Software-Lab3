package factory.vertex;

import vertex.Person;
import vertex.Vertex;

class personVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Person(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
