package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class GraphPoetFactory {
    public static Graph createGraph(String filePath) throws IOException {
        Graph poet = null;
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        Pattern regex;
        Matcher matcher;
        String content;
        fileReader.readLine();  // graph type
        // graph name
        String graphName = GraphFactory.GraphLabel(filePath);
        poet = new ConcreteGraph(graphName);
        //
        return poet;
    }
}
