package application;

import graph.Graph;
import factory.graph.GraphFactory;

import java.io.IOException;

class SocialNetworkApp {
    private Graph socialNetworkGraph;

    SocialNetworkApp(String filePath) throws IOException {
        socialNetworkGraph = GraphFactory.createGraph(filePath);
    }
}
