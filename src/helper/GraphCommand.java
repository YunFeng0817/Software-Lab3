package helper;

import graph.Graph;

public class GraphCommand extends Command {
    GraphCommand(Graph g) {
        super(g);
    }

    @Override
    void add(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void delete(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void update(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    void show(String[] args) {

    }
}
