package helper;

import graph.Graph;

abstract class Command {
    private Graph graph;

    Command(Graph g) {
        graph = g;
    }

    abstract void add(String[] args);

    abstract void delete(String[] args);
}
