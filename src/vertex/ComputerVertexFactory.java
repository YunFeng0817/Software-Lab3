package vertex;

public class ComputerVertexFactory {
    public static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Computer(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}
