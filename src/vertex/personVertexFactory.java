package vertex;

class personVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Person(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
