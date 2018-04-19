package factory.edge;

import edge.Edge;
import edge.MovieActorRelation;
import edge.SameMovieHyperEdge;
import vertex.Vertex;

import java.util.List;

class SameMovieHyperEdgeFactory {
    static Edge createEdge(String label, List<Vertex> vertices, double weight) {
        Edge SameMovieHyper = new SameMovieHyperEdge(label, weight);
        if (vertices.get(0).equals(vertices.get(1))) {
            throw new UnsupportedOperationException("One movie actor edge can't be a loop");
        }
        SameMovieHyper.addVertices(vertices);
        return SameMovieHyper;
    }
}
