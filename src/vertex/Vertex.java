package vertex;

import java.util.*;

import edge.*;

public abstract class Vertex {
    private String label;

    private final Set<Edge> inEdges = new HashSet<>();
    private final Set<Edge> outEdges = new HashSet<>();

    Vertex(String label) {
        this.label = label;
    }

    public abstract void fillVertexInfo(String[] args);

    public boolean addInEdge(Edge inEdge) {
        if (!inEdges.contains(inEdge) && inEdge.targetVertices().contains(this)) {
            inEdges.add(inEdge);
            return true;
        }
        return false;
    }

    public boolean addOutEdge(Edge outEdge) {
        if (!outEdges.contains(outEdge) && outEdge.sourceVertices().contains(this)) {
            outEdges.add(outEdge);
            return true;
        }
        return false;
    }

    public boolean removeEdge(Edge edge) {
        boolean removeInEdge = false, removeOutEdge = false;
        Iterator<Edge> iterator = inEdges.iterator();
        while (iterator.hasNext()) {
            Edge item = iterator.next();
            if (item.equals(edge)) {
                iterator.remove();
                removeInEdge = true;
            }
        }
        iterator = outEdges.iterator();
        while (iterator.hasNext()) {
            Edge item = iterator.next();
            if (item.equals(edge)) {
                iterator.remove();
                removeOutEdge = true;
            }
        }
        return removeInEdge || removeOutEdge;
    }

    public Set<Edge> getInEdges() {
        return new HashSet<>(inEdges);
    }

    public Set<Edge> getOutEdges() {
        return new HashSet<>(outEdges);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Vertex && ((Vertex) obj).getLabel().equals(this.getLabel());
    }

    @Override
    public int hashCode() {
        return this.getLabel().hashCode();
    }
}
