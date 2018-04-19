package application;

import graph.Graph;
import graph.GraphFactory;

import java.io.IOException;

public class SocialNetworkApp {
    Graph socialNetworkGraph;

    SocialNetworkApp(String filePath) throws IOException {
        socialNetworkGraph = GraphFactory.createGraph(filePath);
    }
}
