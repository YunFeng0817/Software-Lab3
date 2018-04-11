package vertex;

import java.util.LinkedList;
import java.util.List;

public abstract class Vertex {
    private String label;

    Vertex(String label) {
        this.label = label;
    }

    abstract void fillVertexInfo(String[] args);

    public String getLabel() {
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
