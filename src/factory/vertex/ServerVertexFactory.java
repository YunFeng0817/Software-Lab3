package factory.vertex;

import vertex.Server;
import vertex.Vertex;

class ServerVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Server(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
