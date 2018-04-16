package application;

import graph.*;
import vertex.Vertex;
import vertex.WordVertexFactory;

public class GraphPoetApp {
    private final Graph graphPoet = new ConcreteGraph();

    public static void Main(String[] args) {
        Vertex point1 = new WordVertexFactory().createVertex("to", null);
        Vertex point2 = new WordVertexFactory().createVertex("explore", null);
        Vertex point3 = new WordVertexFactory().createVertex("strange", null);
        Vertex point4 = new WordVertexFactory().createVertex("new", null);
    }
}
