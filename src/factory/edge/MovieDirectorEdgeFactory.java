package factory.edge;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import vertex.Vertex;

import java.util.List;

class MovieDirectorEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge MovieDirectorEdge = new MovieDirectorRelation(label, weight);
        if (vertices.get(0).equals(vertices.get(1))) {
            throw new UnsupportedOperationException("One movie actor edge can't be a loop");
        }
        MovieDirectorEdge.addVertices(vertices);
        return MovieDirectorEdge;
    }
}
