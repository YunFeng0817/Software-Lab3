package factory.vertex;

import vertex.Actor;
import vertex.Computer;
import vertex.Vertex;

class ActorVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Actor(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
