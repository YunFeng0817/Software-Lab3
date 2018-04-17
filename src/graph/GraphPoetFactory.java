package graph;

import vertex.Vertex;
import vertex.VertexFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class GraphPoetFactory {
    public static Graph createGraph(String filePath) throws IOException {
        Graph poet = null;
        Pattern regex;
        Matcher matcher;
        String content;
        // graph name
        String graphName = GraphFactory.GraphLabel(filePath);
        poet = new ConcreteGraph(graphName);
        // get Vertices from the file
        List<List<String>> vertexCut = GraphFactory.getVertices(filePath);
        List<Vertex> vertices = new ArrayList<>();
        for (List<String> list : vertexCut) {
            vertices.add(VertexFactory.createVertex(list.get(0), list.get(1), null));
        }

        List<List<String>> edgeCut = GraphFactory.getEdges(filePath);
        return poet;
    }
}
