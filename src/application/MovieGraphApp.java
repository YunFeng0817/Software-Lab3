package application;

import factory.graph.GraphMovieFactory;
import graph.Graph;

import java.io.IOException;

class MovieGraphApp {
    MovieGraphApp(String filePath) throws IOException {
        Graph movie = GraphMovieFactory.createGraph(filePath);
    }
}
