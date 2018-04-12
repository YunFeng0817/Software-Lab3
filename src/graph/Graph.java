/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import edge.Edge;
import vertex.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A mutable weighted graph with labeled vertices.
 * Vertices have distinct labels of an immutable type {@code Vertex} when compared
 * using the {@link Object#equals(Object) equals} method.
 * Edgedges have multiple types and have a non-negative weight of type {@code double}.
 * <p>
 * <p>PS2 instructions: this is a required ADT interface.
 * You MUST NOT change the specifications or add additional methods.
 */
public interface Graph {

    /**
     * Add a vertex to this graph.
     *
     * @param vertex label for the new vertex
     * @return true if this graph did not already include a vertex with the
     * given label; otherwise false (and this graph is not modified)
     */
    public boolean addVertex(Vertex vertex);

    /**
     * Remove a vertex from this graph; any edges to or from the vertex are
     * also removed.
     *
     * @param vertex label of the vertex to remove
     * @return true if this graph included a vertex with the given label;
     * otherwise false (and this graph is not modified)
     */
    public boolean removeVertex(Vertex vertex);

    /**
     * Get all the vertices in this graph.
     *
     * @return the set of labels of vertices in this graph
     */
    public Set<Vertex> vertices();

    /**
     * Get the source vertices with directed edges to a target vertex and the
     * weights of those edges.
     *
     * @param target a label
     * @return a map where the key set is the set of labels of vertices such
     * that this graph includes an edge from that vertex to target, and
     * the value for each key is the (nonzero) weight of the edge from
     * the key to target
     */
    public Map<Vertex, List<Double>> sources(Vertex target);

    /**
     * Get the target vertices with directed edges from a source vertex and the
     * weights of those edges.
     *
     * @param source a label
     * @return a map where the key set is the set of labels of vertices such
     * that this graph includes an edge from source to that vertex, and
     * the value for each key is the (nonzero) weight of the edge from
     * source to the key
     */
    public Map<Vertex, List<Double>> targets(Vertex source);

    public boolean addEdge(Edge edge);

    public boolean removeEdge(Edge edge);

    public Set<Edge> edges();

}
