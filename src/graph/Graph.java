/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.Map;
import java.util.Set;

/**
 * A mutable weighted graph with labeled vertices.
 * Vertices have distinct labels of an immutable type {@code L} when compared
 * using the {@link Object#equals(Object) equals} method.
 * Edges have multiple types and have a non-negative weight of type {@code double}.
 * <p>
 * <p>PS2 instructions: this is a required ADT interface.
 * You MUST NOT change the specifications or add additional methods.
 *
 * @param <L> type of vertex labels in this graph, must be immutable
 */
public interface Graph<L, E> {

    /**
     * Create an empty graph. b
     *
     * @param <L>
     * @param <E>
     * @return a new empty weighted abstract graph
     */
    static <L, E> Graph<L, E> empty() {
//        return new ConcreteGraph<L>();
        throw new RuntimeException("not implement");
    }

    /**
     * Add a vertex to this graph.
     *
     * @param vertex label for the new vertex
     * @return true if this graph did not already include a vertex with the
     * given label; otherwise false (and this graph is not modified)
     */
    public boolean add(L vertex);

    /**
     * Add, change, or remove a weighted directed edge in this graph.
     * If weight is nonzero, add an edge or update the weight of that edge;
     * vertices with the given labels are added to the graph if they do not
     * already exist.
     * If weight is zero, remove the edge if it exists (the graph is not
     * otherwise modified).
     *
     * @param source label of the source vertex
     * @param target label of the target vertex
     * @param weight non-negative weight of the edge
     * @return the previous weight of the edge, or zero if there was no such
     * edge
     */
    public int set(L source, L target, int weight);

    /**
     * Remove a vertex from this graph; any edges to or from the vertex are
     * also removed.
     *
     * @param vertex label of the vertex to remove
     * @return true if this graph included a vertex with the given label;
     * otherwise false (and this graph is not modified)
     */
    public boolean removeVertex(L vertex);

    /**
     * Get all the vertices in this graph.
     *
     * @return the set of labels of vertices in this graph
     */
    public Set<L> vertices();

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
    public Map<L, Double> sources(L target);

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
    public Map<L, Double> targets(L source);

    public boolean addEdge(E edge);

    public boolean removeEdge(E edge);

    public Set<E> edges();

}
