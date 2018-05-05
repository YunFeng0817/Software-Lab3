package factory.vertex;

import vertex.Vertex;
import vertex.WirelessRouter;

class WirelessRouterFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new WirelessRouter(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
