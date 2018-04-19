package factory.vertex;

import vertex.Router;
import vertex.Vertex;

class RouterVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Router(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
