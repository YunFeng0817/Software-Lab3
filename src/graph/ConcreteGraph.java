package graph;

import edge.Edge;
import vertex.Vertex;

import java.util.*;

public class ConcreteGraph implements Graph {
    private final List<Vertex> vertices = new LinkedList<>();
    private final List<Edge> edges = new LinkedList<>();

    @Override
    public boolean addVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            return true;
        } else
            return false;
    }

    @Override
    public boolean removeVertex(Vertex vertex) {
        if (vertices.remove(vertex)) {
            vertex.getInEdges().forEach(item -> item.sourceVertices().forEach(o -> o.removeEdge(item)));
            vertex.getOutEdges().forEach(item -> item.targetVertices().forEach(o -> o.removeEdge(item)));
            edges.removeIf(item -> item.vertices().contains(vertex));
            return true;
        }
        return false;
    }

    @Override
    public Set<Vertex> vertices() {
        return new HashSet<>(vertices);
    }


    @Override
    public Map<Vertex, List<Double>> sources(Vertex target) {
        if (vertices.contains(target)) {
            Set<Edge> inEdges = target.getInEdges();
            Map<Vertex, List<Double>> result = new HashMap<>();
            for (Edge item : inEdges) {
                Vertex source = item.sourceVertices().stream().filter(o -> !o.equals(target)).findFirst().orElse(null);
                if (result.keySet().contains(source)) {
                    result.get(source).add(item.getWeight());
                } else {
                    result.put(source, Collections.singletonList(item.getWeight()));
                }
            }
            return result;
        }
        return null;
    }

    @Override
    public Map<Vertex, List<Double>> targets(Vertex source) {
        if (vertices.contains(source)) {
            Set<Edge> outEdges = source.getInEdges();
            Map<Vertex, List<Double>> result = new HashMap<>();
            for (Edge item : outEdges) {
                Vertex target = item.sourceVertices().stream().filter(o -> !o.equals(source)).findFirst().orElse(null);
                if (result.keySet().contains(target)) {
                    result.get(target).add(item.getWeight());
                } else {
                    result.put(target, Collections.singletonList(item.getWeight()));
                }
            }
            return result;
        }
        return null;
    }


    @Override
    public boolean addEdge(Edge edge) {
        if (edges.add(edge)) {
            // add edge to the vertex,as out edges
            this.vertices.stream().filter(item -> edge.sourceVertices().contains(item)).forEach(item -> item.addOutEdge(edge));
            // add edge to the vertex as in edges
            this.vertices.stream().filter(item -> edge.targetVertices().contains(item)).forEach(item -> item.addInEdge(edge));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(Edge edge) {
        if (edges.remove(edge)) {
            // add edge to the vertex,as out edges
            this.vertices.stream().filter(item -> edge.sourceVertices().contains(item)).forEach(item -> item.removeEdge(edge));
            // add edge to the vertex as in edges
            this.vertices.stream().filter(item -> edge.targetVertices().contains(item)).forEach(item -> item.removeEdge(edge));
            return true;
        }
        return false;
    }

    @Override
    public Set<Edge> edges() {
        return new HashSet<>(edges);
    }


}
