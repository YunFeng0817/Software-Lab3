package vertex;

public class Word extends Vertex {

    Word(String label) {
        super(label);
    }

    @Override
    void fillVertexInfo(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Word && ((Word) obj).getLabel().equals(this.getLabel());
    }
}
