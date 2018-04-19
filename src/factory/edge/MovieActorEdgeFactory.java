package factory.edge;

import edge.CommentConnection;
import edge.Edge;
import edge.MovieActorRelation;
import vertex.Vertex;

import java.util.List;

class MovieActorEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge MovieActorEdge = new MovieActorRelation(label, weight);
        if (vertices.get(0).equals(vertices.get(1))) {
            throw new UnsupportedOperationException("One movie actor edge can't be a loop");
        }
        MovieActorEdge.addVertices(vertices);
        return MovieActorEdge;
    }
}
